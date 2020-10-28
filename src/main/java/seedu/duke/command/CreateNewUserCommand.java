package seedu.duke.command;

import seedu.duke.userprofile.Initialiseuser;

public class CreateNewUserCommand extends Command {

    public CreateNewUserCommand() {
    }

    @Override
    public void execute() {
        Initialiseuser.createNewProfile();
    }
}
