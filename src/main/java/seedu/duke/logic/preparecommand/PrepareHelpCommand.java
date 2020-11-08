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
    public PrepareHelpCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(1);
            return new HelpCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }
}
