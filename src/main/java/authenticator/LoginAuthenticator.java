package authenticator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAuthenticator {
    public static boolean authenticate(String user, String pass) {
        // getting the right file path
        ClassLoader loader = LoginAuthenticator.class.getClassLoader();
        String tempPath = loader.getResource("authenticator/LoginAuthenticator.class").toString();
        System.out.println("Test" + tempPath);
        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);

        String accountsPath =  jotterPath + "/src/main/java/account/accounts";
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("Accounts:: " + accountsPath);

        String userAccountInfoPath = accountsPath + "/" + user + "/accountInfo";

        File userFile = new File(userAccountInfoPath);
        System.out.println("test:" + userAccountInfoPath);
        if (userFile.exists()) {
            try {
                Scanner scan = new Scanner(userFile);
                String userInfo = scan.nextLine();
                String segments[] = userInfo.split(",");
                if (segments[1].equals(pass)) {
                    return true;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Could not find user");
                e.printStackTrace();
            }
        } else {
            return false;
        }

        return false;
    }
}
