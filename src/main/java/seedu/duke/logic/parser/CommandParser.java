package seedu.duke.logic.parser;

import seedu.duke.command.Command;
import seedu.duke.command.CreateNewSetCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.logic.preparecommand.PrepareAddCommand;
import seedu.duke.logic.preparecommand.PrepareAddSetCommand;
import seedu.duke.logic.preparecommand.PrepareByeCommand;
import seedu.duke.logic.preparecommand.PrepareDeleteCommand;
import seedu.duke.logic.preparecommand.PrepareEditCommand;
import seedu.duke.logic.preparecommand.PrepareFindCommand;
import seedu.duke.logic.preparecommand.PrepareGraphCommand;
import seedu.duke.logic.preparecommand.PrepareHelpCommand;
import seedu.duke.logic.preparecommand.PrepareListCommand;
import seedu.duke.logic.preparecommand.PrepareMoveIndexCommand;
import seedu.duke.logic.preparecommand.PrepareUserCommand;

import static seedu.duke.Trakcal.logging;
import static seedu.duke.ui.ExceptionMessages.displayInvalidInputErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;

/**
 * Initialises parser class.
 */
public class CommandParser extends Parser {
    public static final String SPACE = " ";
    public static final int SPLIT_LIMIT = 2;

    private static final String USER_COMMAND = "user";
    private static final String CREATESET_COMMAND = "createset";
    private static final String ADD_COMMAND = "add";
    private static final String ADDSET_COMMAND = "addset";
    private static final String FIND_COMMAND = "find";
    private static final String EDITA_COMMAND = "edit";
    private static final String DELETE_COMMAND = "delete";
    private static final String LIST_COMMAND = "list";
    private static final String HELP_COMMAND = "help";
    private static final String MOVE_COMMAND = "move";
    private static final String BYE_COMMAND = "bye";
    private static final String GRAPH_COMMAND = "graph";


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
        logging.writeToLogInfo("UserInput about to be parsed.");
        String[] arguments = userInput.split(SPACE, SPLIT_LIMIT);
        try {
            switch (arguments[0].toLowerCase()) {
            case USER_COMMAND:
                return new PrepareUserCommand(arguments).prepareCommand();
            case CREATESET_COMMAND:
                return new CreateNewSetCommand(arguments[1]);
            case ADD_COMMAND:
                return new PrepareAddCommand(arguments).prepareCommand();
            case ADDSET_COMMAND:
                return new PrepareAddSetCommand(arguments).prepareCommand();
            case FIND_COMMAND:
                return new PrepareFindCommand(arguments).prepareCommand();
            case EDITA_COMMAND:
                return new PrepareEditCommand(arguments).prepareCommand();
            case DELETE_COMMAND:
                return new PrepareDeleteCommand(arguments).prepareCommand();
            case LIST_COMMAND:
                return new PrepareListCommand(arguments).prepareCommand();
            case HELP_COMMAND:
                return new PrepareHelpCommand(arguments).prepareCommand();
            case MOVE_COMMAND:
                return new PrepareMoveIndexCommand(arguments).prepareCommand();
            case BYE_COMMAND:
                return new PrepareByeCommand(arguments).prepareCommand();
            case GRAPH_COMMAND:
                return new PrepareGraphCommand(arguments).prepareCommand();
            default:
                return new InvalidCommand(displayInvalidInputErrorMessage());
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

}
