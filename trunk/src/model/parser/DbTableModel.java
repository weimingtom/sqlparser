package model.parser;

import java.util.Map;
import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * 表名及字段名对象模型
 */
public class DbTableModel {
  private Map tablesLi = new LinkedHashMap();	//表名及字段名信息Map集合（包含一个中文表名KEY，表信息对象TableVO）
  
  //表信息对象TableVO
  class TableVO {
    String cnTableName;		//中文表名
    String enTableName;		//英文表名
    Map fieldsLi = new LinkedHashMap();	//字段信息Map集合（包含一个中文字段名KEY，字段信息对象FieldVO）
  }
  
  //字段信息对象FieldVO
  class FieldVO {
    String chFieldName;		//中文字段名
    String enFieldName;		//英文字段名
  }
  
  public Map getTablesLi() {
    return tablesLi;
  }

  public void setTablesLi(Map tablesLi) {
    this.tablesLi = tablesLi;
  }
  
  /**
   * 设置表信息的英文名
   * @param cnTableName	中文名
   * @param enTableName	英文名
   */
  public void setTableEnName(String cnTableName, String enTableName) {
    TableVO _tableVO = new TableVO();
    _tableVO.cnTableName = cnTableName;
    _tableVO.enTableName = enTableName;
    if (!tablesLi.containsKey(cnTableName)){
      tablesLi.put(cnTableName, _tableVO);
    }
  }
  
  /**
   * 获取中文的表名称数组
   * @return String[] 中文的表名称数组
   */
  public String[] getTablesNameArr(){
  	int i = 0;
  	String[] tablesNameArr = new String[tablesLi.size()];
  	for (Iterator it = tablesLi.keySet().iterator(); it.hasNext();){
  		tablesNameArr[i] = (String) it.next();
  		i++;
  	}
    return tablesNameArr;
  }
  
  /**
   * 根据中文的表名获取对应的字段中文名数组
   * @param tableChName 中文的表名
   * @return	字段中文名数组
   */
  public String[] getFieldsNameArrByTableName(String tableChName){
    String[] fieldsNameArr = new String[0];
    
    try {
	    TableVO tableVO = (TableVO) tablesLi.get(tableChName);
	    Map _fieldLi = tableVO.fieldsLi;
	    fieldsNameArr = new String[_fieldLi.size()];
	    int i = 0;
	    for (Iterator it = _fieldLi.keySet().iterator(); it.hasNext();){
	    	fieldsNameArr[i] = (String) it.next();
	    	i++;
	    }
    }catch(Exception ex){}
    
    return fieldsNameArr;
  }
  
  /**
   * 设置表信息的英文字段名
   * @param tableChName	中文表名
   * @param fieldChName	中文字段名
   * @param fieldEnName	英文字段名
   */
  public void setFieldEnName(String tableChName, String fieldChName, String fieldEnName) {
  	//如果tablesLi中不存在中文表名，则无法进行设置
  	if (!tablesLi.containsKey(tableChName))
      return;
  	
  	TableVO tableVO = (TableVO) tablesLi.get(tableChName);	//获取KEY为对应中文表名的TableVO信息
  	Map _fieldLi = tableVO.fieldsLi;												//获取此表TableVO信息下的字段内容
  	
  	if (_fieldLi.containsKey(fieldChName)){	//如果存在对应的中文字段
  		FieldVO fieldVO = (FieldVO) _fieldLi.get(fieldChName);	//获取KEY为此中文字段的FieldVO字段对象信息
  		fieldVO.chFieldName = fieldChName;											//设置中文字段
  		fieldVO.enFieldName = fieldEnName;											//设置英文字段
  	}else{
  		FieldVO fieldVO = new FieldVO();
  		fieldVO.chFieldName = fieldChName;											//设置中文字段
  		fieldVO.enFieldName = fieldEnName;											//设置英文字段
  		_fieldLi.put(fieldChName, fieldVO);											//将对应字段信息对象FieldVO设到tableVO.fieldsLi的Map中
  	}
  }
  
  /**
   * 根据表名获取英文字段串(f1, f2, ...)
   * @param tableChName 中文表名
   * @return String 英文字段串
   */
  public String getFieldsEnStr(String tableChName){
  	String rValue = "";
  	TableVO tableVO = (TableVO) tablesLi.get(tableChName);	//获取KEY为对应中文表名的TableVO信息
  	if (tableVO != null){	//如果存在对应的中文字段
  		Map _fieldLi = tableVO.fieldsLi;
  		int i = 0;
  		for (Iterator it = _fieldLi.keySet().iterator(); it.hasNext();){
  			String fieldChName = (String) it.next();								//获取字段信息对象的KEY	（中文字段名）
  			FieldVO fieldVO = (FieldVO) _fieldLi.get(fieldChName);	//获取字段信息对象FieldVO
  			if (i > 0)
  				rValue += ", ";
	    	rValue += fieldVO.enFieldName;
	    	i++;
	    }
  	}
  	return rValue;
  }
}
