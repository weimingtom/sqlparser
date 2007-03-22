package translator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public abstract class QueryModel {
  protected Map chTableMap = new HashMap();
  protected Map fieldAliasMap = new HashMap();
  private String chQuery;
  private Map mapEn2Ch=new HashMap();
  
  protected String translateFieldAliasCh2En(String _iColumnStr){
    String _rValue = _iColumnStr;
    Iterator _it = fieldAliasMap.values().iterator();
    while (_it.hasNext()){
      DbFieldAlias _rDbFieldAlias = (DbFieldAlias) _it.next();
      String from = _rDbFieldAlias.getCnFieldAlias();
      String to = _rDbFieldAlias.getEnFieldAlias();
      _rValue = replace(_rValue, from, to);
    }
    return _rValue;
  }
  
  protected String translateFieldCh2En(String src) {
    String ret = src;
    for (Iterator t_it = chTableMap.values().iterator(); t_it.hasNext();) {
      DbTable t = (DbTable) t_it.next();
      DbField[] fields = t.getFields();
      for (int i = 0; i < fields.length; i++) {
        String from = "[" + t.getChName() + "." + fields[i].getChName() + "]";
        String to = "";
        if (t.getAlias() != null){
          to = t.getAlias() + "." + fields[i].getEnName();
          ret = replace(ret, from, to); 
          
          from = "[" + t.getAlias() + "." + fields[i].getChName() + "]";;
          to = t.getAlias() + "." + fields[i].getEnName();
          
        }else{
          to = t.getEnName() + "." + fields[i].getEnName();
        }
        ret = replace(ret, from, to);
      }
    }
    return ret;
  }
  
  protected String translateTableCh2En(String src) {
    String ret = src;
    for (Iterator t_it = chTableMap.values().iterator(); t_it.hasNext();) {
      DbTable t = (DbTable) t_it.next();
      String from = "[" + t.getChName() + "]";
      String to = t.getEnName();
      ret = replace(ret, from, to);
    }
    return ret;
  }

  protected String translateKeywordEn2Ch(String src) {
    String ret = src;
    for (Iterator it = mapEn2Ch.keySet().iterator(); it.hasNext();) {
      String key = (String) it.next();
      if (src.indexOf(key) >= 0)
        ret = replace(ret, key, (String) mapEn2Ch.get(key));
    }
    return ret;
  }

  public abstract String getEnQuery();

  public void setChQuery(String chQuery) {
    this.chQuery = chQuery;
  }

  public String getChQuery() {
    return chQuery;
  }

  public void addTableInfo(DbTable table) {
    chTableMap.put(table.getChName(), table);
  }
  
  public void addfieldAliasInfo(DbFieldAlias _iDbFieldAlias){
    fieldAliasMap.put(_iDbFieldAlias.getCnFieldAlias(), _iDbFieldAlias);
  }
  
  public void setMapEn2Ch(Map mapEn2Ch) {
    this.mapEn2Ch = mapEn2Ch;
  }

  protected String replace(String src, String from, String to) {
    // String f=Pattern.quote(from);
    if (src == null)
      return null;
    String f = "\\Q" + from + "\\E";
    return src.replaceAll(f, to);
  }

  protected String replace(String src, String[] fromSeq, String[] toSeq) {
    if (fromSeq.length != toSeq.length)
      return src;
    String ret = src;
    for (int i = 0; i < fromSeq.length; i++)
      ret = replace(ret, fromSeq[i], toSeq[i]);
    return ret;
  }

  /*
   * 获取xml片段, 将对象保存数据库
   */
  public String getXmlString() {
    Document d = DocumentHelper.createDocument();
    Element e=d.addElement("query");
    getModelElement(e);
    getDbInfoElement(d.getRootElement());
    getMapEn2ChElement(d.getRootElement());
    getChQuery(d.getRootElement());
    return d.asXML();
  }

  /**
   * �?有派生类必须重写此函数将成员变量添加到Element对象�?
   * @param element
   */
  protected abstract void getModelElement(Element element);

  private void getChQuery(Element element) {
    Element chQueryElem=element.addElement("ch_query");
    chQueryElem.addAttribute("value", chQuery);
  }

  private void getMapEn2ChElement(Element element) {
    Element mapElem = element.addElement("map_en_ch");
    for (Iterator it=mapEn2Ch.keySet().iterator(); it.hasNext();) {
      String en=(String)it.next();
      Element elem=mapElem.addElement("en_to_ch");
      elem.addAttribute("en", en);
      elem.addAttribute("ch", (String)mapEn2Ch.get(en));
    }
  }

  private void getDbInfoElement(Element rootElement) {
    Element dbInfo = rootElement.addElement("db_info_list");
    for (Iterator it = chTableMap.values().iterator(); it.hasNext();) {
      DbTable table = (DbTable) it.next();
      table.getModelElement(dbInfo);
    }
  }

  /**
   * 从XML文档恢复查询模型对象
   * @param xml
   * @return
   * @throws DocumentException 如果文档内容有错误无法构造模型对象则抛出此异�?
   */
  public static QueryModel createModelFromXml(String xml)
      throws DocumentException {
    QueryModel model=null;
    Document document = DocumentHelper.parseText(xml);
    Element root = document.getRootElement();
    Attribute queryClass = root.attribute("class");
    String className = queryClass.getValue();
    try {
      model = (QueryModel)Class.forName(className).newInstance();
      model.initModelFromElem(root);
    } catch (ClassNotFoundException e) {
      throw new DocumentException("class " + className + " not exist!");
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    return model;
  }

  protected void initModelFromElem(Element element) {
    for (Iterator it=element.elementIterator(); it.hasNext();) {
      Element elem=(Element)it.next();
      if (elem.getName().equals("property"))
        initProperty(elem);
      if (elem.getName().equals("db_info_list"))
        initDbInfoList(elem);
      if (elem.getName().equals("map_en_ch"))
        initMapEn2Ch(elem);
      if (elem.getName().equals("ch_query"))
        this.chQuery=elem.attributeValue("value");
    }
  }
  
  /**
   * 从XML文档对象中获取模型属性�
   * @param element
   */
  protected abstract void initProperty(Element element);

  private void initMapEn2Ch(Element elem) {
    for (Iterator it=elem.elementIterator(); it.hasNext();){
      Element e=(Element)it.next();
      mapEn2Ch.put(e.attributeValue("en"), e.attributeValue("ch"));
    }
  }

  protected void initDbInfoList(Element elem) {
    for (Iterator it=elem.elementIterator(); it.hasNext();) {
      DbTable table=new DbTable();
      table.initFromElem((Element)it.next());
      chTableMap.put(table.getChName(), table);
    }
  }

  protected void addPropertyElement(Element query, String propName,
      String propVal) {
    Element prop = query.addElement("property");
    prop.addAttribute("name", propName);
    prop.addAttribute("value", propVal);
  }

  public DbTable[] getDbTables() {
    DbTable[] ret=new DbTable[chTableMap.size()];
    int i=0;
    for (Iterator it=chTableMap.values().iterator(); it.hasNext();)
      ret[i++]=(DbTable)it.next();
    return ret;
  }
  
  public void setDbTables(DbTable[] tables) {
    chTableMap.clear();
    for (int i=0; i<tables.length; i++)
      chTableMap.put(tables[i].getChName(), tables[i]);
  }
}
