package seedu.duke.command;

import java.time.LocalDateTime;

import static seedu.duke.ui.Ui.displayMessage;

public class DeleteAllCommand extends Command {
    protected LocalDateTime date;

    public DeleteAllCommand() {
        this.date = LocalDateTime.now();
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        dayMap.getActivityList(this.date).clearList();
        dayMap.getHashMap().remove(this.date.toLocalDate());
        displayMessage("All activities have been deleted");
    }
}
