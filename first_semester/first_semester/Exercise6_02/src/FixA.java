import java.util.Scanner;


public class FixA
{

   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("enter n:");
      int n = keyboard.nextInt();
      java.util.Random random = new java.util.Random();
      int sum = 0;
      do
      {
         int randomNumber = random.nextInt(100);
         System.out.println(randomNumber);
         sum += randomNumber;
      } while (sum <= n);
   }

}
