package interfaces.arrays;

/**
 * interface for double array
 * @author jimmi
 *
 */
public interface Double_interface
{
	public void insert(double element);
	public void removeLast();
	public void removeIndex(int index);
	public void remove(double value);
	public void removeAll(double value);
	public int findIndex(double value);
	public void sort(double[] table);
	public boolean isEmpty();
	public double getMax();
	public double getMin();
	public int howMany(double value);
	public double mean();
	public String sorttoString();
	public String toString();
	public double getValue(int index);
	public int size();
	public int length();
	public boolean compleatlyEqual(double[] obj);
}
