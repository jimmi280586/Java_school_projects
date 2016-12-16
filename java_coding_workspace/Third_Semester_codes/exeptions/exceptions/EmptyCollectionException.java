/**
 * Exception to be used in a call to an operation, that expects the collection to be non-empty
 *
 * 02.02.2016 Original version
 */


package exceptions;


/**
 * Exception to be used in a call to an operation, that expects the collection to be non-empty
 */

public class EmptyCollectionException
	extends Exception
{
	/**
	 * The empty constructor
	 */

	public EmptyCollectionException()
	{
		super();
	}


	/**
	 * Constructor with a an explanation
	 *
	 * @param explanation The extra explanation
	 */

	public EmptyCollectionException( String explanation )
	{
		super( explanation );
	}
}
