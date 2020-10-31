package seedu.duke.command;


import seedu.duke.exception.ListNotFoundException;

import static seedu.duke.ui.ExceptionMessages.displayListNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;

/**
 * This command moves an activity from one index to another.
 */
public class MoveActivityCommand extends Command {
    private int indexToBeMovedFrom;
    private int indexToBeInsertedBelow;

    public MoveActivityCommand(int indexToBeChanged, int indexToBeInsertedBelow) {
        this.indexToBeMovedFrom = indexToBeChanged;
        this.indexToBeInsertedBelow = indexToBeInsertedBelow;
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            dayMap.move(indexToBeMovedFrom, indexToBeInsertedBelow);
        } catch (IndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (ListNotFoundException e) {
            displayListNotFoundExceptionMessage();
        }

    }
}