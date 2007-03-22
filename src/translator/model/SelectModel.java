package translator.model;

import org.dom4j.Element;

public class SelectModel extends QueryModel {
  private static final String selectStr=
    "SELECT _COLUMN_LIST_ FROM _TABLE_LIST_";
  private String columnList, tableList, equation, orderBy, groupBy;
  private SelectModel unionSelect;
  
  SelectModel() {}
  
  public SelectModel(String columnList, String tableList, String equation,String groupBy, String orderBy, SelectModel unionSelect) {
    this.columnList=(columnList==null)?"":columnList;
    this.tableList=(tableList==null)?"":tableList;
    this.equation=(equation==null)?"":equation;
    this.groupBy=(groupBy==null)?"":groupBy;
    this.orderBy=(orderBy==null)?"":orderBy;
    this.unionSelect=unionSelect;
  }
  
  public String getEnQuery() {
    String aliaslist = translateFieldAliasCh2En(columnList);
    String clist=translateFieldCh2En(aliaslist);
    String tlist=translateTableCh2En(tableList);
    String equ=translateFieldCh2En(equation);
    String g=translateFieldCh2En(groupBy);
    String o=translateFieldCh2En(orderBy);
    String ret=replace(
        selectStr,
        new String[]{"_COLUMN_LIST_", "_TABLE_LIST_"},
        new String[]{clist, tlist});
    if (equ!=null && equ.length()>0)
      ret+=" WHERE "+equ;
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

  public String getColumnList() {
    return columnList;
  }

  public String getChColumnList() {
    return translateKeywordEn2Ch(columnList); 
  }
  
  public String getEnColumnList() {
    return translateFieldCh2En(columnList);
  }
  
  public void setColumnList(String columnList) {
    this.columnList = columnList;
  }

  public String getEquation() {
    return equation;
  }
  
  public String getChEquation() {
    return translateKeywordEn2Ch(equation);
  }
  
  public String getEnEquation() {
    return translateFieldCh2En(equation);
  }
  
  public void setEquation(String equation) {
    this.equation = equation;
  }

  public String getGroupBy() {
    return groupBy;
  }

  public String getChGroupBy() {
    return translateKeywordEn2Ch(groupBy);
  }
  
  public String getEnGroupBy() {
    return translateFieldCh2En(groupBy);
  }
  
  public void setGroupBy(String groupBy) {
    this.groupBy = groupBy;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public String getChOrderBy() {
    return translateKeywordEn2Ch(orderBy);
  }
  
  public String getEnOrderBy() {
    return translateFieldCh2En(orderBy);
  }
  
  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public String getTableList() {
    return tableList;
  }

  public String getChTableList() {
    return translateKeywordEn2Ch(tableList);
  }
  
  public String getEnTableList() {
    return translateTableCh2En(tableList);
  }
  
  public void setTableList(String tableList) {
    this.tableList = tableList;
  }

  public void getModelElement(Element element) {
    element.addAttribute("class", getClass().getName());
    addPropertyElement(element, "column_list", columnList);
    addPropertyElement(element, "table_list", tableList);
    addPropertyElement(element, "equation", equation);
    addPropertyElement(element, "group_by", groupBy);
    addPropertyElement(element, "order_by", orderBy);
  }

  protected void initProperty(Element elem) {
    if (elem.attributeValue("name").equals("column_list"))
      this.columnList=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("table_list"))
      this.tableList=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("equation"))
      this.equation=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("group_by"))
      this.groupBy=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("order_by"))
      this.orderBy=elem.attributeValue("value");
  }
}
