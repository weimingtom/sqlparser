package model.parser;

import model.parser.common.Constants;

public class SelectStatementModel extends QueryModel {
  /**
   * 设置SELECT子句SELECT列表模型对象
   * @param model
   */
  public void setSelectList(SelectListModel model) {
    addChild(model);
  }
  
  /**
   * 设置FROM子句表格列表模型对象
   * @param model
   */
  public void setTableList(TableListModel model) {
    addChild(model);
  }
  
  /**
   * 设置WHERE子句条件模型对象
   * @param model
   */
  public void setSearchCondition(SearchConditionModel model) {
    addChild(model);
  }
  
  /**
   * 设置GROUP BY子句分组列表模型
   * @param model
   */
  public void setGroupExpressionList(AggregateExprListModel model) {
    addChild(model);
  }
  
  /**
   * 设置ORDER子句排序列表模型
   * @param model
   */
  public void setOrderExpressionList(OrderExpressionListModel model) {
    addChild(model);
  }
  
  /**
   * 获取片断子句的格式化中文SQL语句
   * @param segmentType 片断子句类型
   * @return String 格式化中文SQL语句
   */
  public String getChSegment(String segmentType) {
    String rValue = "";
    SelectListModel sl = (SelectListModel) getFirstModelByClass(SelectListModel.class);
    SearchConditionModel cond = (SearchConditionModel) getFirstModelByClass(SearchConditionModel.class);
    if (segmentType.equals(Constants.COLUMN)){
      rValue = sl.getChString();
    }else if (segmentType.equals(Constants.WHERE)){
      rValue = cond.getChString();
    }
    return rValue;
  }
  
  /**
   * 获取片断子句的标准英文SQL语句
   * @param segmentType 片断子句类型
   * @return 标准英文SQL语句
   */
  public String getEnSegment(String segmentType) {
    String rValue = "";
    SelectListModel sl = (SelectListModel) getFirstModelByClass(SelectListModel.class);
    SearchConditionModel cond = (SearchConditionModel) getFirstModelByClass(SearchConditionModel.class);
    if (segmentType.equals(Constants.COLUMN)){
      rValue = sl.getEnString();
    }else if (segmentType.equals(Constants.WHERE)){
      rValue = cond.getEnString();
    }
    return rValue;
  }
  
  /**
   * 获取完整查询语句的格式化中文SQL语句
   * @return String 格式化中文SQL语句
   */
  public String getChString() {
    SelectListModel sl = (SelectListModel) getFirstModelByClass(SelectListModel.class);
    TableListModel tl = (TableListModel) getFirstModelByClass(TableListModel.class);
    SearchConditionModel cond = (SearchConditionModel) getFirstModelByClass(SearchConditionModel.class);
    AggregateExprListModel aggr = (AggregateExprListModel) getFirstModelByClass(AggregateExprListModel.class);
    OrderExpressionListModel order = (OrderExpressionListModel) getFirstModelByClass(OrderExpressionListModel.class);
    String ret = Constants.SELECT_CN + " " + sl.getChString();
    if (tl != null)
      ret += " " + Constants.FROM_CN + " " + tl.getChString();
    if (cond != null)
      ret += " " + Constants.WHERE_CN + " " + cond.getChString();
    if (aggr != null)
      ret += " " + Constants.GROUP_BY_CN + " " + aggr.getChString();
    if (order != null)
      ret += " " + Constants.ORDER_BY_CN + " " + order.getChString();
    return ret;
  }
  
  /**
   * 获得标准的英文SQL语句
   */
  public String getEnString() {
   return getExecuteEnString("");
  }
  
  /**
   * 获得可执行的英文SQL语句
   * @param intoTableName INTO的表名，为空时表示标准的SQL语句
   * @return String 可执行的英文SQL语句
   */
   public String getExecuteEnString(String intoTableName) {
    SelectListModel sl = (SelectListModel) getFirstModelByClass(SelectListModel.class);
    TableListModel tl = (TableListModel) getFirstModelByClass(TableListModel.class);
    SearchConditionModel cond = (SearchConditionModel) getFirstModelByClass(SearchConditionModel.class);
    AggregateExprListModel aggr = (AggregateExprListModel) getFirstModelByClass(AggregateExprListModel.class);
    OrderExpressionListModel order = (OrderExpressionListModel) getFirstModelByClass(OrderExpressionListModel.class);
    
    String ret = Constants.SELECT_EN + " " + sl.getEnString();
    if (intoTableName != null && !intoTableName.equals("")){
      ret += " INTO " + intoTableName;
      if (tl != null)
        ret += " " + Constants.FROM_EN + " " + tl.getEnString();
    }else{
      if (tl != null)
        ret += " " + Constants.FROM_EN + " " + tl.getEnString();
    }
    if (cond != null)
      ret += " " + Constants.WHERE_EN + " " + cond.getEnString();
    if (aggr != null)
      ret += " " + Constants.GROUP_BY_EN + " " + aggr.getEnString();
    if (order != null)
      ret += " " + Constants.ORDER_BY_EN + " " + order.getEnString();
    return ret;
  }
  
   /**
    * 获得空的可执行英文SQL语句
    * @param intoTableName INTO的表名
    * @return 返回可执行的英文SQL语句，只有空的表结构
    */
  public String getEmptyExecuteEnString(String intoTableName){
    SelectListModel sl = (SelectListModel) getFirstModelByClass(SelectListModel.class);
    TableListModel tl = (TableListModel) getFirstModelByClass(TableListModel.class);
    AggregateExprListModel aggr = (AggregateExprListModel) getFirstModelByClass(AggregateExprListModel.class);
    OrderExpressionListModel order = (OrderExpressionListModel) getFirstModelByClass(OrderExpressionListModel.class);
    
    String ret = Constants.SELECT_EN + " " + sl.getEnString();
    if (intoTableName != null && !intoTableName.equals(""))
      ret += " INTO " + intoTableName;
    if (tl != null)
      ret += " " + Constants.FROM_EN + " " + tl.getEnString();
    ret += " " + Constants.WHERE_EN + " 1 = 0";
    if (aggr != null)
      ret += " " + Constants.GROUP_BY_EN + " " + aggr.getEnString();
    if (order != null)
      ret += " " + Constants.ORDER_BY_EN + " " + order.getEnString();
    return ret;
  }
}
