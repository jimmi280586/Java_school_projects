package test_04_05_2015.task1;

public class IterativePower 
{
	public static double power(double x, int n)
	{
		while(n >= 0)
		{		
			if (n == 0)
			{
				return 1.0;
			}
			else
			{
				double result = 1;
				while(n > 0)
				{
					result = result * x;
					n--;
				}
				return result;
			}
		}
		return -1;
			
	}
}
