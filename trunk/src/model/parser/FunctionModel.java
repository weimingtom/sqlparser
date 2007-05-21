package model.parser;

public class FunctionModel extends QueryModel {
  public static final int ALL = 1;
  public static final int DISTINCT = 2;

  private String functionName;
  private int filter;

  public FunctionModel(String functionName) {
    this.functionName = functionName;
  }

  public void setParameters(ParametersModel model) {
    addChild(model);
  }

  protected void setFilter(int filter) {
    this.filter = filter;
  }

  public String getChString() {
  	String rValue = "";
    String f = "";
    if (filter == ALL)
      f = "È«²¿ ";
    else if (filter == DISTINCT)
      f = "Î¨Ò» ";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    if (para != null)
    	rValue = functionName + "(" + f + para.getChString() + ")";
    else
    	rValue = functionName + "(" + ")";
    return rValue;
  }
  
  public String getEnString() {
  	String rValue = "";
    String f = "";
    if (filter == ALL)
      f = "all ";
    else if (filter == DISTINCT)
      f = "distinct ";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    if (para != null)
    	rValue = translateStringCh2En(functionName) + "(" + f + para.getEnString() + ")";
    else
    	rValue = translateStringCh2En(functionName) + "(" + f + ")";
    return rValue;
  }
}
