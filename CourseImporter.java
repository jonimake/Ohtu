package Ohtu;

import java.util.ArrayList;
import java.net.*;
import java.io.*;

import com.google.gson.*;;

public class CourseImporter
{
    String url;

	public CourseImporter(String url)
	{
        this.url = url;
	}
	
	public ArrayList<Course> importCourses()
	{
        ArrayList<Course> retList = new ArrayList<Course>();

        String jsonString = "";
        try
        {
            jsonString = readJSONFromUrl();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ImportCourses ic = new Gson().fromJson(jsonString, ImportCourses.class);

        for(ImportCourses.ICourse c : ic.getCourses())
        {
            Course temp = new Course(0, c.getCourse());

            String[] startdate = c.getStart_date().split("[-]");
            int startyear = Integer.parseInt(startdate[0]);
            int startmonth = Integer.parseInt(startdate[1]);
            int startday = Integer.parseInt(startdate[2]);

            String[] enddate = c.getEnd_date().split("[-]");
            int endyear = Integer.parseInt(enddate[0]);
            int endmonth = Integer.parseInt(enddate[1]);
            int endday = Integer.parseInt(enddate[2]);

            temp.setStartDate(startyear, startmonth, startday);
            temp.setEndDate(endyear, endmonth, endday);
            retList.add(temp);
        }

        return retList;
	}

    private String readJSONFromUrl() throws Exception
    {
        String retString = "";
        URL url = new URL(this.url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String temp;
        while ((temp = in.readLine()) != null)
        {
            retString += temp;
        }

        in.close();

        return retString;
    }
}
