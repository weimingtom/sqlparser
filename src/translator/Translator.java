package translator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import model.parser.AggregateExprListModel;
import model.parser.AggregateExprModel;
import model.parser.AliasModel;
import model.parser.ChWrongMessage;
import model.parser.ColumnModel;
import model.parser.EquationModel;
import model.parser.ExpressionModel;
import model.parser.FieldModel;
import model.parser.FunctionModel;
import model.parser.OrderAliasModel;
import model.parser.OrderExpressionListModel;
import model.parser.OrderExpressionModel;
import model.parser.QueryModel;
import model.parser.SearchConditionModel;
import model.parser.SelectListModel;
import model.parser.SelectStatementModel;
import model.parser.StringModel;
import model.parser.TableAliasModel;
import model.parser.TableCompareModel;
import model.parser.TableListModel;
import model.parser.TableModel;
import model.parser.TableUnionModel;

import model.parser.common.Constants;
import model.parser.common.DataBaseType;
import model.parser.exceptions.NoSuchFieldException;
import model.parser.exceptions.NoSuchTableException;
import model.parser.exceptions.TableNotInFromClause;
import model.parser.exceptions.TableNumberException;

/**
 * 编译器与翻译器基本功能的实现类V1.0<br>
 * 修改日志：<br>
 * ======================================================<br>
 * 05/28/2007：<br>
 * 	- 翻译器对象增加databaseType属性，用来对多种数据库的扩展<br>
 * 05/29/2007：<br>
 * 	-	setChQuery方法增加isGroupByValid参数，用来判断[分组]子句<br>
 * 		是否对聚合函数的有效性进行验证<br>
 * 06/05/2007：<br>
 * 	-	loadModelFromXML方法增加对异常集合长度的判断，如果有异常，<br>
 * 		则直接返回QueryModel 对象<br>
 * 06/12/2007:<br>
 * 	- getXmlString、loadModelFromXML方法增加对databaseType<br>
 * 		的转化，用来判断语句的数据库类型<br>
 * 06/13/2007:<br>
 * 	- 重载getCnKeyWords方法，增加databaseType参数，用来根据数据<br>
 * 		库类型获取对应中文关键字信息
 * 07/31/2007:<br>
 *  - 修改了getChFromStr()方法，表名因rowid(表)而引起的重复问题
 * ======================================================
 */
public class Translator {
  //业务常用关键字、函数的属性文件
  private static final String CN_KEY_WORDS = "cnKeyWords";
  
  //中文关键字属性KEY
  public static final String CNKEY_WORDS = "cnKeyWords";
  public static final String CNKEY_FUNC = "cnFunc";
  private static final String CNKEY_ORACLE_FUNC = "cnFunc_oracle";
  private static final String CNKEY_SYBASE_FUNC = "cnFunc_sybase";
  private static final String CNKEY_DB2_FUNC = "cnFunc_db2";
  public static final String CNKEY_OPERSYMBOL = "operSymbol";
  public static final String CNKEY_LOGICSYMBOL = "logicSymbol";
  public static final String CNKEY_NUMBERSYMBOL = "numberSymbol";
  
  //英文关键字名称属性KEY
  public static final String ENVALUE_SELECT = "select";
  public static final String ENVALUE_ALL = "all";
  public static final String ENVALUE_FROM = "from";
  public static final String ENVALUE_WHERE = "where";
  public static final String ENVALUE_GROUPBY = "group_by";
  public static final String ENVALUE_ORDERBY = "order_by";
  public static final String ENVALUE_UNION = "table_union";
  public static final String ENVALUE_COMPARE = "table_compare";
  
  //片段子句关键字
  public static final String COLUMN = Constants.COLUMN;
  public static final String FROM = Constants.FROM;
  public static final String WHERE = Constants.WHERE;
  
  public static final String CIRCLE_TYPE_TABLE = "1"; //表变量循环
  public static final String CIRCLE_TYPE_WHERE = "2"; //条件变量循环
  
  ///////////////////////////////////////////////////
  private QueryModel model;
  private DbTable[] tables;
  private DbTableInfo info = new DbTableInfo();
  private List appDbTableList = new ArrayList();
  private SelectListVO[] selectListVOArr = new SelectListVO[0];
  private FromListVO[] fromListVOArr = new FromListVO[0];
  private WhereListVO[] whereListVOArr = new WhereListVO[0];
  private GroupByListVO[] groupByListVOArr = new GroupByListVO[0];
  private OrderByListVO[] orderByListVOArr = new OrderByListVO[0];
  private List aliasModelList = new ArrayList();
  private List tableAliasModelList = new ArrayList();
  private List orderAliasModelList = new ArrayList();
  private String databaseType;
  
  public Translator(){
  }
  
  public Translator(String databaseType){
  	this.databaseType = databaseType;
  }
  
  public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	/**
   * 根据关键字值获取对应中文关键字名称
   * @param _mValue 关键字值
   * @return String 中文关键字名称
   */
  public static String getCnKeyWordByValue(String _mValue){
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
  public static String getCnKeyWords(String keyName) {
    String[] cnKeyWordsArr = new String[]{CNKEY_WORDS, CNKEY_FUNC, CNKEY_OPERSYMBOL, CNKEY_LOGICSYMBOL, CNKEY_NUMBERSYMBOL};
    
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
   * 根据关键字/函数/操作符/运算符的KEY获取对应中文关键字名称
   * @param keyName 关键字/函数/操作符/运算符属性KEY
   * @return String 中文关键字名称
   */
  public static String getCnKeyWords(String databaseType, String keyName) {
  	String cnKeyFuncs = CNKEY_FUNC;
  	if (databaseType != null && !databaseType.equals("")){
	  	if (databaseType.equals(DataBaseType.ORACLE8i) || databaseType.equals(DataBaseType.ORACLE9i)){
	  		cnKeyFuncs = CNKEY_ORACLE_FUNC;
	  	}else if (databaseType.equals(DataBaseType.SYBASE_ASE_12) || databaseType.equals(DataBaseType.SYBASE_IQ_12)){
	  		cnKeyFuncs = CNKEY_SYBASE_FUNC;
	  	}else if (databaseType.equals(DataBaseType.DB2_UDB_8x) || databaseType.equals(DataBaseType.DB2_UDB_9x)){
	  		cnKeyFuncs = CNKEY_DB2_FUNC;
	  	}else{
	  		cnKeyFuncs = CNKEY_FUNC;
	  	}
  	}
  	if (keyName.equals(CNKEY_FUNC)){
  		keyName = cnKeyFuncs;
  	}
  	
    String[] cnKeyWordsArr = new String[]{CNKEY_WORDS, cnKeyFuncs, CNKEY_OPERSYMBOL, CNKEY_LOGICSYMBOL, CNKEY_NUMBERSYMBOL};
    
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
	 * 设置中文查询语句到编译器并验证
	 * @param chQuery 业务化的中文查询语句
	 */
  public void setChQuery(String chQuery) {
  	if (databaseType == null)
  		model = QueryModel.parseQuery(chQuery);
  	else
  		model = QueryModel.parseQuery(chQuery, databaseType, true);
  }
  
  /**
   * 设置中文查询语句到编译器并验证
   * @param chQuery 业务化的中文查询语句
   * @param isGroupByValid [分组]字句的聚合函数是否进行有效验证
   */
  public void setChQuery(String chQuery, boolean isGroupByValid) {
  	if (databaseType == null)
  		model = QueryModel.parseQuery(chQuery, isGroupByValid);
  	else
  		model = QueryModel.parseQuery(chQuery, databaseType, isGroupByValid);
  }
  
  /**
   * 设置片段查询子句并进行验证
   * @param type 片段子句类型
   * @param chSegment 片段子句
   */
  public void setChSegment(String type, String chSegment) {
    String cnQuery = type + " " + chSegment;
    model =  QueryModel.parseSegment(cnQuery);
  }
  
  /**
   * 获取格式化后的中文查询语句
   * @return String 格式化后的中文查询语句
   */
  public String getChQuery() {
    return model.getChString();
  }
  
  /**
   * 获取SELECT子句的查询语句
   * @return String SELECT子句的查询语句
   */
  public String getChSelectStr(){
    if (model.getFirstModelByClass(SelectListModel.class) != null)
      return (model.getFirstModelByClass(SelectListModel.class)).getChString();
    else
      return "";
  }
  
  /**
   * 获取FROM子句的查询语句
   * @return String FROM子句的查询语句
   */
  public String getChFromStr(){
    String rValue = "";
    if (model instanceof TableCompareModel || model instanceof TableUnionModel){
    	QueryModel tableListModel = model.getFirstModelByClass(TableListModel.class);	//2007-07-31 HJD Add
    	if (tableListModel != null){
	      QueryModel[] tableModelArr = tableListModel.getModelsFromAllChildrenByClass(TableModel.class);
	      if (tableModelArr.length > 0){
	        rValue = tableModelArr[0].getChString();
	        for (int i = 1; i < tableModelArr.length; i++){
	          rValue += ", " + tableModelArr[i].getChString();
	        }
	      }
    	}
    }else{
      if (model.getFirstModelByClass(TableListModel.class) != null)
        rValue = (model.getFirstModelByClass(TableListModel.class)).getChString();
    }
    return rValue;
  }
  
  /**
   * 获取WHERE子句的查询语句
   * @return String WHERE子句的查询语句
   */
  public String getChWhereStr(){
    if (model.getFirstModelByClass(SearchConditionModel.class) != null)
      return (model.getFirstModelByClass(SearchConditionModel.class)).getChString();
    else
      return "";
  }
  
  /**
   * 获取GROUP BY子句的查询语句
   * @return String GROUP BY子句的查询语句
   */
  public String getChGroupByStr(){
    if (model.getFirstModelByClass(AggregateExprListModel.class) != null)
      return (model.getFirstModelByClass(AggregateExprListModel.class)).getChString();
    else
      return "";
  }
  
  /**
   * 获取ORDER BY子句的查询语句
   * @return String ORDER BY子句的查询语句
   */
  public String getChOrderByStr(){
    if (model.getFirstModelByClass(OrderExpressionListModel.class) != null)
      return (model.getFirstModelByClass(OrderExpressionListModel.class)).getChString();
    else
      return "";
  }
  
  /**
   * 获取经解析后的表单及字段属性信息对象数组
   * @return DbTable[] 表单及字段属性信息对象数组
   */
  public DbTable[] getTables() {
    List tables = new ArrayList();
    QueryModel[] tms = model.getTables();
    for (int i = 0; i < tms.length; i++){
      TableModel tm = (TableModel) tms[i];
      DbTable t = new DbTable(tm);
      tables.add(t);
    }
    QueryModel[] fms = model.getFields();
    for (int i = 0; i < fms.length; i++){
      FieldModel fm = (FieldModel) fms[i];
      boolean tableNotFound = true;
      for (Iterator it = tables.iterator(); it.hasNext();){
        DbTable t = (DbTable) it.next();
        if (fm.getTableName() != null
            && (fm.getTableName().equals(t.getChName()) || fm.getTableName().equals(t.getAlias()))){
          t.addDbField(fm);
          tableNotFound = false;
          break;
        }
      }
      if (tableNotFound)
        model.addException(new TableNotInFromClause(fm.getChString()));
    }

    DbTable[] ret = new DbTable[tables.size()];
    int i = 0;
    for (Iterator it = tables.iterator(); it.hasNext();)
      ret[i++] = (DbTable) it.next();
    this.tables = ret;  //Add
    return ret;
  }
  
  /**
   * 根据Translator对象数组中预设的表单、字段属性信息更新DbTable对象数组内容
   * @param t Translator对象数组
   * @param ts DbTable对象数组
   */
  public void updateDbTables(Translator t, DbTable[] ts) {
  	LinkedHashMap tableHM = model.getRowidTables();
  	
    if (t.getQueryModel() instanceof TableUnionModel){  //如果为表合并（追加）
      AppDbTable[] _appDbTablesArr = t.info.getDbTableInfoToAppTableArr();
      if (_appDbTablesArr.length >= ts.length){
        
        for (int i = 0; i < ts.length; i++) {
          DbTable _dbTable = ts[i];
          
          //根据DbTable的中文表名获取业务上传入的英文表名
          String enTableName = t.getTableEnName(_dbTable.getChName());
          
          //循环查找tableHM中的KEY是否有DbTable对应的表名
          for (Iterator t_it = tableHM.keySet().iterator(); t_it.hasNext();) {
          	String rTableName = (String)t_it.next();
          	TableModel rTableModel = (TableModel)tableHM.get(rTableName);
          	if ((rTableModel.getTableName() == null || rTableModel.getTableName().equals(""))
          			&& _dbTable.getChName().equals(rTableName)){
          		rTableModel.setTableEnName(enTableName);
          		break;
          	}
          }
          
          //如果业务上英文表名不存在则提示错误信息，如果存在则将英文表名赋值给DbTable对象
          if (enTableName == null || enTableName.equals("")){
            model.addException(new NoSuchTableException(_dbTable.getChName()));
          }else{
            _dbTable.setEnName(t.getTableEnName(_dbTable.getChName()));
          }
          
          //获取业务上传入的当前表名所有字段属性
          AppDbField[] _appDbFieldsArr = _appDbTablesArr[i].getFields();
          for (int j = 0; j < _appDbFieldsArr.length; j++){
            String cnFieldName = _appDbFieldsArr[j].getChName();
            String enFieldName = _appDbFieldsArr[j].getEnName();
            
            //如果业务上的英文字段不存在则提示错误信息，如果存在则将英文字段赋值给DbTable对象的DbField属性
            if (enFieldName == null || enFieldName.equals("")){
              model.addException(new NoSuchFieldException(_dbTable.getChName(), cnFieldName));
            }else{
              _dbTable.addToDbField(cnFieldName, enFieldName);
            }
          }
          
        }
        
      }else{
      	model.addException(new TableNumberException(ts.length, _appDbTablesArr.length));
      }
    }else{  //如果为常规语句或者比较语句
      for (int i = 0; i < ts.length; i++) {
        DbTable dbt = ts[i];
        
        //根据DbTable的中文表名获取业务上传入的英文表名
        String enTableName = t.getTableEnName(dbt.getChName());
        
        //循环查找tableHM中的KEY是否有DbTable对应的表名
        for (Iterator t_it = tableHM.keySet().iterator(); t_it.hasNext();) {
        	String rTableName = (String)t_it.next();
        	TableModel rTableModel = (TableModel)tableHM.get(rTableName);
        	if ((rTableModel.getSTableEnName() == null || rTableModel.getSTableEnName().equals(""))
        			&& dbt.getChName().equals(rTableName)){
        		rTableModel.setTableEnName(enTableName);
        		break;
        	}
        }
        
        if (enTableName == null || enTableName.equals("")){
        	model.addException(new NoSuchTableException(dbt.getChName()));
        }else{
          dbt.setEnName(t.getTableEnName(dbt.getChName()));
        }
        
        //获取DbTable中的当前表名所有字段属性（查询语句中的字段属性）
        for (Iterator it = dbt.getFields().iterator(); it.hasNext();) {
          DbField dbf = (DbField)it.next();
          dbf.setTableEnName(dbt.getEnName());
          //获取业务上传入的英文字段名称
          String enFieldName = t.getFieldEnName(dbt.getChName(), dbf.getChName());
          //如果业务上的英文字段不存在则提示错误信息，如果存在则将英文字段赋值给DbTable对象的DbField属性
          if (enFieldName == null || enFieldName.equals("")){
            model.addException(new NoSuchFieldException(dbt.getChName(), dbf.getChName()));
          }else{
            dbf.setEnName(t.getFieldEnName(dbt.getChName(), dbf.getChName()));
          }
        }
      }
    }
    
    //查找tableHM中TableModel的tableEnName为空，增加到异常集合去
    QueryModel[] tableModelArr = model.getModelsFromAllChildrenByClass(TableModel.class);
    for (Iterator t_it = tableHM.keySet().iterator(); t_it.hasNext();) {
    	String rTableName = (String) t_it.next();
    	TableModel rTableModel = (TableModel)tableHM.get(rTableName);
    	if (rTableModel.getSTableEnName() == null || rTableModel.getSTableEnName().equals("")){
    		model.addException(new NoSuchTableException(rTableName));
    	}else{
    		for (int i = 0; i < tableModelArr.length; i++){
    			TableModel tableModel = (TableModel) tableModelArr[i];
    			if ((tableModel.getSTableEnName() == null || tableModel.getSTableEnName().equals(""))
    					&& tableModel.getTableName().equals(rTableName)){
    				tableModel.setTableEnName(rTableModel.getTableEnName());
    			}
    		}
    	}
    }
    
  }
  
  /**
   * 清空DbTableInfo表及字段信息
   *
   */
  public void clearInfo() {
    this.model.clearDbTableModel(); //清空QueryModel模型中的DbTableModel信息
    this.info = new DbTableInfo();  //清空Translator本地DbTableInfo信息
  }
  
  /**
   * 获取业务系统中表单及字段信息
   * @return DbTableInfo 包含表单HashMap及字段属性，
   *                     每个表单的字段属性也为HashMap
   */
  public DbTableInfo getInfo() {
    return info;
  }
  
  /**
   * 设置业务系统中表单及字段信息
   * @param info DbTableInfo 表单及字段信息对象
   */
  public void setInfo(DbTableInfo info) {
    this.info = info;
  }

  /**
   * 增加表单对象
   * @param tableChName 中文表名
   * @param tableEnName 英文表名
   */
  public void addDbTable(String tableChName, String tableEnName) {
    this.getQueryModel().addDbTable(tableChName, tableEnName);
    info.setTableEnName(tableChName, tableEnName);
  }
  
  /**
   * 增加表单对象
   * @param tableChName 中文表名
   * @param tableEnName 英文表名
   * @param flag 是否临时表标识
   */
  public void addDbTable(String tableChName, String tableEnName, String flag) {
    this.getQueryModel().addDbTable(tableChName, tableEnName);
    info.setTableEnName(tableChName, tableEnName, flag);
  }
  
  /**
   * 增加表单对象
   * @param tableChName 中文表名
   * @param tableEnName 英文表名
   * @param flag 是否临时表标识
   * @param tableParam 表变量名称
   */
  public void addDbTable(String tableChName, String tableEnName, String flag, String tableParam) {
    if (tableParam != null && !tableParam.equals(""))
      this.getQueryModel().setCircleType(CIRCLE_TYPE_TABLE);  //设置为表循环
    this.getQueryModel().addDbTable(tableChName, tableEnName);
    info.setTableEnName(tableChName, tableEnName, flag, tableParam);
  }
  
  /**
   * 增加表字段属性对象
   * @param tableChName 中文表名
   * @param fieldChName 中文字段
   * @param fieldEnName 英文字段
   */
  public void addDbField(String tableChName, String fieldChName, String fieldEnName) {
    this.getQueryModel().addDbField(tableChName, fieldChName, fieldEnName);
    info.setFieldEnName(tableChName, fieldChName, fieldEnName);
  }
  
  /**
   * 增加表字段属性对象
   * @param tableChName 中文表名
   * @param fieldChName 中文字段
   * @param fieldEnName 英文字段
   * @param fieldParam 条件变量名称
   */
  public void addDbField(String tableChName, String fieldChName, String fieldEnName, String fieldParam) {
    if ((this.getQueryModel().getCircleType() == null || this.getQueryModel().getCircleType().equals("")) &&
        fieldParam != null && !fieldParam.equals("")){
      this.getQueryModel().setCircleType(CIRCLE_TYPE_WHERE);  //设置为条件循环
    }
    this.getQueryModel().addDbField(tableChName, fieldChName, fieldEnName);
    info.setFieldEnName(tableChName, fieldChName, fieldEnName, fieldParam);
  }
  
  /**
   * 根据表单中文名获取表单的英文名
   * @param tableChName 表单中文名
   * @return String 表单的英文名
   */
  public String getTableEnName(String tableChName) {
    return info.getTableEnName(tableChName);
  }
  
  /**
   * 根据表单中文名及字段的中文名获取字段的英文名
   * @param tableChName 表单中文名
   * @param fieldChName 字段的中文名
   * @return String 字段的英文名
   */
  public String getFieldEnName(String tableChName, String fieldChName) {
    return info.getFieldEnName(tableChName, fieldChName);
  }
  
  /**
   * 设置表单及字段属性信息到编译器模型的DbTable中（暂时无法使用）
   * @param tables 编译器中DbTable对象数组
   * @param appTables 应用中的AppDbTable对象数组
   */
  public void setTableInfoToModel(DbTable[] tables, AppDbTable[] appTables){
    for (int i = 0; i < tables.length; i++){
      int m = -1;
      for (int j = 0; j < appTables.length; j++){
        if (tables[i].getChName().equals(appTables[j].getTableName())){
          m = j;
          break;
        }
      }
      if (m >= 0){
        tables[i].setEnName(appTables[m].getTableEnName());
        AppDbField[] appDbFields = appTables[m].getFields();
        for (int k = 0; k < appDbFields.length; k++){
          tables[i].addDbField(appDbFields[k].getChName(), appDbFields[k].getEnName());
        }
      }
    }
  }
  
  /**
   * 设置表单及字段属性信息对象数组到编译器
   * @param tables 表单及字段属性信息对象数组
   */
  public void setTableInfo(DbTable[] tables) {
//    this.tables = tables;
    for (int i = 0; i < tables.length; i++){
      DbTable t = tables[i];
      if (t.getEnName() == null)
        model.addException(new NoSuchTableException(t.getChName()));
      for (Iterator it = t.getFields().iterator(); it.hasNext();){
        DbField f = (DbField) it.next();
        if (f.getEnName() == null)
          model.addException(new NoSuchFieldException(t.getChName(), f.getChName()));
      }
    }
  }

  /**
   * 获取经过解析后的编译器QueryModel模型对象
   * @return QueryModel 编译器QueryModel模型对象
   */
  public QueryModel getQueryModel() {
    return model;
  }
  
  /**
   * 语法校验是否有错误
   * @return boolean（true表示有错误,false表示无错误）
   */
  public boolean hasError() {
    return model.hasError();
  }
  
  /**
   * 获取所有错误信息集合
   * @return ChWrongMessage[] 错误信息对象数组
   */
  public ChWrongMessage[] showWrongMsgs() {
    return model.getWrongMessages();
  }
  
  /**
   * 将QueryModel模型信息转化成XML内容
   * @return String XML内容
   */
  public String getXmlString() {
    Document d = DocumentHelper.createDocument();
    Element e = d.addElement("query");
    
    Element chQueryString = e.addElement("ch_query_string");
    chQueryString.addText(model.getChString());
    
    Element databaseTypeElem = e.addElement("databaseType");
    databaseTypeElem.addText(model.getDatabaseType());
    
    info.getElement(model.getDbTableModel(), e); //将表名称信息及字段属性信息转化成XML内容
    
//    for (int i = 0; i < appDbTableList.size(); i++){
//      AppDbTable appDbTable = (AppDbTable) appDbTableList.get(i);
//      appDbTable.getElement(e);
//    }
//    for (int i = 0; i < tables.length; i++)
//      tables[i].getElement(e);
    
    //SelectListVO对象信息转成XML内容
    Element selectListEquElem = e.addElement("selectListEqu");
    for (int i = 0; i < selectListVOArr.length; i++){
      Element selectListElem = selectListEquElem.addElement("SelectListVO");
      selectListElem.addAttribute("fieldDataType", selectListVOArr[i].getFieldDataType());
    }
    
    //WhereListVO对象信息转成XML内容
    Element whereListEquElem = e.addElement("whereListEqu");
    for (int i = 0; i < whereListVOArr.length; i++){
      Element whereListElem = whereListEquElem.addElement("WhereListVO");
      whereListElem.addAttribute("checkedFlag", whereListVOArr[i].getCheckedFlag());
    }
    
    //字段/字段表达式别名AliasModel内容转成XML内容
    Element aliasListEquElem = e.addElement("aliasListEqu");
    QueryModel[] aliasModelArr = model.getModelsFromAllChildrenByClass(AliasModel.class);
    for (int i = 0; i < aliasModelArr.length; i++){
      Element aliasListElem = aliasListEquElem.addElement("aliasListVO");
      aliasListElem.addAttribute("alias", ((AliasModel)aliasModelArr[i]).getAlias());
      aliasListElem.addAttribute("enAlias", ((AliasModel)aliasModelArr[i]).getEnAlias());
    }
    
    //表别名TableAliasModel内容转化成XML内容
    Element tableAliasListEquElem = e.addElement("tableAliasListEqu");
    QueryModel[] tableAliasModelArr = model.getModelsFromAllChildrenByClass(TableAliasModel.class);
    for (int i = 0; i < tableAliasModelArr.length; i++){
      Element tableAliasListElem = tableAliasListEquElem.addElement("tableAliasListVO");
      tableAliasListElem.addAttribute("alias", ((TableAliasModel)tableAliasModelArr[i]).getAlias());
      tableAliasListElem.addAttribute("enAlias", ((TableAliasModel)tableAliasModelArr[i]).getEnAlias());
    }
    
    //排序别名OrderAliasModel内容转成XML内容
    Element orderAliasListEquElem = e.addElement("orderAliasListEqu");
    QueryModel[] orderAliasModelArr = model.getModelsFromAllChildrenByClass(OrderAliasModel.class);
    for (int i = 0; i < orderAliasModelArr.length; i++){
      Element orderAliasListElem = orderAliasListEquElem.addElement("orderAliasListVO");
      orderAliasListElem.addAttribute("alias", ((OrderAliasModel)orderAliasModelArr[i]).getAlias());
      orderAliasListElem.addAttribute("enAlias", ((OrderAliasModel)orderAliasModelArr[i]).getEnAlias());
    }
    return d.asXML();
  }
  
  /**
   * 将XML内容转成QueryModel对象信息
   * @param iXML XML内容
   * @return QueryModel QueryModel对象
   * @throws DocumentException
   */
  public QueryModel loadModelFromXML(String iXML) throws DocumentException {
  	return loadModelFromXML(iXML, "");
  }
  
  /**
   * 将XML内容转成QueryModel对象信息
   * @param iXML XML内容
   * @param dataBaseType 数据库类型
   * @return QueryModel QueryModel对象
   * @throws DocumentException
   */
  public QueryModel loadModelFromXML(String iXML, String dataBaseType) throws DocumentException {
    Document document = DocumentHelper.parseText(iXML);
    Element root = document.getRootElement();
    String query = root.elementText("ch_query_string");

    String rDatabaseType = root.elementText("databaseType");
    if (dataBaseType != null && !dataBaseType.equals("")){
    	rDatabaseType = dataBaseType;
    }
    
    model = QueryModel.parseQuery(query, rDatabaseType);
    
    if (model.getWrongMessages().length > 0){
    	return model;
    }
    
//    DbTable[] tables = getTables();
//    for (int i = 0; i < tables.length; i++){
//      for (Iterator it = root.elementIterator("db_info"); it.hasNext();){
//        Element e = (Element) it.next();
//        if (e.attributeValue("ch_name").equals(tables[i].getChName()))
//          tables[i].initTableFromElement(e);
//      }
//    }
//    setTableInfo(tables);
    
    //首先获取QueryModel中的
    //SelectListVO、FromListVO、WhereListVO、GroupByListVO、OrderByListVO
    getSelectListVOArr();
    getFromListVOArr();
    getWhereListVOArr();
    getGroupByListVOArr();
    getOrderByListVOArr();
    
    appDbTableList = new ArrayList();
    //如果XML内容中存在着SelectListVO需要的信息则进行设置
    for (Iterator it = root.elementIterator(); it.hasNext();) {
      Element elem = (Element)it.next();
      if (elem.getName().equals("ch_query_string")){
        //model.setCircleType(elem.attributeValue("circleType"));
      }
      if (elem.getName().equals("db_info")){
        //AppDbTable appDbTable = new AppDbTable();
        //appDbTable.setTableName(elem.attributeValue("ch_name"));
        //appDbTable.setTableEnName(elem.attributeValue("en_name"));
        addDbTable(elem.attributeValue("ch_name"), elem.attributeValue("en_name"),
            elem.attributeValue("flag"), elem.attributeValue("tableParam"));
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          //appDbTable.addDbField(e.attributeValue("ch_name"), e.attributeValue("en_name"));
          addDbField(elem.attributeValue("ch_name"), e.attributeValue("ch_name"), 
              e.attributeValue("en_name"), e.attributeValue("fieldParam"));
        }
        //appDbTableList.add(appDbTable);
      }
      
      if (elem.getName().equals("selectListEqu")){
        int m = 0;
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          selectListVOArr[m].setFieldDataType(e.attributeValue("fieldDataType"));
          m++;
        }
      }
      
      if (elem.getName().equals("whereListEqu")){
        int m = 0;
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          whereListVOArr[m].setCheckedFlag(e.attributeValue("checkedFlag"));
          m++;
        }
      }
      
      //如果XML内容中存在着aliasModelList需要的别名信息则进行设置
      if (elem.getName().equals("aliasListEqu")){
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          AliasModel aliasModel = new AliasModel(e.attributeValue("alias"));
          aliasModel.setEnAlias(e.attributeValue("enAlias"));
          aliasModelList.add(aliasModel);
        }
      }
      
      //如果XML内容中存在着tableAliasModelList需要的别名信息则进行设置
      if (elem.getName().equals("tableAliasListEqu")){
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          TableAliasModel tableAliasModel = new TableAliasModel(e.attributeValue("alias"));
          tableAliasModel.setEnAlias(e.attributeValue("enAlias"));
          tableAliasModelList.add(tableAliasModel);
        }
      }
      
      //如果XML内容中存在着orderAliasModelList需要的别名信息则进行设置
      if (elem.getName().equals("orderAliasListEqu")){
        for (Iterator it1 = elem.elementIterator(); it1.hasNext();){
          Element e = (Element)it1.next();
          OrderAliasModel orderAliasModel = new OrderAliasModel(e.attributeValue("alias"));
          orderAliasModel.setEnAlias(e.attributeValue("enAlias"));
          orderAliasModelList.add(orderAliasModel);
        }
      }
    }
    //updateDbTables(this, this.getTables());
    //DbTable[] _dbTablesArr = this.getTables();
    //setTableInfoToModel(_dbTablesArr, appDbTableList);
    //setTableInfo(_dbTablesArr);
    return model;
  }
  
  /**
   * 获取SELECT子句下所有表达式对象数组
   * 
   * @return SelectListVO[] SelectListVO对象数组
   */
  public SelectListVO[] getSelectListVOArrByModel() {
    
    QueryModel[] columnModelArr = model.getModelsFromAllChildrenByClass(ColumnModel.class);
    SelectListVO[] _selectListVOArr = new SelectListVO[columnModelArr.length];
    for (int i = 0; i < columnModelArr.length; i++){
      SelectListVO _selectListVO = new SelectListVO();
      QueryModel[] expressArr = columnModelArr[i].getModelByClass(ExpressionModel.class);
      AliasModel aliasModel = (AliasModel) columnModelArr[i].getFirstModelByClass(AliasModel.class);
      if (expressArr.length > 0)
        _selectListVO.setCnColumnEquElem(expressArr[0].getChString());
      if (aliasModel != null){
        _selectListVO.setCnFieldAlias(aliasModel.getAlias());
        _selectListVO.setEnFieldAlias(aliasModel.getEnAlias());
      }
      _selectListVOArr[i] = _selectListVO;
    }
    return _selectListVOArr;
  }
  
  /**
   * 将SELECT子句的SelectListVO[]对象数组相关信息更新到编译器ColumnModel模型对象
   * （目前只针对没有别名情况下，可通过SelectListVO[]的别名设置）
   * @param selectListVOArr SELECT子句对象数组
   */
  public void setSelectListVOArrToModel(SelectListVO[] selectListVOArr) {
    QueryModel[] columnModelArr = model.getModelsFromAllChildrenByClass(ColumnModel.class);
    if (selectListVOArr != null && selectListVOArr.length > 0 
        && columnModelArr.length == selectListVOArr.length){
      
      for (int i = 0; i < selectListVOArr.length; i++){
        //从对应的COLUMN模型中获取字段别名模型
        AliasModel aliasModel = (AliasModel) columnModelArr[i].getFirstModelByClass(AliasModel.class);
        
        //如果编译器中不存在字段别名模型但SelectListVO却有，则设置到编译器COLUMN模型ColumnModel中
        if (aliasModel == null && !selectListVOArr[i].getCnFieldAlias().equals("")){
          aliasModel = new AliasModel(selectListVOArr[i].getCnFieldAlias());
          aliasModel.setEnAlias(selectListVOArr[i].getEnFieldAlias());
          ((ColumnModel)columnModelArr[i]).addAlias(aliasModel); //增加字段别名模型AliasModel
        }
      }
      
    }
  }
  
  /**
   * 获取FROM子句下所有表达式对象数组
   * @return FromListVO[] FromListVO对象数组
   */
  public FromListVO[] getFromListVOArrByModel() {
  	FromListVO[] _fromListVOArr = new FromListVO[0];
  	TableListModel tableListModel = (TableListModel) model.getFirstModelByClass(TableListModel.class);
  	if (tableListModel != null){
	    QueryModel[] _tableModelArr = tableListModel.getModelsFromAllChildrenByClass(TableModel.class);
	    _fromListVOArr = new FromListVO[_tableModelArr.length];
	    for (int i = 0; i < _tableModelArr.length; i++){
	      FromListVO _fromListVO = new FromListVO();
	      _fromListVO.setCnTableName(((TableModel)_tableModelArr[i]).getTableName());
	      AliasModel aliasModel = (AliasModel) _tableModelArr[i].getFirstModelByClass(AliasModel.class);
	      if (aliasModel != null)
	        _fromListVO.setCnTAbleAlias(aliasModel.getAlias());
	      _fromListVOArr[i] = _fromListVO;
	    }
  	}
    return _fromListVOArr;
  }
  
  /**
   * 获取WHERE子句下所有表达式对象数组
   * @return WhereListVO[] WhereListVO对象数组
   */
  public WhereListVO[] getWhereListVOArrByModel() {
    QueryModel[] _equationModelArr = model.getModelsFromAllChildrenByClass(EquationModel.class);
    WhereListVO[] _whereListVOArr = new WhereListVO[_equationModelArr.length];
    for (int i = 0; i < _equationModelArr.length; i++){
      WhereListVO _whereListVO = new WhereListVO();
      _whereListVO.setCnAllWhereStr(_equationModelArr[i].getChString());
      QueryModel[] _expressionModelArr = _equationModelArr[i].getModelByClass(ExpressionModel.class);
      QueryModel _stringModel = _equationModelArr[i].getFirstModelByClass(StringModel.class);
      for (int j = 0; j < _expressionModelArr.length; j++){
        _whereListVO.setCnWhereEquElem(_expressionModelArr[0].getChString());
        if (j > 0){
          _whereListVO.setCnWhereValue(_expressionModelArr[1].getChString());
          _whereListVO.setConstant(((ExpressionModel)_expressionModelArr[1]).hasConstant());
        }
      }
      if (_stringModel != null)
        _whereListVO.setCnComparSymbol(_stringModel.getChString());
      
      _whereListVOArr[i] = _whereListVO;
    }
    return _whereListVOArr;
  }
  
  /**
   * 获取GROUP BY子句下所有表达式对象数组
   * @return GroupByListVO[] GroupByListVO对象数组
   */
  public GroupByListVO[] getGroupByListVOArrByModel() {
    QueryModel _aggregateExprListModel = model.getFirstModelByClass(AggregateExprListModel.class);
    if (_aggregateExprListModel == null){
      GroupByListVO[] _groupByListVOArr = new GroupByListVO[0];
      return _groupByListVOArr;
    }
    QueryModel[] _aggregateExprModelArr = _aggregateExprListModel.getModelsFromAllChildrenByClass(AggregateExprModel.class);
    GroupByListVO[] _groupByListVOArr = new GroupByListVO[_aggregateExprModelArr.length];
    for (int i = 0; i < _aggregateExprModelArr.length; i++){
      GroupByListVO _groupByListVO = new GroupByListVO();
      _groupByListVO.setCnGroupByEquElem(_aggregateExprModelArr[i].getChString());
      _groupByListVOArr[i] = _groupByListVO;
    }
    return _groupByListVOArr;
  }
  
  /**
   * 获取ORDER BY子句下所有表达式对象数组
   * @return OrderByListVO[] OrderByListVO对象数组
   */
  public OrderByListVO[] getOrderByListVOArrByModel() {
    QueryModel _orderExpressionListModel = model.getFirstModelByClass(OrderExpressionListModel.class);
    if (_orderExpressionListModel == null){
      OrderByListVO[] _orderByListVOArr = new OrderByListVO[0];
      return _orderByListVOArr;
    }
    QueryModel[] _orderExpressionModelArr = _orderExpressionListModel.getModelsFromAllChildrenByClass(OrderExpressionModel.class);
    OrderByListVO[] _orderByListVOArr = new OrderByListVO[_orderExpressionModelArr.length];
    for (int i = 0; i < _orderExpressionModelArr.length; i++){
      OrderByListVO _orderByListVO = new OrderByListVO();
      List orderEquElemli = _orderExpressionModelArr[i].getChildren();
      if (orderEquElemli.size() > 0){
        Object obj = orderEquElemli.get(0);
        if (obj instanceof FunctionModel){
          _orderByListVO.setCnOrerByEquElem(((FunctionModel)obj).getChString());
        }else if (obj instanceof FieldModel){
          _orderByListVO.setCnOrerByEquElem(((FieldModel)obj).getChString());
        }else if (obj instanceof OrderAliasModel){
          _orderByListVO.setCnOrerByEquElem(((OrderAliasModel)obj).getChString());
        }
      }
      _orderByListVO.setCnOrderType(((OrderExpressionModel)_orderExpressionModelArr[i]).getChSort());
      _orderByListVOArr[i] = _orderByListVO;
    }
    return _orderByListVOArr;
  }
  
  /**
   * 获取QueryModel模型的所有字段/字段表达式别名对象数组
   * @return  AliasModel[] 别名对象数组
   */
  public AliasModel[] getAliasModelListVOArrByModel(){
    QueryModel[] aliasModelArr = model.getModelsFromAllChildrenByClass(AliasModel.class);
    AliasModel[] _aliasModelArr = new AliasModel[aliasModelArr.length];
    for (int i = 0; i < aliasModelArr.length; i++){
      AliasModel aliasModel = (AliasModel) aliasModelArr[i];
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 获取XML内容转化后的所有字段/字段表达式别名对象数组
   * @return AliasModel[] 别名对象数组
   */
  public AliasModel[] getAliasModelListVOArrByXML(){
    AliasModel[] _aliasModelArr = new AliasModel[aliasModelList.size()];
    for (int i = 0; i < aliasModelList.size(); i++){
      AliasModel aliasModel = (AliasModel) aliasModelList.get(i);
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 将获取到XML内容的字段/字段表达式别名对象数组设置到QueryModel模型中
   */
  public void setAliasModelListVOArrByXML(){
    AliasModel[] _aliasModelArr1 = getAliasModelListVOArrByModel();
    AliasModel[] _aliasModelArr2 = getAliasModelListVOArrByXML();
    if (_aliasModelArr1.length != _aliasModelArr2.length)
      return;
    for (int i = 0; i < _aliasModelArr1.length; i++){
      _aliasModelArr1[i].setEnAlias(_aliasModelArr2[i].getEnAlias());
    }
  }
  
  /**
   * 获取QueryModel模型的所有表别名对象数组
   * @return  TableAliasModel[] 表别名对象数组
   */
  public TableAliasModel[] getTableAliasModelListVOArrByModel(){
    QueryModel[] aliasModelArr = model.getModelsFromAllChildrenByClass(TableAliasModel.class);
    TableAliasModel[] _aliasModelArr = new TableAliasModel[aliasModelArr.length];
    for (int i = 0; i < aliasModelArr.length; i++){
      TableAliasModel aliasModel = (TableAliasModel) aliasModelArr[i];
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 获取XML内容转化后的所有表别名对象数组
   * @return TableAliasModel[] 表别名对象数组
   */
  public TableAliasModel[] getTableAliasModelListVOArrByXML(){
    TableAliasModel[] _aliasModelArr = new TableAliasModel[tableAliasModelList.size()];
    for (int i = 0; i < tableAliasModelList.size(); i++){
      TableAliasModel aliasModel = (TableAliasModel) tableAliasModelList.get(i);
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 将获取到XML内容的表别名对象数组设置到QueryModel模型中
   */
  public void setTableAliasModelListVOArrByXML(){
    TableAliasModel[] _aliasModelArr1 = getTableAliasModelListVOArrByModel();
    TableAliasModel[] _aliasModelArr2 = getTableAliasModelListVOArrByXML();
    if (_aliasModelArr1.length != _aliasModelArr2.length)
      return;
    for (int i = 0; i < _aliasModelArr1.length; i++){
      _aliasModelArr1[i].setEnAlias(_aliasModelArr2[i].getEnAlias());
    }
  }
  
  /**
   * 获取QueryModel模型的所有排序别名对象数组
   * @return  AliasModel[] 别名对象数组
   */
  public OrderAliasModel[] getOrderAliasModelListVOArrByModel(){
    QueryModel[] aliasModelArr = model.getModelsFromAllChildrenByClass(OrderAliasModel.class);
    OrderAliasModel[] _aliasModelArr = new OrderAliasModel[aliasModelArr.length];
    for (int i = 0; i < aliasModelArr.length; i++){
      OrderAliasModel aliasModel = (OrderAliasModel) aliasModelArr[i];
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 获取XML内容转化后的所有排序别名对象数组
   * @return AliasModel[] 别名对象数组
   */
  public OrderAliasModel[] getOrderAliasModelListVOArrByXML(){
    OrderAliasModel[] _aliasModelArr = new OrderAliasModel[orderAliasModelList.size()];
    for (int i = 0; i < orderAliasModelList.size(); i++){
      OrderAliasModel aliasModel = (OrderAliasModel) orderAliasModelList.get(i);
      _aliasModelArr[i] = aliasModel;
    }
    return _aliasModelArr;
  }
  
  /**
   * 将获取到XML内容的排序别名对象数组设置到QueryModel模型中
   */
  public void setOrderAliasModelListVOArrByXML(){
    OrderAliasModel[] _aliasModelArr1 = getOrderAliasModelListVOArrByModel();
    OrderAliasModel[] _aliasModelArr2 = getOrderAliasModelListVOArrByXML();
    if (_aliasModelArr1.length != _aliasModelArr2.length)
      return;
    for (int i = 0; i < _aliasModelArr1.length; i++){
      _aliasModelArr1[i].setEnAlias(_aliasModelArr2[i].getEnAlias());
    }
  }
  
  /**
   * 获取SELECT子句下的字段或字段表达式信息
   * @return SelectListVO[] 字段或字段表达式对象数组
   */
  public SelectListVO[] getSelectListVOArr() {
    if (selectListVOArr.length == 0)
      selectListVOArr = getSelectListVOArrByModel();
    return selectListVOArr;
  }
  
  /**
   * 设置SELECT子句的字段或字段表达式信息
   * @param selectListVOArr 字段或字段表达式信息对象数组
   */
  public void setSelectListVOArr(SelectListVO[] selectListVOArr) {
    this.selectListVOArr = selectListVOArr;
  }
  
  /**
   * 获取FROM子句下的表名信息
   * @return FromListVO[] 表名信息对象数组
   */
  public FromListVO[] getFromListVOArr() {
    if (fromListVOArr.length == 0)
      fromListVOArr = getFromListVOArrByModel();
    return fromListVOArr;
  }
  
  /**
   * 设置FROM子句下的表名信息
   * @param fromListVOArr 表名信息对象数组
   */
  public void setFromListVOArr(FromListVO[] fromListVOArr) {
    this.fromListVOArr = fromListVOArr;
  }
  
  /**
   * 获取WHERE子句下的条件或条件表达式信息
   * @return WhereListVO[] 条件或条件表达式信息对象数组
   */
  public WhereListVO[] getWhereListVOArr() {
    if (whereListVOArr.length == 0)
      whereListVOArr = getWhereListVOArrByModel();
    return whereListVOArr;
  }
  
  /**
   * 设置WHERE子句下的条件或条件表达式信息
   * @param whereListVOArr 条件或条件表达式信息对象数组
   */
  public void setWhereListVOArr(WhereListVO[] whereListVOArr) {
    this.whereListVOArr = whereListVOArr;
  }
  
  /**
   * 获取WHERE子句下的分组字段或分组表达式信息
   * @return GroupByListVO[] 分组字段或分组表达式信息对象数组
   */
  public GroupByListVO[] getGroupByListVOArr() {
    if (groupByListVOArr.length == 0)
      groupByListVOArr = getGroupByListVOArrByModel();
    return groupByListVOArr;
  }
  
  /**
   * 设置WHERE子句下的分组字段或分组表达式信息
   * @param groupByListVOArr 分组字段或分组表达式信息对象数组
   */
  public void setGroupByListVOArr(GroupByListVO[] groupByListVOArr) {
    this.groupByListVOArr = groupByListVOArr;
  }
  
  /**
   * 获取ORDER BY子句下的排序字段或排序表达式信息
   * @return OrderByListVO[] 排序字段或排序表达式信息对象数组
   */
  public OrderByListVO[] getOrderByListVOArr() {
    if (orderByListVOArr.length == 0)
      orderByListVOArr = getOrderByListVOArrByModel();
    return orderByListVOArr;
  }
  
  /**
   * 设置ORDER BY子句下的排序字段或排序表达式信息
   * @param orderByListVOArr 排序字段或排序表达式信息对象数组
   */
  public void setOrderByListVOArr(OrderByListVO[] orderByListVOArr) {
    this.orderByListVOArr = orderByListVOArr;
  }
  
}
