package translator.model;

public class EquationModel extends QueryModel {

  private String equation;
  public EquationModel(String equation) {
    this.equation=equation;
  }

  public String getEnQuery() {
    return translateFieldCh2En(equation);
  }

}
