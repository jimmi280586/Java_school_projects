
public class ArraysA
{

   public static void main(String[] args)
   {
      final int MONTHS = 12;
      
      int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
      
      for (int index = 0; index < MONTHS; index++)
         // if you change MONTHS to days.length nothing will happen
         // becuse the length of the array is 12,
      {
         System.out.println("Month " + (index + 1) + "has " + days[index] + "days.");
         
      }

   }

}
