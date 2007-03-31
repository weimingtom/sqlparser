package model.parser;

public class SelectStatementModel extends QueryModel {
  public void setSelectList(SelectListModel model) {
    addChild(model);
  }
  
  public void setTableList(TableListModel model) {
    addChild(model);
  }
  
  public void setSearchCondition(SearchConditionModel model) {
    addChild(model);
  }

  public void setGroupExpressionList(AggregateExprListModel model) {
    addChild(model);
  }
  
  public void setOrderExpressionList(OrderExpressionListModel model) {
    addChild(model);
  }
  
  public String getChSegment(String segmentType){
    String rValue = "";
    SelectListModel sl = (SelectListModel)getFirstModelByClass(SelectListModel.class);
    SearchConditionModel cond = (SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
    if (segmentType.equals("column")){
      rValue = sl.getChString();
    }else if (segmentType.equals("where")){
      rValue = cond.getChString();
    }
    return rValue;
  }
  
  public String getEnSegment(String segmentType){
    String rValue = "";
    SelectListModel sl=(SelectListModel)getFirstModelByClass(SelectListModel.class);
    SearchConditionModel cond = (SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
    if (segmentType.equals("column")){
      rValue = sl.getEnString();
    }else if (segmentType.equals("where")){
      rValue = cond.getEnString();
    }
    return rValue;
  }
  
  public String getChString() {
    SelectListModel sl=(SelectListModel)getFirstModelByClass(SelectListModel.class);
    TableListModel tl=(TableListModel)getFirstModelByClass(TableListModel.class);
    SearchConditionModel cond=(SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
    AggregateExprListModel aggr=(AggregateExprListModel)getFirstModelByClass(AggregateExprListModel.class);
    OrderExpressionListModel order=(OrderExpressionListModel)getFirstModelByClass(OrderExpressionListModel.class);
    String ret="查询 "+sl.getChString();
    if (tl!=null)
      ret+=" 来自 "+tl.getChString();
    if (cond!=null)
      ret+=" 条件 "+cond.getChString();
    if (aggr!=null)
      ret+=" 分组 "+aggr.getChString();
    if (order!=null)
      ret+=" 排序 "+order.getChString();
    return ret;
  }
  
  public String getEnString() {
    SelectListModel sl=(SelectListModel)getFirstModelByClass(SelectListModel.class);
    TableListModel tl=(TableListModel)getFirstModelByClass(TableListModel.class);
    SearchConditionModel cond=(SearchConditionModel)getFirstModelByClass(SearchConditionModel.class);
    AggregateExprListModel aggr=(AggregateExprListModel)getFirstModelByClass(AggregateExprListModel.class);
    OrderExpressionListModel order=(OrderExpressionListModel)getFirstModelByClass(OrderExpressionListModel.class);
    String ret="SELECT "+sl.getEnString();
    if(tl!=null)
      ret+=" FROM "+tl.getEnString();
    if (cond!=null)
      ret+=" WHERE "+cond.getEnString();
    if (aggr!=null)
      ret+=" GROUP BY "+aggr.getEnString();
    if (order!=null)
      ret+=" ORDER BY "+order.getEnString();
    return ret;
  }

}
