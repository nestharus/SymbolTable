package compile.antlr;

public class SymbolPath extends SymbolGate
{
	private Symbol	destination;

	public SymbolPath(Symbol destination, SymbolPrivilegeSet requiredPrivilegeSet, SymbolPrivilegeSet grantedPrivilegeSet)
	{
		super(requiredPrivilegeSet, grantedPrivilegeSet);

		this.destination = destination;
	} // SymbolPath

	public Symbol getDestination(SymbolPrivilegeSet symbolPrivilegeSet)
	{
		if (this.isSuccess(symbolPrivilegeSet))
		{
			return destination;
		} // if

		return new Symbol();
	} // getDestination

	public Symbol getDestination()
	{
		return destination;
	} // getDestination
} // SymbolPath
