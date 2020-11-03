package seedu.duke.logic.preparecommand;

import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;

public class PrepareByeCommand extends PrepareCommand {
    public PrepareByeCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() throws Exception {
        return new ByeCommand();
    }
}
