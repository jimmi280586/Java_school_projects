import java.util.Scanner;


public class Stock
{

	public static void main(String[] args) 
	{
		// See gains and loses made on stock purchases
		// Use user input
		// Declare variables
		int shares;
		double sharePrice, purchaseCommission, sellCommission, purchaseAmount, sellAmount;
		
		// Get a scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Joe purchases shares
		// Get shares purchased from the user
		System.out.println("Shares purchased?");
		shares = keyboard.nextInt();
		
		// Get purchase price from the user
		System.out.println("Purchase price?");
		sharePrice = keyboard.nextDouble();
		
		// Commission is 2%
		// Get commission
		purchaseCommission = 0.02 * (shares * sharePrice);
		
		// Get total price of purchase
		purchaseAmount = shares * sharePrice;
		
		// Joe sells shares
		// Get shares sold from the user
		System.out.println("Shares sold?");
		shares = keyboard.nextInt();
		
		// Get sell price from the user
		System.out.println("Sell price?");
		sharePrice = keyboard.nextDouble();
		
		// Commission is 2%
		// Get commission
		sellCommission = 0.02 * (shares * sharePrice);
		
		// Get total price of sale
		sellAmount = shares * sharePrice;
		
		// Print results
		System.out.println("Amount of money paid for stock: " + purchaseAmount);
		System.out.println("Amount of commission paid at purchase: " + purchaseCommission);
		System.out.println("Amount of money made at sale: " + sellAmount);
		System.out.println("Amount of commission paid at sale: " + sellCommission);
		// Find profit
		System.out.println("Amount of profit made: " + ((sellAmount - sellCommission) - (purchaseAmount + purchaseCommission)));
	}

}
