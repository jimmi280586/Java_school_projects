package Exercise5;

import java.util.Scanner;

public class c {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
		int sum = 1;
		int times = 0;
		int cycle = 1;
		int step = 1;
		System.out.println("How many times do you want to repeat?");
		times = keyboard.nextInt();

		System.out.print(sum + ", "); // to state the start value

		for (int i = 0; i <= times; i++) {
			if (cycle % 2 == 1)
			{
				sum += step;
			step++;
			}
			if (cycle % 2 == 0)
				sum -= 1;

			if (i < times)
				System.out.print(sum + ",");
			else
				System.out.print(sum + " ");
			cycle++;
		}
keyboard.close();
	}

}
