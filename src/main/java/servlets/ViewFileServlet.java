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


@WebServlet(name = "ViewFileServlet", urlPatterns = "/ViewFile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)

public class ViewFileServlet extends HttpServlet {
    private Assignment currentAssignment;

    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String filePath = PathFinder.getAccountFilesPath(HomePageServlet.user.getUsername());
        //Need to make this generalizable
        Enumeration<String> parameterNames = request.getParameterNames();
        String assignName = parameterNames.nextElement();
        currentAssignment = (Assignment) HomePageServlet.user.getCurrCal().getCalendarObject(assignName);
        String fileName = currentAssignment.getFileName();
        System.out.println(fileName);
        //fileName = "Batman.png";
        //This is what's causing the download
        response.setContentType("image/png");

        ServletOutputStream out;
        out = response.getOutputStream();
        FileInputStream flinp = new FileInputStream(filePath + "/" + fileName);
        BufferedInputStream buffinp = new BufferedInputStream(flinp);
        BufferedOutputStream buffoup = new BufferedOutputStream(out);

        int ch=0;
        while ((ch=buffinp.read()) != -1) {
            buffoup.write(ch);
        }

        buffinp.close();
        flinp.close();
        buffoup.close();
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}