

public interface ListADT<T> {
	public void add(int index, T element);
	public void add(T element);
	
	public void set(int index, T element);
	public T get(int index);

	public T remove(int index);
	public T remove(T element);
	
	public int indexOf(T element);
	public boolean contains(T element);
	
	public boolean isEmpty();
	public int size();
}
