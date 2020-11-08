package seedu.duke.logic.preparecommand;

import seedu.duke.Trakcal;
import seedu.duke.command.Command;
import seedu.duke.exception.InvalidNumberOfArguments;
import seedu.duke.model.DayMap;

import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandStringOutOfBoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayShortageOfArguments;

public class PrepareDeleteCommand extends PrepareCommand {
    private DayMap dayMap;

    public PrepareDeleteCommand(String[] description) {
        super(description);
        dayMap = Trakcal.calList;
    }

    /**
     * Prepares the delete command by checking the userInput.
     *
     * @return DeleteCommand
     */
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(2);
            if (description[1].equals("all/")) {
                return new PrepareDeleteAll(description).prepareCommand();
            } else {
                return new PrepareDeleteByIndexCommand(description).prepareCommand();
            }
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            displayDeleteCommandStringOutOfBoundExceptionMessage();
        } catch (InvalidNumberOfArguments e) {
            displayShortageOfArguments();
        }
        return null;
    }

}
