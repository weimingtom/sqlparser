package model.parser.exceptions;

import antlr.ANTLRException;

public class NoSuchTableException extends ANTLRException {
  private static final long serialVersionUID = -8685428243117899089L;
  private String tableName;
  public NoSuchTableException(String tableName) {
    this.tableName=tableName;
  }
  public String toString() {
    return "No such table:"+tableName;
  }
  public String getTableName() {
    return tableName;
  }
}
