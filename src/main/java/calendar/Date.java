package calendar;


public class Date {
    private int year;
    private int month;
    private int day;

    //  String date format needs to be mm/dd/yyyy
    public Date(String date){
        //System.out.println("Date constructor param:"+date);
        String temp[] = date.split("-");

        this.year   = Integer.parseInt(temp[0]);
        this.month  = Integer.parseInt(temp[1]);
        this.day    = Integer.parseInt(temp[2]);
    }
    public Date(String y, String m, String d){
        this.year   = Integer.parseInt(y);
        this.month  = Integer.parseInt(m);
        this.day    = Integer.parseInt(d);
    }
//    public Date(int m, int d, int y){
//        this.year   = y;
//        this.month  = m;
//        this.day    = d;
//    }



    @Override
    public String toString() {
        //System.out.println("year for date is:"+ this.year);
        StringBuilder result = new StringBuilder(this.year + "-" + this.month + "-" + this.day);
        if (this.month < 10){
            result = new StringBuilder(this.year + "-0" + this.month + "-" + this.day);
        }
        if (this.day < 10){
            result.setCharAt(result.length()-1,'0');
            result.append(this.day);
        }
        return result.toString();
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

//    @Override
    public int compare(Date dateObj) {
        if (this.year > dateObj.year){
            return 1;
        }else if(this.year < dateObj.year){
            return -1;
        }else{
            //This means years are the same, so compare month
            if(this.month > dateObj.month){
                return 1;
            }else if(this.month < dateObj.month){
                return -1;
            }else{
                //This means that there year and month are the same, check day
                if (this.day > dateObj.day){
                    return 1;
                }else if(this.day < dateObj.day){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }

}
