package seedu.duke.logic.preparecommand;

import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.exception.InvalidNumberOfArguments;
import seedu.duke.model.DayMap;

import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandStringOutOfBoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayShortageOfArguments;

/**
 * Prepares user input for delete command.
 */
public class PrepareDeleteCommand extends PrepareCommand {
    protected final int ARGUMENT_LIMIT = 2;
    protected final String DELETE_ALL_KEYWORD = "all";
    protected DayMap dayMap;

    /**
     * Initializes PrepareDeleteCommand.
     *
     * @param description list of description from parser.
     */
    public PrepareDeleteCommand(String[] description) {
        super(description);
        dayMap = Trakcal.calList;
    }

    /**
     * Prepares the delete command by checking the userInput.
     *
     * @return DeleteCommand
     */
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
            if (description[1].equals(DELETE_ALL_KEYWORD)) {
                return new PrepareDeleteAll(description).prepareCommand();
            } else {
                return new PrepareDeleteByIndexCommand(description).prepareCommand();
            }
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            displayDeleteCommandStringOutOfBoundExceptionMessage();
        } catch (InvalidNumberOfArguments e) {
            displayShortageOfArguments();
        }
        return null;
    }

}
