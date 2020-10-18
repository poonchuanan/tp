package seedu.duke.command;

import static seedu.duke.ExceptionMessages.displayInvalidInputErrorMessage;

public class InvalidCommand extends Command{

    public InvalidCommand() {
    }

    @Override
    public void execute() {
        displayInvalidInputErrorMessage();
    }
}
