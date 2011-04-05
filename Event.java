package Ohtu;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event implements Comparable, Serializable
{
	public GregorianCalendar eventDate;
	private String description;
	
	public Event()
	{
		this.eventDate = new GregorianCalendar();
	}
	
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setTime(int year, int month, int day, int hour, int minute)
	{
		this.eventDate.set(year, (month-1), day, hour, minute);
	}

	@Override
	public int compareTo(Object e) 
	{
		return this.eventDate.compareTo((Calendar) e);
	}
	
	
	
	@Override
	public String toString() 
	{
		String r = "";
		r += this.description+"\n";
		r += this.eventDate.get(GregorianCalendar.DATE)+".";
		r += (this.eventDate.get(GregorianCalendar.MONTH)+1)+".";
		r += this.eventDate.get(GregorianCalendar.YEAR)+"\n";
		r += "Klo: ";
		r += this.eventDate.get(GregorianCalendar.HOUR_OF_DAY)+":";
		r += this.eventDate.get(GregorianCalendar.MINUTE);
		
		//String ret = "";
		//ret += "Nimi: " + this.coursename + "\n";
		//ret += "\tAika: " + dateToString(this.startdate) + "\n";
		return r;
	}
}