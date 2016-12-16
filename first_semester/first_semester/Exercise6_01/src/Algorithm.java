import java.util.Scanner;


public class Algorithm {

	public static void main(String[] args) {

		// Write a do-while loop that asks for two numbers
		// Numbers should be added and sum displayed
		// Ask user if they want to repeat process
		Scanner key = new Scanner(System.in);
		int num1, num2;
		char userConfirmation = 'y';
		do
		{
		System.out.println("Give me a first number!");
		num1 = key.nextInt();
		System.out.println("Give me a second number, such that I will add it to the first!");
		num2 = key.nextInt();
		System.out.println("Sum of " + num1 + " and " + num2 + " is: " + (num1 + num2));
		key.nextLine();
		System.out.println("Would you like to go again?");
		userConfirmation = key.nextLine().toLowerCase().charAt(0);
		} while (userConfirmation == 'y');
		System.out.println("Thank you for playing!");
	}

}
