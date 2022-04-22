package servlets;

import User.UserController;
import account.AccountManager;

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
        String decision = request.getParameter("decision");
        if (decision.equals("deleteAccount")) {
            if (AccountManager.deleteAccount(UserController.getUsername())) {
                System.out.println("Account " + UserController.getUsername() + " was deleted.");
                UserController.dropUser();
            }
        }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
