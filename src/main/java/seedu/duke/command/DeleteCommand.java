package seedu.duke.command;

import seedu.duke.Activity;
import seedu.duke.ActivityList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Initialises Command to delete activities.
 */
public class DeleteCommand extends Command {
    protected LocalDate date;
    protected int index;


    /**
     * Delete Command Constructor.
     * @param index index of the activities.
     */
    public DeleteCommand(int index) {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = index;
        this.canBeChained = true;

    }

    /**
     * Delete Command Constructor.
     */
    public DeleteCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = -1;
        this.canBeChained = true;

    }

    /**
     * Executes the correct delete command.
     */
    @Override
    public void execute() {

        if (index == -1) {
            dayMap.getLastSeenList().clearList();
            dayMap.getHashMap().remove(this.date);
            return;
        } else {
            try {
                dayMap.deleteActivity(index);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid index!");
            }
        }

    }
}
