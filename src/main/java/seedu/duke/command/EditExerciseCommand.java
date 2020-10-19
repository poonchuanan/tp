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
     * @param isFromFile if data is from csv file.
     * @param date date of activity.
     */
    public EditExerciseCommand(int index, String description, int calories, boolean isFromFile, LocalDate date) {
        this.index = index;
        this.exercise = new Exercise(description, calories, isFromFile);
        this.date = date;
    }

    @Override
    public void execute() {
        dayMap.addNewActivity(index, date.atStartOfDay(), exercise);
    }
}
