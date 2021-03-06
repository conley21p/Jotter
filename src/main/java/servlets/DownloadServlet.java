package servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    private final int ARBITARY_SIZE = 1048;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=calendar.txt");
        String filePath = utils.PathFinder.getAccountCalendarsPath(HomePageServlet.user.getUsername());
        String fileName = HomePageServlet.user.getCurrCal().getName();
        String file = filePath + "/" + fileName;
        System.out.println("Path to file: " + file);

        FileInputStream in = new FileInputStream(file);
        OutputStream out = response.getOutputStream();

        int i;
        while ((i = in.read()) != -1) {
        out.write(i);
        }
    }
}
