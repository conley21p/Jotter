package Account;

import java.io.File;

public class AccountCreator {
    public static boolean makeAccount(String user, String pass, String email) {
        File accountFolder = new File("/Accounts/" + user);
        boolean result = accountFolder.mkdir();
        return result;
    }
}

