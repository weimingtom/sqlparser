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
  this(tokenBuf,5);
}

protected P(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public P(TokenStream lexer) {
  this(lexer,5);
}

public P(ParserSharedInputState state) {
  super(state,5);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final void segment() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST segment_AST = null;
		
		{
		switch ( LA(1)) {
		case TABLE_SELECT:
		{
			AST tmp29_AST = null;
			tmp29_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp29_AST);
			match(TABLE_SELECT);
			columnList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case COLUMN:
		{
			AST tmp30_AST = null;
			tmp30_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp30_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case FROM:
		{
			AST tmp31_AST = null;
			tmp31_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp31_AST);
			match(FROM);
			tableList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(WHERE);
			equations();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(Token.EOF_TYPE);
		segment_AST = (AST)currentAST.root;
		returnAST = segment_AST;
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
			AST tmp34_AST = null;
			tmp34_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp34_AST);
			match(COMMA);
			columnList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case FROM:
		case ORDER_BY:
		case ASC:
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
		case NAME_START:
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
		{
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			column_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp35_AST = null;
			tmp35_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp35_AST);
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
	
	public final void tableList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableList_AST = null;
		
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop34:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp36_AST);
				match(COMMA);
				tableName();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop34;
			}
			
		} while (true);
		}
		tableList_AST = (AST)currentAST.root;
		returnAST = tableList_AST;
	}
	
	public final void equations() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equations_AST = null;
		
		if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
			equation();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case LOGIC_OP:
			{
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp37_AST);
				match(LOGIC_OP);
				equations();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case GROUP_BY:
			case ORDER_BY:
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				equations_AST = (AST)currentAST.root;
				equations_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(EQUATION_START)).add(equations_AST));
				currentAST.root = equations_AST;
				currentAST.child = equations_AST!=null &&equations_AST.getFirstChild()!=null ?
					equations_AST.getFirstChild() : equations_AST;
				currentAST.advanceChildToEnd();
			}
			equations_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LPAREN) && (LA(2)==EQUATION_START)) {
			AST tmp38_AST = null;
			tmp38_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp38_AST);
			match(LPAREN);
			AST tmp39_AST = null;
			tmp39_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp39_AST);
			match(EQUATION_START);
			equations();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp40_AST = null;
			tmp40_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp40_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LOGIC_OP:
			{
				AST tmp41_AST = null;
				tmp41_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp41_AST);
				match(LOGIC_OP);
				equations();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case GROUP_BY:
			case ORDER_BY:
			case RPAREN:
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
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = equations_AST;
	}
	
	public final void query() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST query_AST = null;
		
		statement();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop5:
		do {
			if ((LA(1)==SEMI)) {
				match(SEMI);
				statement();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop5;
			}
			
		} while (true);
		}
		match(Token.EOF_TYPE);
		query_AST = (AST)currentAST.root;
		returnAST = query_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		{
		switch ( LA(1)) {
		case TABLE_UNION:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TABLE_COMPARE:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case TABLE_SELECT:
		{
			tableSelect();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		match(Token.EOF_TYPE);
		statement_AST = (AST)currentAST.root;
		returnAST = statement_AST;
	}
	
	public final void tableUnion() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableUnion_AST = null;
		
		AST tmp45_AST = null;
		tmp45_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp45_AST);
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
		
		AST tmp48_AST = null;
		tmp48_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp48_AST);
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
		
		AST tmp52_AST = null;
		tmp52_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp52_AST);
		match(TABLE_SELECT);
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		match(FROM);
		tableList();
		astFactory.addASTChild(currentAST, returnAST);
		match(WHERE);
		equations();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case GROUP_BY:
		{
			groupClause();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case ORDER_BY:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case ORDER_BY:
		{
			orderClause();
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
		if ( inputState.guessing==0 ) {
			tableSelect_AST = (AST)currentAST.root;
			
						tableSelect_AST.addChild(astFactory.create(GROUP_CLAUSE, "G_C"));
						tableSelect_AST.addChild(astFactory.create(ORDER_CLAUSE, "O_C"));
			//			System.out.println(#tableSelect.toStringList());
					
		}
		tableSelect_AST = (AST)currentAST.root;
		returnAST = tableSelect_AST;
	}
	
	public final void tableName() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableName_AST = null;
		
		switch ( LA(1)) {
		case ID:
		{
			AST tmp55_AST = null;
			tmp55_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp55_AST);
			match(ID);
			tableName_AST = (AST)currentAST.root;
			break;
		}
		case NAME_START:
		{
			match(NAME_START);
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(ID);
			match(NAME_END);
			tableName_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = tableName_AST;
	}
	
	public final void method() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST method_AST = null;
		
		switch ( LA(1)) {
		case EXIST:
		{
			AST tmp59_AST = null;
			tmp59_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp59_AST);
			match(EXIST);
			method_AST = (AST)currentAST.root;
			break;
		}
		case NOT_EXIST:
		{
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
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
	
	public final void groupClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST groupClause_AST = null;
		
		AST tmp61_AST = null;
		tmp61_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp61_AST);
		match(GROUP_BY);
		{
		switch ( LA(1)) {
		case ALL:
		{
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp62_AST);
			match(ALL);
			break;
		}
		case STAR:
		case FUNC_NAME:
		case LPAREN:
		case ID:
		case NAME_START:
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		groupClause_AST = (AST)currentAST.root;
		returnAST = groupClause_AST;
	}
	
	public final void orderClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST orderClause_AST = null;
		
		AST tmp63_AST = null;
		tmp63_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp63_AST);
		match(ORDER_BY);
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case ASC:
		{
			AST tmp64_AST = null;
			tmp64_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp64_AST);
			match(ASC);
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
		orderClause_AST = (AST)currentAST.root;
		returnAST = orderClause_AST;
	}
	
	public final void selectClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST selectClause_AST = null;
		
		AST tmp65_AST = null;
		tmp65_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp65_AST);
		match(TABLE_SELECT);
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		match(FROM);
		tableList();
		astFactory.addASTChild(currentAST, returnAST);
		match(WHERE);
		equations();
		astFactory.addASTChild(currentAST, returnAST);
		selectClause_AST = (AST)currentAST.root;
		returnAST = selectClause_AST;
	}
	
	public final void unionClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unionClause_AST = null;
		
		AST tmp68_AST = null;
		tmp68_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp68_AST);
		match(UNION);
		{
		switch ( LA(1)) {
		case ALL:
		{
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp69_AST);
			match(ALL);
			break;
		}
		case TABLE_SELECT:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		tableSelect();
		astFactory.addASTChild(currentAST, returnAST);
		unionClause_AST = (AST)currentAST.root;
		returnAST = unionClause_AST;
	}
	
	public final void fieldList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fieldList_AST = null;
		
		fieldName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case COMMA:
		{
			AST tmp70_AST = null;
			tmp70_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp70_AST);
			match(COMMA);
			fieldList();
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
		fieldList_AST = (AST)currentAST.root;
		returnAST = fieldList_AST;
	}
	
	public final void fieldName() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fieldName_AST = null;
		
		if ((LA(1)==ID||LA(1)==NAME_START) && (LA(2)==ID||LA(2)==POINT) && (LA(3)==ID||LA(3)==NAME_END) && (_tokenSet_2.member(LA(4))) && (_tokenSet_3.member(LA(5)))) {
			tableName();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp71_AST);
			match(POINT);
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp72_AST);
			match(ID);
			fieldName_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==NAME_START) && (LA(2)==ID||LA(2)==NAME_START) && (LA(3)==ID||LA(3)==NAME_START||LA(3)==POINT) && (_tokenSet_4.member(LA(4))) && (_tokenSet_4.member(LA(5)))) {
			match(NAME_START);
			fieldName();
			astFactory.addASTChild(currentAST, returnAST);
			match(NAME_END);
			fieldName_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = fieldName_AST;
	}
	
	public final void func() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST func_AST = null;
		
		AST tmp75_AST = null;
		tmp75_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp75_AST);
		match(FUNC_NAME);
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ALL:
		{
			AST tmp77_AST = null;
			tmp77_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp77_AST);
			match(ALL);
			break;
		}
		case DISTINCT:
		{
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(DISTINCT);
			break;
		}
		case LPAREN:
		case ID:
		case NAME_START:
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		funcArgs();
		astFactory.addASTChild(currentAST, returnAST);
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
		case NAME_START:
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
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
					AST tmp80_AST = null;
					tmp80_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp80_AST);
					match(OPERATOR);
					break;
				}
				case STAR:
				{
					AST tmp81_AST = null;
					tmp81_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp81_AST);
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
			case FROM:
			case COMMA:
			case GROUP_BY:
			case ORDER_BY:
			case ASC:
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
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp82_AST);
			match(LPAREN);
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case OPERATOR:
			{
				AST tmp84_AST = null;
				tmp84_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp84_AST);
				match(OPERATOR);
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case EOF:
			case FROM:
			case COMMA:
			case GROUP_BY:
			case ORDER_BY:
			case ASC:
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
		_loop31:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp85_AST = null;
				tmp85_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp85_AST);
				match(COMMA);
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop31;
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
		AST tmp86_AST = null;
		tmp86_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp86_AST);
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
		case NAME_START:
		{
			fieldName();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case AS:
			{
				AST tmp87_AST = null;
				tmp87_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp87_AST);
				match(AS);
				AST tmp88_AST = null;
				tmp88_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp88_AST);
				match(ID);
				break;
			}
			case EOF:
			case FROM:
			case COMMA:
			case GROUP_BY:
			case ORDER_BY:
			case ASC:
			case STAR:
			case RPAREN:
			case LOGIC_OP:
			case COMPARATOR:
			case OPERATOR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			elem_AST = (AST)currentAST.root;
			break;
		}
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
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
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case REAL_NUM:
		{
			AST tmp89_AST = null;
			tmp89_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp89_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(LITERAL_null);
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
		"EQUATION_START",
		"SELECT_STATEMENT",
		"GROUP_CLAUSE",
		"ORDER_CLAUSE",
		"TABLE_SELECT",
		"COLUMN",
		"FROM",
		"WHERE",
		"SEMI",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"GROUP_BY",
		"ALL",
		"ORDER_BY",
		"ASC",
		"UNION",
		"STAR",
		"FUNC_NAME",
		"LPAREN",
		"DISTINCT",
		"RPAREN",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"COMPARATOR",
		"ID",
		"NAME_START",
		"NAME_END",
		"OPERATOR",
		"AS",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"\"null\"",
		"BETWEEN",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"WS",
		"ESC"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 1937063804928L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 2111018369024L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 261065312258L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 2060707473410L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 167503724544L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	
	}
