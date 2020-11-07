package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.ListUserProfileCommand;
import seedu.duke.exception.InvalidNumberOfArguments;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InvalidClassException;

import static seedu.duke.ui.ExceptionMessages.displayExcessNumberOfArguments;

public class PrepareUserListCommand extends PrepareCommand {
    public PrepareUserListCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares user profile into a list and prints it out.
     *
     * @return ListUserProfileCommand
     */
    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(1);
            return new ListUserProfileCommand();
        } catch (InvalidNumberOfArguments e) {
            displayExcessNumberOfArguments();
        }
        return null;
    }

}
