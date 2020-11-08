package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.HelpCommand;

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
        return new HelpCommand();
    }
}
