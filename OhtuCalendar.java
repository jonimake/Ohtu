package Ohtu;

import java.util.ArrayList;


/*
 * Tähän luokkaan tallennetaan eri Kurssi-olioita.
 * Luokka on singletoni, eli siitä ei voi luoda kuin yhden olion joka saadaan
 * käsiin metodilla getInstance();
 */
public class OhtuCalendar
{
	private static final OhtuCalendar instance = new OhtuCalendar();
	ArrayList<Course> courses;
	
	private OhtuCalendar()
	{
		this.courses = new ArrayList<Course>();
	}
	
	public static OhtuCalendar getInstance() 
	{
        return instance;
    }
	
	public void add(Course course)
	{
		courses.add(course);
	}
	
	public void print()
	{
        if(courses.size() == 0) 
        {
            System.out.println("Kursseja ei ole lisätty");
        }

		for (Course c : courses)
		{
			System.out.println(c.coursename);
		}
	}
}
