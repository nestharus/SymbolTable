package compile.antlr;

import java.util.LinkedList;

// this needs to be accessed by queries and handle the internal access modifier
// stuff itself
public class SymbolSearchPhase
{
	private final LinkedList<SymbolLink>	links;
	private final AccessModifier			accessModifier;

	public SymbolSearchPhase(AccessModifier accessModifier)
	{
		links = new LinkedList<SymbolLink>();
		this.accessModifier = accessModifier;
	} // SearchPhase

	/**
	 * Check to see if the caller has access
	 * if it does, return the links
	 * if it doesn't, return an empty list
	 * 
	 * @param accessModifier
	 * @return ResolvableSymbol
	 */
	public LinkedList<SymbolLink> getLinks(AccessModifier accessModifier)
	{
		if (accessModifier.containsAll(this.accessModifier))
		{
			return links;
		} // if

		return new LinkedList<SymbolLink>();
	} // getLinks

	/**
	 * Restrict privileges to only include those granted by this Phase
	 * 
	 * @param accessModifier
	 * @return AccessModifier
	 */
	public AccessModifier getPrivileges(AccessModifier accessModifier)
	{
		return AccessModifier.intersect(accessModifier, this.accessModifier);
	} // getPrivileges
} // SearchPhase