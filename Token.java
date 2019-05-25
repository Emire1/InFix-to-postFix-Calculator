package expression;
/**
 * Represents a token in an expression. Just provides some
 * static methods
 * 
 * @author (T.M. Rao) 
 * 
 */
public class Token
{
	//-------------------------------------------------------------
	//It classifies the following as "OPERATORS". If you need more, 
	//you have to change this
	private final static String[] validOperators = 
		{"+","-","*","/","%", "<", "<=", ">", ">=", "==", "!=", "&&", "||"};
	private final static String[] varNames = {"A", "B","C","D","E"};


	//-------------------------------------------------------------
	private String body;

	//-------------------------------------------------------------
	private final static char OPENPAREN = '(';
	private final static char CLOSEDPAREN = ')';


	//-------------------------------------------------------------
	public Token(String tok)
	{
		body = tok;   
	}

	//-------------------------------------------------------------
	public String getBody()
	{
		return body;   
	}
	
	public void setBody(String b) {
		body = b;
	}
	//-------------------------------------------------------------
	/**
	 * Takes a String argument and checks if the first 
	 * char (i.e. charAt(0)) is an operator. The string
	 * of valid operators is defined above.
	 */
	public boolean isOperator()
	{
		for (int i = 0; i < validOperators.length; i++)
			if (validOperators[i].equals(body))
				return true;
		return false;
	}


	//-------------------------------------------------------------
	/**
	 * Is the first char of the arg an open Parenthesis?
	 */
	public boolean isOpenParen()
	{
		char ch = body.charAt(0);
		return (ch == OPENPAREN);
	}

	//-------------------------------------------------------------
	/**
	 * Is the first char of the arg an close Parenthesis?
	 */
	public boolean isClosedParen()
	{
		char ch = body.charAt(0);
		return (ch == CLOSEDPAREN);
	}
	
	
	/**
	 * Checks if there is a variable in the body 
	 * @return true if the conditions is met
	 */
	public boolean isVariable()
	{
		for (int i = 0; i < varNames.length; i++)
			if (varNames[i].equals(body))
				return true;
		return false;
	}

	//-------------------------------------------------------------
	public boolean isOperand()
	{
		return (! (( isOperator() ||  isOpenParen() ||  isClosedParen())));
	}

	//-------------------------------------------------------------
	/**
	 * Defines the precedence values for some operators.
	 */
	public int getPrecedence()
	{  
		if (body.equals("*") ||body.equals("/") || body.equals("%"))
			return 12;
		else if (body.equals("+") ||body.equals("-"))
			return 11;
		else if (body.equals("<") || body.equals("<=") || body.equals(">") || body.equals(">="))
			return 9;
		else if (body.equals("==") || body.equals("!="))
			return 8;
		else if (body.equals("&&")) 
			return 4;
		else if (body.equals("||"))
			return 3;
		else
			return -1;
	}

	public String toString()
	{
		return body;   
	}

}