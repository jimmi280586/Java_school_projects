package utillity.collection;

public abstract interface StackADT<T>
{
	
	public abstract T pop();
	public abstract T peek();
	public abstract int indexOf(T element);
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract void push(T element);
}
