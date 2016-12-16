/**
 * An implementation of the minheap ADT (reworked from Lewis&Chase)
 *
 * 03.04.2016 Original version
 */

package interfaces;

import exceptions.EmptyCollectionException;

/**
 * An implementation of the minheap abstract data type
 *
 * @param <T> Generic type of objects stored in the heap
 */
public interface ArrayMinHeapADT<T extends Comparable<T>>
{
	/**
	 * Add an element to the heap
	 *
	 * @param element
	 */

	public void addElement( T element );

	/**
	 * Removes and returns the smallest element in the heap
	 *
	 * @return The smallest element in the heap
	 *
	 * @throws EmptyCollectionException Thrown if the heap is empty
	 */

	public T removeMin() throws EmptyCollectionException;

	/**
	 * Returns the smallest element in the heap
	 *
	 * @return The smallest element in the heap
	 *
	 * @throws EmptyCollectionException Thrown if the heap is empty
	 */

	public T findMin() throws EmptyCollectionException;

	/**
	 * return true if the heap contains no elements
	 *
	 * @return true if the heap is empty
	 */

	public boolean isEmpty();

	/**
	 * Returns the number of elements in the heap
	 *
	 * @return the number of elements in the heap
	 */

	public int size();
}

