/*==========================================================
//	LongtopParser Of Oracle
// 	oracle8i/oracle9i SQL Grammar
//
//	http://www.longtop.com
//
//  Recent updates by jiandeh@sina.com
//
//	\u4fee\u6539\u65e5\u5fd7:
//	========================================================
//	05/31/2007:
//		- \u5c06\u8bed\u6cd5\u5b9a\u4e49\u7684\u5173\u952e\u5b57\u653e\u5728\u8bcd\u6cd5\u7684tokens\u4e2d,\u8bed\u6cd5\u5b9a\u4e49\u4e2d\u4e0d\u518d\u51fa\u73b0
//		  \u81ea\u5df1\u5b9a\u4e49\u5173\u952e\u5b57
//		- \u5728\u64cd\u4f5c\u7b26\u53ca\u51fd\u6570\u653e\u5165\u5bf9\u5e94Model\u65f6\u5c06\u82f1\u6587\u8f6c\u5316\u6210\u4e2d\u6587,\u7edf\u4e00\u683c\u5f0f\u5316
//		- aggregate_expr\u8bed\u6cd5\u589e\u52a0\u5bf9()\u7684\u8bc6\u522b,\u5e76\u589e\u52a0\u5e38\u91cf\u7684\u5b9a\u4e49,\u4f7f
//		  abs(-900) + 500\u7684\u8bed\u53e5\u53ef\u9a8c\u8bc1
//
//==========================================================*/

header {
	package parser.oracle;
}

/*==========================================================
//
//					Parser Define
//
//==========================================================*/
class Oracle9iParser extends Parser;

options {
	k=5;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {	
	SELECT_STATEMENT;		//\u5b8c\u6574\u67e5\u8be2\u8bed\u53e5 TOKEN
	SEARCH_NOT_CONDITION;	//\u975e\u6574\u4e2a\u6761\u4ef6 TOKEN
	SUBQUERY;				//\u5b50\u67e5\u8be2 TOKEN
	GROUP_BY;				//\u5206\u7ec4 TOKEN
	ORDER_BY;				//\u6392\u5e8f TOKEN
	ALIAS_EQU;				//\u522b\u540d TOKEN
	
	FUNCTION;				//\u666e\u901a\u51fd\u6570 TOKEN
	FUNCTION_EMPTY_PARAM;	//\u7a7a\u53c2\u6570\u51fd\u6570 TOKEN [getdate()]
	FUNCTION_STAR_PARAM;	//\u53c2\u6570\u4e3a*\u51fd\u6570 TOKEN [now(*);today(*)]
	FUNCTION_STAR_COUNT;	//\u51fd\u6570COUNT(*) TOKEN
	
	FUNCTION_DATA_TYPE;		//\u5e26\u6570\u636e\u7c7b\u578b\u7684\u51fd\u6570 TOKEN
	FUNCTION_AS_DATA_TYPE;	//\u5e26AS\u53ca\u6570\u636e\u7c7b\u578b\u7684\u51fd\u6570 TOKEN

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
	PAREN_FIELD;			//\u5e26\u62ec\u53f7\u7684\u5b57\u6bb5[\u5229\u7387(\u767e\u5206\u6bd4%)] TOKEN
	PAREN_DATA_TYPE;		//\u5e26\u62ec\u53f7\u7684\u6570\u636e\u7c7b\u578b TOKEN
	PAREN_CHAR_DATA_TYPE;	//\u5e26\u62ec\u53f7\u7684\u4fdd\u7559\u5b57char\u6570\u636e\u7c7b\u578b TOKEN
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

//\u8868\u5408\u5e76
tableUnion
	:	(TABLE_UNION_EN^|TABLE_UNION_CN^) table_lists
	;

table_lists
	:	table_name (COMMA^ table_name)+
	;

//\u8868\u6bd4\u8f83
tableCompare
	:	(TABLE_COMPARE_EN^|TABLE_COMPARE_CN^) table_name COMMA! table_name (WHERE_EN!|WHERE_CN!) compare_method search_condition
	;

compare_method
	:	(EXISTS_EN | EXISTS_CN | NOT_EXISTS_CN)
	|	NOT_EN EXISTS_EN
		{#compare_method = #([LOGICAL_NOT_EXISTS, "logic_not_exists"], compare_method);}
	;

//\u81ea\u5b9a\u4e49\u67e5\u8be2
select_statement
	:	
		//CUSTOM SQL Sentence
		(SELECT_EN^ | SELECT_CN^) (DISTINCT_EN^ | DISTINCT_CN^)? select_list
		((FROM_EN^ | FROM_CN^) table_list)?
		((WHERE_EN^ | WHERE_CN^)search_condition)?
		((GROUP_EN^ BY_EN! | GROUP_BY_CN^) aggregate_expression_list)?
		((ORDER_EN^ BY_EN! | ORDER_BY_CN^) order_expression_list)?
	;

select_list
	:	column (COMMA^ column)*
	;

table_list
	:	table_name (COMMA^ table_name)*
	;

search_condition
	:	bool_exp
	|	( NOT_EN
		{#search_condition = #([SEARCH_NOT_CONDITION, "search_not_condition"], search_condition);}
		| NOT_CN^
		) search_condition
	;

bool_exp
	:	bool_term 
		((AND_EN^ | OR_EN^ | AND_CN^ | OR_CN^) bool_term)*
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
	:	expression_with_aggr_func ((AS_EN^|AS_CN^) alias)?
	|	alias ("="|"\u7b49\u4e8e")! expression_with_aggr_func {#column=#([ALIAS_EQU, "="], #column);}
	|	all: SELECT_ALL_CN {#column=#([ALL_FIELDS, all.getText()]);}
	|	STAR {#column=#([ALL_FIELDS, "*"]);}
	;

aggregate_expr
	:	LPAREN aggregate_expr RPAREN
	|	(field_name|function|constant) (
		two_arg_op aggregate_expr {#aggregate_expr=#([TWO_ARG_OP, "two_arg_op"], #aggregate_expr);})?
	;

order_expression
	:	(alias|field_name|aggregate_func|function) (ASC_EN^|ASC_CN^|DESC_EN^|DESC_CN^)?
	;

expression
	:	LPAREN expression RPAREN
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	|	one_arg_op expression {#expression=#([ONE_ARG_OP, "one_arg_op"], #expression);}
	|	(field_name|constant|function|param_equ)
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	;

expression_with_aggr_func
	:	
		LPAREN expression_with_aggr_func RPAREN 
		(two_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([TWO_ARG_OP, "two_arg_op"], #expression_with_aggr_func);})?
	|	one_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([ONE_ARG_OP, "one_arg_op"], #expression_with_aggr_func);}
	|	(field_name|constant|function|aggregate_func) 
		(two_arg_op expression_with_aggr_func 
		{#expression_with_aggr_func=#([TWO_ARG_OP, "two_arg_op"], #expression_with_aggr_func);})?
	;

equation
	:	expression (
		
		//\u7b97\u672f\u8fd0\u7b97\u7b26(+ - * /) \u8868\u8fbe\u5f0f
		(compare_op) expression
	  	{#equation=#([COMPARE_OP, "comp_op"], #equation);}
	  	
		//\u903b\u8f91\u8fd0\u7b97\u7b26LIKE/NOT LIKE \u8868\u8fbe\u5f0f
	|	(LIKE_EN) expression
		{#equation=#([LOGICAL_LIKE, "logic_like"], #equation);}	
	|	(NOT_EN LIKE_EN) expression
		{#equation=#([LOGICAL_NOT_LIKE, "logic_not_like"], #equation);}	
	|	(LIKE_CN^|NOT_LIKE_CN^) expression

		//\u903b\u8f91\u8fd0\u7b97\u7b26IS NULL/IS NOT NULL
	|	( IS_EN NULL_EN
		  {#equation = #([LOGICAL_NULL, "logic_null"], #equation);}
		| IS_EN NOT_EN NULL_EN
		  {#equation = #([LOGICAL_NOT_NULL, "logic_not_null"], #equation);}
		| NULL_CN^ | NOT_NULL_CN^
		)
	
		//\u903b\u8f91\u8fd0\u7b97\u7b26BETWEEN AND
	| 	BETWEEN_CN^ expression expression
	|	BETWEEN_EN^ expression AND_EN! expression
	
		//\u5173\u7cfb\u8fd0\u7b97\u7b26IN/NOT IN
	|	( IN_EN
		  {#equation = #([LOGICAL_IN, "logic_in"], #equation);}
		| NOT_EN IN_EN
		  {#equation = #([LOGICAL_NOT_IN, "logic_not_in"], #equation);}
		| IN_CN^ | NOT_IN_CN^
		) exp_set
	)
	;

function
	:	empty_function LPAREN! RPAREN!
	{#function = #([FUNCTION_EMPTY_PARAM, "function_empty_param"], #function);}
	|	star_function LPAREN! STAR! RPAREN!
	{#function = #([FUNCTION_STAR_PARAM, "function_star_param"], #function);}
	|	datatype_function LPAREN! data_type_parameter RPAREN!
	{#function = #([FUNCTION_DATA_TYPE, "function_data_type"], #function);}
	|	asdatatype_function LPAREN! as_data_type_parameter RPAREN!
	{#function = #([FUNCTION_AS_DATA_TYPE, "function_as_data_type"], #function);}
	|	function_name LPAREN! parameters RPAREN!
	{#function = #([FUNCTION, "function_block"], #function);}
	;

aggregate_func
	:	(COUNT_EN | COUNT_CN) LPAREN! STAR! RPAREN!
		{#aggregate_func = #([FUNCTION_STAR_COUNT, "function_star_count"], #aggregate_func);}
	|	aggregate_func_name LPAREN! (ALL_EN^ | ALL_CN^ | DISTINCT_EN^ | DISTINCT_CN^)? parameters RPAREN!
	;

parameters
	:	expression (COMMA^ expression)*
	;

//==========\u6570\u636e\u7c7b\u578b\u53c2\u6570 BEGIN==========//
as_data_type_parameter
	: expression (AS_EN! | DATA_TYPE_AS_CN!) (datatype_constant)
	;

data_type_parameter
	:	datatype_constant (COMMA^ expression)+
	;

datatype_constant
	:	//"character" "varying"
		data_type_word
	|	CHAR
	|	CHAR LPAREN! datatype_precision_or_scale_or_maxlength RPAREN!
		{#datatype_constant = #([PAREN_CHAR_DATA_TYPE, "paren_char_data_type"], #datatype_constant);}
	|	DATA_TYPE_STRING LPAREN! datatype_precision_or_scale_or_maxlength RPAREN!
		{#datatype_constant = #([PAREN_DATA_TYPE, "paren_data_type"], #datatype_constant);}
	|	DATA_TYPE_STRING
	;

datatype_precision_or_scale_or_maxlength
	:	REAL_NUM COMMA^ REAL_NUM
	|	REAL_NUM
	;

//==========\u6570\u636e\u7c7b\u578b\u53c2\u6570  END===========//


table_name
	:	ID ((AS_EN^ | AS_CN^) alias)?
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
	:	ID POINT^ sfield_name
	;	
//field_name
//	:	ID POINT^ ID
//	;

sfield_name
	:	//\u5982\uff1a\u5229\u7387(\u767e\u5206\u6bd4%)
		ID LPAREN! ID RPAREN!
		{#sfield_name = #([PAREN_FIELD, "paren_field"], #sfield_name);}
	|	ID
	;

constant
	:	REAL_NUM
	|	NEGATIVE_DIGIT_ELEMENT
	|	QUOTED_STRING
	|	date_key_word
	|	NULL_EN
	;

//=======================================//
//\u805a\u5408\u51fd\u6570
aggregate_func_name
	:	"avg" 		| 	"\u6c42\u5e73\u5747\u6570"
//	|	"count" 	| 	"\u6c42\u8bb0\u5f55\u603b\u6570"
	|	COUNT_EN	|	COUNT_CN
	|	"max" 		| 	"\u6c42\u6700\u5927\u503c"
	|	"min" 		| 	"\u6c42\u6700\u5c0f\u503c"
	|	"stddev" 	| 	"\u6c42\u65b9\u5dee"
	|	"sum" 		|	"\u6c42\u603b\u548c"
	|	"variance" 	| 	"\u6c42\u7edf\u8ba1\u65b9\u5dee"
	;

//\u7a7a\u53c2\u6570\u51fd\u6570
empty_function
	: 	"getdate"	| 	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f42"
	|	"rand"		|	"\u53d6\u968f\u673a\u6570"
	;

//\u53c2\u6570\u4e3a*\u51fd\u6570\u3001
star_function
	:  	"pi"	|	"\u6c42\u5706\u5468\u7387"
	|	"now"	|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f41"
	|	"today"	|	"\u6c42\u5f53\u524d\u65e5\u671f"
	;

//\u5e26\u6570\u636e\u7c7b\u578b\u51fd\u6570
datatype_function
	:	"convert"	|	"\u6570\u636e\u7c7b\u578b\u8f6c\u6362"
	;

//\u5e26\u6570\u636e\u7c7b\u578b\u51fd\u6570
asdatatype_function
	:	"cast"		|	"\u6570\u636e\u7c7b\u578b\u8f6c\u5316"
	;

//\u666e\u901a\u51fd\u6570(\u6570\u5b66\u51fd\u6570\u3001\u5b57\u7b26\u4e32\u51fd\u6570\u3001\u65e5\u671f\u65f6\u95f4\u51fd\u6570\u3001\u7cfb\u7edf\u51fd\u6570\u3001\u6570\u636e\u7c7b\u578b\u8f6c\u5316\u51fd\u6570\u3001\u5176\u4ed6\u51fd\u6570)
function_name
	:
	|	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

//\u6570\u5b66\u51fd\u6570
number_function
	:	"abs" 			| 	"\u53d6\u7edd\u5bf9\u503c"
	|	"acos"			|	"\u6c42\u53cd\u4f59\u5f26\u503c"
	|	"asin"			|	"\u6c42\u53cd\u6b63\u5f26\u503c"
	|	"atan"			|	"\u6c42\u53cd\u6b63\u5207\u503c"
	
	|	"atin2"		|	"\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c"
	|	"ceil"	|	"\u53d6\u4e0a\u9650\u6574\u6570"
	|	"cos"		|	"\u6c42\u4f59\u5f26\u503c"
	|	"cot"		|	"\u6c42\u4f59\u5207\u503c"
	|	"degrees"	|	"\u5f27\u5ea6\u8f6c\u5ea6\u6570"
	|	"exp"		|	"\u6c42\u5e42\u503c"
	|	"floor"		|	"\u53d6\u4e0b\u9650\u6574\u6570"
	|	"log"		|	"\u6c42\u81ea\u7136\u5bf9\u6570"
	|	"log10"		|	"\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570"
	|	"mod"		|	"\u6c42\u6a21"
//	|	"pi"		|	"\u6c42\u5706\u5468\u7387"
	|	"power"		|	"\u6c42\u5e42"
	|	"radians"	|	"\u5ea6\u6570\u8f6c\u5f27\u5ea6"
	|	"rand"		|	"\u53d6\u968f\u673a\u6570"
	|	"remainder"	|	"\u6c42\u6a212"
	|	"round"		|	"\u683c\u5f0f\u5316\u6570\u503c"
	|	"sign"		|	"\u6c42\u503c\u7684\u7b26\u53f7"
	|	"sin"		|	"\u6c42\u6b63\u5f26\u503c"
	|	"sqrt" 		| 	"\u6c42\u5e73\u65b9\u6839"
	|	"tan"		|	"\u6c42\u6b63\u5207\u503c"
	|	"\u683c\u5f0f\u5316\u6570\u503c3"	//"\"truncate\""
	|	"truncnum"	|	"\u683c\u5f0f\u5316\u6570\u503c2"
	;

//\u5b57\u7b26\u4e32\u51fd\u6570
string_function
	:	"ascii"			|	"\u6c42ASCII\u7801"
	|	"asciistr"		|	"\u6c42\u5b57\u7b26\u4e32ASCII\u7801"
	|	"chartorowid"	|	"\u5b57\u7b26\u4e32\u8f6c\u6210ROWID"
	|	"chr"			|	"\u6c42\u7b49\u503c\u7684\u5b57\u7b26"
	|	"char_length" 	| 	"\u6c42\u5b57\u7b26\u4e32\u957f\u5ea61"
	|	"charindex" 	|	"\u5b58\u5728\u4e8e"
	|	"difference" 	|	"\u6c42\u4e24\u4e2a\u4e32\u7684\u58f0\u97f3\u5dee\u503c"
	|	"insertstr"		|	"\u63d2\u5165\u5b57\u7b26\u4e32"
	|	"lcase"			|	"\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd1"
	|	"left"			|	"\u5de6\u622a\u5b57\u7b26\u4e32"
	|	"length"		|	"\u6c42\u5b57\u7b26\u4e32\u957f\u5ea62"
	|	"locate"		|	"\u6c42\u4e32\u4f4d\u7f6e1"
	|	"lower" 		| 	"\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd2"
	|	"ltrim"			|	"\u53bb\u6389\u5de6\u7a7a\u683c"
	|	"octet_length"	|	"\u6c42\u5b57\u7b26\u4e32\u7684\u5b58\u50a8\u957f\u5ea6"
	|	"patindex"		|	"\u6c42\u4e32\u4f4d\u7f6e2"
	|	"repeat"		|	"\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a51"
	|	"replace"		|	"\u66ff\u6362\u5b57\u7b26\u4e32"
	|	"replicate"		|	"\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a52"
	|	"right"			|	"\u53f3\u622a\u5b57\u7b26\u4e32"
	|	"rtrim"			|	"\u53bb\u6389\u53f3\u7a7a\u683c"
	|	"similar"		|	"\u6c42\u5b57\u7b26\u4e32\u76f8\u4f3c\u5ea6"
	|	"sortkey"		|	"\u5b57\u7b26\u4e32\u6392\u5e8f"
	|	"soundex"		|	"\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c"
	|	"space"			|	"\u586b\u7a7a\u683c"
	|	"str"			|	"\u6570\u503c\u8f6c\u5b57\u7b26\u4e32"
	|	"string"		|	"\u5b57\u7b26\u4e32\u5408\u5e76"
	|	"stuff"			|	"\u5b57\u7b26\u4e32\u5220\u9664\u66ff\u6362"
	|	"substring"		|	"\u5b57\u7b26\u4e32\u622a\u53d6"
	|	"trim"			|	"\u53bb\u5de6\u53f3\u7a7a\u683c"
	|	"ucase"			|	"\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd1"
	|	"upper"			|	"\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd2"
	;

//\u65e5\u671f\u65f6\u95f4\u51fd\u6570
datetime_function
	:	"add_months"	|	"\u6708\u4efd\u8fd0\u7b97"
	|	"dateformat" 	|	"\u683c\u5f0f\u5316\u65e5\u671f"
	|	"datename"		|	"\u6c42\u65e5\u671f\u5206\u91cf\u82f1\u6587\u540d"
	|	"datepart"		|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c"
	|	"datetime"		|	"\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4"
	|	"date"			|	"\u8f6c\u4e3a\u65e5\u671f"
	|	"dayname"		|	"\u6c42\u661f\u671f\u82f1\u6587\u540d"
	|	"days"			|	"\u6c42\u5929\u6570"
	|	"day"			|	"\u6c42\u5177\u4f53\u65e5\u671f"
	|	"dow"			|	"\u6c42\u5177\u4f53\u661f\u671f"
	|	"hours"			|	"\u6c42\u5c0f\u65f6\u6570"
	|	"hour"			|	"\u6c42\u5177\u4f53\u5c0f\u65f6"
	|	"minutes"		|	"\u6c42\u5206\u949f\u6570"
	|	"minute"		|	"\u6c42\u5177\u4f53\u5206\u949f"
	|	"monthname"		|	"\u6c42\u6708\u4efd\u82f1\u6587\u540d"
	|	"months"		|	"\u6c42\u6708\u6570"
	|	"month"			|	"\u6c42\u5177\u4f53\u6708\u6570"
//	|	"now"			|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f41"
	|	"quarter"		|	"\u6c42\u5177\u4f53\u5b63\u5ea6"
	|	"seconds"		|	"\u6c42\u79d2\u6570"
	|	"second"		|	"\u6c42\u5177\u4f53\u79d2"
//	|	"today"			|	"\u6c42\u5f53\u524d\u65e5\u671f"
	|	"weeks"			|	"\u6c42\u5468\u6570"
	|	"years"			|	"\u6c42\u5e74\u6570"
	|	"year"			|	"\u6c42\u5177\u4f53\u5e74\u4efd"
	|	"ymd"			|	"\u6570\u503c\u8f6c\u65e5\u671f"
//	|	"getdate"		|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f42"
	|	"dateadd"		|	"\u65e5\u671f\u8fd0\u7b97"
	|	"datediff"		|	"\u6c42\u4e24\u65e5\u671f\u5dee\u503c"
	;

//\u6570\u636e\u7c7b\u578b\u8f6c\u5316\u51fd\u6570
conversion_function
	:	"bin_to_num"	|	"\u4e8c\u8fdb\u5236\u8f6c\u4e3a\u6570\u503c"
	|	"hextoint"	|	"\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570"
	|	"inttohex"	|	"\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236"
	|	"isdate"	|	"\u662f\u5426\u65e5\u671f\u578b"
	|	"isnumeric"	|	"\u662f\u5426\u6570\u503c\u578b"
//	|	"cast"		|	"\u6570\u636e\u7c7b\u578b\u8f6c\u5316"
//	|	"convert"	|	"\u6570\u636e\u7c7b\u578b\u8f6c\u6362"
	;

//\u7cfb\u7edf\u51fd\u6570
system_function
	:	"suser_id"
	|	"suser_name"
	|	"user_id"
	|	"user_name"
	;

//\u5176\u4ed6\u51fd\u6570
other_function
	:	"bitand"	| "\u4e0e\u8fd0\u7b97"
	|	"argn"
	| 	"rowid"
	;

one_arg_op
	: TILDE | "\u975e\u8fd0\u7b97";

two_arg_op
	:	arithmeticOperator | bitwiseOperator
	|	"\u4e0e" | "\u975e\u8fd0\u7b97" | "\u6216" | "\u5f02\u6216" | "\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u6c42\u6a21";

arithmeticOperator
    : PLUS | MINUS | STAR | DIVIDE | MOD
    ;

bitwiseOperator
    : AMPERSAND | TILDE | BITWISEOR | BITWISEXOR
    ;

alias_equ_op
	:	ASSIGNEQUAL | "\u7b49\u4e8e"
	;

compare_op
	:	comparisonOperator
	|	"\u7b49\u4e8e" | "\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	|	"\u5de6\u8fde\u63a5"	| LEFT_JOIN
	;

comparisonOperator
	:	ASSIGNEQUAL
	| 	NOTEQUAL1
	| 	NOTEQUAL2
	| 	LESSTHANOREQUALTO1
	| 	LESSTHANOREQUALTO2 
    | 	LESSTHAN
	| 	GREATERTHANOREQUALTO1
	| 	GREATERTHANOREQUALTO2
	| 	GREATERTHAN
	;

//\u65e5\u671fdate-part\u4fdd\u7559\u5b57
date_key_word
	: "year" | "yy" | "month" | "mm" | "day" | "dd"
	| "quarter" | "qq" | "week" | "wk" | "dayofyear" | "dy"
	| "weekday" | "dw" | "hour" | "hh" | "minute" | "mi" | "second" | "ss" | "millisecond" | "ms"
	| "calweekofyear" | "cwk" | "calyearofweek" | "cyr" | "caldayofweek" | "cdw"
	;

//\u6570\u636e\u7c7b\u578b\u4fdd\u7559\u5b57
data_type_word
	: "uniqueidentifierstr" 
	| "bigint" | "int" | "integer" | "smallint" | "tinyint" | "double" | "real"
	| "date" | "datetime" | "smalldatetime" | "time" | "timestamp"
	| "bit"
	;

/*==========================================================
//
//					   Lexer Define
//
//==========================================================*/
class Oracle9iLexer extends Lexer;

options {
	k=5;
	charVocabulary = '\u0000' .. '\uFFFE';
	testLiterals=false;
	caseSensitive = false;
	caseSensitiveLiterals = false;
}

tokens {
	TABLE_UNION_EN = "t_union";
	TABLE_UNION_CN = "\u8868\u5408\u5e76";
	
	TABLE_COMPARE_EN = "t_compare";
	TABLE_COMPARE_CN = "\u8868\u6bd4\u8f83";

	SELECT_EN = "select";
	SELECT_CN = "\u67e5\u8be2";

	FROM_EN = "from";
	FROM_CN = "\u6765\u81ea";

	WHERE_EN = "where";
	WHERE_CN = "\u6761\u4ef6";

	GROUP_EN = "group";
	GROUP_BY_CN = "\u5206\u7ec4";
	
	ORDER_EN = "order";
	ORDER_BY_CN = "\u6392\u5e8f";

	BY_EN = "by";
	
	ASC_EN = "asc";
	ASC_CN = "\u5347\u5e8f";

	DESC_EN = "desc";
	DESC_CN = "\u964d\u5e8f";	

	AND_EN = "and";
	AND_CN = "\u5e76\u4e14";
	
	OR_EN = "or";
	OR_CN = "\u6216\u8005";
	
	NOT_EN = "not";
	NOT_CN = "\u975e";
	
	ALL_EN = "all";
	ALL_CN = "\u5168\u90e8";
	
	SELECT_ALL_CN = "\u6240\u6709";

	DISTINCT_EN = "distinct";
	DISTINCT_CN = "\u552f\u4e00";

	EXISTS_EN = "exists";
	EXISTS_CN = "\u5b58\u5728";
	
	NOT_EXISTS_CN = "\u4e0d\u5b58\u5728";

	IN_EN = "in";
	IN_CN = "\u5728\u4e8e";
	
	NOT_IN_CN = "\u4e0d\u5728\u4e8e";

	IS_EN = "is";
	
	NULL_EN = "null";
	NULL_CN = "\u4e3a\u7a7a";
	
	NOT_NULL_CN = "\u975e\u7a7a";
	
	LIKE_EN = "like";
	LIKE_CN = "\u5305\u542b";
	
	NOT_LIKE_CN = "\u4e0d\u5305\u542b";
	
	BETWEEN_EN = "between";
	BETWEEN_CN = "\u8303\u56f4";
	
	AS_EN = "as";
	AS_CN = "\u4f5c\u4e3a";
	DATA_TYPE_AS_CN = "\u4e3a";
	
	CHAR = "char";

	COUNT_EN = "count";
	COUNT_CN = "\u6c42\u8bb0\u5f55\u603b\u6570";
}

PLUS	: '+' ;
MINUS 	: '-' ;
STAR 	: '*' ;
DIVIDE 	: '/' ;
MOD 	: '%' ;

AMPERSAND	: '&' ;
TILDE 		: '~' ;
BITWISEOR 	: '|' ;
BITWISEXOR 	: '^' ;
DOT_STAR 	: ".*";

//Comparison Operator
ASSIGNEQUAL				:	'='	;
NOTEQUAL1				: 	"<>";
NOTEQUAL2				:	"!=";
LESSTHANOREQUALTO1		:	"<=";
LESSTHANOREQUALTO2		:	"!>";
LESSTHAN				:	"<"	;
GREATERTHANOREQUALTO1	:	">=";
GREATERTHANOREQUALTO2	:	"!<";
GREATERTHAN				:	">"	;


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
	:	"seg_column";

FROM
	:	"seg_from";

WHERE
	:	"seg_where";


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
	:	ID_START_LETTER ( ID_LETTER )*
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
    |	'%'
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

DATA_TYPE_STRING options {testLiterals=true;}
    : "character" | "varchar"
    | "decimal" | "numeric" | "float"
    | "binary" | "varbinary"
    ;

//DATA_TYPE_STRING options {testLiterals=true;}
//	: "character" | "varchar" | "char" | "uniqueidentifierstr"
//	| "bigint" | "int" | "integer" | "smallint" | "tinyint" | "double" | "float" | "real" | "decimal" | "numeric"
//	| "date" | "datetime" | "smalldatetime" | "time" | "timestamp"
//	| "bit" | "binary" | "varbinary"
//	;

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

/*==========================================================
//
//					TreeParser Define
//
//==========================================================*/	
{
	import java.util.*;

	import model.parser.*;
}

class Oracle9iTreeParser extends TreeParser;

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
	:	#(TABLE_UNION_CN t1=tableUnionList)
		{
			union.addTableListModel(t1);
			model = union;
		}

		//\u8868\u6bd4\u8f83\u8bed\u53e5
	|	#(TABLE_COMPARE_CN tableModel1=table_name tableModel2=table_name method=compare_method cond=search_condition)
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
	|	#(LOGICAL_NOT_EXISTS ne1:NOT ne2:EXISTS)
		{rValue = ne1.getText() + " " + ne2.getText();}
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
	:	#(DISTINCT_CN select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#(DISTINCT_EN select sl=select_list)
	{sl.setDistinct(true); model.setSelectList(sl);}
	|	#(SELECT_CN sl=select_list)
	{model.setSelectList(sl);}
	|	#(SELECT_EN sl=select_list)
	{model.setSelectList(sl);}
	|	#(FROM_CN s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#(FROM_EN s=select_statement tl=table_list)
	{model.addChild(s); model.setTableList(tl);}
	|	#(WHERE_CN s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#(WHERE_EN s=select_statement cond=search_condition)
	{model.addChild(s); model.setSearchCondition(cond);}
	|	#(GROUP_BY_CN s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#(GROUP_EN s=select_statement group=aggregate_expression_list)
	{model.addChild(s); model.setGroupExpressionList(group);}
	|	#(ORDER_BY_CN s=select_statement order=order_expression_list)
	{model.addChild(s); model.setOrderExpressionList(order);}
	|	#(ORDER_EN s=select_statement order=order_expression_list)
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

search_condition returns [SearchConditionModel model]
{SearchConditionModel m1, m2, m3, m4, m5; EquationModel equ; model=new SearchConditionModel();}
	:	#(o1:AND_EN m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o1.getText(), true); model.addChild(m2);}
	|	#(o2:OR_EN m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o2.getText(), true); model.addChild(m2);}
	|	#(o3:AND_CN m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o3.getText()); model.addChild(m2);}
	|	#(o4:OR_CN m1=search_condition m2=search_condition)
	{model.addChild(m1); model.addOperator(o4.getText()); model.addChild(m2);}
	
	|	#(LOGIC_BLOCK m3=search_condition)
	{model.addOperator("("); model.addChild(m3); model.addOperator(")");}

	|	#(SEARCH_NOT_CONDITION o11:NOT_EN m4=search_condition)
	{model.addOperator(o11.getText(), true); model.addChild(m4);}
	|	#(o12:NOT_CN m5=search_condition)
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
	:	#(AS_EN e=expression a=alias)
	{model.addExpression(e); model.addAlias(a);}
	|	#(AS_CN e=expression a=alias)
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
	
	|	#(LOGICAL_LIKE e1=expression ls:LIKE_EN e2=expression)
	{model.addExpression(e1); model.addOperator(ls.getText(), true); model.addExpression(e2);}	
	|	#(LOGICAL_NOT_LIKE e1=expression ls1:NOT_EN ls2:LIKE_EN e2=expression)
	{model.addExpression(e1); model.addOperator(ls1.getText() + " " + ls2.getText(), true); model.addExpression(e2);}
	|	#(l:LIKE_CN e1=expression e2=expression)
	{model.addExpression(e1); model.addOperator(l.getText()); model.addExpression(e2);}
	|	#(nl:NOT_LIKE_CN e1=expression e2=expression)
	{model.addExpression(e1); model.addOperator(nl.getText()); model.addExpression(e2);}


	|	#(LOGICAL_NULL e1=expression nStr1:IS_EN nStr2:NULL_EN)
	{model.addExpression(e1); model.addOperator(nStr1.getText() + " " + nStr2.getText(), true);}
	|	#(n:NULL_CN e1=expression)
	{model.addExpression(e1); model.addOperator(n.getText());}
	|	#(LOGICAL_NOT_NULL e1=expression nStr3:IS_EN nStr4:NOT_EN nStr5:NULL_EN)
	{model.addExpression(e1); model.addOperator(nStr3.getText() + " " + nStr4.getText() + " " + nStr5.getText(), true);}
	|	#(nn:NOT_NULL_CN e1=expression)
	{model.addExpression(e1); model.addOperator(nn.getText());}


	|	#(bt1:BETWEEN_EN e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator(bt1.getText(), true);
	 model.addExpression(e2); model.addExpression(e3);}
	|	#(btw:BETWEEN_CN e1=expression e2=expression e3=expression)
	{model.addExpression(e1); model.addOperator(btw.getText());
	 model.addExpression(e2); model.addExpression(e3);
	}
	
	|	#(LOGICAL_IN e1=expression in1:IN_EN e2=exp_set)
	{model.addExpression(e1); model.addOperator(in1.getText(), true); model.addExpression(e2);}
	|	#(ct1:IN_CN e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);}
	|	#(LOGICAL_NOT_IN e1=expression in2:NOT_EN in3: IN_EN e2=exp_set)
	{model.addExpression(e1); model.addOperator(in2.getText() + " " + in3.getText(), true); model.addExpression(e2);}
	|	#(ct2:NOT_IN_CN e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);}
	;

exp_set returns [ExpressionModel model]
{
	model = new ExpressionModel();
	ExprContainModel expr;
}
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
	:	lp:LPAREN a1=aggregate_expression rp:RPAREN
	{model.addOperator(lp.getText()); model.addChild(a1); model.addOperator(rp.getText());}
	|	#(TWO_ARG_OP a1=aggregate_expression op:two_arg_op a2=aggregate_expression)
	{model.addChild(a1); model.addOperator(op.getText(), true); model.addChild(a2);}
	|	field=field_name
	{model.addField(field);}
	|	func=function
	{model.addFunction(func);}
	|	nrn:NEGATIVE_DIGIT_ELEMENT
	{model.addConstant(nrn.getText());}
	|	rn:REAL_NUM
	{model.addConstant(rn.getText());}
	|	qs:QUOTED_STRING
	{model.addConstant(qs.getText());}	
	;

order_expression returns [OrderExpressionModel model]
{FunctionModel func; FieldModel field; OrderAliasModel alias; OrderExpressionModel o; model=new OrderExpressionModel();}
	:	alias = orderAlias
	{model.addOrderAlias(alias);}
	|	field=field_name
	{model.addField(field);}
	|	func=function
	{model.addFunction(func);}
	|	#(ASC_EN o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.ASC);}
	|	#(ASC_CN o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.ASC);}
	|	#(DESC_EN o=order_expression)
	{model.addChild(o); model.setSort(OrderExpressionModel.DESC);}
	|	#(DESC_CN o=order_expression)
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
	{model.addChild(e1); model.addOperator(op.getText(), true); model.addChild(e2);}
	|	#(ONE_ARG_OP op1:one_arg_op e1=expression)
	{model.addOperator(op1.getText(), true); model.addChild(e1);}
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
	;
	
field_name returns [FieldModel model]
{
	model=null;
	String tStr = "";
	String fStr = "";
}
	:	#(POINT tStr = sfield_name fStr = sfield_name)
		{
			model = new FieldModel(fStr, tStr);
			addTableByChName(tStr);
		}
	|	fStr = sfield_name
		{
			model=new FieldModel(fStr);
		}
	;

sfield_name returns [String rValue]
{rValue = "";}
	:	#(PAREN_FIELD f1:ID f2:ID)
		{rValue = f1.getText() + "(" + f2.getText() + ")";}
	|	f:ID
		{rValue = f.getText();}
	;

function returns [FunctionModel model]
{
	model=null;
	ParametersModel p, dtp1, dtp2; 
	ExpressionModel express1 = new ExpressionModel();
}
	:	//Aggregate functions\u805a\u5408\u51fd\u6570
		af:aggregate_func_name p=parameters
		{
			model = new AggregateFuncModel(af.getText(), AggregateFuncModel.NO_FILTER, true); 
			model.setParameters(p);
		}
		
		//Normal functions\u666e\u901a\u51fd\u6570
//	|	f:function_name p=parameters
	|	#(FUNCTION f:function_name p=parameters)
		{
			model = new FunctionModel(f.getText(), true);
			model.setParameters(p);
		}
		
		//Normal functions\u53c2\u6570\u4e3a\u7a7a\u7684\u666e\u901a\u51fd\u6570[getdate()]
	|	#(FUNCTION_EMPTY_PARAM fun1:function_name)
		{
			model = new FunctionModel(fun1.getText(), true);
		}
		
		//Normal functions\u53c2\u6570\u4e3a*\u7684\u666e\u901a\u51fd\u6570[now(*)...]
	|	#(FUNCTION_STAR_PARAM funStar:function_name)
		{
			model = new FunctionModel(funStar.getText(), true);
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}
	
		//Normal functions\u53c2\u6570\u4e3aDATA TYPE\u7684\u666e\u901a\u51fd\u6570[convert(char(10), '2007-01-01', 120)]
	|	#(FUNCTION_DATA_TYPE dtf1:function_name dtp1=data_type_parameters)
		{
			model = new FunctionModel(dtf1.getText(), true);
			model.setParameters(dtp1);
		}
	
		//Normal functions\u53c2\u6570\u4e3aAS\u53caDATA TYPE\u7684\u666e\u901a\u51fd\u6570[cast('2007-01-01' as char(10))]
	|	#(FUNCTION_AS_DATA_TYPE dtf2:function_name dtp2=as_data_type_parameters)
		{
			model = new FunctionModel(dtf2.getText(), true);
			model.setParameters(dtp2);
		}
		
		//Aggregate functions\u53c2\u6570\u4e3a*\u7684COUNT\u51fd\u6570\uff0c\u805a\u5408\u51fd\u6570[count(*)]
	|	#(FUNCTION_STAR_COUNT cf1:"\u6c42\u8bb0\u5f55\u603b\u6570")
		{	
			model = new AggregateFuncModel(cf1.getText(), AggregateFuncModel.NO_FILTER, true);
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}
	|	#(FUNCTION_STAR_COUNT cf2:COUNT_EN)
		{	
			model = new AggregateFuncModel(cf2.getText(), AggregateFuncModel.NO_FILTER, true);
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}

		//Aggregate functions\u53c2\u6570\u4e3a\u5168\u90e8\u3001all\u7684\u805a\u5408\u51fd\u6570
	|	#(all1:ALL_CN af11:function_name p=parameters)
		{
			model = new AggregateFuncModel(af11.getText(), AggregateFuncModel.ALL, true);
			model.setParameters(p);
		}
	|	#(all2:ALL_EN af12:function_name p=parameters)
		{
			model = new AggregateFuncModel(af12.getText(), AggregateFuncModel.ALL, true);
			model.setParameters(p);
		}
		
		//Aggregate functions\u53c2\u6570\u4e3a\u552f\u4e00\u3001distinct\u7684\u805a\u5408\u51fd\u6570
	|	#(dist1:DISTINCT_CN af21:function_name p=parameters)
		{
			model = new AggregateFuncModel(af21.getText(), AggregateFuncModel.DISTINCT, true);
			model.setParameters(p);
		}
	|	#(dist2:DISTINCT_EN af22:function_name p=parameters)
		{
			model=new AggregateFuncModel(af22.getText(), AggregateFuncModel.DISTINCT, true);
			model.setParameters(p);
		}
	;

//\u666e\u901a\u53c2\u6570\u8bed\u6cd5\u6811\u904d\u5386	
parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel e; model=new ParametersModel();}
	:	#(COMMA p1=parameters p2=parameters)
	{model.addChild(p1); model.addChild(p2);}
	|	e=expression
	{model.addParameter(e);}
	;

//\u6570\u636e\u7c7b\u578b\u53c2\u6570\u8bed\u6cd5\u6811\u904d\u5386	
data_type_parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel dtc, e; model=new ParametersModel();}
	: 	#(COMMA p1=data_type_parameters p2=data_type_parameters)
		{model.addChild(p1);model.addChild(p2);}
	|	dtc=datatype_constant
		{model.addParameter(dtc);}
	|	e=expression
		{model.addParameter(e);}
	;

//\u5e26AS\u6570\u636e\u7c7b\u578b\u53c2\u6570\u8bed\u6cd5\u6811\u904d\u5386
as_data_type_parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel adtc, e, re; model=new ParametersModel();}
	:	e=expression adtc=datatype_constant
	   	{
	   		model.addParameter(e);
	   		model.addParameter(adtc);
	   		model.addFilter(ParametersModel.AS);
	   	}
	;

//\u6570\u636e\u7c7b\u578b\u5e38\u91cf\u904d\u5386
datatype_constant returns [ExpressionModel model]
{model=new ExpressionModel(); String rValue = ""; String rp = "";}
	:	c1:CHAR
		{
			//\u8fd4\u56dechar\u4fdd\u7559\u5b57
			rValue = c1.getText();
			model.addConstant(rValue);
		}
	|	#(PAREN_CHAR_DATA_TYPE c2:CHAR rp=datatype_precision_or_scale_or_maxlength)
		{
			//\u8fd4\u56de\u5e26\u53c2\u6570char\u4fdd\u7559
			rValue = c2.getText() + "(" + rp + ")";
			model.addConstant(rValue);
		}
	|	dtw:data_type_word
		{
			//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u4fdd\u7559\u5b57(date\u3001datetime...)
			rValue = dtw.getText();
			model.addConstant(rValue);
		}
	|	#(PAREN_DATA_TYPE dts:DATA_TYPE_STRING rp=datatype_precision_or_scale_or_maxlength)
		{
			//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u52a0\u5176\u53c2\u6570,\u5982char(10)\u3001numeric(20, 2)]
			rValue = dts.getText() + "(" + rp + ")";
			model.addConstant(rValue);
		}
	|	sdts:DATA_TYPE_STRING
		{
			//\u8fd4\u56de\u6570\u636e\u7c7b\u578b\u4e3a\u53ef\u4e0d\u5e26\u53c2\u6570]
			rValue = sdts.getText();
			model.addConstant(rValue);
		}
	;

datatype_precision_or_scale_or_maxlength returns [String rValue]
{rValue = "";}
	:	#(COMMA rn1:REAL_NUM rn2:REAL_NUM)
		{rValue = rn1.getText() + ", " + rn2.getText();}
	|	rn:REAL_NUM
		{rValue = rn.getText();}
	;

table_name returns [TableModel model]
{AliasModel a; model=null; TableAliasModel ta;}
	:	t:ID
	{model=new TableModel(t.getText());}
	|	#(AS_EN t1:ID ta = tableAlias)
	{model = new TableModel(t1.getText()); model.setAlias(ta);}
	|	#(AS_CN t2:ID ta = tableAlias)
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
select
	: SELECT_EN | SELECT_CN
	;

one_arg_op
	: TILDE | "\u975e\u8fd0\u7b97";

two_arg_op
	:	arithmeticOperator | bitwiseOperator
	|	"\u4e0e" | "\u975e\u8fd0\u7b97" | "\u6216" | "\u5f02\u6216" | "\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u6c42\u6a21";

arithmeticOperator
    : PLUS | MINUS | STAR | DIVIDE | MOD
    ;

bitwiseOperator
    : AMPERSAND | TILDE | BITWISEOR | BITWISEXOR
    ;

alias_equ_op
	:	ASSIGNEQUAL | "\u7b49\u4e8e"
	;

compare_op
	:	comparisonOperator
	|	"\u7b49\u4e8e" | "\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	|	"\u5de6\u8fde\u63a5"	| LEFT_JOIN
	;

comparisonOperator
	:	ASSIGNEQUAL
	| 	NOTEQUAL1
	| 	NOTEQUAL2
	| 	LESSTHANOREQUALTO1
	| 	LESSTHANOREQUALTO2 
    | 	LESSTHAN
	| 	GREATERTHANOREQUALTO1
	| 	GREATERTHANOREQUALTO2
	| 	GREATERTHAN
	;

comparemethod_name
	:	EXISTS_EN | EXISTS_CN | NOT_EXISTS_CN
	;

//\u65e5\u671fdate-part\u4fdd\u7559\u5b57
date_key_word
	: "year" | "yy" | "month" | "mm" | "day" | "dd"
	| "quarter" | "qq" | "week" | "wk" | "dayofyear" | "dy"
	| "weekday" | "dw" | "hour" | "hh" | "minute" | "mi" | "second" | "ss" | "millisecond" | "ms"
	| "calweekofyear" | "cwk" | "calyearofweek" | "cyr" | "caldayofweek" | "cdw"
	;

//\u805a\u5408\u51fd\u6570
aggregate_func_name
	:	"avg" 		| 	"\u6c42\u5e73\u5747\u6570"
//	|	"count" 	| 	"\u6c42\u8bb0\u5f55\u603b\u6570"
	|	COUNT_EN	|	COUNT_CN
	|	"max" 		| 	"\u6c42\u6700\u5927\u503c"
	|	"min" 		| 	"\u6c42\u6700\u5c0f\u503c"
	|	"stddev" 	| 	"\u6c42\u65b9\u5dee"
	|	"sum" 		|	"\u6c42\u603b\u548c"
	|	"variance" 	| 	"\u6c42\u7edf\u8ba1\u65b9\u5dee"
	;

//\u666e\u901a\u51fd\u6570(\u6570\u5b66\u51fd\u6570\u3001\u5b57\u7b26\u4e32\u51fd\u6570\u3001\u65e5\u671f\u65f6\u95f4\u51fd\u6570\u3001\u7cfb\u7edf\u51fd\u6570\u3001\u6570\u636e\u7c7b\u578b\u8f6c\u5316\u51fd\u6570\u3001\u5176\u4ed6\u51fd\u6570)
function_name
	:	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

//\u6570\u5b66\u51fd\u6570
number_function
	:	"abs" 		| 	"\u53d6\u7edd\u5bf9\u503c"
	|	"acos"		|	"\u6c42\u53cd\u4f59\u5f26\u503c"
	|	"asin"		|	"\u6c42\u53cd\u6b63\u5f26\u503c"
	|	"atan"		|	"\u6c42\u53cd\u6b63\u5207\u503c"
	|	"atin2"		|	"\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c"
	|	"ceiling"	|	"\u53d6\u4e0a\u9650\u6574\u6570"
	|	"cos"		|	"\u6c42\u4f59\u5f26\u503c"
	|	"cot"		|	"\u6c42\u4f59\u5207\u503c"
	|	"degrees"	|	"\u5f27\u5ea6\u8f6c\u5ea6\u6570"
	|	"exp"		|	"\u6c42\u5e42\u503c"
	|	"floor"		|	"\u53d6\u4e0b\u9650\u6574\u6570"
	|	"log"		|	"\u6c42\u81ea\u7136\u5bf9\u6570"
	|	"log10"		|	"\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570"
	|	"mod"		|	"\u6c42\u6a21"
	|	"pi"		|	"\u6c42\u5706\u5468\u7387"
	|	"power"		|	"\u6c42\u5e42"
	|	"radians"	|	"\u5ea6\u6570\u8f6c\u5f27\u5ea6"
	|	"rand"		|	"\u53d6\u968f\u673a\u6570"
	|	"remainder"	|	"\u6c42\u6a212"
	|	"round"		|	"\u683c\u5f0f\u5316\u6570\u503c"
	|	"sign"		|	"\u6c42\u503c\u7684\u7b26\u53f7"
	|	"sin"		|	"\u6c42\u6b63\u5f26\u503c"
	|	"sqrt" 		| 	"\u6c42\u5e73\u65b9\u6839"
	|	"tan"		|	"\u6c42\u6b63\u5207\u503c"
	|	"\u683c\u5f0f\u5316\u6570\u503c3"	//"\"truncate\""
	|	"truncnum"	|	"\u683c\u5f0f\u5316\u6570\u503c2"
	;

//\u5b57\u7b26\u4e32\u51fd\u6570
string_function
	:	"ascii"			|	"\u6c42ASCII\u7801"
	|	"bit_length"	|	"\u6c42\u5b57\u7b26\u4e32\u7684\u4e8c\u8fdb\u5236\u957f\u5ea6"
	|	"byte_length" 	| 	"\u6c42\u5b57\u7b26\u4e32\u7684\u5b57\u8282\u6570"
	|	"char"			|	"\u6c42\u7b49\u503c\u7684\u5b57\u7b26"
	|	"char_length" 	| 	"\u6c42\u5b57\u7b26\u4e32\u957f\u5ea61"
	|	"charindex" 	|	"\u5b58\u5728\u4e8e"
	|	"difference" 	|	"\u6c42\u4e24\u4e2a\u4e32\u7684\u58f0\u97f3\u5dee\u503c"
	|	"insertstr"		|	"\u63d2\u5165\u5b57\u7b26\u4e32"
	|	"lcase"			|	"\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd1"
	|	"left"			|	"\u5de6\u622a\u5b57\u7b26\u4e32"
	|	"length"		|	"\u6c42\u5b57\u7b26\u4e32\u957f\u5ea62"
	|	"locate"		|	"\u6c42\u4e32\u4f4d\u7f6e1"
	|	"lower" 		| 	"\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd2"
	|	"ltrim"			|	"\u53bb\u6389\u5de6\u7a7a\u683c"
	|	"octet_length"	|	"\u6c42\u5b57\u7b26\u4e32\u7684\u5b58\u50a8\u957f\u5ea6"
	|	"patindex"		|	"\u6c42\u4e32\u4f4d\u7f6e2"
	|	"repeat"		|	"\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a51"
	|	"replace"		|	"\u66ff\u6362\u5b57\u7b26\u4e32"
	|	"replicate"		|	"\u5b57\u7b26\u4e32\u5faa\u73af\u8fde\u63a52"
	|	"right"			|	"\u53f3\u622a\u5b57\u7b26\u4e32"
	|	"rtrim"			|	"\u53bb\u6389\u53f3\u7a7a\u683c"
	|	"similar"		|	"\u6c42\u5b57\u7b26\u4e32\u76f8\u4f3c\u5ea6"
	|	"sortkey"		|	"\u5b57\u7b26\u4e32\u6392\u5e8f"
	|	"soundex"		|	"\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c"
	|	"space"			|	"\u586b\u7a7a\u683c"
	|	"str"			|	"\u6570\u503c\u8f6c\u5b57\u7b26\u4e32"
	|	"string"		|	"\u5b57\u7b26\u4e32\u5408\u5e76"
	|	"stuff"			|	"\u5b57\u7b26\u4e32\u5220\u9664\u66ff\u6362"
	|	"substring"		|	"\u5b57\u7b26\u4e32\u622a\u53d6"
	|	"trim"			|	"\u53bb\u5de6\u53f3\u7a7a\u683c"
	|	"ucase"			|	"\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd1"
	|	"upper"			|	"\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd2"
	;

//\u65e5\u671f\u65f6\u95f4\u51fd\u6570
datetime_function
	:	"dateformat" 	|	"\u683c\u5f0f\u5316\u65e5\u671f"
	|	"datename"		|	"\u6c42\u65e5\u671f\u5206\u91cf\u82f1\u6587\u540d"
	|	"datepart"		|	"\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c"
	|	"datetime"		|	"\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4"
	|	"date"			|	"\u8f6c\u4e3a\u65e5\u671f"
	|	"dayname"		|	"\u6c42\u661f\u671f\u82f1\u6587\u540d"
	|	"days"			|	"\u6c42\u5929\u6570"
	|	"day"			|	"\u6c42\u5177\u4f53\u65e5\u671f"
	|	"dow"			|	"\u6c42\u5177\u4f53\u661f\u671f"
	|	"hours"			|	"\u6c42\u5c0f\u65f6\u6570"
	|	"hour"			|	"\u6c42\u5177\u4f53\u5c0f\u65f6"
	|	"minutes"		|	"\u6c42\u5206\u949f\u6570"
	|	"minute"		|	"\u6c42\u5177\u4f53\u5206\u949f"
	|	"monthname"		|	"\u6c42\u6708\u4efd\u82f1\u6587\u540d"
	|	"months"		|	"\u6c42\u6708\u6570"
	|	"month"			|	"\u6c42\u5177\u4f53\u6708\u6570"
	|	"now"			|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f41"
	|	"quarter"		|	"\u6c42\u5177\u4f53\u5b63\u5ea6"
	|	"seconds"		|	"\u6c42\u79d2\u6570"
	|	"second"		|	"\u6c42\u5177\u4f53\u79d2"
	|	"today"			|	"\u6c42\u5f53\u524d\u65e5\u671f"
	|	"weeks"			|	"\u6c42\u5468\u6570"
	|	"years"			|	"\u6c42\u5e74\u6570"
	|	"year"			|	"\u6c42\u5177\u4f53\u5e74\u4efd"
	|	"ymd"			|	"\u6570\u503c\u8f6c\u65e5\u671f"
	|	"getdate"		|	"\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f42"
	|	"dateadd"		|	"\u65e5\u671f\u8fd0\u7b97"
	|	"datediff"		|	"\u6c42\u4e24\u65e5\u671f\u5dee\u503c"
	;

//\u6570\u636e\u7c7b\u578b\u8f6c\u5316\u51fd\u6570
conversion_function
	:	"hextoint"	|	"\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570"
	|	"inttohex"	|	"\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236"
	|	"isdate"	|	"\u662f\u5426\u65e5\u671f\u578b"
	|	"isnumeric"	|	"\u662f\u5426\u6570\u503c\u578b"
	|	"cast"		|	"\u6570\u636e\u7c7b\u578b\u8f6c\u5316"
	|	"convert"	|	"\u6570\u636e\u7c7b\u578b\u8f6c\u6362"
	;

//\u7cfb\u7edf\u51fd\u6570
system_function
	:	"suser_id"
	|	"suser_name"
	|	"user_id"
	|	"user_name"
	;

//\u5176\u4ed6\u51fd\u6570
other_function
	:	"argn"
	| 	"rowid"
	;

//\u6570\u636e\u7c7b\u578b\u4fdd\u7559\u5b57
data_type_word
	: "uniqueidentifierstr" 
	| "bigint" | "int" | "integer" | "smallint" | "tinyint" | "double" | "real"
	| "date" | "datetime" | "smalldatetime" | "time" | "timestamp"
	| "bit"
	;
