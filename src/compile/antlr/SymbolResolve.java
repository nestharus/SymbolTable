package compile.antlr;

import java.util.LinkedList;

public class SymbolResolve extends Symbol
{
	protected LinkedList<SymbolPathSet>	symbolPathSets;

	public SymbolResolve(ISignature name)
	{
		super(name);

		this.symbolPathSets = new LinkedList<SymbolPathSet>();
	} // SymbolResolve

	public LinkedList<SymbolPathSet> getSymbolPathSets()
	{
		return this.symbolPathSets;
	} // getSymbolPathSets
} // SymbolResolve
