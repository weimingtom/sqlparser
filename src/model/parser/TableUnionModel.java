package model.parser;

import util.StringUtil;

public class TableUnionModel extends QueryModel {
	private static final String UNION_CN_NAME = "表合并 ";
  private static final String unionStr = "SELECT _FIELDS_ FROM _FROM_TABLE_NAME_";
  private static final String unionAll = " UNION ALL ";
  private static final String unionIntoStr = "INSERT INTO _INTO_TABLE_NAME_ (_FIELDS_) ";
  private static final String unionEmptyStr = "SELECT _FIELDS_ INTO _INTO_TABLE_NAME_ FROM _FROM_TABLE_NAME_ WHERE 1 = 0";
  
  /**
   * 增加表模型对象列表
   * @param tableListModel
   */
  public void addTableListModel(TableListModel tableListModel){
  	addChild(tableListModel);
  }
  
  /**
   * 获取格式化后的中文SQL语句
   */
  public String getChString() {
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    
    String ret = UNION_CN_NAME;
    for (int i = 0; i < tableModelArr.length; i++){
      ret += ((TableModel) tableModelArr[i]).getTableName();
      if (i < tableModelArr.length - 1)
        ret += ", ";
    }
    return ret;
  }
  
  /**
   * 获取标准的英文SQL语句
   */
  public String getEnString() {
    return getExecuteEnString("");
  }
  
  /**
   * 获取可执行的英文SQL语句（如果要插入的表名不为空，则可进行插入记录操作）
   * @param intoTableName 要插入的表名
   * @return String 可执行的英文SQL语句
   */
  public String getExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    for (int i = 0; i < tableModelArr.length; i++){
      DbTableModel _dbTableModel = getDbTableModel();
      TableModel tableModel = (TableModel) tableModelArr[i];
      String enFieldStr = _dbTableModel.getFieldsEnStr(tableModel.getChString());
      if (intoTableName == null || intoTableName.equals("") || intoTableName.length() == 0){
      	//如果合并的表名为第二张及之后，则需增加"UNION ALL"
      	if (i > 0)
      		rValue += unionAll;
      	
      	//将SQL语句替换成当前的表名/字段名
        rValue += StringUtil.replace(unionStr,
        		new String[]{"_FIELDS_", "_FROM_TABLE_NAME_"},
        		new String[]{enFieldStr, tableModel.getEnString()}
        	);
      }else{
      	//获取要插入的临时表英文SQL语句
      	if (i == 0){
      		rValue = StringUtil.replace(unionIntoStr,
      				new String[]{"_INTO_TABLE_NAME_", "_FIELDS_"},
      				new String[]{intoTableName, enFieldStr}
      			);
      	}
      	
      	//如果合并的表名为第二张及之后，则需增加"UNION ALL"
      	if (i > 0)
      		rValue += unionAll;
      	
      	//将SQL语句替换成当前的表名/字段名
        rValue += StringUtil.replace(unionStr,
        		new String[]{"_FIELDS_", "_FROM_TABLE_NAME_"},
        		new String[]{enFieldStr, tableModel.getEnString()}
        	);
        
      }
    }
    return rValue;
  }
  
  /**
   * 获取空的可执行的英文SQL语句（通过此方法可进行表结构的创建）
   * @param intoTableName 要创建的表名
   * @return String 空的可执行的英文SQL语句
   */
  public String getEmptyExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    if (tableModelArr.length > 0){
    	DbTableModel _dbTableModel = getDbTableModel();
    	TableModel tableModel = (TableModel) tableModelArr[0];
    	String enFieldStr = _dbTableModel.getFieldsEnStr(tableModel.getChString());
    	rValue = StringUtil.replace(unionEmptyStr,
          new String[]{"_FIELDS_", "_FROM_TABLE_NAME_", "_INTO_TABLE_NAME_"},
          new String[]{enFieldStr, tableModel.getEnString(), intoTableName}
        );
    	
    }
    return rValue;
  }
}
