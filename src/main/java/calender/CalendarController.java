package calender;

import java.util.ArrayList;

public class CalendarController {
    private ArrayList<Calendar> calenderList;

    public CalendarController(){
        this.calenderList = new ArrayList<Calendar>(0);
        this.calenderList.add(new Calendar(50));
    }
    public CalendarController(int size){
        calenderList = new ArrayList<Calendar>(size);
    }
    /*
        GETTERs & SETTERs
     */

    public ArrayList<Calendar> getCalenderList() {
        return calenderList;
    }
    public Calendar getCalenderListObj(int index) {
        return calenderList.get(index);
    }
    public void setCalenderList(ArrayList<Calendar> calenderList) {
        this.calenderList = calenderList;
    }

}
