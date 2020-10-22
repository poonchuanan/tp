package seedu.duke.command;


import static seedu.duke.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;

public class MoveActivityCommand extends Command {
    private int indexToBeMovedFrom;
    private int indexToBeInsertedBelow;
    public static String indexNotANumberMessage = "The index given is not a number!";
    public static String indexOutOfBoundsMessage = "The index given is out of bounds!";

    public MoveActivityCommand(int indexToBeChanged, int indexToBeInsertedBelow) {
        this.indexToBeMovedFrom = indexToBeChanged;
        this.indexToBeInsertedBelow = indexToBeInsertedBelow;
    }

    @Override
    public void execute() {
        try {
            dayMap.move(indexToBeMovedFrom, indexToBeInsertedBelow);
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        }
    }
}
/**
 *
 **/