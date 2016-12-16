/**
 * Exception to be used in a call to an operation, where a certain element couldn't be found
 *
 * 06.02.2016 Original version
 */


package exceptions;


/**
 * Exception to be used in a call to an operation, where a certain element couldn't be found
 */

public class ElementNotFoundException
	extends Exception
{
	/**
	 * The empty constructor
	 */

	public ElementNotFoundException()
	{
		super();
	}


	/**
	 * Constructor with a an explanation
	 *
	 * @param explanation The extra explanation
	 */

	public ElementNotFoundException( String explanation )
	{
		super( explanation );
	}
}
