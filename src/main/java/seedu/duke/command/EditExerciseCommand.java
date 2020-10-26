package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.Exercise;

import java.time.LocalDate;

import static seedu.duke.Ui.displaySavedMessage;

/**
 * Edits exercise and its attributes at the indicated index.
 */
public class EditExerciseCommand extends Command {
    protected int index;
    protected Exercise exercise;
    protected LocalDate date;

    /**
     * Edits exercise and it's respective calories.
     *
     * @param description exercise description.
     * @param calories calories lost.
     */
    public EditExerciseCommand(int index, String description, int calories) {
        this.index = index;
        ActivityList lastSeenList = dayMap.getLastSeenList();
        LocalDate dateOfActivityToBeEdited = lastSeenList.getDateOfActivityAtIndex(index);
        this.exercise = new Exercise(description, calories,dateOfActivityToBeEdited, false);
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            dayMap.insertActivity(index, exercise);
            displaySavedMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!\n"
                    + "Please pull out the list for the day before editing on it!");
        }
    }
}
