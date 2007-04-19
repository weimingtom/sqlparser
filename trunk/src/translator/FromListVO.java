package translator;

import org.dom4j.Element;

/**
 * FROM字句的表名、别名等信息对象
 *
 */
public class FromListVO {
  private String cnTableName;     //中文表名
  private String cnTAbleAlias;    //中文表名的别名
  
  public String getCnTAbleAlias() {
    return cnTAbleAlias;
  }
  public void setCnTAbleAlias(String cnTAbleAlias) {
    this.cnTAbleAlias = cnTAbleAlias;
  }
  public String getCnTableName() {
    return cnTableName;
  }
  public void setCnTableName(String cnTableName) {
    this.cnTableName = cnTableName;
  }
  
  public void getModelElement(Element parent) {
    Element elem=parent.addElement("FromListVO");
    elem.addAttribute("cnTableName", cnTableName);
    elem.addAttribute("cnTAbleAlias", cnTAbleAlias);
  }
  
}
