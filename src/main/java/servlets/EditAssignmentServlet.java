package servlets;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.time.LocalDateTime;

import calendar.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAssignmentServlet", value = "/editAssign")
public class EditAssignmentServlet extends HttpServlet {
    private Assignment editingObject;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Get assignment info and send to edit page
        Enumeration<String> parameterNames = request.getParameterNames();
        String assignName = parameterNames.nextElement();
        //System.out.println("parameName"+assignName);

        editingObject = (Assignment) HomePageServlet.user.getCurrCal().getCalendarObject(assignName);

        //Set attributes for edit assignment
        request.setAttribute("CalObj", editingObject);

        System.out.println(editingObject.getDate().toString() + "   Completed Status:" + editingObject.getCompleted());

        getServletContext().getRequestDispatcher("/editAssignment.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuilder calendarObj = new StringBuilder();
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String desc = request.getParameter("description");
        String cour = request.getParameter("course");
        String status;

        System.out.println("button Flag" + request.getParameter("button") + ".");
        if (request.getParameter("button").compareTo("Update") == 0) {
            if (request.getParameter("status") == null) {
                status = "null";
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm");
                System.out.println("Completed date:" + dtf.format(LocalDateTime.now()));
                status = dtf.format(LocalDateTime.now());
            }
            /*
                Add a new assignmnet to the assignmnet list by sending HTTP request
             */
            editingObject.edit( name,
                                new Date(date),
                                new Time(time),
                                desc,
                                cour,
                                status);
            editingObject.updateToDataBase(HomePageServlet.user.getUsername(), HomePageServlet.user.getCurrCal().getName());

            /*
                Send user to the page asking them is they want to add another or go to homepage
             */
            response.sendRedirect("HomePageServlet");
        } else if (request.getParameter("button").compareTo("Delete") == 0) {
            int index = HomePageServlet.user.getCurrCal().getCalendarObjList().indexOf(editingObject);
            System.out.println("Index of deleting object is:" + index);
            //  Delete Object from database
            CalendarObject deleted = CalendarController.deleteCalendarObject(index);
            deleted.saveToDataBase(HomePageServlet.user.getUsername(), "DELETED_ITEMS");
            response.sendRedirect("HomePageServlet");
            return;

        } else if (request.getParameter("button").compareTo("Create Copy") == 0) {
            /*
            Add a new assignmnet to the assignmnet list by sending HTTP request
         */
            try {
//                System.out.println("Creating copy");
                HomePageServlet.user.getCurrCal().addNewToCalendarObjList(HomePageServlet.user.getUsername(),
                                                                          new Assignment(name,
                                                                                        new Date(date),
                                                                                        new Time(time),
                                                                                        desc,
                                                                                        cour,
                                                                                        "null"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        /*
            Send user to the page asking them is they want to add another or go to homepage
         */
            response.sendRedirect("AddAssignmentAfterSubmissionServlet");
            return;
        }else if(request.getParameter("button").compareTo("Return To Home Page") == 0){
            response.sendRedirect("HomePageServlet");
            return;
        }else{
            System.err.println("Error:No button was selected on the edit page.");
        }
    }

}
