package compile.antlr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * public SymbolPrivilegeSet()
 * public SymbolPrivilegeSet(LinkedList<SymbolPrivilege> symbolPrivileges)
 * 
 * public SymbolPrivilegeSet createSet()
 * 
 * public static SymbolPrivilegeSet union(SymbolPrivilegeSet... symbolPrivilegeSets)
 * public static SymbolPrivilegeSet intersect(SymbolPrivilegeSet... symbolPrivilegeSets)
 * 
 * public boolean isSuccess(SymbolPrivilegeSet setDestination)
 */

public class SymbolPrivilegeSet
{
	private LinkedList<SymbolPrivilege>	symbolPrivileges;

	public SymbolPrivilegeSet()
	{
		symbolPrivileges = new LinkedList<SymbolPrivilege>();
		symbolPrivileges.add(new SymbolPrivilege(new HashSet<SymbolPrivilege>()));
	} // SymbolPrivilegeSet

	public SymbolPrivilegeSet(LinkedList<SymbolPrivilege> symbolPrivileges)
	{
		this.symbolPrivileges = symbolPrivileges;
	} // SymbolPrivilegeSet

	public SymbolPrivilegeSet createSet()
	{
		LinkedList<SymbolPrivilege> symbolPrivileges = new LinkedList<SymbolPrivilege>();

		for (SymbolPrivilege privilege : this.symbolPrivileges)
		{
			symbolPrivileges.add(privilege.createSet());
		} // for

		SymbolPrivilegeSet symbolPrivilegeSet = null;

		try
		{
			symbolPrivilegeSet =
									this.getClass().getConstructor(new Class[] { LinkedList.class })
										.newInstance(new Object[] { symbolPrivileges });
		} // try
		catch (Exception e)
		{
		} // catch

		return symbolPrivilegeSet;
	} // createSet

	private static SymbolPrivilegeSet getPrototype(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		SymbolPrivilegeSet symbolPrivilegeSetPrototype = null;

		for (SymbolPrivilegeSet symbolPrivilege : symbolPrivilegeSets)
		{
			if (symbolPrivilege != null)
			{
				symbolPrivilegeSetPrototype = symbolPrivilege;

				break;
			} // if
		} // for

		if (symbolPrivilegeSetPrototype == null)
		{
			symbolPrivilegeSetPrototype = new SymbolPrivilegeSet();
		} // if

		return symbolPrivilegeSetPrototype;
	} // getPrototype

	private static SymbolPrivilege[] getPrivilegeArray(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		SymbolPrivilegeSet prototype = getPrototype(symbolPrivilegeSets);
		SymbolPrivilege[] privileges = new SymbolPrivilege[prototype.symbolPrivileges.size()];
		int count = 0;

		for (SymbolPrivilege symbolPrivilege : prototype.symbolPrivileges)
		{
			privileges[count++] = symbolPrivilege.createSet();
		} // for

		return privileges;
	} // createArray

	private static SymbolPrivilege[] unionArray(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		SymbolPrivilege[] privileges = getPrivilegeArray(symbolPrivilegeSets);

		int count = 0;
		for (SymbolPrivilegeSet symbolPrivilegeSet : symbolPrivilegeSets)
		{
			for (SymbolPrivilege symbolPrivilege : symbolPrivilegeSet.symbolPrivileges)
			{
				privileges[count] = SymbolPrivilege.union(privileges[count], symbolPrivilege);

				count = (count + 1) % privileges.length;
			} // for
		} // for

		return privileges;
	} // unionArray

	private static SymbolPrivilege[] intersectArray(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		SymbolPrivilege[] privileges = unionArray(symbolPrivilegeSets);

		int count = 0;
		for (SymbolPrivilegeSet symbolPrivilegeSet : symbolPrivilegeSets)
		{
			for (SymbolPrivilege symbolPrivilege : symbolPrivilegeSet.symbolPrivileges)
			{
				privileges[count] = SymbolPrivilege.intersect(privileges[count], symbolPrivilege);

				count = (count + 1) % privileges.length;
			} // for
		} // for

		return privileges;
	} // intersectArray

	private static LinkedList<SymbolPrivilege> arrayToList(SymbolPrivilege[] privileges)
	{
		LinkedList<SymbolPrivilege> privilegeList = new LinkedList<SymbolPrivilege>();

		for (int i = 0; i < privileges.length; ++i)
		{
			privilegeList.add(privileges[i]);
		} // for

		return privilegeList;
	} // arrayToList

	public static SymbolPrivilegeSet union(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		return new SymbolPrivilegeSet(arrayToList(unionArray(symbolPrivilegeSets)));
	} // union

	public static SymbolPrivilegeSet intersect(SymbolPrivilegeSet... symbolPrivilegeSets)
	{
		return new SymbolPrivilegeSet(arrayToList(intersectArray(symbolPrivilegeSets)));
	} // intersect

	public boolean isSuccess(SymbolPrivilegeSet setDestination)
	{
		Iterator<SymbolPrivilege> itOrigin = symbolPrivileges.iterator();
		Iterator<SymbolPrivilege> itDestination = setDestination.symbolPrivileges.iterator();

		while (itOrigin.hasNext())
		{
			if (!itOrigin.next().isSuccess(itDestination.next()))
			{
				return false;
			} // if
		} // while

		return true;
	} // isSuccess
} // SymbolPrivilegeSet