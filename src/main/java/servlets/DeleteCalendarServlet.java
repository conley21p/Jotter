package servlets;

import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "DeleteCalendarServlet", urlPatterns = "/deleteCalendar")
public class DeleteCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<String> cals = new ArrayList<String>();
        HomePageServlet.user.getCalendarNames();
        for (int i = 1; i < CalendarController.getCalendarNameList(HomePageServlet.user.getUsername()).length; i++){
            if (CalendarController.getCalendarNameList(HomePageServlet.user.getUsername())[i] != null)
                cals.add(i - 1, CalendarController.getCalendarNameList(HomePageServlet.user.getUsername())[i]);
        }
        request.setAttribute("calendars", cals);
        request.setAttribute("size", HomePageServlet.user.getCalendarNames().length);

        getServletContext().getRequestDispatcher("/deleteCalendar.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        String calendarName = parameterNames.nextElement();
        String error = null;

        if (CalendarController.deleteCalendar(HomePageServlet.user.getUsername(), calendarName)) {
            System.out.println("Calendar was successfully deleted.");
            HomePageServlet.user.setCurrCal(CalendarController.getCalendar(HomePageServlet.user.getUsername(), HomePageServlet.user.getCalendarNames()[1]));
            response.sendRedirect("/HomePageServlet");
            return;
        } else {
            error = "Must have at least one calendar.";
        }

        request.setAttribute("error", error);
        getServletContext().getRequestDispatcher("/deleteCalendar.jsp").forward(request, response);
    }
}
