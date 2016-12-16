package utility.collection;

public class LinkedSet<T> implements SetADT<T> 
{
	private int count;
	private LinearNode<T> front;

	public LinkedSet()
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

	private T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T element)
	{
		LinearNode<T> current = front; // Start with the first node
		while (current.getNext() != null)
		{
			current = current.getNext(); // Move to the next node
			if (element == null)
			{ // If looking for a null element
				if (current.getElement() == null)
				{ // If the current node has a null element
					return true; // Then return the current index
				}
			} else if (current.getElement() != null
					&& current.getElement().equals(element))
			{ // If the node has a matching element
				return true; // Return the current index
			}
		}
		return false; // If no match, return junk value
	}

	@Override
	public boolean isEmpty()
	{
		return this.count == 0;
	}

	@Override
	public int size()
	{
		return this.count;
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

	@Override
	public boolean isSubset(SetADT<T> set) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SetADT<T> intersection(SetADT<T> set) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
