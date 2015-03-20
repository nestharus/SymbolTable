package compile.antlr;

import java.util.HashSet;
import java.util.LinkedList;

public class SymbolPrivilegeSetLocal extends SymbolPrivilegeSetBase
{
	public SymbolPrivilegeSetLocal()
	{
		super(new SymbolPrivilegeLocal(), new SymbolPrivilegeRegional(new HashSet<SymbolPrivilege>()));
	} // SymbolPrivilegeSetLocal

	public SymbolPrivilegeSetLocal(LinkedList<SymbolPrivilege> symbolPrivileges)
	{
		super(symbolPrivileges);
	} // SymbolPrivilegeSetLocal
} // SymbolPrivilegeSetLocal