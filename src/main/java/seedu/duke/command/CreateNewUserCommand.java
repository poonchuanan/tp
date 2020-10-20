package seedu.duke.command;

import seedu.duke.userprofile.Initialiseuser;

public class CreateNewUserCommand extends Command {


    @Override
    public void execute() {
        Initialiseuser.createNewProfile();
    }
}
