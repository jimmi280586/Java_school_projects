import java.util.Scanner;


public class Sum 
{

	public static void main(String[] args)
	{
		// Get values from the user
		// Print the sum and product of the values
		// Declare variables
		
		int a,b,c;
		
		// Get a scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Get values from user
		System.out.println("Value for A:");
		a = keyboard.nextInt();
		
		System.out.println("Value for B:");
		b = keyboard.nextInt();
		
		System.out.println("Value for C:");
		c = keyboard.nextInt();
		
		// Print the sum - doing maths in the statement
		System.out.println("Sum: " + (a+b+c));
		
		// Print the product - also doing maths in the statement
		System.out.println("Product: " + (a*b*c));
keyboard.close();
	}

}
