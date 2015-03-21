package compile.antlr;

import java.util.HashSet;

/*
 * public SymbolPrivilege()
 * public SymbolPrivilege(HashSet<SymbolPrivilege> mask)
 * 
 * public SymbolPrivilege createSet()
 * 
 * public static SymbolPrivilege intersect(SymbolPrivilege... symbolPrivileges)
 * public static SymbolPrivilege union(SymbolPrivilege... symbolPrivileges)
 * 
 * public boolean isSuccess(SymbolPrivilege destination)
 * 
 * public boolean isEmpty()
 * public boolean equals(SymbolPrivilege symbolPrivilege)
 * public boolean containsAll(SymbolPrivilege symbolPrivilege)
 */
public class SymbolPrivilege
{
	private HashSet<SymbolPrivilege>	mask;

	public SymbolPrivilege()
	{
		mask = new HashSet<SymbolPrivilege>();
		mask.add(this);
	} // SymbolPrivilege

	public SymbolPrivilege(HashSet<SymbolPrivilege> mask)
	{
		this.mask = mask;
	} // SymbolPrivilege

	// this will never throw an Exception because the constructor exists above
	public SymbolPrivilege createSet()
	{
		SymbolPrivilege privilege = null;

		try
		{
			privilege =
						this.getClass().getConstructor(new Class[] { HashSet.class })
							.newInstance(new Object[] { new HashSet<SymbolPrivilege>() });
		} // try
		catch (Exception e)
		{
		} // catch

		return privilege;
	} // createSet

	private static SymbolPrivilege getPrototype(SymbolPrivilege... symbolPrivileges)
	{
		SymbolPrivilege privilege = null;

		for (SymbolPrivilege symbolPrivilege : symbolPrivileges)
		{
			if (symbolPrivilege != null)
			{
				privilege = symbolPrivilege;
			} // if
		} // for

		if (privilege == null)
		{
			privilege = new SymbolPrivilege();
		} // if

		return privilege;
	} // getPrototype

	private static SymbolPrivilege createSet(SymbolPrivilege... symbolPrivileges)
	{
		return getPrototype(symbolPrivileges).createSet();
	} // createSet

	public static SymbolPrivilege intersect(SymbolPrivilege... symbolPrivileges)
	{
		SymbolPrivilege privilege = union(symbolPrivileges);

		for (SymbolPrivilege symbolPrivilege : symbolPrivileges)
		{
			if (privilege.isEmpty())
			{
				break;
			} // if

			if (symbolPrivileges == null)
			{
				privilege.mask.clear();
			} // if
			else
			{
				privilege.mask.retainAll(symbolPrivilege.mask);
			} // else
		} // for

		return privilege;
	} // intersect

	public static SymbolPrivilege union(SymbolPrivilege... symbolPrivileges)
	{
		SymbolPrivilege privilege = createSet(symbolPrivileges);

		for (SymbolPrivilege symbolPrivilege : symbolPrivileges)
		{
			if (symbolPrivileges != null)
			{
				privilege.mask.addAll(symbolPrivilege.mask);
			} // if
		} // for

		return privilege;
	} // union

	public boolean isEmpty()
	{
		return this.mask.isEmpty();
	} // isEmpty

	public boolean equals(SymbolPrivilege symbolPrivilege)
	{
		return this.containsAll(symbolPrivilege) && symbolPrivilege.containsAll(this);
	} // equals

	public boolean containsAll(SymbolPrivilege symbolPrivilege)
	{
		return this.mask.containsAll(symbolPrivilege.mask);
	} // containsAll

	public boolean isSuccess(SymbolPrivilege destination)
	{
		return false;
	} // isSuccess
} // SymbolPrivilege