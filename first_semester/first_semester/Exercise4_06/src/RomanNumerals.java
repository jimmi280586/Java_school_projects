import java.util.Scanner;


public class RomanNumerals 
{
	public static void main(String[] args)
	{
	// Get a number from user, from 1-10
	// Convert number to roman numerals
	// Use a switch statement
	// Get a scanner object
	Scanner keyboard = new Scanner(System.in);
	// Declare variables
	int number;
	String numeral;
	// Get number from user
	System.out.println("Enter a number from 1-10");
	number = keyboard.nextInt();
	// Start switch statement
	switch (number)
	{
	case 1:
	numeral = "I";
	break;
	case 2:
	numeral = "II";
	break;
	case 3:
	numeral = "III";
	break;
	case 4:
	numeral = "IV";
	break;
	case 5:
	numeral = "V";
	break;
	case 6:
	numeral = "VI";
	break;
	case 7:
	numeral = "VII";
	break;
	case 8:
	numeral = "VIII";
	break;
	case 9:
	numeral = "IX";
	break;
	case 10:
	numeral = "X";
	break;
	default:
	numeral = ""; // Basically, sets to a null value
	}
	// If numeral was between 1-10, print result
	// Use String method for equals instead of ==
	if (!numeral.equals(""))
	System.out.println("Corresponding numeral to " + number + " is: " + numeral);
	else
	{
	// Otherwise, print an error
	System.out.println("Error! Not between 1-10");
	}
	}

}
