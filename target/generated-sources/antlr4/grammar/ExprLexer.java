// Generated from Expr.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, BOOLEAN=18, INTEGER=19, DOUBLE=20, STRING=21, VARIABLE=22, WS=23, 
		COMMENTS=24;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'"
	};
	public static final String[] ruleNames = {
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"BOOLEAN", "INTEGER", "DOUBLE", "STRING", "VARIABLE", "WS", "COMMENTS"
	};


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 20: STRING_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void STRING_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
					_text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index() - 1));
					
					_text = _text.replace("\\n", "\n");
					_text = _text.replace("\\r", "\r");
					_text = _text.replace("\\t", "\t");
					_text = _text.replace("\\b", "\b");
					_text = _text.replace("\\f", "\f");
					_text = _text.replaceAll("\\\\(.)", "$1");
				 break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\32\u00ad\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\5\23e\n\23\3\24\5\24h\n\24\3\24\6\24k\n\24\r\24\16\24"+
		"l\3\25\5\25p\n\25\3\25\6\25s\n\25\r\25\16\25t\3\25\3\25\7\25y\n\25\f\25"+
		"\16\25|\13\25\3\26\3\26\3\26\3\26\7\26\u0082\n\26\f\26\16\26\u0085\13"+
		"\26\3\26\3\26\3\26\3\27\3\27\6\27\u008c\n\27\r\27\16\27\u008d\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u0098\n\31\f\31\16\31\u009b\13\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u00a3\n\31\f\31\16\31\u00a6\13\31"+
		"\6\31\u00a8\n\31\r\31\16\31\u00a9\3\31\3\31\3\u0099\2\32\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\3\2\t\3\2\63;\3\2\62;\4\2$$^^\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u00b9\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\3\63\3\2\2\2\5\65\3\2\2\2\78\3\2\2\2\t;\3\2\2\2\13>\3\2\2\2\rA\3\2"+
		"\2\2\17D\3\2\2\2\21F\3\2\2\2\23H\3\2\2\2\25J\3\2\2\2\27M\3\2\2\2\31O\3"+
		"\2\2\2\33Q\3\2\2\2\35S\3\2\2\2\37U\3\2\2\2!W\3\2\2\2#Y\3\2\2\2%d\3\2\2"+
		"\2\'g\3\2\2\2)o\3\2\2\2+}\3\2\2\2-\u0089\3\2\2\2/\u008f\3\2\2\2\61\u00a7"+
		"\3\2\2\2\63\64\7\61\2\2\64\4\3\2\2\2\65\66\7#\2\2\66\67\7?\2\2\67\6\3"+
		"\2\2\289\7~\2\29:\7~\2\2:\b\3\2\2\2;<\7@\2\2<=\7?\2\2=\n\3\2\2\2>?\7("+
		"\2\2?@\7(\2\2@\f\3\2\2\2AB\7?\2\2BC\7?\2\2C\16\3\2\2\2DE\7>\2\2E\20\3"+
		"\2\2\2FG\7?\2\2G\22\3\2\2\2HI\7@\2\2I\24\3\2\2\2JK\7>\2\2KL\7?\2\2L\26"+
		"\3\2\2\2MN\7#\2\2N\30\3\2\2\2OP\7\'\2\2P\32\3\2\2\2QR\7*\2\2R\34\3\2\2"+
		"\2ST\7+\2\2T\36\3\2\2\2UV\7,\2\2V \3\2\2\2WX\7-\2\2X\"\3\2\2\2YZ\7/\2"+
		"\2Z$\3\2\2\2[\\\7v\2\2\\]\7t\2\2]^\7w\2\2^e\7g\2\2_`\7h\2\2`a\7c\2\2a"+
		"b\7n\2\2bc\7u\2\2ce\7g\2\2d[\3\2\2\2d_\3\2\2\2e&\3\2\2\2fh\t\2\2\2gf\3"+
		"\2\2\2gh\3\2\2\2hj\3\2\2\2ik\t\3\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3"+
		"\2\2\2m(\3\2\2\2np\t\2\2\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qs\t\3\2\2rq\3"+
		"\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vz\7\60\2\2wy\t\3\2\2xw"+
		"\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{*\3\2\2\2|z\3\2\2\2}\u0083\7$\2"+
		"\2~\u0082\n\4\2\2\177\u0080\7^\2\2\u0080\u0082\13\2\2\2\u0081~\3\2\2\2"+
		"\u0081\177\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7$\2\2\u0087"+
		"\u0088\b\26\2\2\u0088,\3\2\2\2\u0089\u008b\t\5\2\2\u008a\u008c\t\6\2\2"+
		"\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e"+
		"\3\2\2\2\u008e.\3\2\2\2\u008f\u0090\t\7\2\2\u0090\u0091\3\2\2\2\u0091"+
		"\u0092\b\30\3\2\u0092\60\3\2\2\2\u0093\u0094\7\61\2\2\u0094\u0095\7,\2"+
		"\2\u0095\u0099\3\2\2\2\u0096\u0098\13\2\2\2\u0097\u0096\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7,\2\2\u009d\u00a8\7\61\2\2\u009e"+
		"\u009f\7\61\2\2\u009f\u00a0\7\61\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\n"+
		"\b\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u0093\3\2"+
		"\2\2\u00a7\u009e\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
		"\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\31\3\2\u00ac\62\3\2\2"+
		"\2\20\2dglotz\u0081\u0083\u008d\u0099\u00a4\u00a7\u00a9\4\3\26\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}