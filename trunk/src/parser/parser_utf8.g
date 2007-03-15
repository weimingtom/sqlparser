header {
package parser;
}

class P extends Parser;

options {
	k=3;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {
	ALL_FIELDS;
	EQUATION_START="equation start";
}

query
	:	statement (SEMI! statement)*;

statement
	:	tableUnion
	|	tableCompare
	|	tableSelect
	;

tableUnion
	:	TABLE_UNION^ tableName COMMA! tableName INTO! tableName
	;

tableCompare
	:	TABLE_COMPARE^ tableName COMMA! tableName INTO! tableName WHERE! method equations
	;

tableSelect
	:	TABLE_SELECT^ columnList FROM! tableList WHERE! equations
	;

columnList
	:	column (COMMA^ columnList)?
	;

column
	:	func
	|	equElem
	|	(STAR)=>STAR
		{#column=#([ALL_FIELDS]);}
	;

func:	FUNC_NAME^ LPAREN! RPAREN!;

funcArgs
	:	equElem (COMMA^ equElem)*;

tableList
	:	tableName (COMMA^ tableName)*
	;

method
	:	EXIST|NOT_EXIST;

equations
	:	equation (LOGIC_OP^ equations)?
//		{#equations=#([EQUATION_START], #equations);}
//	|	LPAREN EQUATION_START equations RPAREN
	;

equation
	:	equElem COMPARATOR^ equElem
//	|	(fieldName BETWEEN)=>fieldName BETWEEN^ constant AND! constant
	;

tableName
	:	ID
	;

equElem
	:	elem ((OPERATOR^|STAR^) equElem )?
	|	LPAREN equElem RPAREN (OPERATOR^ equElem)?
	;

elem:	fieldName
	|	constant
	;

fieldName
	:	tableName POINT^ ID
	;

constant
	:	REAL_NUM
	|	QUOTED_STRING
	;

class L extends Lexer;

options {
	k=6;
	charVocabulary = '\u0000' .. '\uFFFF';
	testLiterals=false;
	caseSensitive = false;
	caseSensitiveLiterals = false;
	
}

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
	:	'\'' ( ~'\'' )* '\'' 
	;

TABLE_UNION
	:	"union";
TABLE_COMPARE
	:	"compare";
TABLE_SELECT
	:	"select";
INTO:	"into";
WHERE
	:	"where";
EXIST
	:	"exist";
NOT_EXIST
	:	"not_exist";
FROM:	"from";
ALL :	"all";
DISTINCT
	:	"distinct";

COMPARATOR
	:	"="|">"|"<"|">="|"<="|"<>"|"like";
OPERATOR
	:	'+'|'-'|'/';
STAR:	'*';
LOGIC_OP
	:	"and"|"or";

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
	|	"rtrim"	// 去掉右空格
	|	"substring"	// 字符串截取
	|	"char_length"	// 求字符串的长度
	|	"floor"	// 求四舍后的整数
	|	"count"	// 求记录总数
	|	"lower"	// 将字符串转为小写
	|	"ceiling"	// 求五入后的整数
	|	"charindex"	// 存在于
	|	"str"
	;

/////////////////////////////////////////////////////
// general symbol
ID	:	ID_START_LETTER ( ID_LETTER )*;
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
	:	NUM (POINT NUM)?
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

{
import java.util.*;

import translator.model.*;
}
class T extends TreeParser;
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
}

statement returns [QueryModel model]
	{String clist, tlist, t1, t2, into, m, e; model=null;}
	:	#(TABLE_UNION t1=tableName t2=tableName into=tableName)
		{model=new UnionModel(t1, t2, into);}
	|	#(TABLE_COMPARE t1=tableName t2=tableName into=tableName m=method e=equations)
		{model=new ComapreModel(t1, t2, into, m, e);}
	|	#(TABLE_SELECT clist=columnList tlist=tableList e=equations)
		{model=new SelectModel(clist, tlist, e);}
	;

method returns [String m]
	{m="";}
	:	EXIST
		{m="EXIST";}
	|	NOT_EXIST
		{m="NOT_EXIST";}
	;

columnList returns [String clist]
	{String elem, args="", c1, c2; clist="";}
	:	#(COMMA c1=columnList c2=columnList)
		{clist=c1+","+c2;}
	|	elem=equElem
		{clist=elem;}
	|	fn:FUNC_NAME args=equElem
		{clist=fn.getText()+"("+args+")";}
	|	ALL_FIELDS
		{clist="*";}
	;

/*
funcArgs returns [String args]
	{String a; args="";}
	:	#(ALL a=funcArgs)
		{args="all "+a;}
	|	#(DISTINCT a=funcArgs)
		{args="distinct "+a;}
	|	a=funcArg
		{args=a;}
	;
funcArg returns [String arg]
	{arg="";}
	:	#(COMMA funcArg funcArg)
	|	equElem
	;
*/

tableList returns [String tlist]
	{String t1, t2; tlist="";}
	:	#(COMMA t1=tableList t2=tableList)
		{tlist=t1+","+t2;}
	|	t1=tableName
		{tlist=t1;}
	;

equations returns [String equStr]
	{String e1, e2; equStr="";}
	:	#(lop:LOGIC_OP e1=equations e2=equations)
		{equStr=e1+" "+lop+" "+e2;}
	|	#(op:COMPARATOR e1=equElem e2=equElem)
		{equStr=e1+" "+op.getText()+" "+e2;}
	|	LPAREN e1=equations EQU_RPAREN
		{equStr="("+e1+")";}
	;

equElem	returns [String equElemStr]
	{String e1, e2, f; equElemStr="";}
	:	#(op:OPERATOR e1=equElem e2=equElem)
		{equElemStr=e1+" "+op.getText()+" "+e2;}
	|	#(star:STAR e1=equElem e2=equElem)
		{equElemStr=e1+" "+star.getText()+" "+e2;}
	|	LPAREN e1=equElem RPAREN
		{equElemStr="("+e1+")";}
	|	f=fieldName
		{equElemStr=f;}
	|	n:REAL_NUM
		{equElemStr=n.getText();}
	|	s:QUOTED_STRING
		{equElemStr=s.getText();}
	;

tableName returns [String tableStr]
	{tableStr="";}
	:	t:ID 
		{
			tableStr=t.getText();
			addTableByChName(tableStr);
		}
	;

fieldName returns [String fieldStr]
	{fieldStr="";}
	:	#(POINT f1:ID f2:ID)
		{
			String t=f1.getText();
			String f=f2.getText();
			fieldStr=t+"."+f;
			DbTable table=addTableByChName(t);
			table.addDbField(f, null);
		}
/*	|	star:STAR
		{fieldStr=star.getText();}
	|	(f3:ID)
		{fieldStr=f3.getText();}
*/	;
