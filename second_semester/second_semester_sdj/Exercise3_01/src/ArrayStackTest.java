import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArrayStackTest {

	private StackADT<String> stack;

	   @Before
	   public void setUp() throws Exception
	   {      System.out.println("Set up");
	      stack = new ArrayStack<>();
	   }

	   @After
	   public void tearDown() throws Exception
	   {
	      System.out.println("Tear down\n");
	   }


	@Test
	public void testPush()
	{
	  stack.push("A");
	  stack.push("B");
	  assertEquals("{A, B}", stack.toString()); // Wrong - on purpose
	  try
	  {
	    stack.push(null);
	    stack.push(null);
	    assertEquals(4, stack.size());
	    assertEquals(null, stack.pop());
	    assertEquals(null, stack.pop());
	    assertEquals("B", stack.pop());
	    assertEquals(1, stack.size());  
	  }
	  catch (IllegalArgumentException e) {/* OK  */}
	  catch (Exception e)
	  {
	    fail("Wrong exception type");
	  }  }

	
	@Test
	public void testPop()
	{
	  stack.push("A"); 
	  stack.push("B");
	  assertFalse(stack.isEmpty());
	  assertEquals("B", stack.pop());
	  assertEquals("A", stack.pop());
	  assertTrue(stack.isEmpty());  
	  try
	  {
	    stack.push(null);
	    assertEquals(null, stack.pop());
	    stack.push("A");
	    stack.push(null);
	    assertEquals(null, stack.pop());
	    assertEquals("A", stack.pop());
	    assertTrue(stack.isEmpty());
	  }
	  catch (IllegalArgumentException e){}
	  catch (Exception e)
	  {
	    fail("Wrong exception type");
	  }}
	  
	@Test(expected = 
			    IllegalStateException.class)
			   public void testPopExcepion()
			   {
			     stack.pop();
			   }


}
