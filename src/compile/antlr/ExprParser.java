// Generated from Expr.g4 by ANTLR 4.2
package compile.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__16=1, T__15=2, T__14=3, T__13=4, T__12=5, T__11=6, T__10=7, T__9=8, 
		T__8=9, T__7=10, T__6=11, T__5=12, T__4=13, T__3=14, T__2=15, T__1=16, 
		T__0=17, BOOLEAN=18, INTEGER=19, DOUBLE=20, STRING=21, VARIABLE=22, WS=23, 
		COMMENTS=24;
	public static final String[] tokenNames = {
		"<INVALID>", "'%'", "'||'", "'>'", "')'", "'+'", "'*'", "'-'", "'('", 
		"'/'", "'<'", "'=='", "'='", "'>='", "'!='", "'!'", "'<='", "'&&'", "BOOLEAN", 
		"INTEGER", "DOUBLE", "STRING", "VARIABLE", "WS", "COMMENTS"
	};
	public static final int
		RULE_start = 0, RULE_expr = 1;
	public static final String[] ruleNames = {
		"start", "expr"
	};

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		AntlrLexer.Environment environment = null;
		public TokenStreamRewriter rewriter = null;
		
		public static class Value
		{
			public final ValueType type;
		
			public final int integerValue;
			public final double doubleValue;
			public final String stringValue;
			public final boolean booleanValue;
			
			public Value()
			{
				type = ValueType.INVALID;
				
				integerValue = 0;
				doubleValue = 0;
				stringValue = null;
				booleanValue = false;
			}
			
			public Value(int value)
			{
				type = ValueType.INTEGER;
				
				integerValue = value;
				
				doubleValue = 0;
				stringValue = null;
				booleanValue = false;
			}
			
			public Value(double value)
			{
				type = ValueType.DOUBLE;
				
				doubleValue = value;
				
				integerValue = 0;
				stringValue = null;
				booleanValue = false;
			}
			
			public Value(String value)
			{
				type = ValueType.STRING;
				
				stringValue = value;
				
				integerValue = 0;
				doubleValue = 0;
				booleanValue = false;
			}
			
			public Value(boolean value)
			{
				type = ValueType.BOOLEAN;
				
				booleanValue = value;
				
				integerValue = 0;
				doubleValue = 0;
				stringValue = null;
			}
			
			public boolean getBoolean()
			{
				switch (type)
				{
					case BOOLEAN:
						return booleanValue;
					case INTEGER:
						return integerValue != 0;
					case DOUBLE:
						return doubleValue != 0;
					case STRING:
						return Boolean.parseBoolean(stringValue);
					default:
						return false;
				}
			}
			
			public int getInteger()
			{
				switch (type)
				{
					case BOOLEAN:
						return booleanValue? 1 : 0;
					case INTEGER:
						return integerValue;
					case DOUBLE:
						return (int)doubleValue;
					case STRING:
						try
						{
							return Integer.parseInt(stringValue);
						}
						catch (Exception e)
						{
							return 0;
						}
					default:
						return 0;
				}
			}
			
			public double getDouble()
			{
				switch (type)
				{
					case BOOLEAN:
						return booleanValue? 1 : 0;
					case INTEGER:
						return integerValue;
					case DOUBLE:
						return doubleValue;
					case STRING:
						try
						{
							return Double.parseDouble(stringValue);
						}
						catch (Exception e)
						{
							return 0;
						}
					default:
						return 0;
				}
			}
			
			public String getString()
			{
				switch (type)
				{
					case BOOLEAN:
						return Boolean.toString(booleanValue);
					case INTEGER:
						return Integer.toString(integerValue);
					case DOUBLE:
						return Double.toString(doubleValue);
					case STRING:
						return stringValue;
					default:
						return "";
				}
			}
			
			public Value and(Value other)
			{
				return new Value(getBoolean() && other.getBoolean());
			}
		
			public Value or(Value other)
			{
				return new Value(getBoolean() || other.getBoolean());
			}
		
			public Value eq(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						if (other.type == ValueType.BOOLEAN)
						{
							return new Value(booleanValue == other.booleanValue);
						} //if
						else
						{
							return new Value(booleanValue == other.getBoolean());
						} //else
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue == other.integerValue);
						} //if
						else
						{
							return new Value(integerValue == other.getInteger());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue == other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue == other.getDouble());
						} //else
					case STRING:
						if (other.type == ValueType.STRING)
						{
							return new Value(stringValue.equals(other.stringValue));
						} //if
						else
						{
							return new Value(stringValue.equals(other.getString()));
						} //else
					default:
						return new Value(false);
				} //switch
			}
		
			public Value neq(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						if (other.type == ValueType.BOOLEAN)
						{
							return new Value(booleanValue != other.booleanValue);
						} //if
						else
						{
							return new Value(booleanValue != other.getBoolean());
						} //else
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue != other.integerValue);
						} //if
						else
						{
							return new Value(integerValue != other.getInteger());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue != other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue != other.getDouble());
						} //else
					case STRING:
						if (other.type == ValueType.STRING)
						{
							return new Value(!stringValue.equals(other.stringValue));
						} //if
						else
						{
							return new Value(!stringValue.equals(other.getString()));
						} //else
					default:
						return new Value(false);
				} //switch
			}
		
			public Value lt(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						return new Value(getInteger() < other.getDouble());
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue < other.integerValue);
						} //if
						else
						{
							return new Value(integerValue < other.getDouble());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue < other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue < other.getDouble());
						} //else
					case STRING:
						return new Value(getDouble() < other.getDouble());
					default:
						return new Value(false);
				} //switch
			}
		
			public Value gt(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						return new Value(getInteger() > other.getDouble());
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue > other.integerValue);
						} //if
						else
						{
							return new Value(integerValue > other.getDouble());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue > other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue > other.getDouble());
						} //else
					case STRING:
						return new Value(getDouble() > other.getDouble());
					default:
						return new Value(false);
				} //switch
			}
		
			public Value lteq(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						return new Value(getInteger() <= other.getDouble());
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue <= other.integerValue);
						} //if
						else
						{
							return new Value(integerValue <= other.getDouble());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue <= other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue <= other.getDouble());
						} //else
					case STRING:
						return new Value(getDouble() <= other.getDouble());
					default:
						return new Value(false);
				} //switch
			}
		
			public Value gteq(Value other)
			{
				switch (type)
				{
					case BOOLEAN:
						return new Value(getInteger() >= other.getDouble());
					case INTEGER:
						if (other.type == ValueType.INTEGER)
						{
							return new Value(integerValue >= other.integerValue);
						} //if
						else
						{
							return new Value(integerValue >= other.getDouble());
						} //else
					case DOUBLE:
						if (other.type == ValueType.DOUBLE)
						{
							return new Value(doubleValue >= other.doubleValue);
						} //if
						else
						{
							return new Value(doubleValue >= other.getDouble());
						} //else
					case STRING:
						return new Value(getDouble() >= other.getDouble());
					default:
						return new Value(false);
				} //switch
			}
		
			public Value not()
			{
				if (type == ValueType.BOOLEAN)
				{
					return new Value(!booleanValue);
				} //if
				else
				{
					return new Value(!getBoolean());
				} //else
			}
			
			public Value add(Value other)
			{
				switch (type)
				{
					case DOUBLE:
						return new Value(doubleValue + other.getDouble());
					case STRING:
						return new Value(stringValue + other.getString());
					default:
						switch (other.type)
						{
							case DOUBLE:
								return new Value(getInteger() + other.doubleValue);
							case STRING:
								if (other.stringValue.contains("."))
								{
									try
									{
										return new Value(getInteger() + Double.parseDouble(other.stringValue));
									} //try
									catch (Exception e)
									{
										new Value(getString() + other.stringValue);
									} //catch
								} //if
								else
								{
									try
									{
										return new Value(getInteger() + Integer.parseInt(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(getString() + other.stringValue);
									} //catch
								} //else
							default:
								return new Value(getInteger() + other.getInteger());
						}
				} //switch
			}
			
			public Value sub(Value other)
			{
				switch (type)
				{
					case DOUBLE:
						return new Value(doubleValue - other.getDouble());
					case STRING:
						return new Value(stringValue.replace(other.getString(), ""));
					default:
						switch (other.type)
						{
							case DOUBLE:
								return new Value(getInteger() - other.doubleValue);
							case STRING:
								if (other.stringValue.contains("."))
								{
									try
									{
										return new Value(getInteger() - Double.parseDouble(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(getString().replace(other.stringValue, ""));
									} //catch
								} //if
								else
								{
									try
									{
										return new Value(getInteger() - Integer.parseInt(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(getString().replace(other.stringValue, ""));
									} //catch
								} //else
							default:
								return new Value(getInteger() - other.getInteger());
						}
				} //switch
			}
			
			public String cross(String set)
			{
				String newString = "";
								
				for (byte b : stringValue.getBytes())
				{
					newString = newString + b + set;
				} //for
				
				return newString;
			}
			
			public String multiplyString(int multiple)
			{
				String newString = "";
								
				for (int i = 0; i < multiple; ++i)
				{
					newString = newString + stringValue;
				} //for
				
				return newString;
			} //multiplyString
			
			public Value mul(Value other)
			{
				switch (type)
				{
					case DOUBLE:
						return new Value(doubleValue*other.getDouble());
					case STRING:
						switch (other.type)
						{
							case STRING:
								return new Value(cross(other.getString()));
							default:
								return new Value(multiplyString(other.getInteger()));
						}
					default:
						switch (other.type)
						{
							case DOUBLE:
								return new Value(getInteger()*other.doubleValue);
							case STRING:
								if (other.stringValue.contains("."))
								{
									try
									{
										return new Value(getInteger()*Double.parseDouble(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(cross(other.getString()));
									} //catch
								} //if
								else
								{
									try
									{
										return new Value(getInteger()*Integer.parseInt(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(cross(other.getString()));
									} //catch
								} //else
							default:
								return new Value(getInteger()*other.getInteger());
						}
				} //switch
			}
			
			public String intersect(String set)
			{
				byte[] bytes = set.getBytes();
				int len = bytes.length;
				String newString = "";
				
				for (byte b : stringValue.getBytes())
				{
					for (int i = 0; i < len; ++i)
					{
						if (b == bytes[i])
						{
							newString += b;
							bytes[i] = bytes[--len];
						} //if
					} //for
				}
				
				return newString;
			}
			
			public Value div(Value other)
			{
				switch (type)
				{
					case DOUBLE:
						return new Value(doubleValue/other.getDouble());
					case STRING:
						return new Value(intersect(other.getString()));
					default:
						switch (other.type)
						{
							case DOUBLE:
								return new Value(getInteger()/other.doubleValue);
							case STRING:
								if (other.stringValue.contains("."))
								{
									try
									{
										return new Value(getInteger()/Double.parseDouble(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(intersect(other.getString()));
									} //catch
								} //if
								else
								{
									try
									{
										return new Value(getInteger()/Integer.parseInt(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(intersect(other.getString()));
									} //catch
								} //else
							default:
								return new Value(getInteger()/other.getInteger());
						}
				} //switch
			}
			
			public String disjoint(String set)
			{
				String oldString = stringValue;
				int index;
				
				for (byte b : stringValue.getBytes())
				{
					index = set.indexOf(b);
					
					if (index != -1)
					{
						set = set.substring(0, index) + set.substring(index + 1);
					} //if
					
					index = oldString.indexOf(b);
					oldString = oldString.substring(0, index) + oldString.substring(index + 1);
				} //for
				
				return oldString + set;
			} //disjoint
			
			public Value mod(Value other)
			{
				switch (type)
				{
					case DOUBLE:
						return new Value(doubleValue%other.getDouble());
					case STRING:
						return new Value(disjoint(other.getString()));
					default:
						switch (other.type)
						{
							case DOUBLE:
								return new Value(getInteger()%other.doubleValue);
							case STRING:
								if (other.stringValue.contains("."))
								{
									try
									{
										return new Value(getInteger()%Double.parseDouble(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(disjoint(other.getString()));
									} //catch
								} //if
								else
								{
									try
									{
										return new Value(getInteger()%Integer.parseInt(other.stringValue));
									} //try
									catch (Exception e)
									{
										return new Value(disjoint(other.getString()));
									} //catch
								} //else
							default:
								return new Value(getInteger()%other.getInteger());
						}
				} //switch
			}
		}
		
		public Value interpretVariable(String text)
		{
			if (text.charAt(0) == '"')
			{
				return new Value(text.substring(1, text.length() - 1));
			} //if
			else if (text == "true" || text == "false")
			{
				return new Value(text == "true");
			} //else if
			else if (text.contains("."))
			{
				return new Value(Double.parseDouble(text));
			} //else if
			else
			{
				return new Value(Integer.parseInt(text));
			} //else
		}
		
		public ExprParser(TokenStreamRewriter rewriter, AntlrLexer.Environment environment)
		{
			super(rewriter.getTokenStream());
			this.rewriter = rewriter;
			this.environment = environment;
			
			_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
		}

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Value v;
		public ExprContext o;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4); ((StartContext)_localctx).o = expr(0);
			((StartContext)_localctx).v =  ((StartContext)_localctx).o.v;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Value v;
		public ExprContext left;
		public ExprContext o;
		public Token VARIABLE;
		public ExprContext right;
		public Token STRING;
		public Token INTEGER;
		public Token DOUBLE;
		public Token BOOLEAN;
		public TerminalNode BOOLEAN() { return getToken(ExprParser.BOOLEAN, 0); }
		public TerminalNode VARIABLE() { return getToken(ExprParser.VARIABLE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DOUBLE() { return getToken(ExprParser.DOUBLE, 0); }
		public TerminalNode INTEGER() { return getToken(ExprParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(ExprParser.STRING, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(8); match(15);
				setState(9); ((ExprContext)_localctx).o = expr(21);
				((ExprContext)_localctx).v =  ((ExprContext)_localctx).o.v.not();
				}
				break;

			case 2:
				{
				setState(12); ((ExprContext)_localctx).VARIABLE = match(VARIABLE);
				setState(13); match(12);
				setState(14); ((ExprContext)_localctx).right = expr(7);
				((ExprContext)_localctx).v =  ((ExprContext)_localctx).right.v; environment.define((((ExprContext)_localctx).VARIABLE!=null?((ExprContext)_localctx).VARIABLE.getText():null), ((ExprContext)_localctx).right.v.getString());
				}
				break;

			case 3:
				{
				setState(17); match(8);
				setState(18); ((ExprContext)_localctx).o = expr(0);
				setState(19); match(4);
				((ExprContext)_localctx).v =  ((ExprContext)_localctx).o.v;
				}
				break;

			case 4:
				{
				setState(22); ((ExprContext)_localctx).STRING = match(STRING);
				((ExprContext)_localctx).v =  new Value((((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null).substring(1, (((ExprContext)_localctx).STRING!=null?((ExprContext)_localctx).STRING.getText():null).length() - 1));
				}
				break;

			case 5:
				{
				setState(24); ((ExprContext)_localctx).INTEGER = match(INTEGER);
				((ExprContext)_localctx).v =  new Value(Integer.parseInt((((ExprContext)_localctx).INTEGER!=null?((ExprContext)_localctx).INTEGER.getText():null)));
				}
				break;

			case 6:
				{
				setState(26); ((ExprContext)_localctx).DOUBLE = match(DOUBLE);
				((ExprContext)_localctx).v =  new Value(Double.parseDouble((((ExprContext)_localctx).DOUBLE!=null?((ExprContext)_localctx).DOUBLE.getText():null)));
				}
				break;

			case 7:
				{
				setState(28); ((ExprContext)_localctx).BOOLEAN = match(BOOLEAN);
				((ExprContext)_localctx).v =  new Value(Boolean.parseBoolean((((ExprContext)_localctx).BOOLEAN!=null?((ExprContext)_localctx).BOOLEAN.getText():null)));
				}
				break;

			case 8:
				{
				setState(30); ((ExprContext)_localctx).VARIABLE = match(VARIABLE);
				((ExprContext)_localctx).v =  interpretVariable(environment.get((((ExprContext)_localctx).VARIABLE!=null?((ExprContext)_localctx).VARIABLE.getText():null)));
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(99);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(34);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(35); match(1);
						setState(36); ((ExprContext)_localctx).right = expr(21);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.mod(((ExprContext)_localctx).right.v);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(39);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(40); match(9);
						setState(41); ((ExprContext)_localctx).right = expr(20);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.div(((ExprContext)_localctx).right.v);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(44);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(45); match(6);
						setState(46); ((ExprContext)_localctx).right = expr(19);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.mul(((ExprContext)_localctx).right.v);
						}
						break;

					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(49);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(50); match(5);
						setState(51); ((ExprContext)_localctx).right = expr(18);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.add(((ExprContext)_localctx).right.v);
						}
						break;

					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(54);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(55); match(7);
						setState(56); ((ExprContext)_localctx).right = expr(17);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.sub(((ExprContext)_localctx).right.v);
						}
						break;

					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(60); match(10);
						setState(61); ((ExprContext)_localctx).right = expr(16);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.lt(((ExprContext)_localctx).right.v);
						}
						break;

					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(65); match(16);
						setState(66); ((ExprContext)_localctx).right = expr(15);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.lteq(((ExprContext)_localctx).right.v);
						}
						break;

					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(69);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(70); match(3);
						setState(71); ((ExprContext)_localctx).right = expr(14);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.gt(((ExprContext)_localctx).right.v);
						}
						break;

					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(75); match(13);
						setState(76); ((ExprContext)_localctx).right = expr(13);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.gteq(((ExprContext)_localctx).right.v);
						}
						break;

					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(79);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(80); match(11);
						setState(81); ((ExprContext)_localctx).right = expr(12);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.eq(((ExprContext)_localctx).right.v);
						}
						break;

					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(85); match(14);
						setState(86); ((ExprContext)_localctx).right = expr(11);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.neq(((ExprContext)_localctx).right.v);
						}
						break;

					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(89);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(90); match(17);
						setState(91); ((ExprContext)_localctx).right = expr(10);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.and(((ExprContext)_localctx).right.v);
						}
						break;

					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(95); match(2);
						setState(96); ((ExprContext)_localctx).right = expr(9);
						((ExprContext)_localctx).v =  ((ExprContext)_localctx).left.v.or(((ExprContext)_localctx).right.v);
						}
						break;
					}
					} 
				}
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 20);

		case 1: return precpred(_ctx, 19);

		case 2: return precpred(_ctx, 18);

		case 3: return precpred(_ctx, 17);

		case 4: return precpred(_ctx, 16);

		case 5: return precpred(_ctx, 15);

		case 6: return precpred(_ctx, 14);

		case 7: return precpred(_ctx, 13);

		case 8: return precpred(_ctx, 12);

		case 9: return precpred(_ctx, 11);

		case 10: return precpred(_ctx, 10);

		case 11: return precpred(_ctx, 9);

		case 12: return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\32k\4\2\t\2\4\3\t"+
		"\3\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3#\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3f\n\3\f\3\16\3i\13\3\3\3\2\3\4\4"+
		"\2\4\2\2|\2\6\3\2\2\2\4\"\3\2\2\2\6\7\5\4\3\2\7\b\b\2\1\2\b\3\3\2\2\2"+
		"\t\n\b\3\1\2\n\13\7\21\2\2\13\f\5\4\3\27\f\r\b\3\1\2\r#\3\2\2\2\16\17"+
		"\7\30\2\2\17\20\7\16\2\2\20\21\5\4\3\t\21\22\b\3\1\2\22#\3\2\2\2\23\24"+
		"\7\n\2\2\24\25\5\4\3\2\25\26\7\6\2\2\26\27\b\3\1\2\27#\3\2\2\2\30\31\7"+
		"\27\2\2\31#\b\3\1\2\32\33\7\25\2\2\33#\b\3\1\2\34\35\7\26\2\2\35#\b\3"+
		"\1\2\36\37\7\24\2\2\37#\b\3\1\2 !\7\30\2\2!#\b\3\1\2\"\t\3\2\2\2\"\16"+
		"\3\2\2\2\"\23\3\2\2\2\"\30\3\2\2\2\"\32\3\2\2\2\"\34\3\2\2\2\"\36\3\2"+
		"\2\2\" \3\2\2\2#g\3\2\2\2$%\f\26\2\2%&\7\3\2\2&\'\5\4\3\27\'(\b\3\1\2"+
		"(f\3\2\2\2)*\f\25\2\2*+\7\13\2\2+,\5\4\3\26,-\b\3\1\2-f\3\2\2\2./\f\24"+
		"\2\2/\60\7\b\2\2\60\61\5\4\3\25\61\62\b\3\1\2\62f\3\2\2\2\63\64\f\23\2"+
		"\2\64\65\7\7\2\2\65\66\5\4\3\24\66\67\b\3\1\2\67f\3\2\2\289\f\22\2\29"+
		":\7\t\2\2:;\5\4\3\23;<\b\3\1\2<f\3\2\2\2=>\f\21\2\2>?\7\f\2\2?@\5\4\3"+
		"\22@A\b\3\1\2Af\3\2\2\2BC\f\20\2\2CD\7\22\2\2DE\5\4\3\21EF\b\3\1\2Ff\3"+
		"\2\2\2GH\f\17\2\2HI\7\5\2\2IJ\5\4\3\20JK\b\3\1\2Kf\3\2\2\2LM\f\16\2\2"+
		"MN\7\17\2\2NO\5\4\3\17OP\b\3\1\2Pf\3\2\2\2QR\f\r\2\2RS\7\r\2\2ST\5\4\3"+
		"\16TU\b\3\1\2Uf\3\2\2\2VW\f\f\2\2WX\7\20\2\2XY\5\4\3\rYZ\b\3\1\2Zf\3\2"+
		"\2\2[\\\f\13\2\2\\]\7\23\2\2]^\5\4\3\f^_\b\3\1\2_f\3\2\2\2`a\f\n\2\2a"+
		"b\7\4\2\2bc\5\4\3\13cd\b\3\1\2df\3\2\2\2e$\3\2\2\2e)\3\2\2\2e.\3\2\2\2"+
		"e\63\3\2\2\2e8\3\2\2\2e=\3\2\2\2eB\3\2\2\2eG\3\2\2\2eL\3\2\2\2eQ\3\2\2"+
		"\2eV\3\2\2\2e[\3\2\2\2e`\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\5\3\2"+
		"\2\2ig\3\2\2\2\5\"eg";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}