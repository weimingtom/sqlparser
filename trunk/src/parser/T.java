// $ANTLR 2.7.7 (2006-11-01): "src/parser/parser.g" -> "T.java"$

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

import java.util.*;

import translator.model.*;


public class T extends antlr.TreeParser       implements PTokenTypes
 {

	Map tables=new HashMap();
	
	public DbTable[] getTables() {
		int i=0;
		DbTable[] ret=new DbTable[tables.size()];
		for (Iterator it=tables.values().iterator(); it.hasNext();)
			ret[i++]=(DbTable)it.next();
		return ret;
	}
	
	private DbTable addTableByChName(String chName) {
		DbTable table=(DbTable)tables.get(chName);
		if (table==null) {
			table=new DbTable();
			table.setChName(chName);
			tables.put(chName, table);
		}
		return table;
	}
public T() {
	tokenNames = _tokenNames;
}

	public final QueryModel  statement(AST _t) throws RecognitionException {
		QueryModel model;
		
		AST statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String clist, tlist, t1, t2, into, m, e; model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_UNION:
			{
				AST __t74 = _t;
				AST tmp1_AST_in = (AST)_t;
				match(_t,TABLE_UNION);
				_t = _t.getFirstChild();
				t1=tableName(_t);
				_t = _retTree;
				t2=tableName(_t);
				_t = _retTree;
				into=tableName(_t);
				_t = _retTree;
				_t = __t74;
				_t = _t.getNextSibling();
				model=new UnionModel(t1, t2, into);
				break;
			}
			case TABLE_COMPARE:
			{
				AST __t75 = _t;
				AST tmp2_AST_in = (AST)_t;
				match(_t,TABLE_COMPARE);
				_t = _t.getFirstChild();
				t1=tableName(_t);
				_t = _retTree;
				t2=tableName(_t);
				_t = _retTree;
				into=tableName(_t);
				_t = _retTree;
				m=method(_t);
				_t = _retTree;
				e=equations(_t);
				_t = _retTree;
				_t = __t75;
				_t = _t.getNextSibling();
				model=new ComapreModel(t1, t2, into, m, e);
				break;
			}
			case TABLE_SELECT:
			{
				AST __t76 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,TABLE_SELECT);
				_t = _t.getFirstChild();
				clist=columnList(_t);
				_t = _retTree;
				tlist=tableList(_t);
				_t = _retTree;
				e=equations(_t);
				_t = _retTree;
				_t = __t76;
				_t = _t.getNextSibling();
				model=new SelectModel(clist, tlist, e);
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
		return model;
	}
	
	public final String  tableName(AST _t) throws RecognitionException {
		String tableStr;
		
		AST tableName_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST t = null;
		tableStr="";
		
		try {      // for error handling
			t = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			
						tableStr=t.getText();
						addTableByChName(tableStr);
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return tableStr;
	}
	
	public final String  method(AST _t) throws RecognitionException {
		String m;
		
		AST method_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		m="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EXIST:
			{
				AST tmp4_AST_in = (AST)_t;
				match(_t,EXIST);
				_t = _t.getNextSibling();
				m="EXIST";
				break;
			}
			case NOT_EXIST:
			{
				AST tmp5_AST_in = (AST)_t;
				match(_t,NOT_EXIST);
				_t = _t.getNextSibling();
				m="NOT_EXIST";
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
		return m;
	}
	
	public final String  equations(AST _t) throws RecognitionException {
		String equStr;
		
		AST equations_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST lop = null;
		AST op = null;
		String e1, e2; equStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LOGIC_OP:
			{
				AST __t83 = _t;
				lop = _t==ASTNULL ? null :(AST)_t;
				match(_t,LOGIC_OP);
				_t = _t.getFirstChild();
				e1=equations(_t);
				_t = _retTree;
				e2=equations(_t);
				_t = _retTree;
				_t = __t83;
				_t = _t.getNextSibling();
				equStr=e1+" "+lop+" "+e2;
				break;
			}
			case COMPARATOR:
			{
				AST __t84 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,COMPARATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t84;
				_t = _t.getNextSibling();
				equStr=e1+" "+op.getText()+" "+e2;
				break;
			}
			case LPAREN:
			{
				AST tmp6_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e1=equations(_t);
				_t = _retTree;
				AST tmp7_AST_in = (AST)_t;
				match(_t,EQU_RPAREN);
				_t = _t.getNextSibling();
				equStr="("+e1+")";
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
		return equStr;
	}
	
	public final String  columnList(AST _t) throws RecognitionException {
		String clist;
		
		AST columnList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST fn = null;
		String elem, args="", c1, c2; clist="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t79 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				c1=columnList(_t);
				_t = _retTree;
				c2=columnList(_t);
				_t = _retTree;
				_t = __t79;
				_t = _t.getNextSibling();
				clist=c1+","+c2;
				break;
			}
			case STAR:
			case LPAREN:
			case OPERATOR:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				elem=equElem(_t);
				_t = _retTree;
				clist=elem;
				break;
			}
			case FUNC_NAME:
			{
				fn = (AST)_t;
				match(_t,FUNC_NAME);
				_t = _t.getNextSibling();
				args=equElem(_t);
				_t = _retTree;
				clist=fn.getText()+"("+args+")";
				break;
			}
			case ALL_FIELDS:
			{
				AST tmp9_AST_in = (AST)_t;
				match(_t,ALL_FIELDS);
				_t = _t.getNextSibling();
				clist="*";
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
		return clist;
	}
	
	public final String  tableList(AST _t) throws RecognitionException {
		String tlist;
		
		AST tableList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String t1, t2; tlist="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t81 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				t1=tableList(_t);
				_t = _retTree;
				t2=tableList(_t);
				_t = _retTree;
				_t = __t81;
				_t = _t.getNextSibling();
				tlist=t1+","+t2;
				break;
			}
			case ID:
			{
				t1=tableName(_t);
				_t = _retTree;
				tlist=t1;
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
		return tlist;
	}
	
	public final String  equElem(AST _t) throws RecognitionException {
		String equElemStr;
		
		AST equElem_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST star = null;
		AST n = null;
		AST s = null;
		String e1, e2, f; equElemStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPERATOR:
			{
				AST __t86 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,OPERATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t86;
				_t = _t.getNextSibling();
				equElemStr=e1+" "+op.getText()+" "+e2;
				break;
			}
			case STAR:
			{
				AST __t87 = _t;
				star = _t==ASTNULL ? null :(AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t87;
				_t = _t.getNextSibling();
				equElemStr=e1+" "+star.getText()+" "+e2;
				break;
			}
			case LPAREN:
			{
				AST tmp11_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e1=equElem(_t);
				_t = _retTree;
				AST tmp12_AST_in = (AST)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				equElemStr="("+e1+")";
				break;
			}
			case POINT:
			{
				f=fieldName(_t);
				_t = _retTree;
				equElemStr=f;
				break;
			}
			case REAL_NUM:
			{
				n = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				equElemStr=n.getText();
				break;
			}
			case QUOTED_STRING:
			{
				s = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				equElemStr=s.getText();
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
		return equElemStr;
	}
	
	public final String  fieldName(AST _t) throws RecognitionException {
		String fieldStr;
		
		AST fieldName_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST f1 = null;
		AST f2 = null;
		fieldStr="";
		
		try {      // for error handling
			AST __t90 = _t;
			AST tmp13_AST_in = (AST)_t;
			match(_t,POINT);
			_t = _t.getFirstChild();
			f1 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			f2 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			_t = __t90;
			_t = _t.getNextSibling();
			
						String t=f1.getText();
						String f=f2.getText();
						fieldStr=t+"."+f;
						DbTable table=addTableByChName(t);
						table.addDbField(f, null);
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return fieldStr;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"ALL_FIELDS",
		"\"equation start\"",
		"SEMI",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"WHERE",
		"TABLE_SELECT",
		"FROM",
		"STAR",
		"FUNC_NAME",
		"LPAREN",
		"RPAREN",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"COMPARATOR",
		"ID",
		"OPERATOR",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"WS",
		"ALL",
		"DISTINCT",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"EQU_RPAREN"
	};
	
	}
	
