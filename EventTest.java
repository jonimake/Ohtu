package Ohtu;

import junit.framework.TestCase;

public class EventTest extends TestCase
{
	private Event e;

	public EventTest(String arg0)
	{
		super(arg0);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
		e = new Event();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		e = null;
	}

	public void testGetDescription()
	{
		e.setDescription("Asd");
		assertEquals(e.getDescription(), "Asd");
	}

	public void testSetDescription()
	{
		e.setDescription("Asd");
		assertEquals(e.getDescription(), "Asd");
	}

	public void testEvent()
	{
		fail("Not yet implemented");
	}

	public void testSetTime()
	{
		fail("Not yet implemented");
	}

	public void testCompareTo()
	{
		fail("Not yet implemented");
	}

	public void testToString()
	{
		fail("Not yet implemented");
	}

}
