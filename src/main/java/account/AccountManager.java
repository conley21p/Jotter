package account;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountManager {
    public static boolean makeAccount(String username, String password, String email) {
        System.out.println("first 1");
        ClassLoader loader = AccountManager.class.getClassLoader();
        System.out.printf("first");
        String tempPath = loader.getResource("account/AccountManager.class").toString();

        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/account/accounts";
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("Accounts:: " + accountsPath);

        // creating user's account directory
        File accountDirectory = new File(accountsPath + "/" + username);
        boolean result = accountDirectory.mkdir();
        System.out.println(result);

        // creating user's account information file
        File accountInfo = new File(accountsPath + "/" + username + "/accountInfo");
        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(accountInfo));
            outfile.print(username + "," + password + "," + email);
            outfile.close();
        }
        catch (IOException e) {
            System.out.println("Could not create user account info");
        }

        // creating user's calendar directory
        File calendarsDirectory = new File(accountsPath + "/" + username + "/Calendars");
        calendarsDirectory.mkdir();

        // Load user
        //UserController.setUser(username);

        // TODO create starter calendar

        return result;
    }

    public static boolean deleteAccount(String username) {
        boolean isSuccess = false;
        ClassLoader loader = AccountManager.class.getClassLoader();
        String tempPath = loader.getResource("account/AccountManager.class").toString();

        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/account/accounts";
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("Accounts:: " + accountsPath);

        // creating user's account directory
        File accountDirectory = new File(accountsPath + "/" + username);
        if (accountDirectory.isDirectory()) {
            System.out.println(accountDirectory.getName() + " is directory");
            if (deleteDirectory(accountDirectory))
                isSuccess = true;
        }
        return isSuccess;
    }

    private static boolean deleteDirectory(File directory) {
        boolean isSuccess = false;
        if (directory.isDirectory())
            for (File subFile : directory.listFiles()) {
                System.out.println(subFile.getName());
                if (subFile.isDirectory()) {
                    System.out.println("subDir");
                    deleteDirectory(subFile);
                }
                else
                    subFile.delete();
                isSuccess = true;
            }
        directory.delete();
        System.out.println("Deleting " + directory.getName() + ": " + isSuccess);
        return isSuccess;
    }
}

