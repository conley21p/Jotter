package Account;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AccountCreator {
    public static boolean makeAccount(String user, String pass, String email) {
        ClassLoader loader = AccountCreator.class.getClassLoader();
        String tempPath = loader.getResource("Account/AccountCreator.class").toString();

        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts";
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("Accounts:: " + accountsPath);

        // creating user's account directory
        File accountDirectory = new File(accountsPath + "/" + user);
        boolean result = accountDirectory.mkdir();
        System.out.println(result);

        // creating user's account information file
        File accountInfo = new File(accountsPath + "/" + user + "/accountInfo");
        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(accountInfo));
            outfile.print(user + "," + pass + "," + email);
            outfile.close();
        }
        catch (IOException e) {
            System.out.println("Could not create user account info");
        }

        // creating user's calendar directory
        File calendarsDirectory = new File(accountsPath + "/" + user + "/Calendars");
        calendarsDirectory.mkdir();
        // creating default school calendar
        File defaultCalendar = new File(accountsPath + "/" + user + "/Calendars/School");
        try {
            PrintWriter outfile = new PrintWriter(new FileWriter(defaultCalendar));
            //outfile.print(user + "," + pass + "," + email);
            outfile.close();
        }
        catch (IOException e) {
            System.out.println("Could not create user account info");
        }



        return result;
    }
}

