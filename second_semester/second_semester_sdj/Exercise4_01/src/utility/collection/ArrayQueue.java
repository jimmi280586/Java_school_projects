package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>
{
	
	private int front;
	private int count;
	private int rear;
	private T[] queue;

	public ArrayQueue(int initialCapacity)
	{
		this.front = 0;
		this.count = 0;
		this.rear = 0;
		this.queue = (T[])(new Object[initialCapacity]);
	}

	@Override
	public void enqueue(T elements) 
	{
		// TODO Auto-generated method stub
		if(count == this.queue.length)
		{
			throw new IllegalStateException("queue is full");
		}
		if(elements == null)
		{
			throw new IllegalArgumentException("elements of null is not alowed");
		}
		else
		{
		this.queue[this.rear] = elements;
			if(this.rear == this.queue.length && this.front != 0)
			{
				this.rear = 0;
			}
			this.count ++;
			this.rear ++;
		}
	}

	@Override
	public T dequeue() 
	{
		// TODO Auto-generated method stub
		if(isEmpty() == true)
		{
			throw new IllegalStateException("queue is empty");
			
		}		
		T result = this.queue[this.front];
		this.front ++;
		return result;
	}

	@Override
	public T first() throws IllegalStateException
	{
		// TODO Auto-generated method stub
		
			if(isEmpty() == true)
			{
				throw new IllegalStateException("queue is empty");
				
			}
			
		
		
		return this.queue[this.front];
	}

	@Override
	   public int indexOf(T element)
	   {
	      if (element == null)
	      {
	         for (int i = front - 1; i >= 0; i--)
	         {
	            if (element == (queue[i]))
	            {
	               return front - 1 - i;
	            }
	         }

	      }
	      else
	      {
	         for (int i = front - 1; i >= 0; i--)
	         {
	            if (element.equals(queue[i]))
	            {
	               return front - 1 - i;
	            }
	         }
	      }
	      return -1;
	   }

	@Override
	public boolean isEmpty()
	{		
		return (this.count == 0);
	}

	@Override
	public int size() 
	{
		// TODO Auto-generated method stub
		return this.count;
	}
	
	public String toString()
	{
		return this.queue.toString();
	}
	
	private void expandCapacity()
	{
		T[] larger = (T[])(new Object[this.queue.length * 2]);
	
		for (int i = 0; i < this.queue.length; i++)
		{
			larger[i] = this.queue[i];
		}
		this.queue = larger;
	}

}
