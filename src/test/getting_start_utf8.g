header {
package test;
}


class GSP extends Parser;
options {
	buildAST = true;
}

tokens {
	SELECT; FROM;
}

startRule
    :   ("select"^|"查询"^) identifier 
    	(("from"^|"来自"^) identifier)? EOF!
    ;

identifier : ID;
select : "select" | "查询";
from : "from" | "来自";
where : "where" | "条件";
group_by : "group by" | "分组";
order_by : "order by" | "排序";
all : "all" | "ȫ��全部";
distinct : "distinct" | "唯一";
asc : "asc" | "升序";
desc : "desc" |"降序";
as : "as" | "作为";
one_arg_op
	:	ONE_ARG_OP | "非";
two_arg_op
	:	TWO_ARG_OP
	|	"加" | "减" | "乘" | "除" | "与" | "或" | "求模" | "异或";
compare_op
	:	COMPARE_OP | "like"
	|	"大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	|	"包含" | "不包含";
is_null 
	:	"is null" | "为空" | "is not null" | "非空";
between
	:	"between" | "范围";
logic_op
	:	"and" | "or"
	|	"并且" | "或者";


class GSL extends Lexer;
options {
	k=5;
	charVocabulary = '\u0000' .. '\uFFFE';
	caseSensitive = false;
	caseSensitiveLiterals = true;
	testLiterals=false;
}
ONE_ARG_OP
	:	'~';
TWO_ARG_OP
	:	'&' | '|' | '^' | '+' | '-' | '*' | '/' | '%';
ALL_FIELDS
	:	"(*)";
EQU	:	'=';
COMPARE_OP
	:	'>' | '<' | ">=" | "<=" | "!=" | "<>";
COMMA
	:	',';
SEMI:	';';
LPAREN
	:	'(';
RPAREN
	:	')';

WS	:	(' '|'\n'|'\r'|'\t')+ {$setType(Token.SKIP);}
    ;

POINT
	:	'.';

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

ID options {testLiterals=true;}
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
	
class GST extends TreeParser;

keywords
	: "select" | "查询"
	|"from" | "来自"
	| "where" | "条件"
	| "group by" | "分组"
	| "order by" | "排序"
	| "all" | "ȫ��全部"
	| "distinct" | "唯一"
	| "asc" | "升序"
	| "desc" |"降序"
	| "as" | "作为"
	| ONE_ARG_OP | "非"
	| TWO_ARG_OP
	|	"加" | "减" | "乘" | "除" | "与" | "或" | "求模" | "异或"
	|	COMPARE_OP | "like"
	|	"大于等于" | "小于等于" | "大于" | "小于" | "不等于"
	|	"包含" | "不包含"
	|	"is null" | "为空" | "is not null" | "非空"
	|	"between" | "范围"
	|	"and" | "or"
	|	"并且" | "或者"
	;
	