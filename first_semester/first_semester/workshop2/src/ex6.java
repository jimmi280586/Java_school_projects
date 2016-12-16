import java.util.Scanner;

public class ex6 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Insert size of the array");
		int size = keyboard.nextInt();
		int[] array = new int[size];

		// loop through the array and insert values
		for (int i = 0; i < array.length; i++) {
			System.out.println("Insert elem " + (i + 1));
			array[i] = keyboard.nextInt();
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	
		int oddpos = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0 && array[i] % 2 == 0) {
				oddpos++;
				
			}
		}
		System.out.println("Total number of odd positive numbers:" + oddpos);
		int oddpostwodigits = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 9 && array[i] % 2 == 0) {
				oddpostwodigits++;
				
			}
			
		}
		System.out.println("Total number of two digits odd positive numbers:"
				+ oddpostwodigits);
		
keyboard.close();
	}
}
