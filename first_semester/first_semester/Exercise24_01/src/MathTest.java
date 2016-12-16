import java.util.Scanner;


public class MathTest
{

	public static void main(String[] args) 
	{
		
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter x: ");
			int x = scanner.nextInt();
			System.out.println("Enter y: ");
			int y = scanner.nextInt();
			
		
			System.out.println("x + y = " + (x + y));
			System.out.println("x - y = " + (x - y));
		try
		{
			System.out.println("x / y = " + (x / y));
		}
		
		catch (ArithmeticException e)
		{
			System.out.println(e.getMessage());
			
		}

			System.out.println("x * y = " + (x * y));
		
		
		
	}

}
