package User;

import calendar.Calendar;

public class UserController {
    private static String username;
    private static String password;
    private static String[] calendarNames;
    private static Calendar curCalendar;

    public static void loadUser(String user, String pass, String[] calNames, Calendar curCal)
    {
        username = user;
        password = pass;
        calendarNames = calNames;
        curCalendar = curCal;
    }

    public static void dropUser() {
        username = null;
        calendarNames = null;
        curCalendar = null;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String user) { username = user; }

    public static String getPassword() { return password; }

    public static void setPassword(String pass) { password = pass; }

    public static String[] getCalendarNames() {
        return calendarNames;
    }

    public static void setCalendarNames(String[] calNames) {
        calendarNames = calNames;
    }

    public static Calendar getCurCalendar() {
        return curCalendar;
    }

    public void setCurCalendar(Calendar calendar) {
        curCalendar = calendar;
    }
}