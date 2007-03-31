package translator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.parser.FieldModel;
import model.parser.TableModel;

import org.dom4j.Element;

public class DbTable {
  private TableModel model;
  private Map fields = new HashMap();

  public DbTable(TableModel model){
    this.model = model;
  }

  public String getChName() {
    return model.getTableName();
  }

  public void setChName(String name) {
    model.setTableName(name);
  }

  public String getAlias() {
    return model.getAlias();
  }

  public void addDbField(DbField f) {
    fields.put(f.getChName(), f);
  }

  public Collection getFields() {
    return fields.values();
  }

  public String getEnName() {
    return model.getEnQuery();
  }

  public void setEnName(String name) {
    model.setTableEnName(name);
  }

  public TableModel getModel() {
    return model;
  }

  public void setModel(TableModel model) {
    this.model = model;
  }

  public void addDbField(String chFieldName, String enFieldName) {
    if (fields.containsKey(chFieldName)){
      DbField field = (DbField) fields.get(chFieldName);
      if (model.getAlias().length() > 0)
        field.setTableEnName(model.getAlias());
      else
        field.setTableEnName(model.getTableEnName());
      field.setEnName(enFieldName);
    }
  }
  
  public void addToDbField(String chFieldName, String enFieldName) {
    FieldModel fm = new FieldModel(chFieldName, model.getTableName());
    addDbField(fm);
  }
  
  public void addDbField(FieldModel fm) {
    if (fields.containsKey(fm.getFieldName())){
      DbField f = (DbField) fields.get(fm.getFieldName());
      f.addFieldModel(fm);
    }else{
      DbField f = new DbField(fm);
      fields.put(fm.getFieldName(), f);
    }
  }

  public void getElement(Element parent) {
    Element elem = parent.addElement("db_info");
    elem.addAttribute("ch_name", model.getTableName());
    elem.addAttribute("en_name", model.getTableEnName());
    for (Iterator it = fields.values().iterator(); it.hasNext();){
      DbField field = (DbField) it.next();
      field.getElement(elem);
    }
  }

  public void initTableFromElement(Element dbElem) {
    setEnName(dbElem.attributeValue("en_name"));
    for (Iterator it = dbElem.elementIterator(); it.hasNext();){
      Element e = (Element) it.next();
      addDbField(e.attributeValue("ch_name"), e.attributeValue("en_name"));
    }
  }
}
