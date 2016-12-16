package Exercise4;

import java.util.Scanner;

public class Read_arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What size do you want your array?");
		int arraysize = keyboard.nextInt();
		String array[] = new String[arraysize];
		
		
		System.out.println("Your array is size: " + arraysize);
		
		for ( int i = 0; i < array.length; i++)
		{
			System.out.println("Array space number: " + i);
			array[i] = keyboard.next();
		}

		
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
		keyboard.close();
	}

}
