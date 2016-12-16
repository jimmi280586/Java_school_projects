import java.util.Scanner;


public class Numbersa
{

   public static void main(String[] args)
   {
     Scanner keyboard = new Scanner(System.in);
     System.out.println("enter n:");
     int n = keyboard.nextInt();
     int a = 1;
     for (int i = 1; i <= n; i++)
     {
     a *= i;
     }
     System.out.println("product is " + a);
     
   }

}

