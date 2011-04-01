package Ohtu;

import java.util.ArrayList;
import java.net.*;
import java.io.*;

import com.google.gson.Gson;

public class CourseImporter
{
    String url;
    Gson g;

	public CourseImporter(String url)
	{
        this.url = url;
        g = new Gson();
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

        return retList;
	}

    private String readJSONFromUrl() throws Exception
    {
        String retString = "";
        URL url = new URL(this.url);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                    url.openStream()));

        String temp;
        while ((temp = in.readLine()) != null)
        {
            retString += temp;
        }

        in.close();

        return retString;
    }
}
