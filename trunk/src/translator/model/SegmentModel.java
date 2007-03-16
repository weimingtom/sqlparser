package translator.model;

public class SegmentModel extends QueryModel {
  private String segment;
  
  public SegmentModel(String segment) {
    this.segment=segment;
  }
  
  public String getEnQuery() {
    String ret=translateField(segment);
    return translateTable(ret);
  }

}
