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
			AST tmp115_AST = null;
			tmp115_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp115_AST);
			match(COLUMN);
			column();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case WHERE:
		{
			AST tmp116_AST = null;
			tmp116_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp116_AST);
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
		case 36:
		{
			all = LT(1);
			all_AST = astFactory.create(all);
			astFactory.addASTChild(currentAST, all_AST);
			match(36);
			column_AST = (AST)currentAST.root;
			column_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(ALL_FIELDS,all.getText())));
			currentAST.root = column_AST;
			currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
				column_AST.getFirstChild() : column_AST;
			currentAST.advanceChildToEnd();
			column_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp118_AST = null;
			tmp118_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp118_AST);
			match(STAR);
			column_AST = (AST)currentAST.root;
			column_AST=(AST)astFactory.make( (new ASTArray(1)).add(astFactory.create(ALL_FIELDS,"*")));
			currentAST.root = column_AST;
			currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
				column_AST.getFirstChild() : column_AST;
			currentAST.advanceChildToEnd();
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
				case 33:
				{
					{
					switch ( LA(1)) {
					case LITERAL_as:
					{
						AST tmp119_AST = null;
						tmp119_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp119_AST);
						match(LITERAL_as);
						break;
					}
					case 33:
					{
						AST tmp120_AST = null;
						tmp120_AST = astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp120_AST);
						match(33);
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
				case 20:
				case LITERAL_from:
				case 26:
				case LITERAL_group:
				case 29:
				case LITERAL_order:
				case 31:
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
			else if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (LA(2)==34||LA(2)==35)) {
				alias();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case 34:
				{
					AST tmp121_AST = null;
					tmp121_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp121_AST);
					match(34);
					break;
				}
				case 35:
				{
					AST tmp122_AST = null;
					tmp122_AST = astFactory.create(LT(1));
					astFactory.addASTChild(currentAST, tmp122_AST);
					match(35);
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
				column_AST = (AST)currentAST.root;
				column_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ALIAS_EQU,"=")).add(column_AST));
				currentAST.root = column_AST;
				currentAST.child = column_AST!=null &&column_AST.getFirstChild()!=null ?
					column_AST.getFirstChild() : column_AST;
				currentAST.advanceChildToEnd();
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
		
		equation();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case LITERAL_and:
		case LITERAL_or:
		case 117:
		case 118:
		{
			logic_op();
			astFactory.addASTChild(currentAST, returnAST);
			search_condition();
			astFactory.addASTChild(currentAST, returnAST);
			search_condition_AST = (AST)currentAST.root;
			search_condition_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(LOGIC_OP,"logic_op")).add(search_condition_AST));
			currentAST.root = search_condition_AST;
			currentAST.child = search_condition_AST!=null &&search_condition_AST.getFirstChild()!=null ?
				search_condition_AST.getFirstChild() : search_condition_AST;
			currentAST.advanceChildToEnd();
			break;
		}
		case EOF:
		case SEMI:
		case LITERAL_group:
		case 29:
		case LITERAL_order:
		case 31:
		{
			break;
		}
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
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
				AST tmp123_AST = null;
				tmp123_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp123_AST);
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
		case 15:
		{
			tableUnion();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_t_compare:
		case 18:
		{
			tableCompare();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_select:
		case 22:
		{
			select_statement();
			astFactory.addASTChild(currentAST, returnAST);
			statement_AST = (AST)currentAST.root;
			statement_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(SELECT_STATEMENT)).add(statement_AST));
			currentAST.root = statement_AST;
			currentAST.child = statement_AST!=null &&statement_AST.getFirstChild()!=null ?
				statement_AST.getFirstChild() : statement_AST;
			currentAST.advanceChildToEnd();
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
			AST tmp125_AST = null;
			tmp125_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp125_AST);
			match(LITERAL_t_union);
			break;
		}
		case 15:
		{
			AST tmp126_AST = null;
			tmp126_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp126_AST);
			match(15);
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
			AST tmp128_AST = null;
			tmp128_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp128_AST);
			match(LITERAL_t_compare);
			break;
		}
		case 18:
		{
			AST tmp129_AST = null;
			tmp129_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp129_AST);
			match(18);
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
		case 20:
		{
			match(20);
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
			AST tmp133_AST = null;
			tmp133_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp133_AST);
			match(LITERAL_select);
			break;
		}
		case 22:
		{
			AST tmp134_AST = null;
			tmp134_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp134_AST);
			match(22);
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
			AST tmp135_AST = null;
			tmp135_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp135_AST);
			match(LITERAL_distinct);
			break;
		}
		case 24:
		{
			AST tmp136_AST = null;
			tmp136_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp136_AST);
			match(24);
			break;
		}
		case 36:
		case STAR:
		case LPAREN:
		case LITERAL_null:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case LITERAL_sqrt:
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
		case LITERAL_sum:
		case 87:
		case LITERAL_avg:
		case 89:
		case LITERAL_max:
		case 91:
		case LITERAL_min:
		case 93:
		case LITERAL_count:
		case 95:
		case ONE_ARG_OP:
		case 97:
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
		case 26:
		{
			{
			switch ( LA(1)) {
			case LITERAL_from:
			{
				AST tmp137_AST = null;
				tmp137_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp137_AST);
				match(LITERAL_from);
				break;
			}
			case 26:
			{
				AST tmp138_AST = null;
				tmp138_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp138_AST);
				match(26);
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
		case 20:
		case LITERAL_group:
		case 29:
		case LITERAL_order:
		case 31:
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
		case 20:
		{
			{
			switch ( LA(1)) {
			case LITERAL_where:
			{
				AST tmp139_AST = null;
				tmp139_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp139_AST);
				match(LITERAL_where);
				break;
			}
			case 20:
			{
				AST tmp140_AST = null;
				tmp140_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp140_AST);
				match(20);
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
		case 29:
		case LITERAL_order:
		case 31:
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
		case 29:
		{
			{
			switch ( LA(1)) {
			case LITERAL_group:
			{
				AST tmp141_AST = null;
				tmp141_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp141_AST);
				match(LITERAL_group);
				match(LITERAL_by);
				break;
			}
			case 29:
			{
				AST tmp143_AST = null;
				tmp143_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp143_AST);
				match(29);
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
		case 31:
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
		case 31:
		{
			{
			switch ( LA(1)) {
			case LITERAL_order:
			{
				AST tmp144_AST = null;
				tmp144_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp144_AST);
				match(LITERAL_order);
				match(LITERAL_by);
				break;
			}
			case 31:
			{
				AST tmp146_AST = null;
				tmp146_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp146_AST);
				match(31);
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
		
		AST tmp147_AST = null;
		tmp147_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp147_AST);
		match(ID);
		{
		switch ( LA(1)) {
		case LITERAL_as:
		case 33:
		{
			{
			switch ( LA(1)) {
			case LITERAL_as:
			{
				AST tmp148_AST = null;
				tmp148_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp148_AST);
				match(LITERAL_as);
				break;
			}
			case 33:
			{
				AST tmp149_AST = null;
				tmp149_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp149_AST);
				match(33);
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
		case 20:
		case LITERAL_group:
		case 29:
		case LITERAL_order:
		case 31:
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
		case 119:
		{
			AST tmp150_AST = null;
			tmp150_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp150_AST);
			match(119);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 120:
		{
			AST tmp151_AST = null;
			tmp151_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp151_AST);
			match(120);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_exist:
		{
			AST tmp152_AST = null;
			tmp152_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp152_AST);
			match(LITERAL_exist);
			comparemethod_name_AST = (AST)currentAST.root;
			break;
		}
		case 122:
		{
			AST tmp153_AST = null;
			tmp153_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp153_AST);
			match(122);
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
				AST tmp154_AST = null;
				tmp154_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp154_AST);
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
				AST tmp155_AST = null;
				tmp155_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp155_AST);
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
		_loop33:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp156_AST = null;
				tmp156_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp156_AST);
				match(COMMA);
				aggregate_expr();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop33;
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
		_loop36:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp157_AST = null;
				tmp157_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp157_AST);
				match(COMMA);
				order_expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop36;
			}
			
		} while (true);
		}
		order_expression_list_AST = (AST)currentAST.root;
		returnAST = order_expression_list_AST;
	}
	
	public final void equation() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST equation_AST = null;
		
		expression();
		astFactory.addASTChild(currentAST, returnAST);
		{
		switch ( LA(1)) {
		case 34:
		case 35:
		case COMPARE_OP:
		case LITERAL_like:
		case 109:
		case 110:
		case 111:
		case 112:
		case 113:
		case 114:
		case 115:
		{
			{
			switch ( LA(1)) {
			case 34:
			{
				AST tmp158_AST = null;
				tmp158_AST = astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp158_AST);
				match(34);
				break;
			}
			case 35:
			case COMPARE_OP:
			case LITERAL_like:
			case 109:
			case 110:
			case 111:
			case 112:
			case 113:
			case 114:
			case 115:
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
			equation_AST = (AST)currentAST.root;
			equation_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(COMPARE_OP,"comp_op")).add(equation_AST));
			currentAST.root = equation_AST;
			currentAST.child = equation_AST!=null &&equation_AST.getFirstChild()!=null ?
				equation_AST.getFirstChild() : equation_AST;
			currentAST.advanceChildToEnd();
			break;
		}
		case LITERAL_is:
		case 47:
		case 48:
		{
			{
			switch ( LA(1)) {
			case 47:
			{
				AST tmp159_AST = null;
				tmp159_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp159_AST);
				match(47);
				break;
			}
			case 48:
			{
				AST tmp160_AST = null;
				tmp160_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp160_AST);
				match(48);
				break;
			}
			default:
				if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_null)) {
					match(LITERAL_is);
					AST tmp162_AST = null;
					tmp162_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp162_AST);
					match(LITERAL_null);
				}
				else if ((LA(1)==LITERAL_is) && (LA(2)==LITERAL_not)) {
					match(LITERAL_is);
					AST tmp164_AST = null;
					tmp164_AST = astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp164_AST);
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
		case 50:
		{
			{
			switch ( LA(1)) {
			case LITERAL_between:
			{
				AST tmp166_AST = null;
				tmp166_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp166_AST);
				match(LITERAL_between);
				break;
			}
			case 50:
			{
				AST tmp167_AST = null;
				tmp167_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp167_AST);
				match(50);
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
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case ONE_ARG_OP:
			case 97:
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
		default:
		{
			throw new NoViableAltException(LT(1), getFilename());
		}
		}
		}
		equation_AST = (AST)currentAST.root;
		returnAST = equation_AST;
	}
	
	public final void logic_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST logic_op_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_and:
		{
			AST tmp169_AST = null;
			tmp169_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp169_AST);
			match(LITERAL_and);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_or:
		{
			AST tmp170_AST = null;
			tmp170_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp170_AST);
			match(LITERAL_or);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 117:
		{
			AST tmp171_AST = null;
			tmp171_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp171_AST);
			match(117);
			logic_op_AST = (AST)currentAST.root;
			break;
		}
		case 118:
		{
			AST tmp172_AST = null;
			tmp172_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp172_AST);
			match(118);
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
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
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
		case 99:
		case 100:
		case 101:
		case 102:
		case 103:
		case 104:
		case 105:
		case 106:
		{
			two_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_expr();
			astFactory.addASTChild(currentAST, returnAST);
			aggregate_expr_AST = (AST)currentAST.root;
			aggregate_expr_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(aggregate_expr_AST));
			currentAST.root = aggregate_expr_AST;
			currentAST.child = aggregate_expr_AST!=null &&aggregate_expr_AST.getFirstChild()!=null ?
				aggregate_expr_AST.getFirstChild() : aggregate_expr_AST;
			currentAST.advanceChildToEnd();
			break;
		}
		case EOF:
		case SEMI:
		case COMMA:
		case LITERAL_order:
		case 31:
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
		case 87:
		case LITERAL_avg:
		case 89:
		case LITERAL_max:
		case 91:
		case LITERAL_min:
		case 93:
		case LITERAL_count:
		case 95:
		{
			aggregate_func();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		case LITERAL_sqrt:
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
		{
			function();
			astFactory.addASTChild(currentAST, returnAST);
			break;
		}
		default:
			if ((LA(1)==ID||LA(1)==QUOTED_STRING) && (_tokenSet_2.member(LA(2)))) {
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
		case 38:
		{
			AST tmp173_AST = null;
			tmp173_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp173_AST);
			match(38);
			break;
		}
		case 39:
		{
			AST tmp174_AST = null;
			tmp174_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp174_AST);
			match(39);
			break;
		}
		case LITERAL_asc:
		{
			AST tmp175_AST = null;
			tmp175_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp175_AST);
			match(LITERAL_asc);
			break;
		}
		case LITERAL_desc:
		{
			AST tmp176_AST = null;
			tmp176_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp176_AST);
			match(LITERAL_desc);
			break;
		}
		case EOF:
		case SEMI:
		case COMMA:
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
		case LITERAL_sqrt:
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
		case LITERAL_sum:
		case 87:
		case LITERAL_avg:
		case 89:
		case LITERAL_max:
		case 91:
		case LITERAL_min:
		case 93:
		case LITERAL_count:
		case 95:
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
			{
				constant();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			{
				function();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_sum:
			case 87:
			case LITERAL_avg:
			case 89:
			case LITERAL_max:
			case 91:
			case LITERAL_min:
			case 93:
			case LITERAL_count:
			case 95:
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
			case 99:
			case 100:
			case 101:
			case 102:
			case 103:
			case 104:
			case 105:
			case 106:
			{
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression_with_aggr_func();
				astFactory.addASTChild(currentAST, returnAST);
				expression_with_aggr_func_AST = (AST)currentAST.root;
				expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_with_aggr_func_AST));
				currentAST.root = expression_with_aggr_func_AST;
				currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
					expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_where:
			case 20:
			case LITERAL_from:
			case 26:
			case LITERAL_group:
			case 29:
			case LITERAL_order:
			case 31:
			case LITERAL_as:
			case 33:
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
			expression_with_aggr_func_AST = (AST)currentAST.root;
			break;
		}
		case LPAREN:
		{
			AST tmp177_AST = null;
			tmp177_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp177_AST);
			match(LPAREN);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp178_AST = null;
			tmp178_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp178_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case 99:
			case 100:
			case 101:
			case 102:
			case 103:
			case 104:
			case 105:
			case 106:
			{
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression_with_aggr_func();
				astFactory.addASTChild(currentAST, returnAST);
				expression_with_aggr_func_AST = (AST)currentAST.root;
				expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_with_aggr_func_AST));
				currentAST.root = expression_with_aggr_func_AST;
				currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
					expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_where:
			case 20:
			case LITERAL_from:
			case 26:
			case LITERAL_group:
			case 29:
			case LITERAL_order:
			case 31:
			case LITERAL_as:
			case 33:
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
			expression_with_aggr_func_AST = (AST)currentAST.root;
			break;
		}
		case ONE_ARG_OP:
		case 97:
		{
			one_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			expression_with_aggr_func();
			astFactory.addASTChild(currentAST, returnAST);
			expression_with_aggr_func_AST = (AST)currentAST.root;
			expression_with_aggr_func_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ONE_ARG_OP,"one_arg_op")).add(expression_with_aggr_func_AST));
			currentAST.root = expression_with_aggr_func_AST;
			currentAST.child = expression_with_aggr_func_AST!=null &&expression_with_aggr_func_AST.getFirstChild()!=null ?
				expression_with_aggr_func_AST.getFirstChild() : expression_with_aggr_func_AST;
			currentAST.advanceChildToEnd();
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
			AST tmp179_AST = null;
			tmp179_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp179_AST);
			match(ID);
			alias_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp180_AST = null;
			tmp180_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp180_AST);
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
		
		AST tmp181_AST = null;
		tmp181_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp181_AST);
		match(ID);
		AST tmp182_AST = null;
		tmp182_AST = astFactory.create(LT(1));
		astFactory.makeASTRoot(currentAST, tmp182_AST);
		match(POINT);
		AST tmp183_AST = null;
		tmp183_AST = astFactory.create(LT(1));
		astFactory.addASTChild(currentAST, tmp183_AST);
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
			AST tmp186_AST = null;
			tmp186_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp186_AST);
			match(TWO_ARG_OP);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case STAR:
		{
			AST tmp187_AST = null;
			tmp187_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp187_AST);
			match(STAR);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 99:
		{
			AST tmp188_AST = null;
			tmp188_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp188_AST);
			match(99);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 100:
		{
			AST tmp189_AST = null;
			tmp189_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp189_AST);
			match(100);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 101:
		{
			AST tmp190_AST = null;
			tmp190_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp190_AST);
			match(101);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 102:
		{
			AST tmp191_AST = null;
			tmp191_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp191_AST);
			match(102);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 103:
		{
			AST tmp192_AST = null;
			tmp192_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp192_AST);
			match(103);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 104:
		{
			AST tmp193_AST = null;
			tmp193_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp193_AST);
			match(104);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 105:
		{
			AST tmp194_AST = null;
			tmp194_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp194_AST);
			match(105);
			two_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 106:
		{
			AST tmp195_AST = null;
			tmp195_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp195_AST);
			match(106);
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
			AST tmp197_AST = null;
			tmp197_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp197_AST);
			match(LITERAL_all);
			break;
		}
		case 57:
		{
			AST tmp198_AST = null;
			tmp198_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp198_AST);
			match(57);
			break;
		}
		case LITERAL_distinct:
		{
			AST tmp199_AST = null;
			tmp199_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp199_AST);
			match(LITERAL_distinct);
			break;
		}
		case 24:
		{
			AST tmp200_AST = null;
			tmp200_AST = astFactory.create(LT(1));
			astFactory.makeASTRoot(currentAST, tmp200_AST);
			match(24);
			break;
		}
		case LPAREN:
		case LITERAL_null:
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case LITERAL_sqrt:
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
		case ONE_ARG_OP:
		case 97:
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
		case ID:
		case QUOTED_STRING:
		case REAL_NUM:
		case LITERAL_sqrt:
		case 59:
		case LITERAL_getdate:
		case 61:
		case LITERAL_abs:
		case 63:
		case LITERAL_substring:
		case 65:
		case LITERAL_round:
		case 67:
		case LITERAL_right:
		case 69:
		case LITERAL_ltrim:
		case 71:
		case LITERAL_rtrim:
		case 73:
		case LITERAL_char_length:
		case 75:
		case LITERAL_floor:
		case 77:
		case LITERAL_ceiling:
		case 79:
		case LITERAL_lower:
		case 81:
		case LITERAL_charindex:
		case 83:
		case LITERAL_str:
		case 85:
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
			{
				constant();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
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
			case 99:
			case 100:
			case 101:
			case 102:
			case 103:
			case 104:
			case 105:
			case 106:
			{
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				expression_AST = (AST)currentAST.root;
				expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_AST));
				currentAST.root = expression_AST;
				currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
					expression_AST.getFirstChild() : expression_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_group:
			case 29:
			case LITERAL_order:
			case 31:
			case 34:
			case 35:
			case LPAREN:
			case RPAREN:
			case LITERAL_is:
			case LITERAL_null:
			case 47:
			case 48:
			case LITERAL_between:
			case 50:
			case LITERAL_and:
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case ONE_ARG_OP:
			case 97:
			case COMPARE_OP:
			case LITERAL_like:
			case 109:
			case 110:
			case 111:
			case 112:
			case 113:
			case 114:
			case 115:
			case LITERAL_or:
			case 117:
			case 118:
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
			AST tmp202_AST = null;
			tmp202_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp202_AST);
			match(LPAREN);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			AST tmp203_AST = null;
			tmp203_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp203_AST);
			match(RPAREN);
			{
			switch ( LA(1)) {
			case STAR:
			case TWO_ARG_OP:
			case 99:
			case 100:
			case 101:
			case 102:
			case 103:
			case 104:
			case 105:
			case 106:
			{
				two_arg_op();
				astFactory.addASTChild(currentAST, returnAST);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
				expression_AST = (AST)currentAST.root;
				expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(TWO_ARG_OP,"two_arg_op")).add(expression_AST));
				currentAST.root = expression_AST;
				currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
					expression_AST.getFirstChild() : expression_AST;
				currentAST.advanceChildToEnd();
				break;
			}
			case EOF:
			case SEMI:
			case COMMA:
			case LITERAL_group:
			case 29:
			case LITERAL_order:
			case 31:
			case 34:
			case 35:
			case LPAREN:
			case RPAREN:
			case LITERAL_is:
			case LITERAL_null:
			case 47:
			case 48:
			case LITERAL_between:
			case 50:
			case LITERAL_and:
			case ID:
			case QUOTED_STRING:
			case REAL_NUM:
			case LITERAL_sqrt:
			case 59:
			case LITERAL_getdate:
			case 61:
			case LITERAL_abs:
			case 63:
			case LITERAL_substring:
			case 65:
			case LITERAL_round:
			case 67:
			case LITERAL_right:
			case 69:
			case LITERAL_ltrim:
			case 71:
			case LITERAL_rtrim:
			case 73:
			case LITERAL_char_length:
			case 75:
			case LITERAL_floor:
			case 77:
			case LITERAL_ceiling:
			case 79:
			case LITERAL_lower:
			case 81:
			case LITERAL_charindex:
			case 83:
			case LITERAL_str:
			case 85:
			case ONE_ARG_OP:
			case 97:
			case COMPARE_OP:
			case LITERAL_like:
			case 109:
			case 110:
			case 111:
			case 112:
			case 113:
			case 114:
			case 115:
			case LITERAL_or:
			case 117:
			case 118:
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
		case 97:
		{
			one_arg_op();
			astFactory.addASTChild(currentAST, returnAST);
			expression();
			astFactory.addASTChild(currentAST, returnAST);
			expression_AST = (AST)currentAST.root;
			expression_AST=(AST)astFactory.make( (new ASTArray(2)).add(astFactory.create(ONE_ARG_OP,"one_arg_op")).add(expression_AST));
			currentAST.root = expression_AST;
			currentAST.child = expression_AST!=null &&expression_AST.getFirstChild()!=null ?
				expression_AST.getFirstChild() : expression_AST;
			currentAST.advanceChildToEnd();
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
			AST tmp204_AST = null;
			tmp204_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp204_AST);
			match(REAL_NUM);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case QUOTED_STRING:
		{
			AST tmp205_AST = null;
			tmp205_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp205_AST);
			match(QUOTED_STRING);
			constant_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_null:
		{
			AST tmp206_AST = null;
			tmp206_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp206_AST);
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
	
	public final void one_arg_op() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST one_arg_op_AST = null;
		
		switch ( LA(1)) {
		case ONE_ARG_OP:
		{
			AST tmp207_AST = null;
			tmp207_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp207_AST);
			match(ONE_ARG_OP);
			one_arg_op_AST = (AST)currentAST.root;
			break;
		}
		case 97:
		{
			AST tmp208_AST = null;
			tmp208_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp208_AST);
			match(97);
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
			AST tmp209_AST = null;
			tmp209_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp209_AST);
			match(COMPARE_OP);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 35:
		{
			AST tmp210_AST = null;
			tmp210_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp210_AST);
			match(35);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_like:
		{
			AST tmp211_AST = null;
			tmp211_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp211_AST);
			match(LITERAL_like);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 109:
		{
			AST tmp212_AST = null;
			tmp212_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp212_AST);
			match(109);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 110:
		{
			AST tmp213_AST = null;
			tmp213_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp213_AST);
			match(110);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 111:
		{
			AST tmp214_AST = null;
			tmp214_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp214_AST);
			match(111);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 112:
		{
			AST tmp215_AST = null;
			tmp215_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp215_AST);
			match(112);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 113:
		{
			AST tmp216_AST = null;
			tmp216_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp216_AST);
			match(113);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 114:
		{
			AST tmp217_AST = null;
			tmp217_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp217_AST);
			match(114);
			compare_op_AST = (AST)currentAST.root;
			break;
		}
		case 115:
		{
			AST tmp218_AST = null;
			tmp218_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp218_AST);
			match(115);
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
	
	public final void function_name() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		AST function_name_AST = null;
		
		switch ( LA(1)) {
		case LITERAL_sqrt:
		{
			AST tmp219_AST = null;
			tmp219_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp219_AST);
			match(LITERAL_sqrt);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 59:
		{
			AST tmp220_AST = null;
			tmp220_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp220_AST);
			match(59);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_getdate:
		{
			AST tmp221_AST = null;
			tmp221_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp221_AST);
			match(LITERAL_getdate);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 61:
		{
			AST tmp222_AST = null;
			tmp222_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp222_AST);
			match(61);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_abs:
		{
			AST tmp223_AST = null;
			tmp223_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp223_AST);
			match(LITERAL_abs);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 63:
		{
			AST tmp224_AST = null;
			tmp224_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp224_AST);
			match(63);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_substring:
		{
			AST tmp225_AST = null;
			tmp225_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp225_AST);
			match(LITERAL_substring);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 65:
		{
			AST tmp226_AST = null;
			tmp226_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp226_AST);
			match(65);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_round:
		{
			AST tmp227_AST = null;
			tmp227_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp227_AST);
			match(LITERAL_round);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 67:
		{
			AST tmp228_AST = null;
			tmp228_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp228_AST);
			match(67);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_right:
		{
			AST tmp229_AST = null;
			tmp229_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp229_AST);
			match(LITERAL_right);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 69:
		{
			AST tmp230_AST = null;
			tmp230_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp230_AST);
			match(69);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ltrim:
		{
			AST tmp231_AST = null;
			tmp231_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp231_AST);
			match(LITERAL_ltrim);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 71:
		{
			AST tmp232_AST = null;
			tmp232_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp232_AST);
			match(71);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_rtrim:
		{
			AST tmp233_AST = null;
			tmp233_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp233_AST);
			match(LITERAL_rtrim);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 73:
		{
			AST tmp234_AST = null;
			tmp234_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp234_AST);
			match(73);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_char_length:
		{
			AST tmp235_AST = null;
			tmp235_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp235_AST);
			match(LITERAL_char_length);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 75:
		{
			AST tmp236_AST = null;
			tmp236_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp236_AST);
			match(75);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_floor:
		{
			AST tmp237_AST = null;
			tmp237_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp237_AST);
			match(LITERAL_floor);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 77:
		{
			AST tmp238_AST = null;
			tmp238_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp238_AST);
			match(77);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_ceiling:
		{
			AST tmp239_AST = null;
			tmp239_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp239_AST);
			match(LITERAL_ceiling);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 79:
		{
			AST tmp240_AST = null;
			tmp240_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp240_AST);
			match(79);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_lower:
		{
			AST tmp241_AST = null;
			tmp241_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp241_AST);
			match(LITERAL_lower);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 81:
		{
			AST tmp242_AST = null;
			tmp242_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp242_AST);
			match(81);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_charindex:
		{
			AST tmp243_AST = null;
			tmp243_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp243_AST);
			match(LITERAL_charindex);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 83:
		{
			AST tmp244_AST = null;
			tmp244_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp244_AST);
			match(83);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_str:
		{
			AST tmp245_AST = null;
			tmp245_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp245_AST);
			match(LITERAL_str);
			function_name_AST = (AST)currentAST.root;
			break;
		}
		case 85:
		{
			AST tmp246_AST = null;
			tmp246_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp246_AST);
			match(85);
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
		_loop69:
		do {
			if ((LA(1)==COMMA)) {
				AST tmp247_AST = null;
				tmp247_AST = astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp247_AST);
				match(COMMA);
				expression();
				astFactory.addASTChild(currentAST, returnAST);
			}
			else {
				break _loop69;
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
			AST tmp248_AST = null;
			tmp248_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp248_AST);
			match(LITERAL_sum);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 87:
		{
			AST tmp249_AST = null;
			tmp249_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp249_AST);
			match(87);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_avg:
		{
			AST tmp250_AST = null;
			tmp250_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp250_AST);
			match(LITERAL_avg);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 89:
		{
			AST tmp251_AST = null;
			tmp251_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp251_AST);
			match(89);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_max:
		{
			AST tmp252_AST = null;
			tmp252_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp252_AST);
			match(LITERAL_max);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 91:
		{
			AST tmp253_AST = null;
			tmp253_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp253_AST);
			match(91);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_min:
		{
			AST tmp254_AST = null;
			tmp254_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp254_AST);
			match(LITERAL_min);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 93:
		{
			AST tmp255_AST = null;
			tmp255_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp255_AST);
			match(93);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case LITERAL_count:
		{
			AST tmp256_AST = null;
			tmp256_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp256_AST);
			match(LITERAL_count);
			aggregate_func_name_AST = (AST)currentAST.root;
			break;
		}
		case 95:
		{
			AST tmp257_AST = null;
			tmp257_AST = astFactory.create(LT(1));
			astFactory.addASTChild(currentAST, tmp257_AST);
			match(95);
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
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SELECT_STATEMENT",
		"GROUP_BY",
		"ORDER_BY",
		"ALIAS_EQU",
		"FUNCTION",
		"LOGIC_OP",
		"ALL_FIELDS",
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
		"LPAREN",
		"RPAREN",
		"\"is\"",
		"\"null\"",
		"\"not\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"and\"",
		"ID",
		"QUOTED_STRING",
		"POINT",
		"REAL_NUM",
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
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"\"not exist\"",
		"\"\\u4e0d\\u5b58\\u5728\"",
		"\"exist\"",
		"\"\\u5b58\\u5728\"",
		"NOT_EXIST",
		"EXIST",
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
		long[] data = { -238651197832036352L, 17179869183L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { -220636645004075006L, 8796093022207L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 4123168677890L, 0L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	
	}
