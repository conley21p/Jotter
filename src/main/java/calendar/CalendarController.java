package calendar;

import account.AccountManager;

import java.io.*;

public class CalendarController {

    public static String[] getCalendarNameList(String username){
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = "/" + jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/";

        //Open user/Calendar folder and store name of each file as a calendar name
        File folder = new File(accountsPath);
        File[] listOfFiles = folder.listFiles();

        // Will store list of calendars
        String[] calNames = new String[5];
        int count = 0;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
                calNames[count++] = listOfFiles[i].getName();
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        System.out.println("Return calender names list is " + calNames.toString());
        return calNames;
    }

    public static Calendar getCalendar(String username,String defaultName){
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
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
                System.out.println("Object type:"+objType);
                if (objType.equals("A")){
                    defaultCal.addNewToCalendarObjList( username,
                                                        new Assignment(nameString,
                                                                       new Date(dateString),
                                                                       new Time(timeString),
                                                                       descString));
                }

            }
            br.close();
        }catch (IOException e) {
            System.out.println("Could not create user account info");
        }
        return defaultCal;
    }

}