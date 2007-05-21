package model.parser;

import antlr.ANTLRException;

/**
 * SELECT子句中非聚合函数表达式
 * 没有在GROUP BY子句中出现异常
 */
public class NoGroupExistsException extends ANTLRException {
	private String selectExpr;

	public NoGroupExistsException(String selectExpr) {
		this.selectExpr = selectExpr;
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

}
