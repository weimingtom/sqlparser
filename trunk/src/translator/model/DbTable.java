package translator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DbTable {
  private String chName;
  private String enName;
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
}
