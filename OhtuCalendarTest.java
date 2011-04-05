package Ohtu;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

public class OhtuCalendarTest extends TestCase
{
	private OhtuCalendar calendar;

	public OhtuCalendarTest(String arg0)
	{
		super(arg0);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
		OhtuCalendar calendar = OhtuCalendar.getInstance();
		assertTrue(calendar == OhtuCalendar.getInstance());
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		calendar = null;
	}

	public void testGetInstance()
	{
		assertTrue(calendar == OhtuCalendar.getInstance());
	}

	public void testAdd()
	{
		//fail("Not yet implemented");
	}

	public void testContainsCourse()
	{
		//fail("Not yet implemented");
	}

	public void testContainsString()
	{
		//fail("Not yet implemented");
	}

	public void testPrintAllCoursesWithIndex()
	{
		//fail("Not yet implemented");
	}

	public void testToCSVFile()
	{
		//fail("Not yet implemented");
	}

	public void testAddEvent()
	{
		Event e = new Event();
		e.setDescription("Testi");
		assertTrue(e.getDescription() == "Testi");
		e.setTime(2011, 5, 15, 10, 15);
		//assertTrue(e.)
	}

	public void testToString()
	{
		//fail("Not yet implemented");
	}

}
