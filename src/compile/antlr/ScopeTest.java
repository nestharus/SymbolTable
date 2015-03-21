package compile.antlr;

/**
 * public final String name
 * 
 * public Scope exportScope
 * 
 * public Access exportAccess = Access.PUBLIC
 * 
 * public Object value = null
 * 
 * public Scope(String name)
 * 
 * public Scope(Scope parent, Access access, String name)
 * 
 * public Scope(Scope parent)
 * 
 * public Scope()
 * 
 * public void linkOuter(Scope parent)
 * 
 * public void addScope(Scope child, Access access)
 * 
 * public void linkImport(Scope scope)
 * 
 * public void linkStatic(Scope scope, Access access)
 * 
 * public void linkDynamic(Scope scope, Access access)
 * 
 * public void linkInherit(Scope scope, Access access)
 * 
 * public Scope findScope(Signature signature)
 * 
 * public Scope define(Access access, String symbol)
 * 
 * public Scope define(Access access, String symbol, Object value)
 * 
 * public Object assign(String symbol, Object value)
 * 
 * public void undefine()
 * 
 * public void undefine(String symbol)
 * 
 * public Scope export(String symbol, Scope scope, Access access)
 * 
 * public Scope export(String symbol)
 * 
 * public Object get(String symbol)
 * 
 */

/*
 * Walk over the tree
 * 
 * 		Define all symbols. Link scopes with everything. This way everything knows where it's at.
 *		Store a queue of all symbols that require type linking
 *
 * Iterate over the queue with all of the symbols that have yet to be linked and link them by resolving
 * The symbols they require using your now partially built symbol table
 */

public class ScopeTest
{
	/*
	 * Merge Scope
	 * 
	 * 	One parent scope that is the name of all of the children
	 *	Children are each searched by the parent and children each search the parent
	 *
	 *	The parent searches the children with up protected access, public to get in
	 *	The children search the parent with up to protected access, private to get in
	 *
	 *	Child scopes of the same name can now share protected members, but can't access
	 *	each other's private members. When something accesses the parent scope, it can access
	 *	public members
	 */

	/*
	 * Global scopes include the child scopes
	 */

	private static void testSuccess(SymbolPrivilegeSet origin, SymbolPrivilegeSet destination, String success)
	{
		if (origin.isSuccess(destination))
		{
			System.out.println(success);
		} // if
		else
		{
			System.out.println("!" + success);
		} // else
	} // testSuccess

	private static void symbolPrivilegeTest()
	{
		SymbolPrivilegeSet g = new SymbolPrivilegeSetRegional();

		SymbolPrivilegeSet p1 = new SymbolPrivilegeSetLocal();
		SymbolPrivilegeSet p2 = new SymbolPrivilegeSetLocal();
		SymbolPrivilegeSet p3 = new SymbolPrivilegeSetLocal();
		SymbolPrivilegeSet p4 = new SymbolPrivilegeSetLocal();
		SymbolPrivilegeSet p5 = new SymbolPrivilegeSetLocal();

		SymbolPrivilegeSet ps1 = SymbolPrivilegeSet.union(p1, p2, p3, p4, p5);
		SymbolPrivilegeSet ps2 = SymbolPrivilegeSet.union(p1, p2, p3);
		SymbolPrivilegeSet ps3 = SymbolPrivilegeSet.union(p3, p4, p5);
		SymbolPrivilegeSet ps4 = SymbolPrivilegeSet.union(p1, p3);

		testSuccess(ps1, ps2, "ps1->ps2");
		testSuccess(ps2, ps4, "ps2->ps4");
		testSuccess(ps3, ps4, "ps3->ps4");

		SymbolPrivilegeSet r1 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet r2 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet r3 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet r4 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet r5 = new SymbolPrivilegeSetRegional();

		SymbolPrivilegeSet rs1 = SymbolPrivilegeSet.union(r1, r3);
		SymbolPrivilegeSet rs2 = SymbolPrivilegeSet.union(r3, r4);
		SymbolPrivilegeSet rs3 = SymbolPrivilegeSet.union(r4, r5);

		testSuccess(rs1, rs2, "rs1->rs2");
		testSuccess(rs2, rs3, "rs2->rs3");
		testSuccess(rs1, rs3, "rs1->rs3");

		SymbolPrivilegeSet prs1 = SymbolPrivilegeSet.union(ps1, rs1);
		SymbolPrivilegeSet prs2 = SymbolPrivilegeSet.union(ps2, rs2);
		SymbolPrivilegeSet prs3 = SymbolPrivilegeSet.union(ps3, rs3);
		SymbolPrivilegeSet prs4 = SymbolPrivilegeSet.union(ps4, r1, r4);

		testSuccess(prs1, prs2, "prs1->prs2");
		testSuccess(prs2, prs3, "prs2->prs3");
		testSuccess(prs1, prs3, "prs1->prs3");

		/*
		 * This is the global scope, which includes all other scopes
		 */
		/*
		Scope global = new Scope(null, Symbol.Access.Lock.PUBLIC, "");

		Scope file1 = new Scope(null, Symbol.Access.Lock.PUBLIC, "file1");
		Scope file2 = new Scope(null, Symbol.Access.Lock.PUBLIC, "file2");
		Scope file3 = new Scope(null, Symbol.Access.Lock.PUBLIC, "file3");
		Scope file4 = new Scope(null, Symbol.Access.Lock.PUBLIC, "file4");

		Scope scope_a_0 = new Scope("a", Symbol.Access.Lock.PUBLIC, "");
		Scope scope_a_1 = new Scope("a", Symbol.Access.Lock.PUBLIC, "file4");
		Scope scope_a_2 = new Scope("a", Symbol.Access.Lock.PUBLIC, "file2");

		global.include(file1);
		global.include(file2);
		global.include(file3);
		global.include(file4);

		scope_a_0.include(scope_a_1);
		scope_a_0.include(scope_a_2);

		file4.add(scope_a_1);
		file2.add(scope_a_2);

		Symbol symbol1_1 = new Symbol("symbol1", Symbol.Access.Lock.PUBLIC, "file1");
		Symbol symbol2_1 = new Symbol("symbol2", Symbol.Access.Lock.INTERNAL, "file2");
		Symbol symbol2_2 = new Symbol("symbol2", Symbol.Access.Lock.PUBLIC, "file3");
		Symbol symbol3_1 = new Symbol("symbol3", Symbol.Access.Lock.PUBLIC, "file4");
		Symbol symbol3_2 = new Symbol("symbol3", Symbol.Access.Lock.PUBLIC, "file2");

		file1.add(symbol1_1);
		file2.add(symbol2_1);
		file3.add(symbol2_2);

		scope_a_1.add(symbol3_1);
		scope_a_2.add(symbol3_2);

		// Symbol.Query query = global.new Query();
		// resolve(query, "symbol1");

		// resolve(global, "symbol1");
		resolve(scope_a_1, "symbol3");
		resolve(scope_a_2, "symbol3");
		*/
	} // public Anonymous Scope

	private static void symbolScopeTest() throws Exception
	{
		// regions
		SymbolPrivilegeSet fileRegion1 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet fileRegion2 = new SymbolPrivilegeSetRegional();
		SymbolPrivilegeSet fileRegion3 = new SymbolPrivilegeSetRegional();

		// scopes
		// note that the global scope has no region
		/*
		 * File1 { A { B { declare module E }, D { } } }
		 * File2 { C { implement E } }
		 * File3 { F { } }
		 * 
		 * E outer = C, B
		 * F private import E
		 * 
		 * A {
		 * 		public a
		 * 		public b
		 * }
		 * 
		 * B {
		 * 	internal b
		 * }
		 * 
		 * D {
		 * 	public c
		 * }
		 * 
		 * scopeGlobal shadow { A, C, F }
		 */

		SymbolScope scopeGlobal = new SymbolScope();

		SymbolScope file1 = new SymbolScope(new SignatureString("File1"), SymbolPrivilegeSet.union(fileRegion1, scopeGlobal.getRegion()));
		SymbolScope file2 = new SymbolScope(new SignatureString("File2"), SymbolPrivilegeSet.union(fileRegion2, scopeGlobal.getRegion()));
		SymbolScope file3 = new SymbolScope(new SignatureString("File3"), SymbolPrivilegeSet.union(fileRegion3, scopeGlobal.getRegion()));

		SymbolScope scopeA = new SymbolScope(new SignatureString("A"), file1.getRegion());
		SymbolScope scopeB = new SymbolScope(new SignatureString("B"), scopeA.getRegion());
		SymbolScope scopeC = new SymbolScope(new SignatureString("C"), file2.getRegion());
		SymbolScope scopeD = new SymbolScope(new SignatureString("D"), scopeA.getRegion());
		SymbolScope scopeE = new SymbolScope(new SignatureString("E"), SymbolPrivilegeSet.union(scopeC.getRegion(), scopeB.getRegion()));
		SymbolScope scopeF = new SymbolScope(new SignatureString("F"), file3.getRegion());

		Symbol symbolA = new Symbol(new SignatureString("A"));
		Symbol symbolB = new Symbol(new SignatureString("B"));
		Symbol symbolC = new Symbol(new SignatureString("C"));
		Symbol symbolE = new Symbol(new SignatureString("E"));

		// setup global scope
		scopeGlobal.includeSymbol(file1);
		scopeGlobal.includeSymbol(file2);
		scopeGlobal.includeSymbol(file3);

		// setup files
		file1.addSymbol(scopeA, SymbolScope.Privilege.Public);
		file2.addSymbol(scopeC, SymbolScope.Privilege.Public);
		file3.addSymbol(scopeF, SymbolScope.Privilege.Public);

		// setup scope A
		scopeA.addSymbol(scopeB, SymbolScope.Privilege.Public);
		scopeA.addSymbol(scopeD, SymbolScope.Privilege.Public);
		scopeA.addSymbol(symbolA, SymbolScope.Privilege.Public);
		scopeA.addSymbol(symbolB, SymbolScope.Privilege.Public);

		// setup scope B
		scopeB.addSymbol(symbolB, SymbolPrivilegeSet.union(SymbolScope.Privilege.Public, scopeB.getRegion()));

		// setup scope C
		scopeC.addSymbol(symbolE, SymbolScope.Privilege.Public);

		// setup scope d
		scopeD.addSymbol(symbolC, SymbolScope.Privilege.Public);

		// setup scope E
		scopeB.includeSymbol(scopeE);
		scopeE.addOuterSymbol(scopeC);

		// setup scope F
		scopeF.importSymbol(scopeE, SymbolScope.Privilege.Private);

		// E, D
		for (SymbolScope scope : SymbolScope.getCommonScopes(scopeA, scopeB))
		{
			System.out.println(scope.toString());
		} // for
	} // symbolScopeTest

	public static void main(String[] args)
	{
		// symbolPrivilegeTest();

		try
		{
			symbolScopeTest();
		} // try
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		} // catch

		/*
		 * Public anonymous scopes (typically files)
		 */

		/*
		 * Any given scope is broken down into two parts, a global part and a file local part
		 * 
		 * The global part contains all public members while the file local part contains all internal
		 * members
		 * 
		 * This will allow for proper scope merges
		 */

		// System.out.println(global.get("a.a").toString());
	}
}
