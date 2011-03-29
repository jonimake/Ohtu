package Ohtu;

import java.util.ArrayList;
import java.util.Scanner;

public class Proto
{
	private ArrayList<Kurssi> courses;
	private Scanner sc;
	private boolean quit;
	
	public Proto()
	{
		this.courses = new ArrayList<Kurssi>();
		this.sc = new Scanner(System.in);
		this.quit = false;
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
		Kurssi course = new Kurssi(courses.size(), coursename);
		courses.add(course);
	}
	
	private void printCourses()
	{
        if(courses.size() == 0) 
        {
            System.out.println("Kursseja ei ole lisätty");
        }

		for (Kurssi c : courses)
		{
			System.out.println(c.coursename);
		}
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
		
	}
}
