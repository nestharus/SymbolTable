package compile.antlr;

import java.util.HashMap;
import java.util.LinkedList;

public class Scope extends Symbol
{
	public class SearchPhase
	{
		public class Link
		{
			public final AccessMask	accessModifier;
			public final Symbol		destination;

			public Link(AccessMask accessModifier, Symbol destination)
			{
				this.accessModifier = accessModifier;
				this.destination = destination;
			} // Link
		} // Link

		public final LinkedList<Link>	links;
		public final AccessMask			accessModifier;

		public SearchPhase(AccessMask accessModifier)
		{
			links = new LinkedList<Link>();
			this.accessModifier = accessModifier;
		} // SearchPhase
	} // SearchPhase
} // Scope

public class Scopeex extends Symbolex
{
	/*
	 * For merging scopes into one scope
	 * 
	 * 	includePhase provides access to children from the super parent scope
	 * 	includePhase essentially states that the children of the children are the children of the super scope
	 * 	the super scope should have no children of its own
	 * 
	 * 	sharedPhase provides access to the super parent scope from the children so that the children
	 * 	can see each other
	 * 
	 * 	importPhase is checking imported scopes. It's similar to include except that this scope doesn't share
	 *  it's information with the imported scope.
	 */
	protected SearchPhase	includePhase	= new SearchPhase(Access.Lock.PUBLIC, Access.Key.DERIVED_TYPE);
	protected SearchPhase	importPhase		= new SearchPhase(Access.Lock.PUBLIC, Access.Key.OUTSIDE_SCOPE);
	protected SearchPhase	sharedPhase		= new SearchPhase(Access.Lock.PRIVATE, Access.Key.DERIVED_TYPE);

	/*
	 * This checks outer scopes
	 */
	protected SearchPhase	outerPhase		= new SearchPhase(Access.Lock.PRIVATE, Access.Key.SAME_SCOPE);

	/*
	 * inherit - protected internal (for objects)
	 * point - public internal (for variables)
	 * outer - private internal (for child -> parent)
	 * inner - public internal (for parent -> child)
	 * import - private internal, public internal
	 */

	/*
	 * Used for merging scopes
	 */
	public void include(Scope scope)
	{
		includePhase.addLink(new Link(Access.Lock.PUBLIC, Access.Key.DERIVED_TYPE, scope));
		scope.sharedPhase.addLink(new Link(Access.Lock.PROTECTED, Access.Key.DERIVED_TYPE, this));
	} // include

	public void importScope(Access.Lock lock, Scope scope)
	{
		importPhase.addLink(new Link(lock, Access.Key.OUTSIDE_SCOPE, scope));
	} // importScope

	private Symbol superGet(String symbol)
	{
		return super.get(symbol);
	} // superGet

	private Symbol get(String symbol, HashMap<Symbol, Boolean> explored)
	{
		Symbol symb = null;

		for (Link link : sharedPhase.links)
		{
			for (Link sibling : ((Scope) (link.target)).includePhase.links)
			{
				if (!explored.containsKey(sibling.target))
				{
					explored.put(sibling.target, true);
					symb = ((Scope) (sibling.target)).superGet(symbol);
				} // if

				if (symb != null)
				{
					return symb;
				} // if

				if (Scope.class.isAssignableFrom(sibling.target.getClass()))
				{
					if (!explored.containsKey(link.target))
					{
						explored.put(link.target, true);
						symb = ((Scope) (sibling.target)).get(symbol, explored);
					} // if
				} // if
			} // for
		} // for

		return null;
	} // Symbol

	public Symbol get(String symbol)
	{
		return get(symbol, new HashMap<Symbol, Boolean>());
	} // has

	public boolean add(Symbol symbol, boolean unique)
	{
		Symbol symb = get(symbol.name);
		if (symb == null
			|| (!unique && (symb.lock.isInternal() || symbol.lock.isInternal() || Scope.class.isAssignableFrom(symbol.getClass()))))
		{
			super.add(symbol);

			return true;
		} // if

		return false;
	} // add

	@Override
	public boolean add(Symbol symbol)
	{
		return add(symbol, false);
	} // add

	public boolean add(Scope scope, boolean unique)
	{
		if (add((Symbol) scope, unique))
		{
			scope.outerPhase.addLink(new Link(Access.Lock.PRIVATE, Access.Key.SAME_SCOPE, this));

			return true;
		} // if

		return false;
	} // add

	public boolean add(Scope scope)
	{
		return add(scope, false);
	} // add

	private void initialize()
	{
		add(includePhase);
		add(importPhase);
		add(sharedPhase);
		add(outerPhase);
	} // initialize

	public Scope(final String name, Access.Lock lock, String filename)
	{
		super(name, lock, filename);
		initialize();
	} // Scope

	public Scope(final String name, String filename)
	{
		super(name, filename);
		initialize();
	} // Scope

	public Scope(Access.Lock lock, String filename)
	{
		super(lock, filename);
		initialize();
	} // Scope

	public Scope(String filename)
	{
		super(filename);
		initialize();
	} // Scope
} // Scope