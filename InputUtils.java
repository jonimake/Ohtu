package Ohtu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class InputUtils
{
	// <editor-fold desc="Members">
	// </editor-fold>
	// <editor-fold desc="Constructors, Accessors">
	// staattinen luokka
	private InputUtils()
	{
	}
	// </editor-fold>
	// <editor-fold desc="Methods">
	public static int askNumber(String message, Scanner sc)
	{
		int luku = 0;
		do
		{
			System.out.print(message + ": ");
			String line = sc.nextLine();
			try
			{
				luku = Integer.parseInt(line);
			} catch (NumberFormatException nfe)
			{
				System.out.println("Vääränlainen syöte, anna numero");
				continue;
			}
			if (luku < 0)
			{
				System.out.println("Anna positiivinen numero");
				continue;
			}
		} while (false);
		return luku;

	}
	public static GregorianCalendar askDate(String message)
	{
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		Date date = null;

		do
		{
			System.out.print(message + ": ");
			try
			{
				date = sdf.parse(sc.nextLine());
			} catch (ParseException e)
			{
				System.out.println("Vääränlainen syöte, anna päivämäärä muodossa dd.mm.yyyy");
				continue;
			}
		} while (false);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.roll(GregorianCalendar.MONTH, false);
		return gc;
	}
	
	public static GregorianCalendar askDate(String message, Scanner sc)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
		Date date = null;

		do
		{
			System.out.print(message + ": ");
			try
			{
				date = sdf.parse(sc.nextLine());
			} catch (ParseException e)
			{
				System.out.println("Vääränlainen syöte, anna päivämäärä muodossa dd.mm.yyyy");
				continue;
			}
		} while (false);
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		gc.roll(GregorianCalendar.MONTH, false);
		return gc;
	}
}
// </editor-fold>

