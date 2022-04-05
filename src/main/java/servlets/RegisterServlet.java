package servlets;

import account.AccountManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterPage", urlPatterns = "/RegisterServlet")
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

        if (!password.equals(confirmPassword)) {
            error = "Passwords do not match.";
            System.out.println("Check");
        } else if (false) { // TODO Authenticator checks if username is already taken
            error = "Username is already taken. Please try a different username";
        } else {
            if (AccountManager.makeAccount(username, password, email)) { // Happy Path
                System.out.println("Account created.");
                getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // go to homepage
            } else {
                error = "Account creation failed";
                request.setAttribute("username", username); // maintaining valid entry
            }
        }
        request.setAttribute("email", email); // maintaining valid entry
        request.setAttribute("error", error);
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response); // return to register page
    }
}
