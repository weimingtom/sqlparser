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
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp126_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp127_AST = null;
			tmp127_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp127_AST);
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
		case 46:
		{
			all = LT(1);
			all_AST = astFactory.create(all);
			astFactory.addASTChild(currentAST, all_AST);
			match(46);
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
			AST tmp129_AST = null;
			tmp129_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp129_AST);
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
				case 43:
				{
					{
					switch ( LA(1)) {
					case LITERAL_as:
					{
						AST tmp130_AST = null;
						tmp130_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp130_AST);
						match(LITERAL_as);
						break;
					}
					case 43:
					{
						AST tmp131_AST = null;
						tmp131_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp131_AST);
						match(43);
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
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==44||LA(2)==45)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 44:
				{
					AST tmp132_AST = null;
					tmp132_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp132_AST);
					match(44);
					break;
				}
				case 45:
				{
					AST tmp133_AST = null;
					tmp133_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp133_AST);
					match(45);
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
		
		bool_exp();
		astFactory.addASTChild(currentAST, returnAST);
		search_condition_AST = (AST)currentAST.root;
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
				AST tmp134_AST = null;
				tmp134_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp134_AST);
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
			AST tmp136_AST = null;
			tmp136_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp136_AST);
			match(LITERAL_t_union);
			break;
		}
		case 19:
		{
			AST tmp137_AST = null;
			tmp137_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp137_AST);
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
			AST tmp139_AST = null;
			tmp139_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp139_AST);
			match(LITERAL_t_compare);
			break;
		}
		case 22:
		{
			AST tmp140_AST = null;
			tmp140_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp140_AST);
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
			AST tmp144_AST = null;
			tmp144_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp144_AST);
			match(LITERAL_select);
			break;
		}
		case 26:
		{
			AST tmp145_AST = null;
			tmp145_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp145_AST);
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
			AST tmp146_AST = null;
			tmp146_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp146_AST);
			match(LITERAL_distinct);
			break;
		}
		case 28:
		{
			AST tmp147_AST = null;
			tmp147_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp147_AST);
			match(28);
			break;
		}
		case LPAREN:
		case 46:
		case STAR:
		case LITERAL_null:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case NEGATIVE_DIGIT_ELEMENT:
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		case LITERAL_sum:
		case 100:
		case LITERAL_avg:
		case 102:
		case LITERAL_max:
		case 104:
		case LITERAL_min:
		case 106:
		case LITERAL_count:
		case 108:
		case ONE_ARG_OP:
		case 110:
		{
			break;
		}
		default:
		{
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
				AST tmp148_AST = null;
				tmp148_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp148_AST);
				match(LITERAL_from);
				break;
			}
			case 30:
			{
				AST tmp149_AST = null;
				tmp149_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp149_AST);
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
				AST tmp150_AST = null;
				tmp150_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp150_AST);
				match(LITERAL_where);
				break;
			}
			case 24:
			{
				AST tmp151_AST = null;
				tmp151_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp151_AST);
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
				AST tmp152_AST = null;
				tmp152_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp152_AST);
				match(LITERAL_group);
				match(LITERAL_by);
				break;
			}
			case 33:
			{
				AST tmp154_AST = null;
				tmp154_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp154_AST);
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
				AST tmp155_AST = null;
				tmp155_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp155_AST);
				match(LITERAL_order);
				match(LITERAL_by);
				break;
			}
			case 35:
			{
				AST tmp157_AST = null;
				tmp157_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp157_AST);
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
		
		AST tmp158_AST = null;
		tmp158_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp158_AST);
		match(ID);
		{
		switch ( LA(1)) {
		case LITERAL_as:
		case 43:
		{
			{
			switch ( LA(1)) {
			case LITERAL_as:
			{
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp159_AST);
				match(LITERAL_as);
				break;
			}
			case 43:
			{
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp160_AST);
				match(43);
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
		case 130:
		{
			AST tmp161_AST = null;
			tmp161_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp161_AST);
			match(130);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 131:
		{
			AST tmp162_AST = null;
			tmp162_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp162_AST);
			match(131);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exists:
		{
			AST tmp163_AST = null;
			tmp163_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp163_AST);
			match(LITERAL_exists);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 133:
		{
			AST tmp164_AST = null;
			tmp164_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp164_AST);
			match(133);
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
				AST tmp165_AST = null;
				tmp165_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp165_AST);
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
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp166_AST);
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
		_loop39:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp167_AST = null;
				tmp167_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp167_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop39;
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
		_loop42:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp168_AST = null;
				tmp168_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp168_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop42;
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
		
		if ((_tokenSet_2.member(LA(1))) && (_tokenSet_3.member(LA(2))) && (_tokenSet_4.member(LA(3))) && (_tokenSet_5.member(LA(4))) && (_tokenSet_6.member(LA(5)))) {
			bool_term();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop33:
			do {
				if (((LA(1) >= LITERAL_and && LA(1) <= 39))) {
					{
					switch ( LA(1)) {
					case LITERAL_and:
					{
						AST tmp169_AST = null;
						tmp169_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp169_AST);
						match(LITERAL_and);
						break;
					}
					case LITERAL_or:
					{
						AST tmp170_AST = null;
						tmp170_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp170_AST);
						match(LITERAL_or);
						break;
					}
					case 38:
					{
						AST tmp171_AST = null;
						tmp171_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp171_AST);
						match(38);
						break;
					}
					case 39:
					{
						AST tmp172_AST = null;
						tmp172_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp172_AST);
						match(39);
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
					break _loop33;
				}
				
			} while (true);
			}
			bool_exp_AST = (AST)currentAST.root;
		}
		else if ((LA(1)==LITERAL_not||LA(1)==110) && (_tokenSet_2.member(LA(2))) && (_tokenSet_3.member(LA(3))) && (_tokenSet_7.member(LA(4))) && (_tokenSet_5.member(LA(5)))) {
			logic_onearg_op();
			astFactory.addASTChild(currentAST, returnAST);
			bool_term();
			astFactory.addASTChild(currentAST, returnAST);
			bool_exp_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = bool_exp_AST;
	}
	
	public final void bool_term() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST bool_term_AST = null;
		AST exp_AST = null;
		
		boolean synPredMatched36 = false;
		if (((LA(1)==LPAREN) && (_tokenSet_8.member(LA(2))) && (_tokenSet_3.member(LA(3))) && (_tokenSet_9.member(LA(4))) && (_tokenSet_10.member(LA(5))))) {
			int _m36 = mark();
			synPredMatched36 = true;
			inputState.guessing++;
			try {
				{
				match(LPAREN);
				bool_exp();
				match(RPAREN);
				}
			}
			catch (RecognitionException pe) {
				synPredMatched36 = false;
			}
			rewind(_m36);
inputState.guessing--;
		}
		if ( synPredMatched36 ) {
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
		else if ((_tokenSet_2.member(LA(1))) && (_tokenSet_11.member(LA(2))) && (_tokenSet_4.member(LA(3))) && (_tokenSet_5.member(LA(4))) && (_tokenSet_6.member(LA(5)))) {
			equation();
			astFactory.addASTChild(currentAST, returnAST);
			bool_term_AST = (AST)currentAST.root;
		}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		
		returnAST = bool_term_AST;
	}
	
	public final void logic_onearg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_onearg_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_not:
		{
			AST tmp175_AST = null;
			tmp175_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp175_AST);
			match(LITERAL_not);
			logic_onearg_op_AST = (AST)currentAST.root;
			break;
		}
		case 110:
		{
			AST tmp176_AST = null;
			tmp176_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp176_AST);
			match(110);
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
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equation_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case 44:
		case 45:
		case COMPARE_OP:
		case LITERAL_like:
		case 123:
		case 124:
		case 125:
		case 126:
		case 127:
		case 128:
		case 129:
		{
			{
			switch ( LA(1)) {
			case 44:
			{
				AST tmp177_AST = null;
				tmp177_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp177_AST);
				match(44);
				break;
			}
			case 45:
			case COMPARE_OP:
			case LITERAL_like:
			case 123:
			case 124:
			case 125:
			case 126:
			case 127:
			case 128:
			case 129:
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
		case 55:
		case 56:
		{
			{
			switch ( LA(1)) {
			case 55:
			{
				AST tmp178_AST = null;
				tmp178_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp178_AST);
				match(55);
				break;
			}
			case 56:
			{
				AST tmp179_AST = null;
				tmp179_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp179_AST);
				match(56);
				break;
			}
			default:
				if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_null)) {
					match(LITERAL_is);
					AST tmp181_AST = null;
					tmp181_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp181_AST);
					match(LITERAL_null);
				}
				else if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_not)) {
					match(LITERAL_is);
					AST tmp183_AST = null;
					tmp183_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp183_AST);
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
		case 58:
		{
			{
			switch ( LA(1)) {
			case LITERAL_between:
			{
				AST tmp185_AST = null;
				tmp185_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp185_AST);
				match(LITERAL_between);
				break;
			}
			case 58:
			{
				AST tmp186_AST = null;
				tmp186_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp186_AST);
				match(58);
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
			switch ( LA(1)) {
			case LITERAL_and:
			{
				match(LITERAL_and);
				break;
			}
			case LPAREN:
			case LITERAL_null:
			case PARAM_ID:
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_sqrt:
			case 72:
			case LITERAL_getdate:
			case 74:
			case LITERAL_abs:
			case 76:
			case LITERAL_substring:
			case 78:
			case LITERAL_round:
			case 80:
			case LITERAL_right:
			case 82:
			case LITERAL_ltrim:
			case 84:
			case LITERAL_rtrim:
			case 86:
			case LITERAL_char_length:
			case 88:
			case LITERAL_floor:
			case 90:
			case LITERAL_ceiling:
			case 92:
			case LITERAL_lower:
			case 94:
			case LITERAL_charindex:
			case 96:
			case LITERAL_str:
			case 98:
			case ONE_ARG_OP:
			case 110:
			{
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
		case 59:
		case LITERAL_in:
		case 61:
		case 62:
		{
			{
			switch ( LA(1)) {
			case 59:
			{
				AST tmp188_AST = null;
				tmp188_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp188_AST);
				match(59);
				break;
			}
			case LITERAL_in:
			{
				AST tmp189_AST = null;
				tmp189_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp189_AST);
				match(LITERAL_in);
				break;
			}
			case 61:
			{
				AST tmp190_AST = null;
				tmp190_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp190_AST);
				match(61);
				break;
			}
			case 62:
			{
				AST tmp191_AST = null;
				tmp191_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp191_AST);
				match(62);
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
		switch ( LA(1)) {
		case ID:
		{
			field_name();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		{
			function();
			astFactory.addASTChild(currentAST, returnAST);
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
		case STAR:
		case TWO_ARG_OP:
		case MINUS:
		case 113:
		case 114:
		case 115:
		case 116:
		case 117:
		case 118:
		case 119:
		case 120:
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
		switch ( LA(1)) {
		case LITERAL_sum:
		case 100:
		case LITERAL_avg:
		case 102:
		case LITERAL_max:
		case 104:
		case LITERAL_min:
		case 106:
		case LITERAL_count:
		case 108:
		{
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		{
			function();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
			if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_12.member(LA(2)))) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else if ((LA(1)==ID) && (LA(2)==POINT)) {
				field_name();
				astFactory.addASTChild(currentAST, returnAST);
			}
		else {
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		{
		switch ( LA(1)) {
		case 48:
		{
			AST tmp192_AST = null;
			tmp192_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp192_AST);
			match(48);
			break;
		}
		case 49:
		{
			AST tmp193_AST = null;
			tmp193_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp193_AST);
			match(49);
			break;
		}
		case LITERAL_asc:
		{
			AST tmp194_AST = null;
			tmp194_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp194_AST);
			match(LITERAL_asc);
			break;
		}
		case LITERAL_desc:
		{
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp195_AST);
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
		case LITERAL_null:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case NEGATIVE_DIGIT_ELEMENT:
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		case LITERAL_sum:
		case 100:
		case LITERAL_avg:
		case 102:
		case LITERAL_max:
		case 104:
		case LITERAL_min:
		case 106:
		case LITERAL_count:
		case 108:
		{
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
			case LITERAL_sqrt:
			case 72:
			case LITERAL_getdate:
			case 74:
			case LITERAL_abs:
			case 76:
			case LITERAL_substring:
			case 78:
			case LITERAL_round:
			case 80:
			case LITERAL_right:
			case 82:
			case LITERAL_ltrim:
			case 84:
			case LITERAL_rtrim:
			case 86:
			case LITERAL_char_length:
			case 88:
			case LITERAL_floor:
			case 90:
			case LITERAL_ceiling:
			case 92:
			case LITERAL_lower:
			case 94:
			case LITERAL_charindex:
			case 96:
			case LITERAL_str:
			case 98:
			{
				function();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_sum:
			case 100:
			case LITERAL_avg:
			case 102:
			case LITERAL_max:
			case 104:
			case LITERAL_min:
			case 106:
			case LITERAL_count:
			case 108:
			{
				aggregate_func();
				astFactory.addASTChild(currentAST, returnAST);
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
			case STAR:
			case TWO_ARG_OP:
			case MINUS:
			case 113:
			case 114:
			case 115:
			case 116:
			case 117:
			case 118:
			case 119:
			case 120:
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
			case 43:
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
		case LPAREN:
		{
			AST tmp196_AST = null;
			tmp196_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp196_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp197_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case MINUS:
			case 113:
			case 114:
			case 115:
			case 116:
			case 117:
			case 118:
			case 119:
			case 120:
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
			case 43:
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
		case 110:
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
		{
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
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp198_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp199_AST);
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
		
		AST tmp200_AST = null;
		tmp200_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp200_AST);
		match(ID);
		AST tmp201_AST = null;
		tmp201_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp201_AST);
		match(POINT);
		AST tmp202_AST = null;
		tmp202_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp202_AST);
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
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(TWO_ARG_OP);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
			match(STAR);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case MINUS:
		{
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(MINUS);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 113:
		{
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(113);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 114:
		{
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(114);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 115:
		{
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(115);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 116:
		{
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(116);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 117:
		{
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(117);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 118:
		{
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(118);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 119:
		{
			AST tmp214_AST = null;
			tmp214_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp214_AST);
			match(119);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 120:
		{
			AST tmp215_AST = null;
			tmp215_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp215_AST);
			match(120);
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
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp217_AST);
			match(LITERAL_all);
			break;
		}
		case 70:
		{
			AST tmp218_AST = null;
			tmp218_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp218_AST);
			match(70);
			break;
		}
		case LITERAL_distinct:
		{
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp219_AST);
			match(LITERAL_distinct);
			break;
		}
		case 28:
		{
			AST tmp220_AST = null;
			tmp220_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp220_AST);
			match(28);
			break;
		}
		case LPAREN:
		case LITERAL_null:
		case PARAM_ID:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case NEGATIVE_DIGIT_ELEMENT:
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		case ONE_ARG_OP:
		case 110:
		{
			break;
		}
		default:
		{
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
		case LITERAL_null:
		case PARAM_ID:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case NEGATIVE_DIGIT_ELEMENT:
		case LITERAL_sqrt:
		case 72:
		case LITERAL_getdate:
		case 74:
		case LITERAL_abs:
		case 76:
		case LITERAL_substring:
		case 78:
		case LITERAL_round:
		case 80:
		case LITERAL_right:
		case 82:
		case LITERAL_ltrim:
		case 84:
		case LITERAL_rtrim:
		case 86:
		case LITERAL_char_length:
		case 88:
		case LITERAL_floor:
		case 90:
		case LITERAL_ceiling:
		case 92:
		case LITERAL_lower:
		case 94:
		case LITERAL_charindex:
		case 96:
		case LITERAL_str:
		case 98:
		{
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
			case LITERAL_sqrt:
			case 72:
			case LITERAL_getdate:
			case 74:
			case LITERAL_abs:
			case 76:
			case LITERAL_substring:
			case 78:
			case LITERAL_round:
			case 80:
			case LITERAL_right:
			case 82:
			case LITERAL_ltrim:
			case 84:
			case LITERAL_rtrim:
			case 86:
			case LITERAL_char_length:
			case 88:
			case LITERAL_floor:
			case 90:
			case LITERAL_ceiling:
			case 92:
			case LITERAL_lower:
			case 94:
			case LITERAL_charindex:
			case 96:
			case LITERAL_str:
			case 98:
			{
				function();
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
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case MINUS:
			case 113:
			case 114:
			case 115:
			case 116:
			case 117:
			case 118:
			case 119:
			case 120:
			{
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
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_group:
			case 33:
			case LITERAL_order:
			case 35:
			case LITERAL_and:
			case LITERAL_or:
			case 38:
			case 39:
			case LPAREN:
			case RPAREN:
			case 44:
			case 45:
			case LITERAL_is:
			case LITERAL_null:
			case 55:
			case 56:
			case LITERAL_between:
			case 58:
			case 59:
			case LITERAL_in:
			case 61:
			case 62:
			case PARAM_ID:
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_sqrt:
			case 72:
			case LITERAL_getdate:
			case 74:
			case LITERAL_abs:
			case 76:
			case LITERAL_substring:
			case 78:
			case LITERAL_round:
			case 80:
			case LITERAL_right:
			case 82:
			case LITERAL_ltrim:
			case 84:
			case LITERAL_rtrim:
			case 86:
			case LITERAL_char_length:
			case 88:
			case LITERAL_floor:
			case 90:
			case LITERAL_ceiling:
			case 92:
			case LITERAL_lower:
			case 94:
			case LITERAL_charindex:
			case 96:
			case LITERAL_str:
			case 98:
			case ONE_ARG_OP:
			case 110:
			case COMPARE_OP:
			case LITERAL_like:
			case 123:
			case 124:
			case 125:
			case 126:
			case 127:
			case 128:
			case 129:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			AST tmp222_AST = null;
			tmp222_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp222_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp223_AST = null;
			tmp223_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp223_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case MINUS:
			case 113:
			case 114:
			case 115:
			case 116:
			case 117:
			case 118:
			case 119:
			case 120:
			{
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
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_group:
			case 33:
			case LITERAL_order:
			case 35:
			case LITERAL_and:
			case LITERAL_or:
			case 38:
			case 39:
			case LPAREN:
			case RPAREN:
			case 44:
			case 45:
			case LITERAL_is:
			case LITERAL_null:
			case 55:
			case 56:
			case LITERAL_between:
			case 58:
			case 59:
			case LITERAL_in:
			case 61:
			case 62:
			case PARAM_ID:
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case NEGATIVE_DIGIT_ELEMENT:
			case LITERAL_sqrt:
			case 72:
			case LITERAL_getdate:
			case 74:
			case LITERAL_abs:
			case 76:
			case LITERAL_substring:
			case 78:
			case LITERAL_round:
			case 80:
			case LITERAL_right:
			case 82:
			case LITERAL_ltrim:
			case 84:
			case LITERAL_rtrim:
			case 86:
			case LITERAL_char_length:
			case 88:
			case LITERAL_floor:
			case 90:
			case LITERAL_ceiling:
			case 92:
			case LITERAL_lower:
			case 94:
			case LITERAL_charindex:
			case 96:
			case LITERAL_str:
			case 98:
			case ONE_ARG_OP:
			case 110:
			case COMPARE_OP:
			case LITERAL_like:
			case 123:
			case 124:
			case 125:
			case 126:
			case 127:
			case 128:
			case 129:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			expression_AST = (AST)currentAST.root;
			break;
		}
		case ONE_ARG_OP:
		case 110:
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
		{
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
			AST tmp224_AST = null;
			tmp224_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp224_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case NEGATIVE_DIGIT_ELEMENT:
		{
			AST tmp225_AST = null;
			tmp225_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp225_AST);
			match(NEGATIVE_DIGIT_ELEMENT);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp226_AST = null;
			tmp226_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp226_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp227_AST = null;
			tmp227_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp227_AST);
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
		
		AST tmp228_AST = null;
		tmp228_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp228_AST);
		match(PARAM_ID);
		param_equ_AST = (AST)currentAST.root;
		returnAST = param_equ_AST;
	}
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		switch ( LA(1)) {
		case ONE_ARG_OP:
		{
			AST tmp229_AST = null;
			tmp229_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp229_AST);
			match(ONE_ARG_OP);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 110:
		{
			AST tmp230_AST = null;
			tmp230_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp230_AST);
			match(110);
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
	
	public final void compare_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST compare_op_AST = null;
		
		switch ( LA(1)) {
		case COMPARE_OP:
		{
			AST tmp231_AST = null;
			tmp231_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp231_AST);
			match(COMPARE_OP);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 45:
		{
			AST tmp232_AST = null;
			tmp232_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp232_AST);
			match(45);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_like:
		{
			AST tmp233_AST = null;
			tmp233_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp233_AST);
			match(LITERAL_like);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 123:
		{
			AST tmp234_AST = null;
			tmp234_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp234_AST);
			match(123);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 124:
		{
			AST tmp235_AST = null;
			tmp235_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(124);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 125:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(125);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 126:
		{
			AST tmp237_AST = null;
			tmp237_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp237_AST);
			match(126);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 127:
		{
			AST tmp238_AST = null;
			tmp238_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp238_AST);
			match(127);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 128:
		{
			AST tmp239_AST = null;
			tmp239_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp239_AST);
			match(128);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 129:
		{
			AST tmp240_AST = null;
			tmp240_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp240_AST);
			match(129);
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
		
		AST tmp241_AST = null;
		tmp241_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp241_AST);
		match(LPAREN);
		constexpset();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp242_AST = null;
		tmp242_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp242_AST);
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
		_loop71:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp243_AST = null;
				tmp243_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp243_AST);
				match(COMMA);
				constant();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop71;
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
		
		AST tmp244_AST = null;
		tmp244_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp244_AST);
		match(LPAREN);
		select_statement();
		astFactory.addASTChild(currentAST, returnAST);
		AST tmp245_AST = null;
		tmp245_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp245_AST);
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
		case LITERAL_sqrt:
		{
			AST tmp246_AST = null;
			tmp246_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp246_AST);
			match(LITERAL_sqrt);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 72:
		{
			AST tmp247_AST = null;
			tmp247_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp247_AST);
			match(72);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_getdate:
		{
			AST tmp248_AST = null;
			tmp248_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp248_AST);
			match(LITERAL_getdate);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 74:
		{
			AST tmp249_AST = null;
			tmp249_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp249_AST);
			match(74);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_abs:
		{
			AST tmp250_AST = null;
			tmp250_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp250_AST);
			match(LITERAL_abs);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 76:
		{
			AST tmp251_AST = null;
			tmp251_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp251_AST);
			match(76);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substring:
		{
			AST tmp252_AST = null;
			tmp252_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp252_AST);
			match(LITERAL_substring);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 78:
		{
			AST tmp253_AST = null;
			tmp253_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp253_AST);
			match(78);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp254_AST = null;
			tmp254_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp254_AST);
			match(LITERAL_round);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 80:
		{
			AST tmp255_AST = null;
			tmp255_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp255_AST);
			match(80);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_right:
		{
			AST tmp256_AST = null;
			tmp256_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp256_AST);
			match(LITERAL_right);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 82:
		{
			AST tmp257_AST = null;
			tmp257_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp257_AST);
			match(82);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp258_AST = null;
			tmp258_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp258_AST);
			match(LITERAL_ltrim);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 84:
		{
			AST tmp259_AST = null;
			tmp259_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp259_AST);
			match(84);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp260_AST = null;
			tmp260_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp260_AST);
			match(LITERAL_rtrim);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 86:
		{
			AST tmp261_AST = null;
			tmp261_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp261_AST);
			match(86);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char_length:
		{
			AST tmp262_AST = null;
			tmp262_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp262_AST);
			match(LITERAL_char_length);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 88:
		{
			AST tmp263_AST = null;
			tmp263_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp263_AST);
			match(88);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp264_AST = null;
			tmp264_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp264_AST);
			match(LITERAL_floor);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 90:
		{
			AST tmp265_AST = null;
			tmp265_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp265_AST);
			match(90);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceiling:
		{
			AST tmp266_AST = null;
			tmp266_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp266_AST);
			match(LITERAL_ceiling);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 92:
		{
			AST tmp267_AST = null;
			tmp267_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp267_AST);
			match(92);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp268_AST = null;
			tmp268_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp268_AST);
			match(LITERAL_lower);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 94:
		{
			AST tmp269_AST = null;
			tmp269_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp269_AST);
			match(94);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_charindex:
		{
			AST tmp270_AST = null;
			tmp270_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp270_AST);
			match(LITERAL_charindex);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 96:
		{
			AST tmp271_AST = null;
			tmp271_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp271_AST);
			match(96);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_str:
		{
			AST tmp272_AST = null;
			tmp272_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp272_AST);
			match(LITERAL_str);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 98:
		{
			AST tmp273_AST = null;
			tmp273_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp273_AST);
			match(98);
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
		_loop82:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp274_AST = null;
				tmp274_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp274_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop82;
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
			AST tmp275_AST = null;
			tmp275_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp275_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 100:
		{
			AST tmp276_AST = null;
			tmp276_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp276_AST);
			match(100);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_avg:
		{
			AST tmp277_AST = null;
			tmp277_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp277_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 102:
		{
			AST tmp278_AST = null;
			tmp278_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp278_AST);
			match(102);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp279_AST = null;
			tmp279_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp279_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 104:
		{
			AST tmp280_AST = null;
			tmp280_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp280_AST);
			match(104);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp281_AST = null;
			tmp281_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp281_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 106:
		{
			AST tmp282_AST = null;
			tmp282_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp282_AST);
			match(106);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_count:
		{
			AST tmp283_AST = null;
			tmp283_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp283_AST);
			match(LITERAL_count);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 108:
		{
			AST tmp284_AST = null;
			tmp284_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp284_AST);
			match(108);
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
	
	public final void contain_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST contain_op_AST = null;
		
		switch ( LA(1)) {
		case 61:
		{
			AST tmp285_AST = null;
			tmp285_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp285_AST);
			match(61);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case 62:
		{
			AST tmp286_AST = null;
			tmp286_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp286_AST);
			match(62);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_in:
		{
			AST tmp287_AST = null;
			tmp287_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp287_AST);
			match(LITERAL_in);
			contain_op_AST = (AST)currentAST.root;
			break;
		}
		case 59:
		{
			AST tmp288_AST = null;
			tmp288_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp288_AST);
			match(59);
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
	
	public final void logic_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_and:
		{
			AST tmp289_AST = null;
			tmp289_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp289_AST);
			match(LITERAL_and);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		{
			AST tmp290_AST = null;
			tmp290_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp290_AST);
			match(LITERAL_or);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 38:
		{
			AST tmp291_AST = null;
			tmp291_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp291_AST);
			match(38);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 39:
		{
			AST tmp292_AST = null;
			tmp292_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp292_AST);
			match(39);
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
		"\"not\"",
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
		"\"sqrt\"",
		"\"\\u6c42\\u5e73\\u65b9\\u6839\"",
		"\"getdate\"",
		"\"\\u6c42\\u5f53\\u524d\\u65e5\\u671f\\u65f6\\u95f4\"",
		"\"abs\"",
		"\"\\u6c42\\u7edd\\u5bf9\\u503c\"",
		"\"substring\"",
		"\"\\u5b57\\u7b26\\u4e32\\u622a\\u53d6\"",
		"\"round\"",
		"\"\\u683c\\u5f0f\\u5316\\u6570\\u503c\"",
		"\"right\"",
		"\"\\u5b57\\u7b26\\u4e32\\u53f3\\u622a\"",
		"\"ltrim\"",
		"\"\\u53bb\\u6389\\u5de6\\u7a7a\\u683c\"",
		"\"rtrim\"",
		"\"\\u53bb\\u6389\\u53f3\\u7a7a\\u683c\"",
		"\"char_length\"",
		"\"\\u6c42\\u5b57\\u7b26\\u4e32\\u7684\\u957f\\u5ea6\"",
		"\"floor\"",
		"\"\\u6c42\\u56db\\u820d\\u540e\\u7684\\u6574\\u6570\"",
		"\"ceiling\"",
		"\"\\u6c42\\u4e94\\u5165\\u540e\\u7684\\u6574\\u6570\"",
		"\"lower\"",
		"\"\\u5c06\\u5b57\\u7b26\\u4e32\\u8f6c\\u4e3a\\u5c0f\\u5199\"",
		"\"charindex\"",
		"\"\\u5b58\\u5728\\u4e8e\"",
		"\"str\"",
		"\"\\u6570\\u503c\\u8f6c\\u5b57\\u7b26\\u4e32\"",
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
		"ONE_ARG_OP",
		"\"\\u975e\"",
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
		long[] data = { 9008298766368768L, 140737488355227L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 9164493331496962L, 144115188075855775L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { -9214363738088407040L, 105587476004763L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { -4308986069254144L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { -4305693976690686L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { -4305689572933630L, -97L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { -13195775442942L, -97L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { -4306724768841726L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { -9196349339578925056L, 105587476004763L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { -4305756253847552L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { -4305693975642110L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { -22323384578736128L, -35150012350561L, 3L, 0L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 4224323675095042L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	
	}
