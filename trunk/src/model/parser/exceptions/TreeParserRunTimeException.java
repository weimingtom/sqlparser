package model.parser.exceptions;

import antlr.RecognitionException;

public class TreeParserRunTimeException extends RecognitionException {
  
  public Throwable getCause() {
    return super.getCause();
  }

  public String getMessage() {
    return super.getMessage();
  }
  
}
