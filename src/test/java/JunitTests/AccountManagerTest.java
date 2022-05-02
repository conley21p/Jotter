package JunitTests;

import User.User;
import account.AccountManager;
import calendar.CalendarController;
import org.junit.jupiter.api.Test;
import servlets.HomePageServlet;
import utils.PathFinder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    private String testUsername1 = "TEST_USER_1";
    private String testUsername2 = "TEST_USER_2";
    private String testUsername3 = "Test_USER_3";
    private String testPassword1 = "PASSWORD_1";
    private String testEmail1 = "EMAIL_1@gmail.com";

    @Test
    void createAccount() {
        assertEquals(true, AccountManager.createAccount(testUsername1, testPassword1, testEmail1));

        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(testUsername1);
        File accountDirectory = new File(accountDirectoryPath);
        File deletedItemsFile = new File(accountDirectoryPath + "/Calendars/DELETED_ITEMS");
        File schoolCalendar = new File(accountDirectoryPath + "/Calendars/School");
        File accountInfoFile = new File(accountDirectoryPath + "/accountInfo");

        assertEquals(true, accountDirectory.exists() && accountDirectory.isDirectory());
        assertEquals(true, deletedItemsFile.exists() && schoolCalendar.exists());
        try {
            Scanner infile = new Scanner(accountInfoFile);
            assertEquals(testUsername1 + "," + testPassword1 + "," + testEmail1, infile.nextLine());
            infile.close();
        }
        catch (IOException e) {}

        // cleanup
        AccountManager.deleteAccount(testUsername1);
    }

    @Test
    void changePassword() {
        assertEquals(true, AccountManager.createAccount(testUsername2, testPassword1, testEmail1));
        assertEquals(true, AccountManager.changePassword(testUsername2, "NEW_PASSWORD"));
        assertEquals("NEW_PASSWORD", HomePageServlet.user.getPassword());

        // cleanup
        AccountManager.deleteAccount(testUsername2);
    }

    @Test
    void deleteAccount() {
        assertEquals(true, AccountManager.createAccount(testUsername3, testPassword1, testEmail1));
        assertEquals(true, AccountManager.deleteAccount(testUsername3));

        File accountDirectory = new File(PathFinder.getAccountDirectoryPath(testUsername3));
        assertEquals(false, accountDirectory.exists());
    }
}