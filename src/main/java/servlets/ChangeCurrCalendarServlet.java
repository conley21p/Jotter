package servlets;

import User.User;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeCurrCalendarServlet", value = "/ChangeCurrCalendarServlet")
public class ChangeCurrCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = HomePageServlet.user;
        request.setAttribute("assignments", user.getCurrCal().getCalendarObjList());
        request.setAttribute("size",        user.getCurrCal().getCalendarObjList().size());
        request.setAttribute("calName",     user.getCurrCal().getName());
        getServletContext().getRequestDispatcher("/changeCurrCalendar.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

