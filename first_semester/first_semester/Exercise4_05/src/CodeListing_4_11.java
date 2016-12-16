import java.util.Scanner;


public class CodeListing_4_11 
{
	public static void main(String[] args)
	{
	// Compare three strings
	// Using the correct .equals() method
	// Declare variables
	String name1, name2, name3;
	// Get a scanner object
	Scanner keyboard = new Scanner(System.in);
	// Get a name
	System.out.print("Enter a name: ");
	name1 = keyboard.nextLine();
	// Get a second name
	System.out.print("Enter a second name: ");
	name2 = keyboard.nextLine();
	// Get a third name
	System.out.print("Enter a third name: ");
	name3 = keyboard.nextLine();
	// Compare name1 and name2
	if ( name1.equals(name2))
	{
	System.out.println(name1 + " and " + name2 + " are the same.");
	}
	else
	{
	System.out.println(name1 + " and " + name2 + " are NOT the same.");
	}
	// Compare name1 and name3
	if (name1.equals(name3))
	{
	System.out.println(name1 + " and " + name3 + " are the same.");
	}
	else
	{
	System.out.println(name1 + " and " + name3 + " are NOT the same.");
	}
	}
}
