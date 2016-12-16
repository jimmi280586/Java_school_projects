import java.util.Scanner;


public class TimesTable
{

   public static void main(String[] args)
   {
     
      
	// Create a times table
	// Using a 2d array
	Scanner key = new Scanner(System.in);
	int[][] timesTable;
	// Find array length
	System.out.println("How many rows?");
	final int ROWS = key.nextInt();
	System.out.println("How many columns?");
	final int COLS = key.nextInt();
	// Set array dimensions
	timesTable = new int[ROWS][COLS];
	// Fill in array
	// Loop through each row
	for (int i = 0; i < timesTable.length; i++)
	{
	// Fill in the values in each row
	for (int j = 0; j < timesTable[i].length; j++)
	{
	timesTable[i][j] = i*j;
	}
	}
	// Loop through each row
	for (int i = 0; i < timesTable.length; i++)
	{
	// Loop through the values in each row
	for (int j = 0; j < timesTable[i].length; j++)
	{
	// Print results in a row
	// if/else statements are to prettify output so it sits in even columns
	if (timesTable[i][j] < 10)
	System.out.printf(" %d", timesTable[i][j]);
	else if (timesTable[i][j] < 100)
	System.out.printf(" %d", timesTable[i][j]);
	else if (timesTable[i][j] < 1000)
	System.out.printf(" %d", timesTable[i][j]);
	else if (timesTable[i][j] < 10000)
	System.out.printf("%d", timesTable[i][j]);
	// And then I won't care about larger values
	}
	// Print each row on a new line
	System.out.println();
	}
   }

}
