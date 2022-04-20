package calendar;

public class Assignment extends CalendarObject{
    private String completed;

    public Assignment(String obj) {
        super(obj);
        this.completed = "null";
    }

    public Assignment(String name, Date date, Time time, String description) {
        super(name, date, time, description);
        this.completed = "null";
    }

    @Override
    public String toString() {
        return  this.getDate() + "," +
                this.getTime() + "," +
                "A," +
                this.getName() + "," +
                this.getDescription() + "," +
                this.getCompleted();
    }

    @Override
    public void edit(String updatedString) {
        super.edit(updatedString);
        String[] attrs = updatedString.split(",");
        if (attrs.length >= 4){
            this.setCompleted(attrs[4]);
        }
    }

    /*
        GETTERs & SETTERs
     */

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }
}
