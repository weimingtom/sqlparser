package model.parser;

public class OrderExpressionListModel extends QueryModel {
  public void addOrderExpression(OrderExpressionModel model) {
    addChild(model);
  }
  public String getChString() {
    return super.getChString(", ");
  }
  
  public String getEnString() {
    return super.getEnString(", ");
  }
}
