package seedu.duke.command;

import static seedu.duke.ui.Ui.displayByeMessage;

/**
 * Bye command.
 */
public class ByeCommand extends Command {
    public ByeCommand() {
    }

    @Override
    public void execute() {
        displayByeMessage();
        System.exit(0);
    }
}
