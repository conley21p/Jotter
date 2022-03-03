package servlets;

import calender.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAssignmentServlet", urlPatterns = "/AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("forward to addAssignment.jsp");
        /*
            Send user to the add assignment page
         */
        getServletContext().getRequestDispatcher("/addAssignment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder calenderObj = new StringBuilder();
        calenderObj.append(request.getParameter("name") + ",");
        System.out.println("time" +request.getParameter("time") + "," );
        calenderObj.append(request.getParameter("date") + ",");
        calenderObj.append(request.getParameter("time") + ",");
        calenderObj.append(request.getParameter("description") + ",");
        /*
            Add a new assignmnet ot the assignmnet list by sending HTTP request
         */
        try{
            HomePageServlet.calendarController.getCalenderList().get(0).addToCalenderObjList(new Assignmnet(calenderObj.toString()));
        } catch (Exception e){
            e.printStackTrace();
        }
        /*
            Send user to the page asking them is they want to add another or go to homepage
         */
        response.sendRedirect("AddAssignmentAfterSubmissionServlet");
    }
}
