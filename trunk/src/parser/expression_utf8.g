header {
	package parser;
}


/*======================================//
//										//
//		ExpressionParser				//
//										//
//======================================*/
class ExpressionParser extends Parser;

options {
	k=2;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {
    MINUS_TOKEN;
}

expr     
	: 	sumExpr EOF!
	;

sumExpr  
	: prodExpr ((PLUS^|MINUS^) prodExpr)*
	;
 
prodExpr
	: 	(atom) ( (MUL^|DIV^) atom)*
	;

minus_token:
        MINUS
        { #minus_token = #([MINUS_TOKEN, "minus_token"], #minus_token); }
    ;


powExpr
	: (atom) (POW^ (atom))?
	;

atom
	: 	VAR_ELEMENT
	| 	DIGIT_ELEMENT
	|	NEGATIVE_DIGIT_ELEMENT
	|	LPAREN sumExpr RPAREN
	;
/*======================================//
//										//
//			ExpressionLexer				//
//										//
//======================================*/
class ExpressionLexer extends Lexer;
options {
	k=2;
	charVocabulary = '\u0000' .. '\uFFFE';
	testLiterals=false;
	caseSensitive = false;
	caseSensitiveLiterals = true;
}

POINT : '.' ;

PLUS  : '+' | '加';

MINUS : '-' | '减';

MUL   : '*' | '乘';

DIV   : '/' | '除';

MOD   : '%' | '求''模';

POW   : '^' ;

LPAREN:	'(' ;

RPAREN:	')' ;

SEMI  : ';' ;

WS	:	(' '
	|	'\t'
	|	'\n'
	|	'\r')
		{ _ttype = Token.SKIP; }
	;



//variable element
VAR_ELEMENT
	:  ELEM_START_LETTER (ELEM_LETTER)*
	;
protected ELEM_START_LETTER
	: 	'a'..'z' 
	|    '\u0080'..'\ufffe'
	;
protected ELEM_LETTER
	: 	ELEM_START_LETTER
	|	'0'..'9'
	;

//negative digit element
NEGATIVE_DIGIT_ELEMENT
	: 	MINUS DIGIT_START (POINT DIGIT_NEXT)?
	;

//digit element
DIGIT_ELEMENT
	: 	DIGIT_START (POINT DIGIT_NEXT)?
	;

MINUS_DIGIT_ELEMENT
	: 	LPAREN MINUS DIGIT_START (POINT DIGIT_NEXT)? RPAREN
	;
protected DIGIT_START
	:	DIGIT_START_LETTER (DIGIT_LETTER)*
	;
protected DIGIT_NEXT
	: 	(DIGIT_LETTER)+
	;
protected DIGIT_START_LETTER
	:	('0'..'9')
	;
protected DIGIT_LETTER
	:	('0'..'9')
	;
/*======================================//
//										//
//		ExpressionParser				//
//										//
//======================================*/
{
	import java.math.BigDecimal;
	import model.parser.*;
	import java.util.*;
}

class ExpressionTreeParser extends TreeParser;
{
	Map exprElemMap = new HashMap();
	
	public Map getExprElemLi(){
		return 	exprElemMap;
	}
	
	public void setExprElemLi(Map exprElemMap){
		this.exprElemMap = exprElemMap;
	}
	
	public void addExprElemModel(String elemName, boolean isConstant){
		ExprElemModel exprElemModel = new ExprElemModel(elemName, isConstant);
    	exprElemMap.put(elemName, exprElemModel);
	}
	
	public BigDecimal getResultByElemName(String elemName){
		BigDecimal rValue = new BigDecimal("0");
		ExprElemModel exprElemModel = (ExprElemModel) exprElemMap.get(elemName);
		if (exprElemModel != null){
			if (!exprElemModel.isConstant() && exprElemModel.getElemValue() != null && !exprElemModel.getElemValue().equals(""))
				rValue = toBigDecimal(exprElemModel.getElemValue());
			else
				rValue = toBigDecimal(elemName);
		}
		return rValue;
	}
	
	public static BigDecimal toBigDecimal(String str){
    	BigDecimal lpReturnValue = new BigDecimal("0");
    	try{
      		if (str == null || str.equals("")){
        		str = "0";
      		}
      		lpReturnValue = new BigDecimal(str);
    	}catch(NumberFormatException nfe) {
      		lpReturnValue = new BigDecimal("0");
    	}catch(Exception nfe) {
    		lpReturnValue = new BigDecimal("0");
    	}
    	return lpReturnValue;
  	}

}

expr returns [String r]
	{
		r = "";
	  	String a, b, e;
	}
  : LPAREN e=expr RPAREN
  	{
  		r = "(" + e + ")";
  	}
  |	#(PLUS a=expr b=expr)
  	{
  		r = a + " + " + b;
  	}
  | #(MINUS a=expr b=expr)
  	{
  		r = a + " - " + b;
  	}
  | #(MUL a = expr b=expr)
  	{
  		r = a + " * " + b;
  	}
  | #(DIV a=expr b=expr)
  	{
  		r = a + " / " + b; 
  	}
  | #(MOD a=expr b=expr)
  	{
  		r = a + " % " + b;
  	}
  | e1:VAR_ELEMENT
  	{
  		r = e1.getText();
  		addExprElemModel(r, false);
  	}
  |	e2:DIGIT_ELEMENT
  	{
  		r = e2.getText();
  		addExprElemModel(r, true);
  	}
  |	e3: NEGATIVE_DIGIT_ELEMENT
  	{
  		r = e3.getText();
  		addExprElemModel(r, true);
  	}
  ;

exprExe returns [BigDecimal r]
	{
		r = new BigDecimal(0);
	  	BigDecimal a, b, e;
	}
  : LPAREN e=exprExe RPAREN
  	{
  		r = e;
  	}
  |	#(PLUS a=exprExe b=exprExe)
  	{
  		r = a.add(b);
  	}
  | #(MINUS a=exprExe b=exprExe)
  	{
  		r = a.subtract(b);
  	}
  | #(MUL a=exprExe b=exprExe)
  	{
  		r = a.multiply(b);
  	}
  | #(DIV a=exprExe b=exprExe)
  	{
  		if (b.compareTo(new BigDecimal("0")) != 0)
  			r = a.divide(b, 2, BigDecimal.ROUND_DOWN); 
  		else
  			r = a;
  	}
  | #(MOD a=exprExe b=exprExe)
  	{
  		//r = a % b;
  	}
  | e1:VAR_ELEMENT
  	{
  		r = getResultByElemName(e1.getText());
  	}
  |	e2:DIGIT_ELEMENT
  	{
  		r = getResultByElemName(e2.getText());
  	}
  |	e3: NEGATIVE_DIGIT_ELEMENT
  	{
  		r = getResultByElemName(e3.getText());
  	}
  ;