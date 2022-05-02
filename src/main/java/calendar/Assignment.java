package calendar;

public class Assignment extends CalendarObject{
    private String completed;
    private String fileName;

    //  Used When adding new assignmnet, so it is okay to assume assignment is not completed
    public Assignment(String name,
                      Date date,
                      Time time,
                      String description,
                      String course,
                      String status) {
        super(name, date, time, description, course);
        status.replaceAll(","," ");
        this.completed = status;
    }

    @Override
    public String toString() {
        return  this.getDate() + "," +
                this.getTime() + "," +
                "A," +
                this.getName() + "," +
                this.getDescription() + "," +
                this.getCourse() + "," +
                this.getCompleted() + "," +
                this.getFileName();
    }

    @Override
    public void edit(String name,
                     Date date,
                     Time time,
                     String description,
                     String course,
                     String status) {
        super.edit(name,
                    date,
                    time,
                    description,
                    course);
        this.setCompleted(status);
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

    public String getFileName() { return fileName;}

    public void setFileName(String fileName) {this.fileName = fileName;}
}
