// $ANTLR 2.7.7 (2006-11-01): "src/parser/sybase/parser_sybase.g" -> "SybaseIQ12TreeParser.java"$

	package parser.sybase;

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

	import model.parser.*;


public class SybaseIQ12TreeParser extends antlr.TreeParser       implements SybaseIQ12ParserTokenTypes
 {

	Map tables = new HashMap();
	
	private TableModel addTableByChName(String chName) {
		TableModel table = (TableModel) tables.get(chName);
		if (table == null) {
			table = new TableModel(chName);
			tables.put(chName, table);
		}
		return table;
	}
	
	public Map getTables(){
		return tables;
	}
public SybaseIQ12TreeParser() {
	tokenNames = _tokenNames;
}

	public final QueryModel  segment(AST _t) throws RecognitionException {
		QueryModel model;
		
		AST segment_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			model=null;
			
			SelectStatementModel stmt = new SelectStatementModel();
			SelectListModel selList = new SelectListModel();
			TableListModel t1 = new TableListModel();
			ColumnModel c1 = new ColumnModel();
			SearchConditionModel cond = new SearchConditionModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COLUMN:
			{
				AST tmp1_AST_in = (AST)_t;
				match(_t,COLUMN);
				_t = _t.getNextSibling();
				c1=column(_t);
				_t = _retTree;
				
							for (Iterator it = getTables().keySet().iterator(); it.hasNext();){
					        	t1.addTable( (TableModel)getTables().get((String)it.next()));
					        }
							selList.addColumn(c1);
							stmt.setTableList(t1);
							stmt.setSelectList(selList);
							model = stmt;
						
				break;
			}
			case WHERE:
			{
				AST tmp2_AST_in = (AST)_t;
				match(_t,WHERE);
				_t = _t.getNextSibling();
				cond=search_condition(_t);
				_t = _retTree;
				
							for (Iterator it = getTables().keySet().iterator(); it.hasNext();){
					        	t1.addTable( (TableModel)getTables().get((String)it.next()));
					        }
							stmt.setTableList(t1);
							stmt.setSearchCondition(cond);
							model = stmt;	
						
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
	
	public final ColumnModel  column(AST _t) throws RecognitionException {
		ColumnModel model;
		
		AST column_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		ExpressionModel e; AliasModel a; model=new ColumnModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case AS_EN:
			{
				AST __t249 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,AS_EN);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t249;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case AS_CN:
			{
				AST __t250 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,AS_CN);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t250;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case ALIAS_EQU:
			{
				AST __t251 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,ALIAS_EQU);
				_t = _t.getFirstChild();
				a=alias(_t);
				_t = _retTree;
				e=expression(_t);
				_t = _retTree;
				_t = __t251;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case ALL_FIELDS:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case REAL_NUM:
			case LPAREN:
			case NULL_EN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case PARAM_ID:
			case QUOTED_STRING:
			case POINT:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			case LITERAL_day:
			case LITERAL_hour:
			case LITERAL_minute:
			case LITERAL_month:
			case LITERAL_quarter:
			case LITERAL_second:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_mm:
			case LITERAL_dd:
			case LITERAL_qq:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hh:
			case LITERAL_mi:
			case LITERAL_ss:
			case LITERAL_millisecond:
			case LITERAL_ms:
			case LITERAL_calweekofyear:
			case LITERAL_cwk:
			case LITERAL_calyearofweek:
			case LITERAL_cyr:
			case LITERAL_caldayofweek:
			case LITERAL_cdw:
			case TWO_ARG_OP:
			case ONE_ARG_OP:
			{
				e=expression(_t);
				_t = _retTree;
				model.addExpression(e);
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
	
	public final SearchConditionModel  search_condition(AST _t) throws RecognitionException {
		SearchConditionModel model;
		
		AST search_condition_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST o1 = null;
		AST o2 = null;
		AST o3 = null;
		AST o4 = null;
		AST o11 = null;
		AST o12 = null;
		SearchConditionModel m1, m2, m3, m4, m5; EquationModel equ; model=new SearchConditionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case AND_EN:
			{
				AST __t237 = _t;
				o1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,AND_EN);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t237;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o1.getText(), true); model.addChild(m2);
				break;
			}
			case OR_EN:
			{
				AST __t238 = _t;
				o2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,OR_EN);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t238;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o2.getText(), true); model.addChild(m2);
				break;
			}
			case AND_CN:
			{
				AST __t239 = _t;
				o3 = _t==ASTNULL ? null :(AST)_t;
				match(_t,AND_CN);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t239;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);
				break;
			}
			case OR_CN:
			{
				AST __t240 = _t;
				o4 = _t==ASTNULL ? null :(AST)_t;
				match(_t,OR_CN);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t240;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);
				break;
			}
			case LOGIC_BLOCK:
			{
				AST __t241 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,LOGIC_BLOCK);
				_t = _t.getFirstChild();
				m3=search_condition(_t);
				_t = _retTree;
				_t = __t241;
				_t = _t.getNextSibling();
				model.addOperator("("); model.addChild(m3); model.addOperator(")");
				break;
			}
			case SEARCH_NOT_CONDITION:
			{
				AST __t242 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,SEARCH_NOT_CONDITION);
				_t = _t.getFirstChild();
				o11 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				m4=search_condition(_t);
				_t = _retTree;
				_t = __t242;
				_t = _t.getNextSibling();
				model.addOperator(o11.getText(), true); model.addChild(m4);
				break;
			}
			case NOT_CN:
			{
				AST __t243 = _t;
				o12 = _t==ASTNULL ? null :(AST)_t;
				match(_t,NOT_CN);
				_t = _t.getFirstChild();
				m5=search_condition(_t);
				_t = _retTree;
				_t = __t243;
				_t = _t.getNextSibling();
				model.addOperator(o12.getText()); model.addChild(m5);
				break;
			}
			case LOGICAL_NULL:
			case LOGICAL_NOT_NULL:
			case LOGICAL_IN:
			case LOGICAL_NOT_IN:
			case LOGICAL_LIKE:
			case LOGICAL_NOT_LIKE:
			case LOGICAL_EXISTS:
			case LOGICAL_NOT_EXISTS:
			case EXISTS_CN:
			case NOT_EXISTS_CN:
			case LIKE_CN:
			case NOT_LIKE_CN:
			case NULL_CN:
			case NOT_NULL_CN:
			case BETWEEN_CN:
			case BETWEEN_EN:
			case IN_CN:
			case NOT_IN_CN:
			case COMPARE_OP:
			{
				equ=equation(_t);
				_t = _retTree;
				model.addEquation(equ);
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
	
	public final StatementsModel  statements(AST _t) throws RecognitionException {
		StatementsModel model;
		
		AST statements_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		StatementsModel s1, s2; QueryModel s; model=new StatementsModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SEMI:
			{
				AST __t205 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getFirstChild();
				s1=statements(_t);
				_t = _retTree;
				s2=statements(_t);
				_t = _retTree;
				_t = __t205;
				_t = _t.getNextSibling();
				model.addChild(s1); model.addChild(s2);
				break;
			}
			case SELECT_STATEMENT:
			case TABLE_UNION_CN:
			case TABLE_COMPARE_CN:
			{
				s=statement(_t);
				_t = _retTree;
				model.addStatement(s);
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
	
	public final QueryModel  statement(AST _t) throws RecognitionException {
		QueryModel model;
		
		AST statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
			model = null;
			String method;
			SelectStatementModel select; 
			TableUnionModel union = new TableUnionModel(); 
			TableModel tableModel1, tableModel2;
			TableCompareModel tableCompare = new TableCompareModel();
			TableListModel t1;
			SearchConditionModel cond;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_UNION_CN:
			{
				AST __t207 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,TABLE_UNION_CN);
				_t = _t.getFirstChild();
				t1=tableUnionList(_t);
				_t = _retTree;
				_t = __t207;
				_t = _t.getNextSibling();
				
							union.addTableListModel(t1);
							model = union;
						
				break;
			}
			case TABLE_COMPARE_CN:
			{
				AST __t208 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,TABLE_COMPARE_CN);
				_t = _t.getFirstChild();
				tableModel1=table_name(_t);
				_t = _retTree;
				tableModel2=table_name(_t);
				_t = _retTree;
				method=compare_method(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t208;
				_t = _t.getNextSibling();
					
							tableCompare.addTableModel1(tableModel1);
							tableCompare.addTableModel2(tableModel2);
							tableCompare.setCompareMethod(method);
							tableCompare.setSearchCondition(cond);
							model = tableCompare;
						
				break;
			}
			case SELECT_STATEMENT:
			{
				AST __t209 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,SELECT_STATEMENT);
				_t = _t.getFirstChild();
				model=select_statement(_t);
				_t = _retTree;
				_t = __t209;
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
		return model;
	}
	
	public final TableListModel  tableUnionList(AST _t) throws RecognitionException {
		TableListModel model;
		
		AST tableUnionList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			model = new TableListModel();
			TableModel t;
			TableListModel m1, m2;
			
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t211 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=tableUnionList(_t);
				_t = _retTree;
				m2=tableUnionList(_t);
				_t = _retTree;
				_t = __t211;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case AS_EN:
			case AS_CN:
			case ID:
			{
				t=table_name(_t);
				_t = _retTree;
				model.addTable(t);
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
	
	public final TableModel  table_name(AST _t) throws RecognitionException {
		TableModel model;
		
		AST table_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST t = null;
		AST t1 = null;
		AST t2 = null;
		AliasModel a; model=null; TableAliasModel ta;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				t = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				model=new TableModel(t.getText());
				break;
			}
			case AS_EN:
			{
				AST __t324 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,AS_EN);
				_t = _t.getFirstChild();
				t1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t324;
				_t = _t.getNextSibling();
				model = new TableModel(t1.getText()); model.setAlias(ta);
				break;
			}
			case AS_CN:
			{
				AST __t325 = _t;
				AST tmp14_AST_in = (AST)_t;
				match(_t,AS_CN);
				_t = _t.getFirstChild();
				t2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t325;
				_t = _t.getNextSibling();
				model = new TableModel(t2.getText()); model.setAlias(ta);
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
	
	public final String  compare_method(AST _t) throws RecognitionException {
		String rValue;
		
		AST compare_method_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST v1 = null;
		AST ne1 = null;
		AST ne2 = null;
		rValue = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EXISTS_EN:
			case EXISTS_CN:
			case NOT_EXISTS_CN:
			{
				v1 = _t==ASTNULL ? null : (AST)_t;
				comparemethod_name(_t);
				_t = _retTree;
				rValue = v1.getText();
				break;
			}
			case LOGICAL_NOT_EXISTS:
			{
				AST __t213 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_EXISTS);
				_t = _t.getFirstChild();
				ne1 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				ne2 = (AST)_t;
				match(_t,EXISTS_EN);
				_t = _t.getNextSibling();
				_t = __t213;
				_t = _t.getNextSibling();
				rValue = ne1.getText() + " " + ne2.getText();
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
	
	public final SelectStatementModel  select_statement(AST _t) throws RecognitionException {
		SelectStatementModel model;
		
		AST select_statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST int1 = null;
		AST int2 = null;
		
			OrderExpressionListModel order;
			AggregateExprListModel group;
			SearchConditionModel cond;
			TableListModel tl;
			SelectListModel sl;
			SelectStatementModel s;
			model=new SelectStatementModel();
			boolean isdst = false;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case DISTINCT_CN:
			{
				AST __t215 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,DISTINCT_CN);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t215;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case DISTINCT_EN:
			{
				AST __t216 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,DISTINCT_EN);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t216;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case TOP_CN:
			{
				AST __t217 = _t;
				AST tmp18_AST_in = (AST)_t;
				match(_t,TOP_CN);
				_t = _t.getFirstChild();
				isdst=distinct_select_op(_t);
				_t = _retTree;
				int1 = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t217;
				_t = _t.getNextSibling();
				sl.setTopNum(int1.getText()); sl.setDistinct(isdst); model.setSelectList(sl);
				break;
			}
			case TOP_EN:
			{
				AST __t218 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,TOP_EN);
				_t = _t.getFirstChild();
				isdst=distinct_select_op(_t);
				_t = _retTree;
				int2 = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t218;
				_t = _t.getNextSibling();
				sl.setTopNum(int2.getText()); sl.setDistinct(isdst); model.setSelectList(sl);
				break;
			}
			case SELECT_CN:
			{
				AST __t219 = _t;
				AST tmp20_AST_in = (AST)_t;
				match(_t,SELECT_CN);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t219;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case SELECT_EN:
			{
				AST __t220 = _t;
				AST tmp21_AST_in = (AST)_t;
				match(_t,SELECT_EN);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t220;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case FROM_CN:
			{
				AST __t221 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,FROM_CN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t221;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case FROM_EN:
			{
				AST __t222 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,FROM_EN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t222;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case WHERE_CN:
			{
				AST __t223 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,WHERE_CN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t223;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case WHERE_EN:
			{
				AST __t224 = _t;
				AST tmp25_AST_in = (AST)_t;
				match(_t,WHERE_EN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t224;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case GROUP_BY_CN:
			{
				AST __t225 = _t;
				AST tmp26_AST_in = (AST)_t;
				match(_t,GROUP_BY_CN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t225;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case GROUP_EN:
			{
				AST __t226 = _t;
				AST tmp27_AST_in = (AST)_t;
				match(_t,GROUP_EN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t226;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case ORDER_BY_CN:
			{
				AST __t227 = _t;
				AST tmp28_AST_in = (AST)_t;
				match(_t,ORDER_BY_CN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t227;
				_t = _t.getNextSibling();
				model.addChild(s); model.setOrderExpressionList(order);
				break;
			}
			case ORDER_EN:
			{
				AST __t228 = _t;
				AST tmp29_AST_in = (AST)_t;
				match(_t,ORDER_EN);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t228;
				_t = _t.getNextSibling();
				model.addChild(s); model.setOrderExpressionList(order);
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
	
	public final void comparemethod_name(AST _t) throws RecognitionException {
		
		AST comparemethod_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EXISTS_EN:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,EXISTS_EN);
				_t = _t.getNextSibling();
				break;
			}
			case EXISTS_CN:
			{
				AST tmp31_AST_in = (AST)_t;
				match(_t,EXISTS_CN);
				_t = _t.getNextSibling();
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp32_AST_in = (AST)_t;
				match(_t,NOT_EXISTS_CN);
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
	
	public final void select(AST _t) throws RecognitionException {
		
		AST select_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SELECT_EN:
			{
				AST tmp33_AST_in = (AST)_t;
				match(_t,SELECT_EN);
				_t = _t.getNextSibling();
				break;
			}
			case SELECT_CN:
			{
				AST tmp34_AST_in = (AST)_t;
				match(_t,SELECT_CN);
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
	
	public final SelectListModel  select_list(AST _t) throws RecognitionException {
		SelectListModel model;
		
		AST select_list_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			SelectListModel m1, m2; 
			ColumnModel c;
			model=new SelectListModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t233 = _t;
				AST tmp35_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=select_list(_t);
				_t = _retTree;
				m2=select_list(_t);
				_t = _retTree;
				_t = __t233;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case ALIAS_EQU:
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case ALL_FIELDS:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case REAL_NUM:
			case LPAREN:
			case AS_EN:
			case AS_CN:
			case NULL_EN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case PARAM_ID:
			case QUOTED_STRING:
			case POINT:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			case LITERAL_day:
			case LITERAL_hour:
			case LITERAL_minute:
			case LITERAL_month:
			case LITERAL_quarter:
			case LITERAL_second:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_mm:
			case LITERAL_dd:
			case LITERAL_qq:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hh:
			case LITERAL_mi:
			case LITERAL_ss:
			case LITERAL_millisecond:
			case LITERAL_ms:
			case LITERAL_calweekofyear:
			case LITERAL_cwk:
			case LITERAL_calyearofweek:
			case LITERAL_cyr:
			case LITERAL_caldayofweek:
			case LITERAL_cdw:
			case TWO_ARG_OP:
			case ONE_ARG_OP:
			{
				c=column(_t);
				_t = _retTree;
				model.addColumn(c);
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
	
	public final boolean  distinct_select_op(AST _t) throws RecognitionException {
		boolean rValue;
		
		AST distinct_select_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			rValue = false;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case DISTINCT_CN:
			{
				AST __t230 = _t;
				AST tmp36_AST_in = (AST)_t;
				match(_t,DISTINCT_CN);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				_t = __t230;
				_t = _t.getNextSibling();
				rValue = true;
				break;
			}
			case DISTINCT_EN:
			{
				AST __t231 = _t;
				AST tmp37_AST_in = (AST)_t;
				match(_t,DISTINCT_EN);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				_t = __t231;
				_t = _t.getNextSibling();
				rValue = true;
				break;
			}
			case SELECT_EN:
			case SELECT_CN:
			{
				select(_t);
				_t = _retTree;
				rValue = false;
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
	
	public final TableListModel  table_list(AST _t) throws RecognitionException {
		TableListModel model;
		
		AST table_list_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		TableModel t; TableListModel m1, m2; model=new TableListModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t235 = _t;
				AST tmp38_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=table_list(_t);
				_t = _retTree;
				m2=table_list(_t);
				_t = _retTree;
				_t = __t235;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case AS_EN:
			case AS_CN:
			case ID:
			{
				t=table_name(_t);
				_t = _retTree;
				model.addTable(t);
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
	
	public final AggregateExprListModel  aggregate_expression_list(AST _t) throws RecognitionException {
		AggregateExprListModel model;
		
		AST aggregate_expression_list_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AggregateExprListModel m1, m2; AggregateExprModel expr; model=new AggregateExprListModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t245 = _t;
				AST tmp39_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=aggregate_expression_list(_t);
				_t = _retTree;
				m2=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t245;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case REAL_NUM:
			case LPAREN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			case TWO_ARG_OP:
			{
				expr=aggregate_expression(_t);
				_t = _retTree;
				model.addAggregateExpression(expr);
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
	
	public final OrderExpressionListModel  order_expression_list(AST _t) throws RecognitionException {
		OrderExpressionListModel model;
		
		AST order_expression_list_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		OrderExpressionModel e; OrderExpressionListModel m1, m2; model=new OrderExpressionListModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t247 = _t;
				AST tmp40_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=order_expression_list(_t);
				_t = _retTree;
				m2=order_expression_list(_t);
				_t = _retTree;
				_t = __t247;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case ASC_EN:
			case ASC_CN:
			case DESC_EN:
			case DESC_CN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				e=order_expression(_t);
				_t = _retTree;
				model.addOrderExpression(e);
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
	
	public final EquationModel  equation(AST _t) throws RecognitionException {
		EquationModel model;
		
		AST equation_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST le0 = null;
		AST le1 = null;
		AST le2 = null;
		AST le = null;
		AST lne = null;
		AST ls = null;
		AST ls1 = null;
		AST ls2 = null;
		AST l = null;
		AST nl = null;
		AST nStr1 = null;
		AST nStr2 = null;
		AST n = null;
		AST nStr3 = null;
		AST nStr4 = null;
		AST nStr5 = null;
		AST nn = null;
		AST bt1 = null;
		AST btw = null;
		AST in1 = null;
		AST in2 = null;
		AST in3 = null;
		AST ct1 = null;
		AST ct2 = null;
		
			ExpressionModel e1, e2, e3;
			EquationModel equation;
			SelectStatementModel stmt;
			model=new EquationModel();
			String nullStr = "";
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMPARE_OP:
			{
				AST __t253 = _t;
				AST tmp41_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				compare_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t253;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);
				break;
			}
			case LOGICAL_EXISTS:
			{
				AST __t254 = _t;
				AST tmp42_AST_in = (AST)_t;
				match(_t,LOGICAL_EXISTS);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				le0 = (AST)_t;
				match(_t,EXISTS_EN);
				_t = _t.getNextSibling();
				AST __t255 = _t;
				AST tmp43_AST_in = (AST)_t;
				match(_t,SUBQUERY);
				_t = _t.getFirstChild();
				stmt=select_statement(_t);
				_t = _retTree;
				_t = __t255;
				_t = _t.getNextSibling();
				_t = __t254;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(le0.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);
				break;
			}
			case LOGICAL_NOT_EXISTS:
			{
				AST __t256 = _t;
				AST tmp44_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_EXISTS);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				le1 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				le2 = (AST)_t;
				match(_t,EXISTS_EN);
				_t = _t.getNextSibling();
				AST __t257 = _t;
				AST tmp45_AST_in = (AST)_t;
				match(_t,SUBQUERY);
				_t = _t.getFirstChild();
				stmt=select_statement(_t);
				_t = _retTree;
				_t = __t257;
				_t = _t.getNextSibling();
				_t = __t256;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(le1.getText() + " " + le2.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);
				break;
			}
			case EXISTS_CN:
			{
				AST __t258 = _t;
				le = _t==ASTNULL ? null :(AST)_t;
				match(_t,EXISTS_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST __t259 = _t;
				AST tmp46_AST_in = (AST)_t;
				match(_t,SUBQUERY);
				_t = _t.getFirstChild();
				stmt=select_statement(_t);
				_t = _retTree;
				_t = __t259;
				_t = _t.getNextSibling();
				_t = __t258;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(le.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST __t260 = _t;
				lne = _t==ASTNULL ? null :(AST)_t;
				match(_t,NOT_EXISTS_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST __t261 = _t;
				AST tmp47_AST_in = (AST)_t;
				match(_t,SUBQUERY);
				_t = _t.getFirstChild();
				stmt=select_statement(_t);
				_t = _retTree;
				_t = __t261;
				_t = _t.getNextSibling();
				_t = __t260;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(lne.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);
				break;
			}
			case LOGICAL_LIKE:
			{
				AST __t262 = _t;
				AST tmp48_AST_in = (AST)_t;
				match(_t,LOGICAL_LIKE);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				ls = (AST)_t;
				match(_t,LIKE_EN);
				_t = _t.getNextSibling();
				e2=expression(_t);
				_t = _retTree;
				_t = __t262;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ls.getText(), true); model.addExpression(e2);
				break;
			}
			case LOGICAL_NOT_LIKE:
			{
				AST __t263 = _t;
				AST tmp49_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_LIKE);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				ls1 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				ls2 = (AST)_t;
				match(_t,LIKE_EN);
				_t = _t.getNextSibling();
				e2=expression(_t);
				_t = _retTree;
				_t = __t263;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ls1.getText() + " " + ls2.getText(), true); model.addExpression(e2);
				break;
			}
			case LIKE_CN:
			{
				AST __t264 = _t;
				l = _t==ASTNULL ? null :(AST)_t;
				match(_t,LIKE_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t264;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(l.getText()); model.addExpression(e2);
				break;
			}
			case NOT_LIKE_CN:
			{
				AST __t265 = _t;
				nl = _t==ASTNULL ? null :(AST)_t;
				match(_t,NOT_LIKE_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t265;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nl.getText()); model.addExpression(e2);
				break;
			}
			case LOGICAL_NULL:
			{
				AST __t266 = _t;
				AST tmp50_AST_in = (AST)_t;
				match(_t,LOGICAL_NULL);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				nStr1 = (AST)_t;
				match(_t,IS_EN);
				_t = _t.getNextSibling();
				nStr2 = (AST)_t;
				match(_t,NULL_EN);
				_t = _t.getNextSibling();
				_t = __t266;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nStr1.getText() + " " + nStr2.getText(), true);
				break;
			}
			case NULL_CN:
			{
				AST __t267 = _t;
				n = _t==ASTNULL ? null :(AST)_t;
				match(_t,NULL_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t267;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(n.getText());
				break;
			}
			case LOGICAL_NOT_NULL:
			{
				AST __t268 = _t;
				AST tmp51_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_NULL);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				nStr3 = (AST)_t;
				match(_t,IS_EN);
				_t = _t.getNextSibling();
				nStr4 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				nStr5 = (AST)_t;
				match(_t,NULL_EN);
				_t = _t.getNextSibling();
				_t = __t268;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nStr3.getText() + " " + nStr4.getText() + " " + nStr5.getText(), true);
				break;
			}
			case NOT_NULL_CN:
			{
				AST __t269 = _t;
				nn = _t==ASTNULL ? null :(AST)_t;
				match(_t,NOT_NULL_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t269;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nn.getText());
				break;
			}
			case BETWEEN_EN:
			{
				AST __t270 = _t;
				bt1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,BETWEEN_EN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t270;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(bt1.getText(), true);
					 model.addExpression(e2); model.addExpression(e3);
				break;
			}
			case BETWEEN_CN:
			{
				AST __t271 = _t;
				btw = _t==ASTNULL ? null :(AST)_t;
				match(_t,BETWEEN_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t271;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(btw.getText());
					 model.addExpression(e2); model.addExpression(e3);
					
				break;
			}
			case LOGICAL_IN:
			{
				AST __t272 = _t;
				AST tmp52_AST_in = (AST)_t;
				match(_t,LOGICAL_IN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				in1 = (AST)_t;
				match(_t,IN_EN);
				_t = _t.getNextSibling();
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t272;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(in1.getText(), true); model.addExpression(e2);
				break;
			}
			case LOGICAL_NOT_IN:
			{
				AST __t273 = _t;
				AST tmp53_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_IN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				in2 = (AST)_t;
				match(_t,NOT_EN);
				_t = _t.getNextSibling();
				in3 = (AST)_t;
				match(_t,IN_EN);
				_t = _t.getNextSibling();
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t273;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(in2.getText() + " " + in3.getText(), true); model.addExpression(e2);
				break;
			}
			case IN_CN:
			{
				AST __t274 = _t;
				ct1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,IN_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t274;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);
				break;
			}
			case NOT_IN_CN:
			{
				AST __t275 = _t;
				ct2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,NOT_IN_CN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t275;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);
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
	
	public final AggregateExprModel  aggregate_expression(AST _t) throws RecognitionException {
		AggregateExprModel model;
		
		AST aggregate_expression_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST lp = null;
		AST rp = null;
		AST op = null;
		AST nrn = null;
		AST rn = null;
		AST qs = null;
		AggregateExprModel a1, a2; FieldModel field; FunctionModel func; model=new AggregateExprModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LPAREN:
			{
				lp = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				a1=aggregate_expression(_t);
				_t = _retTree;
				rp = (AST)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				model.addOperator(lp.getText()); model.addChild(a1); model.addOperator(rp.getText());
				break;
			}
			case TWO_ARG_OP:
			{
				AST __t283 = _t;
				AST tmp54_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				a1=aggregate_expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				a2=aggregate_expression(_t);
				_t = _retTree;
				_t = __t283;
				_t = _t.getNextSibling();
				model.addChild(a1); model.addOperator(op.getText(), true); model.addChild(a2);
				break;
			}
			case PAREN_FIELD:
			case ID:
			case POINT:
			{
				field=field_name(_t);
				_t = _retTree;
				model.addField(field);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
				break;
			}
			case NEGATIVE_DIGIT_ELEMENT:
			{
				nrn = (AST)_t;
				match(_t,NEGATIVE_DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				model.addConstant(nrn.getText());
				break;
			}
			case REAL_NUM:
			{
				rn = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				model.addConstant(rn.getText());
				break;
			}
			case QUOTED_STRING:
			{
				qs = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				model.addConstant(qs.getText());
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
	
	public final OrderExpressionModel  order_expression(AST _t) throws RecognitionException {
		OrderExpressionModel model;
		
		AST order_expression_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		FunctionModel func; FieldModel field; OrderAliasModel alias; OrderExpressionModel o; model=new OrderExpressionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
				break;
			}
			case ASC_EN:
			{
				AST __t285 = _t;
				AST tmp55_AST_in = (AST)_t;
				match(_t,ASC_EN);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t285;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case ASC_CN:
			{
				AST __t286 = _t;
				AST tmp56_AST_in = (AST)_t;
				match(_t,ASC_CN);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t286;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case DESC_EN:
			{
				AST __t287 = _t;
				AST tmp57_AST_in = (AST)_t;
				match(_t,DESC_EN);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t287;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.DESC);
				break;
			}
			case DESC_CN:
			{
				AST __t288 = _t;
				AST tmp58_AST_in = (AST)_t;
				match(_t,DESC_CN);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t288;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.DESC);
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ID||_t.getType()==QUOTED_STRING)) {
					alias=orderAlias(_t);
					_t = _retTree;
					model.addOrderAlias(alias);
				}
				else if ((_t.getType()==PAREN_FIELD||_t.getType()==ID||_t.getType()==POINT)) {
					field=field_name(_t);
					_t = _retTree;
					model.addField(field);
				}
			else {
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
	
	public final ExpressionModel  expression(AST _t) throws RecognitionException {
		ExpressionModel model;
		
		AST expression_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST op1 = null;
		AST lp = null;
		AST rp = null;
		AST dkw = null;
		AST nrn = null;
		AST rn = null;
		AST qs = null;
		AST nullStr = null;
		AST allf = null;
		FieldModel f; FunctionModel func; ParamModel param; ExpressionModel e1, e2; model=new ExpressionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST __t292 = _t;
				AST tmp59_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t292;
				_t = _t.getNextSibling();
				model.addChild(e1); model.addOperator(op.getText(), true); model.addChild(e2);
				break;
			}
			case ONE_ARG_OP:
			{
				AST __t293 = _t;
				AST tmp60_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getFirstChild();
				op1 = _t==ASTNULL ? null : (AST)_t;
				one_arg_op(_t);
				_t = _retTree;
				e1=expression(_t);
				_t = _retTree;
				_t = __t293;
				_t = _t.getNextSibling();
				model.addOperator(op1.getText(), true); model.addChild(e1);
				break;
			}
			case LPAREN:
			{
				lp = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e1=expression(_t);
				_t = _retTree;
				rp = (AST)_t;
				match(_t,RPAREN);
				_t = _t.getNextSibling();
				model.addOperator(lp.getText()); model.addChild(e1); model.addOperator(rp.getText());
				break;
			}
			case LITERAL_day:
			case LITERAL_hour:
			case LITERAL_minute:
			case LITERAL_month:
			case LITERAL_quarter:
			case LITERAL_second:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_mm:
			case LITERAL_dd:
			case LITERAL_qq:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hh:
			case LITERAL_mi:
			case LITERAL_ss:
			case LITERAL_millisecond:
			case LITERAL_ms:
			case LITERAL_calweekofyear:
			case LITERAL_cwk:
			case LITERAL_calyearofweek:
			case LITERAL_cyr:
			case LITERAL_caldayofweek:
			case LITERAL_cdw:
			{
				dkw = _t==ASTNULL ? null : (AST)_t;
				date_key_word(_t);
				_t = _retTree;
				model.addConstant(dkw.getText());
				break;
			}
			case PARAM_ID:
			{
				param=param_equ(_t);
				_t = _retTree;
				model.addParam(param);
				break;
			}
			case PAREN_FIELD:
			case ID:
			case POINT:
			{
				f=field_name(_t);
				_t = _retTree;
				model.addField(f);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
				break;
			}
			case NEGATIVE_DIGIT_ELEMENT:
			{
				nrn = (AST)_t;
				match(_t,NEGATIVE_DIGIT_ELEMENT);
				_t = _t.getNextSibling();
				model.addConstant(nrn.getText());
				break;
			}
			case REAL_NUM:
			{
				rn = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				model.addConstant(rn.getText());
				break;
			}
			case QUOTED_STRING:
			{
				qs = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				model.addConstant(qs.getText());
				break;
			}
			case NULL_EN:
			{
				nullStr = (AST)_t;
				match(_t,NULL_EN);
				_t = _t.getNextSibling();
				model.addConstant(nullStr.getText());
				break;
			}
			case ALL_FIELDS:
			{
				allf = (AST)_t;
				match(_t,ALL_FIELDS);
				_t = _t.getNextSibling();
				model.addOperator(allf.getText());
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
	
	public final AliasModel  alias(AST _t) throws RecognitionException {
		AliasModel model;
		
		AST alias_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST a1 = null;
		AST a2 = null;
		model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case QUOTED_STRING:
			{
				a1 = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				model=new AliasModel(a1.getText());
				break;
			}
			case ID:
			{
				a2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				model=new AliasModel(a2.getText());
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
	
	public final void compare_op(AST _t) throws RecognitionException {
		
		AST compare_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGNEQUAL:
			case NOTEQUAL1:
			case NOTEQUAL2:
			case LESSTHANOREQUALTO1:
			case LESSTHANOREQUALTO2:
			case LESSTHAN:
			case GREATERTHANOREQUALTO1:
			case GREATERTHANOREQUALTO2:
			case GREATERTHAN:
			{
				comparisonOperator(_t);
				_t = _retTree;
				break;
			}
			case 72:
			{
				AST tmp61_AST_in = (AST)_t;
				match(_t,72);
				_t = _t.getNextSibling();
				break;
			}
			case 334:
			{
				AST tmp62_AST_in = (AST)_t;
				match(_t,334);
				_t = _t.getNextSibling();
				break;
			}
			case 335:
			{
				AST tmp63_AST_in = (AST)_t;
				match(_t,335);
				_t = _t.getNextSibling();
				break;
			}
			case 336:
			{
				AST tmp64_AST_in = (AST)_t;
				match(_t,336);
				_t = _t.getNextSibling();
				break;
			}
			case 337:
			{
				AST tmp65_AST_in = (AST)_t;
				match(_t,337);
				_t = _t.getNextSibling();
				break;
			}
			case 338:
			{
				AST tmp66_AST_in = (AST)_t;
				match(_t,338);
				_t = _t.getNextSibling();
				break;
			}
			case 339:
			{
				AST tmp67_AST_in = (AST)_t;
				match(_t,339);
				_t = _t.getNextSibling();
				break;
			}
			case LEFT_JOIN:
			{
				AST tmp68_AST_in = (AST)_t;
				match(_t,LEFT_JOIN);
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
	
	public final ExpressionModel  exp_set(AST _t) throws RecognitionException {
		ExpressionModel model;
		
		AST exp_set_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			model = new ExpressionModel();
			SelectStatementModel stmt;
			ExprContainModel expr;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SUBCONTAIN_OP:
			{
				AST __t277 = _t;
				AST tmp69_AST_in = (AST)_t;
				match(_t,SUBCONTAIN_OP);
				_t = _t.getFirstChild();
				expr=constexpset(_t);
				_t = _retTree;
				_t = __t277;
				_t = _t.getNextSibling();
				
							model.addExprContainModel(expr);
						
				break;
			}
			case SUBQUERY:
			{
				AST __t278 = _t;
				AST tmp70_AST_in = (AST)_t;
				match(_t,SUBQUERY);
				_t = _t.getFirstChild();
				stmt=select_statement(_t);
				_t = _retTree;
				_t = __t278;
				_t = _t.getNextSibling();
				
							model.addSelectStatement(stmt);
							stmt.setSubquery(true);
						
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
	
	public final ExprContainModel  constexpset(AST _t) throws RecognitionException {
		ExprContainModel model;
		
		AST constexpset_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			model = new ExprContainModel();
			ExprContainModel cep1, cep2;
			String ce, ce1, ce2;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t280 = _t;
				AST tmp71_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				cep1=constexpset(_t);
				_t = _retTree;
				cep2=constexpset(_t);
				_t = _retTree;
				_t = __t280;
				_t = _t.getNextSibling();
				model.addChild(cep1); model.addChild(cep2);
				break;
			}
			case REAL_NUM:
			case QUOTED_STRING:
			{
				ce=constant_expr(_t);
				_t = _retTree;
				model.addConstant(ce);
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
	
	public final String  constant_expr(AST _t) throws RecognitionException {
		String rValue;
		
		AST constant_expr_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST rn = null;
		AST qs = null;
		rValue = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case REAL_NUM:
			{
				rn = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				rValue = rn.getText();
				break;
			}
			case QUOTED_STRING:
			{
				qs = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				rValue = qs.getText();
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
	
	public final void two_arg_op(AST _t) throws RecognitionException {
		
		AST two_arg_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case STAR:
			case PLUS:
			case MINUS:
			case DIVIDE:
			case MOD:
			{
				arithmeticOperator(_t);
				_t = _retTree;
				break;
			}
			case TILDE:
			case AMPERSAND:
			case BITWISEOR:
			case BITWISEXOR:
			{
				bitwiseOperator(_t);
				_t = _retTree;
				break;
			}
			case 319:
			{
				AST tmp72_AST_in = (AST)_t;
				match(_t,319);
				_t = _t.getNextSibling();
				break;
			}
			case 318:
			{
				AST tmp73_AST_in = (AST)_t;
				match(_t,318);
				_t = _t.getNextSibling();
				break;
			}
			case 320:
			{
				AST tmp74_AST_in = (AST)_t;
				match(_t,320);
				_t = _t.getNextSibling();
				break;
			}
			case 321:
			{
				AST tmp75_AST_in = (AST)_t;
				match(_t,321);
				_t = _t.getNextSibling();
				break;
			}
			case 322:
			{
				AST tmp76_AST_in = (AST)_t;
				match(_t,322);
				_t = _t.getNextSibling();
				break;
			}
			case 323:
			{
				AST tmp77_AST_in = (AST)_t;
				match(_t,323);
				_t = _t.getNextSibling();
				break;
			}
			case 324:
			{
				AST tmp78_AST_in = (AST)_t;
				match(_t,324);
				_t = _t.getNextSibling();
				break;
			}
			case 325:
			{
				AST tmp79_AST_in = (AST)_t;
				match(_t,325);
				_t = _t.getNextSibling();
				break;
			}
			case 162:
			{
				AST tmp80_AST_in = (AST)_t;
				match(_t,162);
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
	
	public final FieldModel  field_name(AST _t) throws RecognitionException {
		FieldModel model;
		
		AST field_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
			model=null;
			String tStr = "";
			String fStr = "";
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case POINT:
			{
				AST __t296 = _t;
				AST tmp81_AST_in = (AST)_t;
				match(_t,POINT);
				_t = _t.getFirstChild();
				tStr=sfield_name(_t);
				_t = _retTree;
				fStr=sfield_name(_t);
				_t = _retTree;
				_t = __t296;
				_t = _t.getNextSibling();
				
							model = new FieldModel(fStr, tStr);
							addTableByChName(tStr);
						
				break;
			}
			case PAREN_FIELD:
			case ID:
			{
				fStr=sfield_name(_t);
				_t = _retTree;
				
							model=new FieldModel(fStr);
						
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
	
	public final FunctionModel  function(AST _t) throws RecognitionException {
		FunctionModel model;
		
		AST function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST af = null;
		AST f = null;
		AST rowidfun = null;
		AST stable = null;
		AST nfun = null;
		AST fun1 = null;
		AST funStar = null;
		AST dtf1 = null;
		AST dtf2 = null;
		AST cf1 = null;
		AST cf2 = null;
		AST all1 = null;
		AST af11 = null;
		AST all2 = null;
		AST af12 = null;
		AST dist1 = null;
		AST af21 = null;
		AST dist2 = null;
		AST af22 = null;
		
			model=null;
			ParametersModel p, dtp1, dtp2; 
			ExpressionModel express1 = new ExpressionModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COUNT_EN:
			case COUNT_CN:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				af = _t==ASTNULL ? null : (AST)_t;
				aggregate_func_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				
							model = new AggregateFuncModel(af.getText(), AggregateFuncModel.NO_FILTER, true); 
							model.setParameters(p);
						
				break;
			}
			case FUNCTION:
			{
				AST __t300 = _t;
				AST tmp82_AST_in = (AST)_t;
				match(_t,FUNCTION);
				_t = _t.getFirstChild();
				f = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t300;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(f.getText(), true);
							model.setParameters(p);
						
				break;
			}
			case FUNCTION_ROWID:
			{
				AST __t301 = _t;
				AST tmp83_AST_in = (AST)_t;
				match(_t,FUNCTION_ROWID);
				_t = _t.getFirstChild();
				rowidfun = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				stable = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t301;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(rowidfun.getText(), true);
							TableModel tableModel = new TableModel(stable.getText(), true);
							express1.addTable(tableModel);
							p = new ParametersModel();
							p.addParameter(express1);
							model.setParameters(p);
						
				break;
			}
			case FUNCTION_NOTHING:
			{
				AST __t302 = _t;
				AST tmp84_AST_in = (AST)_t;
				match(_t,FUNCTION_NOTHING);
				_t = _t.getFirstChild();
				nfun = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				_t = __t302;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(nfun.getText(), true);
							model.setNothing(true);
						
				break;
			}
			case FUNCTION_EMPTY_PARAM:
			{
				AST __t303 = _t;
				AST tmp85_AST_in = (AST)_t;
				match(_t,FUNCTION_EMPTY_PARAM);
				_t = _t.getFirstChild();
				fun1 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				_t = __t303;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(fun1.getText(), true);
						
				break;
			}
			case FUNCTION_STAR_PARAM:
			{
				AST __t304 = _t;
				AST tmp86_AST_in = (AST)_t;
				match(_t,FUNCTION_STAR_PARAM);
				_t = _t.getFirstChild();
				funStar = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				_t = __t304;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(funStar.getText(), true);
							express1.addOperator("*");
							p = new ParametersModel();
							p.addParameter(express1);
							model.setParameters(p);
						
				break;
			}
			case FUNCTION_DATA_TYPE:
			{
				AST __t305 = _t;
				AST tmp87_AST_in = (AST)_t;
				match(_t,FUNCTION_DATA_TYPE);
				_t = _t.getFirstChild();
				dtf1 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				dtp1=data_type_parameters(_t);
				_t = _retTree;
				_t = __t305;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(dtf1.getText(), true);
							model.setParameters(dtp1);
						
				break;
			}
			case FUNCTION_AS_DATA_TYPE:
			{
				AST __t306 = _t;
				AST tmp88_AST_in = (AST)_t;
				match(_t,FUNCTION_AS_DATA_TYPE);
				_t = _t.getFirstChild();
				dtf2 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				dtp2=as_data_type_parameters(_t);
				_t = _retTree;
				_t = __t306;
				_t = _t.getNextSibling();
				
							model = new FunctionModel(dtf2.getText(), true);
							model.setParameters(dtp2);
						
				break;
			}
			case ALL_CN:
			{
				AST __t309 = _t;
				all1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,ALL_CN);
				_t = _t.getFirstChild();
				af11 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t309;
				_t = _t.getNextSibling();
				
							model = new AggregateFuncModel(af11.getText(), AggregateFuncModel.ALL, true);
							model.setParameters(p);
						
				break;
			}
			case ALL_EN:
			{
				AST __t310 = _t;
				all2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,ALL_EN);
				_t = _t.getFirstChild();
				af12 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t310;
				_t = _t.getNextSibling();
				
							model = new AggregateFuncModel(af12.getText(), AggregateFuncModel.ALL, true);
							model.setParameters(p);
						
				break;
			}
			case DISTINCT_CN:
			{
				AST __t311 = _t;
				dist1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DISTINCT_CN);
				_t = _t.getFirstChild();
				af21 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t311;
				_t = _t.getNextSibling();
				
							model = new AggregateFuncModel(af21.getText(), AggregateFuncModel.DISTINCT, true);
							model.setParameters(p);
						
				break;
			}
			case DISTINCT_EN:
			{
				AST __t312 = _t;
				dist2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,DISTINCT_EN);
				_t = _t.getFirstChild();
				af22 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t312;
				_t = _t.getNextSibling();
				
							model=new AggregateFuncModel(af22.getText(), AggregateFuncModel.DISTINCT, true);
							model.setParameters(p);
						
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==FUNCTION_STAR_COUNT)) {
					AST __t307 = _t;
					AST tmp89_AST_in = (AST)_t;
					match(_t,FUNCTION_STAR_COUNT);
					_t = _t.getFirstChild();
					cf1 = (AST)_t;
					match(_t,COUNT_CN);
					_t = _t.getNextSibling();
					_t = __t307;
					_t = _t.getNextSibling();
						
								model = new AggregateFuncModel(cf1.getText(), AggregateFuncModel.NO_FILTER, true);
								express1.addOperator("*");
								p = new ParametersModel();
								p.addParameter(express1);
								model.setParameters(p);
							
				}
				else if ((_t.getType()==FUNCTION_STAR_COUNT)) {
					AST __t308 = _t;
					AST tmp90_AST_in = (AST)_t;
					match(_t,FUNCTION_STAR_COUNT);
					_t = _t.getFirstChild();
					cf2 = (AST)_t;
					match(_t,COUNT_EN);
					_t = _t.getNextSibling();
					_t = __t308;
					_t = _t.getNextSibling();
						
								model = new AggregateFuncModel(cf2.getText(), AggregateFuncModel.NO_FILTER, true);
								express1.addOperator("*");
								p = new ParametersModel();
								p.addParameter(express1);
								model.setParameters(p);
							
				}
			else {
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
	
	public final OrderAliasModel  orderAlias(AST _t) throws RecognitionException {
		OrderAliasModel model;
		
		AST orderAlias_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST a1 = null;
		AST a2 = null;
		model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case QUOTED_STRING:
			{
				a1 = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				model=new OrderAliasModel(a1.getText());
				break;
			}
			case ID:
			{
				a2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				model=new OrderAliasModel(a2.getText());
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
	
	public final void one_arg_op(AST _t) throws RecognitionException {
		
		AST one_arg_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TILDE:
			{
				AST tmp91_AST_in = (AST)_t;
				match(_t,TILDE);
				_t = _t.getNextSibling();
				break;
			}
			case 318:
			{
				AST tmp92_AST_in = (AST)_t;
				match(_t,318);
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
	
	public final void date_key_word(AST _t) throws RecognitionException {
		
		AST date_key_word_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_year:
			{
				AST tmp93_AST_in = (AST)_t;
				match(_t,LITERAL_year);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_yy:
			{
				AST tmp94_AST_in = (AST)_t;
				match(_t,LITERAL_yy);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_month:
			{
				AST tmp95_AST_in = (AST)_t;
				match(_t,LITERAL_month);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mm:
			{
				AST tmp96_AST_in = (AST)_t;
				match(_t,LITERAL_mm);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_day:
			{
				AST tmp97_AST_in = (AST)_t;
				match(_t,LITERAL_day);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dd:
			{
				AST tmp98_AST_in = (AST)_t;
				match(_t,LITERAL_dd);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_quarter:
			{
				AST tmp99_AST_in = (AST)_t;
				match(_t,LITERAL_quarter);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_qq:
			{
				AST tmp100_AST_in = (AST)_t;
				match(_t,LITERAL_qq);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_week:
			{
				AST tmp101_AST_in = (AST)_t;
				match(_t,LITERAL_week);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_wk:
			{
				AST tmp102_AST_in = (AST)_t;
				match(_t,LITERAL_wk);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dayofyear:
			{
				AST tmp103_AST_in = (AST)_t;
				match(_t,LITERAL_dayofyear);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dy:
			{
				AST tmp104_AST_in = (AST)_t;
				match(_t,LITERAL_dy);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_weekday:
			{
				AST tmp105_AST_in = (AST)_t;
				match(_t,LITERAL_weekday);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dw:
			{
				AST tmp106_AST_in = (AST)_t;
				match(_t,LITERAL_dw);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hour:
			{
				AST tmp107_AST_in = (AST)_t;
				match(_t,LITERAL_hour);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hh:
			{
				AST tmp108_AST_in = (AST)_t;
				match(_t,LITERAL_hh);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minute:
			{
				AST tmp109_AST_in = (AST)_t;
				match(_t,LITERAL_minute);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mi:
			{
				AST tmp110_AST_in = (AST)_t;
				match(_t,LITERAL_mi);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_second:
			{
				AST tmp111_AST_in = (AST)_t;
				match(_t,LITERAL_second);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ss:
			{
				AST tmp112_AST_in = (AST)_t;
				match(_t,LITERAL_ss);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_millisecond:
			{
				AST tmp113_AST_in = (AST)_t;
				match(_t,LITERAL_millisecond);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ms:
			{
				AST tmp114_AST_in = (AST)_t;
				match(_t,LITERAL_ms);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_calweekofyear:
			{
				AST tmp115_AST_in = (AST)_t;
				match(_t,LITERAL_calweekofyear);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cwk:
			{
				AST tmp116_AST_in = (AST)_t;
				match(_t,LITERAL_cwk);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_calyearofweek:
			{
				AST tmp117_AST_in = (AST)_t;
				match(_t,LITERAL_calyearofweek);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cyr:
			{
				AST tmp118_AST_in = (AST)_t;
				match(_t,LITERAL_cyr);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_caldayofweek:
			{
				AST tmp119_AST_in = (AST)_t;
				match(_t,LITERAL_caldayofweek);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cdw:
			{
				AST tmp120_AST_in = (AST)_t;
				match(_t,LITERAL_cdw);
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
	
	public final ParamModel  param_equ(AST _t) throws RecognitionException {
		ParamModel model;
		
		AST param_equ_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST paramName = null;
		model = null;
		
		try {      // for error handling
			paramName = (AST)_t;
			match(_t,PARAM_ID);
			_t = _t.getNextSibling();
			model = new ParamModel(paramName.getText(), "{", "}");
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return model;
	}
	
	public final String  sfield_name(AST _t) throws RecognitionException {
		String rValue;
		
		AST sfield_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST f1 = null;
		AST f2 = null;
		AST f = null;
		rValue = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PAREN_FIELD:
			{
				AST __t298 = _t;
				AST tmp121_AST_in = (AST)_t;
				match(_t,PAREN_FIELD);
				_t = _t.getFirstChild();
				f1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				f2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t298;
				_t = _t.getNextSibling();
				rValue = f1.getText() + "(" + f2.getText() + ")";
				break;
			}
			case ID:
			{
				f = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				rValue = f.getText();
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
	
	public final void aggregate_func_name(AST _t) throws RecognitionException {
		
		AST aggregate_func_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_avg:
			{
				AST tmp122_AST_in = (AST)_t;
				match(_t,LITERAL_avg);
				_t = _t.getNextSibling();
				break;
			}
			case 104:
			{
				AST tmp123_AST_in = (AST)_t;
				match(_t,104);
				_t = _t.getNextSibling();
				break;
			}
			case COUNT_EN:
			{
				AST tmp124_AST_in = (AST)_t;
				match(_t,COUNT_EN);
				_t = _t.getNextSibling();
				break;
			}
			case COUNT_CN:
			{
				AST tmp125_AST_in = (AST)_t;
				match(_t,COUNT_CN);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_max:
			{
				AST tmp126_AST_in = (AST)_t;
				match(_t,LITERAL_max);
				_t = _t.getNextSibling();
				break;
			}
			case 106:
			{
				AST tmp127_AST_in = (AST)_t;
				match(_t,106);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_min:
			{
				AST tmp128_AST_in = (AST)_t;
				match(_t,LITERAL_min);
				_t = _t.getNextSibling();
				break;
			}
			case 108:
			{
				AST tmp129_AST_in = (AST)_t;
				match(_t,108);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_stddev:
			{
				AST tmp130_AST_in = (AST)_t;
				match(_t,LITERAL_stddev);
				_t = _t.getNextSibling();
				break;
			}
			case 110:
			{
				AST tmp131_AST_in = (AST)_t;
				match(_t,110);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sum:
			{
				AST tmp132_AST_in = (AST)_t;
				match(_t,LITERAL_sum);
				_t = _t.getNextSibling();
				break;
			}
			case 112:
			{
				AST tmp133_AST_in = (AST)_t;
				match(_t,112);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_variance:
			{
				AST tmp134_AST_in = (AST)_t;
				match(_t,LITERAL_variance);
				_t = _t.getNextSibling();
				break;
			}
			case 114:
			{
				AST tmp135_AST_in = (AST)_t;
				match(_t,114);
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
	
	public final ParametersModel  parameters(AST _t) throws RecognitionException {
		ParametersModel model;
		
		AST parameters_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		ParametersModel p1, p2; ExpressionModel e; model=new ParametersModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t314 = _t;
				AST tmp136_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				p1=parameters(_t);
				_t = _retTree;
				p2=parameters(_t);
				_t = _retTree;
				_t = __t314;
				_t = _t.getNextSibling();
				model.addChild(p1); model.addChild(p2);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case ALL_FIELDS:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case REAL_NUM:
			case LPAREN:
			case NULL_EN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case PARAM_ID:
			case QUOTED_STRING:
			case POINT:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			case LITERAL_day:
			case LITERAL_hour:
			case LITERAL_minute:
			case LITERAL_month:
			case LITERAL_quarter:
			case LITERAL_second:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_mm:
			case LITERAL_dd:
			case LITERAL_qq:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hh:
			case LITERAL_mi:
			case LITERAL_ss:
			case LITERAL_millisecond:
			case LITERAL_ms:
			case LITERAL_calweekofyear:
			case LITERAL_cwk:
			case LITERAL_calyearofweek:
			case LITERAL_cyr:
			case LITERAL_caldayofweek:
			case LITERAL_cdw:
			case TWO_ARG_OP:
			case ONE_ARG_OP:
			{
				e=expression(_t);
				_t = _retTree;
				model.addParameter(e);
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
	
	public final void function_name(AST _t) throws RecognitionException {
		
		AST function_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_rand:
			case 120:
			case LITERAL_pi:
			case 125:
			case LITERAL_abs:
			case 136:
			case LITERAL_acos:
			case 138:
			case LITERAL_asin:
			case 140:
			case LITERAL_atan:
			case 142:
			case 143:
			case 144:
			case LITERAL_ceiling:
			case 146:
			case LITERAL_cos:
			case 148:
			case LITERAL_cot:
			case 150:
			case LITERAL_degrees:
			case 152:
			case LITERAL_exp:
			case 154:
			case LITERAL_floor:
			case 156:
			case LITERAL_log:
			case 158:
			case 159:
			case 160:
			case LITERAL_mod:
			case 162:
			case LITERAL_power:
			case 164:
			case LITERAL_radians:
			case 166:
			case LITERAL_remainder:
			case 168:
			case LITERAL_round:
			case 170:
			case LITERAL_sign:
			case 172:
			case LITERAL_sin:
			case 174:
			case LITERAL_sqrt:
			case 176:
			case LITERAL_tan:
			case 178:
			case 179:
			case LITERAL_truncnum:
			case 181:
			{
				number_function(_t);
				_t = _retTree;
				break;
			}
			case CHAR:
			case LITERAL_ascii:
			case 183:
			case LITERAL_bit_length:
			case 185:
			case LITERAL_byte_length:
			case 187:
			case 188:
			case LITERAL_char_length:
			case 190:
			case LITERAL_charindex:
			case 192:
			case LITERAL_difference:
			case 194:
			case LITERAL_insertstr:
			case 196:
			case LITERAL_lcase:
			case 198:
			case LITERAL_left:
			case 200:
			case LITERAL_length:
			case 202:
			case LITERAL_locate:
			case 204:
			case LITERAL_lower:
			case 206:
			case LITERAL_ltrim:
			case 208:
			case LITERAL_octet_length:
			case 210:
			case LITERAL_patindex:
			case 212:
			case LITERAL_repeat:
			case 214:
			case LITERAL_replace:
			case 216:
			case LITERAL_replicate:
			case 218:
			case LITERAL_right:
			case 220:
			case LITERAL_rtrim:
			case 222:
			case LITERAL_similar:
			case 224:
			case LITERAL_sortkey:
			case 226:
			case LITERAL_soundex:
			case 228:
			case LITERAL_space:
			case 230:
			case LITERAL_str:
			case 232:
			case LITERAL_string:
			case 234:
			case LITERAL_stuff:
			case 236:
			case LITERAL_substring:
			case 238:
			case LITERAL_trim:
			case 240:
			case LITERAL_ucase:
			case 242:
			case LITERAL_upper:
			case 244:
			{
				string_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_getdate:
			case 118:
			case LITERAL_now:
			case 127:
			case LITERAL_today:
			case 129:
			case LITERAL_dateformat:
			case 246:
			case LITERAL_datename:
			case 248:
			case LITERAL_datepart:
			case 250:
			case LITERAL_datetime:
			case 252:
			case LITERAL_date:
			case 254:
			case LITERAL_dayname:
			case 256:
			case LITERAL_days:
			case 258:
			case LITERAL_day:
			case 260:
			case LITERAL_dow:
			case 262:
			case LITERAL_hours:
			case 264:
			case LITERAL_hour:
			case 266:
			case LITERAL_minutes:
			case 268:
			case LITERAL_minute:
			case 270:
			case LITERAL_monthname:
			case 272:
			case LITERAL_months:
			case 274:
			case LITERAL_month:
			case 276:
			case LITERAL_quarter:
			case 278:
			case LITERAL_seconds:
			case 280:
			case LITERAL_second:
			case 282:
			case LITERAL_weeks:
			case 284:
			case LITERAL_years:
			case 286:
			case LITERAL_year:
			case 288:
			case LITERAL_ymd:
			case 290:
			case LITERAL_dateadd:
			case 292:
			case LITERAL_datediff:
			case 294:
			{
				datetime_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_convert:
			case 132:
			case LITERAL_cast:
			case 134:
			case LITERAL_hextoint:
			case 296:
			case LITERAL_inttohex:
			case 298:
			case LITERAL_isdate:
			case 300:
			case LITERAL_isnumeric:
			case 302:
			{
				conversion_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_suser_id:
			case LITERAL_suser_name:
			case LITERAL_user_id:
			case LITERAL_user_name:
			{
				system_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_dense_rank:
			case LITERAL_percent_rank:
			case LITERAL_rank:
			case LITERAL_ntile:
			case LITERAL_percentile_count:
			case LITERAL_percentile_desc:
			{
				analytical_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_number:
			case LITERAL_rowid:
			case 308:
			case LITERAL_argn:
			case LITERAL_coalesce:
			case LITERAL_ifnull:
			case LITERAL_isnull:
			case LITERAL_nullif:
			{
				miscellane_function(_t);
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
	}
	
	public final ParametersModel  data_type_parameters(AST _t) throws RecognitionException {
		ParametersModel model;
		
		AST data_type_parameters_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		ParametersModel p1, p2; ExpressionModel dtc, e; model=new ParametersModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t316 = _t;
				AST tmp137_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				p1=data_type_parameters(_t);
				_t = _retTree;
				p2=data_type_parameters(_t);
				_t = _retTree;
				_t = __t316;
				_t = _t.getNextSibling();
				model.addChild(p1);model.addChild(p2);
				break;
			}
			case PAREN_DATA_TYPE:
			case PAREN_CHAR_DATA_TYPE:
			case CHAR:
			case DATA_TYPE_STRING:
			case LITERAL_datetime:
			case LITERAL_date:
			case LITERAL_uniqueidentifierstr:
			case LITERAL_bigint:
			case LITERAL_int:
			case LITERAL_integer:
			case LITERAL_smallint:
			case LITERAL_tinyint:
			case LITERAL_double:
			case LITERAL_real:
			case LITERAL_smalldatetime:
			case LITERAL_time:
			case LITERAL_timestamp:
			case LITERAL_bit:
			{
				dtc=datatype_constant(_t);
				_t = _retTree;
				model.addParameter(dtc);
				break;
			}
			case FUNCTION:
			case FUNCTION_ROWID:
			case FUNCTION_NOTHING:
			case FUNCTION_EMPTY_PARAM:
			case FUNCTION_STAR_PARAM:
			case FUNCTION_STAR_COUNT:
			case FUNCTION_DATA_TYPE:
			case FUNCTION_AS_DATA_TYPE:
			case ALL_FIELDS:
			case PAREN_FIELD:
			case DISTINCT_EN:
			case DISTINCT_CN:
			case REAL_NUM:
			case LPAREN:
			case NULL_EN:
			case COUNT_EN:
			case COUNT_CN:
			case ALL_EN:
			case ALL_CN:
			case ID:
			case PARAM_ID:
			case QUOTED_STRING:
			case POINT:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			case LITERAL_day:
			case LITERAL_hour:
			case LITERAL_minute:
			case LITERAL_month:
			case LITERAL_quarter:
			case LITERAL_second:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_mm:
			case LITERAL_dd:
			case LITERAL_qq:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hh:
			case LITERAL_mi:
			case LITERAL_ss:
			case LITERAL_millisecond:
			case LITERAL_ms:
			case LITERAL_calweekofyear:
			case LITERAL_cwk:
			case LITERAL_calyearofweek:
			case LITERAL_cyr:
			case LITERAL_caldayofweek:
			case LITERAL_cdw:
			case TWO_ARG_OP:
			case ONE_ARG_OP:
			{
				e=expression(_t);
				_t = _retTree;
				model.addParameter(e);
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
	
	public final ParametersModel  as_data_type_parameters(AST _t) throws RecognitionException {
		ParametersModel model;
		
		AST as_data_type_parameters_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		ParametersModel p1, p2; ExpressionModel adtc, e, re; model=new ParametersModel();
		
		try {      // for error handling
			e=expression(_t);
			_t = _retTree;
			adtc=datatype_constant(_t);
			_t = _retTree;
			
				   		model.addParameter(e);
				   		model.addParameter(adtc);
				   		model.addFilter(ParametersModel.AS);
				   	
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return model;
	}
	
	public final ExpressionModel  datatype_constant(AST _t) throws RecognitionException {
		ExpressionModel model;
		
		AST datatype_constant_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST c1 = null;
		AST c2 = null;
		AST dtw = null;
		AST dts = null;
		AST sdts = null;
		model=new ExpressionModel(); String rValue = ""; String rp = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CHAR:
			{
				c1 = (AST)_t;
				match(_t,CHAR);
				_t = _t.getNextSibling();
				
							//\u8fd4\u56dechar\u4fdd\u7559\u5b57
							rValue = c1.getText();
							model.addConstant(rValue);
						
				break;
			}
			case PAREN_CHAR_DATA_TYPE:
			{
				AST __t319 = _t;
				AST tmp138_AST_in = (AST)_t;
				match(_t,PAREN_CHAR_DATA_TYPE);
				_t = _t.getFirstChild();
				c2 = (AST)_t;
				match(_t,CHAR);
				_t = _t.getNextSibling();
				rp=datatype_precision_or_scale_or_maxlength(_t);
				_t = _retTree;
				_t = __t319;
				_t = _t.getNextSibling();
				
							//\u8fd4\u56de\u5e26\u53c2\u6570char\u4fdd\u7559
							rValue = c2.getText() + "(" + rp + ")";
							model.addConstant(rValue);
						
				break;
			}
			case LITERAL_datetime:
			case LITERAL_date:
			case LITERAL_uniqueidentifierstr:
			case LITERAL_bigint:
			case LITERAL_int:
			case LITERAL_integer:
			case LITERAL_smallint:
			case LITERAL_tinyint:
			case LITERAL_double:
			case LITERAL_real:
			case LITERAL_smalldatetime:
			case LITERAL_time:
			case LITERAL_timestamp:
			case LITERAL_bit:
			{
				dtw = _t==ASTNULL ? null : (AST)_t;
				data_type_word(_t);
				_t = _retTree;
				
							//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u4fdd\u7559\u5b57(date\u3001datetime...)
							rValue = dtw.getText();
							model.addConstant(rValue);
						
				break;
			}
			case PAREN_DATA_TYPE:
			{
				AST __t320 = _t;
				AST tmp139_AST_in = (AST)_t;
				match(_t,PAREN_DATA_TYPE);
				_t = _t.getFirstChild();
				dts = (AST)_t;
				match(_t,DATA_TYPE_STRING);
				_t = _t.getNextSibling();
				rp=datatype_precision_or_scale_or_maxlength(_t);
				_t = _retTree;
				_t = __t320;
				_t = _t.getNextSibling();
				
							//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u52a0\u5176\u53c2\u6570,\u5982char(10)\u3001numeric(20, 2)]
							rValue = dts.getText() + "(" + rp + ")";
							model.addConstant(rValue);
						
				break;
			}
			case DATA_TYPE_STRING:
			{
				sdts = (AST)_t;
				match(_t,DATA_TYPE_STRING);
				_t = _t.getNextSibling();
				
							//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u4e3a\u53ef\u4e0d\u5e26\u53c2\u6570]
							rValue = sdts.getText();
							model.addConstant(rValue);
						
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
	
	public final String  datatype_precision_or_scale_or_maxlength(AST _t) throws RecognitionException {
		String rValue;
		
		AST datatype_precision_or_scale_or_maxlength_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST rn1 = null;
		AST rn2 = null;
		AST rn = null;
		rValue = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t322 = _t;
				AST tmp140_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				rn1 = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				rn2 = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				_t = __t322;
				_t = _t.getNextSibling();
				rValue = rn1.getText() + ", " + rn2.getText();
				break;
			}
			case REAL_NUM:
			{
				rn = (AST)_t;
				match(_t,REAL_NUM);
				_t = _t.getNextSibling();
				rValue = rn.getText();
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
	
	public final void data_type_word(AST _t) throws RecognitionException {
		
		AST data_type_word_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_uniqueidentifierstr:
			{
				AST tmp141_AST_in = (AST)_t;
				match(_t,LITERAL_uniqueidentifierstr);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_bigint:
			{
				AST tmp142_AST_in = (AST)_t;
				match(_t,LITERAL_bigint);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_int:
			{
				AST tmp143_AST_in = (AST)_t;
				match(_t,LITERAL_int);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_integer:
			{
				AST tmp144_AST_in = (AST)_t;
				match(_t,LITERAL_integer);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_smallint:
			{
				AST tmp145_AST_in = (AST)_t;
				match(_t,LITERAL_smallint);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_tinyint:
			{
				AST tmp146_AST_in = (AST)_t;
				match(_t,LITERAL_tinyint);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_double:
			{
				AST tmp147_AST_in = (AST)_t;
				match(_t,LITERAL_double);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_real:
			{
				AST tmp148_AST_in = (AST)_t;
				match(_t,LITERAL_real);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_date:
			{
				AST tmp149_AST_in = (AST)_t;
				match(_t,LITERAL_date);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datetime:
			{
				AST tmp150_AST_in = (AST)_t;
				match(_t,LITERAL_datetime);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_smalldatetime:
			{
				AST tmp151_AST_in = (AST)_t;
				match(_t,LITERAL_smalldatetime);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_time:
			{
				AST tmp152_AST_in = (AST)_t;
				match(_t,LITERAL_time);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_timestamp:
			{
				AST tmp153_AST_in = (AST)_t;
				match(_t,LITERAL_timestamp);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_bit:
			{
				AST tmp154_AST_in = (AST)_t;
				match(_t,LITERAL_bit);
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
	
	public final TableAliasModel  tableAlias(AST _t) throws RecognitionException {
		TableAliasModel model;
		
		AST tableAlias_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST a1 = null;
		AST a2 = null;
		model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case QUOTED_STRING:
			{
				a1 = (AST)_t;
				match(_t,QUOTED_STRING);
				_t = _t.getNextSibling();
				model = new TableAliasModel(a1.getText());
				break;
			}
			case ID:
			{
				a2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				model = new TableAliasModel(a2.getText());
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
	
	public final void arithmeticOperator(AST _t) throws RecognitionException {
		
		AST arithmeticOperator_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case PLUS:
			{
				AST tmp155_AST_in = (AST)_t;
				match(_t,PLUS);
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST tmp156_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST tmp157_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getNextSibling();
				break;
			}
			case DIVIDE:
			{
				AST tmp158_AST_in = (AST)_t;
				match(_t,DIVIDE);
				_t = _t.getNextSibling();
				break;
			}
			case MOD:
			{
				AST tmp159_AST_in = (AST)_t;
				match(_t,MOD);
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
	
	public final void bitwiseOperator(AST _t) throws RecognitionException {
		
		AST bitwiseOperator_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case AMPERSAND:
			{
				AST tmp160_AST_in = (AST)_t;
				match(_t,AMPERSAND);
				_t = _t.getNextSibling();
				break;
			}
			case TILDE:
			{
				AST tmp161_AST_in = (AST)_t;
				match(_t,TILDE);
				_t = _t.getNextSibling();
				break;
			}
			case BITWISEOR:
			{
				AST tmp162_AST_in = (AST)_t;
				match(_t,BITWISEOR);
				_t = _t.getNextSibling();
				break;
			}
			case BITWISEXOR:
			{
				AST tmp163_AST_in = (AST)_t;
				match(_t,BITWISEXOR);
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
	
	public final void alias_equ_op(AST _t) throws RecognitionException {
		
		AST alias_equ_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGNEQUAL:
			{
				AST tmp164_AST_in = (AST)_t;
				match(_t,ASSIGNEQUAL);
				_t = _t.getNextSibling();
				break;
			}
			case 72:
			{
				AST tmp165_AST_in = (AST)_t;
				match(_t,72);
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
	
	public final void comparisonOperator(AST _t) throws RecognitionException {
		
		AST comparisonOperator_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ASSIGNEQUAL:
			{
				AST tmp166_AST_in = (AST)_t;
				match(_t,ASSIGNEQUAL);
				_t = _t.getNextSibling();
				break;
			}
			case NOTEQUAL1:
			{
				AST tmp167_AST_in = (AST)_t;
				match(_t,NOTEQUAL1);
				_t = _t.getNextSibling();
				break;
			}
			case NOTEQUAL2:
			{
				AST tmp168_AST_in = (AST)_t;
				match(_t,NOTEQUAL2);
				_t = _t.getNextSibling();
				break;
			}
			case LESSTHANOREQUALTO1:
			{
				AST tmp169_AST_in = (AST)_t;
				match(_t,LESSTHANOREQUALTO1);
				_t = _t.getNextSibling();
				break;
			}
			case LESSTHANOREQUALTO2:
			{
				AST tmp170_AST_in = (AST)_t;
				match(_t,LESSTHANOREQUALTO2);
				_t = _t.getNextSibling();
				break;
			}
			case LESSTHAN:
			{
				AST tmp171_AST_in = (AST)_t;
				match(_t,LESSTHAN);
				_t = _t.getNextSibling();
				break;
			}
			case GREATERTHANOREQUALTO1:
			{
				AST tmp172_AST_in = (AST)_t;
				match(_t,GREATERTHANOREQUALTO1);
				_t = _t.getNextSibling();
				break;
			}
			case GREATERTHANOREQUALTO2:
			{
				AST tmp173_AST_in = (AST)_t;
				match(_t,GREATERTHANOREQUALTO2);
				_t = _t.getNextSibling();
				break;
			}
			case GREATERTHAN:
			{
				AST tmp174_AST_in = (AST)_t;
				match(_t,GREATERTHAN);
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
	
	public final void number_function(AST _t) throws RecognitionException {
		
		AST number_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_abs:
			{
				AST tmp175_AST_in = (AST)_t;
				match(_t,LITERAL_abs);
				_t = _t.getNextSibling();
				break;
			}
			case 136:
			{
				AST tmp176_AST_in = (AST)_t;
				match(_t,136);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_acos:
			{
				AST tmp177_AST_in = (AST)_t;
				match(_t,LITERAL_acos);
				_t = _t.getNextSibling();
				break;
			}
			case 138:
			{
				AST tmp178_AST_in = (AST)_t;
				match(_t,138);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_asin:
			{
				AST tmp179_AST_in = (AST)_t;
				match(_t,LITERAL_asin);
				_t = _t.getNextSibling();
				break;
			}
			case 140:
			{
				AST tmp180_AST_in = (AST)_t;
				match(_t,140);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_atan:
			{
				AST tmp181_AST_in = (AST)_t;
				match(_t,LITERAL_atan);
				_t = _t.getNextSibling();
				break;
			}
			case 142:
			{
				AST tmp182_AST_in = (AST)_t;
				match(_t,142);
				_t = _t.getNextSibling();
				break;
			}
			case 143:
			{
				AST tmp183_AST_in = (AST)_t;
				match(_t,143);
				_t = _t.getNextSibling();
				break;
			}
			case 144:
			{
				AST tmp184_AST_in = (AST)_t;
				match(_t,144);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ceiling:
			{
				AST tmp185_AST_in = (AST)_t;
				match(_t,LITERAL_ceiling);
				_t = _t.getNextSibling();
				break;
			}
			case 146:
			{
				AST tmp186_AST_in = (AST)_t;
				match(_t,146);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cos:
			{
				AST tmp187_AST_in = (AST)_t;
				match(_t,LITERAL_cos);
				_t = _t.getNextSibling();
				break;
			}
			case 148:
			{
				AST tmp188_AST_in = (AST)_t;
				match(_t,148);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cot:
			{
				AST tmp189_AST_in = (AST)_t;
				match(_t,LITERAL_cot);
				_t = _t.getNextSibling();
				break;
			}
			case 150:
			{
				AST tmp190_AST_in = (AST)_t;
				match(_t,150);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_degrees:
			{
				AST tmp191_AST_in = (AST)_t;
				match(_t,LITERAL_degrees);
				_t = _t.getNextSibling();
				break;
			}
			case 152:
			{
				AST tmp192_AST_in = (AST)_t;
				match(_t,152);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_exp:
			{
				AST tmp193_AST_in = (AST)_t;
				match(_t,LITERAL_exp);
				_t = _t.getNextSibling();
				break;
			}
			case 154:
			{
				AST tmp194_AST_in = (AST)_t;
				match(_t,154);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_floor:
			{
				AST tmp195_AST_in = (AST)_t;
				match(_t,LITERAL_floor);
				_t = _t.getNextSibling();
				break;
			}
			case 156:
			{
				AST tmp196_AST_in = (AST)_t;
				match(_t,156);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_log:
			{
				AST tmp197_AST_in = (AST)_t;
				match(_t,LITERAL_log);
				_t = _t.getNextSibling();
				break;
			}
			case 158:
			{
				AST tmp198_AST_in = (AST)_t;
				match(_t,158);
				_t = _t.getNextSibling();
				break;
			}
			case 159:
			{
				AST tmp199_AST_in = (AST)_t;
				match(_t,159);
				_t = _t.getNextSibling();
				break;
			}
			case 160:
			{
				AST tmp200_AST_in = (AST)_t;
				match(_t,160);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mod:
			{
				AST tmp201_AST_in = (AST)_t;
				match(_t,LITERAL_mod);
				_t = _t.getNextSibling();
				break;
			}
			case 162:
			{
				AST tmp202_AST_in = (AST)_t;
				match(_t,162);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_pi:
			{
				AST tmp203_AST_in = (AST)_t;
				match(_t,LITERAL_pi);
				_t = _t.getNextSibling();
				break;
			}
			case 125:
			{
				AST tmp204_AST_in = (AST)_t;
				match(_t,125);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_power:
			{
				AST tmp205_AST_in = (AST)_t;
				match(_t,LITERAL_power);
				_t = _t.getNextSibling();
				break;
			}
			case 164:
			{
				AST tmp206_AST_in = (AST)_t;
				match(_t,164);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_radians:
			{
				AST tmp207_AST_in = (AST)_t;
				match(_t,LITERAL_radians);
				_t = _t.getNextSibling();
				break;
			}
			case 166:
			{
				AST tmp208_AST_in = (AST)_t;
				match(_t,166);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rand:
			{
				AST tmp209_AST_in = (AST)_t;
				match(_t,LITERAL_rand);
				_t = _t.getNextSibling();
				break;
			}
			case 120:
			{
				AST tmp210_AST_in = (AST)_t;
				match(_t,120);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_remainder:
			{
				AST tmp211_AST_in = (AST)_t;
				match(_t,LITERAL_remainder);
				_t = _t.getNextSibling();
				break;
			}
			case 168:
			{
				AST tmp212_AST_in = (AST)_t;
				match(_t,168);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_round:
			{
				AST tmp213_AST_in = (AST)_t;
				match(_t,LITERAL_round);
				_t = _t.getNextSibling();
				break;
			}
			case 170:
			{
				AST tmp214_AST_in = (AST)_t;
				match(_t,170);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sign:
			{
				AST tmp215_AST_in = (AST)_t;
				match(_t,LITERAL_sign);
				_t = _t.getNextSibling();
				break;
			}
			case 172:
			{
				AST tmp216_AST_in = (AST)_t;
				match(_t,172);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sin:
			{
				AST tmp217_AST_in = (AST)_t;
				match(_t,LITERAL_sin);
				_t = _t.getNextSibling();
				break;
			}
			case 174:
			{
				AST tmp218_AST_in = (AST)_t;
				match(_t,174);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sqrt:
			{
				AST tmp219_AST_in = (AST)_t;
				match(_t,LITERAL_sqrt);
				_t = _t.getNextSibling();
				break;
			}
			case 176:
			{
				AST tmp220_AST_in = (AST)_t;
				match(_t,176);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_tan:
			{
				AST tmp221_AST_in = (AST)_t;
				match(_t,LITERAL_tan);
				_t = _t.getNextSibling();
				break;
			}
			case 178:
			{
				AST tmp222_AST_in = (AST)_t;
				match(_t,178);
				_t = _t.getNextSibling();
				break;
			}
			case 179:
			{
				AST tmp223_AST_in = (AST)_t;
				match(_t,179);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_truncnum:
			{
				AST tmp224_AST_in = (AST)_t;
				match(_t,LITERAL_truncnum);
				_t = _t.getNextSibling();
				break;
			}
			case 181:
			{
				AST tmp225_AST_in = (AST)_t;
				match(_t,181);
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
	
	public final void string_function(AST _t) throws RecognitionException {
		
		AST string_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_ascii:
			{
				AST tmp226_AST_in = (AST)_t;
				match(_t,LITERAL_ascii);
				_t = _t.getNextSibling();
				break;
			}
			case 183:
			{
				AST tmp227_AST_in = (AST)_t;
				match(_t,183);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_bit_length:
			{
				AST tmp228_AST_in = (AST)_t;
				match(_t,LITERAL_bit_length);
				_t = _t.getNextSibling();
				break;
			}
			case 185:
			{
				AST tmp229_AST_in = (AST)_t;
				match(_t,185);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_byte_length:
			{
				AST tmp230_AST_in = (AST)_t;
				match(_t,LITERAL_byte_length);
				_t = _t.getNextSibling();
				break;
			}
			case 187:
			{
				AST tmp231_AST_in = (AST)_t;
				match(_t,187);
				_t = _t.getNextSibling();
				break;
			}
			case CHAR:
			{
				AST tmp232_AST_in = (AST)_t;
				match(_t,CHAR);
				_t = _t.getNextSibling();
				break;
			}
			case 188:
			{
				AST tmp233_AST_in = (AST)_t;
				match(_t,188);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char_length:
			{
				AST tmp234_AST_in = (AST)_t;
				match(_t,LITERAL_char_length);
				_t = _t.getNextSibling();
				break;
			}
			case 190:
			{
				AST tmp235_AST_in = (AST)_t;
				match(_t,190);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_charindex:
			{
				AST tmp236_AST_in = (AST)_t;
				match(_t,LITERAL_charindex);
				_t = _t.getNextSibling();
				break;
			}
			case 192:
			{
				AST tmp237_AST_in = (AST)_t;
				match(_t,192);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_difference:
			{
				AST tmp238_AST_in = (AST)_t;
				match(_t,LITERAL_difference);
				_t = _t.getNextSibling();
				break;
			}
			case 194:
			{
				AST tmp239_AST_in = (AST)_t;
				match(_t,194);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_insertstr:
			{
				AST tmp240_AST_in = (AST)_t;
				match(_t,LITERAL_insertstr);
				_t = _t.getNextSibling();
				break;
			}
			case 196:
			{
				AST tmp241_AST_in = (AST)_t;
				match(_t,196);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lcase:
			{
				AST tmp242_AST_in = (AST)_t;
				match(_t,LITERAL_lcase);
				_t = _t.getNextSibling();
				break;
			}
			case 198:
			{
				AST tmp243_AST_in = (AST)_t;
				match(_t,198);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_left:
			{
				AST tmp244_AST_in = (AST)_t;
				match(_t,LITERAL_left);
				_t = _t.getNextSibling();
				break;
			}
			case 200:
			{
				AST tmp245_AST_in = (AST)_t;
				match(_t,200);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_length:
			{
				AST tmp246_AST_in = (AST)_t;
				match(_t,LITERAL_length);
				_t = _t.getNextSibling();
				break;
			}
			case 202:
			{
				AST tmp247_AST_in = (AST)_t;
				match(_t,202);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_locate:
			{
				AST tmp248_AST_in = (AST)_t;
				match(_t,LITERAL_locate);
				_t = _t.getNextSibling();
				break;
			}
			case 204:
			{
				AST tmp249_AST_in = (AST)_t;
				match(_t,204);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lower:
			{
				AST tmp250_AST_in = (AST)_t;
				match(_t,LITERAL_lower);
				_t = _t.getNextSibling();
				break;
			}
			case 206:
			{
				AST tmp251_AST_in = (AST)_t;
				match(_t,206);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ltrim:
			{
				AST tmp252_AST_in = (AST)_t;
				match(_t,LITERAL_ltrim);
				_t = _t.getNextSibling();
				break;
			}
			case 208:
			{
				AST tmp253_AST_in = (AST)_t;
				match(_t,208);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_octet_length:
			{
				AST tmp254_AST_in = (AST)_t;
				match(_t,LITERAL_octet_length);
				_t = _t.getNextSibling();
				break;
			}
			case 210:
			{
				AST tmp255_AST_in = (AST)_t;
				match(_t,210);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_patindex:
			{
				AST tmp256_AST_in = (AST)_t;
				match(_t,LITERAL_patindex);
				_t = _t.getNextSibling();
				break;
			}
			case 212:
			{
				AST tmp257_AST_in = (AST)_t;
				match(_t,212);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_repeat:
			{
				AST tmp258_AST_in = (AST)_t;
				match(_t,LITERAL_repeat);
				_t = _t.getNextSibling();
				break;
			}
			case 214:
			{
				AST tmp259_AST_in = (AST)_t;
				match(_t,214);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_replace:
			{
				AST tmp260_AST_in = (AST)_t;
				match(_t,LITERAL_replace);
				_t = _t.getNextSibling();
				break;
			}
			case 216:
			{
				AST tmp261_AST_in = (AST)_t;
				match(_t,216);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_replicate:
			{
				AST tmp262_AST_in = (AST)_t;
				match(_t,LITERAL_replicate);
				_t = _t.getNextSibling();
				break;
			}
			case 218:
			{
				AST tmp263_AST_in = (AST)_t;
				match(_t,218);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_right:
			{
				AST tmp264_AST_in = (AST)_t;
				match(_t,LITERAL_right);
				_t = _t.getNextSibling();
				break;
			}
			case 220:
			{
				AST tmp265_AST_in = (AST)_t;
				match(_t,220);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rtrim:
			{
				AST tmp266_AST_in = (AST)_t;
				match(_t,LITERAL_rtrim);
				_t = _t.getNextSibling();
				break;
			}
			case 222:
			{
				AST tmp267_AST_in = (AST)_t;
				match(_t,222);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_similar:
			{
				AST tmp268_AST_in = (AST)_t;
				match(_t,LITERAL_similar);
				_t = _t.getNextSibling();
				break;
			}
			case 224:
			{
				AST tmp269_AST_in = (AST)_t;
				match(_t,224);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sortkey:
			{
				AST tmp270_AST_in = (AST)_t;
				match(_t,LITERAL_sortkey);
				_t = _t.getNextSibling();
				break;
			}
			case 226:
			{
				AST tmp271_AST_in = (AST)_t;
				match(_t,226);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_soundex:
			{
				AST tmp272_AST_in = (AST)_t;
				match(_t,LITERAL_soundex);
				_t = _t.getNextSibling();
				break;
			}
			case 228:
			{
				AST tmp273_AST_in = (AST)_t;
				match(_t,228);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_space:
			{
				AST tmp274_AST_in = (AST)_t;
				match(_t,LITERAL_space);
				_t = _t.getNextSibling();
				break;
			}
			case 230:
			{
				AST tmp275_AST_in = (AST)_t;
				match(_t,230);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_str:
			{
				AST tmp276_AST_in = (AST)_t;
				match(_t,LITERAL_str);
				_t = _t.getNextSibling();
				break;
			}
			case 232:
			{
				AST tmp277_AST_in = (AST)_t;
				match(_t,232);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_string:
			{
				AST tmp278_AST_in = (AST)_t;
				match(_t,LITERAL_string);
				_t = _t.getNextSibling();
				break;
			}
			case 234:
			{
				AST tmp279_AST_in = (AST)_t;
				match(_t,234);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_stuff:
			{
				AST tmp280_AST_in = (AST)_t;
				match(_t,LITERAL_stuff);
				_t = _t.getNextSibling();
				break;
			}
			case 236:
			{
				AST tmp281_AST_in = (AST)_t;
				match(_t,236);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_substring:
			{
				AST tmp282_AST_in = (AST)_t;
				match(_t,LITERAL_substring);
				_t = _t.getNextSibling();
				break;
			}
			case 238:
			{
				AST tmp283_AST_in = (AST)_t;
				match(_t,238);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_trim:
			{
				AST tmp284_AST_in = (AST)_t;
				match(_t,LITERAL_trim);
				_t = _t.getNextSibling();
				break;
			}
			case 240:
			{
				AST tmp285_AST_in = (AST)_t;
				match(_t,240);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ucase:
			{
				AST tmp286_AST_in = (AST)_t;
				match(_t,LITERAL_ucase);
				_t = _t.getNextSibling();
				break;
			}
			case 242:
			{
				AST tmp287_AST_in = (AST)_t;
				match(_t,242);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_upper:
			{
				AST tmp288_AST_in = (AST)_t;
				match(_t,LITERAL_upper);
				_t = _t.getNextSibling();
				break;
			}
			case 244:
			{
				AST tmp289_AST_in = (AST)_t;
				match(_t,244);
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
	
	public final void datetime_function(AST _t) throws RecognitionException {
		
		AST datetime_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_dateformat:
			{
				AST tmp290_AST_in = (AST)_t;
				match(_t,LITERAL_dateformat);
				_t = _t.getNextSibling();
				break;
			}
			case 246:
			{
				AST tmp291_AST_in = (AST)_t;
				match(_t,246);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datename:
			{
				AST tmp292_AST_in = (AST)_t;
				match(_t,LITERAL_datename);
				_t = _t.getNextSibling();
				break;
			}
			case 248:
			{
				AST tmp293_AST_in = (AST)_t;
				match(_t,248);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datepart:
			{
				AST tmp294_AST_in = (AST)_t;
				match(_t,LITERAL_datepart);
				_t = _t.getNextSibling();
				break;
			}
			case 250:
			{
				AST tmp295_AST_in = (AST)_t;
				match(_t,250);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datetime:
			{
				AST tmp296_AST_in = (AST)_t;
				match(_t,LITERAL_datetime);
				_t = _t.getNextSibling();
				break;
			}
			case 252:
			{
				AST tmp297_AST_in = (AST)_t;
				match(_t,252);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_date:
			{
				AST tmp298_AST_in = (AST)_t;
				match(_t,LITERAL_date);
				_t = _t.getNextSibling();
				break;
			}
			case 254:
			{
				AST tmp299_AST_in = (AST)_t;
				match(_t,254);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dayname:
			{
				AST tmp300_AST_in = (AST)_t;
				match(_t,LITERAL_dayname);
				_t = _t.getNextSibling();
				break;
			}
			case 256:
			{
				AST tmp301_AST_in = (AST)_t;
				match(_t,256);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_days:
			{
				AST tmp302_AST_in = (AST)_t;
				match(_t,LITERAL_days);
				_t = _t.getNextSibling();
				break;
			}
			case 258:
			{
				AST tmp303_AST_in = (AST)_t;
				match(_t,258);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_day:
			{
				AST tmp304_AST_in = (AST)_t;
				match(_t,LITERAL_day);
				_t = _t.getNextSibling();
				break;
			}
			case 260:
			{
				AST tmp305_AST_in = (AST)_t;
				match(_t,260);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dow:
			{
				AST tmp306_AST_in = (AST)_t;
				match(_t,LITERAL_dow);
				_t = _t.getNextSibling();
				break;
			}
			case 262:
			{
				AST tmp307_AST_in = (AST)_t;
				match(_t,262);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hours:
			{
				AST tmp308_AST_in = (AST)_t;
				match(_t,LITERAL_hours);
				_t = _t.getNextSibling();
				break;
			}
			case 264:
			{
				AST tmp309_AST_in = (AST)_t;
				match(_t,264);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hour:
			{
				AST tmp310_AST_in = (AST)_t;
				match(_t,LITERAL_hour);
				_t = _t.getNextSibling();
				break;
			}
			case 266:
			{
				AST tmp311_AST_in = (AST)_t;
				match(_t,266);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minutes:
			{
				AST tmp312_AST_in = (AST)_t;
				match(_t,LITERAL_minutes);
				_t = _t.getNextSibling();
				break;
			}
			case 268:
			{
				AST tmp313_AST_in = (AST)_t;
				match(_t,268);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minute:
			{
				AST tmp314_AST_in = (AST)_t;
				match(_t,LITERAL_minute);
				_t = _t.getNextSibling();
				break;
			}
			case 270:
			{
				AST tmp315_AST_in = (AST)_t;
				match(_t,270);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_monthname:
			{
				AST tmp316_AST_in = (AST)_t;
				match(_t,LITERAL_monthname);
				_t = _t.getNextSibling();
				break;
			}
			case 272:
			{
				AST tmp317_AST_in = (AST)_t;
				match(_t,272);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_months:
			{
				AST tmp318_AST_in = (AST)_t;
				match(_t,LITERAL_months);
				_t = _t.getNextSibling();
				break;
			}
			case 274:
			{
				AST tmp319_AST_in = (AST)_t;
				match(_t,274);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_month:
			{
				AST tmp320_AST_in = (AST)_t;
				match(_t,LITERAL_month);
				_t = _t.getNextSibling();
				break;
			}
			case 276:
			{
				AST tmp321_AST_in = (AST)_t;
				match(_t,276);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_now:
			{
				AST tmp322_AST_in = (AST)_t;
				match(_t,LITERAL_now);
				_t = _t.getNextSibling();
				break;
			}
			case 127:
			{
				AST tmp323_AST_in = (AST)_t;
				match(_t,127);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_quarter:
			{
				AST tmp324_AST_in = (AST)_t;
				match(_t,LITERAL_quarter);
				_t = _t.getNextSibling();
				break;
			}
			case 278:
			{
				AST tmp325_AST_in = (AST)_t;
				match(_t,278);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_seconds:
			{
				AST tmp326_AST_in = (AST)_t;
				match(_t,LITERAL_seconds);
				_t = _t.getNextSibling();
				break;
			}
			case 280:
			{
				AST tmp327_AST_in = (AST)_t;
				match(_t,280);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_second:
			{
				AST tmp328_AST_in = (AST)_t;
				match(_t,LITERAL_second);
				_t = _t.getNextSibling();
				break;
			}
			case 282:
			{
				AST tmp329_AST_in = (AST)_t;
				match(_t,282);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_today:
			{
				AST tmp330_AST_in = (AST)_t;
				match(_t,LITERAL_today);
				_t = _t.getNextSibling();
				break;
			}
			case 129:
			{
				AST tmp331_AST_in = (AST)_t;
				match(_t,129);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_weeks:
			{
				AST tmp332_AST_in = (AST)_t;
				match(_t,LITERAL_weeks);
				_t = _t.getNextSibling();
				break;
			}
			case 284:
			{
				AST tmp333_AST_in = (AST)_t;
				match(_t,284);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_years:
			{
				AST tmp334_AST_in = (AST)_t;
				match(_t,LITERAL_years);
				_t = _t.getNextSibling();
				break;
			}
			case 286:
			{
				AST tmp335_AST_in = (AST)_t;
				match(_t,286);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_year:
			{
				AST tmp336_AST_in = (AST)_t;
				match(_t,LITERAL_year);
				_t = _t.getNextSibling();
				break;
			}
			case 288:
			{
				AST tmp337_AST_in = (AST)_t;
				match(_t,288);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ymd:
			{
				AST tmp338_AST_in = (AST)_t;
				match(_t,LITERAL_ymd);
				_t = _t.getNextSibling();
				break;
			}
			case 290:
			{
				AST tmp339_AST_in = (AST)_t;
				match(_t,290);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_getdate:
			{
				AST tmp340_AST_in = (AST)_t;
				match(_t,LITERAL_getdate);
				_t = _t.getNextSibling();
				break;
			}
			case 118:
			{
				AST tmp341_AST_in = (AST)_t;
				match(_t,118);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dateadd:
			{
				AST tmp342_AST_in = (AST)_t;
				match(_t,LITERAL_dateadd);
				_t = _t.getNextSibling();
				break;
			}
			case 292:
			{
				AST tmp343_AST_in = (AST)_t;
				match(_t,292);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datediff:
			{
				AST tmp344_AST_in = (AST)_t;
				match(_t,LITERAL_datediff);
				_t = _t.getNextSibling();
				break;
			}
			case 294:
			{
				AST tmp345_AST_in = (AST)_t;
				match(_t,294);
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
	
	public final void conversion_function(AST _t) throws RecognitionException {
		
		AST conversion_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_hextoint:
			{
				AST tmp346_AST_in = (AST)_t;
				match(_t,LITERAL_hextoint);
				_t = _t.getNextSibling();
				break;
			}
			case 296:
			{
				AST tmp347_AST_in = (AST)_t;
				match(_t,296);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_inttohex:
			{
				AST tmp348_AST_in = (AST)_t;
				match(_t,LITERAL_inttohex);
				_t = _t.getNextSibling();
				break;
			}
			case 298:
			{
				AST tmp349_AST_in = (AST)_t;
				match(_t,298);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isdate:
			{
				AST tmp350_AST_in = (AST)_t;
				match(_t,LITERAL_isdate);
				_t = _t.getNextSibling();
				break;
			}
			case 300:
			{
				AST tmp351_AST_in = (AST)_t;
				match(_t,300);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isnumeric:
			{
				AST tmp352_AST_in = (AST)_t;
				match(_t,LITERAL_isnumeric);
				_t = _t.getNextSibling();
				break;
			}
			case 302:
			{
				AST tmp353_AST_in = (AST)_t;
				match(_t,302);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cast:
			{
				AST tmp354_AST_in = (AST)_t;
				match(_t,LITERAL_cast);
				_t = _t.getNextSibling();
				break;
			}
			case 134:
			{
				AST tmp355_AST_in = (AST)_t;
				match(_t,134);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_convert:
			{
				AST tmp356_AST_in = (AST)_t;
				match(_t,LITERAL_convert);
				_t = _t.getNextSibling();
				break;
			}
			case 132:
			{
				AST tmp357_AST_in = (AST)_t;
				match(_t,132);
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
	
	public final void system_function(AST _t) throws RecognitionException {
		
		AST system_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_suser_id:
			{
				AST tmp358_AST_in = (AST)_t;
				match(_t,LITERAL_suser_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_suser_name:
			{
				AST tmp359_AST_in = (AST)_t;
				match(_t,LITERAL_suser_name);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_id:
			{
				AST tmp360_AST_in = (AST)_t;
				match(_t,LITERAL_user_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_name:
			{
				AST tmp361_AST_in = (AST)_t;
				match(_t,LITERAL_user_name);
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
	
	public final void analytical_function(AST _t) throws RecognitionException {
		
		AST analytical_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_dense_rank:
			{
				AST tmp362_AST_in = (AST)_t;
				match(_t,LITERAL_dense_rank);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ntile:
			{
				AST tmp363_AST_in = (AST)_t;
				match(_t,LITERAL_ntile);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_percent_rank:
			{
				AST tmp364_AST_in = (AST)_t;
				match(_t,LITERAL_percent_rank);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_percentile_count:
			{
				AST tmp365_AST_in = (AST)_t;
				match(_t,LITERAL_percentile_count);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_percentile_desc:
			{
				AST tmp366_AST_in = (AST)_t;
				match(_t,LITERAL_percentile_desc);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rank:
			{
				AST tmp367_AST_in = (AST)_t;
				match(_t,LITERAL_rank);
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
	
	public final void miscellane_function(AST _t) throws RecognitionException {
		
		AST miscellane_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_argn:
			{
				AST tmp368_AST_in = (AST)_t;
				match(_t,LITERAL_argn);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_coalesce:
			{
				AST tmp369_AST_in = (AST)_t;
				match(_t,LITERAL_coalesce);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ifnull:
			{
				AST tmp370_AST_in = (AST)_t;
				match(_t,LITERAL_ifnull);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isnull:
			{
				AST tmp371_AST_in = (AST)_t;
				match(_t,LITERAL_isnull);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_nullif:
			{
				AST tmp372_AST_in = (AST)_t;
				match(_t,LITERAL_nullif);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_number:
			{
				AST tmp373_AST_in = (AST)_t;
				match(_t,LITERAL_number);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rowid:
			{
				AST tmp374_AST_in = (AST)_t;
				match(_t,LITERAL_rowid);
				_t = _t.getNextSibling();
				break;
			}
			case 308:
			{
				AST tmp375_AST_in = (AST)_t;
				match(_t,308);
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
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SELECT_STATEMENT",
		"SEARCH_NOT_CONDITION",
		"SUBQUERY",
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"FUNCTION_ROWID",
		"FUNCTION_NOTHING",
		"FUNCTION_EMPTY_PARAM",
		"FUNCTION_STAR_PARAM",
		"FUNCTION_STAR_COUNT",
		"FUNCTION_DATA_TYPE",
		"FUNCTION_AS_DATA_TYPE",
		"LOGIC_OP",
		"LOGICAL_NULL",
		"LOGICAL_NOT_NULL",
		"LOGICAL_IN",
		"LOGICAL_NOT_IN",
		"LOGICAL_LIKE",
		"LOGICAL_NOT_LIKE",
		"LOGICAL_EXISTS",
		"LOGICAL_NOT_EXISTS",
		"LOGICAL_BETWEEN",
		"SUBCONTAIN_OP",
		"ALL_FIELDS",
		"PAREN_FIELD",
		"PAREN_DATA_TYPE",
		"PAREN_CHAR_DATA_TYPE",
		"LOGIC_BLOCK",
		"COLUMN",
		"WHERE",
		"SEMI",
		"\"t_union\"",
		"\"\\u8868\\u5408\\u5e76\"",
		"COMMA",
		"\"t_compare\"",
		"\"\\u8868\\u6bd4\\u8f83\"",
		"\"where\"",
		"\"\\u6761\\u4ef6\"",
		"\"exists\"",
		"\"\\u5b58\\u5728\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"not\"",
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"top\"",
		"\"\\u524dN\\u6761\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"\"group\"",
		"\"by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order\"",
		"\"\\u6392\\u5e8f\"",
		"REAL_NUM",
		"\"\\u975e\"",
		"\"and\"",
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"LPAREN",
		"RPAREN",
		"\"as\"",
		"\"\\u4f5c\\u4e3a\"",
		"\"=\"",
		"\"\\u7b49\\u4e8e\"",
		"\"\\u6240\\u6709\"",
		"STAR",
		"\"asc\"",
		"\"\\u5347\\u5e8f\"",
		"\"desc\"",
		"\"\\u964d\\u5e8f\"",
		"\"like\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"\\u8303\\u56f4\"",
		"\"between\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"\"count\"",
		"\"\\u6c42\\u8bb0\\u5f55\\u603b\\u6570\"",
		"\"all\"",
		"\"\\u5168\\u90e8\"",
		"\"\\u4e3a\"",
		"\"char\"",
		"DATA_TYPE_STRING",
		"ID",
		"PARAM_ID",
		"QUOTED_STRING",
		"POINT",
		"NEGATIVE_DIGIT_ELEMENT",
		"\"avg\"",
		"\"\\u6c42\\u5e73\\u5747\\u6570\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"stddev\"",
		"\"\\u6c42\\u65b9\\u5dee\"",
		"\"sum\"",
		"\"\\u6c42\\u603b\\u548c\"",
		"\"variance\"",
		"\"\\u6c42\\u7edf\\u8ba1\\u65b9\\u5dee\"",
		"\"SYSDATE\"",
		"\"\\u53d6\\u7cfb\\u7edf\\u65e5\\u671f\"",
		"\"getdate\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f42\"",
		"\"rand\"",
		"\"\\u53d6\\u968f\\u673a\\u6570\"",
		"\"dense_rank\"",
		"\"percent_rank\"",
		"\"rank\"",
		"\"pi\"",
		"\"\\u6c42\\u5706\\u5468\\u7387\"",
		"\"now\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f41\"",
		"\"today\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\"",
		"\"number\"",
		"\"convert\"",
		"\"\\u6570\\u636e\\u7c7b\\u578b\\u8f6c\\u6362\"",
		"\"cast\"",
		"\"\\u6570\\u636e\\u7c7b\\u578b\\u8f6c\\u5316\"",
		"\"abs\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u53cd\\u4f59\\u5f26\\u503c\"",
		"\"asin\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5f26\\u503c\"",
		"\"atan\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atin2\"",
		"\"\\u6c42\\u4e8c\\u4e2a\\u6570\\u7684\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"ceiling\"",
		"\"\\u53d6\\u4e0a\\u9650\\u6574\\u6570\"",
		"\"cos\"",
		"\"\\u6c42\\u4f59\\u5f26\\u503c\"",
		"\"cot\"",
		"\"\\u6c42\\u4f59\\u5207\\u503c\"",
		"\"degrees\"",
		"\"\\u5f27\\u5ea6\\u8f6c\\u5ea6\\u6570\"",
		"\"exp\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"floor\"",
		"\"\\u53d6\\u4e0b\\u9650\\u6574\\u6570\"",
		"\"log\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log10\"",
		"\"\\u6c4210\\u4e3a\\u5e95\\u7684\\u5bf9\\u6570\"",
		"\"mod\"",
		"\"\\u6c42\\u6a21\"",
		"\"power\"",
		"\"\\u6c42\\u5e42\"",
		"\"radians\"",
		"\"\\u5ea6\\u6570\\u8f6c\\u5f27\\u5ea6\"",
		"\"remainder\"",
		"\"\\u6c42\\u4f59\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"sign\"",
		"\"\\u6c42\\u503c\\u7684\\u7b26\\u53f7\"",
		"\"sin\"",
		"\"\\u6c42\\u6b63\\u5f26\\u503c\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"tan\"",
		"\"\\u6c42\\u6b63\\u5207\\u503c\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c3\"",
		"\"truncnum\"",
		"\"N\\u4f4d\\u7f6e\\u96f6\\u5904\\u7406\"",
		"\"ascii\"",
		"\"\\u6c42ASCII\\u7801\"",
		"\"bit_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u4e8c\\u8fdb\\u5236\\u957f\\u5ea6\"",
		"\"byte_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u5b57\\u8282\\u6570\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u957f\\u5ea61\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u58f0\\u97f3\\u5dee\\u503c\"",
		"\"insertstr\"",
		"\"\\u63d2\\u5165\\u5b57\\u7b26\\u4e32\"",
		"\"lcase\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd1\"",
		"\"left\"",
		"\"\\u5de6\\u622a\\u5b57\\u7b26\\u4e32\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u957f\\u5ea62\"",
		"\"locate\"",
		"\"\\u6c42\\u4e32\\u4f4d\\u7f6e1\"",
		"\"lower\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd2\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"octet_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u5b58\\u50a8\\u957f\\u5ea6\"",
		"\"patindex\"",
		"\"\\u6c42\\u4e32\\u4f4d\\u7f6e2\"",
		"\"repeat\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5faa\\u73af\\u8fde\\u63a51\"",
		"\"replace\"",
		"\"\\u66ff\\u6362\\u5b57\\u7b26\\u4e32\"",
		"\"replicate\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5faa\\u73af\\u8fde\\u63a52\"",
		"\"right\"",
		"\"\\u53f3\\u622a\\u5b57\\u7b26\\u4e32\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"similar\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u76f8\\u4f3c\\u5ea6\"",
		"\"sortkey\"",
		"\"\\u5b57\\u7b26\\u4e32\\u6392\\u5e8f\"",
		"\"soundex\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u58f0\\u97f3\\u503c\"",
		"\"space\"",
		"\"\\u586b\\u7a7a\\u683c\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"string\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5408\\u5e76\"",
		"\"stuff\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5220\\u9664\\u66ff\\u6362\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"trim\"",
		"\"\\u53bb\\u5de6\\u53f3\\u7a7a\\u683c\"",
		"\"ucase\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd1\"",
		"\"upper\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd2\"",
		"\"dateformat\"",
		"\"\\u683c\\u5f0f\\u5316\\u65e5\\u671f\"",
		"\"datename\"",
		"\"\\u6c42\\u65e5\\u671f\\u5206\\u91cf\\u82f1\\u6587\\u540d\"",
		"\"datepart\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u503c\"",
		"\"datetime\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"date\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"dayname\"",
		"\"\\u6c42\\u661f\\u671f\\u82f1\\u6587\\u540d\"",
		"\"days\"",
		"\"\\u6c42\\u5929\\u6570\"",
		"\"day\"",
		"\"\\u6c42\\u5177\\u4f53\\u65e5\\u671f\"",
		"\"dow\"",
		"\"\\u6c42\\u5177\\u4f53\\u661f\\u671f\"",
		"\"hours\"",
		"\"\\u6c42\\u5c0f\\u65f6\\u6570\"",
		"\"hour\"",
		"\"\\u6c42\\u5177\\u4f53\\u5c0f\\u65f6\"",
		"\"minutes\"",
		"\"\\u6c42\\u5206\\u949f\\u6570\"",
		"\"minute\"",
		"\"\\u6c42\\u5177\\u4f53\\u5206\\u949f\"",
		"\"monthname\"",
		"\"\\u6c42\\u6708\\u4efd\\u82f1\\u6587\\u540d\"",
		"\"months\"",
		"\"\\u6c42\\u6708\\u6570\"",
		"\"month\"",
		"\"\\u6c42\\u5177\\u4f53\\u6708\\u6570\"",
		"\"quarter\"",
		"\"\\u6c42\\u5177\\u4f53\\u5b63\\u5ea6\"",
		"\"seconds\"",
		"\"\\u6c42\\u79d2\\u6570\"",
		"\"second\"",
		"\"\\u6c42\\u5177\\u4f53\\u79d2\"",
		"\"weeks\"",
		"\"\\u6c42\\u5468\\u6570\"",
		"\"years\"",
		"\"\\u6c42\\u5e74\\u6570\"",
		"\"year\"",
		"\"\\u6c42\\u5177\\u4f53\\u5e74\\u4efd\"",
		"\"ymd\"",
		"\"\\u6570\\u503c\\u8f6c\\u65e5\\u671f\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u8fd0\\u7b97\"",
		"\"datediff\"",
		"\"\\u6c42\\u4e24\\u65e5\\u671f\\u5dee\\u503c\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u662f\\u5426\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u662f\\u5426\\u6570\\u503c\\u578b\"",
		"\"suser_id\"",
		"\"suser_name\"",
		"\"user_id\"",
		"\"user_name\"",
		"\"rowid\"",
		"\"\\u6c42\\u884c\\u53f7\"",
		"\"ntile\"",
		"\"percentile_count\"",
		"\"percentile_desc\"",
		"\"argn\"",
		"\"coalesce\"",
		"\"ifnull\"",
		"\"isnull\"",
		"\"nullif\"",
		"TILDE",
		"\"\\u975e\\u8fd0\\u7b97\"",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u5f02\\u6216\"",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"PLUS",
		"MINUS",
		"DIVIDE",
		"MOD",
		"AMPERSAND",
		"BITWISEOR",
		"BITWISEXOR",
		"ASSIGNEQUAL",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5de6\\u8fde\\u63a5\"",
		"LEFT_JOIN",
		"NOTEQUAL1",
		"NOTEQUAL2",
		"LESSTHANOREQUALTO1",
		"LESSTHANOREQUALTO2",
		"LESSTHAN",
		"GREATERTHANOREQUALTO1",
		"GREATERTHANOREQUALTO2",
		"GREATERTHAN",
		"\"yy\"",
		"\"mm\"",
		"\"dd\"",
		"\"qq\"",
		"\"week\"",
		"\"wk\"",
		"\"dayofyear\"",
		"\"dy\"",
		"\"weekday\"",
		"\"dw\"",
		"\"hh\"",
		"\"mi\"",
		"\"ss\"",
		"\"millisecond\"",
		"\"ms\"",
		"\"calweekofyear\"",
		"\"cwk\"",
		"\"calyearofweek\"",
		"\"cyr\"",
		"\"caldayofweek\"",
		"\"cdw\"",
		"\"uniqueidentifierstr\"",
		"\"bigint\"",
		"\"int\"",
		"\"integer\"",
		"\"smallint\"",
		"\"tinyint\"",
		"\"double\"",
		"\"real\"",
		"\"smalldatetime\"",
		"\"time\"",
		"\"timestamp\"",
		"\"bit\"",
		"DOT_STAR",
		"PARAM_LPAREN",
		"PARAM_RPAREN",
		"FROM",
		"WS",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"COMPARE_OP",
		"TWO_ARG_OP",
		"ONE_ARG_OP"
	};
	
	}
	
