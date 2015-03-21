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
		return this.getSignature().toString();
	} // toString

	public int hashCode()
	{
		return this.getSignature().hashCode();
	} // hashCode
} // Symbol
