package Ohtu;

import java.util.GregorianCalendar;

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
}
