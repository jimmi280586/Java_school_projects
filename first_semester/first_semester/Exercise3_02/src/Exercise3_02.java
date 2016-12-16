import java.util.Scanner;




public class Exercise3_02 
{
	public static void main(String[] args)
	{
	
	// Get numbers from the user
	// Perform actions on them
	// 1. Sort from low to high
	// 2. Find quotient
	// 3. Find the remainder
	// Declare variables
	
		int a,b, high, low;
		
		// Get a scanner object
		Scanner keyboard = new Scanner(System.in);
	
		// Get values from user
	System.out.print("Enter first integer:");
	a = keyboard.nextInt();
	
	System.out.print("Enter second integer:");
	b = keyboard.nextInt();
	
	// Sort
	// Compare two values
	if (a > b)
	
	{
		// a is higher than b
		low = b;
		high = a;
	}
		
	else
	{
		// a is lower than b
		low = a;
		high = b;
	}
	
		// Print result
		System.out.println("Sorted: " + low + ", " + high);
	
		// Print Sum
		System.out.println("Sum: " + (a+b));
	
		// Quotient & Modulo
		if (b != 0)
	{
			// Cast the integer literals to doubles
			// To prevent integer division (e.g. "2/3 => 1")
			System.out.println("Quotient: " + (double) a / b);
			
			// Find remainder using modulo
			System.out.println("Modulo: " + (a % b));
	}
	
		else
	{
			System.out.println("You can't do that!!!");
	}
	}  
}

