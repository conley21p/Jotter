package servlets;

import User.User;
import calendar.Calendar;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HistoryPage", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curCalendar = HomePageServlet.user.getCurrCal().getName();
        HomePageServlet.user.setCurrCal(CalendarController.getCalendar(HomePageServlet.user.getUsername(), "DELETED_ITEMS"));
        request.setAttribute("assignments", HomePageServlet.user.getCurrCal().getCalendarObjList());
            request.setAttribute("size",    HomePageServlet.user.getCurrCal().getCalendarObjList().size());
        request.setAttribute("calName",     HomePageServlet.user.getCurrCal().getName());
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }
}
