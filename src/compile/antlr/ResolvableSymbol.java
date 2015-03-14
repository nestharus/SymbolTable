package compile.antlr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class ResolvableSymbol extends Symbol
{
	private LinkedList<ResolvableSymbol>	searchPhases;
	private HashSet<Symbol>					symbolRegion;
	private HashMap<String, Symbol>			symbolTable;

	private void initialize()
	{
		searchPhases = new LinkedList<ResolvableSymbol>();
		symbolRegion = new HashSet<Symbol>();
		symbolTable = new HashMap<String, Symbol>();
	} // initialize

	public ResolvableSymbol(AccessModifier accessModifier, String name)
	{
		super(accessModifier, name);
		initialize();
	} // Symbol

	public ResolvableSymbol(String name)
	{
		super(null, name);
		initialize();
	} // Symbol

	public ResolvableSymbol(AccessModifier accessModifier)
	{
		super(accessModifier, null);
		initialize();
	} // Symbol

	public ResolvableSymbol()
	{
		super(null, null);
		initialize();
	} // Symbol

	public LinkedList<ResolvableSymbol> getPhases()
	{
		return searchPhases;
	} // getPhases

	public HashMap<String, Symbol> getSymbolTable()
	{
		return symbolTable;
	} // getSymbolTable

	public HashSet<Symbol> getSymbolRegion()
	{
		return symbolRegion;
	} // getSymbolRegion
} // ResolvableSymbol