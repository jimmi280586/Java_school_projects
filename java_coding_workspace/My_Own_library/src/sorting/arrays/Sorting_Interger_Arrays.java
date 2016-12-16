package sorting.arrays;

import java.util.Arrays;


public class Sorting_Interger_Arrays 
{
	/**
	 * a method for swaping intergers in Arrays
	 * @param A = the array of intergers
	 * @param i the first paramater you want to swap 
	 * @param j the second parameter you want to swap
	 */
	private static void swap(int[] A, int i, int j) 
	{
		  int temp = A[i];
		  A[i] = A[j];
		  A[j] = temp;		
	}
	
	/**
	 * this is a sorting method for sorting intergerArrays using insertion
	 * @param A = the array of intergers
	 */
	public static void insertionSort (int[] A)
	{
		int i = 1;
		int n = A.length;
		while (i <= n-1) 
		{
		 int idx = i; 
		 putIntoRightPlace ( A, idx ); 
		 i++;
		}
	}
	
	/**
	 * this is a sorting method for sorting interger arrays using bubblesort
	 * @param A = the array of intergers
	 */
	public static void bubbleSort (int[] A)
	{
		int index = 0;
		int n = A.length;
		
		while (index < n-1) 
		{
			bubbleDownTo (A, index); 
		
			index++;
		}
	}

	/**
	 * a method for testing is the interger array is sorted
	 * it does so by creating another array and sorting that one an comparing the two
	 * @param A = the interger array allready sorted
	 * @return true if the array is sorted
	 */
	public static boolean isSorted(int[] A)
	{
		for (int i = 0; i < A.length - 1; i++)
		{
			if(A[i] > A[i + 1])
				return false;
		}
		
		return true;		
	}
	
	/**
	 * a method to test if two interger arrays have the same numbers
	 * but in diffrent order is does this by first checking to se
	 * if they have the same length and then it sorts them
	 * after that is checks if they have the same numbers
	 * @param A = interger array number 1
	 * @param B = interger array number 2
	 * @return true if they are the same
	 */
	public static boolean isAPermutation(int[] A, int[] B)
	{
		if(A.length != B.length)
			return false;
		else
			sort(A);
			sort(B);
			for (int i = 0; i < B.length; i++)
			{
				if(A[i] != B[i])
					return false;
			}
		return true;
	}	
	
	/**
	 * private method used in the permutation method
	 * @param A = interger array
	 * @param i
	 */
	private static void putIntoRightPlace(int [] A, int i)
	{       
            int temp = A[i];
            int j = i;
            while (j > 0 && A[j - 1] > temp)
            {
                A[j] = A[j - 1];
                j--;
            }
            A[j] = temp;        
	}
	
	/**
	 * private method used in bubblesort method
	 * @param A = interger array
	 * @param i
	 */
	private static void bubbleDownTo (int[] A, int i)
	{
		for (int j = A.length - 1; j > i; j--)
		{
			if (A[j] < A[j - 1])
				swap(A, j, j - 1 );
		}
			     
	}
	
	/**
	 * my own method for sorting interger arrays using Array.sort
	 * @param table = interger array
	 */
	private static void sort(int[] table)
	  {
		  Arrays.sort(table, 0, table.length);		
	  }
}
