package binary;

public class BinaryNumber
{
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
}
