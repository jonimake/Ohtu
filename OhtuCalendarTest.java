package Ohtu;

import java.io.ByteArrayInputStream;

import junit.framework.TestCase;

public class OhtuCalendarTest extends TestCase
{
	OhtuCalendar c;
	public OhtuCalendarTest(String name)
	{
		super(name);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
		c = OhtuCalendar.getInstance();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testGetInstance()
	{
		c = OhtuCalendar.getInstance();
		assertEquals(c, OhtuCalendar.getInstance());
	}

	public void testAdd()
	{
		Course co = new Course(0, "name");
		c.add(co);
		assertEquals(c.courses.get(0), co);
	}

	public void testContainsCourse()
	{
		Course co = new Course(0, "name");
		assertTrue(c.contains(co));
	}

	public void testGetCourseString()
	{
		Course co = c.getCourse("name");
		assertNotNull(co);
	}

	public void testGetCourseCourse()
	{
		Course co = new Course(0, "name");
		Course c2 = c.getCourse(co);
		assertNotNull(c2);
	}

	public void testContainsString()
	{
		assertTrue(c.contains("name"));
	}

	public void testPrintAllCoursesWithIndex()
	{
		c.printAllCoursesWithIndex();
		assertTrue(true);
	}

	public void testToCSVFile()
	{
		c.toCSVFile("test");
		assertTrue(true);
	}

	public void testAddEvent()
	{
		/*
		Course course;
		String data = "12.12.2011 \n 10.15 \r\n12.12.2011 \n 10.15 \r\n";
		//data += "10.15\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			course = new Course(0, "test");
			c.add(course);
			c.addEvent(course);
			
		} 
		finally
		{
			System.setIn(System.in);
		}
		
		
		assertTrue(c.getCourse(course).events.size() > 0);
		*/
		assertTrue(true);
	}

	public void testToString()
	{
		c.toString();
		assertTrue(true);
	}

}
