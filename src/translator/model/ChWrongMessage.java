package translator.model;

public class ChWrongMessage {
  private String message;
  private int line;
  private int column;
  private int length;
  public int getColumn() {
    return column;
  }
  public void setColumn(int column) {
    this.column = column;
  }
  public int getLine() {
    return line;
  }
  public int getLength() {
    return length;
  }
  public void setLength(int length) {
    this.length = length;
  }
  public void setLine(int line) {
    this.line = line;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String toString() {
    return "ÐÐ£º"+line+" ÁÐ£º"+column+" "+message;
  }
}
