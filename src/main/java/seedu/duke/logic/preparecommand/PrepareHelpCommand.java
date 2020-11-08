package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.HelpCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

//@@author e0425705
/**
 * Prepares help command.
 */
public class PrepareHelpCommand extends PrepareCommand {
    protected final int ARGUMENT_LIMIT = 1;

    public PrepareHelpCommand(String[] description) {
        super(description);
    }

    /**
     * Checks for validity of help command.
     *
     * @return help command
     */
    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
            return new HelpCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }
}
