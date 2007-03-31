package model.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DbTableModel {
  private List tablesLi = new ArrayList();
  class TableVO {
    String cnTableName;
    String enTableName;
    List fieldsLi = new ArrayList();
  }
  class FieldVO {
    String chFieldName;
    String enFieldName;
  }
  
  public List getTables() {
    return tablesLi;
  }
  public void setTables(List tables) {
    this.tablesLi = tables;
  }
  
  public void setTableEnName(String cnTableName, String enTableName) {
    TableVO _tableVO = new TableVO();
    _tableVO.cnTableName = cnTableName;
    _tableVO.enTableName = enTableName;
    tablesLi.add(_tableVO);
  }
  
  public void setFieldEnName(String tableChName, String fieldChName, String fieldEnName) {
    for (int i = 0; i < tablesLi.size(); i++){
      TableVO _tableVO = (TableVO) tablesLi.get(i);
      if (_tableVO.cnTableName.equals(tableChName)){
        FieldVO _fieldVO = new FieldVO();
        _fieldVO.chFieldName = fieldChName;
        _fieldVO.enFieldName = fieldEnName;
        _tableVO.fieldsLi.add(_fieldVO);
        break;
      }
    }
  }
  
  public String getFieldsEnStr(String tableChName){
    String rValue = "";
    for (int i = 0; i < tablesLi.size(); i++){
      TableVO _tableVO = (TableVO) tablesLi.get(i);
      if (_tableVO.cnTableName.equals(tableChName)){
        List _fieldLi = _tableVO.fieldsLi;
        if (_fieldLi.size() > 0)
          rValue = ((FieldVO)_fieldLi.get(0)).enFieldName;
        for (int j = 1; j < _fieldLi.size(); j++){
          rValue += ", " + ((FieldVO)_fieldLi.get(j)).enFieldName;
        }
      }
    }
    return rValue;
  }
}
