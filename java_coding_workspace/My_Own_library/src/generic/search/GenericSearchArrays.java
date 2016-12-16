package generic.search;

public class GenericSearchArrays
{
	public static <T extends Comparable<T>> int iterativBinarySearch (T[] A, T key)
	{
		int first = 0, last = A.length - 1;
		int mid;
		
		while (first <= last)
			{
			mid = first + (last - first)/2;
				if (A[mid].compareTo(key) == 0)
					return mid;
				else if (key.compareTo(A[mid]) < 0)
					last = mid - 1;
				else
					first = mid + 1;
			}
		return -1;
	}
	

	
}
