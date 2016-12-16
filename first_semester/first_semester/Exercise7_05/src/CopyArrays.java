import java.util.Arrays;
import java.util.Scanner;


public class CopyArrays
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// Take an array of integers and copy it to a new array
		Scanner key = new Scanner(System.in);
		int[] collection, collection_copy;
		// Get and set array length
		System.out.println("How many elements will you need?");
		final int LENGTH = key.nextInt();
		collection = new int[LENGTH];
		// Get values from user
		for (int count = 0; count < collection.length; count++)
		{
		System.out.printf("Give me a value for position %d \n", count+1);
		collection[count] = key.nextInt();
		}
		// Copy array
		collection_copy = new int[collection.length];
		for (int count = 0; count < collection.length; count++)
		{
		collection_copy[count] = collection[count];
		}
		// How do they look?
		System.out.println("Original array: " + Arrays.toString(collection));
		System.out.println("Original array: " + Arrays.toString(collection_copy));
	}

}
