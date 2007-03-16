package translator.model;

import antlr.ANTLRException;

public class NoSuchDbTableException extends ANTLRException {
  private static final long serialVersionUID = -8685428243117899089L;
  private String tableName;
  public NoSuchDbTableException(String tableName) {
    this.tableName=tableName;
  }
  public String toString() {
    return "No such table:"+tableName;
  }
  public String getTableName() {
    return tableName;
  }
}
