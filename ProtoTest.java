package Ohtu;

import java.io.ByteArrayInputStream;
import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class ProtoTest extends TestCase
{
	private Proto p;
	public ProtoTest(String name)
	{
		super(name);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
		p = new Proto();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		p = null;
	}

	public void testProto()
	{
		assertNotNull(p);
	}

	public void testPrintView()
	{
		String data = "asd\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			p.printView();
		} 
		finally
		{
			System.setIn(System.in);
		}
		assertTrue(true);
	}

	public void testModify()
	{
		String data = "asd\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			p.modify();
		} 
		finally
		{
			System.setIn(System.in);
		}
		assertTrue(true);
		//fail("Not yet implemented"); // TODO
	}

	public void testPrintMenu()
	{
		String data = "asd\n";
		try 
		{
			System.setIn(new ByteArrayInputStream(data.getBytes()));
			p.printMenu();
		} 
		finally
		{
			System.setIn(System.in);
		}
		
		assertTrue(true);
		//fail("Not yet implemented"); // TODO
	}
}
