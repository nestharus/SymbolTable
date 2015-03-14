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

	private static void resolve(Symbol.Query query, String symbolToFind)
	{
		Symbol found = query.resolveOrNull(symbolToFind);

		if (found == null)
		{
			System.out.println("Unable to resolve symbol: " + symbolToFind);
		} // if
		else
		{
			System.out.println(found.name + "File{" + found.filename + "} Lock{" + found.lock + "} Key{" + query.getKey() + "}");
		} // else
	} // resolve

	private static Symbol.Query resolve(Symbol symbol, String symbolToFind)
	{
		Symbol.Query query = symbol.new Query();
		Symbol found = query.resolveOrNull(symbolToFind);

		if (found == null)
		{
			System.out.println("Unable to resolve symbol: " + symbolToFind);
		} // if
		else
		{
			System.out.println("Found \"" + found.name + "\"\n\tFile: \"" + found.filename + "\"\n\tLock: \"" + found.lock
								+ "\"\n\tKey: \"" + query.getKey() + "\"");
		} // else

		return query;
	} // resolve

	private static void publicAnonymousScope()
	{
		/*
		 * This is the global scope, which includes all other scopes
		 */
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

	} // public Anonymous Scope

	public static void main(String[] args)
	{
		publicAnonymousScope();

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
