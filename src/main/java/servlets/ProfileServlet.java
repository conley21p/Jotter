package servlets;

import account.AccountManager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "ProfileServlet", value = "/profile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String decision = request.getParameter("decision");
        if (decision.equals("deleteAccount")) {
        //    if (AccountManager.deleteAccount(UserController.getUser())) {
        //        System.out.println("account " + UserController.getUser() + "deleted with UserController");
        //        UserController.logoff();
            }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
