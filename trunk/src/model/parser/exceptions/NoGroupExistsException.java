package model.parser.exceptions;

import antlr.ANTLRException;

/**
 * SELECT子句中非聚合函数表达式
 * 没有在GROUP BY子句中出现异常
 */
public class NoGroupExistsException extends ANTLRException {
	public static final String EXPR_NOT_EXISTS_ERROR = "1";	//非聚合函数表达式没有在分组中出现错误
	public static final String EXPR_EXISTS_ERROR = "2";			//聚合函数在分组中出现错误

	private String selectExpr;	//select子句的字段表达式
	private String exType;			//exception类型
	
	public NoGroupExistsException(String selectExpr) {
		this.selectExpr = selectExpr;
		this.exType = EXPR_NOT_EXISTS_ERROR;
	}
	
	public NoGroupExistsException(String selectExpr, String exType) {
		this.selectExpr = selectExpr;
		this.exType = exType;
	}
	
	public String toString() {
		return "错误输入：[查询]子句 \"" + selectExpr + "\" 必须在[分组]子句中出现。";
	}

	public String getSelectExpr() {
		return selectExpr;
	}

	public void setSelectExpr(String selectExpr) {
		this.selectExpr = selectExpr;
	}

	public String getExType() {
		return exType;
	}

	public void setExType(String exType) {
		this.exType = exType;
	}
	
}
