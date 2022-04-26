package calendar;

import account.AccountManager;
import servlets.HomePageServlet;

import java.io.*;

public class CalendarController {

    public static String[] getCalendarNameList(String username){
        ClassLoader loader = AccountManager.class.getClassLoader();

        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/";

        //Open user/Calendar folder and store name of each file as a calendar name
        File folder = new File(accountsPath);
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
        //System.out.println("Return calender names list is " + calNames.toString());
        return calNames;
    }

    public static Calendar getCalendar(String username,String defaultName){
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        //For Jacob's use
        jotterPath = "C:/Users/Jacob Radtke/IdeaProjects/Jotter";
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/" + defaultName + "/";

        // Open Calender object is in
        System.out.println("accountsPath create cal:" + accountsPath + "\n");

        Calendar defaultCal = new Calendar();
        try {

            File file = new File(accountsPath);
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
                //System.out.println("Object type:"+objType);
                if (objType.equals("A")){
                    String status = templine[5];
                    defaultCal.addNewToCalendarObjList( username,
                                                        new Assignment(nameString,
                                                                       new Date(dateString),
                                                                       new Time(timeString),
                                                                       descString,
                                                                       status));
                }

            }
            br.close();
        }catch (IOException e) {
            System.out.println("Could not create user account info");
        }
        return defaultCal;
    }

    public static void deleteCalendarObject(int index){
        CalendarObject deleted = HomePageServlet.user.getCurrCal().deleteCalendarObjectList(index);

        //  Delete Object from the data base
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + HomePageServlet.user.getUsername() + "/Calendars/" + HomePageServlet.user.getCurrCal().getName() + "/";
        // Open Calender object is in
        try {
            File file = new File(accountsPath);
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
                            if (((Assignment)deleted).getCompleted().compareTo(templine[5]) ==0){
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
    }
}