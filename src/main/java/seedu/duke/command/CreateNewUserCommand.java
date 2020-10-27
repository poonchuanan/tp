package seedu.duke.command;

import seedu.duke.userprofile.Initialiseuser;

/**
 * Creates new user profile.
 */
public class CreateNewUserCommand extends Command {
    public CreateNewUserCommand() {
    }

    @Override
    public void execute() {
        Initialiseuser.createNewProfile();
    }
}
