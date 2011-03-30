package Ohtu;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Course
{
	private GregorianCalendar startdate, enddate; 
	//private DateFormat start, end;
	private int coursecode;
	public String coursename;
	
	
	public Course(int i, String name)
	{
		this.coursecode = i;
		this.coursename = name;
		this.startdate = new GregorianCalendar();
		this.enddate = new GregorianCalendar();
		//this.start = DateFormat.getDateInstance();
		//this.end = DateFormat.getDateInstance();
	}
	
	public void setStartDate(int year, int month, int date)
	{
		this.startdate.set(year, month, date);
	}
	
	public void setStartDate(String str)
	{
		String delims = "[.]";
		String[] tokens = str.split(delims);
		this.startdate.set(Integer.parseInt(tokens[2].trim()), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[0].trim())); 
		
	}
	
	public void setEndDate(String str)
	{
		String delims = "[.]";
		String[] tokens = str.split(delims);
		this.enddate.set(Integer.parseInt(tokens[2].trim()), Integer.parseInt(tokens[1].trim()), Integer.parseInt(tokens[0].trim())); 
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
	
	public String dateToString(GregorianCalendar c)
	{
		String tmp;
		tmp = c.get(GregorianCalendar.DATE) +"."+ c.get(GregorianCalendar.MONTH) +"."+ c.get(GregorianCalendar.YEAR) ;
		return tmp;
	}
	
	private class Event
	{
		private GregorianCalendar eventDate;
		public boolean repeatWeekly;
		
		public Event()
		{
			this.eventDate = new GregorianCalendar();
			
		}
		
		public void setTime(int year, int month, int day, int hour, int minute)
		{
			this.eventDate.set(year, month, day, hour, minute);
		}
	}
}
