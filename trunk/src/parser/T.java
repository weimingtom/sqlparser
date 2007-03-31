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

	import model.parser.*;


public class T extends antlr.TreeParser       implements PTokenTypes
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
public T() {
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
			case LITERAL_as:
			{
				AST __t158 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t158;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case 33:
			{
				AST __t159 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,33);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t159;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case ALIAS_EQU:
			{
				AST __t160 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,ALIAS_EQU);
				_t = _t.getFirstChild();
				a=alias(_t);
				_t = _retTree;
				e=expression(_t);
				_t = _retTree;
				_t = __t160;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case ALL_FIELDS:
			case LITERAL_distinct:
			case 24:
			case LPAREN:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case REAL_NUM:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			case ONE_ARG_OP:
			case TWO_ARG_OP:
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
		AST op = null;
		SearchConditionModel m1, m2; EquationModel equ; model=new SearchConditionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LOGIC_OP:
			{
				AST __t152 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,LOGIC_OP);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				logic_op(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t152;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(op.getText()); model.addChild(m2);
				break;
			}
			case LITERAL_null:
			case LITERAL_not:
			case 47:
			case 48:
			case LITERAL_between:
			case 50:
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
				AST __t128 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getFirstChild();
				s1=statements(_t);
				_t = _retTree;
				s2=statements(_t);
				_t = _retTree;
				_t = __t128;
				_t = _t.getNextSibling();
				model.addChild(s1); model.addChild(s2);
				break;
			}
			case SELECT_STATEMENT:
			case 15:
			case 18:
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
			SearchConditionModel cond;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 15:
			{
				AST __t130 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,15);
				_t = _t.getFirstChild();
				tableModel1=table_name(_t);
				_t = _retTree;
				tableModel2=table_name(_t);
				_t = _retTree;
				_t = __t130;
				_t = _t.getNextSibling();
				
							union.addTableModel1(tableModel1);
							union.addTableModel2(tableModel2);
							model = union;
						
				break;
			}
			case 18:
			{
				AST __t131 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,18);
				_t = _t.getFirstChild();
				tableModel1=table_name(_t);
				_t = _retTree;
				tableModel2=table_name(_t);
				_t = _retTree;
				method=compare_method(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t131;
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
				AST __t132 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,SELECT_STATEMENT);
				_t = _t.getFirstChild();
				model=select_statement(_t);
				_t = _retTree;
				_t = __t132;
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
	
	public final TableModel  table_name(AST _t) throws RecognitionException {
		TableModel model;
		
		AST table_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST t = null;
		AST t1 = null;
		AST t2 = null;
		AliasModel a; model=null;
		
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
			case LITERAL_as:
			{
				AST __t191 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				t1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				a=alias(_t);
				_t = _retTree;
				_t = __t191;
				_t = _t.getNextSibling();
				model=new TableModel(t1.getText()); model.setAlias(a);
				break;
			}
			case 33:
			{
				AST __t192 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,33);
				_t = _t.getFirstChild();
				t2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				a=alias(_t);
				_t = _retTree;
				_t = __t192;
				_t = _t.getNextSibling();
				model=new TableModel(t2.getText()); model.setAlias(a);
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
		rValue = "";
		
		try {      // for error handling
			v1 = _t==ASTNULL ? null : (AST)_t;
			comparemethod_name(_t);
			_t = _retTree;
			rValue = v1.getText();
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
		
			OrderExpressionListModel order;
			AggregateExprListModel group;
			SearchConditionModel cond;
			TableListModel tl;
			SelectListModel sl;
			SelectStatementModel s;
			model=new SelectStatementModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 24:
			{
				AST __t135 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,24);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t135;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t136 = _t;
				AST tmp14_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t136;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case 22:
			{
				AST __t137 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,22);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t137;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case LITERAL_select:
			{
				AST __t138 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,LITERAL_select);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t138;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case 26:
			{
				AST __t139 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,26);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t139;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case LITERAL_from:
			{
				AST __t140 = _t;
				AST tmp18_AST_in = (AST)_t;
				match(_t,LITERAL_from);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t140;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case 20:
			{
				AST __t141 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,20);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t141;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case LITERAL_where:
			{
				AST __t142 = _t;
				AST tmp20_AST_in = (AST)_t;
				match(_t,LITERAL_where);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t142;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case 29:
			{
				AST __t143 = _t;
				AST tmp21_AST_in = (AST)_t;
				match(_t,29);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t143;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case LITERAL_group:
			{
				AST __t144 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,LITERAL_group);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t144;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case 31:
			{
				AST __t145 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,31);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t145;
				_t = _t.getNextSibling();
				model.addChild(s); model.setOrderExpressionList(order);
				break;
			}
			case LITERAL_order:
			{
				AST __t146 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,LITERAL_order);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t146;
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
			case 119:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,119);
				_t = _t.getNextSibling();
				break;
			}
			case 120:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,120);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_exist:
			{
				AST tmp27_AST_in = (AST)_t;
				match(_t,LITERAL_exist);
				_t = _t.getNextSibling();
				break;
			}
			case 122:
			{
				AST tmp28_AST_in = (AST)_t;
				match(_t,122);
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
			case 22:
			{
				AST tmp29_AST_in = (AST)_t;
				match(_t,22);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_select:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,LITERAL_select);
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
				AST __t148 = _t;
				AST tmp31_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=select_list(_t);
				_t = _retTree;
				m2=select_list(_t);
				_t = _retTree;
				_t = __t148;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case ALIAS_EQU:
			case ALL_FIELDS:
			case LITERAL_distinct:
			case 24:
			case LITERAL_as:
			case 33:
			case LPAREN:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case REAL_NUM:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			case ONE_ARG_OP:
			case TWO_ARG_OP:
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
	
	public final TableListModel  table_list(AST _t) throws RecognitionException {
		TableListModel model;
		
		AST table_list_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		TableModel t; TableListModel m1, m2; model=new TableListModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t150 = _t;
				AST tmp32_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=table_list(_t);
				_t = _retTree;
				m2=table_list(_t);
				_t = _retTree;
				_t = __t150;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_as:
			case 33:
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
				AST __t154 = _t;
				AST tmp33_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=aggregate_expression_list(_t);
				_t = _retTree;
				m2=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t154;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_distinct:
			case 24:
			case ID:
			case POINT:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
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
				AST __t156 = _t;
				AST tmp34_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=order_expression_list(_t);
				_t = _retTree;
				m2=order_expression_list(_t);
				_t = _retTree;
				_t = __t156;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_distinct:
			case 24:
			case 38:
			case 39:
			case LITERAL_asc:
			case LITERAL_desc:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
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
	
	public final void logic_op(AST _t) throws RecognitionException {
		
		AST logic_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_and:
			{
				AST tmp35_AST_in = (AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_or:
			{
				AST tmp36_AST_in = (AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getNextSibling();
				break;
			}
			case 117:
			{
				AST tmp37_AST_in = (AST)_t;
				match(_t,117);
				_t = _t.getNextSibling();
				break;
			}
			case 118:
			{
				AST tmp38_AST_in = (AST)_t;
				match(_t,118);
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
	
	public final EquationModel  equation(AST _t) throws RecognitionException {
		EquationModel model;
		
		AST equation_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST n = null;
		AST nn = null;
		AST nn_en = null;
		AST btw = null;
		ExpressionModel e1, e2, e3; EquationModel equation; model=new EquationModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMPARE_OP:
			{
				AST __t162 = _t;
				AST tmp39_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				compare_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t162;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);
				break;
			}
			case 47:
			{
				AST __t163 = _t;
				n = _t==ASTNULL ? null :(AST)_t;
				match(_t,47);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t163;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(n.getText());
				break;
			}
			case LITERAL_null:
			{
				AST __t164 = _t;
				AST tmp40_AST_in = (AST)_t;
				match(_t,LITERAL_null);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t164;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is null");
				break;
			}
			case 48:
			{
				AST __t165 = _t;
				nn = _t==ASTNULL ? null :(AST)_t;
				match(_t,48);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t165;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nn.getText());
				break;
			}
			case LITERAL_not:
			{
				AST __t166 = _t;
				nn_en = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t166;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is not null");
				break;
			}
			case LITERAL_between:
			{
				AST __t167 = _t;
				AST tmp41_AST_in = (AST)_t;
				match(_t,LITERAL_between);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t167;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("between");
					 model.addExpression(e2); model.addExpression(e3);
				break;
			}
			case 50:
			{
				AST __t168 = _t;
				btw = _t==ASTNULL ? null :(AST)_t;
				match(_t,50);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t168;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(btw.getText());
					 model.addExpression(e2); model.addExpression(e3);
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
		AST op = null;
		AggregateExprModel a1, a2; FieldModel field; FunctionModel func; model=new AggregateExprModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST __t170 = _t;
				AST tmp42_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				a1=aggregate_expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				a2=aggregate_expression(_t);
				_t = _retTree;
				_t = __t170;
				_t = _t.getNextSibling();
				model.addChild(a1); model.addOperator(op.getText()); model.addChild(a2);
				break;
			}
			case ID:
			case POINT:
			{
				field=field_name(_t);
				_t = _retTree;
				model.addField(field);
				break;
			}
			case LITERAL_distinct:
			case 24:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
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
			case LITERAL_distinct:
			case 24:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
				break;
			}
			case LITERAL_asc:
			{
				AST __t172 = _t;
				AST tmp43_AST_in = (AST)_t;
				match(_t,LITERAL_asc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t172;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case 38:
			{
				AST __t173 = _t;
				AST tmp44_AST_in = (AST)_t;
				match(_t,38);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t173;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case LITERAL_desc:
			{
				AST __t174 = _t;
				AST tmp45_AST_in = (AST)_t;
				match(_t,LITERAL_desc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t174;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.DESC);
				break;
			}
			case 39:
			{
				AST __t175 = _t;
				AST tmp46_AST_in = (AST)_t;
				match(_t,39);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t175;
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
				else if ((_t.getType()==ID||_t.getType()==POINT)) {
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
		AST rn = null;
		AST qs = null;
		AST allf = null;
		FieldModel f; FunctionModel func; ExpressionModel e1, e2; model=new ExpressionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST __t179 = _t;
				AST tmp47_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t179;
				_t = _t.getNextSibling();
				model.addChild(e1); model.addOperator(op.getText()); model.addChild(e2);
				break;
			}
			case ONE_ARG_OP:
			{
				AST __t180 = _t;
				AST tmp48_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getFirstChild();
				op1 = _t==ASTNULL ? null : (AST)_t;
				one_arg_op(_t);
				_t = _retTree;
				e1=expression(_t);
				_t = _retTree;
				_t = __t180;
				_t = _t.getNextSibling();
				model.addOperator(op1.getText()); model.addChild(e1);
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
			case ID:
			case POINT:
			{
				f=field_name(_t);
				_t = _retTree;
				model.addField(f);
				break;
			}
			case LITERAL_distinct:
			case 24:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			{
				func=function(_t);
				_t = _retTree;
				model.addFunction(func);
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
			case COMPARE_OP:
			{
				AST tmp49_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 35:
			{
				AST tmp50_AST_in = (AST)_t;
				match(_t,35);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_like:
			{
				AST tmp51_AST_in = (AST)_t;
				match(_t,LITERAL_like);
				_t = _t.getNextSibling();
				break;
			}
			case 109:
			{
				AST tmp52_AST_in = (AST)_t;
				match(_t,109);
				_t = _t.getNextSibling();
				break;
			}
			case 110:
			{
				AST tmp53_AST_in = (AST)_t;
				match(_t,110);
				_t = _t.getNextSibling();
				break;
			}
			case 111:
			{
				AST tmp54_AST_in = (AST)_t;
				match(_t,111);
				_t = _t.getNextSibling();
				break;
			}
			case 112:
			{
				AST tmp55_AST_in = (AST)_t;
				match(_t,112);
				_t = _t.getNextSibling();
				break;
			}
			case 113:
			{
				AST tmp56_AST_in = (AST)_t;
				match(_t,113);
				_t = _t.getNextSibling();
				break;
			}
			case 114:
			{
				AST tmp57_AST_in = (AST)_t;
				match(_t,114);
				_t = _t.getNextSibling();
				break;
			}
			case 115:
			{
				AST tmp58_AST_in = (AST)_t;
				match(_t,115);
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
	
	public final void two_arg_op(AST _t) throws RecognitionException {
		
		AST two_arg_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST tmp59_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST tmp60_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getNextSibling();
				break;
			}
			case 99:
			{
				AST tmp61_AST_in = (AST)_t;
				match(_t,99);
				_t = _t.getNextSibling();
				break;
			}
			case 100:
			{
				AST tmp62_AST_in = (AST)_t;
				match(_t,100);
				_t = _t.getNextSibling();
				break;
			}
			case 101:
			{
				AST tmp63_AST_in = (AST)_t;
				match(_t,101);
				_t = _t.getNextSibling();
				break;
			}
			case 102:
			{
				AST tmp64_AST_in = (AST)_t;
				match(_t,102);
				_t = _t.getNextSibling();
				break;
			}
			case 103:
			{
				AST tmp65_AST_in = (AST)_t;
				match(_t,103);
				_t = _t.getNextSibling();
				break;
			}
			case 104:
			{
				AST tmp66_AST_in = (AST)_t;
				match(_t,104);
				_t = _t.getNextSibling();
				break;
			}
			case 105:
			{
				AST tmp67_AST_in = (AST)_t;
				match(_t,105);
				_t = _t.getNextSibling();
				break;
			}
			case 106:
			{
				AST tmp68_AST_in = (AST)_t;
				match(_t,106);
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
		AST f = null;
		AST t = null;
		AST f1 = null;
		model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				f = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				model=new FieldModel(f.getText());
				break;
			}
			case POINT:
			{
				AST __t182 = _t;
				AST tmp69_AST_in = (AST)_t;
				match(_t,POINT);
				_t = _t.getFirstChild();
				t = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				f1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t182;
				_t = _t.getNextSibling();
				
						model=new FieldModel(f1.getText(), t.getText());
						addTableByChName(t.getText());
					
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
		AST f = null;
		AST all = null;
		AST af11 = null;
		AST af12 = null;
		AST dist = null;
		AST af21 = null;
		AST af22 = null;
		ParametersModel p; model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			{
				f = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				model=new FunctionModel(f.getText()); model.setParameters(p);
				break;
			}
			case 57:
			{
				AST __t184 = _t;
				all = _t==ASTNULL ? null :(AST)_t;
				match(_t,57);
				_t = _t.getFirstChild();
				af11 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t184;
				_t = _t.getNextSibling();
				model=new FunctionModel(af11.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case LITERAL_all:
			{
				AST __t185 = _t;
				AST tmp70_AST_in = (AST)_t;
				match(_t,LITERAL_all);
				_t = _t.getFirstChild();
				af12 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t185;
				_t = _t.getNextSibling();
				model=new FunctionModel(af12.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case 24:
			{
				AST __t186 = _t;
				dist = _t==ASTNULL ? null :(AST)_t;
				match(_t,24);
				_t = _t.getFirstChild();
				af21 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t186;
				_t = _t.getNextSibling();
				model=new FunctionModel(af21.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t187 = _t;
				AST tmp71_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				af22 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t187;
				_t = _t.getNextSibling();
				model=new FunctionModel(af22.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);
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
			case ONE_ARG_OP:
			{
				AST tmp72_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 97:
			{
				AST tmp73_AST_in = (AST)_t;
				match(_t,97);
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
	
	public final void function_name(AST _t) throws RecognitionException {
		
		AST function_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_sqrt:
			{
				AST tmp74_AST_in = (AST)_t;
				match(_t,LITERAL_sqrt);
				_t = _t.getNextSibling();
				break;
			}
			case 59:
			{
				AST tmp75_AST_in = (AST)_t;
				match(_t,59);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_getdate:
			{
				AST tmp76_AST_in = (AST)_t;
				match(_t,LITERAL_getdate);
				_t = _t.getNextSibling();
				break;
			}
			case 61:
			{
				AST tmp77_AST_in = (AST)_t;
				match(_t,61);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_abs:
			{
				AST tmp78_AST_in = (AST)_t;
				match(_t,LITERAL_abs);
				_t = _t.getNextSibling();
				break;
			}
			case 63:
			{
				AST tmp79_AST_in = (AST)_t;
				match(_t,63);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_substring:
			{
				AST tmp80_AST_in = (AST)_t;
				match(_t,LITERAL_substring);
				_t = _t.getNextSibling();
				break;
			}
			case 65:
			{
				AST tmp81_AST_in = (AST)_t;
				match(_t,65);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_round:
			{
				AST tmp82_AST_in = (AST)_t;
				match(_t,LITERAL_round);
				_t = _t.getNextSibling();
				break;
			}
			case 67:
			{
				AST tmp83_AST_in = (AST)_t;
				match(_t,67);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_right:
			{
				AST tmp84_AST_in = (AST)_t;
				match(_t,LITERAL_right);
				_t = _t.getNextSibling();
				break;
			}
			case 69:
			{
				AST tmp85_AST_in = (AST)_t;
				match(_t,69);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ltrim:
			{
				AST tmp86_AST_in = (AST)_t;
				match(_t,LITERAL_ltrim);
				_t = _t.getNextSibling();
				break;
			}
			case 71:
			{
				AST tmp87_AST_in = (AST)_t;
				match(_t,71);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rtrim:
			{
				AST tmp88_AST_in = (AST)_t;
				match(_t,LITERAL_rtrim);
				_t = _t.getNextSibling();
				break;
			}
			case 73:
			{
				AST tmp89_AST_in = (AST)_t;
				match(_t,73);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char_length:
			{
				AST tmp90_AST_in = (AST)_t;
				match(_t,LITERAL_char_length);
				_t = _t.getNextSibling();
				break;
			}
			case 75:
			{
				AST tmp91_AST_in = (AST)_t;
				match(_t,75);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_floor:
			{
				AST tmp92_AST_in = (AST)_t;
				match(_t,LITERAL_floor);
				_t = _t.getNextSibling();
				break;
			}
			case 77:
			{
				AST tmp93_AST_in = (AST)_t;
				match(_t,77);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ceiling:
			{
				AST tmp94_AST_in = (AST)_t;
				match(_t,LITERAL_ceiling);
				_t = _t.getNextSibling();
				break;
			}
			case 79:
			{
				AST tmp95_AST_in = (AST)_t;
				match(_t,79);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lower:
			{
				AST tmp96_AST_in = (AST)_t;
				match(_t,LITERAL_lower);
				_t = _t.getNextSibling();
				break;
			}
			case 81:
			{
				AST tmp97_AST_in = (AST)_t;
				match(_t,81);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_charindex:
			{
				AST tmp98_AST_in = (AST)_t;
				match(_t,LITERAL_charindex);
				_t = _t.getNextSibling();
				break;
			}
			case 83:
			{
				AST tmp99_AST_in = (AST)_t;
				match(_t,83);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_str:
			{
				AST tmp100_AST_in = (AST)_t;
				match(_t,LITERAL_str);
				_t = _t.getNextSibling();
				break;
			}
			case 85:
			{
				AST tmp101_AST_in = (AST)_t;
				match(_t,85);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sum:
			{
				AST tmp102_AST_in = (AST)_t;
				match(_t,LITERAL_sum);
				_t = _t.getNextSibling();
				break;
			}
			case 87:
			{
				AST tmp103_AST_in = (AST)_t;
				match(_t,87);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_avg:
			{
				AST tmp104_AST_in = (AST)_t;
				match(_t,LITERAL_avg);
				_t = _t.getNextSibling();
				break;
			}
			case 89:
			{
				AST tmp105_AST_in = (AST)_t;
				match(_t,89);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_max:
			{
				AST tmp106_AST_in = (AST)_t;
				match(_t,LITERAL_max);
				_t = _t.getNextSibling();
				break;
			}
			case 91:
			{
				AST tmp107_AST_in = (AST)_t;
				match(_t,91);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_min:
			{
				AST tmp108_AST_in = (AST)_t;
				match(_t,LITERAL_min);
				_t = _t.getNextSibling();
				break;
			}
			case 93:
			{
				AST tmp109_AST_in = (AST)_t;
				match(_t,93);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_count:
			{
				AST tmp110_AST_in = (AST)_t;
				match(_t,LITERAL_count);
				_t = _t.getNextSibling();
				break;
			}
			case 95:
			{
				AST tmp111_AST_in = (AST)_t;
				match(_t,95);
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
				AST __t189 = _t;
				AST tmp112_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				p1=parameters(_t);
				_t = _retTree;
				p2=parameters(_t);
				_t = _retTree;
				_t = __t189;
				_t = _t.getNextSibling();
				model.addChild(p1); model.addChild(p2);
				break;
			}
			case ALL_FIELDS:
			case LITERAL_distinct:
			case 24:
			case LPAREN:
			case ID:
			case QUOTED_STRING:
			case POINT:
			case REAL_NUM:
			case LITERAL_all:
			case 57:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
			case ONE_ARG_OP:
			case TWO_ARG_OP:
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
	
	public final void distinct(AST _t) throws RecognitionException {
		
		AST distinct_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 24:
			{
				AST tmp113_AST_in = (AST)_t;
				match(_t,24);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_distinct:
			{
				AST tmp114_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
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
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"LOGIC_OP",
		"ALL_FIELDS",
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
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"\"group\"",
		"\"by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order\"",
		"\"\\u6392\\u5e8f\"",
		"\"as\"",
		"\"\\u4f5c\\u4e3a\"",
		"\"=\"",
		"\"\\u7b49\\u4e8e\"",
		"\"\\u6240\\u6709\"",
		"STAR",
		"\"\\u5347\\u5e8f\"",
		"\"\\u964d\\u5e8f\"",
		"\"asc\"",
		"\"desc\"",
		"LPAREN",
		"RPAREN",
		"\"is\"",
		"\"null\"",
		"\"not\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"and\"",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
		"\"all\"",
		"\"\\u5168\\u90e8\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"abs\"",
		"\"\\u6c42\\u7edd\\u5bf9\\u503c\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"right\"",
		"\"\\u5b57\\u7b26\\u4e32\\u53f3\\u622a\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"floor\"",
		"\"\\u6c42\\u56db\\u820d\\u540e\\u7684\\u6574\\u6570\"",
		"\"ceiling\"",
		"\"\\u6c42\\u4e94\\u5165\\u540e\\u7684\\u6574\\u6570\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"sum\"",
		"\"\\u6c42\\u548c\"",
		"\"avg\"",
		"\"\\u6c42\\u5e73\\u5747\\u6570\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"count\"",
		"\"\\u6c42\\u8bb0\\u5f55\\u6570\"",
		"ONE_ARG_OP",
		"\"\\u975e\"",
		"TWO_ARG_OP",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u5f02\\u6216\"",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"\"\\u6c42\\u6a21\"",
		"COMPARE_OP",
		"\"like\"",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"\"not exist\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"exist\"",
		"\"\\u5b58\\u5728\"",
		"NOT_EXIST",
		"EXIST",
		"WS",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT"
	};
	
	}
	
