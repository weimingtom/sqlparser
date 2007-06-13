package model.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.parser.common.Constants;

/**
 * 编译器函数模型对象类
 * Recent updates by LORD
 * email: jiandeh@sina.com
 * 修改日志：
 * ======================================================
 * 06/11/2007:
 * 	- 增加isNothing属性，用来判断是否为不带任何东西的函数
 * 	- 修改了相应getChString、getEnString方法	
 * 06/13/2007:
 * 	- 修改FunctionModel方法对含中英文混合关键字的转化，
 *    如：求ASCII码，当含有任何一个中文时返回原传入函数名
 * ======================================================
 */
public class FunctionModel extends QueryModel {
  public static final int ALL = 1;
  public static final int DISTINCT = 2;
  
  private String functionName;
  private boolean isNothing = false;
  private int filter;

  public FunctionModel(String functionName) {
    this.functionName = functionName;
  }
  
  public FunctionModel(String functionName, boolean isEn2Ch) {
  	String rValue = functionName.toLowerCase();
  	if (isEn2Ch){
  		int chCount = 0;
			String regEx = "[\\u4e00-\\u9fa5]";
			Pattern _pattern = Pattern.compile(regEx);
			Matcher _matcher = _pattern.matcher(rValue);
			while (_matcher.find()) {
				for (int i = 0; i <= _matcher.groupCount(); i++) {
					chCount++;	//如果存在中文则计数器加1
					break;
				}
				
				if (chCount > 0){
					break;
				}
			}
			if (chCount == 0)	//如果为英文函数名，则转成中文函数名
				rValue = QueryModel.translateStringEn2Ch(rValue);
			else	//当含有任何一个中文时返回原传入函数名
				rValue = functionName;
  	}
    this.functionName = rValue;
  }
  
  public void setParameters(ParametersModel model) {
    addChild(model);
  }

  protected void setFilter(int filter) {
    this.filter = filter;
  }
  
  public void setNothing(boolean isNothing) {
		this.isNothing = isNothing;
	}

	public String getChString() {
  	String rValue = "";
    String f = "";
    if (filter == ALL)
      f = Constants.ALL_CN + " ";
    else if (filter == DISTINCT)
      f = Constants.DISTINCT_CN + " ";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    if (para != null)
    	rValue = functionName + "(" + f + para.getChString() + ")";
    else if (isNothing)
    	rValue = functionName;
    else
    	rValue = functionName + "(" + ")";
    return rValue;
  }
  
  public String getEnString() {
  	String rValue = "";
    String f = "";
    if (filter == ALL)
      f = Constants.ALL_EN + " ";
    else if (filter == DISTINCT)
      f = Constants.DISTINCT_EN + " ";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    if (para != null)
    	rValue = translateStringCh2En(functionName) + "(" + f + para.getEnString() + ")";
    else if (isNothing)
    	rValue = translateStringCh2En(functionName);
    else
    	rValue = translateStringCh2En(functionName) + "(" + f + ")";
    return rValue;
  }
}
