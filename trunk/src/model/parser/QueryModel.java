package model.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import parser.L;
import parser.P;
import parser.T;
import translator.DbTableInfo;
import util.StringUtil;

import antlr.ANTLRException;
import antlr.CharStreamIOException;
import antlr.CommonAST;
import antlr.MismatchedCharException;
import antlr.MismatchedTokenException;
import antlr.NoViableAltException;
import antlr.NoViableAltForCharException;
import antlr.SemanticException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.TokenStreamRetryException;

public class QueryModel {
  private static final String KEYWORDS = "keywords";
  private static Map mapKeyword = new HashMap();
  static {
    ResourceBundle bundle = 
      ResourceBundle.getBundle(KEYWORDS, Locale.CHINESE);
    Enumeration keys = bundle.getKeys();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement().toString();
      String val = bundle.getString(key);
      mapKeyword.put(key, val);
    }
  }
  
  protected static String translateStringCh2En(String str) {
    String en=(String)mapKeyword.get(str);
    return (en==null)?str:en;
  }
  
  /**
   * parse query, return QueryModel when statement has no error.
   * when query statement has error, return null
   * @param chQuery
   * @return
   */
  public static QueryModel parseQuery(String chQuery) {
    List exs=new ArrayList();
    L l=new L(new StringReader(chQuery));
    P p=new P(l);
    QueryModel model=null;
    try {
      p.statements();
      CommonAST ast=(CommonAST)p.getAST();
      T t=new T();
      model = t.statement(ast);
    } catch (ANTLRException e) {
      exs.add(e);
    }
    if (model==null)
      model=new QueryModel();
    model.setParser(p);
    model.setLexer(l);
    model.setExceptions(exs);
    model.setQuery(chQuery);
    return model;
  }
  
  /**
   * 片断子句语法验证
   * @param chSegment 片断子句
   * @return QueryModel 编译器QueryModel对象
   */
  public static QueryModel parseSegment(String chSegment) {
    List exs=new ArrayList();
    L l=new L(new StringReader(chSegment));
    P p=new P(l);
    QueryModel model=null;
    try {
      p.segment();
      CommonAST ast=(CommonAST)p.getAST();
      T t=new T();
      model = t.segment(ast);
    } catch (ANTLRException e) {
      exs.add(e);
    }
    if (model==null)
      model=new QueryModel();
    model.setParser(p);
    model.setLexer(l);
    model.setExceptions(exs);
    model.setQuery(chSegment);
    return model;
  }
  
  private List children=new ArrayList();
  private P parser;
  private L lexer;
  private T tree;
  private DbTableModel dbTableModel = new DbTableModel();
  private String chQuery;
  private List antlrExceptions=new ArrayList();
  
  protected QueryModel() {}
  
  
  /**
   * 增加表单对象
   * @param tableChName 中文表名
   * @param tableEnName 英文表名
   */
  public void addDbTable(String tableChName, String tableEnName) {
    dbTableModel.setTableEnName(tableChName, tableEnName);
  }
  
  /**
   * 增加表字段属性对象
   * @param tableChName 中文表名
   * @param fieldChName 中文字段
   * @param fieldEnName 英文字段
   */
  public void addDbField(String tableChName, String fieldChName, String fieldEnName) {
    dbTableModel.setFieldEnName(tableChName, fieldChName, fieldEnName);
  }

  public DbTableModel getDbTableModel() {
    return dbTableModel;
  }

  public void setQuery(String query) {
    this.chQuery=query;
  }
  
  public void addChild(QueryModel model) {
    if (model.getClass()==getClass())
      for (Iterator it=model.children.iterator(); it.hasNext();) {
        QueryModel m=(QueryModel)it.next();
        addChild(m);
      }
    else
      children.add(model);
  }
  
  public void addOperator(String op) {
    children.add(new StringModel(op));
  }
  
  public List getChildren() {
    return this.children;
  }
  
  public void setParser(P parser) {
    this.parser=parser;
  }
  
  public void setLexer(L lexer) {
    this.lexer=lexer;
  }
  
  public void setTree(T tree) {
    this.tree=tree;
  }
  
  public void setExceptions(List antlrExceptions) {
    this.antlrExceptions=antlrExceptions;
  }
  
  public QueryModel[] getModelByClass(Class c) {
    List models=new ArrayList();
    for (Iterator it=children.iterator(); it.hasNext();) {
      QueryModel q=(QueryModel)it.next();
      if (q.getClass()==c)
        models.add(q);
    }
    QueryModel[] ret=new QueryModel[models.size()];
    int i=0;
    for (Iterator it=models.iterator(); it.hasNext();) {
      QueryModel q=(QueryModel)it.next();
      ret[i++]=q;
    }
    return ret;
  }
  
  /**
   * get first model from children
   * if no model in children, return null
   * @param c
   * @return
   */
  public QueryModel getFirstModelByClass(Class c) {
    QueryModel[] models=getModelByClass(c);
    if (models.length>0)
      return models[0];
    return null;
  }
  
  /**
   * get all models from children except the first model
   * if less than two model in children, return empty array
   * @param c
   * @return
   */
  public QueryModel[] getNextModelsByClass(Class c) {
    QueryModel[] models=getModelByClass(c);
    if (models.length<2)
      return new QueryModel[0];
    QueryModel[] ret=new QueryModel[models.length-1];
    for (int i=1; i<models.length; i++)
      ret[i-1]=models[i];
    return ret;
  }

  public QueryModel[] getModelsFromAllChildrenByClass(Class c) {
    List models=new ArrayList();
    searchChildren(models, children, c);
    QueryModel[] ret=new QueryModel[models.size()];
    int i=0;
    for (Iterator it=models.iterator(); it.hasNext();)
      ret[i++]=(QueryModel)it.next();
    return ret;
  }
  
  private void searchChildren(List models, List children, Class c) {
    for (Iterator it=children.iterator(); it.hasNext();) {
      QueryModel m=(QueryModel)it.next();
      searchChildren(models, m.getChildren(), c);
      if (m.getClass()==c)
        models.add(m);
    }
  }

  public String getChSegment(String segmentType) {
    String ret="";
    if(children.size()>0)
      ret+=((QueryModel)children.get(0)).getChSegment(segmentType);
    if (children.size()>1)
      for (int i=1; i<children.size(); i++)
        ret+=((QueryModel)children.get(i)).getChSegment(segmentType);
    return ret;
  }
  
  public String getEnSegment(String segmentType) {
    String ret="";
    if(children.size()>0)
      ret+=((QueryModel)children.get(0)).getEnSegment(segmentType);
    if (children.size()>1)
      for (int i=1; i<children.size(); i++)
        ret+=((QueryModel)children.get(i)).getEnSegment(segmentType);
    return ret;
  }
  
  public String getChString(String split) {
    String ret="";
    if(children.size()>0)
      ret+=((QueryModel)children.get(0)).getChString();
    if (children.size()>1)
      for (int i=1; i<children.size(); i++)
        ret+=split+((QueryModel)children.get(i)).getChString();
    return ret;
  }
  
  public String getChString() {
    return getChString(" ");
  }
  
  public String getEnString(String split) {
    String ret="";
    if(children.size()>0)
      ret+=((QueryModel)children.get(0)).getEnString();
    if (children.size()>1)
      for (int i=1; i<children.size(); i++)
        ret+=split+((QueryModel)children.get(i)).getEnString();
    return ret;
  }
  
  public String getEnString() {
    return getEnString(" ");
  }

  public String getEnQuery() {
    return getEnString();
  }
  
  public TableModel[] getTables() {
    QueryModel[] models=getModelsFromAllChildrenByClass(TableModel.class);
    TableModel[] ret=new TableModel[models.length];
    for (int i=0; i<models.length; i++)
        ret[i]=(TableModel)models[i];
    return ret;
  }
  
  public FieldModel[] getFields() {
    QueryModel[] models = getModelsFromAllChildrenByClass(FieldModel.class);
    
    FieldModel[] _fieldModelArr = new FieldModel[models.length]; //HJD Add
    //QueryModel[] aliases=getModelsFromAllChildrenByClass(AliasModel.class);
    boolean isAlias = false;
    List fields = new ArrayList();
    for (int i = 0; i < models.length; i++) {
      //for (int j=0; j<aliases.length; j++) {
        FieldModel f = (FieldModel)models[i];
        _fieldModelArr[i] = f;
        //AliasModel a=(AliasModel)aliases[j];
        //if (f.getFieldName().equals(a.getAlias())) {
          //f.setFieldEnName(f.getFieldName());
          //isAlias=true;
        //}
      //}
      //if (!isAlias)
        //fields.add(models[i]);
    }
    return _fieldModelArr;
    /*
    int i=0;
    FieldModel[] ret=new FieldModel[fields.size()];
    for (Iterator it=fields.iterator(); it.hasNext(); )
      ret[i++]=(FieldModel)it.next();
    return ret;
    */
  }
  
  public boolean hasError() {
    return antlrExceptions.size()>0;
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
    if (exception instanceof NoSuchTableException)
      ret=translateException((NoSuchTableException)exception);
    if (exception instanceof NoSuchFieldException)
      ret=translateException((NoSuchFieldException)exception);
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
    ChWrongMessage msg = new ChWrongMessage();
    msg.setLine(exception.line);
    msg.setColumn(exception.column);
    String expecting = parser.getTokenName(exception.expecting);
    String input = exception.token.getText();
    
    ErrorLexer errorLexer = new ErrorLexer();
    Map lexersMap = errorLexer.getLexersMap();
    for (Iterator it = lexersMap.keySet().iterator(); it.hasNext();){
      String lexerName = (String) it.next();
      String lexerValue = (String) lexersMap.get(lexerName);
      expecting = StringUtil.replace(expecting, lexerName, lexerValue);
    }
    
    String message=
      "错误输入，需要 \""+expecting+"\" "+
      " 实际输入 \""+input+"\"";
    msg.setMessage(message);
    if (input != null && input.equals("") && input.length() > 0)
      msg.setLength(input.length());
    return msg;
  }

  private ChWrongMessage translateException(NoViableAltException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    String token=exception.token.getText();
    msg.setMessage("无法识别的关键字 \""+token+"\"");
    msg.setLine(exception.line);
    msg.setColumn(exception.column);
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
    msg.setColumn(exception.recog.column);
    msg.setLength(-1);
    char ch=0;
    ch=chQuery.charAt(msg.getColumn()-1);
    msg.setMessage("非法字符 \""+ch+"\"");
    return msg;
  }

  private ChWrongMessage translateException(TokenStreamRetryException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(5);
    return msg;
  }

  private ChWrongMessage translateException(NoSuchTableException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage("不存在表 \""+exception.getTableName()+"\"");
    return msg;
  }
  
  private ChWrongMessage translateException(NoSuchFieldException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "表 \""+exception.getTableChName()+"\" 中不存在字段 \""+exception.getFieldChName()+"\"");
    return msg;
  }
  
  private ChWrongMessage translateException(TableNotInFromClause exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "表 \""+exception.getTableName()+"\" 没有在 [来自] 段出现");
    return msg;
  }

  public void addException(ANTLRException e) {
    antlrExceptions.add(e);
  }
  
  public ChWrongMessage[] getWrongMessages() {
    ChWrongMessage[] ret=new ChWrongMessage[antlrExceptions.size()];
    int i=0;
    for (Iterator it=antlrExceptions.iterator(); it.hasNext();)
      ret[i]=(translateException((ANTLRException)it.next()));
    return ret;
  }

}
