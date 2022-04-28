package servlets;

import account.AccountManager;
import authenticator.LoginAuthenticator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String decision = request.getParameter("decision");

        // delete account
        if (decision.equals("deleteAccount")) {
            if (AccountManager.deleteAccount(HomePageServlet.user.getUsername())) {
                System.out.println("Account " + HomePageServlet.user.getUsername() + " was deleted.");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response); // return to profile page
            }
        }
        // change password
        else if (decision.equals("changePassword")) {
            String newPassword = request.getParameter("newPassword");
            if (AccountManager.changePassword(newPassword)) {
                System.out.println("Changed password to " + newPassword);
                message = "Password change successful.";
            }
            else {
                message = "Could not change password.";
            }
        }

        request.setAttribute("message", message); // message or error to display to the user
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
