// $ANTLR 2.7.7 (2006-11-01): "src/test/getting_start.g" -> "GSP.java"$

package test;

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

public class GSP extends antlr.LLkParser       implements GSPTokenTypes
 {

protected GSP(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public GSP(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected GSP(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public GSP(TokenStream lexer) {
  this(lexer,1);
}

public GSP(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void startRule() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST startRule_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_select:
			{
				AST tmp51_AST = null;
				tmp51_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp51_AST);
				match(LITERAL_select);
				break;
			}
			case 7:
			{
				AST tmp52_AST = null;
				tmp52_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp52_AST);
				match(7);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			identifier();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LITERAL_from:
			case 9:
			{
				{
				switch ( LA(1)) {
				case LITERAL_from:
				{
					AST tmp53_AST = null;
					tmp53_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp53_AST);
					match(LITERAL_from);
					break;
				}
				case 9:
				{
					AST tmp54_AST = null;
					tmp54_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp54_AST);
					match(9);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				identifier();
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
			match(Token.EOF_TYPE);
			startRule_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = startRule_AST;
	}
	
	public final void identifier() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST identifier_AST = null;
		
		try {      // for error handling
			AST tmp56_AST = null;
			tmp56_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp56_AST);
			match(ID);
			identifier_AST = (AST)currentAST.root;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		returnAST = identifier_AST;
	}
	
	public final void select() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_select:
			{
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp57_AST);
				match(LITERAL_select);
				select_AST = (AST)currentAST.root;
				break;
			}
			case 7:
			{
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp58_AST);
				match(7);
				select_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = select_AST;
	}
	
	public final void from() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST from_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_from:
			{
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp59_AST);
				match(LITERAL_from);
				from_AST = (AST)currentAST.root;
				break;
			}
			case 9:
			{
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp60_AST);
				match(9);
				from_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = from_AST;
	}
	
	public final void where() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST where_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_where:
			{
				AST tmp61_AST = null;
				tmp61_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp61_AST);
				match(LITERAL_where);
				where_AST = (AST)currentAST.root;
				break;
			}
			case 12:
			{
				AST tmp62_AST = null;
				tmp62_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp62_AST);
				match(12);
				where_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = where_AST;
	}
	
	public final void group_by() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST group_by_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case 13:
			{
				AST tmp63_AST = null;
				tmp63_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp63_AST);
				match(13);
				group_by_AST = (AST)currentAST.root;
				break;
			}
			case 14:
			{
				AST tmp64_AST = null;
				tmp64_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp64_AST);
				match(14);
				group_by_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = group_by_AST;
	}
	
	public final void order_by() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_by_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case 15:
			{
				AST tmp65_AST = null;
				tmp65_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp65_AST);
				match(15);
				order_by_AST = (AST)currentAST.root;
				break;
			}
			case 16:
			{
				AST tmp66_AST = null;
				tmp66_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp66_AST);
				match(16);
				order_by_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = order_by_AST;
	}
	
	public final void all() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST all_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_all:
			{
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp67_AST);
				match(LITERAL_all);
				all_AST = (AST)currentAST.root;
				break;
			}
			case 18:
			{
				AST tmp68_AST = null;
				tmp68_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp68_AST);
				match(18);
				all_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = all_AST;
	}
	
	public final void distinct() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST distinct_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_distinct:
			{
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(LITERAL_distinct);
				distinct_AST = (AST)currentAST.root;
				break;
			}
			case 20:
			{
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp70_AST);
				match(20);
				distinct_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = distinct_AST;
	}
	
	public final void asc() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asc_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_asc:
			{
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(LITERAL_asc);
				asc_AST = (AST)currentAST.root;
				break;
			}
			case 22:
			{
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
				match(22);
				asc_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = asc_AST;
	}
	
	public final void desc() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST desc_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_desc:
			{
				AST tmp73_AST = null;
				tmp73_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp73_AST);
				match(LITERAL_desc);
				desc_AST = (AST)currentAST.root;
				break;
			}
			case 24:
			{
				AST tmp74_AST = null;
				tmp74_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp74_AST);
				match(24);
				desc_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = desc_AST;
	}
	
	public final void as() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST as_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_as:
			{
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp75_AST);
				match(LITERAL_as);
				as_AST = (AST)currentAST.root;
				break;
			}
			case 26:
			{
				AST tmp76_AST = null;
				tmp76_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp76_AST);
				match(26);
				as_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = as_AST;
	}
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ONE_ARG_OP:
			{
				AST tmp77_AST = null;
				tmp77_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp77_AST);
				match(ONE_ARG_OP);
				one_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 28:
			{
				AST tmp78_AST = null;
				tmp78_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp78_AST);
				match(28);
				one_arg_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = one_arg_op_AST;
	}
	
	public final void two_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST two_arg_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case TWO_ARG_OP:
			{
				AST tmp79_AST = null;
				tmp79_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp79_AST);
				match(TWO_ARG_OP);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 30:
			{
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp80_AST);
				match(30);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 31:
			{
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp81_AST);
				match(31);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 32:
			{
				AST tmp82_AST = null;
				tmp82_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp82_AST);
				match(32);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 33:
			{
				AST tmp83_AST = null;
				tmp83_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp83_AST);
				match(33);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 34:
			{
				AST tmp84_AST = null;
				tmp84_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp84_AST);
				match(34);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 35:
			{
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp85_AST);
				match(35);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 36:
			{
				AST tmp86_AST = null;
				tmp86_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp86_AST);
				match(36);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			case 37:
			{
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp87_AST);
				match(37);
				two_arg_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = two_arg_op_AST;
	}
	
	public final void compare_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compare_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case COMPARE_OP:
			{
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(COMPARE_OP);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_like:
			{
				AST tmp89_AST = null;
				tmp89_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp89_AST);
				match(LITERAL_like);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 40:
			{
				AST tmp90_AST = null;
				tmp90_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp90_AST);
				match(40);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 41:
			{
				AST tmp91_AST = null;
				tmp91_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp91_AST);
				match(41);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 42:
			{
				AST tmp92_AST = null;
				tmp92_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp92_AST);
				match(42);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 43:
			{
				AST tmp93_AST = null;
				tmp93_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp93_AST);
				match(43);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 44:
			{
				AST tmp94_AST = null;
				tmp94_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp94_AST);
				match(44);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 45:
			{
				AST tmp95_AST = null;
				tmp95_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp95_AST);
				match(45);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			case 46:
			{
				AST tmp96_AST = null;
				tmp96_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp96_AST);
				match(46);
				compare_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = compare_op_AST;
	}
	
	public final void is_null() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST is_null_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case 47:
			{
				AST tmp97_AST = null;
				tmp97_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp97_AST);
				match(47);
				is_null_AST = (AST)currentAST.root;
				break;
			}
			case 48:
			{
				AST tmp98_AST = null;
				tmp98_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp98_AST);
				match(48);
				is_null_AST = (AST)currentAST.root;
				break;
			}
			case 49:
			{
				AST tmp99_AST = null;
				tmp99_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp99_AST);
				match(49);
				is_null_AST = (AST)currentAST.root;
				break;
			}
			case 50:
			{
				AST tmp100_AST = null;
				tmp100_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp100_AST);
				match(50);
				is_null_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = is_null_AST;
	}
	
	public final void between() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST between_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_between:
			{
				AST tmp101_AST = null;
				tmp101_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp101_AST);
				match(LITERAL_between);
				between_AST = (AST)currentAST.root;
				break;
			}
			case 52:
			{
				AST tmp102_AST = null;
				tmp102_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp102_AST);
				match(52);
				between_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = between_AST;
	}
	
	public final void logic_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_op_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_and:
			{
				AST tmp103_AST = null;
				tmp103_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp103_AST);
				match(LITERAL_and);
				logic_op_AST = (AST)currentAST.root;
				break;
			}
			case LITERAL_or:
			{
				AST tmp104_AST = null;
				tmp104_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp104_AST);
				match(LITERAL_or);
				logic_op_AST = (AST)currentAST.root;
				break;
			}
			case 55:
			{
				AST tmp105_AST = null;
				tmp105_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp105_AST);
				match(55);
				logic_op_AST = (AST)currentAST.root;
				break;
			}
			case 56:
			{
				AST tmp106_AST = null;
				tmp106_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp106_AST);
				match(56);
				logic_op_AST = (AST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
		returnAST = logic_op_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SELECT",
		"FROM",
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"ID",
		"\"where\"",
		"\"\\u6761\\u4ef6\"",
		"\"group by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order by\"",
		"\"\\u6392\\u5e8f\"",
		"\"all\"",
		"\"\\u022b\\ufffd\\ufffd\\u5168\\u90e8\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"asc\"",
		"\"\\u5347\\u5e8f\"",
		"\"desc\"",
		"\"\\u964d\\u5e8f\"",
		"\"as\"",
		"\"\\u4f5c\\u4e3a\"",
		"ONE_ARG_OP",
		"\"\\u975e\"",
		"TWO_ARG_OP",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u6c42\\u6a21\"",
		"\"\\u5f02\\u6216\"",
		"COMPARE_OP",
		"\"like\"",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"is null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"is not null\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"and\"",
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"ALL_FIELDS",
		"EQU",
		"COMMA",
		"SEMI",
		"LPAREN",
		"RPAREN",
		"WS",
		"POINT",
		"QUOTED_STRING",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
		"REAL_NUM",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 770L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
