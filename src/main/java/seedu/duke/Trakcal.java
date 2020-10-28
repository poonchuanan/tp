package seedu.duke;

import java.io.File;

import seedu.duke.command.Command;
import seedu.duke.logic.Parser;
import seedu.duke.model.DayMap;
import seedu.duke.storage.Storage;
import seedu.duke.userprofile.SaveAndAskForUserProfile;
import seedu.duke.userprofile.InitialiseAndCalculateUserProfile;
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
    public static InitialiseAndCalculateUserProfile profile;

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
            profile = SaveAndAskForUserProfile.createNewProfile();
        } else {
            profile = SaveAndAskForUserProfile.loadProfile();
        }
        Trakcal.run();
    }

    public static void run()  {
        while (in.hasNextLine()) {
            String userInput = in.nextLine();
            Parser parser = new Parser(userInput);
            try {
                Command cmd;
                if (userInput.contains(CHAIN_SEPARATOR)) {
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

    public static void executeCmd(Command cmd) throws NullPointerException {
        cmd.setData(calList);
        cmd.execute();
    }

    private static String getJarFilePath() {
        return new File(Trakcal.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                .getParent().replace("%20", SPACE);
    }
}
