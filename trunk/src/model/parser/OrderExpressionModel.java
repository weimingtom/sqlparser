package model.parser;

import model.parser.common.Constants;

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
      s = Constants.DESC_CN;
    else
      s = Constants.ASC_CN;
    return s;
  }
  
  public String getChString() {
    String s="";
    if (sort == ASC)
      s= " " + Constants.ASC_CN;
    else if (sort == DESC)
      s= " " + Constants.DESC_CN;
    return super.getChString()+s;
  }

  public String getEnString() {
    String s="";
    if (sort == ASC)
      s= " " + Constants.ASC_EN;
    else if (sort == DESC)
      s= " " + Constants.DESC_EN;
    return super.getEnString()+s;
  }
}
