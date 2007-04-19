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
	literals.put(new ANTLRHashString("round", this), new Integer(75));
	literals.put(new ANTLRHashString("\u9664", this), new Integer(115));
	literals.put(new ANTLRHashString("all", this), new Integer(65));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u5747\u6570", this), new Integer(98));
	literals.put(new ANTLRHashString("\u6c42\u7edd\u5bf9\u503c", this), new Integer(72));
	literals.put(new ANTLRHashString("sqrt", this), new Integer(67));
	literals.put(new ANTLRHashString("count", this), new Integer(103));
	literals.put(new ANTLRHashString("sum", this), new Integer(95));
	literals.put(new ANTLRHashString("\u6761\u4ef6", this), new Integer(23));
	literals.put(new ANTLRHashString("\u6c42\u56db\u820d\u540e\u7684\u6574\u6570", this), new Integer(86));
	literals.put(new ANTLRHashString("\u51cf", this), new Integer(113));
	literals.put(new ANTLRHashString("min", this), new Integer(101));
	literals.put(new ANTLRHashString("\u975e", this), new Integer(106));
	literals.put(new ANTLRHashString("lower", this), new Integer(89));
	literals.put(new ANTLRHashString("\u964d\u5e8f", this), new Integer(42));
	literals.put(new ANTLRHashString("\u5168\u90e8", this), new Integer(66));
	literals.put(new ANTLRHashString("\u5b58\u5728", this), new Integer(132));
	literals.put(new ANTLRHashString("\u6c42\u5f53\u524d\u65e5\u671f\u65f6\u95f4", this), new Integer(70));
	literals.put(new ANTLRHashString("\u5f02\u6216", this), new Integer(111));
	literals.put(new ANTLRHashString("not in", this), new Integer(55));
	literals.put(new ANTLRHashString("abs", this), new Integer(71));
	literals.put(new ANTLRHashString("\u552f\u4e00", this), new Integer(27));
	literals.put(new ANTLRHashString("floor", this), new Integer(85));
	literals.put(new ANTLRHashString("\u6216\u8005", this), new Integer(128));
	literals.put(new ANTLRHashString("\u5927\u4e8e\u7b49\u4e8e", this), new Integer(119));
	literals.put(new ANTLRHashString("substring", this), new Integer(73));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u53f3\u622a", this), new Integer(78));
	literals.put(new ANTLRHashString("and", this), new Integer(54));
	literals.put(new ANTLRHashString("asc", this), new Integer(43));
	literals.put(new ANTLRHashString("str", this), new Integer(93));
	literals.put(new ANTLRHashString("desc", this), new Integer(44));
	literals.put(new ANTLRHashString("select", this), new Integer(24));
	literals.put(new ANTLRHashString("\u5b58\u5728\u4e8e", this), new Integer(92));
	literals.put(new ANTLRHashString("\u6216", this), new Integer(110));
	literals.put(new ANTLRHashString("\u6570\u503c\u8f6c\u5b57\u7b26\u4e32", this), new Integer(94));
	literals.put(new ANTLRHashString("\u8868\u5408\u5e76", this), new Integer(18));
	literals.put(new ANTLRHashString("exists", this), new Integer(131));
	literals.put(new ANTLRHashString("distinct", this), new Integer(26));
	literals.put(new ANTLRHashString("right", this), new Integer(77));
	literals.put(new ANTLRHashString("group", this), new Integer(30));
	literals.put(new ANTLRHashString("\u6392\u5e8f", this), new Integer(34));
	literals.put(new ANTLRHashString("where", this), new Integer(22));
	literals.put(new ANTLRHashString("\u4e0d\u5305\u542b", this), new Integer(125));
	literals.put(new ANTLRHashString("\u4e0e", this), new Integer(109));
	literals.put(new ANTLRHashString("\u4e3a\u7a7a", this), new Integer(50));
	literals.put(new ANTLRHashString("\u5206\u7ec4", this), new Integer(32));
	literals.put(new ANTLRHashString("\u8868\u6bd4\u8f83", this), new Integer(21));
	literals.put(new ANTLRHashString("\u5927\u4e8e", this), new Integer(121));
	literals.put(new ANTLRHashString("\u5c06\u5b57\u7b26\u4e32\u8f6c\u4e3a\u5c0f\u5199", this), new Integer(90));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5927\u503c", this), new Integer(100));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e\u7b49\u4e8e", this), new Integer(120));
	literals.put(new ANTLRHashString("\u6c42\u5e73\u65b9\u6839", this), new Integer(68));
	literals.put(new ANTLRHashString("avg", this), new Integer(97));
	literals.put(new ANTLRHashString("getdate", this), new Integer(69));
	literals.put(new ANTLRHashString("order", this), new Integer(33));
	literals.put(new ANTLRHashString("in", this), new Integer(56));
	literals.put(new ANTLRHashString("\u6c42\u4e94\u5165\u540e\u7684\u6574\u6570", this), new Integer(88));
	literals.put(new ANTLRHashString("null", this), new Integer(48));
	literals.put(new ANTLRHashString("\u4e58", this), new Integer(114));
	literals.put(new ANTLRHashString("\u4e0d\u7b49\u4e8e", this), new Integer(123));
	literals.put(new ANTLRHashString("ceiling", this), new Integer(87));
	literals.put(new ANTLRHashString("\u6c42\u548c", this), new Integer(96));
	literals.put(new ANTLRHashString("char_length", this), new Integer(83));
	literals.put(new ANTLRHashString("rtrim", this), new Integer(81));
	literals.put(new ANTLRHashString("\u5c0f\u4e8e", this), new Integer(122));
	literals.put(new ANTLRHashString("\u4e0d\u5728\u4e8e", this), new Integer(58));
	literals.put(new ANTLRHashString("\u6c42\u6700\u5c0f\u503c", this), new Integer(102));
	literals.put(new ANTLRHashString("\u6240\u6709", this), new Integer(39));
	literals.put(new ANTLRHashString("\u5305\u542b", this), new Integer(124));
	literals.put(new ANTLRHashString("or", this), new Integer(126));
	literals.put(new ANTLRHashString("between", this), new Integer(52));
	literals.put(new ANTLRHashString("\u53bb\u6389\u5de6\u7a7a\u683c", this), new Integer(80));
	literals.put(new ANTLRHashString("ltrim", this), new Integer(79));
	literals.put(new ANTLRHashString("\u4f5c\u4e3a", this), new Integer(36));
	literals.put(new ANTLRHashString("max", this), new Integer(99));
	literals.put(new ANTLRHashString("from", this), new Integer(28));
	literals.put(new ANTLRHashString("is", this), new Integer(47));
	literals.put(new ANTLRHashString("\u683c\u5f0f\u5316\u6570\u503c", this), new Integer(76));
	literals.put(new ANTLRHashString("\u5e76\u4e14", this), new Integer(127));
	literals.put(new ANTLRHashString("like", this), new Integer(118));
	literals.put(new ANTLRHashString("\u6c42\u5b57\u7b26\u4e32\u7684\u957f\u5ea6", this), new Integer(84));
	literals.put(new ANTLRHashString("\u8303\u56f4", this), new Integer(53));
	literals.put(new ANTLRHashString("=", this), new Integer(37));
	literals.put(new ANTLRHashString("t_union", this), new Integer(17));
	literals.put(new ANTLRHashString("charindex", this), new Integer(91));
	literals.put(new ANTLRHashString("\u7b49\u4e8e", this), new Integer(38));
	literals.put(new ANTLRHashString("\u5728\u4e8e", this), new Integer(57));
	literals.put(new ANTLRHashString("\u4e0d\u5b58\u5728", this), new Integer(130));
	literals.put(new ANTLRHashString("\u5b57\u7b26\u4e32\u622a\u53d6", this), new Integer(74));
	literals.put(new ANTLRHashString("\u6c42\u6a21", this), new Integer(116));
	literals.put(new ANTLRHashString("\u67e5\u8be2", this), new Integer(25));
	literals.put(new ANTLRHashString("\u6c42\u8bb0\u5f55\u6570", this), new Integer(104));
	literals.put(new ANTLRHashString("\u6765\u81ea", this), new Integer(29));
	literals.put(new ANTLRHashString("\u53bb\u6389\u53f3\u7a7a\u683c", this), new Integer(82));
	literals.put(new ANTLRHashString("\u975e\u7a7a", this), new Integer(51));
	literals.put(new ANTLRHashString("\u52a0", this), new Integer(112));
	literals.put(new ANTLRHashString("not", this), new Integer(49));
	literals.put(new ANTLRHashString("not exists", this), new Integer(129));
	literals.put(new ANTLRHashString("\u5347\u5e8f", this), new Integer(41));
	literals.put(new ANTLRHashString("by", this), new Integer(31));
	literals.put(new ANTLRHashString("t_compare", this), new Integer(20));
	literals.put(new ANTLRHashString("as", this), new Integer(35));
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
				case '*':
				{
					mSTAR(true);
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
					if ((LA(1)=='e') && (LA(2)=='x') && (LA(3)=='i') && (LA(4)=='s') && (LA(5)=='t')) {
						mEXIST(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='c') && (LA(2)=='o') && (LA(3)=='l') && (LA(4)=='u') && (LA(5)=='m')) {
						mCOLUMN(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='w') && (LA(2)=='h') && (LA(3)=='e') && (LA(4)=='r') && (LA(5)=='e')) {
						mWHERE(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='n') && (LA(2)=='o') && (LA(3)=='t') && (LA(4)==' ')) {
						mNOT_EXIST(true);
						theRetToken=_returnToken;
					}
					else if ((LA(1)=='n') && (LA(2)=='o') && (LA(3)=='t') && (true) && (true)) {
						mONE_ARG_OP(true);
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
		
		match("not");
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
	
	public final void mNOT_EXIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = NOT_EXIST;
		int _saveIndex;
		
		match("not exist");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	public final void mEXIST(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = EXIST;
		int _saveIndex;
		
		match("exist");
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
		int _cnt106=0;
		_loop106:
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
				if ( _cnt106>=1 ) { break _loop106; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			}
			_cnt106++;
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
		_loop111:
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
				break _loop111;
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
		_loop121:
		do {
			if ((_tokenSet_4.member(LA(1)))) {
				mID_LETTER(false);
			}
			else {
				break _loop121;
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
			_loop130:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9'))) {
					mNUM_LETTER(false);
				}
				else {
					break _loop130;
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
		int _cnt133=0;
		_loop133:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mNUM_LETTER(false);
			}
			else {
				if ( _cnt133>=1 ) { break _loop133; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine(), getColumn());}
			}
			
			_cnt133++;
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
		_loop139:
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
				break _loop139;
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
