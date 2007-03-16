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

	public final String  segment(AST _t) throws RecognitionException {
		String segment;
		
		AST segment_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String str; segment="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_SELECT:
			{
				AST tmp1_AST_in = (AST)_t;
				match(_t,TABLE_SELECT);
				_t = _t.getNextSibling();
				segment=columnList(_t);
				_t = _retTree;
				break;
			}
			case FROM:
			{
				AST tmp2_AST_in = (AST)_t;
				match(_t,FROM);
				_t = _t.getNextSibling();
				segment=tableList(_t);
				_t = _retTree;
				break;
			}
			case WHERE:
			{
				AST tmp3_AST_in = (AST)_t;
				match(_t,WHERE);
				_t = _t.getNextSibling();
				segment=equations(_t);
				_t = _retTree;
				break;
			}
			case COLUMN:
			{
				AST tmp4_AST_in = (AST)_t;
				match(_t,COLUMN);
				_t = _t.getNextSibling();
				segment=column(_t);
				_t = _retTree;
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
		return segment;
	}
	
	public final String  columnList(AST _t) throws RecognitionException {
		String clist;
		
		AST columnList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String elem, args="", c1, c2; clist="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t119 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				c1=columnList(_t);
				_t = _retTree;
				c2=columnList(_t);
				_t = _retTree;
				_t = __t119;
				_t = _t.getNextSibling();
				clist=c1+","+c2;
				break;
			}
			case STAR:
			case FUNC_NAME:
			case LPAREN:
			case OPERATOR:
			case AS:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				elem=column(_t);
				_t = _retTree;
				clist=elem;
				break;
			}
			case ALL_FIELDS:
			{
				AST tmp6_AST_in = (AST)_t;
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
				AST __t126 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				t1=tableList(_t);
				_t = _retTree;
				t2=tableList(_t);
				_t = _retTree;
				_t = __t126;
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
	
	public final String  equations(AST _t) throws RecognitionException {
		String equStr;
		
		AST equations_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST lop = null;
		AST op = null;
		String e1, e2; equStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EQUATION_START:
			{
				AST __t130 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,EQUATION_START);
				_t = _t.getFirstChild();
				e1=equations(_t);
				_t = _retTree;
				_t = __t130;
				_t = _t.getNextSibling();
				equStr=e1;
				break;
			}
			case LOGIC_OP:
			{
				AST __t131 = _t;
				lop = _t==ASTNULL ? null :(AST)_t;
				match(_t,LOGIC_OP);
				_t = _t.getFirstChild();
				e1=equations(_t);
				_t = _retTree;
				e2=equations(_t);
				_t = _retTree;
				_t = __t131;
				_t = _t.getNextSibling();
				equStr=e1+" "+lop+" "+e2;
				break;
			}
			case COMPARATOR:
			{
				AST __t132 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,COMPARATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t132;
				_t = _t.getNextSibling();
				equStr=e1+" "+op.getText()+" "+e2;
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
	
	public final String  column(AST _t) throws RecognitionException {
		String c;
		
		AST column_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST fn = null;
		String args; c="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STAR:
			case LPAREN:
			case OPERATOR:
			case AS:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				c=equElem(_t);
				_t = _retTree;
				break;
			}
			case FUNC_NAME:
			{
				AST __t121 = _t;
				fn = _t==ASTNULL ? null :(AST)_t;
				match(_t,FUNC_NAME);
				_t = _t.getFirstChild();
				args=funcArgs(_t);
				_t = _retTree;
				_t = __t121;
				_t = _t.getNextSibling();
				c=fn.getText()+"("+args+")";
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
		return c;
	}
	
	public final QueryModel  statement(AST _t) throws RecognitionException {
		QueryModel model;
		
		AST statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String clist, tlist, g, o, t1, t2, into, m, e; model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_UNION:
			{
				AST __t109 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,TABLE_UNION);
				_t = _t.getFirstChild();
				t1=tableName(_t);
				_t = _retTree;
				t2=tableName(_t);
				_t = _retTree;
				into=tableName(_t);
				_t = _retTree;
				_t = __t109;
				_t = _t.getNextSibling();
				model=new UnionModel(t1, t2, into);
				break;
			}
			case TABLE_COMPARE:
			{
				AST __t110 = _t;
				AST tmp10_AST_in = (AST)_t;
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
				_t = __t110;
				_t = _t.getNextSibling();
				model=new ComapreModel(t1, t2, into, m, e);
				break;
			}
			case TABLE_SELECT:
			{
				AST __t111 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,TABLE_SELECT);
				_t = _t.getFirstChild();
				clist=columnList(_t);
				_t = _retTree;
				tlist=tableList(_t);
				_t = _retTree;
				e=equations(_t);
				_t = _retTree;
				g=optionalClause(_t);
				_t = _retTree;
				o=optionalClause(_t);
				_t = _retTree;
				_t = __t111;
				_t = _t.getNextSibling();
				model=new SelectModel(clist, tlist, e, g, o, null);
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
		String ts; tableStr="";
		
		try {      // for error handling
			t = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			
						tableStr="["+t.getText()+"]";
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
				AST tmp12_AST_in = (AST)_t;
				match(_t,EXIST);
				_t = _t.getNextSibling();
				m="EXIST";
				break;
			}
			case NOT_EXIST:
			{
				AST tmp13_AST_in = (AST)_t;
				match(_t,NOT_EXIST);
				_t = _t.getNextSibling();
				m="NOT EXIST";
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
	
	public final String  optionalClause(AST _t) throws RecognitionException {
		String optional;
		
		AST optionalClause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST all = null;
		AST asc = null;
		String o; optional="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ALL:
			{
				AST __t115 = _t;
				all = _t==ASTNULL ? null :(AST)_t;
				match(_t,ALL);
				_t = _t.getFirstChild();
				AST tmp14_AST_in = (AST)_t;
				match(_t,GROUP_BY);
				_t = _t.getNextSibling();
				o=columnList(_t);
				_t = _retTree;
				_t = __t115;
				_t = _t.getNextSibling();
				optional=" GROUP BY "+all.getText()+" "+o;
				break;
			}
			case GROUP_BY:
			{
				AST tmp15_AST_in = (AST)_t;
				match(_t,GROUP_BY);
				_t = _t.getNextSibling();
				o=columnList(_t);
				_t = _retTree;
				optional=" GROUP BY "+o;
				break;
			}
			case ASC:
			{
				AST __t116 = _t;
				asc = _t==ASTNULL ? null :(AST)_t;
				match(_t,ASC);
				_t = _t.getFirstChild();
				AST tmp16_AST_in = (AST)_t;
				match(_t,ORDER_BY);
				_t = _t.getNextSibling();
				o=fieldList(_t);
				_t = _retTree;
				_t = __t116;
				_t = _t.getNextSibling();
				optional=" ORDER BY "+o+" "+asc.getText();
				break;
			}
			case ORDER_BY:
			{
				AST tmp17_AST_in = (AST)_t;
				match(_t,ORDER_BY);
				_t = _t.getNextSibling();
				o=fieldList(_t);
				_t = _retTree;
				optional=" ORDER BY "+o;
				break;
			}
			case GROUP_CLAUSE:
			{
				AST tmp18_AST_in = (AST)_t;
				match(_t,GROUP_CLAUSE);
				_t = _t.getNextSibling();
				optional="";
				break;
			}
			case ORDER_CLAUSE:
			{
				AST tmp19_AST_in = (AST)_t;
				match(_t,ORDER_CLAUSE);
				_t = _t.getNextSibling();
				optional="";
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
		return optional;
	}
	
	public final SelectModel  selectStatement(AST _t) throws RecognitionException {
		SelectModel model;
		
		AST selectStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String clist, tlist, e, g, o; model=null;
		
		try {      // for error handling
			AST __t113 = _t;
			AST tmp20_AST_in = (AST)_t;
			match(_t,TABLE_SELECT);
			_t = _t.getFirstChild();
			clist=columnList(_t);
			_t = _retTree;
			tlist=tableList(_t);
			_t = _retTree;
			e=equations(_t);
			_t = _retTree;
			g=optionalClause(_t);
			_t = _retTree;
			o=optionalClause(_t);
			_t = _retTree;
			_t = __t113;
			_t = _t.getNextSibling();
			model=new SelectModel(clist, tlist, e, g, o, null);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return model;
	}
	
	public final String  fieldList(AST _t) throws RecognitionException {
		String fList;
		
		AST fieldList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String f1, f2; fList="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t128 = _t;
				AST tmp21_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				f1=fieldList(_t);
				_t = _retTree;
				f2=fieldList(_t);
				_t = _retTree;
				_t = __t128;
				_t = _t.getNextSibling();
				fList=f1+","+f2;
				break;
			}
			case POINT:
			{
				f1=fieldName(_t);
				_t = _retTree;
				fList=f1;
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
		return fList;
	}
	
	public final String  equElem(AST _t) throws RecognitionException {
		String equElemStr;
		
		AST equElem_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST star = null;
		AST n = null;
		AST s = null;
		AST tempField = null;
		String e1, e2, f; equElemStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPERATOR:
			{
				AST __t134 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,OPERATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t134;
				_t = _t.getNextSibling();
				equElemStr=e1+op.getText()+e2;
				break;
			}
			case STAR:
			{
				AST __t135 = _t;
				star = _t==ASTNULL ? null :(AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t135;
				_t = _t.getNextSibling();
				equElemStr=e1+star.getText()+e2;
				break;
			}
			case LPAREN:
			{
				AST tmp22_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e1=equElem(_t);
				_t = _retTree;
				AST tmp23_AST_in = (AST)_t;
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
			case AS:
			{
				AST __t136 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,AS);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				tempField = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t136;
				_t = _t.getNextSibling();
				equElemStr=e1+" as "+tempField.getText();
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
	
	public final String  funcArgs(AST _t) throws RecognitionException {
		String args;
		
		AST funcArgs_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String a; args="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ALL:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,ALL);
				_t = _t.getNextSibling();
				a=funcArg(_t);
				_t = _retTree;
				args="all "+a;
				break;
			}
			case DISTINCT:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,DISTINCT);
				_t = _t.getNextSibling();
				a=funcArg(_t);
				_t = _retTree;
				args="distinct "+a;
				break;
			}
			case COMMA:
			case STAR:
			case LPAREN:
			case OPERATOR:
			case AS:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				a=funcArg(_t);
				_t = _retTree;
				args=a;
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
		return args;
	}
	
	public final String  funcArg(AST _t) throws RecognitionException {
		String arg;
		
		AST funcArg_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String f1, f2; arg="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t124 = _t;
				AST tmp27_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				f1=funcArg(_t);
				_t = _retTree;
				f2=funcArg(_t);
				_t = _retTree;
				_t = __t124;
				_t = _t.getNextSibling();
				arg=f1+","+f2;
				break;
			}
			case STAR:
			case LPAREN:
			case OPERATOR:
			case AS:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				f1=equElem(_t);
				_t = _retTree;
				arg=f1;
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
		return arg;
	}
	
	public final String  fieldName(AST _t) throws RecognitionException {
		String fieldStr;
		
		AST fieldName_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST f1 = null;
		AST f2 = null;
		fieldStr="";
		
		try {      // for error handling
			AST __t139 = _t;
			AST tmp28_AST_in = (AST)_t;
			match(_t,POINT);
			_t = _t.getFirstChild();
			f1 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			f2 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			_t = __t139;
			_t = _t.getNextSibling();
			
						String t=f1.getText();
						String f=f2.getText();
						fieldStr="["+t+"."+f+"]";
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
		"EQUATION_START",
		"SELECT_STATEMENT",
		"GROUP_CLAUSE",
		"ORDER_CLAUSE",
		"TABLE_SELECT",
		"COLUMN",
		"FROM",
		"WHERE",
		"SEMI",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"GROUP_BY",
		"ALL",
		"ORDER_BY",
		"ASC",
		"UNION",
		"STAR",
		"FUNC_NAME",
		"LPAREN",
		"DISTINCT",
		"RPAREN",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"COMPARATOR",
		"ID",
		"NAME_START",
		"NAME_END",
		"OPERATOR",
		"AS",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"\"null\"",
		"BETWEEN",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"WS",
		"ESC"
	};
	
	}
	
