package seedu.duke;

import java.io.File;

import seedu.duke.command.Command;
import seedu.duke.logic.Parser;
import seedu.duke.model.DayMap;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.userprofile.UserProfile;
import seedu.duke.userprofile.InitialiseUserProfile;
import seedu.duke.userprofile.CheckNewUser;


import java.util.Scanner;

import static seedu.duke.logic.Parser.CHAIN_SEPARATOR;
import static seedu.duke.logic.Parser.SPACE;
import static seedu.duke.ui.Ui.displayNotSavedMessage;
import static seedu.duke.ui.Ui.displayWelcomeMessage;
import static seedu.duke.ui.ExceptionMessages.displayParserNullPointerExceptionMessage;

/**
 * Entry point of the traKCAL application.
 * Initialises the application and starts the interaction with the user.
 */
public class Trakcal {

    public static DayMap calList = new DayMap();
    public static InitialiseUserProfile profile;

    public static Scanner in = new Scanner(System.in);
    public static Storage storage = new Storage(getJarFilePath() + "/tpdata/tpcsv.csv");

    /**
     * Main function.
     * @param args args
     */
    public static void main(String[] args) {
        displayWelcomeMessage();
        System.out.println();
        try {
            storage.loadData(calList);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("here");
        }
        if (CheckNewUser.isNewUser()) {
            profile = UserProfile.createNewProfile();
        } else {
            Ui.displayReturningUserMessage();
            profile = UserProfile.loadProfile();
        }
        Trakcal.run();
    }

    /**
     * Main running loop.
     */
    public static void run()  {
        while (in.hasNextLine()) {
            String userInput = in.nextLine();
            Parser parser = new Parser(userInput);
            try {
                Command command;
                if (userInput.contains(CHAIN_SEPARATOR)) {
                    parser.prepareChaining(userInput);
                } else {
                    command = parser.parseCommand();
                    executeCmd(command);
                    storage.updateFile(calList);
                }
            } catch (NullPointerException e) {
                displayParserNullPointerExceptionMessage();
            } catch (IndexOutOfBoundsException e) {
                displayNotSavedMessage();
            }
        }
    }

    /**
     * Sets the data for each command and executes the command.
     * @param command command to execute
     * @throws NullPointerException if invalid command
     */
    public static void executeCmd(Command command) throws NullPointerException {
        command.setData(calList);
        command.execute();
    }

    /**
     * Gets the file path of the jar file.
     * @return string of the file path
     */
    private static String getJarFilePath() {
        return new File(Trakcal.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                .getParent().replace("%20", SPACE);
    }
}
