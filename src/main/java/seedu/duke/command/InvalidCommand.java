package seedu.duke.command;

import static seedu.duke.ui.ExceptionMessages.print;

/**
 * Represents an invalid command.
 */
public class InvalidCommand extends Command {

    String invalidCommandMessage;

    public InvalidCommand(String invalidCommandMessage) {
        this.invalidCommandMessage = invalidCommandMessage;
    }


    @Override
    public void execute() {
        print(invalidCommandMessage);
    }
}
