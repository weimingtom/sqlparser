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
	SELECT_STATEMENT;
	SUBQUERY;
	GROUP_BY;
	ORDER_BY;
	ALIAS_EQU;
	FUNCTION;
	LOGIC_OP;
	CONTAIN_OP;
	SUBCONTAIN_OP;
	ALL_FIELDS;
	LOGIC_BLOCK;
}

segment
	:	(COLUMN column
	|	WHERE search_condition)
	EOF!
	;

statements
	:	statement (SEMI^ statement)* EOF!;

statement
	:	tableUnion
	|	tableCompare
	|	select_statement
	{#statement=#([SELECT_STATEMENT], #statement);}
	;

tableUnion
	:	("t_union"^|"表合并"^) table_name COMMA! table_name
	;

tableCompare
	:	("t_compare"^|"表比较"^) table_name COMMA! table_name ("where"!|"条件"!) comparemethod_name search_condition
	;

select_statement
	:	("select"^|"查询"^) ("distinct"^|"唯一"^)? select_list
		(("from"^|"来自"^) table_list)?
		(("where"^|"条件"^) search_condition)?
		(("group"^ "by"!|"分组"^) aggregate_expression_list)?
		(("order"^ "by"!|"排序"^) order_expression_list)?
	;

select_list
	:	column (COMMA^ column)*
	;

table_list
	:	table_name (COMMA^ table_name)*
	;

//search_condition
//	:	equation
//		(logic_op search_condition {#search_condition=#([LOGIC_OP, "logic_op"], #search_condition);})?
//	;

search_condition
	:	bool_exp
	|	("not"^ | "非"^) search_condition
	;
		
bool_exp
	:	bool_term 
		(("and"^ | "or"^ | "并且"^ | "或者"^) bool_term)*
	;

bool_term
	:	(LPAREN bool_exp RPAREN) => LPAREN! exp:bool_exp RPAREN!
	{#bool_term=#([LOGIC_BLOCK, "log_block"], bool_term);}
	|	equation
	;

aggregate_expression_list
	:	aggregate_expr (COMMA^ aggregate_expr)*
	;

order_expression_list
	:	order_expression (COMMA^ order_expression)*
	;

column
	:	expression_with_aggr_func (("as"^|"作为"^) alias)?
	|	alias ("="|"等于")! expression_with_aggr_func {#column=#([ALIAS_EQU, "="], #column);}
	|	all:"所有" {#column=#([ALL_FIELDS, all.getText()]);}
	|	STAR {#column=#([ALL_FIELDS, "*"]);}
	;

aggregate_expr
	:	(field_name|function) (
		two_arg_op aggregate_expr {#aggregate_expr=#([TWO_ARG_OP, "two_arg_op"], #aggregate_expr);})?
	;

order_expression
	:	(alias|field_name|aggregate_func|function) ("升序"^|"降序"^|"asc"^|"desc"^)?
	;

expression
	:	(field_name|constant|function|param_equ)
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	|	LPAREN expression RPAREN
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	|	one_arg_op expression {#expression=#([ONE_ARG_OP, "one_arg_op"], #expression);}
	;

expression_with_aggr_func
	:	(field_name|constant|function|aggregate_func) 
		(two_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([TWO_ARG_OP, "two_arg_op"], #expression_with_aggr_func);})?
	|	LPAREN expression_with_aggr_func RPAREN 
		(two_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([TWO_ARG_OP, "two_arg_op"], #expression_with_aggr_func);})?
	|	one_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([ONE_ARG_OP, "one_arg_op"], #expression_with_aggr_func);}
	;

equation
	:	expression (
		("="|compare_op) expression
	  	{#equation=#([COMPARE_OP, "comp_op"], #equation);} 
	|	("is"! "null"^|"is"! "not"^ "null"!|"为空"^|"非空"^)
	| 	("between"^|"范围"^) expression ("and"!)? expression
	| 	("not in"^|"in"^|"在于"^|"不在于"^) exp_set
	)
	;

exp_set
	: 	LPAREN constexpset RPAREN
	{#exp_set = #([SUBCONTAIN_OP, "subcontain_op"], #exp_set);}
//	| subquery
	;

constexpset
	:	constant (COMMA^ constant)*
	;

subquery
	:	LPAREN select_statement RPAREN
		{#subquery = #([SUBQUERY, "subquery"], #subquery);}
	;

param_equ
	:	PARAM_ID
	;

alias
	:	ID | QUOTED_STRING;
field_name
	:	ID POINT^ ID;
constant
	:	REAL_NUM
	|	NEGATIVE_DIGIT_ELEMENT
	|	QUOTED_STRING
	|	"null"
	;

function
	:	function_name LPAREN! parameters RPAREN!
	;
aggregate_func
	:	aggregate_func_name LPAREN! ("all"^|"全部"^|"distinct"^|"唯一"^)? parameters RPAREN!
	;

parameters
	:	expression (COMMA^ expression)*
	;
table_name
	:	ID (("as"^|"作为"^) alias)?
	;

aggregate_func_name
	:	"sum" 	| "求和"
	|	"avg" 	| "求平均数"
	|	"max" 	| "求最大值"
	|	"min" 	| "求最小值"
	|	"count" | "求记录数"
	;

//function_name
//	:	"sqrt" 		| 	"求平方根"
//	|	"getdate" 	| 	"求当前日期时间"
//	|	"abs" 		| 	"取绝对值"
//	|	"acos"		|	"求余弦值"
//	|	"substring" | 	"字符串截取"
//	|	"round"		|	"格式化数值"
//	|	"right" 	| 	"字符串右截"
//	|	"ltrim"		|	"去掉左空格"
//	|	"rtrim"		|	"去掉右空格"
//	|	"char_length" | "求字符串的长度"
//	|	"floor"		|	"求四舍后的整数"
//	|	"ceiling"	|	"求五入后的整数"
//	|	"lower" 	| 	"将字符串转为小写"
//	|	"charindex"	|	"存在于"
//	|	"str" 		| 	"数值转字符串"
//	;

function_name
	:	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

number_function
	:	"abs" 		| 	"取绝对值"
	|	"acos"		|	"求值的余弦角"
	|	"asin"		|	"求值的正弦角"
	|	"atan"		|	"求值的正切角"
	|	"atin2"		|	"求值的正弦和余弦角"
	|	"ceiling"	|	"求五入后的整数"
	|	"cos"		|	"求角的余弦值"
	|	"cot"		|	"求角的余切值"
	|	"degrees"	|	"求弧度数的角大小"
	|	"exp"		|	"求幂值"
	|	"floor"		|	"求四舍后的整数"
	|	"log"		|	"求自然对数"
	|	"log10"		|	"求10为底的对数"
	|	"mod"		|	"求模"
	|	"pi"		|	"求PI"
	|	"power"		|	"求数字的次幂值"
	|	"radians"	|	"求度数角的弧度"
	|	"rand"		|	"求0和1间的随机数"
	|	"round"		|	"格式化数值"
	|	"sign"		|	"求值的符号"
	|	"sin"		|	"求角的正弦值"
	|	"sqrt" 		| 	"求平方根"
	|	"tan"		|	"求角的正切值"
	;

string_function
	:	"ascii"		|	"求第一个字符的ASCII码"
	|	"char"		|	"求等值的字符"
	|	"char_length" | "求字符串的长度"
	|	"charindex"	|	"存在于"
	|	"difference"  |	"求两个串的差值"
	|	"lcase"
	|	"left"		|	"字符串左截"
	|	"length"	|	"求字符串总长度"
	|	"lower" 	| 	"将字符串转为小写"
	|	"ltrim"		|	"去掉左空格"
	|	"patindex"	|	"求第一次出现位置"
	|	"replace"	|	"字符串替换"
	|	"right"		|	"字符串左截"
	|	"rtrim"		|	"去掉右空格"
	|	"str"		|	"数值转字符串"
	|	"substring"	|	"字符串截取"
	|	"upper"		|	"将字符串转为大写"
	;

datetime_function
	:	"dateformat" |	"格式化日期"
	|	"datename"	|	"求日期的分量值"
	|	"datepart"	|	"求日期的分量整数值"
	|	"datetime"	|	"转为日期时间"
	|	"date"
	|	"dayname"
	|	"days"
	|	"day"
	|	"dow"
	|	"hours"
	|	"hour"
	|	"minutes"
	|	"minute"
	|	"monthname"
	|	"months"
	|	"month"
	|	"now"		|	"取当前日期时间"
	|	"quarter"
	|	"seconds"
	|	"second"
	|	"today"		|	"取当前日期"
	|	"weeks"
	|	"week"
	|	"years"
	|	"year"
	|	"getdate"	|	"求当前日期时间"
	|	"dateadd"	|	"日期相加"
	|	"datediff"	|	"日期相减"
	;

conversion_function
	:	"convert"	|	"字符转为日期"
	|	"hextoint"	|	"十六进制转为整数"
	|	"inttohex"	|	"整数转为十六进制"
	|	"isdate"	|	"是日期型"
	|	"isnumeric"	|	"是数值型"
	;

system_function
	:	"suser_id"
	|	"suser_name"
	|	"user_id"
	|	"user_name"
	;

// This is not being used currently (eg. Oracle), but might be useful at some point.
other_function
	:	"decode"
	| 	"dump"
	| 	"greatest"
	| 	"least"
	| 	"nvl"
	|	"vsize"
	;

//包含运算符
contain_op
	:	"在于" | "不在于" | "in" | "not in"
	;

one_arg_op
	:	ONE_ARG_OP;

two_arg_op
	:	TWO_ARG_OP | STAR | MINUS
	|	"与" | "或" | "异或" | "加" | "减" | "乘" | "除" | "求模";

compare_op
	:	COMPARE_OP | "等于" | "like"
	|	"大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	|	"包含" | "不包含"
	;

logic_onearg_op
	:	"not" | "非";

logic_op
	:	"and" | "or" | "并且" | "或者";

comparemethod_name
	:	"not exists" | "不存在"
	|	"exists" | "存在";

class L extends Lexer;

options {
	k=5;
	charVocabulary = '\u0000' .. '\uFFFE';
	testLiterals=false;
	caseSensitive = false;
	caseSensitiveLiterals = true;
}

ONE_ARG_OP
	:	'~';
TWO_ARG_OP
	:	'&' | '|' | '^' | '+' | '/' | '%';
MINUS 
	: 	'-' ;
STAR
	:	'*';
COMPARE_OP
	:	'>' | '<' | ">=" | "<=" | "!=" | "<>" | "=";
NOT_EXIST:
	"not exist";
EXIST:
	"exist";
COMMA
	:	',';
SEMI:	';';
POINT
	:	'.';
LPAREN
	:	'(';
RPAREN
	:	')';

PARAM_LPAREN
	:	'{';

PARAM_RPAREN
	:	'}';


COLUMN
	:	"column";
WHERE
	:	"where";

WS	:	(' '|'\n'|'\r'|'\t')+ {$setType(Token.SKIP);}
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

PARAM_ID
	: PARAM_LPAREN ID PARAM_RPAREN
	;

ID	options {testLiterals=true;}
	:	ID_START_LETTER ( ID_LETTER )*;

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

//negative digit element
NEGATIVE_DIGIT_ELEMENT
	: 	MINUS NUM (POINT DOT_NUM)?
	;
	
protected
NUM	:	'0'
	|	NUM_START (NUM_LETTER)*
	;
protected
DOT_NUM
	:	(NUM_LETTER)+
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

	import model.parser.*;
}
class T extends TreeParser;
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
}

segment returns[QueryModel model]
{
	model=null;
	
	SelectStatementModel stmt = new SelectStatementModel();
	SelectListModel selList = new SelectListModel();
	TableListModel t1 = new TableListModel();
	ColumnModel c1 = new ColumnModel();
	SearchConditionModel cond = new SearchConditionModel();
}
	: 	COLUMN c1 = column
		{
			for (Iterator it = getTables().keySet().iterator(); it.hasNext();){
	        	t1.addTable( (TableModel)getTables().get((String)it.next()));
	        }
			selList.addColumn(c1);
			stmt.setTableList(t1);
			stmt.setSelectList(selList);
			model = stmt;
		}
	|	WHERE cond = search_condition
		{
			for (Iterator it = getTables().keySet().iterator(); it.hasNext();){
	        	t1.addTable( (TableModel)getTables().get((String)it.next()));
	        }
			stmt.setTableList(t1);
			stmt.setSearchCondition(cond);
			model = stmt;	
		}
	;

statements returns [StatementsModel model]
{StatementsModel s1, s2; QueryModel s; model=new StatementsModel();}
	:	#(SEMI s1=statements s2=statements)
	{model.addChild(s1); model.addChild(s2);}
	|	s=statement
	{model.addStatement(s);}
	;
	
statement returns [QueryModel model]
{	model = null;
	String method;
	SelectStatementModel select; 
	TableUnionModel union = new TableUnionModel(); 
	TableModel tableModel1, tableModel2;
	TableCompareModel tableCompare = new TableCompareModel();
	SearchConditionModel cond;
}
	:	#("表合并" tableModel1 = table_name tableModel2 = table_name)
		{
			union.addTableModel1(tableModel1);
			union.addTableModel2(tableModel2);
			model = union;
		}
	|	#("表比较" tableModel1 = table_name tableModel2 = table_name method = compare_method cond = search_condition)
		{	
			tableCompare.addTableModel1(tableModel1);
			tableCompare.addTableModel2(tableModel2);
			tableCompare.setCompareMethod(method);
			tableCompare.setSearchCondition(cond);
			model = tableCompare;
		}
	|	#(SELECT_STATEMENT model=select_statement)
	;

compare_method returns [String rValue]
	{rValue = "";}
	:	v1: comparemethod_name
	{rValue = v1.getText();}
	;

select_statement returns [SelectStatementModel model]
{
	OrderExpressionListModel order;
	AggregateExprListModel group;
	SearchConditionModel cond;
	TableListModel tl;
	SelectListModel sl;
	SelectStatementModel s;
	model=new SelectStatementModel();
}
	:	#("唯一" select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#("distinct" select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#("查询" sl=select_list)
	{model.setSelectList(sl);}
	|	#("select" sl=select_list)
	{model.setSelectList(sl);}
	|	#("来自" s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#("from" s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#("条件" s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#("where" s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#("分组" s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#("group" s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#("排序" s=select_statement order=order_expression_list)
	{model.addChild(s); model.setOrderExpressionList(order);}
	|	#("order" s=select_statement order=order_expression_list)
	{model.addChild(s); model.setOrderExpressionList(order);}
	;
	
select_list returns [SelectListModel model]
{
	SelectListModel m1, m2; 
	ColumnModel c;
	model=new SelectListModel();
}
	:	#(COMMA m1=select_list m2=select_list)
	{model.addChild(m1); model.addChild(m2);}
	|	c=column
	{model.addColumn(c);}
	;

table_list returns [TableListModel model]
{TableModel t; TableListModel m1, m2; model=new TableListModel();}
	:	#(COMMA m1=table_list m2=table_list)
	{model.addChild(m1); model.addChild(m2);}
	|	t=table_name
	{model.addTable(t);}
	;

//search_condition returns [SearchConditionModel model]
//{SearchConditionModel m1, m2; EquationModel equ; model=new SearchConditionModel();}
//	:	#(LOGIC_OP m1=search_condition op:logic_op m2=search_condition)
//	{model.addChild(m1); model.addOperator(op.getText()); model.addChild(m2);}
//	|	equ=equation
//	{model.addEquation(equ);}
//	;
search_condition returns [SearchConditionModel model]
{SearchConditionModel m1, m2, m3, m4, m5; EquationModel equ; model=new SearchConditionModel();}
	:	#(o1:"and" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o1.getText()); model.addChild(m2);}
	|	#(o2:"or" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o2.getText()); model.addChild(m2);}
	|	#(o3:"并且" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);}
	|	#(o4:"或者" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);}
	|	#(LOGIC_BLOCK m3=search_condition)
	{model.addOperator("("); model.addChild(m3); model.addOperator(")");}
	|	#(o11:"not" m4=search_condition)
	{model.addOperator(o11.getText()); model.addChild(m4);}
	|	#(o12:"非" m5=search_condition)
	{model.addOperator(o12.getText()); model.addChild(m5);}
	|	equ=equation
	{model.addEquation(equ);}
	;

aggregate_expression_list returns [AggregateExprListModel model]
{AggregateExprListModel m1, m2; AggregateExprModel expr; model=new AggregateExprListModel();}
	:	#(COMMA m1=aggregate_expression_list m2=aggregate_expression_list)
	{model.addChild(m1); model.addChild(m2);}
	|	expr=aggregate_expression
	{model.addAggregateExpression(expr);}
	;

order_expression_list returns [OrderExpressionListModel model]
{OrderExpressionModel e; OrderExpressionListModel m1, m2; model=new OrderExpressionListModel();}
	:	#(COMMA m1=order_expression_list m2=order_expression_list)
	{model.addChild(m1); model.addChild(m2);}
	|	e=order_expression
	{model.addOrderExpression(e);}
	;

column returns [ColumnModel model]
{ExpressionModel e; AliasModel a; model=new ColumnModel();}
	:	#("as" e=expression a=alias)
	{model.addExpression(e); model.addAlias(a);}
	|	#("作为" e=expression a=alias)
	{model.addExpression(e); model.addAlias(a);}
	|	#(ALIAS_EQU a=alias e=expression)
	{model.addExpression(e); model.addAlias(a);}
	|	e=expression
	{model.addExpression(e);}
	;

equation returns [EquationModel model]
{
	ExpressionModel e1, e2, e3;
	EquationModel equation;
	model=new EquationModel();
}
	:	#(COMPARE_OP e1=expression op:compare_op e2=expression)
	{model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);}
	|	#(n:"为空" e1=expression)
	{model.addExpression(e1); model.addOperator(n.getText());}
	|	#("null" e1=expression)
	{model.addExpression(e1); model.addOperator("is null");}
	|	#(nn:"非空" e1=expression)
	{model.addExpression(e1); model.addOperator(nn.getText());}
	|	#(nn_en:"not" e1=expression)
	{model.addExpression(e1); model.addOperator("is not null");}
	|	#("between" e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator("between");
	 model.addExpression(e2); model.addExpression(e3);}
	|	#(btw:"范围" e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator(btw.getText());
	 model.addExpression(e2); model.addExpression(e3);}
	|	#("in" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator("in"); model.addExpression(e2);}
	|	#(ct1:"在于" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);}
	|	#("not in" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator("not in"); model.addExpression(e2);}
	|	#(ct2:"不在于" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);}
	;

exp_set returns [ExpressionModel model]
{model = new ExpressionModel(); ExprContainModel expr;}
	: 	#(SUBCONTAIN_OP LPAREN expr=constexpset RPAREN)
		{
			model.addExprContainModel(expr);
		}
	;

constexpset returns [ExprContainModel model]
{
	model = new ExprContainModel();
	ExprContainModel cep1, cep2;
	String ce, ce1, ce2;
}
	:	#(COMMA cep1=constexpset cep2=constexpset)
		{model.addChild(cep1); model.addChild(cep2);}
	|	ce=constant_expr
		{model.addConstant(ce);}
	;

constant_expr returns [String rValue]
{rValue = "";}
	:	rn:REAL_NUM
	{rValue = rn.getText();}
	|	qs:QUOTED_STRING
	{rValue = qs.getText();}
	;

aggregate_expression returns [AggregateExprModel model]
{AggregateExprModel a1, a2; FieldModel field; FunctionModel func; model=new AggregateExprModel();}
	:	#(TWO_ARG_OP a1=aggregate_expression op:two_arg_op a2=aggregate_expression)
	{model.addChild(a1); model.addOperator(op.getText()); model.addChild(a2);}
	|	field=field_name
	{model.addField(field);}
	|	func=function
	{model.addFunction(func);}
	;
order_expression returns [OrderExpressionModel model]
{FunctionModel func; FieldModel field; OrderAliasModel alias; OrderExpressionModel o; model=new OrderExpressionModel();}
	:	alias = orderAlias
	{model.addOrderAlias(alias);}
	|	field=field_name
	{model.addField(field);}
	|	func=function
	{model.addFunction(func);}
	|	#("asc" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.ASC);}
	|	#("升序" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.ASC);}
	|	#("desc" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.DESC);}
	|	#("降序" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.DESC);}
	;
orderAlias returns [OrderAliasModel model]
{model=null;}
	:	a1:QUOTED_STRING
	{model=new OrderAliasModel(a1.getText());}
	|	a2:ID
	{model=new OrderAliasModel(a2.getText());}
	;
alias returns [AliasModel model]
{model=null;}
	:	a1:QUOTED_STRING
	{model=new AliasModel(a1.getText());}
	|	a2:ID
	{model=new AliasModel(a2.getText());}
	;

expression returns [ExpressionModel model]
{FieldModel f; FunctionModel func; ParamModel param; ExpressionModel e1, e2; model=new ExpressionModel();}
	:	#(TWO_ARG_OP e1=expression op:two_arg_op e2=expression)
	{model.addChild(e1); model.addOperator(op.getText()); model.addChild(e2);}
	|	#(ONE_ARG_OP op1:one_arg_op e1=expression)
	{model.addOperator(op1.getText()); model.addChild(e1);}
	|	lp:LPAREN e1=expression rp:RPAREN
	{model.addOperator(lp.getText()); model.addChild(e1); model.addOperator(rp.getText());}
	|	param=param_equ
	{model.addParam(param);}
	|	f=field_name
	{model.addField(f);}
	|	func=function
	{model.addFunction(func);}
	|	nrn:NEGATIVE_DIGIT_ELEMENT
	{model.addConstant(nrn.getText());}
	|	rn:REAL_NUM
	{model.addConstant(rn.getText());}
	|	qs:QUOTED_STRING
	{model.addConstant(qs.getText());}
	|	allf:ALL_FIELDS
	{model.addOperator(allf.getText());}
	;

param_equ returns [ParamModel model]
	{model = null;}
	:	paramName:PARAM_ID
		{model = new ParamModel(paramName.getText(), "{", "}");}
//	|	#(paramName:ID lp:PARAM_LPAREN rp:PARAM_RPAREN)
//		{model = new ParamModel(paramName.getText(), lp.getText(), rp.getText());}
	;
	
field_name returns [FieldModel model]
{model=null;}
	:	f:ID
	{model=new FieldModel(f.getText());}
	|	#(POINT t:ID f1:ID)
	{
		model=new FieldModel(f1.getText(), t.getText());
		addTableByChName(t.getText());
	}
	;
function returns [FunctionModel model]
{ParametersModel p; model=null;}
	:	f:function_name p=parameters
	{model=new FunctionModel(f.getText()); model.setParameters(p);}
	|	#(all:"全部" af11:function_name p=parameters)
	{model=new FunctionModel(af11.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);}
	|	#("all" af12:function_name p=parameters)
	{model=new FunctionModel(af12.getText()); model.setFilter(FunctionModel.ALL); model.setParameters(p);}
	|	#(dist:"唯一" af21:function_name p=parameters)
	{model=new FunctionModel(af21.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);}
	|	#("distinct" af22:function_name p=parameters)
	{model=new FunctionModel(af22.getText()); model.setFilter(FunctionModel.DISTINCT); model.setParameters(p);}
	;
	
parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel e; model=new ParametersModel();}
	:	#(COMMA p1=parameters p2=parameters)
	{model.addChild(p1); model.addChild(p2);}
	|	e=expression
	{model.addParameter(e);}
	;

table_name returns [TableModel model]
{AliasModel a; model=null; TableAliasModel ta;}
	:	t:ID
	{model=new TableModel(t.getText());}
//	|	#("as" t1:ID a=alias)
//	{model=new TableModel(t1.getText()); model.setAlias(a);}
//	|	#("作为" t2:ID a = alias)
//	{model = new TableModel(t2.getText()); model.setAlias(a);}
	|	#("as" t1:ID ta = tableAlias)
	{model = new TableModel(t1.getText()); model.setAlias(ta);}
	|	#("作为" t2:ID ta = tableAlias)
	{model = new TableModel(t2.getText()); model.setAlias(ta);}
	;

tableAlias returns [TableAliasModel model]
{model=null;}
	:	a1:QUOTED_STRING
	{model = new TableAliasModel(a1.getText());}
	|	a2:ID
	{model = new TableAliasModel(a2.getText());}
	;	
//////////////////////////////////////////////////////////////
// 常量
select : "查询" | "select";
distinct : "唯一" | "distinct";
logic_op : "and" | "or" | "并且" | "或者";
compare_op
	:	COMPARE_OP | "等于" | "like"
	|	"大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	|	"包含" | "不包含"
	;

//包含运算符
contain_op
	:	"在于" | "不在于" | "in" | "not in"
	;
one_arg_op
	:	ONE_ARG_OP;
two_arg_op
	:	TWO_ARG_OP | STAR | MINUS
	|	"与" | "或" | "异或" | "加" | "减" | "乘" | "除" | "求模";

//function_name
//	:	"sqrt" 		| 	"求平方根"
//	|	"getdate" 	| 	"求当前日期时间"
//	|	"abs" 		| 	"求绝对值"
//	|	"acos"		|	"求余弦值"
//	|	"substring" | 	"字符串截取"
//	|	"round"		|	"格式化数值"
//	|	"right" 	| 	"字符串右截"
//	|	"ltrim"		|	"去掉左空格"
//	|	"rtrim"		|	"去掉右空格"
//	|	"char_length" | "求字符串的长度"
//	|	"floor"		|	"求四舍后的整数"
//	|	"ceiling"	|	"求五入后的整数"
//	|	"lower" 	| 	"将字符串转为小写"
//	|	"charindex"	|	"存在于"
//	|	"str" 		| 	"数值转字符串"
//	|	"sum" 		| 	"求和"
//	|	"avg" 		| 	"求平均数"
//	|	"max" 		| 	"求最大值"
//	|	"min" 		| 	"求最小值"
//	|	"count" 	| 	"求记录数"
//	;

function_name
	:	aggregate_func_name
	|	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

aggregate_func_name
	:	"sum" 	| "求和"
	|	"avg" 	| "求平均数"
	|	"max" 	| "求最大值"
	|	"min" 	| "求最小值"
	|	"count" | "求记录数"
	;

number_function
	:	"abs" 		| 	"取绝对值"
	|	"acos"		|	"求值的余弦角"
	|	"asin"		|	"求值的正弦角"
	|	"atan"		|	"求值的正切角"
	|	"atin2"		|	"求值的正弦和余弦角"
	|	"ceiling"	|	"求五入后的整数"
	|	"cos"		|	"求角的余弦值"
	|	"cot"		|	"求角的余切值"
	|	"degrees"	|	"求弧度数的角大小"
	|	"exp"		|	"求幂值"
	|	"floor"		|	"求四舍后的整数"
	|	"log"		|	"求自然对数"
	|	"log10"		|	"求10为底的对数"
	|	"mod"		|	"求模"
	|	"pi"		|	"求PI"
	|	"power"		|	"求数字的次幂值"
	|	"radians"	|	"求度数角的弧度"
	|	"rand"		|	"求0和1间的随机数"
	|	"round"		|	"格式化数值"
	|	"sign"		|	"求值的符号"
	|	"sin"		|	"求角的正弦值"
	|	"sqrt" 		| 	"求平方根"
	|	"tan"		|	"求角的正切值"
	;

string_function
	:	"ascii"		|	"求第一个字符的ASCII码"
	|	"char"		|	"求等值的字符"
	|	"char_length" | "求字符串的长度"
	|	"charindex"	|	"存在于"
	|	"difference"  |	"求两个串的差值"
	|	"lcase"
	|	"left"		|	"字符串左截"
	|	"length"	|	"求字符串总长度"
	|	"lower" 	| 	"将字符串转为小写"
	|	"ltrim"		|	"去掉左空格"
	|	"patindex"	|	"求第一次出现位置"
	|	"replace"	|	"字符串替换"
	|	"right"		|	"字符串左截"
	|	"rtrim"		|	"去掉右空格"
	|	"str"		|	"数值转字符串"
	|	"substring"	|	"字符串截取"
	|	"upper"		|	"将字符串转为大写"
	;

datetime_function
	:	"dateformat" |	"格式化日期"
	|	"datename"	|	"求日期的分量值"
	|	"datepart"	|	"求日期的分量整数值"
	|	"datetime"	|	"转为日期时间"
	|	"date"
	|	"dayname"
	|	"days"
	|	"day"
	|	"dow"
	|	"hours"
	|	"hour"
	|	"minutes"
	|	"minute"
	|	"monthname"
	|	"months"
	|	"month"
	|	"now"		|	"取当前日期时间"
	|	"quarter"
	|	"seconds"
	|	"second"
	|	"today"		|	"取当前日期"
	|	"weeks"
	|	"week"
	|	"years"
	|	"year"
	|	"getdate"	|	"求当前日期时间"
	|	"dateadd"	|	"日期相加"
	|	"datediff"	|	"日期相减"
	;

conversion_function
	:	"convert"	|	"字符转为日期"
	|	"hextoint"	|	"十六进制转为整数"
	|	"inttohex"	|	"整数转为十六进制"
	|	"isdate"	|	"是日期型"
	|	"isnumeric"	|	"是数值型"
	;

system_function
	:	"suser_id"
	|	"suser_name"
	|	"user_id"
	|	"user_name"
	;

// This is not being used currently (eg. Oracle), but might be useful at some point.
other_function
	:	"decode"
	| 	"dump"
	| 	"greatest"
	| 	"least"
	| 	"nvl"
	|	"vsize"
	;


//比较运算符
comparemethod_name
	:	"not exists" | "不存在"
	|	"exists" 	| "存在"
;