package utillity.collection;

public class ArrayStack<T> implements StackADT<T>
{
	private final int DEFAULT_CAPCITY = 100;
	private int top;
	private T[] stack;
	
	public ArrayStack()
	{
		this.top = 0;
		this.stack = (T[])(new Object[DEFAULT_CAPCITY]);
	}
	
	public ArrayStack(int initialCapacity)
	{
		this.top = 0;
		this.stack = (T[])(new Object[initialCapacity]);
	}
		
	@Override
	public void push(T element)
	{
		if(size() == this.stack.length)
		{
			expandCapacity();
		}
		else
		{
			this.stack[this.top] = element;
			this.top++;
		}
		
	}

	@Override
	public T pop()
	{
		if(isEmpty())
		{
			System.out.println("empty");;
		}
		
			this.top --;
			T result = this.stack[this.top];
			this.stack[this.top] = null;
			
			
		
		return result;
		
	}

	@Override
	public T peek()
	{
		if(isEmpty())
		{
			System.out.println("empty");;
		}
		return this.stack[top-1];
	}

	@Override
	public int indexOf(T element) 
	{
		for (int i = 0; i < this.stack.length; i++)
		{
			if(this.stack[i].equals(element))
			{
				return i;
			}
		}
		return -1;
	}	

	@Override
	public boolean isEmpty()
	{
		if(this.top == 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size()
	{		
		return (this.top - 1);
	}
	
	public String toString()
	{
		return this.stack.toString();
	}
	
	private void expandCapacity()
	{
		T[] larger = (T[])(new Object[this.stack.length * 2]);
	
		for (int i = 0; i < this.stack.length; i++)
		{
			larger[i] = this.stack[i];
		}
		this.stack = larger;
	}

}
