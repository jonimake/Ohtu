package Ohtu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Course implements Serializable
{
	private GregorianCalendar startdate, enddate; 
	private int coursecode;
	public String coursename;
	private int coursepoints;
	private GregorianCalendar examdate;
	public ArrayList<Event> events;

	public Course(int i, String name)
	{
		this.coursecode = i;
		this.coursename = name;
		this.startdate = new GregorianCalendar();
		this.enddate = new GregorianCalendar();
		this.coursepoints = 0;
		this.examdate = new GregorianCalendar();
		this.events = new ArrayList<Event>();
	}

	public void setCoursepoints(int cp)
	{
		this.coursepoints = cp;
	}

	public int getCoursepoints()
	{
		return this.coursepoints;
	}

	public void setStartDate(int year, int month, int date)
	{
		this.startdate.set(year, month, date);
	}

	public void setStartDate(String str)
	{
		String delims = "[.]";
		String[] tokens = str.split(delims);
		
		int year = Integer.parseInt(tokens[2].trim());
		int month = Integer.parseInt(tokens[1].trim());
		int day = Integer.parseInt(tokens[0].trim()); 
		
		if(isValidDate(year, month, day))
			this.startdate.set(year, (month-1), day); //gregorian calendar k�ytt�� kuukaudelle v�li� 0-11
		else System.out.println("Anna kunnon p�iv�m��r�");
	}

	public void setEndDate(String str)
	{
		String delims = "[.]";
		String[] tokens = str.split(delims);
		
		int year = Integer.parseInt(tokens[2].trim());
		int month = Integer.parseInt(tokens[1].trim());
		int day = Integer.parseInt(tokens[0].trim()); 
		
		if(isValidDate(year, month, day))
			this.enddate.set(year, (month-1), day);  //gregorian calendar k�ytt�� kuukaudelle v�li� 0-11
		else System.out.println("Anna kunnon p�iv�m��r�");
		
	}
	
	private boolean isValidDate(int y, int m, int d)
	{
		if(y < 1)
			return false;
		else if(m < 1 || m > 12)
			return false;
		else if(d < 1 || d > 31)
			return false;
		else 
			return true;
	}

	public void setExamDate(GregorianCalendar g)
	{
		this.examdate = g;
	}

	public void setExamDate(int year, int month, int day)
	{
		this.examdate.set(year, (month-1), day);
	}

	public void setEndDate(int year, int month, int day)
	{
		this.enddate.set(year, month, day);
	}

	public GregorianCalendar getStartDate()
	{
		return this.startdate;
	}

	public GregorianCalendar getEndDate()
	{
		return this.enddate;
	}
    
	public GregorianCalendar getExamDate()
	{
		return this.examdate;
	}

	public String dateToString(GregorianCalendar c)
	{
		String tmp;
		tmp = c.get(GregorianCalendar.DATE) +"."+ (c.get(GregorianCalendar.MONTH)+1) +"."+ c.get(GregorianCalendar.YEAR) ;
		return tmp;
	}
	
	public ArrayList<Event> getEvents()
	{
		return this.events;
	}
	
	public void addEvent(Event e)
	{
		this.events.add(e);
	}
	

	@Override
	public String toString() 
	{
		String ret = "";
		ret += "Nimi: " + this.coursename + "\n";
		ret += "\tAloituspäivämäärä: " + dateToString(this.startdate) + "\n";
		ret += "\tPäättymispäivämäärä: " + dateToString(this.enddate) + "\n";
		ret += "\tOpintopisteet: " + this.coursepoints + "\n";
		ret += "\tTentin ajankohta: " + dateToString(this.examdate) + "\n";
		return ret;
	}
}