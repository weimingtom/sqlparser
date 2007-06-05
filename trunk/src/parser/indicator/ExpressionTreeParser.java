// $ANTLR 2.7.7 (2006-11-01): "src/parser/indicator/expression.g" -> "ExpressionTreeParser.java"$

	package parser.indicator;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

	import model.parser.*;
	
	import java.util.*;
	import java.math.BigDecimal;
	
	import java.lang.Math;
	import java.lang.reflect.Field;
	import java.lang.reflect.Method;
	import java.lang.reflect.InvocationTargetException;


public class ExpressionTreeParser extends antlr.TreeParser       implements ExpressionParserTokenTypes
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
  	
public ExpressionTreeParser() {
	tokenNames = _tokenNames;
}

	public final String  expr(AST _t) throws RecognitionException {
		String rValue;
		
		AST expr_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST fun0 = null;
		AST fun1 = null;
		AST fun2 = null;
		AST fun3 = null;
		AST op1 = null;
		AST op2 = null;
		AST op3 = null;
		AST op4 = null;
		AST op5 = null;
		AST op6 = null;
		AST op7 = null;
		AST op8 = null;
		AST e1 = null;
		AST ne1 = null;
		AST ne2 = null;
		
			rValue = "";
			String a, b;
			String p1, p2;
			String e;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EXPRESSION_BLOCK:
			{
				AST __t52 = _t;
				AST tmp1_AST_in = (AST)_t;
				match(_t,EXPRESSION_BLOCK);
				_t = _t.getFirstChild();
				e=expr(_t);
				_t = _retTree;
				_t = __t52;
				_t = _t.getNextSibling();
				
							rValue = "(" + e + ")";
						
				break;
			}
			case CONST_FUNCTION_TOKEN:
			{
				AST __t53 = _t;
				AST tmp2_AST_in = (AST)_t;
				match(_t,CONST_FUNCTION_TOKEN);
				_t = _t.getFirstChild();
				fun0 = _t==ASTNULL ? null : (AST)_t;
				const_function(_t);
				_t = _retTree;
				_t = __t53;
				_t = _t.getNextSibling();
				
							rValue = fun0.getText();
						
				break;
			}
			case EMPTY_FUNCTION_TOKEN:
			{
				AST __t54 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,EMPTY_FUNCTION_TOKEN);
				_t = _t.getFirstChild();
				fun1 = _t==ASTNULL ? null : (AST)_t;
				empty_function(_t);
				_t = _retTree;
				_t = __t54;
				_t = _t.getNextSibling();
				
							rValue = fun1.getText() + "(" + ")";
						
				break;
			}
			case ARITHMETIC_FUNCTION1_TOKEN:
			{
				AST __t55 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,ARITHMETIC_FUNCTION1_TOKEN);
				_t = _t.getFirstChild();
				fun2 = _t==ASTNULL ? null : (AST)_t;
				arithmetic_function1(_t);
				_t = _retTree;
				p1=parameters1(_t);
				_t = _retTree;
				_t = __t55;
				_t = _t.getNextSibling();
				
							rValue = fun2.getText() + "(" + p1 + ")";
						
				break;
			}
			case ARITHMETIC_FUNCTION2_TOKEN:
			{
				AST __t56 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,ARITHMETIC_FUNCTION2_TOKEN);
				_t = _t.getFirstChild();
				fun3 = _t==ASTNULL ? null : (AST)_t;
				arithmetic_function2(_t);
				_t = _retTree;
				p2=parameters2(_t);
				_t = _retTree;
				_t = __t56;
				_t = _t.getNextSibling();
				
							rValue = fun3.getText() + "(" + p2 + ")";
						
				break;
			}
			case PLUS:
			{
				AST __t57 = _t;
				op1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t57;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op1 + " " + b;
						
				break;
			}
			case PLUS_CN:
			{
				AST __t58 = _t;
				op2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,PLUS_CN);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t58;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op2 + " " + b;
						
				break;
			}
			case MINUS:
			{
				AST __t59 = _t;
				op3 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t59;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op3 + " " + b;
						
				break;
			}
			case MINUS_CN:
			{
				AST __t60 = _t;
				op4 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MINUS_CN);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t60;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op4 + " " + b;
						
				break;
			}
			case MUL:
			{
				AST __t61 = _t;
				op5 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MUL);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t61;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op5 + " " + b;
						
				break;
			}
			case MUL_CN:
			{
				AST __t62 = _t;
				op6 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MUL_CN);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t62;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op6 + " " + b;
						
				break;
			}
			case DIV:
			{
				AST __t63 = _t;
				op7 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t63;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op7 + " " + b;
						
				break;
			}
			case DIV_CN:
			{
				AST __t64 = _t;
				op8 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DIV_CN);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t64;
				_t = _t.getNextSibling();
				
							rValue = a + " " + op8 + " " + b;
						
				break;
			}
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = e1.getText();
							addExprElemModel(rValue, false);
						
				break;
			}
			case NUMBER_ELEMENT:
			{
				ne1 = (AST)_t;
				match(_t,NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = ne1.getText();
							addExprElemModel(rValue, true);
						
				break;
			}
			case NEGATIVE_NUMBER_ELEMENT:
			{
				ne2 = (AST)_t;
				match(_t,NEGATIVE_NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = ne2.getText();
							addExprElemModel(rValue, true);
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValue;
	}
	
	public final void const_function(AST _t) throws RecognitionException {
		
		AST const_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PI_CN:
			{
				AST tmp6_AST_in = (AST)_t;
				match(_t,PI_CN);
				_t = _t.getNextSibling();
				break;
			}
			case PI_EN:
			{
				AST tmp7_AST_in = (AST)_t;
				match(_t,PI_EN);
				_t = _t.getNextSibling();
				break;
			}
			case E_CN:
			{
				AST tmp8_AST_in = (AST)_t;
				match(_t,E_CN);
				_t = _t.getNextSibling();
				break;
			}
			case E_EN:
			{
				AST tmp9_AST_in = (AST)_t;
				match(_t,E_EN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void empty_function(AST _t) throws RecognitionException {
		
		AST empty_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case RANDOM_CN:
			{
				AST tmp10_AST_in = (AST)_t;
				match(_t,RANDOM_CN);
				_t = _t.getNextSibling();
				break;
			}
			case RANDOM_EN:
			{
				AST tmp11_AST_in = (AST)_t;
				match(_t,RANDOM_EN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void arithmetic_function1(AST _t) throws RecognitionException {
		
		AST arithmetic_function1_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ABS_CN:
			{
				AST tmp12_AST_in = (AST)_t;
				match(_t,ABS_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ABS_EN:
			{
				AST tmp13_AST_in = (AST)_t;
				match(_t,ABS_EN);
				_t = _t.getNextSibling();
				break;
			}
			case ACOS_CN:
			{
				AST tmp14_AST_in = (AST)_t;
				match(_t,ACOS_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ACOS_EN:
			{
				AST tmp15_AST_in = (AST)_t;
				match(_t,ACOS_EN);
				_t = _t.getNextSibling();
				break;
			}
			case ASIN_CN:
			{
				AST tmp16_AST_in = (AST)_t;
				match(_t,ASIN_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ASIN_EN:
			{
				AST tmp17_AST_in = (AST)_t;
				match(_t,ASIN_EN);
				_t = _t.getNextSibling();
				break;
			}
			case ATAN_CN:
			{
				AST tmp18_AST_in = (AST)_t;
				match(_t,ATAN_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ATAN_EN:
			{
				AST tmp19_AST_in = (AST)_t;
				match(_t,ATAN_EN);
				_t = _t.getNextSibling();
				break;
			}
			case CEIL_CN:
			{
				AST tmp20_AST_in = (AST)_t;
				match(_t,CEIL_CN);
				_t = _t.getNextSibling();
				break;
			}
			case CEIL_EN:
			{
				AST tmp21_AST_in = (AST)_t;
				match(_t,CEIL_EN);
				_t = _t.getNextSibling();
				break;
			}
			case COS_CN:
			{
				AST tmp22_AST_in = (AST)_t;
				match(_t,COS_CN);
				_t = _t.getNextSibling();
				break;
			}
			case COS_EN:
			{
				AST tmp23_AST_in = (AST)_t;
				match(_t,COS_EN);
				_t = _t.getNextSibling();
				break;
			}
			case EXP_CN:
			{
				AST tmp24_AST_in = (AST)_t;
				match(_t,EXP_CN);
				_t = _t.getNextSibling();
				break;
			}
			case EXP_EN:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,EXP_EN);
				_t = _t.getNextSibling();
				break;
			}
			case FLOOR_CN:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,FLOOR_CN);
				_t = _t.getNextSibling();
				break;
			}
			case FLOOR_EN:
			{
				AST tmp27_AST_in = (AST)_t;
				match(_t,FLOOR_EN);
				_t = _t.getNextSibling();
				break;
			}
			case LOG_CN:
			{
				AST tmp28_AST_in = (AST)_t;
				match(_t,LOG_CN);
				_t = _t.getNextSibling();
				break;
			}
			case LOG_EN:
			{
				AST tmp29_AST_in = (AST)_t;
				match(_t,LOG_EN);
				_t = _t.getNextSibling();
				break;
			}
			case RINT_CN:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,RINT_CN);
				_t = _t.getNextSibling();
				break;
			}
			case RINT_EN:
			{
				AST tmp31_AST_in = (AST)_t;
				match(_t,RINT_EN);
				_t = _t.getNextSibling();
				break;
			}
			case ROUND_CN:
			{
				AST tmp32_AST_in = (AST)_t;
				match(_t,ROUND_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ROUND_EN:
			{
				AST tmp33_AST_in = (AST)_t;
				match(_t,ROUND_EN);
				_t = _t.getNextSibling();
				break;
			}
			case SIN_CN:
			{
				AST tmp34_AST_in = (AST)_t;
				match(_t,SIN_CN);
				_t = _t.getNextSibling();
				break;
			}
			case SIN_EN:
			{
				AST tmp35_AST_in = (AST)_t;
				match(_t,SIN_EN);
				_t = _t.getNextSibling();
				break;
			}
			case SQRT_CN:
			{
				AST tmp36_AST_in = (AST)_t;
				match(_t,SQRT_CN);
				_t = _t.getNextSibling();
				break;
			}
			case SQRT_EN:
			{
				AST tmp37_AST_in = (AST)_t;
				match(_t,SQRT_EN);
				_t = _t.getNextSibling();
				break;
			}
			case TAN_CN:
			{
				AST tmp38_AST_in = (AST)_t;
				match(_t,TAN_CN);
				_t = _t.getNextSibling();
				break;
			}
			case TAN_EN:
			{
				AST tmp39_AST_in = (AST)_t;
				match(_t,TAN_EN);
				_t = _t.getNextSibling();
				break;
			}
			case DEGREES_CN:
			{
				AST tmp40_AST_in = (AST)_t;
				match(_t,DEGREES_CN);
				_t = _t.getNextSibling();
				break;
			}
			case DEGREES_EN:
			{
				AST tmp41_AST_in = (AST)_t;
				match(_t,DEGREES_EN);
				_t = _t.getNextSibling();
				break;
			}
			case RADIANS_CN:
			{
				AST tmp42_AST_in = (AST)_t;
				match(_t,RADIANS_CN);
				_t = _t.getNextSibling();
				break;
			}
			case RADIANS_EN:
			{
				AST tmp43_AST_in = (AST)_t;
				match(_t,RADIANS_EN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final String  parameters1(AST _t) throws RecognitionException {
		String rValue;
		
		AST parameters1_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST e1 = null;
		AST ne1 = null;
		AST ne2 = null;
		
			rValue = "";
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = e1.getText();
							addExprElemModel(rValue, false);
						
				break;
			}
			case NUMBER_ELEMENT:
			{
				ne1 = (AST)_t;
				match(_t,NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = ne1.getText();
							addExprElemModel(rValue, true);
						
				break;
			}
			case NEGATIVE_NUMBER_ELEMENT:
			{
				ne2 = (AST)_t;
				match(_t,NEGATIVE_NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = ne2.getText();
							addExprElemModel(rValue, true);
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValue;
	}
	
	public final void arithmetic_function2(AST _t) throws RecognitionException {
		
		AST arithmetic_function2_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ATAN2_CN:
			{
				AST tmp44_AST_in = (AST)_t;
				match(_t,ATAN2_CN);
				_t = _t.getNextSibling();
				break;
			}
			case ATAN2_EN:
			{
				AST tmp45_AST_in = (AST)_t;
				match(_t,ATAN2_EN);
				_t = _t.getNextSibling();
				break;
			}
			case MAX_CN:
			{
				AST tmp46_AST_in = (AST)_t;
				match(_t,MAX_CN);
				_t = _t.getNextSibling();
				break;
			}
			case MAX_EN:
			{
				AST tmp47_AST_in = (AST)_t;
				match(_t,MAX_EN);
				_t = _t.getNextSibling();
				break;
			}
			case MIN_CN:
			{
				AST tmp48_AST_in = (AST)_t;
				match(_t,MIN_CN);
				_t = _t.getNextSibling();
				break;
			}
			case MIN_EN:
			{
				AST tmp49_AST_in = (AST)_t;
				match(_t,MIN_EN);
				_t = _t.getNextSibling();
				break;
			}
			case POW_CN:
			{
				AST tmp50_AST_in = (AST)_t;
				match(_t,POW_CN);
				_t = _t.getNextSibling();
				break;
			}
			case POW_EN:
			{
				AST tmp51_AST_in = (AST)_t;
				match(_t,POW_EN);
				_t = _t.getNextSibling();
				break;
			}
			case REMAINDER_CN:
			{
				AST tmp52_AST_in = (AST)_t;
				match(_t,REMAINDER_CN);
				_t = _t.getNextSibling();
				break;
			}
			case REMAINDER_EN:
			{
				AST tmp53_AST_in = (AST)_t;
				match(_t,REMAINDER_EN);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final String  parameters2(AST _t) throws RecognitionException {
		String rValue;
		
		AST parameters2_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			rValue = "";
			String p1, p2;
		
		
		try {      // for error handling
			AST __t67 = _t;
			AST tmp54_AST_in = (AST)_t;
			match(_t,COMMA);
			_t = _t.getFirstChild();
			p1=parameters1(_t);
			_t = _retTree;
			p2=parameters1(_t);
			_t = _retTree;
			_t = __t67;
			_t = _t.getNextSibling();
			
						rValue = p1 + ", " + p2;
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValue;
	}
	
	public final BigDecimal  exprExe(AST _t) throws RecognitionException {
		BigDecimal rValue;
		
		AST exprExe_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST fun0 = null;
		AST fun1 = null;
		AST fun2 = null;
		AST fun3 = null;
		AST op1 = null;
		AST op2 = null;
		AST op3 = null;
		AST op4 = null;
		AST op5 = null;
		AST op6 = null;
		AST op7 = null;
		AST op8 = null;
		AST e1 = null;
		AST ne1 = null;
		AST ne2 = null;
		
			rValue = new BigDecimal(0);
			BigDecimal a, b;
			BigDecimal e;
			double p1;
			double[] p2;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EXPRESSION_BLOCK:
			{
				AST __t69 = _t;
				AST tmp55_AST_in = (AST)_t;
				match(_t,EXPRESSION_BLOCK);
				_t = _t.getFirstChild();
				e=exprExe(_t);
				_t = _retTree;
				_t = __t69;
				_t = _t.getNextSibling();
				
							rValue = e;
						
				break;
			}
			case CONST_FUNCTION_TOKEN:
			{
				AST __t70 = _t;
				AST tmp56_AST_in = (AST)_t;
				match(_t,CONST_FUNCTION_TOKEN);
				_t = _t.getFirstChild();
				fun0 = _t==ASTNULL ? null : (AST)_t;
				const_function(_t);
				_t = _retTree;
				_t = __t70;
				_t = _t.getNextSibling();
				
							rValue = getResultByClassField(fun0.getText());
						
				break;
			}
			case EMPTY_FUNCTION_TOKEN:
			{
				AST __t71 = _t;
				AST tmp57_AST_in = (AST)_t;
				match(_t,EMPTY_FUNCTION_TOKEN);
				_t = _t.getFirstChild();
				fun1 = _t==ASTNULL ? null : (AST)_t;
				empty_function(_t);
				_t = _retTree;
				_t = __t71;
				_t = _t.getNextSibling();
				
							rValue = getResultByFunction(fun1.getText());
						
				break;
			}
			case ARITHMETIC_FUNCTION1_TOKEN:
			{
				AST __t72 = _t;
				AST tmp58_AST_in = (AST)_t;
				match(_t,ARITHMETIC_FUNCTION1_TOKEN);
				_t = _t.getFirstChild();
				fun2 = _t==ASTNULL ? null : (AST)_t;
				arithmetic_function1(_t);
				_t = _retTree;
				p1=exe_parameters1(_t);
				_t = _retTree;
				_t = __t72;
				_t = _t.getNextSibling();
				
							rValue = getResultByFunction(fun2.getText(), p1);
						
				break;
			}
			case ARITHMETIC_FUNCTION2_TOKEN:
			{
				AST __t73 = _t;
				AST tmp59_AST_in = (AST)_t;
				match(_t,ARITHMETIC_FUNCTION2_TOKEN);
				_t = _t.getFirstChild();
				fun3 = _t==ASTNULL ? null : (AST)_t;
				arithmetic_function2(_t);
				_t = _retTree;
				p2=exe_parameters2(_t);
				_t = _retTree;
				_t = __t73;
				_t = _t.getNextSibling();
				
							rValue = getResultByFunction(fun3.getText(), p2);
						
				break;
			}
			case PLUS:
			{
				AST __t74 = _t;
				op1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t74;
				_t = _t.getNextSibling();
				
							rValue = a.add(b);
						
				break;
			}
			case PLUS_CN:
			{
				AST __t75 = _t;
				op2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,PLUS_CN);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t75;
				_t = _t.getNextSibling();
				
							rValue = a.add(b);
						
				break;
			}
			case MINUS:
			{
				AST __t76 = _t;
				op3 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t76;
				_t = _t.getNextSibling();
				
							rValue = a.subtract(b);
						
				break;
			}
			case MINUS_CN:
			{
				AST __t77 = _t;
				op4 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MINUS_CN);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t77;
				_t = _t.getNextSibling();
				
							rValue = a.subtract(b);
						
				break;
			}
			case MUL:
			{
				AST __t78 = _t;
				op5 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MUL);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t78;
				_t = _t.getNextSibling();
				
							rValue = a.multiply(b);
						
				break;
			}
			case MUL_CN:
			{
				AST __t79 = _t;
				op6 = _t==ASTNULL ? null :(AST)_t;
				match(_t,MUL_CN);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t79;
				_t = _t.getNextSibling();
				
							rValue = a.multiply(b);
						
				break;
			}
			case DIV:
			{
				AST __t80 = _t;
				op7 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t80;
				_t = _t.getNextSibling();
				
							if (b.compareTo(new BigDecimal("0")) != 0){
								rValue = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
							} else {
								rValue = a;
							}
						
				break;
			}
			case DIV_CN:
			{
				AST __t81 = _t;
				op8 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DIV_CN);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t81;
				_t = _t.getNextSibling();
				
							if (b.compareTo(new BigDecimal("0")) != 0){
								rValue = a.divide(b, 2, BigDecimal.ROUND_HALF_UP);
							} else {
								rValue = a;
							}
								
						
				break;
			}
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(e1.getText());
						
				break;
			}
			case NUMBER_ELEMENT:
			{
				ne1 = (AST)_t;
				match(_t,NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(ne1.getText());
						
				break;
			}
			case NEGATIVE_NUMBER_ELEMENT:
			{
				ne2 = (AST)_t;
				match(_t,NEGATIVE_NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(ne2.getText());
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValue;
	}
	
	public final double  exe_parameters1(AST _t) throws RecognitionException {
		double rValue;
		
		AST exe_parameters1_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST e1 = null;
		AST ne1 = null;
		AST ne2 = null;
		
			rValue = 0;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(e1.getText()).doubleValue();
						
				break;
			}
			case NUMBER_ELEMENT:
			{
				ne1 = (AST)_t;
				match(_t,NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(ne1.getText()).doubleValue();
						
				break;
			}
			case NEGATIVE_NUMBER_ELEMENT:
			{
				ne2 = (AST)_t;
				match(_t,NEGATIVE_NUMBER_ELEMENT);
				_t = _t.getNextSibling();
				
							rValue = getResultByElemName(ne2.getText()).doubleValue();
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValue;
	}
	
	public final double[]  exe_parameters2(AST _t) throws RecognitionException {
		double[] rValueArr;
		
		AST exe_parameters2_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			rValueArr = new double[2];
			double p1, p2;
		
		
		try {      // for error handling
			AST __t84 = _t;
			AST tmp60_AST_in = (AST)_t;
			match(_t,COMMA);
			_t = _t.getFirstChild();
			p1=exe_parameters1(_t);
			_t = _retTree;
			p2=exe_parameters1(_t);
			_t = _retTree;
			_t = __t84;
			_t = _t.getNextSibling();
			
						rValueArr[0] = p1;
						rValueArr[1] = p2;
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return rValueArr;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"EXPRESSION_BLOCK",
		"CONST_FUNCTION_TOKEN",
		"EMPTY_FUNCTION_TOKEN",
		"ARITHMETIC_FUNCTION1_TOKEN",
		"ARITHMETIC_FUNCTION2_TOKEN",
		"MINUS_TOKEN",
		"PLUS",
		"\"\\u52a0\"",
		"MINUS",
		"\"\\u51cf\"",
		"MUL",
		"\"\\u4e58\"",
		"DIV",
		"LPAREN",
		"RPAREN",
		"NEGATIVE_NUMBER_ELEMENT",
		"NUMBER_ELEMENT",
		"VAR_ELEMENT",
		"COMMA",
		"\"\\u6c42\\u5706\\u5468\\u7387\"",
		"\"PI\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\\u5e95\\u6570\"",
		"\"E\"",
		"\"\\u53d6\\u968f\\u673a\\u6570\"",
		"\"random\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"abs\"",
		"\"\\u6c42\\u53cd\\u4f59\\u5f26\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5f26\\u503c\"",
		"\"asin\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atan\"",
		"\"\\u53d6\\u4e0a\\u9650\\u6574\\u6570\"",
		"\"ceil\"",
		"\"\\u6c42\\u4f59\\u5f26\\u503c\"",
		"\"cos\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"exp\"",
		"\"\\u53d6\\u4e0b\\u9650\\u6574\\u6570\"",
		"\"floor\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log\"",
		"\"\\u53d6\\u6574\"",
		"\"rint\"",
		"\"\\u56db\\u820d\\u4e94\\u5165\"",
		"\"round\"",
		"\"\\u6c42\\u6b63\\u5f26\\u503c\"",
		"\"sin\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"sqrt\"",
		"\"\\u6c42\\u6b63\\u5207\\u503c\"",
		"\"tan\"",
		"\"\\u5f27\\u5ea6\\u8f6c\\u5ea6\\u6570\"",
		"\"toDegrees\"",
		"\"\\u5ea6\\u6570\\u8f6c\\u5f27\\u5ea6\"",
		"\"toRadians\"",
		"\"\\u6c42\\u4e8c\\u4e2a\\u6570\\u7684\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atan2\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u5e42\"",
		"\"pow\"",
		"\"\\u6c42\\u4f59\"",
		"\"IEEEremainder\"",
		"\"\\u9664\"",
		"POINT",
		"ELEM_START_LETTER",
		"ELEM_LETTER",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"SEMI",
		"WS",
		"ML_COMMENT"
	};
	
	}
	
