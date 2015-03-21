package compile.antlr;

public class SignatureNull implements ISignature
{
	public String toString()
	{
		return "";
	} // toString

	public int hashCode()
	{
		return 0;
	} // hashCode

	@Override
	public boolean equals(ISignature signature)
	{
		return false;
	} // equals
} // SignatureNull