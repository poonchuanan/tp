package seedu.duke.storage;

//import java.io.;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystemAlreadyExistsException;

import seedu.duke.ui.Ui;

//import static seedu.duke.ui.ExceptionMessages.*;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayShortcutDoesNotExistMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCalorieEntryMessage;
import static seedu.duke.ui.ExceptionMessages.displayExistingFileMessage;

public class UserSetStorage {
    private static final String PATH = new File("").getAbsolutePath();

    public static void prepareNewSet(String userInput) {
        String fileName = userInput.substring(0, userInput.indexOf("/") - 2);
        createNewTextFile("/" + fileName + ".txt", userInput.substring(userInput.indexOf("/") - 1));
    }

    public static void createNewTextFile(String fileName, String toTrim) {
        String filePath = PATH + fileName;
        File file = new File(filePath);

        try {
            boolean isFileCreated = file.createNewFile();
            if (!isFileCreated) {
                file.createNewFile();
            }
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        updateTextFile(filePath, toTrim);
    }

    public static void updateTextFile(String path, String toTrim) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String[] activity = toTrim.split("\\+");
            int index = 1;

            for (String s : activity) {
                if (s.startsWith(" ")) {
                    s = s.substring(1);
                }

                if (s.endsWith(" ")) {
                    s = s.substring(0, s.length() - 1);
                }

                bw.write(s);
                String calories = s.substring(s.indexOf("c/") + 2);
                Integer.parseInt(calories);

                if (index == 1) {
                    Ui.drawDivider();
                    System.out.println("You have created a shortcut containing:");
                }

                if (s.startsWith("f/")) {
                    System.out.println(index + ". " + "Food: " + s.substring(2,s.indexOf("c/") - 1)
                            + ", Calories: " + calories);
                } else if (s.startsWith("e/")) {
                    System.out.println(index + ". " + "Exercise: " + s.substring(2,s.indexOf("c/") - 1)
                            + ", Calories: " + calories);
                }
                index++;

                bw.newLine();
            }

            Ui.drawDivider();
            bw.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("There is no such set! Please create a new one first.\n");
        } catch (IOException e) {
            displayExistingFileMessage();
        } catch (NumberFormatException e) {
            displayInvalidCalorieEntryMessage();
        }
    }
}