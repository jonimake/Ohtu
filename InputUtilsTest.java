package Ohtu;

import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import junit.framework.TestCase;

public class InputUtilsTest extends TestCase
{

	public InputUtilsTest(String arg0)
	{
		super(arg0);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	public void testAskNumber()
	{

		String data = "5";

		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner sc = new Scanner(System.in);
			int number = InputUtils.askNumber("Test", sc);
			assertEquals(number, 5);
		} 
		finally
		{
			System.setIn(System.in);
		}
	}

	public void testAskDate()
	{
		String data = "12.12.2011";

		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			Scanner sc = new Scanner(System.in);
			GregorianCalendar g = (GregorianCalendar) Calendar.getInstance();
		
			g.set(2011, GregorianCalendar.DECEMBER, 12);
			//anna ajaksi 12.12.2011
			//String msg = "anna ajaksi 12.12.2011";
			GregorianCalendar g2 = InputUtils.askDate("Test", sc);
			g2.toString();
			assertEquals(g.DATE, g2.DATE);
			assertEquals(g.MONTH, g2.MONTH);
			assertEquals(g.YEAR, g2.YEAR);
		}
		finally
		{
			System.setIn(System.in);
		}
	}

}
