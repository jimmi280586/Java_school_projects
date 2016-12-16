package interfaces.arrays;

/**
 * interface for the interger array
 * @author jimmi
 *
 */
public interface Interger_interface 
{
	public void insert(int element);
	public void removeLast();
	public void removeIndex(int index);
	public void remove(int value);
	public void removeAll(int value);
	public int findIndex(int value);
	public void sort(int[] table);
	public boolean isEmpty();
	public int getMax();
	public int getMin();
	public int howMany(int value);
	public double mean();
	public String sorttoString();
	public String toString();
	public int getValue(int index);
	public int size();
	public int length();
	public boolean compleatlyEqual(int[] obj);
	
}
