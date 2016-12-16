/**
 * Linked list implementation of a set (reworked from Lewis & Chase)
 *
 * 06.02.2016 Original version
 */


package linkedSet;


import java.util.Iterator;
import java.util.Random;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.SetADT;


/**
 * Linked list implementation of a set
 */

public class LinkedSet<T>
	implements SetADT<T>
{
	private Random random = new Random();

	/**
	 * The number of elements in the set
	 */

	private int count = 0;

	/**
	 * Reference to the front of the list of members
	 */

	private LinearNode<T> contents = null;


	@Override
	public void add( T element )
	{
		if( contains( element ) )
			return;

		LinearNode<T> newNode = new LinearNode<T>( element );
		newNode.setNext( contents );
		contents = newNode;
		++count;
	}


	@Override
	public T removeRandom()
		throws EmptyCollectionException
	{
		if( isEmpty() )
			throw new EmptyCollectionException( "LinkedSet.removeRandom()" );

		// randomly choose the index of the element to remove

		int index = random.nextInt( count );

		// remove the chosen element

		T result;

		if( index == 0 ) {
			result = contents.getElement();
			contents = contents.getNext();
		} else {
			LinearNode<T> previous = contents;

			for( int i = 1; i < index; ++i )
				previous = previous.getNext();

			result = previous.getNext().getElement();
			previous.setNext( previous.getNext().getNext() );
		}

		count--;

		return result;
	}


	@Override
	public T remove( T element )
		throws ElementNotFoundException
	{
		T result;

		if( isEmpty() )
			throw new ElementNotFoundException( "LinkedSet.remove()" );
		else if( contents.getElement().equals( element ) ) {
			result = contents.getElement();
			contents = contents.getNext();
			count--;

			return result;
		} else {
			LinearNode<T> previous = contents;
			LinearNode<T> current = contents.getNext();

			while( current != null ) {
				if( current.getElement().equals( element ) ) {
					result = current.getElement();
					previous.setNext( current.getNext() );
					count--;

					return result;
				}

				previous = current;
				current = current.getNext();
			}
		}

		throw new ElementNotFoundException( "LinkedSet.remove()" );
	}


	@Override
	public SetADT<T> union( SetADT<T> other )
	{
		SetADT<T> result = new LinkedSet<T>();

		for( T item: this )
			result.add( item );

		for( T item: other )
			result.add( item );

		return result;
	}


	@Override
	public SetADT<T> intersection( SetADT<T> other )
	{
		SetADT<T> result = new LinkedSet<T>();

		for( T item: this )
			if( other.contains( item ) )
				result.add( item );

		return result;
	}


	@Override
	public boolean contains( T element )
	{
		for( LinearNode<T> current = contents; current != null; current = current.getNext() )
			if( current.getElement().equals( element ) )
				return true;

		return false;
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
		return new LinkedIterator<T>( contents );
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
