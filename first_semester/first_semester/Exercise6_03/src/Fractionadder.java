
public class Fractionadder
{
	public static void main(String[] args)
	{
		// Write a for loop that adds fractions
		// from 1/30 to 30/1
		double sum = 0;
		for (double i = 1; i <= 30; i++)
		{
			sum += (i / (31 - i));
			System.out.println("i is: " + i);
			System.out.println("sum is: " + sum);
		}
		System.out.println("Final sum is: " + sum);
	}
}
