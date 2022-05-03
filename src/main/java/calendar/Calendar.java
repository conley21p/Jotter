package calendar;

import account.AccountManager;
import servlets.HomePageServlet;
import utils.PathFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
        System.out.println("Printing ObjectList after delete");
        for (CalendarObject calObj : this.calendarObjList)
        {
            System.out.println(calObj.toString());
        }
        Calendar school = HomePageServlet.user.getCurrCal();
        System.out.println("Printing SCHOOL ObjectList after delete");
        for (CalendarObject calObj : school.getCalendarObjList())
        {
            System.out.println(calObj.toString());
        }
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

    public boolean sortCalendar()
    {
        Collections.sort(this.calendarObjList, CalendarObject.CalCourseComparator);
        return true;
    }

    public int generateAnalysis()
    {
        int completedAssignments = 0;
        for (int i = 0; i < currentSize; i++)
        {
            Assignment assign = (Assignment) calendarObjList.get(i);
            if (assign.getCompleted().contains("20"))
                completedAssignments++;
        }
        System.out.println(completedAssignments);
        return completedAssignments;
    }

//    //TODO Generate Time Slots
//    public void generateTimeSlots() {
//
//    }
//
//    //TODO method to help with generating time slots
//    public int[][] getCalendarObjDates(String username, String calName, int objects) {
//        String[] segments = new String[objects];
//        String calPath = PathFinder.getAccountCalendarsPath(username) + "/" + calName;
//        File calFile = new File(calPath);
//        if (calFile.exists()) {
//            for (int i = 0; i < objects; i++) {
//                try {
//                    Scanner scan = new Scanner(calFile);
//                    String calInfo = scan.nextLine();
//                    segments = calInfo.split(",");
//                    scan.close();
//                } catch (FileNotFoundException e) {
//                    System.out.println("Could not find Calendar");
//                    e.printStackTrace();
//                }
//            }
//        }
//        String[] fullDates = new String[objects];
//        for (int i = 0; i < objects; i++) {
//            fullDates[i] = segments[i].substring(0, 10);
//        }
//        int[][] dates = new int[objects][3];
//        for (int j = 0; j < objects; j++) {
//
//        }
//        return dates;
//    }

//    //TODO Compare Schedules using generate time slots
//    public String compareSchedules(String calName1, String calName2) {
//
//    }

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
