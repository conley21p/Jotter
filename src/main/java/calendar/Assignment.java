package calendar;

public class Assignment extends CalendarObject{
    private boolean completed;

    public Assignment(String obj) {
        super(obj);
        this.completed = false;
    }

    public Assignment(String name, Date date, Time time, String description) {
        super(name, date, time, description);
        this.completed = false;
    }

    /*
        GETTERs & SETTERs
     */

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
