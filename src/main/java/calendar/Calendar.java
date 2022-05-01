package calendar;

import account.AccountManager;

import java.util.ArrayList;
import java.util.Collections;

public class Calendar {
    private ArrayList<CalendarObject> calendarObjList;
    private String name;
    private int currentSize;


    //  CONSTRUCTOR
    public Calendar(){
        this.calendarObjList = new ArrayList<CalendarObject>(5);
        currentSize = 0;
        this.name = "School";
    }
    public Calendar(int size,String name){
        this.calendarObjList = new ArrayList<CalendarObject>(size);
        currentSize = 0;
        if (name.isEmpty()){
            this.name = "School";
        }else{
            this.name = name;
        }
    }


    /*
        Add calender object to calender list
     */
    public void addToCalendarObjList(CalendarObject obj){
        //  Add New Object to list
        calendarObjList.add(obj);
        currentSize++;
    }
    /*
        Add calender object to calender list
     */
    public void addNewToCalendarObjList(String username,CalendarObject obj){
        //  Add New Object to list
        calendarObjList.add(obj);
        System.out.println("save to database username:" + username + " calName:" + this.name);
        //Save object to database
        obj.saveToDataBase(username,
                            this.name);

        currentSize++;
    }
    /*
        Get calender object from given name of list
     */
    public CalendarObject getCalendarObject(String name){
        currentSize--;
        for (CalendarObject cal: this.calendarObjList) {
//            System.out.println(cal.getName());
            if (cal.getName().equals(name)){
                return cal;
            }
        }
        System.out.println("No calendar Match was found for getting to edit");
        return null;
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

    public void sortCalendar()
    {
        Collections.sort(this.calendarObjList, CalendarObject.CalCourseComparator);
    }

    public int generateAnalysis()
    {
        int completedAssignments = 0;
        for (int i = 0; i < currentSize; i++)
        {
            if (calendarObjList.get(i).getCompleted() != "null")
                completedAssignments++;
        }
        System.out.println(completedAssignments);
        return completedAssignments;
    }

    public int getCurrentSize() {
        return currentSize;
    }
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
