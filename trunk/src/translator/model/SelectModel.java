package translator.model;

public class SelectModel extends QueryModel {
  private static final String selectStr=
    "SELECT _COLUMN_LIST_ FROM _TABLE_LIST_ WHERE _EQUATION_";
  private String columnList, tableList, equation, orderBy, groupBy;
  private SelectModel unionSelect;
  
  public SelectModel(String columnList, String tableList, String equation,String op1, String op2, SelectModel unionSelect) {
    this.columnList=columnList;
    this.tableList=tableList;
    this.equation=equation;
    if (op1!=null && op1.startsWith(" GROUP BY "))
      this.groupBy=replace(op1, " GROUP BY ", "");
    if (op1!=null && op1.startsWith(" ORDER BY "))
      this.orderBy=replace(op1, " ORDER BY ", "");
    if (op2!=null && op2.startsWith(" GROUP BY "))
      this.groupBy=replace(op2, " GROUP BY ", "");
    if (op2!=null && op2.startsWith(" ORDER BY "))
      this.orderBy=replace(op2, " ORDER BY ", "");
    this.unionSelect=unionSelect;
  }
  
  public String getEnQuery() {
    String clist=translateFieldCh2En(columnList);
    String tlist=translateTableCh2En(tableList);
    String equ=translateFieldCh2En(equation);
    String g=translateFieldCh2En(groupBy);
    String o=translateFieldCh2En(orderBy);
    String ret=replace(
        selectStr,
        new String[]{"_COLUMN_LIST_", "_TABLE_LIST_", "_EQUATION_"},
        new String[]{clist, tlist, equ});
    if (groupBy!=null && groupBy.length()>0)
      ret+=" GROUP BY "+g;
    if (orderBy!=null && orderBy.length()>0)
      ret+=" ORDER BY "+o;
    return ret+((unionSelect!=null)?unionSelect.getEnQuery():"");
  }

  public String toString() {
    String ret=replace(
        selectStr,
        new String[]{"_COLUMN_LIST_", "_TABLE_LIST_", "_EQUATION_"},
        new String[]{columnList, tableList, equation});
    if (groupBy!=null && groupBy.length()>0)
      ret+=" GROUP BY "+groupBy;
    if (orderBy!=null && orderBy.length()>0)
      ret+=" ORDER BY "+orderBy;
    return ret+((unionSelect!=null)?unionSelect.toString():"");
  }

  public String getChQuery() {
    // TODO Auto-generated method stub
    return null;
  }

  public String getChColumnList() {
    return translateKeywordEn2Ch(columnList);
  }

  public String getEnColumnList() {
    return columnList;
  }
  
  public String getChEquation() {
    return translateKeywordEn2Ch(equation);
  }
  
  public String getEnEquation() {
    return equation;
  }

  public String getChGroupBy() {
    return groupBy;
  }

  public String getEnGroupBy() {
    return groupBy;
  }
  
  public String getChOrderBy() {
    return orderBy;
  }

  public String getEnOrderBy() {
    return orderBy;
  }
  
  public String getChTableList() {
    return tableList;
  }
  
  public String getEnTableList() {
    return tableList;
  }

  public SelectModel getUnionSelect() {
    return unionSelect;
  }

  public void setUnionSelect(SelectModel unionSelect) {
    this.unionSelect = unionSelect;
  }
}
