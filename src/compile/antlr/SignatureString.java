package compile.antlr;

public class SignatureString implements ISignature
{
	private final String	name;

	public SignatureString(String name)
	{
		this.name = name;
	} // SignatureString

	public String toString()
	{
		return this.name;
	} // toString

	public int hashCode()
	{
		return name.hashCode();
	} // hashCode

	@Override
	public boolean equals(ISignature signature)
	{
		return !this.name.isEmpty() && toString().equals(signature.toString());
	} // equals
} // SignatureString