import java.util.Arrays;
import java.util.Scanner;


public class CompareArrays 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner key = new Scanner(System.in);
		// Take two arrays and compare them for equality
		// Compare value by value
		int[] array1, array2;
		boolean comparison = true;
		// Get and set array lengths
		System.out.println("How many elements will you need?");
		final int LENGTH = key.nextInt();
		array1 = new int[LENGTH];
		array2 = new int[LENGTH];
		// Get values for array1
		for (int count = 0; count < array1.length; count++)
		{
		System.out.println("Give me a value for position " + (count+1));
		array1[count] = key.nextInt();
		}
		// Get values for array2
		for (int count = 0; count < array2.length; count++)
		{
		System.out.println("Give me a value for position " + (count+1));
		array2[count] = key.nextInt();
		}
		// Compare arrays
		for (int count = 0; count < array1.length; count++)
		{
		if (array1[count] != array2[count])
		comparison = false;
		}
		System.out.println("Array one is: " + Arrays.toString(array1));
		System.out.println("Array two is: " + Arrays.toString(array2));
		if (comparison)
		System.out.println("Arrays are equal!");
		else
		System.out.println("Arrays are not equal!");
	}

}
