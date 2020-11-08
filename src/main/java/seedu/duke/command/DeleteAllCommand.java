package seedu.duke.command;

import java.time.LocalDateTime;

import static seedu.duke.ui.Ui.displayMessage;

/**
 * Delete All Command.
 */
public class DeleteAllCommand extends Command {
    protected LocalDateTime date;

    /**
     * Initializes delete all command.
     */
    public DeleteAllCommand() {
        this.date = LocalDateTime.now();
    }

    @Override
    public void execute() {
        dayMap.getActivityList(this.date).clearList();
        dayMap.getHashMap().remove(this.date.toLocalDate());
        displayMessage("All activities have been deleted");
    }
}
