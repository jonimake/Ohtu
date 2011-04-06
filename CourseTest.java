package Ohtu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class CourseTest extends TestCase
{
	private Course c;
	public CourseTest(String name)
	{
		super(name);
	}

	protected void setUp() throws Exception
	{
		c = new Course(0, "name");
		super.setUp();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		c = null;
	}

	public void testCourse()
	{
		assertNotNull(c);
		assertEquals(c.coursename, "name");
		assertNotNull(c.events);
	}

	public void testSetCoursepoints()
	{
		c.setCoursepoints(5);
		assertEquals(c.getCoursepoints(), 5);
	}

	public void testGetCoursepoints()
	{
		c.setCoursepoints(5);
		int a = c.getCoursepoints();
		assertEquals(a, 5);
	}

	public void testSetStartDateIntIntInt()
	{
		c.setStartDate(2011,12,12);
		assertEquals(c.getStartDate().get(GregorianCalendar.DATE), 12);
		assertEquals(c.getStartDate().get(GregorianCalendar.MONTH), 0);
		assertEquals(c.getStartDate().get(GregorianCalendar.YEAR), 2012);
		//gregoriancalenar rollaa seuraavan vuoden puolelle koska 12. kuukausi on sen mielestä
		//tammikuu
	}

	public void testSetStartDateString()
	{
		String data = "12.12.2011\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			//Scanner scanner = new Scanner(System.in);
			//System.out.println(scanner.nextLine());
		
			c.setStartDate("Test");
			assertEquals(c.getStartDate().get(GregorianCalendar.DATE), 12);
			assertEquals(c.getStartDate().get(GregorianCalendar.MONTH), 11);
			assertEquals(c.getStartDate().get(GregorianCalendar.YEAR), 2011);
		} 
		finally
		{
			System.setIn(System.in);
		}
	}

	public void testSetEndDateString()
	{
		String data = "12.12.2011\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
		
			c.setEndDate("Test");
			assertEquals(c.getEndDate().get(GregorianCalendar.DATE), 12);
			assertEquals(c.getEndDate().get(GregorianCalendar.MONTH), 11);
			assertEquals(c.getEndDate().get(GregorianCalendar.YEAR), 2011);
		} 
		finally
		{
			System.setIn(System.in);
		}
	}

	public void testSetExamDateGregorianCalendar()
	{
		GregorianCalendar g = (GregorianCalendar) GregorianCalendar.getInstance();
		c.setExamDate(g);
		assertSame(c.getExamDate(), g);
	}

	public void testSetExamDateIntIntInt()
	{
		c.setExamDate(2011, 12, 11);
		assertEquals(c.getExamDate().get(GregorianCalendar.DATE), 11);
		assertEquals(c.getExamDate().get(GregorianCalendar.MONTH), GregorianCalendar.DECEMBER);
		assertEquals(c.getExamDate().get(GregorianCalendar.YEAR), 2011);
	}

	public void testSetEndDateIntIntInt()
	{
		c.setExamDate(2011, 12, 11);
		assertEquals(c.getExamDate().get(GregorianCalendar.DATE), 11);
		assertEquals(c.getExamDate().get(GregorianCalendar.MONTH), GregorianCalendar.DECEMBER);
		assertEquals(c.getExamDate().get(GregorianCalendar.YEAR), 2011);
		//fail("Not yet implemented"); // TODO
	}

	public void testGetStartDate()
	{
		GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		assertEquals(c.getStartDate().get(GregorianCalendar.DATE), g.get(GregorianCalendar.DATE));
		assertEquals(c.getStartDate().get(GregorianCalendar.MONTH), g.get(GregorianCalendar.MONTH));
		assertEquals(c.getStartDate().get(GregorianCalendar.YEAR), g.get(GregorianCalendar.YEAR));
		//fail("Not yet implemented"); // TODO
	}

	public void testGetEndDate()
	{
		GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		assertEquals(c.getEndDate().get(GregorianCalendar.DATE), g.get(GregorianCalendar.DATE));
		assertEquals(c.getEndDate().get(GregorianCalendar.MONTH), g.get(GregorianCalendar.MONTH));
		assertEquals(c.getEndDate().get(GregorianCalendar.YEAR), g.get(GregorianCalendar.YEAR));
	}

	public void testGetExamDate()
	{
		GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		c.setExamDate(g);
		assertEquals(c.getExamDate().get(GregorianCalendar.DATE), g.get(GregorianCalendar.DATE));
		assertEquals(c.getExamDate().get(GregorianCalendar.MONTH), g.get(GregorianCalendar.MONTH));
		assertEquals(c.getExamDate().get(GregorianCalendar.YEAR), g.get(GregorianCalendar.YEAR));
	}

	public void testDateToString()
	{
		c.dateToString(c.getEndDate());
		assertTrue(true);
	}

	public void testGetEvents()
	{
		assertNotNull(c.getEvents()); 
	}

	public void testAddEvent()
	{
		Event e = new Event();
		c.addEvent(e);
		assertSame(c.events.get(0), e);
	}

	public void testToString()
	{
		c.toString();
		assertTrue(true);
	}

}
