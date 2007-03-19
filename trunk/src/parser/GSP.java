// $ANTLR 2.7.7 (2006-11-01): "src/parser/getting_start.g" -> "GSP.java"$

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

public class GSP extends antlr.LLkParser       implements GSPTokenTypes
 {

protected GSP(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public GSP(TokenBuffer tokenBuf) {
  this(tokenBuf,1);
}

protected GSP(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public GSP(TokenStream lexer) {
  this(lexer,1);
}

public GSP(ParserSharedInputState state) {
  super(state,1);
  tokenNames = _tokenNames;
}

	public final void startRule() throws RecognitionException, TokenStreamException {
		
		Token  n = null;
		
		try {      // for error handling
			n = LT(1);
			match(START);
			System.out.println("You input: "+n.getText());
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"START"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	
	}
