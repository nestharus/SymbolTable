package compile.antlr;

public class SignatureString implements ISignature
{

	private String	name;

	public String toString()
	{
		return this.name;
	}

	public int hashCode()
	{
		return name.hashCode();
	}

	@Override
	public boolean equals(ISignature signature)
	{
		return toString().equals(signature.toString());
	} // equals
}
