package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /* TODO once LoginAuthenticator class and Account directory are done
        if (loginAuthenticator.authenticate) { // if username and password do not match
            error = "Username and Password are invalid.";
        } else { // username does not exist in Account directory
            error = "Username does not exist."
        }
         */
        // request.setAttribute("error", error); TODO error for login.jsp
    }
}
