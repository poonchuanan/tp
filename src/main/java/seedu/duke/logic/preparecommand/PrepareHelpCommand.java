package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.HelpCommand;

/**
 * Prepares help command.
 */
public class PrepareHelpCommand extends PrepareCommand {
    public PrepareHelpCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() throws Exception {
        return new HelpCommand();
    }
}
