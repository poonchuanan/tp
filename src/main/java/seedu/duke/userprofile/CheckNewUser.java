package seedu.duke.userprofile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckNewUser {
    private static final String PATH = new File("").getAbsolutePath();
    public static final String FILE_PATH = PATH + "/tp.txt";

    /**
     * Check if it is a new user.
     *
     * @return boolean for new user outcome
     */
    public static boolean isNewUser() {
        if (!Files.exists(Path.of(FILE_PATH))) {
            System.out.println("Hey there! We do not have a record of your profile. Please create one now! :)\n");
            return true;
        }
        return false;
    }
}
