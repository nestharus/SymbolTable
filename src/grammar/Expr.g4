grammar Expr;

@parser::members
{
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
}

start returns [Value v]
		:	o=expr	{$v = $o.v;}
		;

expr returns [Value v]
		:	'!' o=expr						{$v = $o.v.not();}
		|	left=expr '%' right=expr		{$v = $left.v.mod($right.v);}
		|	left=expr '/' right=expr		{$v = $left.v.div($right.v);}
		|	left=expr '*' right=expr		{$v = $left.v.mul($right.v);}
		|	left=expr '+' right=expr		{$v = $left.v.add($right.v);}
		|	left=expr '-' right=expr		{$v = $left.v.sub($right.v);}
		|	left=expr '<' right=expr		{$v = $left.v.lt($right.v);}
		|	left=expr '<=' right=expr		{$v = $left.v.lteq($right.v);}
		|	left=expr '>' right=expr		{$v = $left.v.gt($right.v);}
		|	left=expr '>=' right=expr		{$v = $left.v.gteq($right.v);}
		|	left=expr '==' right=expr		{$v = $left.v.eq($right.v);}
		|	left=expr '!=' right=expr		{$v = $left.v.neq($right.v);}
		|	left=expr '&&' right=expr		{$v = $left.v.and($right.v);}
		|	left=expr '||' right=expr		{$v = $left.v.or($right.v);}
		| 	VARIABLE '=' right=expr			{$v = $right.v; environment.define($VARIABLE.text, $right.v.getString());}
		|	'(' o=expr ')'					{$v = $o.v;}
		|	STRING							{$v = new Value($STRING.text.substring(1, $STRING.text.length() - 1));}
		|	INTEGER							{$v = new Value(Integer.parseInt($INTEGER.text));}
		|	DOUBLE							{$v = new Value(Double.parseDouble($DOUBLE.text));}
		|	BOOLEAN							{$v = new Value(Boolean.parseBoolean($BOOLEAN.text));}
		|	VARIABLE						{$v = interpretVariable(environment.get($VARIABLE.text));}
		;

BOOLEAN	:	'true'|'false';
INTEGER	:	[1-9]?[0-9]+;
DOUBLE	:	[1-9]?[0-9]+'.'[0-9]*;

STRING	: 	'"' (~[\\"] | '\\' .)* '"'
		{
			_text = _input.getText(Interval.of(_tokenStartCharIndex, _input.index() - 1));
			
			_text = _text.replace("\\n", "\n");
			_text = _text.replace("\\r", "\r");
			_text = _text.replace("\\t", "\t");
			_text = _text.replace("\\b", "\b");
			_text = _text.replace("\\f", "\f");
			_text = _text.replaceAll("\\\\(.)", "$1");
		}
		;
		
VARIABLE:	[a-zA-Z_][a-zA-Z_0-9]+;

WS		: [ \r\n\t] -> skip;
COMMENTS	:
			(	'/*' .*? '*/'
			| 	'//' ~[\r\n]*
			)+
			-> skip
			;