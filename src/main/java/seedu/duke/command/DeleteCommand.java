package seedu.duke.command;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Initialises Command to delete activities.
 */
public class DeleteCommand extends Command {
    protected LocalDate date;
    protected int index;

    /**
     * Delete Command constructor.
     *
     * @param date date of the activities.
     * @param index index of the activies.
     */
    public DeleteCommand(LocalDate date, int index) {
        this.date = date;
        this.index = index;
    }

    /**
     * Delete Command Constructor.
     * @param index index of the activities.
     */
    public DeleteCommand(int index) {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = index;
    }

    /**
     * Delete Command Constructor.
     */
    public DeleteCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = -1;
    }

    /**
     * Executes the correct delete command.
     */
    @Override
    public void execute() {

        if (index != -1) {
            dayMap.getLastSeenList().removeActivity(index);
        } else {
            dayMap.getLastSeenList().clearList();
        }
    }
}
