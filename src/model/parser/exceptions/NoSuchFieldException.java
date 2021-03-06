package model.parser.exceptions;

import antlr.ANTLRException;

public class NoSuchFieldException extends ANTLRException {
  private static final long serialVersionUID = 774001169725414496L;
  private String tableChName;
  private String fieldChName;
  
  public NoSuchFieldException(String tableName, String fieldName) {
    this.tableChName=tableName;
    this.fieldChName=fieldName;
  }

  public String getFieldChName() {
    return fieldChName;
  }

  public void setFieldChName(String fieldChName) {
    this.fieldChName = fieldChName;
  }

  public String getTableChName() {
    return tableChName;
  }

  public void setTableChName(String tableChName) {
    this.tableChName = tableChName;
  }
}
