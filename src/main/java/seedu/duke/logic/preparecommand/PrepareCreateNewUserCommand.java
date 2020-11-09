package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

public class PrepareCreateNewUserCommand extends PrepareCommand {

    public PrepareCreateNewUserCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(1);
            return new CreateNewUserCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }
}
