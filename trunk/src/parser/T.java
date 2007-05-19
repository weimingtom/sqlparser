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
				AST __t199 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t199;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case 57:
			{
				AST __t200 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,57);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t200;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case ALIAS_EQU:
			{
				AST __t201 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,ALIAS_EQU);
				_t = _t.getFirstChild();
				a=alias(_t);
				_t = _retTree;
				e=expression(_t);
				_t = _retTree;
				_t = __t201;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_0.member(_t.getType()))) {
					e=expression(_t);
					_t = _retTree;
					model.addExpression(e);
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
			case LITERAL_and:
			{
				AST __t187 = _t;
				o1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t187;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o1.getText()); model.addChild(m2);
				break;
			}
			case LITERAL_or:
			{
				AST __t188 = _t;
				o2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t188;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o2.getText()); model.addChild(m2);
				break;
			}
			case 52:
			{
				AST __t189 = _t;
				o3 = _t==ASTNULL ? null :(AST)_t;
				match(_t,52);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t189;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);
				break;
			}
			case 53:
			{
				AST __t190 = _t;
				o4 = _t==ASTNULL ? null :(AST)_t;
				match(_t,53);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t190;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);
				break;
			}
			case LOGIC_BLOCK:
			{
				AST __t191 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,LOGIC_BLOCK);
				_t = _t.getFirstChild();
				m3=search_condition(_t);
				_t = _retTree;
				_t = __t191;
				_t = _t.getNextSibling();
				model.addOperator("("); model.addChild(m3); model.addOperator(")");
				break;
			}
			case SEARCH_NOT_CONDITION:
			{
				AST __t192 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,SEARCH_NOT_CONDITION);
				_t = _t.getFirstChild();
				o11 = (AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getNextSibling();
				m4=search_condition(_t);
				_t = _retTree;
				_t = __t192;
				_t = _t.getNextSibling();
				model.addOperator(o11.getText()); model.addChild(m4);
				break;
			}
			case 49:
			{
				AST __t193 = _t;
				o12 = _t==ASTNULL ? null :(AST)_t;
				match(_t,49);
				_t = _t.getFirstChild();
				m5=search_condition(_t);
				_t = _retTree;
				_t = __t193;
				_t = _t.getNextSibling();
				model.addOperator(o12.getText()); model.addChild(m5);
				break;
			}
			case LOGICAL_NULL:
			case LOGICAL_NOT_NULL:
			case LOGICAL_IN:
			case LOGICAL_NOT_IN:
			case LOGICAL_NOT_LIKE:
			case 69:
			case 70:
			case LITERAL_between:
			case 72:
			case 74:
			case 75:
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
				AST __t160 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getFirstChild();
				s1=statements(_t);
				_t = _retTree;
				s2=statements(_t);
				_t = _retTree;
				_t = __t160;
				_t = _t.getNextSibling();
				model.addChild(s1); model.addChild(s2);
				break;
			}
			case SELECT_STATEMENT:
			case 30:
			case 33:
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
			case 30:
			{
				AST __t162 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,30);
				_t = _t.getFirstChild();
				t1=tableUnionList(_t);
				_t = _retTree;
				_t = __t162;
				_t = _t.getNextSibling();
				
							union.addTableListModel(t1);
							model = union;
						
				break;
			}
			case 33:
			{
				AST __t163 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,33);
				_t = _t.getFirstChild();
				tableModel1=table_name(_t);
				_t = _retTree;
				tableModel2=table_name(_t);
				_t = _retTree;
				method=compare_method(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t163;
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
				AST __t164 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,SELECT_STATEMENT);
				_t = _t.getFirstChild();
				model=select_statement(_t);
				_t = _retTree;
				_t = __t164;
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
				AST __t166 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=tableUnionList(_t);
				_t = _retTree;
				m2=tableUnionList(_t);
				_t = _retTree;
				_t = __t166;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_as:
			case 57:
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
			case LITERAL_as:
			{
				AST __t245 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				t1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t245;
				_t = _t.getNextSibling();
				model = new TableModel(t1.getText()); model.setAlias(ta);
				break;
			}
			case 57:
			{
				AST __t246 = _t;
				AST tmp14_AST_in = (AST)_t;
				match(_t,57);
				_t = _t.getFirstChild();
				t2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t246;
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
		rValue = "";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_exists:
			case 272:
			case 273:
			{
				v1 = _t==ASTNULL ? null : (AST)_t;
				comparemethod_name(_t);
				_t = _retTree;
				rValue = v1.getText();
				break;
			}
			case LOGICAL_NOT_EXISTS:
			{
				AST __t168 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_EXISTS);
				_t = _t.getFirstChild();
				AST tmp16_AST_in = (AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getNextSibling();
				AST tmp17_AST_in = (AST)_t;
				match(_t,LITERAL_exists);
				_t = _t.getNextSibling();
				_t = __t168;
				_t = _t.getNextSibling();
				rValue = "not exists";
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
			case 41:
			{
				AST __t170 = _t;
				AST tmp18_AST_in = (AST)_t;
				match(_t,41);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t170;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t171 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t171;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case 39:
			{
				AST __t172 = _t;
				AST tmp20_AST_in = (AST)_t;
				match(_t,39);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t172;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case LITERAL_select:
			{
				AST __t173 = _t;
				AST tmp21_AST_in = (AST)_t;
				match(_t,LITERAL_select);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t173;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case 43:
			{
				AST __t174 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,43);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t174;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case LITERAL_from:
			{
				AST __t175 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,LITERAL_from);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t175;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case 35:
			{
				AST __t176 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,35);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t176;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case LITERAL_where:
			{
				AST __t177 = _t;
				AST tmp25_AST_in = (AST)_t;
				match(_t,LITERAL_where);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t177;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case 46:
			{
				AST __t178 = _t;
				AST tmp26_AST_in = (AST)_t;
				match(_t,46);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t178;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case LITERAL_group:
			{
				AST __t179 = _t;
				AST tmp27_AST_in = (AST)_t;
				match(_t,LITERAL_group);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t179;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case 48:
			{
				AST __t180 = _t;
				AST tmp28_AST_in = (AST)_t;
				match(_t,48);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t180;
				_t = _t.getNextSibling();
				model.addChild(s); model.setOrderExpressionList(order);
				break;
			}
			case LITERAL_order:
			{
				AST __t181 = _t;
				AST tmp29_AST_in = (AST)_t;
				match(_t,LITERAL_order);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t181;
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
			case LITERAL_exists:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,LITERAL_exists);
				_t = _t.getNextSibling();
				break;
			}
			case 272:
			{
				AST tmp31_AST_in = (AST)_t;
				match(_t,272);
				_t = _t.getNextSibling();
				break;
			}
			case 273:
			{
				AST tmp32_AST_in = (AST)_t;
				match(_t,273);
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
			case 39:
			{
				AST tmp33_AST_in = (AST)_t;
				match(_t,39);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_select:
			{
				AST tmp34_AST_in = (AST)_t;
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
			if ((_t.getType()==COMMA)) {
				AST __t183 = _t;
				AST tmp35_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=select_list(_t);
				_t = _retTree;
				m2=select_list(_t);
				_t = _retTree;
				_t = __t183;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_1.member(_t.getType()))) {
				c=column(_t);
				_t = _retTree;
				model.addColumn(c);
			}
			else {
				throw new NoViableAltException(_t);
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
				AST __t185 = _t;
				AST tmp36_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=table_list(_t);
				_t = _retTree;
				m2=table_list(_t);
				_t = _retTree;
				_t = __t185;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_as:
			case 57:
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
			if ((_t.getType()==COMMA)) {
				AST __t195 = _t;
				AST tmp37_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=aggregate_expression_list(_t);
				_t = _retTree;
				m2=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t195;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_2.member(_t.getType()))) {
				expr=aggregate_expression(_t);
				_t = _retTree;
				model.addAggregateExpression(expr);
			}
			else {
				throw new NoViableAltException(_t);
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
			if ((_t.getType()==COMMA)) {
				AST __t197 = _t;
				AST tmp38_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=order_expression_list(_t);
				_t = _retTree;
				m2=order_expression_list(_t);
				_t = _retTree;
				_t = __t197;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_3.member(_t.getType()))) {
				e=order_expression(_t);
				_t = _retTree;
				model.addOrderExpression(e);
			}
			else {
				throw new NoViableAltException(_t);
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
		AST n = null;
		AST nn = null;
		AST btw = null;
		AST ct1 = null;
		AST ct2 = null;
		
			ExpressionModel e1, e2, e3;
			EquationModel equation;
			model=new EquationModel();
			String nullStr = "";
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMPARE_OP:
			{
				AST __t203 = _t;
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
				_t = __t203;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);
				break;
			}
			case LOGICAL_NOT_LIKE:
			{
				AST __t204 = _t;
				AST tmp40_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_LIKE);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST tmp41_AST_in = (AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getNextSibling();
				AST tmp42_AST_in = (AST)_t;
				match(_t,LITERAL_like);
				_t = _t.getNextSibling();
				e2=expression(_t);
				_t = _retTree;
				_t = __t204;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("not like"); model.addExpression(e2);
				break;
			}
			case LOGICAL_NULL:
			{
				AST __t205 = _t;
				AST tmp43_AST_in = (AST)_t;
				match(_t,LOGICAL_NULL);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST tmp44_AST_in = (AST)_t;
				match(_t,LITERAL_is);
				_t = _t.getNextSibling();
				AST tmp45_AST_in = (AST)_t;
				match(_t,LITERAL_null);
				_t = _t.getNextSibling();
				_t = __t205;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is null");
				break;
			}
			case 69:
			{
				AST __t206 = _t;
				n = _t==ASTNULL ? null :(AST)_t;
				match(_t,69);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t206;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(n.getText());
				break;
			}
			case LOGICAL_NOT_NULL:
			{
				AST __t207 = _t;
				AST tmp46_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_NULL);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST tmp47_AST_in = (AST)_t;
				match(_t,LITERAL_is);
				_t = _t.getNextSibling();
				AST tmp48_AST_in = (AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getNextSibling();
				AST tmp49_AST_in = (AST)_t;
				match(_t,LITERAL_null);
				_t = _t.getNextSibling();
				_t = __t207;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is not null");
				break;
			}
			case 70:
			{
				AST __t208 = _t;
				nn = _t==ASTNULL ? null :(AST)_t;
				match(_t,70);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t208;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nn.getText());
				break;
			}
			case LITERAL_between:
			{
				AST __t209 = _t;
				AST tmp50_AST_in = (AST)_t;
				match(_t,LITERAL_between);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t209;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("between");
					 model.addExpression(e2); model.addExpression(e3);
				break;
			}
			case 72:
			{
				AST __t210 = _t;
				btw = _t==ASTNULL ? null :(AST)_t;
				match(_t,72);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t210;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(btw.getText());
					 model.addExpression(e2); model.addExpression(e3);
					
				break;
			}
			case LOGICAL_IN:
			{
				AST __t211 = _t;
				AST tmp51_AST_in = (AST)_t;
				match(_t,LOGICAL_IN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST tmp52_AST_in = (AST)_t;
				match(_t,LITERAL_in);
				_t = _t.getNextSibling();
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t211;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("in"); model.addExpression(e2);
				break;
			}
			case 74:
			{
				AST __t212 = _t;
				ct1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,74);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t212;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);
				break;
			}
			case LOGICAL_NOT_IN:
			{
				AST __t213 = _t;
				AST tmp53_AST_in = (AST)_t;
				match(_t,LOGICAL_NOT_IN);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				AST tmp54_AST_in = (AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getNextSibling();
				AST tmp55_AST_in = (AST)_t;
				match(_t,LITERAL_in);
				_t = _t.getNextSibling();
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t213;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("not in"); model.addExpression(e2);
				break;
			}
			case 75:
			{
				AST __t214 = _t;
				ct2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,75);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t214;
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
		AST op = null;
		AggregateExprModel a1, a2; FieldModel field; FunctionModel func; model=new AggregateExprModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST __t221 = _t;
				AST tmp56_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				a1=aggregate_expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				a2=aggregate_expression(_t);
				_t = _retTree;
				_t = __t221;
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
			default:
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_4.member(_t.getType()))) {
					func=function(_t);
					_t = _retTree;
					model.addFunction(func);
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
	
	public final OrderExpressionModel  order_expression(AST _t) throws RecognitionException {
		OrderExpressionModel model;
		
		AST order_expression_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		FunctionModel func; FieldModel field; OrderAliasModel alias; OrderExpressionModel o; model=new OrderExpressionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_asc:
			{
				AST __t223 = _t;
				AST tmp57_AST_in = (AST)_t;
				match(_t,LITERAL_asc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t223;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case 62:
			{
				AST __t224 = _t;
				AST tmp58_AST_in = (AST)_t;
				match(_t,62);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t224;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case LITERAL_desc:
			{
				AST __t225 = _t;
				AST tmp59_AST_in = (AST)_t;
				match(_t,LITERAL_desc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t225;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.DESC);
				break;
			}
			case 63:
			{
				AST __t226 = _t;
				AST tmp60_AST_in = (AST)_t;
				match(_t,63);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t226;
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
				else if ((_tokenSet_4.member(_t.getType()))) {
					func=function(_t);
					_t = _retTree;
					model.addFunction(func);
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
		AST allf = null;
		FieldModel f; FunctionModel func; ParamModel param; ExpressionModel e1, e2; model=new ExpressionModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TWO_ARG_OP:
			{
				AST __t230 = _t;
				AST tmp61_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t230;
				_t = _t.getNextSibling();
				model.addChild(e1); model.addOperator(op.getText()); model.addChild(e2);
				break;
			}
			case ONE_ARG_OP:
			{
				AST __t231 = _t;
				AST tmp62_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getFirstChild();
				op1 = _t==ASTNULL ? null : (AST)_t;
				one_arg_op(_t);
				_t = _retTree;
				e1=expression(_t);
				_t = _retTree;
				_t = __t231;
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
			case PARAM_ID:
			{
				param=param_equ(_t);
				_t = _retTree;
				model.addParam(param);
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
			case ALL_FIELDS:
			{
				allf = (AST)_t;
				match(_t,ALL_FIELDS);
				_t = _t.getNextSibling();
				model.addOperator(allf.getText());
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_5.member(_t.getType()))) {
					dkw = _t==ASTNULL ? null : (AST)_t;
					date_key_word(_t);
					_t = _retTree;
					model.addConstant(dkw.getText());
				}
				else if ((_tokenSet_4.member(_t.getType()))) {
					func=function(_t);
					_t = _retTree;
					model.addFunction(func);
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
				AST tmp63_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 59:
			{
				AST tmp64_AST_in = (AST)_t;
				match(_t,59);
				_t = _t.getNextSibling();
				break;
			}
			case 263:
			{
				AST tmp65_AST_in = (AST)_t;
				match(_t,263);
				_t = _t.getNextSibling();
				break;
			}
			case 264:
			{
				AST tmp66_AST_in = (AST)_t;
				match(_t,264);
				_t = _t.getNextSibling();
				break;
			}
			case 265:
			{
				AST tmp67_AST_in = (AST)_t;
				match(_t,265);
				_t = _t.getNextSibling();
				break;
			}
			case 266:
			{
				AST tmp68_AST_in = (AST)_t;
				match(_t,266);
				_t = _t.getNextSibling();
				break;
			}
			case 267:
			{
				AST tmp69_AST_in = (AST)_t;
				match(_t,267);
				_t = _t.getNextSibling();
				break;
			}
			case 268:
			{
				AST tmp70_AST_in = (AST)_t;
				match(_t,268);
				_t = _t.getNextSibling();
				break;
			}
			case 269:
			{
				AST tmp71_AST_in = (AST)_t;
				match(_t,269);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_like:
			{
				AST tmp72_AST_in = (AST)_t;
				match(_t,LITERAL_like);
				_t = _t.getNextSibling();
				break;
			}
			case 270:
			{
				AST tmp73_AST_in = (AST)_t;
				match(_t,270);
				_t = _t.getNextSibling();
				break;
			}
			case LEFT_JOIN:
			{
				AST tmp74_AST_in = (AST)_t;
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
		model = new ExpressionModel(); ExprContainModel expr;
		
		try {      // for error handling
			AST __t216 = _t;
			AST tmp75_AST_in = (AST)_t;
			match(_t,SUBCONTAIN_OP);
			_t = _t.getFirstChild();
			AST tmp76_AST_in = (AST)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			expr=constexpset(_t);
			_t = _retTree;
			AST tmp77_AST_in = (AST)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			_t = __t216;
			_t = _t.getNextSibling();
			
						model.addExprContainModel(expr);
					
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
				AST __t218 = _t;
				AST tmp78_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				cep1=constexpset(_t);
				_t = _retTree;
				cep2=constexpset(_t);
				_t = _retTree;
				_t = __t218;
				_t = _t.getNextSibling();
				model.addChild(cep1); model.addChild(cep2);
				break;
			}
			case QUOTED_STRING:
			case REAL_NUM:
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
			case TWO_ARG_OP:
			{
				AST tmp79_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST tmp80_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST tmp81_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getNextSibling();
				break;
			}
			case 254:
			{
				AST tmp82_AST_in = (AST)_t;
				match(_t,254);
				_t = _t.getNextSibling();
				break;
			}
			case 255:
			{
				AST tmp83_AST_in = (AST)_t;
				match(_t,255);
				_t = _t.getNextSibling();
				break;
			}
			case 256:
			{
				AST tmp84_AST_in = (AST)_t;
				match(_t,256);
				_t = _t.getNextSibling();
				break;
			}
			case 257:
			{
				AST tmp85_AST_in = (AST)_t;
				match(_t,257);
				_t = _t.getNextSibling();
				break;
			}
			case 258:
			{
				AST tmp86_AST_in = (AST)_t;
				match(_t,258);
				_t = _t.getNextSibling();
				break;
			}
			case 259:
			{
				AST tmp87_AST_in = (AST)_t;
				match(_t,259);
				_t = _t.getNextSibling();
				break;
			}
			case 260:
			{
				AST tmp88_AST_in = (AST)_t;
				match(_t,260);
				_t = _t.getNextSibling();
				break;
			}
			case 261:
			{
				AST tmp89_AST_in = (AST)_t;
				match(_t,261);
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
				AST __t234 = _t;
				AST tmp90_AST_in = (AST)_t;
				match(_t,POINT);
				_t = _t.getFirstChild();
				t = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				f1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t234;
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
		AST fun1 = null;
		AST fun2 = null;
		AST all = null;
		AST af11 = null;
		AST af12 = null;
		AST dist = null;
		AST af21 = null;
		AST af22 = null;
		
			model=null;
			ParametersModel p; 
			ExpressionModel express1 = new ExpressionModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FUNCTION_EMPTY_PARAM:
			{
				AST __t236 = _t;
				AST tmp91_AST_in = (AST)_t;
				match(_t,FUNCTION_EMPTY_PARAM);
				_t = _t.getFirstChild();
				fun1 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				_t = __t236;
				_t = _t.getNextSibling();
				model=new FunctionModel(fun1.getText());
				break;
			}
			case FUNCTION_COUNT:
			{
				AST __t237 = _t;
				AST tmp92_AST_in = (AST)_t;
				match(_t,FUNCTION_COUNT);
				_t = _t.getFirstChild();
				fun2 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				_t = __t237;
				_t = _t.getNextSibling();
					model=new FunctionModel(fun2.getText());
						express1.addOperator("*");
						p = new ParametersModel();
						p.addParameter(express1);
						model.setParameters(p);
					
				break;
			}
			case 85:
			{
				AST __t238 = _t;
				all = _t==ASTNULL ? null :(AST)_t;
				match(_t,85);
				_t = _t.getFirstChild();
				af11 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t238;
				_t = _t.getNextSibling();
				model=new FunctionModel(af11.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case LITERAL_all:
			{
				AST __t239 = _t;
				AST tmp93_AST_in = (AST)_t;
				match(_t,LITERAL_all);
				_t = _t.getFirstChild();
				af12 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t239;
				_t = _t.getNextSibling();
				model=new FunctionModel(af12.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case 41:
			{
				AST __t240 = _t;
				dist = _t==ASTNULL ? null :(AST)_t;
				match(_t,41);
				_t = _t.getFirstChild();
				af21 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t240;
				_t = _t.getNextSibling();
				model=new FunctionModel(af21.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t241 = _t;
				AST tmp94_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				af22 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t241;
				_t = _t.getNextSibling();
				model=new FunctionModel(af22.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_tokenSet_6.member(_t.getType()))) {
					f = _t==ASTNULL ? null : (AST)_t;
					function_name(_t);
					_t = _retTree;
					p=parameters(_t);
					_t = _retTree;
					model=new FunctionModel(f.getText()); model.setParameters(p);
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
			AST tmp95_AST_in = (AST)_t;
			match(_t,ONE_ARG_OP);
			_t = _t.getNextSibling();
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
				AST tmp96_AST_in = (AST)_t;
				match(_t,LITERAL_year);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_yy:
			{
				AST tmp97_AST_in = (AST)_t;
				match(_t,LITERAL_yy);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_month:
			{
				AST tmp98_AST_in = (AST)_t;
				match(_t,LITERAL_month);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mm:
			{
				AST tmp99_AST_in = (AST)_t;
				match(_t,LITERAL_mm);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_day:
			{
				AST tmp100_AST_in = (AST)_t;
				match(_t,LITERAL_day);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dd:
			{
				AST tmp101_AST_in = (AST)_t;
				match(_t,LITERAL_dd);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_quarter:
			{
				AST tmp102_AST_in = (AST)_t;
				match(_t,LITERAL_quarter);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_qq:
			{
				AST tmp103_AST_in = (AST)_t;
				match(_t,LITERAL_qq);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_week:
			{
				AST tmp104_AST_in = (AST)_t;
				match(_t,LITERAL_week);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_wk:
			{
				AST tmp105_AST_in = (AST)_t;
				match(_t,LITERAL_wk);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dayofyear:
			{
				AST tmp106_AST_in = (AST)_t;
				match(_t,LITERAL_dayofyear);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dy:
			{
				AST tmp107_AST_in = (AST)_t;
				match(_t,LITERAL_dy);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_weekday:
			{
				AST tmp108_AST_in = (AST)_t;
				match(_t,LITERAL_weekday);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dw:
			{
				AST tmp109_AST_in = (AST)_t;
				match(_t,LITERAL_dw);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hour:
			{
				AST tmp110_AST_in = (AST)_t;
				match(_t,LITERAL_hour);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hh:
			{
				AST tmp111_AST_in = (AST)_t;
				match(_t,LITERAL_hh);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minute:
			{
				AST tmp112_AST_in = (AST)_t;
				match(_t,LITERAL_minute);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mi:
			{
				AST tmp113_AST_in = (AST)_t;
				match(_t,LITERAL_mi);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_second:
			{
				AST tmp114_AST_in = (AST)_t;
				match(_t,LITERAL_second);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ss:
			{
				AST tmp115_AST_in = (AST)_t;
				match(_t,LITERAL_ss);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_millisecond:
			{
				AST tmp116_AST_in = (AST)_t;
				match(_t,LITERAL_millisecond);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ms:
			{
				AST tmp117_AST_in = (AST)_t;
				match(_t,LITERAL_ms);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_calweekofyear:
			{
				AST tmp118_AST_in = (AST)_t;
				match(_t,LITERAL_calweekofyear);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cwk:
			{
				AST tmp119_AST_in = (AST)_t;
				match(_t,LITERAL_cwk);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_calyearofweek:
			{
				AST tmp120_AST_in = (AST)_t;
				match(_t,LITERAL_calyearofweek);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cyr:
			{
				AST tmp121_AST_in = (AST)_t;
				match(_t,LITERAL_cyr);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_caldayofweek:
			{
				AST tmp122_AST_in = (AST)_t;
				match(_t,LITERAL_caldayofweek);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cdw:
			{
				AST tmp123_AST_in = (AST)_t;
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
	
	public final void function_name(AST _t) throws RecognitionException {
		
		AST function_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 82:
			case LITERAL_count:
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			{
				aggregate_func_name(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_abs:
			case 97:
			case LITERAL_acos:
			case 99:
			case LITERAL_asin:
			case 101:
			case LITERAL_atan:
			case 103:
			case 104:
			case 105:
			case LITERAL_ceiling:
			case 107:
			case LITERAL_cos:
			case 109:
			case LITERAL_cot:
			case 111:
			case LITERAL_degrees:
			case 113:
			case LITERAL_exp:
			case 115:
			case LITERAL_floor:
			case 117:
			case LITERAL_log:
			case 119:
			case 120:
			case 121:
			case LITERAL_mod:
			case 123:
			case LITERAL_pi:
			case 125:
			case LITERAL_power:
			case 127:
			case LITERAL_radians:
			case 129:
			case LITERAL_rand:
			case 131:
			case LITERAL_round:
			case 134:
			case LITERAL_sign:
			case 136:
			case LITERAL_sin:
			case 138:
			case LITERAL_sqrt:
			case 140:
			case LITERAL_tan:
			case 142:
			{
				number_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_ascii:
			case 145:
			case LITERAL_char:
			case 149:
			case LITERAL_char_length:
			case 151:
			case LITERAL_charindex:
			case 153:
			case LITERAL_difference:
			case 155:
			case LITERAL_lcase:
			case LITERAL_left:
			case 159:
			case LITERAL_length:
			case 161:
			case LITERAL_lower:
			case 164:
			case LITERAL_ltrim:
			case 166:
			case LITERAL_patindex:
			case 169:
			case LITERAL_replace:
			case 172:
			case LITERAL_right:
			case LITERAL_rtrim:
			case 177:
			case LITERAL_str:
			case 183:
			case LITERAL_substring:
			case 187:
			case LITERAL_upper:
			case 191:
			{
				string_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_dateformat:
			case 193:
			case LITERAL_datename:
			case 195:
			case LITERAL_datepart:
			case 197:
			case LITERAL_datetime:
			case 199:
			case LITERAL_date:
			case LITERAL_dayname:
			case LITERAL_days:
			case LITERAL_day:
			case LITERAL_dow:
			case LITERAL_hours:
			case LITERAL_hour:
			case LITERAL_minutes:
			case LITERAL_minute:
			case LITERAL_monthname:
			case LITERAL_months:
			case LITERAL_month:
			case LITERAL_now:
			case 213:
			case LITERAL_quarter:
			case LITERAL_seconds:
			case LITERAL_second:
			case LITERAL_today:
			case 218:
			case LITERAL_weeks:
			case LITERAL_week:
			case LITERAL_years:
			case LITERAL_year:
			case LITERAL_getdate:
			case 225:
			case LITERAL_dateadd:
			case 227:
			case LITERAL_datediff:
			case 229:
			{
				datetime_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_convert:
			case 231:
			case LITERAL_cast:
			case LITERAL_hextoint:
			case 234:
			case LITERAL_inttohex:
			case 236:
			case LITERAL_isdate:
			case 238:
			case LITERAL_isnumeric:
			case 240:
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
			case LITERAL_decode:
			case LITERAL_dump:
			case LITERAL_greatest:
			case LITERAL_least:
			case LITERAL_nvl:
			case LITERAL_vsize:
			{
				other_function(_t);
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
	
	public final ParametersModel  parameters(AST _t) throws RecognitionException {
		ParametersModel model;
		
		AST parameters_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		ParametersModel p1, p2; ExpressionModel e; model=new ParametersModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			if ((_t.getType()==COMMA)) {
				AST __t243 = _t;
				AST tmp124_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				p1=parameters(_t);
				_t = _retTree;
				p2=parameters(_t);
				_t = _retTree;
				_t = __t243;
				_t = _t.getNextSibling();
				model.addChild(p1); model.addChild(p2);
			}
			else if ((_tokenSet_0.member(_t.getType()))) {
				e=expression(_t);
				_t = _retTree;
				model.addParameter(e);
			}
			else {
				throw new NoViableAltException(_t);
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return model;
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
	
	public final void distinct(AST _t) throws RecognitionException {
		
		AST distinct_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 41:
			{
				AST tmp125_AST_in = (AST)_t;
				match(_t,41);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_distinct:
			{
				AST tmp126_AST_in = (AST)_t;
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
	
	public final void logic_op(AST _t) throws RecognitionException {
		
		AST logic_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_and:
			{
				AST tmp127_AST_in = (AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_or:
			{
				AST tmp128_AST_in = (AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getNextSibling();
				break;
			}
			case 52:
			{
				AST tmp129_AST_in = (AST)_t;
				match(_t,52);
				_t = _t.getNextSibling();
				break;
			}
			case 53:
			{
				AST tmp130_AST_in = (AST)_t;
				match(_t,53);
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
	
	public final void aggregate_func_name(AST _t) throws RecognitionException {
		
		AST aggregate_func_name_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_sum:
			{
				AST tmp131_AST_in = (AST)_t;
				match(_t,LITERAL_sum);
				_t = _t.getNextSibling();
				break;
			}
			case 87:
			{
				AST tmp132_AST_in = (AST)_t;
				match(_t,87);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_avg:
			{
				AST tmp133_AST_in = (AST)_t;
				match(_t,LITERAL_avg);
				_t = _t.getNextSibling();
				break;
			}
			case 89:
			{
				AST tmp134_AST_in = (AST)_t;
				match(_t,89);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_max:
			{
				AST tmp135_AST_in = (AST)_t;
				match(_t,LITERAL_max);
				_t = _t.getNextSibling();
				break;
			}
			case 91:
			{
				AST tmp136_AST_in = (AST)_t;
				match(_t,91);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_min:
			{
				AST tmp137_AST_in = (AST)_t;
				match(_t,LITERAL_min);
				_t = _t.getNextSibling();
				break;
			}
			case 93:
			{
				AST tmp138_AST_in = (AST)_t;
				match(_t,93);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_count:
			{
				AST tmp139_AST_in = (AST)_t;
				match(_t,LITERAL_count);
				_t = _t.getNextSibling();
				break;
			}
			case 82:
			{
				AST tmp140_AST_in = (AST)_t;
				match(_t,82);
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
				AST tmp141_AST_in = (AST)_t;
				match(_t,LITERAL_abs);
				_t = _t.getNextSibling();
				break;
			}
			case 97:
			{
				AST tmp142_AST_in = (AST)_t;
				match(_t,97);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_acos:
			{
				AST tmp143_AST_in = (AST)_t;
				match(_t,LITERAL_acos);
				_t = _t.getNextSibling();
				break;
			}
			case 99:
			{
				AST tmp144_AST_in = (AST)_t;
				match(_t,99);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_asin:
			{
				AST tmp145_AST_in = (AST)_t;
				match(_t,LITERAL_asin);
				_t = _t.getNextSibling();
				break;
			}
			case 101:
			{
				AST tmp146_AST_in = (AST)_t;
				match(_t,101);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_atan:
			{
				AST tmp147_AST_in = (AST)_t;
				match(_t,LITERAL_atan);
				_t = _t.getNextSibling();
				break;
			}
			case 103:
			{
				AST tmp148_AST_in = (AST)_t;
				match(_t,103);
				_t = _t.getNextSibling();
				break;
			}
			case 104:
			{
				AST tmp149_AST_in = (AST)_t;
				match(_t,104);
				_t = _t.getNextSibling();
				break;
			}
			case 105:
			{
				AST tmp150_AST_in = (AST)_t;
				match(_t,105);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ceiling:
			{
				AST tmp151_AST_in = (AST)_t;
				match(_t,LITERAL_ceiling);
				_t = _t.getNextSibling();
				break;
			}
			case 107:
			{
				AST tmp152_AST_in = (AST)_t;
				match(_t,107);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cos:
			{
				AST tmp153_AST_in = (AST)_t;
				match(_t,LITERAL_cos);
				_t = _t.getNextSibling();
				break;
			}
			case 109:
			{
				AST tmp154_AST_in = (AST)_t;
				match(_t,109);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cot:
			{
				AST tmp155_AST_in = (AST)_t;
				match(_t,LITERAL_cot);
				_t = _t.getNextSibling();
				break;
			}
			case 111:
			{
				AST tmp156_AST_in = (AST)_t;
				match(_t,111);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_degrees:
			{
				AST tmp157_AST_in = (AST)_t;
				match(_t,LITERAL_degrees);
				_t = _t.getNextSibling();
				break;
			}
			case 113:
			{
				AST tmp158_AST_in = (AST)_t;
				match(_t,113);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_exp:
			{
				AST tmp159_AST_in = (AST)_t;
				match(_t,LITERAL_exp);
				_t = _t.getNextSibling();
				break;
			}
			case 115:
			{
				AST tmp160_AST_in = (AST)_t;
				match(_t,115);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_floor:
			{
				AST tmp161_AST_in = (AST)_t;
				match(_t,LITERAL_floor);
				_t = _t.getNextSibling();
				break;
			}
			case 117:
			{
				AST tmp162_AST_in = (AST)_t;
				match(_t,117);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_log:
			{
				AST tmp163_AST_in = (AST)_t;
				match(_t,LITERAL_log);
				_t = _t.getNextSibling();
				break;
			}
			case 119:
			{
				AST tmp164_AST_in = (AST)_t;
				match(_t,119);
				_t = _t.getNextSibling();
				break;
			}
			case 120:
			{
				AST tmp165_AST_in = (AST)_t;
				match(_t,120);
				_t = _t.getNextSibling();
				break;
			}
			case 121:
			{
				AST tmp166_AST_in = (AST)_t;
				match(_t,121);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mod:
			{
				AST tmp167_AST_in = (AST)_t;
				match(_t,LITERAL_mod);
				_t = _t.getNextSibling();
				break;
			}
			case 123:
			{
				AST tmp168_AST_in = (AST)_t;
				match(_t,123);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_pi:
			{
				AST tmp169_AST_in = (AST)_t;
				match(_t,LITERAL_pi);
				_t = _t.getNextSibling();
				break;
			}
			case 125:
			{
				AST tmp170_AST_in = (AST)_t;
				match(_t,125);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_power:
			{
				AST tmp171_AST_in = (AST)_t;
				match(_t,LITERAL_power);
				_t = _t.getNextSibling();
				break;
			}
			case 127:
			{
				AST tmp172_AST_in = (AST)_t;
				match(_t,127);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_radians:
			{
				AST tmp173_AST_in = (AST)_t;
				match(_t,LITERAL_radians);
				_t = _t.getNextSibling();
				break;
			}
			case 129:
			{
				AST tmp174_AST_in = (AST)_t;
				match(_t,129);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rand:
			{
				AST tmp175_AST_in = (AST)_t;
				match(_t,LITERAL_rand);
				_t = _t.getNextSibling();
				break;
			}
			case 131:
			{
				AST tmp176_AST_in = (AST)_t;
				match(_t,131);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_round:
			{
				AST tmp177_AST_in = (AST)_t;
				match(_t,LITERAL_round);
				_t = _t.getNextSibling();
				break;
			}
			case 134:
			{
				AST tmp178_AST_in = (AST)_t;
				match(_t,134);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sign:
			{
				AST tmp179_AST_in = (AST)_t;
				match(_t,LITERAL_sign);
				_t = _t.getNextSibling();
				break;
			}
			case 136:
			{
				AST tmp180_AST_in = (AST)_t;
				match(_t,136);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sin:
			{
				AST tmp181_AST_in = (AST)_t;
				match(_t,LITERAL_sin);
				_t = _t.getNextSibling();
				break;
			}
			case 138:
			{
				AST tmp182_AST_in = (AST)_t;
				match(_t,138);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sqrt:
			{
				AST tmp183_AST_in = (AST)_t;
				match(_t,LITERAL_sqrt);
				_t = _t.getNextSibling();
				break;
			}
			case 140:
			{
				AST tmp184_AST_in = (AST)_t;
				match(_t,140);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_tan:
			{
				AST tmp185_AST_in = (AST)_t;
				match(_t,LITERAL_tan);
				_t = _t.getNextSibling();
				break;
			}
			case 142:
			{
				AST tmp186_AST_in = (AST)_t;
				match(_t,142);
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
				AST tmp187_AST_in = (AST)_t;
				match(_t,LITERAL_ascii);
				_t = _t.getNextSibling();
				break;
			}
			case 145:
			{
				AST tmp188_AST_in = (AST)_t;
				match(_t,145);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char:
			{
				AST tmp189_AST_in = (AST)_t;
				match(_t,LITERAL_char);
				_t = _t.getNextSibling();
				break;
			}
			case 149:
			{
				AST tmp190_AST_in = (AST)_t;
				match(_t,149);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char_length:
			{
				AST tmp191_AST_in = (AST)_t;
				match(_t,LITERAL_char_length);
				_t = _t.getNextSibling();
				break;
			}
			case 151:
			{
				AST tmp192_AST_in = (AST)_t;
				match(_t,151);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_charindex:
			{
				AST tmp193_AST_in = (AST)_t;
				match(_t,LITERAL_charindex);
				_t = _t.getNextSibling();
				break;
			}
			case 153:
			{
				AST tmp194_AST_in = (AST)_t;
				match(_t,153);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_difference:
			{
				AST tmp195_AST_in = (AST)_t;
				match(_t,LITERAL_difference);
				_t = _t.getNextSibling();
				break;
			}
			case 155:
			{
				AST tmp196_AST_in = (AST)_t;
				match(_t,155);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lcase:
			{
				AST tmp197_AST_in = (AST)_t;
				match(_t,LITERAL_lcase);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_left:
			{
				AST tmp198_AST_in = (AST)_t;
				match(_t,LITERAL_left);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_length:
			{
				AST tmp199_AST_in = (AST)_t;
				match(_t,LITERAL_length);
				_t = _t.getNextSibling();
				break;
			}
			case 161:
			{
				AST tmp200_AST_in = (AST)_t;
				match(_t,161);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lower:
			{
				AST tmp201_AST_in = (AST)_t;
				match(_t,LITERAL_lower);
				_t = _t.getNextSibling();
				break;
			}
			case 164:
			{
				AST tmp202_AST_in = (AST)_t;
				match(_t,164);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ltrim:
			{
				AST tmp203_AST_in = (AST)_t;
				match(_t,LITERAL_ltrim);
				_t = _t.getNextSibling();
				break;
			}
			case 166:
			{
				AST tmp204_AST_in = (AST)_t;
				match(_t,166);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_patindex:
			{
				AST tmp205_AST_in = (AST)_t;
				match(_t,LITERAL_patindex);
				_t = _t.getNextSibling();
				break;
			}
			case 169:
			{
				AST tmp206_AST_in = (AST)_t;
				match(_t,169);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_replace:
			{
				AST tmp207_AST_in = (AST)_t;
				match(_t,LITERAL_replace);
				_t = _t.getNextSibling();
				break;
			}
			case 172:
			{
				AST tmp208_AST_in = (AST)_t;
				match(_t,172);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_right:
			{
				AST tmp209_AST_in = (AST)_t;
				match(_t,LITERAL_right);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rtrim:
			{
				AST tmp210_AST_in = (AST)_t;
				match(_t,LITERAL_rtrim);
				_t = _t.getNextSibling();
				break;
			}
			case 177:
			{
				AST tmp211_AST_in = (AST)_t;
				match(_t,177);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_str:
			{
				AST tmp212_AST_in = (AST)_t;
				match(_t,LITERAL_str);
				_t = _t.getNextSibling();
				break;
			}
			case 183:
			{
				AST tmp213_AST_in = (AST)_t;
				match(_t,183);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_substring:
			{
				AST tmp214_AST_in = (AST)_t;
				match(_t,LITERAL_substring);
				_t = _t.getNextSibling();
				break;
			}
			case 187:
			{
				AST tmp215_AST_in = (AST)_t;
				match(_t,187);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_upper:
			{
				AST tmp216_AST_in = (AST)_t;
				match(_t,LITERAL_upper);
				_t = _t.getNextSibling();
				break;
			}
			case 191:
			{
				AST tmp217_AST_in = (AST)_t;
				match(_t,191);
				_t = _t.getNextSibling();
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==159)) {
					AST tmp218_AST_in = (AST)_t;
					match(_t,159);
					_t = _t.getNextSibling();
				}
				else if ((_t.getType()==159)) {
					AST tmp219_AST_in = (AST)_t;
					match(_t,159);
					_t = _t.getNextSibling();
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
	}
	
	public final void datetime_function(AST _t) throws RecognitionException {
		
		AST datetime_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_dateformat:
			{
				AST tmp220_AST_in = (AST)_t;
				match(_t,LITERAL_dateformat);
				_t = _t.getNextSibling();
				break;
			}
			case 193:
			{
				AST tmp221_AST_in = (AST)_t;
				match(_t,193);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datename:
			{
				AST tmp222_AST_in = (AST)_t;
				match(_t,LITERAL_datename);
				_t = _t.getNextSibling();
				break;
			}
			case 195:
			{
				AST tmp223_AST_in = (AST)_t;
				match(_t,195);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datepart:
			{
				AST tmp224_AST_in = (AST)_t;
				match(_t,LITERAL_datepart);
				_t = _t.getNextSibling();
				break;
			}
			case 197:
			{
				AST tmp225_AST_in = (AST)_t;
				match(_t,197);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datetime:
			{
				AST tmp226_AST_in = (AST)_t;
				match(_t,LITERAL_datetime);
				_t = _t.getNextSibling();
				break;
			}
			case 199:
			{
				AST tmp227_AST_in = (AST)_t;
				match(_t,199);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_date:
			{
				AST tmp228_AST_in = (AST)_t;
				match(_t,LITERAL_date);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dayname:
			{
				AST tmp229_AST_in = (AST)_t;
				match(_t,LITERAL_dayname);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_days:
			{
				AST tmp230_AST_in = (AST)_t;
				match(_t,LITERAL_days);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_day:
			{
				AST tmp231_AST_in = (AST)_t;
				match(_t,LITERAL_day);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dow:
			{
				AST tmp232_AST_in = (AST)_t;
				match(_t,LITERAL_dow);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hours:
			{
				AST tmp233_AST_in = (AST)_t;
				match(_t,LITERAL_hours);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hour:
			{
				AST tmp234_AST_in = (AST)_t;
				match(_t,LITERAL_hour);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minutes:
			{
				AST tmp235_AST_in = (AST)_t;
				match(_t,LITERAL_minutes);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minute:
			{
				AST tmp236_AST_in = (AST)_t;
				match(_t,LITERAL_minute);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_monthname:
			{
				AST tmp237_AST_in = (AST)_t;
				match(_t,LITERAL_monthname);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_months:
			{
				AST tmp238_AST_in = (AST)_t;
				match(_t,LITERAL_months);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_month:
			{
				AST tmp239_AST_in = (AST)_t;
				match(_t,LITERAL_month);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_now:
			{
				AST tmp240_AST_in = (AST)_t;
				match(_t,LITERAL_now);
				_t = _t.getNextSibling();
				break;
			}
			case 213:
			{
				AST tmp241_AST_in = (AST)_t;
				match(_t,213);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_quarter:
			{
				AST tmp242_AST_in = (AST)_t;
				match(_t,LITERAL_quarter);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_seconds:
			{
				AST tmp243_AST_in = (AST)_t;
				match(_t,LITERAL_seconds);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_second:
			{
				AST tmp244_AST_in = (AST)_t;
				match(_t,LITERAL_second);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_today:
			{
				AST tmp245_AST_in = (AST)_t;
				match(_t,LITERAL_today);
				_t = _t.getNextSibling();
				break;
			}
			case 218:
			{
				AST tmp246_AST_in = (AST)_t;
				match(_t,218);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_weeks:
			{
				AST tmp247_AST_in = (AST)_t;
				match(_t,LITERAL_weeks);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_week:
			{
				AST tmp248_AST_in = (AST)_t;
				match(_t,LITERAL_week);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_years:
			{
				AST tmp249_AST_in = (AST)_t;
				match(_t,LITERAL_years);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_year:
			{
				AST tmp250_AST_in = (AST)_t;
				match(_t,LITERAL_year);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_getdate:
			{
				AST tmp251_AST_in = (AST)_t;
				match(_t,LITERAL_getdate);
				_t = _t.getNextSibling();
				break;
			}
			case 225:
			{
				AST tmp252_AST_in = (AST)_t;
				match(_t,225);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dateadd:
			{
				AST tmp253_AST_in = (AST)_t;
				match(_t,LITERAL_dateadd);
				_t = _t.getNextSibling();
				break;
			}
			case 227:
			{
				AST tmp254_AST_in = (AST)_t;
				match(_t,227);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datediff:
			{
				AST tmp255_AST_in = (AST)_t;
				match(_t,LITERAL_datediff);
				_t = _t.getNextSibling();
				break;
			}
			case 229:
			{
				AST tmp256_AST_in = (AST)_t;
				match(_t,229);
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
			case LITERAL_cast:
			{
				AST tmp257_AST_in = (AST)_t;
				match(_t,LITERAL_cast);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_convert:
			{
				AST tmp258_AST_in = (AST)_t;
				match(_t,LITERAL_convert);
				_t = _t.getNextSibling();
				break;
			}
			case 231:
			{
				AST tmp259_AST_in = (AST)_t;
				match(_t,231);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hextoint:
			{
				AST tmp260_AST_in = (AST)_t;
				match(_t,LITERAL_hextoint);
				_t = _t.getNextSibling();
				break;
			}
			case 234:
			{
				AST tmp261_AST_in = (AST)_t;
				match(_t,234);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_inttohex:
			{
				AST tmp262_AST_in = (AST)_t;
				match(_t,LITERAL_inttohex);
				_t = _t.getNextSibling();
				break;
			}
			case 236:
			{
				AST tmp263_AST_in = (AST)_t;
				match(_t,236);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isdate:
			{
				AST tmp264_AST_in = (AST)_t;
				match(_t,LITERAL_isdate);
				_t = _t.getNextSibling();
				break;
			}
			case 238:
			{
				AST tmp265_AST_in = (AST)_t;
				match(_t,238);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isnumeric:
			{
				AST tmp266_AST_in = (AST)_t;
				match(_t,LITERAL_isnumeric);
				_t = _t.getNextSibling();
				break;
			}
			case 240:
			{
				AST tmp267_AST_in = (AST)_t;
				match(_t,240);
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
				AST tmp268_AST_in = (AST)_t;
				match(_t,LITERAL_suser_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_suser_name:
			{
				AST tmp269_AST_in = (AST)_t;
				match(_t,LITERAL_suser_name);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_id:
			{
				AST tmp270_AST_in = (AST)_t;
				match(_t,LITERAL_user_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_name:
			{
				AST tmp271_AST_in = (AST)_t;
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
	
	public final void other_function(AST _t) throws RecognitionException {
		
		AST other_function_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_decode:
			{
				AST tmp272_AST_in = (AST)_t;
				match(_t,LITERAL_decode);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dump:
			{
				AST tmp273_AST_in = (AST)_t;
				match(_t,LITERAL_dump);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_greatest:
			{
				AST tmp274_AST_in = (AST)_t;
				match(_t,LITERAL_greatest);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_least:
			{
				AST tmp275_AST_in = (AST)_t;
				match(_t,LITERAL_least);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_nvl:
			{
				AST tmp276_AST_in = (AST)_t;
				match(_t,LITERAL_nvl);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_vsize:
			{
				AST tmp277_AST_in = (AST)_t;
				match(_t,LITERAL_vsize);
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
		"FUNCTION_EMPTY_PARAM",
		"FUNCTION_COUNT",
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
		"\"not\"",
		"\"exists\"",
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
		"\"\\u5347\\u5e8f\"",
		"\"\\u964d\\u5e8f\"",
		"\"asc\"",
		"\"desc\"",
		"\"like\"",
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"PARAM_ID",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
		"NEGATIVE_DIGIT_ELEMENT",
		"\"\\u6c42\\u8bb0\\u5f55\\u603b\\u6570\"",
		"\"count\"",
		"\"all\"",
		"\"\\u5168\\u90e8\"",
		"\"sum\"",
		"\"\\u6c42\\u548c\"",
		"\"avg\"",
		"\"\\u6c42\\u5e73\\u5747\\u6570\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"stddev\"",
		"\"variance\"",
		"\"abs\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u503c\\u7684\\u4f59\\u5f26\\u89d2\"",
		"\"asin\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5f26\\u89d2\"",
		"\"atan\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5207\\u89d2\"",
		"\"atin2\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5f26\\u548c\\u4f59\\u5f26\\u89d2\"",
		"\"ceiling\"",
		"\"\\u6c42\\u4e94\\u5165\\u540e\\u7684\\u6574\\u6570\"",
		"\"cos\"",
		"\"\\u6c42\\u89d2\\u7684\\u4f59\\u5f26\\u503c\"",
		"\"cot\"",
		"\"\\u6c42\\u89d2\\u7684\\u4f59\\u5207\\u503c\"",
		"\"degrees\"",
		"\"\\u6c42\\u5f27\\u5ea6\\u6570\\u7684\\u89d2\\u5927\\u5c0f\"",
		"\"exp\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"floor\"",
		"\"\\u6c42\\u56db\\u820d\\u540e\\u7684\\u6574\\u6570\"",
		"\"log\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log10\"",
		"\"\\u6c4210\\u4e3a\\u5e95\\u7684\\u5bf9\\u6570\"",
		"\"mod\"",
		"\"\\u6c42\\u4f59\"",
		"\"pi\"",
		"\"\\u6c42PI\"",
		"\"power\"",
		"\"\\u6c42\\u6570\\u5b57\\u7684\\u6b21\\u5e42\\u503c\"",
		"\"radians\"",
		"\"\\u6c42\\u5ea6\\u6570\\u89d2\\u7684\\u5f27\\u5ea6\"",
		"\"rand\"",
		"\"\\u6c420\\u548c1\\u95f4\\u7684\\u968f\\u673a\\u6570\"",
		"\"remaiindex\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"sign\"",
		"\"\\u6c42\\u503c\\u7684\\u7b26\\u53f7\"",
		"\"sin\"",
		"\"\\u6c42\\u89d2\\u7684\\u6b63\\u5f26\\u503c\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"tan\"",
		"\"\\u6c42\\u89d2\\u7684\\u6b63\\u5207\\u503c\"",
		"\"truncnum\"",
		"\"ascii\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u4e2a\\u5b57\\u7b26\\u7684ASCII\\u7801\"",
		"\"bit_length\"",
		"\"byte_length\"",
		"\"char\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u5dee\\u503c\"",
		"\"insertstr\"",
		"\"lcase\"",
		"\"left\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5de6\\u622a\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u603b\\u957f\\u5ea6\"",
		"\"locate\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"octet_length\"",
		"\"patindex\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u6b21\\u51fa\\u73b0\\u4f4d\\u7f6e\"",
		"\"repeat\"",
		"\"replace\"",
		"\"\\u5b57\\u7b26\\u4e32\\u66ff\\u6362\"",
		"\"replicate\"",
		"\"right\"",
		"\"\\u5b57\\u7b26\\u4e32\\u53f3\\u622a\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"similar\"",
		"\"sortkey\"",
		"\"soundex\"",
		"\"space\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"string\"",
		"\"stuff\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"trim\"",
		"\"ucase\"",
		"\"upper\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5927\\u5199\"",
		"\"dateformat\"",
		"\"\\u683c\\u5f0f\\u5316\\u65e5\\u671f\"",
		"\"datename\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u503c\"",
		"\"datepart\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u6574\\u6570\\u503c\"",
		"\"datetime\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"date\"",
		"\"dayname\"",
		"\"days\"",
		"\"day\"",
		"\"dow\"",
		"\"hours\"",
		"\"hour\"",
		"\"minutes\"",
		"\"minute\"",
		"\"monthname\"",
		"\"months\"",
		"\"month\"",
		"\"now\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"quarter\"",
		"\"seconds\"",
		"\"second\"",
		"\"today\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\"",
		"\"weeks\"",
		"\"week\"",
		"\"years\"",
		"\"year\"",
		"\"ymd\"",
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u76f8\\u52a0\"",
		"\"datediff\"",
		"\"\\u65e5\\u671f\\u76f8\\u51cf\"",
		"\"convert\"",
		"\"\\u5b57\\u7b26\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"cast\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u4e3a\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u4e3a\\u6570\\u503c\\u578b\"",
		"\"suser_id\"",
		"\"suser_name\"",
		"\"user_id\"",
		"\"user_name\"",
		"\"decode\"",
		"\"dump\"",
		"\"greatest\"",
		"\"least\"",
		"\"nvl\"",
		"\"vsize\"",
		"ONE_ARG_OP",
		"TWO_ARG_OP",
		"MINUS",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u5f02\\u6216\"",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"\"\\u6c42\\u6a21\"",
		"COMPARE_OP",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"\\u5de6\\u8fde\\u63a5\"",
		"LEFT_JOIN",
		"\"\\u5b58\\u5728\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"yy\"",
		"\"mm\"",
		"\"dd\"",
		"\"qq\"",
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
		"PARAM_LPAREN",
		"PARAM_RPAREN",
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
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[10];
		data[0]=18017697061148672L;
		data[1]=-3221229568L;
		data[2]=-3692006681648857105L;
		data[3]=2305843007066210303L;
		data[4]=274877644800L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[10];
		data[0]=234190479174932992L;
		data[1]=-3221229568L;
		data[2]=-3692006681648857105L;
		data[3]=2305843007066210303L;
		data[4]=274877644800L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=3298534889472L;
		data[1]=-3221446656L;
		data[2]=-3692006681648857105L;
		data[3]=1729382254762786815L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=-4611682719892498432L;
		data[1]=-3221430269L;
		data[2]=-3692006681648857105L;
		data[3]=576460750155939839L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=3298534889472L;
		data[1]=-3221487616L;
		data[2]=-3692006681648857105L;
		data[3]=576460750155939839L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[10];
		data[3]=1363757056L;
		data[4]=274877644800L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[8];
		data[1]=-3224633344L;
		data[2]=-3692006681648857105L;
		data[3]=576460750155939839L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	}
	
