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
                      String status,
                      String fileName) {
        super(name, date, time, description, course);
        if (status != null){
            status = status.replace(",","");
        }
        this.completed = status;
        this.fileName = fileName;
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
    public boolean edit(String name,
                        Date date,
                        Time time,
                        String description,
                        String course,
                        String status) {
        boolean result = super.edit(name,
                                    date,
                                    time,
                                    description,
                                    course);
        try{
            this.setCompleted(status);
        }catch (Exception e){
            return false;
        }
        return result;
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
