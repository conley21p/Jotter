package servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DownloadServlet")

public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fileName = HomePageServlet.user.getCurrCal().getName();
        String filePath = utils.PathFinder.getAccountCalendarsPath(HomePageServlet.user.getUsername());

        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + fileName + "\"");

        FileInputStream fileInputStream = new FileInputStream(filePath
                + fileName);

        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
}
