package Ohtu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;


/*
 * Kalenteriohjelman käli-luokka
 */
public class Proto
{
	OhtuCalendar calendar;
	private Scanner sc;
	private boolean quit;
	
	public Proto()
	{
		this.sc = new Scanner(System.in);
		this.quit = false;
		calendar = OhtuCalendar.getInstance();
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
		String cmd = sc.nextLine();
		System.out.println("Annoit komennon "+cmd);
		if (cmd.equalsIgnoreCase("q"))
			this.quit = true;
		else if (cmd.equalsIgnoreCase("L"))
			addCourse();
		else if (cmd.equalsIgnoreCase("N"))
			printCourses();
        else
            System.out.println("Virheellinen komento");
	}
	
	private void addCourse()
	{
		System.out.println("Anna kurssin nimi");
		String coursename = sc.nextLine();
		Course course = new Course(0, coursename);
		calendar.add(course);
	}
	
	private void printCourses()
	{
		calendar.print();
		pressEnter();
	}
	
	private void pressEnter()
	{
		System.out.println("Paina entteriä jatkaaksesi");
		String dummy = sc.nextLine();
	}

	public void printMenu()
	{
		System.out.println(
		"*************************************************\n"+		
		"   Kalenteri                                     \n"+
		"                                                 \n"+
		"   L   Lisää kurssi                              \n"+
		"   N   Näytä kalenteri                           \n"+
		"   V   Vaihda näkymää                            \n"+
		"   T   Tuo kurssit                               \n"+
		"   Q   Lopeta                                    \n"+
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
		//Kurssi kurssi1 = new Kurssi(123, "xml");
		//kurssi1.setStartDate(2011, 3, 2);
		//kurssi1.setEndDate(2012, 6, 15);
		//System.out.println(kurssi1.toString());
	}
}
