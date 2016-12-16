import java.util.Scanner;


public class Numbera
{

   public static void main(String[] args)
   {
     @SuppressWarnings("resource")
   Scanner keyboard = new Scanner(System.in);
     System.out.println("enter n:");
     int n = keyboard.nextInt();
     int a = 0;
     for (int i = 1; i <= n; i++)
     {
     a += i;
     }
     System.out.println("sum is " + a);
     
   }

}
