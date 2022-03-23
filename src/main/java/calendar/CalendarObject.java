package calendar;

public class CalendarObject {
    private String name;
    private Date date;
    private Time time;
    private String description;

    /*
      Main Constructor
       String format needs to be:
            "name:name, date:date, time:time, desc:description"
               -    Spaces are optional
     */
    public CalendarObject(String obj){
        System.out.println("Stringobj:"+obj);
        String temp[] = obj.split(",");
        this.name       = temp[0];
        this.date       = new Date(temp[1]);
        if (!temp[2].isEmpty()){
            this.time       = new Time(temp[2]);
        }
        if (temp.length > 3){
            this.description= temp[3];
        }




    }
    //  Overloaded constructor
    public CalendarObject(String name,
                          Date date,
                          Time time,
                          String description){
        this.name           = name;
        this.date           = date;
        this.time           = time;
        this.description    = description;
    }

    @Override
    public String toString() {
        return "CalendarObject{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }

    /*
        GETTERs & SETTERs
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
