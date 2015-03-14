/*
 * to do
 * 
 * 		packages (dread)
 * 
 * 			save the package into the package table (the string)
 * 			recall the package later on
 * 
 * 			import will also import packages****
 */
 
//	output is a list of script tokens
//
//	import file with arguments
//
//		#<import("filename" "arg1" "arg2" "arg3" arg4)>
//
//	dump expression result to script
//
//		#<$expression>
//
//	evaluate expression
//
//		#<evaluate(expression)>
//
//	expression
//
//		variable + 19/2
//
//	#<if (expression)>
//	#<end>
//
//	create package with arguments
//
//		#<package name>
//			<arguments>
//			<end>
//		#<end>
//
//	import package with arguments (inherits current file/package arguments)
//
//		#<implement packageName("arg1" "arg2" "arg3" arg4)>

lexer grammar AntlrLexer;

@header
{
	import org.antlr.v4.runtime.ANTLRFileStream;
	import org.antlr.v4.runtime.CommonTokenStream;
	
	import java.util.HashMap;
	import java.util.Stack;
	import java.util.Queue;
	import java.util.LinkedList;
	import java.util.Map;
}

tokens
{
	SCRIPT
}

@members
{
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
}

/*
 * if type is less than 0, skip
 * type only matters if not continue
 * 
 * 		- params
 * 			String ... searchStrings
 * 			String closingString
 * 
 * 			int useType
 * 			int goToMode
 * 
 * 			boolean continue
 * 
 * 		- conditions
 * 			private boolean la(stringsThatMustBeFound)
 * 				returns true if any of these are found
 * 
 * 			private boolean nla(stringsThatMustNotBeFound)
 * 				returns true if none of the strings are found
 * 
 * 		- includes next character in token if continue
 * 		- when a string is provided instead of a boolean, the condition for that
 * 		- string must be true for the next text to be included in the current token
 * 			boolean cont(useType, continue?)
 * 			boolean cont(goToMode, stringsThatMustBeFound)
 * 			boolean ncont(goToMode, stringsThatMustNotBeFound)
 *
 * 		- goes to mode and consumes next token if continue
 * 		- a type < 0 is skipped
 * 			boolean push(closingString, goToMode, useType, continue?)
 * 			boolean push(closingString, goToMode, useType, stringsThatMustBeFound)
 * 			boolean npush(String closingString, goToMode, useType, stringsThatMustNotBeFound)
 *
 * 		- pops from mode and consumes next token if continue
 * 			boolean pop(useType, continue?)
 * 			boolean pop(useType, stringsThatMustBeFound)
 * 			boolean npop(useType, stringsThatMustNotBeFound)
 * 
 * 		boolean environment.open(filename)
 * 		environment.define(symbol, value)
 * 		environment.undefine(symbol)
 * 		string environment.get(symbol)
 * 		environment.pushArg(arg)
 * 		String environment.popArg()
 * 		environment.clearArgs()
 * 		String getCurrentText()
 * 		String getCurrentText(start, end)
 * 
 * 		- tokens are skipped if enabled is false
 * 			boolean isEnabled()
 * 			void pushEnabled(boolean enable)
 * 			void popEnabled()
 */

//header
WS								:	[ \t\r\n]+
								-> skip
								;
COMMENTS						:	(	'/*' .*? '*/'
									| 	'//' ~[\r\n]*
									)+
								-> skip
								;
								
ARGUMENTS						:	'#<arguments>'
								{
									_mode = Normal;
									push("#<end>", Arguments, -1, false);
								}
								;
ANY								:	.
								{
									_mode = Normal;
									_input.seek(_input.index() - 1);
									skip();
								}
								;

//script
//	#{ }
//args
//	#[ ]

mode Normal //Antlr script
;
//this will continue to consume characters for a given token until the #< sequence is hit
CHAR_SEQUENCE					: 	(	~[\'"\[\]\\*/#]
									|	WS
									|	COMMENTS
									| 	'[' (~[\\\]\[] | '\\' .)* ']'			//	[	]
									|	'#'
									|	'/'
									|	'*'
									)
								{
									ncont(SCRIPT, "#<");
								}
								;
STRING_SEQUENCE					:	'"'
								{
									npush("\"", String, SCRIPT, "#<");
								}
								;
STRING_SEQUENCE2				:	'`'
								{
									npush("`", String2, SCRIPT, "#<");
								}
								;
STRING_SEQUENCE3				:	'\''
								{
									npush("'", String3, SCRIPT, "#<");
								}
								;
PARAM_START						:	'['
								{
									push("]", Param, SCRIPT, true);
								}
								;
PRE_START						:	'#<'
								{
									push(">", Pre, -1, false);
									skip();
								}
								;
mode String
;
	String_PRE_START			:	'#<'
								{
									push(">", Pre, -1, false);
									skip();
								}
								;
	String_SEQUENCE				:	(~[\\"] | '\\#<' | '\\' .)
								{
									ncont(SCRIPT, "#<");
								}
								;
	String_END					:	'"'
								{
									npop(SCRIPT, "#<");
								}
								;
mode String2
;
	String2_PRE_START			:	'#<'
								{
									push(">", Pre, -1, false);
									skip();
								}
								;
	String2_SEQUENCE			:	(~[\\`] | '\\#<' | '\\' .)
								{
									ncont(SCRIPT, "#<");
								}
								;
	String2_END					:	'`'
								{
									npop(SCRIPT, "#<");
								}
								;
mode String3
;
	String3_PRE_START			:	'#<'
								{
									push(">", Pre, -1, false);
									skip();
								}
								;
	String3_SEQUENCE			:	(~[\\\'] | '\\#<' | '\\' .)
								{
									ncont(SCRIPT, "#<");
								}
								;
	String3_END					:	'\''
								{
									npop(SCRIPT, "#<");
								}
								;
mode Arguments //<arguments> <end>
;
	Arguments_WS				: 	(WS | COMMENTS)+
								{
									skip();
								}
								;
	Arguments_RBRACK			: 	'#<end>'
								{
									if (isEnabled())
									{
										environment.clearArgs();
									}
									
									pop(-1, false);
								}
								;
//the following will plug an argument into a symbol defined by the argument
//label
//[Symbol = InputArgument]
//Arguments are pushed by import and popped by this. If not all arguments are used, the arguments
//get cleared.
	Arguments_ARGUMENT			: 	[_a-zA-Z0-9]+
								{
									if (isEnabled())
									{
										environment.define(getCurrentText(0, -1), environment.popArg());
									}
									
									skip();
								}
								;
mode Param //[ ] from Antlr
;
	Param_ANY					: 	(	~[\][#<]
									| 	'\\' (~[\]] | EOF)
									|	'#' (~[<] | EOF)
									)+
								{
									ncont(SCRIPT, "]");
								}
								;
	Param_PARAM_START			:	'['
								{
									npush("]", Param, SCRIPT, "#<");
								}
								;
	Param_END					: 	']'
								{
									npop(SCRIPT, "#<");
								}
								;
	Param_PRE_START				:	'#<'
								{
									push(">", Pre, -1, false);
									skip();
								}
								;
//#<import(file, args...)>
mode ImportStart
;
	ImportStart_WS				: 	(WS | COMMENTS)+ 			{skip();};
	ImportStart_Parens			: 	'('							{_mode = Import; skip();};
mode Import
;
	Import_WS					: 	(WS | COMMENTS)+ 			{skip();};
	Import_FILE					: 	'"' (~[\\"] | '\\' .)* '"'
								{
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
								}
								;
	Imporg_ARG_READ				:	[_a-zA-Z0-9]+
								{
									if (isEnabled())
									{
										environment.pushArg(environment.get(getCurrentText(0, -1)));
									}
									
									skip();
									
									_mode = ImportArg;
								}
								;
	Import_END					: 	')'
								{
									pop(-1, false);
									skip();
									
									if (isEnabled())
									{
										environment.open(environment.popArg());
									}
								}
								;
mode ImportArg
;
	ImportArg_WS				: 	(WS | COMMENTS)+ 			{skip();};
	ImportArg_ARG				: 	('"' (~[\\"] | '\\' .)* '"'
								|	[1-9]?[0-9]+'.'[0-9]*
								)
								{
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
								}
								;
	ImportArg_ARG_READ			:	[_a-zA-Z][_a-zA-Z0-9]*
								{
									if (isEnabled())
									{
										environment.pushArg(environment.get(getCurrentText(0, -1)));
									}
									
									skip();
								}
								;
	ImportArg_END				: 	')'
								{
									pop(-1, false);
									skip();
									
									if (isEnabled())
									{
										environment.open(environment.popArg());
									}
								}
								;
mode Arg
;
	Arg_WS					: 	(WS | COMMENTS)+ {skip();};
	Arg_VAL					:
							(	~[">]+
							|	'"' (~[\\"] | '\\' .)* '"'
							)+
							{
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
							}
							;
mode EvalStart;
	EvalStart_WS			: 	(WS | COMMENTS)+ {skip();};
	EvalStart_Parens		: 	'('
							{
								_mode = Eval;
								skip();
								expression = "";
								expressionDepth = 0;
							};
mode Eval
;
	Eval_WS					: 	(WS | COMMENTS)+ {skip();};
	Eval_EXPR				:	(~["()]
							|	'"' (~[\\"] | '\\' .)* '"')
							{
								expression += getCurrentText(0, -1);
								skip();
							}
							;
	Eval_EXPR_PARENS		:	'('
							{
								++expressionDepth;
								push(")", Eval, -1, false);
								expression += "(";
							}
							;
	Eval_END				:	')'
							{
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
							}
							;
mode EvaluateStart;
	EvaluateStart_WS		: 	(WS | COMMENTS)+ {skip();};
	EvaluateStart_Parens		: 	'('
							{
								_mode = Evaluate;
								skip();
								expression = "";
								expressionDepth = 0;
							};
mode Evaluate
;
	Evaluate_WS				: 	(WS | COMMENTS)+ {skip();};
	Evaluate_EXPR			:	(~["()]
							|	'"' (~[\\"] | '\\' .)* '"')
							{
								expression += getCurrentText(0, -1);
								skip();
							}
							;
	Evaluate_EXPR_PARENS	:	'('
							{
								++expressionDepth;
								push(")", Eval, -1, false);
								expression += "(";
							}
							;
	Evaluate_END			:	')'
							{
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
							}
							;

mode Package
;
	Package_WS					: 	(WS | COMMENTS)+ 			{skip();};
	Package_FILE				: 	'"' (~[\\"] | '\\' .)* '"'
								{
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
								}
								;
	Package_FILE_READ			:	[_a-zA-Z0-9]+
								{
									if (isEnabled())
									{
										environment.pushArg(environment.get(getCurrentText()));
									}
									
									skip();
								}
								;
	Package_END					: 	'#`}'
								{
									pop(-1, false);
									
									if (isEnabled())
									{
										environment.openPackage(environment.popArg());
									}
								}
								;
mode PackageArg
;
	PackageArg_WS				: 	(WS | COMMENTS)+ 			{skip();};
	PackageArg_ARG				: 	'"' (~[\\"] | '\\' .)* '"'
								{
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
								}
								;
	PackageArg_ARG_READ			:	[_a-zA-Z0-9]+
								{
									if (isEnabled())
									{
										environment.pushArg(environment.get(getCurrentText()));
									}
									
									skip();
								}
								;
	PackageArg_END				: 	'#`}'
								{
									pop(-1, false);
									
									if (isEnabled())
									{
										environment.openPackage(environment.popArg());
									}
								}
								;
mode Pre
;
	Pre_WS							: 	(WS | COMMENTS)+ 			{skip();};
	Pre_IMPORT_START				:	'import'
									{
										_mode = PreEnd;
										push(")", ImportStart, -1, false);
									}
									;
	Pre_PACKAGE_START				:	{false}? 'package'
									{
										_mode = PreEnd;
										//TO DO
										//popMode();
										//push("#`}", Package, -1, false);
									}
									;
	Pre_ARG_START					:	'$'
									{
										_mode = PreEnd;
										pushMode(Arg);
										skip();
									}
									;
	Pre_EVAL_START					:	'if'
									{
										_mode = PreEnd;
										push(")", EvalStart, -1, false);
										skip();
									}
									;
	Pre_EVAL						:	'evaluate'
									{
										_mode = PreEnd;
										push(")", EvaluateStart, -1, false);
										skip();
									}
									;
	Pre_END							:	'end'
									{
										_mode = PreEnd;
										skip();
										popBlock();
									}
									;
mode PreEnd
;
	PreEnd_WS						: 	(WS | COMMENTS)+ 			{skip();};
	PreEnd_End						:	'>'
									{
										pop(-1, false);
										skip();
									}
									;