package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.MoveActivityCommand;

import static seedu.duke.ui.ExceptionMessages.displayIndexNotNumberExceptionMessage;
import static seedu.duke.ui.Ui.PROMPTUSEROFHELPMESSAGE;
//@@author chewyang



/**
 * Prepares move command.
 */
public class PrepareMoveIndexCommand extends PrepareCommand {

    public static final String SPACE = " ";
    public static final String FROM_KEYWORD = "from/";
    public static final String BELOW_KEYWORD = "below/";
    public static final String BOTH_KEY_MISSING_ERROR_MESSAGE = "'from/' and 'below/' keyword is missing!\n "
            + PROMPTUSEROFHELPMESSAGE;
    public static final String FROM_KEY_MISSING_ERROR_MESSAGE = "'from/' keyword is missing!\n"
            + PROMPTUSEROFHELPMESSAGE;
    public static final String BELOW_KEY_MISSING_ERROR_MESSAGE = "'below/' keyword is missing!\n"
            + PROMPTUSEROFHELPMESSAGE;


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
        String after = description[1].trim().replaceAll(" +", SPACE).toLowerCase();


        int firstIndex = after.indexOf(FROM_KEYWORD) + FROM_KEYWORD.length(); //index after first keyword
        int secondIndex = after.indexOf(BELOW_KEYWORD) + BELOW_KEYWORD.length(); //index after second keyword

        if (!after.contains(FROM_KEYWORD) && !after.contains(BELOW_KEYWORD)) {
            return new InvalidCommand(BOTH_KEY_MISSING_ERROR_MESSAGE);
        } else if (!after.contains(FROM_KEYWORD)) {
            return new InvalidCommand(FROM_KEY_MISSING_ERROR_MESSAGE);
        } else if (!after.contains(BELOW_KEYWORD)) {
            return new InvalidCommand(BELOW_KEY_MISSING_ERROR_MESSAGE);
        }


        String firstIndexString = after.substring(firstIndex).trim().split(SPACE)[0];
        String secondIndexString = after.substring(secondIndex).trim().split(SPACE)[0];
        int indexToBeChanged;
        int indexToBeInsertedBelow;
        try {
            indexToBeChanged = Integer.parseInt(firstIndexString);
            indexToBeInsertedBelow = Integer.parseInt(secondIndexString);
            return new MoveActivityCommand(indexToBeChanged, indexToBeInsertedBelow);
        } catch (NumberFormatException e) {
            displayIndexNotNumberExceptionMessage();
            //return new InvalidCommand();
        }
        return null;
    }
}
