package model.parser;

public class ColumnModel extends QueryModel {
  public void addExpression(ExpressionModel model) {
    addChild(model);
  }
  
  public void addAlias(AliasModel model) {
    addChild(model);
  }
  
  public String getChString() {
    ExpressionModel exp=(ExpressionModel)getFirstModelByClass(ExpressionModel.class);
    AliasModel alias=(AliasModel)getFirstModelByClass(AliasModel.class);
    //return exp.getChString()+((alias==null)?"":alias.getChString())+" ";
    return exp.getChString()+((alias==null)?"":alias.getChString());
  }

  public String getEnString() {
    ExpressionModel exp=(ExpressionModel)getFirstModelByClass(ExpressionModel.class);
    AliasModel alias=(AliasModel)getFirstModelByClass(AliasModel.class);
    //return exp.getEnString()+((alias==null)?"":alias.getEnString())+" ";
    return exp.getEnString()+((alias==null)?"":alias.getEnString());
  }
}
