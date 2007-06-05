package model.parser;

/**
 *	聚合函数模型对象 
 */
public class AggregateFuncModel extends FunctionModel {

	public static final int NO_FILTER = 0;

	public static final int ALL = 1;

	public static final int DISTINCT = 2;

	public AggregateFuncModel(String functionName, int filter) {

		super(functionName);

		setFilter(filter);

	}

	public AggregateFuncModel(String functionName, int filter, boolean isEn2Ch) {

		super(functionName, isEn2Ch);

		setFilter(filter);

	}
}
