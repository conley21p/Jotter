package servlets;
import utils.PathFinder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "ImportCalendarServlet", value = "/ImportCalendarServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class ImportCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("forward to importCalendar.jsp");
        /*
            Send user to the add assignment page
         */
        getServletContext().getRequestDispatcher("/importCalendar.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("HomePageServlet");
        File accountInfoFile = new File(PathFinder.getAccountInformationPath(HomePageServlet.user.getUsername()));
    }
}
