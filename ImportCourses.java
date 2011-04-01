package Ohtu;

import java.util.List;

public class ImportCourses
{
    private List<ICourse> courses;

    public void setCourses(List<ICourse> c)
    {
        this.courses = c;
    }

    public List<ICourse> getCourses()
    {
        return courses;
    }

    public String toString()
    {
        String ret = "";

        for (ImportCourses.ICourse c : courses)
        {
            ret += c.toString();
        }

        return ret + "\n";
    }

    public static class ICourse
    {
        private String course;
        private String start_date;
        private String end_date;

        public String getCourse()
        {
            return course;
        }
        public String getStart_date()
        {
            return course;
        }
        public String getEnd_date()
        {
            return course;
        }
        public void setCourse(String i)
        {
            this.course = i;
        }
        public void setStart_date(String d)
        {
            this.start_date = d;
        }
        public void setEnd_date(String d)
        {
            this.end_date = d;
        }

        public String toString()
        {
            String ret = "";
            ret += "Nimi " + course + "\n";
            ret += "\tAloitus " + start_date + "\n";
            ret += "\tLopetus " + end_date + "\n";

            return ret;
        }
    }
}
