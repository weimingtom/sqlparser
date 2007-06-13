// $ANTLR 2.7.7 (2006-11-01): "src/parser/db2/parser_db2.g" -> "DB2UDB8xParser.java"$

	package parser.db2;

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

public class DB2UDB8xParser extends antlr.LLkParser       implements DB2UDB8xParserTokenTypes
 {

protected DB2UDB8xParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public DB2UDB8xParser(TokenBuffer tokenBuf) {
  this(tokenBuf,5);
}

protected DB2UDB8xParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public DB2UDB8xParser(TokenStream lexer) {
  this(lexer,5);
}

public DB2UDB8xParser(ParserSharedInputState state) {
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
			AST tmp1_AST = null;
			tmp1_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp1_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp2_AST = null;
			tmp2_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp2_AST);
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
			AST tmp4_AST = null;
			tmp4_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp4_AST);
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
						AST tmp5_AST = null;
						tmp5_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp5_AST);
						match(AS_EN);
						break;
					}
					case AS_CN:
					{
						AST tmp6_AST = null;
						tmp6_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp6_AST);
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
					AST tmp7_AST = null;
					tmp7_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp7_AST);
					match(67);
					break;
				}
				case 68:
				{
					AST tmp8_AST = null;
					tmp8_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp8_AST);
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
				AST tmp9_AST = null;
				tmp9_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp9_AST);
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
				AST tmp10_AST = null;
				tmp10_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp10_AST);
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
				AST tmp11_AST = null;
				tmp11_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp11_AST);
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
			AST tmp13_AST = null;
			tmp13_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp13_AST);
			match(TABLE_UNION_EN);
			break;
		}
		case TABLE_UNION_CN:
		{
			AST tmp14_AST = null;
			tmp14_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp14_AST);
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
			AST tmp15_AST = null;
			tmp15_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp15_AST);
			match(TABLE_COMPARE_EN);
			break;
		}
		case TABLE_COMPARE_CN:
		{
			AST tmp16_AST = null;
			tmp16_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp16_AST);
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
			AST tmp20_AST = null;
			tmp20_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp20_AST);
			match(SELECT_EN);
			break;
		}
		case SELECT_CN:
		{
			AST tmp21_AST = null;
			tmp21_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp21_AST);
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
			AST tmp22_AST = null;
			tmp22_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp22_AST);
			match(DISTINCT_EN);
			break;
		}
		case DISTINCT_CN:
		{
			AST tmp23_AST = null;
			tmp23_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp23_AST);
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
				AST tmp24_AST = null;
				tmp24_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp24_AST);
				match(FROM_EN);
				break;
			}
			case FROM_CN:
			{
				AST tmp25_AST = null;
				tmp25_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp25_AST);
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
				AST tmp26_AST = null;
				tmp26_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp26_AST);
				match(WHERE_EN);
				break;
			}
			case WHERE_CN:
			{
				AST tmp27_AST = null;
				tmp27_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp27_AST);
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
				AST tmp28_AST = null;
				tmp28_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp28_AST);
				match(GROUP_EN);
				match(BY_EN);
				break;
			}
			case GROUP_BY_CN:
			{
				AST tmp30_AST = null;
				tmp30_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp30_AST);
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
				AST tmp31_AST = null;
				tmp31_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp31_AST);
				match(ORDER_EN);
				match(BY_EN);
				break;
			}
			case ORDER_BY_CN:
			{
				AST tmp33_AST = null;
				tmp33_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp33_AST);
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
				AST tmp34_AST = null;
				tmp34_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp34_AST);
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
		
		AST tmp35_AST = null;
		tmp35_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp35_AST);
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
				AST tmp36_AST = null;
				tmp36_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp36_AST);
				match(AS_EN);
				break;
			}
			case AS_CN:
			{
				AST tmp37_AST = null;
				tmp37_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp37_AST);
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
				AST tmp38_AST = null;
				tmp38_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp38_AST);
				match(EXISTS_EN);
				break;
			}
			case EXISTS_CN:
			{
				AST tmp39_AST = null;
				tmp39_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp39_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp40_AST = null;
				tmp40_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp40_AST);
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
			AST tmp41_AST = null;
			tmp41_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp41_AST);
			match(NOT_EN);
			AST tmp42_AST = null;
			tmp42_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp42_AST);
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
				AST tmp43_AST = null;
				tmp43_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp43_AST);
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
				AST tmp44_AST = null;
				tmp44_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp44_AST);
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
				AST tmp45_AST = null;
				tmp45_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp45_AST);
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
				AST tmp46_AST = null;
				tmp46_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp46_AST);
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
					AST tmp47_AST = null;
					tmp47_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp47_AST);
					match(AND_EN);
					break;
				}
				case OR_EN:
				{
					AST tmp48_AST = null;
					tmp48_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp48_AST);
					match(OR_EN);
					break;
				}
				case AND_CN:
				{
					AST tmp49_AST = null;
					tmp49_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp49_AST);
					match(AND_CN);
					break;
				}
				case OR_CN:
				{
					AST tmp50_AST = null;
					tmp50_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp50_AST);
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
			AST tmp53_AST = null;
			tmp53_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp53_AST);
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
				AST tmp54_AST = null;
				tmp54_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp54_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp55_AST = null;
				tmp55_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp55_AST);
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
			AST tmp56_AST = null;
			tmp56_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp56_AST);
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
				AST tmp57_AST = null;
				tmp57_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp57_AST);
				match(LIKE_CN);
				break;
			}
			case NOT_LIKE_CN:
			{
				AST tmp58_AST = null;
				tmp58_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp58_AST);
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
				AST tmp59_AST = null;
				tmp59_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp59_AST);
				match(NULL_CN);
				break;
			}
			case NOT_NULL_CN:
			{
				AST tmp60_AST = null;
				tmp60_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp60_AST);
				match(NOT_NULL_CN);
				break;
			}
			default:
				if ((LA(1)==IS_EN) && (LA(2)==NULL_EN)) {
					AST tmp61_AST = null;
					tmp61_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp61_AST);
					match(IS_EN);
					AST tmp62_AST = null;
					tmp62_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp62_AST);
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
					AST tmp63_AST = null;
					tmp63_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp63_AST);
					match(IS_EN);
					AST tmp64_AST = null;
					tmp64_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp64_AST);
					match(NOT_EN);
					AST tmp65_AST = null;
					tmp65_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp65_AST);
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
			AST tmp66_AST = null;
			tmp66_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp66_AST);
			match(BETWEEN_CN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case BETWEEN_EN:
		{
			AST tmp67_AST = null;
			tmp67_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp67_AST);
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
				AST tmp69_AST = null;
				tmp69_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp69_AST);
				match(NOT_EN);
				AST tmp70_AST = null;
				tmp70_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp70_AST);
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
				AST tmp71_AST = null;
				tmp71_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp71_AST);
				match(NOT_EN);
				AST tmp72_AST = null;
				tmp72_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp72_AST);
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
					AST tmp73_AST = null;
					tmp73_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp73_AST);
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
					AST tmp74_AST = null;
					tmp74_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp74_AST);
					match(NOT_EN);
					AST tmp75_AST = null;
					tmp75_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp75_AST);
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
					AST tmp76_AST = null;
					tmp76_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp76_AST);
					match(IN_CN);
					break;
				}
				case NOT_IN_CN:
				{
					AST tmp77_AST = null;
					tmp77_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp77_AST);
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
			AST tmp78_AST = null;
			tmp78_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp78_AST);
			match(LPAREN);
			aggregate_expr();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp79_AST = null;
			tmp79_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp79_AST);
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
			AST tmp80_AST = null;
			tmp80_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp80_AST);
			match(ASC_EN);
			break;
		}
		case ASC_CN:
		{
			AST tmp81_AST = null;
			tmp81_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp81_AST);
			match(ASC_CN);
			break;
		}
		case DESC_EN:
		{
			AST tmp82_AST = null;
			tmp82_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp82_AST);
			match(DESC_EN);
			break;
		}
		case DESC_CN:
		{
			AST tmp83_AST = null;
			tmp83_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp83_AST);
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
			AST tmp84_AST = null;
			tmp84_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp84_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp85_AST = null;
			tmp85_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp85_AST);
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
			AST tmp86_AST = null;
			tmp86_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp86_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp87_AST = null;
			tmp87_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp87_AST);
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
		
		AST tmp88_AST = null;
		tmp88_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp88_AST);
		match(ID);
		AST tmp89_AST = null;
		tmp89_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp89_AST);
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
			AST tmp94_AST = null;
			tmp94_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp94_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp95_AST = null;
			tmp95_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp95_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp96_AST = null;
			tmp96_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp96_AST);
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
			AST tmp97_AST = null;
			tmp97_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp97_AST);
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
			AST tmp98_AST = null;
			tmp98_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp98_AST);
			match(264);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 263:
		{
			AST tmp99_AST = null;
			tmp99_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp99_AST);
			match(263);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 265:
		{
			AST tmp100_AST = null;
			tmp100_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp100_AST);
			match(265);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 266:
		{
			AST tmp101_AST = null;
			tmp101_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp101_AST);
			match(266);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 267:
		{
			AST tmp102_AST = null;
			tmp102_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp102_AST);
			match(267);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 268:
		{
			AST tmp103_AST = null;
			tmp103_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp103_AST);
			match(268);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 269:
		{
			AST tmp104_AST = null;
			tmp104_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp104_AST);
			match(269);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 270:
		{
			AST tmp105_AST = null;
			tmp105_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp105_AST);
			match(270);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 141:
		{
			AST tmp106_AST = null;
			tmp106_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp106_AST);
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
				AST tmp107_AST = null;
				tmp107_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp107_AST);
				match(COUNT_EN);
				break;
			}
			case COUNT_CN:
			{
				AST tmp108_AST = null;
				tmp108_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp108_AST);
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
				AST tmp113_AST = null;
				tmp113_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp113_AST);
				match(ALL_EN);
				break;
			}
			case ALL_CN:
			{
				AST tmp114_AST = null;
				tmp114_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp114_AST);
				match(ALL_CN);
				break;
			}
			case DISTINCT_EN:
			{
				AST tmp115_AST = null;
				tmp115_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp115_AST);
				match(DISTINCT_EN);
				break;
			}
			case DISTINCT_CN:
			{
				AST tmp116_AST = null;
				tmp116_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp116_AST);
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
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp119_AST = null;
			tmp119_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp119_AST);
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
			AST tmp120_AST = null;
			tmp120_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp120_AST);
			match(TILDE);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 263:
		{
			AST tmp121_AST = null;
			tmp121_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp121_AST);
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
		
		AST tmp122_AST = null;
		tmp122_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp122_AST);
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
			AST tmp123_AST = null;
			tmp123_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp123_AST);
			match(68);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 279:
		{
			AST tmp124_AST = null;
			tmp124_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp124_AST);
			match(279);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 280:
		{
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp125_AST);
			match(280);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 281:
		{
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp126_AST);
			match(281);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 282:
		{
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp127_AST);
			match(282);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 283:
		{
			AST tmp128_AST = null;
			tmp128_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp128_AST);
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
			AST tmp133_AST = null;
			tmp133_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp133_AST);
			match(SYSDATE_EN);
			nothing_function_AST = (AST)currentAST.root;
			break;
		}
		case SYSDATE_CN:
		{
			AST tmp134_AST = null;
			tmp134_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp134_AST);
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
			AST tmp135_AST = null;
			tmp135_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp135_AST);
			match(LITERAL_cast);
			asdatatype_function_AST = (AST)currentAST.root;
			break;
		}
		case 115:
		{
			AST tmp136_AST = null;
			tmp136_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp136_AST);
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
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp139_AST);
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
			AST tmp140_AST = null;
			tmp140_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp140_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 101:
		{
			AST tmp141_AST = null;
			tmp141_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp141_AST);
			match(101);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_EN:
		{
			AST tmp142_AST = null;
			tmp142_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp142_AST);
			match(COUNT_EN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_CN:
		{
			AST tmp143_AST = null;
			tmp143_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp143_AST);
			match(COUNT_CN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp144_AST = null;
			tmp144_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp144_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 103:
		{
			AST tmp145_AST = null;
			tmp145_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp145_AST);
			match(103);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp146_AST = null;
			tmp146_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp146_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 105:
		{
			AST tmp147_AST = null;
			tmp147_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp147_AST);
			match(105);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_stddev:
		{
			AST tmp148_AST = null;
			tmp148_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp148_AST);
			match(LITERAL_stddev);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 107:
		{
			AST tmp149_AST = null;
			tmp149_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp149_AST);
			match(107);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sum:
		{
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp150_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 109:
		{
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp151_AST);
			match(109);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_variance:
		{
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(LITERAL_variance);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 111:
		{
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp153_AST);
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
			AST tmp154_AST = null;
			tmp154_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp154_AST);
			match(CHAR);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==CHAR) && (LA(2)==LPAREN)) {
			AST tmp155_AST = null;
			tmp155_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp155_AST);
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
			AST tmp158_AST = null;
			tmp158_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp158_AST);
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
			AST tmp161_AST = null;
			tmp161_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp161_AST);
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
				AST tmp162_AST = null;
				tmp162_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp162_AST);
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
			AST tmp163_AST = null;
			tmp163_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp163_AST);
			match(LITERAL_long);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp164_AST = null;
			tmp164_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp164_AST);
			match(LITERAL_date);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rowid:
		{
			AST tmp165_AST = null;
			tmp165_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp165_AST);
			match(LITERAL_rowid);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_clob:
		{
			AST tmp166_AST = null;
			tmp166_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp166_AST);
			match(LITERAL_clob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nclob:
		{
			AST tmp167_AST = null;
			tmp167_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp167_AST);
			match(LITERAL_nclob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_blob:
		{
			AST tmp168_AST = null;
			tmp168_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp168_AST);
			match(LITERAL_blob);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bfile:
		{
			AST tmp169_AST = null;
			tmp169_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp169_AST);
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
			AST tmp170_AST = null;
			tmp170_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp170_AST);
			match(REAL_NUM);
			AST tmp171_AST = null;
			tmp171_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp171_AST);
			match(COMMA);
			AST tmp172_AST = null;
			tmp172_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp172_AST);
			match(REAL_NUM);
			datatype_precision_or_scale_or_maxlength_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==REAL_NUM) && (LA(2)==RPAREN)) {
			AST tmp173_AST = null;
			tmp173_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp173_AST);
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
				AST tmp174_AST = null;
				tmp174_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp174_AST);
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
			AST tmp175_AST = null;
			tmp175_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp175_AST);
			match(ID);
			match(LPAREN);
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp177_AST);
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
			AST tmp179_AST = null;
			tmp179_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp179_AST);
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
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
			match(LITERAL_year);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yy:
		{
			AST tmp181_AST = null;
			tmp181_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp181_AST);
			match(LITERAL_yy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yyyy:
		{
			AST tmp182_AST = null;
			tmp182_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp182_AST);
			match(LITERAL_yyyy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp183_AST = null;
			tmp183_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp183_AST);
			match(LITERAL_month);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mm:
		{
			AST tmp184_AST = null;
			tmp184_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp184_AST);
			match(LITERAL_mm);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_m:
		{
			AST tmp185_AST = null;
			tmp185_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp185_AST);
			match(LITERAL_m);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp186_AST = null;
			tmp186_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp186_AST);
			match(LITERAL_day);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dd:
		{
			AST tmp187_AST = null;
			tmp187_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp187_AST);
			match(LITERAL_dd);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_d:
		{
			AST tmp188_AST = null;
			tmp188_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp188_AST);
			match(LITERAL_d);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp189_AST = null;
			tmp189_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp189_AST);
			match(LITERAL_quarter);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_qq:
		{
			AST tmp190_AST = null;
			tmp190_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp190_AST);
			match(LITERAL_qq);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_q:
		{
			AST tmp191_AST = null;
			tmp191_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp191_AST);
			match(LITERAL_q);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp192_AST = null;
			tmp192_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp192_AST);
			match(LITERAL_week);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_wk:
		{
			AST tmp193_AST = null;
			tmp193_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp193_AST);
			match(LITERAL_wk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_w:
		{
			AST tmp194_AST = null;
			tmp194_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp194_AST);
			match(LITERAL_w);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayofyear:
		{
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp195_AST);
			match(LITERAL_dayofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dy:
		{
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp196_AST);
			match(LITERAL_dy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_y:
		{
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp197_AST);
			match(LITERAL_y);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weekday:
		{
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp198_AST);
			match(LITERAL_weekday);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dw:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp199_AST);
			match(LITERAL_dw);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp200_AST = null;
			tmp200_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp200_AST);
			match(LITERAL_hour);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hh:
		{
			AST tmp201_AST = null;
			tmp201_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp201_AST);
			match(LITERAL_hh);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case 314:
		{
			AST tmp202_AST = null;
			tmp202_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp202_AST);
			match(314);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case 315:
		{
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(315);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp204_AST = null;
			tmp204_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp204_AST);
			match(LITERAL_minute);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mi:
		{
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(LITERAL_mi);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_n:
		{
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
			match(LITERAL_n);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(LITERAL_second);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ss:
		{
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(LITERAL_ss);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_s:
		{
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(LITERAL_s);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_millisecond:
		{
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(LITERAL_millisecond);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ms:
		{
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
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
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(LITERAL_abs);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 117:
		{
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(117);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_acos:
		{
			AST tmp214_AST = null;
			tmp214_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp214_AST);
			match(LITERAL_acos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 119:
		{
			AST tmp215_AST = null;
			tmp215_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp215_AST);
			match(119);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asin:
		{
			AST tmp216_AST = null;
			tmp216_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp216_AST);
			match(LITERAL_asin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 121:
		{
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp217_AST);
			match(121);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_atan:
		{
			AST tmp218_AST = null;
			tmp218_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp218_AST);
			match(LITERAL_atan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 123:
		{
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp219_AST);
			match(123);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 124:
		{
			AST tmp220_AST = null;
			tmp220_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp220_AST);
			match(124);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 125:
		{
			AST tmp221_AST = null;
			tmp221_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp221_AST);
			match(125);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceil:
		{
			AST tmp222_AST = null;
			tmp222_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp222_AST);
			match(LITERAL_ceil);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 127:
		{
			AST tmp223_AST = null;
			tmp223_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp223_AST);
			match(127);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cos:
		{
			AST tmp224_AST = null;
			tmp224_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp224_AST);
			match(LITERAL_cos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp225_AST = null;
			tmp225_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp225_AST);
			match(129);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cosh:
		{
			AST tmp226_AST = null;
			tmp226_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp226_AST);
			match(LITERAL_cosh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 131:
		{
			AST tmp227_AST = null;
			tmp227_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp227_AST);
			match(131);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exp:
		{
			AST tmp228_AST = null;
			tmp228_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp228_AST);
			match(LITERAL_exp);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 133:
		{
			AST tmp229_AST = null;
			tmp229_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp229_AST);
			match(133);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp230_AST = null;
			tmp230_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp230_AST);
			match(LITERAL_floor);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 135:
		{
			AST tmp231_AST = null;
			tmp231_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp231_AST);
			match(135);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ln:
		{
			AST tmp232_AST = null;
			tmp232_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp232_AST);
			match(LITERAL_ln);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 137:
		{
			AST tmp233_AST = null;
			tmp233_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp233_AST);
			match(137);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_log:
		{
			AST tmp234_AST = null;
			tmp234_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp234_AST);
			match(LITERAL_log);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 139:
		{
			AST tmp235_AST = null;
			tmp235_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(139);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(LITERAL_mod);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 141:
		{
			AST tmp237_AST = null;
			tmp237_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp237_AST);
			match(141);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_power:
		{
			AST tmp238_AST = null;
			tmp238_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp238_AST);
			match(LITERAL_power);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 143:
		{
			AST tmp239_AST = null;
			tmp239_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp239_AST);
			match(143);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp240_AST = null;
			tmp240_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp240_AST);
			match(LITERAL_round);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 145:
		{
			AST tmp241_AST = null;
			tmp241_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp241_AST);
			match(145);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sign:
		{
			AST tmp242_AST = null;
			tmp242_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp242_AST);
			match(LITERAL_sign);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 147:
		{
			AST tmp243_AST = null;
			tmp243_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp243_AST);
			match(147);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sin:
		{
			AST tmp244_AST = null;
			tmp244_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp244_AST);
			match(LITERAL_sin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 149:
		{
			AST tmp245_AST = null;
			tmp245_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp245_AST);
			match(149);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sinh:
		{
			AST tmp246_AST = null;
			tmp246_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp246_AST);
			match(LITERAL_sinh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 151:
		{
			AST tmp247_AST = null;
			tmp247_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp247_AST);
			match(151);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sqrt:
		{
			AST tmp248_AST = null;
			tmp248_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp248_AST);
			match(LITERAL_sqrt);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 153:
		{
			AST tmp249_AST = null;
			tmp249_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp249_AST);
			match(153);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tan:
		{
			AST tmp250_AST = null;
			tmp250_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp250_AST);
			match(LITERAL_tan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 155:
		{
			AST tmp251_AST = null;
			tmp251_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp251_AST);
			match(155);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tanh:
		{
			AST tmp252_AST = null;
			tmp252_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp252_AST);
			match(LITERAL_tanh);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 157:
		{
			AST tmp253_AST = null;
			tmp253_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp253_AST);
			match(157);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trunc:
		{
			AST tmp254_AST = null;
			tmp254_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp254_AST);
			match(LITERAL_trunc);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 159:
		{
			AST tmp255_AST = null;
			tmp255_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp255_AST);
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
			AST tmp256_AST = null;
			tmp256_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp256_AST);
			match(LITERAL_ascii);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 161:
		{
			AST tmp257_AST = null;
			tmp257_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp257_AST);
			match(161);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asciistr:
		{
			AST tmp258_AST = null;
			tmp258_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp258_AST);
			match(LITERAL_asciistr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 163:
		{
			AST tmp259_AST = null;
			tmp259_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp259_AST);
			match(163);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_chr:
		{
			AST tmp260_AST = null;
			tmp260_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp260_AST);
			match(LITERAL_chr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 165:
		{
			AST tmp261_AST = null;
			tmp261_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp261_AST);
			match(165);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cancat:
		{
			AST tmp262_AST = null;
			tmp262_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp262_AST);
			match(LITERAL_cancat);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 167:
		{
			AST tmp263_AST = null;
			tmp263_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp263_AST);
			match(167);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_initcap:
		{
			AST tmp264_AST = null;
			tmp264_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp264_AST);
			match(LITERAL_initcap);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 169:
		{
			AST tmp265_AST = null;
			tmp265_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp265_AST);
			match(169);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_instr:
		{
			AST tmp266_AST = null;
			tmp266_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp266_AST);
			match(LITERAL_instr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 171:
		{
			AST tmp267_AST = null;
			tmp267_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp267_AST);
			match(171);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_instrb:
		{
			AST tmp268_AST = null;
			tmp268_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp268_AST);
			match(LITERAL_instrb);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 173:
		{
			AST tmp269_AST = null;
			tmp269_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp269_AST);
			match(173);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_length:
		{
			AST tmp270_AST = null;
			tmp270_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp270_AST);
			match(LITERAL_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 175:
		{
			AST tmp271_AST = null;
			tmp271_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp271_AST);
			match(175);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lengthb:
		{
			AST tmp272_AST = null;
			tmp272_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp272_AST);
			match(LITERAL_lengthb);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 177:
		{
			AST tmp273_AST = null;
			tmp273_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp273_AST);
			match(177);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp274_AST = null;
			tmp274_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp274_AST);
			match(LITERAL_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 179:
		{
			AST tmp275_AST = null;
			tmp275_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp275_AST);
			match(179);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp276_AST = null;
			tmp276_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp276_AST);
			match(LITERAL_ltrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 181:
		{
			AST tmp277_AST = null;
			tmp277_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp277_AST);
			match(181);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lpad:
		{
			AST tmp278_AST = null;
			tmp278_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp278_AST);
			match(LITERAL_lpad);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 183:
		{
			AST tmp279_AST = null;
			tmp279_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp279_AST);
			match(183);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_initcap:
		{
			AST tmp280_AST = null;
			tmp280_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp280_AST);
			match(LITERAL_nls_initcap);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 185:
		{
			AST tmp281_AST = null;
			tmp281_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp281_AST);
			match(185);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_lower:
		{
			AST tmp282_AST = null;
			tmp282_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp282_AST);
			match(LITERAL_nls_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 187:
		{
			AST tmp283_AST = null;
			tmp283_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp283_AST);
			match(187);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nlssort:
		{
			AST tmp284_AST = null;
			tmp284_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp284_AST);
			match(LITERAL_nlssort);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 189:
		{
			AST tmp285_AST = null;
			tmp285_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp285_AST);
			match(189);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nls_upper:
		{
			AST tmp286_AST = null;
			tmp286_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp286_AST);
			match(LITERAL_nls_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 191:
		{
			AST tmp287_AST = null;
			tmp287_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp287_AST);
			match(191);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replace:
		{
			AST tmp288_AST = null;
			tmp288_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp288_AST);
			match(LITERAL_replace);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 193:
		{
			AST tmp289_AST = null;
			tmp289_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp289_AST);
			match(193);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rpad:
		{
			AST tmp290_AST = null;
			tmp290_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp290_AST);
			match(LITERAL_rpad);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 195:
		{
			AST tmp291_AST = null;
			tmp291_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp291_AST);
			match(195);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp292_AST = null;
			tmp292_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp292_AST);
			match(LITERAL_rtrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 197:
		{
			AST tmp293_AST = null;
			tmp293_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp293_AST);
			match(197);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_soundex:
		{
			AST tmp294_AST = null;
			tmp294_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp294_AST);
			match(LITERAL_soundex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 199:
		{
			AST tmp295_AST = null;
			tmp295_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp295_AST);
			match(199);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substr:
		{
			AST tmp296_AST = null;
			tmp296_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp296_AST);
			match(LITERAL_substr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 201:
		{
			AST tmp297_AST = null;
			tmp297_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp297_AST);
			match(201);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trim:
		{
			AST tmp298_AST = null;
			tmp298_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp298_AST);
			match(LITERAL_trim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 203:
		{
			AST tmp299_AST = null;
			tmp299_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp299_AST);
			match(203);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ranslate:
		{
			AST tmp300_AST = null;
			tmp300_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp300_AST);
			match(LITERAL_ranslate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 205:
		{
			AST tmp301_AST = null;
			tmp301_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp301_AST);
			match(205);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_upper:
		{
			AST tmp302_AST = null;
			tmp302_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp302_AST);
			match(LITERAL_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 207:
		{
			AST tmp303_AST = null;
			tmp303_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp303_AST);
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
			AST tmp304_AST = null;
			tmp304_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp304_AST);
			match(LITERAL_add_months);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 209:
		{
			AST tmp305_AST = null;
			tmp305_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp305_AST);
			match(209);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_last_day:
		{
			AST tmp306_AST = null;
			tmp306_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp306_AST);
			match(LITERAL_last_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 211:
		{
			AST tmp307_AST = null;
			tmp307_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp307_AST);
			match(211);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_months_between:
		{
			AST tmp308_AST = null;
			tmp308_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp308_AST);
			match(LITERAL_months_between);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 213:
		{
			AST tmp309_AST = null;
			tmp309_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp309_AST);
			match(213);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_new_time:
		{
			AST tmp310_AST = null;
			tmp310_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp310_AST);
			match(LITERAL_new_time);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 215:
		{
			AST tmp311_AST = null;
			tmp311_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp311_AST);
			match(215);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_next_day:
		{
			AST tmp312_AST = null;
			tmp312_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp312_AST);
			match(LITERAL_next_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 217:
		{
			AST tmp313_AST = null;
			tmp313_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp313_AST);
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
			AST tmp314_AST = null;
			tmp314_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp314_AST);
			match(LITERAL_bin_to_num);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 219:
		{
			AST tmp315_AST = null;
			tmp315_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp315_AST);
			match(219);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_chartorowid:
		{
			AST tmp316_AST = null;
			tmp316_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp316_AST);
			match(LITERAL_chartorowid);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 221:
		{
			AST tmp317_AST = null;
			tmp317_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp317_AST);
			match(221);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_convert:
		{
			AST tmp318_AST = null;
			tmp318_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp318_AST);
			match(LITERAL_convert);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 223:
		{
			AST tmp319_AST = null;
			tmp319_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp319_AST);
			match(223);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hextoraw:
		{
			AST tmp320_AST = null;
			tmp320_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp320_AST);
			match(LITERAL_hextoraw);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 225:
		{
			AST tmp321_AST = null;
			tmp321_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp321_AST);
			match(225);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rawtohex:
		{
			AST tmp322_AST = null;
			tmp322_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp322_AST);
			match(LITERAL_rawtohex);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 227:
		{
			AST tmp323_AST = null;
			tmp323_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp323_AST);
			match(227);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rowidtochar:
		{
			AST tmp324_AST = null;
			tmp324_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp324_AST);
			match(LITERAL_rowidtochar);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 229:
		{
			AST tmp325_AST = null;
			tmp325_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp325_AST);
			match(229);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_char:
		{
			AST tmp326_AST = null;
			tmp326_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp326_AST);
			match(LITERAL_to_char);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 231:
		{
			AST tmp327_AST = null;
			tmp327_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp327_AST);
			match(231);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_date:
		{
			AST tmp328_AST = null;
			tmp328_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp328_AST);
			match(LITERAL_to_date);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 233:
		{
			AST tmp329_AST = null;
			tmp329_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp329_AST);
			match(233);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_multi_byte:
		{
			AST tmp330_AST = null;
			tmp330_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp330_AST);
			match(LITERAL_to_multi_byte);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 235:
		{
			AST tmp331_AST = null;
			tmp331_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp331_AST);
			match(235);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_number:
		{
			AST tmp332_AST = null;
			tmp332_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp332_AST);
			match(LITERAL_to_number);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 237:
		{
			AST tmp333_AST = null;
			tmp333_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp333_AST);
			match(237);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_to_single_byte:
		{
			AST tmp334_AST = null;
			tmp334_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp334_AST);
			match(LITERAL_to_single_byte);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 239:
		{
			AST tmp335_AST = null;
			tmp335_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp335_AST);
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
			AST tmp336_AST = null;
			tmp336_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp336_AST);
			match(LITERAL_uid);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 241:
		{
			AST tmp337_AST = null;
			tmp337_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp337_AST);
			match(241);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user:
		{
			AST tmp338_AST = null;
			tmp338_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp338_AST);
			match(LITERAL_user);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 243:
		{
			AST tmp339_AST = null;
			tmp339_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp339_AST);
			match(243);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_userenv:
		{
			AST tmp340_AST = null;
			tmp340_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp340_AST);
			match(LITERAL_userenv);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 245:
		{
			AST tmp341_AST = null;
			tmp341_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp341_AST);
			match(245);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_vsize:
		{
			AST tmp342_AST = null;
			tmp342_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp342_AST);
			match(LITERAL_vsize);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case 247:
		{
			AST tmp343_AST = null;
			tmp343_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp343_AST);
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
			AST tmp344_AST = null;
			tmp344_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp344_AST);
			match(LITERAL_decode);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 249:
		{
			AST tmp345_AST = null;
			tmp345_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp345_AST);
			match(249);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dump:
		{
			AST tmp346_AST = null;
			tmp346_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp346_AST);
			match(LITERAL_dump);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 251:
		{
			AST tmp347_AST = null;
			tmp347_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp347_AST);
			match(251);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_empty_blob:
		{
			AST tmp348_AST = null;
			tmp348_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp348_AST);
			match(LITERAL_empty_blob);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 253:
		{
			AST tmp349_AST = null;
			tmp349_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp349_AST);
			match(253);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_empty_clob:
		{
			AST tmp350_AST = null;
			tmp350_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp350_AST);
			match(LITERAL_empty_clob);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 255:
		{
			AST tmp351_AST = null;
			tmp351_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp351_AST);
			match(255);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_greatest:
		{
			AST tmp352_AST = null;
			tmp352_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp352_AST);
			match(LITERAL_greatest);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 257:
		{
			AST tmp353_AST = null;
			tmp353_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp353_AST);
			match(257);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_least:
		{
			AST tmp354_AST = null;
			tmp354_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp354_AST);
			match(LITERAL_least);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 259:
		{
			AST tmp355_AST = null;
			tmp355_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp355_AST);
			match(259);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nvl:
		{
			AST tmp356_AST = null;
			tmp356_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp356_AST);
			match(LITERAL_nvl);
			other_function_AST = (AST)currentAST.root;
			break;
		}
		case 261:
		{
			AST tmp357_AST = null;
			tmp357_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp357_AST);
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
			AST tmp358_AST = null;
			tmp358_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp358_AST);
			match(PLUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp359_AST = null;
			tmp359_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp359_AST);
			match(MINUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp360_AST = null;
			tmp360_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp360_AST);
			match(STAR);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case DIVIDE:
		{
			AST tmp361_AST = null;
			tmp361_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp361_AST);
			match(DIVIDE);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MOD:
		{
			AST tmp362_AST = null;
			tmp362_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp362_AST);
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
			AST tmp363_AST = null;
			tmp363_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp363_AST);
			match(AMPERSAND);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case TILDE:
		{
			AST tmp364_AST = null;
			tmp364_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp364_AST);
			match(TILDE);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEOR:
		{
			AST tmp365_AST = null;
			tmp365_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp365_AST);
			match(BITWISEOR);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEXOR:
		{
			AST tmp366_AST = null;
			tmp366_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp366_AST);
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
			AST tmp367_AST = null;
			tmp367_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp367_AST);
			match(ASSIGNEQUAL);
			alias_equ_op_AST = (AST)currentAST.root;
			break;
		}
		case 68:
		{
			AST tmp368_AST = null;
			tmp368_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp368_AST);
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
			AST tmp369_AST = null;
			tmp369_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp369_AST);
			match(ASSIGNEQUAL);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL1:
		{
			AST tmp370_AST = null;
			tmp370_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp370_AST);
			match(NOTEQUAL1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL2:
		{
			AST tmp371_AST = null;
			tmp371_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp371_AST);
			match(NOTEQUAL2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO1:
		{
			AST tmp372_AST = null;
			tmp372_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp372_AST);
			match(LESSTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO2:
		{
			AST tmp373_AST = null;
			tmp373_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp373_AST);
			match(LESSTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHAN:
		{
			AST tmp374_AST = null;
			tmp374_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp374_AST);
			match(LESSTHAN);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO1:
		{
			AST tmp375_AST = null;
			tmp375_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp375_AST);
			match(GREATERTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO2:
		{
			AST tmp376_AST = null;
			tmp376_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp376_AST);
			match(GREATERTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHAN:
		{
			AST tmp377_AST = null;
			tmp377_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp377_AST);
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
