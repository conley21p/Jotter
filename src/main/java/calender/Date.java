package calender;

public class Date {
    private int year;
    private int month;
    private int day;

    //  String date format needs to be mm/dd/yyyy
    public Date(String date){
        String temp[] = date.split("-");

        this.year   = Integer.parseInt(temp[2]);
        this.month  = Integer.parseInt(temp[0]);
        this.day    = Integer.parseInt(temp[1]);
    }
    public Date(String m, String d, String y){
        this.year   = Integer.parseInt(y);
        this.month  = Integer.parseInt(m);
        this.day    = Integer.parseInt(d);
    }
    public Date(int m, int d, int y){
        this.year   = y;
        this.month  = m;
        this.day    = d;
    }

    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /*
            GETTERs & SETTERs
         */
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
}
