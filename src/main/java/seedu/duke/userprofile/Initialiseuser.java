package seedu.duke.userprofile;

import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.Scanner;


public class Initialiseuser {
    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[4];

    public static void sendname(String userInput)  {
        data[0] = userInput;
    }

    public static void gender() throws IOException {
        System.out.print("What is your gender (male/female)? ");
        Scanner input = new Scanner(System.in);
        String gender = input.next();
        data[1] = gender;
        weight();
    }


    public static void weight() throws IOException {
        System.out.print("What is your weight in kg? ");
        Scanner input = new Scanner(System.in);
        String weight = input.next();
        data[2] = weight;
        height();
    }

    public static void height() throws IOException {
        System.out.print("What is your height in m? ");
        Scanner input = new Scanner(System.in);
        String height = input.next();
        data[3] = height;
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