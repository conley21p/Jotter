package servlets;

import calendar.Calendar;
import calendar.CalendarObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAssignmentServlet", value = "/editAssign")
public class EditAssignmentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Get assignment info and send to edit page
        String assignName = request.getParameter("assignName");
        System.out.println("assignName name is "+ assignName);

        CalendarObject editObj = HomePageServlet.user.getCurrCal().getCalendarObject(assignName);

        //Set attributes for edit assignment
        request.setAttribute("CalObj", editObj);

        getServletContext().getRequestDispatcher("/editAssignment.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
