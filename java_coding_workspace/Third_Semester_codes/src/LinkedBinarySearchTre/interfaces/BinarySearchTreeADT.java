/**
 * An implementation of the binary search tree ADT (reworked from Lewis&Chase)
 *
 * 28.02.2016 Original version
 */

package interfaces;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 * Interface defining the operations of the binary searchtree abstract data type
 *
 * @param <T> the generic type of elements stored in the tree
 */

public interface BinarySearchTreeADT<T extends Comparable<T>>
	extends LinkedBinarysearchTreeADT<T>
{
	public void addElement( T element );

	public T removeElement( T element ) throws ElementNotFoundException;

	public void removeAllOccurrences( T element ) throws ElementNotFoundException;

	public T removeMin() throws EmptyCollectionException;

	public T removeMax() throws EmptyCollectionException;

	public T findMin() throws EmptyCollectionException;

	public T findMax() throws EmptyCollectionException;
}
