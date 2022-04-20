package servlets;
import java.util.Enumeration;

import calendar.Assignment;
import calendar.Calendar;
import calendar.CalendarObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAssignmentServlet", value = "/editAssign")
public class EditAssignmentServlet extends HttpServlet {
    private CalendarObject editingObject;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //  Get assignment info and send to edit page
        Enumeration<String> parameterNames = request.getParameterNames();
        String assignName = parameterNames.nextElement();
        System.out.println("parameName"+assignName);

        editingObject = HomePageServlet.user.getCurrCal().getCalendarObject(assignName);

        //Set attributes for edit assignment
        request.setAttribute("CalObj", editingObject);

        getServletContext().getRequestDispatcher("/editAssignment.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder calendarObj = new StringBuilder();
        calendarObj.append(request.getParameter("name") + ",");
//        calendarObj.append(request.getParameter("date") + ",");
        calendarObj.append("temp,");
        calendarObj.append(request.getParameter("time") + ",");
        calendarObj.append(request.getParameter("description") + ",");
        calendarObj.append(request.getParameter("status"));

        System.out.println("builderTostring:" + calendarObj.toString());


        /*
            Add a new assignmnet to the assignmnet list by sending HTTP request
         */
        editingObject.edit(calendarObj.toString());
        editingObject.updateToDataBase(HomePageServlet.user.getUsername(),HomePageServlet.user.getCurrCal().getName());

        /*
            Send user to the page asking them is they want to add another or go to homepage
         */
        response.sendRedirect("HomePageServlet");

    }
}
