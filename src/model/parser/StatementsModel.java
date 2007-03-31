package model.parser;

public class StatementsModel extends QueryModel {
  public void addStatement(QueryModel model) {
    addChild(model);
  }
}
