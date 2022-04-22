package servlets;

import User.UserController;
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
            if (AccountManager.deleteAccount(UserController.getUsername())) {
                System.out.println("Account " + UserController.getUsername() + " was deleted.");
                UserController.dropUser();
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response); // return to profile page
            }
        }
        // change password
        else if (decision.equals("changePassword")) {
            String newPassword = request.getParameter("newPassword");
            if (AccountManager.changePassword(newPassword)) {
                System.out.println("Changed password to " + newPassword);
                message = "Password change successful.";
                UserController.setPassword(newPassword);
            }
            else {
                message = "Could not change password.";
            }
        }

        request.setAttribute("message", message); // message or error to display to the user
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
