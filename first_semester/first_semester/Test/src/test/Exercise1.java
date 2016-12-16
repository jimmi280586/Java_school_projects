package test;

import java.util.Scanner;

public class Exercise1
{

   public static void main(String[] args)
   {
      @SuppressWarnings("resource")
      Scanner input = new Scanner(System.in);
      System.out.print("Home team score ");
      int home = input.nextInt();
      @SuppressWarnings("resource")
      Scanner input1 = new Scanner(System.in);
      System.out.print("Away team score ");
      int Away = input1.nextInt();
      
      if (home == Away)
      {
         System.out.println("result is x");
      }
      if (home < Away)
      {
         System.out.println("result is 2");
      }
      if (home > Away)
      {
         System.out.println("result is 1");
      }
   }

}
