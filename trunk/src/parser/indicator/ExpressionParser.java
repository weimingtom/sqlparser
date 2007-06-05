// $ANTLR 2.7.7 (2006-11-01): "src/parser/indicator/expression.g" -> "ExpressionParser.java"$

	package parser.indicator;

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
  this(tokenBuf,2);
}

protected ExpressionParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ExpressionParser(TokenStream lexer) {
  this(lexer,2);
}

public ExpressionParser(ParserSharedInputState state) {
  super(state,2);
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
			if (((LA(1) >= PLUS && LA(1) <= MINUS_CN))) {
				{
				switch ( LA(1)) {
				case PLUS:
				{
					AST tmp61_AST = null;
					tmp61_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp61_AST);
					match(PLUS);
					break;
				}
				case PLUS_CN:
				{
					AST tmp62_AST = null;
					tmp62_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp62_AST);
					match(PLUS_CN);
					break;
				}
				case MINUS:
				{
					AST tmp63_AST = null;
					tmp63_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp63_AST);
					match(MINUS);
					break;
				}
				case MINUS_CN:
				{
					AST tmp64_AST = null;
					tmp64_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp64_AST);
					match(MINUS_CN);
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
			if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
				{
				switch ( LA(1)) {
				case MUL:
				{
					AST tmp65_AST = null;
					tmp65_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp65_AST);
					match(MUL);
					break;
				}
				case MUL_CN:
				{
					AST tmp66_AST = null;
					tmp66_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp66_AST);
					match(MUL_CN);
					break;
				}
				case MINUS:
				{
					AST tmp67_AST = null;
					tmp67_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp67_AST);
					match(MINUS);
					break;
				}
				case DIV:
				{
					AST tmp68_AST = null;
					tmp68_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp68_AST);
					match(DIV);
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
		case LPAREN:
		case NEGATIVE_NUMBER_ELEMENT:
		case NUMBER_ELEMENT:
		case VAR_ELEMENT:
		{
			constants();
			astFactory.addASTChild(currentAST, returnAST);
			atom_AST = (AST)currentAST.root;
			break;
		}
		case PI_CN:
		case PI_EN:
		case E_CN:
		case E_EN:
		{
			const_function();
			astFactory.addASTChild(currentAST, returnAST);
			atom_AST = (AST)currentAST.root;
			atom_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(CONST_FUNCTION_TOKEN,"const_function")).add(atom_AST));
			currentAST.root = atom_AST;
			currentAST.child = atom_AST!=null &&atom_AST.getFirstChild()!=null ?
				atom_AST.getFirstChild() : atom_AST;
			currentAST.advanceChildToEnd();
			atom_AST = (AST)currentAST.root;
			break;
		}
		case RANDOM_CN:
		case RANDOM_EN:
		{
			empty_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			match(RPAREN);
			atom_AST = (AST)currentAST.root;
			atom_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EMPTY_FUNCTION_TOKEN,"empty_function")).add(atom_AST));
			currentAST.root = atom_AST;
			currentAST.child = atom_AST!=null &&atom_AST.getFirstChild()!=null ?
				atom_AST.getFirstChild() : atom_AST;
			currentAST.advanceChildToEnd();
			atom_AST = (AST)currentAST.root;
			break;
		}
		case ABS_CN:
		case ABS_EN:
		case ACOS_CN:
		case ACOS_EN:
		case ASIN_CN:
		case ASIN_EN:
		case ATAN_CN:
		case ATAN_EN:
		case CEIL_CN:
		case CEIL_EN:
		case COS_CN:
		case COS_EN:
		case EXP_CN:
		case EXP_EN:
		case FLOOR_CN:
		case FLOOR_EN:
		case LOG_CN:
		case LOG_EN:
		case RINT_CN:
		case RINT_EN:
		case ROUND_CN:
		case ROUND_EN:
		case SIN_CN:
		case SIN_EN:
		case SQRT_CN:
		case SQRT_EN:
		case TAN_CN:
		case TAN_EN:
		case DEGREES_CN:
		case DEGREES_EN:
		case RADIANS_CN:
		case RADIANS_EN:
		{
			arithmetic_function1();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			parameters1();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			atom_AST = (AST)currentAST.root;
			atom_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARITHMETIC_FUNCTION1_TOKEN,"arithmetic_function1")).add(atom_AST));
			currentAST.root = atom_AST;
			currentAST.child = atom_AST!=null &&atom_AST.getFirstChild()!=null ?
				atom_AST.getFirstChild() : atom_AST;
			currentAST.advanceChildToEnd();
			atom_AST = (AST)currentAST.root;
			break;
		}
		case ATAN2_CN:
		case ATAN2_EN:
		case MAX_CN:
		case MAX_EN:
		case MIN_CN:
		case MIN_EN:
		case POW_CN:
		case POW_EN:
		case REMAINDER_CN:
		case REMAINDER_EN:
		{
			arithmetic_function2();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			parameters2();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			atom_AST = (AST)currentAST.root;
			atom_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ARITHMETIC_FUNCTION2_TOKEN,"arithmetic_function2")).add(atom_AST));
			currentAST.root = atom_AST;
			currentAST.child = atom_AST!=null &&atom_AST.getFirstChild()!=null ?
				atom_AST.getFirstChild() : atom_AST;
			currentAST.advanceChildToEnd();
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
	
	public final void constants() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constants_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		{
			match(LPAREN);
			expr();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			constants_AST = (AST)currentAST.root;
			constants_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EXPRESSION_BLOCK,"expression_block")).add(constants_AST));
			currentAST.root = constants_AST;
			currentAST.child = constants_AST!=null &&constants_AST.getFirstChild()!=null ?
				constants_AST.getFirstChild() : constants_AST;
			currentAST.advanceChildToEnd();
			constants_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_NUMBER_ELEMENT:
		{
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(NEGATIVE_NUMBER_ELEMENT);
			constants_AST = (AST)currentAST.root;
			break;
		}
		case NUMBER_ELEMENT:
		{
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(NUMBER_ELEMENT);
			constants_AST = (AST)currentAST.root;
			break;
		}
		case VAR_ELEMENT:
		{
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(VAR_ELEMENT);
			constants_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = constants_AST;
	}
	
	public final void const_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST const_function_AST = null;
		
		switch ( LA(1)) {
		case PI_CN:
		{
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp80_AST);
			match(PI_CN);
			const_function_AST = (AST)currentAST.root;
			break;
		}
		case PI_EN:
		{
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp81_AST);
			match(PI_EN);
			const_function_AST = (AST)currentAST.root;
			break;
		}
		case E_CN:
		{
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(E_CN);
			const_function_AST = (AST)currentAST.root;
			break;
		}
		case E_EN:
		{
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(E_EN);
			const_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = const_function_AST;
	}
	
	public final void empty_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST empty_function_AST = null;
		
		switch ( LA(1)) {
		case RANDOM_CN:
		{
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(RANDOM_CN);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case RANDOM_EN:
		{
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
			match(RANDOM_EN);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = empty_function_AST;
	}
	
	public final void arithmetic_function1() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arithmetic_function1_AST = null;
		
		switch ( LA(1)) {
		case ABS_CN:
		{
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(ABS_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ABS_EN:
		{
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(ABS_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ACOS_CN:
		{
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(ACOS_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ACOS_EN:
		{
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
			match(ACOS_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ASIN_CN:
		{
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(ASIN_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ASIN_EN:
		{
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(ASIN_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ATAN_CN:
		{
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
			match(ATAN_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ATAN_EN:
		{
			AST tmp93_AST = null;
			tmp93_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp93_AST);
			match(ATAN_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case CEIL_CN:
		{
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(CEIL_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case CEIL_EN:
		{
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
			match(CEIL_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case COS_CN:
		{
			AST tmp96_AST = null;
			tmp96_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp96_AST);
			match(COS_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case COS_EN:
		{
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
			match(COS_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case EXP_CN:
		{
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(EXP_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case EXP_EN:
		{
			AST tmp99_AST = null;
			tmp99_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp99_AST);
			match(EXP_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case FLOOR_CN:
		{
			AST tmp100_AST = null;
			tmp100_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp100_AST);
			match(FLOOR_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case FLOOR_EN:
		{
			AST tmp101_AST = null;
			tmp101_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp101_AST);
			match(FLOOR_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case LOG_CN:
		{
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(LOG_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case LOG_EN:
		{
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
			match(LOG_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case RINT_CN:
		{
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(RINT_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case RINT_EN:
		{
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
			match(RINT_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ROUND_CN:
		{
			AST tmp106_AST = null;
			tmp106_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp106_AST);
			match(ROUND_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case ROUND_EN:
		{
			AST tmp107_AST = null;
			tmp107_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp107_AST);
			match(ROUND_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case SIN_CN:
		{
			AST tmp108_AST = null;
			tmp108_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp108_AST);
			match(SIN_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case SIN_EN:
		{
			AST tmp109_AST = null;
			tmp109_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp109_AST);
			match(SIN_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case SQRT_CN:
		{
			AST tmp110_AST = null;
			tmp110_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp110_AST);
			match(SQRT_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case SQRT_EN:
		{
			AST tmp111_AST = null;
			tmp111_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp111_AST);
			match(SQRT_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case TAN_CN:
		{
			AST tmp112_AST = null;
			tmp112_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp112_AST);
			match(TAN_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case TAN_EN:
		{
			AST tmp113_AST = null;
			tmp113_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp113_AST);
			match(TAN_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case DEGREES_CN:
		{
			AST tmp114_AST = null;
			tmp114_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp114_AST);
			match(DEGREES_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case DEGREES_EN:
		{
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
			match(DEGREES_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case RADIANS_CN:
		{
			AST tmp116_AST = null;
			tmp116_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp116_AST);
			match(RADIANS_CN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		case RADIANS_EN:
		{
			AST tmp117_AST = null;
			tmp117_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp117_AST);
			match(RADIANS_EN);
			arithmetic_function1_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = arithmetic_function1_AST;
	}
	
	public final void parameters1() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameters1_AST = null;
		
		constants();
		astFactory.addASTChild(currentAST, returnAST);
		parameters1_AST = (AST)currentAST.root;
		returnAST = parameters1_AST;
	}
	
	public final void arithmetic_function2() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arithmetic_function2_AST = null;
		
		switch ( LA(1)) {
		case ATAN2_CN:
		{
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(ATAN2_CN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case ATAN2_EN:
		{
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp119_AST);
			match(ATAN2_EN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case MAX_CN:
		{
			AST tmp120_AST = null;
			tmp120_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp120_AST);
			match(MAX_CN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case MAX_EN:
		{
			AST tmp121_AST = null;
			tmp121_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp121_AST);
			match(MAX_EN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case MIN_CN:
		{
			AST tmp122_AST = null;
			tmp122_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp122_AST);
			match(MIN_CN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case MIN_EN:
		{
			AST tmp123_AST = null;
			tmp123_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp123_AST);
			match(MIN_EN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case POW_CN:
		{
			AST tmp124_AST = null;
			tmp124_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp124_AST);
			match(POW_CN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case POW_EN:
		{
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp125_AST);
			match(POW_EN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case REMAINDER_CN:
		{
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp126_AST);
			match(REMAINDER_CN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		case REMAINDER_EN:
		{
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp127_AST);
			match(REMAINDER_EN);
			arithmetic_function2_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = arithmetic_function2_AST;
	}
	
	public final void parameters2() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameters2_AST = null;
		
		constants();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp128_AST = null;
		tmp128_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp128_AST);
		match(COMMA);
		constants();
		astFactory.addASTChild(currentAST, returnAST);
		parameters2_AST = (AST)currentAST.root;
		returnAST = parameters2_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"EXPRESSION_BLOCK",
		"CONST_FUNCTION_TOKEN",
		"EMPTY_FUNCTION_TOKEN",
		"ARITHMETIC_FUNCTION1_TOKEN",
		"ARITHMETIC_FUNCTION2_TOKEN",
		"MINUS_TOKEN",
		"PLUS",
		"\"\\u52a0\"",
		"MINUS",
		"\"\\u51cf\"",
		"MUL",
		"\"\\u4e58\"",
		"DIV",
		"LPAREN",
		"RPAREN",
		"NEGATIVE_NUMBER_ELEMENT",
		"NUMBER_ELEMENT",
		"VAR_ELEMENT",
		"COMMA",
		"\"\\u6c42\\u5706\\u5468\\u7387\"",
		"\"PI\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\\u5e95\\u6570\"",
		"\"E\"",
		"\"\\u53d6\\u968f\\u673a\\u6570\"",
		"\"random\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"abs\"",
		"\"\\u6c42\\u53cd\\u4f59\\u5f26\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5f26\\u503c\"",
		"\"asin\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atan\"",
		"\"\\u53d6\\u4e0a\\u9650\\u6574\\u6570\"",
		"\"ceil\"",
		"\"\\u6c42\\u4f59\\u5f26\\u503c\"",
		"\"cos\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"exp\"",
		"\"\\u53d6\\u4e0b\\u9650\\u6574\\u6570\"",
		"\"floor\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log\"",
		"\"\\u53d6\\u6574\"",
		"\"rint\"",
		"\"\\u56db\\u820d\\u4e94\\u5165\"",
		"\"round\"",
		"\"\\u6c42\\u6b63\\u5f26\\u503c\"",
		"\"sin\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"sqrt\"",
		"\"\\u6c42\\u6b63\\u5207\\u503c\"",
		"\"tan\"",
		"\"\\u5f27\\u5ea6\\u8f6c\\u5ea6\\u6570\"",
		"\"toDegrees\"",
		"\"\\u5ea6\\u6570\\u8f6c\\u5f27\\u5ea6\"",
		"\"toRadians\"",
		"\"\\u6c42\\u4e8c\\u4e2a\\u6570\\u7684\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atan2\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u5e42\"",
		"\"pow\"",
		"\"\\u6c42\\u4f59\"",
		"\"IEEEremainder\"",
		"\"\\u9664\"",
		"POINT",
		"ELEM_START_LETTER",
		"ELEM_LETTER",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"SEMI",
		"WS",
		"ML_COMMENT"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 118784L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { -4587520L, 127L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
