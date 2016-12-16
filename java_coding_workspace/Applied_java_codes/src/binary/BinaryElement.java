package binary;

public class BinaryElement
{	
	public static <T extends Comparable<T>> int iterativElementBinarySearch (T[] A, T key)
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
	
	public static void main(String[] args)
	{
		Element a = new Element("jimmi", 2);
		Element b = new Element("jimmi", 2);
		Element c = new Element("kurt", 3);
		Element d = new Element("jimmi", 6);
		
		Element[] s = new Element[]{a, b, c, d};
		
		System.out.println(iterativElementBinarySearch(s, a));
	}
}