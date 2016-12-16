import java.util.Scanner;


public class Radius
{

	public static void main(String[] args) 
	{
		  double radius, area, circumference;
	      Scanner keyboard = new Scanner(System.in);
	      System.out.println("radius: ");
	      radius = keyboard.nextInt();

	      
	      
	      area = Math.PI * radius * radius;
	      circumference = 2 * Math.PI * radius;
	      
	      System.out.println("the circumference of a circle with radius" + "\n" + radius + " is " + circumference);
	      System.out.println("the area is " + area);
keyboard.close();
	}

}
