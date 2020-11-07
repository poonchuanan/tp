package seedu.duke.command;

import seedu.duke.Trakcal;
import seedu.duke.model.Activity;
import seedu.duke.model.DayMap;
import seedu.duke.ui.Ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import static seedu.duke.ui.ExceptionMessages.print;
import static seedu.duke.ui.Ui.displayMessage;
import static seedu.duke.ui.Ui.displaySavedMessage;

/**
 * Initialises Command to delete activities.
 */
public class DeleteCommand extends Command {
    protected LocalDateTime date;
    protected int index;
    protected DayMap dayList;


    /**
     * Deletes Command Constructor.
     *
     * @param index index of the activities
     */
    public DeleteCommand(int index) {
        this.date = LocalDateTime.now();
        this.index = index;
        this.canBeChained = true;
        this.dayList = Trakcal.calList;
    }

    /**
     * Deletes Command Constructor.
     */
    public DeleteCommand() {
        this.date = LocalDateTime.now();
        this.index = -1;
        this.canBeChained = true;
        this.dayList = Trakcal.calList;

    }

    /**
     * Executes the correct delete command.
     */
    @Override
    public void execute() {

        if ((index == -1) && (isDeleteConfirmed())) {
            dayList.getActivityList(this.date).clearList();
            dayList.getHashMap().remove(this.date.toLocalDate());
            displayMessage("All activities have been deleted");
        } else if (index >= 0) {
            try {
                dayMap.deleteActivity(index);
                displaySavedMessage();
            } catch (IndexOutOfBoundsException e) {
                displayMessage("Invalid Index");
            }
        }
    }

    /**
     * Gets input from the user to confirm the delete command.
     *
     * @return true if the user says yes
     */
    public boolean isDeleteConfirmed() {
        System.out.println("Are you sure you want to delete all activities in today's list? [yes/no]");
        try {
            String userInput = Trakcal.in.nextLine().trim().toLowerCase();
            if (userInput.equals("yes")) {
                return true;
            } else if (userInput.equals("no")) {
                print("Delete command aborted.");
            } else {
                print("Invalid input....aborting delete command.");
            }
        } catch (NoSuchElementException e) {
            print("Invalid input....aborting delete command.");
        }
        return false;

    }
}
