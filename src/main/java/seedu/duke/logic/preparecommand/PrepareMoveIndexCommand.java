package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.MoveActivityCommand;
//@@author chewyang

/**
 * Prepares move command.
 */
public class PrepareMoveIndexCommand extends PrepareCommand {
    public static final String SPACE = " ";

    public PrepareMoveIndexCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the arguments needed for moving an activity from one index to another.
     *
     * @return the moveCommand
     * @throws IndexOutOfBoundsException if the index is not valid
     */
    @Override
    public Command prepareCommand() throws IndexOutOfBoundsException {
        //Removing additional spaces in the user's input
        String after = description[1].trim().replaceAll(" +", " ");
        String firstIndexKey = "from/";
        String secondIndexKey = "below/";


        int firstIndex = after.indexOf(firstIndexKey) + firstIndexKey.length(); //index after first keyword
        int secondIndex = after.indexOf(secondIndexKey) + secondIndexKey.length(); //index after second keyword

        if (!after.contains(firstIndexKey) && !after.contains(secondIndexKey)) {
            return new InvalidCommand("'from/' and 'below/' keyword is missing!");
        } else if (!after.contains(firstIndexKey)) {
            return new InvalidCommand("'from/' keyword is missing!");
        } else if (!after.contains(secondIndexKey)) {
            return new InvalidCommand("'below/' keyword is missing!");
        }


        String firstIndexString = after.substring(firstIndex).trim().split(SPACE)[0];
        String secondIndexString = after.substring(secondIndex).trim().split(SPACE)[0];
        int indexToBeChanged = 0;
        int indexToBeInsertedBelow = 0;
        try {
            indexToBeChanged = Integer.parseInt(firstIndexString);
            indexToBeInsertedBelow = Integer.parseInt(secondIndexString);
            return new MoveActivityCommand(indexToBeChanged, indexToBeInsertedBelow);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid index!");
        }
        return null;

    }
}
