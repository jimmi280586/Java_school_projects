package utillity.math;

public final class Middlesum
{
	public static double middlesum(Function fct, double a, double b, int n)
	{
		double deltaX = ((b - a) / n);
		double x = (a + (deltaX / 2.0));
		double sum = 0.0;
		
		for (int i = 0; i < n; i++)
		{
			sum += fct.f(x);
			x = x + deltaX;
		}
		return (sum * deltaX);
		
	}
	
	
}
