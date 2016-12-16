package utility.collection;

import org.junit.Before;

public class Main
{

	private static QueueADT<String> stack;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	
			 System.out.println("Set up");
		      stack = new ArrayQueue<>(4);
	
		      stack.enqueue("a");
		      stack.enqueue("b");
		      stack.enqueue("c");
		      stack.enqueue("d");
		      
		      System.out.println(stack.dequeue());
		      System.out.println(stack.dequeue());
		      System.out.println(stack.isEmpty());
		      stack.enqueue("e");
		      stack.enqueue("f");
		      System.out.println(stack.dequeue());
		      System.out.println(stack.dequeue());
		      System.out.println(stack.dequeue());
		      System.out.println(stack.dequeue());
		      System.out.println(stack.isEmpty());

		      System.out.println(stack.dequeue());
		     
	}

}
