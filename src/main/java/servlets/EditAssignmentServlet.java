package servlets;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.time.LocalDateTime;

import calendar.Assignment;

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
        calendarObj.append(request.getParameter("name") + ",");
        calendarObj.append(request.getParameter("date") + ",");
        calendarObj.append(request.getParameter("time") + ",");
        calendarObj.append(request.getParameter("description") + ",");

        if (request.getParameter("button") == "update") {
            if (request.getParameter("status") == null) {
                calendarObj.append("null");
            } else {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm");
                System.out.println("Completed date:" + dtf.format(LocalDateTime.now()));
                calendarObj.append(dtf.format(LocalDateTime.now()));
            }
            /*
                Add a new assignmnet to the assignmnet list by sending HTTP request
             */
            editingObject.edit(calendarObj.toString());
            editingObject.updateToDataBase(HomePageServlet.user.getUsername(), HomePageServlet.user.getCurrCal().getName());

            /*
                Send user to the page asking them is they want to add another or go to homepage
             */
            response.sendRedirect("HomePageServlet");
        }else{
            /*
            Add a new assignmnet to the assignmnet list by sending HTTP request
         */
            try{
                System.out.println("Creating copy");
                HomePageServlet.user.getCurrCal().addNewToCalendarObjList(HomePageServlet.user.getUsername(),
                                                        new Assignment(calendarObj.toString()));
                System.out.println("Created copy");
            } catch (Exception e){
                e.printStackTrace();
            }
        /*
            Send user to the page asking them is they want to add another or go to homepage
         */
            response.sendRedirect("AddAssignmentAfterSubmissionServlet");
        }
    }
}
