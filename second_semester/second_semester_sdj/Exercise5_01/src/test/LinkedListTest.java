package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import utility.collection.*;

public class LinkedListTest
{

	private LinkedList<String> list ;

	@Before
	public void setUp() throws Exception
	{
		list = new LinkedList<String>();
	}

	@Test
	public void shouldBeInTheCorrectPackage()
	{
		assertEquals("utility.collection.LinkedList", list.getClass().getCanonicalName());
	}
	
	@Test
	public void addShouldInsertElementAtIndex()
	{
		list.add(0, "Zeroeth");
		list.add(1, "First");
		list.add(1, "New First");
		
		assertEquals("New First", list.get(1));
		assertEquals("First", list.get(2));
	}

	@Test
	public void addShouldAppendElementToList()
	{
		String testString = "Testing, 3...2...1!";
		list.add(testString);

		assertEquals(testString, list.get(0));
	}
	
	@Test
	public void addShouldAllowDuplicateElements()
	{
		assertEquals(0, list.size());

		list.add("First");
		list.add(list.get(0));
		
		assertEquals(2, list.size());
		assertTrue(list.get(0).equals(list.get(1)));
	}
	
	@Test
	public void addShouldAllowNullElements()
	{
		list.add(null);
		
		assertEquals(1, list.size());
		assertTrue(list.get(0) == null);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void addShouldNotAllowIncorrectIndexes()
	{
		list.add(-1, "Boom!");
	}
	
	@Test
	public void containsShouldConfirmExistenceOfElement()
	{
		list.add("Testing!");
		
		assertFalse(list.contains("Test"));
		assertTrue(list.contains("Testing!"));
	}
	
	@Test
	public void getShouldFindElementAtIndex()
	{
		list.add("First");
		list.add("Second");
		list.add("Third");
		
		assertEquals("First", list.get(0));
		assertEquals("Second", list.get(1));
		assertEquals("Third", list.get(2));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void getShouldNotAllowIncorrectIndexes()
	{
		list.get(-1);
	}

	@Test
	public void indexOfShouldFindCorrectIndex()
	{
		list.add("First");
		list.add("Second");
		list.add("Third");
		
		assertEquals(0, list.indexOf("First"));
		assertEquals(1, list.indexOf("Second"));
		assertEquals(2, list.indexOf("Third"));
		assertEquals(-1, list.indexOf("None"));
	}
	
	@Test
	public void isEmptyShouldReportEmptyArray()
	{
		assertTrue(list.isEmpty());
		
		list.add("First");
		list.add("Second");
		list.remove(0);
		list.remove(0);
		
		assertTrue(list.isEmpty());
	}

	@Test
	public void removeShouldDeleteElement()
	{
		list.add("First");
		list.add("Second");
		
		assertEquals(0, list.indexOf("First"));
		list.remove("First");
		assertEquals(-1, list.indexOf("First"));
	}

	@Test
	public void removeAtIndexShouldDeleteElementAtIndex()
	{
		list.add("First");
		list.add("Second");

		assertEquals(1, list.indexOf("Second"));
		list.remove(1);
		assertEquals(-1, list.indexOf("Second"));

	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void removeShouldNotAllowIncorrectIndexes()
	{
		list.remove(-1);
	}

	@Test
	public void setShouldCorrectlySetElement()
	{
		list.add("First");
		list.add("Second");
		
		assertEquals(1, list.indexOf("Second"));
		
		list.set(1, "New Second");
		assertNotEquals(1, list.indexOf("Second"));
		assertEquals(1, list.indexOf("New Second"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void setShouldNotAllowIncorrectIndexes()
	{
		list.set(-1, "Boom!");
	}

	@Test
	public void linksShouldStayConsistentAfterRemovingAndAdding()
	{
		list.add("One");
		list.add("Two");
		list.add("Three");
		String snapshot = list.toString();
		list.remove(2);
		list.remove("Two");
		list.add("Two");
		list.add("Three");
		assertEquals(snapshot, list.toString());

		list = new LinkedList<String>();
		list.add("One");
		list.add("Two");
		list.add("Three");
		snapshot = list.toString();
		list.remove(0);
		list.remove("Two");
		list.remove(0);
		list.add("One");
		list.add("Two");
		list.add("Three");
		assertEquals(snapshot, list.toString());
	}
	
	@Test
	public void shouldImplementTheCorrectVersion()
	{
		list.add("One");
		list.add("Two");
		assertEquals("One",list.get(0));
		//assertEquals(null, list.get(1).getNext());
	}


}
