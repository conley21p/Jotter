package servlets;

import calendar.*;
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

        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String desc = request.getParameter("description");
        String cour = request.getParameter("course");
        /*
            Add a new assignmnet to the assignmnet list by sending HTTP request
         */
        try{
            HomePageServlet.user.getCurrCal().addNewToCalendarObjList(HomePageServlet.user.getUsername(),
                                                                      new Assignment(name,
                                                                                     new Date(date),
                                                                                     new Time(time),
                                                                                     desc,
                                                                                     cour,
                                                                                     "null",
                                                                                     "null"));
        } catch (Exception e){
            e.printStackTrace();
        }
        /*
            Send user to the page asking them is they want to add another or go to homepage
         */
        response.sendRedirect("AddAssignmentAfterSubmissionServlet");
    }
}
