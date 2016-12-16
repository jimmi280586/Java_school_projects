import java.util.Scanner;


public class FixD
{

   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int n = keyboard.nextInt();
      int divisor = 2;
      while(!(n % divisor == 0))
      {
         divisor++;
      }
      System.out.println(divisor);
   }

}
