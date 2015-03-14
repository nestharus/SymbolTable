package compile.antlr;

import java.util.Stack;

// This class begins a Query that starts at a Symbol and then, using
// a Signature, locates another Symbol by navigating over the graph of
// links between symbols. Needs to check the HashMap and phases and stop
// when it encounters a symbol, not when the symbol it is currently inside
// of is a match
//
//	scope A
//		integer B
//
//	if searching for A.B, it will stop at A once it sees that B is
//	inside of A. It will not stop at B.
//
//	A Query can only be used a single time.
//
//	The query needs to store the path to the symbol from the origin
//	within a Stack. It also needs to store the final symbol and the
//	final privileges used to access that symbol.
//
//	As the Query searches, it will recursively call itself, storing
//	branching privileges on the stack.
//
//	When a Query encounters a symbol that is a match, it will store it
//	as a prospective Symbol, but it will not stop searching until it has
//	either exhausted the graph or has found an accessible symbol.
//
//	If the Query has found some symbol and that symbol can't be accessed, the
//	Query has failed. The path should still be saved along with everything else.
//	This data can be used to generate error messages.
//
//	If the Query has found no symbol, then the query has failed. In this case, the
//	thing should return an empty symbol.
//
//	If the query has found the symbol and that symbol can be accessed, the query
//	was a success.
//
//	The constructor should initialize the Query
//	the resolve method should execute the query (possibly rename it to execute)
//	The execute method should return nothing. Use getters instead.
public class SymbolQuery
{
	public SymbolQuery(AccessModifier accessModifier, ResolvableSymbol origin)
	{
	} // SymbolQuery

	public boolean isSuccess()
	{

	} // isSuccess

	public Stack<ResolvableSymbol> getPath()
	{
		return state.path;
	} // getPath

	public void resolve(String symbolName) throws Exception
	{
		// find
	} // resolve
} // SymbolQuery