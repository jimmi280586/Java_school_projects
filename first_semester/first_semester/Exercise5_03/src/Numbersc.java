import java.util.Scanner;


public class Numbersc
{

   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.println("enter m:");
      int m = keyboard.nextInt();
      System.out.println("enter n:");
      int n = keyboard.nextInt();
      int a = 1;
      for (int i = 1; i <= n; i++)
      {
      a *= m;
      }
      System.out.println("product is " + a);

   }

}
