package translator;

import org.dom4j.Element;

/**
 * GROUP BY字句字段/字段表达式等信息对象
 *
 */
public class GroupByListVO {
  private String cnGroupByEquElem;  //中文字段/字段表达式

  public String getCnGroupByEquElem() {
    return cnGroupByEquElem;
  }

  public void setCnGroupByEquElem(String cnGroupByEquElem) {
    this.cnGroupByEquElem = cnGroupByEquElem;
  }
  
  public void getModelElement(Element parent){
    Element elem=parent.addElement("GroupByListVO");
    elem.addAttribute("cnGroupByEquElem", cnGroupByEquElem);
  }
  
}
