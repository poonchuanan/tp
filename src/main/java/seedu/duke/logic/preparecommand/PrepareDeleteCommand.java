package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;

import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandStringOutOfBoundExceptionMessage;

/**
 * Prepares user input for delete command.
 */
public class PrepareDeleteCommand extends PrepareCommand {
    public PrepareDeleteCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the delete command by checking the userInput.
     *
     * @return DeleteCommand
     */
    public Command prepareCommand() {
        try {
            if (description[1].equals("all/")) {
                return new DeleteCommand();
            } else {
                int index = Integer.parseInt(description[1]) - 1;
                checkIndex(index);
                return new DeleteCommand(index);
            }
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            displayDeleteCommandStringOutOfBoundExceptionMessage();
        }
        return null;
    }

}
