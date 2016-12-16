package binary;
public class Recursion
{
	public static int binSearchRecurtion(int[] t, int key, int first, int last)
	{
		int mid;
		if(last < first)
			return -1;
		else
		{
			mid = first + (last - first)/2;			
			if(t[mid] == key)
				return mid;
			else if(key < t[mid])				
				return binSearchRecurtion(t, key, first, mid - 1);			
			else				
				return binSearchRecurtion(t, key, mid + 1, last);			
		}
	}
	
	public static int IterativeBinarySearch(int[] array, int key, int left, int right)   
	{  	   
	    while (left <= right)   
	    {  	      
	        int index = (left + right) / 2;  	          
	       
	        if (key < array[index])  
	        {  	           
	            right = index - 1;  
	        }  	        
	        else if (key > array[index])  
	        {  	          
	            left = index + 1;  
	        }  	       
	        else  
	        {  
	            return index;  
	        }  
	    }  	    
	    return -1;  
	}  	  
	
	public static void main(String[] args)  
	{  
	    //Input array (already sorted)  
	    int A[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};  	
	    
	    System.out.println("binary search iteration");
	    System.out.println(IterativeBinarySearch(A, 6, 0, 9)); // returns 5
	    System.out.println(IterativeBinarySearch(A, -6, 0, 9)); // returns -1
	    System.out.println();
	    System.out.println("binary search recurtion");
	    System.out.println(binSearchRecurtion(A, 5, 0, 9));// returns 4
	    System.out.println(binSearchRecurtion(A, -5, 0, 9));// returns -1
	}
}
