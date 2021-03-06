//*==========================================================
//	LongtopParser Of Expression
// 	Indicator Expression Grammar
//
//	http://www.longtop.com
//
//  Recent updates by jiandeh@sina.com
//
//	\u4fee\u6539\u65e5\u5fd7:
//	========================================================
//	06/01/2007:
//		- \u589e\u52a0JAVA\u7684\u6570\u5b66\u51fd\u6570(\u5c5e\u6027\u5e38\u91cf\u3001\u7a7a\u53c2\u6570\u3001\u5355\u53c2\u6570\u3001\u4e24\u4e2a\u53c2\u6570)
//
//==========================================================*/

header {
	package parser.indicator;
}

/*=========================================//
//
//			Expression Parser
//
//========================================*/
class ExpressionParser extends Parser;

options {
	k = 2;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {
	EXPRESSION_BLOCK;						//\u6307\u6807\u516c\u5f0f\u5757\u6807\u8bb0TOKEN
	CONST_FUNCTION_TOKEN;				//\u5e38\u91cf\u51fd\u6570TOKEN
	EMPTY_FUNCTION_TOKEN;				//\u7a7a\u53c2\u6570\u51fd\u6570TOKEN
	ARITHMETIC_FUNCTION1_TOKEN;	//\u6570\u5b66\u51fd\u6570(1\u4e2a\u53c2\u6570)TOKEN
	ARITHMETIC_FUNCTION2_TOKEN;	//\u6570\u5b66\u51fd\u6570(2\u4e2a\u53c2\u6570)TOKEN
	MINUS_TOKEN;								//\u76f8\u51cfTOKEN
}

expr
	:	sumExpr
	;

sumExpr
	:	prodExpr ((PLUS^ | PLUS_CN^ | MINUS^ | MINUS_CN^) prodExpr)*
	;

prodExpr
	:	atom ((MUL^ | MUL_CN^ | MINUS^ | DIV^) atom)*
	;

atom
	:	constants
	|	const_function
	{#atom = #([CONST_FUNCTION_TOKEN, "const_function"], #atom);}
	|	empty_function LPAREN! RPAREN!
	{#atom = #([EMPTY_FUNCTION_TOKEN, "empty_function"], #atom);}
	|	arithmetic_function1 LPAREN! parameters1 RPAREN!
	{#atom = #([ARITHMETIC_FUNCTION1_TOKEN, "arithmetic_function1"], #atom);}
	|	arithmetic_function2 LPAREN! parameters2 RPAREN!
	{#atom = #([ARITHMETIC_FUNCTION2_TOKEN, "arithmetic_function2"], #atom);}
	;

constants
	:	LPAREN! expr RPAREN!
	{#constants = #([EXPRESSION_BLOCK, "expression_block"], #constants);}
	|	NEGATIVE_NUMBER_ELEMENT
	|	NUMBER_ELEMENT
	|	VAR_ELEMENT
	;

parameters1
	:	constants
	;
parameters2
	:	constants COMMA^ constants
	;
//parameters
//	:	constants (COMMA^ constants)?
//	;

const_function
	:	PI_CN	|	PI_EN
	|	E_CN	|	E_EN
	;

empty_function
	:	RANDOM_CN	|	RANDOM_EN
	;

arithmetic_function1
	:	ABS_CN			|	ABS_EN
	|	ACOS_CN			|	ACOS_EN
	|	ASIN_CN			|	ASIN_EN
	|	ATAN_CN			|	ATAN_EN
	|	CEIL_CN			|	CEIL_EN
	|	COS_CN			|	COS_EN
	|	EXP_CN			|	EXP_EN
	|	FLOOR_CN 		|	FLOOR_EN
	|	LOG_CN			|	LOG_EN
	|	RINT_CN			|	RINT_EN
	|	ROUND_CN		|	ROUND_EN
	|	SIN_CN			|	SIN_EN
	|	SQRT_CN			|	SQRT_EN
	|	TAN_CN			|	TAN_EN
	|	DEGREES_CN		|	DEGREES_EN
	|	RADIANS_CN		|	RADIANS_EN
	;

arithmetic_function2
	:	ATAN2_CN		|	ATAN2_EN
	|	MAX_CN			|	MAX_EN
	|	MIN_CN			|	MIN_EN
	|	POW_CN			|	POW_EN
	|	REMAINDER_CN	|	REMAINDER_EN
	;

/*=========================================//
//
//			Expression Lexer
//
//========================================*/
class ExpressionLexer extends Lexer;

options{
	k = 2;
	charVocabulary = '\u0000' .. '\uFFFE';
	testLiterals = false;
	caseSensitive = false;
	caseSensitiveLiterals = true;
}

tokens{
	PLUS_CN  = "\u52a0" ;
	MINUS_CN = "\u51cf" ;
	MUL_CN   = "\u4e58" ;
	DIV_CN   = "\u9664" ;
	
	PI_CN = "\u6c42\u5706\u5468\u7387";
	PI_EN = "PI";
	
	E_CN = "\u6c42\u81ea\u7136\u5bf9\u6570\u5e95\u6570";
	E_EN = "E";

	ABS_CN = "\u53d6\u7edd\u5bf9\u503c";
	ABS_EN = "abs";
	
	ACOS_CN = "\u6c42\u53cd\u4f59\u5f26\u503c";
	ACOS_EN = "acos";
	
	ASIN_CN = "\u6c42\u53cd\u6b63\u5f26\u503c";
	ASIN_EN = "asin";
	
	ATAN_CN = "\u6c42\u53cd\u6b63\u5207\u503c";
	ATAN_EN = "atan";

	ATAN2_CN = "\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c";
	ATAN2_EN = "atan2";

	CEIL_CN = "\u53d6\u4e0a\u9650\u6574\u6570";
	CEIL_EN = "ceil";

	COS_CN = "\u6c42\u4f59\u5f26\u503c";
	COS_EN = "cos";
	
	EXP_CN = "\u6c42\u5e42\u503c";
	EXP_EN = "exp";

	FLOOR_CN = "\u53d6\u4e0b\u9650\u6574\u6570";
	FLOOR_EN = "floor";
	
	LOG_CN = "\u6c42\u81ea\u7136\u5bf9\u6570";
	LOG_EN = "log";
	
	MAX_CN = "\u6c42\u6700\u5927\u503c";
	MAX_EN = "max";
	
	MIN_CN = "\u6c42\u6700\u5c0f\u503c";
	MIN_EN = "min";

	POW_CN = "\u6c42\u5e42";
	POW_EN = "pow";

	REMAINDER_CN = "\u6c42\u4f59";
	REMAINDER_EN = "IEEEremainder";

	RANDOM_CN = "\u53d6\u968f\u673a\u6570";
	RANDOM_EN = "random";

	RINT_CN = "\u53d6\u6574";
	RINT_EN = "rint";
	
	ROUND_CN = "\u56db\u820d\u4e94\u5165";
	ROUND_EN = "round";
	
	SIN_CN = "\u6c42\u6b63\u5f26\u503c";
	SIN_EN = "sin";
	
	SQRT_CN = "\u6c42\u5e73\u65b9\u6839";
	SQRT_EN = "sqrt";
	
	TAN_CN = "\u6c42\u6b63\u5207\u503c";
	TAN_EN = "tan";
	
	DEGREES_CN = "\u5f27\u5ea6\u8f6c\u5ea6\u6570";
	DEGREES_EN = "toDegrees";
	
	RADIANS_CN = "\u5ea6\u6570\u8f6c\u5f27\u5ea6";
	RADIANS_EN = "toRadians";
}

POINT 	: '.' ;

COMMA	: ',' ;

//Arithmetic Operator
PLUS	: '+' ;

MINUS	: '-' ;

MUL		: '*' ;

DIV		: '/' ;


LPAREN:	'(' ;

RPAREN:	')' ;

//Var Element
VAR_ELEMENT	options {testLiterals = true;}
	:	ELEM_START_LETTER ( ELEM_LETTER )*
	;
	
protected ELEM_START_LETTER
    :    'a'..'z'
    |	'_'
    |    '\u0080'..'\ufffe'
    ;

protected ELEM_LETTER
    :	ELEM_START_LETTER
    |	'0'..'9'
    ;

//Number Element
NUMBER_ELEMENT
	:	NUM (POINT DOT_NUM)?
	;

//Negative Number Element
NEGATIVE_NUMBER_ELEMENT
	: 	MINUS NUM (POINT DOT_NUM)?
	;
	
protected NUM
	:	'0'
	|	NUM_START (NUM_LETTER)*
	;
protected DOT_NUM
	:	(NUM_LETTER)+
	;
protected NUM_START
	:	'1'..'9'
	;
protected NUM_LETTER
	:	'0'..'9'
	;

SEMI  : ';' ;

WS
	: (	' '
	|	'\t'
	|	'\n'	{ newline(); }
	|	'\r' ('\n')?	{ newline(); }
	)
	{$setType(Token.SKIP);}
	;

ML_COMMENT
	:	"/*"
		(	/*	'\r' '\n' can be matched in one alternative or by matching
				'\r' in one iteration and '\n' in another.  I am trying to
				handle any flavor of newline that comes in, but the language
				that allows both "\r\n" and "\r" and "\n" to all be valid
				newline is ambiguous.  Consequently, the resulting grammar
				must be ambiguous.  I'm shutting this warning off.
			 */
			options {
				generateAmbigWarnings=false;
			}
		:
			{ LA(2)!='/' }? '*'
		|	'\r' '\n'		{newline();}
		|	'\r'			{newline();}
		|	'\n'			{newline();}
		|	~('*'|'\n'|'\r')
		)*
		"*/"
		{$setType(Token.SKIP);}
	;


/*=========================================//
//
//			Expression TreeParser
//
//========================================*/
{
	import model.parser.*;
	
	import java.util.*;
	import java.math.BigDecimal;
	
	import java.lang.Math;
	import java.lang.reflect.Field;
	import java.lang.reflect.Method;
	import java.lang.reflect.InvocationTargetException;
}

class ExpressionTreeParser extends TreeParser;

{
	Map exprElemMap = new LinkedHashMap();
	
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
  
  /**
	 * \u6839\u636e\u7c7b\u7684Field\u5c5e\u6027\u540d\u79f0\u83b7\u53d6\u5bf9\u5e94\u7684\u503c
	 * @param mField \u5c5e\u6027\u540d\u79f0
	 * @return BigDecimal \u7c7b\u5c5e\u6027\u5bf9\u5e94\u7684\u503c
	 */
	public BigDecimal getResultByClassField(String mField) {
		BigDecimal rValue = new BigDecimal("0");
		try {
			Class c = Class.forName("java.lang.Math");
			Field field = c.getField(TargetExprModel.getFunctionByKey(mField));
			if (field != null){
				Object rResult = field.get(c);
				if (rResult instanceof Double) {
					double _rResult = ((Double) rResult).doubleValue();
					rValue = new BigDecimal(_rResult);
				}else if (rResult instanceof Long){
					long _rResult = ((Long) rResult).longValue();
					rValue = new BigDecimal(_rResult);
				}else if (rResult instanceof Float){
					float _rResult = ((Float) rResult).floatValue();
					rValue = new BigDecimal(_rResult);
				}else if (rResult instanceof Integer){
					int _rResult = ((Integer) rResult).intValue();
					rValue = new BigDecimal(_rResult);
				}
				//rValue = rValue.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
			}
		} catch (Exception e) {
			System.err.println("getResultByClassField() Error: " + e.getMessage());
		}
		return rValue;
	}
	
	/**
	 * \u6839\u636e\u51fd\u6570\u540d\u79f0\u83b7\u53d6\u5bf9\u5e94\u7ed3\u679c\uff08\u7a7a\u53c2\u6570\u51fd\u6570\uff09
	 * @param mFunction \u51fd\u6570\u540d\u79f0
	 * @return BigDecimal \u6570\u5b66\u51fd\u6570\u8fd0\u7b97\u540e\u7684\u503c
	 */
  public BigDecimal getResultByFunction(String mFunction) {
		BigDecimal rValue = new BigDecimal("0");
		try {
			Class c = Class.forName("java.lang.Math");
			Method method = c.getMethod(TargetExprModel.getFunctionByKey(mFunction), null);
			Object rResult = method.invoke(c, null);
			if (rResult instanceof Double) {
				double _rResult = ((Double) rResult).doubleValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Long){
				long _rResult = ((Long) rResult).longValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Float){
				float _rResult = ((Float) rResult).floatValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Integer){
				int _rResult = ((Integer) rResult).intValue();
				rValue = new BigDecimal(_rResult);
			}
			//rValue = rValue.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			System.err.println("getResultByFunction() Error: " + e.getMessage());
		}
		return rValue;
	}
	
	/**
	 * \u6839\u636e\u51fd\u6570\u540d\u79f0\u83b7\u53d6\u5bf9\u5e94\u7ed3\u679c\uff08\u5355\u4e2a\u53c2\u6570\u51fd\u6570\uff09
	 * @param mFunction  \u51fd\u6570\u540d\u79f0
	 * @param mParameter \u53c2\u6570
	 * @return BigDecimal \u6570\u5b66\u51fd\u6570\u8fd0\u7b97\u540e\u7684\u503c
	 */
	public BigDecimal getResultByFunction(String mFunction, double mParameter) {
		BigDecimal rValue = new BigDecimal("0");
		try {
			Class c = Class.forName("java.lang.Math");
			Method method = c.getMethod(TargetExprModel.getFunctionByKey(mFunction), new Class[] { double.class });
			Object rResult = method.invoke(c, new Object[] { new Double(mParameter) });
			if (rResult instanceof Double) {
				double _rResult = ((Double) rResult).doubleValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Long){
				long _rResult = ((Long) rResult).longValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Float){
				float _rResult = ((Float) rResult).floatValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Integer){
				int _rResult = ((Integer) rResult).intValue();
				rValue = new BigDecimal(_rResult);
			}
			//rValue = rValue.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
		} catch (Exception e) {
			System.err.println("getResultByFunction() Error: " + e.getMessage());
		}
		return rValue;
	}
	
	/**
	 * \u6839\u636e\u51fd\u6570\u540d\u79f0\u83b7\u53d6\u5bf9\u5e94\u7ed3\u679c\uff08\u4e24\u4e2a\u53c2\u6570\u51fd\u6570\uff09
	 * @param mFunction  \u51fd\u6570\u540d\u79f0
	 * @param parametersArr \u53c2\u6570\u6570\u7ec4
	 * @return BigDecimal \u6570\u5b66\u51fd\u6570\u8fd0\u7b97\u540e\u7684\u503c
	 */
	public BigDecimal getResultByFunction(String mFunction, double[] parametersArr) {
		BigDecimal rValue = new BigDecimal("0");

		try {
			Class c = Class.forName("java.lang.Math");
			if (parametersArr != null && parametersArr.length == 2) {
				Method method = c.getMethod(TargetExprModel.getFunctionByKey(mFunction), 
					new Class[] { double.class, double.class });
				Object rResult = method.invoke(c, new Object[] {
						new Double(parametersArr[0]), new Double(parametersArr[1])});
				if (rResult instanceof Double) {
				double _rResult = ((Double) rResult).doubleValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Long){
				long _rResult = ((Long) rResult).longValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Float){
				float _rResult = ((Float) rResult).floatValue();
				rValue = new BigDecimal(_rResult);
			}else if (rResult instanceof Integer){
				int _rResult = ((Integer) rResult).intValue();
				rValue = new BigDecimal(_rResult);
			}
			//rValue = rValue.divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP);
			}
		} catch (Exception e) {
			System.err.println("getResultByFunction() Error: " + e.getMessage());
		}
		return rValue;
	}
  	
}

expr returns [String rValue]
{
	rValue = "";
	String a, b;
	String p1, p2;
	String e;
}
	:	#(EXPRESSION_BLOCK e = expr)
		{
			rValue = "(" + e + ")";
		}
		
	|	#(CONST_FUNCTION_TOKEN fun0:const_function)
		{
			rValue = fun0.getText();
		}
		
	|	#(EMPTY_FUNCTION_TOKEN fun1:empty_function)
		{
			rValue = fun1.getText() + "(" + ")";
		}
		
	|	#(ARITHMETIC_FUNCTION1_TOKEN fun2:arithmetic_function1 p1 = parameters1)
		{
			rValue = fun2.getText() + "(" + p1 + ")";
		}
		
	|	#(ARITHMETIC_FUNCTION2_TOKEN fun3:arithmetic_function2 p2 = parameters2)
		{
			rValue = fun3.getText() + "(" + p2 + ")";
		}
	
	|	#(op1:PLUS a = expr b = expr)
		{
			rValue = a + " " + op1 + " " + b;
		}
	|	#(op2:PLUS_CN a = expr b = expr)
		{
			rValue = a + " " + op2 + " " + b;
		}
		
	|	#(op3:MINUS a = expr b = expr)
		{
			rValue = a + " " + op3 + " " + b;
		}
	|	#(op4:MINUS_CN a = expr b = expr)
		{
			rValue = a + " " + op4 + " " + b;
		}
	
	|	#(op5:MUL a = expr b = expr)
		{
			rValue = a + " " + op5 + " " + b;
		}
	|	#(op6:MUL_CN a = expr b = expr)
		{
			rValue = a + " " + op6 + " " + b;
		}
		
	|	#(op7:DIV a = expr b = expr)
		{
			rValue = a + " " + op7 + " " + b;
		}
	|	#(op8:DIV_CN a = expr b = expr)
		{
			rValue = a + " " + op8 + " " + b;
		}
		
	|	e1:VAR_ELEMENT
		{
  			rValue = e1.getText();
  			addExprElemModel(rValue, false);
  		}
  	|	ne1:NUMBER_ELEMENT
  		{
  			rValue = ne1.getText();
  			addExprElemModel(rValue, true);
  		}
  	|	ne2:NEGATIVE_NUMBER_ELEMENT
  		{
  			rValue = ne2.getText();
  			addExprElemModel(rValue, true);
  		}
	;

parameters1 returns [String rValue]
{
	rValue = "";
}
	:	e1:VAR_ELEMENT
		{
  			rValue = e1.getText();
  			addExprElemModel(rValue, false);
  		}
  	|	ne1:NUMBER_ELEMENT
  		{
  			rValue = ne1.getText();
  			addExprElemModel(rValue, true);
  		}
  	|	ne2:NEGATIVE_NUMBER_ELEMENT
  		{
  			rValue = ne2.getText();
  			addExprElemModel(rValue, true);
  		}
	;

parameters2 returns [String rValue]
{
	rValue = "";
	String p1, p2;
}
	:	#(COMMA p1 = parameters1 p2 = parameters1)
		{
			rValue = p1 + ", " + p2;
		}
	;




exprExe returns [BigDecimal rValue]
{
	rValue = new BigDecimal(0);
	BigDecimal a, b;
	BigDecimal e;
	double p1;
	double[] p2;
}
	:	#(EXPRESSION_BLOCK e = exprExe)
		{
			rValue = e;
		}
		
	|	#(CONST_FUNCTION_TOKEN fun0:const_function)
		{
			rValue = getResultByClassField(fun0.getText());
		}
		
	|	#(EMPTY_FUNCTION_TOKEN fun1:empty_function)
		{
			rValue = getResultByFunction(fun1.getText());
		}
		
	|	#(ARITHMETIC_FUNCTION1_TOKEN fun2:arithmetic_function1 p1 = exe_parameters1)
		{
			rValue = getResultByFunction(fun2.getText(), p1);
		}
		
	|	#(ARITHMETIC_FUNCTION2_TOKEN fun3:arithmetic_function2 p2 = exe_parameters2)
		{
			rValue = getResultByFunction(fun3.getText(), p2);
		}
	
	|	#(op1:PLUS a = exprExe b = exprExe)
		{
			rValue = a.add(b);
		}
	|	#(op2:PLUS_CN a = exprExe b = exprExe)
		{
			rValue = a.add(b);
		}
		
	|	#(op3:MINUS a = exprExe b = exprExe)
		{
			rValue = a.subtract(b);
		}
	|	#(op4:MINUS_CN a = exprExe b = exprExe)
		{
			rValue = a.subtract(b);
		}
	
	|	#(op5:MUL a = exprExe b = exprExe)
		{
			rValue = a.multiply(b);
		}
	|	#(op6:MUL_CN a = exprExe b = exprExe)
		{
			rValue = a.multiply(b);
		}
		
	|	#(op7:DIV a = exprExe b = exprExe)
		{
			if (b.compareTo(new BigDecimal("0")) != 0){
				rValue = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
			} else {
				rValue = a;
			}
  		}
	|	#(op8:DIV_CN a = exprExe b = exprExe)
		{
			if (b.compareTo(new BigDecimal("0")) != 0){
  				rValue = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
			} else {
				rValue = a;
			}
  				
		}
		
	|	e1:VAR_ELEMENT
		{
  			rValue = getResultByElemName(e1.getText());
  		}
  	|	ne1:NUMBER_ELEMENT
  		{
  			rValue = getResultByElemName(ne1.getText());
  		}
  	|	ne2:NEGATIVE_NUMBER_ELEMENT
  		{
  			rValue = getResultByElemName(ne2.getText());
  		}
	;

exe_parameters1 returns [double rValue]
{
	rValue = 0;
}
	:	e1:VAR_ELEMENT
		{
  			rValue = getResultByElemName(e1.getText()).doubleValue();
  		}
  	|	ne1:NUMBER_ELEMENT
  		{
  			rValue = getResultByElemName(ne1.getText()).doubleValue();
  		}
  	|	ne2:NEGATIVE_NUMBER_ELEMENT
  		{
  			rValue = getResultByElemName(ne2.getText()).doubleValue();
  		}
	;

exe_parameters2 returns [double[] rValueArr]
{
	rValueArr = new double[2];
	double p1, p2;
}
	:	#(COMMA p1 = exe_parameters1 p2 = exe_parameters1)
		{
			rValueArr[0] = p1;
			rValueArr[1] = p2;
		}
	;

////////////////////////////////////////////////////
const_function
	:	PI_CN	|	PI_EN
	|	E_CN	|	E_EN
	;

empty_function
	:	RANDOM_CN	|	RANDOM_EN
	;

arithmetic_function1
	:	ABS_CN			|	ABS_EN
	|	ACOS_CN			|	ACOS_EN
	|	ASIN_CN			|	ASIN_EN
	|	ATAN_CN			|	ATAN_EN
	|	CEIL_CN			|	CEIL_EN
	|	COS_CN			|	COS_EN
	|	EXP_CN			|	EXP_EN
	|	FLOOR_CN 		|	FLOOR_EN
	|	LOG_CN			|	LOG_EN
	|	RINT_CN			|	RINT_EN
	|	ROUND_CN		|	ROUND_EN
	|	SIN_CN			|	SIN_EN
	|	SQRT_CN			|	SQRT_EN
	|	TAN_CN			|	TAN_EN
	|	DEGREES_CN		|	DEGREES_EN
	|	RADIANS_CN		|	RADIANS_EN
	;

arithmetic_function2
	:	ATAN2_CN		|	ATAN2_EN
	|	MAX_CN			|	MAX_EN
	|	MIN_CN			|	MIN_EN
	|	POW_CN			|	POW_EN
	|	REMAINDER_CN	|	REMAINDER_EN
	;
