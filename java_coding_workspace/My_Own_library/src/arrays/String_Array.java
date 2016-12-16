package arrays;

public class String_Array
{
	 // prints the string s reverse; e.g if s = "abcd", the method prints "dcba"
	  public static String printString(String s)
	  {
		  System.out.println("Now examining " + s);
		     if (s.length() <= 1)
		     {
		       return s;                                     // stopping case
		     }
		     else
		     {
		       return printString(s.substring(1)) + s.charAt(0); // recursion
		     } 
	  }
	  
	  /**
		 * finds every way the given string can be written in
		 * beginning strin should be "" when called
		 * @param beginningString
		 * @param endingString
		 */
		 public static void permuteString(String beginningString, String endingString) {
			    if (endingString.length() <= 1)
			      System.out.println(beginningString + endingString);
			    else
			      for (int i = 0; i < endingString.length(); i++) {
			        try {
			          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

			          permuteString(beginningString + endingString.charAt(i), newString);
			        } catch (StringIndexOutOfBoundsException exception) {
			          exception.printStackTrace();
			        }
			      }
			  }
}
