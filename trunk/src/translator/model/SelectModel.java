package translator.model;

public class SelectModel extends QueryModel {
  private static final String selectStr=
    "SELECT _COLUMN_LIST_ FROM _TABLE_LIST_ WHERE _EQUATION_";
  private String columnList, tableList, equation;
  public SelectModel(String columnList, String tableList, String equation) {
    this.columnList=columnList;
    this.tableList=tableList;
    this.equation=equation;
  }
  
  public String getEnQuery() {
    String clist=translateField(columnList);
    String tlist=translateTable(tableList);
    String equ=translateField(equation);
    return replace(
        selectStr,
        new String[]{"_COLUMN_LIST_", "_TABLE_LIST_", "_EQUATION_"},
        new String[]{clist, tlist, equ});
//    return selectStr.replaceAll("_COLUMN_LIST_", clist)
//      .replaceAll("_TABLE_LIST_", tlist)
//      .replaceAll("_EQUATION_", equ);
  }

  public String toString() {
    return replace(
        selectStr,
        new String[]{"_COLUMN_LIST_", "_TABLE_LIST_", "_EQUATION_"},
        new String[]{columnList, tableList, equation});
//    return selectStr.replaceAll("_COLUMN_LIST_", columnList)
//      .replaceAll("_TABLE_LIST_", tableList)
//      .replaceAll("_EQUATION_", equation);
  }
}
