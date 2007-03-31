package model.parser;

import java.util.HashMap;
import java.util.Map;

public class ErrorLexer {
  public static final String COMMA_LEXER_NAME = "COMMA";
  public static final String COMMA_LEXER_VALUE = ",";
  
  public static final String COMMA_POINT_NAME = "POINT";
  public static final String COMMA_POINT_VALUE = ".";
  
  public static final String COMMA_LPAREN_NAME = "LPAREN";
  public static final String COMMA_LPAREN_VALUE = "(";
  
  public static final String COMMA_RPAREN_NAME = "RPAREN";
  public static final String COMMA_RPAREN_VALUE = ")";
  
  public static final String COMMA_EOF_NAME = "EOF";
  public static final String COMMA_EOF_VALUE = "½áÊø·û";
  
  Map lexersMap = new HashMap();
  
  public ErrorLexer(){
    setlexersMap();
  }

  public void setlexersMap(){
    lexersMap.put(COMMA_LEXER_NAME, COMMA_LEXER_VALUE);
    lexersMap.put(COMMA_POINT_NAME, COMMA_POINT_VALUE);
    lexersMap.put(COMMA_LPAREN_NAME, COMMA_LPAREN_VALUE);
    lexersMap.put(COMMA_RPAREN_NAME, COMMA_RPAREN_VALUE);
    lexersMap.put(COMMA_EOF_NAME, COMMA_EOF_VALUE);
  }

  public Map getLexersMap() {
    return lexersMap;
  }
  
}
