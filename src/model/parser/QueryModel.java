package model.parser;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
import antlr.debug.misc.ASTFrame;

/**
 * 编译器核心模型QueryModel及对语法解析实现类
 *
 */
public class QueryModel {
  private static final String KEYWORDS = "keywords";  //关键字属性文件名称
  private static Map mapKeyword = new HashMap();      //存放关键字的HashMap
  
  private List children = new ArrayList();
  private P parser;
  private L lexer;
  private T tree;
  private DbTableModel dbTableModel = new DbTableModel();
  private String chQuery;
  private String circleType;  //循环语句类型(表变量/条件变量)
  private List antlrExceptions=new ArrayList();
  
  static {
    //获取所有中英文关键字并存储在HashMap的mapKeyword中
    ResourceBundle bundle =  ResourceBundle.getBundle(KEYWORDS, Locale.CHINESE);
    Enumeration keys = bundle.getKeys();
    while (keys.hasMoreElements()) {
      String key = keys.nextElement().toString();
      String val = bundle.getString(key);
      mapKeyword.put(key, val);
    }
  }
  
  /**
   * 将中文的关键字（关键字/函数/运算符/操作符...）翻译成标准的关键字
   * @param str 业务化的关键字
   * @return String 标准的关键字
   */
  protected static String translateStringCh2En(String str) {
    String en=(String)mapKeyword.get(str);
    return (en==null)?str:en;
  }
  
  protected QueryModel() {}
  
  /**
   * 完整SQL语句解析，当解析正确时返回QueryModel对象
   * @param chQuery 完整SQL语句
   * @return QueryModel 编译器QueryModel对象
   */
  public static QueryModel parseQuery(String chQuery) {
    QueryModel model = null;
    List exs = new ArrayList();
    
    L l = new L(new StringReader(chQuery));
    P p = new P(l);
    try {
      p.statements();
      CommonAST ast = (CommonAST)p.getAST();
      T t = new T();
      //TODO Visible ASTFrame
//      ASTFrame _ASTFrame = new ASTFrame("longtopParser", ast);
//      _ASTFrame.setVisible(true);
      model = t.statement(ast);
    } catch (ANTLRException e) {
      exs.add(e);
    }
    
    if (model == null){
      model = new QueryModel();
    }
    model.setParser(p);
    model.setLexer(l);
    model.setExceptions(exs);
    model.setQuery(chQuery);
    QueryModel[] _paramModelArr = model.getModelsFromAllChildrenByClass(ParamModel.class);
    if (_paramModelArr.length > 0)
      model.setCircleType(((ParamModel) _paramModelArr[0]).getCircleType());
    
    //===SELECT子句中非聚合函数表达式必须在GROUP BY子句中出现===//
    Map aFunMap = new LinkedHashMap();	//聚合函数Map
    //获取所有聚合函数Model数组
    QueryModel[] _aggregateFunModelArr = model.getModelsFromAllChildrenByClass(AggregateFuncModel.class);
    // 循环获取所有聚合函数Model数组相关信息
		for (int i = 0; i < _aggregateFunModelArr.length; i++) {
			System.out.println(_aggregateFunModelArr[i].getChString());
			aFunMap.put(_aggregateFunModelArr[i].getChString(), "0");
			QueryModel apm = _aggregateFunModelArr[i].getFirstModelByClass(ParametersModel.class);
			// 得到每个集合函数的所有参数表达式模型
			QueryModel expm = apm.getFirstModelByClass(ExpressionModel.class);
			QueryModel[] expms = apm.getModelByClass(ExpressionModel.class);
			// 得到每个集合函数的所有字段模型
			QueryModel[] fdms = apm.getModelsFromAllChildrenByClass(FieldModel.class);
		}
    
		Map nGroupExprMap = new LinkedHashMap();	//需要分组的表达式Map
		//获取SELECT子句下的所有表达式
		QueryModel[] _columnModelArr = model.getModelsFromAllChildrenByClass(ColumnModel.class); 
		for (int i = 0; i < _columnModelArr.length; i++){
			ColumnModel _columnModel = (ColumnModel) _columnModelArr[i];
			QueryModel expm =  _columnModel.getFirstModelByClass(ExpressionModel.class);
			System.out.println(expm.getChString());
			if (aFunMap.containsKey(expm.getChString())){
				aFunMap.put(expm.getChString(), "1");
			}else{
				nGroupExprMap.put(expm.getChString(), "0");
			}
    }
		
		 //GROUP BY列表
    QueryModel _groupByListModel = model.getFirstModelByClass(AggregateExprListModel.class);
    QueryModel[] _groupByExprModelArr;
    if (_groupByListModel == null){
    	_groupByExprModelArr = new QueryModel[0];
    }else{
    	_groupByExprModelArr = _groupByListModel.getModelByClass(AggregateExprModel.class);
    }
    
    for (int i = 0; i < _groupByExprModelArr.length; i++){
    	if (nGroupExprMap.containsKey(_groupByExprModelArr[i].getChString())){
    		nGroupExprMap.put(_groupByExprModelArr[i].getChString(), "1");
    	}
    }
    
    for (Iterator it = nGroupExprMap.keySet().iterator(); it.hasNext();){
    	String selectExpr = (String) it.next();
    	if (((String)nGroupExprMap.get(selectExpr)).equals("0")){
    		NoGroupExistsException _exception = new NoGroupExistsException(selectExpr);
    		exs.add(_exception);
    	}
    }
    
    // 得到所有函数模型(包括一般函数和聚合函数)
    //QueryModel[] _allFunctionModelArr = model.getModelsFromAllChildrenByClass(FunctionModel.class);
    //===SELECT子句中非聚合函数表达式必须在GROUP BY子句中出现===//
    
    return model;
  }
  
  /**
   * 片断子句语法验证，当解析正确是返回QueryModel对象
   * @param chSegment 片断子句
   * @return QueryModel 编译器QueryModel对象
   */
  public static QueryModel parseSegment(String chSegment) {
    QueryModel model = null;
    
    List exs = new ArrayList();
    L l = new L(new StringReader(chSegment));
    P p = new P(l);
    try {
      p.segment();
      CommonAST ast = (CommonAST)p.getAST();
      T t = new T();
      model = t.segment(ast);
    } catch (ANTLRException e) {
      exs.add(e);
    }
    
    if (model == null){
      model = new QueryModel();
    }
    model.setParser(p);
    model.setLexer(l);
    model.setExceptions(exs);
    model.setQuery(chSegment);
    
    return model;
  }
  
  /**
   * 将传入的原始业务化查询语句保存在QueryModel的chQuery属性中
   * @param query 业务化查询
   */
  public void setQuery(String query) {
    this.chQuery = query;
  }
  
  /**
   * 取得循环语句类型（1为表变量，2为条件变量）
   * @return String 循环语句类型
   */
  public String getCircleType() {
    return circleType;
  }
  
  /**
   * 设置取得循环语句类型
   * @param circleType （1为表变量，2为条件变量）
   */
  public void setCircleType(String circleType) {
    this.circleType = circleType;
  }
  
  /**
   * 清空模型中表及字段信息
   *
   */
  public void clearDbTableModel(){
    this.dbTableModel = new DbTableModel();
  }
  
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
  
  /**
   * 获取编译器中表名及字段名的模型对象
   * @return DbTableModel 表名及字段名的模型对象
   */
  public DbTableModel getDbTableModel() {
    return dbTableModel;
  }
  
  /**
   * 增加QueryModel对象到children的List集合中
   * @param model QueryModel对象
   */
  public void addChild(QueryModel model) {
    if (model.getClass() == getClass()){
      for (Iterator it = model.children.iterator(); it.hasNext();) {
        QueryModel m = (QueryModel)it.next();
        addChild(m);
      }
    } else {
      children.add(model);
    }
  }
  
  /**
   * 增加操作符对象到QueryModel的children的List集合中（在遍历语法树时加入）
   * @param op 操作符
   */
  public void addOperator(String op) {
    children.add(new StringModel(op));
  }
  
  public List getChildren() {
    return this.children;
  }
  
  public void setParser(P parser) {
    this.parser = parser;
  }
  
  public void setLexer(L lexer) {
    this.lexer = lexer;
  }
  
  public void setTree(T tree) {
    this.tree = tree;
  }
  
  public void setExceptions(List antlrExceptions) {
    this.antlrExceptions = antlrExceptions;
  }
  
  /**
   * 从QueryModel的children List集合中获取对象为c的所有对象存放到QueryModel[]中
   * @param c 指定的模型对象(StatementsModel、SelectStatementModel...）
   * @return QueryModel[] 返回类型为指定的模型对象的所有信息集合
   */
  public QueryModel[] getModelByClass(Class c) {
    List models = new ArrayList();
    for (Iterator it = children.iterator(); it.hasNext();) {
      QueryModel q = (QueryModel)it.next();
      if (q.getClass() == c)
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
   * 从QueryModel的children List集合中获取对象为c的第一个对象
   * @param c 指定的模型对象(StatementsModel、SelectStatementModel...）
   * @return QueryModel 返回类型为指定的模型对象的第一个QueryModelQueryModel
   */
  public QueryModel getFirstModelByClass(Class c) {
    QueryModel[] models = getModelByClass(c);
    if (models.length > 0)
      return models[0];
    return null;
  }
  
  /**
   * 从QueryModel的children List集合中获取对象为c的除了第一个外的所有对象数组
   * 如果children的List集合中对象为c的只有一个，则返回空数组
   * @param c 指定的模型对象(StatementsModel、SelectStatementModel...）
   * @return QueryModel 返回类型为指定的模型对象的第一个QueryModelQueryModel
   */
  public QueryModel[] getNextModelsByClass(Class c) {
    QueryModel[] models = getModelByClass(c);
    if (models.length < 2)
      return new QueryModel[0];
    
    QueryModel[] ret = new QueryModel[models.length - 1];
    for (int i = 1; i < models.length; i++)
      ret[i-1] = models[i];
    return ret;
  }
  
  /**
   * 从QueryModel的所有children List集合中获取对象为c的所有对象<br>
   * @param c 指定的模型对象(StatementsModel、SelectStatementModel...）
   * @return QueryModel[] 返回类型为指定的模型对象的所有信息集合<br>
   */
  public QueryModel[] getModelsFromAllChildrenByClass(Class c) {
    List models = new ArrayList();
    searchChildren(models, children, c);
    QueryModel[] ret = new QueryModel[models.size()];
    int i = 0;
    for (Iterator it = models.iterator(); it.hasNext();)
      ret[i++] = (QueryModel)it.next();
    return ret;
  }
  
  /**
   * 在children的List集合中查找为c的对象，存放在models中
   * @param models 模型对象为c的所有集合信息 
   * @param children 编译器中的children List集合
   * @param c 指定的模型对象
   */
  private void searchChildren(List models, List children, Class c) {
    for (Iterator it = children.iterator(); it.hasNext();) {
      QueryModel m = (QueryModel)it.next();
      searchChildren(models, m.getChildren(), c);
      if (m.getClass() == c){
        models.add(m);
      }
    }
  }

  /**
   * 获取片断子句的中文SQL语句
   * @param segmentType 片断子句类型
   * @return String 中文SQL语句
   */
  public String getChSegment(String segmentType) {
    String ret = "";
    if (children.size() > 0)
      ret += ((QueryModel)children.get(0)).getChSegment(segmentType);
    
    if (children.size() > 1)
      for (int i = 1; i < children.size(); i++)
        ret += ((QueryModel)children.get(i)).getChSegment(segmentType);
    return ret;
  }
  
  /**
   * 获取片断子句的英文SQL语句
   * @param segmentType 片断子句类型
   * @return String 英文SQL语句
   */
  public String getEnSegment(String segmentType) {
    String ret = "";
    if (children.size() > 0)
      ret += ((QueryModel)children.get(0)).getEnSegment(segmentType);
    
    if (children.size() > 1)
      for (int i = 1; i < children.size(); i++)
        ret += ((QueryModel)children.get(i)).getEnSegment(segmentType);
    return ret;
  }
  
  /**
   * 获取完整语句的中文SQL语句（如果有分隔符，则子句间用分隔符隔开）
   * @param split 分隔符
   * @return String 中文SQL语句
   */
  public String getChString(String split) {
    String ret = "";
    if (children.size() > 0)
      ret += ((QueryModel)children.get(0)).getChString();
    
    if (children.size() > 1)
      for (int i = 1; i < children.size(); i++)
        ret += split + ((QueryModel)children.get(i)).getChString();
    return ret;
  }
  
  /**
   * 获取完整语句的中文SQL语句
   * @return String 中文SQL语句
   */
  public String getChString() {
    return getChString(" ");
  }
  
  /**
   * 获取完整的可执行英文SQL语句（必须有INTO的表名）
   * @param intoTableName INTO的名称
   * @return String 可执行英文SQL语句
   */
  public String getExecuteEnString(String intoTableName) {
    return getExecuteEnString(intoTableName);
  }
  
  /**
   * 获取空的可执行英文SQL语句（不进行数据插入操作，必须有INTO的表名）
   * @param intoTableName INTO的名称
   * @return String 空的可执行英文SQL语句
   */
  public String getEmptyExecuteEnString(String intoTableName) {
    return getEmptyExecuteEnString(intoTableName);
  }
  
  /**
   * 获取完整语句的英文SQL语句（如果有分隔符，则子句间用分隔符隔开）
   * @param split 分隔符
   * @return String 英文SQL语句
   */
  public String getEnString(String split) {
    String ret = "";
    if (children.size() > 0)
      ret += ((QueryModel)children.get(0)).getEnString();
    if (children.size()>1)
      for (int i=1; i<children.size(); i++)
        ret+=split+((QueryModel)children.get(i)).getEnString();
    return ret;
  }
  
  /**
   * 获取完整语句的英文SQL语句
   * @return String 英文SQL语句
   */
  public String getEnString() {
    return getEnString(" ");
  }

  /**
   * 获取查询语句的英文SQL语句
   * @return String 英文SQL语句
   */
  public String getEnQuery() {
    return getEnString();
  }
  
  /**
   * 获取查询语句中所有的表名信息，返回表单信息对象数组
   * @return TableModel[] 表单信息对象数组
   */
  public TableModel[] getTables() {
    QueryModel[] models = getModelsFromAllChildrenByClass(TableModel.class);
    TableModel[] ret = new TableModel[models.length];
    for (int i = 0; i < models.length; i++)
        ret[i] = (TableModel)models[i];
    return ret;
  }
  
  /**
   * 获取查询语句中所有的字段信息，返回字段属性信息对象数组
   * @return FieldModel[] 字段属性信息对象数组
   */
  public FieldModel[] getFields() {
    QueryModel[] models = getModelsFromAllChildrenByClass(FieldModel.class);
    
    FieldModel[] _fieldModelArr = new FieldModel[models.length]; //HJD Add
    //QueryModel[] aliases=getModelsFromAllChildrenByClass(AliasModel.class);
    boolean isAlias = false;
    List fields = new ArrayList();
    for (int i = 0; i < models.length; i++) {
      //for (int j=0; j<aliases.length; j++) {
        FieldModel f = (FieldModel) models[i];
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
  
  /**
   * 判断编译器进行语法解析时是否存在错误
   * @return boolean（true表示存在错误，false表示不存在错误）
   */
  public boolean hasError() {
    return antlrExceptions.size() > 0;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(ANTLRException exception) {
    ChWrongMessage ret=null;
    if (exception instanceof CharStreamIOException)
      ret = translateException((CharStreamIOException)exception);
    else if (exception instanceof MismatchedCharException)
      ret = translateException((MismatchedCharException)exception);
    else if (exception instanceof MismatchedTokenException)
      ret = translateException((MismatchedTokenException)exception);
    else if (exception instanceof NoViableAltException)
      ret = translateException((NoViableAltException)exception);
    else if (exception instanceof NoViableAltForCharException)
      ret = translateException((NoViableAltForCharException)exception);
    else if (exception instanceof SemanticException)
      ret = translateException((SemanticException)exception);
    else if (exception instanceof TokenStreamIOException)
      ret = translateException((TokenStreamIOException)exception);
    else if (exception instanceof TokenStreamRecognitionException)
      ret = translateException((TokenStreamRecognitionException)exception);
    else if (exception instanceof TokenStreamRetryException)
      ret = translateException((TokenStreamRetryException)exception);
    else if (exception instanceof TableNumberException)
    	ret = translateException((TableNumberException)exception);
    else if (exception instanceof NoSuchTableException)
      ret = translateException((NoSuchTableException)exception);
    else if (exception instanceof NoSuchFieldException)
      ret = translateException((NoSuchFieldException)exception);
    else if (exception instanceof TableNotInFromClause)
      ret = translateException((TableNotInFromClause)exception);
    else if (exception instanceof NoGroupExistsException)
    	ret = translateException((NoGroupExistsException)exception);
    else
      ret = translateException((Exception)exception);
    return ret;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(CharStreamIOException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(MismatchedCharException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（标记符不正确）
   * @return ChWrongMessage 错误信息对象
   */
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
      " 实际输入 \""+input+"\"。";
    msg.setMessage(message);
    if (input != null && input.equals("") && input.length() > 0)
      msg.setLength(input.length());
    return msg;
  }

  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（无法识别的关键字）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(NoViableAltException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    String token=exception.token.getText();
    msg.setMessage("无法识别的关键字 \""+token+"\"。");
    msg.setLine(exception.line);
    msg.setColumn(exception.column);
    msg.setLength((token==null)?0:token.length());
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(NoViableAltForCharException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(1);
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(SemanticException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(2);
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(TokenStreamIOException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(3);
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(TokenStreamRecognitionException exception) {
    
    ChWrongMessage msg=new ChWrongMessage();
    msg.setLine(exception.recog.line);
    msg.setColumn(exception.recog.column);
    msg.setLength(-1);
    
    char ch=0;
    int m = 1;
    boolean isChFlag = false;
    while (!isChFlag){
      try {
        ch = chQuery.charAt(msg.getColumn() - m);
        isChFlag = true;
      }catch(Exception ex){
        m++;
      }
    }
    
    msg.setMessage("非法字符 \""+ch+"\"。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(TokenStreamRetryException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(exception.getMessage());
    msg.setLine(5);
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（表的个数不存在）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(TableNumberException exception) {
  	ChWrongMessage msg = new ChWrongMessage();
    msg.setMessage("表的个数不一致：需要的表的个数为"+ exception.getExistTableNumber() + 
    		"，而实际传入的表的个数为" + exception.getInputTableNumber() + "。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（输入的表不存在）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(NoSuchTableException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage("不存在表 \""+exception.getTableName()+"\"。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（表中不存在所输入的字段）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(NoSuchFieldException exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "表 \""+exception.getTableChName()+"\" 中不存在字段 \""+exception.getFieldChName()+"\"。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（SELECT的字段中的表没有在FROM中出现）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(TableNotInFromClause exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage(
        "表 \""+exception.getTableName()+"\" 没有在 [来自] 段出现。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（表的个数不存在）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(NoGroupExistsException exception) {
  	ChWrongMessage msg = new ChWrongMessage();
    msg.setMessage("[查询]子句 \""+ exception.getSelectExpr() + "\" 没有在[分组]子句中出现。");
    return msg;
  }
  
  /**
   * 翻译ANTLR异常信息到业务化错误信息对象ChWrongMessage
   * @param exception ANTLR异常信息（不可识别异常）
   * @return ChWrongMessage 错误信息对象
   */
  private ChWrongMessage translateException(Exception exception) {
    ChWrongMessage msg=new ChWrongMessage();
    msg.setMessage("语法解析过程中发生错误，请与系统管理员联系。");
    return msg;
  }
  
  /**
   * 增加ANTLR异常信息到编译器antlrExceptions的List集合中
   * @param e ANTLRException ANTLR异常信息
   */
  public void addException(ANTLRException e) {
    antlrExceptions.add(e);
  }
  
  /**
   * 获取所有错误信息到ChWrongMessage[]错误对象数组
   * @return ChWrongMessage[] 错误对象数组
   */
  public ChWrongMessage[] getWrongMessages() {
    ChWrongMessage[] ret = new ChWrongMessage[antlrExceptions.size()];
    int i = 0;
    for (Iterator it = antlrExceptions.iterator(); it.hasNext();){
      ret[i] = (translateException((ANTLRException)it.next()));
      i++;
    }
    return ret;
  }

}
