package servlets;

import account.AccountManager;
import calendar.CalendarController;
import User.UserController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterPage", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        String error = null;

        // username is taken
        if (false) { // TODO Authenticator checks if username is already taken
            error = "Username is already taken. Please try a different username.";
        }
        // passwords do not match
        else if (!password.equals(confirmPassword)) {
            error = "Passwords do not match.";
            request.setAttribute("email", email); // maintaining email information for convenience
            request.setAttribute("username", username); // maintaining username information for convenience
        }
        // no user-created errors
        else {
            if (AccountManager.createAccount(username, password, email)) {
                System.out.println("Account creation succeeded.");
                String[] calendarNameList = CalendarController.getCalendarNameList(username);
                UserController.loadUser(username, password, calendarNameList, CalendarController.getCalendar(username, calendarNameList[0]));

                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); // go to homepage with new account
            } else {
                error = "We could not create your account. Please try again later.";
            }
        }
        request.setAttribute("error", error); // error to display to the user
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response); // return to register page
    }
}
