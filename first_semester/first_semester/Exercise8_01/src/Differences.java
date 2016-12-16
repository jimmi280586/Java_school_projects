import java.util.Scanner;


public class Differences
{

   public static void main(String[] args)
   {
      int numbers; // how many numbers user inputs
      double[] numbers1; // the array
     double index2;
     double dif;
      Scanner keyboard = new Scanner(System.in);
      System.out.println("how manny numbers do you want to input");
      numbers = keyboard.nextInt();
      
      numbers1 = new double[numbers];
      
      for (int index = 0; index < numbers1.length; index++)
      {
         System.out.println("input numbers");
         numbers1[index] = keyboard.nextDouble();
      }
      
      System.out.println();

      // the difference between the numbers is
      
      for(int index = 0; index < numbers1.length; index++)
      {
       index2 = (index -= numbers1[index]);
      
      
      if (index2 < 0)
      {
        dif = (index2 * -1);
        System.out.println(dif);
      }  
         
      }
      
   }

   }
