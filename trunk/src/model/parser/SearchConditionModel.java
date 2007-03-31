package model.parser;

public class SearchConditionModel extends QueryModel {
  public void addEquation(EquationModel equ) {
    addChild(equ);
  }
  
}
