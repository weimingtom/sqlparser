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
			AST tmp27_AST = null;
			tmp27_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp27_AST);
			match(TABLE_SELECT);
			columnList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case COLUMN:
		{
			AST tmp28_AST = null;
			tmp28_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp28_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case FROM:
		{
			AST tmp29_AST = null;
			tmp29_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp29_AST);
			match(FROM);
			tableList();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp30_AST = null;
			tmp30_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp30_AST);
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
		
		{
		switch ( LA(1)) {
		case ALL:
		{
			AST tmp32_AST = null;
			tmp32_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp32_AST);
			match(ALL);
			break;
		}
		case DISTINCT:
		{
			AST tmp33_AST = null;
			tmp33_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp33_AST);
			match(DISTINCT);
			break;
		}
		case ALL_FIELDS:
		case ID:
		case STAR:
		case LPAREN:
		case NAME_START:
		case FUNC_NAME:
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
		columns();
		astFactory.addASTChild(currentAST, returnAST);
		columnList_AST = (AST)currentAST.root;
		returnAST = columnList_AST;
	}
	
	public final void column() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST column_AST = null;
		
		switch ( LA(1)) {
		case ID:
		case LPAREN:
		case NAME_START:
		case FUNC_NAME:
		case REAL_NUM:
		case QUOTED_STRING:
		case LITERAL_null:
		{
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			{
			switch ( LA(1)) {
			case AS:
			{
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp34_AST);
				match(AS);
				AST tmp35_AST = null;
				tmp35_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(ID);
				break;
			}
			case EOF:
			case FROM:
			case COMMA:
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
			column_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp36_AST = null;
			tmp36_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp36_AST);
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
		case ALL_FIELDS:
		{
			AST tmp37_AST = null;
			tmp37_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp37_AST);
			match(ALL_FIELDS);
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
		
		tableElem();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop36:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp38_AST);
				match(COMMA);
				tableElem();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop36;
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
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp39_AST);
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
			AST tmp40_AST = null;
			tmp40_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp40_AST);
			match(LPAREN);
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(EQUATION_START);
			equations();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case LOGIC_OP:
			{
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp43_AST);
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
		{
		switch ( LA(1)) {
		case WHERE:
		{
			AST tmp54_AST = null;
			tmp54_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp54_AST);
			match(WHERE);
			equations();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case GROUP_BY:
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
		case GROUP_BY:
		{
			AST tmp55_AST = null;
			tmp55_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp55_AST);
			match(GROUP_BY);
			columnList();
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
			AST tmp56_AST = null;
			tmp56_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp56_AST);
			match(ORDER_BY);
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
			tableSelect_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_STATEMENT)).add(tableSelect_AST));
			currentAST.root = tableSelect_AST;
			currentAST.child = tableSelect_AST!=null &&tableSelect_AST.getFirstChild()!=null ?
				tableSelect_AST.getFirstChild() : tableSelect_AST;
			currentAST.advanceChildToEnd();
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
			AST tmp57_AST = null;
			tmp57_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp57_AST);
			match(ID);
			tableName_AST = (AST)currentAST.root;
			break;
		}
		case NAME_START:
		{
			match(NAME_START);
			tableName();
			astFactory.addASTChild(currentAST, returnAST);
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
			AST tmp60_AST = null;
			tmp60_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp60_AST);
			match(EXIST);
			method_AST = (AST)currentAST.root;
			break;
		}
		case NOT_EXIST:
		{
			AST tmp61_AST = null;
			tmp61_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp61_AST);
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
	
	public final void orderClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST orderClause_AST = null;
		
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case ASC:
		{
			AST tmp62_AST = null;
			tmp62_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp62_AST);
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
		
		AST tmp63_AST = null;
		tmp63_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp63_AST);
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
	
	public final void groupClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST groupClause_AST = null;
		
		AST tmp66_AST = null;
		tmp66_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp66_AST);
		match(GROUP_BY);
		columnList();
		astFactory.addASTChild(currentAST, returnAST);
		groupClause_AST = (AST)currentAST.root;
		returnAST = groupClause_AST;
	}
	
	public final void unionClause() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST unionClause_AST = null;
		
		{
		int _cnt18=0;
		_loop18:
		do {
			if ((LA(1)==UNION)) {
				AST tmp67_AST = null;
				tmp67_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp67_AST);
				match(UNION);
				{
				switch ( LA(1)) {
				case ALL:
				{
					AST tmp68_AST = null;
					tmp68_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp68_AST);
					match(ALL);
					break;
				}
				case EOF:
				case UNION:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			else {
				if ( _cnt18>=1 ) { break _loop18; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt18++;
		} while (true);
		}
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
			AST tmp69_AST = null;
			tmp69_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp69_AST);
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
		
		switch ( LA(1)) {
		case ID:
		{
			AST tmp70_AST = null;
			tmp70_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp70_AST);
			match(ID);
			AST tmp71_AST = null;
			tmp71_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp71_AST);
			match(POINT);
			AST tmp72_AST = null;
			tmp72_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp72_AST);
			match(ID);
			fieldName_AST = (AST)currentAST.root;
			break;
		}
		case NAME_START:
		{
			match(NAME_START);
			fieldName();
			astFactory.addASTChild(currentAST, returnAST);
			match(NAME_END);
			fieldName_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = fieldName_AST;
	}
	
	public final void columns() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST columns_AST = null;
		
		column();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop25:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp75_AST = null;
				tmp75_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp75_AST);
				match(COMMA);
				column();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop25;
			}
			
		} while (true);
		}
		columns_AST = (AST)currentAST.root;
		returnAST = columns_AST;
	}
	
	public final void equElem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equElem_AST = null;
		
		switch ( LA(1)) {
		case ID:
		case NAME_START:
		case FUNC_NAME:
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
					AST tmp76_AST = null;
					tmp76_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp76_AST);
					match(OPERATOR);
					break;
				}
				case STAR:
				{
					AST tmp77_AST = null;
					tmp77_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp77_AST);
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
			case AS:
			case LOGIC_OP:
			case RPAREN:
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
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(LPAREN);
			equElem();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case OPERATOR:
			{
				AST tmp80_AST = null;
				tmp80_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp80_AST);
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
			case AS:
			case LOGIC_OP:
			case RPAREN:
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
		_loop32:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp81_AST = null;
				tmp81_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp81_AST);
				match(COMMA);
				equElem();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop32;
			}
			
		} while (true);
		}
		funcArgs_AST = (AST)currentAST.root;
		returnAST = funcArgs_AST;
	}
	
	public final void fromClauseTableList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST fromClauseTableList_AST = null;
		
		tableList();
		astFactory.addASTChild(currentAST, returnAST);
		fromClauseTableList_AST = (AST)currentAST.root;
		returnAST = fromClauseTableList_AST;
	}
	
	public final void tableElem() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableElem_AST = null;
		
		tableName();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case AS:
		{
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp82_AST);
			match(AS);
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp83_AST);
			match(ID);
			break;
		}
		case EOF:
		case WHERE:
		case COMMA:
		case GROUP_BY:
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
		tableElem_AST = (AST)currentAST.root;
		returnAST = tableElem_AST;
	}
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equation_AST = null;
		
		equElem();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp84_AST = null;
		tmp84_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp84_AST);
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
			elem_AST = (AST)currentAST.root;
			break;
		}
		case FUNC_NAME:
		{
			func();
			astFactory.addASTChild(currentAST, returnAST);
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
	
	public final void func() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST func_AST = null;
		
		AST tmp85_AST = null;
		tmp85_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp85_AST);
		match(FUNC_NAME);
		match(LPAREN);
		{
		switch ( LA(1)) {
		case ALL:
		{
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
			match(ALL);
			break;
		}
		case DISTINCT:
		{
			AST tmp88_AST = null;
			tmp88_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp88_AST);
			match(DISTINCT);
			break;
		}
		case ID:
		case LPAREN:
		case NAME_START:
		case FUNC_NAME:
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
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case REAL_NUM:
		{
			AST tmp90_AST = null;
			tmp90_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp90_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp91_AST = null;
			tmp91_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp91_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp92_AST = null;
			tmp92_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp92_AST);
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
		"UNION_CLAUSE",
		"ORDER_CLAUSE",
		"FIELD_NAME",
		"TABLE_SELECT",
		"COLUMN",
		"FROM",
		"WHERE",
		"TABLE_UNION",
		"COMMA",
		"INTO",
		"TABLE_COMPARE",
		"GROUP_BY",
		"ORDER_BY",
		"ASC",
		"UNION",
		"ALL",
		"DISTINCT",
		"AS",
		"ID",
		"STAR",
		"EXIST",
		"NOT_EXIST",
		"LOGIC_OP",
		"LPAREN",
		"RPAREN",
		"COMPARATOR",
		"NAME_START",
		"NAME_END",
		"OPERATOR",
		"FUNC_NAME",
		"POINT",
		"REAL_NUM",
		"QUOTED_STRING",
		"\"null\"",
		"BETWEEN",
		"ID_START_LETTER",
		"ID_LETTER",
		"DOT_NUM",
		"NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"SEMI",
		"WS",
		"ESC"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 4005124112384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 4357445648384L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	
	}
