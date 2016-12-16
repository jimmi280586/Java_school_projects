package Exercise5;

import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		int sum = 1;
		int times = 0;
		System.out.println("How many times do you want to repeat?");
		times = keyboard.nextInt();

		System.out.print(sum + ", "); // to state the start value

		for(int i = 1; i <= times; i++)
		{
			sum += i;
			if(i < times )
					System.out.print(sum + ",");
			else
				System.out.print(sum + " ");
		}
keyboard.close();
	}

}
