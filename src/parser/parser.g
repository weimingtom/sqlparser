/*==========================================================//
//	LongtopParser Of Sybase									//
// 	Sybase 12.5.3/Sybase IQ 12.6 SQL Grammar				//
//															//
//	http://www.longtop.com									//
//															//
//  Recent updates by jiandeh@sina.com						//
//															//
//	\u4fee\u6539\u65e5\u5fd7:													//
//	======================================================	//
//	05/01/2007:												//
//		- \u4fee\u6539\u4e86WHERE\u6761\u4ef6\u591a\u4e2a\u903b\u8f91\u5173\u7cfbAND/OR	\u4e4b\u95f4\u62ec\u53f7\u7684\u5d4c\u5957\u95ee\u9898		//
//		- \u4fee\u6539\u4e86\u6574\u4e2aWHERE\u6761\u4ef6\u903b\u8f91\u975e(NOT)\u7684\u95ee\u9898					//
//	05/18/2007\uff1a												//
//		- \u4fee\u6539\u4e86\u903b\u8f91\u975e\u6574\u4e2a\u6761\u4ef6\uff0c\u7528SEARCH_NOT_CONDITION TOKEN	//
//		- \u4fee\u6539\u4e86IS NULL/IS NOT NULL; NOT EXISTS;				//
//        NOT LIKE; IN/NOT IN TOKEN\u53ca\u8bed\u6cd5\u6811\u904d\u5386\uff0c\u53ef\u4ee5\u7528\u9a8c\u8bc1\u82f1\u6587	//
//		- \u589e\u52a0FUNCTION_EMPTY_PARAM TOKEN\uff0c\u53ef\u4ee5\u5bf9\u7a7a\u51fd\u6570\u9a8c\u8bc1		//
//		- \u589e\u52a0FUNCTION_COUNT TOKEN\uff0c\u5141\u8bb8\u5bf9\u805a\u5408\u51fd\u6570COUNT(*)\u9a8c\u8bc1	//
//		- \u589e\u52a0\u5de6\u8fde\u63a5(*=)\u8bed\u6cd5\u9a8c\u8bc1								//
//	05/19/2007:												//
//		- \u589e\u52a0\u4e86\u65e5\u671fdate-part\u4fdd\u7559\u5b57\u7684\u5904\u7406\uff0c\u53ef\u4ee5\u4f7f\u7528dateadd(day, 	//
//		  10, getdate())\u51fd\u6570\u53caday\u4fdd\u7559\u5b57						//
//		- \u589e\u52a0empty_function\u3001star_function\uff0c\u7528\u6765\u5bf9getdate();	//
//		  pi(*)\u3001now(*)\u3001today(*)\u7684\u9a8c\u8bc1						//
//	05/22/2007\uff1a												//
//		- \u4fee\u6539\u4e86SELECT\u5b50\u53e5\u975e\u805a\u5408\u51fd\u6570\u8868\u8fbe\u5f0f\u5fc5\u987b\u5728GROUP BY\u51fa\u73b0\u95ee\u9898	//
//		  													//
//==========================================================*/

header {
	package parser;
}

/*==========================================================//
//															//
//						Parser Define						//
//															//
//==========================================================*/
class P extends Parser;

options {
	k=5;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {	
	SELECT_STATEMENT;
	SEARCH_NOT_CONDITION;	//\u975e\u6574\u4e2a\u6761\u4ef6TOKEN
	SUBQUERY;				//\u5b50\u67e5\u8be2TOKEN
	GROUP_BY;				//GROUP BY TOKEN
	ORDER_BY;				//ORDER BY TOKEN
	ALIAS_EQU;				//\u522b\u540dTOKEN
	
	FUNCTION;				//\u51fd\u6570TOKEN
	FUNCTION_EMPTY_PARAM;	//\u7a7a\u53c2\u6570\u51fd\u6570TOKEN[getdate()]
	FUNCTION_STAR_PARAM;	//\u53c2\u6570\u4e3a*\u51fd\u6570TOKEN[now(*);today(*)]
	FUNCTION_STAR_COUNT;	//\u51fd\u6570COUNT(*) TOKEN
	
	LOGIC_OP;				//\u903b\u8f91\u64cd\u4f5c\u7b26TOKEN
	LOGICAL_NULL;			//\u903b\u8f91IS NULL TOKEN
	LOGICAL_NOT_NULL;		//\u903b\u8f91IS NOT NULL TOKEN
	LOGICAL_IN;				//\u903b\u8f91IN TOKEN
	LOGICAL_NOT_IN;			//\u903b\u8f91NOT IN TOKEN
	LOGICAL_LIKE;			//\u903b\u8f91LIKE TOKEN
	LOGICAL_NOT_LIKE;		//\u903b\u8f91LIKE TOKEN
	LOGICAL_EXISTS;			//\u903b\u8f91EXISTS TOKEN
	LOGICAL_NOT_EXISTS;		//\u903b\u8f91NOT EXISTS TOKEN
	LOGICAL_BETWEEN;		//\u903b\u8f91BETWEEN AND TOKEN
	
	SUBCONTAIN_OP;			//\u5173\u7cfbIN/NOT IN TOKEN
	ALL_FIELDS;				//\u5b57\u6bb5\u6240\u6709(*) TOKEN
	LOGIC_BLOCK;			//WHERE\u6761\u4ef6\u903b\u8f91\u5757 TOKEN
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
	:	("t_union"^|"\u8868\u5408\u5e76"^) table_lists
	;

table_lists
	:	table_name (COMMA^ table_name)+
	;

tableCompare
	:	("t_compare"^|"\u8868\u6bd4\u8f83"^) table_name COMMA! table_name ("where"!|"\u6761\u4ef6"!) compare_method search_condition
	;

compare_method
	:	comparemethod_name
	|	"not" "exists"
		{#compare_method = #([LOGICAL_NOT_EXISTS, "logic_not_exists"], compare_method);}
	;

select_statement
	:	
		//CUSTOM SQL Sentence
		("select"^ | "\u67e5\u8be2"^) ("distinct"^ | "\u552f\u4e00"^)? select_list
		(("from"^ | "\u6765\u81ea"^) table_list)?
		(("where"^ | "\u6761\u4ef6"^) search_condition)?
		(("group"^ "by"!|"\u5206\u7ec4"^) aggregate_expression_list)?
		(("order"^ "by"!|"\u6392\u5e8f"^) order_expression_list)?
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
	|	( "not"
		{#search_condition = #([SEARCH_NOT_CONDITION, "search_not_condition"], search_condition);}
		| "\u975e"^
		) search_condition
	;

bool_exp
	:	bool_term 
		(("and"^ | "or"^ | "\u5e76\u4e14"^ | "\u6216\u8005"^) bool_term)*
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
	:	expression_with_aggr_func (("as"^|"\u4f5c\u4e3a"^) alias)?
	|	alias ("="|"\u7b49\u4e8e")! expression_with_aggr_func {#column=#([ALIAS_EQU, "="], #column);}
	|	all:"\u6240\u6709" {#column=#([ALL_FIELDS, all.getText()]);}
	|	STAR {#column=#([ALL_FIELDS, "*"]);}
	;

aggregate_expr
	:	(field_name|function) (
		two_arg_op aggregate_expr {#aggregate_expr=#([TWO_ARG_OP, "two_arg_op"], #aggregate_expr);})?
	;

order_expression
	:	(alias|field_name|aggregate_func|function) ("\u5347\u5e8f"^|"\u964d\u5e8f"^|"asc"^|"desc"^)?
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
		
		//\u5173\u7cfb\u8fd0\u7b97\u7b26(+ - * /) \u8868\u8fbe\u5f0f
		("=" | compare_op) expression
	  	{#equation=#([COMPARE_OP, "comp_op"], #equation);}
	  	
		//\u5173\u7cfb\u8fd0\u7b97\u7b26NOT LIKE \u8868\u8fbe\u5f0f
	|	("not" "like") expression
		{#equation=#([LOGICAL_NOT_LIKE, "logic_not_like"], #equation);}	

		//\u5173\u7cfb\u8fd0\u7b97\u7b26IS NULL/IS NOT NULL
	|	( "is" "null"
		  {#equation = #([LOGICAL_NULL, "logic_null"], #equation);}
		| "is" "not" "null"
		  {#equation = #([LOGICAL_NOT_NULL, "logic_not_null"], #equation);}
		| "\u4e3a\u7a7a"^ | "\u975e\u7a7a"^
		)
	
		//\u5173\u7cfb\u8fd0\u7b97\u7b26BETWEEN AND
	| 	("between"^ | "\u8303\u56f4"^) expression ("and"!)? expression
	
		//\u5173\u7cfb\u8fd0\u7b97\u7b26IN/NOT IN
	|	( "in"
		  {#equation = #([LOGICAL_IN, "logic_in"], #equation);}
		| "not" "in"
		  {#equation = #([LOGICAL_NOT_IN, "logic_not_in"], #equation);}
		| "\u5728\u4e8e"^ | "\u4e0d\u5728\u4e8e"^
		) exp_set
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
	|	date_key_word
	|	"null"
	;

function
	:	function_name LPAREN! parameters RPAREN!
	{#function = #([FUNCTION, "function_block"], #function);}
	|	empty_function LPAREN! RPAREN!
	{#function = #([FUNCTION_EMPTY_PARAM, "function_empty_param"], #function);}
	|	star_function LPAREN! STAR! RPAREN!
	{#function = #([FUNCTION_STAR_PARAM, "function_star_param"], #function);}
	;

aggregate_func
	:	("\u6c42\u8bb0\u5f55\u603b\u6570"^ | "count"^) LPAREN! STAR! RPAREN!
		{#aggregate_func = #([FUNCTION_STAR_COUNT, "function_star_count"], #aggregate_func);}
	|	aggregate_func_name LPAREN! ("all"^ | "\u5168\u90e8"^ | "distinct"^ |"\u552f\u4e00"^)? parameters RPAREN!
	;

parameters
	:	expression (COMMA^ expression)*
	;
table_name
	:	ID (("as"^|"\u4f5c\u4e3a"^) alias)?
	;

aggregate_func_name
	:	"sum" 	| "\u6c42\u548c"
	|	"avg" 	| "\u6c42\u5e73\u5747\u6570"
	|	"max" 	| "\u6c42\u6700\u5927\u503c"
	|	"min" 	| "\u6c42\u6700\u5c0f\u503c"
	|	"count" | "\u6c42\u8bb0\u5f55\u603b\u6570"
	|	"stddev"
	|	"variance"
	;

//function_name
//	:	"sqrt" 		| 	"\u6c42\u5e73\u65b9\u6839"
//	|	"getdate" 	| 	"\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
//	|	"abs" 		| 	"\u53d6\u7edd\u5bf9\u503c"
//	|	"acos"		|	"\u6c42\u4f59\u5f26\u503c"
//	|	"substring" | 	"\u5b57\u7b26\u4e32\u622a\u53d6"
//	|	"round"		|	"\u683c\u5f0f\u5316\u6570\u503c"
//	|	"right" 	| 	"\u5b57\u7b26\u4e32\u53f3\u622a"
//	|	"ltrim"		|	"\u53bb\u6389\u5de6\u7a7a\u683c"
//	|	"rtrim"		|	"\u53bb\u6389\u53f3\u7a7a\u683c"
//	|	"char_length" | "\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6"
//	|	"floor"		|	"\u6c42\u56db\u820d\u540e\u7684\u6574\u6570"
//	|	"ceiling"	|	"\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570"
//	|	"lower" 	| 	"\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199"
//	|	"charindex"	|	"\u5b58\u5728\u4e8e"
//	|	"str" 		| 	"\u6570\u503c\u8f6c\u5b57\u7b26\u4e32"
//	;

function_name
	:
	|	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

empty_function
	: "getdate" | "\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	;

star_function
	:  	"pi"	|	"\u6c42PI"
	|	"now"	|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	|	"today"	|	"\u53d6\u5f53\u524d\u65e5\u671f"	
	;

number_function
	:	"abs" 		| 	"\u53d6\u7edd\u5bf9\u503c"
	|	"acos"		|	"\u6c42\u503c\u7684\u4f59\u5f26\u89d2"
	|	"asin"		|	"\u6c42\u503c\u7684\u6b63\u5f26\u89d2"
	|	"atan"		|	"\u6c42\u503c\u7684\u6b63\u5207\u89d2"
	|	"atin2"		|	"\u6c42\u503c\u7684\u6b63\u5f26\u548c\u4f59\u5f26\u89d2"
	|	"ceiling"	|	"\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570"
	|	"cos"		|	"\u6c42\u89d2\u7684\u4f59\u5f26\u503c"
	|	"cot"		|	"\u6c42\u89d2\u7684\u4f59\u5207\u503c"
	|	"degrees"	|	"\u6c42\u5f27\u5ea6\u6570\u7684\u89d2\u5927\u5c0f"
	|	"exp"		|	"\u6c42\u5e42\u503c"
	|	"floor"		|	"\u6c42\u56db\u820d\u540e\u7684\u6574\u6570"
	|	"log"		|	"\u6c42\u81ea\u7136\u5bf9\u6570"
	|	"log10"		|	"\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570"
	|	"mod"		|	"\u6c42\u4f59"
//	|	"pi"		|	"\u6c42PI"
	|	"power"		|	"\u6c42\u6570\u5b57\u7684\u6b21\u5e42\u503c"
	|	"radians"	|	"\u6c42\u5ea6\u6570\u89d2\u7684\u5f27\u5ea6"
	|	"rand"		|	"\u6c420\u548c1\u95f4\u7684\u968f\u673a\u6570"
	|	"remaiindex"
	|	"round"		|	"\u683c\u5f0f\u5316\u6570\u503c"
	|	"sign"		|	"\u6c42\u503c\u7684\u7b26\u53f7"
	|	"sin"		|	"\u6c42\u89d2\u7684\u6b63\u5f26\u503c"
	|	"sqrt" 		| 	"\u6c42\u5e73\u65b9\u6839"
	|	"tan"		|	"\u6c42\u89d2\u7684\u6b63\u5207\u503c"
	|	"truncnum"
	;

string_function
	:	"ascii"		|	"\u6c42\u7b2c\u4e00\u4e2a\u5b57\u7b26\u7684ASCII\u7801"
	|	"bit_length"
	|	"byte_length"
	|	"char"		|	"\u6c42\u7b49\u503c\u7684\u5b57\u7b26"
	|	"char_length" | "\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6"
	|	"charindex"	|	"\u5b58\u5728\u4e8e"
	|	"difference"  |	"\u6c42\u4e24\u4e2a\u4e32\u7684\u5dee\u503c"
	|	"insertstr"
	|	"lcase"
	|	"left"		|	"\u5b57\u7b26\u4e32\u5de6\u622a"
	|	"length"	|	"\u6c42\u5b57\u7b26\u4e32\u603b\u957f\u5ea6"
	|	"locate"
	|	"lower" 	| 	"\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199"
	|	"ltrim"		|	"\u53bb\u6389\u5de6\u7a7a\u683c"
	|	"octet_length"
	|	"patindex"	|	"\u6c42\u7b2c\u4e00\u6b21\u51fa\u73b0\u4f4d\u7f6e"
	|	"repeat"
	|	"replace"	|	"\u5b57\u7b26\u4e32\u66ff\u6362"
	|	"replicate"
	|	"right"		|	"\u5b57\u7b26\u4e32\u53f3\u622a"
	|	"rtrim"		|	"\u53bb\u6389\u53f3\u7a7a\u683c"
	|	"similar"
	|	"sortkey"
	|	"soundex"
	|	"space"
	|	"str"		|	"\u6570\u503c\u8f6c\u5b57\u7b26\u4e32"
	|	"string"
	|	"stuff"
	|	"substring"	|	"\u5b57\u7b26\u4e32\u622a\u53d6"
	|	"trim"
	|	"ucase"
	|	"upper"		|	"\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5927\u5199"
	;

datetime_function
	:	"dateformat" |	"\u683c\u5f0f\u5316\u65e5\u671f"
	|	"datename"	|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c"
	|	"datepart"	|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u6574\u6570\u503c"
	|	"datetime"	|	"\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4"
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
//	|	"now"		|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	|	"quarter"
	|	"seconds"
	|	"second"
//	|	"today"		|	"\u53d6\u5f53\u524d\u65e5\u671f"
	|	"weeks"
	|	"week"
	|	"years"
	|	"year"
	|	"ymd"
//	|	"getdate"	|	"\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	|	"dateadd"	|	"\u65e5\u671f\u76f8\u52a0"
	|	"datediff"	|	"\u65e5\u671f\u76f8\u51cf"
	;

conversion_function
	:	"convert"	|	"\u5b57\u7b26\u8f6c\u4e3a\u65e5\u671f"
	|	"cast"
	|	"hextoint"	|	"\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570"
	|	"inttohex"	|	"\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236"
	|	"isdate"	|	"\u4e3a\u65e5\u671f\u578b"
	|	"isnumeric"	|	"\u4e3a\u6570\u503c\u578b"
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

one_arg_op
	:	ONE_ARG_OP;

two_arg_op
	:	TWO_ARG_OP | STAR | MINUS
	|	"\u4e0e" | "\u6216" | "\u5f02\u6216" | "\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u6c42\u6a21";

compare_op
	:	COMPARE_OP
	|	"\u7b49\u4e8e" | "\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	|	"\u5305\u542b" | "\u4e0d\u5305\u542b" | "like"
	|	"\u5de6\u8fde\u63a5"	| LEFT_JOIN
	;

logic_op
	:	"and" | "or" | "\u5e76\u4e14" | "\u6216\u8005";

comparemethod_name
	:	"exists" | "\u5b58\u5728" | "\u4e0d\u5b58\u5728";

//\u65e5\u671fdate-part\u4fdd\u7559\u5b57
date_key_word
	: "year" | "yy" | "month" | "mm" | "day" | "dd"
	| "quarter" | "qq" | "week" | "wk" | "dayofyear" | "dy"
	| "weekday" | "dw" | "hour" | "hh" | "minute" | "mi" | "second" | "ss" | "millisecond" | "ms"
	| "calweekofyear" | "cwk" | "calyearofweek" | "cyr" | "caldayofweek" | "cdw"
	;


/*==========================================================//
//															//
//						Lexer Define						//
//															//
//==========================================================*/
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
LEFT_JOIN
	: "*=";

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

/*==========================================================//
//															//
//					TreeParser Define						//
//															//
//==========================================================*/	
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
	TableListModel t1;
	SearchConditionModel cond;
}
		//\u8868\u5408\u5e76\u8bed\u53e5
	:	#("\u8868\u5408\u5e76" t1=tableUnionList)
		{
			union.addTableListModel(t1);
			model = union;
		}

		//\u8868\u6bd4\u8f83\u8bed\u53e5
	|	#("\u8868\u6bd4\u8f83" tableModel1=table_name tableModel2=table_name method=compare_method cond=search_condition)
		{	
			tableCompare.addTableModel1(tableModel1);
			tableCompare.addTableModel2(tableModel2);
			tableCompare.setCompareMethod(method);
			tableCompare.setSearchCondition(cond);
			model = tableCompare;
		}
		//\u81ea\u5b9a\u4e49\u67e5\u8be2\u8bed\u53e5
	|	#(SELECT_STATEMENT model=select_statement)
	;

tableUnionList returns [TableListModel model]
{
	model = new TableListModel();
	TableModel t;
	TableListModel m1, m2;
	
}
	: 	#(COMMA m1=tableUnionList m2=tableUnionList)
		{model.addChild(m1); model.addChild(m2);}
	|	t = table_name
		{model.addTable(t);}
	;


compare_method returns [String rValue]
{rValue = "";}
	:	v1: comparemethod_name
		{rValue = v1.getText();}
	|	#(LOGICAL_NOT_EXISTS "not" "exists")
		{rValue = "not exists";}
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
	:	#("\u552f\u4e00" select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#("distinct" select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#("\u67e5\u8be2" sl=select_list)
	{model.setSelectList(sl);}
	|	#("select" sl=select_list)
	{model.setSelectList(sl);}
	|	#("\u6765\u81ea" s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#("from" s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#("\u6761\u4ef6" s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#("where" s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#("\u5206\u7ec4" s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#("group" s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#("\u6392\u5e8f" s=select_statement order=order_expression_list)
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
	|	#(o3:"\u5e76\u4e14" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);}
	|	#(o4:"\u6216\u8005" m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);}

	|	#(LOGIC_BLOCK m3=search_condition)
	{model.addOperator("("); model.addChild(m3); model.addOperator(")");}

	|	#(SEARCH_NOT_CONDITION o11:"not" m4=search_condition)
	{model.addOperator(o11.getText()); model.addChild(m4);}
	|	#(o12:"\u975e" m5=search_condition)
	{model.addOperator(o12.getText()); model.addChild(m5);}
//	|	#(o11:"not" m4=search_condition)
//	{model.addOperator(o11.getText()); model.addChild(m4);}
//	|	#(o12:"\u975e" m5=search_condition)
//	{model.addOperator(o12.getText()); model.addChild(m5);}

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
	|	#("\u4f5c\u4e3a" e=expression a=alias)
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
	String nullStr = "";
}
	:	#(COMPARE_OP e1=expression op:compare_op e2=expression)
	{model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);}
	
	|	#(LOGICAL_NOT_LIKE e1=expression "not" "like" e2=expression)
	{model.addExpression(e1); model.addOperator("not like"); model.addExpression(e2);}
	
	|	#(LOGICAL_NULL e1=expression "is" "null")
	{model.addExpression(e1); model.addOperator("is null");}
	|	#(n:"\u4e3a\u7a7a" e1=expression)
	{model.addExpression(e1); model.addOperator(n.getText());}
	|	#(LOGICAL_NOT_NULL e1=expression "is" "not" "null")
	{model.addExpression(e1); model.addOperator("is not null");}
	|	#(nn:"\u975e\u7a7a" e1=expression)
	{model.addExpression(e1); model.addOperator(nn.getText());}

//	|	#(n:"\u4e3a\u7a7a" e1=expression)
//	{model.addExpression(e1); model.addOperator(n.getText());}
//	|	#("null" e1=expression)
//	{model.addExpression(e1); model.addOperator("is null");}
//	|	#(nn:"\u975e\u7a7a" e1=expression)
//	{model.addExpression(e1); model.addOperator(nn.getText());}
//	|	#(nn_en:"not" e1=expression)
//	{model.addExpression(e1); model.addOperator("is not null");}

	|	#("between" e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator("between");
	 model.addExpression(e2); model.addExpression(e3);}
	|	#(btw:"\u8303\u56f4" e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator(btw.getText());
	 model.addExpression(e2); model.addExpression(e3);
	}
	
	|	#(LOGICAL_IN e1=expression "in" e2=exp_set)
	{model.addExpression(e1); model.addOperator("in"); model.addExpression(e2);}
	|	#(ct1:"\u5728\u4e8e" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);}
	|	#(LOGICAL_NOT_IN e1=expression "not" "in" e2=exp_set)
	{model.addExpression(e1); model.addOperator("not in"); model.addExpression(e2);}
	|	#(ct2:"\u4e0d\u5728\u4e8e" e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);}

//	|	#("in" e1=expression e2=exp_set)
//	{model.addExpression(e1); model.addOperator("in"); model.addExpression(e2);}
//	|	#(ct1:"\u5728\u4e8e" e1=expression e2=exp_set)
//	{model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);}
//	|	#("not in" e1=expression e2=exp_set)
//	{model.addExpression(e1); model.addOperator("not in"); model.addExpression(e2);}
//	|	#(ct2:"\u4e0d\u5728\u4e8e" e1=expression e2=exp_set)
//	{model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);}

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
	|	#("\u5347\u5e8f" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.ASC);}
	|	#("desc" o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.DESC);}
	|	#("\u964d\u5e8f" o=order_expression)
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
	|	dkw:date_key_word
	{model.addConstant(dkw.getText());}
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
{
	model=null;
	ParametersModel p; 
	ExpressionModel express1 = new ExpressionModel();
}
	:	//Aggregate functions\u805a\u5408\u51fd\u6570
		af:aggregate_func_name p=parameters
		{
			model = new AggregateFuncModel(af.getText(), AggregateFuncModel.NO_FILTER); 
			model.setParameters(p);
		}
		
		//Normal functions\u666e\u901a\u51fd\u6570
//	|	f:function_name p=parameters
	|	#(FUNCTION f:function_name p=parameters)
		{
			model = new FunctionModel(f.getText());
			model.setParameters(p);
		}
		
		//Normal functions\u53c2\u6570\u4e3a\u7a7a\u7684\u666e\u901a\u51fd\u6570[getdate()]
	|	#(FUNCTION_EMPTY_PARAM fun1:function_name)
		{
			model = new FunctionModel(fun1.getText());
		}
		
		//Normal functions\u53c2\u6570\u4e3a*\u7684\u666e\u901a\u51fd\u6570[now(*)...]
	|	#(FUNCTION_STAR_PARAM funStar:function_name)
		{
			model = new FunctionModel(funStar.getText());
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}
		
		//Aggregate functions\u53c2\u6570\u4e3a*\u7684COUNT\u51fd\u6570\uff0c\u805a\u5408\u51fd\u6570[count(*)]
	|	#(FUNCTION_STAR_COUNT fun2:function_name)
		{	
			model = new AggregateFuncModel(fun2.getText(), AggregateFuncModel.NO_FILTER);
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}
		
		//Aggregate functions\u53c2\u6570\u4e3a\u5168\u90e8\u3001all\u7684\u805a\u5408\u51fd\u6570
	|	#(all:"\u5168\u90e8" af11:function_name p=parameters)
		{
			model = new AggregateFuncModel(af11.getText(), AggregateFuncModel.ALL);
			model.setParameters(p);
		}
	|	#("all" af12:function_name p=parameters)
		{
			model = new AggregateFuncModel(af12.getText(), AggregateFuncModel.ALL);
			model.setParameters(p);
		}
		
		//Aggregate functions\u53c2\u6570\u4e3a\u552f\u4e00\u3001distinct\u7684\u805a\u5408\u51fd\u6570
	|	#(dist:"\u552f\u4e00" af21:function_name p=parameters)
		{
			model = new AggregateFuncModel(af21.getText(), AggregateFuncModel.DISTINCT);
			model.setParameters(p);
		}
	|	#("distinct" af22:function_name p=parameters)
		{
			model=new AggregateFuncModel(af22.getText(), AggregateFuncModel.DISTINCT);
			model.setParameters(p);
		}
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
//	|	#("\u4f5c\u4e3a" t2:ID a = alias)
//	{model = new TableModel(t2.getText()); model.setAlias(a);}
	|	#("as" t1:ID ta = tableAlias)
	{model = new TableModel(t1.getText()); model.setAlias(ta);}
	|	#("\u4f5c\u4e3a" t2:ID ta = tableAlias)
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
// \u5e38\u91cf
select : "\u67e5\u8be2" | "select";

distinct : "\u552f\u4e00" | "distinct";

logic_op : "and" | "or" | "\u5e76\u4e14" | "\u6216\u8005";

compare_op
	:	COMPARE_OP
	| "\u7b49\u4e8e" | "\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	| "\u5305\u542b" | "\u4e0d\u5305\u542b" | "like"
	| "\u5de6\u8fde\u63a5" | LEFT_JOIN
	;

one_arg_op
	:	ONE_ARG_OP;

two_arg_op
	:	TWO_ARG_OP | STAR | MINUS
	|	"\u4e0e" | "\u6216" | "\u5f02\u6216" | "\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u6c42\u6a21";

//\u6bd4\u8f83\u8fd0\u7b97\u7b26
comparemethod_name
	:	"exists" | "\u5b58\u5728" | "\u4e0d\u5b58\u5728"
	;

//\u65e5\u671fdate-part\u4fdd\u7559\u5b57
date_key_word
	: "year" | "yy" | "month" | "mm" | "day" | "dd"
	| "quarter" | "qq" | "week" | "wk" | "dayofyear" | "dy"
	| "weekday" | "dw" | "hour" | "hh" | "minute" | "mi" | "second" | "ss" | "millisecond" | "ms"
	| "calweekofyear" | "cwk" | "calyearofweek" | "cyr" | "caldayofweek" | "cdw"
	;

function_name
	:	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

aggregate_func_name
	:	"sum" 	| "\u6c42\u548c"
	|	"avg" 	| "\u6c42\u5e73\u5747\u6570"
	|	"max" 	| "\u6c42\u6700\u5927\u503c"
	|	"min" 	| "\u6c42\u6700\u5c0f\u503c"
	|	"count" | "\u6c42\u8bb0\u5f55\u603b\u6570"
	|	"stddev"
	|	"variance"
	;

number_function
	:	"abs" 		| 	"\u53d6\u7edd\u5bf9\u503c"
	|	"acos"		|	"\u6c42\u503c\u7684\u4f59\u5f26\u89d2"
	|	"asin"		|	"\u6c42\u503c\u7684\u6b63\u5f26\u89d2"
	|	"atan"		|	"\u6c42\u503c\u7684\u6b63\u5207\u89d2"
	|	"atin2"		|	"\u6c42\u503c\u7684\u6b63\u5f26\u548c\u4f59\u5f26\u89d2"
	|	"ceiling"	|	"\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570"
	|	"cos"		|	"\u6c42\u89d2\u7684\u4f59\u5f26\u503c"
	|	"cot"		|	"\u6c42\u89d2\u7684\u4f59\u5207\u503c"
	|	"degrees"	|	"\u6c42\u5f27\u5ea6\u6570\u7684\u89d2\u5927\u5c0f"
	|	"exp"		|	"\u6c42\u5e42\u503c"
	|	"floor"		|	"\u6c42\u56db\u820d\u540e\u7684\u6574\u6570"
	|	"log"		|	"\u6c42\u81ea\u7136\u5bf9\u6570"
	|	"log10"		|	"\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570"
	|	"mod"		|	"\u6c42\u4f59"
	|	"pi"		|	"\u6c42PI"
	|	"power"		|	"\u6c42\u6570\u5b57\u7684\u6b21\u5e42\u503c"
	|	"radians"	|	"\u6c42\u5ea6\u6570\u89d2\u7684\u5f27\u5ea6"
	|	"rand"		|	"\u6c420\u548c1\u95f4\u7684\u968f\u673a\u6570"
	|	"round"		|	"\u683c\u5f0f\u5316\u6570\u503c"
	|	"sign"		|	"\u6c42\u503c\u7684\u7b26\u53f7"
	|	"sin"		|	"\u6c42\u89d2\u7684\u6b63\u5f26\u503c"
	|	"sqrt" 		| 	"\u6c42\u5e73\u65b9\u6839"
	|	"tan"		|	"\u6c42\u89d2\u7684\u6b63\u5207\u503c"
	;

string_function
	:	"ascii"		|	"\u6c42\u7b2c\u4e00\u4e2a\u5b57\u7b26\u7684ASCII\u7801"
	|	"char"		|	"\u6c42\u7b49\u503c\u7684\u5b57\u7b26"
	|	"char_length" | "\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6"
	|	"charindex"	|	"\u5b58\u5728\u4e8e"
	|	"difference"  |	"\u6c42\u4e24\u4e2a\u4e32\u7684\u5dee\u503c"
	|	"lcase"
	|	"left"		|	"\u5b57\u7b26\u4e32\u5de6\u622a"
	|	"length"	|	"\u6c42\u5b57\u7b26\u4e32\u603b\u957f\u5ea6"
	|	"lower" 	| 	"\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199"
	|	"ltrim"		|	"\u53bb\u6389\u5de6\u7a7a\u683c"
	|	"patindex"	|	"\u6c42\u7b2c\u4e00\u6b21\u51fa\u73b0\u4f4d\u7f6e"
	|	"replace"	|	"\u5b57\u7b26\u4e32\u66ff\u6362"
	|	"right"		|	"\u5b57\u7b26\u4e32\u53f3\u622a"
	|	"rtrim"		|	"\u53bb\u6389\u53f3\u7a7a\u683c"
	|	"str"		|	"\u6570\u503c\u8f6c\u5b57\u7b26\u4e32"
	|	"substring"	|	"\u5b57\u7b26\u4e32\u622a\u53d6"
	|	"upper"		|	"\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5927\u5199"
	;

datetime_function
	:	"dateformat" |	"\u683c\u5f0f\u5316\u65e5\u671f"
	|	"datename"	|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c"
	|	"datepart"	|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u6574\u6570\u503c"
	|	"datetime"	|	"\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4"
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
	|	"now"		|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	|	"quarter"
	|	"seconds"
	|	"second"
	|	"today"		|	"\u53d6\u5f53\u524d\u65e5\u671f"
	|	"weeks"
	|	"week"
	|	"years"
	|	"year"
	|	"getdate"	|	"\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4"
	|	"dateadd"	|	"\u65e5\u671f\u76f8\u52a0"
	|	"datediff"	|	"\u65e5\u671f\u76f8\u51cf"
	;

conversion_function
	:	"cast"
	|	"convert"	|	"\u5b57\u7b26\u8f6c\u4e3a\u65e5\u671f"
	|	"hextoint"	|	"\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570"
	|	"inttohex"	|	"\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236"
	|	"isdate"	|	"\u4e3a\u65e5\u671f\u578b"
	|	"isnumeric"	|	"\u4e3a\u6570\u503c\u578b"
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
