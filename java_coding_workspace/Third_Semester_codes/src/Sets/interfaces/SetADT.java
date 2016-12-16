/**
 * The set abstract data type (reworked from Lewis and Chase)
 *
 * 16.02.2016 intersection() added
 * 06.02.2016 Original version
 */


package interfaces;


import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

/**
 * Interface defining the operations of the set abstract data type
 *
 * @param <T> the generic type of elements stored in the set
 */

public interface SetADT<T>
	extends Iterable<T> // Makes it possible to use a foreach statement to iterate through the set
{
	/**
	 * Add an element to the set. The element is only added if it isn't in the set already
	 *
	 * @param element The element to add to the set
	 */

	public void add( T element );

	/**
	 * Randomly chooses an element from the set and removes it
	 *
	 * @return the removed element
	 *
	 * @throws EmptyCollectionException thrown is the operation is attempted on an empty set
	 */

	public T removeRandom() throws EmptyCollectionException;

	/**
	 * Removes and element from the (ie. where equals returns true)
	 *
	 * @param element The element to remove
	 *
	 * @return The removed element
	 *
	 * @throws ElementNotFoundException Thrown if the set doesn't contain the element
	 */

	public T remove( T element ) throws ElementNotFoundException;

	/**
	 * Returns a new set, that is the union of this and other. The result contains all elements, that are contained in at least one of the sets.
	 *
	 * @param other The set that should be "unioned" with this
	 *
	 * @return the union of this and other
	 */

	public SetADT<T> union( SetADT<T> other );

	/**
	 * Returns a new set, that is the intersection of this and other. The result contains all elements, that are contained in both of the sets.
	 *
	 * @param other The set that should be "intersected" with this
	 *
	 * @return the union of this and other
	 */

	public SetADT<T> intersection( SetADT<T> other );

	/**
	 * Determines if an element is contained in the set
	 *
	 * @param element The element to lookup in the set
	 *
	 * @return true if element is contained in the set
	 */

	public boolean contains( T element );

	/**
	 * Compares to sets to see if they are equal (have the same size and contains exactly the same members)
	 *
	 * @param other The set set to be compared to this
	 *
	 * @return True if this and other is equal
	 */

	public boolean equals( SetADT<T> other );

	/**
	 * Returns true if the set contains no elements
	 *
	 * @return True if the set is empty
	 */

	public boolean isEmpty();

	/**
	 * Returns the number of elements in the set
	 *
	 * @return The number of elements in the set
	 */

	public int size();

	/**
	 * Returns an iterator for the set. The iterator will go through all the members of the set, but in no specific order.
	 *
	 * @return The iterator
	 */

	@Override
	public Iterator<T> iterator();
}
