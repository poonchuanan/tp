package seedu.duke.command;

import seedu.duke.Exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Add exercise.
 */
public class AddExerciseCommand extends Command {
    protected Exercise exercise;
    protected LocalDate date;

    /**
     * Adds exercise and it's respective calories.
     *
     * @param description exercise description
     * @param calories calories burnt
     */
    public AddExerciseCommand(String description, int calories, boolean isFromFile) {
        this.exercise = new Exercise(description, calories, isFromFile);
        this.date = LocalDateTime.now().toLocalDate();
    }

    /**
     * Add exercise and it's respective calories.
     *
     * @param description exercise description.
     * @param calories calories lost.
     * @param isFromFile if data is from csv file.
     * @param date date of activity.
     */
    public AddExerciseCommand(String description, int calories, boolean isFromFile, LocalDate date) {
        this.exercise = new Exercise(description, calories, isFromFile);
        this.date = date;
    }

    @Override
    public void execute() {
        dayMap.addActivity(date.atStartOfDay(), exercise);
    }


}
