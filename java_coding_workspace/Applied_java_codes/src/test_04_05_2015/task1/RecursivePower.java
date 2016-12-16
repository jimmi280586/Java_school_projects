package test_04_05_2015.task1;

public class RecursivePower 
{
	public static double power(double x, int n)
	{
		if (n == 0)
			return 1.0;//base case
		else
			return x * power(x, n-1);
	}
	
	public static double power2(double x, int n)
	{
		if(n == 0)
			return 1.0; // base case
		else if(n % 2 == 0)
			return x * x * power2(x, n/2);
		else
			return x * power2(x, n-1);
		
	}	

}
