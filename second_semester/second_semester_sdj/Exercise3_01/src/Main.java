
public class Main
{
	public static void main(String[] args)
	   {
	      StackADT<String> stack = new ArrayStack<>();
	      System.out.println("Pushing C-D-C-A");
	      stack.push("C");
	      stack.push("D");
	      stack.push("C");
	      stack.push("A");

	      System.out.println("stack=" + stack);
	      System.out.println("indexOf(C)=" + stack.indexOf("C"));
	      System.out.println("indexOf(\"NOT\")=" + stack.indexOf("NOT"));
	      System.out.println("top=" + stack.pop());
	      System.out.println("top=" + stack.pop());
	      System.out.println("stack=" + stack);
	      System.out.println("size=" + stack.size());

	      try
	      {
	         System.out.println("Pushing null");
	         stack.push(null);
	         System.out.println("Pushing \"TOP\"");
	         stack.push("TOP");
	         System.out.println("stack=" + stack);
	         System.out.println("indexOf(C)=" + stack.indexOf("C"));
	         System.out.println("indexOf(null)=" + stack.indexOf(null));
	         System.out.println("top=" + stack.pop());
	         System.out.println("top=" + stack.pop());
	      }
	      catch (IllegalArgumentException e)
	      {
	         System.out.println("OK - null elements not allowed");
	      }
	      catch(Exception e)
	      {
	         System.out.println("Wrong exception type: " + 
	                                               e.getClass().getName());
	      }
	      System.out.println("top=" + stack.pop());
	      System.out.println("top=" + stack.pop());
	      try
	      {
	         System.out.println("top=" + stack.pop());
	         System.out.println("ERROR" + 
	                " - trying to pop out an element from an empty stack");
	      }
	      catch (IllegalStateException e)
	      {
	         System.out.println("OK" + 
	                " - trying to pop out an element from an empty stack");
	      }
	      catch(Exception e)
	      {
	         System.out.println("Wrong exception type: " + 
	                                               e.getClass().getName());
	      }
	   }

}
