package compile.antlr;

import java.util.HashSet;

public class SymbolPrivilegeLocal extends SymbolPrivilege
{
	public SymbolPrivilegeLocal()
	{
		super();
	} // SymbolPrivilegeLocal

	public SymbolPrivilegeLocal(HashSet<SymbolPrivilege> mask)
	{
		super(mask);
	} // SymbolPrivilegeLocal

	@Override
	public boolean isSuccess(SymbolPrivilege destination)
	{
		return this.containsAll(destination);
	} // isSuccess
} // SymbolPrivilegeLocal