package utility.collection;



public abstract interface SetADT<T> 
{
	public void add(T elements);
	public T remove(T elements);
	public boolean contains(T elements);
	public boolean isEmpty();
	public int size();
	public boolean isSubset(SetADT<T> set);
	public SetADT<T> intersection(SetADT<T> set);
}
