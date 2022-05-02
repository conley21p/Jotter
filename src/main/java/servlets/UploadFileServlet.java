package servlets;
import calendar.Assignment;
import calendar.CalendarController;
import utils.PathFinder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet(name = "UploadFileServlet", urlPatterns = "/UploadFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class UploadFileServlet extends HttpServlet {
    private Assignment currentAssignment;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();
        String assignName = parameterNames.nextElement();

        currentAssignment = (Assignment) HomePageServlet.user.getCurrCal().getCalendarObject(assignName);
        request.setAttribute("CalObj", currentAssignment);

        getServletContext().getRequestDispatcher("/uploadFile.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String fileName = null;
        String uploadPath = PathFinder.getAccountFilesPath(HomePageServlet.user.getUsername());
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();
        for (Part part : request.getParts()) {
            fileName = part.getSubmittedFileName();
            if (fileName != null){
                part.write(uploadPath + File.separator + fileName);
                break;
            }
        }
        currentAssignment.setFileName(fileName);
        currentAssignment.updateToDataBase(HomePageServlet.user.getUsername(), HomePageServlet.user.getCurrCal().getName());
        System.out.println(currentAssignment.getFileName());

        message = "File Successfully Uploaded";
        getServletContext().setAttribute("message", message);
        getServletContext().getRequestDispatcher("/uploadFile.jsp").forward(request, response);
    }
}
