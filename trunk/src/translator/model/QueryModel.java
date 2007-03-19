package translator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class QueryModel {
  protected Map chTableMap=new HashMap();
  protected Map mapKeyword;
  
  private String chQuery;
  private Map mapEn2Ch;
  
  protected String translateFieldCh2En(String src) {
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
  protected String translateTableCh2En(String src) {
    String ret=src;
    for (Iterator t_it=chTableMap.values().iterator(); t_it.hasNext();) {
      DbTable t=(DbTable)t_it.next();
      String from="["+t.getChName()+"]";
      String to=t.getEnName();
      ret=replace(ret, from, to);
    }
    return ret;
  }
  
  protected String translateKeywordEn2Ch(String src) {
    String ret=src;
    for (Iterator it=mapEn2Ch.keySet().iterator(); it.hasNext();) {
      String key=(String)it.next();
      if (src.indexOf(key)>=0)
        ret=replace(ret, key, (String)mapEn2Ch.get(key));
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
  
  public void setMapEn2Ch(Map mapEn2Ch) {
    this.mapEn2Ch=mapEn2Ch;
  }
  
  protected String replace(String src, String from, String to) {
//    String f=Pattern.quote(from);
    if (src==null)
      return null;
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
