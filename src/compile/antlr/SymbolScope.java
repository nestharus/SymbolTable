package compile.antlr;

import java.util.LinkedList;

/*
 * public SymbolScope(ISignature name, SymbolPrivilegeSet region)
 * 
 * public void addSymbol(Symbol symbol) throws Exception
 * -	regular symbol adding (hashmap)
 * -	the added symbol gets an external path to this symbol
 * public void includeSymbol(Symbol symbol) throws Exception
 * -	add symbol as though it's scope is part of this symbol's scope (up to protected)
 * -	the added symbol gets an external path to this symbol
 * public void importSymbol(Symbol symbol, SymbolPrivilegeSet requiredPrivileges) throws Exception
 * -	import the scope of one symbol to the scope of this symbol
 * 
 * public static boolean isScope(Symbol symbol)
 * 
 * public SymbolPrivilegeSet getRegion()
 * 
 * public static class Privilege
 * 
 *  public static final SymbolPrivilegeSet	Public
 *  public static final SymbolPrivilegeSet	Protected
 *  public static final SymbolPrivilegeSet	Private
 *  public static final SymbolPrivilegeSet	All
 */

public class SymbolScope extends SymbolResolve
{
	public final SymbolPathSet		symbolTable;	// the contents of this
													// symbol
	public final SymbolPathSet		shadowTable;	// scope inclusion
	public final SymbolPathSet		importTable;	// scope usage w/o
													// resolution
	public final SymbolPathSet		externalTable;	// parent scope
	public final SymbolPrivilegeSet	region;		// file etc

	public SymbolScope(ISignature name, SymbolPrivilegeSet region)
	{
		super(name);

		this.region = region;

		// everything heading out of this symbol is granted this symbol's region
		symbolTable = new SymbolPathSetHashMap(Privilege.Public, region);
		shadowTable = new SymbolPathSetLinkedList(Privilege.Public, SymbolPrivilegeSet.union(Privilege.Protected, region));
		importTable = new SymbolPathSetLinkedList(Privilege.Public, region);
		externalTable =
						new SymbolPathSetLinkedList(SymbolPrivilegeSet.union(Privilege.Private, region),
													SymbolPrivilegeSet.union(Privilege.All, region));

		// populate
		LinkedList<SymbolPathSet> paths = this.getSymbolPathSets();

		paths.add(symbolTable);
		paths.add(shadowTable);
		paths.add(importTable);
		paths.add(externalTable);
	} // SymbolScope

	public static boolean isScope(Symbol symbol)
	{
		return SymbolScope.class.isAssignableFrom(symbol.getClass());
	} // isScope

	public SymbolPrivilegeSet getRegion()
	{
		return region;
	} // getRegion

	private static SymbolPrivilegeSet getRegion(Symbol symbol)
	{
		if (isScope(symbol))
		{
			return ((SymbolScope) symbol).region;
		} // if

		return Privilege.Public;
	} // getRegion

	public void addSymbol(Symbol symbol) throws Exception
	{
		// this -> symbol
		symbolTable.addPath(new SymbolPath(symbol, Privilege.Public, getRegion(symbol)));

		// symbol -> this
		if (isScope(symbol))
		{
			// the path set already requires Private, region
			SymbolPrivilegeSet requiredPrivileges = Privilege.Public;
			SymbolPrivilegeSet grantedPrivileges = SymbolPrivilegeSet.union(Privilege.All, region);

			SymbolPath path = new SymbolPath(this, requiredPrivileges, grantedPrivileges);

			((SymbolScope) symbol).externalTable.addPath(path);
		} // if
	} // addSymbol

	public void includeSymbol(Symbol symbol) throws Exception
	{
		// this -> symbol
		shadowTable.addPath(new SymbolPath(symbol, Privilege.Public, SymbolPrivilegeSet.union(Privilege.Protected, getRegion(symbol))));

		// symbol -> this
		if (isScope(symbol))
		{
			SymbolPrivilegeSet requiredPrivileges = Privilege.Public;
			SymbolPrivilegeSet grantedPrivileges = SymbolPrivilegeSet.union(Privilege.Protected, region);

			SymbolPath path = new SymbolPath(this, requiredPrivileges, grantedPrivileges);

			((SymbolScope) symbol).externalTable.addPath(path);
		} // if
	} // addSymbol

	public void importSymbol(Symbol symbol, SymbolPrivilegeSet requiredPrivileges) throws Exception
	{
		// this -> symbol
		importTable.addPath(new SymbolPath(symbol, requiredPrivileges, getRegion(symbol)));
	} // addSymbol

	public static class Privilege
	{
		public static final SymbolPrivilegeSet	Protected	= new SymbolPrivilegeSetLocal();
		public static final SymbolPrivilegeSet	Private		= new SymbolPrivilegeSetLocal();
		public static final SymbolPrivilegeSet	Public		= Protected.createSet();
		public static final SymbolPrivilegeSet	All			= SymbolPrivilegeSet.union(Public, Protected, Private);
	} // Privilege
} // SymbolScope