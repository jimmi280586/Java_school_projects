package recursion;

public class Recursive
{

  public static long fac (int n)  // factorial
  {
	  long result;

      if(n == 1)
        return 1;

      result = fac(n - 1) * n;
      
      return result;
  }

  public static int sum (int n)  // 1 + 2 + .. + n
  {
      if (n > 0)
      {
        return n + sum(n - 1);
      }
      else
      {
          return 1;
      }
  }

  public static int product (int n)  // 1 * 2 * .. * n
  {
    return -1;
  }


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

  // prints val in base 2; e.g. if val = 3, 101 is printed
  public static void printInt(int val)
  {
	  if (val < 2)
	  {	        
	        System.out.println(val);
	    } 
	  else 
	  { 
	        printInt(val / 2);
	        printInt(val % 2);
	    }

  }

  // prints val in base; e.g. if base is 16, the value is printed in hexadecimal.
  // Example: val = 19 is printed as A3; base = 2 and value = 19: 10011 is printed
  public static void printInt (int value, int base)
  {

  }
}