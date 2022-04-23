package servlets;

import User.UserController;
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
        String curCalendar = UserController.getCurCalendar().getName();
        UserController.setCurCalendar(CalendarController.getCalendar(UserController.getUsername(), "DELETED_ITEMS"));
        request.setAttribute("assignments", UserController.getCurCalendar().getCalendarObjList());
        request.setAttribute("size",        UserController.getCurCalendar().getCalendarObjList().size());
        request.setAttribute("calName",     UserController.getCurCalendar().getName());
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }
}
