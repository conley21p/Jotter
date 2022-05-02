package calendar;

public class Time {
    private int hour;
    private int min;

    /*
      Constructor works with passing time as a string
        Format: hour:min or hour:min:sec
                            - Seconds will not be stored
     */
    public Time(String time){
        //System.out.println("Time:time:"+time);
        String temp[] = time.split(":");
        this.hour   = Integer.parseInt(temp[0]);
        this.min    = Integer.parseInt(temp[1]);
    }
    public Time(String h, String m){
        this.hour   = Integer.parseInt(h);
        this.min    = Integer.parseInt(m);
    }
    //  Overload constructor to work with passing actual hour and min value
    public Time(int h, int m){
        this.hour   = h;
        this.min    = m;
    }

    @Override
    public String toString() {
        return hour + ":" + min;
    }

    /*
            GETTERS and SETTERS
         */
    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
}
