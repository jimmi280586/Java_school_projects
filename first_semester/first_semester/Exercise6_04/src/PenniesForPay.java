import java.text.DecimalFormat;
import java.util.Scanner;


public class PenniesForPay {
	
	public static void main(String[] args)
	{
	// Calculate how much a person would earn
	// If they made one penny the first day,
	// And double that for each consecutive day
	// For n days
	Scanner key = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("#.##");
	double dailyPay, totalPay;
	int days;
	totalPay = 0.0;
	System.out.println("How many days?");
	days = key.nextInt();
	// Require that days is greater than 0
	while(days < 0)
	{
	System.out.println("Give me a number greater than 0!");
	days = key.nextInt();
	}
	for (double i = 0; i <= days; i++)
	{
	dailyPay = 0.01 * (Math.pow(2, i));
	totalPay += dailyPay;
	System.out.println("*****");
	System.out.println("Daily pay is: " + df.format(dailyPay));
	System.out.println("Current total pay is: " + df.format(totalPay));
	}
	System.out.println("***** Total pay is: " + df.format(totalPay) + " *****");
	}

}
