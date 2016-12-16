//*****************************************************************************
//File name  : IntTable.java.
//Start date : 
//Programmer : Hans So.
//Java       : Java 1.7
//Description: 
//*****************************************************************************
package utillity.problemsolving;

import java.util.Arrays;

public class IntTable
{
 private int[] table;  // instantiated in a constructor etc.
 private int index;    // index is the first free place in the table;
 private int length;              // it also counts the number of integers in table
  
  public IntTable (int length)
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
  
  public void removeLast()
  {
	  this.index --;
  }
  
  public void removeIndex(int index)
  {
	  this.table[index] = this.table[this.index-1];
  }
  
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
	  // not able to figure out why i could not print the array after sorted so did it like this it works for printing
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
  
  int getValue (int index)
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
  
  public int length()
  {
    return this.table.length;
  }
  

  }
  


