package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddAssignmentAfterSubmissionServlet", value = "/AddAssignmentAfterSubmissionServlet")
public class ImportCalendarAfterSubmissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Forward to add assignment page
        getServletContext().getRequestDispatcher("/ImportCalendar.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String choice = request.getParameter("choice");
//        System.out.println("choice" + choice);
//        if (choice == "Yes"){
//            System.out.println("forward to addAssignment.jsp");
//            response.sendRedirect("addAssignment.jsp");
//        }else{
//            System.out.println("HomePageServlet.jsp");
//            response.sendRedirect("/HomePageServlet");
//        }

    }
}
