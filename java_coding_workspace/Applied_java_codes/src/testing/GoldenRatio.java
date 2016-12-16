package testing;

public class GoldenRatio
{
	public static double golden1(int n)
	{
		if (n == 0)
			return 1;
		else
			return 1 + 1 / golden1(n - 1);
		
	}
	
	public static double golden2(int n)
	{
		double a = 1;
		
		for (int i = 1; i <= n; ++i) 
		{
			a = 1 + 1 / a;
		}
		
		return a;
		
	}
	
	public static void main(String[] args) 
	{
		System.out.println(golden1(20));
		System.out.println(golden2(20));
	}
}
