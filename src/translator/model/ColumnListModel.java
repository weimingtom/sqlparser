package translator.model;

public class ColumnListModel extends QueryModel {
  private String columnList;
  public ColumnListModel(String columnList) {
    this.columnList=columnList;
  }
  public String getEnQuery() {
    return translateField(columnList);
  }

}
