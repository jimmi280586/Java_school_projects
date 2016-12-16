import utility.collection.LinkedList;
import utility.collection.ListADT;

public class LinkedListMain
{
   private static ListADT<String> list = new LinkedList<>();

    public static void main(String[] args)
   {
    	int count = 1000;
    	while(count-- > 0)
    	{
    		list.add("please sir, may I have another?\n");
    	}
    	System.out.println(list);

/*      System.out.println(list);
      list.add("A");
      System.out.println(list);
      list.add("B");
      System.out.println(list);
      list.add("C");
      System.out.println(list);
      list.add(0, "FIRST");
      System.out.println(list);
      list.add(list.size(), "LAST");
      System.out.println(list);
      list.add(2, "Index2Element");
      System.out.println(list);
      System.out.println("Removing at index 2: " + list.remove(2));
      System.out.println(list);
      System.out.println("Removing first element: " + list.remove(0));
      System.out.println(list);
      System.out.println("Removing last element: "
            + list.remove(list.size() - 1));
      System.out.println(list);
      System.out.println("Removing \"B\": " + list.remove("B"));
      System.out.println(list);
      System.out.println("Removing \"FIRST\": " + list.remove("FIRST"));
      System.out.println(list);
      System.out.println("Adding null at index 0");
      list.add(0, null);
      System.out.println(list);
      System.out.println("Removing null: " + list.remove(null));
      System.out.println(list);

      System.out.println("indexOf(A): " + list.indexOf("A"));
      System.out.println("indexOf(B): " + list.indexOf("B"));
      System.out.println("indexOf(C): " + list.indexOf("C"));

      list.set(1, "B");
      list.set(0, null);
      System.out.println(list);
*/   }

  
}
