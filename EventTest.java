package Ohtu;

import java.io.ByteArrayInputStream;
import java.util.Calendar;

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
		assertNotNull(e);
	}

	public void testSetTime()
	{
		String data = "12.12.2011\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			e.setTime(InputUtils.askDate("Test"));
		} 
		finally
		{
			System.setIn(System.in);
		}
		assertEquals(Calendar.DECEMBER, e.eventDate.get(Calendar.MONTH));
		assertEquals(12, e.eventDate.get(Calendar.DATE));
		assertEquals(2011, e.eventDate.get(Calendar.YEAR));
		
	}

	public void testCompareTo()
	{
		Event e2 = new Event();
		e2.compareTo(e);
		assertTrue(true);
	}

	public void testToString()
	{
		e.toString();
		assertTrue(true);
	}

}
