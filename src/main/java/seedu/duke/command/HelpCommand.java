package seedu.duke.command;

import static seedu.duke.Ui.displayHelpMessage;

/**
 * Help command.
 */
public class HelpCommand extends Command {
    public HelpCommand() {
    }

    @Override
    public void execute() {
        displayHelpMessage();
    }
}
