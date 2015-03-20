package compile.antlr;

import java.util.HashSet;
import java.util.LinkedList;

public class SymbolPrivilegeSetRegional extends SymbolPrivilegeSetBase
{
	public SymbolPrivilegeSetRegional()
	{
		super(new SymbolPrivilegeLocal(new HashSet<SymbolPrivilege>()), new SymbolPrivilegeRegional());
	} // SymbolPrivilegeSetRegional

	public SymbolPrivilegeSetRegional(LinkedList<SymbolPrivilege> symbolPrivileges)
	{
		super(symbolPrivileges);
	} // SymbolPrivilegeSetRegional
} // SymbolPrivilegeSetRegional