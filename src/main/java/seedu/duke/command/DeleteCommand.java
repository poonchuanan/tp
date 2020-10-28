package seedu.duke.command;

import seedu.duke.model.Activity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.ui.Ui.displaySavedMessage;

/**
 * Initialises Command to delete activities.
 */
public class DeleteCommand extends Command {
    protected LocalDate date;
    protected int index;


    /**
     * Deletes Command Constructor.
     *
     * @param index index of the activities
     */
    public DeleteCommand(int index) {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = index;
        this.canBeChained = true;

    }

    /**
     * Deletes Command Constructor.
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
        displaySavedMessage();
    }
}
