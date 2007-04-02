package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DbTableModel {
  //private List tablesLi = new ArrayList();
  private Map tablesLi = new HashMap();
  class TableVO {
    String cnTableName;
    String enTableName;
    //List fieldsLi = new ArrayList();
    Map fieldsLi = new HashMap();
  }
  class FieldVO {
    String chFieldName;
    String enFieldName;
  }
  
//  public List getTables() {
//    return tablesLi;
//  }
//  public void setTables(List tables) {
//    this.tablesLi = tables;
//  }
  
  
  
  public void setTableEnName(String cnTableName, String enTableName) {
    TableVO _tableVO = new TableVO();
    _tableVO.cnTableName = cnTableName;
    _tableVO.enTableName = enTableName;
    if (!tablesLi.containsKey(cnTableName)){
      tablesLi.put(cnTableName, _tableVO);
    }
    //tablesLi.add(_tableVO);
  }
  
  public void setFieldEnName(String tableChName, String fieldChName, String fieldEnName) {
//    for (int i = 0; i < tablesLi.size(); i++){
//      TableVO _tableVO = (TableVO) tablesLi.get(i);
//      if (_tableVO.cnTableName.equals(tableChName)){
//        FieldVO _fieldVO = new FieldVO();
//        _fieldVO.chFieldName = fieldChName;
//        _fieldVO.enFieldName = fieldEnName;
//        _tableVO.fieldsLi.add(_fieldVO);
//        break;
//      }
//    }
    
    TableVO _tableVO = (TableVO) tablesLi.get(tableChName);
    if (_tableVO != null){
      FieldVO _fieldVO = new FieldVO();
      _fieldVO.chFieldName = fieldChName;
      _fieldVO.enFieldName = fieldEnName;
      _tableVO.fieldsLi.put(fieldChName, _fieldVO);
    }
  }
  
  public String getFieldsEnStr(String tableChName){
    String rValue = "";
//    for (int i = 0; i < tablesLi.size(); i++){
//      TableVO _tableVO = (TableVO) tablesLi.get(i);
//      if (_tableVO.cnTableName.equals(tableChName)){
//        List _fieldLi = _tableVO.fieldsLi;
//        if (_fieldLi.size() > 0)
//          rValue = ((FieldVO)_fieldLi.get(0)).enFieldName;
//        for (int j = 1; j < _fieldLi.size(); j++){
//          rValue += ", " + ((FieldVO)_fieldLi.get(j)).enFieldName;
//        }
//      }
//    }
    TableVO _tableVO = (TableVO) tablesLi.get(tableChName);
    if (_tableVO != null){
      int maxFieldSize = _tableVO.fieldsLi.size();
      int nowPos = 0;
      for (Iterator it = _tableVO.fieldsLi.keySet().iterator(); it.hasNext();){
        String fieldKey = (String) it.next();
        FieldVO _fieldVO = (FieldVO) _tableVO.fieldsLi.get(fieldKey);
        if (_fieldVO != null){
          rValue += _fieldVO.enFieldName;
          if (nowPos < maxFieldSize - 1)
            rValue += ", ";
          nowPos++;
        }
      }
    }
    return rValue;
  }

  public Map getTablesLi() {
    return tablesLi;
  }

  public void setTablesLi(Map tablesLi) {
    this.tablesLi = tablesLi;
  }
}
