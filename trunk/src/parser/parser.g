header {
package parser;
}

class P extends Parser;

options {
	k=5;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {
	ALL_FIELDS;
	EQUATION_START;
	SELECT_STATEMENT;
	GROUP_CLAUSE;
	UNION_CLAUSE;
	ORDER_CLAUSE;
	FIELD_NAME;
}

segment
	:	(TABLE_SELECT columnList
	|	COLUMN column
	|	FROM tableList
	|	WHERE equations)
	EOF!
	;

statement
	:	(tableUnion
	|	tableCompare
	|	tableSelect)
	EOF!
	;

tableUnion
	:	TABLE_UNION^ tableName COMMA! tableName INTO! tableName
	;

tableCompare
	:	TABLE_COMPARE^ tableName COMMA! tableName INTO! tableName WHERE! method equations
	;

tableSelect
	:	TABLE_SELECT^ columnList FROM! tableList 
		(WHERE^ equations)?
		(GROUP_BY^ columnList)?
		(ORDER_BY^ orderClause)?
		{#tableSelect=#([SELECT_STATEMENT], #tableSelect);}
/*		(groupClause)?
		(orderClause)?
		{
			#tableSelect.addChild(astFactory.create(GROUP_CLAUSE, "G_C"));
			#tableSelect.addChild(astFactory.create(ORDER_CLAUSE, "O_C"));
		}
*/	;

selectClause
	:	TABLE_SELECT^ columnList FROM! tableList WHERE! equations 
	;

groupClause
	:	GROUP_BY columnList
	;
	
orderClause
	:	columnList (ASC^)?
	;

unionClause
	:	(UNION^ (ALL)?)+
	;
	
fieldList
	:	fieldName (COMMA^ fieldList)?
	;
	
columnList
	:	(ALL|DISTINCT)? columns
	;
	
columns
	:	column (COMMA^ column)*
	;

column
	:	equElem (AS^ ID)?
	|	(STAR)=>STAR
		{#column=#([ALL_FIELDS]);}
	|	ALL_FIELDS
	;

funcArgs
	:	equElem (COMMA^ equElem)*;

fromClauseTableList
	:	tableList
	;

tableList
	:	tableElem (COMMA^ tableElem)*
	;

method
	:	EXIST|NOT_EXIST;

equations
	:	equation (LOGIC_OP^ equations)?
		{#equations=#([EQUATION_START], #equations);}
	|	LPAREN EQUATION_START equations RPAREN (LOGIC_OP^ equations)?
	;

equation
	:	equElem COMPARATOR^ equElem
//	|	JOIN
//	|	(fieldName BETWEEN^)=>fieldName BETWEEN^ constant AND! constant
	;

tableElem
	:	tableName (AS^ ID)?
	;

tableName
	:	ID
	|	NAME_START! tableName NAME_END!
	;

equElem
	:	elem ((OPERATOR^|STAR^) equElem)?
	|	LPAREN equElem RPAREN (OPERATOR^ equElem)?
	;

elem:	fieldName 
	|	func
	|	constant
	;

func:	FUNC_NAME^ LPAREN! (ALL|DISTINCT)? funcArgs RPAREN!;

fieldName
	:	ID POINT^ ID
	|	NAME_START! fieldName NAME_END!
	;

constant
	:	REAL_NUM
	|	QUOTED_STRING
	|	"null"
	;

class L extends Lexer;

options {
	k=5;
	charVocabulary = '\u0000' .. '\uFFFE';
	testLiterals=false;
	caseSensitive = false;
	caseSensitiveLiterals = false;
	
}

TABLE_UNION
	:	"t_union";
TABLE_COMPARE
	:	"t_compare";
TABLE_SELECT
	:	"select";
INTO:	"into";
WHERE
	:	"where";
EXIST
	:	"exist";
NOT_EXIST
	:	"not exist";
FROM:	"from";
ALL :	"all";
DISTINCT
	:	"distinct";
ORDER_BY
	:	"order by";
ASC	:	"asc"|"desc";
GROUP_BY
	:	"group by";
UNION
	:	"union";

COMPARATOR
	:	"="|">"|"<"|">="|"<="|"<>"|"like";
BETWEEN
	:	"between";
OPERATOR
	:	'+'|'-'|'/';
STAR:	'*';
ALL_FIELDS
	:	"(*)";
LOGIC_OP
	:	"and"|"or";
AS	:	"as";

///////////////////////////////////////////////////////
// function name list
FUNC_NAME
	:	"sqrt"
	|	"getdate"
	|	"avg"
	|	"max"
	|	"min"
	|	"abs"
	|	"round"
	|	"sum"
	|	"right"
	|	"ltrim"
	|	"rtrim"
	|	"substring"
	|	"char_length"
	|	"floor"
	|	"count"
	|	"lower"
	|	"ceiling"
	|	"charindex"
	|	"str"
	;

COLUMN
	:	"column";

/////////////////////////////////////////////////////
// general symbol
ID	:	ID_START_LETTER ( ID_LETTER )*
	;

protected
ID_START_LETTER
    :    'a'..'z'
    |	'_'
    |    '\u0080'..'\ufffe'
    ;
protected
ID_LETTER
    :	ID_START_LETTER
    |	'0'..'9'
    |	'/'
    ;

REAL_NUM
	:	NUM (POINT DOT_NUM)?
	;
	
protected
DOT_NUM
	:	(NUM_LETTER)+
	;

protected
NUM	:	'0'
	|	NUM_START (NUM_LETTER)*
	;
protected
NUM_START
	:	'1'..'9'
	;
protected
NUM_LETTER
	:	'0'..'9'
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
NAME_START
	:	'[';
NAME_END
	:	']';
COMMA
	:	',';
SEMI:	';';
POINT
	:	'.';
LPAREN
	:	'(';
RPAREN
	:	')';

WS	:	(' '|'\n'|'\t') {$setType(Token.SKIP);}
    ;

QUOTED_STRING
	:	('"'|'\'') (ESC|~('\''|'"'|'\\'|'\n'|'\r'))* ('"'|'\'')
	;
protected
ESC
	:	'\\'
		(	'n'
		|	'r'
		|	't'
		|	'b'
		|	'f'
		|	'"'
		|	'\''
		|	'\\'
		|	'0'..'3'
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:	'0'..'7'
				(
					options {
						warnWhenFollowAmbig = false;
					}
				:	'0'..'7'
				)?
			)?
		|	'4'..'7'
			(
				options {
					warnWhenFollowAmbig = false;
				}
			:	'0'..'7'
			)?
		)
	;


{
import java.util.*;

import translator.model.*;
}
class T extends TreeParser;
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
}

segment returns [String segment]
	{String str; segment="";}
	:	TABLE_SELECT segment=columnList
	|	FROM segment=tableList
	|	WHERE segment=equations
	|	COLUMN segment=column
	;

statement returns [QueryModel model]
	{String statement, clist, tlist, g, o, t1, t2, into, m, e;model=null;}
	:	#(TABLE_UNION t1=tableName t2=tableName into=tableName)
		{model=new UnionModel(t1, t2, into);}
	|	#(TABLE_COMPARE t1=tableName t2=tableName into=tableName m=method e=equations)
		{model=new CompareModel(t1, t2, into, m, e);}
	|	#(SELECT_STATEMENT statement=selectStatement)
		{model=new SelectModel(
			(String)segment.get("clist"),
			(String)segment.get("tlist"),
			(String)segment.get("equations"),
			(String)segment.get("groupby"),
			(String)segment.get("orderby"),
			null);}
/*		{System.out.println(statement);}
	|	#(TABLE_SELECT clist=columnList tlist=tableList e=equations g=optionalClause o=optionalClause)
		{model=new SelectModel(clist, tlist, e, g, o, null);}
*/	;

selectStatement returns [String statement]
	{String clist, tlist, e, g, o, s; statement="";}
	:	#(TABLE_SELECT clist=columnList tlist=tableList)
		{
			segment.put("clist", clist);
			segment.put("tlist", tlist);
		}
	|	#(WHERE s=selectStatement e=equations)
		{segment.put("equations", e);}
	|	#(GROUP_BY s=selectStatement g=columnList)
		{segment.put("groupby", g);}
	|	#(ORDER_BY s=selectStatement o=orderClause)
		{segment.put("orderby", o);}
	;
	
orderClause returns [String clause]
	{String c; clause="";}
	:	clause=columnList
	|	#(a:ASC c=columnList)
		{clause=c+" "+a.getText();}
	;

/*
optionalClause returns [String optional]
	{String o; optional="";}
	:	#(all:ALL GROUP_BY o=columnList)
		{optional=" GROUP BY "+all.getText()+" "+o;}
	|	GROUP_BY o=columnList
		{optional=" GROUP BY "+o;}
	|	#(asc:ASC ORDER_BY o=fieldList)
		{optional=" ORDER BY "+o+" "+asc.getText();}
	|	ORDER_BY o=fieldList
		{optional=" ORDER BY "+o;}
	|	GROUP_CLAUSE
		{optional="";}
	|	ORDER_CLAUSE
		{optional="";}
	;
*/

method returns [String m]
	{m="";}
	:	EXIST
		{m="EXIST";}
	|	NOT_EXIST
		{m="NOT EXIST";}
	;

columnList returns [String clist]
	{String elem, args="", c1, c2; clist="";}
	:	#(COMMA c1=columnList c2=columnList)
		{clist=c1+","+c2;}
	|	elem=column
		{clist=elem;}
	|	ALL_FIELDS
		{
			clist="(*)";
			addSelectListVO(clist, "");
		}
	|	ALL c1=columnList
		{clist="ALL "+c1;}
	|	DISTINCT c1=columnList
		{clist="DISTINCT "+c1;}
	;
	
column returns [String c]
	{String args; c="";}
	:	#(a:AS args=equElem d:ID)
		{
			c=args+" "+a.getText()+" "+d.getText();
			addFieldAliasByChAliasName(args, d.getText());
			addSelectListVO(args, d.getText());
		}
	|	c = equElem
		{
			addSelectListVO(c, "");
		}
	;

funcArgs returns [String args]
	{String a; args="";}
	:	ALL a=funcArg
		{args="all "+a;}
	|	DISTINCT a=funcArg
		{args="distinct "+a;}
	|	a=funcArg
		{args=a;}
	;
funcArg returns [String arg]
	{String f1, f2; arg="";}
	:	#(COMMA f1=funcArg f2=funcArg)
		{arg=f1+","+f2;}
	|	f1=equElem
		{arg=f1;}
	;

tableList returns [String tlist]
	{String t1, t2; tlist="";}
	:	#(COMMA t1=tableList t2=tableList)
		{tlist=t1+","+t2;}
	|	t1=tableName
		{tlist=t1;}
	;
fieldList returns [String fList]
	{String f1, f2; fList="";}
	:	#(COMMA f1=fieldList f2=fieldList)
		{fList=f1+","+f2;}
	|	f1=fieldName
		{fList=f1;}
	;

equations returns [String equStr]
	{String e1, e2; equStr="";int m = 0, n = 0;}
	:	#(EQUATION_START e1=equations)
		{
			equStr=e1;
		}
	|	#(lop:LOGIC_OP e1=equations e2=equations)
		{
			equStr=e1+" "+lop+" "+e2;
		}
	|	#(op:COMPARATOR e1=equElem e2=equElem)
		{
			equStr=e1+" "+op.getText()+" "+e2;
			whereIntKey++;
			addWhereListVO(e1, op.getText(), e2);
		}
//	|	LPAREN e1=equations EQU_RPAREN
//		{equStr="("+e1+")";}
	;

equElem	returns [String equElemStr]
	{String e1, e2, f, args; equElemStr="";}
	:	#(op:OPERATOR e1=equElem e2=equElem)
		{equElemStr=e1+op.getText()+e2;}
	|	#(star:STAR e1=equElem e2=equElem)
		{equElemStr=e1+star.getText()+e2;}
	|	LPAREN e1=equElem RPAREN
		{equElemStr="("+e1+")";}
	|	f=fieldName
		{equElemStr=f;}
	|	n:REAL_NUM
		{equElemStr=n.getText();}
	|	s:QUOTED_STRING
		{equElemStr=s.getText();}
	|	#(a:AS e1=equElem tempField:ID)
		{equElemStr=e1+" "+a.getText()+" "+tempField.getText();}
	|	#(fn:FUNC_NAME args=funcArgs)
		{equElemStr=fn.getText()+"("+args+")";}
	;

tableName returns [String tableStr]
	{String ts; tableStr="";}
	:	t:ID 
		{
			tableStr="["+t.getText()+"]";
			addFromTableByChName(t.getText());
			addFromListVO(t.getText(), "");
		}
	|	#(a:AS t1:ID t2:ID)
		{
			tableStr="["+t1.getText()+"] "+a.getText()+" "+t2.getText();
			//addFromTableByChName(t1.getText());
			addFromTableByChName(t1.getText(), t2.getText());
			addFromListVO(t1.getText(), t2.getText());
		}
	;

fieldName returns [String fieldStr]
	{fieldStr="";}
	:	#(POINT f1:ID f2:ID)
		{
			String t=f1.getText();
			String f=f2.getText();
			fieldStr="["+t+"."+f+"]";
			DbTable table=addTableByChName(t);
			table.addDbField(f, null);
		}
/*	|	star:STAR
		{fieldStr=star.getText();}
	|	(f3:ID)
		{fieldStr=f3.getText();}
*/	;
