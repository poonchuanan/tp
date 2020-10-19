package seedu.duke.command;


public class InsertActivityBelow extends Command {
    private int indexToBeChanged;
    private int indexToBeInsertedBelow;
    public static String indexNotANumberMessage = "The index given is not a number!";
    public static String indexOutOfBoundsMessage = "The index given is out of bounds!";

    public InsertActivityBelow(int indexToBeChanged, int indexToBeInsertedBelow) {
        this.indexToBeChanged = indexToBeChanged;
        this.indexToBeInsertedBelow = indexToBeInsertedBelow;
    }

    @Override
    public void execute() {
        dayMap.insert(indexToBeChanged, indexToBeInsertedBelow);
    }
}
/**
 *
 **/