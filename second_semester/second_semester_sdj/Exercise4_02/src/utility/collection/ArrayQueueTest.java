package utility.collection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
	
	private QueueADT<String> stack;

	@Before
	public void setUp() throws Exception 
	{
		 System.out.println("Set up");
	      stack = new ArrayQueue<>();
	}

	@Test
	public void testEnqueue() 
	{
		  stack.enqueue("A");
		  stack.enqueue("B");
		 
		  try
		  {
	
		    stack.enqueue(null);
		    assertEquals(2, stack.size());
		   stack.dequeue();
		    assertEquals(1, stack.size());  
		    stack.enqueue("C");
		    assertEquals(2, stack.size());
		  }
		  catch (IllegalArgumentException e) {/* OK  */}
		  catch (IllegalStateException e) {/* ok */}
		  catch (Exception e)
		  {
		    fail("Wrong exception type");
		  }
	}

	@Test
	public void testDequeue() 
	{
		  stack.enqueue("A"); 
		  stack.enqueue("B");
		  assertFalse(stack.isEmpty());
		  stack.dequeue();
		  stack.dequeue();
		  assertTrue(stack.isEmpty());  
		  try
		  {
		    stack.dequeue();
		   
		  }
		  catch (IllegalArgumentException e) {/* OK  */}
		  catch (IllegalStateException e){ /* ok */}
		  catch (Exception e)
		  {
		    fail("Wrong exception type");
		  }
	}

	@Test
	public void testFirst() 
	{
		  stack.enqueue("A");
		  stack.enqueue("B");
		  try
		  {
		    stack.first();
		  }
		  catch (IllegalArgumentException e) {/* OK  */}
		  catch (IllegalStateException e){ /* ok */}
		  catch (Exception e)
		  {
		    fail("Wrong exception type");
		  }
	}

	@Test
	public void testIndexOf() 
	{
		  stack.enqueue("A"); 
		  stack.enqueue("B");
		  assertEquals(1, stack.indexOf("B"));
		  assertEquals(0, stack.indexOf("A"));  
	}

	@Test
	public void testIsEmpty() 
	{
		  stack.enqueue("A"); 
		  stack.enqueue("B");
		  assertFalse(stack.isEmpty());
		  stack.dequeue();
		  stack.dequeue();
		  assertTrue(stack.isEmpty());  
	}

	@Test
	public void testSize()
	{
		stack.enqueue("A"); 
		  stack.enqueue("B");
		  assertEquals(2, stack.size());
		  stack.dequeue();
		  assertEquals(1, stack.size());  
	}

	@Test
	public void testToString()
	{
		stack.enqueue("A"); 
		stack.enqueue("B");
		assertEquals("[ A B ]", stack.toString());
	}
	
	@After
	public void tearDown() throws Exception 
	{
		 System.out.println("Tear down\n");
	}
}
