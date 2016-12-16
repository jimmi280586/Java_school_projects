import java.util.Scanner;


public class FatGram 
{
	 public static void main(String[] args)
	 {
	 // Get calories and fat grams from user
	 // And judge product accordingly
	 // Get a scanner object
	 Scanner keyboard = new Scanner(System.in);
	 // Declare variables
	 double calories, fatGrams, caloriesFromFat, percentCaloriesFromFat;
	 // Get calories and fat grams from user
	 System.out.println("How many calories?");
	 calories = keyboard.nextDouble();
	 System.out.println("How many grams of fat?");
	 fatGrams = keyboard.nextDouble();
	 // Calories from fat = grams of fat * 9
	 caloriesFromFat = fatGrams * 9;
	 // Divide calories from fat by total calories for total percent from fat
	 percentCaloriesFromFat = caloriesFromFat / calories;
	 // Calories from fat can't be greater than total calories
	 if (caloriesFromFat > calories)
	 {
	 System.out.println("Calories from fat (" + caloriesFromFat + "), cannot exceed total calories (" + calories + ")");
	 }
	 else
	 {
	 // Return results to user
	 if (caloriesFromFat < (calories * .3))
	 {
	 System.out.println("This is a low fat food!");
	 }
	 // Multiply by 100 to turn from decimal to percent
	 System.out.println("Percent of calories from fat: " + (int) (100 * percentCaloriesFromFat) + "%");
	 }
	 }
	 
}
