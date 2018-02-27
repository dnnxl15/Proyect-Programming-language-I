package exception;

public class CodeBookException extends Exception
{
	private String code;
	
	public CodeBookException(String pCode)
	{
		code = pCode;
	}
}