package servlets;
import utils.PathFinder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "ImportCalendarServlet", urlPatterns = "/ImportCalendar")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class ImportCalendarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("forward to ImportCalendar.jsp");
        /*
            Send user to the add assignment page
         */
        getServletContext().getRequestDispatcher("/ImportCalendar.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = PathFinder.getAccountCalendarsPath(HomePageServlet.user.getUsername());
        File uploadDir = new File(uploadPath);
        //if (!uploadDir.exists()) uploadDir.mkdir();

        for (Part part : request.getParts()) {
            String fileName = part.getSubmittedFileName();
            part.write(uploadPath + File.separator + fileName);
        }

        getServletContext().getRequestDispatcher("/ImportCalendar.jsp").forward(request, response);
    }
}
