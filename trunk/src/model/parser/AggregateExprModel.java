package model.parser;

public class AggregateExprModel extends QueryModel {
  public void addField(FieldModel model) {
    addChild(model);
  }
  public void addFunction(FunctionModel model) {
    addChild(model);
  }
}
