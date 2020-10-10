package seedu.duke.command;

import static seedu.duke.Ui.displayByeMessage;

public class ByeCommand extends Command {
    public ByeCommand() {
    }

    @Override
    public void execute() {
        displayByeMessage();
        System.exit(0);
    }
}
