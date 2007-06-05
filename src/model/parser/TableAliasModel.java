package model.parser;

import model.parser.common.Constants;

/**
 * 表名别名模型对象
 */
public class TableAliasModel extends QueryModel {
  private String alias;
  private String enAlias;
  
  public TableAliasModel(String alias) {
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
    return " " + Constants.AS_CN + " " + alias;
  }
  
  public String getEnString() {
    if (enAlias != null && !enAlias.equals(""))
      return " " + Constants.AS_EN + " " + enAlias;
    else
      return " " + Constants.AS_EN + " " + alias;
  }
}
