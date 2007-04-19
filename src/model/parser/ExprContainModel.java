package model.parser;

public class ExprContainModel extends QueryModel {
  private boolean hasConstant = false;
  
  public void addChild(ExprContainModel model){
    super.addChild(model);
  }
  
  public void addConstant(String c) {
    hasConstant = true;
    addChild(new StringModel(c));
  }

  public boolean hasConstant() {
    return hasConstant;
  }
  
  public String getChString() {
    return "(" + getChString(", ") + ")";
  }
  
  public String getEnString() {
    return "(" + getEnString(", ") + ")";
  }
}
