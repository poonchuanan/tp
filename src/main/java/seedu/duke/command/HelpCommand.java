package seedu.duke.command;

import static seedu.duke.Ui.displayHelpMessage;

public class HelpCommand extends Command{
    public HelpCommand() {
    }

    @Override
    public void execute() {
        displayHelpMessage();
    }
}
