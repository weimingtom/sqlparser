package translator.model;

import org.dom4j.Element;

/**
 * WHERE字句表达式、运算符、对应的条件等信息对象
 *
 */
public class WhereListVO {
  private String cnAllWhereStr;   //本中文条件所有句子
  private String cnWhereEquElem;  //中文条件字段或表达式
  private String cnComparSymbol;  //中文关系运算符
  private String cnWhereValue;    //中文条件的值
  
  public String getCnComparSymbol() {
    return cnComparSymbol;
  }
  public void setCnComparSymbol(String cnComparSymbol) {
    this.cnComparSymbol = cnComparSymbol;
  }
  public String getCnWhereEquElem() {
    return cnWhereEquElem;
  }
  public void setCnWhereEquElem(String cnWhereEquElem) {
    this.cnWhereEquElem = cnWhereEquElem;
  }
  public String getCnWhereValue() {
    return cnWhereValue;
  }
  public void setCnWhereValue(String cnWhereValue) {
    this.cnWhereValue = cnWhereValue;
  }
  
  public String getCnAllWhereStr() {
    return cnAllWhereStr;
  }
  public void setCnAllWhereStr(String cnAllWhereStr) {
    this.cnAllWhereStr = cnAllWhereStr;
  }
  public void getModelElement(Element parent) {
    Element elem=parent.addElement("WhereListVO");
    elem.addAttribute("cnAllWhereStr", cnAllWhereStr);
    elem.addAttribute("cnWhereEquElem", cnWhereEquElem);
    elem.addAttribute("cnComparSymbol", cnComparSymbol);
    elem.addAttribute("cnWhereValue", cnWhereValue);
  }
}