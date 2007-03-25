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
  private Map selectListMap = new HashMap();  //SELECT子句表达式列表
  private Map fromListMap = new HashMap();    //FROM子句表达式列表
  private Map whereListMap = new HashMap();   //WHERE子句表达式列表
  private Map groupByListMap = new HashMap(); //GROUP BY子句表达式列表
  private Map orderByListMap = new HashMap(); //ORDER BY子句表达式列表
  
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
      if (key != null && !key.equals("")){
        if (src.indexOf(key) >= 0){
          ret = replace(ret, key, (String) mapEn2Ch.get(key));
        }
      }
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
    getSelectListEqu(d.getRootElement());
    getFromListEqu(d.getRootElement());
    getWhereListEqu(d.getRootElement());
    getGroupByListEqu(d.getRootElement());
    getOrderByListEqu(d.getRootElement());
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
  
  private void getSelectListEqu(Element rootElement){
    Element _selectListEqu = rootElement.addElement("selectListEqu");
    for (Iterator it = selectListMap.values().iterator(); it.hasNext();) {
      SelectListVO _selectListVO = (SelectListVO) it.next();
      _selectListVO.setCnColumnEquElem(translateKeywordEn2Ch(_selectListVO.getCnColumnEquElem()));
      _selectListVO.getModelElement(_selectListEqu);
    }
  }
  
  private void getFromListEqu(Element rootElement){
    Element _fromListEqu = rootElement.addElement("fromListEqu");
    for (Iterator it = fromListMap.values().iterator(); it.hasNext();) {
      FromListVO _fromListVO = (FromListVO) it.next();
      _fromListVO.getModelElement(_fromListEqu);
    }
  }
  
  private void getWhereListEqu(Element rootElement){
    Element _whereListEqu = rootElement.addElement("whereListEqu");
    for (Iterator it = whereListMap.values().iterator(); it.hasNext();) {
      WhereListVO _whereListVO = (WhereListVO) it.next();
      _whereListVO.setCnAllWhereStr(translateKeywordEn2Ch(_whereListVO.getCnAllWhereStr()));
      _whereListVO.setCnComparSymbol(translateKeywordEn2Ch(_whereListVO.getCnComparSymbol()));
      _whereListVO.getModelElement(_whereListEqu);
    }
  }
  
  private void getGroupByListEqu(Element rootElement){
    Element _groupByListEqu = rootElement.addElement("groupByListEqu");
    for (Iterator it = groupByListMap.values().iterator(); it.hasNext();) {
      GroupByListVO _groupByListVO = (GroupByListVO) it.next();
      _groupByListVO.getModelElement(_groupByListEqu);
    }
  }
  
  private void getOrderByListEqu(Element rootElement){
    Element _orderByListEqu = rootElement.addElement("orderByListEqu");
    for (Iterator it = orderByListMap.values().iterator(); it.hasNext();) {
      OrderByListVO _orderByListVO = (OrderByListVO) it.next();
      _orderByListVO.getModelElement(_orderByListEqu);
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
      if (elem.getName().equals("selectListEqu"))
        initSelectListMap(elem);
      if (elem.getName().equals("fromListEqu"))
        initFromListMap(elem);
      if (elem.getName().equals("whereListEqu"))
        initWhereListMap(elem);
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
  
  protected void initSelectListMap(Element elem){
    for (Iterator it = elem.elementIterator(); it.hasNext();){
      Element e = (Element)it.next();
      SelectListVO _selectListVO = new SelectListVO();
      _selectListVO.setCnColumnEquElem(e.attributeValue("cnColumnEquElem"));
      _selectListVO.setCnFieldAlias(e.attributeValue("cnFieldAlias"));
      selectListMap.put("SQL_SELECT_" + String.valueOf(selectListMap.size() + 1), _selectListVO);
    }
  }
  
  protected void initFromListMap(Element elem){
    for (Iterator it = elem.elementIterator(); it.hasNext();){
      Element e = (Element)it.next();
      FromListVO _fromListVO = new FromListVO();
      _fromListVO.setCnTableName(e.attributeValue("cnTableName"));
      _fromListVO.setCnTAbleAlias(e.attributeValue("cnTAbleAlias"));
      fromListMap.put(_fromListVO.getCnTableName(), _fromListVO);
    }
  }
  
  protected void initWhereListMap(Element elem){
    for (Iterator it = elem.elementIterator(); it.hasNext();){
      Element e = (Element)it.next();
      WhereListVO _whereListVO = new WhereListVO();
      _whereListVO.setCnAllWhereStr(e.attributeValue("cnAllWhereStr"));
      _whereListVO.setCnWhereEquElem(e.attributeValue("cnWhereEquElem"));
      _whereListVO.setCnComparSymbol(e.attributeValue("cnComparSymbol"));
      _whereListVO.setCnWhereValue(e.attributeValue("cnWhereValue"));
      whereListMap.put("SQL_WHERE_" + String.valueOf(whereListMap.size() + 1), _whereListVO);
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

  public Map getFieldAliasMap() {
    return fieldAliasMap;
  }

  public void setFieldAliasMap(Map fieldAliasMap) {
    this.fieldAliasMap = fieldAliasMap;
  }

  public Map getSelectListMap() {
    return selectListMap;
  }
  
  /**
   * 获取SELECT子句下所有表达式对象数组
   * @return SelectListVO[] SelectListVO对象数组
   */
  public SelectListVO[] getSelectListArr() {
    int i = 0;
    SelectListVO[] _selectListVOArr = new SelectListVO[selectListMap.size()];
    Iterator it = selectListMap.values().iterator();
    while (it.hasNext()){
      SelectListVO _selectListVO = (SelectListVO) it.next();
      _selectListVOArr[i++] = _selectListVO;
    }
    return _selectListVOArr;
  }
  
  /**
   * 获取FROM子句下所有表达式对象数组
   * @return FromListVO[] FromListVO对象数组
   */
  public FromListVO[] getFromListVOArr() {
    int i = 0;
    FromListVO[] _fromListVOArr = new FromListVO[fromListMap.size()];
    Iterator it = fromListMap.values().iterator();
    while (it.hasNext()){
      FromListVO _fromListVO = (FromListVO) it.next();
      _fromListVOArr[i++] = _fromListVO;
    }
    return _fromListVOArr;
  }
  
  /**
   * 获取WHERE子句下所有表达式对象数组
   * @return WhereListVO[] WhereListVO对象数组
   */
  public WhereListVO[] getWhereListVOArr() {
    int i = 0;
    WhereListVO[] _whereListVOArr = new WhereListVO[whereListMap.size()];
    Iterator it = whereListMap.values().iterator();
    while (it.hasNext()){
      WhereListVO _whereListVO = (WhereListVO) it.next();
      _whereListVOArr[i++] = _whereListVO;
    }
    return _whereListVOArr;
  }
  
  /**
   * 获取GROUP BY子句下所有表达式对象数组
   * @return GroupByListVO[] GroupByListVO对象数组
   */
  public GroupByListVO[] getGroupByListVOArr() {
    int i = 0;
    GroupByListVO[] _groupByListVOArr = new GroupByListVO[groupByListMap.size()];
    Iterator it = groupByListMap.values().iterator();
    while (it.hasNext()){
      GroupByListVO _groupByListVO = (GroupByListVO) it.next();
      _groupByListVOArr[i++] = _groupByListVO;
    }
    return _groupByListVOArr;
  }
  
  /**
   * 获取ORDER BY子句下所有表达式对象数组
   * @return OrderByListVO[] OrderByListVO对象数组
   */
  public OrderByListVO[] getOrdereByListVOArr() {
    int i = 0;
    OrderByListVO[] _orderByListVOArr = new OrderByListVO[orderByListMap.size()];
    Iterator it = orderByListMap.values().iterator();
    while (it.hasNext()){
      OrderByListVO _orderByListVO = (OrderByListVO) it.next();
      _orderByListVOArr[i++] = _orderByListVO;
    }
    return _orderByListVOArr;
  }
  
  public Map getFromListMap() {
    return fromListMap;
  }
  
  public Map getWhereListMap() {
    return whereListMap;
  }
  
  public Map getGroupByListMap() {
    return groupByListMap;
  }
  
  public Map getOrderByListMap() {
    return orderByListMap;
  }
  
  public void setSelectListMap(Map selectListMap) {
    this.selectListMap = selectListMap;
  }
  
  public void setFromListMap(Map fromListMap) {
    this.fromListMap = fromListMap;
  }

  public void setWhereListMap(Map whereListMap) {
    this.whereListMap = whereListMap;
  }
  
  public void setGroupByListMap(Map groupByListMap) {
    this.groupByListMap = groupByListMap;
  }

  public void setOrderByListMap(Map orderByListMap) {
    this.orderByListMap = orderByListMap;
  }
  
}
