package utility.collection;

public abstract interface QueueADT<T> 
{
	public void enqueue(T elements);
	public T dequeue();
	public T first();
	public int indexOf(T elements);
	public boolean isEmpty();
	public int size();
}
