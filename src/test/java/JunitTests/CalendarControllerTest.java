package JunitTests;

import calendar.*;
import servlets.HomePageServlet;
import User.User;
import account.AccountManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarControllerTest {

    String userName = "deleteTest";
    String password = "password";
    String email    = "test@gmail.com";
    Assignment[] testAssigns = new Assignment[4];
    Calendar calendar = new Calendar();

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
        testAssigns[0] = new Assignment( "Final Exam",
                                        new Date("2022-6-13"),
                                        new Time("08:55"),
                                        "Comprehensive final for 327",
                                        "327",
                                        "null",
                                        "null");
        testAssigns[1] = new Assignment( "Final Exam 356",
                                        new Date("2022-7-13"),
                                        new Time("14:55"),
                                        "Comprehensive final for 356",
                                        "356",
                                        "null",
                                        "null");
        testAssigns[2] = new Assignment( "Final HW",
                                        new Date("2022-6-13"),
                                        new Time("23:55"),
                                        "Cost models homwork",
                                        "327",
                                        "null",
                                        "null");
        testAssigns[3] = new Assignment( "Final Exam",
                                        new Date("2022-8-13"),
                                        new Time("08:55"),
                                        "Comprehensive final for 326",
                                        "326",
                                        "null",
                                        "null");
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                                                                    testAssigns[0]);
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                                                                    testAssigns[1]);
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                                                                    testAssigns[2]);
        HomePageServlet.user.getCurrCal().addNewToCalendarObjList(userName,
                                                                    testAssigns[3]);
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

        assertEquals(testAssigns[3],testResult1);
        assertEquals(testAssigns[1],testResult2);
        assertEquals(testAssigns[0],testResult3);
        assertEquals(testAssigns[2],testResult4);
    }

    @Test
    void addCalendar() {
        boolean answer = true;

        boolean testResult1 = CalendarController.addCalendar(this.userName, this.calendar.getName());
        boolean testResult2 = CalendarController.addCalendar(this.userName, new Calendar().getName());
        boolean testResult3 = CalendarController.addCalendar(HomePageServlet.user.getUsername(), this.calendar.getName());
        boolean testResult4 = CalendarController.addCalendar(HomePageServlet.user.getUsername(), new Calendar().getName());

        assertEquals(answer,testResult1);
        assertEquals(answer,testResult2);
        assertEquals(answer,testResult3);
        assertEquals(answer,testResult4);
    }

    @Test
    void deleteCalendar() {
        boolean answer = true;

        boolean testResult1 = CalendarController.deleteCalendar(this.userName, this.calendar.getName());
        boolean testResult2 = CalendarController.deleteCalendar(this.userName, new Calendar().getName());
        boolean testResult3 = CalendarController.deleteCalendar(HomePageServlet.user.getUsername(), this.calendar.getName());
        boolean testResult4 = CalendarController.deleteCalendar(HomePageServlet.user.getUsername(), new Calendar().getName());

        assertEquals(!answer,testResult1);
        assertEquals(!answer,testResult2);
        assertEquals(!answer,testResult3);
        assertEquals(!answer,testResult4);
    }
}