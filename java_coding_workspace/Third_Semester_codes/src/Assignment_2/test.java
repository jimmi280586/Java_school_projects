
public class test
{
   public static void main(String[] args)
   {
      int[] a = {12,34,43,87,4,6,8,45,9,60};
      int s = compareToAllNumbers(a);
      System.out.println(s);
   }

   private static int compareToAllNumbers(int array[])
   {
      boolean isMin;

      int x, y;
      for (x = 0; x < 10; x++)
      {
         isMin = true;
         for (y = 0; y < 10; y++)
         {
            if(array[x] > array[y])
               isMin = false;
         }
         if(isMin)
            break;
      }
      return array[x];
   }


}
