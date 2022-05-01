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

        try(InputStream in = request.getServletContext().getResourceAsStream(file);
            OutputStream out = response.getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                System.out.println("Test");
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
