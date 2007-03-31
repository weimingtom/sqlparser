package model.parser;

import util.StringUtil;

public class TableUnionModel extends QueryModel {
  private int TABLE_NUMBER = 2;
  private static final String unionStr1 = "INSERT INTO _INTO_TABLE_NAME_ (_FIELDS_) ";
  private static final String unionStr2 = "SELECT _FIELDS_ FROM _TABLE1_ UNION ALL " +
                                          "SELECT _FIELDS_ FROM _TABLE2_";
  
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
    String rValue = "";
    QueryModel[] tableModelArr = getModelsFromAllChildrenByClass(TableModel.class);
    if (tableModelArr.length == TABLE_NUMBER){
      DbTableModel _dbTableModel = getDbTableModel();
      TableModel tableModel1 = (TableModel) tableModelArr[0];
      TableModel tableModel2 = (TableModel) tableModelArr[1];
      String enFieldStr = _dbTableModel.getFieldsEnStr(tableModel1.getChString());
      
      rValue = StringUtil.replace(unionStr2,
          new String[]{"_FIELDS_", "_TABLE1_", "_TABLE2_"},
          new String[]{enFieldStr, tableModel1.getEnString(), tableModel2.getEnString()}
        );
    }
    return rValue;
  }
  
  
}
