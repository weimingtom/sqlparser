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

  public void setFilter(int filter) {
    this.filter = filter;
  }

  public String getChString() {
    String f = "";
    if (filter == ALL)
      f = "ËùÓÐ";
    else if (filter == DISTINCT)
      f = "Î¨Ò»";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    return functionName + "(" + f + para.getChString() + ")";
  }
  
  public String getEnString() {
    String f = "";
    if (filter == ALL)
      f = "all ";
    else if (filter == DISTINCT)
      f = "distinct ";
    ParametersModel para=(ParametersModel)getFirstModelByClass(ParametersModel.class);
    return translateStringCh2En(functionName)+"("+f+para.getEnString()+")";
  }
}
