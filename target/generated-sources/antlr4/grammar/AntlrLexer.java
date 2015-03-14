// Generated from AntlrLexer.g4 by ANTLR 4.4
package grammar;

	import org.antlr.v4.runtime.ANTLRFileStream;
	import org.antlr.v4.runtime.CommonTokenStream;
	
	import java.util.HashMap;
	import java.util.Stack;
	import java.util.Queue;
	import java.util.LinkedList;
	import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AntlrLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SCRIPT=1, WS=2, COMMENTS=3, ARGUMENTS=4, ANY=5, CHAR_SEQUENCE=6, STRING_SEQUENCE=7, 
		STRING_SEQUENCE2=8, STRING_SEQUENCE3=9, PARAM_START=10, PRE_START=11, 
		String_PRE_START=12, String_SEQUENCE=13, String_END=14, String2_PRE_START=15, 
		String2_SEQUENCE=16, String2_END=17, String3_PRE_START=18, String3_SEQUENCE=19, 
		String3_END=20, Arguments_WS=21, Arguments_RBRACK=22, Arguments_ARGUMENT=23, 
		Param_ANY=24, Param_PARAM_START=25, Param_END=26, Param_PRE_START=27, 
		ImportStart_WS=28, ImportStart_Parens=29, Import_WS=30, Import_FILE=31, 
		Imporg_ARG_READ=32, Import_END=33, ImportArg_WS=34, ImportArg_ARG=35, 
		ImportArg_ARG_READ=36, ImportArg_END=37, Arg_WS=38, Arg_VAL=39, EvalStart_WS=40, 
		EvalStart_Parens=41, Eval_WS=42, Eval_EXPR=43, Eval_EXPR_PARENS=44, Eval_END=45, 
		EvaluateStart_WS=46, EvaluateStart_Parens=47, Evaluate_WS=48, Evaluate_EXPR=49, 
		Evaluate_EXPR_PARENS=50, Evaluate_END=51, Package_WS=52, Package_FILE=53, 
		Package_FILE_READ=54, Package_END=55, PackageArg_WS=56, PackageArg_ARG=57, 
		PackageArg_ARG_READ=58, PackageArg_END=59, Pre_WS=60, Pre_IMPORT_START=61, 
		Pre_PACKAGE_START=62, Pre_ARG_START=63, Pre_EVAL_START=64, Pre_EVAL=65, 
		Pre_END=66, PreEnd_WS=67, PreEnd_End=68;
	public static final int Normal = 1;
	public static final int String = 2;
	public static final int String2 = 3;
	public static final int String3 = 4;
	public static final int Arguments = 5;
	public static final int Param = 6;
	public static final int ImportStart = 7;
	public static final int Import = 8;
	public static final int ImportArg = 9;
	public static final int Arg = 10;
	public static final int EvalStart = 11;
	public static final int Eval = 12;
	public static final int EvaluateStart = 13;
	public static final int Evaluate = 14;
	public static final int Package = 15;
	public static final int PackageArg = 16;
	public static final int Pre = 17;
	public static final int PreEnd = 18;
	public static String[] modeNames = {
		"DEFAULT_MODE", "Normal", "String", "String2", "String3", "Arguments", 
		"Param", "ImportStart", "Import", "ImportArg", "Arg", "EvalStart", "Eval", 
		"EvaluateStart", "Evaluate", "Package", "PackageArg", "Pre", "PreEnd"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'", "'%'", "'&'", "'''", 
		"'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", "'/'", "'0'", "'1'", 
		"'2'", "'3'", "'4'", "'5'", "'6'", "'7'", "'8'", "'9'", "':'", "';'", 
		"'<'", "'='", "'>'", "'?'", "'@'", "'A'", "'B'", "'C'", "'D'"
	};
	public static final String[] ruleNames = {
		"WS", "COMMENTS", "ARGUMENTS", "ANY", "CHAR_SEQUENCE", "STRING_SEQUENCE", 
		"STRING_SEQUENCE2", "STRING_SEQUENCE3", "PARAM_START", "PRE_START", "String_PRE_START", 
		"String_SEQUENCE", "String_END", "String2_PRE_START", "String2_SEQUENCE", 
		"String2_END", "String3_PRE_START", "String3_SEQUENCE", "String3_END", 
		"Arguments_WS", "Arguments_RBRACK", "Arguments_ARGUMENT", "Param_ANY", 
		"Param_PARAM_START", "Param_END", "Param_PRE_START", "ImportStart_WS", 
		"ImportStart_Parens", "Import_WS", "Import_FILE", "Imporg_ARG_READ", "Import_END", 
		"ImportArg_WS", "ImportArg_ARG", "ImportArg_ARG_READ", "ImportArg_END", 
		"Arg_WS", "Arg_VAL", "EvalStart_WS", "EvalStart_Parens", "Eval_WS", "Eval_EXPR", 
		"Eval_EXPR_PARENS", "Eval_END", "EvaluateStart_WS", "EvaluateStart_Parens", 
		"Evaluate_WS", "Evaluate_EXPR", "Evaluate_EXPR_PARENS", "Evaluate_END", 
		"Package_WS", "Package_FILE", "Package_FILE_READ", "Package_END", "PackageArg_WS", 
		"PackageArg_ARG", "PackageArg_ARG_READ", "PackageArg_END", "Pre_WS", "Pre_IMPORT_START", 
		"Pre_PACKAGE_START", "Pre_ARG_START", "Pre_EVAL_START", "Pre_EVAL", "Pre_END", 
		"PreEnd_WS", "PreEnd_End"
	};


		private ExprParser.Value evaluate(String expr)
		{
			if (expr == null || expr == "")
			{
				return new ExprParser.Value(true);
			}
			
			ExprLexer lexer = new ExprLexer(new ANTLRInputStream(expr));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
			tokenStream.fill();
			return new ExprParser(rewriter, environment).start().v;
		}
		
		public class Environment
		{
			private class InputState
			{
				public final int line;
				public final int charPosition;
				public final CharStream input;
				public final Pair<TokenSource, CharStream> tokenFactory;
				
				public InputState()
				{
					line = _interp.getLine();
					charPosition = _interp.getCharPositionInLine();
					input = _input;
					tokenFactory = _tokenFactorySourcePair;
				}
				
				public void load()
				{
					_input = input;
					_tokenFactorySourcePair = tokenFactory;
					_interp.setLine(line);
					_interp.setCharPositionInLine(charPosition);
				}
			}
			
			private Stack<InputState> inputStates = new Stack<InputState>();
			private LinkedList<String> args = new LinkedList<String>();
			
			public boolean openPackage(String whichPackage)
			{
				ANTLRInputStream input = null;
				
				try
				{
					input = new ANTLRInputStream(symbolTable.get(whichPackage));
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				if (input == null)
				{
					return false;
				}
				
				/*
				 * replace input
				 */
				inputStates.push(new InputState());
				
				_input = input;
				_interp.setLine(0);
				_interp.setCharPositionInLine(0);
				
				/*
				 * replace symbols
				 */
				 new Scope(Scope.get()).enter();
				
				/*
				 * go to top mode
				 */
				pushMode(0);
				
				return true;
			}
			
			public boolean openFile(String filename)
			{
				ANTLRFileStream input = null;
				
				try
				{
					input = new ANTLRFileStream(filename);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
				if (input == null)
				{
					return false;
				}
				
				/*
				 * replace input
				 */
				inputStates.push(new InputState());
				
				_input = input;
				_tokenFactorySourcePair = new Pair<TokenSource, CharStream>(AntlrLexer.this, input);
				_interp.setLine(0);
				_interp.setCharPositionInLine(0);
				
				/*
				 * replace symbols
				 */
				new Scope(Scope.get()).enter();
				
				/*
				 * go to top mode
				 */
				 
				pushMode(0);
				
				return true;
			}
			
			public boolean close()
			{
				if (inputStates.isEmpty())
				{
					return false;
				}
				
				/*
				 * load previous input
				 */
				inputStates.pop().load();
				
				/*
				 * load previous symbols
				 */
				//symbolTable.pop();
				
				/*
				 * go to previous mode
				 */
				popMode();
				
				_hitEOF = false;
							
				return true;
			}
			
			public void define(String symbol, String value)
			{
				if (value != null)
				{
					symbolTable.define(symbol, value);
				}
			}
			
			public void undefine(String symbol)
			{
				symbolTable.undefine(symbol);
			}
			
			public String get(String symbol)
			{
				return symbolTable.get(symbol);
			}
			
			public void pushArg(String arg)
			{
				args.addLast(arg);
			}
			
			public String popArg()
			{
				if (args.isEmpty())
				{
					return null;
				}
				
				return args.pop();
			}
			
			public void clearArgs()
			{
				args.clear();
			}
			
			public boolean isEmpty()
			{
				return inputStates.isEmpty();
			}
		}
		
		/*
		 * this manages
		 * 
		 * 		input
		 * 		symbol table
		 */
		private Environment environment = new Environment();
		
		/*
		 * override to close current input when at EOF as there may be multiple
		 * inputs
		 */
		@Override
		public Token nextToken()
		{
			Token token = super.nextToken();
			while (token.getType() == -1 && environment.close())
			{
				token = super.nextToken();
			}
			return token;
		}
		
		private class BlockState
		{
			public final String close;
			
			public BlockState(String close)
			{
				this.close = close;
			}
		}
		
		private java.util.Stack<BlockState> block = new java.util.Stack<BlockState>();
		private java.util.Stack<Boolean> enabled = new java.util.Stack<Boolean>();
		private java.util.Stack<ScriptBlock> scriptBlock = new java.util.Stack<ScriptBlock>();
		
		private class ScriptBlock
		{
			public ScriptBlock()
			{
				scriptBlock.push(this);
			}
			
			public void onExit()
			{
				scriptBlock.pop();
			}
		} //ScriptBlock
		
		private class IfBlock extends ScriptBlock
		{
			public IfBlock(boolean enable)
			{
				super();
				enabled.push(enable);
			} //IfBlock
			
			@Override public void onExit()
			{
				super.onExit();
				enabled.pop();
			}
		}
		
		public void popBlock()
		{
			if (!scriptBlock.isEmpty())
			{
				scriptBlock.peek().onExit();
			} //if
			else
			{
				error("Attempt to close a block that does not exist");
			} //else
		}
		
		public boolean isEnabled()
		{
			return enabled.isEmpty() || enabled.peek();
		}
		
		private boolean valid = true;
		public boolean isValid() { return valid; }
		
		private void error(final String message)
	    {
	    	valid = false;
	    	
			getErrorListenerDispatch().syntaxError(
	    		                                       AntlrLexer.this,
	    		                                       null,
	    		                                       _tokenStartLine,
	    		                                       _tokenStartCharPositionInLine,
	    		                                       message + ": " + getCurrentText(),
	    		                                       null
			                                       );
		}
		
		private String getCurrentText(int start, int end)
		{
			return _input.getText(Interval.of(_tokenStartCharIndex + start, _input.index() + end));
		}
		
		private String getCurrentText()
		{
			return _input.getText(Interval.of(_tokenStartCharIndex, _input.index()));
		}
		
		private void checkForClose()
		{
			if (!block.isEmpty() && _input.LA(2) == EOF && environment.isEmpty())
			{
				error("Missing closing '" + block.peek().close + "'");
				pop(-1, false);
			}
			
			if (!scriptBlock.isEmpty() && _input.LA(2) == EOF)
			{
				error("Missing closing '<end>'");
				popBlock();
			}
		}
		
		//or
		private boolean la(String ... ts)
		{
			if (ts != null)
			{
				int i = 0;
				int len = 0;
				
				byte ahead;
				
				for (String s : ts)
				{
					i = 0;
					len = s.length();
					
					while (i < len)
					{
						ahead = (byte)_input.LA(1 + i);
						
						if (ahead == -1 || ahead != s.charAt(i))
						{
							len = 0;
						}
						else
						{
							++i;
						}
					}
					
					if (len > 0)
					{
						return true;
					}
				}
				
				if (len == 0)
				{
					return false;
				}
			}
			
			return true;
		}
		
		//and
		private boolean nla(String ... ts)
		{
			if (ts != null)
			{
				int i = 0;
				int len = 0;
				
				byte ahead;
				
				for (String s : ts)
				{
					i = 0;
					len = s.length();
					
					while (i < len)
					{
						ahead = (byte)_input.LA(1 + i);
						
						if (ahead != -1 && ahead != s.charAt(i))
						{
							len = 0;
						}
						else
						{
							++i;
						}
					}
					
					if (len > 0)
					{
						return false;
					}
				}
			}
			
			return true;
		}
		
		private boolean cont(int t, boolean o)
		{
			if (o)
			{
				more();
			}
			else if (t < 0 || !isEnabled())
			{
				skip();
			}
			else
			{
				_type = t;
			}
			
			checkForClose();
			
			return o;
		}
		
		private boolean push(String c, int m, int t, boolean o)
		{
			boolean enabled = isEnabled();
			block.push(new BlockState(c));
			
			pushMode(m);
			
			cont(t, o);
			
			return o;
		}
		
		private boolean pop(int t, boolean o)
		{
			block.pop();
			
			popMode();
			
			cont(t, o);
			
			return o;
		}
		
		private boolean cont(int t, String ... ts)
		{
			return cont(t, la(ts));
		}
		
		private boolean ncont(int t, String ... ts)
		{
			return cont(t, nla(ts));
		}
		
		private boolean push(String c, int m, int t, String ... ts)
		{
			return push(c, m, t, la(ts));
		}
		
		private boolean npush(String c, int m, int t, String ... ts)
		{
			return push(c, m, t, nla(ts));
		}
		
		private boolean pop(int t, String ... ts)
		{
			return pop(t, la(ts));
		}
		
		private boolean npop(int t, String ... ts)
		{
			return pop(t, nla(ts));
		}
		
		public String expression = "";
		public int expressionDepth = 0;


	public AntlrLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AntlrLexer.g4"; }

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
		case 2: ARGUMENTS_action((RuleContext)_localctx, actionIndex); break;
		case 3: ANY_action((RuleContext)_localctx, actionIndex); break;
		case 4: CHAR_SEQUENCE_action((RuleContext)_localctx, actionIndex); break;
		case 5: STRING_SEQUENCE_action((RuleContext)_localctx, actionIndex); break;
		case 6: STRING_SEQUENCE2_action((RuleContext)_localctx, actionIndex); break;
		case 7: STRING_SEQUENCE3_action((RuleContext)_localctx, actionIndex); break;
		case 8: PARAM_START_action((RuleContext)_localctx, actionIndex); break;
		case 9: PRE_START_action((RuleContext)_localctx, actionIndex); break;
		case 10: String_PRE_START_action((RuleContext)_localctx, actionIndex); break;
		case 11: String_SEQUENCE_action((RuleContext)_localctx, actionIndex); break;
		case 12: String_END_action((RuleContext)_localctx, actionIndex); break;
		case 13: String2_PRE_START_action((RuleContext)_localctx, actionIndex); break;
		case 14: String2_SEQUENCE_action((RuleContext)_localctx, actionIndex); break;
		case 15: String2_END_action((RuleContext)_localctx, actionIndex); break;
		case 16: String3_PRE_START_action((RuleContext)_localctx, actionIndex); break;
		case 17: String3_SEQUENCE_action((RuleContext)_localctx, actionIndex); break;
		case 18: String3_END_action((RuleContext)_localctx, actionIndex); break;
		case 19: Arguments_WS_action((RuleContext)_localctx, actionIndex); break;
		case 20: Arguments_RBRACK_action((RuleContext)_localctx, actionIndex); break;
		case 21: Arguments_ARGUMENT_action((RuleContext)_localctx, actionIndex); break;
		case 22: Param_ANY_action((RuleContext)_localctx, actionIndex); break;
		case 23: Param_PARAM_START_action((RuleContext)_localctx, actionIndex); break;
		case 24: Param_END_action((RuleContext)_localctx, actionIndex); break;
		case 25: Param_PRE_START_action((RuleContext)_localctx, actionIndex); break;
		case 26: ImportStart_WS_action((RuleContext)_localctx, actionIndex); break;
		case 27: ImportStart_Parens_action((RuleContext)_localctx, actionIndex); break;
		case 28: Import_WS_action((RuleContext)_localctx, actionIndex); break;
		case 29: Import_FILE_action((RuleContext)_localctx, actionIndex); break;
		case 30: Imporg_ARG_READ_action((RuleContext)_localctx, actionIndex); break;
		case 31: Import_END_action((RuleContext)_localctx, actionIndex); break;
		case 32: ImportArg_WS_action((RuleContext)_localctx, actionIndex); break;
		case 33: ImportArg_ARG_action((RuleContext)_localctx, actionIndex); break;
		case 34: ImportArg_ARG_READ_action((RuleContext)_localctx, actionIndex); break;
		case 35: ImportArg_END_action((RuleContext)_localctx, actionIndex); break;
		case 36: Arg_WS_action((RuleContext)_localctx, actionIndex); break;
		case 37: Arg_VAL_action((RuleContext)_localctx, actionIndex); break;
		case 38: EvalStart_WS_action((RuleContext)_localctx, actionIndex); break;
		case 39: EvalStart_Parens_action((RuleContext)_localctx, actionIndex); break;
		case 40: Eval_WS_action((RuleContext)_localctx, actionIndex); break;
		case 41: Eval_EXPR_action((RuleContext)_localctx, actionIndex); break;
		case 42: Eval_EXPR_PARENS_action((RuleContext)_localctx, actionIndex); break;
		case 43: Eval_END_action((RuleContext)_localctx, actionIndex); break;
		case 44: EvaluateStart_WS_action((RuleContext)_localctx, actionIndex); break;
		case 45: EvaluateStart_Parens_action((RuleContext)_localctx, actionIndex); break;
		case 46: Evaluate_WS_action((RuleContext)_localctx, actionIndex); break;
		case 47: Evaluate_EXPR_action((RuleContext)_localctx, actionIndex); break;
		case 48: Evaluate_EXPR_PARENS_action((RuleContext)_localctx, actionIndex); break;
		case 49: Evaluate_END_action((RuleContext)_localctx, actionIndex); break;
		case 50: Package_WS_action((RuleContext)_localctx, actionIndex); break;
		case 51: Package_FILE_action((RuleContext)_localctx, actionIndex); break;
		case 52: Package_FILE_READ_action((RuleContext)_localctx, actionIndex); break;
		case 53: Package_END_action((RuleContext)_localctx, actionIndex); break;
		case 54: PackageArg_WS_action((RuleContext)_localctx, actionIndex); break;
		case 55: PackageArg_ARG_action((RuleContext)_localctx, actionIndex); break;
		case 56: PackageArg_ARG_READ_action((RuleContext)_localctx, actionIndex); break;
		case 57: PackageArg_END_action((RuleContext)_localctx, actionIndex); break;
		case 58: Pre_WS_action((RuleContext)_localctx, actionIndex); break;
		case 59: Pre_IMPORT_START_action((RuleContext)_localctx, actionIndex); break;
		case 60: Pre_PACKAGE_START_action((RuleContext)_localctx, actionIndex); break;
		case 61: Pre_ARG_START_action((RuleContext)_localctx, actionIndex); break;
		case 62: Pre_EVAL_START_action((RuleContext)_localctx, actionIndex); break;
		case 63: Pre_EVAL_action((RuleContext)_localctx, actionIndex); break;
		case 64: Pre_END_action((RuleContext)_localctx, actionIndex); break;
		case 65: PreEnd_WS_action((RuleContext)_localctx, actionIndex); break;
		case 66: PreEnd_End_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void PackageArg_ARG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 53: 
											if (isEnabled())
											{
												_text = getCurrentText(1, -2);
											
												_text = _text.replace("\\n", "\n");
												_text = _text.replace("\\r", "\r");
												_text = _text.replace("\\t", "\t");
												_text = _text.replace("\\b", "\b");
												_text = _text.replace("\\f", "\f");
												_text = _text.replace("\\\"", "\"");
												_text = _text.replaceAll("\\(.)", "$1");
												
												environment.pushArg(_text);
											}
											
											skip();
										 break;
		}
	}
	private void Param_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 22: 
											npop(SCRIPT, "#<");
										 break;
		}
	}
	private void Package_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 48: skip(); break;
		}
	}
	private void Pre_ARG_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 59: 
												_mode = PreEnd;
												pushMode(Arg);
												skip();
											 break;
		}
	}
	private void Param_PARAM_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 21: 
											npush("]", Param, SCRIPT, "#<");
										 break;
		}
	}
	private void Eval_EXPR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 39: 
										expression += getCurrentText(0, -1);
										skip();
									 break;
		}
	}
	private void EvaluateStart_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 42: skip(); break;
		}
	}
	private void PackageArg_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 52: skip(); break;
		}
	}
	private void PackageArg_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 55: 
											pop(-1, false);
											
											if (isEnabled())
											{
												environment.openPackage(environment.popArg());
											}
										 break;
		}
	}
	private void Pre_IMPORT_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 57: 
												_mode = PreEnd;
												push(")", ImportStart, -1, false);
											 break;
		}
	}
	private void String3_SEQUENCE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 15: 
											ncont(SCRIPT, "#<");
										 break;
		}
	}
	private void Import_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 26: skip(); break;
		}
	}
	private void Param_ANY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 20: 
											ncont(SCRIPT, "]");
										 break;
		}
	}
	private void String2_PRE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 11: 
											push(">", Pre, -1, false);
											skip();
										 break;
		}
	}
	private void PackageArg_ARG_READ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 54: 
											if (isEnabled())
											{
												environment.pushArg(environment.get(getCurrentText()));
											}
											
											skip();
										 break;
		}
	}
	private void Evaluate_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 44: skip(); break;
		}
	}
	private void Package_FILE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 49: 
											if (isEnabled())
											{
												_text = getCurrentText(1, -2);
											
												_text = _text.replace("\\n", "\n");
												_text = _text.replace("\\r", "\r");
												_text = _text.replace("\\t", "\t");
												_text = _text.replace("\\b", "\b");
												_text = _text.replace("\\f", "\f");
												_text = _text.replace("\\\"", "\"");
												_text = _text.replaceAll("\\(.)", "$1");
												
												environment.pushArg(_text);
											}
											
											skip();
											
											_mode = PackageArg;
										 break;
		}
	}
	private void Arguments_ARGUMENT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 19: 
											if (isEnabled())
											{
												environment.define(getCurrentText(0, -1), environment.popArg());
											}
											
											skip();
										 break;
		}
	}
	private void Pre_PACKAGE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 58: 
												_mode = PreEnd;
												//TO DO
												//popMode();
												//push("#`}", Package, -1, false);
											 break;
		}
	}
	private void Arguments_RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 18: 
											if (isEnabled())
											{
												environment.clearArgs();
											}
											
											pop(-1, false);
										 break;
		}
	}
	private void String_SEQUENCE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 9: 
											ncont(SCRIPT, "#<");
										 break;
		}
	}
	private void Arg_VAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 35: 
										if (isEnabled())
										{
											String value = evaluate(getCurrentText(0, -1)).getString();
											//System.out.println("value: " + value);
											
											if (value == null || value == "")
											{
												skip();
											} //if
											else
											{
												_text = value;
												_type = SCRIPT;
											} //else
										}
										else
										{
											skip();
										}
										
										popMode();
									 break;
		}
	}
	private void Imporg_ARG_READ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 28: 
											if (isEnabled())
											{
												environment.pushArg(environment.get(getCurrentText(0, -1)));
											}
											
											skip();
											
											_mode = ImportArg;
										 break;
		}
	}
	private void ImportStart_Parens_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 25: _mode = Import; skip(); break;
		}
	}
	private void Package_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 51: 
											pop(-1, false);
											
											if (isEnabled())
											{
												environment.openPackage(environment.popArg());
											}
										 break;
		}
	}
	private void PARAM_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: 
											push("]", Param, SCRIPT, true);
										 break;
		}
	}
	private void EvaluateStart_Parens_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 43: 
										_mode = Evaluate;
										skip();
										expression = "";
										expressionDepth = 0;
									 break;
		}
	}
	private void Evaluate_EXPR_PARENS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 46: 
										++expressionDepth;
										push(")", Eval, -1, false);
										expression += "(";
									 break;
		}
	}
	private void STRING_SEQUENCE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: 
											npush("\"", String, SCRIPT, "#<");
										 break;
		}
	}
	private void String_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 10: 
											npop(SCRIPT, "#<");
										 break;
		}
	}
	private void String_PRE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: 
											push(">", Pre, -1, false);
											skip();
										 break;
		}
	}
	private void Pre_EVAL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 61: 
												_mode = PreEnd;
												push(")", EvaluateStart, -1, false);
												skip();
											 break;
		}
	}
	private void String2_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 13: 
											npop(SCRIPT, "#<");
										 break;
		}
	}
	private void Import_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 29: 
											pop(-1, false);
											skip();
											
											if (isEnabled())
											{
												environment.open(environment.popArg());
											}
										 break;
		}
	}
	private void Package_FILE_READ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 50: 
											if (isEnabled())
											{
												environment.pushArg(environment.get(getCurrentText()));
											}
											
											skip();
										 break;
		}
	}
	private void ImportStart_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 24: skip(); break;
		}
	}
	private void Pre_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 62: 
												_mode = PreEnd;
												skip();
												popBlock();
											 break;
		}
	}
	private void ANY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
											_mode = Normal;
											_input.seek(_input.index() - 1);
											skip();
										 break;
		}
	}
	private void Eval_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 38: skip(); break;
		}
	}
	private void Eval_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 41: 
										pop(-1, false);
										
										if (expressionDepth-- > 0)
										{
											expression += ")";
										}
										else
										{
											ExprParser.Value value = evaluate(expression);
											//System.out.println("Value: " + value.getString() + " == " + expression);
											new IfBlock(value.getBoolean());
										}
									 break;
		}
	}
	private void Arguments_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 17: 
											skip();
										 break;
		}
	}
	private void Evaluate_EXPR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 45: 
										expression += getCurrentText(0, -1);
										skip();
									 break;
		}
	}
	private void STRING_SEQUENCE3_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
											npush("'", String3, SCRIPT, "#<");
										 break;
		}
	}
	private void STRING_SEQUENCE2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
											npush("`", String2, SCRIPT, "#<");
										 break;
		}
	}
	private void Import_FILE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 27: 
											if (isEnabled())
											{
												_text = getCurrentText(1, -2);
												_text = _text.replace("\\n", "\n");
												_text = _text.replace("\\r", "\r");
												_text = _text.replace("\\t", "\t");
												_text = _text.replace("\\b", "\b");
												_text = _text.replace("\\f", "\f");
												_text = _text.replaceAll("\\\\(.)", "$1");
												
												environment.pushArg(_text);
											}
											
											skip();
											
											_mode = ImportArg;
										 break;
		}
	}
	private void ImportArg_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 30: skip(); break;
		}
	}
	private void PreEnd_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 63: skip(); break;
		}
	}
	private void Pre_EVAL_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 60: 
												_mode = PreEnd;
												push(")", EvalStart, -1, false);
												skip();
											 break;
		}
	}
	private void CHAR_SEQUENCE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
											ncont(SCRIPT, "#<");
										 break;
		}
	}
	private void PRE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: 
											push(">", Pre, -1, false);
											skip();
										 break;
		}
	}
	private void EvalStart_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 36: skip(); break;
		}
	}
	private void Pre_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 56: skip(); break;
		}
	}
	private void Arg_WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 34: skip(); break;
		}
	}
	private void Evaluate_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 47: 
										pop(-1, false);
										
										if (expressionDepth-- > 0)
										{
											expression += ")";
										}
										else
										{
											evaluate(expression);
											//System.out.println("Value: " + value.getString() + " == " + expression);
										}
									 break;
		}
	}
	private void PreEnd_End_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 64: 
												pop(-1, false);
												skip();
											 break;
		}
	}
	private void ImportArg_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 33: 
											pop(-1, false);
											skip();
											
											if (isEnabled())
											{
												environment.open(environment.popArg());
											}
										 break;
		}
	}
	private void ImportArg_ARG_READ_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 32: 
											if (isEnabled())
											{
												environment.pushArg(environment.get(getCurrentText(0, -1)));
											}
											
											skip();
										 break;
		}
	}
	private void EvalStart_Parens_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 37: 
										_mode = Eval;
										skip();
										expression = "";
										expressionDepth = 0;
									 break;
		}
	}
	private void ARGUMENTS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
											_mode = Normal;
											push("#<end>", Arguments, -1, false);
										 break;
		}
	}
	private void String3_END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 16: 
											npop(SCRIPT, "#<");
										 break;
		}
	}
	private void Eval_EXPR_PARENS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 40: 
										++expressionDepth;
										push(")", Eval, -1, false);
										expression += "(";
									 break;
		}
	}
	private void ImportArg_ARG_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 31: 
											if (isEnabled())
											{
												_text = getCurrentText(0, -1);
												
												if (_text.charAt(0) == '"')
												{
													_text = _text.replace("\\n", "\n");
													_text = _text.replace("\\r", "\r");
													_text = _text.replace("\\t", "\t");
													_text = _text.replace("\\b", "\b");
													_text = _text.replace("\\f", "\f");
													_text = _text.replaceAll("\\\\(.)", "$1");
												} //if
												
												environment.pushArg(_text);
											}
											
											skip();
										 break;
		}
	}
	private void String2_SEQUENCE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 12: 
											ncont(SCRIPT, "#<");
										 break;
		}
	}
	private void String3_PRE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 14: 
											push(">", Pre, -1, false);
											skip();
										 break;
		}
	}
	private void Param_PRE_START_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 23: 
											push(">", Pre, -1, false);
											skip();
										 break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 60: return Pre_PACKAGE_START_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean Pre_PACKAGE_START_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return false;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2F\u02a4\b\1\b\1\b"+
		"\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t"+
		"=\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\6\2\u009d\n\2\r\2\16\2"+
		"\u009e\3\2\3\2\3\3\3\3\3\3\3\3\7\3\u00a7\n\3\f\3\16\3\u00aa\13\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\7\3\u00b2\n\3\f\3\16\3\u00b5\13\3\6\3\u00b7\n\3\r\3"+
		"\16\3\u00b8\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00d6\n\6\f\6\16"+
		"\6\u00d9\13\6\3\6\3\6\5\6\u00dd\n\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\5\r\u00fd\n\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u010f\n\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\5\23\u0121\n\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\6\25\u012a\n\25\r"+
		"\25\16\25\u012b\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\6\27\u013a\n\27\r\27\16\27\u013b\3\27\3\27\3\30\3\30\3\30\3\30\5"+
		"\30\u0144\n\30\3\30\3\30\3\30\5\30\u0149\n\30\6\30\u014b\n\30\r\30\16"+
		"\30\u014c\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\6\34\u015e\n\34\r\34\16\34\u015f\3\34\3\34\3\35\3\35\3"+
		"\35\3\36\3\36\6\36\u0169\n\36\r\36\16\36\u016a\3\36\3\36\3\37\3\37\3\37"+
		"\3\37\7\37\u0173\n\37\f\37\16\37\u0176\13\37\3\37\3\37\3\37\3 \6 \u017c"+
		"\n \r \16 \u017d\3 \3 \3!\3!\3!\3\"\3\"\6\"\u0187\n\"\r\"\16\"\u0188\3"+
		"\"\3\"\3#\3#\3#\3#\7#\u0191\n#\f#\16#\u0194\13#\3#\3#\5#\u0198\n#\3#\6"+
		"#\u019b\n#\r#\16#\u019c\3#\3#\7#\u01a1\n#\f#\16#\u01a4\13#\5#\u01a6\n"+
		"#\3#\3#\3$\3$\7$\u01ac\n$\f$\16$\u01af\13$\3$\3$\3%\3%\3%\3&\3&\6&\u01b8"+
		"\n&\r&\16&\u01b9\3&\3&\3\'\6\'\u01bf\n\'\r\'\16\'\u01c0\3\'\3\'\3\'\3"+
		"\'\7\'\u01c7\n\'\f\'\16\'\u01ca\13\'\3\'\6\'\u01cd\n\'\r\'\16\'\u01ce"+
		"\3\'\3\'\3(\3(\6(\u01d5\n(\r(\16(\u01d6\3(\3(\3)\3)\3)\3*\3*\6*\u01e0"+
		"\n*\r*\16*\u01e1\3*\3*\3+\3+\3+\3+\3+\7+\u01eb\n+\f+\16+\u01ee\13+\3+"+
		"\5+\u01f1\n+\3+\3+\3,\3,\3,\3-\3-\3-\3.\3.\6.\u01fd\n.\r.\16.\u01fe\3"+
		".\3.\3/\3/\3/\3\60\3\60\6\60\u0208\n\60\r\60\16\60\u0209\3\60\3\60\3\61"+
		"\3\61\3\61\3\61\3\61\7\61\u0213\n\61\f\61\16\61\u0216\13\61\3\61\5\61"+
		"\u0219\n\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3\64\3\64\6\64\u0225"+
		"\n\64\r\64\16\64\u0226\3\64\3\64\3\65\3\65\3\65\3\65\7\65\u022f\n\65\f"+
		"\65\16\65\u0232\13\65\3\65\3\65\3\65\3\66\6\66\u0238\n\66\r\66\16\66\u0239"+
		"\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\38\38\68\u0246\n8\r8\168\u0247"+
		"\38\38\39\39\39\39\79\u0250\n9\f9\169\u0253\139\39\39\39\3:\6:\u0259\n"+
		":\r:\16:\u025a\3:\3:\3;\3;\3;\3;\3;\3;\3<\3<\6<\u0267\n<\r<\16<\u0268"+
		"\3<\3<\3=\3=\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3>\3?"+
		"\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B"+
		"\3B\3C\3C\6C\u029c\nC\rC\16C\u029d\3C\3C\3D\3D\3D\3\u00a8\2E\25\4\27\5"+
		"\31\6\33\7\35\b\37\t!\n#\13%\f\'\r)\16+\17-\20/\21\61\22\63\23\65\24\67"+
		"\259\26;\27=\30?\31A\32C\33E\34G\35I\36K\37M O!Q\"S#U$W%Y&[\'](_)a*c+"+
		"e,g-i.k/m\60o\61q\62s\63u\64w\65y\66{\67}8\1779\u0081:\u0083;\u0085<\u0087"+
		"=\u0089>\u008b?\u008d@\u008fA\u0091B\u0093C\u0095D\u0097E\u0099F\25\2"+
		"\3\4\5\6\7\b\t\n\13\f\r\16\17\20\21\22\23\24\23\5\2\13\f\17\17\"\"\4\2"+
		"\f\f\17\17\7\2$%)),,\61\61]_\3\2]_\5\2%%,,\61\61\4\2$$^^\4\2^^bb\4\2)"+
		")^^\6\2\62;C\\aac|\5\2%%>>]_\3\2^_\3\2>>\3\2\63;\3\2\62;\5\2C\\aac|\4"+
		"\2$$@@\4\2$$*+\u02dd\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\3\35\3\2\2\2\3\37\3\2\2\2\3!\3\2\2\2\3#\3\2\2\2\3%\3\2\2\2\3\'\3\2"+
		"\2\2\4)\3\2\2\2\4+\3\2\2\2\4-\3\2\2\2\5/\3\2\2\2\5\61\3\2\2\2\5\63\3\2"+
		"\2\2\6\65\3\2\2\2\6\67\3\2\2\2\69\3\2\2\2\7;\3\2\2\2\7=\3\2\2\2\7?\3\2"+
		"\2\2\bA\3\2\2\2\bC\3\2\2\2\bE\3\2\2\2\bG\3\2\2\2\tI\3\2\2\2\tK\3\2\2\2"+
		"\nM\3\2\2\2\nO\3\2\2\2\nQ\3\2\2\2\nS\3\2\2\2\13U\3\2\2\2\13W\3\2\2\2\13"+
		"Y\3\2\2\2\13[\3\2\2\2\f]\3\2\2\2\f_\3\2\2\2\ra\3\2\2\2\rc\3\2\2\2\16e"+
		"\3\2\2\2\16g\3\2\2\2\16i\3\2\2\2\16k\3\2\2\2\17m\3\2\2\2\17o\3\2\2\2\20"+
		"q\3\2\2\2\20s\3\2\2\2\20u\3\2\2\2\20w\3\2\2\2\21y\3\2\2\2\21{\3\2\2\2"+
		"\21}\3\2\2\2\21\177\3\2\2\2\22\u0081\3\2\2\2\22\u0083\3\2\2\2\22\u0085"+
		"\3\2\2\2\22\u0087\3\2\2\2\23\u0089\3\2\2\2\23\u008b\3\2\2\2\23\u008d\3"+
		"\2\2\2\23\u008f\3\2\2\2\23\u0091\3\2\2\2\23\u0093\3\2\2\2\23\u0095\3\2"+
		"\2\2\24\u0097\3\2\2\2\24\u0099\3\2\2\2\25\u009c\3\2\2\2\27\u00b6\3\2\2"+
		"\2\31\u00bc\3\2\2\2\33\u00cb\3\2\2\2\35\u00dc\3\2\2\2\37\u00e0\3\2\2\2"+
		"!\u00e3\3\2\2\2#\u00e6\3\2\2\2%\u00e9\3\2\2\2\'\u00ec\3\2\2\2)\u00f1\3"+
		"\2\2\2+\u00fc\3\2\2\2-\u0100\3\2\2\2/\u0103\3\2\2\2\61\u010e\3\2\2\2\63"+
		"\u0112\3\2\2\2\65\u0115\3\2\2\2\67\u0120\3\2\2\29\u0124\3\2\2\2;\u0129"+
		"\3\2\2\2=\u012f\3\2\2\2?\u0139\3\2\2\2A\u014a\3\2\2\2C\u0150\3\2\2\2E"+
		"\u0153\3\2\2\2G\u0156\3\2\2\2I\u015d\3\2\2\2K\u0163\3\2\2\2M\u0168\3\2"+
		"\2\2O\u016e\3\2\2\2Q\u017b\3\2\2\2S\u0181\3\2\2\2U\u0186\3\2\2\2W\u01a5"+
		"\3\2\2\2Y\u01a9\3\2\2\2[\u01b2\3\2\2\2]\u01b7\3\2\2\2_\u01cc\3\2\2\2a"+
		"\u01d4\3\2\2\2c\u01da\3\2\2\2e\u01df\3\2\2\2g\u01f0\3\2\2\2i\u01f4\3\2"+
		"\2\2k\u01f7\3\2\2\2m\u01fc\3\2\2\2o\u0202\3\2\2\2q\u0207\3\2\2\2s\u0218"+
		"\3\2\2\2u\u021c\3\2\2\2w\u021f\3\2\2\2y\u0224\3\2\2\2{\u022a\3\2\2\2}"+
		"\u0237\3\2\2\2\177\u023d\3\2\2\2\u0081\u0245\3\2\2\2\u0083\u024b\3\2\2"+
		"\2\u0085\u0258\3\2\2\2\u0087\u025e\3\2\2\2\u0089\u0266\3\2\2\2\u008b\u026c"+
		"\3\2\2\2\u008d\u0275\3\2\2\2\u008f\u0280\3\2\2\2\u0091\u0283\3\2\2\2\u0093"+
		"\u0288\3\2\2\2\u0095\u0293\3\2\2\2\u0097\u029b\3\2\2\2\u0099\u02a1\3\2"+
		"\2\2\u009b\u009d\t\2\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\b\2"+
		"\2\2\u00a1\26\3\2\2\2\u00a2\u00a3\7\61\2\2\u00a3\u00a4\7,\2\2\u00a4\u00a8"+
		"\3\2\2\2\u00a5\u00a7\13\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2"+
		"\u00a8\u00a9\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8"+
		"\3\2\2\2\u00ab\u00ac\7,\2\2\u00ac\u00b7\7\61\2\2\u00ad\u00ae\7\61\2\2"+
		"\u00ae\u00af\7\61\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\n\3\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00a2\3\2\2\2\u00b6\u00ad\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9"+
		"\u00ba\3\2\2\2\u00ba\u00bb\b\3\2\2\u00bb\30\3\2\2\2\u00bc\u00bd\7%\2\2"+
		"\u00bd\u00be\7>\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1"+
		"\7i\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7o\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"\u00c5\7p\2\2\u00c5\u00c6\7v\2\2\u00c6\u00c7\7u\2\2\u00c7\u00c8\7@\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\u00ca\b\4\3\2\u00ca\32\3\2\2\2\u00cb\u00cc"+
		"\13\2\2\2\u00cc\u00cd\b\5\4\2\u00cd\34\3\2\2\2\u00ce\u00dd\n\4\2\2\u00cf"+
		"\u00dd\5\25\2\2\u00d0\u00dd\5\27\3\2\u00d1\u00d7\7]\2\2\u00d2\u00d6\n"+
		"\5\2\2\u00d3\u00d4\7^\2\2\u00d4\u00d6\13\2\2\2\u00d5\u00d2\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\7_\2\2\u00db"+
		"\u00dd\t\6\2\2\u00dc\u00ce\3\2\2\2\u00dc\u00cf\3\2\2\2\u00dc\u00d0\3\2"+
		"\2\2\u00dc\u00d1\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de"+
		"\u00df\b\6\5\2\u00df\36\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1\u00e2\b\7\6\2"+
		"\u00e2 \3\2\2\2\u00e3\u00e4\7b\2\2\u00e4\u00e5\b\b\7\2\u00e5\"\3\2\2\2"+
		"\u00e6\u00e7\7)\2\2\u00e7\u00e8\b\t\b\2\u00e8$\3\2\2\2\u00e9\u00ea\7]"+
		"\2\2\u00ea\u00eb\b\n\t\2\u00eb&\3\2\2\2\u00ec\u00ed\7%\2\2\u00ed\u00ee"+
		"\7>\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f0\b\13\n\2\u00f0(\3\2\2\2\u00f1"+
		"\u00f2\7%\2\2\u00f2\u00f3\7>\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b\f\13"+
		"\2\u00f5*\3\2\2\2\u00f6\u00fd\n\7\2\2\u00f7\u00f8\7^\2\2\u00f8\u00f9\7"+
		"%\2\2\u00f9\u00fd\7>\2\2\u00fa\u00fb\7^\2\2\u00fb\u00fd\13\2\2\2\u00fc"+
		"\u00f6\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\3\2"+
		"\2\2\u00fe\u00ff\b\r\f\2\u00ff,\3\2\2\2\u0100\u0101\7$\2\2\u0101\u0102"+
		"\b\16\r\2\u0102.\3\2\2\2\u0103\u0104\7%\2\2\u0104\u0105\7>\2\2\u0105\u0106"+
		"\3\2\2\2\u0106\u0107\b\17\16\2\u0107\60\3\2\2\2\u0108\u010f\n\b\2\2\u0109"+
		"\u010a\7^\2\2\u010a\u010b\7%\2\2\u010b\u010f\7>\2\2\u010c\u010d\7^\2\2"+
		"\u010d\u010f\13\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2\2\u010e\u010c"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0111\b\20\17\2\u0111\62\3\2\2\2\u0112"+
		"\u0113\7b\2\2\u0113\u0114\b\21\20\2\u0114\64\3\2\2\2\u0115\u0116\7%\2"+
		"\2\u0116\u0117\7>\2\2\u0117\u0118\3\2\2\2\u0118\u0119\b\22\21\2\u0119"+
		"\66\3\2\2\2\u011a\u0121\n\t\2\2\u011b\u011c\7^\2\2\u011c\u011d\7%\2\2"+
		"\u011d\u0121\7>\2\2\u011e\u011f\7^\2\2\u011f\u0121\13\2\2\2\u0120\u011a"+
		"\3\2\2\2\u0120\u011b\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\3\2\2\2\u0122"+
		"\u0123\b\23\22\2\u01238\3\2\2\2\u0124\u0125\7)\2\2\u0125\u0126\b\24\23"+
		"\2\u0126:\3\2\2\2\u0127\u012a\5\25\2\2\u0128\u012a\5\27\3\2\u0129\u0127"+
		"\3\2\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\b\25\24\2\u012e<\3\2\2"+
		"\2\u012f\u0130\7%\2\2\u0130\u0131\7>\2\2\u0131\u0132\7g\2\2\u0132\u0133"+
		"\7p\2\2\u0133\u0134\7f\2\2\u0134\u0135\7@\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0137\b\26\25\2\u0137>\3\2\2\2\u0138\u013a\t\n\2\2\u0139\u0138\3\2\2"+
		"\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013e\b\27\26\2\u013e@\3\2\2\2\u013f\u014b\n\13\2\2\u0140"+
		"\u0143\7^\2\2\u0141\u0144\n\f\2\2\u0142\u0144\7\2\2\3\u0143\u0141\3\2"+
		"\2\2\u0143\u0142\3\2\2\2\u0144\u014b\3\2\2\2\u0145\u0148\7%\2\2\u0146"+
		"\u0149\n\r\2\2\u0147\u0149\7\2\2\3\u0148\u0146\3\2\2\2\u0148\u0147\3\2"+
		"\2\2\u0149\u014b\3\2\2\2\u014a\u013f\3\2\2\2\u014a\u0140\3\2\2\2\u014a"+
		"\u0145\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b\30\27\2\u014fB\3\2\2\2\u0150\u0151"+
		"\7]\2\2\u0151\u0152\b\31\30\2\u0152D\3\2\2\2\u0153\u0154\7_\2\2\u0154"+
		"\u0155\b\32\31\2\u0155F\3\2\2\2\u0156\u0157\7%\2\2\u0157\u0158\7>\2\2"+
		"\u0158\u0159\3\2\2\2\u0159\u015a\b\33\32\2\u015aH\3\2\2\2\u015b\u015e"+
		"\5\25\2\2\u015c\u015e\5\27\3\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2\2\2"+
		"\u015e\u015f\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161"+
		"\3\2\2\2\u0161\u0162\b\34\33\2\u0162J\3\2\2\2\u0163\u0164\7*\2\2\u0164"+
		"\u0165\b\35\34\2\u0165L\3\2\2\2\u0166\u0169\5\25\2\2\u0167\u0169\5\27"+
		"\3\2\u0168\u0166\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u016b\3\2\2\2\u016b\u016c\3\2\2\2\u016c\u016d\b\36"+
		"\35\2\u016dN\3\2\2\2\u016e\u0174\7$\2\2\u016f\u0173\n\7\2\2\u0170\u0171"+
		"\7^\2\2\u0171\u0173\13\2\2\2\u0172\u016f\3\2\2\2\u0172\u0170\3\2\2\2\u0173"+
		"\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2"+
		"\2\2\u0176\u0174\3\2\2\2\u0177\u0178\7$\2\2\u0178\u0179\b\37\36\2\u0179"+
		"P\3\2\2\2\u017a\u017c\t\n\2\2\u017b\u017a\3\2\2\2\u017c\u017d\3\2\2\2"+
		"\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180"+
		"\b \37\2\u0180R\3\2\2\2\u0181\u0182\7+\2\2\u0182\u0183\b! \2\u0183T\3"+
		"\2\2\2\u0184\u0187\5\25\2\2\u0185\u0187\5\27\3\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u018b\b\"!\2\u018bV\3\2\2\2\u018c\u0192"+
		"\7$\2\2\u018d\u0191\n\7\2\2\u018e\u018f\7^\2\2\u018f\u0191\13\2\2\2\u0190"+
		"\u018d\3\2\2\2\u0190\u018e\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0192\3\2\2\2\u0195"+
		"\u01a6\7$\2\2\u0196\u0198\t\16\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2"+
		"\2\2\u0198\u019a\3\2\2\2\u0199\u019b\t\17\2\2\u019a\u0199\3\2\2\2\u019b"+
		"\u019c\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2"+
		"\2\2\u019e\u01a2\7\60\2\2\u019f\u01a1\t\17\2\2\u01a0\u019f\3\2\2\2\u01a1"+
		"\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a6\3\2"+
		"\2\2\u01a4\u01a2\3\2\2\2\u01a5\u018c\3\2\2\2\u01a5\u0197\3\2\2\2\u01a6"+
		"\u01a7\3\2\2\2\u01a7\u01a8\b#\"\2\u01a8X\3\2\2\2\u01a9\u01ad\t\20\2\2"+
		"\u01aa\u01ac\t\n\2\2\u01ab\u01aa\3\2\2\2\u01ac\u01af\3\2\2\2\u01ad\u01ab"+
		"\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae\u01b0\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0"+
		"\u01b1\b$#\2\u01b1Z\3\2\2\2\u01b2\u01b3\7+\2\2\u01b3\u01b4\b%$\2\u01b4"+
		"\\\3\2\2\2\u01b5\u01b8\5\25\2\2\u01b6\u01b8\5\27\3\2\u01b7\u01b5\3\2\2"+
		"\2\u01b7\u01b6\3\2\2\2\u01b8\u01b9\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba"+
		"\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bc\b&%\2\u01bc^\3\2\2\2\u01bd\u01bf"+
		"\n\21\2\2\u01be\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01be\3\2\2\2"+
		"\u01c0\u01c1\3\2\2\2\u01c1\u01cd\3\2\2\2\u01c2\u01c8\7$\2\2\u01c3\u01c7"+
		"\n\7\2\2\u01c4\u01c5\7^\2\2\u01c5\u01c7\13\2\2\2\u01c6\u01c3\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c7\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2"+
		"\2\2\u01c9\u01cb\3\2\2\2\u01ca\u01c8\3\2\2\2\u01cb\u01cd\7$\2\2\u01cc"+
		"\u01be\3\2\2\2\u01cc\u01c2\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01cc\3\2"+
		"\2\2\u01ce\u01cf\3\2\2\2\u01cf\u01d0\3\2\2\2\u01d0\u01d1\b\'&\2\u01d1"+
		"`\3\2\2\2\u01d2\u01d5\5\25\2\2\u01d3\u01d5\5\27\3\2\u01d4\u01d2\3\2\2"+
		"\2\u01d4\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6\u01d7"+
		"\3\2\2\2\u01d7\u01d8\3\2\2\2\u01d8\u01d9\b(\'\2\u01d9b\3\2\2\2\u01da\u01db"+
		"\7*\2\2\u01db\u01dc\b)(\2\u01dcd\3\2\2\2\u01dd\u01e0\5\25\2\2\u01de\u01e0"+
		"\5\27\3\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0\u01e1\3\2\2\2"+
		"\u01e1\u01df\3\2\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01e4"+
		"\b*)\2\u01e4f\3\2\2\2\u01e5\u01f1\n\22\2\2\u01e6\u01ec\7$\2\2\u01e7\u01eb"+
		"\n\7\2\2\u01e8\u01e9\7^\2\2\u01e9\u01eb\13\2\2\2\u01ea\u01e7\3\2\2\2\u01ea"+
		"\u01e8\3\2\2\2\u01eb\u01ee\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2"+
		"\2\2\u01ed\u01ef\3\2\2\2\u01ee\u01ec\3\2\2\2\u01ef\u01f1\7$\2\2\u01f0"+
		"\u01e5\3\2\2\2\u01f0\u01e6\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f3\b+"+
		"*\2\u01f3h\3\2\2\2\u01f4\u01f5\7*\2\2\u01f5\u01f6\b,+\2\u01f6j\3\2\2\2"+
		"\u01f7\u01f8\7+\2\2\u01f8\u01f9\b-,\2\u01f9l\3\2\2\2\u01fa\u01fd\5\25"+
		"\2\2\u01fb\u01fd\5\27\3\2\u01fc\u01fa\3\2\2\2\u01fc\u01fb\3\2\2\2\u01fd"+
		"\u01fe\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ff\u0200\3\2"+
		"\2\2\u0200\u0201\b.-\2\u0201n\3\2\2\2\u0202\u0203\7*\2\2\u0203\u0204\b"+
		"/.\2\u0204p\3\2\2\2\u0205\u0208\5\25\2\2\u0206\u0208\5\27\3\2\u0207\u0205"+
		"\3\2\2\2\u0207\u0206\3\2\2\2\u0208\u0209\3\2\2\2\u0209\u0207\3\2\2\2\u0209"+
		"\u020a\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020c\b\60/\2\u020cr\3\2\2\2"+
		"\u020d\u0219\n\22\2\2\u020e\u0214\7$\2\2\u020f\u0213\n\7\2\2\u0210\u0211"+
		"\7^\2\2\u0211\u0213\13\2\2\2\u0212\u020f\3\2\2\2\u0212\u0210\3\2\2\2\u0213"+
		"\u0216\3\2\2\2\u0214\u0212\3\2\2\2\u0214\u0215\3\2\2\2\u0215\u0217\3\2"+
		"\2\2\u0216\u0214\3\2\2\2\u0217\u0219\7$\2\2\u0218\u020d\3\2\2\2\u0218"+
		"\u020e\3\2\2\2\u0219\u021a\3\2\2\2\u021a\u021b\b\61\60\2\u021bt\3\2\2"+
		"\2\u021c\u021d\7*\2\2\u021d\u021e\b\62\61\2\u021ev\3\2\2\2\u021f\u0220"+
		"\7+\2\2\u0220\u0221\b\63\62\2\u0221x\3\2\2\2\u0222\u0225\5\25\2\2\u0223"+
		"\u0225\5\27\3\2\u0224\u0222\3\2\2\2\u0224\u0223\3\2\2\2\u0225\u0226\3"+
		"\2\2\2\u0226\u0224\3\2\2\2\u0226\u0227\3\2\2\2\u0227\u0228\3\2\2\2\u0228"+
		"\u0229\b\64\63\2\u0229z\3\2\2\2\u022a\u0230\7$\2\2\u022b\u022f\n\7\2\2"+
		"\u022c\u022d\7^\2\2\u022d\u022f\13\2\2\2\u022e\u022b\3\2\2\2\u022e\u022c"+
		"\3\2\2\2\u022f\u0232\3\2\2\2\u0230\u022e\3\2\2\2\u0230\u0231\3\2\2\2\u0231"+
		"\u0233\3\2\2\2\u0232\u0230\3\2\2\2\u0233\u0234\7$\2\2\u0234\u0235\b\65"+
		"\64\2\u0235|\3\2\2\2\u0236\u0238\t\n\2\2\u0237\u0236\3\2\2\2\u0238\u0239"+
		"\3\2\2\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2\u023b"+
		"\u023c\b\66\65\2\u023c~\3\2\2\2\u023d\u023e\7%\2\2\u023e\u023f\7b\2\2"+
		"\u023f\u0240\7\177\2\2\u0240\u0241\3\2\2\2\u0241\u0242\b\67\66\2\u0242"+
		"\u0080\3\2\2\2\u0243\u0246\5\25\2\2\u0244\u0246\5\27\3\2\u0245\u0243\3"+
		"\2\2\2\u0245\u0244\3\2\2\2\u0246\u0247\3\2\2\2\u0247\u0245\3\2\2\2\u0247"+
		"\u0248\3\2\2\2\u0248\u0249\3\2\2\2\u0249\u024a\b8\67\2\u024a\u0082\3\2"+
		"\2\2\u024b\u0251\7$\2\2\u024c\u0250\n\7\2\2\u024d\u024e\7^\2\2\u024e\u0250"+
		"\13\2\2\2\u024f\u024c\3\2\2\2\u024f\u024d\3\2\2\2\u0250\u0253\3\2\2\2"+
		"\u0251\u024f\3\2\2\2\u0251\u0252\3\2\2\2\u0252\u0254\3\2\2\2\u0253\u0251"+
		"\3\2\2\2\u0254\u0255\7$\2\2\u0255\u0256\b98\2\u0256\u0084\3\2\2\2\u0257"+
		"\u0259\t\n\2\2\u0258\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u0258\3\2"+
		"\2\2\u025a\u025b\3\2\2\2\u025b\u025c\3\2\2\2\u025c\u025d\b:9\2\u025d\u0086"+
		"\3\2\2\2\u025e\u025f\7%\2\2\u025f\u0260\7b\2\2\u0260\u0261\7\177\2\2\u0261"+
		"\u0262\3\2\2\2\u0262\u0263\b;:\2\u0263\u0088\3\2\2\2\u0264\u0267\5\25"+
		"\2\2\u0265\u0267\5\27\3\2\u0266\u0264\3\2\2\2\u0266\u0265\3\2\2\2\u0267"+
		"\u0268\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u026a\3\2"+
		"\2\2\u026a\u026b\b<;\2\u026b\u008a\3\2\2\2\u026c\u026d\7k\2\2\u026d\u026e"+
		"\7o\2\2\u026e\u026f\7r\2\2\u026f\u0270\7q\2\2\u0270\u0271\7t\2\2\u0271"+
		"\u0272\7v\2\2\u0272\u0273\3\2\2\2\u0273\u0274\b=<\2\u0274\u008c\3\2\2"+
		"\2\u0275\u0276\6>\2\2\u0276\u0277\7r\2\2\u0277\u0278\7c\2\2\u0278\u0279"+
		"\7e\2\2\u0279\u027a\7m\2\2\u027a\u027b\7c\2\2\u027b\u027c\7i\2\2\u027c"+
		"\u027d\7g\2\2\u027d\u027e\3\2\2\2\u027e\u027f\b>=\2\u027f\u008e\3\2\2"+
		"\2\u0280\u0281\7&\2\2\u0281\u0282\b?>\2\u0282\u0090\3\2\2\2\u0283\u0284"+
		"\7k\2\2\u0284\u0285\7h\2\2\u0285\u0286\3\2\2\2\u0286\u0287\b@?\2\u0287"+
		"\u0092\3\2\2\2\u0288\u0289\7g\2\2\u0289\u028a\7x\2\2\u028a\u028b\7c\2"+
		"\2\u028b\u028c\7n\2\2\u028c\u028d\7w\2\2\u028d\u028e\7c\2\2\u028e\u028f"+
		"\7v\2\2\u028f\u0290\7g\2\2\u0290\u0291\3\2\2\2\u0291\u0292\bA@\2\u0292"+
		"\u0094\3\2\2\2\u0293\u0294\7g\2\2\u0294\u0295\7p\2\2\u0295\u0296\7f\2"+
		"\2\u0296\u0297\3\2\2\2\u0297\u0298\bBA\2\u0298\u0096\3\2\2\2\u0299\u029c"+
		"\5\25\2\2\u029a\u029c\5\27\3\2\u029b\u0299\3\2\2\2\u029b\u029a\3\2\2\2"+
		"\u029c\u029d\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e\u029f"+
		"\3\2\2\2\u029f\u02a0\bCB\2\u02a0\u0098\3\2\2\2\u02a1\u02a2\7@\2\2\u02a2"+
		"\u02a3\bDC\2\u02a3\u009a\3\2\2\2Z\2\3\4\5\6\7\b\t\n\13\f\r\16\17\20\21"+
		"\22\23\24\u009e\u00a8\u00b3\u00b6\u00b8\u00d5\u00d7\u00dc\u00fc\u010e"+
		"\u0120\u0129\u012b\u013b\u0143\u0148\u014a\u014c\u015d\u015f\u0168\u016a"+
		"\u0172\u0174\u017d\u0186\u0188\u0190\u0192\u0197\u019c\u01a2\u01a5\u01ad"+
		"\u01b7\u01b9\u01c0\u01c6\u01c8\u01cc\u01ce\u01d4\u01d6\u01df\u01e1\u01ea"+
		"\u01ec\u01f0\u01fc\u01fe\u0207\u0209\u0212\u0214\u0218\u0224\u0226\u022e"+
		"\u0230\u0239\u0245\u0247\u024f\u0251\u025a\u0266\u0268\u029b\u029dD\b"+
		"\2\2\3\4\2\3\5\3\3\6\4\3\7\5\3\b\6\3\t\7\3\n\b\3\13\t\3\f\n\3\r\13\3\16"+
		"\f\3\17\r\3\20\16\3\21\17\3\22\20\3\23\21\3\24\22\3\25\23\3\26\24\3\27"+
		"\25\3\30\26\3\31\27\3\32\30\3\33\31\3\34\32\3\35\33\3\36\34\3\37\35\3"+
		" \36\3!\37\3\" \3#!\3$\"\3%#\3&$\3\'%\3(&\3)\'\3*(\3+)\3,*\3-+\3.,\3/"+
		"-\3\60.\3\61/\3\62\60\3\63\61\3\64\62\3\65\63\3\66\64\3\67\65\38\66\3"+
		"9\67\3:8\3;9\3<:\3=;\3><\3?=\3@>\3A?\3B@\3CA\3DB";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}