package binarySearch;

import java.util.Arrays;


public class Generic_Sorting_Arrays <T extends Comparable<T>>
{
	private static String[] unsortedNames = new String[]
			{"Pankaj", "Paresh", "Ankit", "Sankalp", "Aditya", "Prem", "Rocket", "Singh", "Alabama", "Alaska", "Animal" };
	
	 public static <T extends Comparable<T>> void bubbleSort(T[] elems)
	 {
		int size = elems.length;
		 
		 for (int outerLoopIdx = 0; outerLoopIdx < size; ++outerLoopIdx)
		 {
		     for (int innerLoopIdx = 0; innerLoopIdx < (size - outerLoopIdx - 1); ++innerLoopIdx)
		     {
		        if (elems[innerLoopIdx].compareTo(elems[innerLoopIdx + 1]) > 0) 
		        {
		            T temp = elems[innerLoopIdx];
		            elems[innerLoopIdx] = elems[innerLoopIdx + 1];
		            elems[innerLoopIdx + 1] = temp;
		        }
		     }
	     }
	 }
	 
	    public static <T extends Comparable<T>> void doQuickSort(T[] a)
	    {
	    	if (a == null)
	    	{
	    		throw new IllegalArgumentException("Input Array cannot be null");
	    	}
	    	int length = a.length;
	    	
	    	if (length == 1)
	    		return;
	    	doQuickSort(a, 0, length-1);
	    }

	    /**
	     * Actual quicksort implementation using 
	     * median of 3 partitioning.
	     * @param a an array of Comparable items.
	     * @param left the left index of the subarray.
	     * @param right the right index of the subarray.
	     */
	    private static <T extends Comparable<T>> void doQuickSort(T[] a, int left, int right)
	    {

	    	//Base case
	    	if (left >= right) return;

	    	//Choose the pivot using median of 3 partitioning
	    	//using the following 2 steps
	    	//First step: find the center
	    	int center = (left+right)/2;
	    	//Second step: sort left, center and right
	    	if (a[left].compareTo(a[center]) > 0) 
	    	{
	    		swap(a, left, center);
	    	}
	    	if (a[left].compareTo(a[right]) > 0) 
	    	{
	    		swap(a, left, right);
	    	}
	    	if (a[center].compareTo(a[right]) > 0)
	    	{
	    		swap(a, center, right);
	    	}    
	    	//Third Step: 
	    	//Got the pivot and it is at the center. 
	    	//Move it to the end of the array.
	    	swap(a,center,right-1);
	    	int pivot = right-1;

	    	//Partition the array 
	    	int i = left,j = right - 2;
	    	if (j >= 0) 
	    	{
	    		for(;;) 
	    		{
	    			while (a[i].compareTo(a[pivot])< 0) 
	    			{
	    				i++;
	    			}
	    			while(a[j].compareTo(a[pivot]) > 0)
	    			{
	    				j--;
	    			}
	    			if (i >= j) 
	    				break;
	    			swap(a,i,j);
	    		}
	    	}
	    	//Put the pivot at ith position of the array
	    	swap(a,i,right-1); 
	    	//Now all the elements to the right of i are less than 
	    	//it and all the elements to the left of i are greater
	    	//than it. So partition the array and 
	    	//recursively call quicksort on the left and right partition
	    	doQuickSort(a, left, i-1);
	    	doQuickSort(a, i+1, right);

	    }
	    
	    public static <T extends Comparable<T>> void insertionSort(T[] elems) 
	    {
	    	int size = elems.length;
	    	 
	    	for (int outerLoopIdx = 1; outerLoopIdx < size; ++outerLoopIdx)
	    	{
	    	   for (int innerLoopIdx = outerLoopIdx; innerLoopIdx > 0; --innerLoopIdx)
	    	   {
	    	     if (elems[innerLoopIdx - 1].compareTo(elems[innerLoopIdx]) > 0)
	    	     {
	    	        T temp = elems[innerLoopIdx - 1];
	    	        elems[innerLoopIdx - 1] = elems[innerLoopIdx];
	    	        elems[innerLoopIdx] = temp;
	             }
	    	   }
	    	}
	    }
	    
	    public static <T extends Comparable<T>> void selectionSort(T[] list)
	    {
	        for(int i=0; i<list.length -1; i++)
	        {
	            int iSmallest = i;

	            for(int j=i+1; j<list.length; j++)
	            {
	                if(list[iSmallest].compareTo((list[j])) > 0  )
	                {
	                    iSmallest = j;
	                }
	            }
	           swap(list, iSmallest, i);
	        }
	    }
	    
	    public static <T extends Comparable> boolean isSorted(T[] data) 
	    {
	        for (int i = 1; i < data.length; i++) 
	        {
	            if (data[i - 1].compareTo(data[i]) > 0) 
	            {
	                return false;
	            }
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
		public static <T extends Comparable<T>> boolean isAPermutation(T[] A, T[] B)
		{
			if(A.length != B.length)
				return false;
			else
				Arrays.sort(A);
				Arrays.sort(B);
				for (int i = 0; i < B.length; i++)
				{
					if(A[i] != B[i])
						return false;
				}
			return true;
		}	

	/**
	* Internal method to swap to elements in an array.
	* @param a an array of objects.
	* @param left the index of the first object.
	* @param right the index of the second object.
	*/
	private static <T extends Comparable<T>> void swap(T[] a, int left, int right)
	{
		T temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

		//Test it
	private void testGenericQuickSorting()
	{
		Integer[] input = {5,14,16,2,17,1,8,6,0,9};
		doQuickSort(input);
		printArray(input);
		System.out.println(isSorted(input));
		String[] str = new String[]{"adc","abc", "acd", "aaa"};
		doQuickSort(str);
		printArray(str);
		System.out.println(isSorted(str));
	}

	/**
	 * Internal method to print the elements in an array.
	 * @param a an array of objects.
	 */
	public static <T extends Comparable<T>> void printArray(T[] a)
	{
		for (T elem: a) 
		{
			System.out.println(elem);
		}
	}
	 
	 private void testGenericSelectionSorting()
	 {
		 Generic_Sorting_Arrays<String> bs = new Generic_Sorting_Arrays<>();
		 
	        System.out.println("Original Array: ");
	        bs.printArray(unsortedNames);

	        bs.selectionSort(unsortedNames);
	        System.out.println("\nSelection sort:");
	        bs.printArray(unsortedNames);
	 }
	
	 private void testGenericBubbleSorting()
	 {
		Generic_Sorting_Arrays<String> bs = new Generic_Sorting_Arrays<>();
		bs.bubbleSort(unsortedNames);
		for (int i = 0; i < unsortedNames.length; i++)
		{
			System.out.println(unsortedNames[i]);
		}
	 }
	 
	 private void testGenericInsertionSorting()
	 {
		Generic_Sorting_Arrays<String> bs = new Generic_Sorting_Arrays<>();
		bs.insertionSort(unsortedNames);
		for (int i = 0; i < unsortedNames.length; i++)
		{
			System.out.println(unsortedNames[i]);
		}
	 }
	 
	 public static void main(String[] args)
	 {
		 Generic_Sorting_Arrays<String> bs = new Generic_Sorting_Arrays<>();
		// bs.testGenericBubbleSorting();
		 bs.testGenericQuickSorting();
		// bs.testGenericInsertionSorting();
		// bs.testGenericSelectionSorting();
	 }
}
