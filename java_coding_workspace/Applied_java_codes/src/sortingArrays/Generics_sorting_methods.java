package sortingArrays;

public class Generics_sorting_methods<T> implements Comparable<T>
{
	 private <T> void swap(T[] a, int i, int j) 
	 {
	        if (i != j)
	        {
	            T temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	        }
	 }

	 public <T extends Comparable<T>> void selectionSort(T[] a)
	 {
	     for (int i = 0; i < a.length - 1; i++)
	     {
	            
	            int smallest = i;
	            for (int j = i + 1; j < a.length; j++)
	            {
	                if (a[j].compareTo(a[smallest])<=0) 
	                {
	                    smallest = j;
	                }
	            }

	            swap(a, i, smallest);  
	        }
	    }
	 
	 public static <T extends Comparable<T>> void insertionSort(T[] a)
	 {

         for (int i=0;  i != a.length;  i = i+1)
         {
            T itemToInsert = a[i];
            int j = i;
            while (j != 0  &&  (a[j-1].compareTo(itemToInsert) > 0))
            {
               a[j] = a[j-1];  j = j-1;
            }
            a[j] = itemToInsert;
         }
      }
	 
	 public static <T extends Comparable<T>> void bubbleSort(T[] array)
	 {
	 	int right_border = array.length - 1;

	 	do
	 	{
	 		int last_exchange = 0;

	 		for (int i = 0; i < right_border; i++)
	 		{
	 			if (array[i].compareTo(array[i + 1]) > 0)
	 			{
	 				T temp = array[i];
	 				array[i] = array[i + 1];
	 				array[i + 1] = temp;

	 				last_exchange = i;
	 			}
	 		}

	 		right_border = last_exchange;
	 	}
	 	while ( right_border > 0 );
	 }
	 
	 

	@Override
	public int compareTo(T other) 
	{
	      if(this.compareTo(other) > 0)
	            return 1;
	        else if(this.compareTo(other) == 0)
	            return 0;
	        else
	            return -1;
	}
}
