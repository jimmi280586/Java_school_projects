import java.util.Scanner;

public class ex3 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Insert size of the array");
		int size = keyboard.nextInt();
		int[] array = new int[size];
	
		
		// loop through the array and insert values
		for (int i = 0; i < array.length; i++) {
			System.out.println("Insert elem " + (i + 1));
			int value = keyboard.nextInt();
			int control = 0;
				for(int j=0;j<=i;j++)
				{
					if (array[j] == value){
						control = 1;
					}
				}
			if (control ==1){ 
				System.out.println("Duplicate value. Insert another value:");
				value = keyboard.nextInt();
				array[i] = value;
			} else {
				array[i] = value;
			}

		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		keyboard.close();
	}
	
	
}
