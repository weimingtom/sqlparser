header {
package parser;
}

class GSP extends Parser;

startRule
    :   n:START
        {System.out.println("You input: "+n.getText());}
    ;

class GSL extends Lexer;
options {
	k=6;
}
START
	:	"start" | "开始";
