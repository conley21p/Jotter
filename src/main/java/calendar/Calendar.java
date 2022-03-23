package calendar;

import java.util.ArrayList;

public class Calendar {
    private ArrayList<CalendarObject> calendarObjList;
    private int currentSize;


    //  CONSTRUCTOR
    public Calendar(int size){
        this.calendarObjList = new ArrayList<CalendarObject>(size);
        currentSize = 0;
    }


    /*
        Add calender object to calender list
     */
    public void addToCalendarObjList(CalendarObject obj){
        calendarObjList.add(obj);
        //  Sort

        currentSize++;
    }
    /*
        Delete calender object at index of list
     */
    public CalendarObject deleteCalendarObjectList(int index){
        currentSize--;
        CalendarObject temp = this.calendarObjList.get(index);
        this.calendarObjList.remove(index);
        //  Remove empty space in list

        return temp;
    }
    /*
        GETTERs & SETTERs
     */
    public ArrayList<CalendarObject> getCalendarObjList() {
        return calendarObjList;
    }
    public void setCalendarObjList(ArrayList<CalendarObject> calendarObjList) {
        this.calendarObjList = calendarObjList;
    }
    public int getCurrentSize() {
        return currentSize;
    }
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}
