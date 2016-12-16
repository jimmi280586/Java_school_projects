import java.util.ArrayList;
import java.util.Scanner;


public class Arraylist
{

   public static void main(String[] args)
   {
      Double numbers; // how many numbers user inputs
      Double numbers2;
      ArrayList<Double> numbers1 = new ArrayList<Double>(); // the array
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("how manny numbers do you want to input");
      numbers2 = keyboard.nextDouble();
      
      while (numbers1.size() < numbers2)
      {
         numbers = keyboard.nextDouble();
         numbers1.add(numbers);
      }
      
          
      System.out.println();
      System.out.println("this is your numbers");
      for (int index = 0; index < numbers1.size(); index++)
      System.out.println(numbers1.get(index));
      
      System.out.println();
      System.out.println("this is your numbers in reverse");
      for (int index = numbers1.size() - 1; index >= 0; index--)
         // print array in reverse
      System.out.println(numbers1.get(index));

      System.out.println();
      System.out.println("this is the squarote of your numbers");
      for (int index = 0; index < numbers1.size(); index++)
      System.out.println(Math.sqrt(numbers1.get(index)));
      
      
   }

}
