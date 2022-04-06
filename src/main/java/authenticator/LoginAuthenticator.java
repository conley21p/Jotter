package authenticator;

public class LoginAuthenticator {
    public boolean authenticate(String user, String pass) {
        // getting the right file path
        ClassLoader loader = LoginAuthenticator.class.getClassLoader();
        String tempPath = loader.getResource("authenticator/LoginAuthenticator.class").toString();

        String jotterPath = tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
        String accountsPath = jotterPath + "/src/main/java/Account/Accounts";
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("Accounts:: " + accountsPath);

        String userPath = accountsPath + "/" + user;

        return true;

    }
}
