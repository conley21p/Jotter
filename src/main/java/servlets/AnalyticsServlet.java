package servlets;

import User.User;
import authenticator.LoginAuthenticator;
import calendar.Calendar;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Analytic", urlPatterns = "/Analytic")
public class AnalyticsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/analytics.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        int comAssignments = HomePageServlet.user.getCurrCal().generateAnalysis();
        int totalAssignments = HomePageServlet.user.getCurrCal().getCurrentSize();

        message = "You have completed " + comAssignments + " out of " + totalAssignments + " assignments.";

        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/analytics.jsp").forward(request, response);
    }
}
