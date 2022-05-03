package servlets;

import calendar.Calendar;
import calendar.CalendarController;
import calendar.CalendarObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "HistoryPage", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar deletedItemsCalendar = CalendarController.getCalendar(HomePageServlet.user.getUsername(), "DELETED_ITEMS");

        request.setAttribute("assignments", deletedItemsCalendar.getCalendarObjList());
        request.setAttribute("size",    deletedItemsCalendar.getCalendarObjList().size());
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String objectName = request.getParameter("restore");
        String username = HomePageServlet.user.getUsername();
        Calendar currCalendar = HomePageServlet.user.getCurrCal();
        Calendar deletedItemsCalendar = CalendarController.getCalendar(username, "DELETED_ITEMS");
        CalendarObject itemToRestore = deletedItemsCalendar.getCalendarObject(objectName);

        // delete object and save it to the School calendar
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(username, itemToRestore);
        ArrayList<CalendarObject> objects = deletedItemsCalendar.getCalendarObjList();
        int restoreIndex = -1;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getName().equals(objectName))
                restoreIndex = i;
        }
        System.out.println(restoreIndex);
        HomePageServlet.user.setCurrCal(deletedItemsCalendar);
        CalendarController.deleteCalendarObject(restoreIndex);
        HomePageServlet.user.setCurrCal(currCalendar);


        // return to history page
        request.setAttribute("assignments", deletedItemsCalendar.getCalendarObjList());
        request.setAttribute("size",    deletedItemsCalendar.getCalendarObjList().size());
        getServletContext().getRequestDispatcher("/history.jsp").forward(request, response);
    }
}
