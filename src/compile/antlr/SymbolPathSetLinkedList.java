package compile.antlr;

import java.util.LinkedList;

public class SymbolPathSetLinkedList extends SymbolPathSet
{
	private LinkedList<SymbolPath>	paths	= new LinkedList<SymbolPath>();

	public SymbolPathSetLinkedList(SymbolPrivilegeSet requiredPrivilegeSet, SymbolPrivilegeSet grantedPrivilegeSet)
	{
		super(requiredPrivilegeSet, grantedPrivilegeSet);
	} // SymbolPathSetLinkedList

	@Override
	protected LinkedList<SymbolPath> getPaths(ISignature signature)
	{
		return paths;
	} // getPaths

	@Override
	public void addPath(SymbolPath symbolPath) throws Exception
	{
		paths.add(symbolPath);
	} // addPath
} // SymbolPathSetLinkedList