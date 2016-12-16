package utility.collection;

public class LinearNode<T>
{
	private T element;
	private LinearNode<T> next;

	public LinearNode()
	{
		element = null;
		next = null;
	}

	public LinearNode(T element)
	{
		this.element = element;
		this.next = null;
	}

	public LinearNode(T element, LinearNode<T> next)
	{
		this.element = element;
		this.next = next;
	}

	public LinearNode<T> getNext()
	{
		return next;
	}

	public void setNext(LinearNode<T> node)
	{
		next = node;
	}

	public T getElement()
	{
		return element;
	}

	public void setElement(T element)
	{
		this.element = element;
	}

}
