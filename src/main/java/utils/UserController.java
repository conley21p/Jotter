package utils;

public class UserController {
    private static String username;

    public static void setUser(String user) {
        System.out.println("User " + user + " loaded.");
        username = user;
    }

    public static String getUser() {
        return username;
    }

    public static void logoff() {
        setUser(null);
    }
}
