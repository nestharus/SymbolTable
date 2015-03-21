package compile.antlr;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * public SymbolScope()
 * public SymbolScope(ISignature name, SymbolPrivilegeSet region)
 * 
 * public void addSymbol(Symbol symbol, SymbolPrivilegeSet requiredPrivileges) throws Exception
 * -	regular symbol adding (hashmap)
 * -	the added symbol gets an external path to this symbol
 * public void addOuterSymbol(SymbolScope scope) throws Exception
 * -	sees scope as an outer scope
 * public void includeSymbol(Symbol symbol) throws Exception
 * -	add symbol as though it's scope is part of this symbol's scope (up to protected)
 * -	the added symbol gets an external path to this symbol
 * public void importSymbol(Symbol symbol, SymbolPrivilegeSet requiredPrivileges) throws Exception
 * -	import the scope of one symbol to the scope of this symbol
 * 
 * public static SymbolScope[] getCommonScopes(SymbolScope... scopes)
 * 
 * public boolean containsScope(SymbolScope symbol)
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
	private SymbolPathSet		symbolTable;	// the contents of this
												// symbol
	private SymbolPathSet		shadowTable;	// scope inclusion
	private SymbolPathSet		importTable;	// scope usage w/o
												// resolution
	private SymbolPathSet		externalTable;	// parent scope
	private SymbolPrivilegeSet	region;		// file etc

	// this scope contains the target symbol directly
	private boolean hasSymbol(Symbol symbol)
	{
		LinkedList<SymbolPath> internalPaths = symbolTable.getPaths(symbol.getSignature());

		LinkedList<SymbolPath> importPaths = importTable.getPaths(null);
		LinkedList<SymbolPath> shadowPaths = shadowTable.getPaths(null);

		for (SymbolPath path : importPaths)
		{
			if (path.getDestination() == symbol)
			{
				return true;
			} // if
		} // for

		for (SymbolPath path : shadowPaths)
		{
			if (path.getDestination() == symbol)
			{
				return true;
			} // if
		} // for

		return !internalPaths.isEmpty() && internalPaths.peek().getDestination() == symbol;
	} // hasScope

	// get all outer scopes that actually contain this symbol
	private LinkedList<SymbolScope> getContainingScopes()
	{
		LinkedList<SymbolPath> outerScopes = externalTable.getPaths(null);
		LinkedList<SymbolScope> scopes = new LinkedList<SymbolScope>();
		SymbolScope outerScope;

		for (SymbolPath outerPath : outerScopes)
		{
			outerScope = (SymbolScope) outerPath.getDestination();

			if (outerScope.hasSymbol(this))
			{
				scopes.add(outerScope);
			} // if
		} // for

		return scopes;
	} // getContainingScopes

	// this scope contains a symbol somewhere
	public boolean containsScope(SymbolScope symbol)
	{
		return symbol.isChild(this);
	} // Symbol

	private boolean isChild(SymbolScope outerScopeToFind)
	{
		SymbolScope outerScope;

		for (SymbolPath path : externalTable.getPaths(null))
		{
			outerScope = (SymbolScope) path.getDestination();

			if (outerScope.hasSymbol(this))
			{
				if (outerScope == outerScopeToFind)
				{
					return true;
				} // if
				else
				{
					return outerScope.isChild(outerScopeToFind);
				} // else
			} // if
		} // for

		return false;
	} // isChild

	// get all outer scopes that somehow contain this symbol
	private LinkedList<HashSet<SymbolScope>> getScopeRegion()
	{
		LinkedList<HashSet<SymbolScope>> region = new LinkedList<HashSet<SymbolScope>>();
		region.push(new HashSet<SymbolScope>());
		region.peek().add(this);
		region.push(new HashSet<SymbolScope>());

		LinkedList<SymbolScope> currentRegion = getContainingScopes();
		LinkedList<SymbolScope> nextRegion = new LinkedList<SymbolScope>();
		SymbolScope scope;

		while (!currentRegion.isEmpty())
		{
			scope = currentRegion.pop();

			region.peek().add(scope);

			nextRegion.addAll(scope.getContainingScopes());

			if (currentRegion.isEmpty() && !nextRegion.isEmpty())
			{
				currentRegion = nextRegion;
				nextRegion = new LinkedList<SymbolScope>();
				region.push(new HashSet<SymbolScope>());
			} // if
		} // while

		return region;
	} // getScopeRegion

	private static boolean containsEmptyRegion(LinkedList<LinkedList<HashSet<SymbolScope>>> regions)
	{
		for (LinkedList<HashSet<SymbolScope>> region : regions)
		{
			if (region.isEmpty())
			{
				return true;
			} // if
		} // for

		return false;
	} // containsEmptyRegion

	private static LinkedList<HashSet<SymbolScope>> getNextRegionLevel(LinkedList<LinkedList<HashSet<SymbolScope>>> regions)
	{
		LinkedList<HashSet<SymbolScope>> regionLevel = new LinkedList<HashSet<SymbolScope>>();

		for (LinkedList<HashSet<SymbolScope>> region : regions)
		{
			regionLevel.add(region.pop());
		} // for

		return regionLevel;
	} // containsEmptyRegion

	private static HashSet<SymbolScope> unionRegionLevel(LinkedList<HashSet<SymbolScope>> regionLevel)
	{
		HashSet<SymbolScope> regionResult = new HashSet<SymbolScope>();

		for (HashSet<SymbolScope> region : regionLevel)
		{
			regionResult.addAll(region);
		} // for

		return regionResult;
	} // for

	private static HashSet<SymbolScope> intersectRegionLevel(LinkedList<HashSet<SymbolScope>> regionLevel)
	{
		HashSet<SymbolScope> regionResult = unionRegionLevel(regionLevel);

		for (HashSet<SymbolScope> region : regionLevel)
		{
			regionResult.retainAll(region);
		} // for

		return regionResult;
	} // containsEmptyRegion

	// gets the lowest common containing scopes between a set of scopes
	public static LinkedList<SymbolScope> getCommonScopes(SymbolScope... scopes)
	{
		LinkedList<LinkedList<HashSet<SymbolScope>>> regions = new LinkedList<LinkedList<HashSet<SymbolScope>>>();
		LinkedList<HashSet<SymbolScope>> regionLevel;

		for (SymbolScope scope : scopes)
		{
			regions.add(scope.getScopeRegion());
		} // for

		HashSet<SymbolScope> hash;
		HashSet<SymbolScope> resultHash = new HashSet<SymbolScope>();

		while (!containsEmptyRegion(regions))
		{
			regionLevel = getNextRegionLevel(regions);
			hash = intersectRegionLevel(regionLevel);

			if (hash.isEmpty())
			{
				break;
			} // if

			resultHash = hash;
		} // while

		LinkedList<SymbolScope> result = new LinkedList<SymbolScope>();
		result.addAll(resultHash);

		return result;
	} // getCommonScope

	private void initialize(SymbolPrivilegeSet region)
	{
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
	} // initialize

	public SymbolScope()
	{
		// has no signature
		super(new SignatureNull());

		// contained in no region
		initialize(new SymbolPrivilegeSet(new LinkedList<SymbolPrivilege>()));
	} // SymbolScope

	public SymbolScope(ISignature name, SymbolPrivilegeSet region)
	{
		super(name);
		initialize(region);
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

	public void addSymbol(Symbol symbol, SymbolPrivilegeSet requiredPrivileges) throws Exception
	{
		// this -> symbol
		symbolTable.addPath(new SymbolPath(symbol, requiredPrivileges, getRegion(symbol)));

		// symbol -> this
		if (isScope(symbol))
		{
			((SymbolScope) symbol).addOuterSymbol(this);
		} // if
	} // addSymbol

	public void addOuterSymbol(SymbolScope scope) throws Exception
	{
		// the path set already requires Private, region
		SymbolPrivilegeSet requiredPrivileges = Privilege.Public;
		SymbolPrivilegeSet grantedPrivileges = SymbolPrivilegeSet.union(Privilege.All, region);

		SymbolPath path = new SymbolPath(scope, requiredPrivileges, grantedPrivileges);

		this.externalTable.addPath(path);
	} // addOuterSymbol

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
		public static final SymbolPrivilegeSet	Protected;
		public static final SymbolPrivilegeSet	Private;
		public static final SymbolPrivilegeSet	Public;
		public static final SymbolPrivilegeSet	All;

		static
		{
			Protected = new SymbolPrivilegeSetLocal();
			Private = new SymbolPrivilegeSetLocal();
			Public = Protected.createSet();
			All = SymbolPrivilegeSet.union(Public, Protected, Private);
		} // static
	} // Privilege
} // SymbolScope