package model.parser;

public class ParamModel extends QueryModel {
  private static final String CIRCLE_TYPE_TABLE = "1"; //表变量循环
  private static final String CIRCLE_TYPE_WHERE = "2"; //条件变量循环
  
  private String paramLparen;
  private String paramRparen;
  private String paramName;
  private String paramEnName;
  private String paramValue;
  
  public ParamModel(String paramName, String paramLparen, String paramRparen){
    setParamName(paramName.substring(1, paramName.length() - 1));
    setParamLparen(paramLparen);
    setParamRparen(paramRparen);
    setCircleType(CIRCLE_TYPE_WHERE);
  }
  
  public void setCircleType(String circleType) {
    super.setCircleType(circleType);
  }
  
  public String getParamLparen() {
    return paramLparen;
  }
  public void setParamLparen(String paramLparen) {
    this.paramLparen = paramLparen;
  }
  
  public String getParamName() {
    return paramName;
  }
  public void setParamName(String paramName) {
    this.paramName = paramName;
  }
  
  public String getParamEnName() {
    return paramEnName;
  }

  public void setParamEnName(String paramEnName) {
    this.paramEnName = paramEnName;
  }

  public String getParamRparen() {
    return paramRparen;
  }
  
  public void setParamRparen(String paramRparen) {
    this.paramRparen = paramRparen;
  }
  
  public String getParamValue() {
    return paramValue;
  }
  
  public void setParamValue(String paramValue) {
    this.paramValue = paramValue;
  }
  
  public String getChString() {
    return getParamLparen() + getParamName() + getParamRparen();
  }
  
  public String getEnString() {
    if (getParamValue() == null || getParamValue().equals("")){
      if (getParamEnName() == null || getParamEnName().equals(""))
        return getParamLparen() + getParamName() + getParamRparen();
      else
        return getParamLparen() + getParamEnName() + getParamRparen();
    }else{
      return getParamValue();
    }
  }
}
