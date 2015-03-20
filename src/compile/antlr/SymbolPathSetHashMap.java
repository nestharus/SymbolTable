package compile.antlr;

import java.util.HashMap;
import java.util.LinkedList;

public class SymbolPathSetHashMap extends SymbolPathSet
{
	private HashMap<ISignature, SymbolPath>	paths;

	public SymbolPathSetHashMap(SymbolPrivilegeSet requiredPrivilegeSet, SymbolPrivilegeSet grantedPrivilegeSet)
	{
		super(requiredPrivilegeSet, grantedPrivilegeSet);

		paths = new HashMap<ISignature, SymbolPath>();
	} // SymbolPathSetHashMap

	@Override
	protected LinkedList<SymbolPath> getPaths(ISignature signature)
	{
		LinkedList<SymbolPath> paths = new LinkedList<SymbolPath>();

		if (this.paths.containsKey(signature))
		{
			paths.add(this.paths.get(signature));
		} // if

		return paths;
	} // getPaths

	@Override
	public void addPath(SymbolPath symbolPath) throws Exception
	{
		if (paths.containsKey(symbolPath.getDestination().getSignature()))
		{
			throw new Exception("Symbol Path Set Already Contains Symbol");
		} // if

		this.paths.put(symbolPath.getDestination().getSignature(), symbolPath);
	} // addPath
} // SymbolPathSetHashMap