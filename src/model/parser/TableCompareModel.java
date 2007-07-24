package model.parser;

import util.StringUtil;

/**
 * 表比较模型TableCompareModel<br>
 * 修改日志：<br>
 * ======================================================<br>
 * 07/24/2007：<br>
 * 	- 增加addTableListModel()方法，用来存储所有表单模型对象<br>
 * 		getChString()、getExecuteEnString()、getEmptyExecuteEnString()也做了相应修改<br>
 * <br>
 * ======================================================<br>
 */
public class TableCompareModel extends QueryModel {
  private int TABLE_NUMBER = 2;
  private static final String compareStr1 = "SELECT _FIELDS_";
  private static final String compareStr2 = " INTO _TABLE_NAME_";
  private static final String compareStr3 = " FROM _TABLE1_";
  private static final String compareStr4 = " WHERE _METHOD_ (SELECT * FROM _TABLE2_ WHERE _CONDITION_)";
  private String chTable1, chTable2, intoTable, method, equation;
  
  private String compareMethod;
 
  public String getCompareMethod() {
    String rValue = "";
    if (compareMethod.equals("存在")){
      rValue = "exists";
    }else if (compareMethod.equals("不存在")){
      rValue = "not exists";
    }else{
      rValue = compareMethod;
    }
    return rValue;
  }
  
  public String getChCompareMethod() {
    String rValue = "";
    if (compareMethod.equals("exists")){
      rValue = "存在";
    }else if (compareMethod.equals("not exists")){
      rValue = "不存在";
    }else{
      rValue = compareMethod;
    }
    return rValue;
  }
  
  public void setCompareMethod(String compareMethod) {
    this.compareMethod = compareMethod;
  }
  
  public void addTableModel1(TableModel tableModel){
    addChild(tableModel);
  }
  
  public void addTableModel2(TableModel tableModel){
    addChild(tableModel);
  }
  
  public void addTableListModel(TableListModel model){
  	addChild(model);
  }
  
  public void setSearchCondition(SearchConditionModel cond){
    addChild(cond);
  }
  
  public String getChString() {
    String ret = "表比较 ";
    QueryModel tableListModel = getFirstModelByClass(TableListModel.class);
    if (tableListModel != null){
	    QueryModel[] tableModelArr = tableListModel.getModelsFromAllChildrenByClass(TableModel.class);
	    SearchConditionModel cond = (SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
	    if (tableModelArr.length == TABLE_NUMBER){
	      TableModel tableModel1 = (TableModel) tableModelArr[0];
	      TableModel tableModel2 = (TableModel) tableModelArr[1];
	      ret += tableModel1.getChString();
	      ret += ", ";
	      ret += tableModel2.getChString();
	      ret += " 条件 ";
	      ret += getChCompareMethod();
	      ret += " " + cond.getChString();
	    }
    }
    return ret;
  }
  
  public String getEnString() {
    return getExecuteEnString("");
  }
  
  public String getExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel tableListModel = getFirstModelByClass(TableListModel.class);
    if (tableListModel != null){
	    QueryModel[] tableModelArr = tableListModel.getModelsFromAllChildrenByClass(TableModel.class);
	    SearchConditionModel cond = (SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
	    if (tableModelArr.length == TABLE_NUMBER){
	      DbTableModel _dbTableModel = getDbTableModel();
	      TableModel tableModel1 = (TableModel) tableModelArr[0];
	      TableModel tableModel2 = (TableModel) tableModelArr[1];
	      String enFieldStr = _dbTableModel.getFieldsEnStr(tableModel1.getChString());
	      if (intoTableName == null || intoTableName.equals("") || intoTableName.length() == 0){
	        rValue = StringUtil.replace(
	            (compareStr1 + compareStr3 + compareStr4),
	            new String[]{"_FIELDS_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
	            new String[]{enFieldStr, tableModel1.getEnString(), tableModel2.getEnString(), getCompareMethod(), cond.getEnString()}
	        );
	      }else{
	        rValue = StringUtil.replace(
	            (compareStr1 + compareStr2 + compareStr3 + compareStr4),
	            new String[]{"_FIELDS_", "_TABLE_NAME_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
	            new String[]{enFieldStr, intoTableName, tableModel1.getEnString(), tableModel2.getEnString(), getCompareMethod(), cond.getEnString()}
	        );
	      }
	    }
    }
    return rValue;
  }
  
  public String getEmptyExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel tableListModel = getFirstModelByClass(TableListModel.class);
    if (tableListModel != null){
	    QueryModel[] tableModelArr = tableListModel.getModelsFromAllChildrenByClass(TableModel.class);
	    SearchConditionModel cond = (SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
	    if (tableModelArr.length == TABLE_NUMBER){
	      DbTableModel _dbTableModel = getDbTableModel();
	      TableModel tableModel1 = (TableModel) tableModelArr[0];
	      TableModel tableModel2 = (TableModel) tableModelArr[1];
	      String enFieldStr = _dbTableModel.getFieldsEnStr(tableModel1.getChString());
	      rValue = StringUtil.replace(
	            (compareStr1 + compareStr2 + compareStr3),
	            new String[]{"_FIELDS_", "_TABLE_NAME_", "_TABLE1_", "_TABLE2_"},
	            new String[]{enFieldStr, intoTableName, tableModel1.getEnString(), tableModel2.getEnString()}
	        );
	      rValue += " WHERE 1 = 0";
	    }
    }
    return rValue;
  }
  
}
