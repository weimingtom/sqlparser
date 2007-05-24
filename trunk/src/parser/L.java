// $ANTLR 2.7.7 (2006-11-01): "src/parser/parser.g" -> "L.java"$

	package parser;

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

public class L extends antlr.CharScanner implements PTokenTypes, TokenStream
 {
public L(InputStream in) {
	this(new ByteBuffer(in));
}
public L(Reader in) {
	this(new CharBuffer(in));
}
public L(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public L(LexerSharedInputState state) {
	super(state);
	caseSensitiveLiterals = true;
	setCaseSensitive(false);
	literals = new Hashtable();
	literals.put(new ANTLRHashString("upper", this), new Integer(222));
	literals.put(new ANTLRHashString("t_union", this), new Integer(32));
	literals.put(new ANTLRHashString("user_id", this), new Integer(286));
	literals.put(new ANTLRHashString("\u6c42\u4f59\u5f26\u503c", this), new Integer(126));
	literals.put(new ANTLRHashString("avg", this), new Integer(89));
	literals.put(new ANTLRHashString("dd", this), new Integer(315));
	literals.put(new ANTLRHashString("today", this), new Integer(109));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5927\u503c", this), new Integer(92));
	literals.put(new ANTLRHashString("stuff", this), new Integer(214));
	literals.put(new ANTLRHashString("getdate", this), new Integer(101));
	literals.put(new ANTLRHashString("\u6c42\u7b49\u503c\u7684\u5b57\u7b26", this), new Integer(167));
	literals.put(new ANTLRHashString("\u683c\u5f0f\u5316\u6570\u503c", this), new Integer(148));
	literals.put(new ANTLRHashString("weekday", this), new Integer(321));
	literals.put(new ANTLRHashString("argn", this), new Integer(288));
	literals.put(new ANTLRHashString("\u5c06\u5ea6\u6570\u8f6c\u4e3a\u5f27\u5ea6", this), new Integer(144));
	literals.put(new ANTLRHashString("count", this), new Integer(86));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u6708", this), new Integer(255));
	literals.put(new ANTLRHashString("monthname", this), new Integer(250));
	literals.put(new ANTLRHashString("\u6c42\u7edf\u8ba1\u65b9\u5dee", this), new Integer(100));
	literals.put(new ANTLRHashString("tan", this), new Integer(155));
	literals.put(new ANTLRHashString("day", this), new Integer(238));
	literals.put(new ANTLRHashString("\u6c42\u6b63\u5f26\u503c", this), new Integer(152));
	literals.put(new ANTLRHashString("week", this), new Integer(317));
	literals.put(new ANTLRHashString("\u6216\u8005", this), new Integer(56));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5c0f\u503c", this), new Integer(94));
	literals.put(new ANTLRHashString("patindex", this), new Integer(190));
	literals.put(new ANTLRHashString("suser_id", this), new Integer(284));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u4f59\u5f26\u503c", this), new Integer(116));
	literals.put(new ANTLRHashString("\u552f\u4e00", this), new Integer(44));
	literals.put(new ANTLRHashString("\u4e58", this), new Integer(298));
	literals.put(new ANTLRHashString("cyr", this), new Integer(331));
	literals.put(new ANTLRHashString("similar", this), new Integer(202));
	literals.put(new ANTLRHashString("\u6c42ASCII\u7801", this), new Integer(161));
	literals.put(new ANTLRHashString("ms", this), new Integer(327));
	literals.put(new ANTLRHashString("\u52a0", this), new Integer(296));
	literals.put(new ANTLRHashString("remainder", this), new Integer(145));
	literals.put(new ANTLRHashString("\u5728\u4e8e", this), new Integer(77));
	literals.put(new ANTLRHashString("bit_length", this), new Integer(162));
	literals.put(new ANTLRHashString("\u6c42\u6708\u6570", this), new Integer(253));
	literals.put(new ANTLRHashString("is", this), new Integer(70));
	literals.put(new ANTLRHashString("datetime", this), new Integer(230));
	literals.put(new ANTLRHashString("\u6c42\u5e74\u6570", this), new Integer(265));
	literals.put(new ANTLRHashString("\u6c420\u548c1\u95f4\u7684\u968f\u673a\u6570", this), new Integer(104));
	literals.put(new ANTLRHashString("rowid", this), new Integer(289));
	literals.put(new ANTLRHashString("\u4e3a\u6570\u503c\u578b", this), new Integer(281));
	literals.put(new ANTLRHashString("length", this), new Integer(180));
	literals.put(new ANTLRHashString("weeks", this), new Integer(262));
	literals.put(new ANTLRHashString("and", this), new Integer(53));
	literals.put(new ANTLRHashString("dy", this), new Integer(320));
	literals.put(new ANTLRHashString("as", this), new Integer(59));
	literals.put(new ANTLRHashString("convert", this), new Integer(282));
	literals.put(new ANTLRHashString("desc", this), new Integer(68));
	literals.put(new ANTLRHashString("insertstr", this), new Integer(174));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u5408\u5e76", this), new Integer(213));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u6b63\u5f26\u503c", this), new Integer(118));
	literals.put(new ANTLRHashString("exists", this), new Integer(40));
	literals.put(new ANTLRHashString("qq", this), new Integer(316));
	literals.put(new ANTLRHashString("like", this), new Integer(69));
	literals.put(new ANTLRHashString("now", this), new Integer(107));
	literals.put(new ANTLRHashString("\u9664", this), new Integer(299));
	literals.put(new ANTLRHashString("date", this), new Integer(232));
	literals.put(new ANTLRHashString("variance", this), new Integer(99));
	literals.put(new ANTLRHashString("\u6c42\u4f59", this), new Integer(140));
	literals.put(new ANTLRHashString("left", this), new Integer(178));
	literals.put(new ANTLRHashString("dayofyear", this), new Integer(319));
	literals.put(new ANTLRHashString("ymd", this), new Integer(268));
	literals.put(new ANTLRHashString("\u5347\u5e8f", this), new Integer(65));
	literals.put(new ANTLRHashString("\u6574\u6570\u8f6c\u4e3a\u5341\u516d\u8fdb\u5236", this), new Integer(277));
	literals.put(new ANTLRHashString("cdw", this), new Integer(333));
	literals.put(new ANTLRHashString("\u6c42\u56db\u820d\u540e\u7684\u6574\u6570", this), new Integer(134));
	literals.put(new ANTLRHashString("\u6c42\u4f59\u5207\u503c", this), new Integer(128));
	literals.put(new ANTLRHashString("\u6c42\u6570\u5b57\u7684\u6b21\u5e42\u503c", this), new Integer(142));
	literals.put(new ANTLRHashString("dw", this), new Integer(322));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u65e5\u671f", this), new Integer(233));
	literals.put(new ANTLRHashString("\u6c42\u6708\u4efd\u540d\u79f0", this), new Integer(251));
	literals.put(new ANTLRHashString("\u53bb\u6389\u7a7a\u683c", this), new Integer(219));
	literals.put(new ANTLRHashString("octet_length", this), new Integer(188));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u7684\u5b57\u8282\u6570", this), new Integer(165));
	literals.put(new ANTLRHashString("trim", this), new Integer(218));
	literals.put(new ANTLRHashString("between", this), new Integer(74));
	literals.put(new ANTLRHashString("dateadd", this), new Integer(270));
	literals.put(new ANTLRHashString("datepart", this), new Integer(228));
	literals.put(new ANTLRHashString("millisecond", this), new Integer(326));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e\u7b49\u4e8e", this), new Integer(303));
	literals.put(new ANTLRHashString("\u51cf", this), new Integer(297));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u58f0\u97f3\u503c", this), new Integer(207));
	literals.put(new ANTLRHashString("datename", this), new Integer(226));
	literals.put(new ANTLRHashString("months", this), new Integer(252));
	literals.put(new ANTLRHashString("ceiling", this), new Integer(123));
	literals.put(new ANTLRHashString("\u6c42\u65e5\u671f\u7684\u5206\u91cf\u503c", this), new Integer(229));
	literals.put(new ANTLRHashString("radians", this), new Integer(143));
	literals.put(new ANTLRHashString("t_compare", this), new Integer(35));
	literals.put(new ANTLRHashString("\u53d6\u4f59", this), new Integer(146));
	literals.put(new ANTLRHashString("char_length", this), new Integer(168));
	literals.put(new ANTLRHashString("\u6c42\u6b63\u5207\u503c", this), new Integer(156));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u6392\u5e8f", this), new Integer(205));
	literals.put(new ANTLRHashString("not", this), new Integer(39));
	literals.put(new ANTLRHashString("\u5927\u4e8e\u7b49\u4e8e", this), new Integer(302));
	literals.put(new ANTLRHashString("\u8303\u56f4", this), new Integer(75));
	literals.put(new ANTLRHashString("all", this), new Integer(87));
	literals.put(new ANTLRHashString("in", this), new Integer(76));
	literals.put(new ANTLRHashString("\u6c4210\u4e3a\u5e95\u7684\u5bf9\u6570", this), new Integer(138));
	literals.put(new ANTLRHashString("\u53d6\u5f53\u524d\u65e5\u671f\u65f6\u95f4", this), new Integer(108));
	literals.put(new ANTLRHashString("byte_length", this), new Integer(164));
	literals.put(new ANTLRHashString("\u6c42\u6a21", this), new Integer(300));
	literals.put(new ANTLRHashString("sign", this), new Integer(149));
	literals.put(new ANTLRHashString("hours", this), new Integer(242));
	literals.put(new ANTLRHashString("mm", this), new Integer(314));
	literals.put(new ANTLRHashString("days", this), new Integer(236));
	literals.put(new ANTLRHashString("\u5168\u90e8", this), new Integer(88));
	literals.put(new ANTLRHashString("isnumeric", this), new Integer(280));
	literals.put(new ANTLRHashString("hour", this), new Integer(244));
	literals.put(new ANTLRHashString("\u8868\u5408\u5e76", this), new Integer(33));
	literals.put(new ANTLRHashString("\u53bb\u6389\u5de6\u7a7a\u683c", this), new Integer(187));
	literals.put(new ANTLRHashString("\u6c42\u5e42\u503c", this), new Integer(132));
	literals.put(new ANTLRHashString("\u5341\u516d\u8fdb\u5236\u8f6c\u4e3a\u6574\u6570", this), new Integer(275));
	literals.put(new ANTLRHashString("caldayofweek", this), new Integer(332));
	literals.put(new ANTLRHashString("calweekofyear", this), new Integer(328));
	literals.put(new ANTLRHashString("quarter", this), new Integer(256));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u79d2", this), new Integer(261));
	literals.put(new ANTLRHashString("\u6c42\u79d2\u6570", this), new Integer(259));
	literals.put(new ANTLRHashString("calyearofweek", this), new Integer(330));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5927\u5199", this), new Integer(221));
	literals.put(new ANTLRHashString("user_name", this), new Integer(287));
	literals.put(new ANTLRHashString("\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570", this), new Integer(124));
	literals.put(new ANTLRHashString("suser_name", this), new Integer(285));
	literals.put(new ANTLRHashString("\u53d6\u5b57\u7b26\u4e32\u7684\u957f\u5ea6", this), new Integer(181));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u7684\u5b58\u50a8\u957f\u5ea6", this), new Integer(189));
	literals.put(new ANTLRHashString("\u6c42\u7b2c\u4e00\u6b21\u51fa\u73b0\u4f4d\u7f6e", this), new Integer(191));
	literals.put(new ANTLRHashString("acos", this), new Integer(115));
	literals.put(new ANTLRHashString("\u6c42\u53cd\u6b63\u5207\u503c", this), new Integer(120));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u661f\u671f\u540d\u79f0", this), new Integer(235));
	literals.put(new ANTLRHashString("null", this), new Integer(71));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u5220\u9664\u66ff\u6362", this), new Integer(215));
	literals.put(new ANTLRHashString("\u5de6\u8fde\u63a5", this), new Integer(309));
	literals.put(new ANTLRHashString("\u5e76\u4e14", this), new Integer(55));
	literals.put(new ANTLRHashString("lower", this), new Integer(184));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u661f\u671f\u503c", this), new Integer(241));
	literals.put(new ANTLRHashString("\u683c\u5f0f\u5316\u65e5\u671f", this), new Integer(225));
	literals.put(new ANTLRHashString("difference", this), new Integer(172));
	literals.put(new ANTLRHashString("\u4f5c\u4e3a", this), new Integer(60));
	literals.put(new ANTLRHashString("years", this), new Integer(264));
	literals.put(new ANTLRHashString("\u53bb\u6389\u53f3\u7a7a\u683c", this), new Integer(201));
	literals.put(new ANTLRHashString("\u6c42\u5706\u5468\u7387", this), new Integer(106));
	literals.put(new ANTLRHashString("\u4e3a\u65e5\u671f\u578b", this), new Integer(279));
	literals.put(new ANTLRHashString("ucase", this), new Integer(220));
	literals.put(new ANTLRHashString("month", this), new Integer(254));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199", this), new Integer(177));
	literals.put(new ANTLRHashString("\u6c42\u8bb0\u5f55\u603b\u6570", this), new Integer(85));
	literals.put(new ANTLRHashString("repeat", this), new Integer(192));
	literals.put(new ANTLRHashString("distinct", this), new Integer(43));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u66ff\u6362", this), new Integer(195));
	literals.put(new ANTLRHashString("ltrim", this), new Integer(186));
	literals.put(new ANTLRHashString("\u6570\u636e\u7c7b\u578b\u8f6c\u5316", this), new Integer(112));
	literals.put(new ANTLRHashString("\u8f6c\u4e3a\u65e5\u671f\u65f6\u95f4", this), new Integer(231));
	literals.put(new ANTLRHashString("minutes", this), new Integer(246));
	literals.put(new ANTLRHashString("\u6c42\u5929\u6570", this), new Integer(237));
	literals.put(new ANTLRHashString("\u6c42\u5206\u949f\u6570", this), new Integer(247));
	literals.put(new ANTLRHashString("\u964d\u5e8f", this), new Integer(66));
	literals.put(new ANTLRHashString("\u5b58\u5728", this), new Integer(311));
	literals.put(new ANTLRHashString("\u6570\u503c\u8f6c\u5b57\u7b26\u4e32", this), new Integer(211));
	literals.put(new ANTLRHashString("dateformat", this), new Integer(224));
	literals.put(new ANTLRHashString("log", this), new Integer(135));
	literals.put(new ANTLRHashString("stddev", this), new Integer(95));
	literals.put(new ANTLRHashString("mi", this), new Integer(324));
	literals.put(new ANTLRHashString("\u67e5\u8be2", this), new Integer(42));
	literals.put(new ANTLRHashString("max", this), new Integer(91));
	literals.put(new ANTLRHashString("\u6c42\u7a7a\u683c", this), new Integer(209));
	literals.put(new ANTLRHashString("\u975e\u7a7a", this), new Integer(73));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u5de6\u622a", this), new Integer(179));
	literals.put(new ANTLRHashString("\u6c42\u5f53\u524d\u65e5\u671f", this), new Integer(110));
	literals.put(new ANTLRHashString("\u4e0e", this), new Integer(293));
	literals.put(new ANTLRHashString("round", this), new Integer(147));
	literals.put(new ANTLRHashString("\u4e0d\u5b58\u5728", this), new Integer(312));
	literals.put(new ANTLRHashString("\u6c42\u65e5\u671f\u7684\u5206\u91cf\u540d\u79f0", this), new Integer(227));
	literals.put(new ANTLRHashString("cot", this), new Integer(127));
	literals.put(new ANTLRHashString("\u5c06\u5f27\u5ea6\u8f6c\u4e3a\u5ea6\u6570", this), new Integer(130));
	literals.put(new ANTLRHashString("abs", this), new Integer(113));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u5b63\u5ea6", this), new Integer(257));
	literals.put(new ANTLRHashString("\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4", this), new Integer(102));
	literals.put(new ANTLRHashString("soundex", this), new Integer(206));
	literals.put(new ANTLRHashString("\u6c42\u5468\u6570", this), new Integer(263));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u5747\u6570", this), new Integer(90));
	literals.put(new ANTLRHashString("dow", this), new Integer(240));
	literals.put(new ANTLRHashString("ss", this), new Integer(325));
	literals.put(new ANTLRHashString("sqrt", this), new Integer(153));
	literals.put(new ANTLRHashString("\u6c42\u65b9\u5dee", this), new Integer(96));
	literals.put(new ANTLRHashString("cos", this), new Integer(125));
	literals.put(new ANTLRHashString("\u6c42\u65e5\u671f", this), new Integer(269));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u53f3\u622a", this), new Integer(199));
	literals.put(new ANTLRHashString("hextoint", this), new Integer(274));
	literals.put(new ANTLRHashString("dayname", this), new Integer(234));
	literals.put(new ANTLRHashString("right", this), new Integer(198));
	literals.put(new ANTLRHashString("\u5206\u7ec4", this), new Integer(49));
	literals.put(new ANTLRHashString("\u5c06\u5b57\u7b26\u4e32\u8fde\u63a5", this), new Integer(193));
	literals.put(new ANTLRHashString("\u975e", this), new Integer(52));
	literals.put(new ANTLRHashString("rtrim", this), new Integer(200));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6", this), new Integer(169));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u8fde\u63a5", this), new Integer(197));
	literals.put(new ANTLRHashString("locate", this), new Integer(182));
	literals.put(new ANTLRHashString("or", this), new Integer(54));
	literals.put(new ANTLRHashString("char", this), new Integer(166));
	literals.put(new ANTLRHashString("seconds", this), new Integer(258));
	literals.put(new ANTLRHashString("year", this), new Integer(266));
	literals.put(new ANTLRHashString("by", this), new Integer(48));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u622a\u53d6", this), new Integer(217));
	literals.put(new ANTLRHashString("sortkey", this), new Integer(204));
	literals.put(new ANTLRHashString("degrees", this), new Integer(129));
	literals.put(new ANTLRHashString("string", this), new Integer(212));
	literals.put(new ANTLRHashString("asin", this), new Integer(117));
	literals.put(new ANTLRHashString("\u6c42\u5c0f\u65f6\u6570", this), new Integer(243));
	literals.put(new ANTLRHashString("floor", this), new Integer(133));
	literals.put(new ANTLRHashString("\u5305\u542b", this), new Integer(307));
	literals.put(new ANTLRHashString("group", this), new Integer(47));
	literals.put(new ANTLRHashString("from", this), new Integer(45));
	literals.put(new ANTLRHashString("replace", this), new Integer(194));
	literals.put(new ANTLRHashString("log10", this), new Integer(137));
	literals.put(new ANTLRHashString("charindex", this), new Integer(170));
	literals.put(new ANTLRHashString("\u6c42\u81ea\u7136\u5bf9\u6570", this), new Integer(136));
	literals.put(new ANTLRHashString("\u6c42\u548c", this), new Integer(98));
	literals.put(new ANTLRHashString("where", this), new Integer(37));
	literals.put(new ANTLRHashString("atin2", this), new Integer(121));
	literals.put(new ANTLRHashString("\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5927\u5199", this), new Integer(223));
	literals.put(new ANTLRHashString("\u4e0d\u5305\u542b", this), new Integer(308));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u63d2\u5165", this), new Integer(175));
	literals.put(new ANTLRHashString("lcase", this), new Integer(176));
	literals.put(new ANTLRHashString("\u53d6\u7edd\u5bf9\u503c", this), new Integer(114));
	literals.put(new ANTLRHashString("\u4e3a\u7a7a", this), new Integer(72));
	literals.put(new ANTLRHashString("\u65e5\u671f\u76f8\u52a0", this), new Integer(271));
	literals.put(new ANTLRHashString("pi", this), new Integer(105));
	literals.put(new ANTLRHashString("exp", this), new Integer(131));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u65b9\u6839", this), new Integer(154));
	literals.put(new ANTLRHashString("order", this), new Integer(50));
	literals.put(new ANTLRHashString("rand", this), new Integer(103));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u7684\u4e8c\u8fdb\u5236\u957f\u5ea6", this), new Integer(163));
	literals.put(new ANTLRHashString("\u6392\u5e8f", this), new Integer(51));
	literals.put(new ANTLRHashString("mod", this), new Integer(139));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u8f6c\u4e3a\u65e5\u671f", this), new Integer(283));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u5c0f\u65f6", this), new Integer(245));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u76f8\u4f3c\u5ea6", this), new Integer(203));
	literals.put(new ANTLRHashString("\u6c42\u4e24\u4e2a\u4e32\u7684\u58f0\u97f3\u5dee\u503c", this), new Integer(173));
	literals.put(new ANTLRHashString("\u6761\u4ef6", this), new Integer(38));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u5e74", this), new Integer(267));
	literals.put(new ANTLRHashString("minute", this), new Integer(248));
	literals.put(new ANTLRHashString("\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199", this), new Integer(185));
	literals.put(new ANTLRHashString("hh", this), new Integer(323));
	literals.put(new ANTLRHashString("\u5c06\u6570\u503c\u683c\u5f0f\u5316", this), new Integer(157));
	literals.put(new ANTLRHashString("\u6c42\u4e8c\u4e2a\u6570\u7684\u53cd\u6b63\u5207\u503c", this), new Integer(122));
	literals.put(new ANTLRHashString("yy", this), new Integer(313));
	literals.put(new ANTLRHashString("select", this), new Integer(41));
	literals.put(new ANTLRHashString("\u7b49\u4e8e", this), new Integer(62));
	literals.put(new ANTLRHashString("\u6240\u6709", this), new Integer(63));
	literals.put(new ANTLRHashString("\u53d6\u683c\u5f0f\u5316\u6570\u503c", this), new Integer(159));
	literals.put(new ANTLRHashString("=", this), new Integer(61));
	literals.put(new ANTLRHashString("\u4e0d\u5728\u4e8e", this), new Integer(78));
	literals.put(new ANTLRHashString("atan", this), new Integer(119));
	literals.put(new ANTLRHashString("sin", this), new Integer(151));
	literals.put(new ANTLRHashString("power", this), new Integer(141));
	literals.put(new ANTLRHashString("sum", this), new Integer(97));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u5929", this), new Integer(239));
	literals.put(new ANTLRHashString("\u5927\u4e8e", this), new Integer(304));
	literals.put(new ANTLRHashString("substring", this), new Integer(216));
	literals.put(new ANTLRHashString("ascii", this), new Integer(160));
	literals.put(new ANTLRHashString("\u4e0d\u7b49\u4e8e", this), new Integer(306));
	literals.put(new ANTLRHashString("cwk", this), new Integer(329));
	literals.put(new ANTLRHashString("space", this), new Integer(208));
	literals.put(new ANTLRHashString("cast", this), new Integer(111));
	literals.put(new ANTLRHashString("\u8868\u6bd4\u8f83", this), new Integer(36));
	literals.put(new ANTLRHashString("wk", this), new Integer(318));
	literals.put(new ANTLRHashString("min", this), new Integer(93));
	literals.put(new ANTLRHashString("\u65e5\u671f\u76f8\u51cf", this), new Integer(273));
	literals.put(new ANTLRHashString("asc", this), new Integer(67));
	literals.put(new ANTLRHashString("str", this), new Integer(210));
	literals.put(new ANTLRHashString("second", this), new Integer(260));
	literals.put(new ANTLRHashString("isdate", this), new Integer(278));
	literals.put(new ANTLRHashString("\u6765\u81ea", this), new Integer(46));
	literals.put(new ANTLRHashString("\u6c42\u503c\u7684\u7b26\u53f7", this), new Integer(150));
	literals.put(new ANTLRHashString("\u6c42\u5bf9\u5e94\u5206\u949f", this), new Integer(249));
	literals.put(new ANTLRHashString("\u6c42\u4e32\u51fa\u73b0\u4f4d\u7f6e", this), new Integer(183));
	literals.put(new ANTLRHashString("\u6216", this), new Integer(294));
	literals.put(new ANTLRHashString("inttohex", this), new Integer(276));
	literals.put(new ANTLRHashString("\u5f02\u6216", this), new Integer(295));
	literals.put(new ANTLRHashString("datediff", this), new Integer(272));
	literals.put(new ANTLRHashString("replicate", this), new Integer(196));
	literals.put(new ANTLRHashString("truncnum", this), new Integer(158));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e", this), new Integer(305));
	literals.put(new ANTLRHashString("\u5b58\u5728\u4e8e", this), new Integer(171));
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
				case '~':
				{
					mONE_ARG_OP(true);
					theRetToken=_returnToken;
					break;
				}
				case '!':  case '<':  case '=':  case '>':
				{
					mCOMPARE_OP(true);
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
				case '.':
				{
					mPOINT(true);
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
					if ((LA(1)=='c') && (LA(2)=='o') && (LA(3)=='l') && (LA(4)=='u') && (LA(5)=='m')) {
						mCOLUMN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='w') && (LA(2)=='h') && (LA(3)=='e') && (LA(4)=='r') && (LA(5)=='e')) {
						mWHERE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='*') && (LA(2)=='=')) {
						mLEFT_JOIN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='{') && (_tokenSet_0.member(LA(2)))) {
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
					else if ((_tokenSet_1.member(LA(1))) && (true)) {
						mTWO_ARG_OP(true);
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
					else if ((LA(1)=='{') && (true)) {
						mPARAM_LPAREN(true);
						theRetToken=_returnToken;
					}
					else if ((_tokenSet_0.member(LA(1))) && (true) && (true) && (true) && (true)) {
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

	public final void mONE_ARG_OP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ONE_ARG_OP;
		int _saveIndex;
		
		match('~');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mTWO_ARG_OP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TWO_ARG_OP;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '&':
		{
			match('&');
			break;
		}
		case '|':
		{
			match('|');
			break;
		}
		case '^':
		{
			match('^');
			break;
		}
		case '+':
		{
			match('+');
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
	
	public final void mCOMPARE_OP(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMPARE_OP;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '!':
		{
			match("!=");
			break;
		}
		case '=':
		{
			match("=");
			break;
		}
		default:
			if ((LA(1)=='>') && (LA(2)=='=')) {
				match(">=");
			}
			else if ((LA(1)=='<') && (LA(2)=='=')) {
				match("<=");
			}
			else if ((LA(1)=='<') && (LA(2)=='>')) {
				match("<>");
			}
			else if ((LA(1)=='>') && (true)) {
				match('>');
			}
			else if ((LA(1)=='<') && (true)) {
				match('<');
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
		
		match("column");
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
		
		match("where");
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
		int _cnt127=0;
		_loop127:
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
				if ( _cnt127>=1 ) { break _loop127; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt127++;
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
		_loop132:
		do {
			if ((LA(1)=='\\')) {
				mESC(false);
			}
			else if ((_tokenSet_2.member(LA(1)))) {
				{
				match(_tokenSet_2);
				}
			}
			else {
				break _loop132;
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
			if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_3.member(LA(2))) && (true) && (true) && (true)) {
				matchRange('0','7');
				{
				if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_3.member(LA(2))) && (true) && (true) && (true)) {
					matchRange('0','7');
				}
				else if ((_tokenSet_3.member(LA(1))) && (true) && (true) && (true) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());
				}
				
				}
			}
			else if ((_tokenSet_3.member(LA(1))) && (true) && (true) && (true) && (true)) {
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
			if (((LA(1) >= '0' && LA(1) <= '7')) && (_tokenSet_3.member(LA(2))) && (true) && (true) && (true)) {
				matchRange('0','7');
			}
			else if ((_tokenSet_3.member(LA(1))) && (true) && (true) && (true) && (true)) {
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
		_loop142:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				mID_LETTER(false);
			}
			else {
				break _loop142;
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
		default:
			if ((_tokenSet_0.member(LA(1)))) {
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
			_loop151:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUM_LETTER(false);
				}
				else {
					break _loop151;
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
		int _cnt154=0;
		_loop154:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mNUM_LETTER(false);
			}
			else {
				if ( _cnt154>=1 ) { break _loop154; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt154++;
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
	
	public final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;
		
		match("/*");
		{
		_loop160:
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
			else if ((_tokenSet_5.member(LA(1)))) {
				{
				match(_tokenSet_5);
				}
			}
			else {
				break _loop160;
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
		long[] data = new long[3072];
		data[1]=576460745860972544L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = new long[1025];
		data[0]=149945898237952L;
		data[1]=1152921505680588800L;
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = new long[2048];
		data[0]=-566935692289L;
		data[1]=-268435457L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = new long[2048];
		data[0]=-9217L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = new long[3072];
		data[0]=288089638663356416L;
		data[1]=576460745860972544L;
		for (int i = 2; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = new long[2048];
		data[0]=-4398046520321L;
		for (int i = 1; i<=1022; i++) { data[i]=-1L; }
		data[1023]=9223372036854775807L;
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
