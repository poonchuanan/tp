package seedu.duke.logic.preparecommand;

import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;
import seedu.duke.exception.InvalidNumberOfArguments;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

public class PrepareByeCommand extends PrepareCommand {
    public PrepareByeCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() throws Exception {
        try {
            isNumberOfArgumentsValid(1);
            return new ByeCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }
}
