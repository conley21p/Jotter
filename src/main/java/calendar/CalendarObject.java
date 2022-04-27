package calendar;

import account.AccountManager;
import java.io.*;

public abstract class CalendarObject {
    private String name;
    private Date date;
    private Time time;
    private String description;

        //  constructor
    public CalendarObject(String name,
                          Date date,
                          Time time,
                          String description){
        name.replace(","," ");
        description.replace(","," ");
        this.name           = name;
        this.date           = date;
        this.time           = time;
        this.description    = description;
    }
    public CalendarObject(String name,
                          String date,
                          String time,
                          String description){
        this.name           = name;
        this.date           = new Date(date);
        this.time           = new Time(time);
        this.description    = description;
    }

    /*
     *  This method is used to save calendar object to database
     */
    public void saveToDataBase(String username,
                                   String calenderName){
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        //For Jacob's use
        jotterPath = "C:/Users/Jacob Radtke/IdeaProjects/Jotter";
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/" + calenderName + "/";

        // Open Calender object is in
        try {
            File file = new File(accountsPath);
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
            System.out.println("Problem saving assignment to database");
            //return false;
        }
    //return true;
    }
    /*
     *  This method is used to save calendar object to database
     */
    public void edit(String name,
                     Date date,
                     Time time,
                     String description){
        name.replace(","," ");
        description.replace(","," ");
        //  ParseUpdated string
        if (!this.name.equals(name)){
            this.setName(name);
        }
        if  (!this.date.equals(date)){
            this.setDate(date);
        }
        if (!this.time.equals(time)){
            this.setTime(time);
        }
        if (!this.description.equals(description)){
            this.setDescription(description);
        }
    }
    /*
     *  This method is used to save calendar object to database
     */
    public void updateToDataBase(String username,
                                 String calenderName){
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/" + calenderName + "/";

        // Open Calender object is in
        try {
            File file = new File(accountsPath);
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

    public abstract void edit(String name,
                              Date date,
                              Time time,
                              String description,
                              String status);
}
