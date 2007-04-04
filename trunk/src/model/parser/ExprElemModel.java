package model.parser;

public class ExprElemModel{
  private String elemName;
  private boolean isConstant;
  private String elemValue;
  
  public ExprElemModel(String elemName, boolean isConstant){
    setElemName(elemName);
    setConstant(isConstant);
  }
  
  public String getElemName() {
    return elemName;
  }
  public void setElemName(String elemName) {
    this.elemName = elemName;
  }
  public String getElemValue() {
    return elemValue;
  }
  public void setElemValue(String elemValue) {
    this.elemValue = elemValue;
  }
  public boolean isConstant() {
    return isConstant;
  }
  public void setConstant(boolean isConstant) {
    this.isConstant = isConstant;
  }
}
