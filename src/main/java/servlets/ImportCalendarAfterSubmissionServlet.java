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

    }
}
