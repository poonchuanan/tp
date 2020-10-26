package seedu.duke.command;

import seedu.duke.model.Exercise;

import java.time.LocalDate;

import static seedu.duke.ui.Ui.displaySavedMessage;

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
     * @param description exercise description.
     * @param calories calories lost.
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
            displaySavedMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!\n"
                    + "Please pull out the list for the day before editing on it!");
        }
    }
}
