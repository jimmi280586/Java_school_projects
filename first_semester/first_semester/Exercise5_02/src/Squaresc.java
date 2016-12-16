import java.util.Scanner;


public class Squaresc
{

   public static void main(String[] args)
   {
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("enter a number");
      int n = keyboard.nextInt();
      int number;
      System.out.println("number  number Squared");
      System.out.println("----------------------");
      
      for (number = 1; number <= n; number++)
      {
         System.out.println(number + "\t\t" + number * number);
      // "\t\t" is the same as pressing the tab button it move the text

   }

}
}