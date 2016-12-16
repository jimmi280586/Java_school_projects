package utility.collection;

import java.util.EmptyStackException;

public class LinkedList<T> implements QueueADT<T>
{
	private int count;
	private LinearNode<T> front;
	private LinearNode<T> rear;

	public LinkedList()
	{
		front = new LinearNode<T>(); // Dummy node
		rear = front; // Make rear point to the dummy node
		count = 0;
	}

	@Override
	public void enqueue(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		if(isEmpty())
		{
			front = newNode;
		} else 
		{
			rear.setNext(newNode);
		}
		
		rear = newNode;
		count++;
	}

	@Override
	public T dequeue()
	{
		if(isEmpty())
		{
			throw new EmptyStackException();  // Should be an EmptyCollectionException...
		}
		T currentElement = front.getElement(); // Get the element at the current front node

		front = front.getNext(); // Move to the next node on the queue
		count--;
		
		if(isEmpty()) // Handle the queue now being empty
		{
			rear = front; // Set the rear to the dummy node
		}
		
		return currentElement;
	}

	@Override
	public T first()
	{
		return front.getElement();
	}

	@Override
	public int indexOf(T element) // Shouldn't be in a queue...
	{
		int index = 0; // Start index at 0
		LinearNode<T> current = front; // Start with the first node
		while (current.getNext() != null)
		{
			current = current.getNext(); // Move to the next node
			if (element == null)
			{ // If looking for a null element
				if (current.getElement() == null)
				{ // If the current node has a null element
					return index; // Then return the current index
				}
			} else if (current.getElement() != null
					&& current.getElement().equals(element))
			{ // If the node has a matching element
				return index; // Return the current index
			}
			index++;
		}
		return -1; // If no match, return junk value
	}

	@Override
	public boolean isEmpty()
	{
		return count == 0;
	}

	@Override
	public int size()
	{
		return count;
	}

	@Override
	public String toString()
	{
		String str = "";
		LinearNode<T> current = front; // Start with the first node
		while (current.getNext() != null)
		{
			current = current.getNext(); // Move off of the dummy node
			if (current.getElement() == null)
			{ // If current node has no element
				str += "Empty"; // Report as empty
			} else
			{
				str += current.getElement().toString(); // Otherwise, add element's toString to the string
			}
			str += "\n";
		}
		return str;
	}


}
