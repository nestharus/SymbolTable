package compile.antlr;

import java.util.Stack;

public class Env
{
	private Stack<Scope> scope = new Stack<Scope>();

	public Scope get()
	{
		if (scope.isEmpty())
		{
			return null;
		} // if

		return scope.peek();
	} // Scope

	public void enter(Scope scope)
	{
		this.scope.push(scope);
	} // enter

	public void leave()
	{
		scope.pop();
	} // leave
}
