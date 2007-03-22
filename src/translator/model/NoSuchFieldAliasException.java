package translator.model;

import antlr.ANTLRException;

public class NoSuchFieldAliasException extends ANTLRException {
  private String fieldChAliasName;
  
  public NoSuchFieldAliasException(String fieldChAliasName) {
    this.fieldChAliasName = fieldChAliasName;
  }

  public String getFieldChAliasName() {
    return fieldChAliasName;
  }

  public void setFieldChAliasName(String fieldChAliasName) {
    this.fieldChAliasName = fieldChAliasName;
  }

  
}
