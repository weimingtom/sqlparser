package model.parser;

public class TableListModel extends QueryModel {
  public void addTable(TableModel model) {
    addChild(model);
  }
  public String getChString() {
    return super.getChString(", ");
  }
  public String getEnString() {
    return super.getEnString(", ");
  }

}
