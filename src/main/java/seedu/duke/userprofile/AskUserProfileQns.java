package seedu.duke.userprofile;

import seedu.duke.Trakcal;
import seedu.duke.storage.Userinfotextfilestorage;
import java.io.IOException;
import java.util.ArrayList;

import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityLevelMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityLevelRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidAgeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidAgeRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidHeightMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidHeightRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightMessage;
import seedu.duke.ui.Ui;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightGoalMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidGenderMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightRangeMessage;

/**
 * Initialises user profile after asking for user input.
 */
public class AskUserProfileQns {
    private static String[] data = new String[7];

    /**
     * Reading user input after printing question.
     *
     * @param text question to be printed
     */
    public static String input(String text) {
        System.out.print(text);
        return Trakcal.in.nextLine();
    }

    /**
     * Reading user input.
     *
     * @return user input
     */
    public static String input() {
        return Trakcal.in.nextLine();
    }

    public static InitialiseUserProfile createNewProfile() {
        InitialiseUserProfile profile = null;
        gatherData();
        try {
            profile = enterNewUserInfo();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }

    public static void gatherData() {
        name();
        gender();
        weight();
        height();
        age();
        activityLevel();
        weightGoal();
    }

    /**
     * ask user for name and save in an array entry.
     *
     */
    public static void name()  {
        data[0] = input("What is your name?\n");
    }

    /**
     * user gender restricted to what is stated in enum.
     *
     */
    private enum GenderEnum {
        male, female;
    }

    /**
     * ask user for gender and save in an array entry.
     *
     */
    private static void gender() {
        Ui.displayAskUserGenderMessage();
        String gender = input();

        try {
            checkGender(gender);
            data[1] = gender;

        } catch (IllegalArgumentException e) {
            displayInvalidGenderMessage();
            gender();
        }
    }

    /**
     * ask user for weight and save in an array entry.
     * must be between 20 to 650kg and type double.
     */
    private static void weight() {
        Ui.displayAskUserWeightMessage();
        String weight = input();

        try {
            checkInputIsDouble(weight);
            checkWeightIsWithinRange(weight);
            data[2] = weight;

        } catch (NumberFormatException e) {
            displayInvalidWeightMessage();
            weight();
        } catch (IllegalArgumentException e) {
            displayInvalidWeightRangeMessage();
            weight();
        }
    }

    /**
     * ask user for height and save in an array entry.
     * must be between 10 to 300cm and type double.
     */
    private static void height() {
        Ui.displayAskUserHeightMessage();
        String height = input();
        try {
            checkInputIsDouble(height);
            checkHeightIsWithinRange(height);
            data[3] = height;

        } catch (NumberFormatException e) {
            displayInvalidHeightMessage();
            height();
        } catch (IllegalArgumentException e) {
            displayInvalidHeightRangeMessage();
            height();
        }
    }

    /**
     * ask user for age and save in an array entry.
     * must be between 1 to 120 years old.
     */
    private static void age() {
        Ui.displayAskUserAgeMessage();
        String age = input();
        try {
            checkInputIsInt(age);
            checkAgeIsWithinRange(age);
            data[4] = age;

        } catch (NumberFormatException e) {
            displayInvalidAgeMessage();
            age();
        } catch (IllegalArgumentException e) {
            displayInvalidAgeRangeMessage();
            age();
        }
    }

    /**
     * ask user for activity level and save in an array entry.
     *
     */
    private static void activityLevel() {
        Ui.displayAskUserActivityLevelMessage();
        String activityLevel = input();
        try {
            checkInputIsInt(activityLevel);
            checkAcLeIsWithinRange(activityLevel);
            data[5] = activityLevel;

        } catch (NumberFormatException e) {
            displayInvalidActivityLevelMessage();
            activityLevel();
        } catch (IllegalArgumentException e) {
            displayInvalidActivityLevelRangeMessage();
            activityLevel();
        }
    }

    /**
     * user weight goal restricted to what is stated in enum.
     *
     */
    private enum WeightGoalEnum {
        lose, maintain, gain;
    }

    /**
     * ask user for weight goal and save in an array entry.
     *
     */
    private static void weightGoal() {
        Ui.displayAskUserWeightGoalMessage();
        String weightGoal = input();

        try {
            checkWeightGoal(weightGoal);
            data[6] = weightGoal;

        } catch (IllegalArgumentException e) {
            displayInvalidWeightGoalMessage();
            weightGoal();
        }
    }

    private static void checkGender(String gender) throws IllegalArgumentException {
        for (GenderEnum validGender : GenderEnum.values()) {
            if (validGender.name().equals(gender)) {
                return;
            }
        }

        throw new IllegalArgumentException();
    }

    private static void checkInputIsDouble(String userInput) throws NumberFormatException {
        Double.parseDouble(userInput);
    }

    private static void checkWeightIsWithinRange(String weight) throws IllegalArgumentException {
        if (Double.parseDouble(weight) < 20 || Double.parseDouble(weight) > 650) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkHeightIsWithinRange(String height) throws IllegalArgumentException {
        if (Double.parseDouble(height) < 10 || Double.parseDouble(height) > 300) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkAgeIsWithinRange(String age) throws IllegalArgumentException {
        if (Integer.parseInt(age) < 1 || Integer.parseInt(age) > 120) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputIsInt(String userInput) throws NumberFormatException {
        Integer.parseInt(userInput);
    }

    private static void checkAcLeIsWithinRange(String al) throws IllegalArgumentException {
        if (Integer.parseInt(al) < 1 || Integer.parseInt(al) > 5) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkWeightGoal(String wg) throws IllegalArgumentException {
        for (WeightGoalEnum validWg : WeightGoalEnum.values()) {
            if (validWg.name().equals(wg)) {
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public static InitialiseUserProfile enterNewUserInfo() throws IOException {
        InitialiseUserProfile profile =
                new InitialiseUserProfile(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        System.out.println(profile.calculateNewUserDetails());
        AskUserProfileQns.save(profile);
        return profile;
    }

    /**
     * override and save user details in text file.
     *
     * @param profile to be saved in text file
     */
    public static void saveExistingUserInfo(InitialiseUserProfile profile) throws IOException {
        AskUserProfileQns.save(profile);
    }

    /**
     * create a new text file and save user input into the text file.
     *
     * @param profile question to be printed
     */
    public static void save(InitialiseUserProfile profile) throws IOException {
        Userinfotextfilestorage storage = new Userinfotextfilestorage();
        storage.save(profile.toString());
    }

    /**
     * Reading user input from existing text file and save a profile type.
     *
     * @return Storage type
     */
    public static InitialiseUserProfile loadProfile() {
        String[] data = new String[7];
        ArrayList<String> previous = Userinfotextfilestorage.update();
        for (int i = 0; i < 7; i++) {
            data[i] = previous.get(i);
        }
        InitialiseUserProfile profile =
                new InitialiseUserProfile(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        profile.calculateNewUserDetails();
        try {
            AskUserProfileQns.saveExistingUserInfo(profile);
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }
}