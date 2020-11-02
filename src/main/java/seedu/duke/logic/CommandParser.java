package seedu.duke.logic;


import seedu.duke.command.Command;
import seedu.duke.command.CreateNewRepeatedSet;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.command.InvalidCommand;
import java.io.IOException;
import java.time.LocalDate;
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
        String[] arguments = userInput.split(SPACE, 2);
        try {
            switch (arguments[0].toLowerCase()) {
            case "create":
                return new CreateNewUserCommand();
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
