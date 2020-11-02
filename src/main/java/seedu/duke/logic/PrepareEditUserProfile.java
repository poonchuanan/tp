package seedu.duke.logic;

import seedu.duke.command.Command;
import seedu.duke.command.EditUserProfileCommand;
import seedu.duke.userprofile.AskUserProfileQns;

import java.io.IOException;

public class PrepareEditUserProfile extends PrepareCommand {

    public PrepareEditUserProfile(String[] description) {
        super(description);
    }

    public Command prepareCommand() throws IOException {
        AskUserProfileQns.edit(description[1]);
        return new EditUserProfileCommand();
    }

}
