package seedu.duke.command;


import seedu.duke.exception.ListNotFoundException;

import java.util.logging.Level;

import static seedu.duke.Trakcal.logging;
import static seedu.duke.ui.ExceptionMessages.displayListNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.print;
//@@author chewyang

/**
 * This command moves an activity from one index to another.
 */
public class MoveActivityCommand extends Command {
    private int indexToBeMovedFrom;
    private int indexToBeInsertedBelow;
    private static final String MOVE_COMMAND_SUCCESS_MESSAGE = "Activity has been successfully moved!";
    private static final String OUT_OF_BOUNDS_MESSAGE = "Accessing an index that is out of bounds, move unsuccessful";
    private static final String EMPTY_LIST_MESSAGE = "Accessing a list that does not exist, move unsuccessful";

    public MoveActivityCommand(int indexToBeChanged, int indexToBeInsertedBelow) {
        this.indexToBeMovedFrom = indexToBeChanged;
        this.indexToBeInsertedBelow = indexToBeInsertedBelow;
    }

    @Override
    public void execute() {
        try {
            dayMap.move(indexToBeMovedFrom, indexToBeInsertedBelow);
            print(MOVE_COMMAND_SUCCESS_MESSAGE);
            logging.writeToLogInfo(MOVE_COMMAND_SUCCESS_MESSAGE);
        } catch (IndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
            logging.writeToLogWarning(OUT_OF_BOUNDS_MESSAGE);
        } catch (ListNotFoundException e) {
            displayListNotFoundExceptionMessage();
            logging.writeToLogWarning(EMPTY_LIST_MESSAGE);
        }

    }
}
//@@author chewyang
