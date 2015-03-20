package compile.antlr;

public interface ISignature
{
	public String toString();

	public int hashCode();

	public boolean equals(ISignature signature);
} // ISignature