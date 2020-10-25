package seedu.duke.userprofile;

import seedu.duke.Duke;
import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.ArrayList;

import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;

public class Initialiseuser {
    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[7];

    public static String input(String text) {
        System.out.print(text);
        return Duke.in.nextLine();
    }

    public static Userinfo createNewProfile() {
        Userinfo profile = null;
        sendname();
        gender();
        weight();
        height();
        age();
        activityfactor();
        weightGoal();
        try {
            profile = enterNewUserInfo();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }

    public static void sendname()  {
        data[0] = input("What is your name?\n");
    }

    public static void gender() {
        data[1] = input("What is your gender (male/female)?\n");
    }

    public static void weight() {
        data[2] = input("What is your weight in kg?\n");
    }

    public static void height() {
        data[3] = input("What is your height in cm?\n");
    }

    public static void age() {
        data[4] = input("What is your age?\n");
    }

    public static void activityfactor() {
        data[5] = input("How active are you on a scale of 1-5? With 1 being least active and 5 being most active.\n");
    }

    public static void weightGoal() {
        data[6] = input("Do you want to lose/maintain/gain weight?\n");
    }

    public static Userinfo enterNewUserInfo() throws IOException {
        Userinfo profile = new Userinfo(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        System.out.println(profile.calculateNewUserDetails());
        Initialiseuser.save(profile);
        return profile;
    }

    public static void saveExistingUserInfo(Userinfo profile) throws IOException {
        Initialiseuser.save(profile);
    }

    public static void save(Userinfo profile) throws IOException {
        Userinfotextfilestorage storage = new Userinfotextfilestorage();
        storage.save(profile.toString());
    }

    public static Userinfo loadProfile() {
        String[] data = new String[7];
        ArrayList<String> previous = Userinfotextfilestorage.update();
        for (int i = 0; i < 7; i++) {
            data[i] = previous.get(i);
        }
        Userinfo profile =  new Userinfo(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        profile.calculateNewUserDetails();
        try {
            Initialiseuser.saveExistingUserInfo(userInfo);
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }
}