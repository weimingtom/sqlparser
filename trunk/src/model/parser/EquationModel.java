package model.parser;

public class EquationModel extends QueryModel {
  public void addExpression(ExpressionModel exp) {
    addChild(exp);
  }
  
  public String getChString() {
    return super.getChString(" ");
  }
  
  public String getEnString() {
    QueryModel[] exprs=getModelByClass(ExpressionModel.class);
    if (exprs.length==3)
      return exprs[0].getEnQuery() + " between " + 
        exprs[1].getEnQuery() + " and " + exprs[2].getEnQuery();
    return super.getEnString(" ");
  }
}
