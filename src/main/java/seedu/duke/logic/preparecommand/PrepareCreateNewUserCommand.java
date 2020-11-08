package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

/**
 * Prepares create new user command.
 */
public class PrepareCreateNewUserCommand extends PrepareCommand {
    protected final int ARGUMENT_LIMIT = 1;

    /**
     * Initializes PrepareCreateNewUserCommand.
     *
     * @param description A list of description from parser
     */
    public PrepareCreateNewUserCommand(String[] description) {
        super(description);
    }

    /**
     * Checks for the validity of description.
     *
     * @return CreateNewUserCommand
     */
    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
            return new CreateNewUserCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }
}
