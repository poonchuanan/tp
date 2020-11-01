package seedu.duke.command;

import seedu.duke.Trakcal;
import seedu.duke.userprofile.AskUserProfileQns;
import seedu.duke.userprofile.InitialiseUserProfile;

import static seedu.duke.ui.Ui.displayHelpMessage;

public class ListUserProfileCommand extends Command {

    @Override
    public void execute() {
        Trakcal.profile.printList();
    }
}
