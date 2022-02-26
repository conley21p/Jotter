package calenderObj;

public class Assignment extends CalenderObject{

    private boolean status = false;

    //  Assignment Constructor
    Assignment(String name,
               String date,
               String time,
               String description){
        this.name           = name;
        this.date           = date;
        this.time           = time;
        this.description    = description;
    }


    /*
        Edit local variables of assignment object
     */
    @Override
    public void edit(String updates) {
        for (String update:
             updates.split(",")) {
            String attribute = update.substring(0,update.indexOf(':'));
            String val = update.substring(update.indexOf(":")+1);
            switch (attribute){
                case "name:":
                    this.name = val;
                    break;
                case "date":
                    this.date = val;
                    break;
                case "time":
                    this.time = val;
                case "description":
                    this.description = val;
                case "status":
                    if (val.compareTo("T")==0){
                        this.status = true;
                    }else{
                        this.status = false;
                    }
                    break;

                default:
                    System.err.println("Value not matched\n");
//                    throw new IllegalStateException("Unexpected value: " + attribute);
            }
        }
    }

    @Override
    public void BackUpToCSV() {

    }


}
