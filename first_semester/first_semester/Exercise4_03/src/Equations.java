import java.util.Scanner;


public class Equations
{

	   public static void main(String[] args)
	   {
	      Scanner input = new Scanner(System.in);
	      System.out.print("Give the a variable: ");
	      double a = input.nextDouble();
	     
	      System.out.print("Give the b variable: ");
	      double b = input.nextDouble();
	     
	      System.out.print("Give the c variable: ");
	      double c = input.nextDouble();
	      
	     double D = b * b - (4 * a * c);
	     double solution1 = (-(b/(2 * a)));
	     double div_one = (2 * a);
	     double div_two = ( -b + Math.sqrt(D) );
	     double div_tre = ( -b - Math.sqrt(D) );
	     double solution2 = ( div_two / div_one );
	     double solution3 = ( div_tre / div_one );
	     
	     if (D < 0)
	      {
	         System.out.println("No solutions");
	      }
	      
	     else if (D == 0)
	      {
	         System.out.println("x = " + solution1);   
	      }
	     
	     else if (D > 0)
	      {
	         System.out.println("x = " + solution2 + " and x = " + solution3); 
	         
	      }       
	   }

}
