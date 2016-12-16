import java.util.Scanner;


public class HelloB {

	public static void main(String[] args) 
	{
		//asks user for name and prints to consol
		Scanner keyboard = new Scanner(System.in);
		System.out.println("what is your name");
		String name = keyboard.next();
		System.out.println("Hello " + name);
		
		keyboard.close();
	}

}
