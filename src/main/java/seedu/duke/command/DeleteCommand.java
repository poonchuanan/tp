package seedu.duke.command;

import seedu.duke.Activity;
import seedu.duke.ActivityList;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DeleteCommand extends Command {
    protected LocalDate date;
    protected int index;

    public DeleteCommand(LocalDate date, int index) {
        this.date = date;
        this.index = index;
    }

    public DeleteCommand(int index) {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = index;
    }

    public DeleteCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = -1;
    }

    @Override
    public void execute() {
        ActivityList activities = dayMap.getActivityList(date.atStartOfDay());
        if (index != -1) {
            activities.removeActivity(index);
        } else {
            activities.clearList();
        }
    }
}
