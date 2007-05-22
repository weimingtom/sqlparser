package model.parser.exceptions;

import antlr.ANTLRException;

public class TableNotInFromClause extends ANTLRException {
  private static final long serialVersionUID = -7440502723389485432L;
  private String tableName;
  public TableNotInFromClause(String tableName) {
    this.tableName=tableName;
  }
  public String getTableName() {
    return tableName;
  }
  
}
