package test_04_05_2015.task2;

import java.util.Arrays;

public class sortingTesting 
{
	public static int max(int[] A)
	{
		  int max = A[0];
		  for (int i = 1; i < A.length; i++) 
		  {		  
			  if(A[i] > max)
			  {
				  max = A[i];
			  }
		  }
		  return max;
	}
	
	public static int[] createCountersArray(int[] A)
	{
		int[] B = new int[max(A) + 1];
		Arrays.sort(A);
		int value = A[0];	
		for (int i = 0; i < B.length; i++)
		{
			int count = 0;
			for (int j = 0; j < A.length; j++)
			{
				if(A[j] == value)
					count++;
				else continue;
			}
			value ++;
			B[i] = count;
		}
	
	return B;		
	}
	
	public static void countingSort(int[] A)
	{
		int[] B = createCountersArray(A);
		int[] sorted = new int[20];
		int count;
		int place = 0;
		
		for (int i = 0; i < B.length; i++)
		{			
			count = B[i];
			while(count > 0)
			{
				sorted[place] = i;
				place++;
				count --;
			}
		}
	
		A = sorted;
	}	
	
}
