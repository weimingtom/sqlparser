package model.parser;

import util.StringUtil;

public class TableUnionModel extends QueryModel {
  private int TABLE_NUMBER = 2;
  private static final String unionStr1 = "INSERT INTO _INTO_TABLE_NAME_ (_FIELDS1_) ";
  private static final String unionStr2 = "SELECT _FIELDS1_ FROM _TABLE1_" +
                                          " UNION ALL " +
                                          "SELECT _FIELDS2_ FROM _TABLE2_";
  private static final String unionStr3 = "SELECT _FIELDS1_ INTO _INTO_TABLE_NAME_ FROM _TABLE1_ WHERE 1 = 0";
  
  public void addTableModel1(TableModel tableModel){
    addChild(tableModel);
  }
  
  public void addTableModel2(TableModel tableModel){
    addChild(tableModel);
  }
  
  public String getChString() {
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    String ret = "±íºÏ²¢ ";
    for (int i = 0; i < tableModelArr.length; i++){
      ret += ((TableModel) tableModelArr[i]).getTableName();
      if (i < tableModelArr.length - 1)
        ret += ", ";
    }
    return ret;
  }
  
  public String getEnString() {
    return getExecuteEnString("");
  }
  
  public String getExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    if (tableModelArr.length == TABLE_NUMBER){
      DbTableModel _dbTableModel = getDbTableModel();
      TableModel tableModel1 = (TableModel) tableModelArr[0];
      TableModel tableModel2 = (TableModel) tableModelArr[1];
      String enFieldStr1 = _dbTableModel.getFieldsEnStr(tableModel1.getChString());
      String enFieldStr2 = _dbTableModel.getFieldsEnStr(tableModel2.getChString());
      if (intoTableName == null || intoTableName.equals("") || intoTableName.length() == 0){
        rValue = StringUtil.replace(unionStr2,
            new String[]{"_FIELDS1_", "_FIELDS2_", "_TABLE1_", "_TABLE2_"},
            new String[]{enFieldStr1, enFieldStr2, tableModel1.getEnString(), tableModel2.getEnString()}
          );
      }else{
        rValue = StringUtil.replace(unionStr1 + unionStr2,
            new String[]{"_INTO_TABLE_NAME_", "_FIELDS1_", "_FIELDS2_", "_TABLE1_", "_TABLE2_"},
            new String[]{intoTableName, enFieldStr1, enFieldStr2, tableModel1.getEnString(), tableModel2.getEnString()}
          );
      }
    }
    return rValue;
  }
  
  public String getEmptyExecuteEnString(String intoTableName) {
    String rValue = "";
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    if (tableModelArr.length == TABLE_NUMBER){
      DbTableModel _dbTableModel = getDbTableModel();
      TableModel tableModel1 = (TableModel) tableModelArr[0];
      String enFieldStr1 = _dbTableModel.getFieldsEnStr(tableModel1.getChString());
      rValue = StringUtil.replace(unionStr3,
          new String[]{"_FIELDS1_", "_TABLE1_", "_INTO_TABLE_NAME_"},
          new String[]{enFieldStr1, tableModel1.getEnString(), intoTableName}
        );
    }
    return rValue;
  }
}
