package translator.model;

import java.util.Iterator;

import org.dom4j.Element;

/**
 * SELECT字句的字段名/表达式、别名等信息对象
 *
 */
public class SelectListVO {
  private String cnColumnEquElem; //中文字段或表达式
  private String cnFieldAlias;    //中文字段或表达式的中文别名
  private String enFieldAlias;    //中文字段或表达式的英文别名
  private String fieldDataType;   //字段数据类型
  
  public String getCnColumnEquElem() {
    return cnColumnEquElem;
  }
  public void setCnColumnEquElem(String cnColumnEquElem) {
    this.cnColumnEquElem = cnColumnEquElem;
  }
  public String getCnFieldAlias() {
    return cnFieldAlias;
  }
  public void setCnFieldAlias(String cnFieldAlias) {
    this.cnFieldAlias = cnFieldAlias;
  }
  
  public String getEnFieldAlias() {
    return enFieldAlias;
  }
  public void setEnFieldAlias(String enFieldAlias) {
    this.enFieldAlias = enFieldAlias;
  }
  
  public String getFieldDataType() {
    return fieldDataType;
  }
  public void setFieldDataType(String fieldDataType) {
    this.fieldDataType = fieldDataType;
  }
  public void getModelElement(Element parent) {
    Element elem=parent.addElement("SelectListVO");
    elem.addAttribute("cnColumnEquElem", cnColumnEquElem);
    elem.addAttribute("cnFieldAlias", cnFieldAlias);
    elem.addAttribute("enFieldAlias", enFieldAlias);
    elem.addAttribute("fieldDataType", fieldDataType);
  }
}
