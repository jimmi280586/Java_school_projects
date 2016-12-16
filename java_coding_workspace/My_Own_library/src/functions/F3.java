package functions;

import interfaces.math.Function;

public class F3 implements Function
{
	public double f(double x)
	{
		
		return ((x * x * x) + (4 * x * x) - 10);
	}
}
