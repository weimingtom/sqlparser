package translator.model;

import org.dom4j.Element;

public class CompareModel extends QueryModel {
  private static final String compareStr1 = "SELECT _FIELDS_";
  private static final String compareStr2 = " INTO _TABLE_NAME_";
  private static final String compareStr3 = " FROM _TABLE1_ WHERE _METHOD_ (SELECT * FROM _TABLE2_ WHERE _CONDITION_)";
  private String chTable1, chTable2, intoTable, method, equation;
  
  CompareModel() {}
  
  public CompareModel(String chTable1, String chTable2, String method, String equation) {
    this.chTable1=chTable1.substring(1, chTable1.length()-1);
    this.chTable2=chTable2.substring(1, chTable2.length()-1);
    this.method=method;
    this.equation=equation;
  }
  
  public CompareModel(String chTable1, String chTable2, String intoTable, String method, String equation) {
    this.chTable1=chTable1.substring(1, chTable1.length()-1);
    this.chTable2=chTable2.substring(1, chTable2.length()-1);
    this.intoTable=intoTable;
    this.method=method;
    this.equation=equation;
  }
  
  public String getExcuteEnQuery(String _intoTable){
    DbTable t1 = (DbTable)chTableMap.get(chTable1);
    DbTable t2 = (DbTable)chTableMap.get(chTable2);
    String equ = translateFieldCh2En(equation);
    return replace(
        (compareStr1 + compareStr2 + compareStr3),
        new String[]{"_FIELDS_", "_INTO_TABLE_NAME_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
        new String[]{t1.getFieldsEnStr(), _intoTable, t1.getEnName(), t2.getEnName(), method, equ});
  }
  
  public String getEnQuery() {
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    String equ=translateFieldCh2En(equation);
    return replace(
        (compareStr1 + compareStr3),
//        new String[]{"_INTO_TABLE_NAME_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
//        new String[]{intoTable, t1.getEnName(), t2.getEnName(), method, equ});
          new String[]{"_FIELDS_", "_TABLE1_", "_TABLE2_", "_METHOD_", "_CONDITION_"},
          new String[]{t1.getFieldsEnStr(), t1.getEnName(), t2.getEnName(), method, equ});
  }
  
  public String getEnColumnList(){
    DbTable t1 = (DbTable) chTableMap.get(chTable1);
    return t1.getFieldsEnStr();
  }
  
  public String getEnTableList(){
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    return (t1.getEnName() + "," + t2.getEnName());
  }
  
  public String getChTableList(){
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    return (t1.getChName() + "," + t2.getChName());
  }
  
  public String getEnMethod(){
    return this.method;
  }
  
  public String getChMethod(){
    return translateSimpleKeywordEn2Ch(this.method);
  }
  
  public String getChEquation(){
    return translateKeywordEn2Ch(this.equation);
  }
  
  public String getEnEquation(){
    return translateFieldCh2En(equation);
  }
  
  protected void getModelElement(Element element) {
    element.addAttribute("class", getClass().getName());
    addPropertyElement(element, "ch_table1", chTable1);
    addPropertyElement(element, "ch_table2", chTable2);
    addPropertyElement(element, "ch_into", intoTable);
    addPropertyElement(element, "method", method);
    addPropertyElement(element, "equation", equation);
  }

  protected void initProperty(Element element) {
    if (element.attributeValue("name").equals("ch_table1"))
      this.chTable1=element.attributeValue("value");
    if (element.attributeValue("name").equals("ch_table2"))
      this.chTable2=element.attributeValue("value");
    if (element.attributeValue("name").equals("ch_into"))
      this.intoTable=element.attributeValue("value");
    if (element.attributeValue("name").equals("method"))
      this.method=element.attributeValue("value");
    if (element.attributeValue("name").equals("equation"))
      this.equation=element.attributeValue("value");
  }

}
