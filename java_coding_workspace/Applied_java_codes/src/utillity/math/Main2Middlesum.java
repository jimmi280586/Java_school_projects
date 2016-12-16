package utillity.math;


public class Main2Middlesum 
{
	
	public static void main(String[] args)
	{
		double result = Middlesum.middlesum(new F1() , 0.0, 3.0, 100);
		System.out.println(result);
		double result1 = RightSum.rightSum(0.0, 3.0, 100);
		System.out.println(result1);
		double result2 = LeftSum.leftSum(0.0, 3.0, 100);
		System.out.println(result2);
		System.out.println(result1 - result2);
	}
}
