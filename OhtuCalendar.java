package Ohtu;

import java.util.ArrayList;
import java.util.GregorianCalendar;


/*
 * Tähän luokkaan tallennetaan eri Kurssi-olioita.
 * Luokka on singletoni, eli siitä ei voi luoda kuin yhden olion joka saadaan
 * käsiin metodilla getInstance();
 */
public class OhtuCalendar
{
	private static final OhtuCalendar instance = new OhtuCalendar();
	ArrayList<Course> courses;
	ArrayList<Course> allCourses;
	
	private OhtuCalendar()
	{
		this.courses = new ArrayList<Course>();
		this.allCourses = new ArrayList<Course>();
		CourseImporter im = new CourseImporter("http://www.cs.helsinki.fi/u/tkairi/rajapinta/courses.json");
		this.allCourses = im.importCourses();
	}
	
	public static OhtuCalendar getInstance() 
	{
        return instance;
    }
	
	public boolean add(Course course)
	{
		courses.add(course);
		return true;
	}
	
	public boolean contains(Course course)
	{
		for (Course c : courses)
			if (c.coursename.equalsIgnoreCase(course.coursename))
				return true;
		
		return false;
	}

    public void printAllCoursesWithIndex()
    {
        int i = 1;
        for(Course c : this.allCourses)
        {
            System.out.println(i + ": " + c.coursename);
            i++;
        }
    }
	
	public String toString()
	{
		String tmp = new String();
        if(courses.size() == 0) 
        {
            tmp = "Kursseja ei ole lisätty";
            return tmp;
        }

		for (Course c : courses)
		{
			tmp = tmp + c.toString() + "\n";
		}
		
		return tmp;
	}
}
