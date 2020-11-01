package seedu.duke.command;

import seedu.duke.model.Exercise;

import java.time.LocalDate;

import static seedu.duke.ui.ExceptionMessages.displayEditIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ui.Ui.displaySavedMessage;
import static seedu.duke.ui.Ui.drawDivider;

/**
 * Edits exercise and its attributes at the indicated index.
 */
public class EditExerciseCommand extends Command {
    protected int index;
    protected Exercise exercise;
    protected String description;
    protected int calories;
    protected LocalDate date;

    /**
     * Edits exercise and it's respective calories.
     *
     * @param description exercise description
     * @param calories calories lost
     */
    public EditExerciseCommand(int index, String description, int calories) {
        this.index = index;
        this.description = description;
        this.calories = calories;
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            LocalDate dateOfActivityToBeEdited = dayMap.getDateFromLastSeenListAtIndex(index);
            this.exercise = new Exercise(description, calories,dateOfActivityToBeEdited, false);
            dayMap.insertActivity(index, exercise);
            System.out.println();
            displaySavedMessage();
        } catch (IndexOutOfBoundsException e) {
            displayEditIndexOutOfBoundsExceptionMessage();
        }
    }
}
