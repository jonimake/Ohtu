package Ohtu;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;

/*
 * Tähän luokkaan tallennetaan eri Kurssi-olioita.
 * Luokka on singletoni, eli siitä ei voi luoda kuin yhden olion joka saadaan
 * käsiin metodilla getInstance();
 */
public class OhtuCalendar implements Serializable
{
	public static final String DATAFILE = "Calendar.dat";
	private static final OhtuCalendar instance;
	ArrayList<Course> courses;
	ArrayList<Course> allCourses;

	static
	{
		OhtuCalendar inst = null;
		try
		{
			inst = Serialization.openCalendar(DATAFILE);
		} catch (Exception ex)
		{
			System.out.println("Virhe avattaessa tiedostoa: " + ex.toString());
		}
		instance = inst != null ? inst : new OhtuCalendar();
	}

	private OhtuCalendar()
	{
		//private Scanner sc = new Scanner(System.in);
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
	/*
	public course get(String str)
	{
		
	}
	*/
	public boolean contains(Course course)
	{
		for (Course c : courses)
			if (c.coursename.equalsIgnoreCase(course.coursename))
				return true;

		return false;
	}
	
	public boolean contains(String course)
	{
		for (Course c : courses)
			if (c.coursename.equalsIgnoreCase(course))
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

    private void writeStringToFile(String s, String filename) throws IOException
    {
        File f = new File(filename);
        if(f.exists())
            f.delete();

        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
        out.write(s);
        out.close();
    }

    public void toCSVFile(String filename)
    {
        String s = "";
        s += "Kurssin nimi,Alkamispäivämäärä,";
        s += "Loppumispäivämäärä,Opintopisteet,";
        s += "Kurssikoe\n";

        for(Course c : this.courses)
        {
            s += c.coursename + ",";
            s += c.dateToString(c.getStartDate()) + ",";
            s += c.dateToString(c.getEndDate()) + ",";
            s += c.getCoursepoints() + ",";
            s += c.dateToString(c.getExamDate());
            s += "\n";
        }

        try
        {
            writeStringToFile(s, filename);
        }
        catch (Exception e)
        {
            System.out.println("Kurssiraportin luominen ei onniustunut, kokeile uudestaan");
        }
        System.out.println("Kurssiraportti luotu");
    }
    
    public void addEvent(Course course)
	{	
		Event e = new Event();
		System.out.println("Anna tapahtuman nimi/kuvaus");
		String event = Proto.sc.nextLine();
		e.setDescription(event);
		
		System.out.println("Anna päivämäärä muotoa dd.mm.yy");
		String str = Proto.sc.nextLine();
		String delims = "[.]";
		String[] tokens = str.split(delims);
		
		int year = Integer.parseInt(tokens[2].trim());
		int month = Integer.parseInt(tokens[1].trim());
		int day = Integer.parseInt(tokens[0].trim()); 
		
		System.out.println("Anna aika muotoa hh.mm");
		String time = Proto.sc.nextLine();
		String[] tokens2 = str.split(delims);
		
		int hour = Integer.parseInt(tokens2[0]);
		int minute = Integer.parseInt(tokens2[1]);
		
		e.setTime(year, month, day, hour, minute);
		
		
		courses.get(courses.indexOf(course)).events.add(e);
	}

	@Override
	public String toString()
	{
		String tmp = "";
        if(courses.size() == 0) 
        {
            tmp = "Kursseja ei ole lisätty";
            return tmp;
        }

		for (Course c : courses)
		{
			tmp += courses.indexOf(c)+": "+c.toString() + "\n";
		}

		return tmp;
	}
}