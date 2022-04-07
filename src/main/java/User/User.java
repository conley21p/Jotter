package User;

import calendar.Calendar;

public class User {
    private String username;
    private String[] CalendarNames;
    private Calendar currCal;

    public User(String usrName,
                String[] calNames,
                Calendar cal){
        this.username = usrName;
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
