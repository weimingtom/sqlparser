package model.parser;

/**
 * 编译器单个表达式模型对象类
 * Recent updates by LORD
 * email: jiandeh@sina.com
 * 修改日志：
 * ======================================================
 * 06/12/2007:
 * 	- 增加addSelectStatement方法，用来存储in/not in子查询内容
 * 		
 * ======================================================
 */
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
  
  public void addSelectStatement(SelectStatementModel stmt){
  	addChild(stmt);
  }
  
  public String getChString() {
    return getChString(" ");
  }

  public String getEnString() {
    return getEnString(" ");
  }
}
