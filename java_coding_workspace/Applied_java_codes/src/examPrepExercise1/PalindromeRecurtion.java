package examPrepExercise1;
public class PalindromeRecurtion
{
	public static boolean isRecPalindrome(char[] A, int left, int right)
	{							
			if(left >= right)			
				return true;			
			if(A[left] != A[right])
				return false;			
			else				
				return isRecPalindrome(A, ++left, --right);		
	}
	
	public static void main(String[] args)
	{
		String a = "level";
		String c = "desd";
		char[] d = c.toCharArray();
		char[] b = a.toCharArray();
		
		System.out.println(isRecPalindrome(b, 0, b.length-1));
		System.out.println();
		System.out.println(isRecPalindrome(d, 0, d.length-1));
	}
}
