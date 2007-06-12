// $ANTLR 2.7.7 (2006-11-01): "src/parser/oracle/parser_oracle.g" -> "Oracle9iParser.java"$

	package parser.oracle;

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

public class Oracle9iParser extends antlr.LLkParser       implements Oracle9iParserTokenTypes
 {

protected Oracle9iParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Oracle9iParser(TokenBuffer tokenBuf) {
  this(tokenBuf,5);
}

protected Oracle9iParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public Oracle9iParser(TokenStream lexer) {
  this(lexer,5);
}

public Oracle9iParser(ParserSharedInputState state) {
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
			AST tmp317_AST = null;
			tmp317_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp317_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp318_AST = null;
			tmp318_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp318_AST);
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
		case SELECT_ALL_CN:
		{
			all = LT(1);
			all_AST = astFactory.create(all);
			astFactory.addASTChild(currentAST, all_AST);
			match(SELECT_ALL_CN);
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
			AST tmp320_AST = null;
			tmp320_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp320_AST);
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
				case AS_EN:
				case AS_CN:
				{
					{
					switch ( LA(1)) {
					case AS_EN:
					{
						AST tmp321_AST = null;
						tmp321_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp321_AST);
						match(AS_EN);
						break;
					}
					case AS_CN:
					{
						AST tmp322_AST = null;
						tmp322_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp322_AST);
						match(AS_CN);
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
				case WHERE_EN:
				case WHERE_CN:
				case FROM_EN:
				case FROM_CN:
				case GROUP_EN:
				case GROUP_BY_CN:
				case ORDER_EN:
				case ORDER_BY_CN:
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
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==67||LA(2)==68)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 67:
				{
					AST tmp323_AST = null;
					tmp323_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp323_AST);
					match(67);
					break;
				}
				case 68:
				{
					AST tmp324_AST = null;
					tmp324_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp324_AST);
					match(68);
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
		else if ((LA(1)==NOT_EN||LA(1)==NOT_CN)) {
			{
			switch ( LA(1)) {
			case NOT_EN:
			{
				AST tmp325_AST = null;
				tmp325_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp325_AST);
				match(NOT_EN);
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
			case NOT_CN:
			{
				AST tmp326_AST = null;
				tmp326_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp326_AST);
				match(NOT_CN);
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
				AST tmp327_AST = null;
				tmp327_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp327_AST);
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
		case TABLE_UNION_EN:
		case TABLE_UNION_CN:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case TABLE_COMPARE_EN:
		case TABLE_COMPARE_CN:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case SELECT_EN:
		case SELECT_CN:
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
		case TABLE_UNION_EN:
		{
			AST tmp329_AST = null;
			tmp329_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp329_AST);
			match(TABLE_UNION_EN);
			break;
		}
		case TABLE_UNION_CN:
		{
			AST tmp330_AST = null;
			tmp330_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp330_AST);
			match(TABLE_UNION_CN);
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
		case TABLE_COMPARE_EN:
		{
			AST tmp331_AST = null;
			tmp331_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp331_AST);
			match(TABLE_COMPARE_EN);
			break;
		}
		case TABLE_COMPARE_CN:
		{
			AST tmp332_AST = null;
			tmp332_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp332_AST);
			match(TABLE_COMPARE_CN);
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
		case WHERE_EN:
		{
			match(WHERE_EN);
			break;
		}
		case WHERE_CN:
		{
			match(WHERE_CN);
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
		case SELECT_EN:
		{
			AST tmp336_AST = null;
			tmp336_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp336_AST);
			match(SELECT_EN);
			break;
		}
		case SELECT_CN:
		{
			AST tmp337_AST = null;
			tmp337_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp337_AST);
			match(SELECT_CN);
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
		case DISTINCT_EN:
		{
			AST tmp338_AST = null;
			tmp338_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp338_AST);
			match(DISTINCT_EN);
			break;
		}
		case DISTINCT_CN:
		{
			AST tmp339_AST = null;
			tmp339_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp339_AST);
			match(DISTINCT_CN);
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
		case FROM_EN:
		case FROM_CN:
		{
			{
			switch ( LA(1)) {
			case FROM_EN:
			{
				AST tmp340_AST = null;
				tmp340_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp340_AST);
				match(FROM_EN);
				break;
			}
			case FROM_CN:
			{
				AST tmp341_AST = null;
				tmp341_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp341_AST);
				match(FROM_CN);
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
		case WHERE_EN:
		case WHERE_CN:
		case GROUP_EN:
		case GROUP_BY_CN:
		case ORDER_EN:
		case ORDER_BY_CN:
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
		case WHERE_EN:
		case WHERE_CN:
		{
			{
			switch ( LA(1)) {
			case WHERE_EN:
			{
				AST tmp342_AST = null;
				tmp342_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp342_AST);
				match(WHERE_EN);
				break;
			}
			case WHERE_CN:
			{
				AST tmp343_AST = null;
				tmp343_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp343_AST);
				match(WHERE_CN);
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
		case GROUP_EN:
		case GROUP_BY_CN:
		case ORDER_EN:
		case ORDER_BY_CN:
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
		case GROUP_EN:
		case GROUP_BY_CN:
		{
			{
			switch ( LA(1)) {
			case GROUP_EN:
			{
				AST tmp344_AST = null;
				tmp344_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp344_AST);
				match(GROUP_EN);
				match(BY_EN);
				break;
			}
			case GROUP_BY_CN:
			{
				AST tmp346_AST = null;
				tmp346_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp346_AST);
				match(GROUP_BY_CN);
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
		case ORDER_EN:
		case ORDER_BY_CN:
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
		case ORDER_EN:
		case ORDER_BY_CN:
		{
			{
			switch ( LA(1)) {
			case ORDER_EN:
			{
				AST tmp347_AST = null;
				tmp347_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp347_AST);
				match(ORDER_EN);
				match(BY_EN);
				break;
			}
			case ORDER_BY_CN:
			{
				AST tmp349_AST = null;
				tmp349_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp349_AST);
				match(ORDER_BY_CN);
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
				AST tmp350_AST = null;
				tmp350_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp350_AST);
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
		
		AST tmp351_AST = null;
		tmp351_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp351_AST);
		match(ID);
		{
		switch ( LA(1)) {
		case AS_EN:
		case AS_CN:
		{
			{
			switch ( LA(1)) {
			case AS_EN:
			{
				AST tmp352_AST = null;
				tmp352_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp352_AST);
				match(AS_EN);
				break;
			}
			case AS_CN:
			{
				AST tmp353_AST = null;
				tmp353_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp353_AST);
				match(AS_CN);
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
		case WHERE_EN:
		case WHERE_CN:
		case GROUP_EN:
		case GROUP_BY_CN:
		case ORDER_EN:
		case ORDER_BY_CN:
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
		case EXISTS_EN:
		case EXISTS_CN:
		case NOT_EXISTS_CN:
		{
			{
			switch ( LA(1)) {
			case EXISTS_EN:
			{
				AST tmp354_AST = null;
				tmp354_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp354_AST);
				match(EXISTS_EN);
				break;
			}
			case EXISTS_CN:
			{
				AST tmp355_AST = null;
				tmp355_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp355_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp356_AST = null;
				tmp356_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp356_AST);
				match(NOT_EXISTS_CN);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			compare_method_AST = (AST)currentAST.root;
			break;
		}
		case NOT_EN:
		{
			AST tmp357_AST = null;
			tmp357_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp357_AST);
			match(NOT_EN);
			AST tmp358_AST = null;
			tmp358_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp358_AST);
			match(EXISTS_EN);
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
	
	public final void select_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;
		
		column();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop30:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp359_AST = null;
				tmp359_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp359_AST);
				match(COMMA);
				column();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop30;
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
		_loop33:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp360_AST = null;
				tmp360_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp360_AST);
				match(COMMA);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop33;
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
		_loop45:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp361_AST = null;
				tmp361_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp361_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop45;
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
		_loop48:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp362_AST = null;
				tmp362_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp362_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop48;
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
		_loop39:
		do {
			if (((LA(1) >= AND_EN && LA(1) <= OR_CN))) {
				{
				switch ( LA(1)) {
				case AND_EN:
				{
					AST tmp363_AST = null;
					tmp363_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp363_AST);
					match(AND_EN);
					break;
				}
				case OR_EN:
				{
					AST tmp364_AST = null;
					tmp364_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp364_AST);
					match(OR_EN);
					break;
				}
				case AND_CN:
				{
					AST tmp365_AST = null;
					tmp365_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp365_AST);
					match(AND_CN);
					break;
				}
				case OR_CN:
				{
					AST tmp366_AST = null;
					tmp366_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp366_AST);
					match(OR_CN);
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
				break _loop39;
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
		
		boolean synPredMatched42 = false;
		if (((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_4.member(LA(3))) && (_tokenSet_5.member(LA(4))) && (_tokenSet_6.member(LA(5))))) {
			int _m42 = mark();
			synPredMatched42 = true;
			inputState.guessing++;
			try {
				{
				match(LPAREN);
				bool_exp();
				match(RPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched42 = false;
			}
			rewind(_m42);
inputState.guessing--;
		}
		if ( synPredMatched42 ) {
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
		case 68:
		case ASSIGNEQUAL:
		case 279:
		case 280:
		case 281:
		case 282:
		case 283:
		case NOTEQUAL1:
		case NOTEQUAL2:
		case LESSTHANOREQUALTO1:
		case LESSTHANOREQUALTO2:
		case LESSTHAN:
		case GREATERTHANOREQUALTO1:
		case GREATERTHANOREQUALTO2:
		case GREATERTHAN:
		{
			{
			compare_op();
			astFactory.addASTChild(currentAST, returnAST);
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
		case EXISTS_EN:
		{
			{
			AST tmp369_AST = null;
			tmp369_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp369_AST);
			match(EXISTS_EN);
			}
			subquery();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				equation_AST = (AST)currentAST.root;
				equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_EXISTS,"logic_exists")).add(equation_AST));
				currentAST.root = equation_AST;
				currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
					equation_AST.getFirstChild() : equation_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case EXISTS_CN:
		case NOT_EXISTS_CN:
		{
			{
			switch ( LA(1)) {
			case EXISTS_CN:
			{
				AST tmp370_AST = null;
				tmp370_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp370_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp371_AST = null;
				tmp371_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp371_AST);
				match(NOT_EXISTS_CN);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			subquery();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LIKE_EN:
		{
			{
			AST tmp372_AST = null;
			tmp372_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp372_AST);
			match(LIKE_EN);
			}
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				equation_AST = (AST)currentAST.root;
				equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_LIKE,"logic_like")).add(equation_AST));
				currentAST.root = equation_AST;
				currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
					equation_AST.getFirstChild() : equation_AST;
				currentAST.advanceChildToEnd();
			}
			break;
		}
		case LIKE_CN:
		case NOT_LIKE_CN:
		{
			{
			switch ( LA(1)) {
			case LIKE_CN:
			{
				AST tmp373_AST = null;
				tmp373_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp373_AST);
				match(LIKE_CN);
				break;
			}
			case NOT_LIKE_CN:
			{
				AST tmp374_AST = null;
				tmp374_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp374_AST);
				match(NOT_LIKE_CN);
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
			break;
		}
		case IS_EN:
		case NULL_CN:
		case NOT_NULL_CN:
		{
			{
			switch ( LA(1)) {
			case NULL_CN:
			{
				AST tmp375_AST = null;
				tmp375_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp375_AST);
				match(NULL_CN);
				break;
			}
			case NOT_NULL_CN:
			{
				AST tmp376_AST = null;
				tmp376_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp376_AST);
				match(NOT_NULL_CN);
				break;
			}
			default:
				if ((LA(1)==IS_EN) && (LA(2)==NULL_EN)) {
					AST tmp377_AST = null;
					tmp377_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp377_AST);
					match(IS_EN);
					AST tmp378_AST = null;
					tmp378_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp378_AST);
					match(NULL_EN);
					if ( inputState.guessing==0 ) {
						equation_AST = (AST)currentAST.root;
						equation_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NULL,"logic_null")).add(equation_AST));
						currentAST.root = equation_AST;
						currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
							equation_AST.getFirstChild() : equation_AST;
						currentAST.advanceChildToEnd();
					}
				}
				else if ((LA(1)==IS_EN) && (LA(2)==NOT_EN)) {
					AST tmp379_AST = null;
					tmp379_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp379_AST);
					match(IS_EN);
					AST tmp380_AST = null;
					tmp380_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp380_AST);
					match(NOT_EN);
					AST tmp381_AST = null;
					tmp381_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp381_AST);
					match(NULL_EN);
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
		case BETWEEN_CN:
		{
			AST tmp382_AST = null;
			tmp382_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp382_AST);
			match(BETWEEN_CN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case BETWEEN_EN:
		{
			AST tmp383_AST = null;
			tmp383_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp383_AST);
			match(BETWEEN_EN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			match(AND_EN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
			if ((LA(1)==NOT_EN) && (LA(2)==EXISTS_EN)) {
				{
				AST tmp385_AST = null;
				tmp385_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp385_AST);
				match(NOT_EN);
				AST tmp386_AST = null;
				tmp386_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp386_AST);
				match(EXISTS_EN);
				}
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					equation_AST = (AST)currentAST.root;
					equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGICAL_NOT_EXISTS,"logic_not_exists")).add(equation_AST));
					currentAST.root = equation_AST;
					currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
						equation_AST.getFirstChild() : equation_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else if ((LA(1)==NOT_EN) && (LA(2)==LIKE_EN)) {
				{
				AST tmp387_AST = null;
				tmp387_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp387_AST);
				match(NOT_EN);
				AST tmp388_AST = null;
				tmp388_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp388_AST);
				match(LIKE_EN);
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
			else if ((_tokenSet_10.member(LA(1))) && (LA(2)==LPAREN||LA(2)==IN_EN)) {
				{
				switch ( LA(1)) {
				case IN_EN:
				{
					AST tmp389_AST = null;
					tmp389_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp389_AST);
					match(IN_EN);
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
				case NOT_EN:
				{
					AST tmp390_AST = null;
					tmp390_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp390_AST);
					match(NOT_EN);
					AST tmp391_AST = null;
					tmp391_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp391_AST);
					match(IN_EN);
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
				case IN_CN:
				{
					AST tmp392_AST = null;
					tmp392_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp392_AST);
					match(IN_CN);
					break;
				}
				case NOT_IN_CN:
				{
					AST tmp393_AST = null;
					tmp393_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp393_AST);
					match(NOT_IN_CN);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_11.member(LA(2))) && (_tokenSet_12.member(LA(3))) && (_tokenSet_13.member(LA(4))) && (_tokenSet_14.member(LA(5)))) {
			AST tmp394_AST = null;
			tmp394_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp394_AST);
			match(LPAREN);
			aggregate_expr();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp395_AST = null;
			tmp395_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp395_AST);
			match(RPAREN);
			aggregate_expr_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_11.member(LA(1))) && (_tokenSet_13.member(LA(2))) && (_tokenSet_15.member(LA(3))) && (_tokenSet_16.member(LA(4))) && (_tokenSet_17.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case NULL_EN:
			case REAL_NUM:
			case QUOTED_STRING:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_yyyy:
			case LITERAL_month:
			case LITERAL_mm:
			case LITERAL_m:
			case LITERAL_day:
			case LITERAL_dd:
			case LITERAL_d:
			case LITERAL_quarter:
			case LITERAL_qq:
			case LITERAL_q:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_w:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_y:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hour:
			case LITERAL_hh:
			case 314:
			case 315:
			case LITERAL_minute:
			case LITERAL_mi:
			case LITERAL_n:
			case LITERAL_second:
			case LITERAL_ss:
			case LITERAL_s:
			case LITERAL_millisecond:
			case LITERAL_ms:
			{
				constant();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((_tokenSet_18.member(LA(1)))) {
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
			case 141:
			case TILDE:
			case 263:
			case 264:
			case 265:
			case 266:
			case 267:
			case 268:
			case 269:
			case 270:
			case PLUS:
			case MINUS:
			case DIVIDE:
			case MOD:
			case AMPERSAND:
			case BITWISEOR:
			case BITWISEXOR:
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
			case ORDER_EN:
			case ORDER_BY_CN:
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
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = aggregate_expr_AST;
	}
	
	public final void order_expression() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST order_expression_AST = null;
		
		{
		if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_19.member(LA(2)))) {
			alias();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==ID) && (LA(2)==POINT)) {
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_20.member(LA(1)))) {
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_18.member(LA(1)))) {
			function();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		}
		{
		switch ( LA(1)) {
		case ASC_EN:
		{
			AST tmp396_AST = null;
			tmp396_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp396_AST);
			match(ASC_EN);
			break;
		}
		case ASC_CN:
		{
			AST tmp397_AST = null;
			tmp397_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp397_AST);
			match(ASC_CN);
			break;
		}
		case DESC_EN:
		{
			AST tmp398_AST = null;
			tmp398_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp398_AST);
			match(DESC_EN);
			break;
		}
		case DESC_CN:
		{
			AST tmp399_AST = null;
			tmp399_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp399_AST);
			match(DESC_CN);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_0.member(LA(2))) && (_tokenSet_21.member(LA(3))) && (_tokenSet_22.member(LA(4))) && (_tokenSet_23.member(LA(5)))) {
			AST tmp400_AST = null;
			tmp400_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp400_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp401_AST = null;
			tmp401_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp401_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case 141:
			case TILDE:
			case 263:
			case 264:
			case 265:
			case 266:
			case 267:
			case 268:
			case 269:
			case 270:
			case PLUS:
			case MINUS:
			case DIVIDE:
			case MOD:
			case AMPERSAND:
			case BITWISEOR:
			case BITWISEXOR:
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
			case WHERE_EN:
			case WHERE_CN:
			case FROM_EN:
			case FROM_CN:
			case GROUP_EN:
			case GROUP_BY_CN:
			case ORDER_EN:
			case ORDER_BY_CN:
			case RPAREN:
			case AS_EN:
			case AS_CN:
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
		else if ((LA(1)==TILDE||LA(1)==263)) {
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
		else if ((_tokenSet_24.member(LA(1))) && (_tokenSet_25.member(LA(2))) && (_tokenSet_26.member(LA(3))) && (_tokenSet_27.member(LA(4))) && (_tokenSet_28.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case NULL_EN:
			case REAL_NUM:
			case QUOTED_STRING:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_yyyy:
			case LITERAL_month:
			case LITERAL_mm:
			case LITERAL_m:
			case LITERAL_day:
			case LITERAL_dd:
			case LITERAL_d:
			case LITERAL_quarter:
			case LITERAL_qq:
			case LITERAL_q:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_w:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_y:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hour:
			case LITERAL_hh:
			case 314:
			case 315:
			case LITERAL_minute:
			case LITERAL_mi:
			case LITERAL_n:
			case LITERAL_second:
			case LITERAL_ss:
			case LITERAL_s:
			case LITERAL_millisecond:
			case LITERAL_ms:
			{
				constant();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COUNT_EN:
			case COUNT_CN:
			case LITERAL_avg:
			case 101:
			case LITERAL_max:
			case 103:
			case LITERAL_min:
			case 105:
			case LITERAL_stddev:
			case 107:
			case LITERAL_sum:
			case 109:
			case LITERAL_variance:
			case 111:
			{
				aggregate_func();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((_tokenSet_18.member(LA(1)))) {
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
			case 141:
			case TILDE:
			case 263:
			case 264:
			case 265:
			case 266:
			case 267:
			case 268:
			case 269:
			case 270:
			case PLUS:
			case MINUS:
			case DIVIDE:
			case MOD:
			case AMPERSAND:
			case BITWISEOR:
			case BITWISEXOR:
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
			case WHERE_EN:
			case WHERE_CN:
			case FROM_EN:
			case FROM_CN:
			case GROUP_EN:
			case GROUP_BY_CN:
			case ORDER_EN:
			case ORDER_BY_CN:
			case RPAREN:
			case AS_EN:
			case AS_CN:
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
		
		returnAST = expression_with_aggr_func_AST;
	}
	
	public final void alias() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_AST = null;
		
		switch ( LA(1)) {
		case ID:
		{
			AST tmp402_AST = null;
			tmp402_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp402_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp403_AST = null;
			tmp403_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp403_AST);
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
		
		AST tmp404_AST = null;
		tmp404_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp404_AST);
		match(ID);
		AST tmp405_AST = null;
		tmp405_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp405_AST);
		match(POINT);
		sfield_name();
		astFactory.addASTChild(currentAST, returnAST);
		field_name_AST = (AST)currentAST.root;
		returnAST = field_name_AST;
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_AST = null;
		
		switch ( LA(1)) {
		case SYSDATE_EN:
		case SYSDATE_CN:
		{
			nothing_function();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_NOTHING,"function_nothing")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cast:
		case 115:
		{
			asdatatype_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			as_data_type_parameter();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_AS_DATA_TYPE,"function_as_data_type")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		default:
			if ((_tokenSet_29.member(LA(1)))) {
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
	
	public final void constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constant_AST = null;
		
		switch ( LA(1)) {
		case REAL_NUM:
		{
			AST tmp410_AST = null;
			tmp410_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp410_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp411_AST = null;
			tmp411_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp411_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp412_AST = null;
			tmp412_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp412_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_year:
		case LITERAL_yy:
		case LITERAL_yyyy:
		case LITERAL_month:
		case LITERAL_mm:
		case LITERAL_m:
		case LITERAL_day:
		case LITERAL_dd:
		case LITERAL_d:
		case LITERAL_quarter:
		case LITERAL_qq:
		case LITERAL_q:
		case LITERAL_week:
		case LITERAL_wk:
		case LITERAL_w:
		case LITERAL_dayofyear:
		case LITERAL_dy:
		case LITERAL_y:
		case LITERAL_weekday:
		case LITERAL_dw:
		case LITERAL_hour:
		case LITERAL_hh:
		case 314:
		case 315:
		case LITERAL_minute:
		case LITERAL_mi:
		case LITERAL_n:
		case LITERAL_second:
		case LITERAL_ss:
		case LITERAL_s:
		case LITERAL_millisecond:
		case LITERAL_ms:
		{
			date_key_word();
			astFactory.addASTChild(currentAST, returnAST);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NULL_EN:
		{
			AST tmp413_AST = null;
			tmp413_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp413_AST);
			match(NULL_EN);
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
	
	public final void two_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST two_arg_op_AST = null;
		
		switch ( LA(1)) {
		case STAR:
		case PLUS:
		case MINUS:
		case DIVIDE:
		case MOD:
		{
			arithmeticOperator();
			astFactory.addASTChild(currentAST, returnAST);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case TILDE:
		case AMPERSAND:
		case BITWISEOR:
		case BITWISEXOR:
		{
			bitwiseOperator();
			astFactory.addASTChild(currentAST, returnAST);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 264:
		{
			AST tmp414_AST = null;
			tmp414_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp414_AST);
			match(264);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 263:
		{
			AST tmp415_AST = null;
			tmp415_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp415_AST);
			match(263);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 265:
		{
			AST tmp416_AST = null;
			tmp416_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp416_AST);
			match(265);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 266:
		{
			AST tmp417_AST = null;
			tmp417_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp417_AST);
			match(266);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 267:
		{
			AST tmp418_AST = null;
			tmp418_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp418_AST);
			match(267);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 268:
		{
			AST tmp419_AST = null;
			tmp419_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp419_AST);
			match(268);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 269:
		{
			AST tmp420_AST = null;
			tmp420_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp420_AST);
			match(269);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 270:
		{
			AST tmp421_AST = null;
			tmp421_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp421_AST);
			match(270);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 141:
		{
			AST tmp422_AST = null;
			tmp422_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp422_AST);
			match(141);
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
		
		if ((LA(1)==COUNT_EN||LA(1)==COUNT_CN) && (LA(2)==LPAREN) && (LA(3)==STAR)) {
			{
			switch ( LA(1)) {
			case COUNT_EN:
			{
				AST tmp423_AST = null;
				tmp423_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp423_AST);
				match(COUNT_EN);
				break;
			}
			case COUNT_CN:
			{
				AST tmp424_AST = null;
				tmp424_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp424_AST);
				match(COUNT_CN);
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
		else if ((_tokenSet_20.member(LA(1))) && (LA(2)==LPAREN) && (_tokenSet_30.member(LA(3)))) {
			aggregate_func_name();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ALL_EN:
			{
				AST tmp429_AST = null;
				tmp429_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp429_AST);
				match(ALL_EN);
				break;
			}
			case ALL_CN:
			{
				AST tmp430_AST = null;
				tmp430_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp430_AST);
				match(ALL_CN);
				break;
			}
			case DISTINCT_EN:
			{
				AST tmp431_AST = null;
				tmp431_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp431_AST);
				match(DISTINCT_EN);
				break;
			}
			case DISTINCT_CN:
			{
				AST tmp432_AST = null;
				tmp432_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp432_AST);
				match(DISTINCT_CN);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_12.member(LA(3))) && (_tokenSet_31.member(LA(4))) && (_tokenSet_32.member(LA(5)))) {
			AST tmp434_AST = null;
			tmp434_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp434_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp435_AST = null;
			tmp435_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp435_AST);
			match(RPAREN);
			{
			if ((_tokenSet_33.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_31.member(LA(3))) && (_tokenSet_32.member(LA(4))) && (_tokenSet_34.member(LA(5)))) {
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
			else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_32.member(LA(2))) && (_tokenSet_34.member(LA(3))) && (_tokenSet_28.member(LA(4))) && (_tokenSet_28.member(LA(5)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==TILDE||LA(1)==263)) {
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
		else if ((_tokenSet_36.member(LA(1))) && (_tokenSet_31.member(LA(2))) && (_tokenSet_32.member(LA(3))) && (_tokenSet_34.member(LA(4))) && (_tokenSet_28.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case NULL_EN:
			case REAL_NUM:
			case QUOTED_STRING:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_year:
			case LITERAL_yy:
			case LITERAL_yyyy:
			case LITERAL_month:
			case LITERAL_mm:
			case LITERAL_m:
			case LITERAL_day:
			case LITERAL_dd:
			case LITERAL_d:
			case LITERAL_quarter:
			case LITERAL_qq:
			case LITERAL_q:
			case LITERAL_week:
			case LITERAL_wk:
			case LITERAL_w:
			case LITERAL_dayofyear:
			case LITERAL_dy:
			case LITERAL_y:
			case LITERAL_weekday:
			case LITERAL_dw:
			case LITERAL_hour:
			case LITERAL_hh:
			case 314:
			case 315:
			case LITERAL_minute:
			case LITERAL_mi:
			case LITERAL_n:
			case LITERAL_second:
			case LITERAL_ss:
			case LITERAL_s:
			case LITERAL_millisecond:
			case LITERAL_ms:
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
				if ((_tokenSet_18.member(LA(1)))) {
					function();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((_tokenSet_33.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_31.member(LA(3))) && (_tokenSet_32.member(LA(4))) && (_tokenSet_34.member(LA(5)))) {
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
			else if ((_tokenSet_35.member(LA(1))) && (_tokenSet_32.member(LA(2))) && (_tokenSet_34.member(LA(3))) && (_tokenSet_28.member(LA(4))) && (_tokenSet_28.member(LA(5)))) {
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
		
		returnAST = expression_AST;
	}
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		switch ( LA(1)) {
		case TILDE:
		{
			AST tmp436_AST = null;
			tmp436_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp436_AST);
			match(TILDE);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 263:
		{
			AST tmp437_AST = null;
			tmp437_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp437_AST);
			match(263);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = one_arg_op_AST;
	}
	
	public final void param_equ() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST param_equ_AST = null;
		
		AST tmp438_AST = null;
		tmp438_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp438_AST);
		match(PARAM_ID);
		param_equ_AST = (AST)currentAST.root;
		returnAST = param_equ_AST;
	}
	
	public final void compare_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compare_op_AST = null;
		
		switch ( LA(1)) {
		case ASSIGNEQUAL:
		case NOTEQUAL1:
		case NOTEQUAL2:
		case LESSTHANOREQUALTO1:
		case LESSTHANOREQUALTO2:
		case LESSTHAN:
		case GREATERTHANOREQUALTO1:
		case GREATERTHANOREQUALTO2:
		case GREATERTHAN:
		{
			comparisonOperator();
			astFactory.addASTChild(currentAST, returnAST);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 68:
		{
			AST tmp439_AST = null;
			tmp439_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp439_AST);
			match(68);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 279:
		{
			AST tmp440_AST = null;
			tmp440_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp440_AST);
			match(279);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 280:
		{
			AST tmp441_AST = null;
			tmp441_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp441_AST);
			match(280);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 281:
		{
			AST tmp442_AST = null;
			tmp442_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp442_AST);
			match(281);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 282:
		{
			AST tmp443_AST = null;
			tmp443_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp443_AST);
			match(282);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 283:
		{
			AST tmp444_AST = null;
			tmp444_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp444_AST);
			match(283);
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
	
	public final void subquery() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST subquery_AST = null;
		
		match(LPAREN);
		select_statement();
		astFactory.addASTChild(currentAST, returnAST);
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
	
	public final void exp_set() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST exp_set_AST = null;
		
		if ((LA(1)==LPAREN) && (_tokenSet_37.member(LA(2)))) {
			match(LPAREN);
			constexpset();
			astFactory.addASTChild(currentAST, returnAST);
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
		}
		else {
			boolean synPredMatched98 = false;
			if (((LA(1)==LPAREN) && (LA(2)==SELECT_EN||LA(2)==SELECT_CN))) {
				int _m98 = mark();
				synPredMatched98 = true;
				inputState.guessing++;
				try {
					{
					subquery();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched98 = false;
				}
				rewind(_m98);
inputState.guessing--;
			}
			if ( synPredMatched98 ) {
				subquery();
				astFactory.addASTChild(currentAST, returnAST);
				exp_set_AST = (AST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			returnAST = exp_set_AST;
		}
		
	public final void nothing_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nothing_function_AST = null;
		
		switch ( LA(1)) {
		case SYSDATE_EN:
		{
			AST tmp449_AST = null;
			tmp449_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp449_AST);
			match(SYSDATE_EN);
			nothing_function_AST = (AST)currentAST.root;
			break;
		}
		case SYSDATE_CN:
		{
			AST tmp450_AST = null;
			tmp450_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp450_AST);
			match(SYSDATE_CN);
			nothing_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = nothing_function_AST;
	}
	
	public final void asdatatype_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asdatatype_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_cast:
		{
			AST tmp451_AST = null;
			tmp451_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp451_AST);
			match(LITERAL_cast);
			asdatatype_function_AST = (AST)currentAST.root;
			break;
		}
		case 115:
		{
			AST tmp452_AST = null;
			tmp452_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp452_AST);
			match(115);
			asdatatype_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = asdatatype_function_AST;
	}
	
	public final void as_data_type_parameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST as_data_type_parameter_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case AS_EN:
		{
			match(AS_EN);
			break;
		}
		case DATA_TYPE_AS_CN:
		{
			match(DATA_TYPE_AS_CN);
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		datatype_constant();
		astFactory.addASTChild(currentAST, returnAST);
		}
		as_data_type_parameter_AST = (AST)currentAST.root;
		returnAST = as_data_type_parameter_AST;
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
		case 117:
		case LITERAL_acos:
		case 119:
		case LITERAL_asin:
		case 121:
		case LITERAL_atan:
		case 123:
		case 124:
		case 125:
		case LITERAL_ceil:
		case 127:
		case LITERAL_cos:
		case 129:
		case LITERAL_cosh:
		case 131:
		case LITERAL_exp:
		case 133:
		case LITERAL_floor:
		case 135:
		case LITERAL_ln:
		case 137:
		case LITERAL_log:
		case 139:
		case LITERAL_mod:
		case 141:
		case LITERAL_power:
		case 143:
		case LITERAL_round:
		case 145:
		case LITERAL_sign:
		case 147:
		case LITERAL_sin:
		case 149:
		case LITERAL_sinh:
		case 151:
		case LITERAL_sqrt:
		case 153:
		case LITERAL_tan:
		case 155:
		case LITERAL_tanh:
		case 157:
		case LITERAL_trunc:
		case 159:
		{
			number_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ascii:
		case 161:
		case LITERAL_asciistr:
		case 163:
		case LITERAL_chr:
		case 165:
		case LITERAL_cancat:
		case 167:
		case LITERAL_initcap:
		case 169:
		case LITERAL_instr:
		case 171:
		case LITERAL_instrb:
		case 173:
		case LITERAL_length:
		case 175:
		case LITERAL_lengthb:
		case 177:
		case LITERAL_lower:
		case 179:
		case LITERAL_ltrim:
		case 181:
		case LITERAL_lpad:
		case 183:
		case LITERAL_nls_initcap:
		case 185:
		case LITERAL_nls_lower:
		case 187:
		case LITERAL_nlssort:
		case 189:
		case LITERAL_nls_upper:
		case 191:
		case LITERAL_replace:
		case 193:
		case LITERAL_rpad:
		case 195:
		case LITERAL_rtrim:
		case 197:
		case LITERAL_soundex:
		case 199:
		case LITERAL_substr:
		case 201:
		case LITERAL_trim:
		case 203:
		case LITERAL_ranslate:
		case 205:
		case LITERAL_upper:
		case 207:
		{
			string_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_add_months:
		case 209:
		case LITERAL_last_day:
		case 211:
		case LITERAL_months_between:
		case 213:
		case LITERAL_new_time:
		case 215:
		case LITERAL_next_day:
		case 217:
		{
			datetime_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bin_to_num:
		case 219:
		case LITERAL_chartorowid:
		case 221:
		case LITERAL_convert:
		case 223:
		case LITERAL_hextoraw:
		case 225:
		case LITERAL_rawtohex:
		case 227:
		case LITERAL_rowidtochar:
		case 229:
		case LITERAL_to_char:
		case 231:
		case LITERAL_to_date:
		case 233:
		case LITERAL_to_multi_byte:
		case 235:
		case LITERAL_to_number:
		case 237:
		case LITERAL_to_single_byte:
		case 239:
		{
			conversion_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_uid:
		case 241:
		case LITERAL_user:
		case 243:
		case LITERAL_userenv:
		case 245:
		case LITERAL_vsize:
		case 247:
		{
			system_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_decode:
		case 249:
		case LITERAL_dump:
		case 251:
		case LITERAL_empty_blob:
		case 253:
		case LITERAL_empty_clob:
		case 255:
		case LITERAL_greatest:
		case 257:
		case LITERAL_least:
		case 259:
		case LITERAL_nvl:
		case 261:
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
		_loop84:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp455_AST = null;
				tmp455_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp455_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop84;
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
		case LITERAL_avg:
		{
			AST tmp456_AST = null;
			tmp456_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp456_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 101:
		{
			AST tmp457_AST = null;
			tmp457_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp457_AST);
			match(101);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_EN:
		{
			AST tmp458_AST = null;
			tmp458_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp458_AST);
			match(COUNT_EN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_CN:
		{
			AST tmp459_AST = null;
			tmp459_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp459_AST);
			match(COUNT_CN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp460_AST = null;
			tmp460_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp460_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 103:
		{
			AST tmp461_AST = null;
			tmp461_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp461_AST);
			match(103);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp462_AST = null;
			tmp462_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp462_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 105:
		{
			AST tmp463_AST = null;
			tmp463_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp463_AST);
			match(105);
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
		case 107:
		{
			AST tmp465_AST = null;
			tmp465_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp465_AST);
			match(107);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sum:
		{
			AST tmp466_AST = null;
			tmp466_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp466_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 109:
		{
			AST tmp467_AST = null;
			tmp467_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp467_AST);
			match(109);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_variance:
		{
			AST tmp468_AST = null;
			tmp468_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp468_AST);
			match(LITERAL_variance);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 111:
		{
			AST tmp469_AST = null;
			tmp469_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp469_AST);
			match(111);
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
	
	public final void datatype_constant() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST datatype_constant_AST = null;
		
		if ((_tokenSet_38.member(LA(1)))) {
			data_type_word();
			astFactory.addASTChild(currentAST, returnAST);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==CHAR) && (LA(2)==COMMA||LA(2)==RPAREN)) {
			AST tmp470_AST = null;
			tmp470_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp470_AST);
			match(CHAR);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==CHAR) && (LA(2)==LPAREN)) {
			AST tmp471_AST = null;
			tmp471_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp471_AST);
			match(CHAR);
			match(LPAREN);
			datatype_precision_or_scale_or_maxlength();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				datatype_constant_AST = (AST)currentAST.root;
				datatype_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PAREN_CHAR_DATA_TYPE,"paren_char_data_type")).add(datatype_constant_AST));
				currentAST.root = datatype_constant_AST;
				currentAST.child = datatype_constant_AST!=null &&datatype_constant_AST.getFirstChild()!=null ?
					datatype_constant_AST.getFirstChild() : datatype_constant_AST;
				currentAST.advanceChildToEnd();
			}
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==DATA_TYPE_STRING) && (LA(2)==LPAREN)) {
			AST tmp474_AST = null;
			tmp474_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp474_AST);
			match(DATA_TYPE_STRING);
			match(LPAREN);
			datatype_precision_or_scale_or_maxlength();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				datatype_constant_AST = (AST)currentAST.root;
				datatype_constant_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PAREN_DATA_TYPE,"paren_data_type")).add(datatype_constant_AST));
				currentAST.root = datatype_constant_AST;
				currentAST.child = datatype_constant_AST!=null &&datatype_constant_AST.getFirstChild()!=null ?
					datatype_constant_AST.getFirstChild() : datatype_constant_AST;
				currentAST.advanceChildToEnd();
			}
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==DATA_TYPE_STRING) && (LA(2)==COMMA||LA(2)==RPAREN)) {
			AST tmp477_AST = null;
			tmp477_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp477_AST);
			match(DATA_TYPE_STRING);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = datatype_constant_AST;
	}
	
	public final void data_type_parameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST data_type_parameter_AST = null;
		
		datatype_constant();
		astFactory.addASTChild(currentAST, returnAST);
		{
		int _cnt90=0;
		_loop90:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp478_AST = null;
				tmp478_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp478_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt90>=1 ) { break _loop90; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt90++;
		} while (true);
		}
		data_type_parameter_AST = (AST)currentAST.root;
		returnAST = data_type_parameter_AST;
	}
	
	public final void data_type_word() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST data_type_word_AST = null;
		
		switch ( LA(1)) {
		case COMMA:
		case RPAREN:
		{
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_long:
		{
			AST tmp479_AST = null;
			tmp479_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp479_AST);
			match(LITERAL_long);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp480_AST = null;
			tmp480_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp480_AST);
			match(LITERAL_date);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rowid:
		{
			AST tmp481_AST = null;
			tmp481_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp481_AST);
			match(LITERAL_rowid);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_clob:
		{
			AST tmp482_AST = null;
			tmp482_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp482_AST);
			match(LITERAL_clob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nclob:
		{
			AST tmp483_AST = null;
			tmp483_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp483_AST);
			match(LITERAL_nclob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_blob:
		{
			AST tmp484_AST = null;
			tmp484_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp484_AST);
			match(LITERAL_blob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bfile:
		{
			AST tmp485_AST = null;
			tmp485_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp485_AST);
			match(LITERAL_bfile);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = data_type_word_AST;
	}
	
	public final void datatype_precision_or_scale_or_maxlength() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST datatype_precision_or_scale_or_maxlength_AST = null;
		
		if ((LA(1)==REAL_NUM) && (LA(2)==COMMA)) {
			AST tmp486_AST = null;
			tmp486_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp486_AST);
			match(REAL_NUM);
			AST tmp487_AST = null;
			tmp487_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp487_AST);
			match(COMMA);
			AST tmp488_AST = null;
			tmp488_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp488_AST);
			match(REAL_NUM);
			datatype_precision_or_scale_or_maxlength_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==REAL_NUM) && (LA(2)==RPAREN)) {
			AST tmp489_AST = null;
			tmp489_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp489_AST);
			match(REAL_NUM);
			datatype_precision_or_scale_or_maxlength_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = datatype_precision_or_scale_or_maxlength_AST;
	}
	
	public final void constexpset() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST constexpset_AST = null;
		
		constant();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop101:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp490_AST = null;
				tmp490_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp490_AST);
				match(COMMA);
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop101;
			}
			
		} while (true);
		}
		constexpset_AST = (AST)currentAST.root;
		returnAST = constexpset_AST;
	}
	
	public final void sfield_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST sfield_name_AST = null;
		
		if ((LA(1)==ID) && (LA(2)==LPAREN) && (LA(3)==ID) && (LA(4)==RPAREN) && (_tokenSet_39.member(LA(5)))) {
			AST tmp491_AST = null;
			tmp491_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp491_AST);
			match(ID);
			match(LPAREN);
			AST tmp493_AST = null;
			tmp493_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp493_AST);
			match(ID);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				sfield_name_AST = (AST)currentAST.root;
				sfield_name_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(PAREN_FIELD,"paren_field")).add(sfield_name_AST));
				currentAST.root = sfield_name_AST;
				currentAST.child = sfield_name_AST!=null &&sfield_name_AST.getFirstChild()!=null ?
					sfield_name_AST.getFirstChild() : sfield_name_AST;
				currentAST.advanceChildToEnd();
			}
			sfield_name_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==ID) && (_tokenSet_39.member(LA(2))) && (_tokenSet_40.member(LA(3))) && (_tokenSet_41.member(LA(4))) && (_tokenSet_28.member(LA(5)))) {
			AST tmp495_AST = null;
			tmp495_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp495_AST);
			match(ID);
			sfield_name_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = sfield_name_AST;
	}
	
	public final void date_key_word() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST date_key_word_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_year:
		{
			AST tmp496_AST = null;
			tmp496_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp496_AST);
			match(LITERAL_year);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yy:
		{
			AST tmp497_AST = null;
			tmp497_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp497_AST);
			match(LITERAL_yy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yyyy:
		{
			AST tmp498_AST = null;
			tmp498_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp498_AST);
			match(LITERAL_yyyy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp499_AST = null;
			tmp499_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp499_AST);
			match(LITERAL_month);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mm:
		{
			AST tmp500_AST = null;
			tmp500_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp500_AST);
			match(LITERAL_mm);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_m:
		{
			AST tmp501_AST = null;
			tmp501_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp501_AST);
			match(LITERAL_m);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp502_AST = null;
			tmp502_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp502_AST);
			match(LITERAL_day);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dd:
		{
			AST tmp503_AST = null;
			tmp503_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp503_AST);
			match(LITERAL_dd);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_d:
		{
			AST tmp504_AST = null;
			tmp504_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp504_AST);
			match(LITERAL_d);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp505_AST = null;
			tmp505_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp505_AST);
			match(LITERAL_quarter);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_qq:
		{
			AST tmp506_AST = null;
			tmp506_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp506_AST);
			match(LITERAL_qq);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_q:
		{
			AST tmp507_AST = null;
			tmp507_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp507_AST);
			match(LITERAL_q);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp508_AST = null;
			tmp508_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp508_AST);
			match(LITERAL_week);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_wk:
		{
			AST tmp509_AST = null;
			tmp509_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp509_AST);
			match(LITERAL_wk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_w:
		{
			AST tmp510_AST = null;
			tmp510_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp510_AST);
			match(LITERAL_w);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayofyear:
		{
			AST tmp511_AST = null;
			tmp511_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp511_AST);
			match(LITERAL_dayofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dy:
		{
			AST tmp512_AST = null;
			tmp512_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp512_AST);
			match(LITERAL_dy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_y:
		{
			AST tmp513_AST = null;
			tmp513_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp513_AST);
			match(LITERAL_y);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weekday:
		{
			AST tmp514_AST = null;
			tmp514_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp514_AST);
			match(LITERAL_weekday);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dw:
		{
			AST tmp515_AST = null;
			tmp515_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp515_AST);
			match(LITERAL_dw);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp516_AST = null;
			tmp516_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp516_AST);
			match(LITERAL_hour);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hh:
		{
			AST tmp517_AST = null;
			tmp517_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp517_AST);
			match(LITERAL_hh);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case 314:
		{
			AST tmp518_AST = null;
			tmp518_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp518_AST);
			match(314);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case 315:
		{
			AST tmp519_AST = null;
			tmp519_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp519_AST);
			match(315);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp520_AST = null;
			tmp520_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp520_AST);
			match(LITERAL_minute);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mi:
		{
			AST tmp521_AST = null;
			tmp521_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp521_AST);
			match(LITERAL_mi);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_n:
		{
			AST tmp522_AST = null;
			tmp522_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp522_AST);
			match(LITERAL_n);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp523_AST = null;
			tmp523_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp523_AST);
			match(LITERAL_second);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ss:
		{
			AST tmp524_AST = null;
			tmp524_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp524_AST);
			match(LITERAL_ss);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_s:
		{
			AST tmp525_AST = null;
			tmp525_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp525_AST);
			match(LITERAL_s);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_millisecond:
		{
			AST tmp526_AST = null;
			tmp526_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp526_AST);
			match(LITERAL_millisecond);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ms:
		{
			AST tmp527_AST = null;
			tmp527_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp527_AST);
			match(LITERAL_ms);
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
	
	public final void number_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_abs:
		{
			AST tmp528_AST = null;
			tmp528_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp528_AST);
			match(LITERAL_abs);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 117:
		{
			AST tmp529_AST = null;
			tmp529_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp529_AST);
			match(117);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_acos:
		{
			AST tmp530_AST = null;
			tmp530_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp530_AST);
			match(LITERAL_acos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 119:
		{
			AST tmp531_AST = null;
			tmp531_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp531_AST);
			match(119);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asin:
		{
			AST tmp532_AST = null;
			tmp532_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp532_AST);
			match(LITERAL_asin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 121:
		{
			AST tmp533_AST = null;
			tmp533_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp533_AST);
			match(121);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_atan:
		{
			AST tmp534_AST = null;
			tmp534_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp534_AST);
			match(LITERAL_atan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 123:
		{
			AST tmp535_AST = null;
			tmp535_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp535_AST);
			match(123);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 124:
		{
			AST tmp536_AST = null;
			tmp536_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp536_AST);
			match(124);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 125:
		{
			AST tmp537_AST = null;
			tmp537_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp537_AST);
			match(125);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceil:
		{
			AST tmp538_AST = null;
			tmp538_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp538_AST);
			match(LITERAL_ceil);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 127:
		{
			AST tmp539_AST = null;
			tmp539_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp539_AST);
			match(127);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cos:
		{
			AST tmp540_AST = null;
			tmp540_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp540_AST);
			match(LITERAL_cos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp541_AST = null;
			tmp541_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp541_AST);
			match(129);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cosh:
		{
			AST tmp542_AST = null;
			tmp542_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp542_AST);
			match(LITERAL_cosh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 131:
		{
			AST tmp543_AST = null;
			tmp543_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp543_AST);
			match(131);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exp:
		{
			AST tmp544_AST = null;
			tmp544_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp544_AST);
			match(LITERAL_exp);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 133:
		{
			AST tmp545_AST = null;
			tmp545_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp545_AST);
			match(133);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp546_AST = null;
			tmp546_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp546_AST);
			match(LITERAL_floor);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 135:
		{
			AST tmp547_AST = null;
			tmp547_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp547_AST);
			match(135);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ln:
		{
			AST tmp548_AST = null;
			tmp548_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp548_AST);
			match(LITERAL_ln);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 137:
		{
			AST tmp549_AST = null;
			tmp549_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp549_AST);
			match(137);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_log:
		{
			AST tmp550_AST = null;
			tmp550_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp550_AST);
			match(LITERAL_log);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 139:
		{
			AST tmp551_AST = null;
			tmp551_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp551_AST);
			match(139);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp552_AST = null;
			tmp552_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp552_AST);
			match(LITERAL_mod);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 141:
		{
			AST tmp553_AST = null;
			tmp553_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp553_AST);
			match(141);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_power:
		{
			AST tmp554_AST = null;
			tmp554_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp554_AST);
			match(LITERAL_power);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 143:
		{
			AST tmp555_AST = null;
			tmp555_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp555_AST);
			match(143);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp556_AST = null;
			tmp556_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp556_AST);
			match(LITERAL_round);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 145:
		{
			AST tmp557_AST = null;
			tmp557_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp557_AST);
			match(145);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sign:
		{
			AST tmp558_AST = null;
			tmp558_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp558_AST);
			match(LITERAL_sign);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 147:
		{
			AST tmp559_AST = null;
			tmp559_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp559_AST);
			match(147);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sin:
		{
			AST tmp560_AST = null;
			tmp560_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp560_AST);
			match(LITERAL_sin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 149:
		{
			AST tmp561_AST = null;
			tmp561_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp561_AST);
			match(149);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sinh:
		{
			AST tmp562_AST = null;
			tmp562_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp562_AST);
			match(LITERAL_sinh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 151:
		{
			AST tmp563_AST = null;
			tmp563_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp563_AST);
			match(151);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sqrt:
		{
			AST tmp564_AST = null;
			tmp564_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp564_AST);
			match(LITERAL_sqrt);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 153:
		{
			AST tmp565_AST = null;
			tmp565_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp565_AST);
			match(153);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tan:
		{
			AST tmp566_AST = null;
			tmp566_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp566_AST);
			match(LITERAL_tan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 155:
		{
			AST tmp567_AST = null;
			tmp567_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp567_AST);
			match(155);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tanh:
		{
			AST tmp568_AST = null;
			tmp568_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp568_AST);
			match(LITERAL_tanh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 157:
		{
			AST tmp569_AST = null;
			tmp569_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp569_AST);
			match(157);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trunc:
		{
			AST tmp570_AST = null;
			tmp570_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp570_AST);
			match(LITERAL_trunc);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 159:
		{
			AST tmp571_AST = null;
			tmp571_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp571_AST);
			match(159);
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
			AST tmp572_AST = null;
			tmp572_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp572_AST);
			match(LITERAL_ascii);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 161:
		{
			AST tmp573_AST = null;
			tmp573_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp573_AST);
			match(161);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asciistr:
		{
			AST tmp574_AST = null;
			tmp574_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp574_AST);
			match(LITERAL_asciistr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 163:
		{
			AST tmp575_AST = null;
			tmp575_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp575_AST);
			match(163);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_chr:
		{
			AST tmp576_AST = null;
			tmp576_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp576_AST);
			match(LITERAL_chr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 165:
		{
			AST tmp577_AST = null;
			tmp577_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp577_AST);
			match(165);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cancat:
		{
			AST tmp578_AST = null;
			tmp578_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp578_AST);
			match(LITERAL_cancat);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 167:
		{
			AST tmp579_AST = null;
			tmp579_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp579_AST);
			match(167);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_initcap:
		{
			AST tmp580_AST = null;
			tmp580_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp580_AST);
			match(LITERAL_initcap);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 169:
		{
			AST tmp581_AST = null;
			tmp581_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp581_AST);
			match(169);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_instr:
		{
			AST tmp582_AST = null;
			tmp582_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp582_AST);
			match(LITERAL_instr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 171:
		{
			AST tmp583_AST = null;
			tmp583_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp583_AST);
			match(171);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_instrb:
		{
			AST tmp584_AST = null;
			tmp584_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp584_AST);
			match(LITERAL_instrb);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 173:
		{
			AST tmp585_AST = null;
			tmp585_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp585_AST);
			match(173);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_length:
		{
			AST tmp586_AST = null;
			tmp586_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp586_AST);
			match(LITERAL_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 175:
		{
			AST tmp587_AST = null;
			tmp587_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp587_AST);
			match(175);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lengthb:
		{
			AST tmp588_AST = null;
			tmp588_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp588_AST);
			match(LITERAL_lengthb);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 177:
		{
			AST tmp589_AST = null;
			tmp589_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp589_AST);
			match(177);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp590_AST = null;
			tmp590_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp590_AST);
			match(LITERAL_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 179:
		{
			AST tmp591_AST = null;
			tmp591_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp591_AST);
			match(179);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp592_AST = null;
			tmp592_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp592_AST);
			match(LITERAL_ltrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 181:
		{
			AST tmp593_AST = null;
			tmp593_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp593_AST);
			match(181);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lpad:
		{
			AST tmp594_AST = null;
			tmp594_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp594_AST);
			match(LITERAL_lpad);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 183:
		{
			AST tmp595_AST = null;
			tmp595_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp595_AST);
			match(183);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_initcap:
		{
			AST tmp596_AST = null;
			tmp596_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp596_AST);
			match(LITERAL_nls_initcap);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 185:
		{
			AST tmp597_AST = null;
			tmp597_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp597_AST);
			match(185);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_lower:
		{
			AST tmp598_AST = null;
			tmp598_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp598_AST);
			match(LITERAL_nls_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 187:
		{
			AST tmp599_AST = null;
			tmp599_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp599_AST);
			match(187);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nlssort:
		{
			AST tmp600_AST = null;
			tmp600_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp600_AST);
			match(LITERAL_nlssort);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 189:
		{
			AST tmp601_AST = null;
			tmp601_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp601_AST);
			match(189);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_upper:
		{
			AST tmp602_AST = null;
			tmp602_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp602_AST);
			match(LITERAL_nls_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 191:
		{
			AST tmp603_AST = null;
			tmp603_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp603_AST);
			match(191);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replace:
		{
			AST tmp604_AST = null;
			tmp604_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp604_AST);
			match(LITERAL_replace);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 193:
		{
			AST tmp605_AST = null;
			tmp605_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp605_AST);
			match(193);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rpad:
		{
			AST tmp606_AST = null;
			tmp606_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp606_AST);
			match(LITERAL_rpad);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 195:
		{
			AST tmp607_AST = null;
			tmp607_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp607_AST);
			match(195);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp608_AST = null;
			tmp608_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp608_AST);
			match(LITERAL_rtrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 197:
		{
			AST tmp609_AST = null;
			tmp609_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp609_AST);
			match(197);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_soundex:
		{
			AST tmp610_AST = null;
			tmp610_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp610_AST);
			match(LITERAL_soundex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 199:
		{
			AST tmp611_AST = null;
			tmp611_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp611_AST);
			match(199);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substr:
		{
			AST tmp612_AST = null;
			tmp612_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp612_AST);
			match(LITERAL_substr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 201:
		{
			AST tmp613_AST = null;
			tmp613_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp613_AST);
			match(201);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trim:
		{
			AST tmp614_AST = null;
			tmp614_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp614_AST);
			match(LITERAL_trim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 203:
		{
			AST tmp615_AST = null;
			tmp615_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp615_AST);
			match(203);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ranslate:
		{
			AST tmp616_AST = null;
			tmp616_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp616_AST);
			match(LITERAL_ranslate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 205:
		{
			AST tmp617_AST = null;
			tmp617_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp617_AST);
			match(205);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_upper:
		{
			AST tmp618_AST = null;
			tmp618_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp618_AST);
			match(LITERAL_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 207:
		{
			AST tmp619_AST = null;
			tmp619_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp619_AST);
			match(207);
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
		case LITERAL_add_months:
		{
			AST tmp620_AST = null;
			tmp620_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp620_AST);
			match(LITERAL_add_months);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 209:
		{
			AST tmp621_AST = null;
			tmp621_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp621_AST);
			match(209);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_last_day:
		{
			AST tmp622_AST = null;
			tmp622_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp622_AST);
			match(LITERAL_last_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 211:
		{
			AST tmp623_AST = null;
			tmp623_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp623_AST);
			match(211);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_months_between:
		{
			AST tmp624_AST = null;
			tmp624_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp624_AST);
			match(LITERAL_months_between);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 213:
		{
			AST tmp625_AST = null;
			tmp625_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp625_AST);
			match(213);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_new_time:
		{
			AST tmp626_AST = null;
			tmp626_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp626_AST);
			match(LITERAL_new_time);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 215:
		{
			AST tmp627_AST = null;
			tmp627_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp627_AST);
			match(215);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_next_day:
		{
			AST tmp628_AST = null;
			tmp628_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp628_AST);
			match(LITERAL_next_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 217:
		{
			AST tmp629_AST = null;
			tmp629_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp629_AST);
			match(217);
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
		case LITERAL_bin_to_num:
		{
			AST tmp630_AST = null;
			tmp630_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp630_AST);
			match(LITERAL_bin_to_num);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 219:
		{
			AST tmp631_AST = null;
			tmp631_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp631_AST);
			match(219);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_chartorowid:
		{
			AST tmp632_AST = null;
			tmp632_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp632_AST);
			match(LITERAL_chartorowid);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 221:
		{
			AST tmp633_AST = null;
			tmp633_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp633_AST);
			match(221);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_convert:
		{
			AST tmp634_AST = null;
			tmp634_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp634_AST);
			match(LITERAL_convert);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 223:
		{
			AST tmp635_AST = null;
			tmp635_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp635_AST);
			match(223);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hextoraw:
		{
			AST tmp636_AST = null;
			tmp636_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp636_AST);
			match(LITERAL_hextoraw);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 225:
		{
			AST tmp637_AST = null;
			tmp637_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp637_AST);
			match(225);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rawtohex:
		{
			AST tmp638_AST = null;
			tmp638_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp638_AST);
			match(LITERAL_rawtohex);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 227:
		{
			AST tmp639_AST = null;
			tmp639_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp639_AST);
			match(227);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rowidtochar:
		{
			AST tmp640_AST = null;
			tmp640_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp640_AST);
			match(LITERAL_rowidtochar);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 229:
		{
			AST tmp641_AST = null;
			tmp641_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp641_AST);
			match(229);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_char:
		{
			AST tmp642_AST = null;
			tmp642_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp642_AST);
			match(LITERAL_to_char);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 231:
		{
			AST tmp643_AST = null;
			tmp643_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp643_AST);
			match(231);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_date:
		{
			AST tmp644_AST = null;
			tmp644_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp644_AST);
			match(LITERAL_to_date);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 233:
		{
			AST tmp645_AST = null;
			tmp645_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp645_AST);
			match(233);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_multi_byte:
		{
			AST tmp646_AST = null;
			tmp646_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp646_AST);
			match(LITERAL_to_multi_byte);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 235:
		{
			AST tmp647_AST = null;
			tmp647_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp647_AST);
			match(235);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_number:
		{
			AST tmp648_AST = null;
			tmp648_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp648_AST);
			match(LITERAL_to_number);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 237:
		{
			AST tmp649_AST = null;
			tmp649_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp649_AST);
			match(237);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_single_byte:
		{
			AST tmp650_AST = null;
			tmp650_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp650_AST);
			match(LITERAL_to_single_byte);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 239:
		{
			AST tmp651_AST = null;
			tmp651_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp651_AST);
			match(239);
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
		case LITERAL_uid:
		{
			AST tmp652_AST = null;
			tmp652_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp652_AST);
			match(LITERAL_uid);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 241:
		{
			AST tmp653_AST = null;
			tmp653_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp653_AST);
			match(241);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user:
		{
			AST tmp654_AST = null;
			tmp654_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp654_AST);
			match(LITERAL_user);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 243:
		{
			AST tmp655_AST = null;
			tmp655_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp655_AST);
			match(243);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_userenv:
		{
			AST tmp656_AST = null;
			tmp656_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp656_AST);
			match(LITERAL_userenv);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 245:
		{
			AST tmp657_AST = null;
			tmp657_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp657_AST);
			match(245);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_vsize:
		{
			AST tmp658_AST = null;
			tmp658_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp658_AST);
			match(LITERAL_vsize);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 247:
		{
			AST tmp659_AST = null;
			tmp659_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp659_AST);
			match(247);
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
			AST tmp660_AST = null;
			tmp660_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp660_AST);
			match(LITERAL_decode);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 249:
		{
			AST tmp661_AST = null;
			tmp661_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp661_AST);
			match(249);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dump:
		{
			AST tmp662_AST = null;
			tmp662_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp662_AST);
			match(LITERAL_dump);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 251:
		{
			AST tmp663_AST = null;
			tmp663_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp663_AST);
			match(251);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_empty_blob:
		{
			AST tmp664_AST = null;
			tmp664_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp664_AST);
			match(LITERAL_empty_blob);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 253:
		{
			AST tmp665_AST = null;
			tmp665_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp665_AST);
			match(253);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_empty_clob:
		{
			AST tmp666_AST = null;
			tmp666_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp666_AST);
			match(LITERAL_empty_clob);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 255:
		{
			AST tmp667_AST = null;
			tmp667_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp667_AST);
			match(255);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_greatest:
		{
			AST tmp668_AST = null;
			tmp668_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp668_AST);
			match(LITERAL_greatest);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 257:
		{
			AST tmp669_AST = null;
			tmp669_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp669_AST);
			match(257);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_least:
		{
			AST tmp670_AST = null;
			tmp670_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp670_AST);
			match(LITERAL_least);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 259:
		{
			AST tmp671_AST = null;
			tmp671_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp671_AST);
			match(259);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nvl:
		{
			AST tmp672_AST = null;
			tmp672_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp672_AST);
			match(LITERAL_nvl);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 261:
		{
			AST tmp673_AST = null;
			tmp673_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp673_AST);
			match(261);
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
	
	public final void arithmeticOperator() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arithmeticOperator_AST = null;
		
		switch ( LA(1)) {
		case PLUS:
		{
			AST tmp674_AST = null;
			tmp674_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp674_AST);
			match(PLUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp675_AST = null;
			tmp675_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp675_AST);
			match(MINUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp676_AST = null;
			tmp676_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp676_AST);
			match(STAR);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case DIVIDE:
		{
			AST tmp677_AST = null;
			tmp677_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp677_AST);
			match(DIVIDE);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MOD:
		{
			AST tmp678_AST = null;
			tmp678_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp678_AST);
			match(MOD);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = arithmeticOperator_AST;
	}
	
	public final void bitwiseOperator() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bitwiseOperator_AST = null;
		
		switch ( LA(1)) {
		case AMPERSAND:
		{
			AST tmp679_AST = null;
			tmp679_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp679_AST);
			match(AMPERSAND);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case TILDE:
		{
			AST tmp680_AST = null;
			tmp680_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp680_AST);
			match(TILDE);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEOR:
		{
			AST tmp681_AST = null;
			tmp681_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp681_AST);
			match(BITWISEOR);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEXOR:
		{
			AST tmp682_AST = null;
			tmp682_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp682_AST);
			match(BITWISEXOR);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = bitwiseOperator_AST;
	}
	
	public final void alias_equ_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST alias_equ_op_AST = null;
		
		switch ( LA(1)) {
		case ASSIGNEQUAL:
		{
			AST tmp683_AST = null;
			tmp683_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp683_AST);
			match(ASSIGNEQUAL);
			alias_equ_op_AST = (AST)currentAST.root;
			break;
		}
		case 68:
		{
			AST tmp684_AST = null;
			tmp684_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp684_AST);
			match(68);
			alias_equ_op_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = alias_equ_op_AST;
	}
	
	public final void comparisonOperator() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST comparisonOperator_AST = null;
		
		switch ( LA(1)) {
		case ASSIGNEQUAL:
		{
			AST tmp685_AST = null;
			tmp685_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp685_AST);
			match(ASSIGNEQUAL);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL1:
		{
			AST tmp686_AST = null;
			tmp686_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp686_AST);
			match(NOTEQUAL1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL2:
		{
			AST tmp687_AST = null;
			tmp687_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp687_AST);
			match(NOTEQUAL2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO1:
		{
			AST tmp688_AST = null;
			tmp688_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp688_AST);
			match(LESSTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO2:
		{
			AST tmp689_AST = null;
			tmp689_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp689_AST);
			match(LESSTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHAN:
		{
			AST tmp690_AST = null;
			tmp690_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp690_AST);
			match(LESSTHAN);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO1:
		{
			AST tmp691_AST = null;
			tmp691_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp691_AST);
			match(GREATERTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO2:
		{
			AST tmp692_AST = null;
			tmp692_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp692_AST);
			match(GREATERTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHAN:
		{
			AST tmp693_AST = null;
			tmp693_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp693_AST);
			match(GREATERTHAN);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = comparisonOperator_AST;
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
		"FUNCTION_NOTHING",
		"FUNCTION_EMPTY_PARAM",
		"FUNCTION_STAR_PARAM",
		"FUNCTION_STAR_COUNT",
		"FUNCTION_DATA_TYPE",
		"FUNCTION_AS_DATA_TYPE",
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
		"PAREN_FIELD",
		"PAREN_DATA_TYPE",
		"PAREN_CHAR_DATA_TYPE",
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
		"\"exists\"",
		"\"\\u5b58\\u5728\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"not\"",
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
		"\"asc\"",
		"\"\\u5347\\u5e8f\"",
		"\"desc\"",
		"\"\\u964d\\u5e8f\"",
		"\"like\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"is\"",
		"\"null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"\\u8303\\u56f4\"",
		"\"between\"",
		"\"in\"",
		"\"\\u5728\\u4e8e\"",
		"\"\\u4e0d\\u5728\\u4e8e\"",
		"\"count\"",
		"\"\\u6c42\\u8bb0\\u5f55\\u603b\\u6570\"",
		"\"all\"",
		"\"\\u5168\\u90e8\"",
		"\"\\u4e3a\"",
		"\"char\"",
		"DATA_TYPE_STRING",
		"REAL_NUM",
		"ID",
		"PARAM_ID",
		"QUOTED_STRING",
		"POINT",
		"NEGATIVE_DIGIT_ELEMENT",
		"\"avg\"",
		"\"\\u6c42\\u5e73\\u5747\\u6570\"",
		"\"max\"",
		"\"\\u6c42\\u6700\\u5927\\u503c\"",
		"\"min\"",
		"\"\\u6c42\\u6700\\u5c0f\\u503c\"",
		"\"stddev\"",
		"\"\\u6c42\\u6807\\u51c6\\u5dee\"",
		"\"sum\"",
		"\"\\u6c42\\u603b\\u548c\"",
		"\"variance\"",
		"\"\\u6c42\\u534f\\u65b9\\u5dee\"",
		"\"SYSDATE\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"cast\"",
		"\"\\u6570\\u636e\\u7c7b\\u578b\\u8f6c\\u5316\"",
		"\"abs\"",
		"\"\\u53d6\\u7edd\\u5bf9\\u503c\"",
		"\"acos\"",
		"\"\\u6c42\\u53cd\\u4f59\\u5f26\\u503c\"",
		"\"asin\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5f26\\u503c\"",
		"\"atan\"",
		"\"\\u6c42\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"atin2\"",
		"\"\\u6c42\\u4e8c\\u4e2a\\u6570\\u7684\\u53cd\\u6b63\\u5207\\u503c\"",
		"\"ceil\"",
		"\"\\u53d6\\u4e0a\\u9650\\u6574\\u6570\"",
		"\"cos\"",
		"\"\\u6c42\\u4f59\\u5f26\\u503c\"",
		"\"cosh\"",
		"\"\\u6c42\\u4f59\\u5207\\u503c\"",
		"\"exp\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"floor\"",
		"\"\\u53d6\\u4e0b\\u9650\\u6574\\u6570\"",
		"\"ln\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log\"",
		"\"\\u6c42\\u5bf9\\u6570\"",
		"\"mod\"",
		"\"\\u6c42\\u6a21\"",
		"\"power\"",
		"\"\\u6c42\\u5e42\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"sign\"",
		"\"\\u6c42\\u503c\\u7684\\u7b26\\u53f7\"",
		"\"sin\"",
		"\"\\u6c42\\u6b63\\u5f26\\u503c\"",
		"\"sinh\"",
		"\"\\u6c42\\u53cc\\u66f2\\u6b63\\u5f26\\u503c\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"tan\"",
		"\"\\u6c42\\u6b63\\u5207\\u503c\"",
		"\"tanh\"",
		"\"\\u6c42\\u53cc\\u66f2\\u6b63\\u5207\\u503c\"",
		"\"trunc\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c2\"",
		"\"ascii\"",
		"\"\\u6c42ASCII\\u7801\"",
		"\"asciistr\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32ASCII\\u7801\"",
		"\"chr\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"cancat\"",
		"\"\\u5b57\\u7b26\\u4e32\\u8fde\\u63a5\"",
		"\"initcap\"",
		"\"\\u5355\\u8bcd\\u9996\\u5b57\\u6bcd\\u5927\\u51991\"",
		"\"instr\"",
		"\"\\u6c42\\u4e32\\u4f4d\\u7f6e\"",
		"\"instrb\"",
		"\"\\u5b57\\u8282\\u65b9\\u5f0f\\u6c42\\u4e32\\u4f4d\\u7f6e\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u957f\\u5ea6\"",
		"\"lengthb\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u5b57\\u8282\\u6570\"",
		"\"lower\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd1\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"lpad\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5de6\\u8865\"",
		"\"nls_initcap\"",
		"\"\\u5355\\u8bcd\\u9996\\u5b57\\u6bcd\\u5927\\u51992\"",
		"\"nls_lower\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd2\"",
		"\"nlssort\"",
		"\"\\u5b57\\u7b26\\u4e32\\u6392\\u5e8f\"",
		"\"nls_upper\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd2\"",
		"\"replace\"",
		"\"\\u5b57\\u7b26\\u4e32\\u66ff\\u6362\"",
		"\"rpad\"",
		"\"\\u5b57\\u7b26\\u4e32\\u53f3\\u8865\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"soundex\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u58f0\\u97f3\\u503c\"",
		"\"substr\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"trim\"",
		"\"\\u53bb\\u5de6\\u53f3\\u7a7a\\u683c\"",
		"\"ranslate\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5168\\u66ff\\u6362\"",
		"\"upper\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd1\"",
		"\"add_months\"",
		"\"\\u6708\\u4efd\\u8fd0\\u7b97\"",
		"\"last_day\"",
		"\"\\u6c42\\u65e5\\u671f\\u6700\\u540e\\u4e00\\u5929\"",
		"\"months_between\"",
		"\"\\u6c42\\u6708\\u4efd\\u5dee\\u503c\"",
		"\"new_time\"",
		"\"\\u6c42\\u5bf9\\u5e94\\u65f6\\u533a\\u7684\\u65f6\\u95f4\"",
		"\"next_day\"",
		"\"\\u6c42\\u5177\\u4f53\\u661f\\u671f\\u7684\\u65e5\\u671f\"",
		"\"bin_to_num\"",
		"\"\\u4e8c\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6570\\u503c\"",
		"\"chartorowid\"",
		"\"\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u884c\\u53f7\"",
		"\"convert\"",
		"\"\\u5b57\\u7b26\\u4e32\\u8f6c\\u5316\"",
		"\"hextoraw\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u4e8c\\u8fdb\\u5236\"",
		"\"rawtohex\"",
		"\"\\u4e8c\\u8fdb\\u5236\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"rowidtochar\"",
		"\"\\u884c\\u53f7\\u8f6c\\u6210\\u5b57\\u7b26\\u4e32\"",
		"\"to_char\"",
		"\"\\u8f6c\\u4e3a\\u5b57\\u7b26\\u578b\"",
		"\"to_date\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\\u578b\"",
		"\"to_multi_byte\"",
		"\"\\u8f6c\\u4e3a\\u591a\\u5b57\\u8282\\u578b\"",
		"\"to_number\"",
		"\"\\u8f6c\\u4e3a\\u6570\\u503c\\u578b\"",
		"\"to_single_byte\"",
		"\"\\u8f6c\\u4e3a\\u5355\\u5b57\\u8282\\u578b\"",
		"\"uid\"",
		"\"\\u6c42\\u6807\\u8bc6\\u7f16\\u53f7\"",
		"\"user\"",
		"\"\\u6c42\\u5f53\\u524d\\u7528\\u6237\"",
		"\"userenv\"",
		"\"\\u6c42\\u5f53\\u524d\\u7528\\u6237\\u73af\\u5883\\u4fe1\\u606f\"",
		"\"vsize\"",
		"\"\\u6c42\\u5b57\\u6bb5\\u5927\\u5c0f\"",
		"\"decode\"",
		"\"\\u6c42\\u6bd4\\u8f83\\u7ed3\\u679c\"",
		"\"dump\"",
		"\"\\u8fd4\\u56de\\u6570\\u636e\\u683c\\u5f0f\"",
		"\"empty_blob\"",
		"\"\\u521d\\u59cb\\u5316BLOB\"",
		"\"empty_clob\"",
		"\"\\u521d\\u59cb\\u5316CLOB\"",
		"\"greatest\"",
		"\"\\u6c42\\u6700\\u5927\\u8868\\u8fbe\\u5f0f\"",
		"\"least\"",
		"\"\\u6c42\\u6700\\u5c0f\\u8868\\u8fbe\\u5f0f\"",
		"\"nvl\"",
		"\"\\u6c42\\u975e\\u7a7a\\u503c\"",
		"TILDE",
		"\"\\u975e\\u8fd0\\u7b97\"",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u5f02\\u6216\"",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"PLUS",
		"MINUS",
		"DIVIDE",
		"MOD",
		"AMPERSAND",
		"BITWISEOR",
		"BITWISEXOR",
		"ASSIGNEQUAL",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"NOTEQUAL1",
		"NOTEQUAL2",
		"LESSTHANOREQUALTO1",
		"LESSTHANOREQUALTO2",
		"LESSTHAN",
		"GREATERTHANOREQUALTO1",
		"GREATERTHANOREQUALTO2",
		"GREATERTHAN",
		"\"year\"",
		"\"yy\"",
		"\"yyyy\"",
		"\"month\"",
		"\"mm\"",
		"\"m\"",
		"\"day\"",
		"\"dd\"",
		"\"d\"",
		"\"quarter\"",
		"\"qq\"",
		"\"q\"",
		"\"week\"",
		"\"wk\"",
		"\"w\"",
		"\"dayofyear\"",
		"\"dy\"",
		"\"y\"",
		"\"weekday\"",
		"\"dw\"",
		"\"hour\"",
		"\"hh\"",
		"\"hh12\"",
		"\"hh24\"",
		"\"minute\"",
		"\"mi\"",
		"\"n\"",
		"\"second\"",
		"\"ss\"",
		"\"s\"",
		"\"millisecond\"",
		"\"ms\"",
		"\"long\"",
		"\"date\"",
		"\"rowid\"",
		"\"clob\"",
		"\"nclob\"",
		"\"blob\"",
		"\"bfile\"",
		"DOT_STAR",
		"LEFT_JOIN",
		"PARAM_LPAREN",
		"PARAM_RPAREN",
		"FROM",
		"WS",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT",
		"NOT",
		"EXISTS",
		"COMPARE_OP",
		"TWO_ARG_OP",
		"ONE_ARG_OP",
		"\"\\u5de6\\u8fde\\u63a5\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u6700\\u5927\\u503c\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u6700\\u5c0f\\u503c\""
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-22523379712L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476481L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[12];
		data[0]=-8955400952718819326L;
		data[1]=-1048543161L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-281424510812160L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476481L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-22523379616L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476481L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[12];
		data[0]=-9223240095459442688L;
		data[1]=-281407322589104L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[12];
		data[0]=-576328536030183424L;
		data[1]=-281407322589103L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[12];
		data[0]=-314697510817890302L;
		data[1]=-281407188371373L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[12];
		data[0]=-315119723282956286L;
		data[1]=-281407322589103L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[12];
		data[0]=-296681256882536446L;
		data[1]=-905971629L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[12];
		data[0]=-294992407022272510L;
		data[1]=-100663309L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 70368744177664L, 7340032L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-281428805779456L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476673L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-281407330942911L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[12];
		data[0]=-9007198945503346686L;
		data[1]=-281407330942911L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[12];
		data[0]=-296813198277869566L;
		data[1]=-914325437L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[12];
		data[0]=-296813198277869566L;
		data[1]=-1048543167L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[12];
		data[0]=-295124348417605630L;
		data[1]=-914323485L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[12];
		data[0]=-288230410511450110L;
		for (int i = 1; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[10];
		data[0]=-9223372036854775808L;
		data[1]=-281474976710656L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=63L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = { 309237645314L, 1921L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = { 0L, 281406282399744L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-1048543167L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[12];
		data[0]=-8953712102858555390L;
		data[1]=-947879865L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[12];
		data[0]=-61607010893822L;
		data[1]=-813662105L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-22523379712L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476673L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[12];
		data[0]=-8955400952718819326L;
		data[1]=-281407330942905L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[12];
		data[0]=-61607010893822L;
		data[1]=-947879833L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68715282433L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[12];
		data[0]=-34359738366L;
		data[1]=-905969665L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = new long[12];
		data[0]=-34359738366L;
		for (int i = 1; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = new long[10];
		data[0]=-9223372036854775808L;
		data[1]=-4503599627370496L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=63L;
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = new long[12];
		data[0]=-9221683186994511872L;
		data[1]=-281424410148864L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476481L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[12];
		data[0]=-315119723282956286L;
		data[1]=-281407188371373L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = new long[12];
		data[0]=-289919260371714046L;
		data[1]=-100663337L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = new long[10];
		data[1]=64L;
		data[2]=8192L;
		data[4]=4194240L;
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = new long[12];
		data[0]=-34359738366L;
		data[1]=-100663305L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = new long[12];
		data[0]=-315119723282956286L;
		data[1]=-281424368240621L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-4194049L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = new long[12];
		data[0]=-9223372036854775808L;
		data[1]=-281424510812160L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=-68719476673L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = new long[12];
		data[1]=44023447552L;
		data[4]=-68719476736L;
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = new long[12];
		data[0]=274877906944L;
		data[1]=1L;
		data[5]=2032L;
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = new long[12];
		data[0]=-308357726772133886L;
		data[1]=-281424368238633L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=15L;
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = new long[12];
		data[0]=-1688884220002302L;
		data[1]=-100663305L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = new long[12];
		data[0]=-34359738366L;
		data[1]=-100663297L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=2047L;
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	
	}
