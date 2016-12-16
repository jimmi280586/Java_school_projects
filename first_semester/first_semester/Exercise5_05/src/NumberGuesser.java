import java.util.Random;
import java.util.Scanner;


public class NumberGuesser 
{
	public static void main(String[] args) {
	
	// Make a guessing game
	// Use a while loop
	// And if statements
	// Get a scanner object
	Scanner key = new Scanner(System.in);
	// Get a new random number object from Java
	Random random = new Random();
	// Base target value off that Random object (using a built-in method)
	int target = random.nextInt(1000) + 1;
	// Make a junk guess
	int guess = -1;
	
	
	// Loop until guess matches target
	while (guess != target)
	{
	System.out.println("\nMake a new guess!");
	guess = key.nextInt();
	// Process answer
	// Tell user if too high or too low
	if (guess > target)
	{
	System.out.println(guess + " is too high!");
	}
	else if (guess < target)
	{
	System.out.println(guess + " is too low!");
	}
	}
	// If loop ends, it's because user guessed correctly
	System.out.println("\nYou got it! The value was: " + target);
	}
}
