package arrays;

import java.util.Arrays;

import interfaces.arrays.Interger_interface;

/**
 * this class helps to control interger arrays with wearies methods
 * @author jimmi
 *
 */
public class interger_Array implements Interger_interface
{
	 private int[] table;  // instantiated in a constructor etc.
	 private int index;    // index is the first free place in the table;
	 private int length;              // it also counts the number of integers in table
	  
	 /**
	  * cunstroctor for making interger arrays
	  * @param length
	  */
	  public interger_Array (int length)
	  {
		this.length = length;  
	    this.table = new int[length];
	    this.index = 0;
	  }
	  
	  /**
	   * The element is inserted on the first free place in the table
	   * Precondition:  The table is not full
	   * Postcondition: The element has been inserted and now the table is not empty
	   * @param element The element to insert 
	   */
	  public void insert (int element)
	  {		 
			  this.table[index++] = element;		 
	  }
	  
	  /**
	   * removes the last interger entered into the array
	   */
	  public void removeLast()
	  {
		  this.index --;
	  }
	  
	  /**
	   * removes the interger from index parameter and replaces it with the last
	   * interger from the array
	   * @param index
	   */
	  public void removeIndex(int index)
	  {
		  this.table[index] = this.table[this.index-1];
		  this.index--;
	  }
	  
	  /**
	   * removes the given value parameter from the array and replaces it with the last
	   * index in the array
	   * @param value you want to remove
	   */
	  public void remove(int value)
	  {
		  for (int i = 0; i < size(); i++)
		  {
			if (this.table[i] == value)
			{			
				this.table[i] = this.table[index-1];
				index--;
				break;
			}
		  }
	  }
	  
	  /**
	   * removes all instances of the given value from the array 
	   * and replacec them with the last indexes from the array
	   * @param value you want to remove
	   */
	  public void removeAll(int value)
	  {
		  for (int i = 0; i < size(); i++)
		  {
			if (this.table[i] == value)
			{	
				if(this.table[index-1] == value)
				{
					index--;
				}
				this.table[i] = this.table[index-1];
				index--;
			}
		  }
	  }
	  
	  @Override
	  public int findIndex(int value)
	  {
		  for (int i = 0; i < size(); i++)
		  {
			if (this.table[i] == value)
			{
				return i;
			}
		  }
		  	return 0;
	  }
	  
	  public void sort(int[] table)
	  {
		 int[] sort = table.clone(); 
		 Arrays.sort(sort, 0, sort.length);
		
	  }
	  

	  public boolean isEmpty()
	  {
			return size() == 0;
	  }
	  
	  public boolean isFull()
	  {
		  return this.length == size();
	  }
	  
	  @Override
	  public int getMax()
	  {
		  int max = this.table[0];
		  for (int i = 1; i < size(); i++) 
		  {		  
			  if(this.table[i] > max)
			  {
				  max = this.table[i];
			  }
		  }
		  return max;
	  }
	  
	  @Override
	  public int getMin()
	  {
		  int min = this.table[0];
		  for (int i = 1; i < size(); i++) 
		  {
			if (this.table[i] < min)
			{
				min = this.table[i];
			}
		  }
		  return min;
	  }

	  public int howMany(int value)
	  {
		  int count = 0;
		  for (int i = 0; i < size(); i++)
		  {
			if(this.table[i] == value)
			{
				count++;
			}
		  }
		  return count;
	  }
	  
	  public double mean()
	  {
		  int sum = 0;
		  double mean;
		  for (int i = 0; i < size(); i++)
		  {
			sum += this.table[i];
		  }
		  mean = (sum / size()); 
		  return mean;
	  }
	  
	  public String sorttoString()
	  {
		  
		  String table = "";
		  int[] sort = this.table.clone();
		  Arrays.sort(sort, 0, sort.length);
		  for (int i = 0; i < size(); i++)
			{
				table += (sort[i] + " ");
			}
			String print = "[ " + table + "]";
			return print;
	  }
	  
	  public String toString()
	  {
		String table = "";	
		String print = "";
		
			for (int i = 0; i < size(); i++)
			{
				table += (this.table[i] + " ");
			}
			print = "[ " + table + "]";
		return print;
	  }
	 
	 /**
	  * gets you what is stored at the given index parameter
	  * @return what the array holds at the given index number
	  * @param index number 
	  */
	 public int getValue (int index)
	  {
	    return this.table[index];
	  }
	  
	  /**
	   * size tells how many elements are in the table; 
	   * - not the length of the array.
	   * @return the number of elements in the table
	   */
	  public int size ()
	  {
	    return this.index;
	  }
	  
	  /**
	   * length tells how big the array is not what is in it
	   * @return the length of the array
	   */
	  public int length()
	  {
	    return this.table.length;
	  }
	  
	/**
	 * compares two interger arrays against one another
	 * @return true if the arrays are same length and index are the same  
	 */
	@Override
	public boolean compleatlyEqual(int[] obj) 
	{
		if(table.length != obj.length)
			return false;
		else
		{
		for (int i = 0; i < table.length; i++)
		{
			if(table[i] == obj[i])
				continue;
			else
				return false;
		}
		return true;
		}
	}

	
}
