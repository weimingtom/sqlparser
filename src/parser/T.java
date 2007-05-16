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
				AST __t209 = _t;
				AST tmp3_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t209;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case 48:
			{
				AST __t210 = _t;
				AST tmp4_AST_in = (AST)_t;
				match(_t,48);
				_t = _t.getFirstChild();
				e=expression(_t);
				_t = _retTree;
				a=alias(_t);
				_t = _retTree;
				_t = __t210;
				_t = _t.getNextSibling();
				model.addExpression(e); model.addAlias(a);
				break;
			}
			case ALIAS_EQU:
			{
				AST __t211 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,ALIAS_EQU);
				_t = _t.getFirstChild();
				a=alias(_t);
				_t = _retTree;
				e=expression(_t);
				_t = _retTree;
				_t = __t211;
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
				AST __t197 = _t;
				o1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t197;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o1.getText()); model.addChild(m2);
				break;
			}
			case LITERAL_or:
			{
				AST __t198 = _t;
				o2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t198;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o2.getText()); model.addChild(m2);
				break;
			}
			case 43:
			{
				AST __t199 = _t;
				o3 = _t==ASTNULL ? null :(AST)_t;
				match(_t,43);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t199;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);
				break;
			}
			case 44:
			{
				AST __t200 = _t;
				o4 = _t==ASTNULL ? null :(AST)_t;
				match(_t,44);
				_t = _t.getFirstChild();
				m1=search_condition(_t);
				_t = _retTree;
				m2=search_condition(_t);
				_t = _retTree;
				_t = __t200;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);
				break;
			}
			case LOGIC_BLOCK:
			{
				AST __t201 = _t;
				AST tmp6_AST_in = (AST)_t;
				match(_t,LOGIC_BLOCK);
				_t = _t.getFirstChild();
				m3=search_condition(_t);
				_t = _retTree;
				_t = __t201;
				_t = _t.getNextSibling();
				model.addOperator("("); model.addChild(m3); model.addOperator(")");
				break;
			}
			case 40:
			{
				AST __t203 = _t;
				o12 = _t==ASTNULL ? null :(AST)_t;
				match(_t,40);
				_t = _t.getFirstChild();
				m5=search_condition(_t);
				_t = _retTree;
				_t = __t203;
				_t = _t.getNextSibling();
				model.addOperator(o12.getText()); model.addChild(m5);
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==LITERAL_not)) {
					AST __t202 = _t;
					o11 = _t==ASTNULL ? null :(AST)_t;
					match(_t,LITERAL_not);
					_t = _t.getFirstChild();
					m4=search_condition(_t);
					_t = _retTree;
					_t = __t202;
					_t = _t.getNextSibling();
					model.addOperator(o11.getText()); model.addChild(m4);
				}
				else if ((_tokenSet_1.member(_t.getType()))) {
					equ=equation(_t);
					_t = _retTree;
					model.addEquation(equ);
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
	
	public final StatementsModel  statements(AST _t) throws RecognitionException {
		StatementsModel model;
		
		AST statements_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		StatementsModel s1, s2; QueryModel s; model=new StatementsModel();
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SEMI:
			{
				AST __t171 = _t;
				AST tmp7_AST_in = (AST)_t;
				match(_t,SEMI);
				_t = _t.getFirstChild();
				s1=statements(_t);
				_t = _retTree;
				s2=statements(_t);
				_t = _retTree;
				_t = __t171;
				_t = _t.getNextSibling();
				model.addChild(s1); model.addChild(s2);
				break;
			}
			case SELECT_STATEMENT:
			case 19:
			case 22:
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
			case 19:
			{
				AST __t173 = _t;
				AST tmp8_AST_in = (AST)_t;
				match(_t,19);
				_t = _t.getFirstChild();
				t1=tableUnionList(_t);
				_t = _retTree;
				_t = __t173;
				_t = _t.getNextSibling();
				
							union.addTableListModel(t1);
							//union.addTableModel1(tableModel1);
							//union.addTableModel2(tableModel2);
							model = union;
						
				break;
			}
			case 22:
			{
				AST __t174 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,22);
				_t = _t.getFirstChild();
				tableModel1=table_name(_t);
				_t = _retTree;
				tableModel2=table_name(_t);
				_t = _retTree;
				method=compare_method(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t174;
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
				AST __t175 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,SELECT_STATEMENT);
				_t = _t.getFirstChild();
				model=select_statement(_t);
				_t = _retTree;
				_t = __t175;
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
				AST __t177 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=tableUnionList(_t);
				_t = _retTree;
				m2=tableUnionList(_t);
				_t = _retTree;
				_t = __t177;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_as:
			case 48:
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
				AST __t252 = _t;
				AST tmp12_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getFirstChild();
				t1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t252;
				_t = _t.getNextSibling();
				model = new TableModel(t1.getText()); model.setAlias(ta);
				break;
			}
			case 48:
			{
				AST __t253 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,48);
				_t = _t.getFirstChild();
				t2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				ta=tableAlias(_t);
				_t = _retTree;
				_t = __t253;
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
			case 28:
			{
				AST __t180 = _t;
				AST tmp14_AST_in = (AST)_t;
				match(_t,28);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t180;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t181 = _t;
				AST tmp15_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				select(_t);
				_t = _retTree;
				sl=select_list(_t);
				_t = _retTree;
				_t = __t181;
				_t = _t.getNextSibling();
				sl.setDistinct(true); model.setSelectList(sl);
				break;
			}
			case 26:
			{
				AST __t182 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,26);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t182;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case LITERAL_select:
			{
				AST __t183 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,LITERAL_select);
				_t = _t.getFirstChild();
				sl=select_list(_t);
				_t = _retTree;
				_t = __t183;
				_t = _t.getNextSibling();
				model.setSelectList(sl);
				break;
			}
			case 30:
			{
				AST __t184 = _t;
				AST tmp18_AST_in = (AST)_t;
				match(_t,30);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t184;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case LITERAL_from:
			{
				AST __t185 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,LITERAL_from);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				tl=table_list(_t);
				_t = _retTree;
				_t = __t185;
				_t = _t.getNextSibling();
				model.addChild(s); model.setTableList(tl);
				break;
			}
			case 24:
			{
				AST __t186 = _t;
				AST tmp20_AST_in = (AST)_t;
				match(_t,24);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t186;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case LITERAL_where:
			{
				AST __t187 = _t;
				AST tmp21_AST_in = (AST)_t;
				match(_t,LITERAL_where);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				cond=search_condition(_t);
				_t = _retTree;
				_t = __t187;
				_t = _t.getNextSibling();
				model.addChild(s); model.setSearchCondition(cond);
				break;
			}
			case 36:
			{
				AST __t188 = _t;
				AST tmp22_AST_in = (AST)_t;
				match(_t,36);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t188;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case LITERAL_group:
			{
				AST __t189 = _t;
				AST tmp23_AST_in = (AST)_t;
				match(_t,LITERAL_group);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				group=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t189;
				_t = _t.getNextSibling();
				model.addChild(s); model.setGroupExpressionList(group);
				break;
			}
			case 38:
			{
				AST __t190 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,38);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t190;
				_t = _t.getNextSibling();
				model.addChild(s); model.setOrderExpressionList(order);
				break;
			}
			case LITERAL_order:
			{
				AST __t191 = _t;
				AST tmp25_AST_in = (AST)_t;
				match(_t,LITERAL_order);
				_t = _t.getFirstChild();
				s=select_statement(_t);
				_t = _retTree;
				order=order_expression_list(_t);
				_t = _retTree;
				_t = __t191;
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
			case 238:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,238);
				_t = _t.getNextSibling();
				break;
			}
			case 239:
			{
				AST tmp27_AST_in = (AST)_t;
				match(_t,239);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_exists:
			{
				AST tmp28_AST_in = (AST)_t;
				match(_t,LITERAL_exists);
				_t = _t.getNextSibling();
				break;
			}
			case 241:
			{
				AST tmp29_AST_in = (AST)_t;
				match(_t,241);
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
			case 26:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,26);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_select:
			{
				AST tmp31_AST_in = (AST)_t;
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
				AST __t193 = _t;
				AST tmp32_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=select_list(_t);
				_t = _retTree;
				m2=select_list(_t);
				_t = _retTree;
				_t = __t193;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_2.member(_t.getType()))) {
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
				AST __t195 = _t;
				AST tmp33_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=table_list(_t);
				_t = _retTree;
				m2=table_list(_t);
				_t = _retTree;
				_t = __t195;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
				break;
			}
			case LITERAL_as:
			case 48:
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
				AST __t205 = _t;
				AST tmp34_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=aggregate_expression_list(_t);
				_t = _retTree;
				m2=aggregate_expression_list(_t);
				_t = _retTree;
				_t = __t205;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_3.member(_t.getType()))) {
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
				AST __t207 = _t;
				AST tmp35_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				m1=order_expression_list(_t);
				_t = _retTree;
				m2=order_expression_list(_t);
				_t = _retTree;
				_t = __t207;
				_t = _t.getNextSibling();
				model.addChild(m1); model.addChild(m2);
			}
			else if ((_tokenSet_4.member(_t.getType()))) {
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
		AST nn_en = null;
		AST btw = null;
		AST ct1 = null;
		AST ct2 = null;
		
			ExpressionModel e1, e2, e3;
			EquationModel equation;
			model=new EquationModel();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMPARE_OP:
			{
				AST __t213 = _t;
				AST tmp36_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				compare_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t213;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);
				break;
			}
			case 59:
			{
				AST __t214 = _t;
				n = _t==ASTNULL ? null :(AST)_t;
				match(_t,59);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t214;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(n.getText());
				break;
			}
			case LITERAL_null:
			{
				AST __t215 = _t;
				AST tmp37_AST_in = (AST)_t;
				match(_t,LITERAL_null);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t215;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is null");
				break;
			}
			case 60:
			{
				AST __t216 = _t;
				nn = _t==ASTNULL ? null :(AST)_t;
				match(_t,60);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t216;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(nn.getText());
				break;
			}
			case LITERAL_not:
			{
				AST __t217 = _t;
				nn_en = _t==ASTNULL ? null :(AST)_t;
				match(_t,LITERAL_not);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				_t = __t217;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("is not null");
				break;
			}
			case LITERAL_between:
			{
				AST __t218 = _t;
				AST tmp38_AST_in = (AST)_t;
				match(_t,LITERAL_between);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t218;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("between");
					 model.addExpression(e2); model.addExpression(e3);
				break;
			}
			case 62:
			{
				AST __t219 = _t;
				btw = _t==ASTNULL ? null :(AST)_t;
				match(_t,62);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				e3=expression(_t);
				_t = _retTree;
				_t = __t219;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(btw.getText());
					 model.addExpression(e2); model.addExpression(e3);
				break;
			}
			case LITERAL_in:
			{
				AST __t220 = _t;
				AST tmp39_AST_in = (AST)_t;
				match(_t,LITERAL_in);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t220;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("in"); model.addExpression(e2);
				break;
			}
			case 65:
			{
				AST __t221 = _t;
				ct1 = _t==ASTNULL ? null :(AST)_t;
				match(_t,65);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t221;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);
				break;
			}
			case 63:
			{
				AST __t222 = _t;
				AST tmp40_AST_in = (AST)_t;
				match(_t,63);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t222;
				_t = _t.getNextSibling();
				model.addExpression(e1); model.addOperator("not in"); model.addExpression(e2);
				break;
			}
			case 66:
			{
				AST __t223 = _t;
				ct2 = _t==ASTNULL ? null :(AST)_t;
				match(_t,66);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				e2=exp_set(_t);
				_t = _retTree;
				_t = __t223;
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
				AST __t230 = _t;
				AST tmp41_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				a1=aggregate_expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				a2=aggregate_expression(_t);
				_t = _retTree;
				_t = __t230;
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
				if ((_tokenSet_5.member(_t.getType()))) {
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
				AST __t232 = _t;
				AST tmp42_AST_in = (AST)_t;
				match(_t,LITERAL_asc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t232;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case 53:
			{
				AST __t233 = _t;
				AST tmp43_AST_in = (AST)_t;
				match(_t,53);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t233;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.ASC);
				break;
			}
			case LITERAL_desc:
			{
				AST __t234 = _t;
				AST tmp44_AST_in = (AST)_t;
				match(_t,LITERAL_desc);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t234;
				_t = _t.getNextSibling();
				model.addChild(o); model.setSort(OrderExpressionModel.DESC);
				break;
			}
			case 54:
			{
				AST __t235 = _t;
				AST tmp45_AST_in = (AST)_t;
				match(_t,54);
				_t = _t.getFirstChild();
				o=order_expression(_t);
				_t = _retTree;
				_t = __t235;
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
				else if ((_tokenSet_5.member(_t.getType()))) {
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
				AST __t239 = _t;
				AST tmp46_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getFirstChild();
				e1=expression(_t);
				_t = _retTree;
				op = _t==ASTNULL ? null : (AST)_t;
				two_arg_op(_t);
				_t = _retTree;
				e2=expression(_t);
				_t = _retTree;
				_t = __t239;
				_t = _t.getNextSibling();
				model.addChild(e1); model.addOperator(op.getText()); model.addChild(e2);
				break;
			}
			case ONE_ARG_OP:
			{
				AST __t240 = _t;
				AST tmp47_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getFirstChild();
				op1 = _t==ASTNULL ? null : (AST)_t;
				one_arg_op(_t);
				_t = _retTree;
				e1=expression(_t);
				_t = _retTree;
				_t = __t240;
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
				AST tmp48_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 50:
			{
				AST tmp49_AST_in = (AST)_t;
				match(_t,50);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_like:
			{
				AST tmp50_AST_in = (AST)_t;
				match(_t,LITERAL_like);
				_t = _t.getNextSibling();
				break;
			}
			case 231:
			{
				AST tmp51_AST_in = (AST)_t;
				match(_t,231);
				_t = _t.getNextSibling();
				break;
			}
			case 232:
			{
				AST tmp52_AST_in = (AST)_t;
				match(_t,232);
				_t = _t.getNextSibling();
				break;
			}
			case 233:
			{
				AST tmp53_AST_in = (AST)_t;
				match(_t,233);
				_t = _t.getNextSibling();
				break;
			}
			case 234:
			{
				AST tmp54_AST_in = (AST)_t;
				match(_t,234);
				_t = _t.getNextSibling();
				break;
			}
			case 235:
			{
				AST tmp55_AST_in = (AST)_t;
				match(_t,235);
				_t = _t.getNextSibling();
				break;
			}
			case 236:
			{
				AST tmp56_AST_in = (AST)_t;
				match(_t,236);
				_t = _t.getNextSibling();
				break;
			}
			case 237:
			{
				AST tmp57_AST_in = (AST)_t;
				match(_t,237);
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
			AST __t225 = _t;
			AST tmp58_AST_in = (AST)_t;
			match(_t,SUBCONTAIN_OP);
			_t = _t.getFirstChild();
			AST tmp59_AST_in = (AST)_t;
			match(_t,LPAREN);
			_t = _t.getNextSibling();
			expr=constexpset(_t);
			_t = _retTree;
			AST tmp60_AST_in = (AST)_t;
			match(_t,RPAREN);
			_t = _t.getNextSibling();
			_t = __t225;
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
				AST __t227 = _t;
				AST tmp61_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				cep1=constexpset(_t);
				_t = _retTree;
				cep2=constexpset(_t);
				_t = _retTree;
				_t = __t227;
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
				AST tmp62_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case STAR:
			{
				AST tmp63_AST_in = (AST)_t;
				match(_t,STAR);
				_t = _t.getNextSibling();
				break;
			}
			case MINUS:
			{
				AST tmp64_AST_in = (AST)_t;
				match(_t,MINUS);
				_t = _t.getNextSibling();
				break;
			}
			case 222:
			{
				AST tmp65_AST_in = (AST)_t;
				match(_t,222);
				_t = _t.getNextSibling();
				break;
			}
			case 223:
			{
				AST tmp66_AST_in = (AST)_t;
				match(_t,223);
				_t = _t.getNextSibling();
				break;
			}
			case 224:
			{
				AST tmp67_AST_in = (AST)_t;
				match(_t,224);
				_t = _t.getNextSibling();
				break;
			}
			case 225:
			{
				AST tmp68_AST_in = (AST)_t;
				match(_t,225);
				_t = _t.getNextSibling();
				break;
			}
			case 226:
			{
				AST tmp69_AST_in = (AST)_t;
				match(_t,226);
				_t = _t.getNextSibling();
				break;
			}
			case 227:
			{
				AST tmp70_AST_in = (AST)_t;
				match(_t,227);
				_t = _t.getNextSibling();
				break;
			}
			case 228:
			{
				AST tmp71_AST_in = (AST)_t;
				match(_t,228);
				_t = _t.getNextSibling();
				break;
			}
			case 112:
			{
				AST tmp72_AST_in = (AST)_t;
				match(_t,112);
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
				AST __t243 = _t;
				AST tmp73_AST_in = (AST)_t;
				match(_t,POINT);
				_t = _t.getFirstChild();
				t = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				f1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t243;
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
			case 74:
			{
				AST __t245 = _t;
				all = _t==ASTNULL ? null :(AST)_t;
				match(_t,74);
				_t = _t.getFirstChild();
				af11 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t245;
				_t = _t.getNextSibling();
				model=new FunctionModel(af11.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case LITERAL_all:
			{
				AST __t246 = _t;
				AST tmp74_AST_in = (AST)_t;
				match(_t,LITERAL_all);
				_t = _t.getFirstChild();
				af12 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t246;
				_t = _t.getNextSibling();
				model=new FunctionModel(af12.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);
				break;
			}
			case 28:
			{
				AST __t247 = _t;
				dist = _t==ASTNULL ? null :(AST)_t;
				match(_t,28);
				_t = _t.getFirstChild();
				af21 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t247;
				_t = _t.getNextSibling();
				model=new FunctionModel(af21.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);
				break;
			}
			case LITERAL_distinct:
			{
				AST __t248 = _t;
				AST tmp75_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getFirstChild();
				af22 = _t==ASTNULL ? null : (AST)_t;
				function_name(_t);
				_t = _retTree;
				p=parameters(_t);
				_t = _retTree;
				_t = __t248;
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
			AST tmp76_AST_in = (AST)_t;
			match(_t,ONE_ARG_OP);
			_t = _t.getNextSibling();
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
			case LITERAL_sum:
			case 76:
			case LITERAL_avg:
			case 78:
			case LITERAL_max:
			case 80:
			case LITERAL_min:
			case 82:
			case LITERAL_count:
			case 84:
			{
				aggregate_func_name(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_abs:
			case 86:
			case LITERAL_acos:
			case 88:
			case LITERAL_asin:
			case 90:
			case LITERAL_atan:
			case 92:
			case 93:
			case 94:
			case LITERAL_ceiling:
			case 96:
			case LITERAL_cos:
			case 98:
			case LITERAL_cot:
			case 100:
			case LITERAL_degrees:
			case 102:
			case LITERAL_exp:
			case 104:
			case LITERAL_floor:
			case 106:
			case LITERAL_log:
			case 108:
			case 109:
			case 110:
			case LITERAL_mod:
			case 112:
			case LITERAL_pi:
			case 114:
			case LITERAL_power:
			case 116:
			case LITERAL_radians:
			case 118:
			case LITERAL_rand:
			case 120:
			case LITERAL_round:
			case 122:
			case LITERAL_sign:
			case 124:
			case LITERAL_sin:
			case 126:
			case LITERAL_sqrt:
			case 128:
			case LITERAL_tan:
			case 130:
			{
				number_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_left:
			case LITERAL_ascii:
			case 132:
			case LITERAL_char:
			case 134:
			case LITERAL_char_length:
			case 136:
			case LITERAL_charindex:
			case 138:
			case LITERAL_difference:
			case 140:
			case LITERAL_lcase:
			case 142:
			case LITERAL_length:
			case 144:
			case LITERAL_lower:
			case 146:
			case LITERAL_ltrim:
			case 148:
			case LITERAL_patindex:
			case 150:
			case LITERAL_replace:
			case 152:
			case LITERAL_right:
			case LITERAL_rtrim:
			case 155:
			case LITERAL_str:
			case 157:
			case LITERAL_substring:
			case 159:
			case LITERAL_upper:
			case 161:
			{
				string_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_dateformat:
			case 163:
			case LITERAL_datename:
			case 165:
			case LITERAL_datepart:
			case 167:
			case LITERAL_datetime:
			case 169:
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
			case 183:
			case LITERAL_quarter:
			case LITERAL_seconds:
			case LITERAL_second:
			case LITERAL_today:
			case 188:
			case LITERAL_weeks:
			case LITERAL_week:
			case LITERAL_years:
			case LITERAL_year:
			case LITERAL_getdate:
			case 194:
			case LITERAL_dateadd:
			case 196:
			case LITERAL_datediff:
			case 198:
			{
				datetime_function(_t);
				_t = _retTree;
				break;
			}
			case LITERAL_convert:
			case 200:
			case LITERAL_hextoint:
			case 202:
			case LITERAL_inttohex:
			case 204:
			case LITERAL_isdate:
			case 206:
			case LITERAL_isnumeric:
			case 208:
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
				AST __t250 = _t;
				AST tmp77_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				p1=parameters(_t);
				_t = _retTree;
				p2=parameters(_t);
				_t = _retTree;
				_t = __t250;
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
			case 28:
			{
				AST tmp78_AST_in = (AST)_t;
				match(_t,28);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_distinct:
			{
				AST tmp79_AST_in = (AST)_t;
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
				AST tmp80_AST_in = (AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_or:
			{
				AST tmp81_AST_in = (AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getNextSibling();
				break;
			}
			case 43:
			{
				AST tmp82_AST_in = (AST)_t;
				match(_t,43);
				_t = _t.getNextSibling();
				break;
			}
			case 44:
			{
				AST tmp83_AST_in = (AST)_t;
				match(_t,44);
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
	
	public final void contain_op(AST _t) throws RecognitionException {
		
		AST contain_op_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case 65:
			{
				AST tmp84_AST_in = (AST)_t;
				match(_t,65);
				_t = _t.getNextSibling();
				break;
			}
			case 66:
			{
				AST tmp85_AST_in = (AST)_t;
				match(_t,66);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_in:
			{
				AST tmp86_AST_in = (AST)_t;
				match(_t,LITERAL_in);
				_t = _t.getNextSibling();
				break;
			}
			case 63:
			{
				AST tmp87_AST_in = (AST)_t;
				match(_t,63);
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
				AST tmp88_AST_in = (AST)_t;
				match(_t,LITERAL_sum);
				_t = _t.getNextSibling();
				break;
			}
			case 76:
			{
				AST tmp89_AST_in = (AST)_t;
				match(_t,76);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_avg:
			{
				AST tmp90_AST_in = (AST)_t;
				match(_t,LITERAL_avg);
				_t = _t.getNextSibling();
				break;
			}
			case 78:
			{
				AST tmp91_AST_in = (AST)_t;
				match(_t,78);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_max:
			{
				AST tmp92_AST_in = (AST)_t;
				match(_t,LITERAL_max);
				_t = _t.getNextSibling();
				break;
			}
			case 80:
			{
				AST tmp93_AST_in = (AST)_t;
				match(_t,80);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_min:
			{
				AST tmp94_AST_in = (AST)_t;
				match(_t,LITERAL_min);
				_t = _t.getNextSibling();
				break;
			}
			case 82:
			{
				AST tmp95_AST_in = (AST)_t;
				match(_t,82);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_count:
			{
				AST tmp96_AST_in = (AST)_t;
				match(_t,LITERAL_count);
				_t = _t.getNextSibling();
				break;
			}
			case 84:
			{
				AST tmp97_AST_in = (AST)_t;
				match(_t,84);
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
				AST tmp98_AST_in = (AST)_t;
				match(_t,LITERAL_abs);
				_t = _t.getNextSibling();
				break;
			}
			case 86:
			{
				AST tmp99_AST_in = (AST)_t;
				match(_t,86);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_acos:
			{
				AST tmp100_AST_in = (AST)_t;
				match(_t,LITERAL_acos);
				_t = _t.getNextSibling();
				break;
			}
			case 88:
			{
				AST tmp101_AST_in = (AST)_t;
				match(_t,88);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_asin:
			{
				AST tmp102_AST_in = (AST)_t;
				match(_t,LITERAL_asin);
				_t = _t.getNextSibling();
				break;
			}
			case 90:
			{
				AST tmp103_AST_in = (AST)_t;
				match(_t,90);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_atan:
			{
				AST tmp104_AST_in = (AST)_t;
				match(_t,LITERAL_atan);
				_t = _t.getNextSibling();
				break;
			}
			case 92:
			{
				AST tmp105_AST_in = (AST)_t;
				match(_t,92);
				_t = _t.getNextSibling();
				break;
			}
			case 93:
			{
				AST tmp106_AST_in = (AST)_t;
				match(_t,93);
				_t = _t.getNextSibling();
				break;
			}
			case 94:
			{
				AST tmp107_AST_in = (AST)_t;
				match(_t,94);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ceiling:
			{
				AST tmp108_AST_in = (AST)_t;
				match(_t,LITERAL_ceiling);
				_t = _t.getNextSibling();
				break;
			}
			case 96:
			{
				AST tmp109_AST_in = (AST)_t;
				match(_t,96);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cos:
			{
				AST tmp110_AST_in = (AST)_t;
				match(_t,LITERAL_cos);
				_t = _t.getNextSibling();
				break;
			}
			case 98:
			{
				AST tmp111_AST_in = (AST)_t;
				match(_t,98);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_cot:
			{
				AST tmp112_AST_in = (AST)_t;
				match(_t,LITERAL_cot);
				_t = _t.getNextSibling();
				break;
			}
			case 100:
			{
				AST tmp113_AST_in = (AST)_t;
				match(_t,100);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_degrees:
			{
				AST tmp114_AST_in = (AST)_t;
				match(_t,LITERAL_degrees);
				_t = _t.getNextSibling();
				break;
			}
			case 102:
			{
				AST tmp115_AST_in = (AST)_t;
				match(_t,102);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_exp:
			{
				AST tmp116_AST_in = (AST)_t;
				match(_t,LITERAL_exp);
				_t = _t.getNextSibling();
				break;
			}
			case 104:
			{
				AST tmp117_AST_in = (AST)_t;
				match(_t,104);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_floor:
			{
				AST tmp118_AST_in = (AST)_t;
				match(_t,LITERAL_floor);
				_t = _t.getNextSibling();
				break;
			}
			case 106:
			{
				AST tmp119_AST_in = (AST)_t;
				match(_t,106);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_log:
			{
				AST tmp120_AST_in = (AST)_t;
				match(_t,LITERAL_log);
				_t = _t.getNextSibling();
				break;
			}
			case 108:
			{
				AST tmp121_AST_in = (AST)_t;
				match(_t,108);
				_t = _t.getNextSibling();
				break;
			}
			case 109:
			{
				AST tmp122_AST_in = (AST)_t;
				match(_t,109);
				_t = _t.getNextSibling();
				break;
			}
			case 110:
			{
				AST tmp123_AST_in = (AST)_t;
				match(_t,110);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_mod:
			{
				AST tmp124_AST_in = (AST)_t;
				match(_t,LITERAL_mod);
				_t = _t.getNextSibling();
				break;
			}
			case 112:
			{
				AST tmp125_AST_in = (AST)_t;
				match(_t,112);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_pi:
			{
				AST tmp126_AST_in = (AST)_t;
				match(_t,LITERAL_pi);
				_t = _t.getNextSibling();
				break;
			}
			case 114:
			{
				AST tmp127_AST_in = (AST)_t;
				match(_t,114);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_power:
			{
				AST tmp128_AST_in = (AST)_t;
				match(_t,LITERAL_power);
				_t = _t.getNextSibling();
				break;
			}
			case 116:
			{
				AST tmp129_AST_in = (AST)_t;
				match(_t,116);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_radians:
			{
				AST tmp130_AST_in = (AST)_t;
				match(_t,LITERAL_radians);
				_t = _t.getNextSibling();
				break;
			}
			case 118:
			{
				AST tmp131_AST_in = (AST)_t;
				match(_t,118);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rand:
			{
				AST tmp132_AST_in = (AST)_t;
				match(_t,LITERAL_rand);
				_t = _t.getNextSibling();
				break;
			}
			case 120:
			{
				AST tmp133_AST_in = (AST)_t;
				match(_t,120);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_round:
			{
				AST tmp134_AST_in = (AST)_t;
				match(_t,LITERAL_round);
				_t = _t.getNextSibling();
				break;
			}
			case 122:
			{
				AST tmp135_AST_in = (AST)_t;
				match(_t,122);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sign:
			{
				AST tmp136_AST_in = (AST)_t;
				match(_t,LITERAL_sign);
				_t = _t.getNextSibling();
				break;
			}
			case 124:
			{
				AST tmp137_AST_in = (AST)_t;
				match(_t,124);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sin:
			{
				AST tmp138_AST_in = (AST)_t;
				match(_t,LITERAL_sin);
				_t = _t.getNextSibling();
				break;
			}
			case 126:
			{
				AST tmp139_AST_in = (AST)_t;
				match(_t,126);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_sqrt:
			{
				AST tmp140_AST_in = (AST)_t;
				match(_t,LITERAL_sqrt);
				_t = _t.getNextSibling();
				break;
			}
			case 128:
			{
				AST tmp141_AST_in = (AST)_t;
				match(_t,128);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_tan:
			{
				AST tmp142_AST_in = (AST)_t;
				match(_t,LITERAL_tan);
				_t = _t.getNextSibling();
				break;
			}
			case 130:
			{
				AST tmp143_AST_in = (AST)_t;
				match(_t,130);
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
				AST tmp144_AST_in = (AST)_t;
				match(_t,LITERAL_ascii);
				_t = _t.getNextSibling();
				break;
			}
			case 132:
			{
				AST tmp145_AST_in = (AST)_t;
				match(_t,132);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char:
			{
				AST tmp146_AST_in = (AST)_t;
				match(_t,LITERAL_char);
				_t = _t.getNextSibling();
				break;
			}
			case 134:
			{
				AST tmp147_AST_in = (AST)_t;
				match(_t,134);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_char_length:
			{
				AST tmp148_AST_in = (AST)_t;
				match(_t,LITERAL_char_length);
				_t = _t.getNextSibling();
				break;
			}
			case 136:
			{
				AST tmp149_AST_in = (AST)_t;
				match(_t,136);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_charindex:
			{
				AST tmp150_AST_in = (AST)_t;
				match(_t,LITERAL_charindex);
				_t = _t.getNextSibling();
				break;
			}
			case 138:
			{
				AST tmp151_AST_in = (AST)_t;
				match(_t,138);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_difference:
			{
				AST tmp152_AST_in = (AST)_t;
				match(_t,LITERAL_difference);
				_t = _t.getNextSibling();
				break;
			}
			case 140:
			{
				AST tmp153_AST_in = (AST)_t;
				match(_t,140);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lcase:
			{
				AST tmp154_AST_in = (AST)_t;
				match(_t,LITERAL_lcase);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_left:
			{
				AST tmp155_AST_in = (AST)_t;
				match(_t,LITERAL_left);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_length:
			{
				AST tmp156_AST_in = (AST)_t;
				match(_t,LITERAL_length);
				_t = _t.getNextSibling();
				break;
			}
			case 144:
			{
				AST tmp157_AST_in = (AST)_t;
				match(_t,144);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_lower:
			{
				AST tmp158_AST_in = (AST)_t;
				match(_t,LITERAL_lower);
				_t = _t.getNextSibling();
				break;
			}
			case 146:
			{
				AST tmp159_AST_in = (AST)_t;
				match(_t,146);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_ltrim:
			{
				AST tmp160_AST_in = (AST)_t;
				match(_t,LITERAL_ltrim);
				_t = _t.getNextSibling();
				break;
			}
			case 148:
			{
				AST tmp161_AST_in = (AST)_t;
				match(_t,148);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_patindex:
			{
				AST tmp162_AST_in = (AST)_t;
				match(_t,LITERAL_patindex);
				_t = _t.getNextSibling();
				break;
			}
			case 150:
			{
				AST tmp163_AST_in = (AST)_t;
				match(_t,150);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_replace:
			{
				AST tmp164_AST_in = (AST)_t;
				match(_t,LITERAL_replace);
				_t = _t.getNextSibling();
				break;
			}
			case 152:
			{
				AST tmp165_AST_in = (AST)_t;
				match(_t,152);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_right:
			{
				AST tmp166_AST_in = (AST)_t;
				match(_t,LITERAL_right);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_rtrim:
			{
				AST tmp167_AST_in = (AST)_t;
				match(_t,LITERAL_rtrim);
				_t = _t.getNextSibling();
				break;
			}
			case 155:
			{
				AST tmp168_AST_in = (AST)_t;
				match(_t,155);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_str:
			{
				AST tmp169_AST_in = (AST)_t;
				match(_t,LITERAL_str);
				_t = _t.getNextSibling();
				break;
			}
			case 157:
			{
				AST tmp170_AST_in = (AST)_t;
				match(_t,157);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_substring:
			{
				AST tmp171_AST_in = (AST)_t;
				match(_t,LITERAL_substring);
				_t = _t.getNextSibling();
				break;
			}
			case 159:
			{
				AST tmp172_AST_in = (AST)_t;
				match(_t,159);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_upper:
			{
				AST tmp173_AST_in = (AST)_t;
				match(_t,LITERAL_upper);
				_t = _t.getNextSibling();
				break;
			}
			case 161:
			{
				AST tmp174_AST_in = (AST)_t;
				match(_t,161);
				_t = _t.getNextSibling();
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==142)) {
					AST tmp175_AST_in = (AST)_t;
					match(_t,142);
					_t = _t.getNextSibling();
				}
				else if ((_t.getType()==142)) {
					AST tmp176_AST_in = (AST)_t;
					match(_t,142);
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
				AST tmp177_AST_in = (AST)_t;
				match(_t,LITERAL_dateformat);
				_t = _t.getNextSibling();
				break;
			}
			case 163:
			{
				AST tmp178_AST_in = (AST)_t;
				match(_t,163);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datename:
			{
				AST tmp179_AST_in = (AST)_t;
				match(_t,LITERAL_datename);
				_t = _t.getNextSibling();
				break;
			}
			case 165:
			{
				AST tmp180_AST_in = (AST)_t;
				match(_t,165);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datepart:
			{
				AST tmp181_AST_in = (AST)_t;
				match(_t,LITERAL_datepart);
				_t = _t.getNextSibling();
				break;
			}
			case 167:
			{
				AST tmp182_AST_in = (AST)_t;
				match(_t,167);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datetime:
			{
				AST tmp183_AST_in = (AST)_t;
				match(_t,LITERAL_datetime);
				_t = _t.getNextSibling();
				break;
			}
			case 169:
			{
				AST tmp184_AST_in = (AST)_t;
				match(_t,169);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_date:
			{
				AST tmp185_AST_in = (AST)_t;
				match(_t,LITERAL_date);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dayname:
			{
				AST tmp186_AST_in = (AST)_t;
				match(_t,LITERAL_dayname);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_days:
			{
				AST tmp187_AST_in = (AST)_t;
				match(_t,LITERAL_days);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_day:
			{
				AST tmp188_AST_in = (AST)_t;
				match(_t,LITERAL_day);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dow:
			{
				AST tmp189_AST_in = (AST)_t;
				match(_t,LITERAL_dow);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hours:
			{
				AST tmp190_AST_in = (AST)_t;
				match(_t,LITERAL_hours);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hour:
			{
				AST tmp191_AST_in = (AST)_t;
				match(_t,LITERAL_hour);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minutes:
			{
				AST tmp192_AST_in = (AST)_t;
				match(_t,LITERAL_minutes);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_minute:
			{
				AST tmp193_AST_in = (AST)_t;
				match(_t,LITERAL_minute);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_monthname:
			{
				AST tmp194_AST_in = (AST)_t;
				match(_t,LITERAL_monthname);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_months:
			{
				AST tmp195_AST_in = (AST)_t;
				match(_t,LITERAL_months);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_month:
			{
				AST tmp196_AST_in = (AST)_t;
				match(_t,LITERAL_month);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_now:
			{
				AST tmp197_AST_in = (AST)_t;
				match(_t,LITERAL_now);
				_t = _t.getNextSibling();
				break;
			}
			case 183:
			{
				AST tmp198_AST_in = (AST)_t;
				match(_t,183);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_quarter:
			{
				AST tmp199_AST_in = (AST)_t;
				match(_t,LITERAL_quarter);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_seconds:
			{
				AST tmp200_AST_in = (AST)_t;
				match(_t,LITERAL_seconds);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_second:
			{
				AST tmp201_AST_in = (AST)_t;
				match(_t,LITERAL_second);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_today:
			{
				AST tmp202_AST_in = (AST)_t;
				match(_t,LITERAL_today);
				_t = _t.getNextSibling();
				break;
			}
			case 188:
			{
				AST tmp203_AST_in = (AST)_t;
				match(_t,188);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_weeks:
			{
				AST tmp204_AST_in = (AST)_t;
				match(_t,LITERAL_weeks);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_week:
			{
				AST tmp205_AST_in = (AST)_t;
				match(_t,LITERAL_week);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_years:
			{
				AST tmp206_AST_in = (AST)_t;
				match(_t,LITERAL_years);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_year:
			{
				AST tmp207_AST_in = (AST)_t;
				match(_t,LITERAL_year);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_getdate:
			{
				AST tmp208_AST_in = (AST)_t;
				match(_t,LITERAL_getdate);
				_t = _t.getNextSibling();
				break;
			}
			case 194:
			{
				AST tmp209_AST_in = (AST)_t;
				match(_t,194);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dateadd:
			{
				AST tmp210_AST_in = (AST)_t;
				match(_t,LITERAL_dateadd);
				_t = _t.getNextSibling();
				break;
			}
			case 196:
			{
				AST tmp211_AST_in = (AST)_t;
				match(_t,196);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_datediff:
			{
				AST tmp212_AST_in = (AST)_t;
				match(_t,LITERAL_datediff);
				_t = _t.getNextSibling();
				break;
			}
			case 198:
			{
				AST tmp213_AST_in = (AST)_t;
				match(_t,198);
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
			case LITERAL_convert:
			{
				AST tmp214_AST_in = (AST)_t;
				match(_t,LITERAL_convert);
				_t = _t.getNextSibling();
				break;
			}
			case 200:
			{
				AST tmp215_AST_in = (AST)_t;
				match(_t,200);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_hextoint:
			{
				AST tmp216_AST_in = (AST)_t;
				match(_t,LITERAL_hextoint);
				_t = _t.getNextSibling();
				break;
			}
			case 202:
			{
				AST tmp217_AST_in = (AST)_t;
				match(_t,202);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_inttohex:
			{
				AST tmp218_AST_in = (AST)_t;
				match(_t,LITERAL_inttohex);
				_t = _t.getNextSibling();
				break;
			}
			case 204:
			{
				AST tmp219_AST_in = (AST)_t;
				match(_t,204);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isdate:
			{
				AST tmp220_AST_in = (AST)_t;
				match(_t,LITERAL_isdate);
				_t = _t.getNextSibling();
				break;
			}
			case 206:
			{
				AST tmp221_AST_in = (AST)_t;
				match(_t,206);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_isnumeric:
			{
				AST tmp222_AST_in = (AST)_t;
				match(_t,LITERAL_isnumeric);
				_t = _t.getNextSibling();
				break;
			}
			case 208:
			{
				AST tmp223_AST_in = (AST)_t;
				match(_t,208);
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
				AST tmp224_AST_in = (AST)_t;
				match(_t,LITERAL_suser_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_suser_name:
			{
				AST tmp225_AST_in = (AST)_t;
				match(_t,LITERAL_suser_name);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_id:
			{
				AST tmp226_AST_in = (AST)_t;
				match(_t,LITERAL_user_id);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_user_name:
			{
				AST tmp227_AST_in = (AST)_t;
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
				AST tmp228_AST_in = (AST)_t;
				match(_t,LITERAL_decode);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_dump:
			{
				AST tmp229_AST_in = (AST)_t;
				match(_t,LITERAL_dump);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_greatest:
			{
				AST tmp230_AST_in = (AST)_t;
				match(_t,LITERAL_greatest);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_least:
			{
				AST tmp231_AST_in = (AST)_t;
				match(_t,LITERAL_least);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_nvl:
			{
				AST tmp232_AST_in = (AST)_t;
				match(_t,LITERAL_nvl);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_vsize:
			{
				AST tmp233_AST_in = (AST)_t;
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
		"SUBQUERY",
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"LOGIC_OP",
		"CONTAIN_OP",
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
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"\"left\"",
		"\"join\"",
		"\"\\u5de6\\u8fde\\u63a5\"",
		"\"group\"",
		"\"by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order\"",
		"\"\\u6392\\u5e8f\"",
		"\"not\"",
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
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"not in\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"PARAM_ID",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
		"NEGATIVE_DIGIT_ELEMENT",
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
		"\"count\"",
		"\"\\u6c42\\u8bb0\\u5f55\\u6570\"",
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
		"\"\\u6c42\\u6a21\"",
		"\"pi\"",
		"\"\\u6c42PI\"",
		"\"power\"",
		"\"\\u6c42\\u6570\\u5b57\\u7684\\u6b21\\u5e42\\u503c\"",
		"\"radians\"",
		"\"\\u6c42\\u5ea6\\u6570\\u89d2\\u7684\\u5f27\\u5ea6\"",
		"\"rand\"",
		"\"\\u6c420\\u548c1\\u95f4\\u7684\\u968f\\u673a\\u6570\"",
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
		"\"ascii\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u4e2a\\u5b57\\u7b26\\u7684ASCII\\u7801\"",
		"\"char\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u5dee\\u503c\"",
		"\"lcase\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5de6\\u622a\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u603b\\u957f\\u5ea6\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"patindex\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u6b21\\u51fa\\u73b0\\u4f4d\\u7f6e\"",
		"\"replace\"",
		"\"\\u5b57\\u7b26\\u4e32\\u66ff\\u6362\"",
		"\"right\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
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
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u76f8\\u52a0\"",
		"\"datediff\"",
		"\"\\u65e5\\u671f\\u76f8\\u51cf\"",
		"\"convert\"",
		"\"\\u5b57\\u7b26\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u662f\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u662f\\u6570\\u503c\\u578b\"",
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
		"COMPARE_OP",
		"\"like\"",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"not exists\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"exists\"",
		"\"\\u5b58\\u5728\"",
		"NOT_EXIST",
		"EXIST",
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
		long[] data = new long[8];
		data[0]=35186922233856L;
		data[1]=-8L;
		data[2]=-1L;
		data[3]=536870911L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=-288229826395897856L;
		data[1]=7L;
		data[3]=137438953472L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=457399387300096L;
		data[1]=-8L;
		data[2]=-1L;
		data[3]=536870911L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=2550136832L;
		data[1]=-432L;
		data[2]=-1L;
		data[3]=402653183L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=135107991371251712L;
		data[1]=-400L;
		data[2]=-1L;
		data[3]=134217727L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[8];
		data[0]=2550136832L;
		data[1]=-512L;
		data[2]=-1L;
		data[3]=134217727L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[8];
		data[0]=2147483648L;
		data[1]=-2048L;
		data[2]=-1L;
		data[3]=134217727L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	}
	
