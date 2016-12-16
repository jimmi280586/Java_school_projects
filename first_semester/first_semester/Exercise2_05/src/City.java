import java.util.Scanner;


public class City 
{

	public static void main(String[] args)
	{

		// Using String methods
		// Declare variables
		
		String city, upperName, lowerName;
		int cityLength;
		char firstChar;
		
		// Get a scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Get a city name from the user
		System.out.println("What is your favorite city?");
		city = keyboard.nextLine();
		
		// Set values using String methods
		// Set whole name to upper case
		upperName = city.toUpperCase();
		
		// Set whole name to lower case
		lowerName = city.toLowerCase();
		
		// Get the length of the name
		cityLength = city.length();
		
		// Get the first character in the name
		firstChar = city.charAt(0);
		
		// Print the results using string concatenation
		System.out.println("Number of characters in " + city + ": " + cityLength);
		System.out.println(city + " in upper case: " + upperName);
		System.out.println(city + " in lower case: " + lowerName);
		System.out.println("First character in " + city + ": " + firstChar);

	}

}
