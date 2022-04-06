package utils;

import java.io.File;

public class PathFinder {
    public String findUserDirectory(String username) {
        String jotterPath = getJotterPath();
        String userDirectoryPath = jotterPath + "/src/main/java/account/accounts/" + username;
        System.out.println("Jotter:: " + jotterPath);
        System.out.println("User:: " + userDirectoryPath);

        File userDirectory = new File(userDirectoryPath);
        if (userDirectory.isDirectory()) {
            return userDirectoryPath;
        }
        return null;
    }

    public String findUserInformation(String username) {
        String userDirectoryPath = findUserDirectory(username);
        if (userDirectoryPath != null) {
            System.out.println("findUserCalendars(" + username + ") = " + userDirectoryPath + "/" + username);
        return userDirectoryPath + "/" + username;
        }
        return null;
    }

    public String findUserCalendars(String username) {
        String userDirectoryPath = findUserDirectory(username);
        if (userDirectoryPath != null) {
            System.out.println("findUserCalendars(" + username + ") = " + userDirectoryPath + "/calendars");
            return userDirectoryPath + "/" + username;
        }
        return null;
    }

    private String getJotterPath() {
        ClassLoader loader = PathFinder.class.getClassLoader();
        String tempPath = loader.getResource("utils/PathFinder.class").toString();
        return tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
    }
}
