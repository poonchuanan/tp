package seedu.duke.command;

import seedu.duke.Trakcal;
import seedu.duke.model.Activity;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.ui.Ui.displayMessage;
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

        if ((index == -1) && (isDeleteConfirmed())) {
            dayMap.getLastSeenList().clearList();
            dayMap.getHashMap().remove(this.date);
            displayMessage("All activities have been deleted");
            displaySavedMessage();
        } else if (index >= 0){
            try {
                dayMap.deleteActivity(index);
                displaySavedMessage();
            } catch (IndexOutOfBoundsException e) {
                displayMessage("Invalid Index");
            }
        }
    }


    public boolean isDeleteConfirmed() {
        System.out.println("Are you sure you want to delete all activities in today's list? [yes/no]");
        String userInput = Trakcal.in.nextLine().trim().toLowerCase();
        if (userInput.equals("yes")) {
            return true;
        } else if (userInput.equals("no")) {
            System.out.println("Delete command aborted.");
            return false;
        } else {
            System.out.println("Invalid input....aborting delete command.");
            return false;
        }

    }
}
