package model.parser;

public class OrderAliasModel extends QueryModel {
  private String alias;
  private String enAlias;
  
  public OrderAliasModel(String alias) {
    this.alias=alias;
  }
  
  public String getAlias() {
    return alias;
  }
  
  public String getEnAlias() {
    return enAlias;
  }

  public void setEnAlias(String enAlias) {
    this.enAlias = enAlias;
  }

  public String getChString() {
    return alias;
  }
  
  public String getEnString() {
    if (enAlias != null && !enAlias.equals(""))
      return enAlias;
    else
      return alias;
  }
}
