package compile.antlr;

import java.util.LinkedList;

/*
 * public SymbolPrivilegeSetBase(SymbolPrivilege localPrivilege, SymbolPrivilege regionalPrivilege)
 * public SymbolPrivilegeSetBase(LinkedList<SymbolPrivilege> symbolPrivileges)
 * 
 * public SymbolPrivilege getLocalPrivilege()
 * public SymbolPrivilege getRegionalPrivilege()
 */

public class SymbolPrivilegeSetBase extends SymbolPrivilegeSet
{
	private SymbolPrivilege	localPrivilege;
	private SymbolPrivilege	regionalPrivilege;

	private static LinkedList<SymbolPrivilege> createSkeleton(SymbolPrivilege localPrivilege, SymbolPrivilege regionalPrivilege)
	{
		LinkedList<SymbolPrivilege> symbolPrivileges = new LinkedList<SymbolPrivilege>();

		symbolPrivileges.add(localPrivilege);
		symbolPrivileges.add(regionalPrivilege);

		return symbolPrivileges;
	} // initialize

	public SymbolPrivilegeSetBase(SymbolPrivilege localPrivilege, SymbolPrivilege regionalPrivilege)
	{
		super(createSkeleton(localPrivilege, regionalPrivilege));

		this.localPrivilege = localPrivilege;
		this.regionalPrivilege = regionalPrivilege;
	} // SymbolPrivilegeSetBase

	public SymbolPrivilegeSetBase(LinkedList<SymbolPrivilege> symbolPrivileges)
	{
		super(symbolPrivileges);

		localPrivilege = symbolPrivileges.get(0);
		regionalPrivilege = symbolPrivileges.get(1);
	} // SymbolPrivilegeSetBase

	public SymbolPrivilege getLocalPrivilege()
	{
		return localPrivilege;
	} // getLocalPrivileges()

	public SymbolPrivilege getRegionalPrivilege()
	{
		return regionalPrivilege;
	} // getRegionalPrivileges
} // SymbolPrivilegeSetBase