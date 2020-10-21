package seedu.duke.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static seedu.duke.ExceptionMessages.displayExistingFileMessage;

public class UserSetStorage {
    private static final String PATH = new File("").getAbsolutePath();

    public static void prepareNewSet(String userInput) {
        String fileName = userInput.substring(0, userInput.indexOf("/")-2);
        createNewTextFile("/" + fileName + ".txt", userInput.substring(userInput.indexOf("c/")));
    }

    public static void createNewTextFile(String fileName, String toTrim) {
        String FILE_PATH = PATH + fileName;
        File file = new File(FILE_PATH);

        try {
            boolean isFileCreated = file.createNewFile();
            if (!isFileCreated) {
                file.createNewFile();
            }
        } catch (IOException e) {
            displayExistingFileMessage();
        }
        updateTextFile(FILE_PATH, toTrim);
    }

    public static void prepareSetUserInput (String userInput) {
    }

    public static void updateTextFile (String path, String trimmed) {
        try {
            Files.writeString(Path.of(path),trimmed);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error\n");
        } catch (IOException e) {
            displayExistingFileMessage();
        }
    }
}