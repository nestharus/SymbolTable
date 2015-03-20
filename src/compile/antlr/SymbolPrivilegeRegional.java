package compile.antlr;

import java.util.HashSet;

public class SymbolPrivilegeRegional extends SymbolPrivilege
{
	public SymbolPrivilegeRegional()
	{
		super();
	} // SymbolPrivilegeRegional

	public SymbolPrivilegeRegional(HashSet<SymbolPrivilege> mask)
	{
		super(mask);
	} // SymbolPrivilegeRegional

	@Override
	public boolean isSuccess(SymbolPrivilege destination)
	{
		return destination.isEmpty() || !intersect(this, destination).isEmpty();
	} // isSuccess
} // SymbolPrivilegeRegional