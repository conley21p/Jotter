package calendar;

import User.User;
import account.AccountManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import servlets.HomePageServlet;

import static org.junit.jupiter.api.Assertions.*;

class CalendarControllerTest {

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
                        "null",
                        "null"));
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                new Assignment( "Final Exam",
                        new Date("2022-8-13"),
                        new Time("08:55"),
                        "Comprehensive final for 326",
                        "326",
                        "null",
                        "null"));
    }

    @AfterEach
    void tearDown() {
        AccountManager.deleteAccount("deleteTest");
    }

    @Test
    void deleteCalendarObject() {
        Assignment testResult1 = (Assignment) CalendarController.deleteCalendarObject(3);
        Assignment testResult2 = (Assignment) CalendarController.deleteCalendarObject(1);
        Assignment testResult3 = (Assignment) CalendarController.deleteCalendarObject(0);
        Assignment testResult4 = (Assignment) CalendarController.deleteCalendarObject(0);
        if( testResult1 == null
                ||  testResult2 == null
                ||  testResult3 == null
                ||  testResult4 == null){
            System.out.println("test results 1:" +testResult1 +
                    " 2:" + testResult2 +
                    " 3:" + testResult3 +
                    " 4:" + testResult4);
        }
    }
}