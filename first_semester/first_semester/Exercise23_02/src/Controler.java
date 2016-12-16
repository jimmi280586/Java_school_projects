import java.util.Scanner;


public class Controler
{

	public static void main(String[] args)
	{
		Object[] ships = new Object[2];
		double a;
		double b;
		int c;
		
		for( int i = 0; i < ships.length; i++)
		{
		
			Scanner keyboard = new Scanner(System.in);
			System.out.println("input 1 for ship ore 2 for ferry");
			int j = keyboard.nextInt();
			
			if( j == 1)
			{
				
				System.out.println("input length");
				a = keyboard.nextDouble();
				System.out.println("input weight");
				b = keyboard.nextDouble();
				Ship ship = new Ship(a, b);	
				
			}
			else if (j == 2)
			{
				
				System.out.println("input length");
				a = keyboard.nextDouble();
				System.out.println("input weight");
				b = keyboard.nextDouble();
				System.out.println("input passengers");
				c = keyboard.nextInt();
				Ferry ferry = new Ferry(a, b, c);
				
			}
			
			
		}
		
		for ( int i = 0; i < ships.length; i++)
		{
			
			System.out.println(ships[i].toString());
		}	

	}

}
