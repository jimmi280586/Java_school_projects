package utility.collection;

public class LinkedList<T> implements ListADT<T>
{
	private int count;
	private LinearNode<T> front;

	public LinkedList()
	{
		front = new LinearNode<T>(); // Dummy node
		count = 0;
	}

	public LinearNode<T> getNode(int index)
	{
		LinearNode<T> current = front; // Start at front node
		for (int i = -1; i < index; i++)
		{
			current = current.getNext(); // cycle through nodes
		}
		return current;
	}

	@Override
	public void add(int index, T element)
	{
		if (index < 0 || index > count)
		{
			throw new IndexOutOfBoundsException();
		}

		LinearNode<T> previous = getNode(index - 1);
		LinearNode<T> newNode = new LinearNode<T>(element, previous.getNext());
		previous.setNext(newNode);
		count++;
	}

	@Override
	public void add(T element)
	{
		LinearNode<T> current = front;
		while (current.getNext() != null)
		{
			current = current.getNext();
		}
		current.setNext(new LinearNode<T>(element));
		count++;
		
		/*
		 * Can be one-lined:
		 * add(count, element);
		 */
	}

	@Override
	public void set(int index, T element)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		getNode(index).setElement(element);
	}

	@Override
	public T get(int index)
	{
		if(index < 0)
		{
			throw new IndexOutOfBoundsException();
		}
		return getNode(index).getElement();
	}

	@Override
	public T remove(int index)
	{
		if(index < 0 || index >= count) // Account for bad arguments
		{
			throw new IndexOutOfBoundsException();
		}
		LinearNode<T> previous = getNode(index - 1); // Get the node right before the one we want to delete
		LinearNode<T> nodeToDelete = previous.getNext(); // Get the node we want to delete
		previous.setNext(nodeToDelete.getNext()); // Set the previous node to point to the node after the one we want to delete
		nodeToDelete.setNext(null); // Remove the deleted node's pointer

		count--;
		return nodeToDelete.getElement(); // Return the element at the deleted node
	}

	@Override
	public T remove(T element)
	{
		T elementToRemove = null;
		int index = indexOf(element);

		if (index > -1)
		{
			elementToRemove = remove(index);
		}

		return elementToRemove;
	}

	@Override
	public int indexOf(T element)
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
	public boolean contains(T element)
	{
		return indexOf(element) != -1;
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
