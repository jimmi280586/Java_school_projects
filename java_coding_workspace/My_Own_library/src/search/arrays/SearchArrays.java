package search.arrays;

public class SearchArrays
{
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
	
	public static int recursiveBinarySearch(int[] t, int key, int first, int last)
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
				return recursiveBinarySearch(t, key, first, mid - 1);			
			else				
				return recursiveBinarySearch(t, key, mid + 1, last);			
		}
	}
}
