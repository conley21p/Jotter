package authenticator;

import utils.PathFinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginAuthenticator {
    public static boolean authenticate(String user, String pass) {
        // getting the right file path
        String userAccountInfoPath = PathFinder.getAccountInformationPath(user);

        File userFile = new File(userAccountInfoPath);
        System.out.println("test:" + userAccountInfoPath);
        if (userFile.exists()) {
            try {
                Scanner scan = new Scanner(userFile);
                String userInfo = scan.nextLine();
                String segments[] = userInfo.split(",");
                scan.close();
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

    public static boolean isAvailableUsername(String username) {
        String accountDirectoryPath = PathFinder.getAccountDirectoryPath(username);
        File accountDirectory = new File(accountDirectoryPath);
        return !(accountDirectory.isDirectory());
    }
}
