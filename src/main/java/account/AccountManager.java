package account;

import User.UserController;
import utils.PathFinder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AccountManager {
    public static boolean createAccount(String username, String password, String email) {
        boolean isSuccess = true;
        // creating new account directory
        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(username);
        File accountDirectory = new File(accountDirectoryPath);
        isSuccess = accountDirectory.mkdir();
        System.out.println("Account " + username + " made? " + isSuccess);

        // creating new information file
        File accountInfo = new File(accountDirectoryPath + "/accountInfo");
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
        File calendarsDirectory = new File(accountDirectoryPath + "/Calendars");
        isSuccess = calendarsDirectory.mkdir();
        System.out.println("Account " + username + " calendars directory made? " + isSuccess);

        // creating starter calendar
        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(new File(calendarsDirectory + "/School")));
            outfile.write("");
            outfile.close();
        } catch (IOException e) {
            System.out.println("Could not create starting calendar file.");
            isSuccess = false;
        }

        return isSuccess;
    }

    public static boolean deleteAccount(String username) {
        boolean isSuccess = false;
        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(username);

        // deleting account directory
        File accountDirectory = new File(accountDirectoryPath);
        if (accountDirectory.isDirectory()) {
            System.out.println("isDirectory");
            if (deleteDirectory(accountDirectory))
                isSuccess = true;
        }
        System.out.println("Account " + username + " is deleted? " + isSuccess);
        return isSuccess;
    }

    public static boolean changePassword(String newPassword) {
        boolean isSuccess = true;
        File accountInfoFile = new File(PathFinder.getAccountInformationPath(UserController.getUsername()));
        try {
            Scanner infile = new Scanner(accountInfoFile);
            String contents = infile.nextLine();
            infile.close();
            contents = contents.replace(UserController.getPassword(), newPassword);
            PrintWriter outfile = new PrintWriter(new FileWriter(accountInfoFile));
            outfile.println(contents);
            outfile.close();
        }
        catch (IOException e) {
            isSuccess = false;
        }
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

