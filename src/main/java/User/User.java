package User;

import calendar.Calendar;

public class User {
    private String username;
    private String password;
    private String[] CalendarNames;
    private Calendar currCal;

    public User(String usrName, String password,
                String[] calNames,
                Calendar cal){
        this.username = usrName;
        this.password = password;
        this.CalendarNames = calNames;
        this.currCal = cal;
    }
    public User(){
        this.username = "";
        this.CalendarNames = new String[]{"", ""};
        this.currCal = new Calendar();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() { return this.password; }

    public void setPassword(String password) { this.password = password; }

    public String[] getCalendarNames() {
        return CalendarNames;
    }

    public void setCalendarNames(String[] calendarNames) {
        CalendarNames = calendarNames;
    }

    public Calendar getCurrCal() {
        return currCal;
    }

    public void setCurrCal(Calendar currCal) {
        this.currCal = currCal;
    }
}
