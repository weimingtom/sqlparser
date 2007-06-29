package model.parser;

/**
 * 编译器单个表达式模型对象类
 * Recent updates by LORD
 * email: jiandeh@sina.com
 * 修改日志：
 * ======================================================
 * 06/12/2007:
 * 	- 增加addSelectStatement方法，用来存储in/not in子查询内容
 * 06/29/2007:
 * 	- 增加addConstant(String c, boolean isContant)方法
 * 		用isContant判断是否为常量，false时为系统关键字用到(rownum)
 * ======================================================
 */
public class ExpressionModel extends QueryModel {
  private boolean hasConstant = false;
  private boolean hasTable = false;
  
  /**
   * 增加常量模型对象
   * @param c 字符串或数字
   */
  public void addConstant(String c) {
    hasConstant = true;
    addChild(new StringModel(c));
  }
  
  /**
   * 增加常量模型对象
   * @param c	字符串或数字或关键字
   * @param isContant 是否为常量
   */
  public void addConstant(String c, boolean isContant) {
    hasConstant = isContant;
    addChild(new StringModel(c));
  }

  public boolean hasConstant() {
    return hasConstant;
  }
  
  public boolean isHasTable() {
		return hasTable;
	}

	public void addTable(TableModel model){
  	hasTable = true;
  	addChild(model);
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
