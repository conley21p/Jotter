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
        assertEquals(true,test1);
        assertEquals("2022-06-13,8:55,A,Final Exam,Comprehensive final for 327,327,2022/05/01 18:12,null",
                assign.toString());

        boolean test2 = assign.edit("Final Exam for 327",
                new Date("2022-6-13"),
                new Time("08:55"),
                "Comprehensive final for 327",
                "356",
                "null");
        System.out.println("View ToString:" + assign.toString());
        assertEquals(true,test2);
        assertEquals("2022-06-13,8:55,A,Final Exam for 327,Comprehensive final for 327,356,null,null",
                assign.toString());

        boolean test3 = assign.edit("Final Exam, for, 327",
                new Date("2022-6-13"),
                new Time("00:55"),
                "Comprehensive, final, for 327",
                "356",
                "null");
        System.out.println("View ToString:" + assign.toString());
        assertEquals(true,test3);
        assertEquals("2022-06-13,0:55,A,Final Exam for 327,Comprehensive final for 327,356,null,null",
                assign.toString());

        boolean test4 = assign.edit("Final Exam for 356",
                new Date("2022-5-13"),
                new Time("00:55"),
                "Comprehensive final for 356",
                "356",
                "2022/04/01 18:12");
        System.out.println("View ToString:" + assign.toString());
        assertEquals(true,test4);
        assertEquals("2022-05-13,0:55,A,Final Exam for 356,Comprehensive final for 356,356,2022/04/01 18:12,null",
                assign.toString());


        if (test1 || test2 || test3 || test4){
            System.out.println("Test results 1:"+ test1 + " 2:" + test2 + " 3:" + test3 + " 4:" + test4);
        }
    }


}