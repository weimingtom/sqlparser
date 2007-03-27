package translator.model;

import org.dom4j.Element;

public class DbField {
  private String chName;
  private String enName;
  private String fieldParam;  //条件变量
  private boolean existInQuery;
  
  public String getFieldParam() {
    return fieldParam;
  }

  public void setFieldParam(String fieldParam) {
    this.fieldParam = fieldParam;
  }

  public boolean isExistInQuery() {
    return existInQuery;
  }

  public void setExistInQuery(boolean existInQuery) {
    this.existInQuery = existInQuery;
  }

  public String getChName() {
    return chName;
  }

  public void setChName(String chName) {
    this.chName = chName;
  }

  public String getEnName() {
    return enName;
  }

  public void setEnName(String enName) {
    if (enName==null)
      this.existInQuery=true;
    this.enName=enName;
  }

  public void getModelElement(Element elem) {
    Element e=elem.addElement("db_field");
    e.addAttribute("ch_name", chName);
    e.addAttribute("en_name", enName);
    e.addAttribute("exist_in_query", String.valueOf(existInQuery));
  }

  public void initFromElem(Element elem) {
    this.chName=elem.attributeValue("ch_name");
    this.enName=elem.attributeValue("en_name");
    this.existInQuery=Boolean.valueOf(elem.attributeValue("exist_in_query")).booleanValue();
  }

}
