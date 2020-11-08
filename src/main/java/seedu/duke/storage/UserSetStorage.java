package seedu.duke.storage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static seedu.duke.ui.ExceptionMessages.displayMissingAddSetInfoMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCalorieMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCreateSetCommandMessage;
import static seedu.duke.ui.ExceptionMessages.displayIncompleteSetMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieMustBeIntegerMessage;
import static seedu.duke.ui.ExceptionMessages.displayMissingFileNameMessage;

import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.FileAlreadyExistException;
import seedu.duke.exception.InvalidCalorieException;
import seedu.duke.exception.InvalidCreateSetCommandException;
import seedu.duke.exception.NoFileNameException;
import seedu.duke.ui.Ui;

import static seedu.duke.ui.ExceptionMessages.displayExistingShortcutMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;

public class UserSetStorage {
    private static final String PATH = new File("").getAbsolutePath();
    private static final Integer MAX_CALORIES = 3000;
    private static final Integer MIN_CALORIES = 0;
    private static final String WHITE_SPACE = " ";
    private static final String FOOD_TAG = "/f";
    private static final String CALORIE_TAG = "c/";
    private static final String EXERCISE_TAG = "e/";

    public static void prepareNewSet(String userInput) {
        try {
            checkFileNamePresent(userInput);
            String fileName = userInput.substring(0, userInput.indexOf("/") - 2);

            createNewTextFile("/" + fileName + ".txt", userInput.substring(userInput.indexOf("/") - 1));
        } catch (NoFileNameException e) {
            displayMissingFileNameMessage();
        }
    }

    public static void createNewTextFile(String fileName, String toTrim) {
        String filePath = PATH + fileName;

        try {
            checkExistingFile(filePath);
            File file = new File(filePath);
            file.createNewFile();

        } catch (IOException e) {
            displayIoExceptionMessage();
        } catch (FileAlreadyExistException e) {
            displayExistingShortcutMessage();
            return;
        }
        updateTextFile(filePath, toTrim);
    }

    public static void deleteInvalidSetFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }

    public static void updateTextFile(String path, String toTrim) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

            String[] activity = toTrim.split("\\+");
            int index = 1;

            for (String s : activity) {
                checkActivityAndCalorieTag(s);
                while (s.startsWith(WHITE_SPACE)) {
                    s = s.substring(1);
                }

                while (s.endsWith(WHITE_SPACE)) {
                    s = s.substring(0, s.length() - 1);
                }

                bw.write(s);
                String calories = s.substring(s.indexOf(CALORIE_TAG) + 2);
                String description = s.substring(2,s.indexOf(CALORIE_TAG) - 1);

                checkEmptyDescription(description);
                checkEmptyDescription(calories);
                checkCalorieType(calories);
                checkValidCalorieRange(calories);
                Integer.parseInt(calories);

                if (index == 1) {
                    Ui.drawDivider();
                    System.out.println("You have created a shortcut containing:");
                }

                if (s.indexOf(FOOD_TAG) == 1) {
                    System.out.println(index + ". " + "Food: " + description
                            + ", Calories: " + calories);
                } else if (s.indexOf(EXERCISE_TAG) == 1) {
                    System.out.println(index + ". " + "Exercise: " + description
                            + ", Calories: " + calories);
                }

                index++;
                bw.newLine();
            }

            Ui.drawDivider();
            System.out.println();
            bw.close();

        } catch (IOException e) {
            displayIncompleteSetMessage();
            deleteInvalidSetFile(path);
        } catch (InvalidCreateSetCommandException e) {
            displayInvalidCreateSetCommandMessage();
            displayIncompleteSetMessage();
            deleteInvalidSetFile(path);
        } catch (InvalidCalorieException e) {
            displayInvalidCalorieMessage();
            displayIncompleteSetMessage();
            deleteInvalidSetFile(path);
        } catch (EmptyDescriptionException e) {
            displayMissingAddSetInfoMessage();
            displayIncompleteSetMessage();
            deleteInvalidSetFile(path);
        } catch (NumberFormatException e) {
            displayCalorieMustBeIntegerMessage();
            displayIncompleteSetMessage();
            deleteInvalidSetFile(path);
        }
    }

    private static void checkEmptyDescription(String description) throws EmptyDescriptionException {
        if (description.isBlank() || description.isEmpty()) {
            throw new EmptyDescriptionException();
        }
    }

    private static void checkExistingFile(String fileName) throws FileAlreadyExistException {
        File file = new File(fileName);
        if (file.exists()) {
            throw new FileAlreadyExistException();
        }
    }

    private static void checkActivityAndCalorieTag(String input) throws InvalidCreateSetCommandException {
        if (!input.contains(CALORIE_TAG) || !(input.contains(FOOD_TAG) || input.contains(EXERCISE_TAG))) {
            throw new InvalidCreateSetCommandException();
        }
    }

    private static void checkValidCalorieRange(String input) throws InvalidCalorieException {
        int calories = Integer.parseInt(input);
        if (calories < MIN_CALORIES || calories > MAX_CALORIES) {
            throw new InvalidCalorieException();
        }
    }

    private static void checkCalorieType(String input) throws NumberFormatException {
        Integer.parseInt(input);
    }

    private static void checkFileNamePresent(String input) throws NoFileNameException {
        if (input.indexOf(FOOD_TAG) == 1 || input.indexOf(EXERCISE_TAG) == 1) {
            throw new NoFileNameException();
        }
    }
}