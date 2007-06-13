/*==========================================================
//	LongtopParser Of Oracle
// 	oracle8i/oracle9i SQL Grammar
//
//	http://www.longtop.com
//
//  Recent updates by jiandeh@sina.com
//
//	修改日志:
//	========================================================
//	05/31/2007:
//		- 将语法定义的关键字放在词法的tokens中,语法定义中不再出现
//		  自己定义关键字
//		- 在操作符及函数放入对应Model时将英文转化成中文,统一格式化
//		- aggregate_expr语法增加对()的识别,并增加常量的定义,使
//		  abs(-900) + 500的语句可验证
//	06/11/2007:
//		- equation增加EXISTS/NOT EXISTS的语法定义，允许子查询
//		  设置SUBQUERY的TOKEN进行语法树遍历
//	06/12/2007:
//		- exp_set语法增加子查询解析，同时增加子查询的语法树遍历
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
	k = 5;
	buildAST = true;
	defaultErrorHandler = false;
}

tokens {	
	SELECT_STATEMENT;		//完整查询语句 TOKEN
	SEARCH_NOT_CONDITION;	//非整个条件 TOKEN
	SUBQUERY;				//子查询 TOKEN
	GROUP_BY;				//分组 TOKEN
	ORDER_BY;				//排序 TOKEN
	ALIAS_EQU;				//别名 TOKEN
	
	FUNCTION;				//普通函数 TOKEN
	FUNCTION_NOTHING;		//不带任何东西的函数 TOKEN[sysdate]
	FUNCTION_EMPTY_PARAM;	//空参数函数 TOKEN [getdate()]
	FUNCTION_STAR_PARAM;	//参数为*函数 TOKEN [now(*);today(*)]
	FUNCTION_STAR_COUNT;	//函数COUNT(*) TOKEN
	
	FUNCTION_DATA_TYPE;		//带数据类型的函数 TOKEN
	FUNCTION_AS_DATA_TYPE;	//带AS及数据类型的函数 TOKEN

	LOGIC_OP;				//逻辑操作符TOKEN
	LOGICAL_NULL;			//逻辑IS NULL TOKEN
	LOGICAL_NOT_NULL;		//逻辑IS NOT NULL TOKEN
	LOGICAL_IN;				//逻辑IN TOKEN
	LOGICAL_NOT_IN;			//逻辑NOT IN TOKEN
	LOGICAL_LIKE;			//逻辑LIKE TOKEN
	LOGICAL_NOT_LIKE;		//逻辑LIKE TOKEN
	LOGICAL_EXISTS;			//逻辑EXISTS TOKEN
	LOGICAL_NOT_EXISTS;		//逻辑NOT EXISTS TOKEN
	LOGICAL_BETWEEN;		//逻辑BETWEEN AND TOKEN
	
	SUBCONTAIN_OP;			//关系IN/NOT IN TOKEN
	ALL_FIELDS;				//字段所有(*) TOKEN
	PAREN_FIELD;			//带括号的字段[利率(百分比%)] TOKEN
	PAREN_DATA_TYPE;		//带括号的数据类型 TOKEN
	PAREN_CHAR_DATA_TYPE;	//带括号的保留字char数据类型 TOKEN
	LOGIC_BLOCK;			//WHERE条件逻辑块 TOKEN
}

//片段字句规则入口
segment
	:	(COLUMN column
	|	WHERE search_condition)
	EOF!
	;

//完整查询语句规则入口
statements
	:	statement (SEMI^ statement)* EOF!;

//单个语句规则(表合并、表比较、自定义查询)
statement
	:	tableUnion
	|	tableCompare
	|	select_statement
		{#statement=#([SELECT_STATEMENT], #statement);}
	;

//表合并
tableUnion
	:	(TABLE_UNION_EN^|TABLE_UNION_CN^) table_lists
	;

//表合并的表名列表
table_lists
	:	table_name (COMMA^ table_name)+
	;

//表比较
tableCompare
	:	(TABLE_COMPARE_EN^|TABLE_COMPARE_CN^) table_name COMMA! table_name (WHERE_EN!|WHERE_CN!) compare_method search_condition
	;

//比较方法定义(存在、不存在)
compare_method
	:	(EXISTS_EN | EXISTS_CN | NOT_EXISTS_CN)
	|	NOT_EN EXISTS_EN
		{#compare_method = #([LOGICAL_NOT_EXISTS, "logic_not_exists"], #compare_method);}
	;

//自定义查询
select_statement
	:	
		//CUSTOM SQL Sentence
		(SELECT_EN^ | SELECT_CN^) (DISTINCT_EN^ | DISTINCT_CN^)? select_list
		((FROM_EN^ | FROM_CN^) table_list)?
		((WHERE_EN^ | WHERE_CN^)search_condition)?
		((GROUP_EN^ BY_EN! | GROUP_BY_CN^) aggregate_expression_list)?
		((ORDER_EN^ BY_EN! | ORDER_BY_CN^) order_expression_list)?
	;

//SELECT子句字段列表
select_list
	:	column (COMMA^ column)*
	;

//FROM子句表列表
table_list
	:	table_name (COMMA^ table_name)*
	;

//WHERE子句条件信息
search_condition
	:	bool_exp
	|	( NOT_EN
		{#search_condition = #([SEARCH_NOT_CONDITION, "search_not_condition"], #search_condition);}
		| NOT_CN^
		) search_condition
	;

//单个条件间的逻辑运算
bool_exp
	:	bool_term 
		((AND_EN^ | OR_EN^ | AND_CN^ | OR_CN^) bool_term)*
	;

//单个条件的括号推理
bool_term
	:	(LPAREN bool_exp RPAREN) => LPAREN! exp:bool_exp RPAREN!
	{#bool_term=#([LOGIC_BLOCK, "log_block"], #bool_term);}
	|	equation
	;

//GROUP BY子句的分组列表
aggregate_expression_list
	:	aggregate_expr (COMMA^ aggregate_expr)*
	;

//ORDER BY子句的排序列表
order_expression_list
	:	order_expression (COMMA^ order_expression)*
	;

//单个字段定义
column
	:	expression_with_aggr_func ((AS_EN^|AS_CN^) alias)?
	|	alias ("="|"等于")! expression_with_aggr_func {#column=#([ALIAS_EQU, "="], #column);}
	|	all: SELECT_ALL_CN {#column=#([ALL_FIELDS, all.getText()]);}
	|	STAR {#column=#([ALL_FIELDS, "*"]);}
	;

//单个分组表达式
aggregate_expr
	:	LPAREN aggregate_expr RPAREN
	|	(field_name|function|constant) (
		two_arg_op aggregate_expr {#aggregate_expr=#([TWO_ARG_OP, "two_arg_op"], #aggregate_expr);})?
	;

//单个排序表达式
order_expression
	:	(alias|field_name|aggregate_func|function) (ASC_EN^|ASC_CN^|DESC_EN^|DESC_CN^)?
	;

//普通表达式
expression
	:	LPAREN expression RPAREN
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	|	one_arg_op expression {#expression=#([ONE_ARG_OP, "one_arg_op"], #expression);}
	|	(field_name|constant|function|param_equ)
		(two_arg_op expression {#expression=#([TWO_ARG_OP, "two_arg_op"], #expression);})?
	;

//带函数的单个字段表达式
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

//单个条件信息(a > 0/a like '%oracle%')
equation
	:	expression (
		
		//比较运算符(>= > = <...) 表达式
		(compare_op) expression
	  	{#equation=#([COMPARE_OP, "comp_op"], #equation);}

	|	(EXISTS_EN) subquery
		{#equation=#([LOGICAL_EXISTS, "logic_exists"], #equation);}	
	|	(NOT_EN EXISTS_EN) subquery
		{#equation=#([LOGICAL_NOT_EXISTS, "logic_not_exists"], #equation);}	
	|	(EXISTS_CN^ | NOT_EXISTS_CN^) subquery

		//逻辑运算符LIKE/NOT LIKE 表达式
	|	(LIKE_EN) expression
		{#equation=#([LOGICAL_LIKE, "logic_like"], #equation);}	
	|	(NOT_EN LIKE_EN) expression
		{#equation=#([LOGICAL_NOT_LIKE, "logic_not_like"], #equation);}	
	|	(LIKE_CN^|NOT_LIKE_CN^) expression

		//逻辑运算符IS NULL/IS NOT NULL
	|	( IS_EN NULL_EN
		  {#equation = #([LOGICAL_NULL, "logic_null"], #equation);}
		| IS_EN NOT_EN NULL_EN
		  {#equation = #([LOGICAL_NOT_NULL, "logic_not_null"], #equation);}
		| NULL_CN^ | NOT_NULL_CN^
		)
	
		//逻辑运算符BETWEEN AND
	| 	BETWEEN_CN^ expression expression
	|	BETWEEN_EN^ expression AND_EN! expression
	
		//关系运算符IN/NOT IN
	|	( IN_EN
		  {#equation = #([LOGICAL_IN, "logic_in"], #equation);}
		| NOT_EN IN_EN
		  {#equation = #([LOGICAL_NOT_IN, "logic_not_in"], #equation);}
		| IN_CN^ | NOT_IN_CN^
		) exp_set
	)
	;

//函数定义
function
	:	nothing_function
	{#function = #([FUNCTION_NOTHING, "function_nothing"], #function);}
	|	asdatatype_function LPAREN! as_data_type_parameter RPAREN!
	{#function = #([FUNCTION_AS_DATA_TYPE, "function_as_data_type"], #function);}
	|	function_name LPAREN! parameters RPAREN!
	{#function = #([FUNCTION, "function_block"], #function);}
	;

//聚合函数
aggregate_func
	:	(COUNT_EN | COUNT_CN) LPAREN! STAR! RPAREN!
		{#aggregate_func = #([FUNCTION_STAR_COUNT, "function_star_count"], #aggregate_func);}
	|	aggregate_func_name LPAREN! (ALL_EN^ | ALL_CN^ | DISTINCT_EN^ | DISTINCT_CN^)? parameters RPAREN!
	;

//函数的参数列表
parameters
	:	expression (COMMA^ expression)*
	;

//==========数据类型参数 BEGIN==========//

//带AS关键字的数据类型参数表达式[f1 as char(10)]
as_data_type_parameter
	: expression (AS_EN! | DATA_TYPE_AS_CN!) (datatype_constant)
	;

//数据类型参数表达式[char(10), f1]
data_type_parameter
	:	datatype_constant (COMMA^ expression)+
	;

//数据类型定义
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

//数据类型的参数设置
datatype_precision_or_scale_or_maxlength
	:	REAL_NUM COMMA^ REAL_NUM
	|	REAL_NUM
	;

//==========数据类型参数  END===========//


//表名定义
table_name
	:	ID ((AS_EN^ | AS_CN^) alias)?
	;


//IN/NOT IN间的常量设置
exp_set
	: 	LPAREN! constexpset RPAREN!
	{#exp_set = #([SUBCONTAIN_OP, "subcontain_op"], #exp_set);}
	| (subquery) => subquery
	;

//常量定义[IN(10, 20, 30)]
constexpset
	:	constant (COMMA^ constant)*
	;
//子查询
subquery
	:	LPAREN! select_statement RPAREN!
		{#subquery = #([SUBQUERY, "subquery"], #subquery);}
	;

//循环的参数变量[{月变量}]
param_equ
	:	PARAM_ID
	;

//别名定义
alias
	:	ID | QUOTED_STRING;

//字段定义[表名.字段名]
field_name
	:	ID POINT^ sfield_name
	;	
//field_name
//	:	ID POINT^ ID
//	;

//单个字段名定义
sfield_name
	:	//如：利率(百分比%)
		ID LPAREN! ID RPAREN!
		{#sfield_name = #([PAREN_FIELD, "paren_field"], #sfield_name);}
	|	ID
	;

//常量定义[正数、负数、字符串('abc')、保留字、NULL]
constant
	:	REAL_NUM
	|	NEGATIVE_DIGIT_ELEMENT
	|	QUOTED_STRING
	|	date_key_word
	|	NULL_EN
	;

//=======================================//
//聚合函数
aggregate_func_name
	:	"avg" 		| 	"求平均数"
	|	COUNT_EN	|	COUNT_CN
	|	"max" 		| 	"求最大值"
	|	"min" 		| 	"求最小值"
	|	"stddev" 	| 	"求标准差"
	|	"sum" 		|	"求总和"
	|	"variance" 	| 	"求协方差"
	;

//没有带任何东西的函数[格式如： sysdate]
nothing_function
	:	SYSDATE_EN	|	SYSDATE_CN
	;

//带关键字AS的数据类型函数
asdatatype_function
	:	"cast"		|	"数据类型转化"
	;

//普通函数(数学函数、字符串函数、日期时间函数、系统函数、数据类型转化函数、其他函数)
function_name
	:
	|	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

//数学函数
number_function
	:	"abs" 		| 	"取绝对值"
	|	"acos"		|	"求反余弦值"
	|	"asin"		|	"求反正弦值"
	|	"atan"		|	"求反正切值"
	|	"atin2"		|	"求二个数的反正切值"
	|	"ceil"		|	"取上限整数"
	|	"cos"		|	"求余弦值"
	|	"cosh"		|	"求余切值"
	|	"exp"		|	"求幂值"
	|	"floor"		|	"取下限整数"
	|	"ln"		|	"求自然对数"
	|	"log"		|	"求对数"
	|	"mod"		|	"求模"
	|	"power"		|	"求幂"
	|	"round"		|	"格式化数值"
	|	"sign"		|	"求值的符号"
	|	"sin"		|	"求正弦值"
	|	"sinh"		|	"求双曲正弦值"
	|	"sqrt" 		| 	"求平方根"
	|	"tan"		|	"求正切值"
	|	"tanh"		|	"求双曲正切值"
	|	"trunc"		|	"格式化数值2"
	;

//字符串函数
string_function
	:	"ascii"			|	"求ASCII码"			//返回数字
	|	"asciistr"		|	"求字符串ASCII码"
	|	"chr"			|	"求等值的字符"
	|	"cancat" 		| 	"字符串连接"
	|	"initcap" 		|	"单词首字母大写1"
	|	"instr"			|	"求串位置"			//返回数字
	|	"instrb"		|	"字节方式求串位置"		//返回数字
	|	"length"		|	"求字符串长度"		//返回数字
	|	"lengthb"		|	"求字符串字节数"		//返回数字
	|	"lower"			|	"转为小写字母1"
	|	"ltrim"			|	"去掉左空格"
	|	"lpad"			|	"字符串左补"
	|	"nls_initcap"	|	"单词首字母大写2"
	|	"nls_lower"		|	"转为小写字母2"
	|	"nlssort"		|	"字符串排序"			//返回数字
	|	"nls_upper"		|	"转为大写字母2"
	|	"replace"		|	"字符串替换"
	|	"rpad"			|	"字符串右补"
	|	"rtrim"			|	"去掉右空格"
	|	"soundex"		|	"求字符串声音值"
	|	"substr"		|	"字符串截取"
	|	"trim"			|	"去左右空格"
	|	"ranslate"		|	"字符串全替换"
	|	"upper"			|	"转为大写字母1"
	;

//日期时间函数
datetime_function
	:	"add_months"	|	"月份运算"
	|	"last_day" 		|	"求日期最后一天"
	|	"months_between"|	"求月份差值"
	|	"new_time"		|	"求对应时区的时间"
	|	"next_day"		|	"求具体星期的日期"
//	|	"sysdate"		|	"取当前日期时间"		//详见Lexer Token
	;

conversion_function
	:	"bin_to_num"	|	"二进制转为数值"
	|	"chartorowid"	|	"字符串转为行号"
//	|	"cast"			|	"数据类型转化"	//语法见asdatatype_function
	|	"convert"		|	"字符串转化"
	|	"hextoraw"		|	"十六进制转为二进制"
	|	"rawtohex"		|	"二进制转为十六进制"
	|	"rowidtochar"	|	"行号转成字符串"
	|	"to_char"		|	"转为字符型"
	|	"to_date"		|	"转为日期型"
	|	"to_multi_byte"	|	"转为多字节型"
	|	"to_number"		|	"转为数值型"
	|	"to_single_byte"|	"转为单字节型"
	;

//系统函数
system_function
	:	"uid"		|	"求标识编号"
	|	"user"		|	"求当前用户"
	|	"userenv"	|	"求当前用户环境信息"
	|	"vsize"		|	"求字段大小"
	;

//其他函数
other_function
	:	"decode"	|	"求比较结果"
	|	"dump"		|	"返回数据格式"
	| 	"empty_blob"|	"初始化BLOB"
	|	"empty_clob"|	"初始化CLOB"
	|	"greatest"	|	"求最大表达式"
	|	"least"		|	"求最小表达式"
	|	"nvl"		|	"求非空值"
	;

//单个运算符号[~]
one_arg_op
	: TILDE | "非运算";

//前后均需表达式运算符号[算术运算符、位运算符号...]
two_arg_op
	:	arithmeticOperator | bitwiseOperator
	|	"与" | "非运算" | "或" | "异或" | "加" | "减" | "乘" | "除" | "求模";

//算术运算符[+ - * /]
arithmeticOperator
    : PLUS | MINUS | STAR | DIVIDE | MOD
    ;

//位运算符号[& ~ ^]
bitwiseOperator
    : AMPERSAND | TILDE | BITWISEOR | BITWISEXOR
    ;

//等于运算符
alias_equ_op
	:	ASSIGNEQUAL | "等于"
	;

//比较运算符[中英]
compare_op
	:	comparisonOperator
	|	"等于" | "大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	;

//比较运算符(= != <> <= ...)
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

//日期date-part保留字
date_key_word
	: "year" | "yy" | "yyyy" | "month" | "mm" | "m" | "day" | "dd" | "d"
	| "quarter" | "qq" | "q" | "week" | "wk" | "w" 
	| "dayofyear" | "dy" | "y" | "weekday" | "dw" 
	| "hour" | "hh" | "hh12" | "hh24" | "minute" | "mi" | "n"| "second" | "ss" | "s" | "millisecond" | "ms"
	;

//数据类型保留字
data_type_word
	:
	| "long" //| "long" "raw"
	| "date"
	| "rowid"
	| "clob" | "nclob" | "blob" | "bfile"
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
	TABLE_UNION_CN = "表合并";
	
	TABLE_COMPARE_EN = "t_compare";
	TABLE_COMPARE_CN = "表比较";

	SELECT_EN = "select";
	SELECT_CN = "查询";

	FROM_EN = "from";
	FROM_CN = "来自";

	WHERE_EN = "where";
	WHERE_CN = "条件";

	GROUP_EN = "group";
	GROUP_BY_CN = "分组";
	
	ORDER_EN = "order";
	ORDER_BY_CN = "排序";

	BY_EN = "by";
	
	ASC_EN = "asc";
	ASC_CN = "升序";

	DESC_EN = "desc";
	DESC_CN = "降序";	

	AND_EN = "and";
	AND_CN = "并且";
	
	OR_EN = "or";
	OR_CN = "或者";
	
	NOT_EN = "not";
	NOT_CN = "非";
	
	ALL_EN = "all";
	ALL_CN = "全部";
	
	SELECT_ALL_CN = "所有";

	DISTINCT_EN = "distinct";
	DISTINCT_CN = "唯一";

	EXISTS_EN = "exists";
	EXISTS_CN = "存在";
	
	NOT_EXISTS_CN = "不存在";

	IN_EN = "in";
	IN_CN = "在于";
	
	NOT_IN_CN = "不在于";

	IS_EN = "is";
	
	NULL_EN = "null";
	NULL_CN = "为空";
	
	NOT_NULL_CN = "非空";
	
	LIKE_EN = "like";
	LIKE_CN = "包含";
	
	NOT_LIKE_CN = "不包含";
	
	BETWEEN_EN = "between";
	BETWEEN_CN = "范围";
	
	AS_EN = "as";
	AS_CN = "作为";
	DATA_TYPE_AS_CN = "为";
	
	CHAR = "char";

	COUNT_EN = "count";
	COUNT_CN = "求记录总数";

	SYSDATE_EN = "SYSDATE";
	SYSDATE_CN = "取当前日期时间";
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
	
protected ID_START_LETTER
    :    'a'..'z'
    |	'_'
    |    '\u0080'..'\ufffe'
    ;

protected ID_LETTER
    :	ID_START_LETTER
    |	'0'..'9'
    |	'/'
    |	'%'
    ;


//Real Numeric
REAL_NUM
	:	NUM (POINT DOT_NUM)?
	;

//Negative Digit Element
NEGATIVE_DIGIT_ELEMENT
	: 	MINUS NUM (POINT DOT_NUM)?
	;
	
protected NUM
	:	'0'
	|	NUM_START (NUM_LETTER)*
	;

protected DOT_NUM
	:	(NUM_LETTER)+
	;

protected NUM_START
	:	'1'..'9'
	;

protected NUM_LETTER
	:	'0'..'9'
	;

DATA_TYPE_STRING options {testLiterals=true;}
    : "varchar2" | "nchar" | "nvarchar2"
    | "numeric"
    | "raw"
//    | "interval" "year" | "interval" "month"
    | "urowid"
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
		//表合并语句
	:	#(TABLE_UNION_CN t1=tableUnionList)
		{
			union.addTableListModel(t1);
			model = union;
		}

		//表比较语句
	|	#(TABLE_COMPARE_CN tableModel1=table_name tableModel2=table_name method=compare_method cond=search_condition)
		{	
			tableCompare.addTableModel1(tableModel1);
			tableCompare.addTableModel2(tableModel2);
			tableCompare.setCompareMethod(method);
			tableCompare.setSearchCondition(cond);
			model = tableCompare;
		}
		//自定义查询语句
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
	SelectStatementModel stmt;
	model=new EquationModel();
	String nullStr = "";
}
	:	#(COMPARE_OP e1=expression op:compare_op e2=expression)
	{model.addExpression(e1); model.addOperator(op.getText()); model.addExpression(e2);}
	
	|	#(LOGICAL_EXISTS e1=expression le0:EXISTS_EN #(SUBQUERY stmt=select_statement))
	{model.addExpression(e1); model.addOperator(le0.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);}
	|	#(LOGICAL_NOT_EXISTS e1=expression le1:NOT_EN le2:EXISTS_EN #(SUBQUERY stmt=select_statement))
	{model.addExpression(e1); model.addOperator(le1.getText() + " " + le2.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);}
	|	#(le:EXISTS_CN e1=expression #(SUBQUERY stmt=select_statement))
	{model.addExpression(e1); model.addOperator(le.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);}
	|	#(lne:NOT_EXISTS_CN e1=expression #(SUBQUERY stmt=select_statement))
	{model.addExpression(e1); model.addOperator(lne.getText(), true); model.addSelectStatement(stmt); stmt.setSubquery(true);}
	
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
	|	#(LOGICAL_NOT_IN e1=expression in2:NOT_EN in3: IN_EN e2=exp_set)
	{model.addExpression(e1); model.addOperator(in2.getText() + " " + in3.getText(), true); model.addExpression(e2);}
	|	#(ct1:IN_CN e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct1.getText()); model.addExpression(e2);}
	|	#(ct2:NOT_IN_CN e1=expression e2=exp_set)
	{model.addExpression(e1); model.addOperator(ct2.getText()); model.addExpression(e2);}
	;

exp_set returns [ExpressionModel model]
{
	model = new ExpressionModel();
	SelectStatementModel stmt;
	ExprContainModel expr;
}
	: 	#(SUBCONTAIN_OP expr=constexpset)
		{
			model.addExprContainModel(expr);
		}
	|	#(SUBQUERY stmt=select_statement)
		{
			model.addSelectStatement(stmt);
			stmt.setSubquery(true);
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
	:	//Aggregate functions聚合函数
		af:aggregate_func_name p=parameters
		{
			model = new AggregateFuncModel(af.getText(), AggregateFuncModel.NO_FILTER, true); 
			model.setParameters(p);
		}
		
		//Normal functions普通函数
	|	#(FUNCTION f:function_name p=parameters)
		{
			model = new FunctionModel(f.getText(), true);
			model.setParameters(p);
		}
		
		//Normal functions参数为空的普通函数[sysdate]
	|	#(FUNCTION_NOTHING nfun:function_name)
		{
			model = new FunctionModel(nfun.getText(), true);
			model.setNothing(true);
		}
		
		//Normal functions参数为空的普通函数[getdate()]
	|	#(FUNCTION_EMPTY_PARAM fun1:function_name)
		{
			model = new FunctionModel(fun1.getText(), true);
		}
		
		//Normal functions参数为*的普通函数[now(*)...]
	|	#(FUNCTION_STAR_PARAM funStar:function_name)
		{
			model = new FunctionModel(funStar.getText(), true);
			express1.addOperator("*");
			p = new ParametersModel();
			p.addParameter(express1);
			model.setParameters(p);
		}
	
		//Normal functions参数为DATA TYPE的普通函数[convert(char(10), '2007-01-01', 120)]
	|	#(FUNCTION_DATA_TYPE dtf1:function_name dtp1=data_type_parameters)
		{
			model = new FunctionModel(dtf1.getText(), true);
			model.setParameters(dtp1);
		}
	
		//Normal functions参数为AS及DATA TYPE的普通函数[cast('2007-01-01' as char(10))]
	|	#(FUNCTION_AS_DATA_TYPE dtf2:function_name dtp2=as_data_type_parameters)
		{
			model = new FunctionModel(dtf2.getText(), true);
			model.setParameters(dtp2);
		}
		
		//Aggregate functions参数为*的COUNT函数，聚合函数[count(*)]
	|	#(FUNCTION_STAR_COUNT cf1:"求记录总数")
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

		//Aggregate functions参数为全部、all的聚合函数
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
		
		//Aggregate functions参数为唯一、distinct的聚合函数
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

//普通参数语法树遍历	
parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel e; model=new ParametersModel();}
	:	#(COMMA p1=parameters p2=parameters)
	{model.addChild(p1); model.addChild(p2);}
	|	e=expression
	{model.addParameter(e);}
	;

//数据类型参数语法树遍历	
data_type_parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel dtc, e; model=new ParametersModel();}
	: 	#(COMMA p1=data_type_parameters p2=data_type_parameters)
		{model.addChild(p1);model.addChild(p2);}
	|	dtc=datatype_constant
		{model.addParameter(dtc);}
	|	e=expression
		{model.addParameter(e);}
	;

//带AS数据类型参数语法树遍历
as_data_type_parameters returns [ParametersModel model]
{ParametersModel p1, p2; ExpressionModel adtc, e, re; model=new ParametersModel();}
	:	e=expression adtc=datatype_constant
	   	{
	   		model.addParameter(e);
	   		model.addParameter(adtc);
	   		model.addFilter(ParametersModel.AS);
	   	}
	;

//数据类型常量遍历
datatype_constant returns [ExpressionModel model]
{model=new ExpressionModel(); String rValue = ""; String rp = "";}
	:	c1:CHAR
		{
			//返回char保留字
			rValue = c1.getText();
			model.addConstant(rValue);
		}
	|	#(PAREN_CHAR_DATA_TYPE c2:CHAR rp=datatype_precision_or_scale_or_maxlength)
		{
			//返回带参数char保留
			rValue = c2.getText() + "(" + rp + ")";
			model.addConstant(rValue);
		}
	|	dtw:data_type_word
		{
			//返回数据类型保留字(date、datetime...)
			rValue = dtw.getText();
			model.addConstant(rValue);
		}
	|	#(PAREN_DATA_TYPE dts:DATA_TYPE_STRING rp=datatype_precision_or_scale_or_maxlength)
		{
			//返回数据类型加其参数,如char(10)、numeric(20, 2)]
			rValue = dts.getText() + "(" + rp + ")";
			model.addConstant(rValue);
		}
	|	sdts:DATA_TYPE_STRING
		{
			//返回数据类型为可不带参数]
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
	: TILDE | "非运算";

two_arg_op
	:	arithmeticOperator | bitwiseOperator
	|	"与" | "非运算" | "或" | "异或" | "加" | "减" | "乘" | "除" | "求模";

arithmeticOperator
    : PLUS | MINUS | STAR | DIVIDE | MOD
    ;

bitwiseOperator
    : AMPERSAND | TILDE | BITWISEOR | BITWISEXOR
    ;

alias_equ_op
	:	ASSIGNEQUAL | "等于"
	;

compare_op
	:	comparisonOperator
	|	"等于" | "大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	|	"左连接"	| LEFT_JOIN
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

//聚合函数
aggregate_func_name
	:	"avg" 		| 	"求平均数"
	|	COUNT_EN	|	COUNT_CN
	|	"max" 		| 	"求最大值"
	|	"min" 		| 	"求最小值"
	|	"stddev" 	| 	"求标准差"
	|	"sum" 		|	"求总和"
	|	"variance" 	| 	"求协方差"
	;

//普通函数(数学函数、字符串函数、日期时间函数、系统函数、数据类型转化函数、其他函数)
function_name
	:
	|	number_function
	|	string_function
	|	datetime_function
	|	conversion_function
	|	system_function
	|	other_function
	;

//数学函数
number_function
	:	"abs" 		| 	"取绝对值"
	|	"acos"		|	"求反余弦值"
	|	"asin"		|	"求反正弦值"
	|	"atan"		|	"求反正切值"
	|	"atin2"		|	"求二个数的反正切值"
	|	"ceil"		|	"取上限整数"
	|	"cos"		|	"求余弦值"
	|	"cosh"		|	"求余切值"
	|	"exp"		|	"求幂值"
	|	"floor"		|	"取下限整数"
	|	"ln"		|	"求自然对数"
	|	"log"		|	"求对数"
	|	"mod"		|	"求模"
	|	"power"		|	"求幂"
	|	"round"		|	"格式化数值"
	|	"sign"		|	"求值的符号"
	|	"sin"		|	"求正弦值"
	|	"sinh"		|	"求双曲正弦值"
	|	"sqrt" 		| 	"求平方根"
	|	"tan"		|	"求正切值"
	|	"tanh"		|	"求双曲正切值"
	|	"trunc"		|	"格式化数值2"
	;

//字符串函数
string_function
	:	"ascii"			|	"求ASCII码"			//返回数字
	|	"asciistr"		|	"求字符串ASCII码"
	|	"chr"			|	"求等值的字符"
	|	"cancat" 		| 	"字符串连接"
	|	"initcap" 		|	"单词首字母大写1"
	|	"instr"			|	"求串位置"			//返回数字
	|	"instrb"		|	"字节方式求串位置"		//返回数字
	|	"length"		|	"求字符串长度"		//返回数字
	|	"lengthb"		|	"求字符串字节数"		//返回数字
	|	"lower"			|	"转为小写字母1"
	|	"lpad"			|	"字符串左补"
	|	"ltrim"			|	"去掉左空格"
	|	"nls_initcap"	|	"单词首字母大写2"
	|	"nls_lower"		|	"转为小写字母2"
	|	"nlssort"		|	"字符串排序"			//返回数字
	|	"nls_upper"		|	"转为大写字母2"
	|	"replace"		|	"字符串替换"
	|	"rpad"			|	"字符串右补"
	|	"rtrim"			|	"去掉右空格"
	|	"soundex"		|	"求字符串声音值"
	|	"substr"		|	"字符串截取"
	|	"trim"			|	"去左右空格"
	|	"ranslate"		|	"字符串全替换"
	|	"upper"			|	"转为大写字母1"
	;

//日期时间函数
datetime_function
	:	"add_months"	|	"月份运算"
	|	"last_day" 		|	"求日期最后一天"
	|	"months_between"|	"求月份差值"
	|	"new_time"		|	"求对应时区的时间"
	|	"next_day"		|	"求具体星期的日期"
	|	SYSDATE_EN		|	SYSDATE_CN
	;

//数据类型转化函数
conversion_function
	:	"bin_to_num"	|	"二进制转为数值"
	|	"chartorowid"	|	"字符串转为行号"
	|	"cast"			|	"数据类型转化"
	|	"convert"		|	"字符串转化"
	|	"hextoraw"		|	"十六进制转为二进制"
	|	"rawtohex"		|	"二进制转为十六进制"
	|	"rowidtochar"	|	"行号转成字符串"
	|	"to_char"		|	"转为字符型"
	|	"to_date"		|	"转为日期型"
	|	"to_multi_byte"	|	"转为多字节型"
	|	"to_number"		|	"转为数值型"
	|	"to_single_byte"|	"转为单字节型"
	;

//系统函数
system_function
	:	"uid"		|	"求标识编号"
	|	"user"		|	"求当前用户"
	|	"userenv"	|	"求当前用户环境信息"
	|	"vsize"		|	"求字段大小"
	;

//其他函数
other_function
	:	"decode"	|	"求比较结果"
	|	"dump"		|	"返回数据格式"
	| 	"empty_blob"|	"初始化BLOB"
	|	"empty_clob"|	"初始化CLOB"
	|	"greatest"	|	"求字符串最大值"
	|	"least"		|	"求字符串最小值"
	|	"nvl"		|	"求非空值"
	;


//日期date-part保留字
date_key_word
	: "year" | "yy" | "yyyy" | "month" | "mm" | "m" | "day" | "dd" | "d"
	| "quarter" | "qq" | "q" | "week" | "wk" | "w" 
	| "dayofyear" | "dy" | "y" | "weekday" | "dw" 
	| "hour" | "hh" | "hh12" | "hh24" | "minute" | "mi" | "n"| "second" | "ss" | "s" | "millisecond" | "ms"
	;

//数据类型保留字
data_type_word
	:
	| "long" //| "long" "raw"
	| "date"
	| "rowid"
	| "clob" | "nclob" | "blob" | "bfile"
	;
