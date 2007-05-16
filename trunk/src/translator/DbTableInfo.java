package translator;

import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Iterator;
import model.parser.DbTableModel;
import org.dom4j.Element;

public class DbTableInfo {
  private Map tables = new LinkedHashMap();
  class Table {
    String enName;
    String flag;
    String tableParam;
    Map fields = new HashMap();
  }
  
  class Field {
    String enName;
    String fieldParam;
  }
  
  public Map getTables() {
    return tables;
  }

  public void setTables(Map tables) {
    this.tables = tables;
  }

  public void setTableEnName(String tableChName, String tableEnName) {
    setTableEnName(tableChName, tableEnName, "", "");
  }
  
  public void setTableEnName(String tableChName, String tableEnName, String flag) {
    setTableEnName(tableChName, tableEnName, flag, "");
  }
  
  public void setTableEnName(String tableChName, String tableEnName, String flag, String tableParam) {
    if (tables.containsKey(tableChName)) {
      Table t = (Table) tables.get(tableChName);
      t.enName = tableEnName;
      t.flag = flag;
      t.tableParam = tableParam;
    } else {
      Table t = new Table();
      t.enName = tableEnName;
      t.flag = flag;
      t.tableParam = tableParam;
      tables.put(tableChName, t);
    }
  }
  
  public void setFieldEnName(String tableChName, String fieldChName, String fieldEnName) {
    setFieldEnName(tableChName, fieldChName, fieldEnName, "");
  }
  
  public void setFieldEnName(String tableChName, String fieldChName, String fieldEnName, String fieldParam) {
    if (!tables.containsKey(tableChName))
      return;
    Table t = (Table)tables.get(tableChName);
    if (t.fields.containsKey(fieldChName)) {
      Field f = (Field)t.fields.get(fieldChName);
      f.enName = fieldEnName;
      f.fieldParam = fieldParam;
    } else {
      Field f = new Field();
      f.enName = fieldEnName;
      f.fieldParam = fieldParam;
      t.fields.put(fieldChName, f);
    }
  }
  
  public String getTableEnName(String tableChName) {
    Table t=(Table)tables.get(tableChName);
    return (t==null)?"":t.enName;
  }
  
  public String getFieldEnName(String tableChName, String fieldChName) {
    Table t=(Table)tables.get(tableChName);
    if (t==null)
      return "";
    Field f=(Field)t.fields.get(fieldChName);
    return (f==null)?"":f.enName;
  }
  
  public AppDbTable[] getDbTableInfoToAppTableArr(){
    int m = 0;
    AppDbTable[] appDbTableArr = new AppDbTable[tables.size()];
    for (Iterator it = tables.keySet().iterator(); it.hasNext();){
      AppDbTable _appDbTable = new AppDbTable();
      String cnTableName = (String) it.next();
      Table t = (Table) tables.get(cnTableName);
      _appDbTable.setTableName(cnTableName);
      _appDbTable.setTableEnName(t.enName);
      _appDbTable.setFlag(t.flag);
      _appDbTable.setTableParam(t.tableParam);
      
      Map fieldsMap = t.fields;
      AppDbField[] appDbFieldArr = new AppDbField[fieldsMap.size()]; 
      for (Iterator it1 = fieldsMap.keySet().iterator(); it1.hasNext();){
        AppDbField _appDbField = new AppDbField();
        String cnFieldName = (String) it1.next();
        Field _field = (Field) fieldsMap.get(cnFieldName);
        _appDbField.setChName(cnFieldName);
        _appDbField.setEnName(_field.enName);
        _appDbField.setFieldParam(_field.fieldParam);
        _appDbTable.addDbField(_appDbField);
      }
      appDbTableArr[m] = _appDbTable;
      m++;
    }
    return appDbTableArr;
  } 
  
  public void getElement(DbTableModel tableModel, Element parent) {
    
    String[] tablesName = tableModel.getTablesNameArr();
    for (int i = 0; i < tablesName.length; i++){
      Element elem = parent.addElement("db_info");
      Table t = (Table) tables.get(tablesName[i]);
      elem.addAttribute("ch_name", tablesName[i]);
      elem.addAttribute("en_name", t.enName);
      elem.addAttribute("flag", t.flag);
      elem.addAttribute("tableParam", t.tableParam);
      
      Map _fields = t.fields;
      String[] fieldsNameArr = tableModel.getFieldsNameArrByTableName(tablesName[i]);
      for (int j = 0; j < fieldsNameArr.length; j++){
        Element e = elem.addElement("db_field");
        Field field = (Field) _fields.get(fieldsNameArr[j]);
        e.addAttribute("ch_name", fieldsNameArr[j]);
        e.addAttribute("en_name", field.enName);
        e.addAttribute("fieldParam", field.fieldParam);
      }
      
    }
    
//    Iterator it = tables.keySet().iterator();
//    while (it.hasNext()){
//      Element elem = parent.addElement("db_info");
//      String cnTableName = (String) it.next();
//      Table t = (Table) tables.get(cnTableName);
//      elem.addAttribute("ch_name", cnTableName);
//      elem.addAttribute("en_name", t.enName);
//      elem.addAttribute("flag", t.flag);
//      elem.addAttribute("tableParam", t.tableParam);
//      
//      Map _fields = t.fields;
//      Iterator it1 = _fields.keySet().iterator();
//      while (it1.hasNext()){
//        Element e = elem.addElement("db_field");
//        String fieldChName = (String) it1.next();
//        Field field = (Field) _fields.get(fieldChName);
//        e.addAttribute("ch_name", fieldChName);
//        e.addAttribute("en_name", field.enName);
//        e.addAttribute("fieldParam", field.fieldParam);
//      }
//    }
  }
  
  public void initDbTableInfoElement(Element dbElem) {
    setTableEnName(dbElem.attributeValue("ch_name"), dbElem.attributeValue("en_name"));
  }
  
  public void initDbTableFieldInfoElement(String chTableName, Element dbElem) {
    setFieldEnName(chTableName, dbElem.attributeValue("ch_name"), dbElem.attributeValue("en_name"));
  }
}
