/**
 * The stack abstract data type (reworked from Lewis and Chase)
 *
 * 02.02.2016 Original version
 */


package stackInterface;

import exceptions.EmptyCollectionException;

/**
 * Interface defining the operations of the stack abstract data type
 *
 * @param <T> the generic type of elements stored in the stack
 */

public interface StackADT<T>
{
	/**
	 * Adds an element to the top of the stack
	 *
	 * @param element The element to be added
	 */

	public void push( T element );

	/**
	 * Removes and returns the top element of the stack
	 *
	 * @return The removed top element
	 *
	 * @throws EmptyCollectionException Thrown if pop is attempted on an empty stack
	 */

	public T pop() throws EmptyCollectionException;

	/**
	 * Returns the top element of the stack without mofifying the stack
	 *
	 * @return The top element
	 *
	 * @throws EmptyCollectionException Thrown if peek is attempted on an empty stack
	 */

	public T peek() throws EmptyCollectionException;

	/**
	 * Returns true is the stack has no elements
	 *
	 * @return true if the stack is empty
	 */

	public boolean isEmpty();

	/**
	 * Returns the number of elements on the stack
	 *
	 * @return The number of elements on the stack
	 */

	public int size();
}
