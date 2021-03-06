package calendar;

import account.AccountManager;
import servlets.HomePageServlet;
import utils.PathFinder;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class CalendarController {

    public static boolean addCalendar(String username, String calendarName) {
        String calendarPath = PathFinder.getAccountCalendarsPath(username);

        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(new File(calendarPath + "/" + calendarName)));
            outfile.write("");
            outfile.close();
        } catch (IOException e) {
            System.out.println("Could not create calendar.");
            return false;
        }

        return true;
    }

    public static boolean deleteCalendar(String username, String calendarName) {
        boolean isSuccess = false;

        if (getCalendarCapacity(username) <= 2) {
            System.out.println("User must have one calendar.");
        } else {
            String calendarPath = PathFinder.getAccountCalendarsPath(username) + "/" + calendarName;

            // deleting calendar
            File calendarDirectory = new File(calendarPath);
            if (calendarDirectory.delete()) {
                isSuccess = true;
            } else {
                System.out.println("Failed to delete calendar.");
            }
        }

        System.out.println("Calendar " + calendarName + " deleted? " + isSuccess);
        return isSuccess;
    }

    public static String[] getCalendarNameList(String username){
        String calendarsPath = PathFinder.getAccountCalendarsPath(username);
        //Open user/Calendar folder and store name of each file as a calendar name
        File folder = new File(calendarsPath);
        File[] listOfFiles = folder.listFiles();

        // Will store list of calendars
        String[] calNames = new String[5];
        int count = 0;
        try{
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println("File " + listOfFiles[i].getName());
                    calNames[count++] = listOfFiles[i].getName();
                } else if (listOfFiles[i].isDirectory()) {
                    System.out.println("Directory " + listOfFiles[i].getName());
                }
            }
        }catch (NullPointerException e){
            System.out.println("List of all files NUll pointer error");
        }
        System.out.println("Return calender names list is " + Arrays.toString(calNames));
        return calNames;
    }

    public static int getCalendarCapacity(String username) {
        int count = 0;
        for (int i = 0; i < getCalendarNameList(username).length; i++) {
            if (getCalendarNameList(username)[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static Calendar getCalendar(String username,String defaultName){
        String calendarPath = PathFinder.getAccountCalendarsPath(username) + "/" + defaultName;

        Calendar defaultCal = new Calendar(5, defaultName);
        try {

            File file = new File(calendarPath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            while((line = br.readLine()) != null){
                /*
                 *  Assignments are stored in the database in this format:
                 *  Date,time,name,description
                 *
                 *  Date format: yyyy-mm-dd
                 *  Time format: in military time hh:mm
                 */
                String templine[] =  line.split(",");
                String dateString = templine[0];
                String timeString = templine[1];
                String objType    = templine[2];
                String nameString = templine[3];
                String descString = templine[4];
                String course = templine[5];
                //System.out.println("Object type:"+objType);
                if (objType.equals("A")){
                    String status = templine[6];
                    String filename = "null";
                    if (templine.length > 7) {
                        filename = templine[7];
                    }
                    defaultCal.addNewToCalendarObjList( username,
                                                        new Assignment(nameString,
                                                                       new Date(dateString),
                                                                       new Time(timeString),
                                                                       descString,
                                                                       course,
                                                                       status,
                                                                       filename));
                }

            }
            br.close();
        }catch (IOException e) {
            System.out.println("Could not create user account info");
        }
        return defaultCal;
    }

    public static CalendarObject deleteCalendarObject(int index){
        CalendarObject deleted = HomePageServlet.user.getCurrCal().deleteCalendarObjectList(index);
        //  Delete Object from the data base
        String calendarPath = PathFinder.getAccountCalendarsPath(HomePageServlet.user.getUsername()) + "/" + HomePageServlet.user.getCurrCal().getName();
        System.out.println("CalPath:" + calendarPath);
        // Open Calender object is in
        try {
            File file = new File(calendarPath);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String line;
            boolean flag = true;
            if((line = br.readLine()) != null){
                do{
                    flag = true;
                    String templine[] =  line.split(",");
                    Date tempDate = new Date(templine[0]);
                    Time tempTime = new Time(templine[1]);
                    //System.out.println("Date to string is:" + tempDate.toString());
                    if (deleted.getDate().compare(tempDate) == 0
                    &&  deleted.getTime().toString().compareTo(tempTime.toString()) == 0
                    &&  deleted.getName().compareTo(templine[3]) == 0
                    &&  deleted.getDescription().compareTo(templine[4])== 0){
                        if (templine[2].compareTo("A") ==0){
                            if (((Assignment)deleted).getCompleted().compareTo(templine[6]) == 0
                            &&  deleted.getCourse().compareTo(templine[5])                  == 0){
                                //  All attributes match so delete line
                                flag = false;
                            }
                        }
                    }
                    if(flag) {
                        //  Print the last read line
                        pw.println(line);
                    }

                }while((line = br.readLine()) != null);
            }else{
                System.out.println("db is empty\n");
            }
            br.close();
            pw.close();
            file.delete();
            temp.renameTo(file);
        }catch (IOException e) {
            System.out.println("Problem saving assignment to database");
            //return false;
        }
        return deleted;
    }
}