package seedu.duke.command;

import seedu.duke.storage.UserSetStorage;

/**
 * Creates new shortcut command.
 */
public class CreateNewRepeatedSet extends Command {
    protected String trimmedInput;

    /**
     * Creates new repeated set.
     *
     * @param trimmedUserInput user input
     */
    public CreateNewRepeatedSet(String trimmedUserInput) {
        this.canBeChained = true;
        this.trimmedInput = trimmedUserInput;
    }

    @Override
    public void execute() {
        UserSetStorage.prepareNewSet(trimmedInput);
    }
}
