import java.util.Scanner;


public class CodeListing_4_2
{

	public static void main(String[] args)
	{
		 // Find the quotient of two numbers
		// Get numbers from user
		// Make a scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Declare variables
		int number1, number2;
		double quotient;
		
		// Get the two numbers
		System.out.println("Enter an integer: ");
		number1 = keyboard.nextInt();
		
		System.out.println("Enter another integer: ");
		number2 = keyboard.nextInt();
		
		// Prevent against divide by zero errors
		if (number2 == 0)
		{
		System.out.println("Please don't divide by zero!");
		}
		else
		{
		
		// Cast to a double, to avoid integer division
		quotient = (double) number1 / number2;
		
		// Print the result
		System.out.println("Quotient is: " + quotient);
		}

	}

}
