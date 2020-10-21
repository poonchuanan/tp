package seedu.duke.storage;

//import java.io.;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static seedu.duke.ExceptionMessages.displayExistingFileMessage;

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
            displayExistingFileMessage();
        }
        updateTextFile(filePath, toTrim);
    }

    public static void updateTextFile(String path, String toTrim) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String[] activity = toTrim.split("&&");

            for (String s : activity) {
                if (s.startsWith(" ")) {
                    s = s.substring(1);
                }

                if (s.endsWith(" ")) {
                    s = s.substring(0, s.length() - 1);
                }

                bw.write(s);
                bw.newLine();
            }

            bw.close();

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Error\n");
        } catch (IOException e) {
            displayExistingFileMessage();
        }
    }
}