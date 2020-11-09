package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.EditUserProfileCommand;
import seedu.duke.exception.InvalidNumberOfArguments;


import java.io.IOException;

import static seedu.duke.ui.ExceptionMessages.displayShortageOfArguments;

/**
 * Prepares editing of user profile.
 */
public class PrepareEditUserProfile extends PrepareCommand {

    public PrepareEditUserProfile(String[] description) {
        super(description);
    }

    /**
     * Prepares to edit user profile.
     *
     * @return EditUserProfileCommand
     * @throws IOException when there is an error
     */
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(2);
            return new EditUserProfileCommand(description[1]);
        } catch (InvalidNumberOfArguments e) {
            displayShortageOfArguments();
        }
        return null;
    }

}
