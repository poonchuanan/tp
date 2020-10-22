package seedu.duke.command;

import seedu.duke.Exercise;
import seedu.duke.Food;

import java.time.LocalDate;

/**
 * Edit exercise.
 */
public class EditExerciseCommand extends Command {
    protected int index;
    protected Exercise exercise;
    protected LocalDate date;

    /**
     * Add exercise and it's respective calories.
     *
     * @param description exercise description.
     * @param calories calories lost.
     */
    public EditExerciseCommand(int index, String description, int calories) {
        this.index = index;
        this.exercise = new Exercise(description, calories, false);
        this.canBeChained = true;

    }

    @Override
    public void execute() {

        try {
            dayMap.insertActivity(index, exercise);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!");
        }

    }
}
