package compile.antlr;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

// take a function signature
// take a type signature
// a type signature is equal to a function signature if the argument of that function signature is
// a derived type of the type signature and the function signature's name is equal to the name of
// the function signature (generics equal too). Essentially, treat everything about the function
// signature as a type signature except for the argument, which adds another condition to whether it's
// true or not

public class SymbolQuery
{
	protected final static Symbol				emptySymbol		= new Symbol();
	protected final static SymbolPrivilegeSet	emptyPrivilege	=
																	new SymbolPrivilegeSetBase(
																								new SymbolPrivilege(
																													new HashSet<SymbolPrivilege>()),
																								new SymbolPrivilege(
																													new HashSet<SymbolPrivilege>()));

	private SymbolResolve						origin;
	private SymbolPrivilegeSet					initialPrivileges;
	private ISignature							signature;

	private Symbol								destination;
	private SymbolPrivilegeSet					resolvedPrivileges;
	private Stack<SymbolPath>					path;

	public SymbolQuery(SymbolResolve origin, ISignature signature, SymbolPrivilegeSet initialPrivileges)
	{
		this.origin = origin;
		this.initialPrivileges = initialPrivileges;
		this.signature = signature;

		this.destination = emptySymbol;
		this.resolvedPrivileges = emptyPrivilege;

		this.path = new Stack<SymbolPath>();
	} // SymbolQuery

	public void execute()
	{
		resolve(origin, initialPrivileges);
	} // execute

	protected boolean resolve(SymbolResolve origin, SymbolPrivilegeSet privileges)
	{
		LinkedList<SymbolPathSet> pathSets = origin.getSymbolPathSets();
		LinkedList<SymbolPath> paths;
		SymbolPrivilegeSet setPrivilege;
		Symbol destination;

		// go over all sets of paths for the origin
		for (SymbolPathSet pathSet : pathSets)
		{
			// retrieve all paths in the set
			paths = pathSet.getPaths(signature, privileges);

			// retrieve the privileges granted by the set
			setPrivilege = pathSet.getPrivileges(privileges);

			// for every path
			for (SymbolPath path : paths)
			{
				if (pathSet.isProxy())
				{
					// if the path is a proxy for other paths, resolve using the
					// path's destination as the new origin
					if (resolve((SymbolResolve) path.getDestination(setPrivilege), path.getPrivileges(setPrivilege)))
					{
						this.path.push(path);

						return true;
					} // if
				} // if
				else
				{
					// if the path is not a proxy, see if it's a match
					destination = path.getDestination();

					if (destination.getSignature().equals(signature))
					{
						// if the path was a match, store it as the last found
						// match
						this.resolvedPrivileges = setPrivilege;
						this.destination = destination;

						// if the path was also accessible, end the search
						if (path.isSuccess(setPrivilege))
						{
							this.path.push(path);

							return true;
						} // if
					} // else
				} // else
			} // for
		} // for

		return false;
	} // resolve

	public Stack<SymbolPath> getPath()
	{
		return this.path;
	} // getPath

	public Symbol getDestination()
	{
		return destination;
	} // getDestination

	public SymbolResolve getOrigin()
	{
		return this.origin;
	} // getOrigin

	public SymbolPrivilegeSet getPrivileges()
	{
		return this.resolvedPrivileges;
	} // getPrivileges

	public ISignature getSignature()
	{
		return signature;
	} // getSignature

	public boolean isEmpty()
	{
		return this.path.isEmpty();
	} // isEmpty

	public boolean isSuccess()
	{
		return !isEmpty() && path.peek().isSuccess(resolvedPrivileges);
	} // isSuccess
} // SymbolQuery
