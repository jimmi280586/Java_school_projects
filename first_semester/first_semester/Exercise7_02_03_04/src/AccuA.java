import java.util.Scanner;


public class AccuA
{

   public static void main(String[] args)
   {
      int numbers; // how many numbers user inputs
      double[] numbers1; // the array
      int sum = 0;
     double index2;
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
      
      // start of the sum code
      System.out.println("this is the sum of your numbers");
      for (int index = 0; index < numbers1.length; index++)
      sum += numbers1[index]; 
      System.out.println(sum);
     
      // start of the average code
      System.out.println("this is your average");
      int average = (sum / numbers);
      System.out.println(average);
     
     // start of the highest number code
      double high = numbers1[0];
      System.out.println("higest number");
     for (int index = 0; index < numbers1.length; index++)
      
      {
         if (numbers1[index] > high)// you can use Math.max(high, array[index])
         high = numbers1[index];
      }
      System.out.println(high);

      // start of the product code
      System.out.println("The product of the numbers");
      
      int product = 1;
      for (int index = 0; index < numbers1.length; index++)
      {
         product*=numbers1[index];
      }
      System.out.println(product);
   
      // start of the double the value code
      System.out.println("THIS IS THE DOUBLE VALUE OF YOUR NUMBERS");
     for(int index = 0; index < numbers1.length; index++)
     {
        index2 = (2*numbers1[index]);
        System.out.println(index2);
     }
     
    
   
   }

      

}
