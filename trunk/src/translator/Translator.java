package translator;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import parser.*;
import translator.model.*;

import antlr.ANTLRException;
import antlr.CharStreamIOException;
import antlr.CommonAST;
import antlr.MismatchedCharException;
import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.SemanticException;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.TokenStreamRetryException;

/**
 * 
 * 
 * @author Meatball.Li
 * 
 */
public class Translator {
  private static final String KEYWORD_TRANSLATE_TABLE = "keyword_translate_table";
  private static final String CN_KEY_WORDS = "cnKeyWords";
  
//中文关键字属性KEY
  public static final String CNKEY_WORDS = "cnKeyWords";
  public static final String CNKEY_FUNC = "cnFunc";
  public static final String CNKEY_OPERSYMBOL = "operSymbol";
  public static final String CNKEY_NUMBERSYMBOL = "numberSymbol";
  
  //英文关键字名称属性KEY
  public static final String ENVALUE_SELECT = "select";
  public static final String ENVALUE_FROM = "from";
  public static final String ENVALUE_WHERE = "where";
  public static final String ENVALUE_GROUPBY = "group_by";
  public static final String ENVALUE_ORDERBY = "order_by";

  public static final String SELECT = "select";
  public static final String COLUMN = "column";
  public static final String FROM = "from";
  public static final String WHERE = "where";

  private String chQuery;
  private String enQuery;
  private Map mapKeyword = new HashMap();
  private Map mapEn2Ch = new HashMap();
  private Map mapPosEn2Ch = new HashMap();
  private List antlrExceptions = new ArrayList();
  private List chWrongMessages = new ArrayList();
  private P parser;
  private L lexer;
  private T tree;
  private QueryModel queryModel=null;

  public Translator() {
    initKeywordMap();
  }

  private void initKeywordMap() {
    ResourceBundle bundle = 
      ResourceBundle.getBundle(KEYWORD_TRANSLATE_TABLE, Locale.CHINESE);
    Enumeration keys = bundle.getKeys();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement().toString();
      String val = bundle.getString(key);
      mapKeyword.put(key, val);
    }
  }

  public String[] getChKeywords() {
    String[] ret=new String[mapKeyword.size()];
    int i=0;
    for (Iterator it=mapKeyword.keySet().iterator(); it.hasNext();)
      ret[i++]=(String)it.next();
    return ret;
  }
  
  /**
   * 根据关键字值获取对应中文关键字名称
   * @param keyName 关键字值
   * @return String 中文关键字名称
   */
  public String getCnKeyWordByValue(String _mValue){
    String _rValue = "";
    ResourceBundle bundle = ResourceBundle.getBundle(CN_KEY_WORDS, Locale.CHINESE);
    _rValue = bundle.getString(_mValue);
    return _rValue;
  }
  
  /**
   * 根据关键字/函数/操作符/运算符的KEY获取对应中文关键字名称
   * @param keyName 关键字/函数/操作符/运算符属性KEY
   * @return String 中文关键字名称
   */
  public String getCnKeyWords(String keyName) {
    String[] cnKeyWordsArr = new String[]{CNKEY_WORDS, CNKEY_FUNC, CNKEY_OPERSYMBOL, CNKEY_NUMBERSYMBOL};
    
    String cnKeyWords = "";
    ResourceBundle bundle = ResourceBundle.getBundle(CN_KEY_WORDS, Locale.CHINESE);
    if (keyName == null || keyName.equals("")){
      for (int i = 0; i < cnKeyWordsArr.length; i++){
        cnKeyWords +=  bundle.getString(cnKeyWordsArr[i]);
        if (i < cnKeyWordsArr.length - 1)
          cnKeyWords += ",";
      }
    }else{
      cnKeyWords = bundle.getString(keyName);
    }
    return cnKeyWords;
  }
  
  /**
   * 返回字段属性中的别名对象数组
   */
  public DbFieldAlias[] getDbFieldAlias(){
    return this.tree.getDbFieldAlias();
  }
  
  /**
   * 设置字段别名信息
   * @param _iDbFieldAlias
   */
  public void setDbFieldAlias(DbFieldAlias[] _iDbFieldAlias) {
    for (int i = 0; i < _iDbFieldAlias.length; i++) {
      if (_iDbFieldAlias[i].getEnFieldAlias() == null || 
          _iDbFieldAlias[i].getEnFieldAlias().equals(""))
        antlrExceptions.add(new NoSuchFieldAliasException(_iDbFieldAlias[i].getCnFieldAlias()));
      if (queryModel != null)
        queryModel.addfieldAliasInfo(_iDbFieldAlias[i]);
    }
  }
  
  /**
   * 获取当前查询语句包含的数据库表对象列表，
   * 业务系统需要调用这个函数获得中文表对象列表后从数据库中获取每个表相应的英文名
   * @return
   */
  public DbTable[] getTables() {
    DbTable[] tablesArr = tree.getTables();
    DbTable[] tableLiArr = new DbTable[(tablesArr.length)];
    
    int m = 0;
    for (int i = 0; i < tablesArr.length; i++){
      DbTable dbTable = (DbTable) tablesArr[i];
      boolean isExistFlag = false;
      for (int j = 0; j < m; j++){
        DbTable _mDbTable = (DbTable) tableLiArr[j];
        if ( (_mDbTable.getChName() != null && dbTable.getChName() != null && _mDbTable.getChName().equals(dbTable.getChName())) ||
            _mDbTable.getAlias() != null && dbTable.getChName() != null && _mDbTable.getAlias().equals(dbTable.getChName())
            ){
          isExistFlag = true;
          break;
        }
      }
      if (!isExistFlag){
        tableLiArr[m] = dbTable;
        m++;
      }
    }
    
    DbTable[] _rDbTableArr = new DbTable[m];
    System.arraycopy(tableLiArr, 0, _rDbTableArr, 0, m);
    return _rDbTableArr;
  }
  
  /**
   * 获取表格信息（英文表名�?�字段名）后将信息设置回queryModel
   * @param tables
   */
  public void setTableInfo(DbTable[] tables) {
    for (int i=0; i<tables.length; i++) {
      if (tables[i].getEnName()==null)
        antlrExceptions.add(new NoSuchDbTableException(tables[i].getChName()));
      if (!tables[i].isExistInFromClause())
        antlrExceptions.add(new TableNotInFromClause(tables[i].getChName()));
      DbField[] fields=tables[i].getFields();
      for (int j=0; j<fields.length; j++) {
        if (fields[j].getEnName()==null)
          antlrExceptions.add(
              new NoSuchDbFieldException(tables[i].getChName(), fields[j].getChName()));
      }
      if (queryModel!=null)
        queryModel.addTableInfo(tables[i]);
    }
  }

/*
  private List getAntlrExceptions() {
    return antlrExceptions;
  }

  private void setAntlrExceptions(List antlrExceptions) {
    this.antlrExceptions = antlrExceptions;
  }

  private List getChWrongMessages() {
    return chWrongMessages;
  }

  private void setChWrongMessages(List chWrongMessages) {
    this.chWrongMessages = chWrongMessages;
  }

  private L getLexer() {
    return lexer;
  }

  private void setLexer(L lexer) {
    this.lexer = lexer;
  }

  private Map getMapPosEn2Ch() {
    return mapPosEn2Ch;
  }

  private void setMapPosEn2Ch(Map mapPosEn2Ch) {
    this.mapPosEn2Ch = mapPosEn2Ch;
  }

  private P getParser() {
    return parser;
  }

  private void setParser(P parser) {
    this.parser = parser;
  }
*/  
  /**
   * 获取中文查询语句，如果需要检查或存数据库
   * @return 中文查询语句 
   */
  public String getChQuery() {
    // TODO 如果chQuery==null抛出异常
    return chQuery;
  }
  private void initTranslator(String query) {
    this.mapEn2Ch.clear();
    this.mapPosEn2Ch.clear();
    this.antlrExceptions.clear();
    this.chWrongMessages.clear();
    
    this.chQuery = query;
    this.enQuery = "";
  }
  /**
   * 设置中文查询语句，准备进行语法验证与翻译
   * @param chQuery
   */
  public void setChQuery(String chQuery) {
    initTranslator(chQuery);
    translateQuery();
  }

  public void setChSegment(String segment_type, String chSegment) {
    initTranslator(chSegment);
    if (chQuery == null || chQuery.equals("")) {
      enQuery = "";
      return;
    }
    enQuery = segment_type+" "+chQuery;

    translateKeyword();

    lexer=new L(new StringReader(enQuery));
    parser=new P(lexer);
    tree=new T();
    
    try {
      parser.segment();
      CommonAST parserTree=(CommonAST)parser.getAST();
      enQuery=tree.segment(parserTree);
      queryModel=new SegmentModel(enQuery);
      queryModel.setMapEn2Ch(mapEn2Ch);
      queryModel.setChQuery(chQuery);
    } catch (RecognitionException e) {
      antlrExceptions.add(e);
    } catch (TokenStreamException e) {
      antlrExceptions.add(e);
    }

  }
  
  /**
   * 设置中文条件语句，准备进行语法验证与翻译
   * @param equation
   */
  public void setChEquation(String equation) {
    setChSegment(WHERE, equation);
  }

  public void setChColumnList(String columnList) {
    setChSegment(SELECT, columnList);
  }

/*
  private void translateEquation() {
    if (chQuery == null || chQuery.equals("")) {
      enQuery = "";
      return;
    }
    enQuery = chQuery;

    translateKeyword();
    parseEquation();
  }

  private void parseEquation() {
    lexer=new L(new StringReader(enQuery));
    parser=new P(lexer);
    tree=new T();
    
    try {
      parser.equations();
      CommonAST parserTree=(CommonAST)parser.getAST();
      enQuery=tree.equations(parserTree);
    } catch (RecognitionException e) {
      antlrExceptions.add(e);
    } catch (TokenStreamException e) {
      antlrExceptions.add(e);
    }
  }

  public void setChColumnList(String columnList) {
    initTranslator(columnList);
    translateColumnList();
    
    queryModel=new ColumnListModel(enQuery);
  }

  private void translateColumnList() {
    if (chQuery == null || chQuery.equals("")) {
      enQuery = "";
      return;
    }
    enQuery = chQuery;

    translateKeyword();
    parseColumnList();
  }
  
  private void parseColumnList() {
    lexer=new L(new StringReader(enQuery));
    parser=new P(lexer);
    tree=new T();
    
    try {
      parser.columnList();
      CommonAST parserTree=(CommonAST)parser.getAST();
      enQuery=tree.columnList(parserTree);
    } catch (RecognitionException e) {
      antlrExceptions.add(e);
    } catch (TokenStreamException e) {
      antlrExceptions.add(e);
    }
  }
*/
  public QueryModel getQueryModel() {
    return queryModel;
  }
  
  private void translateQuery() {
    if (chQuery == null || chQuery.equals("")) {
      enQuery = "";
      return;
    }
    enQuery = chQuery;
    translateKeyword();
    translateQuery2Sql();
  }

  private void translateQuery2Sql() {
    lexer=new L(new StringReader(enQuery));
    parser=new P(lexer);
    tree=new T();

    try {
      parser.statement();
      CommonAST parserTree=(CommonAST)parser.getAST();
      queryModel=tree.statement(parserTree);
      queryModel.setMapEn2Ch(mapEn2Ch);
      queryModel.setChQuery(chQuery);
    } catch (RecognitionException e) {
      antlrExceptions.add(e);
    } catch (TokenStreamException e) {
      antlrExceptions.add(e);
    }
  }

  private void translateKeyword() {
    enQuery = formatStringLit(enQuery);
    for (Iterator it = mapKeyword.keySet().iterator(); it.hasNext();) {
      String chKey = it.next().toString();
      enQuery = replace(enQuery, chKey, mapKeyword.get(chKey).toString());
    }
    enQuery = replace(enQuery, "[", "");
    enQuery = replace(enQuery, "]", "");
    enQuery = recoverStringLit(enQuery);
  }

  private String recoverStringLit(String str) {
    char[] charToFormat={'[', ']'};
    char[] charReplace={(char)1, (char)2};
    String ret=str;
    for (int i=0; i<charReplace.length; i++) {
      ret=ret.replace(charReplace[i], charToFormat[i]);
    }
    return ret;
  }

  private String formatStringLit(String str) {
    boolean inStrLit=false;
    boolean changed=false;
    String ret="";
    char[] charToFormat={'[', ']'};
    char[] charReplace={(char)1, (char)2};
    for (int i=0; i<str.length(); i++) {
      if (str.charAt(i)=='"' || str.charAt(i)=='\'')
        inStrLit=!inStrLit;
      if (inStrLit)
        for (int j=0; j<charToFormat.length; j++)
          if (str.charAt(i)==charToFormat[j]) {
            ret+=charReplace[j];
            changed=true;
            break;
          }
      if (!changed)
        ret+=str.charAt(i);
      changed=false;
    }
    return ret;
  }

  /**
   * 获取中文错误对象，给前台进行错误提示
   * @return
   */
  public ChWrongMessage[] showWrongMsgs() {
    if (chQuery == null || chQuery.equals(""))
      return new ChWrongMessage[0];
    if (antlrExceptions.size()>0)
      translateExceptions();
    ChWrongMessage[] msgs = new ChWrongMessage[chWrongMessages.size()];
    for (int i = 0; i < msgs.length; i++)
      msgs[i] = (ChWrongMessage) chWrongMessages.get(i);
    return msgs;
  }

  private String replace(String src, String from, String to) {
    String ret = src;
    int pos=0;
    int offset=to.length()-from.length();
    String f="\\Q"+from+"\\E";

    while (ret.indexOf(from, pos) != -1) {
      pos=chQuery.indexOf(from, pos);
      mapEn2Ch.put(to, from);
      int posTo=ret.indexOf(from);
      mapPosEn2Ch.put(new Integer(posTo), new Integer(offset));

      Map mapNewPos=new HashMap();
      for (Iterator it=mapPosEn2Ch.keySet().iterator(); it.hasNext();) {
        Integer p=(Integer)it.next();
        Integer o=(Integer)mapPosEn2Ch.get(p);
        if (p.intValue()>posTo)
          p=new Integer(p.intValue()+offset);
        mapNewPos.put(p, o);
      }
      mapPosEn2Ch=mapNewPos;
      ret=ret.replaceFirst(f, to);
    }
    return ret;
  }

  private void translateExceptions() {
    chWrongMessages.clear();
    for (Iterator it=antlrExceptions.iterator(); it.hasNext();) {
      ChWrongMessage msg=translateException((ANTLRException)it.next());
      if (msg!=null)
        chWrongMessages.add(msg);
    }
  }

  private ChWrongMessage translateException(ANTLRException exception) {
    ChWrongMessage ret=null;
    if (exception instanceof CharStreamIOException)
      ret=translateException((CharStreamIOException)exception);
    if (exception instanceof MismatchedCharException)
      ret=translateException((MismatchedCharException)exception);
    if (exception instanceof MismatchedTokenException)
      ret=translateException((MismatchedTokenException)exception);
    if (exception instanceof NoViableAltException)
      ret=translateException((NoViableAltException)exception);
    if (exception instanceof NoViableAltForCharException)
      ret=translateException((NoViableAltForCharException)exception);
    if (exception instanceof SemanticException)
      ret=translateException((SemanticException)exception);
    if (exception instanceof TokenStreamIOException)
      ret=translateException((TokenStreamIOException)exception);
    if (exception instanceof TokenStreamRecognitionException)
      ret=translateException((TokenStreamRecognitionException)exception);
    if (exception instanceof TokenStreamRetryException)
      ret=translateException((TokenStreamRetryException)exception);
    if (exception instanceof NoSuchDbTableException)
      ret=translateException((NoSuchDbTableException)exception);
    if (exception instanceof NoSuchDbFieldException)
      ret=translateException((NoSuchDbFieldException)exception);
    if (exception instanceof TableNotInFromClause)
      ret=translateException((TableNotInFromClause)exception);
    return ret;
  }
  
  private ChWrongMessage translateException(CharStreamIOException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    return msg;
  }

  private ChWrongMessage translateException(MismatchedCharException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    return msg;
  }

  private ChWrongMessage translateException(MismatchedTokenException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setLine(exception.line);
    msg.setColumn(getChPos(exception.line, exception.column));
    String expecting=parser.getTokenName(exception.expecting);
    String expectingCh=translateEn2Ch(expecting);
    String input=exception.token.getText();
    String inputCh=translateEn2Ch(input);
    inputCh=inputCh==null?input:inputCh;

    String message=
      "错误输入，需�? \""+expectingCh+"\" "+
      " 实际输入 \""+inputCh+"\"";
    msg.setMessage(message);
    msg.setLength(inputCh.length());
    return msg;
  }

  /**
   * 
   * @param ent
   * @return
   */
  private String translateEn2Ch(String en) {
    if (en==null)
      return "";
    String ent=en.toLowerCase();
    String ret=mapEn2Ch.containsKey(ent)?mapEn2Ch.get(ent).toString():ent;
    if (ret.equals(ent) && mapKeyword.values().contains(ent))
      for (Iterator it=mapKeyword.keySet().iterator(); it.hasNext();) {
        String key=(String)it.next();
        String val=(String)mapKeyword.get(key);
        if (ret.equals(val))
          return key;
      }
    return ret;
  }

  private ChWrongMessage translateException(NoViableAltException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    String token=exception.token.getText();
    String tokenCh=translateEn2Ch(token);
    msg.setMessage("无法识别的关键字 '"+tokenCh+"'");
    msg.setLine(exception.line);
    msg.setColumn(getChPos(exception.line, exception.column));
    msg.setLength((token==null)?0:token.length());
    return msg;
  }

  private ChWrongMessage translateException(NoViableAltForCharException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(1);
    return msg;
  }

  private ChWrongMessage translateException(SemanticException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(2);
    return msg;
  }

  private ChWrongMessage translateException(TokenStreamIOException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(3);
    return msg;
  }

  private ChWrongMessage translateException(TokenStreamRecognitionException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setLine(exception.recog.line);
    msg.setColumn(getChPos(exception.recog.line, exception.recog.column));
    msg.setLength(-1);
    char ch=0;
    ch=chQuery.charAt(msg.getColumn()-1);
    msg.setMessage("非法字符'"+ch+"'");
    return msg;
  }

  private ChWrongMessage translateException(TokenStreamRetryException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(5);
    return msg;
  }

  private ChWrongMessage translateException(NoSuchDbTableException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage("不存在表 \""+exception.getTableName()+"\"");
    return msg;
  }
  
  private ChWrongMessage translateException(NoSuchDbFieldException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "�? \""+exception.getTableChName()+"\" 中不存在字段 \""+exception.getFieldChName()+"\"");
    return msg;
  }
  
  private ChWrongMessage translateException(TableNotInFromClause exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "�? \""+exception.getTableName()+"\" 没有�? [来自] 段出�?");
    return msg;
  }
  private int getChPos(int line, int enPos) {
    int ret=enPos-2;
    for (int i=ret; i>=0; i--) {
      Integer intg=new Integer(i);
      Integer off=(Integer)mapPosEn2Ch.get(intg);
      ret-=(off==null)?0:off.intValue();
    }
    return ret+1;
  }

  public boolean hasError() {
    return antlrExceptions.size()>0;
  }

  public void setSegmentTableInfo(DbTable[] tables) {
    for (int i=0; i<tables.length; i++)
      tables[i].setExistInFromClause(true);
    setTableInfo(tables);
  }

  public L getLexer() {
    return lexer;
  }

  public void setLexer(L lexer) {
    this.lexer = lexer;
  }

  public P getParser() {
    return parser;
  }

  public void setParser(P parser) {
    this.parser = parser;
  }

  public T getTree() {
    return tree;
  }

  public void setTree(T tree) {
    this.tree = tree;
  }

}
