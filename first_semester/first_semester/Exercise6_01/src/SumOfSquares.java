import java.util.Scanner;


public class SumOfSquares {

	public static void main(String[] args) {

		// Write a for loop
		// Take in a number n
		// Loop should sum all the squares between 1 and n
		Scanner key = new Scanner(System.in);
		int n;
		long sum = 0;
		System.out.println("Give me a number, I'll give you the sum of the squares up to that number!");
		n = key.nextInt();
		for (int i = 1; i <= n; i++)
		{
		System.out.println("Current process: " + i + ": " + Math.pow(i, 2));
		sum += Math.pow(i, 2);
		}
		System.out.println("Sum of squares from 1 to " + n + " is: " + sum);

	}

}
