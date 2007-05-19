package model.parser;

public class ChWrongMessage {
	private String message;

	private int line;

	private int column;

	private int length = 0;

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
		return "第 " + line + "行，第 " + column + " 列，错误输入：" + message;
	}
}
