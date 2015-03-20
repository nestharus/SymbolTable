package compile.antlr;

import java.util.Stack;

public class SymbolQuery {
	
	private SymbolPrivilegeSet privileges;
	private SymbolPrivilegeSet resolvedPrivileges;
	private SymbolResolve originSymbol;
	private ISignature symbolToFind;
	private Symbol resolvedSymbol;
	private Stack<Symbol> path;
	
	public SymbolQuery(SymbolResolve symbolResolve, Symbol symbol, SymbolPrivilegeSet symbolPrivilegeSet) {
		this.originSymbol = symbolResolve;
		this.resolvedSymbol = symbol;
		this.privileges = symbolPrivilegeSet;
		this.path = new Stack<Symbol>();
	}
	
	public void execute() {
		// TODO
	}
	
	public Stack<Symbol> getPath() {
		return this.path;
	}
	
	public Symbol getResolvedSymbol() {
		return this.resolvedSymbol;
	}
	
	public SymbolResolve getOrigin() {
		return this.originSymbol;
	}
	
	public SymbolPrivilegeSet getResolvedPrivileges() {
		return this.resolvedPrivileges;
	}
	
	public boolean isEmpty() {
		return this.path.isEmpty(); // TODO ?
	}
	
	public boolean isSuccess() {
		return false; // TODO
	}
	
	protected boolean resolve(SymbolResolve symbolResolve, SymbolPrivilegeSet symbolPrivilegeSet) {
		return false; // TODO
	}
	
}

/*
import java.util.Stack;

public class SymbolQuery
{
	private String						symbolSignature;
	protected AccessModifier			accessModifier;
	protected Symbol					resolvedSymbol;
	protected Stack<ResolvableSymbol>	path;

	public SymbolQuery(String symbolSignature)
	{
		// this is not null because of the isSuccess method
		// this takes a new AccessModifier, meaning that it can't
		// be accessed by anything
		this.resolvedSymbol = new Symbol(new AccessModifier());

		// this is not null because of isSuccess
		// this is the empty set, meaning that it can only access
		// the empty set
		this.accessModifier = AccessModifier.createSet();

		// this is stored as a field because it never changes
		this.symbolSignature = symbolSignature;

		this.path = new Stack<ResolvableSymbol>();
	} // SymbolQuery

	public String getSignature()
	{
		return symbolSignature;
	} // getName

	public AccessModifier getAccessModifier()
	{
		return this.accessModifier;
	} // getAccessModifier

	public Symbol getResolvedSymbol()
	{
		return this.resolvedSymbol;
	} // getResolvedSymbol

	public Stack<ResolvableSymbol> getPath()
	{
		return this.path;
	} // getPath

	// a success occurs when the query's access modifier can
	// access the query's symbol
	private boolean isSuccess(AccessModifier accessModifier)
	{
		return accessModifier.containsAll(resolvedSymbol.getAccessModifier());
	} // isSuccess

	public boolean isSuccess()
	{
		return isSuccess(accessModifier);
	} // isSuccess

	// A symbol can't be resolved unless it has a name
	// If the resolved symbol has no name, no symbol was resolved
	public boolean isEmpty()
	{
		return resolvedSymbol.getName().isEmpty();
	} // isEmpty

	protected void resolve(AccessModifier accessModifier, ResolvableSymbol frontier)
	{
		// first check the symbol table for the symbol
		if (frontier.getSymbolTable().containsKey(symbolSignature))
		{
			// if the symbol was found, then store it as the resolved
			// symbol
			this.resolvedSymbol = frontier.getSymbolTable().get(symbolSignature);

			// the access modifier is stored even on a failed resolved
			// symbol because it will be lost otherwise
			// furthermore, false positives can occur as the *initial*
			// access modifier may actually be able to access the symbol
			this.accessModifier = accessModifier;

			// if the found symbol can be accessed with
			// the current access modifier, then end the search
			if (isSuccess(accessModifier))
			{
				path.push(frontier);

				return;
			} // if
		} // if

		// can result in an infinite loop
		for (SymbolSearchPhase phase : frontier.getPhases())
		{
			AccessModifier sub = phase.getPrivileges(accessModifier);
			for (SymbolLink link : phase.getLinks(accessModifier))
			{
				// resolve via link
				resolve(link.getPrivileges(sub), link.getDestination(accessModifier));

				// if the above resolution resulted in a success
				// then terminate
				if (isSuccess())
				{
					path.push(frontier);

					return;
				} // if
			} // for
		} // for
	} // resolve

	public static SymbolQuery resolve(String symbolSignature, AccessModifier accessModifier, Symbol origin) throws Exception
	{
		// SymbolName Exception
		if (symbolSignature == null || symbolSignature.isEmpty())
		{
			throw new Exception("Null Symbol Name");
		} // if

		// Check origin
		if (origin == null || !ResolvableSymbol.class.isInstance(origin))
		{
			throw new Exception("Invalid Start Symbol");
		} // if

		// Check to see if origin can be accessed
		if (!accessModifier.containsAll(origin.getAccessModifier()))
		{
			throw new Exception("Lacking Privileges");
		} // if

		// resolve query
		SymbolQuery query = new SymbolQuery(symbolSignature);

		query.resolve(accessModifier, (ResolvableSymbol) origin);

		return query;
	} // resolve
} // SymbolQuery
*/
