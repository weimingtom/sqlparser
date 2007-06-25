package model.parser;

public class TableModel extends QueryModel {
  private String tableName;
  private boolean isRowid = false;
  private String tableEnName;

  public TableModel(String tableName){
    this.tableName = tableName;
  }
  
  public TableModel(String tableName, boolean isRowid){
    this.tableName = tableName;
    this.isRowid = isRowid;
  }
  
  public String getTableName() {
    return tableName;
  }

  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
  
  public String getSTableEnName() {
  	return tableEnName;
  }
  
  public String getTableEnName() {
  	if (tableEnName == null || tableEnName.equals(""))
  		return tableName;
  	else
  		return tableEnName;
  }
  
  public boolean isRowid() {
		return isRowid;
	}

	public String getAlias() {
    AliasModel alias = (AliasModel) getFirstModelByClass(AliasModel.class);
    if (alias != null)
      return alias.getAlias();
    return "";
  }

  public void setAlias(AliasModel alias) {
    addChild(alias);
  }

  public void setAlias(TableAliasModel alias) {
    addChild(alias);
  }

  public void setTableEnName(String tableEnName) {
    this.tableEnName = tableEnName;
  }

  public String getChString() {
    String ret = tableName;
    // QueryModel alias=getFirstModelByClass(AliasModel.class);
    QueryModel alias = getFirstModelByClass(TableAliasModel.class);
    if (alias != null)
      ret += alias.getChString();
    return ret;
  }
  
  public String getEnString() {
    String ret = getTableEnName();
    // QueryModel alias=getFirstModelByClass(AliasModel.class);
    QueryModel alias = getFirstModelByClass(TableAliasModel.class);
    if (alias != null)
      ret += alias.getEnString();
    return ret;
  }

  public String toString() {
    return tableName;
  }
}
