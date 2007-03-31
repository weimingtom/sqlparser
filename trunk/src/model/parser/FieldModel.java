package model.parser;

public class FieldModel extends QueryModel {
  private String fieldName;
  private String tableName;
  private String fieldEnName;
  private String tableEnName;
  
  public FieldModel(String fieldName) {
    this.fieldName=fieldName;
  }
  
  public FieldModel(String fieldName, String tableName) {
    this.fieldName=fieldName;
    this.tableName=tableName;
  }
  
  public String getTableName() {
    return tableName;
  }
  
  public String getFieldName() {
    return fieldName;
  }
  
  public void setFieldEnName(String fieldEnName) {
    this.fieldEnName=fieldEnName;
  }
  
  public void setTableEnName(String tableEnName) {
    this.tableEnName=tableEnName;
  }
  
  public String getChString() {
    String ret=fieldName;
    if (tableName!=null)
      ret=tableName+"."+ret;
    return ret;
  }
  
  public String getEnString() {
    String ret=fieldEnName;
    if (tableEnName!=null && tableEnName.length()>0)
      ret=tableEnName+"."+ret;
    return ret;
  }
  
  public String toString() {
    return tableName+"."+fieldName;
  }
}
