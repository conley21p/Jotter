package JunitTests;

import calendar.Assignment;
import calendar.Time;
import calendar.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {
    public Assignment assign;

    @BeforeEach
    void setUp() {
        assign = new Assignment("Final Exam",
                                new Date("2022-6-13"),
                                new Time("08:55"),
                                "Comprehensive final for 327",
                                "327",
                                "null",
                                "null");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void edit() {
        boolean test1 = assign.edit("Final Exam",
                new Date("2022-6-13"),
                new Time("08:55"),
                "Comprehensive final for 327",
                "327",
                "2022/05/01 18:12");
        System.out.println("View ToString:" + assign.toString());
        boolean test2 = assign.edit("Final Exam for 327",
                new Date("2022-6-13"),
                new Time("08:55"),
                "Comprehensive final for 327",
                "356",
                "2022/05/01 18:12");
        System.out.println("View ToString:" + assign.toString());
        boolean test3 = assign.edit("Final Exam, for, 327",
                new Date("2022-6-13"),
                new Time("00:55"),
                "Comprehensive, final, for 327",
                "356",
                "2022/05/01 18:12");
        System.out.println("View ToString:" + assign.toString());
        boolean test4 = assign.edit("Final Exam for 356",
                new Date("2022-5-13"),
                new Time("00:55"),
                "Comprehensive final for 356",
                "356",
                "2022/05/01 18:12");
        System.out.println("View ToString:" + assign.toString());
        System.out.println("Test results 1:"+ test1 + " 2:" + test2 + " 3:" + test3 + " 4:" + test4);
    }


}