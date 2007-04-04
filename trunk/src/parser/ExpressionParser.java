// $ANTLR 2.7.7 (2006-11-01): "src/parser/expression.g" -> "ExpressionParser.java"$

	package parser;

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

public class ExpressionParser extends antlr.LLkParser       implements ExpressionParserTokenTypes
 {

protected ExpressionParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExpressionParser(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected ExpressionParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExpressionParser(TokenStream lexer) {
  this(lexer,1);
}

public ExpressionParser(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expr_AST = null;
		
		sumExpr();
		astFactory.addASTChild(currentAST, returnAST);
		match(Token.EOF_TYPE);
		expr_AST = (AST)currentAST.root;
		returnAST = expr_AST;
	}
	
	public final void sumExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sumExpr_AST = null;
		
		prodExpr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop5:
		do {
			if ((LA(1)==PLUS||LA(1)==MINUS)) {
				{
				switch ( LA(1)) {
				case PLUS:
				{
					AST tmp17_AST = null;
					tmp17_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp17_AST);
					match(PLUS);
					break;
				}
				case MINUS:
				{
					AST tmp18_AST = null;
					tmp18_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp18_AST);
					match(MINUS);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				prodExpr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop5;
			}
			
		} while (true);
		}
		sumExpr_AST = (AST)currentAST.root;
		returnAST = sumExpr_AST;
	}
	
	public final void prodExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST prodExpr_AST = null;
		
		atom();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop9:
		do {
			if (((LA(1) >= MUL && LA(1) <= MOD))) {
				{
				switch ( LA(1)) {
				case MUL:
				{
					AST tmp19_AST = null;
					tmp19_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp19_AST);
					match(MUL);
					break;
				}
				case DIV:
				{
					AST tmp20_AST = null;
					tmp20_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp20_AST);
					match(DIV);
					break;
				}
				case MOD:
				{
					AST tmp21_AST = null;
					tmp21_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp21_AST);
					match(MOD);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				atom();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop9;
			}
			
		} while (true);
		}
		prodExpr_AST = (AST)currentAST.root;
		returnAST = prodExpr_AST;
	}
	
	public final void atom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST atom_AST = null;
		
		switch ( LA(1)) {
		case VAR_ELEMENT:
		{
			AST tmp22_AST = null;
			tmp22_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp22_AST);
			match(VAR_ELEMENT);
			atom_AST = (AST)currentAST.root;
			break;
		}
		case DIGIT_ELEMENT:
		{
			AST tmp23_AST = null;
			tmp23_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp23_AST);
			match(DIGIT_ELEMENT);
			atom_AST = (AST)currentAST.root;
			break;
		}
		case 14:
		{
			negative_sign();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp24_AST = null;
			tmp24_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp24_AST);
			match(DIGIT_ELEMENT);
			atom_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			AST tmp25_AST = null;
			tmp25_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp25_AST);
			match(LPAREN);
			sumExpr();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp26_AST = null;
			tmp26_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp26_AST);
			match(RPAREN);
			atom_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = atom_AST;
	}
	
	public final void powExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST powExpr_AST = null;
		
		atom();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case POW:
		{
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp27_AST);
			match(POW);
			atom();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		powExpr_AST = (AST)currentAST.root;
		returnAST = powExpr_AST;
	}
	
	public final void negative_sign() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST negative_sign_AST = null;
		
		AST tmp28_AST = null;
		tmp28_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp28_AST);
		match(14);
		negative_sign_AST = (AST)currentAST.root;
		returnAST = negative_sign_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"PLUS",
		"MINUS",
		"MUL",
		"DIV",
		"MOD",
		"POW",
		"VAR_ELEMENT",
		"DIGIT_ELEMENT",
		"LPAREN",
		"RPAREN",
		"\"-\"",
		"POINT",
		"SEMI",
		"WS",
		"ELEM_START_LETTER",
		"ELEM_LETTER",
		"DIGIT_START",
		"DIGIT_NEXT",
		"DIGIT_START_LETTER",
		"DIGIT_LETTER"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	
	}
