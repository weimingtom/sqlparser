package translator.model;

public class SegmentModel extends QueryModel {
  private String segment;
  
  public SegmentModel(String segment) {
    this.segment=segment;
  }
  
  public String getEnQuery() {
    String ret=translateFieldCh2En(segment);
    return translateTableCh2En(ret);
  }

}
