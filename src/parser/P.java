// $ANTLR 2.7.7 (2006-11-01): "src/parser/parser.g" -> "P.java"$

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

public class P extends antlr.LLkParser       implements PTokenTypes
 {

protected P(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public P(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected P(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public P(TokenStream lexer) {
  this(lexer,3);
}

public P(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void query() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST query_AST = null;
		
		statement();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop3:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop3;
			}
			
		} while (true);
		}
		query_AST = (AST)currentAST.root;
		returnAST = query_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		switch ( LA(1)) {
		case TABLE_UNION:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case TABLE_COMPARE:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case TABLE_SELECT:
		{
			tableSelect();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = statement_AST;
	}
	
	public final void tableUnion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableUnion_AST = null;
		
		AST tmp15_AST = null;
		tmp15_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp15_AST);
		match(TABLE_UNION);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		match(COMMA);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		match(INTO);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		tableUnion_AST = (AST)currentAST.root;
		returnAST = tableUnion_AST;
	}
	
	public final void tableCompare() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableCompare_AST = null;
		
		AST tmp18_AST = null;
		tmp18_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp18_AST);
		match(TABLE_COMPARE);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		match(COMMA);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		match(INTO);
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		match(WHERE);
		method();
		astFactory.addASTChild(currentAST, returnAST);
		equations();
		astFactory.addASTChild(currentAST, returnAST);
		tableCompare_AST = (AST)currentAST.root;
		returnAST = tableCompare_AST;
	}
	
	public final void tableSelect() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableSelect_AST = null;
		
		AST tmp22_AST = null;
		tmp22_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp22_AST);
		match(TABLE_SELECT);
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		match(FROM);
		tableList();
		astFactory.addASTChild(currentAST, returnAST);
		match(WHERE);
		equations();
		astFactory.addASTChild(currentAST, returnAST);
		tableSelect_AST = (AST)currentAST.root;
		returnAST = tableSelect_AST;
	}
	
	public final void tableName() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableName_AST = null;
		
		AST tmp25_AST = null;
		tmp25_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp25_AST);
		match(ID);
		tableName_AST = (AST)currentAST.root;
		returnAST = tableName_AST;
	}
	
	public final void method() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_AST = null;
		
		switch ( LA(1)) {
		case EXIST:
		{
			AST tmp26_AST = null;
			tmp26_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp26_AST);
			match(EXIST);
			method_AST = (AST)currentAST.root;
			break;
		}
		case NOT_EXIST:
		{
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp27_AST);
			match(NOT_EXIST);
			method_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = method_AST;
	}
	
	public final void equations() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equations_AST = null;
		
		equation();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LOGIC_OP:
		{
			AST tmp28_AST = null;
			tmp28_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp28_AST);
			match(LOGIC_OP);
			equations();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		equations_AST = (AST)currentAST.root;
		returnAST = equations_AST;
	}
	
	public final void columnList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST columnList_AST = null;
		
		column();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			AST tmp29_AST = null;
			tmp29_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp29_AST);
			match(COMMA);
			columnList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case FROM:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		columnList_AST = (AST)currentAST.root;
		returnAST = columnList_AST;
	}
	
	public final void tableList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableList_AST = null;
		
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop19:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp30_AST);
				match(COMMA);
				tableName();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop19;
			}
			
		} while (true);
		}
		tableList_AST = (AST)currentAST.root;
		returnAST = tableList_AST;
	}
	
	public final void column() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST column_AST = null;
		
		switch ( LA(1)) {
		case FUNC_NAME:
		{
			func();
			astFactory.addASTChild(currentAST, returnAST);
			column_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		case ID:
		case REAL_NUM:
		case QUOTED_STRING:
		{
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			column_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(STAR);
			if ( inputState.guessing==0 ) {
				column_AST = (AST)currentAST.root;
				column_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(ALL_FIELDS)));
				currentAST.root = column_AST;
				currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
					column_AST.getFirstChild() : column_AST;
				currentAST.advanceChildToEnd();
			}
			column_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = column_AST;
	}
	
	public final void func() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST func_AST = null;
		
		AST tmp32_AST = null;
		tmp32_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp32_AST);
		match(FUNC_NAME);
		match(LPAREN);
		match(RPAREN);
		func_AST = (AST)currentAST.root;
		returnAST = func_AST;
	}
	
	public final void equElem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equElem_AST = null;
		
		switch ( LA(1)) {
		case ID:
		case REAL_NUM:
		case QUOTED_STRING:
		{
			elem();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case STAR:
			case OPERATOR:
			{
				{
				switch ( LA(1)) {
				case OPERATOR:
				{
					AST tmp35_AST = null;
					tmp35_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp35_AST);
					match(OPERATOR);
					break;
				}
				case STAR:
				{
					AST tmp36_AST = null;
					tmp36_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp36_AST);
					match(STAR);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case FROM:
			case RPAREN:
			case LOGIC_OP:
			case COMPARATOR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			equElem_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(LPAREN);
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp38_AST = null;
			tmp38_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp38_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case OPERATOR:
			{
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp39_AST);
				match(OPERATOR);
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case FROM:
			case RPAREN:
			case LOGIC_OP:
			case COMPARATOR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			equElem_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = equElem_AST;
	}
	
	public final void funcArgs() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST funcArgs_AST = null;
		
		equElem();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop16:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp40_AST = null;
				tmp40_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp40_AST);
				match(COMMA);
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop16;
			}
			
		} while (true);
		}
		funcArgs_AST = (AST)currentAST.root;
		returnAST = funcArgs_AST;
	}
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equation_AST = null;
		
		equElem();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp41_AST = null;
		tmp41_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp41_AST);
		match(COMPARATOR);
		equElem();
		astFactory.addASTChild(currentAST, returnAST);
		equation_AST = (AST)currentAST.root;
		returnAST = equation_AST;
	}
	
	public final void elem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST elem_AST = null;
		
		switch ( LA(1)) {
		case ID:
		{
			fieldName();
			astFactory.addASTChild(currentAST, returnAST);
			elem_AST = (AST)currentAST.root;
			break;
		}
		case REAL_NUM:
		case QUOTED_STRING:
		{
			constant();
			astFactory.addASTChild(currentAST, returnAST);
			elem_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = elem_AST;
	}
	
	public final void fieldName() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fieldName_AST = null;
		
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp42_AST = null;
		tmp42_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp42_AST);
		match(POINT);
		AST tmp43_AST = null;
		tmp43_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp43_AST);
		match(ID);
		fieldName_AST = (AST)currentAST.root;
		returnAST = fieldName_AST;
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case REAL_NUM:
		{
			AST tmp44_AST = null;
			tmp44_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp44_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp45_AST = null;
			tmp45_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp45_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = constant_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"ALL_FIELDS",
		"\"equation start\"",
		"SEMI",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"WHERE",
		"TABLE_SELECT",
		"FROM",
		"STAR",
		"FUNC_NAME",
		"LPAREN",
		"RPAREN",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"COMPARATOR",
		"ID",
		"OPERATOR",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"WS",
		"ALL",
		"DISTINCT",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"EQU_RPAREN"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	
	}
