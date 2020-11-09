package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.CreateNewSet;
import seedu.duke.exception.ListNotFoundException;

public class PrepareNewSetCommand extends PrepareCommand {
    public PrepareNewSetCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() throws Exception, ListNotFoundException {
        return new CreateNewSet(description[1]);
    }
}
