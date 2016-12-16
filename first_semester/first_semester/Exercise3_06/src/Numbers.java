import java.util.Scanner;


public class Numbers
{
	 public static void main(String[] args)
	 {
	 // Optional assignment
	 // Take in three numbers from the user
	 // And order them greatest to smallest
	 // Note: this is much, much easier with collections
	 // and a proper algorithm
	 // Declare variables
	 double a, b, c;
	 // Get a scanner object
	 Scanner keyboard = new Scanner(System.in);
	 // Get values from the user
	 System.out.println("A: ");
	 a = keyboard.nextInt();
	 System.out.println("B: ");
	 b = keyboard.nextInt();
	 System.out.println("C: ");
	 c = keyboard.nextInt();
	 // Check if a is greater than b
	 if (a > b)
	 {
	 // if yes, check if a is greater than c
	 if (a > c)
	 {
	 // If yes, a is the greatest
	 // Check for second highest number
	 if (b > c)
	 {
	 // If b is second highest, then c is third
	 System.out.println("ABC");
	 }
	 else
	 {
	 // If c is second highest, then b is third
	 System.out.println("ACB");
	 }
	 }
	 else
	 {
	 // If a is higher than b but less than c
	 // Then c is highest and a is in the middle
	 System.out.println("CAB");
	 }
	 }
	 else if (a < c)
	 {
	 // a is also lower than c
	 if (b > c)
	 {
	 // b is also greater than c
	 System.out.println("BCA");
	 }
	 else
	 {
	 // c is greater than b, which is greater than a
	 System.out.println("CBA");
	 }
	 }
	 else
	 {
	 // b is greater than a, but a is greater than c
	 System.out.println("BAC");
	 }
	 }
}
