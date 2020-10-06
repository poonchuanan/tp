package seedu.duke.userprofile;

import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.Scanner;

public class Initialiseuser {
    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[4];
    private static Scanner scanner = new Scanner(System.in);

    public static String input(String text) {
        System.out.print(text);
        return scanner.nextLine();
    }

    public static String input2() {
        return scanner.nextLine();
    }

    public static void closescanner() {
        scanner.close();
    }

    public static void sendname(String userInput)  {
        data[0] = userInput;
    }

    public static void gender() throws IOException {
        data[1] = input("What is your gender (male/female)?\n");
        weight();
    }

    public static void weight() throws IOException {
        data[2] = input("What is your weight in kg?\n");
        height();
    }

    public static void height() throws IOException {
        data[3] = input("What is your height in m?\n");

        enterNewUserInfo();
    }

    public static void enterNewUserInfo() throws IOException {
        new Userinfo(data[0],data[1],data[2],data[3]);
        userInfo.printNewUserCalculatedDetails();
        Initialiseuser.save();

    }

    public static void saveExistingUserInfo() throws IOException {
        Initialiseuser.save();

    }

    public static void save() throws IOException {
        Userinfotextfilestorage storage = new Userinfotextfilestorage();
        storage.save(userInfo.toString());

    }
}