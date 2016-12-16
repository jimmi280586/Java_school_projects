import java.util.Scanner;


public class TimeCalculator 
{
	public static void main(String[] args)
	{
	// Get a seconds value from user
	// Convert it to other time measurements
	// Get a scanner object
	Scanner keyboard = new Scanner(System.in);
	// Declare variables
	double seconds, minutes, hours, days;
	// Find number of seconds
	System.out.println("How many seconds?");
	seconds = keyboard.nextDouble();
	// if more than 60 seconds, return number of minutes
	if (seconds >= 60)
	{
	minutes = seconds / 60;
	System.out.println("Number of minutes: " + minutes);
	}
	// if more than 3600 seconds, return number of hours
	if (seconds >= 3600)
	{
	hours = seconds / 3600;
	System.out.println("Number of hours: " + hours);
	}
	// if more than 86,400 seconds, return number of days
	if ( seconds >= 86400)
	{
	days = seconds / 86400;
	System.out.println("Number of days: " + days);
	}
	}
}
