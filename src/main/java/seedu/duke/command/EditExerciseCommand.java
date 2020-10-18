package seedu.duke.command;

import seedu.duke.Exercise;
import seedu.duke.Food;

import java.time.LocalDate;

public class EditExerciseCommand extends Command {
    protected int index;
    protected Exercise exercise;
    protected LocalDate date;

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
