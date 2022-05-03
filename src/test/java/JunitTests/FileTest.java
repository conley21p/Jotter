package JunitTests;

import User.User;
import account.AccountManager;
import calendar.Assignment;
import calendar.CalendarController;
import calendar.Date;
import calendar.Time;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servlets.HomePageServlet;

import static org.junit.jupiter.api.Assertions.*;

class FileTest {

    String userName = "deleteTest";
    String password = "password";
    String email    = "test@gmail.com";

    @BeforeEach
    void setUp() {
        AccountManager.createAccount(userName,
                password,
                email);
        String[] calendarNameList = CalendarController.getCalendarNameList(userName);
        HomePageServlet.user = new User(userName,
                password,
                calendarNameList,
                CalendarController.getCalendar(userName,
                        "School"));
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                new Assignment( "Final Exam",
                        new Date("2022-6-13"),
                        new Time("08:55"),
                        "Comprehensive final for 327",
                        "327",
                        "null",
                        "null"));
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                new Assignment( "Final Exam 356",
                        new Date("2022-7-13"),
                        new Time("14:55"),
                        "Comprehensive final for 356",
                        "356",
                        "null",
                        "null"));
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                new Assignment( "Final HW",
                        new Date("2022-6-13"),
                        new Time("23:55"),
                        "Cost models homwork",
                        "327",
                        "2022/05/01 18:15",
                        "null"));
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                new Assignment( "Final Exam",
                        new Date("2022-8-13"),
                        new Time("08:55"),
                        "Comprehensive final for 326",
                        "326",
                        "2022/05/01 18:12",
                        "null"));
    }

    @AfterEach
    void tearDown() {
        AccountManager.deleteAccount("deleteTest");
    }

    @Test
    void uploadFile() {
        Assignment testAssign = (Assignment) HomePageServlet.user.getCurrCal().getCalendarObject("Final Exam");
        testAssign.setFileName("test.png");
        assertEquals("test.png", testAssign.getFileName());
    }

    @Test
    void importCal() {
        //Is done through the servlet and sent to the directory.
    }

    @Test
    void sort() {
        assertEquals(true, HomePageServlet.user.getCurrCal().sortCalendar());
    }

    @Test
    void exportCal() {
        assertEquals("School", HomePageServlet.user.getCurrCal().getName());
    }

    @Test
    void generateAnalytics() {
        assertEquals(2, HomePageServlet.user.getCurrCal().generateAnalysis());
    }
}