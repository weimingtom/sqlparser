package model.parser;

public class OrderExpressionModel extends QueryModel {
  public static final int ASC=1;
  public static final int DESC=2;
  private int sort;
  
  public void addField(FieldModel model) {
    addChild(model);
  }
  
  public void addOrderAlias(OrderAliasModel model){
    addChild(model);
  }
  
  public void addFunction(FunctionModel model) {
    addChild(model);
  }
  
  public void setSort(int sort) {
    this.sort=sort;
  }
  
  public String getChSort() {
    String s = "";
    if (sort == DESC)
      s = "½µÐò";
    else
      s = "ÉýÐò";
    return s;
  }
  
  public String getChString() {
    String s="";
    if (sort==ASC)
      s=" ÉýÐò";
    else if (sort==DESC)
      s=" ½µÐò";
    return super.getChString()+s;
  }

  public String getEnString() {
    String s="";
    if (sort==ASC)
      s=" asc";
    else if (sort==DESC)
      s=" desc";
    return super.getEnString()+s;
  }
}
