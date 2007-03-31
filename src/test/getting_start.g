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
    :   ("select"^|"\u67e5\u8be2"^) identifier 
    	(("from"^|"\u6765\u81ea"^) identifier)? EOF!
    ;

identifier : ID;
select : "select" | "\u67e5\u8be2";
from : "from" | "\u6765\u81ea";
where : "where" | "\u6761\u4ef6";
group_by : "group by" | "\u5206\u7ec4";
order_by : "order by" | "\u6392\u5e8f";
all : "all" | "\u022b\ufffd\ufffd\u5168\u90e8";
distinct : "distinct" | "\u552f\u4e00";
asc : "asc" | "\u5347\u5e8f";
desc : "desc" |"\u964d\u5e8f";
as : "as" | "\u4f5c\u4e3a";
one_arg_op
	:	ONE_ARG_OP | "\u975e";
two_arg_op
	:	TWO_ARG_OP
	|	"\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u4e0e" | "\u6216" | "\u6c42\u6a21" | "\u5f02\u6216";
compare_op
	:	COMPARE_OP | "like"
	|	"\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	|	"\u5305\u542b" | "\u4e0d\u5305\u542b";
is_null 
	:	"is null" | "\u4e3a\u7a7a" | "is not null" | "\u975e\u7a7a";
between
	:	"between" | "\u8303\u56f4";
logic_op
	:	"and" | "or"
	|	"\u5e76\u4e14" | "\u6216\u8005";


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
	: "select" | "\u67e5\u8be2"
	|"from" | "\u6765\u81ea"
	| "where" | "\u6761\u4ef6"
	| "group by" | "\u5206\u7ec4"
	| "order by" | "\u6392\u5e8f"
	| "all" | "\u022b\ufffd\ufffd\u5168\u90e8"
	| "distinct" | "\u552f\u4e00"
	| "asc" | "\u5347\u5e8f"
	| "desc" |"\u964d\u5e8f"
	| "as" | "\u4f5c\u4e3a"
	| ONE_ARG_OP | "\u975e"
	| TWO_ARG_OP
	|	"\u52a0" | "\u51cf" | "\u4e58" | "\u9664" | "\u4e0e" | "\u6216" | "\u6c42\u6a21" | "\u5f02\u6216"
	|	COMPARE_OP | "like"
	|	"\u5927\u4e8e\u7b49\u4e8e" | "\u5c0f\u4e8e\u7b49\u4e8e" | "\u5927\u4e8e" | "\u5c0f\u4e8e" | "\u4e0d\u7b49\u4e8e"
	|	"\u5305\u542b" | "\u4e0d\u5305\u542b"
	|	"is null" | "\u4e3a\u7a7a" | "is not null" | "\u975e\u7a7a"
	|	"between" | "\u8303\u56f4"
	|	"and" | "or"
	|	"\u5e76\u4e14" | "\u6216\u8005"
	;
	
