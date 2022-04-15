package servlets;

import User.User;
import authenticator.LoginAuthenticator;
import calendar.CalendarController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // loggin off
        /*
        HomePageServlet.user = new User();
         */
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String error = null;

        if (LoginAuthenticator.authenticate(username, password)) {
            System.out.println("Successfully logged in");
            String[] calList    = CalendarController.getCalendarNameList(username);
            HomePageServlet.user = new User(username,
                                            calList,
                                            CalendarController.getCalendar(username,calList[0]));
            System.out.println(HomePageServlet.user.getCurrCal().getName() + " checking");
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
