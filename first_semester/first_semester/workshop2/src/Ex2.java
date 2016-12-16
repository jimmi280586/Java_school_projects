import java.util.Scanner;


public class Ex2 {
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

		System.out.println("Number to search through the array");
		int number = keyboard.nextInt();
		boolean result=false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				System.out.println("Found at position " + (i + 1));
				result=true;
			}

		}
		if(result==false){
		System.out.println("Not found");}
		keyboard.close();
	}

}
