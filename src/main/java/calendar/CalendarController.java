package calendar;

import java.util.ArrayList;

public class CalendarController {
    private ArrayList<Calendar> calendarList;

    public CalendarController(){
        this.calendarList = new ArrayList<Calendar>(0);
        this.calendarList.add(new Calendar(50));
    }
    public CalendarController(int size){
        calendarList = new ArrayList<Calendar>(size);
    }
    /*
        GETTERs & SETTERs
     */

    public ArrayList<Calendar> getCalendarList() {
        return calendarList;
    }
    public Calendar getCalendarListObj(int index) {
        return calendarList.get(index);
    }
    public void setCalendarList(ArrayList<Calendar> calendarList) {
        this.calendarList = calendarList;
    }

}
