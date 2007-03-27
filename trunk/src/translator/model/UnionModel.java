package translator.model;

import org.dom4j.Element;

public class UnionModel extends QueryModel {
  private static final String unionStr1 = "INSERT INTO _INTO_TABLE_NAME_ (_FIELDS_) ";
  private static final String unionStr2 = 
    "SELECT _FIELDS_ FROM _TABLE1_ UNION ALL " +
    "SELECT _FIELDS_ FROM _TABLE2_";
  
  private String chTable1, chTable2, chIntoTable;
  
  UnionModel() {}
  
  public UnionModel(String t1, String t2) {
    this.chTable1=t1.substring(1, t1.length()-1);
    this.chTable2=t2.substring(1, t2.length()-1);
  }
  
  public UnionModel(String t1, String t2, String into) {
    this.chTable1=t1.substring(1, t1.length()-1);
    this.chTable2=t2.substring(1, t2.length()-1);
    this.chIntoTable=into;
  }
  
  public String getExecuteEnQuery(String _intoTable) {
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    return replace(
        (unionStr1 + unionStr2),
        new String[]{"_INTO_TABLE_NAME_", "_FIELDS_", "_TABLE1_", "_TABLE2_"},
        new String[]{_intoTable, t1.getFieldsEnStr(), t1.getEnName(), t2.getEnName()});
  }
  
  public String getEnQuery() {
    DbTable t1=(DbTable)chTableMap.get(chTable1);
    DbTable t2=(DbTable)chTableMap.get(chTable2);
    return replace(
        unionStr2,
        new String[]{"_FIELDS_", "_TABLE1_", "_TABLE2_"},
        new String[]{t1.getFieldsEnStr(), t1.getEnName(), t2.getEnName()});
  }

  protected void getModelElement(Element element) {
    element.addAttribute("class", getClass().getName());
    addPropertyElement(element, "ch_table1", chTable1);
    addPropertyElement(element, "ch_table2", chTable2);
    addPropertyElement(element, "ch_into", chIntoTable);
  }

  protected void initProperty(Element elem) {
    if (elem.attributeValue("name").equals("ch_table1"))
      this.chTable1=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("ch_table2"))
      this.chTable2=elem.attributeValue("value");
    if (elem.attributeValue("name").equals("ch_into"))
      this.chIntoTable=elem.attributeValue("value");
  }
  
}
