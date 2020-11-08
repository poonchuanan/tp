package seedu.duke.logic.preparecommand;

import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.command.GraphCommand;
import seedu.duke.exception.InvalidNumberOfArguments;
import seedu.duke.exception.ListNotFoundException;

import static seedu.duke.ui.ExceptionMessages.displayEmptyListError;
import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

/**
 * Prepares graph command.
 */
public class PrepareGraphCommand extends PrepareCommand {
    protected final int ARGUMENT_LIMIT = 1;

    public PrepareGraphCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the arguments needed for the graph command.
     *
     * @return graphCommand
     * @throws Exception if no records are found
     */
    public Command prepareCommand() throws Exception {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
            isListEmpty();
            return new GraphCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        } catch (ListNotFoundException e) {
            displayEmptyListError();
        }
        return null;
    }

    /**
     * Checks if the list is empty.
     *
     * @return false if list is not empty
     * @throws ListNotFoundException if list is empty or not found.
     */
    public boolean isListEmpty() throws ListNotFoundException {
        if (Trakcal.calList.getHashMap().size() == 0) {
            throw new ListNotFoundException();
        }
        return false;
    }

}
