// $ANTLR 2.7.7 (2006-11-01): "src/parser/sybase/parser_sybase.g" -> "SybaseIQ12Parser.java"$

	package parser.sybase;

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

public class SybaseIQ12Parser extends antlr.LLkParser       implements SybaseIQ12ParserTokenTypes
 {

protected SybaseIQ12Parser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public SybaseIQ12Parser(TokenBuffer tokenBuf) {
  this(tokenBuf,5);
}

protected SybaseIQ12Parser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public SybaseIQ12Parser(TokenStream lexer) {
  this(lexer,5);
}

public SybaseIQ12Parser(ParserSharedInputState state) {
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
			AST tmp376_AST = null;
			tmp376_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp376_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp377_AST = null;
			tmp377_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp377_AST);
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
			AST tmp379_AST = null;
			tmp379_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp379_AST);
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
						AST tmp380_AST = null;
						tmp380_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp380_AST);
						match(AS_EN);
						break;
					}
					case AS_CN:
					{
						AST tmp381_AST = null;
						tmp381_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp381_AST);
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
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==71||LA(2)==72)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 71:
				{
					AST tmp382_AST = null;
					tmp382_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp382_AST);
					match(71);
					break;
				}
				case 72:
				{
					AST tmp383_AST = null;
					tmp383_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp383_AST);
					match(72);
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
				AST tmp384_AST = null;
				tmp384_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp384_AST);
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
				AST tmp385_AST = null;
				tmp385_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp385_AST);
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
				AST tmp386_AST = null;
				tmp386_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp386_AST);
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
			AST tmp388_AST = null;
			tmp388_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp388_AST);
			match(TABLE_UNION_EN);
			break;
		}
		case TABLE_UNION_CN:
		{
			AST tmp389_AST = null;
			tmp389_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp389_AST);
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
			AST tmp390_AST = null;
			tmp390_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp390_AST);
			match(TABLE_COMPARE_EN);
			break;
		}
		case TABLE_COMPARE_CN:
		{
			AST tmp391_AST = null;
			tmp391_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp391_AST);
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
			AST tmp395_AST = null;
			tmp395_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp395_AST);
			match(SELECT_EN);
			break;
		}
		case SELECT_CN:
		{
			AST tmp396_AST = null;
			tmp396_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp396_AST);
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
			AST tmp397_AST = null;
			tmp397_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp397_AST);
			match(DISTINCT_EN);
			break;
		}
		case DISTINCT_CN:
		{
			AST tmp398_AST = null;
			tmp398_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp398_AST);
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
		{
		if ((LA(1)==TOP_EN||LA(1)==TOP_CN)) {
			{
			switch ( LA(1)) {
			case TOP_EN:
			{
				AST tmp399_AST = null;
				tmp399_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp399_AST);
				match(TOP_EN);
				break;
			}
			case TOP_CN:
			{
				AST tmp400_AST = null;
				tmp400_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp400_AST);
				match(TOP_CN);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			integer();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_4.member(LA(1)))) {
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
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
				AST tmp401_AST = null;
				tmp401_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp401_AST);
				match(FROM_EN);
				break;
			}
			case FROM_CN:
			{
				AST tmp402_AST = null;
				tmp402_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp402_AST);
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
				AST tmp403_AST = null;
				tmp403_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp403_AST);
				match(WHERE_EN);
				break;
			}
			case WHERE_CN:
			{
				AST tmp404_AST = null;
				tmp404_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp404_AST);
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
				AST tmp405_AST = null;
				tmp405_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp405_AST);
				match(GROUP_EN);
				match(BY_EN);
				break;
			}
			case GROUP_BY_CN:
			{
				AST tmp407_AST = null;
				tmp407_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp407_AST);
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
				AST tmp408_AST = null;
				tmp408_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp408_AST);
				match(ORDER_EN);
				match(BY_EN);
				break;
			}
			case ORDER_BY_CN:
			{
				AST tmp410_AST = null;
				tmp410_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp410_AST);
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
				AST tmp411_AST = null;
				tmp411_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp411_AST);
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
		
		AST tmp412_AST = null;
		tmp412_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp412_AST);
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
				AST tmp413_AST = null;
				tmp413_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp413_AST);
				match(AS_EN);
				break;
			}
			case AS_CN:
			{
				AST tmp414_AST = null;
				tmp414_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp414_AST);
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
				AST tmp415_AST = null;
				tmp415_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp415_AST);
				match(EXISTS_EN);
				break;
			}
			case EXISTS_CN:
			{
				AST tmp416_AST = null;
				tmp416_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp416_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp417_AST = null;
				tmp417_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp417_AST);
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
			AST tmp418_AST = null;
			tmp418_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp418_AST);
			match(NOT_EN);
			AST tmp419_AST = null;
			tmp419_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp419_AST);
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
	
	public final void integer() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST integer_AST = null;
		
		AST tmp420_AST = null;
		tmp420_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp420_AST);
		match(REAL_NUM);
		integer_AST = (AST)currentAST.root;
		returnAST = integer_AST;
	}
	
	public final void select_list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST select_list_AST = null;
		
		column();
		astFactory.addASTChild(currentAST, returnAST);
		{
		_loop33:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp421_AST = null;
				tmp421_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp421_AST);
				match(COMMA);
				column();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop33;
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
		_loop36:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp422_AST = null;
				tmp422_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp422_AST);
				match(COMMA);
				table_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop36;
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
		_loop48:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp423_AST = null;
				tmp423_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp423_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop48;
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
		_loop51:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp424_AST = null;
				tmp424_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp424_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop51;
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
		_loop42:
		do {
			if (((LA(1) >= AND_EN && LA(1) <= OR_CN))) {
				{
				switch ( LA(1)) {
				case AND_EN:
				{
					AST tmp425_AST = null;
					tmp425_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp425_AST);
					match(AND_EN);
					break;
				}
				case OR_EN:
				{
					AST tmp426_AST = null;
					tmp426_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp426_AST);
					match(OR_EN);
					break;
				}
				case AND_CN:
				{
					AST tmp427_AST = null;
					tmp427_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp427_AST);
					match(AND_CN);
					break;
				}
				case OR_CN:
				{
					AST tmp428_AST = null;
					tmp428_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp428_AST);
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
				break _loop42;
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
		
		boolean synPredMatched45 = false;
		if (((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_5.member(LA(3))) && (_tokenSet_6.member(LA(4))) && (_tokenSet_7.member(LA(5))))) {
			int _m45 = mark();
			synPredMatched45 = true;
			inputState.guessing++;
			try {
				{
				match(LPAREN);
				bool_exp();
				match(RPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched45 = false;
			}
			rewind(_m45);
inputState.guessing--;
		}
		if ( synPredMatched45 ) {
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
		else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_5.member(LA(2))) && (_tokenSet_8.member(LA(3))) && (_tokenSet_9.member(LA(4))) && (_tokenSet_10.member(LA(5)))) {
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
		case 72:
		case ASSIGNEQUAL:
		case 334:
		case 335:
		case 336:
		case 337:
		case 338:
		case 339:
		case LEFT_JOIN:
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
			AST tmp431_AST = null;
			tmp431_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp431_AST);
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
				AST tmp432_AST = null;
				tmp432_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp432_AST);
				match(EXISTS_CN);
				break;
			}
			case NOT_EXISTS_CN:
			{
				AST tmp433_AST = null;
				tmp433_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp433_AST);
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
			AST tmp434_AST = null;
			tmp434_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp434_AST);
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
				AST tmp435_AST = null;
				tmp435_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp435_AST);
				match(LIKE_CN);
				break;
			}
			case NOT_LIKE_CN:
			{
				AST tmp436_AST = null;
				tmp436_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp436_AST);
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
				AST tmp437_AST = null;
				tmp437_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp437_AST);
				match(NULL_CN);
				break;
			}
			case NOT_NULL_CN:
			{
				AST tmp438_AST = null;
				tmp438_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp438_AST);
				match(NOT_NULL_CN);
				break;
			}
			default:
				if ((LA(1)==IS_EN) && (LA(2)==NULL_EN)) {
					AST tmp439_AST = null;
					tmp439_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp439_AST);
					match(IS_EN);
					AST tmp440_AST = null;
					tmp440_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp440_AST);
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
					AST tmp441_AST = null;
					tmp441_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp441_AST);
					match(IS_EN);
					AST tmp442_AST = null;
					tmp442_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp442_AST);
					match(NOT_EN);
					AST tmp443_AST = null;
					tmp443_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp443_AST);
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
			AST tmp444_AST = null;
			tmp444_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp444_AST);
			match(BETWEEN_CN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case BETWEEN_EN:
		{
			AST tmp445_AST = null;
			tmp445_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp445_AST);
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
				AST tmp447_AST = null;
				tmp447_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp447_AST);
				match(NOT_EN);
				AST tmp448_AST = null;
				tmp448_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp448_AST);
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
				AST tmp449_AST = null;
				tmp449_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp449_AST);
				match(NOT_EN);
				AST tmp450_AST = null;
				tmp450_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp450_AST);
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
			else if ((_tokenSet_11.member(LA(1))) && (LA(2)==LPAREN||LA(2)==IN_EN)) {
				{
				switch ( LA(1)) {
				case IN_EN:
				{
					AST tmp451_AST = null;
					tmp451_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp451_AST);
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
					AST tmp452_AST = null;
					tmp452_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp452_AST);
					match(NOT_EN);
					AST tmp453_AST = null;
					tmp453_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp453_AST);
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
					AST tmp454_AST = null;
					tmp454_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp454_AST);
					match(IN_CN);
					break;
				}
				case NOT_IN_CN:
				{
					AST tmp455_AST = null;
					tmp455_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp455_AST);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_12.member(LA(2))) && (_tokenSet_13.member(LA(3))) && (_tokenSet_14.member(LA(4))) && (_tokenSet_15.member(LA(5)))) {
			AST tmp456_AST = null;
			tmp456_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp456_AST);
			match(LPAREN);
			aggregate_expr();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp457_AST = null;
			tmp457_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp457_AST);
			match(RPAREN);
			aggregate_expr_AST = (AST)currentAST.root;
		}
		else if ((_tokenSet_12.member(LA(1))) && (_tokenSet_16.member(LA(2))) && (_tokenSet_17.member(LA(3))) && (_tokenSet_18.member(LA(4))) && (_tokenSet_19.member(LA(5)))) {
			{
			if ((LA(1)==ID)) {
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_21.member(LA(3))) && (_tokenSet_22.member(LA(4))) && (_tokenSet_15.member(LA(5)))) {
				function();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((_tokenSet_23.member(LA(1))) && (_tokenSet_24.member(LA(2))) && (_tokenSet_25.member(LA(3))) && (_tokenSet_26.member(LA(4))) && (_tokenSet_27.member(LA(5)))) {
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			{
			switch ( LA(1)) {
			case STAR:
			case 162:
			case TILDE:
			case 318:
			case 319:
			case 320:
			case 321:
			case 322:
			case 323:
			case 324:
			case 325:
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
		if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_28.member(LA(2)))) {
			alias();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((LA(1)==ID) && (LA(2)==POINT)) {
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_29.member(LA(1)))) {
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
		}
		else if ((_tokenSet_20.member(LA(1)))) {
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
			AST tmp458_AST = null;
			tmp458_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp458_AST);
			match(ASC_EN);
			break;
		}
		case ASC_CN:
		{
			AST tmp459_AST = null;
			tmp459_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp459_AST);
			match(ASC_CN);
			break;
		}
		case DESC_EN:
		{
			AST tmp460_AST = null;
			tmp460_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp460_AST);
			match(DESC_EN);
			break;
		}
		case DESC_CN:
		{
			AST tmp461_AST = null;
			tmp461_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp461_AST);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_0.member(LA(2))) && (_tokenSet_30.member(LA(3))) && (_tokenSet_31.member(LA(4))) && (_tokenSet_32.member(LA(5)))) {
			AST tmp462_AST = null;
			tmp462_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp462_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp463_AST = null;
			tmp463_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp463_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case 162:
			case TILDE:
			case 318:
			case 319:
			case 320:
			case 321:
			case 322:
			case 323:
			case 324:
			case 325:
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
		else if ((LA(1)==TILDE||LA(1)==318)) {
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
		else if ((_tokenSet_33.member(LA(1))) && (_tokenSet_34.member(LA(2))) && (_tokenSet_35.member(LA(3))) && (_tokenSet_36.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
			{
			switch ( LA(1)) {
			case ID:
			{
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case COUNT_EN:
			case COUNT_CN:
			case LITERAL_avg:
			case 104:
			case LITERAL_max:
			case 106:
			case LITERAL_min:
			case 108:
			case LITERAL_stddev:
			case 110:
			case LITERAL_sum:
			case 112:
			case LITERAL_variance:
			case 114:
			{
				aggregate_func();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
				if ((_tokenSet_23.member(LA(1))) && (_tokenSet_38.member(LA(2))) && (_tokenSet_39.member(LA(3))) && (_tokenSet_40.member(LA(4))) && (_tokenSet_41.member(LA(5)))) {
					constant();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_21.member(LA(3))) && (_tokenSet_42.member(LA(4))) && (_tokenSet_43.member(LA(5)))) {
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
			case 162:
			case TILDE:
			case 318:
			case 319:
			case 320:
			case 321:
			case 322:
			case 323:
			case 324:
			case 325:
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
			AST tmp464_AST = null;
			tmp464_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp464_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp465_AST = null;
			tmp465_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp465_AST);
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
		
		AST tmp466_AST = null;
		tmp466_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp466_AST);
		match(ID);
		AST tmp467_AST = null;
		tmp467_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp467_AST);
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
		case LITERAL_pi:
		case 125:
		case LITERAL_now:
		case 127:
		case LITERAL_today:
		case 129:
		case LITERAL_number:
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
		case LITERAL_convert:
		case 132:
		{
			datatype_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			data_type_parameter();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_DATA_TYPE,"function_data_type")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cast:
		case 134:
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
		case LITERAL_rowid:
		case 308:
		{
			rowid_function();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			stable_name();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				function_AST = (AST)currentAST.root;
				function_AST = (AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(FUNCTION_ROWID,"function_rowid")).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (AST)currentAST.root;
			break;
		}
		default:
			if (((LA(1) >= LITERAL_getdate && LA(1) <= LITERAL_rank)) && (LA(2)==LPAREN) && (LA(3)==RPAREN) && (_tokenSet_44.member(LA(4))) && (_tokenSet_45.member(LA(5)))) {
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
			}
			else if ((_tokenSet_46.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_47.member(LA(3))) && (_tokenSet_48.member(LA(4))) && (_tokenSet_45.member(LA(5)))) {
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
			AST tmp481_AST = null;
			tmp481_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp481_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp482_AST = null;
			tmp482_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp482_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp483_AST = null;
			tmp483_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp483_AST);
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
		case LITERAL_year:
		case LITERAL_yy:
		case LITERAL_mm:
		case LITERAL_dd:
		case LITERAL_qq:
		case LITERAL_week:
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
		case NULL_EN:
		{
			AST tmp484_AST = null;
			tmp484_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp484_AST);
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
		case 319:
		{
			AST tmp485_AST = null;
			tmp485_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp485_AST);
			match(319);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 318:
		{
			AST tmp486_AST = null;
			tmp486_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp486_AST);
			match(318);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 320:
		{
			AST tmp487_AST = null;
			tmp487_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp487_AST);
			match(320);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 321:
		{
			AST tmp488_AST = null;
			tmp488_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp488_AST);
			match(321);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 322:
		{
			AST tmp489_AST = null;
			tmp489_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp489_AST);
			match(322);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 323:
		{
			AST tmp490_AST = null;
			tmp490_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp490_AST);
			match(323);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 324:
		{
			AST tmp491_AST = null;
			tmp491_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp491_AST);
			match(324);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 325:
		{
			AST tmp492_AST = null;
			tmp492_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp492_AST);
			match(325);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 162:
		{
			AST tmp493_AST = null;
			tmp493_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp493_AST);
			match(162);
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
				AST tmp494_AST = null;
				tmp494_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp494_AST);
				match(COUNT_EN);
				break;
			}
			case COUNT_CN:
			{
				AST tmp495_AST = null;
				tmp495_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp495_AST);
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
		else if ((_tokenSet_29.member(LA(1))) && (LA(2)==LPAREN) && (_tokenSet_49.member(LA(3)))) {
			aggregate_func_name();
			astFactory.addASTChild(currentAST, returnAST);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ALL_EN:
			{
				AST tmp500_AST = null;
				tmp500_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp500_AST);
				match(ALL_EN);
				break;
			}
			case ALL_CN:
			{
				AST tmp501_AST = null;
				tmp501_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp501_AST);
				match(ALL_CN);
				break;
			}
			case DISTINCT_EN:
			{
				AST tmp502_AST = null;
				tmp502_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp502_AST);
				match(DISTINCT_EN);
				break;
			}
			case DISTINCT_CN:
			{
				AST tmp503_AST = null;
				tmp503_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp503_AST);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_2.member(LA(2))) && (_tokenSet_13.member(LA(3))) && (_tokenSet_50.member(LA(4))) && (_tokenSet_51.member(LA(5)))) {
			AST tmp505_AST = null;
			tmp505_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp505_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp506_AST = null;
			tmp506_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp506_AST);
			match(RPAREN);
			{
			if ((_tokenSet_52.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_53.member(LA(3))) && (_tokenSet_51.member(LA(4))) && (_tokenSet_54.member(LA(5)))) {
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
			else if ((_tokenSet_55.member(LA(1))) && (_tokenSet_51.member(LA(2))) && (_tokenSet_54.member(LA(3))) && (_tokenSet_37.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			expression_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==TILDE||LA(1)==318)) {
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
		else if ((_tokenSet_56.member(LA(1))) && (_tokenSet_53.member(LA(2))) && (_tokenSet_51.member(LA(3))) && (_tokenSet_54.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
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
				if ((_tokenSet_23.member(LA(1))) && (_tokenSet_57.member(LA(2))) && (_tokenSet_51.member(LA(3))) && (_tokenSet_54.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
					constant();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else if ((_tokenSet_20.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_21.member(LA(3))) && (_tokenSet_50.member(LA(4))) && (_tokenSet_51.member(LA(5)))) {
					function();
					astFactory.addASTChild(currentAST, returnAST);
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			if ((_tokenSet_52.member(LA(1))) && (_tokenSet_2.member(LA(2))) && (_tokenSet_53.member(LA(3))) && (_tokenSet_51.member(LA(4))) && (_tokenSet_54.member(LA(5)))) {
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
			else if ((_tokenSet_55.member(LA(1))) && (_tokenSet_51.member(LA(2))) && (_tokenSet_54.member(LA(3))) && (_tokenSet_37.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
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
			AST tmp507_AST = null;
			tmp507_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp507_AST);
			match(TILDE);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 318:
		{
			AST tmp508_AST = null;
			tmp508_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp508_AST);
			match(318);
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
		
		AST tmp509_AST = null;
		tmp509_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp509_AST);
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
		case 72:
		{
			AST tmp510_AST = null;
			tmp510_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp510_AST);
			match(72);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 334:
		{
			AST tmp511_AST = null;
			tmp511_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp511_AST);
			match(334);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 335:
		{
			AST tmp512_AST = null;
			tmp512_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp512_AST);
			match(335);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 336:
		{
			AST tmp513_AST = null;
			tmp513_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp513_AST);
			match(336);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 337:
		{
			AST tmp514_AST = null;
			tmp514_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp514_AST);
			match(337);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 338:
		{
			AST tmp515_AST = null;
			tmp515_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp515_AST);
			match(338);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 339:
		{
			AST tmp516_AST = null;
			tmp516_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp516_AST);
			match(339);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LEFT_JOIN:
		{
			AST tmp517_AST = null;
			tmp517_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp517_AST);
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
		
		if ((LA(1)==LPAREN) && (_tokenSet_23.member(LA(2)))) {
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
			boolean synPredMatched102 = false;
			if (((LA(1)==LPAREN) && (LA(2)==SELECT_EN||LA(2)==SELECT_CN))) {
				int _m102 = mark();
				synPredMatched102 = true;
				inputState.guessing++;
				try {
					{
					subquery();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched102 = false;
				}
				rewind(_m102);
inputState.guessing--;
			}
			if ( synPredMatched102 ) {
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
		
	public final void empty_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST empty_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_getdate:
		{
			AST tmp522_AST = null;
			tmp522_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp522_AST);
			match(LITERAL_getdate);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case 118:
		{
			AST tmp523_AST = null;
			tmp523_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp523_AST);
			match(118);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rand:
		{
			AST tmp524_AST = null;
			tmp524_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp524_AST);
			match(LITERAL_rand);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case 120:
		{
			AST tmp525_AST = null;
			tmp525_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp525_AST);
			match(120);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dense_rank:
		{
			AST tmp526_AST = null;
			tmp526_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp526_AST);
			match(LITERAL_dense_rank);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_percent_rank:
		{
			AST tmp527_AST = null;
			tmp527_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp527_AST);
			match(LITERAL_percent_rank);
			empty_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rank:
		{
			AST tmp528_AST = null;
			tmp528_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp528_AST);
			match(LITERAL_rank);
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
			AST tmp529_AST = null;
			tmp529_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp529_AST);
			match(LITERAL_pi);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 125:
		{
			AST tmp530_AST = null;
			tmp530_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp530_AST);
			match(125);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_now:
		{
			AST tmp531_AST = null;
			tmp531_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp531_AST);
			match(LITERAL_now);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 127:
		{
			AST tmp532_AST = null;
			tmp532_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp532_AST);
			match(127);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_today:
		{
			AST tmp533_AST = null;
			tmp533_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp533_AST);
			match(LITERAL_today);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp534_AST = null;
			tmp534_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp534_AST);
			match(129);
			star_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_number:
		{
			AST tmp535_AST = null;
			tmp535_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp535_AST);
			match(LITERAL_number);
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
	
	public final void datatype_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST datatype_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_convert:
		{
			AST tmp536_AST = null;
			tmp536_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp536_AST);
			match(LITERAL_convert);
			datatype_function_AST = (AST)currentAST.root;
			break;
		}
		case 132:
		{
			AST tmp537_AST = null;
			tmp537_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp537_AST);
			match(132);
			datatype_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = datatype_function_AST;
	}
	
	public final void data_type_parameter() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST data_type_parameter_AST = null;
		
		datatype_constant();
		astFactory.addASTChild(currentAST, returnAST);
		{
		int _cnt93=0;
		_loop93:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp538_AST = null;
				tmp538_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp538_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				if ( _cnt93>=1 ) { break _loop93; } else {throw new NoViableAltException(LT(1), getFilename());}
			}
			
			_cnt93++;
		} while (true);
		}
		data_type_parameter_AST = (AST)currentAST.root;
		returnAST = data_type_parameter_AST;
	}
	
	public final void asdatatype_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST asdatatype_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_cast:
		{
			AST tmp539_AST = null;
			tmp539_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp539_AST);
			match(LITERAL_cast);
			asdatatype_function_AST = (AST)currentAST.root;
			break;
		}
		case 134:
		{
			AST tmp540_AST = null;
			tmp540_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp540_AST);
			match(134);
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
	
	public final void rowid_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST rowid_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_rowid:
		{
			AST tmp543_AST = null;
			tmp543_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp543_AST);
			match(LITERAL_rowid);
			rowid_function_AST = (AST)currentAST.root;
			break;
		}
		case 308:
		{
			AST tmp544_AST = null;
			tmp544_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp544_AST);
			match(308);
			rowid_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = rowid_function_AST;
	}
	
	public final void stable_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST stable_name_AST = null;
		
		AST tmp545_AST = null;
		tmp545_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp545_AST);
		match(ID);
		stable_name_AST = (AST)currentAST.root;
		returnAST = stable_name_AST;
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
		case LITERAL_rand:
		case 120:
		case LITERAL_abs:
		case 136:
		case LITERAL_acos:
		case 138:
		case LITERAL_asin:
		case 140:
		case LITERAL_atan:
		case 142:
		case 143:
		case 144:
		case LITERAL_ceiling:
		case 146:
		case LITERAL_cos:
		case 148:
		case LITERAL_cot:
		case 150:
		case LITERAL_degrees:
		case 152:
		case LITERAL_exp:
		case 154:
		case LITERAL_floor:
		case 156:
		case LITERAL_log:
		case 158:
		case 159:
		case 160:
		case LITERAL_mod:
		case 162:
		case LITERAL_power:
		case 164:
		case LITERAL_radians:
		case 166:
		case LITERAL_remainder:
		case 168:
		case LITERAL_round:
		case 170:
		case LITERAL_sign:
		case 172:
		case LITERAL_sin:
		case 174:
		case LITERAL_sqrt:
		case 176:
		case LITERAL_tan:
		case 178:
		case 179:
		case LITERAL_truncnum:
		case 181:
		{
			number_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case CHAR:
		case LITERAL_ascii:
		case 183:
		case LITERAL_bit_length:
		case 185:
		case LITERAL_byte_length:
		case 187:
		case 188:
		case LITERAL_char_length:
		case 190:
		case LITERAL_charindex:
		case 192:
		case LITERAL_difference:
		case 194:
		case LITERAL_insertstr:
		case 196:
		case LITERAL_lcase:
		case 198:
		case LITERAL_left:
		case 200:
		case LITERAL_length:
		case 202:
		case LITERAL_locate:
		case 204:
		case LITERAL_lower:
		case 206:
		case LITERAL_ltrim:
		case 208:
		case LITERAL_octet_length:
		case 210:
		case LITERAL_patindex:
		case 212:
		case LITERAL_repeat:
		case 214:
		case LITERAL_replace:
		case 216:
		case LITERAL_replicate:
		case 218:
		case LITERAL_right:
		case 220:
		case LITERAL_rtrim:
		case 222:
		case LITERAL_similar:
		case 224:
		case LITERAL_sortkey:
		case 226:
		case LITERAL_soundex:
		case 228:
		case LITERAL_space:
		case 230:
		case LITERAL_str:
		case 232:
		case LITERAL_string:
		case 234:
		case LITERAL_stuff:
		case 236:
		case LITERAL_substring:
		case 238:
		case LITERAL_trim:
		case 240:
		case LITERAL_ucase:
		case 242:
		case LITERAL_upper:
		case 244:
		{
			string_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateformat:
		case 246:
		case LITERAL_datename:
		case 248:
		case LITERAL_datepart:
		case 250:
		case LITERAL_datetime:
		case 252:
		case LITERAL_date:
		case 254:
		case LITERAL_dayname:
		case 256:
		case LITERAL_days:
		case 258:
		case LITERAL_day:
		case 260:
		case LITERAL_dow:
		case 262:
		case LITERAL_hours:
		case 264:
		case LITERAL_hour:
		case 266:
		case LITERAL_minutes:
		case 268:
		case LITERAL_minute:
		case 270:
		case LITERAL_monthname:
		case 272:
		case LITERAL_months:
		case 274:
		case LITERAL_month:
		case 276:
		case LITERAL_quarter:
		case 278:
		case LITERAL_seconds:
		case 280:
		case LITERAL_second:
		case 282:
		case LITERAL_weeks:
		case 284:
		case LITERAL_years:
		case 286:
		case LITERAL_year:
		case 288:
		case LITERAL_ymd:
		case 290:
		case LITERAL_dateadd:
		case 292:
		case LITERAL_datediff:
		case 294:
		{
			datetime_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hextoint:
		case 296:
		case LITERAL_inttohex:
		case 298:
		case LITERAL_isdate:
		case 300:
		case LITERAL_isnumeric:
		case 302:
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
		case LITERAL_ntile:
		case LITERAL_percentile_count:
		case LITERAL_percentile_desc:
		{
			analytical_function();
			astFactory.addASTChild(currentAST, returnAST);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_argn:
		case LITERAL_coalesce:
		case LITERAL_ifnull:
		case LITERAL_isnull:
		case LITERAL_nullif:
		{
			miscellane_function();
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
		_loop87:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp546_AST = null;
				tmp546_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp546_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop87;
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
			AST tmp547_AST = null;
			tmp547_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp547_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 104:
		{
			AST tmp548_AST = null;
			tmp548_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp548_AST);
			match(104);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_EN:
		{
			AST tmp549_AST = null;
			tmp549_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp549_AST);
			match(COUNT_EN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case COUNT_CN:
		{
			AST tmp550_AST = null;
			tmp550_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp550_AST);
			match(COUNT_CN);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp551_AST = null;
			tmp551_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp551_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 106:
		{
			AST tmp552_AST = null;
			tmp552_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp552_AST);
			match(106);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp553_AST = null;
			tmp553_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp553_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 108:
		{
			AST tmp554_AST = null;
			tmp554_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp554_AST);
			match(108);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_stddev:
		{
			AST tmp555_AST = null;
			tmp555_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp555_AST);
			match(LITERAL_stddev);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 110:
		{
			AST tmp556_AST = null;
			tmp556_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp556_AST);
			match(110);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sum:
		{
			AST tmp557_AST = null;
			tmp557_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp557_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 112:
		{
			AST tmp558_AST = null;
			tmp558_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp558_AST);
			match(112);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_variance:
		{
			AST tmp559_AST = null;
			tmp559_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp559_AST);
			match(LITERAL_variance);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 114:
		{
			AST tmp560_AST = null;
			tmp560_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp560_AST);
			match(114);
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
		
		if ((_tokenSet_58.member(LA(1)))) {
			data_type_word();
			astFactory.addASTChild(currentAST, returnAST);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==CHAR) && (LA(2)==COMMA||LA(2)==RPAREN)) {
			AST tmp561_AST = null;
			tmp561_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp561_AST);
			match(CHAR);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==CHAR) && (LA(2)==LPAREN)) {
			AST tmp562_AST = null;
			tmp562_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp562_AST);
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
			AST tmp565_AST = null;
			tmp565_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp565_AST);
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
			AST tmp568_AST = null;
			tmp568_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp568_AST);
			match(DATA_TYPE_STRING);
			datatype_constant_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = datatype_constant_AST;
	}
	
	public final void data_type_word() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST data_type_word_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_uniqueidentifierstr:
		{
			AST tmp569_AST = null;
			tmp569_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp569_AST);
			match(LITERAL_uniqueidentifierstr);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bigint:
		{
			AST tmp570_AST = null;
			tmp570_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp570_AST);
			match(LITERAL_bigint);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_int:
		{
			AST tmp571_AST = null;
			tmp571_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp571_AST);
			match(LITERAL_int);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_integer:
		{
			AST tmp572_AST = null;
			tmp572_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp572_AST);
			match(LITERAL_integer);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_smallint:
		{
			AST tmp573_AST = null;
			tmp573_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp573_AST);
			match(LITERAL_smallint);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tinyint:
		{
			AST tmp574_AST = null;
			tmp574_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp574_AST);
			match(LITERAL_tinyint);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_double:
		{
			AST tmp575_AST = null;
			tmp575_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp575_AST);
			match(LITERAL_double);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_real:
		{
			AST tmp576_AST = null;
			tmp576_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp576_AST);
			match(LITERAL_real);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp577_AST = null;
			tmp577_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp577_AST);
			match(LITERAL_date);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datetime:
		{
			AST tmp578_AST = null;
			tmp578_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp578_AST);
			match(LITERAL_datetime);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_smalldatetime:
		{
			AST tmp579_AST = null;
			tmp579_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp579_AST);
			match(LITERAL_smalldatetime);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_time:
		{
			AST tmp580_AST = null;
			tmp580_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp580_AST);
			match(LITERAL_time);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_timestamp:
		{
			AST tmp581_AST = null;
			tmp581_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp581_AST);
			match(LITERAL_timestamp);
			data_type_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bit:
		{
			AST tmp582_AST = null;
			tmp582_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp582_AST);
			match(LITERAL_bit);
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
			AST tmp583_AST = null;
			tmp583_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp583_AST);
			match(REAL_NUM);
			AST tmp584_AST = null;
			tmp584_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp584_AST);
			match(COMMA);
			AST tmp585_AST = null;
			tmp585_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp585_AST);
			match(REAL_NUM);
			datatype_precision_or_scale_or_maxlength_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==REAL_NUM) && (LA(2)==RPAREN)) {
			AST tmp586_AST = null;
			tmp586_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp586_AST);
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
		_loop105:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp587_AST = null;
				tmp587_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp587_AST);
				match(COMMA);
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop105;
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
		
		if ((LA(1)==ID) && (LA(2)==LPAREN) && (LA(3)==ID) && (LA(4)==RPAREN) && (_tokenSet_44.member(LA(5)))) {
			AST tmp588_AST = null;
			tmp588_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp588_AST);
			match(ID);
			match(LPAREN);
			AST tmp590_AST = null;
			tmp590_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp590_AST);
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
		else if ((LA(1)==ID) && (_tokenSet_44.member(LA(2))) && (_tokenSet_45.member(LA(3))) && (_tokenSet_36.member(LA(4))) && (_tokenSet_37.member(LA(5)))) {
			AST tmp592_AST = null;
			tmp592_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp592_AST);
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
			AST tmp593_AST = null;
			tmp593_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp593_AST);
			match(LITERAL_year);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_yy:
		{
			AST tmp594_AST = null;
			tmp594_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp594_AST);
			match(LITERAL_yy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp595_AST = null;
			tmp595_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp595_AST);
			match(LITERAL_month);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mm:
		{
			AST tmp596_AST = null;
			tmp596_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp596_AST);
			match(LITERAL_mm);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp597_AST = null;
			tmp597_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp597_AST);
			match(LITERAL_day);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dd:
		{
			AST tmp598_AST = null;
			tmp598_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp598_AST);
			match(LITERAL_dd);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp599_AST = null;
			tmp599_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp599_AST);
			match(LITERAL_quarter);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_qq:
		{
			AST tmp600_AST = null;
			tmp600_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp600_AST);
			match(LITERAL_qq);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_week:
		{
			AST tmp601_AST = null;
			tmp601_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp601_AST);
			match(LITERAL_week);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_wk:
		{
			AST tmp602_AST = null;
			tmp602_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp602_AST);
			match(LITERAL_wk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayofyear:
		{
			AST tmp603_AST = null;
			tmp603_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp603_AST);
			match(LITERAL_dayofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dy:
		{
			AST tmp604_AST = null;
			tmp604_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp604_AST);
			match(LITERAL_dy);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weekday:
		{
			AST tmp605_AST = null;
			tmp605_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp605_AST);
			match(LITERAL_weekday);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dw:
		{
			AST tmp606_AST = null;
			tmp606_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp606_AST);
			match(LITERAL_dw);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp607_AST = null;
			tmp607_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp607_AST);
			match(LITERAL_hour);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hh:
		{
			AST tmp608_AST = null;
			tmp608_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp608_AST);
			match(LITERAL_hh);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp609_AST = null;
			tmp609_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp609_AST);
			match(LITERAL_minute);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mi:
		{
			AST tmp610_AST = null;
			tmp610_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp610_AST);
			match(LITERAL_mi);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp611_AST = null;
			tmp611_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp611_AST);
			match(LITERAL_second);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ss:
		{
			AST tmp612_AST = null;
			tmp612_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp612_AST);
			match(LITERAL_ss);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_millisecond:
		{
			AST tmp613_AST = null;
			tmp613_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp613_AST);
			match(LITERAL_millisecond);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ms:
		{
			AST tmp614_AST = null;
			tmp614_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp614_AST);
			match(LITERAL_ms);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_calweekofyear:
		{
			AST tmp615_AST = null;
			tmp615_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp615_AST);
			match(LITERAL_calweekofyear);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cwk:
		{
			AST tmp616_AST = null;
			tmp616_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp616_AST);
			match(LITERAL_cwk);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_calyearofweek:
		{
			AST tmp617_AST = null;
			tmp617_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp617_AST);
			match(LITERAL_calyearofweek);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cyr:
		{
			AST tmp618_AST = null;
			tmp618_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp618_AST);
			match(LITERAL_cyr);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_caldayofweek:
		{
			AST tmp619_AST = null;
			tmp619_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp619_AST);
			match(LITERAL_caldayofweek);
			date_key_word_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cdw:
		{
			AST tmp620_AST = null;
			tmp620_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp620_AST);
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
	
	public final void nothing_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST nothing_function_AST = null;
		
		switch ( LA(1)) {
		case SYSDATE_EN:
		{
			AST tmp621_AST = null;
			tmp621_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp621_AST);
			match(SYSDATE_EN);
			nothing_function_AST = (AST)currentAST.root;
			break;
		}
		case SYSDATE_CN:
		{
			AST tmp622_AST = null;
			tmp622_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp622_AST);
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
	
	public final void number_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST number_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_abs:
		{
			AST tmp623_AST = null;
			tmp623_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp623_AST);
			match(LITERAL_abs);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 136:
		{
			AST tmp624_AST = null;
			tmp624_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp624_AST);
			match(136);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_acos:
		{
			AST tmp625_AST = null;
			tmp625_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp625_AST);
			match(LITERAL_acos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 138:
		{
			AST tmp626_AST = null;
			tmp626_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp626_AST);
			match(138);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_asin:
		{
			AST tmp627_AST = null;
			tmp627_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp627_AST);
			match(LITERAL_asin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 140:
		{
			AST tmp628_AST = null;
			tmp628_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp628_AST);
			match(140);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_atan:
		{
			AST tmp629_AST = null;
			tmp629_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp629_AST);
			match(LITERAL_atan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 142:
		{
			AST tmp630_AST = null;
			tmp630_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp630_AST);
			match(142);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 143:
		{
			AST tmp631_AST = null;
			tmp631_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp631_AST);
			match(143);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 144:
		{
			AST tmp632_AST = null;
			tmp632_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp632_AST);
			match(144);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceiling:
		{
			AST tmp633_AST = null;
			tmp633_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp633_AST);
			match(LITERAL_ceiling);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 146:
		{
			AST tmp634_AST = null;
			tmp634_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp634_AST);
			match(146);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cos:
		{
			AST tmp635_AST = null;
			tmp635_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp635_AST);
			match(LITERAL_cos);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 148:
		{
			AST tmp636_AST = null;
			tmp636_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp636_AST);
			match(148);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_cot:
		{
			AST tmp637_AST = null;
			tmp637_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp637_AST);
			match(LITERAL_cot);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 150:
		{
			AST tmp638_AST = null;
			tmp638_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp638_AST);
			match(150);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_degrees:
		{
			AST tmp639_AST = null;
			tmp639_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp639_AST);
			match(LITERAL_degrees);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 152:
		{
			AST tmp640_AST = null;
			tmp640_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp640_AST);
			match(152);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exp:
		{
			AST tmp641_AST = null;
			tmp641_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp641_AST);
			match(LITERAL_exp);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 154:
		{
			AST tmp642_AST = null;
			tmp642_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp642_AST);
			match(154);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp643_AST = null;
			tmp643_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp643_AST);
			match(LITERAL_floor);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 156:
		{
			AST tmp644_AST = null;
			tmp644_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp644_AST);
			match(156);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_log:
		{
			AST tmp645_AST = null;
			tmp645_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp645_AST);
			match(LITERAL_log);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 158:
		{
			AST tmp646_AST = null;
			tmp646_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp646_AST);
			match(158);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 159:
		{
			AST tmp647_AST = null;
			tmp647_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp647_AST);
			match(159);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 160:
		{
			AST tmp648_AST = null;
			tmp648_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp648_AST);
			match(160);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_mod:
		{
			AST tmp649_AST = null;
			tmp649_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp649_AST);
			match(LITERAL_mod);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 162:
		{
			AST tmp650_AST = null;
			tmp650_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp650_AST);
			match(162);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_power:
		{
			AST tmp651_AST = null;
			tmp651_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp651_AST);
			match(LITERAL_power);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 164:
		{
			AST tmp652_AST = null;
			tmp652_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp652_AST);
			match(164);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_radians:
		{
			AST tmp653_AST = null;
			tmp653_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp653_AST);
			match(LITERAL_radians);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 166:
		{
			AST tmp654_AST = null;
			tmp654_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp654_AST);
			match(166);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rand:
		{
			AST tmp655_AST = null;
			tmp655_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp655_AST);
			match(LITERAL_rand);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 120:
		{
			AST tmp656_AST = null;
			tmp656_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp656_AST);
			match(120);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_remainder:
		{
			AST tmp657_AST = null;
			tmp657_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp657_AST);
			match(LITERAL_remainder);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 168:
		{
			AST tmp658_AST = null;
			tmp658_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp658_AST);
			match(168);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp659_AST = null;
			tmp659_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp659_AST);
			match(LITERAL_round);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 170:
		{
			AST tmp660_AST = null;
			tmp660_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp660_AST);
			match(170);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sign:
		{
			AST tmp661_AST = null;
			tmp661_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp661_AST);
			match(LITERAL_sign);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 172:
		{
			AST tmp662_AST = null;
			tmp662_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp662_AST);
			match(172);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sin:
		{
			AST tmp663_AST = null;
			tmp663_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp663_AST);
			match(LITERAL_sin);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 174:
		{
			AST tmp664_AST = null;
			tmp664_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp664_AST);
			match(174);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sqrt:
		{
			AST tmp665_AST = null;
			tmp665_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp665_AST);
			match(LITERAL_sqrt);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 176:
		{
			AST tmp666_AST = null;
			tmp666_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp666_AST);
			match(176);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_tan:
		{
			AST tmp667_AST = null;
			tmp667_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp667_AST);
			match(LITERAL_tan);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 178:
		{
			AST tmp668_AST = null;
			tmp668_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp668_AST);
			match(178);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 179:
		{
			AST tmp669_AST = null;
			tmp669_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp669_AST);
			match(179);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_truncnum:
		{
			AST tmp670_AST = null;
			tmp670_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp670_AST);
			match(LITERAL_truncnum);
			number_function_AST = (AST)currentAST.root;
			break;
		}
		case 181:
		{
			AST tmp671_AST = null;
			tmp671_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp671_AST);
			match(181);
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
			AST tmp672_AST = null;
			tmp672_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp672_AST);
			match(LITERAL_ascii);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 183:
		{
			AST tmp673_AST = null;
			tmp673_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp673_AST);
			match(183);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_bit_length:
		{
			AST tmp674_AST = null;
			tmp674_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp674_AST);
			match(LITERAL_bit_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 185:
		{
			AST tmp675_AST = null;
			tmp675_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp675_AST);
			match(185);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_byte_length:
		{
			AST tmp676_AST = null;
			tmp676_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp676_AST);
			match(LITERAL_byte_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 187:
		{
			AST tmp677_AST = null;
			tmp677_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp677_AST);
			match(187);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case CHAR:
		{
			AST tmp678_AST = null;
			tmp678_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp678_AST);
			match(CHAR);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 188:
		{
			AST tmp679_AST = null;
			tmp679_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp679_AST);
			match(188);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char_length:
		{
			AST tmp680_AST = null;
			tmp680_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp680_AST);
			match(LITERAL_char_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 190:
		{
			AST tmp681_AST = null;
			tmp681_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp681_AST);
			match(190);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_charindex:
		{
			AST tmp682_AST = null;
			tmp682_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp682_AST);
			match(LITERAL_charindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 192:
		{
			AST tmp683_AST = null;
			tmp683_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp683_AST);
			match(192);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_difference:
		{
			AST tmp684_AST = null;
			tmp684_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp684_AST);
			match(LITERAL_difference);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 194:
		{
			AST tmp685_AST = null;
			tmp685_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp685_AST);
			match(194);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_insertstr:
		{
			AST tmp686_AST = null;
			tmp686_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp686_AST);
			match(LITERAL_insertstr);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 196:
		{
			AST tmp687_AST = null;
			tmp687_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp687_AST);
			match(196);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lcase:
		{
			AST tmp688_AST = null;
			tmp688_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp688_AST);
			match(LITERAL_lcase);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 198:
		{
			AST tmp689_AST = null;
			tmp689_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp689_AST);
			match(198);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_left:
		{
			AST tmp690_AST = null;
			tmp690_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp690_AST);
			match(LITERAL_left);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 200:
		{
			AST tmp691_AST = null;
			tmp691_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp691_AST);
			match(200);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_length:
		{
			AST tmp692_AST = null;
			tmp692_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp692_AST);
			match(LITERAL_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 202:
		{
			AST tmp693_AST = null;
			tmp693_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp693_AST);
			match(202);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_locate:
		{
			AST tmp694_AST = null;
			tmp694_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp694_AST);
			match(LITERAL_locate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 204:
		{
			AST tmp695_AST = null;
			tmp695_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp695_AST);
			match(204);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp696_AST = null;
			tmp696_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp696_AST);
			match(LITERAL_lower);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 206:
		{
			AST tmp697_AST = null;
			tmp697_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp697_AST);
			match(206);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp698_AST = null;
			tmp698_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp698_AST);
			match(LITERAL_ltrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 208:
		{
			AST tmp699_AST = null;
			tmp699_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp699_AST);
			match(208);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_octet_length:
		{
			AST tmp700_AST = null;
			tmp700_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp700_AST);
			match(LITERAL_octet_length);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 210:
		{
			AST tmp701_AST = null;
			tmp701_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp701_AST);
			match(210);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_patindex:
		{
			AST tmp702_AST = null;
			tmp702_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp702_AST);
			match(LITERAL_patindex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 212:
		{
			AST tmp703_AST = null;
			tmp703_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp703_AST);
			match(212);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_repeat:
		{
			AST tmp704_AST = null;
			tmp704_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp704_AST);
			match(LITERAL_repeat);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 214:
		{
			AST tmp705_AST = null;
			tmp705_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp705_AST);
			match(214);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replace:
		{
			AST tmp706_AST = null;
			tmp706_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp706_AST);
			match(LITERAL_replace);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 216:
		{
			AST tmp707_AST = null;
			tmp707_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp707_AST);
			match(216);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_replicate:
		{
			AST tmp708_AST = null;
			tmp708_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp708_AST);
			match(LITERAL_replicate);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 218:
		{
			AST tmp709_AST = null;
			tmp709_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp709_AST);
			match(218);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_right:
		{
			AST tmp710_AST = null;
			tmp710_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp710_AST);
			match(LITERAL_right);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 220:
		{
			AST tmp711_AST = null;
			tmp711_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp711_AST);
			match(220);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp712_AST = null;
			tmp712_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp712_AST);
			match(LITERAL_rtrim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 222:
		{
			AST tmp713_AST = null;
			tmp713_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp713_AST);
			match(222);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_similar:
		{
			AST tmp714_AST = null;
			tmp714_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp714_AST);
			match(LITERAL_similar);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 224:
		{
			AST tmp715_AST = null;
			tmp715_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp715_AST);
			match(224);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_sortkey:
		{
			AST tmp716_AST = null;
			tmp716_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp716_AST);
			match(LITERAL_sortkey);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 226:
		{
			AST tmp717_AST = null;
			tmp717_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp717_AST);
			match(226);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_soundex:
		{
			AST tmp718_AST = null;
			tmp718_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp718_AST);
			match(LITERAL_soundex);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 228:
		{
			AST tmp719_AST = null;
			tmp719_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp719_AST);
			match(228);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_space:
		{
			AST tmp720_AST = null;
			tmp720_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp720_AST);
			match(LITERAL_space);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 230:
		{
			AST tmp721_AST = null;
			tmp721_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp721_AST);
			match(230);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_str:
		{
			AST tmp722_AST = null;
			tmp722_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp722_AST);
			match(LITERAL_str);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 232:
		{
			AST tmp723_AST = null;
			tmp723_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp723_AST);
			match(232);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_string:
		{
			AST tmp724_AST = null;
			tmp724_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp724_AST);
			match(LITERAL_string);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 234:
		{
			AST tmp725_AST = null;
			tmp725_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp725_AST);
			match(234);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_stuff:
		{
			AST tmp726_AST = null;
			tmp726_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp726_AST);
			match(LITERAL_stuff);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 236:
		{
			AST tmp727_AST = null;
			tmp727_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp727_AST);
			match(236);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substring:
		{
			AST tmp728_AST = null;
			tmp728_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp728_AST);
			match(LITERAL_substring);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 238:
		{
			AST tmp729_AST = null;
			tmp729_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp729_AST);
			match(238);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_trim:
		{
			AST tmp730_AST = null;
			tmp730_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp730_AST);
			match(LITERAL_trim);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 240:
		{
			AST tmp731_AST = null;
			tmp731_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp731_AST);
			match(240);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ucase:
		{
			AST tmp732_AST = null;
			tmp732_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp732_AST);
			match(LITERAL_ucase);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 242:
		{
			AST tmp733_AST = null;
			tmp733_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp733_AST);
			match(242);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_upper:
		{
			AST tmp734_AST = null;
			tmp734_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp734_AST);
			match(LITERAL_upper);
			string_function_AST = (AST)currentAST.root;
			break;
		}
		case 244:
		{
			AST tmp735_AST = null;
			tmp735_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp735_AST);
			match(244);
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
			AST tmp736_AST = null;
			tmp736_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp736_AST);
			match(LITERAL_dateformat);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 246:
		{
			AST tmp737_AST = null;
			tmp737_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp737_AST);
			match(246);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datename:
		{
			AST tmp738_AST = null;
			tmp738_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp738_AST);
			match(LITERAL_datename);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 248:
		{
			AST tmp739_AST = null;
			tmp739_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp739_AST);
			match(248);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datepart:
		{
			AST tmp740_AST = null;
			tmp740_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp740_AST);
			match(LITERAL_datepart);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 250:
		{
			AST tmp741_AST = null;
			tmp741_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp741_AST);
			match(250);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datetime:
		{
			AST tmp742_AST = null;
			tmp742_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp742_AST);
			match(LITERAL_datetime);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 252:
		{
			AST tmp743_AST = null;
			tmp743_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp743_AST);
			match(252);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_date:
		{
			AST tmp744_AST = null;
			tmp744_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp744_AST);
			match(LITERAL_date);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 254:
		{
			AST tmp745_AST = null;
			tmp745_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp745_AST);
			match(254);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dayname:
		{
			AST tmp746_AST = null;
			tmp746_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp746_AST);
			match(LITERAL_dayname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 256:
		{
			AST tmp747_AST = null;
			tmp747_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp747_AST);
			match(256);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_days:
		{
			AST tmp748_AST = null;
			tmp748_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp748_AST);
			match(LITERAL_days);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 258:
		{
			AST tmp749_AST = null;
			tmp749_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp749_AST);
			match(258);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_day:
		{
			AST tmp750_AST = null;
			tmp750_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp750_AST);
			match(LITERAL_day);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 260:
		{
			AST tmp751_AST = null;
			tmp751_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp751_AST);
			match(260);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dow:
		{
			AST tmp752_AST = null;
			tmp752_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp752_AST);
			match(LITERAL_dow);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 262:
		{
			AST tmp753_AST = null;
			tmp753_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp753_AST);
			match(262);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hours:
		{
			AST tmp754_AST = null;
			tmp754_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp754_AST);
			match(LITERAL_hours);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 264:
		{
			AST tmp755_AST = null;
			tmp755_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp755_AST);
			match(264);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_hour:
		{
			AST tmp756_AST = null;
			tmp756_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp756_AST);
			match(LITERAL_hour);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 266:
		{
			AST tmp757_AST = null;
			tmp757_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp757_AST);
			match(266);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minutes:
		{
			AST tmp758_AST = null;
			tmp758_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp758_AST);
			match(LITERAL_minutes);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 268:
		{
			AST tmp759_AST = null;
			tmp759_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp759_AST);
			match(268);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_minute:
		{
			AST tmp760_AST = null;
			tmp760_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp760_AST);
			match(LITERAL_minute);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 270:
		{
			AST tmp761_AST = null;
			tmp761_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp761_AST);
			match(270);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_monthname:
		{
			AST tmp762_AST = null;
			tmp762_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp762_AST);
			match(LITERAL_monthname);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 272:
		{
			AST tmp763_AST = null;
			tmp763_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp763_AST);
			match(272);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_months:
		{
			AST tmp764_AST = null;
			tmp764_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp764_AST);
			match(LITERAL_months);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 274:
		{
			AST tmp765_AST = null;
			tmp765_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp765_AST);
			match(274);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_month:
		{
			AST tmp766_AST = null;
			tmp766_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp766_AST);
			match(LITERAL_month);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 276:
		{
			AST tmp767_AST = null;
			tmp767_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp767_AST);
			match(276);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_quarter:
		{
			AST tmp768_AST = null;
			tmp768_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp768_AST);
			match(LITERAL_quarter);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 278:
		{
			AST tmp769_AST = null;
			tmp769_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp769_AST);
			match(278);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_seconds:
		{
			AST tmp770_AST = null;
			tmp770_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp770_AST);
			match(LITERAL_seconds);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 280:
		{
			AST tmp771_AST = null;
			tmp771_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp771_AST);
			match(280);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_second:
		{
			AST tmp772_AST = null;
			tmp772_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp772_AST);
			match(LITERAL_second);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 282:
		{
			AST tmp773_AST = null;
			tmp773_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp773_AST);
			match(282);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_weeks:
		{
			AST tmp774_AST = null;
			tmp774_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp774_AST);
			match(LITERAL_weeks);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 284:
		{
			AST tmp775_AST = null;
			tmp775_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp775_AST);
			match(284);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_years:
		{
			AST tmp776_AST = null;
			tmp776_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp776_AST);
			match(LITERAL_years);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 286:
		{
			AST tmp777_AST = null;
			tmp777_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp777_AST);
			match(286);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_year:
		{
			AST tmp778_AST = null;
			tmp778_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp778_AST);
			match(LITERAL_year);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 288:
		{
			AST tmp779_AST = null;
			tmp779_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp779_AST);
			match(288);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ymd:
		{
			AST tmp780_AST = null;
			tmp780_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp780_AST);
			match(LITERAL_ymd);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 290:
		{
			AST tmp781_AST = null;
			tmp781_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp781_AST);
			match(290);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_dateadd:
		{
			AST tmp782_AST = null;
			tmp782_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp782_AST);
			match(LITERAL_dateadd);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 292:
		{
			AST tmp783_AST = null;
			tmp783_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp783_AST);
			match(292);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_datediff:
		{
			AST tmp784_AST = null;
			tmp784_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp784_AST);
			match(LITERAL_datediff);
			datetime_function_AST = (AST)currentAST.root;
			break;
		}
		case 294:
		{
			AST tmp785_AST = null;
			tmp785_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp785_AST);
			match(294);
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
		case LITERAL_hextoint:
		{
			AST tmp786_AST = null;
			tmp786_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp786_AST);
			match(LITERAL_hextoint);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 296:
		{
			AST tmp787_AST = null;
			tmp787_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp787_AST);
			match(296);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_inttohex:
		{
			AST tmp788_AST = null;
			tmp788_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp788_AST);
			match(LITERAL_inttohex);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 298:
		{
			AST tmp789_AST = null;
			tmp789_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp789_AST);
			match(298);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isdate:
		{
			AST tmp790_AST = null;
			tmp790_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp790_AST);
			match(LITERAL_isdate);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 300:
		{
			AST tmp791_AST = null;
			tmp791_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp791_AST);
			match(300);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isnumeric:
		{
			AST tmp792_AST = null;
			tmp792_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp792_AST);
			match(LITERAL_isnumeric);
			conversion_function_AST = (AST)currentAST.root;
			break;
		}
		case 302:
		{
			AST tmp793_AST = null;
			tmp793_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp793_AST);
			match(302);
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
			AST tmp794_AST = null;
			tmp794_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp794_AST);
			match(LITERAL_suser_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_suser_name:
		{
			AST tmp795_AST = null;
			tmp795_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp795_AST);
			match(LITERAL_suser_name);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_id:
		{
			AST tmp796_AST = null;
			tmp796_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp796_AST);
			match(LITERAL_user_id);
			system_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_user_name:
		{
			AST tmp797_AST = null;
			tmp797_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp797_AST);
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
	
	public final void analytical_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST analytical_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_ntile:
		{
			AST tmp798_AST = null;
			tmp798_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp798_AST);
			match(LITERAL_ntile);
			analytical_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_percentile_count:
		{
			AST tmp799_AST = null;
			tmp799_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp799_AST);
			match(LITERAL_percentile_count);
			analytical_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_percentile_desc:
		{
			AST tmp800_AST = null;
			tmp800_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp800_AST);
			match(LITERAL_percentile_desc);
			analytical_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = analytical_function_AST;
	}
	
	public final void miscellane_function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST miscellane_function_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_argn:
		{
			AST tmp801_AST = null;
			tmp801_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp801_AST);
			match(LITERAL_argn);
			miscellane_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_coalesce:
		{
			AST tmp802_AST = null;
			tmp802_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp802_AST);
			match(LITERAL_coalesce);
			miscellane_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ifnull:
		{
			AST tmp803_AST = null;
			tmp803_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp803_AST);
			match(LITERAL_ifnull);
			miscellane_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_isnull:
		{
			AST tmp804_AST = null;
			tmp804_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp804_AST);
			match(LITERAL_isnull);
			miscellane_function_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_nullif:
		{
			AST tmp805_AST = null;
			tmp805_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp805_AST);
			match(LITERAL_nullif);
			miscellane_function_AST = (AST)currentAST.root;
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		returnAST = miscellane_function_AST;
	}
	
	public final void arithmeticOperator() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST arithmeticOperator_AST = null;
		
		switch ( LA(1)) {
		case PLUS:
		{
			AST tmp806_AST = null;
			tmp806_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp806_AST);
			match(PLUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp807_AST = null;
			tmp807_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp807_AST);
			match(MINUS);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp808_AST = null;
			tmp808_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp808_AST);
			match(STAR);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case DIVIDE:
		{
			AST tmp809_AST = null;
			tmp809_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp809_AST);
			match(DIVIDE);
			arithmeticOperator_AST = (AST)currentAST.root;
			break;
		}
		case MOD:
		{
			AST tmp810_AST = null;
			tmp810_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp810_AST);
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
			AST tmp811_AST = null;
			tmp811_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp811_AST);
			match(AMPERSAND);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case TILDE:
		{
			AST tmp812_AST = null;
			tmp812_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp812_AST);
			match(TILDE);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEOR:
		{
			AST tmp813_AST = null;
			tmp813_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp813_AST);
			match(BITWISEOR);
			bitwiseOperator_AST = (AST)currentAST.root;
			break;
		}
		case BITWISEXOR:
		{
			AST tmp814_AST = null;
			tmp814_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp814_AST);
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
			AST tmp815_AST = null;
			tmp815_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp815_AST);
			match(ASSIGNEQUAL);
			alias_equ_op_AST = (AST)currentAST.root;
			break;
		}
		case 72:
		{
			AST tmp816_AST = null;
			tmp816_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp816_AST);
			match(72);
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
			AST tmp817_AST = null;
			tmp817_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp817_AST);
			match(ASSIGNEQUAL);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL1:
		{
			AST tmp818_AST = null;
			tmp818_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp818_AST);
			match(NOTEQUAL1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case NOTEQUAL2:
		{
			AST tmp819_AST = null;
			tmp819_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp819_AST);
			match(NOTEQUAL2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO1:
		{
			AST tmp820_AST = null;
			tmp820_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp820_AST);
			match(LESSTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHANOREQUALTO2:
		{
			AST tmp821_AST = null;
			tmp821_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp821_AST);
			match(LESSTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case LESSTHAN:
		{
			AST tmp822_AST = null;
			tmp822_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp822_AST);
			match(LESSTHAN);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO1:
		{
			AST tmp823_AST = null;
			tmp823_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp823_AST);
			match(GREATERTHANOREQUALTO1);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHANOREQUALTO2:
		{
			AST tmp824_AST = null;
			tmp824_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp824_AST);
			match(GREATERTHANOREQUALTO2);
			comparisonOperator_AST = (AST)currentAST.root;
			break;
		}
		case GREATERTHAN:
		{
			AST tmp825_AST = null;
			tmp825_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp825_AST);
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
		"FUNCTION_ROWID",
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
		"\"top\"",
		"\"\\u524dN\\u6761\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"\"group\"",
		"\"by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order\"",
		"\"\\u6392\\u5e8f\"",
		"REAL_NUM",
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
		"\"\\u6c42\\u65b9\\u5dee\"",
		"\"sum\"",
		"\"\\u6c42\\u603b\\u548c\"",
		"\"variance\"",
		"\"\\u6c42\\u7edf\\u8ba1\\u65b9\\u5dee\"",
		"\"SYSDATE\"",
		"\"\\u53d6\\u7cfb\\u7edf\\u65e5\\u671f\"",
		"\"getdate\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f42\"",
		"\"rand\"",
		"\"\\u53d6\\u968f\\u673a\\u6570\"",
		"\"dense_rank\"",
		"\"percent_rank\"",
		"\"rank\"",
		"\"pi\"",
		"\"\\u6c42\\u5706\\u5468\\u7387\"",
		"\"now\"",
		"\"\\u53d6\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f41\"",
		"\"today\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\"",
		"\"number\"",
		"\"convert\"",
		"\"\\u6570\\u636e\\u7c7b\\u578b\\u8f6c\\u6362\"",
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
		"\"ceiling\"",
		"\"\\u53d6\\u4e0a\\u9650\\u6574\\u6570\"",
		"\"cos\"",
		"\"\\u6c42\\u4f59\\u5f26\\u503c\"",
		"\"cot\"",
		"\"\\u6c42\\u4f59\\u5207\\u503c\"",
		"\"degrees\"",
		"\"\\u5f27\\u5ea6\\u8f6c\\u5ea6\\u6570\"",
		"\"exp\"",
		"\"\\u6c42\\u5e42\\u503c\"",
		"\"floor\"",
		"\"\\u53d6\\u4e0b\\u9650\\u6574\\u6570\"",
		"\"log\"",
		"\"\\u6c42\\u81ea\\u7136\\u5bf9\\u6570\"",
		"\"log10\"",
		"\"\\u6c4210\\u4e3a\\u5e95\\u7684\\u5bf9\\u6570\"",
		"\"mod\"",
		"\"\\u6c42\\u6a21\"",
		"\"power\"",
		"\"\\u6c42\\u5e42\"",
		"\"radians\"",
		"\"\\u5ea6\\u6570\\u8f6c\\u5f27\\u5ea6\"",
		"\"remainder\"",
		"\"\\u6c42\\u4f59\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"sign\"",
		"\"\\u6c42\\u503c\\u7684\\u7b26\\u53f7\"",
		"\"sin\"",
		"\"\\u6c42\\u6b63\\u5f26\\u503c\"",
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"tan\"",
		"\"\\u6c42\\u6b63\\u5207\\u503c\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c3\"",
		"\"truncnum\"",
		"\"N\\u4f4d\\u7f6e\\u96f6\\u5904\\u7406\"",
		"\"ascii\"",
		"\"\\u6c42ASCII\\u7801\"",
		"\"bit_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u4e8c\\u8fdb\\u5236\\u957f\\u5ea6\"",
		"\"byte_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u5b57\\u8282\\u6570\"",
		"\"\\u6c42\\u7b49\\u503c\\u7684\\u5b57\\u7b26\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u957f\\u5ea61\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"difference\"",
		"\"\\u6c42\\u4e24\\u4e2a\\u4e32\\u7684\\u58f0\\u97f3\\u5dee\\u503c\"",
		"\"insertstr\"",
		"\"\\u63d2\\u5165\\u5b57\\u7b26\\u4e32\"",
		"\"lcase\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd1\"",
		"\"left\"",
		"\"\\u5de6\\u622a\\u5b57\\u7b26\\u4e32\"",
		"\"length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u957f\\u5ea62\"",
		"\"locate\"",
		"\"\\u6c42\\u4e32\\u4f4d\\u7f6e1\"",
		"\"lower\"",
		"\"\\u8f6c\\u4e3a\\u5c0f\\u5199\\u5b57\\u6bcd2\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"octet_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u5b58\\u50a8\\u957f\\u5ea6\"",
		"\"patindex\"",
		"\"\\u6c42\\u4e32\\u4f4d\\u7f6e2\"",
		"\"repeat\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5faa\\u73af\\u8fde\\u63a51\"",
		"\"replace\"",
		"\"\\u66ff\\u6362\\u5b57\\u7b26\\u4e32\"",
		"\"replicate\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5faa\\u73af\\u8fde\\u63a52\"",
		"\"right\"",
		"\"\\u53f3\\u622a\\u5b57\\u7b26\\u4e32\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"similar\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u76f8\\u4f3c\\u5ea6\"",
		"\"sortkey\"",
		"\"\\u5b57\\u7b26\\u4e32\\u6392\\u5e8f\"",
		"\"soundex\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u58f0\\u97f3\\u503c\"",
		"\"space\"",
		"\"\\u586b\\u7a7a\\u683c\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
		"\"string\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5408\\u5e76\"",
		"\"stuff\"",
		"\"\\u5b57\\u7b26\\u4e32\\u5220\\u9664\\u66ff\\u6362\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"trim\"",
		"\"\\u53bb\\u5de6\\u53f3\\u7a7a\\u683c\"",
		"\"ucase\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd1\"",
		"\"upper\"",
		"\"\\u8f6c\\u4e3a\\u5927\\u5199\\u5b57\\u6bcd2\"",
		"\"dateformat\"",
		"\"\\u683c\\u5f0f\\u5316\\u65e5\\u671f\"",
		"\"datename\"",
		"\"\\u6c42\\u65e5\\u671f\\u5206\\u91cf\\u82f1\\u6587\\u540d\"",
		"\"datepart\"",
		"\"\\u6c42\\u65e5\\u671f\\u7684\\u5206\\u91cf\\u503c\"",
		"\"datetime\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"date\"",
		"\"\\u8f6c\\u4e3a\\u65e5\\u671f\"",
		"\"dayname\"",
		"\"\\u6c42\\u661f\\u671f\\u82f1\\u6587\\u540d\"",
		"\"days\"",
		"\"\\u6c42\\u5929\\u6570\"",
		"\"day\"",
		"\"\\u6c42\\u5177\\u4f53\\u65e5\\u671f\"",
		"\"dow\"",
		"\"\\u6c42\\u5177\\u4f53\\u661f\\u671f\"",
		"\"hours\"",
		"\"\\u6c42\\u5c0f\\u65f6\\u6570\"",
		"\"hour\"",
		"\"\\u6c42\\u5177\\u4f53\\u5c0f\\u65f6\"",
		"\"minutes\"",
		"\"\\u6c42\\u5206\\u949f\\u6570\"",
		"\"minute\"",
		"\"\\u6c42\\u5177\\u4f53\\u5206\\u949f\"",
		"\"monthname\"",
		"\"\\u6c42\\u6708\\u4efd\\u82f1\\u6587\\u540d\"",
		"\"months\"",
		"\"\\u6c42\\u6708\\u6570\"",
		"\"month\"",
		"\"\\u6c42\\u5177\\u4f53\\u6708\\u6570\"",
		"\"quarter\"",
		"\"\\u6c42\\u5177\\u4f53\\u5b63\\u5ea6\"",
		"\"seconds\"",
		"\"\\u6c42\\u79d2\\u6570\"",
		"\"second\"",
		"\"\\u6c42\\u5177\\u4f53\\u79d2\"",
		"\"weeks\"",
		"\"\\u6c42\\u5468\\u6570\"",
		"\"years\"",
		"\"\\u6c42\\u5e74\\u6570\"",
		"\"year\"",
		"\"\\u6c42\\u5177\\u4f53\\u5e74\\u4efd\"",
		"\"ymd\"",
		"\"\\u6570\\u503c\\u8f6c\\u65e5\\u671f\"",
		"\"dateadd\"",
		"\"\\u65e5\\u671f\\u8fd0\\u7b97\"",
		"\"datediff\"",
		"\"\\u6c42\\u4e24\\u65e5\\u671f\\u5dee\\u503c\"",
		"\"hextoint\"",
		"\"\\u5341\\u516d\\u8fdb\\u5236\\u8f6c\\u4e3a\\u6574\\u6570\"",
		"\"inttohex\"",
		"\"\\u6574\\u6570\\u8f6c\\u4e3a\\u5341\\u516d\\u8fdb\\u5236\"",
		"\"isdate\"",
		"\"\\u662f\\u5426\\u65e5\\u671f\\u578b\"",
		"\"isnumeric\"",
		"\"\\u662f\\u5426\\u6570\\u503c\\u578b\"",
		"\"suser_id\"",
		"\"suser_name\"",
		"\"user_id\"",
		"\"user_name\"",
		"\"rowid\"",
		"\"\\u6c42\\u884c\\u53f7\"",
		"\"ntile\"",
		"\"percentile_count\"",
		"\"percentile_desc\"",
		"\"argn\"",
		"\"coalesce\"",
		"\"ifnull\"",
		"\"isnull\"",
		"\"nullif\"",
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
		"\"\\u5de6\\u8fde\\u63a5\"",
		"LEFT_JOIN",
		"NOTEQUAL1",
		"NOTEQUAL2",
		"LESSTHANOREQUALTO1",
		"LESSTHANOREQUALTO2",
		"LESSTHAN",
		"GREATERTHANOREQUALTO1",
		"GREATERTHANOREQUALTO2",
		"GREATERTHAN",
		"\"yy\"",
		"\"mm\"",
		"\"dd\"",
		"\"qq\"",
		"\"week\"",
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
		"\"uniqueidentifierstr\"",
		"\"bigint\"",
		"\"int\"",
		"\"integer\"",
		"\"smallint\"",
		"\"tinyint\"",
		"\"double\"",
		"\"real\"",
		"\"smalldatetime\"",
		"\"time\"",
		"\"timestamp\"",
		"\"bit\"",
		"DOT_STAR",
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
		"ONE_ARG_OP"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-6755583721471992L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[12];
		data[0]=4449570244456873986L;
		data[1]=-6755411922779016L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-9006799822258168L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[12];
		data[0]=2319353808095805440L;
		data[1]=-6755583721470456L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-6755583721470456L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[12];
		data[0]=2306106892004360192L;
		data[1]=-9006662249642744L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[12];
		data[0]=-6917264595094601728L;
		data[1]=-9006653659708129L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[12];
		data[0]=-4826749874345082878L;
		data[1]=-9006651512224449L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = new long[12];
		data[0]=-4827594299275214846L;
		data[1]=-9006653659708129L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = new long[12];
		data[0]=-4682630975417483262L;
		data[1]=-6755401051699905L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = new long[12];
		data[0]=-4665742476814843902L;
		data[1]=-6755401051668673L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 140737488355328L, 117440512L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-9006834181996536L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=2305843009213693951L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-9006662383303656L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = new long[12];
		data[0]=4035225884599255042L;
		data[1]=-9006653793369064L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	private static final long[] mk_tokenSet_15() {
		long[] data = new long[12];
		data[0]=-4682894858208149502L;
		data[1]=-6755401185360833L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_15 = new BitSet(mk_tokenSet_15());
	private static final long[] mk_tokenSet_16() {
		long[] data = new long[12];
		data[0]=4035225884599255042L;
		data[1]=-9006662383303656L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_16 = new BitSet(mk_tokenSet_16());
	private static final long[] mk_tokenSet_17() {
		long[] data = new long[12];
		data[0]=-4682894858208149502L;
		data[1]=-6755403332844513L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_17 = new BitSet(mk_tokenSet_17());
	private static final long[] mk_tokenSet_18() {
		long[] data = new long[12];
		data[0]=-4666006359605510142L;
		data[1]=-6755401185329601L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_18 = new BitSet(mk_tokenSet_18());
	private static final long[] mk_tokenSet_19() {
		long[] data = new long[12];
		data[0]=-4611686087146864638L;
		data[1]=-6755399441055745L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_19 = new BitSet(mk_tokenSet_19());
	private static final long[] mk_tokenSet_20() {
		long[] data = new long[10];
		data[1]=-9007194959773688L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=2305843009213693951L;
		return data;
	}
	public static final BitSet _tokenSet_20 = new BitSet(mk_tokenSet_20());
	private static final long[] mk_tokenSet_21() {
		long[] data = new long[12];
		data[0]=2305843558969507840L;
		data[1]=-9006653793369064L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_21 = new BitSet(mk_tokenSet_21());
	private static final long[] mk_tokenSet_22() {
		long[] data = new long[12];
		data[0]=4035225884599255042L;
		data[1]=-9006651645885384L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_22 = new BitSet(mk_tokenSet_22());
	private static final long[] mk_tokenSet_23() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=343597907968L;
		data[4]=2183668232L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_23 = new BitSet(mk_tokenSet_23());
	private static final long[] mk_tokenSet_24() {
		long[] data = new long[12];
		data[0]=1729382875385561090L;
		data[1]=1040L;
		data[2]=17179869184L;
		data[4]=-2305843009213693952L;
		data[5]=8191L;
		return data;
	}
	public static final BitSet _tokenSet_24 = new BitSet(mk_tokenSet_24());
	private static final long[] mk_tokenSet_25() {
		long[] data = new long[12];
		data[0]=-4682894858208149502L;
		data[1]=-6755583721471969L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=2305843009213693951L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_25 = new BitSet(mk_tokenSet_25());
	private static final long[] mk_tokenSet_26() {
		long[] data = new long[12];
		data[0]=-4666006359605510142L;
		data[1]=-6755411922747873L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_26 = new BitSet(mk_tokenSet_26());
	private static final long[] mk_tokenSet_27() {
		long[] data = new long[12];
		data[0]=-4611686087146864638L;
		data[1]=-6755401588539393L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_27 = new BitSet(mk_tokenSet_27());
	private static final long[] mk_tokenSet_28() {
		long[] data = { 618475290626L, 30736L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_28 = new BitSet(mk_tokenSet_28());
	private static final long[] mk_tokenSet_29() {
		long[] data = { 0L, 2251250460524544L, 0L, 0L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_29 = new BitSet(mk_tokenSet_29());
	private static final long[] mk_tokenSet_30() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-6755411922779112L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_30 = new BitSet(mk_tokenSet_30());
	private static final long[] mk_tokenSet_31() {
		long[] data = new long[12];
		data[0]=4452947944177401858L;
		data[1]=-6755401722231688L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_31 = new BitSet(mk_tokenSet_31());
	private static final long[] mk_tokenSet_32() {
		long[] data = new long[12];
		data[0]=-13634012903899134L;
		data[1]=-6755399574747521L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_32 = new BitSet(mk_tokenSet_32());
	private static final long[] mk_tokenSet_33() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-6755583721471992L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=2305843009213693951L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_33 = new BitSet(mk_tokenSet_33());
	private static final long[] mk_tokenSet_34() {
		long[] data = new long[12];
		data[0]=4449570244456873986L;
		data[1]=-9006662383303560L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_34 = new BitSet(mk_tokenSet_34());
	private static final long[] mk_tokenSet_35() {
		long[] data = new long[12];
		data[0]=-13634012903899134L;
		data[1]=-6755401722231169L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_35 = new BitSet(mk_tokenSet_35());
	private static final long[] mk_tokenSet_36() {
		long[] data = new long[12];
		data[0]=-68719476734L;
		data[1]=-6755401051668481L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_36 = new BitSet(mk_tokenSet_36());
	private static final long[] mk_tokenSet_37() {
		long[] data = new long[12];
		data[0]=-68719476734L;
		data[1]=-6755399441055745L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_37 = new BitSet(mk_tokenSet_37());
	private static final long[] mk_tokenSet_38() {
		long[] data = new long[12];
		data[0]=2143727235243180034L;
		data[1]=1136L;
		data[2]=17179869184L;
		data[4]=-2305843009213693952L;
		data[5]=8191L;
		return data;
	}
	public static final BitSet _tokenSet_38 = new BitSet(mk_tokenSet_38());
	private static final long[] mk_tokenSet_39() {
		long[] data = new long[12];
		data[0]=-17011712624427006L;
		data[1]=-6755549361731969L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_39 = new BitSet(mk_tokenSet_39());
	private static final long[] mk_tokenSet_40() {
		long[] data = new long[12];
		data[0]=-68719476734L;
		data[1]=-6755411789086721L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_40 = new BitSet(mk_tokenSet_40());
	private static final long[] mk_tokenSet_41() {
		long[] data = new long[12];
		data[0]=-68719476734L;
		data[1]=-6755401588539393L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_41 = new BitSet(mk_tokenSet_41());
	private static final long[] mk_tokenSet_42() {
		long[] data = new long[12];
		data[0]=4449570244456873986L;
		data[1]=-9006651645885320L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_42 = new BitSet(mk_tokenSet_42());
	private static final long[] mk_tokenSet_43() {
		long[] data = new long[12];
		data[0]=-17011712624427006L;
		data[1]=-6755401185360257L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686017890525183L;
		return data;
	}
	public static final BitSet _tokenSet_43 = new BitSet(mk_tokenSet_43());
	private static final long[] mk_tokenSet_44() {
		long[] data = new long[12];
		data[0]=-4773537909607235582L;
		data[1]=-9006797541081729L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_44 = new BitSet(mk_tokenSet_44());
	private static final long[] mk_tokenSet_45() {
		long[] data = new long[12];
		data[0]=-16888567322116094L;
		data[1]=-6755401051668609L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_45 = new BitSet(mk_tokenSet_45());
	private static final long[] mk_tokenSet_46() {
		long[] data = new long[10];
		data[1]=108086395351859208L;
		data[2]=-128L;
		data[3]=-1L;
		data[4]=2299087609772638207L;
		return data;
	}
	public static final BitSet _tokenSet_46 = new BitSet(mk_tokenSet_46());
	private static final long[] mk_tokenSet_47() {
		long[] data = new long[12];
		data[0]=2305843558969507840L;
		data[1]=-9006662383303656L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899369979903L;
		return data;
	}
	public static final BitSet _tokenSet_47 = new BitSet(mk_tokenSet_47());
	private static final long[] mk_tokenSet_48() {
		long[] data = new long[12];
		data[0]=-4773537909607235582L;
		data[1]=-9006651512193665L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_48 = new BitSet(mk_tokenSet_48());
	private static final long[] mk_tokenSet_49() {
		long[] data = new long[12];
		data[0]=2309220708934221824L;
		data[1]=-9006798211645432L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_49 = new BitSet(mk_tokenSet_49());
	private static final long[] mk_tokenSet_50() {
		long[] data = new long[12];
		data[0]=-4827594299275214846L;
		data[1]=-9006651512224449L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_50 = new BitSet(mk_tokenSet_50());
	private static final long[] mk_tokenSet_51() {
		long[] data = new long[12];
		data[0]=-4628574585749503998L;
		data[1]=-6755401051669121L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_51 = new BitSet(mk_tokenSet_51());
	private static final long[] mk_tokenSet_52() {
		long[] data = new long[12];
		data[1]=1024L;
		data[2]=17179869184L;
		data[4]=-2305843009213693952L;
		data[5]=8191L;
		return data;
	}
	public static final BitSet _tokenSet_52 = new BitSet(mk_tokenSet_52());
	private static final long[] mk_tokenSet_53() {
		long[] data = new long[12];
		data[0]=-4827594299275214846L;
		data[1]=-9006660102159041L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_53 = new BitSet(mk_tokenSet_53());
	private static final long[] mk_tokenSet_54() {
		long[] data = new long[12];
		data[0]=-68719476734L;
		data[1]=-6755401051668609L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=4611686018427387903L;
		return data;
	}
	public static final BitSet _tokenSet_54 = new BitSet(mk_tokenSet_54());
	private static final long[] mk_tokenSet_55() {
		long[] data = new long[12];
		data[0]=-4827594299275214846L;
		data[1]=-9006797541113537L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=9223372036854775807L;
		data[5]=1125899906834432L;
		return data;
	}
	public static final BitSet _tokenSet_55 = new BitSet(mk_tokenSet_55());
	private static final long[] mk_tokenSet_56() {
		long[] data = new long[12];
		data[0]=2305843009213693952L;
		data[1]=-9006799822258168L;
		for (int i = 2; i<=3; i++) { data[i]=-1L; }
		data[4]=2305843009213693951L;
		data[5]=1125899369971712L;
		return data;
	}
	public static final BitSet _tokenSet_56 = new BitSet(mk_tokenSet_56());
	private static final long[] mk_tokenSet_57() {
		long[] data = new long[12];
		data[0]=-4827594299275214846L;
		data[1]=-9006797541112513L;
		for (int i = 2; i<=4; i++) { data[i]=-1L; }
		data[5]=1125899906842623L;
		return data;
	}
	public static final BitSet _tokenSet_57 = new BitSet(mk_tokenSet_57());
	private static final long[] mk_tokenSet_58() {
		long[] data = new long[12];
		data[3]=2882303761517117440L;
		data[5]=4610560118520545280L;
		return data;
	}
	public static final BitSet _tokenSet_58 = new BitSet(mk_tokenSet_58());
	
	}
