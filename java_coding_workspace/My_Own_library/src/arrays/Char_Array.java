package arrays;

public class Char_Array 
{
	public static boolean iterativIsPalindrome(char[] A)
	{						
			int left = 0;
			int right = A.length-1;
					
				 while(left < right)
				 {					
					 if(A[left] != A[right])					
						 return false;
					 
					 left++;
					 right--;
				 }
				 return true;
	}
	
	public static boolean recursiveIsPalindrome(char[] A, int left, int right)
	{							
			if(left >= right)			
				return true;			
			if(A[left] != A[right])
				return false;			
			else				
				return recursiveIsPalindrome(A, ++left, --right);		
	}
}
