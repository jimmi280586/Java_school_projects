package recursion;

import utillity.math.F3;
import utillity.math.Function;

public class RecursiveMethods
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
	
	public static void main(String[] args) 
	{
		
		System.out.println("recurtion of bisection " + bisection(new F3(), 0.0, 4.0, 0.0001));
		
		System.out.println("recurtion of powerOf " + powerOf(1.6, 100));
		
		System.out.println("recurtion of fibiatchi numbers " + fibNr(3));
	}
}
