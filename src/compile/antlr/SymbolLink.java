package compile.antlr;

/*
 * public SymbolLink(AccessModifier accessModifier, ResolvableSymbol source, ResolvableSymbol destination)
 * 
 * public ResolvableSymbol getDestination(AccessModifier accessModifier)
 * public AccessModifier getPrivileges(AccessModifier accessModifier)
 */

public class SymbolLink
{
	private final AccessModifier	accessModifier;
	private final ResolvableSymbol	source;
	private final ResolvableSymbol	destination;

	public SymbolLink(AccessModifier accessModifier, ResolvableSymbol source, ResolvableSymbol destination)
	{
		this.accessModifier = accessModifier;
		this.source = source;
		this.destination = destination;
	} // Link

	/**
	 * Check to see if the caller has access
	 * if it does, return the destination
	 * if it doesn't, return an empty destination
	 * 
	 * @param accessModifier
	 * @return ResolvableSymbol
	 */
	public ResolvableSymbol getDestination(AccessModifier accessModifier)
	{
		if (accessModifier.containsAll(this.accessModifier))
		{
			return this.destination;
		} // if

		return new ResolvableSymbol();
	} // getDestination

	/**
	 * Restrict privileges to only include those granted by this Link
	 * 
	 * Restrict privileges to only include those granted by the relationship
	 * between the source and destination
	 * 
	 * @param accessModifier
	 * @return AccessModifier
	 */
	public AccessModifier getPrivileges(AccessModifier accessModifier)
	{
		return AccessModifier.contextIntersect(AccessModifier.intersect(accessModifier, this.accessModifier), source, destination);
	} // getPrivileges
} // Link