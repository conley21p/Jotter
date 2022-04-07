package calendar;

import account.AccountManager;

import java.io.*;

public class CalendarObject {
    private String name;
    private Date date;
    private Time time;
    private String description;

    /*
      Main Constructor
       String format needs to be:
            "name:name, date:date, time:time, desc:description"
               -    Spaces are optional
     */
    public CalendarObject(String obj){
        System.out.println("Stringobj:"+obj);
        String temp[] = obj.split(",");
        this.name       = temp[0];
        this.date       = new Date(temp[1]);
        if (!temp[2].isEmpty()){
            this.time       = new Time(temp[2]);
        }
        if (temp.length > 3){
            this.description= temp[3];
        }
    }

    //  Overloaded constructor
    public CalendarObject(String name,
                          Date date,
                          Time time,
                          String description){
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
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts/" + username + "/Calendars/" + calenderName + "/";

        // Open Calender object is in
        try {
            File file = new File(accountsPath);
            File temp = File.createTempFile("temp-file-name", ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(temp));
            String line;
            if((line = br.readLine()) != null){
                do{

                    String templine[] =  line.split(",");
                    Date tempDate = new Date(templine[0]);
                    if (this.date.compare(tempDate) == 1){
                        pw.println(this.toString());
                    }
                    //  Print the last read line
                    pw.println(line);
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
            //return false;
        }
    //return true;
    }

    @Override
    public String toString() {
        return this.date + ","  + this.time + "," + this.name + "," + this.description;
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
}
