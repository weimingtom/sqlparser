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
		case COLUMN:
		{
			AST tmp233_AST = null;
			tmp233_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp233_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp234_AST = null;
			tmp234_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp234_AST);
			match(WHERE);
			search_condition();
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
	
	public final void column() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST column_AST = null;
		Token  all = null;
		AST all_AST = null;
		
		switch ( LA(1)) {
		case 48:
		{
			all = LT(1);
			all_AST = astFactory.create(all);
			astFactory.addASTChild(currentAST, all_AST);
			match(48);
			if ( inputState.guessing==0 ) {
				column_AST = (AST)currentAST.root;
				column_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(ALL_FIELDS,all.getText())));
				currentAST.root = column_AST;
				currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
					column_AST.getFirstChild() : column_AST;
				currentAST.advanceChildToEnd();
			}
			column_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(STAR);
			if ( inputState.guessing==0 ) {
				column_AST = (AST)currentAST.root;
				column_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(ALL_FIELDS,"*")));
				currentAST.root = column_AST;
				currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
					column_AST.getFirstChild() : column_AST;
				currentAST.advanceChildToEnd();
			}
			column_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2)))) {
				expression_with_aggr_func();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case LITERAL_as:
				case 45:
				{
					{
					switch ( LA(1)) {
					case LITERAL_as:
					{
						AST tmp237_AST = null;
						tmp237_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp237_AST);
						match(LITERAL_as);
						break;
					}
					case 45:
					{
						AST tmp238_AST = null;
						tmp238_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp238_AST);
						match(45);
						break;
					}
					default:
					{
						throw new NoViableAltException(LT(1), getFilename());
					}
					}
					}
					alias();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case EOF:
				case SEMI:
				case COMMA:
				case LITERAL_where:
				case 24:
				case LITERAL_from:
				case 30:
				case LITERAL_group:
				case 33:
				case LITERAL_order:
				case 35:
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
				column_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==46||LA(2)==47)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 46:
				{
					AST tmp239_AST = null;
					tmp239_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp239_AST);
					match(46);
					break;
				}
				case 47:
				{
					AST tmp240_AST = null;
					tmp240_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp240_AST);
					match(47);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expression_with_aggr_func();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					column_AST = (AST)currentAST.root;
					column_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ALIAS_EQU,"=")).add(column_AST));
					currentAST.root = column_AST;
					currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
						column_AST.getFirstChild() : column_AST;
					currentAST.advanceChildToEnd();
				}
				column_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = column_AST;
	}
	
	public final void search_condition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST search_condition_AST = null;
		
		if ((_tokenSet_2.member(LA(1)))) {
			bool_exp();
			astFactory.addASTChild(currentAST, returnAST);
			search_condition_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LITERAL_not||LA(1)==37)) {
			{
			switch ( LA(1)) {
			case LITERAL_not:
			{
				AST tmp241_AST = null;
				tmp241_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp241_AST);
				match(LITERAL_not);
				break;
			}
			case 37:
			{
				AST tmp242_AST = null;
				tmp242_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp242_AST);
				match(37);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			search_condition();
			astFactory.addASTChild(currentAST, returnAST);
			search_condition_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = search_condition_AST;
	}
	
	public final void statements() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statements_AST = null;
		
		statement();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop5:
		do {
			if ((LA(1)==SEMI)) {
				AST tmp243_AST = null;
				tmp243_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp243_AST);
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
		statements_AST = (AST)currentAST.root;
		returnAST = statements_AST;
	}
	
	public final void statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST statement_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_t_union:
		case 19:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_t_compare:
		case 22:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_select:
		case 26:
		{
			select_statement();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				statement_AST = (AST)currentAST.root;
				statement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_STATEMENT)).add(statement_AST));
				currentAST.root = statement_AST;
				currentAST.child = statement_AST!=null &&statement_AST.getFirstChild()!=null ?
					statement_AST.getFirstChild() : statement_AST;
				currentAST.advanceChildToEnd();
			}
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
		
		{
		switch ( LA(1)) {
		case LITERAL_t_union:
		{
			AST tmp245_AST = null;
			tmp245_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp245_AST);
			match(LITERAL_t_union);
			break;
		}
		case 19:
		{
			AST tmp246_AST = null;
			tmp246_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp246_AST);
			match(19);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		match(COMMA);
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		tableUnion_AST = (AST)currentAST.root;
		returnAST = tableUnion_AST;
	}
	
	public final void tableCompare() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST tableCompare_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_t_compare:
		{
			AST tmp248_AST = null;
			tmp248_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp248_AST);
			match(LITERAL_t_compare);
			break;
		}
		case 22:
		{
			AST tmp249_AST = null;
			tmp249_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp249_AST);
			match(22);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		match(COMMA);
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LITERAL_where:
		{
			match(LITERAL_where);
			break;
		}
		case 24:
		{
			match(24);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		comparemethod_name();
		astFactory.addASTChild(currentAST, returnAST);
		search_condition();
		astFactory.addASTChild(currentAST, returnAST);
		tableCompare_AST = (AST)currentAST.root;
		returnAST = tableCompare_AST;
	}
	
	public final void select_statement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_statement_AST = null;
		
		{
		switch ( LA(1)) {
		case LITERAL_select:
		{
			AST tmp253_AST = null;
			tmp253_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp253_AST);
			match(LITERAL_select);
			break;
		}
		case 26:
		{
			AST tmp254_AST = null;
			tmp254_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp254_AST);
			match(26);
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
		case LITERAL_distinct:
		{
			AST tmp255_AST = null;
			tmp255_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp255_AST);
			match(LITERAL_distinct);
			break;
		}
		case 28:
		{
			AST tmp256_AST = null;
			tmp256_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp256_AST);
			match(28);
			break;
		}
		default:
			if ((_tokenSet_3.member(LA(1)))) {
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		select_list();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LITERAL_from:
		case 30:
		{
			{
			switch ( LA(1)) {
			case LITERAL_from:
			{
				AST tmp257_AST = null;
				tmp257_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp257_AST);
				match(LITERAL_from);
				break;
			}
			case 30:
			{
				AST tmp258_AST = null;
				tmp258_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp258_AST);
				match(30);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			table_list();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
		case LITERAL_where:
		case 24:
		case LITERAL_group:
		case 33:
		case LITERAL_order:
		case 35:
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
		{
		switch ( LA(1)) {
		case LITERAL_where:
		case 24:
		{
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				AST tmp259_AST = null;
				tmp259_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp259_AST);
				match(LITERAL_where);
				break;
			}
			case 24:
			{
				AST tmp260_AST = null;
				tmp260_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp260_AST);
				match(24);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			search_condition();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
		case LITERAL_group:
		case 33:
		case LITERAL_order:
		case 35:
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
		{
		switch ( LA(1)) {
		case LITERAL_group:
		case 33:
		{
			{
			switch ( LA(1)) {
			case LITERAL_group:
			{
				AST tmp261_AST = null;
				tmp261_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp261_AST);
				match(LITERAL_group);
				match(LITERAL_by);
				break;
			}
			case 33:
			{
				AST tmp263_AST = null;
				tmp263_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp263_AST);
				match(33);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			aggregate_expression_list();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
		case LITERAL_order:
		case 35:
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
		{
		switch ( LA(1)) {
		case LITERAL_order:
		case 35:
		{
			{
			switch ( LA(1)) {
			case LITERAL_order:
			{
				AST tmp264_AST = null;
				tmp264_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp264_AST);
				match(LITERAL_order);
				match(LITERAL_by);
				break;
			}
			case 35:
			{
				AST tmp266_AST = null;
				tmp266_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp266_AST);
				match(35);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			order_expression_list();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
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
		select_statement_AST = (AST)currentAST.root;
		returnAST = select_statement_AST;
	}
	
	public final void table_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_name_AST = null;
		
		AST tmp267_AST = null;
		tmp267_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp267_AST);
		match(ID);
		{
		switch ( LA(1)) {
		case LITERAL_as:
		case 45:
		{
			{
			switch ( LA(1)) {
			case LITERAL_as:
			{
				AST tmp268_AST = null;
				tmp268_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp268_AST);
				match(LITERAL_as);
				break;
			}
			case 45:
			{
				AST tmp269_AST = null;
				tmp269_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp269_AST);
				match(45);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			alias();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case EOF:
		case SEMI:
		case COMMA:
		case LITERAL_where:
		case 24:
		case LITERAL_group:
		case 33:
		case LITERAL_order:
		case 35:
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
		table_name_AST = (AST)currentAST.root;
		returnAST = table_name_AST;
	}
	
	public final void comparemethod_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparemethod_name_AST = null;
		
		switch ( LA(1)) {
		case 236:
		{
			AST tmp270_AST = null;
			tmp270_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp270_AST);
			match(236);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 237:
		{
			AST tmp271_AST = null;
			tmp271_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp271_AST);
			match(237);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exists:
		{
			AST tmp272_AST = null;
			tmp272_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp272_AST);
			match(LITERAL_exists);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 239:
		{
			AST tmp273_AST = null;
			tmp273_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp273_AST);
			match(239);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = comparemethod_name_AST;
	}
	
	public final void select_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;
		
		column();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop25:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp274_AST = null;
				tmp274_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp274_AST);
				match(COMMA);
				column();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop25;
			}
			
		} while (true);
		}
		select_list_AST = (AST)currentAST.root;
		returnAST = select_list_AST;
	}
	
	public final void table_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_list_AST = null;
		
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop28:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp275_AST = null;
				tmp275_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp275_AST);
				match(COMMA);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop28;
			}
			
		} while (true);
		}
		table_list_AST = (AST)currentAST.root;
		returnAST = table_list_AST;
	}
	
	public final void aggregate_expression_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_expression_list_AST = null;
		
		aggregate_expr();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop40:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp276_AST = null;
				tmp276_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp276_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop40;
			}
			
		} while (true);
		}
		aggregate_expression_list_AST = (AST)currentAST.root;
		returnAST = aggregate_expression_list_AST;
	}
	
	public final void order_expression_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_expression_list_AST = null;
		
		order_expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop43:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp277_AST = null;
				tmp277_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp277_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop43;
			}
			
		} while (true);
		}
		order_expression_list_AST = (AST)currentAST.root;
		returnAST = order_expression_list_AST;
	}
	
	public final void bool_exp() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bool_exp_AST = null;
		
		bool_term();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop34:
		do {
			if (((LA(1) >= LITERAL_and && LA(1) <= 41))) {
				{
				switch ( LA(1)) {
				case LITERAL_and:
				{
					AST tmp278_AST = null;
					tmp278_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp278_AST);
					match(LITERAL_and);
					break;
				}
				case LITERAL_or:
				{
					AST tmp279_AST = null;
					tmp279_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp279_AST);
					match(LITERAL_or);
					break;
				}
				case 40:
				{
					AST tmp280_AST = null;
					tmp280_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp280_AST);
					match(40);
					break;
				}
				case 41:
				{
					AST tmp281_AST = null;
					tmp281_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp281_AST);
					match(41);
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				bool_term();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop34;
			}
			
		} while (true);
		}
		bool_exp_AST = (AST)currentAST.root;
		returnAST = bool_exp_AST;
	}
	
	public final void bool_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bool_term_AST = null;
		AST exp_AST = null;
		
		boolean synPredMatched37 = false;
		if (((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_4.member(LA(3))) && (_tokenSet_5.member(LA(4))) && (_tokenSet_6.member(LA(5))))) {
			int _m37 = mark();
			synPredMatched37 = true;
			inputState.guessing++;
			try {
				{
				match(LPAREN);
				bool_exp();
				match(RPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched37 = false;
			}
			rewind(_m37);
inputState.guessing--;
		}
		if ( synPredMatched37 ) {
			match(LPAREN);
			bool_exp();
			exp_AST = (AST)returnAST;
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				bool_term_AST = (AST)currentAST.root;
				bool_term_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGIC_BLOCK,"log_block")).add(bool_term_AST));
				currentAST.root = bool_term_AST;
				currentAST.child = bool_term_AST!=null &&bool_term_AST.getFirstChild()!=null ?
					bool_term_AST.getFirstChild() : bool_term_AST;
				currentAST.advanceChildToEnd();
			}
			bool_term_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_4.member(LA(2))) && (_tokenSet_7.member(LA(3))) && (_tokenSet_8.member(LA(4))) && (_tokenSet_9.member(LA(5)))) {
			equation();
			astFactory.addASTChild(currentAST, returnAST);
			bool_term_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = bool_term_AST;
	}
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equation_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case 46:
		case 47:
		case COMPARE_OP:
		case LITERAL_like:
		case 229:
		case 230:
		case 231:
		case 232:
		case 233:
		case 234:
		case 235:
		{
			{
			switch ( LA(1)) {
			case 46:
			{
				AST tmp284_AST = null;
				tmp284_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp284_AST);
				match(46);
				break;
			}
			case 47:
			case COMPARE_OP:
			case LITERAL_like:
			case 229:
			case 230:
			case 231:
			case 232:
			case 233:
			case 234:
			case 235:
			{
				compare_op();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				equation_AST = (AST)currentAST.root;
				equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE_OP,"comp_op")).add(equation_AST));
				currentAST.root = equation_AST;
				currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
					equation_AST.getFirstChild() : equation_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LITERAL_is:
		case 56:
		case 57:
		{
			{
			switch ( LA(1)) {
			case 56:
			{
				AST tmp285_AST = null;
				tmp285_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp285_AST);
				match(56);
				break;
			}
			case 57:
			{
				AST tmp286_AST = null;
				tmp286_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp286_AST);
				match(57);
				break;
			}
			default:
				if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_null)) {
					match(LITERAL_is);
					AST tmp288_AST = null;
					tmp288_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp288_AST);
					match(LITERAL_null);
				}
				else if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_not)) {
					match(LITERAL_is);
					AST tmp290_AST = null;
					tmp290_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp290_AST);
					match(LITERAL_not);
					match(LITERAL_null);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case LITERAL_between:
		case 59:
		{
			{
			switch ( LA(1)) {
			case LITERAL_between:
			{
				AST tmp292_AST = null;
				tmp292_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp292_AST);
				match(LITERAL_between);
				break;
			}
			case 59:
			{
				AST tmp293_AST = null;
				tmp293_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp293_AST);
				match(59);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			{
			if ((LA(1)==LITERAL_and)) {
				match(LITERAL_and);
			}
			else if ((_tokenSet_2.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case 60:
		case LITERAL_in:
		case 62:
		case 63:
		{
			{
			switch ( LA(1)) {
			case 60:
			{
				AST tmp295_AST = null;
				tmp295_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp295_AST);
				match(60);
				break;
			}
			case LITERAL_in:
			{
				AST tmp296_AST = null;
				tmp296_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp296_AST);
				match(LITERAL_in);
				break;
			}
			case 62:
			{
				AST tmp297_AST = null;
				tmp297_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp297_AST);
				match(62);
				break;
			}
			case 63:
			{
				AST tmp298_AST = null;
				tmp298_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp298_AST);
				match(63);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			exp_set();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		equation_AST = (AST)currentAST.root;
		returnAST = equation_AST;
	}
	
	public final void aggregate_expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_expr_AST = null;
		
		{
		if ((LA(1)==ID)) {
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if (((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_vsize))) {
			function();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		switch ( LA(1)) {
		case STAR:
		case 109:
		case TWO_ARG_OP:
		case MINUS:
		case 220:
		case 221:
		case 222:
		case 223:
		case 224:
		case 225:
		case 226:
		{
			two_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_expr();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				aggregate_expr_AST = (AST)currentAST.root;
				aggregate_expr_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(aggregate_expr_AST));
				currentAST.root = aggregate_expr_AST;
				currentAST.child = aggregate_expr_AST!=null &&aggregate_expr_AST.getFirstChild()!=null ?
					aggregate_expr_AST.getFirstChild() : aggregate_expr_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case EOF:
		case SEMI:
		case COMMA:
		case LITERAL_order:
		case 35:
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
		aggregate_expr_AST = (AST)currentAST.root;
		returnAST = aggregate_expr_AST;
	}
	
	public final void order_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_expression_AST = null;
		
		{
		if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_10.member(LA(2)))) {
			alias();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==ID) && (LA(2)==POINT)) {
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if (((LA(1) >= LITERAL_sum && LA(1) <= 81))) {
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if (((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_vsize))) {
			function();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		switch ( LA(1)) {
		case 50:
		{
			AST tmp299_AST = null;
			tmp299_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp299_AST);
			match(50);
			break;
		}
		case 51:
		{
			AST tmp300_AST = null;
			tmp300_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp300_AST);
			match(51);
			break;
		}
		case LITERAL_asc:
		{
			AST tmp301_AST = null;
			tmp301_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp301_AST);
			match(LITERAL_asc);
			break;
		}
		case LITERAL_desc:
		{
			AST tmp302_AST = null;
			tmp302_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp302_AST);
			match(LITERAL_desc);
			break;
		}
		case EOF:
		case SEMI:
		case COMMA:
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
		order_expression_AST = (AST)currentAST.root;
		returnAST = order_expression_AST;
	}
	
	public final void expression_with_aggr_func() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_with_aggr_func_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		{
			AST tmp303_AST = null;
			tmp303_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp303_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp304_AST = null;
			tmp304_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp304_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case 109:
			case TWO_ARG_OP:
			case MINUS:
			case 220:
			case 221:
			case 222:
			case 223:
			case 224:
			case 225:
			case 226:
			{
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression_with_aggr_func();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					expression_with_aggr_func_AST = (AST)currentAST.root;
					expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_with_aggr_func_AST));
					currentAST.root = expression_with_aggr_func_AST;
					currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
						expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_where:
			case 24:
			case LITERAL_from:
			case 30:
			case LITERAL_group:
			case 33:
			case LITERAL_order:
			case 35:
			case RPAREN:
			case LITERAL_as:
			case 45:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression_with_aggr_func_AST = (AST)currentAST.root;
			break;
		}
		case ONE_ARG_OP:
		{
			one_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				expression_with_aggr_func_AST = (AST)currentAST.root;
				expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ONE_ARG_OP,"one_arg_op")).add(expression_with_aggr_func_AST));
				currentAST.root = expression_with_aggr_func_AST;
				currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
					expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
				currentAST.advanceChildToEnd();
			}
			expression_with_aggr_func_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((_tokenSet_11.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case ID:
				{
					field_name();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_null:
				case QUOTED_STRING:
				case REAL_NUM:
				case NEGATIVE_DIGIT_ELEMENT:
				{
					constant();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_sum:
				case 73:
				case LITERAL_avg:
				case 75:
				case LITERAL_max:
				case 77:
				case LITERAL_min:
				case 79:
				case LITERAL_count:
				case 81:
				{
					aggregate_func();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
					if (((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_vsize))) {
						function();
						astFactory.addASTChild(currentAST, returnAST);
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				switch ( LA(1)) {
				case STAR:
				case 109:
				case TWO_ARG_OP:
				case MINUS:
				case 220:
				case 221:
				case 222:
				case 223:
				case 224:
				case 225:
				case 226:
				{
					two_arg_op();
					astFactory.addASTChild(currentAST, returnAST);
					expression_with_aggr_func();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						expression_with_aggr_func_AST = (AST)currentAST.root;
						expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_with_aggr_func_AST));
						currentAST.root = expression_with_aggr_func_AST;
						currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
							expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case EOF:
				case SEMI:
				case COMMA:
				case LITERAL_where:
				case 24:
				case LITERAL_from:
				case 30:
				case LITERAL_group:
				case 33:
				case LITERAL_order:
				case 35:
				case RPAREN:
				case LITERAL_as:
				case 45:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				expression_with_aggr_func_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = expression_with_aggr_func_AST;
	}
	
	public final void alias() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_AST = null;
		
		switch ( LA(1)) {
		case ID:
		{
			AST tmp305_AST = null;
			tmp305_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp305_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp306_AST = null;
			tmp306_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp306_AST);
			match(QUOTED_STRING);
			alias_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = alias_AST;
	}
	
	public final void field_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST field_name_AST = null;
		
		AST tmp307_AST = null;
		tmp307_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp307_AST);
		match(ID);
		AST tmp308_AST = null;
		tmp308_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp308_AST);
		match(POINT);
		AST tmp309_AST = null;
		tmp309_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp309_AST);
		match(ID);
		field_name_AST = (AST)currentAST.root;
		returnAST = field_name_AST;
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_AST = null;
		
		function_name();
		astFactory.addASTChild(currentAST, returnAST);
		match(LPAREN);
		parameters();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		function_AST = (AST)currentAST.root;
		returnAST = function_AST;
	}
	
	public final void two_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST two_arg_op_AST = null;
		
		switch ( LA(1)) {
		case TWO_ARG_OP:
		{
			AST tmp312_AST = null;
			tmp312_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp312_AST);
			match(TWO_ARG_OP);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp313_AST = null;
			tmp313_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp313_AST);
			match(STAR);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp314_AST = null;
			tmp314_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp314_AST);
			match(MINUS);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 220:
		{
			AST tmp315_AST = null;
			tmp315_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp315_AST);
			match(220);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 221:
		{
			AST tmp316_AST = null;
			tmp316_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp316_AST);
			match(221);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 222:
		{
			AST tmp317_AST = null;
			tmp317_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp317_AST);
			match(222);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 223:
		{
			AST tmp318_AST = null;
			tmp318_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp318_AST);
			match(223);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 224:
		{
			AST tmp319_AST = null;
			tmp319_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp319_AST);
			match(224);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 225:
		{
			AST tmp320_AST = null;
			tmp320_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp320_AST);
			match(225);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 226:
		{
			AST tmp321_AST = null;
			tmp321_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp321_AST);
			match(226);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 109:
		{
			AST tmp322_AST = null;
			tmp322_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp322_AST);
			match(109);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = two_arg_op_AST;
	}
	
	public final void aggregate_func() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_func_AST = null;
		
		aggregate_func_name();
		astFactory.addASTChild(currentAST, returnAST);
		match(LPAREN);
		{
		switch ( LA(1)) {
		case LITERAL_all:
		{
			AST tmp324_AST = null;
			tmp324_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp324_AST);
			match(LITERAL_all);
			break;
		}
		case 71:
		{
			AST tmp325_AST = null;
			tmp325_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp325_AST);
			match(71);
			break;
		}
		case LITERAL_distinct:
		{
			AST tmp326_AST = null;
			tmp326_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp326_AST);
			match(LITERAL_distinct);
			break;
		}
		case 28:
		{
			AST tmp327_AST = null;
			tmp327_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp327_AST);
			match(28);
			break;
		}
		default:
			if ((_tokenSet_2.member(LA(1)))) {
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		parameters();
		astFactory.addASTChild(currentAST, returnAST);
		match(RPAREN);
		aggregate_func_AST = (AST)currentAST.root;
		returnAST = aggregate_func_AST;
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		{
			AST tmp329_AST = null;
			tmp329_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp329_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp330_AST = null;
			tmp330_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp330_AST);
			match(RPAREN);
			{
			if ((_tokenSet_12.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_13.member(LA(3))) && (_tokenSet_14.member(LA(4))) && (_tokenSet_15.member(LA(5)))) {
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					expression_AST = (AST)currentAST.root;
					expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_AST));
					currentAST.root = expression_AST;
					currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
						expression_AST.getFirstChild() : expression_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_14.member(LA(2))) && (_tokenSet_15.member(LA(3))) && (_tokenSet_17.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression_AST = (AST)currentAST.root;
			break;
		}
		case ONE_ARG_OP:
		{
			one_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				expression_AST = (AST)currentAST.root;
				expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ONE_ARG_OP,"one_arg_op")).add(expression_AST));
				currentAST.root = expression_AST;
				currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
					expression_AST.getFirstChild() : expression_AST;
				currentAST.advanceChildToEnd();
			}
			expression_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((_tokenSet_18.member(LA(1)))) {
				{
				switch ( LA(1)) {
				case ID:
				{
					field_name();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case LITERAL_null:
				case QUOTED_STRING:
				case REAL_NUM:
				case NEGATIVE_DIGIT_ELEMENT:
				{
					constant();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case PARAM_ID:
				{
					param_equ();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				default:
					if (((LA(1) >= LITERAL_abs && LA(1) <= LITERAL_vsize))) {
						function();
						astFactory.addASTChild(currentAST, returnAST);
					}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				{
				if ((_tokenSet_12.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_13.member(LA(3))) && (_tokenSet_14.member(LA(4))) && (_tokenSet_15.member(LA(5)))) {
					two_arg_op();
					astFactory.addASTChild(currentAST, returnAST);
					expression();
					astFactory.addASTChild(currentAST, returnAST);
					if ( inputState.guessing==0 ) {
						expression_AST = (AST)currentAST.root;
						expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_AST));
						currentAST.root = expression_AST;
						currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
							expression_AST.getFirstChild() : expression_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else if ((_tokenSet_16.member(LA(1))) && (_tokenSet_14.member(LA(2))) && (_tokenSet_15.member(LA(3))) && (_tokenSet_17.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				
				}
				expression_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = expression_AST;
	}
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case REAL_NUM:
		{
			AST tmp331_AST = null;
			tmp331_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp331_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp332_AST = null;
			tmp332_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp332_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp333_AST = null;
			tmp333_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp333_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp334_AST = null;
			tmp334_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp334_AST);
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
	
	public final void param_equ() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST param_equ_AST = null;
		
		AST tmp335_AST = null;
		tmp335_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp335_AST);
		match(PARAM_ID);
		param_equ_AST = (AST)currentAST.root;
		returnAST = param_equ_AST;
	}
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		AST tmp336_AST = null;
		tmp336_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp336_AST);
		match(ONE_ARG_OP);
		one_arg_op_AST = (AST)currentAST.root;
		returnAST = one_arg_op_AST;
	}
	
	public final void compare_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compare_op_AST = null;
		
		switch ( LA(1)) {
		case COMPARE_OP:
		{
			AST tmp337_AST = null;
			tmp337_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp337_AST);
			match(COMPARE_OP);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 47:
		{
			AST tmp338_AST = null;
			tmp338_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp338_AST);
			match(47);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_like:
		{
			AST tmp339_AST = null;
			tmp339_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp339_AST);
			match(LITERAL_like);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 229:
		{
			AST tmp340_AST = null;
			tmp340_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp340_AST);
			match(229);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 230:
		{
			AST tmp341_AST = null;
			tmp341_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp341_AST);
			match(230);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 231:
		{
			AST tmp342_AST = null;
			tmp342_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp342_AST);
			match(231);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 232:
		{
			AST tmp343_AST = null;
			tmp343_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp343_AST);
			match(232);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 233:
		{
			AST tmp344_AST = null;
			tmp344_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp344_AST);
			match(233);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 234:
		{
			AST tmp345_AST = null;
			tmp345_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp345_AST);
			match(234);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 235:
		{
			AST tmp346_AST = null;
			tmp346_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp346_AST);
			match(235);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = compare_op_AST;
	}
	
	public final void exp_set() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_set_AST = null;
		
		AST tmp347_AST = null;
		tmp347_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp347_AST);
		match(LPAREN);
		constexpset();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp348_AST = null;
		tmp348_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp348_AST);
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			exp_set_AST = (AST)currentAST.root;
			exp_set_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBCONTAIN_OP,"subcontain_op")).add(exp_set_AST));
			currentAST.root = exp_set_AST;
			currentAST.child = exp_set_AST!=null &&exp_set_AST.getFirstChild()!=null ?
				exp_set_AST.getFirstChild() : exp_set_AST;
			currentAST.advanceChildToEnd();
		}
		exp_set_AST = (AST)currentAST.root;
		returnAST = exp_set_AST;
	}
	
	public final void constexpset() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constexpset_AST = null;
		
		constant();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop72:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp349_AST = null;
				tmp349_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp349_AST);
				match(COMMA);
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop72;
			}
			
		} while (true);
		}
		constexpset_AST = (AST)currentAST.root;
		returnAST = constexpset_AST;
	}
	
	public final void subquery() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subquery_AST = null;
		
		AST tmp350_AST = null;
		tmp350_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp350_AST);
		match(LPAREN);
		select_statement();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp351_AST = null;
		tmp351_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp351_AST);
		match(RPAREN);
		if ( inputState.guessing==0 ) {
			subquery_AST = (AST)currentAST.root;
			subquery_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SUBQUERY,"subquery")).add(subquery_AST));
			currentAST.root = subquery_AST;
			currentAST.child = subquery_AST!=null &&subquery_AST.getFirstChild()!=null ?
				subquery_AST.getFirstChild() : subquery_AST;
			currentAST.advanceChildToEnd();
		}
		subquery_AST = (AST)currentAST.root;
		returnAST = subquery_AST;
	}
	
	public final void function_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_name_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_abs:
		case 83:
		case LITERAL_acos:
		case 85:
		case LITERAL_asin:
		case 87:
		case LITERAL_atan:
		case 89:
		case 90:
		case 91:
		case LITERAL_ceiling:
		case 93:
		case LITERAL_cos:
		case 95:
		case LITERAL_cot:
		case 97:
		case LITERAL_degrees:
		case 99:
		case LITERAL_exp:
		case 101:
		case LITERAL_floor:
		case 103:
		case LITERAL_log:
		case 105:
		case 106:
		case 107:
		case LITERAL_mod:
		case 109:
		case LITERAL_pi:
		case 111:
		case LITERAL_power:
		case 113:
		case LITERAL_radians:
		case 115:
		case LITERAL_rand:
		case 117:
		case LITERAL_round:
		case 119:
		case LITERAL_sign:
		case 121:
		case LITERAL_sin:
		case 123:
		case LITERAL_sqrt:
		case 125:
		case LITERAL_tan:
		case 127:
		{
			number_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ascii:
		case 129:
		case LITERAL_char:
		case 131:
		case LITERAL_char_length:
		case 133:
		case LITERAL_charindex:
		case 135:
		case LITERAL_difference:
		case 137:
		case LITERAL_lcase:
		case LITERAL_left:
		case 140:
		case LITERAL_length:
		case 142:
		case LITERAL_lower:
		case 144:
		case LITERAL_ltrim:
		case 146:
		case LITERAL_patindex:
		case 148:
		case LITERAL_replace:
		case 150:
		case LITERAL_right:
		case LITERAL_rtrim:
		case 153:
		case LITERAL_str:
		case 155:
		case LITERAL_substring:
		case 157:
		case LITERAL_upper:
		case 159:
		{
			string_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateformat:
		case 161:
		case LITERAL_datename:
		case 163:
		case LITERAL_datepart:
		case 165:
		case LITERAL_datetime:
		case 167:
		case LITERAL_date:
		case LITERAL_dayname:
		case LITERAL_days:
		case LITERAL_day:
		case LITERAL_dow:
		case LITERAL_hours:
		case LITERAL_hour:
		case LITERAL_minutes:
		case LITERAL_minute:
		case LITERAL_monthname:
		case LITERAL_months:
		case LITERAL_month:
		case LITERAL_now:
		case 181:
		case LITERAL_quarter:
		case LITERAL_seconds:
		case LITERAL_second:
		case LITERAL_today:
		case 186:
		case LITERAL_weeks:
		case LITERAL_week:
		case LITERAL_years:
		case LITERAL_year:
		case LITERAL_getdate:
		case 192:
		case LITERAL_dateadd:
		case 194:
		case LITERAL_datediff:
		case 196:
		{
			datetime_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_convert:
		case 198:
		case LITERAL_hextoint:
		case 200:
		case LITERAL_inttohex:
		case 202:
		case LITERAL_isdate:
		case 204:
		case LITERAL_isnumeric:
		case 206:
		{
			conversion_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_suser_id:
		case LITERAL_suser_name:
		case LITERAL_user_id:
		case LITERAL_user_name:
		{
			system_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_decode:
		case LITERAL_dump:
		case LITERAL_greatest:
		case LITERAL_least:
		case LITERAL_nvl:
		case LITERAL_vsize:
		{
			other_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = function_name_AST;
	}
	
	public final void parameters() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST parameters_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop83:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp352_AST = null;
				tmp352_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp352_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop83;
			}
			
		} while (true);
		}
		parameters_AST = (AST)currentAST.root;
		returnAST = parameters_AST;
	}
	
	public final void aggregate_func_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_func_name_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_sum:
		{
			AST tmp353_AST = null;
			tmp353_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp353_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 73:
		{
			AST tmp354_AST = null;
			tmp354_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp354_AST);
			match(73);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_avg:
		{
			AST tmp355_AST = null;
			tmp355_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp355_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 75:
		{
			AST tmp356_AST = null;
			tmp356_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp356_AST);
			match(75);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp357_AST = null;
			tmp357_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp357_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 77:
		{
			AST tmp358_AST = null;
			tmp358_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp358_AST);
			match(77);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp359_AST = null;
			tmp359_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp359_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 79:
		{
			AST tmp360_AST = null;
			tmp360_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp360_AST);
			match(79);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_count:
		{
			AST tmp361_AST = null;
			tmp361_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp361_AST);
			match(LITERAL_count);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 81:
		{
			AST tmp362_AST = null;
			tmp362_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp362_AST);
			match(81);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = aggregate_func_name_AST;
	}
	
	public final void number_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_abs:
		{
			AST tmp363_AST = null;
			tmp363_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp363_AST);
			match(LITERAL_abs);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 83:
		{
			AST tmp364_AST = null;
			tmp364_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp364_AST);
			match(83);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_acos:
		{
			AST tmp365_AST = null;
			tmp365_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp365_AST);
			match(LITERAL_acos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 85:
		{
			AST tmp366_AST = null;
			tmp366_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp366_AST);
			match(85);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asin:
		{
			AST tmp367_AST = null;
			tmp367_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp367_AST);
			match(LITERAL_asin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 87:
		{
			AST tmp368_AST = null;
			tmp368_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp368_AST);
			match(87);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_atan:
		{
			AST tmp369_AST = null;
			tmp369_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp369_AST);
			match(LITERAL_atan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 89:
		{
			AST tmp370_AST = null;
			tmp370_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp370_AST);
			match(89);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 90:
		{
			AST tmp371_AST = null;
			tmp371_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp371_AST);
			match(90);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 91:
		{
			AST tmp372_AST = null;
			tmp372_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp372_AST);
			match(91);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceiling:
		{
			AST tmp373_AST = null;
			tmp373_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp373_AST);
			match(LITERAL_ceiling);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 93:
		{
			AST tmp374_AST = null;
			tmp374_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp374_AST);
			match(93);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cos:
		{
			AST tmp375_AST = null;
			tmp375_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp375_AST);
			match(LITERAL_cos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 95:
		{
			AST tmp376_AST = null;
			tmp376_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp376_AST);
			match(95);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cot:
		{
			AST tmp377_AST = null;
			tmp377_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp377_AST);
			match(LITERAL_cot);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 97:
		{
			AST tmp378_AST = null;
			tmp378_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp378_AST);
			match(97);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_degrees:
		{
			AST tmp379_AST = null;
			tmp379_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp379_AST);
			match(LITERAL_degrees);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 99:
		{
			AST tmp380_AST = null;
			tmp380_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp380_AST);
			match(99);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exp:
		{
			AST tmp381_AST = null;
			tmp381_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp381_AST);
			match(LITERAL_exp);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 101:
		{
			AST tmp382_AST = null;
			tmp382_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp382_AST);
			match(101);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp383_AST = null;
			tmp383_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp383_AST);
			match(LITERAL_floor);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 103:
		{
			AST tmp384_AST = null;
			tmp384_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp384_AST);
			match(103);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_log:
		{
			AST tmp385_AST = null;
			tmp385_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp385_AST);
			match(LITERAL_log);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 105:
		{
			AST tmp386_AST = null;
			tmp386_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp386_AST);
			match(105);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 106:
		{
			AST tmp387_AST = null;
			tmp387_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp387_AST);
			match(106);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 107:
		{
			AST tmp388_AST = null;
			tmp388_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp388_AST);
			match(107);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp389_AST = null;
			tmp389_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp389_AST);
			match(LITERAL_mod);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 109:
		{
			AST tmp390_AST = null;
			tmp390_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp390_AST);
			match(109);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_pi:
		{
			AST tmp391_AST = null;
			tmp391_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp391_AST);
			match(LITERAL_pi);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 111:
		{
			AST tmp392_AST = null;
			tmp392_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp392_AST);
			match(111);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_power:
		{
			AST tmp393_AST = null;
			tmp393_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp393_AST);
			match(LITERAL_power);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 113:
		{
			AST tmp394_AST = null;
			tmp394_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp394_AST);
			match(113);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_radians:
		{
			AST tmp395_AST = null;
			tmp395_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp395_AST);
			match(LITERAL_radians);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 115:
		{
			AST tmp396_AST = null;
			tmp396_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp396_AST);
			match(115);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rand:
		{
			AST tmp397_AST = null;
			tmp397_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp397_AST);
			match(LITERAL_rand);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 117:
		{
			AST tmp398_AST = null;
			tmp398_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp398_AST);
			match(117);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp399_AST = null;
			tmp399_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp399_AST);
			match(LITERAL_round);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 119:
		{
			AST tmp400_AST = null;
			tmp400_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp400_AST);
			match(119);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sign:
		{
			AST tmp401_AST = null;
			tmp401_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp401_AST);
			match(LITERAL_sign);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 121:
		{
			AST tmp402_AST = null;
			tmp402_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp402_AST);
			match(121);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sin:
		{
			AST tmp403_AST = null;
			tmp403_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp403_AST);
			match(LITERAL_sin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 123:
		{
			AST tmp404_AST = null;
			tmp404_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp404_AST);
			match(123);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sqrt:
		{
			AST tmp405_AST = null;
			tmp405_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp405_AST);
			match(LITERAL_sqrt);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 125:
		{
			AST tmp406_AST = null;
			tmp406_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp406_AST);
			match(125);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tan:
		{
			AST tmp407_AST = null;
			tmp407_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp407_AST);
			match(LITERAL_tan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 127:
		{
			AST tmp408_AST = null;
			tmp408_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp408_AST);
			match(127);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = number_function_AST;
	}
	
	public final void string_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST string_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_ascii:
		{
			AST tmp409_AST = null;
			tmp409_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp409_AST);
			match(LITERAL_ascii);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp410_AST = null;
			tmp410_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp410_AST);
			match(129);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char:
		{
			AST tmp411_AST = null;
			tmp411_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp411_AST);
			match(LITERAL_char);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 131:
		{
			AST tmp412_AST = null;
			tmp412_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp412_AST);
			match(131);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char_length:
		{
			AST tmp413_AST = null;
			tmp413_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp413_AST);
			match(LITERAL_char_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 133:
		{
			AST tmp414_AST = null;
			tmp414_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp414_AST);
			match(133);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_charindex:
		{
			AST tmp415_AST = null;
			tmp415_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp415_AST);
			match(LITERAL_charindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 135:
		{
			AST tmp416_AST = null;
			tmp416_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp416_AST);
			match(135);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_difference:
		{
			AST tmp417_AST = null;
			tmp417_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp417_AST);
			match(LITERAL_difference);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 137:
		{
			AST tmp418_AST = null;
			tmp418_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp418_AST);
			match(137);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lcase:
		{
			AST tmp419_AST = null;
			tmp419_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp419_AST);
			match(LITERAL_lcase);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_left:
		{
			AST tmp420_AST = null;
			tmp420_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp420_AST);
			match(LITERAL_left);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_length:
		{
			AST tmp421_AST = null;
			tmp421_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp421_AST);
			match(LITERAL_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 142:
		{
			AST tmp422_AST = null;
			tmp422_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp422_AST);
			match(142);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp423_AST = null;
			tmp423_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp423_AST);
			match(LITERAL_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 144:
		{
			AST tmp424_AST = null;
			tmp424_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp424_AST);
			match(144);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp425_AST = null;
			tmp425_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp425_AST);
			match(LITERAL_ltrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 146:
		{
			AST tmp426_AST = null;
			tmp426_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp426_AST);
			match(146);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_patindex:
		{
			AST tmp427_AST = null;
			tmp427_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp427_AST);
			match(LITERAL_patindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 148:
		{
			AST tmp428_AST = null;
			tmp428_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp428_AST);
			match(148);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replace:
		{
			AST tmp429_AST = null;
			tmp429_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp429_AST);
			match(LITERAL_replace);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 150:
		{
			AST tmp430_AST = null;
			tmp430_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp430_AST);
			match(150);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_right:
		{
			AST tmp431_AST = null;
			tmp431_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp431_AST);
			match(LITERAL_right);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp432_AST = null;
			tmp432_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp432_AST);
			match(LITERAL_rtrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 153:
		{
			AST tmp433_AST = null;
			tmp433_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp433_AST);
			match(153);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_str:
		{
			AST tmp434_AST = null;
			tmp434_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp434_AST);
			match(LITERAL_str);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 155:
		{
			AST tmp435_AST = null;
			tmp435_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp435_AST);
			match(155);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substring:
		{
			AST tmp436_AST = null;
			tmp436_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp436_AST);
			match(LITERAL_substring);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 157:
		{
			AST tmp437_AST = null;
			tmp437_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp437_AST);
			match(157);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_upper:
		{
			AST tmp438_AST = null;
			tmp438_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp438_AST);
			match(LITERAL_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 159:
		{
			AST tmp439_AST = null;
			tmp439_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp439_AST);
			match(159);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((LA(1)==140) && (LA(2)==LPAREN) && (_tokenSet_2.member(LA(3))) && (_tokenSet_19.member(LA(4))) && (_tokenSet_20.member(LA(5)))) {
				AST tmp440_AST = null;
				tmp440_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp440_AST);
				match(140);
				string_function_AST = (AST)currentAST.root;
			}
			else if ((LA(1)==140) && (LA(2)==LPAREN) && (_tokenSet_2.member(LA(3))) && (_tokenSet_19.member(LA(4))) && (_tokenSet_20.member(LA(5)))) {
				AST tmp441_AST = null;
				tmp441_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp441_AST);
				match(140);
				string_function_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = string_function_AST;
	}
	
	public final void datetime_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST datetime_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_dateformat:
		{
			AST tmp442_AST = null;
			tmp442_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp442_AST);
			match(LITERAL_dateformat);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 161:
		{
			AST tmp443_AST = null;
			tmp443_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp443_AST);
			match(161);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datename:
		{
			AST tmp444_AST = null;
			tmp444_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp444_AST);
			match(LITERAL_datename);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 163:
		{
			AST tmp445_AST = null;
			tmp445_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp445_AST);
			match(163);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datepart:
		{
			AST tmp446_AST = null;
			tmp446_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp446_AST);
			match(LITERAL_datepart);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 165:
		{
			AST tmp447_AST = null;
			tmp447_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp447_AST);
			match(165);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datetime:
		{
			AST tmp448_AST = null;
			tmp448_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp448_AST);
			match(LITERAL_datetime);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 167:
		{
			AST tmp449_AST = null;
			tmp449_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp449_AST);
			match(167);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp450_AST = null;
			tmp450_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp450_AST);
			match(LITERAL_date);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayname:
		{
			AST tmp451_AST = null;
			tmp451_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp451_AST);
			match(LITERAL_dayname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_days:
		{
			AST tmp452_AST = null;
			tmp452_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp452_AST);
			match(LITERAL_days);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp453_AST = null;
			tmp453_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp453_AST);
			match(LITERAL_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dow:
		{
			AST tmp454_AST = null;
			tmp454_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp454_AST);
			match(LITERAL_dow);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hours:
		{
			AST tmp455_AST = null;
			tmp455_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp455_AST);
			match(LITERAL_hours);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp456_AST = null;
			tmp456_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp456_AST);
			match(LITERAL_hour);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minutes:
		{
			AST tmp457_AST = null;
			tmp457_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp457_AST);
			match(LITERAL_minutes);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp458_AST = null;
			tmp458_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp458_AST);
			match(LITERAL_minute);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_monthname:
		{
			AST tmp459_AST = null;
			tmp459_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp459_AST);
			match(LITERAL_monthname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_months:
		{
			AST tmp460_AST = null;
			tmp460_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp460_AST);
			match(LITERAL_months);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp461_AST = null;
			tmp461_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp461_AST);
			match(LITERAL_month);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_now:
		{
			AST tmp462_AST = null;
			tmp462_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp462_AST);
			match(LITERAL_now);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 181:
		{
			AST tmp463_AST = null;
			tmp463_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp463_AST);
			match(181);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp464_AST = null;
			tmp464_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp464_AST);
			match(LITERAL_quarter);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_seconds:
		{
			AST tmp465_AST = null;
			tmp465_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp465_AST);
			match(LITERAL_seconds);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp466_AST = null;
			tmp466_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp466_AST);
			match(LITERAL_second);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_today:
		{
			AST tmp467_AST = null;
			tmp467_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp467_AST);
			match(LITERAL_today);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 186:
		{
			AST tmp468_AST = null;
			tmp468_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp468_AST);
			match(186);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weeks:
		{
			AST tmp469_AST = null;
			tmp469_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp469_AST);
			match(LITERAL_weeks);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp470_AST = null;
			tmp470_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp470_AST);
			match(LITERAL_week);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_years:
		{
			AST tmp471_AST = null;
			tmp471_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp471_AST);
			match(LITERAL_years);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_year:
		{
			AST tmp472_AST = null;
			tmp472_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp472_AST);
			match(LITERAL_year);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_getdate:
		{
			AST tmp473_AST = null;
			tmp473_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp473_AST);
			match(LITERAL_getdate);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 192:
		{
			AST tmp474_AST = null;
			tmp474_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp474_AST);
			match(192);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateadd:
		{
			AST tmp475_AST = null;
			tmp475_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp475_AST);
			match(LITERAL_dateadd);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 194:
		{
			AST tmp476_AST = null;
			tmp476_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp476_AST);
			match(194);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datediff:
		{
			AST tmp477_AST = null;
			tmp477_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp477_AST);
			match(LITERAL_datediff);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 196:
		{
			AST tmp478_AST = null;
			tmp478_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp478_AST);
			match(196);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = datetime_function_AST;
	}
	
	public final void conversion_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST conversion_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_convert:
		{
			AST tmp479_AST = null;
			tmp479_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp479_AST);
			match(LITERAL_convert);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 198:
		{
			AST tmp480_AST = null;
			tmp480_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp480_AST);
			match(198);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hextoint:
		{
			AST tmp481_AST = null;
			tmp481_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp481_AST);
			match(LITERAL_hextoint);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 200:
		{
			AST tmp482_AST = null;
			tmp482_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp482_AST);
			match(200);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_inttohex:
		{
			AST tmp483_AST = null;
			tmp483_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp483_AST);
			match(LITERAL_inttohex);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 202:
		{
			AST tmp484_AST = null;
			tmp484_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp484_AST);
			match(202);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isdate:
		{
			AST tmp485_AST = null;
			tmp485_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp485_AST);
			match(LITERAL_isdate);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 204:
		{
			AST tmp486_AST = null;
			tmp486_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp486_AST);
			match(204);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isnumeric:
		{
			AST tmp487_AST = null;
			tmp487_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp487_AST);
			match(LITERAL_isnumeric);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 206:
		{
			AST tmp488_AST = null;
			tmp488_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp488_AST);
			match(206);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = conversion_function_AST;
	}
	
	public final void system_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST system_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_suser_id:
		{
			AST tmp489_AST = null;
			tmp489_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp489_AST);
			match(LITERAL_suser_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_suser_name:
		{
			AST tmp490_AST = null;
			tmp490_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp490_AST);
			match(LITERAL_suser_name);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_id:
		{
			AST tmp491_AST = null;
			tmp491_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp491_AST);
			match(LITERAL_user_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_name:
		{
			AST tmp492_AST = null;
			tmp492_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp492_AST);
			match(LITERAL_user_name);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = system_function_AST;
	}
	
	public final void other_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST other_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_decode:
		{
			AST tmp493_AST = null;
			tmp493_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp493_AST);
			match(LITERAL_decode);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dump:
		{
			AST tmp494_AST = null;
			tmp494_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp494_AST);
			match(LITERAL_dump);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_greatest:
		{
			AST tmp495_AST = null;
			tmp495_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp495_AST);
			match(LITERAL_greatest);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_least:
		{
			AST tmp496_AST = null;
			tmp496_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp496_AST);
			match(LITERAL_least);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nvl:
		{
			AST tmp497_AST = null;
			tmp497_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp497_AST);
			match(LITERAL_nvl);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_vsize:
		{
			AST tmp498_AST = null;
			tmp498_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp498_AST);
			match(LITERAL_vsize);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = other_function_AST;
	}
	
	public final void contain_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contain_op_AST = null;
		
		switch ( LA(1)) {
		case 62:
		{
			AST tmp499_AST = null;
			tmp499_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp499_AST);
			match(62);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case 63:
		{
			AST tmp500_AST = null;
			tmp500_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp500_AST);
			match(63);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_in:
		{
			AST tmp501_AST = null;
			tmp501_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp501_AST);
			match(LITERAL_in);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case 60:
		{
			AST tmp502_AST = null;
			tmp502_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp502_AST);
			match(60);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = contain_op_AST;
	}
	
	public final void logic_onearg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_onearg_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_not:
		{
			AST tmp503_AST = null;
			tmp503_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp503_AST);
			match(LITERAL_not);
			logic_onearg_op_AST = (AST)currentAST.root;
			break;
		}
		case 37:
		{
			AST tmp504_AST = null;
			tmp504_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp504_AST);
			match(37);
			logic_onearg_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = logic_onearg_op_AST;
	}
	
	public final void logic_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_and:
		{
			AST tmp505_AST = null;
			tmp505_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp505_AST);
			match(LITERAL_and);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		{
			AST tmp506_AST = null;
			tmp506_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp506_AST);
			match(LITERAL_or);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 40:
		{
			AST tmp507_AST = null;
			tmp507_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp507_AST);
			match(40);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 41:
		{
			AST tmp508_AST = null;
			tmp508_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp508_AST);
			match(41);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = logic_op_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SELECT_STATEMENT",
		"SUBQUERY",
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"LOGIC_OP",
		"CONTAIN_OP",
		"SUBCONTAIN_OP",
		"ALL_FIELDS",
		"LOGIC_BLOCK",
		"COLUMN",
		"WHERE",
		"SEMI",
		"\"t_union\"",
		"\"\\u8868\\u5408\\u5e76\"",
		"COMMA",
		"\"t_compare\"",
		"\"\\u8868\\u6bd4\\u8f83\"",
		"\"where\"",
		"\"\\u6761\\u4ef6\"",
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"\"group\"",
		"\"by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order\"",
		"\"\\u6392\\u5e8f\"",
		"\"not\"",
		"\"\\u975e\"",
		"\"and\"",
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"LPAREN",
		"RPAREN",
		"\"as\"",
		"\"\\u4f5c\\u4e3a\"",
		"\"=\"",
		"\"\\u7b49\\u4e8e\"",
		"\"\\u6240\\u6709\"",
		"STAR",
		"\"\\u5347\\u5e8f\"",
		"\"\\u964d\\u5e8f\"",
		"\"asc\"",
		"\"desc\"",
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"not in\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"PARAM_ID",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
		"NEGATIVE_DIGIT_ELEMENT",
		"\"all\"",
		"\"\\u5168\\u90e8\"",
		"\"sum\"",
		"\"\\u6c42\\u548c\"",
		"\"avg\"",
		"\"\\u6c42\\u5e73\\u5747\\u6570\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"count\"",
		"\"\\u6c42\\u8bb0\\u5f55\\u6570\"",
		"\"abs\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u503c\\u7684\\u4f59\\u5f26\\u89d2\"",
		"\"asin\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5f26\\u89d2\"",
		"\"atan\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5207\\u89d2\"",
		"\"atin2\"",
		"\"\\u6c42\\u503c\\u7684\\u6b63\\u5f26\\u548c\\u4f59\\u5f26\\u89d2\"",
		"\"ceiling\"",
		"\"\\u6c42\\u4e94\\u5165\\u540e\\u7684\\u6574\\u6570\"",
		"\"cos\"",
		"\"\\u6c42\\u89d2\\u7684\\u4f59\\u5f26\\u503c\"",
		"\"cot\"",
		"\"\\u6c42\\u89d2\\u7684\\u4f59\\u5207\\u503c\"",
		"\"degrees\"",
		"\"\\u6c42\\u5f27\\u5ea6\\u6570\\u7684\\u89d2\\u5927\\u5c0f\"",
		"\"exp\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"floor\"",
		"\"\\u6c42\\u56db\\u820d\\u540e\\u7684\\u6574\\u6570\"",
		"\"log\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log10\"",
		"\"\\u6c4210\\u4e3a\\u5e95\\u7684\\u5bf9\\u6570\"",
		"\"mod\"",
		"\"\\u6c42\\u6a21\"",
		"\"pi\"",
		"\"\\u6c42PI\"",
		"\"power\"",
		"\"\\u6c42\\u6570\\u5b57\\u7684\\u6b21\\u5e42\\u503c\"",
		"\"radians\"",
		"\"\\u6c42\\u5ea6\\u6570\\u89d2\\u7684\\u5f27\\u5ea6\"",
		"\"rand\"",
		"\"\\u6c420\\u548c1\\u95f4\\u7684\\u968f\\u673a\\u6570\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"sign\"",
		"\"\\u6c42\\u503c\\u7684\\u7b26\\u53f7\"",
		"\"sin\"",
		"\"\\u6c42\\u89d2\\u7684\\u6b63\\u5f26\\u503c\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"tan\"",
		"\"\\u6c42\\u89d2\\u7684\\u6b63\\u5207\\u503c\"",
		"\"ascii\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u4e2a\\u5b57\\u7b26\\u7684ASCII\\u7801\"",
		"\"char\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u5dee\\u503c\"",
		"\"lcase\"",
		"\"left\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5de6\\u622a\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u603b\\u957f\\u5ea6\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"patindex\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u6b21\\u51fa\\u73b0\\u4f4d\\u7f6e\"",
		"\"replace\"",
		"\"\\u5b57\\u7b26\\u4e32\\u66ff\\u6362\"",
		"\"right\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"upper\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5927\\u5199\"",
		"\"dateformat\"",
		"\"\\u683c\\u5f0f\\u5316\\u65e5\\u671f\"",
		"\"datename\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u503c\"",
		"\"datepart\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u6574\\u6570\\u503c\"",
		"\"datetime\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"date\"",
		"\"dayname\"",
		"\"days\"",
		"\"day\"",
		"\"dow\"",
		"\"hours\"",
		"\"hour\"",
		"\"minutes\"",
		"\"minute\"",
		"\"monthname\"",
		"\"months\"",
		"\"month\"",
		"\"now\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"quarter\"",
		"\"seconds\"",
		"\"second\"",
		"\"today\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\"",
		"\"weeks\"",
		"\"week\"",
		"\"years\"",
		"\"year\"",
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u76f8\\u52a0\"",
		"\"datediff\"",
		"\"\\u65e5\\u671f\\u76f8\\u51cf\"",
		"\"convert\"",
		"\"\\u5b57\\u7b26\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u662f\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u662f\\u6570\\u503c\\u578b\"",
		"\"suser_id\"",
		"\"suser_name\"",
		"\"user_id\"",
		"\"user_name\"",
		"\"decode\"",
		"\"dump\"",
		"\"greatest\"",
		"\"least\"",
		"\"nvl\"",
		"\"vsize\"",
		"ONE_ARG_OP",
		"TWO_ARG_OP",
		"MINUS",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u5f02\\u6216\"",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"COMPARE_OP",
		"\"like\"",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"not exists\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"exists\"",
		"\"\\u5b58\\u5728\"",
		"NOT_EXIST",
		"EXIST",
		"PARAM_LPAREN",
		"PARAM_RPAREN",
		"WS",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
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
		long[] data = new long[8];
		data[0]=36033195065475072L;
		data[1]=-202L;
		data[2]=-1L;
		data[3]=67108863L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[8];
		data[0]=36657781584035842L;
		data[1]=-194L;
		data[2]=-1L;
		data[3]=34359738367L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[8];
		data[0]=36033195065475072L;
		data[1]=-262089L;
		data[2]=-1L;
		data[3]=67108863L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[8];
		data[0]=36877619995607040L;
		data[1]=-202L;
		data[2]=-1L;
		data[3]=67108863L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[8];
		data[0]=-17235944277016576L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[8];
		data[0]=-17222956295913472L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[8];
		data[0]=-17222894017708030L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[8];
		data[0]=-17222894018756606L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[8];
		data[0]=-17222889614999550L;
		data[1]=-193L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[8];
		data[0]=-52915632996350L;
		data[1]=-193L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 16897294696841218L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[8];
		data[0]=36028797018963968L;
		data[1]=-202L;
		data[2]=-1L;
		data[3]=33554431L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[8];
		data[0]=562949953421312L;
		data[1]=35184372088832L;
		data[3]=34292629504L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[8];
		data[0]=-17222962737184766L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[8];
		data[0]=-281612818448382L;
		data[1]=-193L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[8];
		data[0]=-131070L;
		data[1]=-193L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[8];
		data[0]=-17785912690606078L;
		data[1]=-262089L;
		data[2]=-1L;
		data[3]=17557893414911L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[8];
		data[0]=-131070L;
		for (int i = 1; i<=2; i++) { data[i]=-1L; }
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[8];
		data[0]=36028797018963968L;
		data[1]=-262089L;
		data[2]=-1L;
		data[3]=33554431L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[8];
		data[0]=36604941112967168L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=34359738367L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = new long[8];
		data[0]=-281685940633598L;
		data[1]=-262081L;
		data[2]=-1L;
		data[3]=17592186044415L;
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	
	}
