package translator.model;

import org.dom4j.Element;

public class SegmentModel extends QueryModel {
  private String segment;
  
  public SegmentModel(String segment) {
    this.segment=segment;
  }
  
  public String getEnQuery() {
    String ret=translateFieldCh2En(segment);
    return translateTableCh2En(ret);
  }

  protected void getModelElement(Element element) {
    element.addAttribute("class", getClass().getName());
    addPropertyElement(element, "segment", segment);
  }

  protected void initProperty(Element element) {
    if (element.attributeValue("name").equals("segment"))
      this.segment=element.attributeValue("value");
  }

}
