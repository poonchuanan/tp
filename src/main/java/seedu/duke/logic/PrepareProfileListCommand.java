package seedu.duke.logic;

import seedu.duke.command.Command;
import seedu.duke.command.ListUserProfileCommand;

public class PrepareProfileListCommand extends PrepareCommand {
    public PrepareProfileListCommand(String[] description){
        super(description);
    }


    @Override
    public Command prepareCommand() {
        return new ListUserProfileCommand();
    }

}
