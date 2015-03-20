package compile.antlr;

public class SymbolGate
{
	private SymbolPrivilegeSet	requiredPrivilegeSet;
	private SymbolPrivilegeSet	grantedPrivilegeSet;

	public SymbolGate(SymbolPrivilegeSet requiredPrivilegeSet, SymbolPrivilegeSet grantedPrivilegeSet)
	{
		this.requiredPrivilegeSet = requiredPrivilegeSet;
		this.grantedPrivilegeSet = grantedPrivilegeSet;
	} // SymbolGate

	protected boolean isSuccess(SymbolPrivilegeSet symbolPrivilegeSet)
	{
		return symbolPrivilegeSet.isSuccess(this.requiredPrivilegeSet);
	} // isSuccess

	public SymbolPrivilegeSet getPrivileges(SymbolPrivilegeSet symbolPrivilegeSet)
	{
		return SymbolPrivilegeSet.intersect(symbolPrivilegeSet, this.grantedPrivilegeSet);
	} // getPrivileges
} // SymbolGate