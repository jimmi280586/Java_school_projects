/**
 * Array implementation of the minheap abstract data type
 *
 * 03.04.2016 Original version
 */


package heap;

import exceptions.EmptyCollectionException;

/**
 * Array implementation of the minheap abstract data type
 *
 * @param <T> Generic type for the values stored in the tree
 */

public class ArrayMinHeap<T extends Comparable<T>>
	implements MinHeapADT<T>
{
	private static final int DEFAULT_CAPACITY = 100;

	private Object[] nodes;
	private int count = 0;


	public ArrayMinHeap()
	{
		this( DEFAULT_CAPACITY );
	}


	public ArrayMinHeap( int initialCapacity )
	{
		nodes = new Object[initialCapacity];
	}


	protected int left( int index )
	{
		return 2 * index + 1;
	}


	protected int right( int index )
	{
		return 2 * index + 2;
	}


	protected int parent( int index )
	{
		return ( index - 1 ) / 2;
	}


	@Override
	public void addElement( T element )
	{
		if( size() == nodes.length )
			expandCapacity();

		int current = count;

		while( current > 0 && ((T)nodes[parent(current)]).compareTo( element ) > 0 ) {
			nodes[current] = nodes[parent(current)];
			current = parent(current);
		}

		nodes[current] = element;
		++count;
	}


	@Override
	public T removeMin()
		throws EmptyCollectionException
	{
		T result = findMin();
		count--;
		T element = (T)nodes[count];
		nodes[count] = null;
		int current = 0;

		for(;;)
			if( right(current) < count ) {
				// current has both a left and right child
				if( ((T)nodes[left(current)]).compareTo( ((T)nodes[right(current)]) ) < 0 ) {
					// left child smaller than right child
					if( ((T)nodes[left(current)]).compareTo( element ) < 0 ) {
						nodes[current] = nodes[left(current)];
						current = left(current);
					} else {
						nodes[current] = element;

						return result;
					}
				} else {
					// right child larger than left child
					if( ((T)nodes[right(current)]).compareTo( element ) < 0 ) {
						nodes[current] = nodes[right(current)];
						current = right(current);
					} else {
						nodes[current] = element;

						return result;
					}
				}
			} else if( left(current) < count ) {
				// current only has a left child
				if( ((T)nodes[left(current)]).compareTo( element ) < 0 ) {
					nodes[current] = nodes[left(current)];
					current = left(current);
				} else {
					nodes[current] = element;

					return result;
				}
			} else {
				nodes[current] = element;

				return result;
			}
	}


	@Override
	public T findMin()
		throws EmptyCollectionException
	{
		if( size() == 0 )
			throw new EmptyCollectionException( "ArrayMinHeap.findMin()" );

		return (T)nodes[0];
	}


	@Override
	public int size()
	{
		return count;
	}


	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}


	protected void expandCapacity()
	{
		// Create a new array of double size and copy all elements from the old to the new array

		Object[] newNodes = new Object[2 * nodes.length];

		for( int i = 0; i < nodes.length; ++i )
			newNodes[i] = nodes[i];

		// Let the new array be the contents

		nodes = newNodes;
	}


	@Override
	public String toString()
	{
		String res = "";

		for( int i = 0; i < count; ++i )
			res += " " + nodes[i];

		return res;
	}
}
