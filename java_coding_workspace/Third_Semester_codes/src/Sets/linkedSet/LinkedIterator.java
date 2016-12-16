/**
 * General linked list iterator (reworked from Lewis & Chase)
 *
 * 06.02.2016 Original version
 */


package linkedSet;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedIterator<T>
	implements Iterator<T>
{
	private LinearNode<T> next;


	public LinkedIterator( LinearNode<T> next )
	{
		this.next = next;
	}


	@Override
	public boolean hasNext()
	{
		return next != null;
	}


	@Override
	public T next()
		throws NoSuchElementException
	{
		if( !hasNext() )
			throw new NoSuchElementException();

		T result = next.getElement();
		next = next.getNext();

		return result;
	}


	@Override
	public void remove()
		throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
}
