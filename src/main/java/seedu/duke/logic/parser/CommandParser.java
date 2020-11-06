package seedu.duke.logic.parser;


import seedu.duke.command.Command;
import seedu.duke.command.CreateNewRepeatedSet;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.logic.preparecommand.PrepareAddCommand;
import seedu.duke.logic.preparecommand.PrepareAddSetCommand;
import seedu.duke.logic.preparecommand.PrepareByeCommand;
import seedu.duke.logic.preparecommand.PrepareDeleteCommand;
import seedu.duke.logic.preparecommand.PrepareEditCommand;
import seedu.duke.logic.preparecommand.PrepareEditUserProfile;
import seedu.duke.logic.preparecommand.PrepareFindCommand;
import seedu.duke.logic.preparecommand.PrepareGraphCommand;
import seedu.duke.logic.preparecommand.PrepareHelpCommand;
import seedu.duke.logic.preparecommand.PrepareListCommand;
import seedu.duke.logic.preparecommand.PrepareMoveIndexCommand;
import seedu.duke.logic.preparecommand.PrepareProfileListCommand;
import seedu.duke.logic.preparecommand.PrepareUserCommand;

import java.io.IOException;

import static seedu.duke.ui.ExceptionMessages.displayInvalidInputErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;


/**
 * Initialises parser class.
 */
public class CommandParser extends Parser {
    public static final String SPACE = " ";


    /**
     * Store details in the class.
     *
     * @param userInput user from the user
     */
    public CommandParser(String userInput) {
        super(userInput);
    }

    /**
     * Parses commands input by user.
     *
     * @return Command type
     */
    @Override
    public Command parseArgument() {
        this.userInput = checkExtraSpaces();
        String[] arguments = userInput.split(SPACE, 2);
        try {
            switch (arguments[0].toLowerCase()) {
            case "user":
                return new PrepareUserCommand(arguments).prepareCommand();
            case "createset":
                return new CreateNewRepeatedSet(arguments[1]);
            case "add":
                return new PrepareAddCommand(arguments).prepareCommand();
            case "addset":
                return new PrepareAddSetCommand(arguments).prepareCommand();
            case "find":
                return new PrepareFindCommand(arguments).prepareCommand();
            case "edit":
                return new PrepareEditUserProfile(arguments).prepareCommand();
            case "edita":
                return new PrepareEditCommand(arguments).prepareCommand();
            case "delete":
                return new PrepareDeleteCommand(arguments).prepareCommand();
            case "list":
                return new PrepareListCommand(arguments).prepareCommand();
            case "listup":
                return new PrepareProfileListCommand(arguments).prepareCommand();
            case "help":
                return new PrepareHelpCommand(arguments).prepareCommand();
            case "move":
                return new PrepareMoveIndexCommand(arguments).prepareCommand();
            case "bye":
                return new PrepareByeCommand(arguments).prepareCommand();
            case "graph":
                return new PrepareGraphCommand(arguments).prepareCommand();
            default:
                return new InvalidCommand(displayInvalidInputErrorMessage());
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (IOException e) {
            displayIoExceptionMessage();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

}
