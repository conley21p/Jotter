package calenderObj;

import java.util.ArrayList;

public class Controller {


    private static ArrayList<Assignment> assignments = new ArrayList<>(10);

//    public static void main(){
//
//    }


    public static void addAssignmentlist(String name,
                             String date,
                             String time,
                             String description){
        assignments.add(new  Assignment(name,
                                        date,
                                        time,
                                        description));
    }
    public static String getAssignment()
    {
        StringBuilder temp = new StringBuilder();
        for (Assignment assign: assignments) {
            temp.append(assign.getName());
        }
        return temp.toString();
    }
    public static String getAssignment(int index)
    {
        return assignments.get(index).getName();
    }
    public static ArrayList<Assignment> getAssignments(){

        return assignments;
    }


}
