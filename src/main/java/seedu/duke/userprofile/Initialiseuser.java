package seedu.duke.userprofile;

import seedu.duke.Trakcal;
import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityLevelMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidAgeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidHeightMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightMessage;
import seedu.duke.ui.Ui;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightGoalMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidGenderMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;

public class Initialiseuser {
    private static Userinfo userInfo = new Userinfo();
    private static String[] data = new String[7];

    public static String input(String text) {
        System.out.print(text);
        return Trakcal.in.nextLine();
    }

    public static String input() {
        return Trakcal.in.nextLine();
    }

    public static Userinfo createNewProfile() {
        Userinfo profile = null;
        name();
        gender();
        weight();
        height();
        age();
        activityLevel();
        weightGoal();
        try {
            profile = enterNewUserInfo();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }

    public static void name()  {
        data[0] = input("What is your name?\n");
    }

    public enum GenderEnum {
        male, female;
    }

    public static void gender() {
        Ui.displayAskUserGenderMessage();
        String gender = input();

        try {
            if (Arrays.toString(GenderEnum.values()).contains(gender)) {
                data[1] = gender;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            displayInvalidGenderMessage();
            gender();
        }
    }

    public static void weight() {
        Ui.displayAskUserWeightMessage();
        String weight = input();
        try {
            Double.parseDouble(weight);
        } catch (NumberFormatException e) {
            displayInvalidWeightMessage();
            weight();
        }
        data[2] = weight;
    }

    public static void height() {
        Ui.displayAskUserHeightMessage();
        String height = input();
        try {
            Double.parseDouble(height);
        } catch (NumberFormatException e) {
            displayInvalidHeightMessage();
            height();
        }
        data[3] = height;
    }

    public static void age() {
        Ui.displayAskUserAgeMessage();
        String age = input();
        try {
            Integer.parseInt(age);
        } catch (NumberFormatException e) {
            displayInvalidAgeMessage();
            age();
        }
        data[4] = age;
    }

    public static void activityLevel() {
        Ui.displayAskUserActivityLevelMessage();
        String activityLevel = input();
        try {
            int checkRange = Integer.parseInt(activityLevel);

            if (checkRange < 0 || checkRange > 5) {
                throw new IllegalArgumentException();
            }

        } catch (IllegalArgumentException e) {
            displayInvalidActivityLevelMessage();
            activityLevel();
        }
        data[5] = activityLevel;
    }

    public enum WeightGoalEnum {
        lose, maintain, gain;
    }

    public static void weightGoal() {
        Ui.displayAskUserWeightGoalMessage();
        String weightGoal = input();

        try {
            if (Arrays.toString(WeightGoalEnum.values()).contains(weightGoal)) {
                data[6] = weightGoal;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            displayInvalidWeightGoalMessage();
            weightGoal();
        }
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
            Initialiseuser.saveExistingUserInfo(profile);
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }
}