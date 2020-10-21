package seedu.duke.command;

import seedu.duke.storage.UserSetStorage;

public class AddNewRepeatedSet extends Command {
    protected String trimmedInput;

    public AddNewRepeatedSet (String trimmedUserInput) {
        this.trimmedInput = trimmedUserInput;
    }

    @Override
    public void execute() {
        UserSetStorage.prepareNewSet(trimmedInput);
    }
}
