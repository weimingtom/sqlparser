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
			AST tmp282_AST = null;
			tmp282_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp282_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp283_AST = null;
			tmp283_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp283_AST);
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
		case 61:
		{
			all = LT(1);
			all_AST = astFactory.create(all);
			astFactory.addASTChild(currentAST, all_AST);
			match(61);
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
			AST tmp285_AST = null;
			tmp285_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp285_AST);
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
				case 58:
				{
					{
					switch ( LA(1)) {
					case LITERAL_as:
					{
						AST tmp286_AST = null;
						tmp286_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp286_AST);
						match(LITERAL_as);
						break;
					}
					case 58:
					{
						AST tmp287_AST = null;
						tmp287_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp287_AST);
						match(58);
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
				case 36:
				case LITERAL_from:
				case 44:
				case LITERAL_group:
				case 47:
				case LITERAL_order:
				case 49:
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
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==59||LA(2)==60)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 59:
				{
					AST tmp288_AST = null;
					tmp288_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp288_AST);
					match(59);
					break;
				}
				case 60:
				{
					AST tmp289_AST = null;
					tmp289_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp289_AST);
					match(60);
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
		else if ((LA(1)==LITERAL_not||LA(1)==50)) {
			{
			switch ( LA(1)) {
			case LITERAL_not:
			{
				AST tmp290_AST = null;
				tmp290_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp290_AST);
				match(LITERAL_not);
				if ( inputState.guessing==0 ) {
					search_condition_AST = (AST)currentAST.root;
					search_condition_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SEARCH_NOT_CONDITION,"search_not_condition")).add(search_condition_AST));
					currentAST.root = search_condition_AST;
					currentAST.child = search_condition_AST!=null &&search_condition_AST.getFirstChild()!=null ?
						search_condition_AST.getFirstChild() : search_condition_AST;
					currentAST.advanceChildToEnd();
				}
				break;
			}
			case 50:
			{
				AST tmp291_AST = null;
				tmp291_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp291_AST);
				match(50);
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
				AST tmp292_AST = null;
				tmp292_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp292_AST);
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
		case 31:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_t_compare:
		case 34:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_select:
		case 40:
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
			AST tmp294_AST = null;
			tmp294_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp294_AST);
			match(LITERAL_t_union);
			break;
		}
		case 31:
		{
			AST tmp295_AST = null;
			tmp295_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp295_AST);
			match(31);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		table_lists();
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
			AST tmp296_AST = null;
			tmp296_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp296_AST);
			match(LITERAL_t_compare);
			break;
		}
		case 34:
		{
			AST tmp297_AST = null;
			tmp297_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp297_AST);
			match(34);
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
		case 36:
		{
			match(36);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		compare_method();
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
			AST tmp301_AST = null;
			tmp301_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp301_AST);
			match(LITERAL_select);
			break;
		}
		case 40:
		{
			AST tmp302_AST = null;
			tmp302_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp302_AST);
			match(40);
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
			AST tmp303_AST = null;
			tmp303_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp303_AST);
			match(LITERAL_distinct);
			break;
		}
		case 42:
		{
			AST tmp304_AST = null;
			tmp304_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp304_AST);
			match(42);
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
		case 44:
		{
			{
			switch ( LA(1)) {
			case LITERAL_from:
			{
				AST tmp305_AST = null;
				tmp305_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp305_AST);
				match(LITERAL_from);
				break;
			}
			case 44:
			{
				AST tmp306_AST = null;
				tmp306_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp306_AST);
				match(44);
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
		case 36:
		case LITERAL_group:
		case 47:
		case LITERAL_order:
		case 49:
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
		case 36:
		{
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				AST tmp307_AST = null;
				tmp307_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp307_AST);
				match(LITERAL_where);
				break;
			}
			case 36:
			{
				AST tmp308_AST = null;
				tmp308_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp308_AST);
				match(36);
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
		case 47:
		case LITERAL_order:
		case 49:
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
		case 47:
		{
			{
			switch ( LA(1)) {
			case LITERAL_group:
			{
				AST tmp309_AST = null;
				tmp309_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp309_AST);
				match(LITERAL_group);
				match(LITERAL_by);
				break;
			}
			case 47:
			{
				AST tmp311_AST = null;
				tmp311_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp311_AST);
				match(47);
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
		case 49:
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
		case 49:
		{
			{
			switch ( LA(1)) {
			case LITERAL_order:
			{
				AST tmp312_AST = null;
				tmp312_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp312_AST);
				match(LITERAL_order);
				match(LITERAL_by);
				break;
			}
			case 49:
			{
				AST tmp314_AST = null;
				tmp314_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp314_AST);
				match(49);
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
	
	public final void table_lists() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_lists_AST = null;
		
		table_name();
		astFactory.addASTChild(currentAST, returnAST);
		{
		int _cnt11=0;
		_loop11:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp315_AST = null;
				tmp315_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp315_AST);
				match(COMMA);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt11>=1 ) { break _loop11; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt11++;
		} while (true);
		}
		table_lists_AST = (AST)currentAST.root;
		returnAST = table_lists_AST;
	}
	
	public final void table_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST table_name_AST = null;
		
		AST tmp316_AST = null;
		tmp316_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp316_AST);
		match(ID);
		{
		switch ( LA(1)) {
		case LITERAL_as:
		case 58:
		{
			{
			switch ( LA(1)) {
			case LITERAL_as:
			{
				AST tmp317_AST = null;
				tmp317_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp317_AST);
				match(LITERAL_as);
				break;
			}
			case 58:
			{
				AST tmp318_AST = null;
				tmp318_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp318_AST);
				match(58);
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
		case 36:
		case LITERAL_group:
		case 47:
		case LITERAL_order:
		case 49:
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
	
	public final void compare_method() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compare_method_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_exists:
		case 273:
		case 274:
		{
			comparemethod_name();
			astFactory.addASTChild(currentAST, returnAST);
			compare_method_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_not:
		{
			AST tmp319_AST = null;
			tmp319_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp319_AST);
			match(LITERAL_not);
			AST tmp320_AST = null;
			tmp320_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp320_AST);
			match(LITERAL_exists);
			if ( inputState.guessing==0 ) {
				compare_method_AST = (AST)currentAST.root;
				compare_method_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NOT_EXISTS,"logic_not_exists")).add(compare_method_AST));
				currentAST.root = compare_method_AST;
				currentAST.child = compare_method_AST!=null &&compare_method_AST.getFirstChild()!=null ?
					compare_method_AST.getFirstChild() : compare_method_AST;
				currentAST.advanceChildToEnd();
			}
			compare_method_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = compare_method_AST;
	}
	
	public final void comparemethod_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparemethod_name_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_exists:
		{
			AST tmp321_AST = null;
			tmp321_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp321_AST);
			match(LITERAL_exists);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 273:
		{
			AST tmp322_AST = null;
			tmp322_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp322_AST);
			match(273);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 274:
		{
			AST tmp323_AST = null;
			tmp323_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp323_AST);
			match(274);
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
		_loop29:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp324_AST = null;
				tmp324_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp324_AST);
				match(COMMA);
				column();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop29;
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
		_loop32:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp325_AST = null;
				tmp325_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp325_AST);
				match(COMMA);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop32;
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
		_loop44:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp326_AST = null;
				tmp326_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp326_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop44;
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
		_loop47:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp327_AST = null;
				tmp327_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp327_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop47;
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
		_loop38:
		do {
			if (((LA(1) >= LITERAL_and && LA(1) <= 54))) {
				{
				switch ( LA(1)) {
				case LITERAL_and:
				{
					AST tmp328_AST = null;
					tmp328_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp328_AST);
					match(LITERAL_and);
					break;
				}
				case LITERAL_or:
				{
					AST tmp329_AST = null;
					tmp329_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp329_AST);
					match(LITERAL_or);
					break;
				}
				case 53:
				{
					AST tmp330_AST = null;
					tmp330_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp330_AST);
					match(53);
					break;
				}
				case 54:
				{
					AST tmp331_AST = null;
					tmp331_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp331_AST);
					match(54);
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
				break _loop38;
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
		
		boolean synPredMatched41 = false;
		if (((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_4.member(LA(3))) && (_tokenSet_5.member(LA(4))) && (_tokenSet_6.member(LA(5))))) {
			int _m41 = mark();
			synPredMatched41 = true;
			inputState.guessing++;
			try {
				{
				match(LPAREN);
				bool_exp();
				match(RPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched41 = false;
			}
			rewind(_m41);
inputState.guessing--;
		}
		if ( synPredMatched41 ) {
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
		else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_4.member(LA(2))) && (_tokenSet_6.member(LA(3))) && (_tokenSet_7.member(LA(4))) && (_tokenSet_8.member(LA(5)))) {
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
		case 59:
		case 60:
		case LITERAL_like:
		case COMPARE_OP:
		case 264:
		case 265:
		case 266:
		case 267:
		case 268:
		case 269:
		case 270:
		case 271:
		case LEFT_JOIN:
		{
			{
			switch ( LA(1)) {
			case 59:
			{
				AST tmp334_AST = null;
				tmp334_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp334_AST);
				match(59);
				break;
			}
			case 60:
			case LITERAL_like:
			case COMPARE_OP:
			case 264:
			case 265:
			case 266:
			case 267:
			case 268:
			case 269:
			case 270:
			case 271:
			case LEFT_JOIN:
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
		case 70:
		case 71:
		{
			{
			switch ( LA(1)) {
			case 70:
			{
				AST tmp335_AST = null;
				tmp335_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp335_AST);
				match(70);
				break;
			}
			case 71:
			{
				AST tmp336_AST = null;
				tmp336_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp336_AST);
				match(71);
				break;
			}
			default:
				if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_null)) {
					AST tmp337_AST = null;
					tmp337_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp337_AST);
					match(LITERAL_is);
					AST tmp338_AST = null;
					tmp338_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp338_AST);
					match(LITERAL_null);
					if ( inputState.guessing==0 ) {
						equation_AST = (AST)currentAST.root;
						equation_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NULL,"logic_null")).add(equation_AST));
						currentAST.root = equation_AST;
						currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
							equation_AST.getFirstChild() : equation_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_not)) {
					AST tmp339_AST = null;
					tmp339_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp339_AST);
					match(LITERAL_is);
					AST tmp340_AST = null;
					tmp340_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp340_AST);
					match(LITERAL_not);
					AST tmp341_AST = null;
					tmp341_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp341_AST);
					match(LITERAL_null);
					if ( inputState.guessing==0 ) {
						equation_AST = (AST)currentAST.root;
						equation_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NOT_NULL,"logic_not_null")).add(equation_AST));
						currentAST.root = equation_AST;
						currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
							equation_AST.getFirstChild() : equation_AST;
						currentAST.advanceChildToEnd();
					}
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			break;
		}
		case LITERAL_between:
		case 73:
		{
			{
			switch ( LA(1)) {
			case LITERAL_between:
			{
				AST tmp342_AST = null;
				tmp342_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp342_AST);
				match(LITERAL_between);
				break;
			}
			case 73:
			{
				AST tmp343_AST = null;
				tmp343_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp343_AST);
				match(73);
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
		default:
			if ((LA(1)==LITERAL_not) && (LA(2)==LITERAL_like)) {
				{
				AST tmp345_AST = null;
				tmp345_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp345_AST);
				match(LITERAL_not);
				AST tmp346_AST = null;
				tmp346_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp346_AST);
				match(LITERAL_like);
				}
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					equation_AST = (AST)currentAST.root;
					equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NOT_LIKE,"logic_not_like")).add(equation_AST));
					currentAST.root = equation_AST;
					currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
						equation_AST.getFirstChild() : equation_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if ((_tokenSet_9.member(LA(1))) && (LA(2)==LPAREN||LA(2)==LITERAL_in)) {
				{
				switch ( LA(1)) {
				case LITERAL_in:
				{
					AST tmp347_AST = null;
					tmp347_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp347_AST);
					match(LITERAL_in);
					if ( inputState.guessing==0 ) {
						equation_AST = (AST)currentAST.root;
						equation_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_IN,"logic_in")).add(equation_AST));
						currentAST.root = equation_AST;
						currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
							equation_AST.getFirstChild() : equation_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case LITERAL_not:
				{
					AST tmp348_AST = null;
					tmp348_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp348_AST);
					match(LITERAL_not);
					AST tmp349_AST = null;
					tmp349_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp349_AST);
					match(LITERAL_in);
					if ( inputState.guessing==0 ) {
						equation_AST = (AST)currentAST.root;
						equation_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NOT_IN,"logic_not_in")).add(equation_AST));
						currentAST.root = equation_AST;
						currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
							equation_AST.getFirstChild() : equation_AST;
						currentAST.advanceChildToEnd();
					}
					break;
				}
				case 75:
				{
					AST tmp350_AST = null;
					tmp350_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp350_AST);
					match(75);
					break;
				}
				case 76:
				{
					AST tmp351_AST = null;
					tmp351_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp351_AST);
					match(76);
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
			}
		else {
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
		else if ((_tokenSet_10.member(LA(1)))) {
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
		case TWO_ARG_OP:
		case MINUS:
		case 255:
		case 256:
		case 257:
		case 258:
		case 259:
		case 260:
		case 261:
		case 262:
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
		case 49:
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
		if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_11.member(LA(2)))) {
			alias();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==ID) && (LA(2)==POINT)) {
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_12.member(LA(1)))) {
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_10.member(LA(1)))) {
			function();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		switch ( LA(1)) {
		case 63:
		{
			AST tmp352_AST = null;
			tmp352_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp352_AST);
			match(63);
			break;
		}
		case 64:
		{
			AST tmp353_AST = null;
			tmp353_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp353_AST);
			match(64);
			break;
		}
		case LITERAL_asc:
		{
			AST tmp354_AST = null;
			tmp354_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp354_AST);
			match(LITERAL_asc);
			break;
		}
		case LITERAL_desc:
		{
			AST tmp355_AST = null;
			tmp355_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp355_AST);
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
		
		if ((_tokenSet_13.member(LA(1))) && (_tokenSet_14.member(LA(2))) && (_tokenSet_15.member(LA(3))) && (_tokenSet_16.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case 83:
			case LITERAL_count:
			case LITERAL_sum:
			case 88:
			case LITERAL_avg:
			case 90:
			case LITERAL_max:
			case 92:
			case LITERAL_min:
			case 94:
			case LITERAL_stddev:
			case LITERAL_variance:
			{
				aggregate_func();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((_tokenSet_18.member(LA(1))) && (_tokenSet_19.member(LA(2)))) {
					constant();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_10.member(LA(1))) && (_tokenSet_2.member(LA(2)))) {
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
			case TWO_ARG_OP:
			case MINUS:
			case 255:
			case 256:
			case 257:
			case 258:
			case 259:
			case 260:
			case 261:
			case 262:
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
			case 36:
			case LITERAL_from:
			case 44:
			case LITERAL_group:
			case 47:
			case LITERAL_order:
			case 49:
			case RPAREN:
			case LITERAL_as:
			case 58:
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
		else if ((LA(1)==LPAREN) && (_tokenSet_0.member(LA(2))) && (_tokenSet_20.member(LA(3))) && (_tokenSet_21.member(LA(4))) && (_tokenSet_15.member(LA(5)))) {
			AST tmp356_AST = null;
			tmp356_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp356_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp357_AST = null;
			tmp357_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp357_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case MINUS:
			case 255:
			case 256:
			case 257:
			case 258:
			case 259:
			case 260:
			case 261:
			case 262:
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
			case 36:
			case LITERAL_from:
			case 44:
			case LITERAL_group:
			case 47:
			case LITERAL_order:
			case 49:
			case RPAREN:
			case LITERAL_as:
			case 58:
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
		else if ((LA(1)==ONE_ARG_OP)) {
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
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
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
			AST tmp358_AST = null;
			tmp358_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp358_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp359_AST = null;
			tmp359_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp359_AST);
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
		
		AST tmp360_AST = null;
		tmp360_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp360_AST);
		match(ID);
		AST tmp361_AST = null;
		tmp361_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp361_AST);
		match(POINT);
		AST tmp362_AST = null;
		tmp362_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp362_AST);
		match(ID);
		field_name_AST = (AST)currentAST.root;
		returnAST = field_name_AST;
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_getdate:
		case 98:
		{
			empty_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_EMPTY_PARAM,"function_empty_param")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_pi:
		case 100:
		case LITERAL_now:
		case 102:
		case LITERAL_today:
		case 104:
		{
			star_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			match(STAR);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_STAR_PARAM,"function_star_param")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((_tokenSet_22.member(LA(1)))) {
				function_name();
				astFactory.addASTChild(currentAST, returnAST);
				match(LPAREN);
				parameters();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				if ( inputState.guessing==0 ) {
					function_AST = (AST)currentAST.root;
					function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION,"function_block")).add(function_AST));
					currentAST.root = function_AST;
					currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
						function_AST.getFirstChild() : function_AST;
					currentAST.advanceChildToEnd();
				}
				function_AST = (AST)currentAST.root;
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = function_AST;
	}
	
	public final void two_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST two_arg_op_AST = null;
		
		switch ( LA(1)) {
		case TWO_ARG_OP:
		{
			AST tmp370_AST = null;
			tmp370_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp370_AST);
			match(TWO_ARG_OP);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp371_AST = null;
			tmp371_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp371_AST);
			match(STAR);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp372_AST = null;
			tmp372_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp372_AST);
			match(MINUS);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 255:
		{
			AST tmp373_AST = null;
			tmp373_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp373_AST);
			match(255);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 256:
		{
			AST tmp374_AST = null;
			tmp374_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp374_AST);
			match(256);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 257:
		{
			AST tmp375_AST = null;
			tmp375_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp375_AST);
			match(257);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 258:
		{
			AST tmp376_AST = null;
			tmp376_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp376_AST);
			match(258);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 259:
		{
			AST tmp377_AST = null;
			tmp377_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp377_AST);
			match(259);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 260:
		{
			AST tmp378_AST = null;
			tmp378_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp378_AST);
			match(260);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 261:
		{
			AST tmp379_AST = null;
			tmp379_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp379_AST);
			match(261);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 262:
		{
			AST tmp380_AST = null;
			tmp380_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp380_AST);
			match(262);
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
		
		if ((LA(1)==83||LA(1)==LITERAL_count) && (LA(2)==LPAREN) && (LA(3)==STAR)) {
			{
			switch ( LA(1)) {
			case 83:
			{
				AST tmp381_AST = null;
				tmp381_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp381_AST);
				match(83);
				break;
			}
			case LITERAL_count:
			{
				AST tmp382_AST = null;
				tmp382_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp382_AST);
				match(LITERAL_count);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(LPAREN);
			match(STAR);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				aggregate_func_AST = (AST)currentAST.root;
				aggregate_func_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_STAR_COUNT,"function_star_count")).add(aggregate_func_AST));
				currentAST.root = aggregate_func_AST;
				currentAST.child = aggregate_func_AST!=null &&aggregate_func_AST.getFirstChild()!=null ?
					aggregate_func_AST.getFirstChild() : aggregate_func_AST;
				currentAST.advanceChildToEnd();
			}
			aggregate_func_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_12.member(LA(1))) && (LA(2)==LPAREN) && (_tokenSet_23.member(LA(3)))) {
			aggregate_func_name();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case LITERAL_all:
			{
				AST tmp387_AST = null;
				tmp387_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp387_AST);
				match(LITERAL_all);
				break;
			}
			case 86:
			{
				AST tmp388_AST = null;
				tmp388_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp388_AST);
				match(86);
				break;
			}
			case LITERAL_distinct:
			{
				AST tmp389_AST = null;
				tmp389_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp389_AST);
				match(LITERAL_distinct);
				break;
			}
			case 42:
			{
				AST tmp390_AST = null;
				tmp390_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp390_AST);
				match(42);
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
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = aggregate_func_AST;
	}
	
	public final void expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST expression_AST = null;
		
		if ((_tokenSet_24.member(LA(1))) && (_tokenSet_6.member(LA(2))) && (_tokenSet_25.member(LA(3))) && (_tokenSet_26.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
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
				if ((_tokenSet_18.member(LA(1))) && (_tokenSet_27.member(LA(2))) && (_tokenSet_25.member(LA(3))) && (_tokenSet_26.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
					constant();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_10.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_28.member(LA(3))) && (_tokenSet_6.member(LA(4))) && (_tokenSet_25.member(LA(5)))) {
					function();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((_tokenSet_29.member(LA(1)))) {
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
			else if ((_tokenSet_30.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_31.member(LA(3))) && (_tokenSet_6.member(LA(4))) && (_tokenSet_25.member(LA(5)))) {
			AST tmp392_AST = null;
			tmp392_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp392_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp393_AST = null;
			tmp393_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp393_AST);
			match(RPAREN);
			{
			if ((_tokenSet_29.member(LA(1)))) {
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
			else if ((_tokenSet_30.member(LA(1)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==ONE_ARG_OP)) {
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
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
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
			AST tmp394_AST = null;
			tmp394_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp394_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp395_AST = null;
			tmp395_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp395_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp396_AST = null;
			tmp396_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp396_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		case LITERAL_hour:
		case LITERAL_minute:
		case LITERAL_month:
		case LITERAL_quarter:
		case LITERAL_second:
		case LITERAL_week:
		case LITERAL_year:
		case LITERAL_yy:
		case LITERAL_mm:
		case LITERAL_dd:
		case LITERAL_qq:
		case LITERAL_wk:
		case LITERAL_dayofyear:
		case LITERAL_dy:
		case LITERAL_weekday:
		case LITERAL_dw:
		case LITERAL_hh:
		case LITERAL_mi:
		case LITERAL_ss:
		case LITERAL_millisecond:
		case LITERAL_ms:
		case LITERAL_calweekofyear:
		case LITERAL_cwk:
		case LITERAL_calyearofweek:
		case LITERAL_cyr:
		case LITERAL_caldayofweek:
		case LITERAL_cdw:
		{
			date_key_word();
			astFactory.addASTChild(currentAST, returnAST);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp397_AST = null;
			tmp397_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp397_AST);
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
		
		AST tmp398_AST = null;
		tmp398_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp398_AST);
		match(PARAM_ID);
		param_equ_AST = (AST)currentAST.root;
		returnAST = param_equ_AST;
	}
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		AST tmp399_AST = null;
		tmp399_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp399_AST);
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
			AST tmp400_AST = null;
			tmp400_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp400_AST);
			match(COMPARE_OP);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 60:
		{
			AST tmp401_AST = null;
			tmp401_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp401_AST);
			match(60);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 264:
		{
			AST tmp402_AST = null;
			tmp402_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp402_AST);
			match(264);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 265:
		{
			AST tmp403_AST = null;
			tmp403_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp403_AST);
			match(265);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 266:
		{
			AST tmp404_AST = null;
			tmp404_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp404_AST);
			match(266);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 267:
		{
			AST tmp405_AST = null;
			tmp405_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp405_AST);
			match(267);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 268:
		{
			AST tmp406_AST = null;
			tmp406_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp406_AST);
			match(268);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 269:
		{
			AST tmp407_AST = null;
			tmp407_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp407_AST);
			match(269);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 270:
		{
			AST tmp408_AST = null;
			tmp408_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp408_AST);
			match(270);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_like:
		{
			AST tmp409_AST = null;
			tmp409_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp409_AST);
			match(LITERAL_like);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 271:
		{
			AST tmp410_AST = null;
			tmp410_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp410_AST);
			match(271);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LEFT_JOIN:
		{
			AST tmp411_AST = null;
			tmp411_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp411_AST);
			match(LEFT_JOIN);
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
		
		AST tmp412_AST = null;
		tmp412_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp412_AST);
		match(LPAREN);
		constexpset();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp413_AST = null;
		tmp413_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp413_AST);
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
		_loop77:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp414_AST = null;
				tmp414_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp414_AST);
				match(COMMA);
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop77;
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
		
		AST tmp415_AST = null;
		tmp415_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp415_AST);
		match(LPAREN);
		select_statement();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp416_AST = null;
		tmp416_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp416_AST);
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
	
	public final void date_key_word() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST date_key_word_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_year:
		{
			AST tmp417_AST = null;
			tmp417_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp417_AST);
			match(LITERAL_year);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yy:
		{
			AST tmp418_AST = null;
			tmp418_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp418_AST);
			match(LITERAL_yy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp419_AST = null;
			tmp419_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp419_AST);
			match(LITERAL_month);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mm:
		{
			AST tmp420_AST = null;
			tmp420_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp420_AST);
			match(LITERAL_mm);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp421_AST = null;
			tmp421_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp421_AST);
			match(LITERAL_day);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dd:
		{
			AST tmp422_AST = null;
			tmp422_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp422_AST);
			match(LITERAL_dd);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp423_AST = null;
			tmp423_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp423_AST);
			match(LITERAL_quarter);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_qq:
		{
			AST tmp424_AST = null;
			tmp424_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp424_AST);
			match(LITERAL_qq);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp425_AST = null;
			tmp425_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp425_AST);
			match(LITERAL_week);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_wk:
		{
			AST tmp426_AST = null;
			tmp426_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp426_AST);
			match(LITERAL_wk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayofyear:
		{
			AST tmp427_AST = null;
			tmp427_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp427_AST);
			match(LITERAL_dayofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dy:
		{
			AST tmp428_AST = null;
			tmp428_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp428_AST);
			match(LITERAL_dy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weekday:
		{
			AST tmp429_AST = null;
			tmp429_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp429_AST);
			match(LITERAL_weekday);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dw:
		{
			AST tmp430_AST = null;
			tmp430_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp430_AST);
			match(LITERAL_dw);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp431_AST = null;
			tmp431_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp431_AST);
			match(LITERAL_hour);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hh:
		{
			AST tmp432_AST = null;
			tmp432_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp432_AST);
			match(LITERAL_hh);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp433_AST = null;
			tmp433_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp433_AST);
			match(LITERAL_minute);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mi:
		{
			AST tmp434_AST = null;
			tmp434_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp434_AST);
			match(LITERAL_mi);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp435_AST = null;
			tmp435_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp435_AST);
			match(LITERAL_second);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ss:
		{
			AST tmp436_AST = null;
			tmp436_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp436_AST);
			match(LITERAL_ss);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_millisecond:
		{
			AST tmp437_AST = null;
			tmp437_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp437_AST);
			match(LITERAL_millisecond);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ms:
		{
			AST tmp438_AST = null;
			tmp438_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp438_AST);
			match(LITERAL_ms);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_calweekofyear:
		{
			AST tmp439_AST = null;
			tmp439_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp439_AST);
			match(LITERAL_calweekofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cwk:
		{
			AST tmp440_AST = null;
			tmp440_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp440_AST);
			match(LITERAL_cwk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_calyearofweek:
		{
			AST tmp441_AST = null;
			tmp441_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp441_AST);
			match(LITERAL_calyearofweek);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cyr:
		{
			AST tmp442_AST = null;
			tmp442_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp442_AST);
			match(LITERAL_cyr);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_caldayofweek:
		{
			AST tmp443_AST = null;
			tmp443_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp443_AST);
			match(LITERAL_caldayofweek);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cdw:
		{
			AST tmp444_AST = null;
			tmp444_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp444_AST);
			match(LITERAL_cdw);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = date_key_word_AST;
	}
	
	public final void function_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_name_AST = null;
		
		switch ( LA(1)) {
		case LPAREN:
		{
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_abs:
		case 106:
		case LITERAL_acos:
		case 108:
		case LITERAL_asin:
		case 110:
		case LITERAL_atan:
		case 112:
		case 113:
		case 114:
		case LITERAL_ceiling:
		case 116:
		case LITERAL_cos:
		case 118:
		case LITERAL_cot:
		case 120:
		case LITERAL_degrees:
		case 122:
		case LITERAL_exp:
		case 124:
		case LITERAL_floor:
		case 126:
		case LITERAL_log:
		case 128:
		case 129:
		case 130:
		case LITERAL_mod:
		case 132:
		case LITERAL_power:
		case 134:
		case LITERAL_radians:
		case 136:
		case LITERAL_rand:
		case 138:
		case LITERAL_remaiindex:
		case LITERAL_round:
		case 141:
		case LITERAL_sign:
		case 143:
		case LITERAL_sin:
		case 145:
		case LITERAL_sqrt:
		case 147:
		case LITERAL_tan:
		case 149:
		case LITERAL_truncnum:
		{
			number_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ascii:
		case 152:
		case LITERAL_bit_length:
		case LITERAL_byte_length:
		case LITERAL_char:
		case 156:
		case LITERAL_char_length:
		case 158:
		case LITERAL_charindex:
		case 160:
		case LITERAL_difference:
		case 162:
		case LITERAL_insertstr:
		case LITERAL_lcase:
		case LITERAL_left:
		case 166:
		case LITERAL_length:
		case 168:
		case LITERAL_locate:
		case LITERAL_lower:
		case 171:
		case LITERAL_ltrim:
		case 173:
		case LITERAL_octet_length:
		case LITERAL_patindex:
		case 176:
		case LITERAL_repeat:
		case LITERAL_replace:
		case 179:
		case LITERAL_replicate:
		case LITERAL_right:
		case 182:
		case LITERAL_rtrim:
		case 184:
		case LITERAL_similar:
		case LITERAL_sortkey:
		case LITERAL_soundex:
		case LITERAL_space:
		case LITERAL_str:
		case 190:
		case LITERAL_string:
		case LITERAL_stuff:
		case LITERAL_substring:
		case 194:
		case LITERAL_trim:
		case LITERAL_ucase:
		case LITERAL_upper:
		case 198:
		{
			string_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateformat:
		case 200:
		case LITERAL_datename:
		case 202:
		case LITERAL_datepart:
		case 204:
		case LITERAL_datetime:
		case 206:
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
		case LITERAL_quarter:
		case LITERAL_seconds:
		case LITERAL_second:
		case LITERAL_weeks:
		case LITERAL_week:
		case LITERAL_years:
		case LITERAL_year:
		case LITERAL_ymd:
		case LITERAL_dateadd:
		case 228:
		case LITERAL_datediff:
		case 230:
		{
			datetime_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_convert:
		case 232:
		case LITERAL_cast:
		case LITERAL_hextoint:
		case 235:
		case LITERAL_inttohex:
		case 237:
		case LITERAL_isdate:
		case 239:
		case LITERAL_isnumeric:
		case 241:
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
		_loop89:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp445_AST = null;
				tmp445_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp445_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop89;
			}
			
		} while (true);
		}
		parameters_AST = (AST)currentAST.root;
		returnAST = parameters_AST;
	}
	
	public final void empty_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST empty_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_getdate:
		{
			AST tmp446_AST = null;
			tmp446_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp446_AST);
			match(LITERAL_getdate);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case 98:
		{
			AST tmp447_AST = null;
			tmp447_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp447_AST);
			match(98);
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
	
	public final void star_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST star_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_pi:
		{
			AST tmp448_AST = null;
			tmp448_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp448_AST);
			match(LITERAL_pi);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 100:
		{
			AST tmp449_AST = null;
			tmp449_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp449_AST);
			match(100);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_now:
		{
			AST tmp450_AST = null;
			tmp450_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp450_AST);
			match(LITERAL_now);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 102:
		{
			AST tmp451_AST = null;
			tmp451_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp451_AST);
			match(102);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_today:
		{
			AST tmp452_AST = null;
			tmp452_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp452_AST);
			match(LITERAL_today);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 104:
		{
			AST tmp453_AST = null;
			tmp453_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp453_AST);
			match(104);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = star_function_AST;
	}
	
	public final void aggregate_func_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST aggregate_func_name_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_sum:
		{
			AST tmp454_AST = null;
			tmp454_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp454_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 88:
		{
			AST tmp455_AST = null;
			tmp455_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp455_AST);
			match(88);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_avg:
		{
			AST tmp456_AST = null;
			tmp456_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp456_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 90:
		{
			AST tmp457_AST = null;
			tmp457_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp457_AST);
			match(90);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp458_AST = null;
			tmp458_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp458_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 92:
		{
			AST tmp459_AST = null;
			tmp459_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp459_AST);
			match(92);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp460_AST = null;
			tmp460_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp460_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 94:
		{
			AST tmp461_AST = null;
			tmp461_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp461_AST);
			match(94);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_count:
		{
			AST tmp462_AST = null;
			tmp462_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp462_AST);
			match(LITERAL_count);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 83:
		{
			AST tmp463_AST = null;
			tmp463_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp463_AST);
			match(83);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_stddev:
		{
			AST tmp464_AST = null;
			tmp464_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp464_AST);
			match(LITERAL_stddev);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_variance:
		{
			AST tmp465_AST = null;
			tmp465_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp465_AST);
			match(LITERAL_variance);
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
			AST tmp466_AST = null;
			tmp466_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp466_AST);
			match(LITERAL_abs);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 106:
		{
			AST tmp467_AST = null;
			tmp467_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp467_AST);
			match(106);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_acos:
		{
			AST tmp468_AST = null;
			tmp468_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp468_AST);
			match(LITERAL_acos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 108:
		{
			AST tmp469_AST = null;
			tmp469_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp469_AST);
			match(108);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asin:
		{
			AST tmp470_AST = null;
			tmp470_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp470_AST);
			match(LITERAL_asin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 110:
		{
			AST tmp471_AST = null;
			tmp471_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp471_AST);
			match(110);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_atan:
		{
			AST tmp472_AST = null;
			tmp472_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp472_AST);
			match(LITERAL_atan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 112:
		{
			AST tmp473_AST = null;
			tmp473_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp473_AST);
			match(112);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 113:
		{
			AST tmp474_AST = null;
			tmp474_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp474_AST);
			match(113);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 114:
		{
			AST tmp475_AST = null;
			tmp475_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp475_AST);
			match(114);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceiling:
		{
			AST tmp476_AST = null;
			tmp476_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp476_AST);
			match(LITERAL_ceiling);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 116:
		{
			AST tmp477_AST = null;
			tmp477_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp477_AST);
			match(116);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cos:
		{
			AST tmp478_AST = null;
			tmp478_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp478_AST);
			match(LITERAL_cos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 118:
		{
			AST tmp479_AST = null;
			tmp479_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp479_AST);
			match(118);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cot:
		{
			AST tmp480_AST = null;
			tmp480_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp480_AST);
			match(LITERAL_cot);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 120:
		{
			AST tmp481_AST = null;
			tmp481_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp481_AST);
			match(120);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_degrees:
		{
			AST tmp482_AST = null;
			tmp482_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp482_AST);
			match(LITERAL_degrees);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 122:
		{
			AST tmp483_AST = null;
			tmp483_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp483_AST);
			match(122);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exp:
		{
			AST tmp484_AST = null;
			tmp484_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp484_AST);
			match(LITERAL_exp);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 124:
		{
			AST tmp485_AST = null;
			tmp485_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp485_AST);
			match(124);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp486_AST = null;
			tmp486_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp486_AST);
			match(LITERAL_floor);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 126:
		{
			AST tmp487_AST = null;
			tmp487_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp487_AST);
			match(126);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_log:
		{
			AST tmp488_AST = null;
			tmp488_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp488_AST);
			match(LITERAL_log);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 128:
		{
			AST tmp489_AST = null;
			tmp489_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp489_AST);
			match(128);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp490_AST = null;
			tmp490_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp490_AST);
			match(129);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 130:
		{
			AST tmp491_AST = null;
			tmp491_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp491_AST);
			match(130);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp492_AST = null;
			tmp492_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp492_AST);
			match(LITERAL_mod);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 132:
		{
			AST tmp493_AST = null;
			tmp493_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp493_AST);
			match(132);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_power:
		{
			AST tmp494_AST = null;
			tmp494_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp494_AST);
			match(LITERAL_power);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 134:
		{
			AST tmp495_AST = null;
			tmp495_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp495_AST);
			match(134);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_radians:
		{
			AST tmp496_AST = null;
			tmp496_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp496_AST);
			match(LITERAL_radians);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 136:
		{
			AST tmp497_AST = null;
			tmp497_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp497_AST);
			match(136);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rand:
		{
			AST tmp498_AST = null;
			tmp498_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp498_AST);
			match(LITERAL_rand);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 138:
		{
			AST tmp499_AST = null;
			tmp499_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp499_AST);
			match(138);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_remaiindex:
		{
			AST tmp500_AST = null;
			tmp500_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp500_AST);
			match(LITERAL_remaiindex);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp501_AST = null;
			tmp501_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp501_AST);
			match(LITERAL_round);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 141:
		{
			AST tmp502_AST = null;
			tmp502_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp502_AST);
			match(141);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sign:
		{
			AST tmp503_AST = null;
			tmp503_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp503_AST);
			match(LITERAL_sign);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 143:
		{
			AST tmp504_AST = null;
			tmp504_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp504_AST);
			match(143);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sin:
		{
			AST tmp505_AST = null;
			tmp505_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp505_AST);
			match(LITERAL_sin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 145:
		{
			AST tmp506_AST = null;
			tmp506_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp506_AST);
			match(145);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sqrt:
		{
			AST tmp507_AST = null;
			tmp507_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp507_AST);
			match(LITERAL_sqrt);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 147:
		{
			AST tmp508_AST = null;
			tmp508_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp508_AST);
			match(147);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tan:
		{
			AST tmp509_AST = null;
			tmp509_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp509_AST);
			match(LITERAL_tan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 149:
		{
			AST tmp510_AST = null;
			tmp510_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp510_AST);
			match(149);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_truncnum:
		{
			AST tmp511_AST = null;
			tmp511_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp511_AST);
			match(LITERAL_truncnum);
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
			AST tmp512_AST = null;
			tmp512_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp512_AST);
			match(LITERAL_ascii);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 152:
		{
			AST tmp513_AST = null;
			tmp513_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp513_AST);
			match(152);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bit_length:
		{
			AST tmp514_AST = null;
			tmp514_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp514_AST);
			match(LITERAL_bit_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_byte_length:
		{
			AST tmp515_AST = null;
			tmp515_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp515_AST);
			match(LITERAL_byte_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char:
		{
			AST tmp516_AST = null;
			tmp516_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp516_AST);
			match(LITERAL_char);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 156:
		{
			AST tmp517_AST = null;
			tmp517_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp517_AST);
			match(156);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char_length:
		{
			AST tmp518_AST = null;
			tmp518_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp518_AST);
			match(LITERAL_char_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 158:
		{
			AST tmp519_AST = null;
			tmp519_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp519_AST);
			match(158);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_charindex:
		{
			AST tmp520_AST = null;
			tmp520_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp520_AST);
			match(LITERAL_charindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 160:
		{
			AST tmp521_AST = null;
			tmp521_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp521_AST);
			match(160);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_difference:
		{
			AST tmp522_AST = null;
			tmp522_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp522_AST);
			match(LITERAL_difference);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 162:
		{
			AST tmp523_AST = null;
			tmp523_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp523_AST);
			match(162);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_insertstr:
		{
			AST tmp524_AST = null;
			tmp524_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp524_AST);
			match(LITERAL_insertstr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lcase:
		{
			AST tmp525_AST = null;
			tmp525_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp525_AST);
			match(LITERAL_lcase);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_left:
		{
			AST tmp526_AST = null;
			tmp526_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp526_AST);
			match(LITERAL_left);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 166:
		{
			AST tmp527_AST = null;
			tmp527_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp527_AST);
			match(166);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_length:
		{
			AST tmp528_AST = null;
			tmp528_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp528_AST);
			match(LITERAL_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 168:
		{
			AST tmp529_AST = null;
			tmp529_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp529_AST);
			match(168);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_locate:
		{
			AST tmp530_AST = null;
			tmp530_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp530_AST);
			match(LITERAL_locate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp531_AST = null;
			tmp531_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp531_AST);
			match(LITERAL_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 171:
		{
			AST tmp532_AST = null;
			tmp532_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp532_AST);
			match(171);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp533_AST = null;
			tmp533_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp533_AST);
			match(LITERAL_ltrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 173:
		{
			AST tmp534_AST = null;
			tmp534_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp534_AST);
			match(173);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_octet_length:
		{
			AST tmp535_AST = null;
			tmp535_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp535_AST);
			match(LITERAL_octet_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_patindex:
		{
			AST tmp536_AST = null;
			tmp536_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp536_AST);
			match(LITERAL_patindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 176:
		{
			AST tmp537_AST = null;
			tmp537_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp537_AST);
			match(176);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_repeat:
		{
			AST tmp538_AST = null;
			tmp538_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp538_AST);
			match(LITERAL_repeat);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replace:
		{
			AST tmp539_AST = null;
			tmp539_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp539_AST);
			match(LITERAL_replace);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 179:
		{
			AST tmp540_AST = null;
			tmp540_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp540_AST);
			match(179);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replicate:
		{
			AST tmp541_AST = null;
			tmp541_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp541_AST);
			match(LITERAL_replicate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_right:
		{
			AST tmp542_AST = null;
			tmp542_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp542_AST);
			match(LITERAL_right);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 182:
		{
			AST tmp543_AST = null;
			tmp543_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp543_AST);
			match(182);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp544_AST = null;
			tmp544_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp544_AST);
			match(LITERAL_rtrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 184:
		{
			AST tmp545_AST = null;
			tmp545_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp545_AST);
			match(184);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_similar:
		{
			AST tmp546_AST = null;
			tmp546_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp546_AST);
			match(LITERAL_similar);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sortkey:
		{
			AST tmp547_AST = null;
			tmp547_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp547_AST);
			match(LITERAL_sortkey);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_soundex:
		{
			AST tmp548_AST = null;
			tmp548_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp548_AST);
			match(LITERAL_soundex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_space:
		{
			AST tmp549_AST = null;
			tmp549_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp549_AST);
			match(LITERAL_space);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_str:
		{
			AST tmp550_AST = null;
			tmp550_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp550_AST);
			match(LITERAL_str);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 190:
		{
			AST tmp551_AST = null;
			tmp551_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp551_AST);
			match(190);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_string:
		{
			AST tmp552_AST = null;
			tmp552_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp552_AST);
			match(LITERAL_string);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_stuff:
		{
			AST tmp553_AST = null;
			tmp553_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp553_AST);
			match(LITERAL_stuff);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substring:
		{
			AST tmp554_AST = null;
			tmp554_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp554_AST);
			match(LITERAL_substring);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 194:
		{
			AST tmp555_AST = null;
			tmp555_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp555_AST);
			match(194);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trim:
		{
			AST tmp556_AST = null;
			tmp556_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp556_AST);
			match(LITERAL_trim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ucase:
		{
			AST tmp557_AST = null;
			tmp557_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp557_AST);
			match(LITERAL_ucase);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_upper:
		{
			AST tmp558_AST = null;
			tmp558_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp558_AST);
			match(LITERAL_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 198:
		{
			AST tmp559_AST = null;
			tmp559_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp559_AST);
			match(198);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
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
			AST tmp560_AST = null;
			tmp560_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp560_AST);
			match(LITERAL_dateformat);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 200:
		{
			AST tmp561_AST = null;
			tmp561_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp561_AST);
			match(200);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datename:
		{
			AST tmp562_AST = null;
			tmp562_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp562_AST);
			match(LITERAL_datename);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 202:
		{
			AST tmp563_AST = null;
			tmp563_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp563_AST);
			match(202);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datepart:
		{
			AST tmp564_AST = null;
			tmp564_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp564_AST);
			match(LITERAL_datepart);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 204:
		{
			AST tmp565_AST = null;
			tmp565_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp565_AST);
			match(204);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datetime:
		{
			AST tmp566_AST = null;
			tmp566_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp566_AST);
			match(LITERAL_datetime);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 206:
		{
			AST tmp567_AST = null;
			tmp567_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp567_AST);
			match(206);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp568_AST = null;
			tmp568_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp568_AST);
			match(LITERAL_date);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayname:
		{
			AST tmp569_AST = null;
			tmp569_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp569_AST);
			match(LITERAL_dayname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_days:
		{
			AST tmp570_AST = null;
			tmp570_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp570_AST);
			match(LITERAL_days);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp571_AST = null;
			tmp571_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp571_AST);
			match(LITERAL_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dow:
		{
			AST tmp572_AST = null;
			tmp572_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp572_AST);
			match(LITERAL_dow);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hours:
		{
			AST tmp573_AST = null;
			tmp573_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp573_AST);
			match(LITERAL_hours);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp574_AST = null;
			tmp574_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp574_AST);
			match(LITERAL_hour);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minutes:
		{
			AST tmp575_AST = null;
			tmp575_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp575_AST);
			match(LITERAL_minutes);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp576_AST = null;
			tmp576_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp576_AST);
			match(LITERAL_minute);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_monthname:
		{
			AST tmp577_AST = null;
			tmp577_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp577_AST);
			match(LITERAL_monthname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_months:
		{
			AST tmp578_AST = null;
			tmp578_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp578_AST);
			match(LITERAL_months);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp579_AST = null;
			tmp579_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp579_AST);
			match(LITERAL_month);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp580_AST = null;
			tmp580_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp580_AST);
			match(LITERAL_quarter);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_seconds:
		{
			AST tmp581_AST = null;
			tmp581_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp581_AST);
			match(LITERAL_seconds);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp582_AST = null;
			tmp582_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp582_AST);
			match(LITERAL_second);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weeks:
		{
			AST tmp583_AST = null;
			tmp583_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp583_AST);
			match(LITERAL_weeks);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp584_AST = null;
			tmp584_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp584_AST);
			match(LITERAL_week);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_years:
		{
			AST tmp585_AST = null;
			tmp585_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp585_AST);
			match(LITERAL_years);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_year:
		{
			AST tmp586_AST = null;
			tmp586_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp586_AST);
			match(LITERAL_year);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ymd:
		{
			AST tmp587_AST = null;
			tmp587_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp587_AST);
			match(LITERAL_ymd);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateadd:
		{
			AST tmp588_AST = null;
			tmp588_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp588_AST);
			match(LITERAL_dateadd);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 228:
		{
			AST tmp589_AST = null;
			tmp589_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp589_AST);
			match(228);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datediff:
		{
			AST tmp590_AST = null;
			tmp590_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp590_AST);
			match(LITERAL_datediff);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 230:
		{
			AST tmp591_AST = null;
			tmp591_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp591_AST);
			match(230);
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
			AST tmp592_AST = null;
			tmp592_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp592_AST);
			match(LITERAL_convert);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 232:
		{
			AST tmp593_AST = null;
			tmp593_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp593_AST);
			match(232);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cast:
		{
			AST tmp594_AST = null;
			tmp594_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp594_AST);
			match(LITERAL_cast);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hextoint:
		{
			AST tmp595_AST = null;
			tmp595_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp595_AST);
			match(LITERAL_hextoint);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 235:
		{
			AST tmp596_AST = null;
			tmp596_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp596_AST);
			match(235);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_inttohex:
		{
			AST tmp597_AST = null;
			tmp597_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp597_AST);
			match(LITERAL_inttohex);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 237:
		{
			AST tmp598_AST = null;
			tmp598_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp598_AST);
			match(237);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isdate:
		{
			AST tmp599_AST = null;
			tmp599_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp599_AST);
			match(LITERAL_isdate);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 239:
		{
			AST tmp600_AST = null;
			tmp600_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp600_AST);
			match(239);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isnumeric:
		{
			AST tmp601_AST = null;
			tmp601_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp601_AST);
			match(LITERAL_isnumeric);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 241:
		{
			AST tmp602_AST = null;
			tmp602_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp602_AST);
			match(241);
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
			AST tmp603_AST = null;
			tmp603_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp603_AST);
			match(LITERAL_suser_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_suser_name:
		{
			AST tmp604_AST = null;
			tmp604_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp604_AST);
			match(LITERAL_suser_name);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_id:
		{
			AST tmp605_AST = null;
			tmp605_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp605_AST);
			match(LITERAL_user_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_name:
		{
			AST tmp606_AST = null;
			tmp606_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp606_AST);
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
			AST tmp607_AST = null;
			tmp607_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp607_AST);
			match(LITERAL_decode);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dump:
		{
			AST tmp608_AST = null;
			tmp608_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp608_AST);
			match(LITERAL_dump);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_greatest:
		{
			AST tmp609_AST = null;
			tmp609_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp609_AST);
			match(LITERAL_greatest);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_least:
		{
			AST tmp610_AST = null;
			tmp610_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp610_AST);
			match(LITERAL_least);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nvl:
		{
			AST tmp611_AST = null;
			tmp611_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp611_AST);
			match(LITERAL_nvl);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_vsize:
		{
			AST tmp612_AST = null;
			tmp612_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp612_AST);
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
	
	public final void logic_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_and:
		{
			AST tmp613_AST = null;
			tmp613_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp613_AST);
			match(LITERAL_and);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		{
			AST tmp614_AST = null;
			tmp614_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp614_AST);
			match(LITERAL_or);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 53:
		{
			AST tmp615_AST = null;
			tmp615_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp615_AST);
			match(53);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 54:
		{
			AST tmp616_AST = null;
			tmp616_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp616_AST);
			match(54);
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
		"SEARCH_NOT_CONDITION",
		"SUBQUERY",
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"FUNCTION_EMPTY_PARAM",
		"FUNCTION_STAR_PARAM",
		"FUNCTION_STAR_COUNT",
		"LOGIC_OP",
		"LOGICAL_NULL",
		"LOGICAL_NOT_NULL",
		"LOGICAL_IN",
		"LOGICAL_NOT_IN",
		"LOGICAL_LIKE",
		"LOGICAL_NOT_LIKE",
		"LOGICAL_EXISTS",
		"LOGICAL_NOT_EXISTS",
		"LOGICAL_BETWEEN",
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
		"\"not\"",
		"\"exists\"",
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
		"\"like\"",
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"PARAM_ID",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
		"NEGATIVE_DIGIT_ELEMENT",
		"\"\\u6c42\\u8bb0\\u5f55\\u603b\\u6570\"",
		"\"count\"",
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
		"\"stddev\"",
		"\"variance\"",
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"pi\"",
		"\"\\u6c42PI\"",
		"\"now\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"today\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\"",
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
		"\"\\u6c42\\u4f59\"",
		"\"power\"",
		"\"\\u6c42\\u6570\\u5b57\\u7684\\u6b21\\u5e42\\u503c\"",
		"\"radians\"",
		"\"\\u6c42\\u5ea6\\u6570\\u89d2\\u7684\\u5f27\\u5ea6\"",
		"\"rand\"",
		"\"\\u6c420\\u548c1\\u95f4\\u7684\\u968f\\u673a\\u6570\"",
		"\"remaiindex\"",
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
		"\"truncnum\"",
		"\"ascii\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u4e2a\\u5b57\\u7b26\\u7684ASCII\\u7801\"",
		"\"bit_length\"",
		"\"byte_length\"",
		"\"char\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u5dee\\u503c\"",
		"\"insertstr\"",
		"\"lcase\"",
		"\"left\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5de6\\u622a\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u603b\\u957f\\u5ea6\"",
		"\"locate\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"octet_length\"",
		"\"patindex\"",
		"\"\\u6c42\\u7b2c\\u4e00\\u6b21\\u51fa\\u73b0\\u4f4d\\u7f6e\"",
		"\"repeat\"",
		"\"replace\"",
		"\"\\u5b57\\u7b26\\u4e32\\u66ff\\u6362\"",
		"\"replicate\"",
		"\"right\"",
		"\"\\u5b57\\u7b26\\u4e32\\u53f3\\u622a\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"similar\"",
		"\"sortkey\"",
		"\"soundex\"",
		"\"space\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"string\"",
		"\"stuff\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"trim\"",
		"\"ucase\"",
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
		"\"quarter\"",
		"\"seconds\"",
		"\"second\"",
		"\"weeks\"",
		"\"week\"",
		"\"years\"",
		"\"year\"",
		"\"ymd\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u76f8\\u52a0\"",
		"\"datediff\"",
		"\"\\u65e5\\u671f\\u76f8\\u51cf\"",
		"\"convert\"",
		"\"\\u5b57\\u7b26\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"cast\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u4e3a\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u4e3a\\u6570\\u503c\\u578b\"",
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
		"\"\\u6c42\\u6a21\"",
		"COMPARE_OP",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"\\u5de6\\u8fde\\u63a5\"",
		"LEFT_JOIN",
		"\"\\u5b58\\u5728\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"yy\"",
		"\"mm\"",
		"\"dd\"",
		"\"qq\"",
		"\"wk\"",
		"\"dayofyear\"",
		"\"dy\"",
		"\"weekday\"",
		"\"dw\"",
		"\"hh\"",
		"\"mi\"",
		"\"ss\"",
		"\"millisecond\"",
		"\"ms\"",
		"\"calweekofyear\"",
		"\"cwk\"",
		"\"calyearofweek\"",
		"\"cyr\"",
		"\"caldayofweek\"",
		"\"cdw\"",
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
		long[] data = new long[10];
		data[0]=36028797018963968L;
		data[1]=-6373344L;
		data[2]=-1L;
		data[3]=2305843009213693951L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[10];
		data[0]=5153164816692543490L;
		data[1]=-6299616L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[10];
		data[0]=36028797018963968L;
		data[1]=-8589484000L;
		data[2]=-1L;
		data[3]=2305843009213693951L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[10];
		data[0]=6953557824660045824L;
		data[1]=-6373344L;
		data[2]=-1L;
		data[3]=2305843009213693951L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[10];
		data[0]=6377097209795575808L;
		data[1]=-8589410312L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[10];
		data[0]=6482931805333749760L;
		data[1]=-8589410312L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[10];
		data[0]=6483952152661196802L;
		data[1]=-8589410312L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[10];
		data[0]=6484024199663845378L;
		data[1]=-6291464L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[10];
		data[0]=-433498230907469822L;
		data[1]=-6291457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 137438953472L, 7168L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = new long[8];
		data[0]=36028797018963968L;
		data[1]=-8589934592L;
		data[2]=-1L;
		data[3]=1152921504606846975L;
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { -9151314437985009662L, 7L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 0L, 8583118848L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[10];
		data[0]=36028797018963968L;
		data[1]=-6373344L;
		data[2]=-1L;
		data[3]=1152921504606846975L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[10];
		data[0]=5153164816692543490L;
		data[1]=-8589418464L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[10];
		data[0]=7460212507324448770L;
		data[1]=-8160L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[10];
		data[0]=-33777272620056574L;
		data[1]=-6291457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[10];
		data[0]=-275414777854L;
		for (int i = 1; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[10];
		data[1]=426016L;
		data[3]=11486363648L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[10];
		data[0]=5117136019673579522L;
		data[3]=-2305843009213693952L;
		data[4]=127L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = new long[10];
		data[0]=4719772409484279808L;
		data[1]=-6299616L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = new long[10];
		data[0]=5153171413762310146L;
		data[1]=-8160L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[8];
		data[0]=36028797018963968L;
		data[1]=-2199023255552L;
		data[2]=-1L;
		data[3]=1152921504606846975L;
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[10];
		data[0]=36035394088730624L;
		data[1]=-8583192544L;
		data[2]=-1L;
		data[3]=2305843009213693951L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[10];
		data[0]=36028797018963968L;
		data[1]=-8589484000L;
		data[2]=-1L;
		data[3]=1152921504606846975L;
		data[4]=549755289600L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[10];
		data[0]=-2306975781605081086L;
		data[1]=-6291457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[10];
		data[0]=-275414777854L;
		data[1]=-6291457L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[10];
		data[0]=6483952152661196802L;
		data[1]=-8589475848L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755420671L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = new long[10];
		data[0]=4719772413779247104L;
		data[1]=-8589418464L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = new long[10];
		data[0]=4611686018427387904L;
		data[3]=-2305843009213693952L;
		data[4]=127L;
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = new long[10];
		data[0]=1872266134233808898L;
		data[1]=-8589475848L;
		data[2]=-1L;
		data[3]=2305843009213693951L;
		data[4]=549755420544L;
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[10];
		data[0]=4719772409484279808L;
		data[1]=-8589418464L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=549755289727L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	
	}
