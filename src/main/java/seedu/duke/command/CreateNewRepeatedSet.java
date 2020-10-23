package seedu.duke.command;

import seedu.duke.storage.UserSetStorage;

public class CreateNewRepeatedSet extends Command {
    protected String trimmedInput;

    public CreateNewRepeatedSet(String trimmedUserInput) {
        this.canBeChained = true;
        this.trimmedInput = trimmedUserInput;
    }

    @Override
    public void execute() {
        UserSetStorage.prepareNewSet(trimmedInput);
    }
}
