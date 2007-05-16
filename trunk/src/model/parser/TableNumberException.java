package model.parser;

import antlr.ANTLRException;

public class TableNumberException extends ANTLRException {
	private static final long serialVersionUID = -5122806882449286593L;
	
	private int existTableNumber = 0;
	private int inputTableNumber = 0;
	
  public TableNumberException(int existTableNumber, int inputTableNumber) {
    this.existTableNumber = existTableNumber;
    this.inputTableNumber = inputTableNumber;
  }
  
  public String toString() {
    return "table number differ:" + "exist table number is " + existTableNumber + ", but input table number is " + inputTableNumber;
  }

	public int getExistTableNumber() {
		return existTableNumber;
	}

	public void setExistTableNumber(int existTableNumber) {
		this.existTableNumber = existTableNumber;
	}

	public int getInputTableNumber() {
		return inputTableNumber;
	}

	public void setInputTableNumber(int inputTableNumber) {
		this.inputTableNumber = inputTableNumber;
	}
  
 
}
