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
                //need to figure out how to generalize username
                String accountsPath = jotterPath + "/src/main/java/account/accounts/" + "jacob" + "/Calendars/";
                System.out.println("Jotter:: " + jotterPath);
                System.out.println("Accounts:: " + accountsPath);
                System.out.println(request.getParameter("file"));


                for (Part part : request.getParts()) {
                    String fileName = part.getSubmittedFileName();;
                    part.write(accountsPath + File.separator + fileName);
                }
            }
        }
        getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response); // return to profile page
    }
}
