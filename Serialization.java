package Ohtu;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization
{
	// <editor-fold desc="Members">
	// </editor-fold>

	// <editor-fold desc="Constructors, Accessors">
	// staattinen luokka
	private Serialization()
	{

	}
	// </editor-fold>

	// <editor-fold desc="Methods">
	public static void saveCalendar(OhtuCalendar oc, String tiedosto) throws FileNotFoundException, IOException
	{
		FileOutputStream fos = new FileOutputStream(tiedosto);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(oc);
	}
	public static OhtuCalendar openCalendar(String tiedosto) throws ClassNotFoundException, IOException
	{
		try
		{

			FileInputStream fis = new FileInputStream(tiedosto);
			ObjectInputStream ois = new ObjectInputStream(fis);

			return (OhtuCalendar)ois.readObject();
		} catch(FileNotFoundException e)
		{
			return null;
		}
	}

	// </editor-fold>
}
