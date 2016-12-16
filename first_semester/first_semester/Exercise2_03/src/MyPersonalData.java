import java.util.Scanner;


public class MyPersonalData
{

	public static void main(String[] args)
	{
		// Collect data from the user
		// Print the data back to the user
		// Declare variables
		
		String name, address;
		int age;
		
		// Get a new scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Get info from user
		System.out.println("What is your name?");
		name = keyboard.nextLine();
		
		System.out.println("What is your address?");
		address = keyboard.nextLine();
		
		System.out.println("What is your age?");
		age = keyboard.nextInt();
		
		
		// Print back to user
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Address: " + address);
keyboard.close();
	}

}
