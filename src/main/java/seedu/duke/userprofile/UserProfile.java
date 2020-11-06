package seedu.duke.userprofile;

import seedu.duke.Trakcal;
import seedu.duke.storage.UserInfoStorage;
import java.io.IOException;
import java.util.ArrayList;

import static seedu.duke.ui.ExceptionMessages.displayInvalidEditedUserProfileMessage;
import seedu.duke.exception.EmptyDescriptionException;
import static seedu.duke.ui.Ui.displayEditWeightMessage;
import static seedu.duke.ui.Ui.displayEditHeightMessage;
import static seedu.duke.ui.Ui.displayEditAgeMessage;
import static seedu.duke.ui.Ui.displayEditActivityLevelMessage;
import static seedu.duke.ui.Ui.displayEditGoalMessage;
import static seedu.duke.ui.Ui.displayEditGenderMessage;
import static seedu.duke.ui.Ui.displayEditNameMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityLevelMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidActivityLevelRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidAgeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidAgeRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidHeightMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidHeightRangeMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightMessage;

import seedu.duke.ui.ExceptionMessages;
import seedu.duke.ui.Ui;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightGoalMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidGenderMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidWeightRangeMessage;

/**
 * Initialises user profile after asking for user input.
 */
public class UserProfile {
    private static String[] data = new String[7];

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

    public static void edit(String info) throws IOException {
        ArrayList<String> previous = UserInfoStorage.update();
        for (int i = 0; i < 7; i++) {
            data[i] = previous.get(i);
        }

        String[] arguments = info.split(",");

        for (String argument : arguments) {
            if (argument.startsWith("n/")) {
                editName(argument.substring(2));
            } else if (argument.startsWith("g/")) {
                editGender(argument.substring(2));
            } else if (argument.startsWith("w/")) {
                editWeight(argument.substring(2));
            } else if (argument.startsWith("h/")) {
                editHeight(argument.substring(2));
            } else if (argument.startsWith("age/")) {
                editAge(argument.substring(4));
            } else if (argument.startsWith("al/")) {
                editAl(argument.substring(3));
            } else if (argument.startsWith("goal/")) {
                editGoal(argument.substring(5));
            }
        }
        InitialiseUserProfile profile =
                new InitialiseUserProfile(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        UserProfile.save(profile);
        profile.calculateEditedUserDetails();
    }

    private static void editName(String name) {
        try {
            checkEmptyInput(name);
            data[0] = name;
            displayEditNameMessage();
            System.out.println(data[0] + ".\n");
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editGender(String gender) {
        try {
            checkEmptyInput(gender);
            checkGender(gender);
            data[1] = gender;
            displayEditGenderMessage();
            System.out.println(data[1] + ".\n");

        } catch (IllegalArgumentException e) {
            displayInvalidGenderMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editWeight(String weight) {
        try {
            checkEmptyInput(weight);
            checkInputIsDouble(weight);
            checkWeightIsWithinRange(weight);
            data[2] = weight;
            displayEditWeightMessage();
            System.out.println(data[2] + "kg.\n");

        } catch (NumberFormatException e) {
            displayInvalidWeightMessage();
        } catch (IllegalArgumentException e) {
            displayInvalidWeightRangeMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editHeight(String height) {
        try {
            checkEmptyInput(height);
            checkInputIsDouble(height);
            checkHeightIsWithinRange(height);
            data[3] = height;
            displayEditHeightMessage();
            System.out.println(data[3] + "cm.\n");

        } catch (NumberFormatException e) {
            displayInvalidHeightMessage();
        } catch (IllegalArgumentException e) {
            displayInvalidHeightRangeMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editAge(String age) {
        try {
            checkEmptyInput(age);
            checkInputIsInt(age);
            checkAgeIsWithinRange(age);
            data[4] = age;
            displayEditAgeMessage();
            System.out.println(data[4] + "years old.\n");

        } catch (NumberFormatException e) {
            displayInvalidAgeMessage();
        } catch (IllegalArgumentException e) {
            displayInvalidAgeRangeMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editAl(String al) {
        try {
            checkEmptyInput(al);
            checkInputIsInt(al);
            checkAcLeIsWithinRange(al);
            data[5] = al;
            displayEditActivityLevelMessage();
            System.out.println(data[5] + ".\n");

        } catch (NumberFormatException e) {
            displayInvalidActivityLevelMessage();
        } catch (IllegalArgumentException e) {
            displayInvalidActivityLevelRangeMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }

    private static void editGoal(String goal) {
        try {
            checkEmptyInput(goal);
            checkWeightGoal(goal);
            data[6] = goal;
            displayEditGoalMessage();
            System.out.println(data[6] + ".\n");

        } catch (IllegalArgumentException e) {
            displayInvalidWeightGoalMessage();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
        }
    }


    /**
     * ask user for name and save in an array entry.
     *
     */
    public static void name()  {
        Ui.displayAskUserNameMessage();
        String name = input();
        try {
            checkEmptyInput(name);
            data[0] = name;
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            name();
        }
    }


    /**
     * user gender restricted to what is stated in enum.
     *
     */
    private enum GenderEnum {
        male, female
    }

    /**
     * ask user for gender and save in an array entry.
     *
     */
    public static void gender() {
        Ui.displayAskUserGenderMessage();
        String gender = input();

        try {
            checkEmptyInput(gender);
            checkGender(gender);
            data[1] = gender;

        } catch (IllegalArgumentException e) {
            displayInvalidGenderMessage();
            gender();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            gender();
        }
    }

    /**
     * ask user for weight and save in an array entry.
     * must be between 20 to 650kg and type double.
     */
    public static void weight() {
        Ui.displayAskUserWeightMessage();
        String weight = input();

        try {
            checkEmptyInput(weight);
            checkInputIsDouble(weight);
            checkWeightIsWithinRange(weight);
            data[2] = weight;

        } catch (NumberFormatException e) {
            displayInvalidWeightMessage();
            weight();
        } catch (IllegalArgumentException e) {
            displayInvalidWeightRangeMessage();
            weight();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            weight();
        }
    }

    /**
     * ask user for height and save in an array entry.
     * must be between 10 to 300cm and type double.
     */
    public static void height() {
        Ui.displayAskUserHeightMessage();
        String height = input();
        try {
            checkEmptyInput(height);
            checkInputIsDouble(height);
            checkHeightIsWithinRange(height);
            data[3] = height;

        } catch (NumberFormatException e) {
            displayInvalidHeightMessage();
            height();
        } catch (IllegalArgumentException e) {
            displayInvalidHeightRangeMessage();
            height();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            height();
        }
    }

    /**
     * ask user for age and save in an array entry.
     * must be between 1 to 120 years old.
     */
    public static void age() {
        Ui.displayAskUserAgeMessage();
        String age = input();
        try {
            checkEmptyInput(age);
            checkInputIsInt(age);
            checkAgeIsWithinRange(age);
            data[4] = age;

        } catch (NumberFormatException e) {
            displayInvalidAgeMessage();
            age();
        } catch (IllegalArgumentException e) {
            displayInvalidAgeRangeMessage();
            age();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            age();
        }
    }

    /**
     * ask user for activity level and save in an array entry.
     *
     */
    public static void activityLevel() {
        Ui.displayAskUserActivityLevelMessage();
        String activityLevel = input();
        try {
            checkEmptyInput(activityLevel);
            checkInputIsInt(activityLevel);
            checkAcLeIsWithinRange(activityLevel);
            data[5] = activityLevel;

        } catch (NumberFormatException e) {
            displayInvalidActivityLevelMessage();
            activityLevel();
        } catch (IllegalArgumentException e) {
            displayInvalidActivityLevelRangeMessage();
            activityLevel();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
            activityLevel();
        }
    }

    /**
     * user weight goal restricted to what is stated in enum.
     *
     */
    private enum WeightGoalEnum {
        lose, maintain, gain
    }

    /**
     * ask user for weight goal and save in an array entry.
     *
     */
    public static void weightGoal() {
        Ui.displayAskUserWeightGoalMessage();
        String weightGoal = input();

        try {
            checkEmptyInput(weightGoal);
            checkWeightGoal(weightGoal);
            data[6] = weightGoal;

        } catch (IllegalArgumentException e) {
            displayInvalidWeightGoalMessage();
            weightGoal();
        } catch (EmptyDescriptionException e) {
            ExceptionMessages.displayEmptyStringMessage();
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
        if (Double.parseDouble(weight) < 30 || Double.parseDouble(weight) > 650) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkHeightIsWithinRange(String height) throws IllegalArgumentException {
        if (Double.parseDouble(height) < 90 || Double.parseDouble(height) > 300) {
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

    public static void checkEmptyInput(String userInput) throws EmptyDescriptionException {
        if (userInput.equals(" ") || userInput.equals("")) {
            throw new EmptyDescriptionException();
        }
    }

    public static void checkEmptyInput2(String[] data) throws EmptyDescriptionException {
        for (String datum : data) {
            if (datum.isEmpty() || datum.isBlank()) {
                throw new EmptyDescriptionException();
            }
        }
    }

    public static InitialiseUserProfile enterNewUserInfo() throws IOException {
        InitialiseUserProfile profile =
                new InitialiseUserProfile(data[0],data[1],data[2],data[3],data[4],data[5],data[6]);
        System.out.println(profile.calculateNewUserDetails());
        UserProfile.save(profile);
        return profile;
    }

    /**
     * override and save user details in text file.
     *
     * @param profile to be saved in text file
     */
    public static void saveExistingUserInfo(InitialiseUserProfile profile) throws IOException {
        UserProfile.save(profile);
    }

    /**
     * create a new text file and save user input into the text file.
     *
     * @param profile question to be printed
     */
    public static void save(InitialiseUserProfile profile) throws IOException {
        UserInfoStorage storage = new UserInfoStorage();
        storage.save(profile.toString());
    }

    /**
     * Reading user input from existing text file and save a profile type.
     *
     * @return Storage type
     */
    public static InitialiseUserProfile loadProfile() {
        String[] data = new String[7];
        ArrayList<String> previous = UserInfoStorage.update();


        for (int i = 0; i < 7; i++) {
            try {
                if (!previous.get(i).isEmpty()) {
                    data[i] = previous.get(i);
                } else {
                    throw new NullPointerException();
                }
            } catch (IndexOutOfBoundsException e) {
                displayInvalidEditedUserProfileMessage();
                createNewProfile();
                return null;
            }
        }

        try {
            checkEmptyInput2(data);
            checkGender(data[1]);
            checkWeightGoal(data[6]);
            checkInputIsInt(data[4]);
            checkInputIsDouble(data[2]);
            checkInputIsInt(data[5]);
            checkInputIsDouble(data[3]);
            checkAcLeIsWithinRange(data[5]);
            checkAgeIsWithinRange(data[4]);
            checkWeightIsWithinRange(data[2]);
            checkHeightIsWithinRange(data[3]);
        } catch (IllegalArgumentException | EmptyDescriptionException | NullPointerException e) {
            displayInvalidEditedUserProfileMessage();
            createNewProfile();
            return null;
        }

        InitialiseUserProfile profile =
                new InitialiseUserProfile(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
        profile.calculateNewUserDetails();
        try {
            UserProfile.saveExistingUserInfo(profile);
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return profile;
    }
}