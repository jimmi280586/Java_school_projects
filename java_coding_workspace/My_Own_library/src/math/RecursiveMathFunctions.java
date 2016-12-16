package math;

import interfaces.math.Function;

public class RecursiveMathFunctions 
{
	public static double powerOf(double x, int n)
	{
		if (n == 0)
			return 1;//base case
		else
			return x * powerOf(x, n-1);
	}
	
	public static int fibNr(int n)
	{
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibNr(n - 1) + fibNr(n - 2);
	}
	
	public static double bisection(Function fct, double left, double right, double epsilon)
	{
		double mid = (left + right)/2;
		if(Math.abs((right - left)) < epsilon)
			return (left + right)/2;
		else if((fct.f(left) * fct.f(mid)) < 0)
			return bisection(fct, left, mid, epsilon);
		
		else
			
			return bisection(fct, mid , right, epsilon);
	}
	
	  public static long factorial(int n)  // factorial
	  {
		  long result;

	      if(n == 1)
	        return 1;

	      result = factorial(n - 1) * n;
	      
	      return result;
	  }

	  public static int sum(int n)  // 1 + 2 + .. + n
	  {
	      if (n > 0)
	      {
	        return n + sum(n - 1);
	      }
	      else
	      {
	          return 1;
	      }
	  }
}
