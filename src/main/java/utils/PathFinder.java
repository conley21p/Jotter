package utils;

import java.io.File;

public class PathFinder {
    public static String getAccountDirectoryPath(String username) {
        String jotterPath = getJotterPath();
        //For Jacob's use
        //jotterPath = "C:/Users/Jacob Radtke/IdeaProjects/Jotter";
        String userDirectoryPath = jotterPath + "/src/main/java/account/accounts/" + username;
        System.out.println("userDirectoryPath: " + userDirectoryPath);
        return userDirectoryPath;
    }

    public static String getAccountInformationPath(String username) {
        String userDirectoryPath = getAccountDirectoryPath(username);
        return userDirectoryPath + "/accountInfo";
    }

    public static String getAccountCalendarsPath(String username) {
        String userDirectoryPath = getAccountDirectoryPath(username);
        return userDirectoryPath + "/Calendars";
    }

    public static String getAccountFilesPath(String username) {
        String userDirectoryPath = getAccountDirectoryPath(username);
        return userDirectoryPath + "/Files";
    }

    public static String getJotterPath() {
        ClassLoader loader = PathFinder.class.getClassLoader();
        String tempPath = loader.getResource("utils/PathFinder.class").toString();
        return tempPath.substring(6, tempPath.indexOf("Jotter") + 6);
    }
}
