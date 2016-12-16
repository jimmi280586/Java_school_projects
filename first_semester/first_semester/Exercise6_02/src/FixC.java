import java.util.Scanner;


public class FixC
{

   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      int n = keyboard.nextInt();
      for (int i = 0; i <= n * 2; i += 2)
      {
         System.out.println(i);
      }
   }

}
