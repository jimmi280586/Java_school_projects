package examPrepExercise1;
public class PalindromeIteration
{
	public static boolean isPalindrome(char[] A)
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
	
	public static void main(String[] args)
	{
		String a = "level";
		String c = "dead";
		char[] d = c.toCharArray();
		char[] b = a.toCharArray();
		
		System.out.println(isPalindrome(b));
		System.out.println();
		System.out.println(isPalindrome(d));
	}
}
