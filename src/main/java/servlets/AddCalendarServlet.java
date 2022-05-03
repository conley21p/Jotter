package servlets;

import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddCalendarServlet", urlPatterns = "/addCalendar")
public class AddCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/addCalendar.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String calendarName = request.getParameter("calendarName");

        if (CalendarController.addCalendar(HomePageServlet.user.getUsername(), calendarName)) {
            System.out.println("New calendar " + calendarName + " was created.");
        }

        HomePageServlet.user.setCurrCal(CalendarController.getCalendar(HomePageServlet.user.getUsername(), calendarName));
        response.sendRedirect("/HomePageServlet");
    }
}
