package domain.model;

public class LinearNode<T> 
{
	private T element;
	private LinearNode<T> next;

	public LinearNode() 
	{
		this.element = null;
		this.next = null;
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
		return this.next;
	}
	
	public void setNext(LinearNode<T> node) 
	{
		this.next = node;
	}
	
	public T getElement() 
	{
		return this.element;
	}
	
	public void setElement(T element) 
	{
		this.element = element;
	}


}
