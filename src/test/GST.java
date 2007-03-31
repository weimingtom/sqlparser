// $ANTLR 2.7.7 (2006-11-01): "src/test/getting_start.g" -> "GST.java"$

package test;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class GST extends antlr.TreeParser       implements GSPTokenTypes
 {
public GST() {
	tokenNames = _tokenNames;
}

	public final void keywords(AST _t) throws RecognitionException {
		
		AST keywords_AST_in = (_t == ASTNULL) ? null : (AST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_select:
			{
				AST tmp1_AST_in = (AST)_t;
				match(_t,LITERAL_select);
				_t = _t.getNextSibling();
				break;
			}
			case 7:
			{
				AST tmp2_AST_in = (AST)_t;
				match(_t,7);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_from:
			{
				AST tmp3_AST_in = (AST)_t;
				match(_t,LITERAL_from);
				_t = _t.getNextSibling();
				break;
			}
			case 9:
			{
				AST tmp4_AST_in = (AST)_t;
				match(_t,9);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_where:
			{
				AST tmp5_AST_in = (AST)_t;
				match(_t,LITERAL_where);
				_t = _t.getNextSibling();
				break;
			}
			case 12:
			{
				AST tmp6_AST_in = (AST)_t;
				match(_t,12);
				_t = _t.getNextSibling();
				break;
			}
			case 13:
			{
				AST tmp7_AST_in = (AST)_t;
				match(_t,13);
				_t = _t.getNextSibling();
				break;
			}
			case 14:
			{
				AST tmp8_AST_in = (AST)_t;
				match(_t,14);
				_t = _t.getNextSibling();
				break;
			}
			case 15:
			{
				AST tmp9_AST_in = (AST)_t;
				match(_t,15);
				_t = _t.getNextSibling();
				break;
			}
			case 16:
			{
				AST tmp10_AST_in = (AST)_t;
				match(_t,16);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_all:
			{
				AST tmp11_AST_in = (AST)_t;
				match(_t,LITERAL_all);
				_t = _t.getNextSibling();
				break;
			}
			case 18:
			{
				AST tmp12_AST_in = (AST)_t;
				match(_t,18);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_distinct:
			{
				AST tmp13_AST_in = (AST)_t;
				match(_t,LITERAL_distinct);
				_t = _t.getNextSibling();
				break;
			}
			case 20:
			{
				AST tmp14_AST_in = (AST)_t;
				match(_t,20);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_asc:
			{
				AST tmp15_AST_in = (AST)_t;
				match(_t,LITERAL_asc);
				_t = _t.getNextSibling();
				break;
			}
			case 22:
			{
				AST tmp16_AST_in = (AST)_t;
				match(_t,22);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_desc:
			{
				AST tmp17_AST_in = (AST)_t;
				match(_t,LITERAL_desc);
				_t = _t.getNextSibling();
				break;
			}
			case 24:
			{
				AST tmp18_AST_in = (AST)_t;
				match(_t,24);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_as:
			{
				AST tmp19_AST_in = (AST)_t;
				match(_t,LITERAL_as);
				_t = _t.getNextSibling();
				break;
			}
			case 26:
			{
				AST tmp20_AST_in = (AST)_t;
				match(_t,26);
				_t = _t.getNextSibling();
				break;
			}
			case ONE_ARG_OP:
			{
				AST tmp21_AST_in = (AST)_t;
				match(_t,ONE_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 28:
			{
				AST tmp22_AST_in = (AST)_t;
				match(_t,28);
				_t = _t.getNextSibling();
				break;
			}
			case TWO_ARG_OP:
			{
				AST tmp23_AST_in = (AST)_t;
				match(_t,TWO_ARG_OP);
				_t = _t.getNextSibling();
				break;
			}
			case 30:
			{
				AST tmp24_AST_in = (AST)_t;
				match(_t,30);
				_t = _t.getNextSibling();
				break;
			}
			case 31:
			{
				AST tmp25_AST_in = (AST)_t;
				match(_t,31);
				_t = _t.getNextSibling();
				break;
			}
			case 32:
			{
				AST tmp26_AST_in = (AST)_t;
				match(_t,32);
				_t = _t.getNextSibling();
				break;
			}
			case 33:
			{
				AST tmp27_AST_in = (AST)_t;
				match(_t,33);
				_t = _t.getNextSibling();
				break;
			}
			case 34:
			{
				AST tmp28_AST_in = (AST)_t;
				match(_t,34);
				_t = _t.getNextSibling();
				break;
			}
			case 35:
			{
				AST tmp29_AST_in = (AST)_t;
				match(_t,35);
				_t = _t.getNextSibling();
				break;
			}
			case 36:
			{
				AST tmp30_AST_in = (AST)_t;
				match(_t,36);
				_t = _t.getNextSibling();
				break;
			}
			case 37:
			{
				AST tmp31_AST_in = (AST)_t;
				match(_t,37);
				_t = _t.getNextSibling();
				break;
			}
			case COMPARE_OP:
			{
				AST tmp32_AST_in = (AST)_t;
				match(_t,COMPARE_OP);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_like:
			{
				AST tmp33_AST_in = (AST)_t;
				match(_t,LITERAL_like);
				_t = _t.getNextSibling();
				break;
			}
			case 40:
			{
				AST tmp34_AST_in = (AST)_t;
				match(_t,40);
				_t = _t.getNextSibling();
				break;
			}
			case 41:
			{
				AST tmp35_AST_in = (AST)_t;
				match(_t,41);
				_t = _t.getNextSibling();
				break;
			}
			case 42:
			{
				AST tmp36_AST_in = (AST)_t;
				match(_t,42);
				_t = _t.getNextSibling();
				break;
			}
			case 43:
			{
				AST tmp37_AST_in = (AST)_t;
				match(_t,43);
				_t = _t.getNextSibling();
				break;
			}
			case 44:
			{
				AST tmp38_AST_in = (AST)_t;
				match(_t,44);
				_t = _t.getNextSibling();
				break;
			}
			case 45:
			{
				AST tmp39_AST_in = (AST)_t;
				match(_t,45);
				_t = _t.getNextSibling();
				break;
			}
			case 46:
			{
				AST tmp40_AST_in = (AST)_t;
				match(_t,46);
				_t = _t.getNextSibling();
				break;
			}
			case 47:
			{
				AST tmp41_AST_in = (AST)_t;
				match(_t,47);
				_t = _t.getNextSibling();
				break;
			}
			case 48:
			{
				AST tmp42_AST_in = (AST)_t;
				match(_t,48);
				_t = _t.getNextSibling();
				break;
			}
			case 49:
			{
				AST tmp43_AST_in = (AST)_t;
				match(_t,49);
				_t = _t.getNextSibling();
				break;
			}
			case 50:
			{
				AST tmp44_AST_in = (AST)_t;
				match(_t,50);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_between:
			{
				AST tmp45_AST_in = (AST)_t;
				match(_t,LITERAL_between);
				_t = _t.getNextSibling();
				break;
			}
			case 52:
			{
				AST tmp46_AST_in = (AST)_t;
				match(_t,52);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_and:
			{
				AST tmp47_AST_in = (AST)_t;
				match(_t,LITERAL_and);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_or:
			{
				AST tmp48_AST_in = (AST)_t;
				match(_t,LITERAL_or);
				_t = _t.getNextSibling();
				break;
			}
			case 55:
			{
				AST tmp49_AST_in = (AST)_t;
				match(_t,55);
				_t = _t.getNextSibling();
				break;
			}
			case 56:
			{
				AST tmp50_AST_in = (AST)_t;
				match(_t,56);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"SELECT",
		"FROM",
		"\"select\"",
		"\"\\u67e5\\u8be2\"",
		"\"from\"",
		"\"\\u6765\\u81ea\"",
		"ID",
		"\"where\"",
		"\"\\u6761\\u4ef6\"",
		"\"group by\"",
		"\"\\u5206\\u7ec4\"",
		"\"order by\"",
		"\"\\u6392\\u5e8f\"",
		"\"all\"",
		"\"\\u022b\\ufffd\\ufffd\\u5168\\u90e8\"",
		"\"distinct\"",
		"\"\\u552f\\u4e00\"",
		"\"asc\"",
		"\"\\u5347\\u5e8f\"",
		"\"desc\"",
		"\"\\u964d\\u5e8f\"",
		"\"as\"",
		"\"\\u4f5c\\u4e3a\"",
		"ONE_ARG_OP",
		"\"\\u975e\"",
		"TWO_ARG_OP",
		"\"\\u52a0\"",
		"\"\\u51cf\"",
		"\"\\u4e58\"",
		"\"\\u9664\"",
		"\"\\u4e0e\"",
		"\"\\u6216\"",
		"\"\\u6c42\\u6a21\"",
		"\"\\u5f02\\u6216\"",
		"COMPARE_OP",
		"\"like\"",
		"\"\\u5927\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\\u7b49\\u4e8e\"",
		"\"\\u5927\\u4e8e\"",
		"\"\\u5c0f\\u4e8e\"",
		"\"\\u4e0d\\u7b49\\u4e8e\"",
		"\"\\u5305\\u542b\"",
		"\"\\u4e0d\\u5305\\u542b\"",
		"\"is null\"",
		"\"\\u4e3a\\u7a7a\"",
		"\"is not null\"",
		"\"\\u975e\\u7a7a\"",
		"\"between\"",
		"\"\\u8303\\u56f4\"",
		"\"and\"",
		"\"or\"",
		"\"\\u5e76\\u4e14\"",
		"\"\\u6216\\u8005\"",
		"ALL_FIELDS",
		"EQU",
		"COMMA",
		"SEMI",
		"LPAREN",
		"RPAREN",
		"WS",
		"POINT",
		"QUOTED_STRING",
		"ESC",
		"ID_START_LETTER",
		"ID_LETTER",
		"REAL_NUM",
		"NUM",
		"DOT_NUM",
		"NUM_START",
		"NUM_LETTER",
		"ML_COMMENT"
	};
	
	}
	
