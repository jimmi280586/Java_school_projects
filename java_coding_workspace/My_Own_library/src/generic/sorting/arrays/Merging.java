package generic.sorting.arrays;

import java.util.*;


public class Merging<T extends Comparable <? super T>>
{
	private boolean debug; //turn on/off debug messages

	public Merging(boolean i_debug)
	{
		debug = i_debug;
	}
	
	public static void main(String[] args)
	{
		Merging<Integer> ml = new Merging(false);
		List<Integer> l1 = new ArrayList<Integer>();
		
		l1.add(8);
		l1.add(6);
		l1.add(7);
		l1.add(5);
		l1.add(3);
		l1.add(0);
		l1.add(9);
		
		System.out.println(l1.toString());
		System.out.println("calling mergesort");
		
		List<Integer> result = ml.mergesort(l1);
		
		System.out.println(result.toString());
		
		Merging<String> ml2 = new Merging(false);
		List<String> l2 = new ArrayList<String>();
		
		l2.add("eight");
		l2.add("six");
		l2.add("seven");
		l2.add("five");
		l2.add("three");
		l2.add("oh");
		l2.add("nein");
		
		System.out.println(l2.toString());
		System.out.println("calling mergesort");
		
		List<String> result2 = ml2.mergesort(l2);
		
		System.out.println(result2.toString());
	}
	
	//call mergesort on param list
	public List<T> mergesort(List<T> ilist) 
	{
		if(debug)
			System.out.println("domergesort called on arg (" + ilist.toString() + ")");
		if(ilist.size() <= 1)
		{
			if(debug)
				System.out.println("Returning single length list: " + ilist.toString());
			return ilist;
		} 
		else
		{
			List<T> left = new ArrayList<T>();
			List<T> right = new ArrayList<T>();
			int middle = ilist.size() / 2; //int division
			for(int i=0;i<middle;i++)
			{
				left.add(ilist.get(i));
			}
			for(int i=middle;i<ilist.size();i++) 
			{
				right.add(ilist.get(i));
			}
			if(debug)
				System.out.println("Calling merge on left: " + left.toString() + " and right: " + right.toString());
			return merge(mergesort(left), mergesort(right));
		}
	}
	
	//used by mergesort to do merging
	private List<T> merge(List<T> a, List<T> b)
	{
		List<T> ret = new ArrayList<T>(); //return list
		int a_idx = 0, b_idx = 0; //counters of items left in respective lists
		while(a_idx+1 <= a.size() || b_idx+1 <= b.size()) 
		{
			if(a_idx+1 <= a.size() && b_idx+1 <= b.size())
			{
				if(a.get(a_idx).compareTo(b.get(b_idx)) <= 0.0) 
				{
					ret.add(a.get(a_idx));
					a_idx++;
				} 
				else 
				{
					ret.add(b.get(b_idx));
					b_idx++;
				}
			}
			else if(a_idx+1 <= a.size()) 
			{
				ret.add(a.get(a_idx));
				a_idx++;
			}
			else if(b_idx+1 <= b.size()) 
			{
				ret.add(b.get(b_idx));
				b_idx++;
			}
		}
		if(debug)
			System.out.println("Returning merged array: " + ret.toString());
		return ret;
	}


}
