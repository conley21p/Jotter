package servlets;

import User.User;
import calendar.Calendar;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomePageServlet", value = "/HomePageServlet")
public class HomePageServlet extends HttpServlet {
    /*
        Create a calendar controller object.
            -calendarController is basically the live database
     */
    public static User user = new User("conley",
            CalendarController.getCalendarNameList("conley"),
            CalendarController.getCalendar("conley","School.csv"));
//    public static User user = new User();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("assignments", user.getCurrCal().getCalendarObjList());
        request.setAttribute("size",        user.getCurrCal().getCalendarObjList().size());
        request.setAttribute("calName",     user.getCurrCal().getName());
        System.out.println("CalName:" + user.getCurrCal().getName()+ "\n");


        /*
            Send the user to the index(home page) with the list of assignments
         */
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}