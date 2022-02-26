package calenderObj;

abstract class CalenderObject{
    protected String name;
    protected String date;
    protected String time;
    protected String description;

    //  Edit local variables of calender object
    public abstract void edit(String updates);
    //  Create a backup entry in the database for calender object
    public abstract void BackUpToCSV();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}