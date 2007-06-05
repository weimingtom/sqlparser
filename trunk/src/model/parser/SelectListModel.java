package model.parser;

import model.parser.common.Constants;

public class SelectListModel extends QueryModel {
  public boolean distinct;
  public int topNum;
  
  public void setDistinct(boolean distinct) {
    this.distinct = distinct;
  }

	public void setTopNum(String topNum) {
		int rValue = 0;
		try {
			rValue = Integer.parseInt(topNum);
		}catch(Exception e){}
		this.topNum = rValue;
	}

	public void addColumn(ColumnModel model) {
    addChild(model);
  }

  public String getChString() {
    String ret = "";
    if (distinct)
      ret = Constants.DISTINCT_CN + " ";
    if (topNum > 0)
    	ret += Constants.TOP_CN + " " + topNum + " ";
    
    ret += getChString(", ");
    return ret;
  }

  public String getEnString() {
    String ret = "";
    if (distinct)
      ret = Constants.DISTINCT_EN + " ";
    if (topNum > 0)
    	ret += Constants.TOP_EN + " " + topNum + " ";
    ret += getEnString(", ");
    return ret;
  }
}
