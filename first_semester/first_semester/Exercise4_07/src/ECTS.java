import java.util.Scanner;


public class ECTS 
{
	public static void main(String[] args)
	{
	// Convert an ECTS grade to a 12-scale grade
	// Declare variables
	String ects;
	Integer grade = null; // Using an Integer wrapper, to set a null value
	// Get scanner object
	Scanner keyboard = new Scanner(System.in);
	// Get value from user
	System.out.println("Enter an ECTS grade");
	ects = keyboard.nextLine().toUpperCase();
	// Perform switch statement to match values
	switch (ects)
	{
	case "A":
	grade = 12;
	break;
	case "B":
	grade = 10;
	break;
	case "C":
	grade = 7;
	break;
	case "D":
	grade = 4;
	break;
	case "E":
	grade = 2;
	break;
	case "Fx":
	grade = 0;
	break;
	case "F":
	grade = -3;
	break;
	}
	// If grade was set (isn't still null), return result
	if (grade != null)
	{
	System.out.println("ECTS value: " + ects);
	System.out.println("7-grade equivalent: " + grade);
	}
	else
	{
	// If it wasn't set (still is null), return an error
	System.out.println("Grade: " + ects + " is off of the ECTS scale.");
	}
	}

}
