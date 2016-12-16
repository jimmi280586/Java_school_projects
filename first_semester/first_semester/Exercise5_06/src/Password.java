import java.util.Scanner;


public class Password {

	public static void main(String[] args) {
		 // Get a username and a password from the user
		// Make the user confirm the password
		// Password must match confirmation
		// Get a new scanner object
		Scanner key = new Scanner(System.in);
		// Declare variables
		String username, password, passwordConfirmation;
		// Initialize password and passwordConfirmation to junk values
		passwordConfirmation = "";
		password = " ";
		// Get a username from the user
		System.out.println("Give me a username!");
		username = key.nextLine();
		// Use a loop to ensure password equals confirmation before continuing
		while (!password.equals(passwordConfirmation)) // Passwords must match
		{
		// Generic message works at start of loop and as error message
		// Obviously this isn't very robust
		System.out.println("\nPassword and confirmation need to match\n");
		// Get a password
		System.out.println("Give me a new password!");
		password = key.nextLine();
		// Get a confirmation
		System.out.println("Confirm that password!");
		passwordConfirmation = key.nextLine();
		}
		// Print results
		System.out.println("\nUsername: " + username);
		System.out.println("Password: " + password);

	}

}
