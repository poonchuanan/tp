package seedu.duke;

import java.io.File;

import seedu.duke.command.Command;
import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;
import seedu.duke.userprofile.CheckNewUser;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.Ui.displayNotSavedMessage;
import static seedu.duke.Ui.displayWelcomeMessage;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ExceptionMessages.displayParserNullPointerExceptionMessage;

/**
 * Entry point of the traKCAL application.
 * Initialises the application and starts the interaction with the user.
 */
public class Duke {

    public static DayMap calList = new DayMap();
    public static Userinfo profile;

    public static Scanner in = new Scanner(System.in);
    public static Storage storage = new Storage(getJarFilePath() + "/tpdata/tpcsv.csv");

    public static void main(String[] args) {
        displayWelcomeMessage();
        System.out.println();
        try {
            storage.loadData(calList);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("here");
        }
        if (CheckNewUser.isNewUser()) {
            Initialiseuser.createNewProfile();
        } else {
            Initialiseuser.loadProfile();
        }
        Duke.run();
    }

    public static void run()  {
        while (in.hasNextLine()) {
            String userInput = in.nextLine();
            Parser parser = new Parser(userInput);
            try {
                Command cmd;
                if (userInput.contains("&&") && userInput.charAt(userInput.indexOf("&&") + 4) != '/') {
                    parser.prepareChaining(userInput);
                } else {
                    cmd = parser.parseCommand();
                    executeCmd(cmd);
                    storage.updateFile(calList);
                }
                System.out.println();
            } catch (NullPointerException e) {
                displayParserNullPointerExceptionMessage();
            } catch (IndexOutOfBoundsException e) {
                displayNotSavedMessage();
            }
        }
    }

    public static void executeCmd(Command cmd) {
        cmd.setData(calList);
        cmd.execute();
    }

    private static String getJarFilePath() {
        return new File(Duke.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                .getParent().replace("%20", " ");
    }
}
