package utility.collection;

public class ArrayQueue<T> implements QueueADT<T>
{
	private static final int DEFAULT_CAPACITY = 100;
	private int front;
	private int count;
	private int rear;
	private T[] queue;
	
	public ArrayQueue() 
	{
		this.front = 0;
		this.count = 0;
		this.rear = 0;
		this.queue = (T[])(new Object[this.DEFAULT_CAPACITY]);
	}
	
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
		
			if(this.rear == this.queue.length && this.front != 0)
			{
				this.rear = 0;
			}
			this.queue[this.rear] = elements;
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
		else
		{
			if(this.front == this.queue.length && this.rear != 0)
			{
				this.front = 0;
			}

		}
		T result = this.queue[this.front];
		this.front ++;
		this.count --;
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
	     
	         for (int i = 0; i < queue.length; i++)
	         {
	            if (element.equals(queue[i]))
	            {
	               return  i;
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
		String result = "";
		for (int i = front; i < count; i++) 
		{
			result += (queue[i] + " ");
		}
		return "[ " + result + "]" ;
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
