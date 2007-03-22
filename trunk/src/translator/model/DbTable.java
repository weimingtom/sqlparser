package translator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Element;

public class DbTable {
  private String flag;
  private String chName;
  private String enName;
  private String alias;
  private boolean existInFromClause;
  
  private Map chFields = new HashMap();

  // private Map enFields=new HashMap();

  public DbTable(String chName, String enName) {
    this.chName = chName;
    this.enName = enName;
  }

  public DbTable() {

  }

  public String getChName() {
    return chName;
  }

  public String getEnName() {
    return enName;
  }

  public String getFieldsEnStr() {
    String ret;
    DbField[] fields = getFields();
    if (fields.length > 0)
      ret = fields[0].getEnName();
    else
      return "";
    for (int i = 1; i < fields.length; i++)
      ret += ", " + fields[i].getEnName();
    return ret;
  }

  public void setEnName(String enName) {
    this.enName = enName;
  }

  public void setChName(String chName) {
    this.chName = chName;
  }

  /**
   * 让编译器在扫描的时候构造DbTable对象，应用系统不要调用这个函数
   * 
   * @param field
   */
  private void addDbField(DbField field) {
    this.chFields.put(field.getChName(), field);
    // this.enFields.put(field.getEnName(), field);
  }

  public void addDbField(String chFieldName, String enFieldName) {
    DbField field = (DbField) chFields.get(chFieldName);
    if (field == null) {
      field = new DbField();
      field.setChName(chFieldName);
      addDbField(field);
    }
    field.setEnName(enFieldName);
  }

  /**
   * 获得表的字段列表
   * 
   * @return
   */
  public DbField[] getFields() {
    DbField[] ret = new DbField[chFields.size()];
    int i = 0;
    for (Iterator it = chFields.values().iterator(); it.hasNext();)
      ret[i++] = (DbField) it.next();
    return ret;
  }

  public boolean isExistInFromClause() {
    return existInFromClause;
  }

  public void setExistInFromClause(boolean existInFromClause) {
    this.existInFromClause = existInFromClause;
  }

  public void getModelElement(Element parent) {
    Element elem=parent.addElement("db_info");
    elem.addAttribute("ch_name", chName);
    elem.addAttribute("en_name", enName);
    elem.addAttribute("flag", flag);
    elem.addAttribute("alias", alias);
    elem.addAttribute("exist_in_form", String.valueOf(existInFromClause));
    for (Iterator it=chFields.values().iterator(); it.hasNext();) {
      DbField field=(DbField)it.next();
      field.getModelElement(elem);
    }
  }

  public void initFromElem(Element elem) {
    this.chName=elem.attributeValue("ch_name");
    this.enName=elem.attributeValue("en_name");
    this.alias=elem.attributeValue("alias");
    this.flag=elem.attributeValue("flag");
    for (Iterator it=elem.elementIterator(); it.hasNext();) {
      DbField field=new DbField();
      field.initFromElem((Element)it.next());
      chFields.put(field.getChName(), field);
    }
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }
}
