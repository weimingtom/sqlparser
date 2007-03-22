package translator.model;

public class DbFieldAlias {
  private String columnEquElem; //字段表达式
  private String cnFieldAlias;  //中文别名
  private String enFieldAlias;  //英文别名
  public String getCnFieldAlias() {
    return cnFieldAlias;
  }
  public void setCnFieldAlias(String cnFieldAlias) {
    this.cnFieldAlias = cnFieldAlias;
  }
  public String getColumnEquElem() {
    return columnEquElem;
  }
  public void setColumnEquElem(String columnEquElem) {
    this.columnEquElem = columnEquElem;
  }
  public String getEnFieldAlias() {
    return enFieldAlias;
  }
  public void setEnFieldAlias(String enFieldAlias) {
    this.enFieldAlias = enFieldAlias;
  }
  
  
}
