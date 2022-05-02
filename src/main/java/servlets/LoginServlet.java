package servlets;

import User.User;
import authenticator.LoginAuthenticator;
import calendar.Calendar;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // logoff
        HomePageServlet.user = null;

        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String error;

        if (LoginAuthenticator.authenticate(username, password)) {
            System.out.println("Successfully logged in");
            String[] calendarNameList = CalendarController.getCalendarNameList(username);
            Calendar calendar = CalendarController.getCalendar(username, "School");
            // load user into the controller
            User user = new User(username, password, calendarNameList, calendar);
            HomePageServlet.user = user;
            System.out.println(user.getCurrCal().getName() + " checking");
            System.out.println("send redirect**************");
            response.sendRedirect("/HomePageServlet");
            return;
        } else {
            error = "Username and password do not match.";
            request.setAttribute("username", username);
        }

        request.setAttribute("error", error);
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
