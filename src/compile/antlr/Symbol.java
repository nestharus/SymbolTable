package compile.antlr;

public class Symbol
{
	private ISignature	name;

	public Symbol()
	{
		name = null;
	} // Symbol

	public Symbol(ISignature name)
	{
		this.name = name;
	} // Symbol

	public ISignature getSignature()
	{
		return this.name;
	} // getSignature

	public String toString()
	{
		if (this.name == null)
		{
			return "";
		} // if

		return this.getSignature().toString();
	} // toString

	public int hashCode()
	{
		if (name == null)
		{
			return 0;
		} // if

		return this.getSignature().hashCode();
	} // hashCode
} // Symbol

/*
 * Symbol
 *  public Symbol(String name)
 *  public Symbol(AccessModifier accessModifier, String name)
 *  public Symbol()
 *  public Symbol(AccessModifier accessModifier)
 *  
 *  public AccessModifier getAccessModifier()
 *  public String getName()
 *  public String toString()


public class Symbol
{
	private AccessModifier	accessModifier;

	// this needs to be a Signature
	private String			name;

	private void initialize(AccessModifier accessModifier, String name)
	{
		this.accessModifier = accessModifier;
		this.name = name == null? "" : name;
	} // initialize

	public Symbol(AccessModifier accessModifier, String name)
	{
		initialize(accessModifier, name);
	} // Symbol

	public Symbol(String name)
	{
		initialize(null, name);
	} // Symbol

	public Symbol(AccessModifier accessModifier)
	{
		initialize(accessModifier, null);
	} // Symbol

	public Symbol()
	{
		initialize(null, null);
	} // Symbol

	public AccessModifier getAccessModifier()
	{
		return accessModifier;
	} // getAccessModifier

	public String getName()
	{
		return name;
	} // getName

	public String toString()
	{
		return name;
	} // toString
} // Symbol
*/
