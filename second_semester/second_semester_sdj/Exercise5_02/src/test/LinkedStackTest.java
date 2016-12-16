package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import utility.collection.LinkedStack;

public class LinkedStackTest
{

	private LinkedStack<String> stack;

	@Before
	public void setUp() throws Exception
	{
		stack = new LinkedStack<String>();
	}

	@Test
	public void shouldBeInTheCorrectPackage()
	{
		assertEquals("utility.collection.LinkedStack", stack.getClass().getCanonicalName());
	}

	@Test
	public void indexOfShouldFindCorrectIndex()
	{
		stack.push("First");
		stack.push("Second");
		stack.push("Third");

		assertEquals(0, stack.indexOf("Third"));
		assertEquals(1, stack.indexOf("Second"));
		assertEquals(2, stack.indexOf("First"));
	}

	@Test
	public void isEmptyShouldReportEmptyStack()
	{
		assertTrue(stack.isEmpty());

		assertTrue(stack.isEmpty());
	}

	@Test
	public void pushShouldAddElementToTopOfStack()
	{
		stack.push("First");
		assertEquals(0, stack.indexOf("First"));
		stack.push("Second");
		assertNotEquals(0, stack.indexOf("First"));
		assertEquals(0, stack.indexOf("Second"));
	}

	@Test
	public void popShouldRemoveTheTopElementOnTheStack()
	{
		stack.push("First");
		stack.push("Second");
		stack.push("Third");

		assertEquals(0, stack.indexOf("Third"));
		assertTrue(stack.contains("Third"));
		assertEquals("Third", stack.pop());
		assertNotEquals(0, stack.indexOf("Third"));
		assertFalse(stack.contains("Third"));
	}

	@Test(expected = IllegalStateException.class)
	public void popShouldThrowExceptionOnEmptyStack()
	{
		assertTrue(stack.isEmpty());
		stack.pop();
	}

	@Test
	public void peekShouldShowTheCurrentTopElement()
	{
		stack.push("First");
		assertEquals("First", stack.peek());
		stack.push("Second");
		assertEquals("Second", stack.peek());
	}

	@Test(expected = IllegalStateException.class)
	public void peekShouldThrowExceptionOnEmptyStack()
	{
		assertTrue(stack.isEmpty());
		stack.peek();
	}

	@Test
	public void sizeShouldReportCorrectStackSize()
	{
		assertEquals(0, stack.size());

		stack.push("First");
		stack.push("Second");
		stack.push("Third");

		assertEquals(3, stack.size());
	}

	@Test
	public void shouldImplementTheCorrectVersion()
	{
		// Not sure how to show this here!
	}

}
