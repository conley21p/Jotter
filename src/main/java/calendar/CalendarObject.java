package calendar;

import utils.PathFinder;

import java.io.*;
import java.util.Comparator;

public abstract class CalendarObject {
    private String name;
    private Date date;
    private Time time;
    private String description;
    private String course;

        //  constructor
    public CalendarObject(String name,
                          Date date,
                          Time time,
                          String description,
                          String course){
        name.replaceAll(","," ");
        description.replaceAll(","," ");
        course.replaceAll(",", " ");
        this.name           = name;
        this.date           = date;
        this.time           = time;
        this.description    = description;
        this.course         = course;
    }
    public CalendarObject(String name,
                          String date,
                          String time,
                          String description,
                          String course){
        this.name           = name;
        this.date           = new Date(date);
        this.time           = new Time(time);
        this.description    = description;
        this.course         = course;
    }

    /*
     *  This method is used to save calendar object to database
     */
    public void saveToDataBase(String username,
                                   String calenderName){
        String calendarPath = PathFinder.getAccountCalendarsPath(username) + "/" + calenderName;
        System.out.println("CalPath:"+calendarPath);

        // Open Calender object is in
        try {
            File file = new File(calendarPath);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String line;
            boolean addedFlag = true;
            if((line = br.readLine()) != null){
                do{

                    String templine[] =  line.split(",");
                    Date tempDate = new Date(templine[0]);
                    //System.out.println("Date to string is:" + tempDate.toString());
                    if (this.date.compare(tempDate) < 0 && addedFlag){
                        pw.println(this.toString());
                        addedFlag = false;
                    }
                    //  Print the last read line
                    pw.println(line);
                }while((line = br.readLine()) != null);
                if (addedFlag){
                    pw.println(this.toString());
                }
            }else{
                System.out.println("db is empty\n");
                pw.println(this.toString());
            }
            br.close();
            pw.close();
            file.delete();
            temp.renameTo(file);
        }catch (IOException e) {
            System.out.println("Problem saving assignment to database1");
            //return false;
        }
    //return true;
    }
    /*
     *  This method is used to save calendar object to database
     */
    public boolean edit(String name,
                     Date date,
                     Time time,
                     String description,
                     String course){
        try {
            name = name.replace(",", "");
            if (description != null){
                description = description.replace(",", "");
            }
            if (course != null){
                course = course.replace(",", "");
            }
            //  ParseUpdated string
            if (!this.name.equals(name)) {
                this.setName(name);
            }
            if (!this.date.equals(date)) {
                this.setDate(date);
            }
            if (!this.time.equals(time)) {
                this.setTime(time);
            }
            if (!this.description.equals(description)) {
                this.setDescription(description);
            }
            if (!this.course.equals(course)) {
                this.setCourse(course);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
    /*
     *  This method is used to save calendar object to database
     */
    public void updateToDataBase(String username,
                                 String calenderName){
        String calendarPath = PathFinder.getAccountCalendarsPath(username);
        calendarPath = calendarPath + "/" +calenderName;

        // Open Calender object is in
        try {
            File file = new File(calendarPath);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String line;
            boolean addedFlag = true;
            if((line = br.readLine()) != null){
                do{
                    String templine[] =  line.split(",");
                    Date tempDate = new Date(templine[0]);
                    //System.out.println("Date to string is:" + tempDate.toString());
                    if (this.date.compare(tempDate) == 0 && addedFlag){
                        pw.println(this.toString());
                        addedFlag = false;
                    }else{
                        pw.println(line);
                    }
                }while((line = br.readLine()) != null);
            }else{
                System.out.println("db is empty\n");
                pw.println(this.toString());
            }
            br.close();
            pw.close();
            file.delete();
            temp.renameTo(file);
        }catch (IOException e) {
            System.out.println("Problem saving assignment to database");
        }
    }



    @Override
    public String toString() {
        System.out.println("tostring for calObj show date:"+ this.date.toString());
        return this.date.toString() + ","  + this.time.toString() + ",CalObj," + this.name + "," + this.description;
    }


    public static Comparator<CalendarObject> CalCourseComparator = new Comparator<CalendarObject>() {

        public int compare(CalendarObject c1, CalendarObject c2) {
            String CourseName1 = c1.getCourse().toUpperCase();
            String CourseName2 = c2.getCourse().toUpperCase();

            //ascending order
            return CourseName1.compareTo(CourseName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
        }};
    /*
        GETTERs & SETTERs
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourse() {return course;}

    public void setCourse(String course) {this.course = course;}

    public abstract boolean edit(String name,
                                 Date date,
                                 Time time,
                                 String description,
                                 String course,
                                 String status);
}
