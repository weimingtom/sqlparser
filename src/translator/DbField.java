package translator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.parser.FieldModel;

import org.dom4j.Element;

public class DbField {
  private String chName;
  private String enName;
  private List models=new ArrayList();
  
  public DbField() {
  }
  
  public DbField(FieldModel fm) {
    chName=fm.getFieldName();
    models.add(fm);
  }

  public String getEnName() {
    return enName;
  }

  public String getChName() {
    return chName;
  }

  public void setEnName(String name) {
    this.enName=name;
    for (Iterator it=models.iterator(); it.hasNext(); ) {
      FieldModel m=(FieldModel)it.next();
      m.setFieldEnName(name);
    }
  }

  public void setTableEnName(String name) {
    for (Iterator it=models.iterator(); it.hasNext(); ) {
      FieldModel m=(FieldModel)it.next();
      m.setTableEnName(name);
    }
  }

  public void addFieldModel(FieldModel fm) {
    models.add(fm);
  }

  public void getElement(Element parent) {
    Element e=parent.addElement("db_field");
    e.addAttribute("ch_name", chName);
    e.addAttribute("en_name", enName);
  }

}
