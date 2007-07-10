// $ANTLR 2.7.7 (2006-11-01): "src/parser/oracle/parser_oracle.g" -> "Oracle9iLexer.java"$

	package parser.oracle;

import java.io.InputStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.ANTLRException;
import java.io.Reader;
import java.util.Hashtable;
import antlr.CharScanner;
import antlr.InputBuffer;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.Token;
import antlr.CommonToken;
import antlr.RecognitionException;
import antlr.NoViableAltForCharException;
import antlr.MismatchedCharException;
import antlr.TokenStream;
import antlr.ANTLRHashString;
import antlr.LexerSharedInputState;
import antlr.collections.impl.BitSet;
import antlr.SemanticException;

public class Oracle9iLexer extends antlr.CharScanner implements Oracle9iParserTokenTypes, TokenStream
 {
public Oracle9iLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public Oracle9iLexer(Reader in) {
	this(new CharBuffer(in));
}
public Oracle9iLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public Oracle9iLexer(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = false;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("upper", this), new Integer(205));
	literals.put(new ANTLRHashString("\u4e8c\u8fdb\u5236\u8f6c\u4e3a\u6570\u503c", this), new Integer(218));
	literals.put(new ANTLRHashString("t_union", this), new Integer(37));
	literals.put(new ANTLRHashString("\u5355\u8bcd\u9996\u5b57\u6bcd\u5927\u51991", this), new Integer(172));
	literals.put(new ANTLRHashString("\u6c42\u4f59\u5f26\u503c", this), new Integer(132));
	literals.put(new ANTLRHashString("avg", this), new Integer(103));
	literals.put(new ANTLRHashString("dd", this), new Integer(298));
	literals.put(new ANTLRHashString("\u6c42\u4e32\u4f4d\u7f6e", this), new Integer(174));
	literals.put(new ANTLRHashString("least", this), new Integer(257));
	literals.put(new ANTLRHashString("bfile", this), new Integer(329));
	literals.put(new ANTLRHashString("nls_lower", this), new Integer(185));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5927\u503c", this), new Integer(106));
	literals.put(new ANTLRHashString("\u6c42\u7b49\u503c\u7684\u5b57\u7b26", this), new Integer(168));
	literals.put(new ANTLRHashString("\u683c\u5f0f\u5316\u6570\u503c", this), new Integer(148));
	literals.put(new ANTLRHashString("weekday", this), new Integer(309));
	literals.put(new ANTLRHashString("new_time", this), new Integer(213));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32ASCII\u7801", this), new Integer(166));
	literals.put(new ANTLRHashString("hh12", this), new Integer(313));
	literals.put(new ANTLRHashString("count", this), new Integer(91));
	literals.put(new ANTLRHashString("tan", this), new Integer(157));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u65e5\u671f\u578b", this), new Integer(232));
	literals.put(new ANTLRHashString("day", this), new Integer(297));
	literals.put(new ANTLRHashString("\u6c42\u6b63\u5f26\u503c", this), new Integer(152));
	literals.put(new ANTLRHashString("week", this), new Integer(303));
	literals.put(new ANTLRHashString("\u6216\u8005", this), new Integer(63));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5c0f\u503c", this), new Integer(108));
	literals.put(new ANTLRHashString("\u552f\u4e00", this), new Integer(51));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u4f59\u5f26\u503c", this), new Integer(122));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u6bb5\u5927\u5c0f", this), new Integer(246));
	literals.put(new ANTLRHashString("trunc", this), new Integer(161));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5c0f\u8868\u8fbe\u5f0f", this), new Integer(258));
	literals.put(new ANTLRHashString("\u4e58", this), new Integer(268));
	literals.put(new ANTLRHashString("\u8fd4\u56de\u6570\u636e\u683c\u5f0f", this), new Integer(250));
	literals.put(new ANTLRHashString("\u6c42ASCII\u7801", this), new Integer(164));
	literals.put(new ANTLRHashString("ms", this), new Integer(322));
	literals.put(new ANTLRHashString("\u52a0", this), new Integer(266));
	literals.put(new ANTLRHashString("\u5728\u4e8e", this), new Integer(86));
	literals.put(new ANTLRHashString("\u6c42\u603b\u548c", this), new Integer(112));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u5de6\u8865", this), new Integer(182));
	literals.put(new ANTLRHashString("initcap", this), new Integer(171));
	literals.put(new ANTLRHashString("is", this), new Integer(79));
	literals.put(new ANTLRHashString("\u6c42\u6807\u51c6\u5dee", this), new Integer(110));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u591a\u5b57\u8282\u578b", this), new Integer(234));
	literals.put(new ANTLRHashString("\u53d6\u4e0a\u9650\u6574\u6570", this), new Integer(130));
	literals.put(new ANTLRHashString("to_single_byte", this), new Integer(237));
	literals.put(new ANTLRHashString("rowid", this), new Integer(325));
	literals.put(new ANTLRHashString("length", this), new Integer(175));
	literals.put(new ANTLRHashString("and", this), new Integer(60));
	literals.put(new ANTLRHashString("\u6708\u4efd\u8fd0\u7b97", this), new Integer(208));
	literals.put(new ANTLRHashString("concat", this), new Integer(169));
	literals.put(new ANTLRHashString("user", this), new Integer(241));
	literals.put(new ANTLRHashString("dy", this), new Integer(307));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5927\u8868\u8fbe\u5f0f", this), new Integer(256));
	literals.put(new ANTLRHashString("as", this), new Integer(66));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u6570", this), new Integer(142));
	literals.put(new ANTLRHashString("convert", this), new Integer(221));
	literals.put(new ANTLRHashString("nls_initcap", this), new Integer(183));
	literals.put(new ANTLRHashString("desc", this), new Integer(74));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5b57\u7b26\u578b", this), new Integer(230));
	literals.put(new ANTLRHashString("\u6c42\u65e5\u671f\u6700\u540e\u4e00\u5929", this), new Integer(210));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u6b63\u5f26\u503c", this), new Integer(124));
	literals.put(new ANTLRHashString("exists", this), new Integer(44));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u53f3\u8865", this), new Integer(194));
	literals.put(new ANTLRHashString("qq", this), new Integer(301));
	literals.put(new ANTLRHashString("like", this), new Integer(76));
	literals.put(new ANTLRHashString("date", this), new Integer(324));
	literals.put(new ANTLRHashString("\u9664", this), new Integer(269));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u6700\u5927\u503c", this), new Integer(348));
	literals.put(new ANTLRHashString("variance", this), new Integer(113));
	literals.put(new ANTLRHashString("hextoraw", this), new Integer(223));
	literals.put(new ANTLRHashString("dayofyear", this), new Integer(306));
	literals.put(new ANTLRHashString("SYSDATE", this), new Integer(115));
	literals.put(new ANTLRHashString("\u5347\u5e8f", this), new Integer(73));
	literals.put(new ANTLRHashString("\u6c42\u4f59\u5207\u503c", this), new Integer(134));
	literals.put(new ANTLRHashString("rownum", this), new Integer(88));
	literals.put(new ANTLRHashString("dw", this), new Integer(310));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8f6c\u4e3a\u884c\u53f7", this), new Integer(220));
	literals.put(new ANTLRHashString("nlssort", this), new Integer(187));
	literals.put(new ANTLRHashString("trim", this), new Integer(201));
	literals.put(new ANTLRHashString("between", this), new Integer(84));
	literals.put(new ANTLRHashString("millisecond", this), new Integer(321));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e\u7b49\u4e8e", this), new Integer(279));
	literals.put(new ANTLRHashString("\u4e8c\u8fdb\u5236\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236", this), new Integer(226));
	literals.put(new ANTLRHashString("substr", this), new Integer(199));
	literals.put(new ANTLRHashString("\u51cf", this), new Integer(267));
	literals.put(new ANTLRHashString("\u6c42\u6807\u8bc6\u7f16\u53f7", this), new Integer(240));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c", this), new Integer(198));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u6700\u5c0f\u503c", this), new Integer(349));
	literals.put(new ANTLRHashString("\u683c\u5f0f\u5316\u6570\u503c2", this), new Integer(162));
	literals.put(new ANTLRHashString("to_multi_byte", this), new Integer(233));
	literals.put(new ANTLRHashString("empty_clob", this), new Integer(253));
	literals.put(new ANTLRHashString("d", this), new Integer(299));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u957f\u5ea6", this), new Integer(176));
	literals.put(new ANTLRHashString("\u975e\u8fd0\u7b97", this), new Integer(262));
	literals.put(new ANTLRHashString("t_compare", this), new Integer(40));
	literals.put(new ANTLRHashString("long", this), new Integer(323));
	literals.put(new ANTLRHashString("\u6c42\u6b63\u5207\u503c", this), new Integer(158));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd2", this), new Integer(190));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u6392\u5e8f", this), new Integer(188));
	literals.put(new ANTLRHashString("\u6c42\u53cc\u66f2\u6b63\u5f26\u503c", this), new Integer(154));
	literals.put(new ANTLRHashString("not", this), new Integer(47));
	literals.put(new ANTLRHashString("\u5927\u4e8e\u7b49\u4e8e", this), new Integer(278));
	literals.put(new ANTLRHashString("\u8303\u56f4", this), new Integer(83));
	literals.put(new ANTLRHashString("all", this), new Integer(93));
	literals.put(new ANTLRHashString("in", this), new Integer(85));
	literals.put(new ANTLRHashString("rawtohex", this), new Integer(225));
	literals.put(new ANTLRHashString("\u53bb\u5de6\u53f3\u7a7a\u683c", this), new Integer(202));
	literals.put(new ANTLRHashString("\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4", this), new Integer(116));
	literals.put(new ANTLRHashString("nclob", this), new Integer(327));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5927\u5199\u5b57\u6bcd1", this), new Integer(206));
	literals.put(new ANTLRHashString("sign", this), new Integer(149));
	literals.put(new ANTLRHashString("\u6c42\u6a21", this), new Integer(144));
	literals.put(new ANTLRHashString("empty_blob", this), new Integer(251));
	literals.put(new ANTLRHashString("mm", this), new Integer(295));
	literals.put(new ANTLRHashString("\u5168\u90e8", this), new Integer(94));
	literals.put(new ANTLRHashString("\u8868\u5408\u5e76", this), new Integer(38));
	literals.put(new ANTLRHashString("hour", this), new Integer(311));
	literals.put(new ANTLRHashString("\u53bb\u6389\u5de6\u7a7a\u683c", this), new Integer(180));
	literals.put(new ANTLRHashString("\u6c42\u5e42\u503c", this), new Integer(136));
	literals.put(new ANTLRHashString("\u53d6\u4e0b\u9650\u6574\u6570", this), new Integer(138));
	literals.put(new ANTLRHashString("quarter", this), new Integer(300));
	literals.put(new ANTLRHashString("clob", this), new Integer(326));
	literals.put(new ANTLRHashString("ceil", this), new Integer(129));
	literals.put(new ANTLRHashString("add_months", this), new Integer(207));
	literals.put(new ANTLRHashString("chr", this), new Integer(167));
	literals.put(new ANTLRHashString("to_char", this), new Integer(229));
	literals.put(new ANTLRHashString("acos", this), new Integer(121));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u6b63\u5207\u503c", this), new Integer(126));
	literals.put(new ANTLRHashString("null", this), new Integer(80));
	literals.put(new ANTLRHashString("\u5de6\u8fde\u63a5", this), new Integer(347));
	literals.put(new ANTLRHashString("\u5e76\u4e14", this), new Integer(62));
	literals.put(new ANTLRHashString("lower", this), new Integer(177));
	literals.put(new ANTLRHashString("y", this), new Integer(308));
	literals.put(new ANTLRHashString("\u4f5c\u4e3a", this), new Integer(67));
	literals.put(new ANTLRHashString("asciistr", this), new Integer(165));
	literals.put(new ANTLRHashString("\u6c42\u5f53\u524d\u7528\u6237\u73af\u5883\u4fe1\u606f", this), new Integer(244));
	literals.put(new ANTLRHashString("rpad", this), new Integer(193));
	literals.put(new ANTLRHashString("\u53bb\u6389\u53f3\u7a7a\u683c", this), new Integer(196));
	literals.put(new ANTLRHashString("blob", this), new Integer(328));
	literals.put(new ANTLRHashString("month", this), new Integer(294));
	literals.put(new ANTLRHashString("\u6c42\u8bb0\u5f55\u603b\u6570", this), new Integer(92));
	literals.put(new ANTLRHashString("\u6c42\u884c\u53f7", this), new Integer(89));
	literals.put(new ANTLRHashString("distinct", this), new Integer(50));
	literals.put(new ANTLRHashString("tanh", this), new Integer(159));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u66ff\u6362", this), new Integer(192));
	literals.put(new ANTLRHashString("ltrim", this), new Integer(179));
	literals.put(new ANTLRHashString("yyyy", this), new Integer(293));
	literals.put(new ANTLRHashString("\u6570\u636e\u7c7b\u578b\u8f6c\u5316", this), new Integer(118));
	literals.put(new ANTLRHashString("instr", this), new Integer(173));
	literals.put(new ANTLRHashString("\u964d\u5e8f", this), new Integer(75));
	literals.put(new ANTLRHashString("\u5b58\u5728", this), new Integer(45));
	literals.put(new ANTLRHashString("\u6c42\u5e42", this), new Integer(146));
	literals.put(new ANTLRHashString("w", this), new Integer(305));
	literals.put(new ANTLRHashString("log", this), new Integer(141));
	literals.put(new ANTLRHashString("stddev", this), new Integer(109));
	literals.put(new ANTLRHashString("mi", this), new Integer(316));
	literals.put(new ANTLRHashString("\u67e5\u8be2", this), new Integer(49));
	literals.put(new ANTLRHashString("max", this), new Integer(105));
	literals.put(new ANTLRHashString("bin_to_num", this), new Integer(217));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5355\u5b57\u8282\u578b", this), new Integer(238));
	literals.put(new ANTLRHashString("\u975e\u7a7a", this), new Integer(82));
	literals.put(new ANTLRHashString("nls_upper", this), new Integer(189));
	literals.put(new ANTLRHashString("\u4e0e", this), new Integer(263));
	literals.put(new ANTLRHashString("round", this), new Integer(147));
	literals.put(new ANTLRHashString("\u4e0d\u5b58\u5728", this), new Integer(46));
	literals.put(new ANTLRHashString("abs", this), new Integer(119));
	literals.put(new ANTLRHashString("ln", this), new Integer(139));
	literals.put(new ANTLRHashString("soundex", this), new Integer(197));
	literals.put(new ANTLRHashString("uid", this), new Integer(239));
	literals.put(new ANTLRHashString("\u6c42\u6708\u4efd\u5dee\u503c", this), new Integer(212));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u5747\u6570", this), new Integer(104));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8f6c\u5316", this), new Integer(222));
	literals.put(new ANTLRHashString("rowidtochar", this), new Integer(227));
	literals.put(new ANTLRHashString("ss", this), new Integer(319));
	literals.put(new ANTLRHashString("sqrt", this), new Integer(155));
	literals.put(new ANTLRHashString("cos", this), new Integer(131));
	literals.put(new ANTLRHashString("\u5206\u7ec4", this), new Integer(56));
	literals.put(new ANTLRHashString("cosh", this), new Integer(133));
	literals.put(new ANTLRHashString("\u975e", this), new Integer(59));
	literals.put(new ANTLRHashString("rtrim", this), new Integer(195));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8fde\u63a5", this), new Integer(170));
	literals.put(new ANTLRHashString("or", this), new Integer(61));
	literals.put(new ANTLRHashString("char", this), new Integer(96));
	literals.put(new ANTLRHashString("by", this), new Integer(55));
	literals.put(new ANTLRHashString("year", this), new Integer(291));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u622a\u53d6", this), new Integer(200));
	literals.put(new ANTLRHashString("chartorowid", this), new Integer(219));
	literals.put(new ANTLRHashString("decode", this), new Integer(247));
	literals.put(new ANTLRHashString("s", this), new Integer(320));
	literals.put(new ANTLRHashString("asin", this), new Integer(123));
	literals.put(new ANTLRHashString("floor", this), new Integer(137));
	literals.put(new ANTLRHashString("\u5305\u542b", this), new Integer(77));
	literals.put(new ANTLRHashString("group", this), new Integer(54));
	literals.put(new ANTLRHashString("from", this), new Integer(52));
	literals.put(new ANTLRHashString("dump", this), new Integer(249));
	literals.put(new ANTLRHashString("hh24", this), new Integer(314));
	literals.put(new ANTLRHashString("months_between", this), new Integer(211));
	literals.put(new ANTLRHashString("replace", this), new Integer(191));
	literals.put(new ANTLRHashString("\u6c42\u5f53\u524d\u7528\u6237", this), new Integer(242));
	literals.put(new ANTLRHashString("vsize", this), new Integer(245));
	literals.put(new ANTLRHashString("\u6c42\u81ea\u7136\u5bf9\u6570", this), new Integer(140));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u5168\u66ff\u6362", this), new Integer(204));
	literals.put(new ANTLRHashString("greatest", this), new Integer(255));
	literals.put(new ANTLRHashString("\u521d\u59cb\u5316CLOB", this), new Integer(254));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u6570\u503c\u578b", this), new Integer(236));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u65f6\u533a\u7684\u65f6\u95f4", this), new Integer(214));
	literals.put(new ANTLRHashString("where", this), new Integer(42));
	literals.put(new ANTLRHashString("atin2", this), new Integer(127));
	literals.put(new ANTLRHashString("\u4e0d\u5305\u542b", this), new Integer(78));
	literals.put(new ANTLRHashString("\u53d6\u7edd\u5bf9\u503c", this), new Integer(120));
	literals.put(new ANTLRHashString("\u4e3a\u7a7a", this), new Integer(81));
	literals.put(new ANTLRHashString("q", this), new Integer(302));
	literals.put(new ANTLRHashString("exp", this), new Integer(135));
	literals.put(new ANTLRHashString("\u6c42\u5177\u4f53\u661f\u671f\u7684\u65e5\u671f", this), new Integer(216));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u65b9\u6839", this), new Integer(156));
	literals.put(new ANTLRHashString("order", this), new Integer(57));
	literals.put(new ANTLRHashString("\u6c42\u534f\u65b9\u5dee", this), new Integer(114));
	literals.put(new ANTLRHashString("\u6392\u5e8f", this), new Integer(58));
	literals.put(new ANTLRHashString("\u521d\u59cb\u5316BLOB", this), new Integer(252));
	literals.put(new ANTLRHashString("mod", this), new Integer(143));
	literals.put(new ANTLRHashString("translate", this), new Integer(203));
	literals.put(new ANTLRHashString("\u6761\u4ef6", this), new Integer(43));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd2", this), new Integer(186));
	literals.put(new ANTLRHashString("minute", this), new Integer(315));
	literals.put(new ANTLRHashString("sinh", this), new Integer(153));
	literals.put(new ANTLRHashString("hh", this), new Integer(312));
	literals.put(new ANTLRHashString("next_day", this), new Integer(215));
	literals.put(new ANTLRHashString("\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c", this), new Integer(128));
	literals.put(new ANTLRHashString("yy", this), new Integer(292));
	literals.put(new ANTLRHashString("select", this), new Integer(48));
	literals.put(new ANTLRHashString("\u7b49\u4e8e", this), new Integer(69));
	literals.put(new ANTLRHashString("\u6c42\u53cc\u66f2\u6b63\u5207\u503c", this), new Integer(160));
	literals.put(new ANTLRHashString("\u6240\u6709", this), new Integer(70));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u5c0f\u5199\u5b57\u6bcd1", this), new Integer(178));
	literals.put(new ANTLRHashString("\u4e0d\u5728\u4e8e", this), new Integer(87));
	literals.put(new ANTLRHashString("=", this), new Integer(68));
	literals.put(new ANTLRHashString("nvl", this), new Integer(259));
	literals.put(new ANTLRHashString("atan", this), new Integer(125));
	literals.put(new ANTLRHashString("sin", this), new Integer(151));
	literals.put(new ANTLRHashString("power", this), new Integer(145));
	literals.put(new ANTLRHashString("sum", this), new Integer(111));
	literals.put(new ANTLRHashString("lpad", this), new Integer(181));
	literals.put(new ANTLRHashString("n", this), new Integer(317));
	literals.put(new ANTLRHashString("to_number", this), new Integer(235));
	literals.put(new ANTLRHashString("\u5927\u4e8e", this), new Integer(280));
	literals.put(new ANTLRHashString("\u6c42\u6bd4\u8f83\u7ed3\u679c", this), new Integer(248));
	literals.put(new ANTLRHashString("ascii", this), new Integer(163));
	literals.put(new ANTLRHashString("\u4e0d\u7b49\u4e8e", this), new Integer(282));
	literals.put(new ANTLRHashString("\u8868\u6bd4\u8f83", this), new Integer(41));
	literals.put(new ANTLRHashString("cast", this), new Integer(117));
	literals.put(new ANTLRHashString("wk", this), new Integer(304));
	literals.put(new ANTLRHashString("min", this), new Integer(107));
	literals.put(new ANTLRHashString("asc", this), new Integer(72));
	literals.put(new ANTLRHashString("second", this), new Integer(318));
	literals.put(new ANTLRHashString("m", this), new Integer(296));
	literals.put(new ANTLRHashString("\u6765\u81ea", this), new Integer(53));
	literals.put(new ANTLRHashString("\u6c42\u503c\u7684\u7b26\u53f7", this), new Integer(150));
	literals.put(new ANTLRHashString("\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u4e8c\u8fdb\u5236", this), new Integer(224));
	literals.put(new ANTLRHashString("\u6c42\u975e\u7a7a\u503c", this), new Integer(260));
	literals.put(new ANTLRHashString("\u5355\u8bcd\u9996\u5b57\u6bcd\u5927\u51992", this), new Integer(184));
	literals.put(new ANTLRHashString("userenv", this), new Integer(243));
	literals.put(new ANTLRHashString("\u6216", this), new Integer(264));
	literals.put(new ANTLRHashString("to_date", this), new Integer(231));
	literals.put(new ANTLRHashString("\u4e3a", this), new Integer(95));
	literals.put(new ANTLRHashString("\u884c\u53f7\u8f6c\u6210\u5b57\u7b26\u4e32", this), new Integer(228));
	literals.put(new ANTLRHashString("last_day", this), new Integer(209));
	literals.put(new ANTLRHashString("\u5f02\u6216", this), new Integer(265));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e", this), new Integer(281));
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				switch ( LA(1)) {
				case '+':
				{
					mPLUS(true);
					theRetToken=_returnToken;
					break;
				}
				case '%':
				{
					mMOD(true);
					theRetToken=_returnToken;
					break;
				}
				case '&':
				{
					mAMPERSAND(true);
					theRetToken=_returnToken;
					break;
				}
				case '~':
				{
					mTILDE(true);
					theRetToken=_returnToken;
					break;
				}
				case '|':
				{
					mBITWISEOR(true);
					theRetToken=_returnToken;
					break;
				}
				case '^':
				{
					mBITWISEXOR(true);
					theRetToken=_returnToken;
					break;
				}
				case '=':
				{
					mASSIGNEQUAL(true);
					theRetToken=_returnToken;
					break;
				}
				case ',':
				{
					mCOMMA(true);
					theRetToken=_returnToken;
					break;
				}
				case ';':
				{
					mSEMI(true);
					theRetToken=_returnToken;
					break;
				}
				case '(':
				{
					mLPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case ')':
				{
					mRPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '}':
				{
					mPARAM_RPAREN(true);
					theRetToken=_returnToken;
					break;
				}
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(true);
					theRetToken=_returnToken;
					break;
				}
				case '"':  case '\'':
				{
					mQUOTED_STRING(true);
					theRetToken=_returnToken;
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					mREAL_NUM(true);
					theRetToken=_returnToken;
					break;
				}
				default:
					if ((LA(1)=='s') && (LA(2)=='e') && (LA(3)=='g') && (LA(4)=='_') && (LA(5)=='c')) {
						mCOLUMN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='s') && (LA(2)=='e') && (LA(3)=='g') && (LA(4)=='_') && (LA(5)=='f')) {
						mFROM(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='s') && (LA(2)=='e') && (LA(3)=='g') && (LA(4)=='_') && (LA(5)=='w')) {
						mWHERE(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (_tokenSet_1.member(LA(2))) && (_tokenSet_2.member(LA(3))) && (true) && (true)) {
						mDATA_TYPE_STRING(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='.') && (LA(2)=='*')) {
						mDOT_STAR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='>')) {
						mNOTEQUAL1(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (LA(2)=='=')) {
						mNOTEQUAL2(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (LA(2)=='=')) {
						mLESSTHANOREQUALTO1(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (LA(2)=='>')) {
						mLESSTHANOREQUALTO2(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (LA(2)=='=')) {
						mGREATERTHANOREQUALTO1(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='!') && (LA(2)=='<')) {
						mGREATERTHANOREQUALTO2(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (LA(2)=='=')) {
						mLEFT_JOIN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='{') && (_tokenSet_3.member(LA(2)))) {
						mPARAM_ID(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && ((LA(2) >= '0' && LA(2) <= '9'))) {
						mNEGATIVE_DIGIT_ELEMENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (LA(2)=='*')) {
						mML_COMMENT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='-') && (true)) {
						mMINUS(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (true)) {
						mSTAR(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='/') && (true)) {
						mDIVIDE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='<') && (true)) {
						mLESSTHAN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='>') && (true)) {
						mGREATERTHAN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='.') && (true)) {
						mPOINT(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='{') && (true)) {
						mPARAM_LPAREN(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_3.member(LA(1))) && (true) && (true) && (true) && (true)) {
						mID(true);
						theRetToken=_returnToken;
					}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
				}
				}
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mPLUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PLUS;
		int _saveIndex;
		
		match('+');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMINUS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MINUS;
		int _saveIndex;
		
		match('-');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSTAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STAR;
		int _saveIndex;
		
		match('*');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDIVIDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIVIDE;
		int _saveIndex;
		
		match('/');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mMOD(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = MOD;
		int _saveIndex;
		
		match('%');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mAMPERSAND(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AMPERSAND;
		int _saveIndex;
		
		match('&');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mTILDE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TILDE;
		int _saveIndex;
		
		match('~');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBITWISEOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BITWISEOR;
		int _saveIndex;
		
		match('|');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mBITWISEXOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = BITWISEXOR;
		int _saveIndex;
		
		match('^');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDOT_STAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT_STAR;
		int _saveIndex;
		
		match(".*");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mASSIGNEQUAL(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ASSIGNEQUAL;
		int _saveIndex;
		
		match('=');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOTEQUAL1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOTEQUAL1;
		int _saveIndex;
		
		match("<>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNOTEQUAL2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOTEQUAL2;
		int _saveIndex;
		
		match("!=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESSTHANOREQUALTO1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESSTHANOREQUALTO1;
		int _saveIndex;
		
		match("<=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESSTHANOREQUALTO2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESSTHANOREQUALTO2;
		int _saveIndex;
		
		match("!>");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLESSTHAN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LESSTHAN;
		int _saveIndex;
		
		match("<");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATERTHANOREQUALTO1(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATERTHANOREQUALTO1;
		int _saveIndex;
		
		match(">=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATERTHANOREQUALTO2(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATERTHANOREQUALTO2;
		int _saveIndex;
		
		match("!<");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mGREATERTHAN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = GREATERTHAN;
		int _saveIndex;
		
		match(">");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLEFT_JOIN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LEFT_JOIN;
		int _saveIndex;
		
		match("*=");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOMMA(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMA;
		int _saveIndex;
		
		match(',');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mSEMI(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SEMI;
		int _saveIndex;
		
		match(';');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPOINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = POINT;
		int _saveIndex;
		
		match('.');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mLPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = LPAREN;
		int _saveIndex;
		
		match('(');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mRPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = RPAREN;
		int _saveIndex;
		
		match(')');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPARAM_LPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PARAM_LPAREN;
		int _saveIndex;
		
		match('{');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPARAM_RPAREN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PARAM_RPAREN;
		int _saveIndex;
		
		match('}');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mCOLUMN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COLUMN;
		int _saveIndex;
		
		match("seg_column");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mFROM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = FROM;
		int _saveIndex;
		
		match("seg_from");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWHERE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WHERE;
		int _saveIndex;
		
		match("seg_where");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		int _cnt160=0;
		_loop160:
		do {
			switch ( LA(1)) {
			case ' ':
			{
				match(' ');
				break;
			}
			case '\n':
			{
				match('\n');
				break;
			}
			case '\r':
			{
				match('\r');
				break;
			}
			case '\t':
			{
				match('\t');
				break;
			}
			default:
			{
				if ( _cnt160>=1 ) { break _loop160; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt160++;
		} while (true);
		}
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mQUOTED_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = QUOTED_STRING;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '"':
		{
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		{
		_loop165:
		do {
			if ((LA(1)=='\\')) {
				mESC(false);
			}
			else if ((_tokenSet_4.member(LA(1)))) {
				{
				match(_tokenSet_4);
				}
			}
			else {
				break _loop165;
			}
			
		} while (true);
		}
		{
		switch ( LA(1)) {
		case '"':
		{
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESC;
		int _saveIndex;
		
		match('\\');
		{
		switch ( LA(1)) {
		case 'n':
		{
			match('n');
			break;
		}
		case 'r':
		{
			match('r');
			break;
		}
		case 't':
		{
			match('t');
			break;
		}
		case 'b':
		{
			match('b');
			break;
		}
		case 'f':
		{
			match('f');
			break;
		}
		case '"':
		{
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		case '\\':
		{
			match('\\');
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		{
			matchRange('0','3');
			{
			if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_5.member(LA(2))) && (true) && (true) && (true)) {
				matchRange('0','7');
				{
				if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_5.member(LA(2))) && (true) && (true) && (true)) {
					matchRange('0','7');
				}
				else if ((_tokenSet_5.member(LA(1))) && (true) && (true) && (true) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else if ((_tokenSet_5.member(LA(1))) && (true) && (true) && (true) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			break;
		}
		case '4':  case '5':  case '6':  case '7':
		{
			matchRange('4','7');
			{
			if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_5.member(LA(2))) && (true) && (true) && (true)) {
				matchRange('0','7');
			}
			else if ((_tokenSet_5.member(LA(1))) && (true) && (true) && (true) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mPARAM_ID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = PARAM_ID;
		int _saveIndex;
		
		mPARAM_LPAREN(false);
		mID(false);
		mPARAM_RPAREN(false);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		mID_START_LETTER(false);
		{
		_loop175:
		do {
			if ((_tokenSet_6.member(LA(1)))) {
				mID_LETTER(false);
			}
			else {
				break _loop175;
			}
			
		} while (true);
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mID_START_LETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID_START_LETTER;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		default:
			if (((LA(1) >= '\u0080' && LA(1) <= '\ufffe'))) {
				matchRange('\u0080','\ufffe');
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mID_LETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID_LETTER;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			matchRange('0','9');
			break;
		}
		case '/':
		{
			match('/');
			break;
		}
		case '%':
		{
			match('%');
			break;
		}
		default:
			if ((_tokenSet_3.member(LA(1)))) {
				mID_START_LETTER(false);
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mREAL_NUM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = REAL_NUM;
		int _saveIndex;
		
		mNUM(false);
		{
		if ((LA(1)=='.')) {
			mPOINT(false);
			mDOT_NUM(false);
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUM;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '0':
		{
			match('0');
			break;
		}
		case '1':  case '2':  case '3':  case '4':
		case '5':  case '6':  case '7':  case '8':
		case '9':
		{
			mNUM_START(false);
			{
			_loop184:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUM_LETTER(false);
				}
				else {
					break _loop184;
				}
				
			} while (true);
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDOT_NUM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DOT_NUM;
		int _saveIndex;
		
		{
		int _cnt187=0;
		_loop187:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mNUM_LETTER(false);
			}
			else {
				if ( _cnt187>=1 ) { break _loop187; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt187++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mNEGATIVE_DIGIT_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NEGATIVE_DIGIT_ELEMENT;
		int _saveIndex;
		
		mMINUS(false);
		mNUM(false);
		{
		if ((LA(1)=='.')) {
			mPOINT(false);
			mDOT_NUM(false);
		}
		else {
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUM_START(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUM_START;
		int _saveIndex;
		
		matchRange('1','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mNUM_LETTER(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NUM_LETTER;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mDATA_TYPE_STRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DATA_TYPE_STRING;
		int _saveIndex;
		
		switch ( LA(1)) {
		case 'v':
		{
			match("varchar2");
			break;
		}
		case 'r':
		{
			match("raw");
			break;
		}
		case 'u':
		{
			match("urowid");
			break;
		}
		default:
			if ((LA(1)=='n') && (LA(2)=='c')) {
				match("nchar");
			}
			else if ((LA(1)=='n') && (LA(2)=='v')) {
				match("nvarchar2");
			}
			else if ((LA(1)=='n') && (LA(2)=='u')) {
				match("numeric");
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
		}
		}
		_ttype = testLiteralsTable(_ttype);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;
		
		match("/*");
		{
		_loop194:
		do {
			if ((LA(1)=='\r') && (LA(2)=='\n') && ((LA(3) >= '\u0000' && LA(3) <= '\ufffe')) && ((LA(4) >= '\u0000' && LA(4) <= '\ufffe')) && (true)) {
				match('\r');
				match('\n');
				newline();
			}
			else if (((LA(1)=='*') && ((LA(2) >= '\u0000' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0000' && LA(3) <= '\ufffe')))&&( LA(2)!='/' )) {
				match('*');
			}
			else if ((LA(1)=='\r') && ((LA(2) >= '\u0000' && LA(2) <= '\ufffe')) && ((LA(3) >= '\u0000' && LA(3) <= '\ufffe')) && (true) && (true)) {
				match('\r');
				newline();
			}
			else if ((LA(1)=='\n')) {
				match('\n');
				newline();
			}
			else if ((_tokenSet_7.member(LA(1)))) {
				{
				match(_tokenSet_7);
				}
			}
			else {
				break _loop194;
			}
			
		} while (true);
		}
		match("*/");
		_ttype = Token.SKIP;
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	private static final long[] mk_tokenSet_0() {
		long[] data = new long[1025];
		data[1]=28217866415243264L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[1025];
		data[1]=28147540620738560L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[1025];
		data[1]=37331726887813120L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[3072];
		data[1]=576460745860972544L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[2048];
		data[0]=-566935692289L;
		data[1]=-268435457L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[2048];
		data[0]=-9217L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = new long[3072];
		data[0]=288089776102309888L;
		data[1]=576460745860972544L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = new long[2048];
		data[0]=-4398046520321L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	
	}
