package sorts;

/**
 * Merge sort is an O(n log n) comparison-based sorting algorithm. Most
 * implementations produce a stable sort, which means that the implementation
 * preserves the input order of equal elements in the sorted output. Family:
 * Merging. Space: In-place. Stable: True. Average case = O(n*log n) Worst case
 * = O(n*log n) Best case = O(n*log n) http://en.wikipedia.org/wiki/Merge_sort
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class MergeSort<T extends Comparable<T>>
{

   public static enum SPACE_TYPE
   {
      IN_PLACE, NOT_IN_PLACE
   }

   private MergeSort()
   {
   }

   public static <T extends Comparable<T>> T[] sort(SPACE_TYPE type,
         T[] unsorted)
   {
      sort(type, 0, unsorted.length, unsorted);
      return unsorted;
   }

   private static <T extends Comparable<T>> void sort(SPACE_TYPE type,
         int start, int length, T[] unsorted)
   {
      if (length > 2)
      {
         int aLength = (int) Math.floor(length / 2);
         int bLength = length - aLength;
         sort(type, start, aLength, unsorted);
         sort(type, start + aLength, bLength, unsorted);
         if (type == SPACE_TYPE.IN_PLACE)
            mergeInPlace(start, aLength, start + aLength, bLength, unsorted);
         else
            mergeWithExtraStorage(start, aLength, start + aLength, bLength,
                  unsorted);
      }
      else if (length == 2)
      {
         T e = unsorted[start + 1];
         if (e.compareTo(unsorted[start]) < 0)
         {
            unsorted[start + 1] = unsorted[start];
            unsorted[start] = e;
         }
      }
   }

   private static <T extends Comparable<T>> void mergeInPlace(int aStart,
         int aLength, int bStart, int bLength, T[] unsorted)
   {
      int i = aStart;
      int j = bStart;
      int aSize = aStart + aLength;
      int bSize = bStart + bLength;
      while (i < aSize && j < bSize)
      {
         T a = unsorted[i];
         T b = unsorted[j];
         if (b.compareTo(a) < 0)
         {
            // Shift everything to the right one spot
            System.arraycopy(unsorted, i, unsorted, i + 1, j - i);
            unsorted[i] = b;
            i++;
            j++;
            aSize++;
         }
         else
         {
            i++;
         }
      }
   }

   @SuppressWarnings("unchecked")
   private static <T extends Comparable<T>> void mergeWithExtraStorage(
         int aStart, int aLength, int bStart, int bLength, T[] unsorted)
   {
      int count = 0;
      T[] output = (T[]) new Comparable[aLength + bLength];
      int i = aStart;
      int j = bStart;
      int aSize = aStart + aLength;
      int bSize = bStart + bLength;
      while (i < aSize || j < bSize)
      {
         T a = null;
         if (i < aSize)
         {
            a = unsorted[i];
         }
         T b = null;
         if (j < bSize)
         {
            b = unsorted[j];
         }
         if (a != null && b == null)
         {
            output[count++] = a;
            i++;
         }
         else if (b != null && a == null)
         {
            output[count++] = b;
            j++;
         }
         else if (b != null && b.compareTo(a) <= 0)
         {
            output[count++] = b;
            j++;
         }
         else
         {
            output[count++] = a;
            i++;
         }
      }
      int x = 0;
      int size = aStart + aLength + bLength;
      for (int y = aStart; y < size; y++)
      {
         unsorted[y] = output[x++];
      }
   }
}
