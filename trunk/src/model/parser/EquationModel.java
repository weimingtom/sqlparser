package model.parser;

/**
 * 编译器WHERE子句单个条件表达式模型对象类
 * Recent updates by LORD
 * email: jiandeh@sina.com
 * 修改日志：
 * ======================================================
 * 06/11/2007:
 * 	- 增加addSelectStatement方法，用来存储exists/not exists
 * 		的子查询内容
 * ======================================================
 */
public class EquationModel extends QueryModel {
  public void addExpression(ExpressionModel exp) {
    addChild(exp);
  }
  
  public void addSelectStatement(SelectStatementModel stmt){
  	addChild(stmt);
  }
  
	public String getChString() {
		return super.getChString(" ");
  }
  
  public String getEnString() {
    String rValue = "";
    QueryModel[] exprs = getModelByClass(ExpressionModel.class);
    if (exprs.length == 3){
      rValue = exprs[0].getEnQuery() + " between " + 
        exprs[1].getEnQuery() + " and " + exprs[2].getEnQuery();
    }else{
      rValue = super.getEnString(" ");
    }
    return rValue;
  }
}
