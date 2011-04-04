package Ohtu;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event implements Comparable
{
	private GregorianCalendar eventDate;
	public String description;
	

	public Event()
	{
		this.eventDate = new GregorianCalendar();
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
	
	
	
	public String toString() 
	{
		String tmp = "";
		tmp += this.description;
		tmp += eventDate.get(GregorianCalendar.DATE) +"."+ 
		(eventDate.get(GregorianCalendar.MONTH)+1) +"."+ 
		eventDate.get(GregorianCalendar.YEAR)+"\n Klo: "+
		eventDate.get(GregorianCalendar.HOUR_OF_DAY)+
		eventDate.get(GregorianCalendar.MINUTE);
		
		//String ret = "";
		//ret += "Nimi: " + this.coursename + "\n";
		//ret += "\tAika: " + dateToString(this.startdate) + "\n";
		return tmp;
	}
}