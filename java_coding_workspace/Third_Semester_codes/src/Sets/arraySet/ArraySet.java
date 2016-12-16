/**
 * Array implementation of a set (reworked from Lewis & Chase)
 *
 * 16.02.2016 intersection() added
 * 06.02.2016 Original version
 */


package arraySet;


import java.util.Iterator;
import java.util.Random;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.SetADT;


/**
 * Array implementation of a set. If the set overflows the size is automatically increased
 */

public class ArraySet<T>
	implements SetADT<T>
{
	private static final int DEFAULT_CAPACITY = 100;

	private Random random = new Random();

	/**
	 * The number of elements in the set
	 */

	private int count = 0;

	/**
	 * The elements of the set. The elements are placed between index 0 and index count-1
	 */

	private T[] contents;


	/**
	 * Constructor where the initial size of the contents array is given by the class user
	 *
	 * @param initialCapacity The initial size of array contents
	 */

	public ArraySet( int initialCapacity )
	{
		contents = (T[]) new Object[initialCapacity];
	}

	/**
	 * Constructor where the initial size of the contents array is fiven a default value
	 */

	public ArraySet()
	{
		this( DEFAULT_CAPACITY );
	}


	@Override
	public void add( T element )
	{
		if( contains( element ) )
			return;

		if( size() == contents.length )
			expandCapacity();

		contents[count++] = element;
	}


	@Override
	public T removeRandom()
		throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException( "ArraySet.removeRandom()" );

		// randomly choose the index of the element to remove

		int index = random.nextInt( count );

		// replace the removed element with the last element

		T result = contents[index];
		count--;
		contents[index] = contents[count];
		contents[count] = null; // help the garbage collector

		return result;
	}


	@Override
	public T remove( T element )
		throws ElementNotFoundException
	{
		int index = find( element );

		if( index < 0 )
			throw new ElementNotFoundException( "ArraySet.remove" );

		// replace the removed element with the last element

		T result = contents[index];
		count--;
		contents[index] = contents[count];
		contents[count] = null; // help the garbage collector

		return result;
	}


	@Override
	public SetADT<T> union( SetADT<T> other )
	{
		SetADT<T> result = new ArraySet<T>();

		for( T item: this )
			result.add( item );

		for( T item: other )
			result.add( item );

		return result;
	}


	@Override
	public SetADT<T> intersection( SetADT<T> other )
	{
		SetADT<T> result = new ArraySet<T>();

		for( T item: this )
			if( other.contains( item ) )
				result.add( item );

		return result;
	}


	@Override
	public boolean contains( T element )
	{
		return find( element ) >= 0;
	}


	private int find( T element )
	{
		for( int i = 0; i < count; ++i )
			if( element.equals( contents[i] ) )
				return i;

		return -1;
	}


	@Override
	public boolean equals( SetADT<T> other )
	{
		// do the two sets have the same size?

		if( this.size() != other.size() )
			return false;

		// do they contain the same elements?

		for( T item: other )
			if( !contains( item ) )
				return false;

		return true;
	}


	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}


	@Override
	public int size()
	{
		return count;
	}


	@Override
	public Iterator<T> iterator()
	{
		return new ArrayIterator<T>( contents, count );
	}


	private void expandCapacity()
	{
		// Create a new array of double size and copy all elements from the old to the new array

		T[] newContents = (T[]) new Object[2 * contents.length];

		for( int i = 0; i < contents.length; ++i )
			newContents[i] = contents[i];

		// Let the new array be the contents

		contents = newContents;
	}


	@Override
	public String toString()
	{
		String result = "";

		for( T item: this )
			result += " " + item;

		return result;
	}
}
