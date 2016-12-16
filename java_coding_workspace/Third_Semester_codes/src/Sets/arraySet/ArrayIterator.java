/**
 * General array iterator (reworked from Lewis & Chase)
 *
 * 06.02.2016 Original version
 */


package arraySet;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayIterator<T>
	implements Iterator<T>
{
	private T[] items;
	private int size;
	private int next = 0;


	public ArrayIterator( T[] items, int size )
	{
		this.items = items;
		this.size = size;
	}


	@Override
	public boolean hasNext()
	{
		return next < size;
	}


	@Override
	public T next()
		throws NoSuchElementException
	{
		if( !hasNext() )
			throw new NoSuchElementException();

		return items[next++];
	}


	@Override
	public void remove()
		throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}
