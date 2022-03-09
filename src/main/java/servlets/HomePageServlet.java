package servlets;

import calender.CalendarController;

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
    public static CalendarController calendarController = new CalendarController();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("assignments", calendarController.getCalenderList().get(0).getCalendarObjList());
        request.setAttribute("size", calendarController.getCalenderList().get(0).getCalendarObjList().size());
        /*
            Send the user to the index(home page) with the list of assignments
         */
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}