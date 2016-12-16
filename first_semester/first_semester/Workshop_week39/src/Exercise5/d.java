package Exercise5;

import java.util.Scanner;

public class d {
	
	public static void main(String[] args) {
		
	
	Scanner keyboard = new Scanner(System.in);
	int current = 1;
	int last = 0;
	int sum = 1;
	int times = 0;
	System.out.println("How many times do you want to repeat?");
	times = keyboard.nextInt();

	System.out.print(sum + ", "); // to state the start value
	
	
	
	for(int i = 0; i< times; i++)
	{
		sum = current + last;
		if (i < times -1)
			System.out.print(sum + ",");
		else
			System.out.print(sum + " ");
		last = current;
		current = sum;
	}
	keyboard.close();
	}
	
}
