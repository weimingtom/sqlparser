// $ANTLR 2.7.7 (2006-11-01): "src/parser/expression.g" -> "ExpressionTreeParser.java"$

	package parser;

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

	import java.math.BigDecimal;
	import model.parser.*;
	import java.util.*;


public class ExpressionTreeParser extends antlr.TreeParser       implements ExpressionParserTokenTypes
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

public ExpressionTreeParser() {
	tokenNames = _tokenNames;
}

	public final String  expr(AST _t) throws RecognitionException {
		String r;
		
		AST expr_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST e1 = null;
		AST e2 = null;
		AST nsign = null;
		AST e3 = null;
		
				r = "";
			  	String a, b, e;
			
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LPAREN:
			{
				AST tmp1_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e=expr(_t);
				_t = _retTree;
				AST tmp2_AST_in = (AST)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				
						r = "(" + e + ")";
					
				break;
			}
			case PLUS:
			{
				AST __t44 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t44;
				_t = _t.getNextSibling();
				
						r = a + "+" + b;
					
				break;
			}
			case MINUS:
			{
				AST __t45 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t45;
				_t = _t.getNextSibling();
				
						r = a + "-" + b;
					
				break;
			}
			case MUL:
			{
				AST __t46 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,MUL);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t46;
				_t = _t.getNextSibling();
				
						r = a + "*" + b;
					
				break;
			}
			case DIV:
			{
				AST __t47 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t47;
				_t = _t.getNextSibling();
				
						r = a + "/" + b; 
					
				break;
			}
			case MOD:
			{
				AST __t48 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,MOD);
				_t = _t.getFirstChild();
				a=expr(_t);
				_t = _retTree;
				b=expr(_t);
				_t = _retTree;
				_t = __t48;
				_t = _t.getNextSibling();
				
						r = a + "%" + b;
					
				break;
			}
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
						r = e1.getText();
						addExprElemModel(r, false);
					
				break;
			}
			case DIGIT_ELEMENT:
			{
				e2 = (AST)_t;
				match(_t,DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				
						r = e2.getText();
						addExprElemModel(r, true);
					
				break;
			}
			case 14:
			{
				nsign = _t==ASTNULL ? null : (AST)_t;
				negative_sign(_t);
				_t = _retTree;
				e3 = (AST)_t;
				match(_t,DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				
						r = "-" + e3.getText();
						addExprElemModel(r, true);
					
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
		return r;
	}
	
	public final void negative_sign(AST _t) throws RecognitionException {
		
		AST negative_sign_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			AST tmp8_AST_in = (AST)_t;
			match(_t,14);
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final BigDecimal  exprExe(AST _t) throws RecognitionException {
		BigDecimal r;
		
		AST exprExe_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST e1 = null;
		AST e2 = null;
		AST nsign = null;
		AST e3 = null;
		
				r = new BigDecimal(0);
			  	BigDecimal a, b, e;
			
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LPAREN:
			{
				AST tmp9_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e=exprExe(_t);
				_t = _retTree;
				AST tmp10_AST_in = (AST)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				
						r = e;
					
				break;
			}
			case PLUS:
			{
				AST __t50 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t50;
				_t = _t.getNextSibling();
				
						r = a.add(b);
					
				break;
			}
			case MINUS:
			{
				AST __t51 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t51;
				_t = _t.getNextSibling();
				
						r = a.subtract(b);
					
				break;
			}
			case MUL:
			{
				AST __t52 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,MUL);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t52;
				_t = _t.getNextSibling();
				
						r = a.multiply(b);
					
				break;
			}
			case DIV:
			{
				AST __t53 = _t;
				AST tmp14_AST_in = (AST)_t;
				match(_t,DIV);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t53;
				_t = _t.getNextSibling();
				
						if (b.compareTo(new BigDecimal("0")) != 0)
							r = a.divide(b, 2, BigDecimal.ROUND_DOWN); 
						else
							r = a;
					
				break;
			}
			case MOD:
			{
				AST __t54 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,MOD);
				_t = _t.getFirstChild();
				a=exprExe(_t);
				_t = _retTree;
				b=exprExe(_t);
				_t = _retTree;
				_t = __t54;
				_t = _t.getNextSibling();
				
						//r = a % b;
					
				break;
			}
			case VAR_ELEMENT:
			{
				e1 = (AST)_t;
				match(_t,VAR_ELEMENT);
				_t = _t.getNextSibling();
				
						r = getResultByElemName(e1.getText());
					
				break;
			}
			case DIGIT_ELEMENT:
			{
				e2 = (AST)_t;
				match(_t,DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				
						r = getResultByElemName(e2.getText());
					
				break;
			}
			case 14:
			{
				nsign = _t==ASTNULL ? null : (AST)_t;
				negative_sign(_t);
				_t = _retTree;
				e3 = (AST)_t;
				match(_t,DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				
						r = getResultByElemName("-" + e3.getText());
					
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
		return r;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"PLUS",
		"MINUS",
		"MUL",
		"DIV",
		"MOD",
		"POW",
		"VAR_ELEMENT",
		"DIGIT_ELEMENT",
		"LPAREN",
		"RPAREN",
		"\"-\"",
		"POINT",
		"SEMI",
		"WS",
		"ELEM_START_LETTER",
		"ELEM_LETTER",
		"DIGIT_START",
		"DIGIT_NEXT",
		"DIGIT_START_LETTER",
		"DIGIT_LETTER"
	};
	
	}
	
