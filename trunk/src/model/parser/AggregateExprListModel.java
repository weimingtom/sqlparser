package model.parser;

public class AggregateExprListModel extends QueryModel {
  public void addAggregateExpression(AggregateExprModel model) {
    addChild(model);
  }
  
  public String getChString() {
    return getChString(", ");
  }

  public String getEnString() {
    return getEnString(", ");
  }
}
