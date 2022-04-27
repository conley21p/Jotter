package servlets;

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
//            if (AccountManager.deleteAccount(UserController.getUser())) {
//                System.out.println("account " + UserController.getUser() + "deleted with UserController");
//                UserController.logoff();
//            }
        } else if ("import".equals(decision))
        {
            if (request.getParameter("file") != null)
            {
                ClassLoader loader = AccountManager.class.getClassLoader();
                String tempPath = loader.getResource("account/AccountManager.class").toString();
                String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
                //For Jacob's use
                jotterPath = "C:/Users/Jacob Radtke/IdeaProjects/Jotter";
                String accountsPath = jotterPath + "/src/main/java/account/accounts";
                System.out.println("Jotter:: " + jotterPath);
                System.out.println("Accounts:: " + accountsPath);
                System.out.println(request.getParameter("file"));
            }
        }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
