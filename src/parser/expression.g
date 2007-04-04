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
	buildAST = true;
	defaultErrorHandler = false;
}

expr     
	: 	sumExpr EOF!
	;

sumExpr  
	: prodExpr ((PLUS^|MINUS^) prodExpr)*
	;
 
prodExpr
	: 	atom ((MUL^|DIV^|MOD^) atom)*
	;

powExpr
	: atom (POW^ atom)?
	;

atom
	: 	VAR_ELEMENT 
	| 	DIGIT_ELEMENT
	|	negative_sign DIGIT_ELEMENT
	|	LPAREN sumExpr RPAREN
	;

negative_sign
	:	"-"
	;

/*======================================//
//										//
//			ExpressionLexer				//
//										//
//======================================*/
class ExpressionLexer extends Lexer;

POINT : '.' ;

PLUS  : '+' ;

MINUS : '-' ;

MUL   : '*' ;

DIV   : '/' ;

MOD   : '%' ;

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
	: 	'a'..'z' | 'A'..'Z'
	;
protected ELEM_LETTER
	: 	ELEM_START_LETTER
	|	'0'..'9'
	;

//digit element
DIGIT_ELEMENT
	: 	DIGIT_START (POINT DIGIT_NEXT)?
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
  		r = a + "+" + b;
  	}
  | #(MINUS a=expr b=expr)
  	{
  		r = a + "-" + b;
  	}
  | #(MUL a = expr b=expr)
  	{
  		r = a + "*" + b;
  	}
  | #(DIV a=expr b=expr)
  	{
  		r = a + "/" + b; 
  	}
  | #(MOD a=expr b=expr)
  	{
  		r = a + "%" + b;
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
  |	nsign: negative_sign e3:DIGIT_ELEMENT
  	{
  		r = "-" + e3.getText();
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
  |	nsign: negative_sign e3:DIGIT_ELEMENT
  	{
  		r = getResultByElemName("-" + e3.getText());
  	}
  ;

//=============CONSTANT==========//
negative_sign
	:	"-"
	;