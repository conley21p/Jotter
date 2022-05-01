package servlets;

import User.User;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChangeCurrCalendarServlet", urlPatterns = "/ChangeCurrCalendar")
public class ChangeCurrCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("calendars", HomePageServlet.user.getCalendarNames());
        //request.setAttribute("size",        HomePageServlet.user.getCurrCal().getCalendarObjList().size());
        //request.setAttribute("calName",     HomePageServlet.user.getCurrCal().getName());

        /*
            Send the user to the index(home page) with the list of assignments
         */
        getServletContext().getRequestDispatcher("/changeCurrCalendar.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

