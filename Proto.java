package Ohtu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Kalenteriohjelman käli-luokka
 */
public class Proto
{
	OhtuCalendar calendar;
	public static Scanner sc;
	private boolean quit, weekView, monthView;

	public Proto()
	{
		this.sc = new Scanner(System.in);
		this.quit = false;
		this.calendar = OhtuCalendar.getInstance();
		//calendar.add(new Course(0, "Rinnakkaisohjelmointi"));
		//calendar.add(new Course(0, "Tietorakenteet"));
		//calendar.add(new Course(0, "Ohjelmistotuotanto"));
	}

	public void loop()
	{
		while (!quit)
		{
			printMenu();
			readCommand();
		}
	}

	private void readCommand()
	{
		String cmd;
		if(!sc.hasNextLine())
			return;
		cmd = sc.nextLine();
		System.out.println("Annoit komennon "+cmd);
		if (cmd.equalsIgnoreCase("q"))
			this.quit = true;
		else if (cmd.equalsIgnoreCase("M"))
			modify();
		else if (cmd.equalsIgnoreCase("N"))
			printView();
		else if (cmd.equalsIgnoreCase("T"))
			importAndPrintCourses();
		else if (cmd.equalsIgnoreCase("R"))
			createCourseReport();
		else if (cmd.equalsIgnoreCase("V"))
			switchViewMode();
        else
            System.out.println("Virheellinen komento");
	}

    private void createCourseReport()
    {
        this.calendar.toCSVFile("raportti.csv");
    }
    
    private void switchViewMode()
    {
    	if(weekView)
    	{
    		weekView = false;
    		monthView = true;
    	}
    	else if(monthView)
    	{
    		weekView = false;
    		monthView = false;
    	}
    	else
    	{
    		weekView = true;
    		monthView = false;
    	}
    }

	private void addCourse()
	{
		System.out.println("Anna kurssin nimi");
		String coursename = sc.nextLine();
		Course course = new Course(0, coursename);

		if(calendar.contains(course))
		{
			System.out.println("Kurssi on jo kalenterissasi, lisätään sille viikottaisen tapahtuman");
			calendar.addEvent(course);
		}
		
		else
		{
			System.out.println("Anna alkupvm muotoa dd.mm.yyyy");
			String str; 
	
			str = sc.nextLine();
			course.setStartDate(str);
	
			System.out.println("Anna loppupvm muotoa dd.mm.yyyy");
			str = sc.nextLine();
			course.setEndDate(str);
	
			calendar.add(course);
		}
	}

	private void printCourses()
	{
		System.out.println(calendar.toString());
		pressEnter();
	}

	private void importAndPrintCourses()
    {
        this.calendar.printAllCoursesWithIndex();
        System.out.println(
                "*************************************************\n"+		
                "                                                 \n"+
                "   Rekisteröinti:                                \n"+
                "   Anna sen kurssin numero jolle haluat          \n"+
                "   osallistua. Jos haluat rekisteräityä monelle  \n"+
                "   kurssille samalla kertaa, niin annan kaikkien \n"+
                "   kurssien numerot välilyännille erotettuina.   \n"+
                "                                                 \n"+
                "*************************************************");
        
		String cmd;
		if(!sc.hasNextLine())
        {
            System.out.println("Ei komentoa, palaat takaisin päävalikkoon");
            return;
        }
		cmd = sc.nextLine();
        String[] ids = cmd.split("[ ]");
        for(int i = 0; i < ids.length; i++) 
        {
        	Course c;
            int id = Integer.parseInt(ids[i]);
            if(id >= 0 && id < this.calendar.allCourses.size())
            {
            	c = this.calendar.allCourses.get(id - 1);
            	System.out.println("Anna lisätietoja kurssille " + c.coursename);
            	int cp = InputUtils.askNumber("Anna opintopisteiden määrä (pelkkä luku)", sc);
            	c.setCoursepoints(cp);

            	GregorianCalendar date = InputUtils.askDate("Anna tenttipäivämäärä muodossa dd.mm.yyyy", sc);
            	c.setExamDate(date);
            
            	this.calendar.add(c);
            }
            else
            	System.out.println("Kurssia ei ole listalla");
        }
    }
	
	private String viewMode()
	{
		String r = "";
		if(weekView)
		{
			r += "Viikkonäkymä";
		}
		else if(monthView)
		{
			r += "Kuukausinäkymä";
		}
		else
		{
			r += "Vuosinäkymä";
		}
		return r;
	}
	
	public void printView()
	{
		//näitä kahta gregoriankalenteria vertaillaan
		//event olioiden päivään, jos osuu viikon
		//sisälle, lisätään viikkolistaan
		GregorianCalendar g = (GregorianCalendar) GregorianCalendar.getInstance(); 	
		GregorianCalendar g2 = (GregorianCalendar) GregorianCalendar.getInstance();	
		
		//rollataan toista vertailukalenteria eteenpäin viewmoden määräämän 
		if(weekView)																			
			g2.roll(GregorianCalendar.DATE, 7);
		else if(monthView)
			g2.roll(GregorianCalendar.MONTH, 1);
		else
		{
			printCourses();
			return;
		}
			//g2.roll(GregorianCalendar.YEAR, 1);
		//g = (GregorianCalendar) GregorianCalendar.getInstance();
		
		ArrayList<Event> week = new ArrayList<Event>();
		
		for(int i = 0; i < calendar.courses.size(); i++)
        {
			Course c = calendar.courses.get(i);
			for(int o = 0; o < c.events.size(); o++)
			{
				Event e = c.events.get(o);
				if(e.eventDate.after(g) && e.eventDate.before(g2))
					week.add(e);
			}
        }
		Collections.sort(week);
		for(int x = 0; x < week.size(); x++)
		{
			System.out.println(week.get(x).toString()+"\n");
		}
		pressEnter();
	}

	private void pressEnter()
	{
		System.out.println("Paina entteriä jatkaaksesi");
		String dummy = sc.nextLine();
	}
	
	public void modify()
	{	System.out.println(
		"\t (P) Poista kurssi                             \n"+
		"\t (M) Muuta  kurssin tietoja                    \n"+
		"\t (L) Lisää tapahtuma kurssille                 \n"+
		"\t (T) Lisää muu tapahtuma                       \n");

		String cmd;
		if(!sc.hasNextLine())
			return;
		cmd = sc.nextLine();
		System.out.println("Annoit komennon "+cmd);
		
		if (cmd.equalsIgnoreCase("p"))
		{
			System.out.println("Anna kurssin nimi");
			cmd = sc.nextLine();
			
			Course course = new Course(0, cmd);

			if(calendar.contains(course))
			{
				
				System.out.println("Poistetaan kurssi");
				calendar.courses.remove(calendar.getCourse(course));
			}
			else 
				System.out.println("Kurssia ei löytynyt listalta");
		}
		
		else if (cmd.equalsIgnoreCase("m"))
		{
			System.out.println("Anna kurssin nimi");
			cmd = sc.nextLine();
			
			Course course = new Course(0, cmd);

			if(calendar.contains(course))
			{
				System.out.println("Anna päivämäärä muotoa dd.mm.yy");
				String str = Proto.sc.nextLine();
				String delims = "[.]";
				String[] tokens = str.split(delims);
				
				int year = Integer.parseInt(tokens[2].trim());
				int month = Integer.parseInt(tokens[1].trim());
				int day = Integer.parseInt(tokens[0].trim()); 
				
				calendar.getCourse(course).setExamDate(year,month,day);
				//calendar.courses.get(calendar.courses.indexOf(course)).setExamDate(year, month, day);
				
				System.out.println("Anna noppamäärä");
				int cp = InputUtils.askNumber("Anna opintopisteiden määrä (pelkkä luku)", sc);
				calendar.getCourse(course).setCoursepoints(cp);
				//calendar.courses.get(calendar.courses.indexOf(course)).setCoursepoints(cp);
			}
			else 
				System.out.println("Kurssia ei löytynyt listalta");
		}
		
		else if (cmd.equalsIgnoreCase("l"))
		{
			System.out.println("Anna kurssin nimi");
			cmd = sc.nextLine();
			Course course = new Course(0, cmd);

			if(calendar.contains(course))
			{
				calendar.addEvent(course);
			}
			else
				System.out.println("Kurssia ei löytynyt listalta");
		}
		else if (cmd.equalsIgnoreCase("t"))
		{
			System.out.println("Todo");
		}
		
		else 
			System.out.println("Et antanut kunnon komentoa");
	}

	public void printMenu()
	{
		System.out.println(
		"*************************************************\n"+		
		"\t Kalenteri                                     \n"+
		"                                                 \n"+
		"\t "+viewMode()+                                 "\n"+
		"                                                 \n"+
		"\t M   Lisää tai muuta tapahtumia/kursseja       \n"+
		//"\t P   Poista kurssi tai muu tapahtuma           \n"+
		"\t N   Näytä kalenteri                           \n"+
		"\t V   Vaihda näkymää                            \n"+
		"\t T   Tuo kurssit                               \n"+
		"\t R   Luo raportti                              \n"+
		"\t Q   Lopeta                                    \n"+
		"                                                 \n"+
		"*************************************************");
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Proto proto = new Proto();
		proto.loop();
		try
		{
			Serialization.saveCalendar(proto.calendar, OhtuCalendar.DATAFILE);
		} catch (Exception ex)
		{
			System.out.println("Virhe tallennuksessa: " + ex.toString());
		}
		
	}
}