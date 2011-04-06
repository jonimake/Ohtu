package Ohtu;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

	public static Test suite()
	{
		TestSuite suite = new TestSuite("Test for Ohtu");
		//$JUnit-BEGIN$
		suite.addTestSuite(InputUtilsTest.class);
		suite.addTestSuite(ProtoTest.class);
		suite.addTestSuite(CourseTest.class);
		//suite.addTestSuite(CourseImporterTest.class);
		suite.addTestSuite(EventTest.class);
		suite.addTestSuite(OhtuCalendarTest.class);
		//$JUnit-END$
		return suite;
	}

}
