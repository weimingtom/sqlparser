package model.parser;

public class StringModel extends QueryModel {

  private String content;
  public StringModel(String content) {
    this.content=content;
  }

  public String getChString() {
    return content;
  }
  public String getEnString() {
    return translateStringCh2En(content);
  }
}
