package model.parser;

public class AggregateExprModel extends QueryModel {
  public void addField(FieldModel model) {
    addChild(model);
  }
  public void addFunction(FunctionModel model) {
    addChild(model);
  }
  public void addConstant(String c) {
    addChild(new StringModel(c));
  }
}
