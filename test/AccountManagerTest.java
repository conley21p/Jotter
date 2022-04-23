import User.UserController;
import account.AccountManager;
import calendar.CalendarController;
import org.junit.jupiter.api.Test;
import utils.PathFinder;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AccountManagerTest {
    private String testUsername1 = "TEST_USER_1";
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
        }
        catch (IOException e) {}

        // cleanup
        AccountManager.deleteAccount(testUsername1);
    }

    @Test
    void changePassword() {
        assertEquals(true, AccountManager.createAccount(testUsername1, testPassword1, testEmail1));
        UserController.loadUser(testUsername1, testPassword1, CalendarController.getCalendarNameList(testUsername1), CalendarController.getCalendar(testUsername1,"School"));
        assertEquals(true, AccountManager.changePassword("NEW_PASSWORD"));
        assertEquals("NEW_PASSWORD", UserController.getPassword());

        // cleanup
        AccountManager.deleteAccount(testUsername1);
    }

    @Test
    void deleteAccount() {
        assertEquals(true, AccountManager.createAccount(testUsername1, testPassword1, testEmail1));
        assertEquals(true, AccountManager.deleteAccount(testUsername1));

        File accountDirectory = new File(PathFinder.getAccountDirectoryPath(testUsername1));
        assertEquals(false, accountDirectory.exists());
    }
}