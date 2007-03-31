package translator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import translator.DbTableInfo.Field;
import translator.DbTableInfo.Table;

public class AppDbTable {
  private String tableName;
  private String tableEnName;
  private String flag;
  private String tableParam;
  private List fieldLiArr = new ArrayList();
  
  public String getTableEnName() {
    return tableEnName;
  }
  public void setTableEnName(String tableEnName) {
    this.tableEnName = tableEnName;
  }
  public String getTableName() {
    return tableName;
  }
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }
  public String getFlag() {
    return flag;
  }
  public void setFlag(String flag) {
    this.flag = flag;
  }
  public String getTableParam() {
    return tableParam;
  }
  public void setTableParam(String tableParam) {
    this.tableParam = tableParam;
  }
  
  public void addDbField(String chFieldName, String enFieldName) {
    addDbField(chFieldName, enFieldName, "");
  }
  
  public void addDbField(String chFieldName, String enFieldName, String fieldParam) {
    AppDbField appDbField = new AppDbField();
    appDbField.setChName(chFieldName);
    appDbField.setEnName(enFieldName);
    fieldLiArr.add(appDbField);
  }
  
  public void addDbField(AppDbField appDbField){
    fieldLiArr.add(appDbField);
  }
  
  public AppDbField[] getFields(){
    AppDbField[] appDbFields = new AppDbField[fieldLiArr.size()];
    for (int i = 0; i < fieldLiArr.size(); i++){
      appDbFields[i] = (AppDbField) fieldLiArr.get(i);
    }
    return appDbFields;
  }
  
  public void getElement(Element parent) {
    Element elem = parent.addElement("db_info");
    elem.addAttribute("ch_name", getTableName());
    elem.addAttribute("en_name", getTableEnName());
    AppDbField[] appDbFields = this.getFields();
    for (int i = 0; i < appDbFields.length; i++){
        Element e = elem.addElement("db_field");
        String fieldChName = appDbFields[i].getChName();
        String fieldEnName = appDbFields[i].getEnName();
        e.addAttribute("ch_name", fieldChName);
        e.addAttribute("en_name", fieldEnName);
    }
  }
}
