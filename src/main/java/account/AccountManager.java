package account;

import utils.PathFinder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountManager {
    public static boolean makeAccount(String username, String password, String email) {
        // creating new account directory
        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(username);
        File accountDirectory = new File(accountDirectoryPath);
        boolean isSuccess = true;
        isSuccess = accountDirectory.mkdir();
        System.out.println("Account " + username + " made? " + isSuccess);

        // creating new information file
        File accountInfo = new File(accountDirectoryPath + "/" + username + "/accountInfo");
        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(accountInfo));
            outfile.print(username + "," + password + "," + email);
            outfile.close();
        }
        catch (IOException e) {
            System.out.println("Could not create account information file.");
            isSuccess = false;
        }

        // creating new calendar directory
        File calendarsDirectory = new File(accountDirectoryPath + "/" + username + "/Calendars");
        isSuccess = calendarsDirectory.mkdir();
        System.out.println("Account " + username + " calendars directory made? " + isSuccess);

        // TODO load user

        // TODO create starter calendar

        return isSuccess;
    }

    public static boolean deleteAccount(String username) {
        boolean isSuccess = false;
        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(username);

        // deleting account directory
        File accountDirectory = new File(accountDirectoryPath + "/" + username);
        if (accountDirectory.isDirectory()) {
            if (deleteDirectory(accountDirectory))
                isSuccess = true;
        }
        System.out.println("Account " + username + " is deleted? " + isSuccess);
        return isSuccess;
    }

    /**
     * Helper method to recursively delete a directory with contents
     * Precondition: directory is an actual directory
     */
    private static boolean deleteDirectory(File directory) {
        boolean isSuccess = false;
        for (File subFile : directory.listFiles()) {
            if (subFile.isDirectory()) {
                deleteDirectory(subFile);
            }
            else {
                subFile.delete();
            }
        }
        isSuccess = directory.delete();
        System.out.println("Deleting " + directory.getName() + ": " + isSuccess);
        return isSuccess;
    }
}

