package compile.antlr;

import java.util.LinkedList;

public abstract class SymbolPathSet extends SymbolGate
{
	public SymbolPathSet(SymbolPrivilegeSet requiredPrivilegeSet, SymbolPrivilegeSet grantedPrivilegeSet)
	{
		super(requiredPrivilegeSet, grantedPrivilegeSet);
	} // SymbolPathSet

	public LinkedList<SymbolPath> getPaths(ISignature signature, SymbolPrivilegeSet symbolPrivilegeSet)
	{
		if (isSuccess(symbolPrivilegeSet))
		{
			return getPaths(signature);
		} // if

		return new LinkedList<SymbolPath>();
	} // getPaths

	protected abstract LinkedList<SymbolPath> getPaths(ISignature signature);

	public abstract void addPath(SymbolPath symbolPath) throws Exception;
} // SymbolPathSet