package seedu.duke.command;

import seedu.duke.userprofile.SaveAndAskForUserProfile;

/**
 * Creates new user profile.
 */
public class CreateNewUserCommand extends Command {
    public CreateNewUserCommand() {
    }

    @Override
    public void execute() {
        SaveAndAskForUserProfile.createNewProfile();
    }
}
