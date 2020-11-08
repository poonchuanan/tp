package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.DeleteByIndexCommand;

import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;

public class PrepareDeleteByIndexCommand extends PrepareCommand {


    public PrepareDeleteByIndexCommand(String[] description) {
        super(description);
    }

    @Override
    public Command prepareCommand() {
        try {
            int index = Integer.parseInt(description[1]) - 1;
            checkIndex(index);
            return new DeleteByIndexCommand(index);
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        }
        return null;
    }
}
