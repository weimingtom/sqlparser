package model.parser;

public class ParametersModel extends QueryModel {
  public void addParameter(ExpressionModel e) {
    addChild(e);
  }
  
  public String getChString() {
    return getChString(", ");
  }
  
  public String getEnString() {
    return getEnString(", ");
  }
}
