package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import calenderObj.Controller;

@WebServlet(name = "AddAssignmentServlet", urlPatterns = "/AddAssignmentServlet")
public class AddAssignmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("forward to addAssignment.jsp");
        //  Forward to add assignment page
        getServletContext().getRequestDispatcher("/addAssignment.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name         = request.getParameter("name");
        String date         = request.getParameter("date");
        String time         = request.getParameter("time");
        String description  = request.getParameter("description");

        try{
            Controller.addAssignmentlist(name,date,time,description);
        } catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("The POST request has been made to /addAssignment");
        System.out.printf("Name:%s, Date:%s, Time:%s ,Desc:%s\n",name,date,time, description);

        System.out.println("forward to addAssignment.jsp");
        //  Forward to add assignment page
        response.sendRedirect("AddAssignmentAfterSubmissionServlet");
    }
}
