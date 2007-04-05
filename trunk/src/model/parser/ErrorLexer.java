package model.parser;

import java.util.HashMap;
import java.util.Map;

public class ErrorLexer {
  Map lexersMap = new HashMap();
  
  public static final String COMMA_LEXER_NAME  = "COMMA";
  public static final String COMMA_LEXER_VALUE = ",";
  
  public static final String POINT_LEXER_NAME  = "POINT";
  public static final String POINT_LEXER_VALUE = ".";
  
  public static final String LPAREN_LEXER_NAME  = "LPAREN";
  public static final String LPAREN_LEXER_VALUE = "(";
  
  public static final String RPAREN_LEXER_NAME  = "RPAREN";
  public static final String RPAREN_LEXER_VALUE = ")";
  
  public static final String PARAM_LPAREN_LEXER_NAME = "PARAM_LPAREN";
  public static final String PARAM_LPAREN_LEXER_VALUE = "{";
  
  public static final String PARAM_RPAREN_LEXER_NAME = "PARAM_RPAREN";
  public static final String PARAM_RPAREN_LEXER_VALUE = "}";
  
  public static final String EOF_LEXER_NAME = "EOF";
  public static final String EOF_LEXER_VALUE = "½áÊø·û";
  
  public ErrorLexer(){
    setlexersMap();
  }
  
  public Map getLexersMap() {
    return lexersMap;
  }
  
  public void setlexersMap(){
    lexersMap.put(COMMA_LEXER_NAME, COMMA_LEXER_VALUE);
    lexersMap.put(POINT_LEXER_NAME, POINT_LEXER_VALUE);
    lexersMap.put(LPAREN_LEXER_NAME, LPAREN_LEXER_VALUE);
    lexersMap.put(RPAREN_LEXER_NAME, RPAREN_LEXER_VALUE);
    lexersMap.put(PARAM_RPAREN_LEXER_NAME, PARAM_RPAREN_LEXER_VALUE);
    lexersMap.put(EOF_LEXER_NAME, EOF_LEXER_VALUE);
  }
}
