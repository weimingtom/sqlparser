package translator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class QueryModel {
  protected Map chTableMap=new HashMap();
  protected Map mapKeyword;
  
  private String chQuery;
  
  protected String translateField(String src) {
    String ret=src;
    for (Iterator t_it=chTableMap.values().iterator(); t_it.hasNext();) {
      DbTable t=(DbTable)t_it.next();
      DbField[] fields=t.getFields();
      for (int i=0; i<fields.length; i++) {
        String from="["+t.getChName()+"."+fields[i].getChName()+"]";
        String to=t.getEnName()+"."+fields[i].getEnName();
        ret=replace(ret, from, to);
      }
    }
    return ret;
  }
  protected String translateTable(String src) {
    String ret=src;
    for (Iterator t_it=chTableMap.values().iterator(); t_it.hasNext();) {
      DbTable t=(DbTable)t_it.next();
      String from="["+t.getChName()+"]";
      String to=t.getEnName();
      ret=replace(ret, from, to);
    }
    return ret;
  }
  
  public abstract String getEnQuery();
  public void setKeywordMap(Map keywordMap) {
    this.mapKeyword=keywordMap;
  }
  public void setChQuery(String chQuery) {
    this.chQuery=chQuery;
  }
  public String getChQuery() {
    return chQuery;
  }
  
  public void addTableInfo(DbTable table) {
    chTableMap.put(table.getChName(), table);
  }
  
  protected String replace(String src, String from, String to) {
//    String f=Pattern.quote(from);
    String f="\\Q"+from+"\\E";
    return src.replaceAll(f, to);
  }
  
  protected String replace(String src, String[] fromSeq, String[] toSeq) {
    if (fromSeq.length!=toSeq.length)
      return src;
    String ret=src;
    for (int i=0; i<fromSeq.length; i++)
      ret=replace(ret, fromSeq[i], toSeq[i]);
    return ret;
  }


}
