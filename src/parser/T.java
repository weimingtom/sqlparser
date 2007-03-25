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
	
	Map selectListMap = new HashMap();
    Map fromListMap = new HashMap();
    Map whereListMap = new HashMap();
    Map groupByListMap = new HashMap();
    Map orderByListMap = new HashMap();
    
	Map tables = new HashMap();
	Map fieldAliasMap = new HashMap();
	Map segment = new HashMap();
	
	int whereIntKey = 0;
	
	//Get DbTable Model (Remove the alias table Object)
	public DbTable[] getTables() {
		int i=0;
		List removeKeyLi = new ArrayList();
    
	    Iterator it = tables.values().iterator();
	    while (it.hasNext()){
	      DbTable _tDbTable = (DbTable)it.next();
	      if (tables.keySet().contains(_tDbTable.getAlias())){
	        if (!removeKeyLi.contains(_tDbTable.getAlias())){
	          removeKeyLi.add(_tDbTable.getAlias());
	        }
	      }
	    }
	    
	    for (int m = 0; m < removeKeyLi.size(); m++){
	      tables.remove((Object) removeKeyLi.get(m));
	    }
	    
	    DbTable[] ret=new DbTable[tables.size()];
	    Iterator _rit = tables.values().iterator();
	    while (_rit.hasNext()){
	      ret[i++] = (DbTable)_rit.next();
	    }
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
	
	private DbTable addFromTableByChName(String chName) {
		DbTable table=addTableByChName(chName);
		table.setExistInFromClause(true);
		return table;
	}
	
	//Add DbTable Object By tableCnName And tableAlias
	private DbTable addTableByChNameAndTableAlias(String chName, String tableAlias) {
		DbTable table=(DbTable) tables.get(chName);
		if (table==null) {
			table=new DbTable();
			table.setChName(chName);
			table.setAlias(tableAlias);
			tables.put(chName, table);
		}else{
			table.setAlias(tableAlias);
			tables.put(chName, table);
		}
		return table;
	}
	
	//Add DbTable Object By tableCnName And tableAlias
	private DbTable addFromTableByChName(String chName, String tableAlias) {
		DbTable table=addTableByChNameAndTableAlias(chName, tableAlias);
		table.setExistInFromClause(true);
		return table;
	}
	
	//================= Column Fields EquElement AS FieldAlias =================//
	//Add FieldAlias Object By CnFieldAliasName
	private DbFieldAlias addFieldAliasByChAliasName(String columnEquElem, String chAliasName){
		DbFieldAlias _dbFieldAlias = (DbFieldAlias) fieldAliasMap.get(chAliasName);
		if (_dbFieldAlias == null){
			_dbFieldAlias = new DbFieldAlias();
			_dbFieldAlias.setCnFieldAlias(chAliasName);
			_dbFieldAlias.setEnFieldAlias(chAliasName);
			_dbFieldAlias.setColumnEquElem(columnEquElem);
			fieldAliasMap.put(chAliasName, _dbFieldAlias);
		}
		return _dbFieldAlias;
	}
	
	//Get ALL FieldAlias Object Array
	public DbFieldAlias[] getDbFieldAlias() {
		int i = 0;
		DbFieldAlias[] _rDbFieldAlias = new DbFieldAlias[fieldAliasMap.size()];
		for (Iterator it = fieldAliasMap.values().iterator(); it.hasNext();){
			_rDbFieldAlias[i++] = (DbFieldAlias) it.next();
		}
		return _rDbFieldAlias;
	}
	
	/**=====================================================================//
	//															  			//
	//				  		Get SQL Every Step EquElement				  	//
	//															  			//
	//======================================================================*/
	
	public Map getSelectListMap() {
	    return selectListMap;
	}
	
	public Map getFromListMap() {
		return fromListMap;
	}
	
	public Map getWhereListMap() {
	    return whereListMap;
	}
	
	public Map getGroupByListMap() {
	    return groupByListMap;
	}
	
	public Map getOrderByListMap() {
	    return orderByListMap;
	}
	
	//Add SelectListVO to selectListMap
	private SelectListVO addSelectListVO(String columnEquElem, String chAliasName){
		int intMapKey = selectListMap.size() + 1;
		SelectListVO _selectListVO = new SelectListVO();
		_selectListVO.setCnColumnEquElem(columnEquElem);
		_selectListVO.setCnFieldAlias(chAliasName);
		selectListMap.put("SQL_SELECT_" + String.valueOf(intMapKey), _selectListVO);
		return _selectListVO;
	}
	
	//Get ALL FieldEquElem Object Array from selectListMap
	public SelectListVO[] getSelectListVOArr() {
		int i = 0;
		SelectListVO[] _selectListVOArr = new SelectListVO[selectListMap.size()];
		for (Iterator it = selectListMap.values().iterator(); it.hasNext();){
			_selectListVOArr[i++] = (SelectListVO) it.next();
		}
		return _selectListVOArr;
	}
	
	
	//Add FromListVO to fromListMap
	private FromListVO addFromListVO(String chName, String tableAlias){
		FromListVO _fromListVO = new FromListVO();
	    _fromListVO.setCnTableName(chName);
	    _fromListVO.setCnTAbleAlias(tableAlias);
	    fromListMap.put(_fromListVO.getCnTableName(), _fromListVO);
	    return _fromListVO;
	}
	
	//Get ALL FromListVO(TableName) Object Array from fromListMap
	public FromListVO[] getFromListVOArr() {
	    int i = 0;
	    FromListVO[] _fromListVOArr = new FromListVO[fromListMap.size()];
	    for (Iterator it = fromListMap.values().iterator(); it.hasNext();){
	      _fromListVOArr[i++] = (FromListVO) it.next();
	    }
	    return _fromListVOArr;
	}
	
	//Add WhereListVO to whereListMap
	private WhereListVO addWhereListVO(String cnWhereEquElem, String comparSymbol, String cnWhereValue){
		int whereIntKey = whereListMap.size() + 1;
		WhereListVO _whereListVO = new WhereListVO();
		_whereListVO.setCnAllWhereStr(cnWhereEquElem+" "+comparSymbol+" "+cnWhereValue);
	    _whereListVO.setCnWhereEquElem(cnWhereEquElem);
	    _whereListVO.setCnComparSymbol(comparSymbol);
	    _whereListVO.setCnWhereValue(cnWhereValue);
	    whereListMap.put("SQL_WHERE_" + String.valueOf(whereIntKey), _whereListVO);
		return _whereListVO;
	}
	
	//Get ALL WhereListVO Object Array from whereListMap
	public WhereListVO[] getWhereListVOArr() {
    	int i = 0;
      	WhereListVO[] _whereListVO = new WhereListVO[whereListMap.size()];
      	for (Iterator it = whereListMap.values().iterator(); it.hasNext();){
        	_whereListVO[i++] = (WhereListVO) it.next();
      	}
      	return _whereListVO;
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
				AST __t130 = _t;
				AST tmp5_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				c1=columnList(_t);
				_t = _retTree;
				c2=columnList(_t);
				_t = _retTree;
				_t = __t130;
				_t = _t.getNextSibling();
				clist=c1+","+c2;
				break;
			}
			case AS:
			case STAR:
			case LPAREN:
			case OPERATOR:
			case FUNC_NAME:
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
				
							clist="(*)";
							addSelectListVO(clist, "");
						
				break;
			}
			case ALL:
			{
				AST tmp7_AST_in = (AST)_t;
				match(_t,ALL);
				_t = _t.getNextSibling();
				c1=columnList(_t);
				_t = _retTree;
				clist="ALL "+c1;
				break;
			}
			case DISTINCT:
			{
				AST tmp8_AST_in = (AST)_t;
				match(_t,DISTINCT);
				_t = _t.getNextSibling();
				c1=columnList(_t);
				_t = _retTree;
				clist="DISTINCT "+c1;
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
				AST __t137 = _t;
				AST tmp9_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				t1=tableList(_t);
				_t = _retTree;
				t2=tableList(_t);
				_t = _retTree;
				_t = __t137;
				_t = _t.getNextSibling();
				tlist=t1+","+t2;
				break;
			}
			case AS:
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
		String e1, e2; equStr="";int m = 0, n = 0;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case EQUATION_START:
			{
				AST __t141 = _t;
				AST tmp10_AST_in = (AST)_t;
				match(_t,EQUATION_START);
				_t = _t.getFirstChild();
				e1=equations(_t);
				_t = _retTree;
				_t = __t141;
				_t = _t.getNextSibling();
				
							equStr=e1;
						
				break;
			}
			case LOGIC_OP:
			{
				AST __t142 = _t;
				lop = _t==ASTNULL ? null :(AST)_t;
				match(_t,LOGIC_OP);
				_t = _t.getFirstChild();
				e1=equations(_t);
				_t = _retTree;
				e2=equations(_t);
				_t = _retTree;
				_t = __t142;
				_t = _t.getNextSibling();
				
							equStr=e1+" "+lop+" "+e2;
						
				break;
			}
			case COMPARATOR:
			{
				AST __t143 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,COMPARATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t143;
				_t = _t.getNextSibling();
				
							equStr=e1+" "+op.getText()+" "+e2;
							whereIntKey++;
							addWhereListVO(e1, op.getText(), e2);
						
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
		AST a = null;
		AST d = null;
		String args; c="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			if ((_t.getType()==AS)) {
				AST __t132 = _t;
				a = _t==ASTNULL ? null :(AST)_t;
				match(_t,AS);
				_t = _t.getFirstChild();
				args=equElem(_t);
				_t = _retTree;
				d = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t132;
				_t = _t.getNextSibling();
				
							c=args+" "+a.getText()+" "+d.getText();
							addFieldAliasByChAliasName(args, d.getText());
							addSelectListVO(args, d.getText());
						
			}
			else if ((_tokenSet_0.member(_t.getType()))) {
				c=equElem(_t);
				_t = _retTree;
				
							addSelectListVO(c, "");
						
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
		return c;
	}
	
	public final QueryModel  statement(AST _t) throws RecognitionException {
		QueryModel model;
		
		AST statement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String statement, clist, tlist, g, o, t1, t2, into, m, e;model=null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_UNION:
			{
				AST __t118 = _t;
				AST tmp11_AST_in = (AST)_t;
				match(_t,TABLE_UNION);
				_t = _t.getFirstChild();
				t1=tableName(_t);
				_t = _retTree;
				t2=tableName(_t);
				_t = _retTree;
				into=tableName(_t);
				_t = _retTree;
				_t = __t118;
				_t = _t.getNextSibling();
				model=new UnionModel(t1, t2, into);
				break;
			}
			case TABLE_COMPARE:
			{
				AST __t119 = _t;
				AST tmp12_AST_in = (AST)_t;
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
				_t = __t119;
				_t = _t.getNextSibling();
				model=new CompareModel(t1, t2, into, m, e);
				break;
			}
			case SELECT_STATEMENT:
			{
				AST __t120 = _t;
				AST tmp13_AST_in = (AST)_t;
				match(_t,SELECT_STATEMENT);
				_t = _t.getFirstChild();
				statement=selectStatement(_t);
				_t = _retTree;
				_t = __t120;
				_t = _t.getNextSibling();
				model=new SelectModel(
							(String)segment.get("clist"),
							(String)segment.get("tlist"),
							(String)segment.get("equations"),
							(String)segment.get("groupby"),
							(String)segment.get("orderby"),
							null);
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
		AST a = null;
		AST t1 = null;
		AST t2 = null;
		String ts; tableStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				t = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				
							tableStr="["+t.getText()+"]";
							addFromTableByChName(t.getText());
							addFromListVO(t.getText(), "");
						
				break;
			}
			case AS:
			{
				AST __t150 = _t;
				a = _t==ASTNULL ? null :(AST)_t;
				match(_t,AS);
				_t = _t.getFirstChild();
				t1 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				t2 = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t150;
				_t = _t.getNextSibling();
				
							tableStr="["+t1.getText()+"] "+a.getText()+" "+t2.getText();
							//addFromTableByChName(t1.getText());
							addFromTableByChName(t1.getText(), t2.getText());
							addFromListVO(t1.getText(), t2.getText());
						
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
				AST tmp14_AST_in = (AST)_t;
				match(_t,EXIST);
				_t = _t.getNextSibling();
				m="EXIST";
				break;
			}
			case NOT_EXIST:
			{
				AST tmp15_AST_in = (AST)_t;
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
	
	public final String  selectStatement(AST _t) throws RecognitionException {
		String statement;
		
		AST selectStatement_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String clist, tlist, e, g, o, s; statement="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TABLE_SELECT:
			{
				AST __t122 = _t;
				AST tmp16_AST_in = (AST)_t;
				match(_t,TABLE_SELECT);
				_t = _t.getFirstChild();
				clist=columnList(_t);
				_t = _retTree;
				tlist=tableList(_t);
				_t = _retTree;
				_t = __t122;
				_t = _t.getNextSibling();
				
							segment.put("clist", clist);
							segment.put("tlist", tlist);
						
				break;
			}
			case WHERE:
			{
				AST __t123 = _t;
				AST tmp17_AST_in = (AST)_t;
				match(_t,WHERE);
				_t = _t.getFirstChild();
				s=selectStatement(_t);
				_t = _retTree;
				e=equations(_t);
				_t = _retTree;
				_t = __t123;
				_t = _t.getNextSibling();
				segment.put("equations", e);
				break;
			}
			case GROUP_BY:
			{
				AST __t124 = _t;
				AST tmp18_AST_in = (AST)_t;
				match(_t,GROUP_BY);
				_t = _t.getFirstChild();
				s=selectStatement(_t);
				_t = _retTree;
				g=columnList(_t);
				_t = _retTree;
				_t = __t124;
				_t = _t.getNextSibling();
				segment.put("groupby", g);
				break;
			}
			case ORDER_BY:
			{
				AST __t125 = _t;
				AST tmp19_AST_in = (AST)_t;
				match(_t,ORDER_BY);
				_t = _t.getFirstChild();
				s=selectStatement(_t);
				_t = _retTree;
				o=orderClause(_t);
				_t = _retTree;
				_t = __t125;
				_t = _t.getNextSibling();
				segment.put("orderby", o);
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
		return statement;
	}
	
	public final String  orderClause(AST _t) throws RecognitionException {
		String clause;
		
		AST orderClause_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST a = null;
		String c; clause="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ALL_FIELDS:
			case COMMA:
			case ALL:
			case DISTINCT:
			case AS:
			case STAR:
			case LPAREN:
			case OPERATOR:
			case FUNC_NAME:
			case POINT:
			case REAL_NUM:
			case QUOTED_STRING:
			{
				clause=columnList(_t);
				_t = _retTree;
				break;
			}
			case ASC:
			{
				AST __t127 = _t;
				a = _t==ASTNULL ? null :(AST)_t;
				match(_t,ASC);
				_t = _t.getFirstChild();
				c=columnList(_t);
				_t = _retTree;
				_t = __t127;
				_t = _t.getNextSibling();
				clause=c+" "+a.getText();
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
		return clause;
	}
	
	public final String  equElem(AST _t) throws RecognitionException {
		String equElemStr;
		
		AST equElem_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST op = null;
		AST star = null;
		AST n = null;
		AST s = null;
		AST a = null;
		AST tempField = null;
		AST fn = null;
		String e1, e2, f, args; equElemStr="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPERATOR:
			{
				AST __t145 = _t;
				op = _t==ASTNULL ? null :(AST)_t;
				match(_t,OPERATOR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t145;
				_t = _t.getNextSibling();
				equElemStr=e1+op.getText()+e2;
				break;
			}
			case STAR:
			{
				AST __t146 = _t;
				star = _t==ASTNULL ? null :(AST)_t;
				match(_t,STAR);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				e2=equElem(_t);
				_t = _retTree;
				_t = __t146;
				_t = _t.getNextSibling();
				equElemStr=e1+star.getText()+e2;
				break;
			}
			case LPAREN:
			{
				AST tmp20_AST_in = (AST)_t;
				match(_t,LPAREN);
				_t = _t.getNextSibling();
				e1=equElem(_t);
				_t = _retTree;
				AST tmp21_AST_in = (AST)_t;
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
				AST __t147 = _t;
				a = _t==ASTNULL ? null :(AST)_t;
				match(_t,AS);
				_t = _t.getFirstChild();
				e1=equElem(_t);
				_t = _retTree;
				tempField = (AST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				_t = __t147;
				_t = _t.getNextSibling();
				equElemStr=e1+" "+a.getText()+" "+tempField.getText();
				break;
			}
			case FUNC_NAME:
			{
				AST __t148 = _t;
				fn = _t==ASTNULL ? null :(AST)_t;
				match(_t,FUNC_NAME);
				_t = _t.getFirstChild();
				args=funcArgs(_t);
				_t = _retTree;
				_t = __t148;
				_t = _t.getNextSibling();
				equElemStr=fn.getText()+"("+args+")";
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
				AST tmp22_AST_in = (AST)_t;
				match(_t,ALL);
				_t = _t.getNextSibling();
				a=funcArg(_t);
				_t = _retTree;
				args="all "+a;
				break;
			}
			case DISTINCT:
			{
				AST tmp23_AST_in = (AST)_t;
				match(_t,DISTINCT);
				_t = _t.getNextSibling();
				a=funcArg(_t);
				_t = _retTree;
				args="distinct "+a;
				break;
			}
			case COMMA:
			case AS:
			case STAR:
			case LPAREN:
			case OPERATOR:
			case FUNC_NAME:
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
				AST __t135 = _t;
				AST tmp24_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				f1=funcArg(_t);
				_t = _retTree;
				f2=funcArg(_t);
				_t = _retTree;
				_t = __t135;
				_t = _t.getNextSibling();
				arg=f1+","+f2;
				break;
			}
			case AS:
			case STAR:
			case LPAREN:
			case OPERATOR:
			case FUNC_NAME:
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
	
	public final String  fieldList(AST _t) throws RecognitionException {
		String fList;
		
		AST fieldList_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		String f1, f2; fList="";
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case COMMA:
			{
				AST __t139 = _t;
				AST tmp25_AST_in = (AST)_t;
				match(_t,COMMA);
				_t = _t.getFirstChild();
				f1=fieldList(_t);
				_t = _retTree;
				f2=fieldList(_t);
				_t = _retTree;
				_t = __t139;
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
	
	public final String  fieldName(AST _t) throws RecognitionException {
		String fieldStr;
		
		AST fieldName_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		AST f1 = null;
		AST f2 = null;
		fieldStr="";
		
		try {      // for error handling
			AST __t152 = _t;
			AST tmp26_AST_in = (AST)_t;
			match(_t,POINT);
			_t = _t.getFirstChild();
			f1 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			f2 = (AST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			_t = __t152;
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
		"UNION_CLAUSE",
		"ORDER_CLAUSE",
		"FIELD_NAME",
		"TABLE_SELECT",
		"COLUMN",
		"FROM",
		"WHERE",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"GROUP_BY",
		"ORDER_BY",
		"ASC",
		"UNION",
		"ALL",
		"DISTINCT",
		"AS",
		"ID",
		"STAR",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"LPAREN",
		"RPAREN",
		"COMPARATOR",
		"NAME_START",
		"NAME_END",
		"OPERATOR",
		"FUNC_NAME",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"\"null\"",
		"BETWEEN",
		"ID_START_LETTER",
		"ID_LETTER",
		"DOT_NUM",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"SEMI",
		"WS",
		"ESC"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2132619034624L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	}
	
