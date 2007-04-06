package model.parser;

public class ExpressionModel extends QueryModel {
  private boolean hasConstant = false;

  public void addConstant(String c) {
    hasConstant = true;
    addChild(new StringModel(c));
  }

  public boolean hasConstant() {
    return hasConstant;
  }

  public void addParam(ParamModel model) {
    addChild(model);
  }

  public void addField(FieldModel model) {
    addChild(model);
  }

  public void addFunction(FunctionModel model) {
    addChild(model);
  }

  public void addExprContainModel(ExprContainModel model){
    addChild(model);
  }
  
  public String getChString() {
    return getChString(" ");
  }

  public String getEnString() {
    return getEnString(" ");
  }
}
