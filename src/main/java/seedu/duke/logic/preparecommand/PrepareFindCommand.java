package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.FindAllCommand;
import seedu.duke.command.FindCalorieCommand;
import seedu.duke.command.FindDescriptionCommand;
import seedu.duke.command.FindEitherCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;
import static seedu.duke.ui.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayShortageOfArguments;

public class PrepareFindCommand extends PrepareCommand {
    protected static final String CALORIE_TAG = "c/";

    public PrepareFindCommand(String[] description) {
        super(description);
    }


    /**
     * Prepares the find command by checking the userInput.
     * If the keyword contains activity description, returns FindDescriptionCommand.
     * Else if the keyword contains calories count, returns FindCalorieCommand.
     *
     * @return FindCalorieCommand
     */
    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(2);
            if (description[1].startsWith("d/")) {
                String descriptionString = description[1].substring(2).trim();
                return new FindDescriptionCommand(descriptionString);
            } else if (description[1].startsWith(CALORIE_TAG)) {
                String calorie = description[1].substring(2).trim();
                return new FindCalorieCommand(calorie);
            } else if (description[1].startsWith("a/")) {
                return new FindAllCommand(description[1]);
            } else if (description[1].startsWith("e/")) {
                return new FindEitherCommand(description[1]);
            } else {
                displayFindErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayFindErrorMessage();
        } catch (InvalidNumberOfArguments e) {
            displayShortageOfArguments();
        }
        return null;
    }
}
