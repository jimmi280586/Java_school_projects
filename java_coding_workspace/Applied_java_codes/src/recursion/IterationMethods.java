package recursion;

import utillity.math.F3;
import utillity.math.Function;

public class IterationMethods 
{
	public static double powerOf(double x, int n)
	{
		while(n >= 0)
		{		
			if (n == 0)
			{
				return 1;
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
	
	public static int fibNr(int n)
	{
		if (n == 0) return 0;
	    if (n == 1) return 1;
	        
	    int prevPrev = 0;
	    int prev = 1;
	    int result = 0;
	        
	    for (int i = 2; i <= n; i++)
	    {
	        result = prev + prevPrev;
	        prevPrev = prev;
	        prev = result;
	    }
	    return result;
			
			
	}
	
	public static double bisection(Function fct, double left, double right, double epsilon)
	{			         
			      double c; 
			      double d;
			     
			      while (Math.abs(right - left) > epsilon) 
			      {
			         c = (right + left) / 2;
			         d = fct.f(c);
			         if (d * fct.f(right) == 0 || d * fct.f(left) == 0)
			         {
			            return c;
			         } else if (d * fct.f(right) > 0) 
			         {
			            right = c;
			         } else 
			         {
			            left = c;
			         }
			      }
			      return (right + left) / 2;
		
	}
	
	public static void main(String[] args) 
	{
		
		System.out.println("iteration of bisection " + bisection(new F3(), 0.0, 4.0, 0.0001));
		
		System.out.println("iteration of powerOf " + powerOf(1.6, 100));
		
		System.out.println("iteration of fibiatchi numbers " + fibNr(10));
	}
}
