package model.parser;

public class SelectListModel extends QueryModel {
  public boolean distinct;
  
  public void setDistinct(boolean distinct) {
    this.distinct=distinct;
  }
  
  public void addColumn(ColumnModel model) {
    addChild(model);
  }
  public String getChString() {
    String ret="";
    if (distinct)
      ret="Ψһ ";

    ret+=getChString(", ");
    return ret;
  }

  public String getEnString() {
    String ret="";
    if (distinct)
      ret="distinct ";

    ret+=getEnString(", ");
    return ret;
  }
}
