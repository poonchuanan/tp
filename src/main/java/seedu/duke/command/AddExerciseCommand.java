package seedu.duke.command;

import seedu.duke.Exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddExerciseCommand extends Command {
    protected Exercise exercise;
    protected LocalDate date;

    public AddExerciseCommand(String description, int calories) {
        this.exercise = new Exercise(description, calories);
        this.date = LocalDateTime.now().toLocalDate();
    }

    public AddExerciseCommand(String description, int calories, LocalDate date) {
        this.exercise = new Exercise(description, calories);
        this.date = date;
    }

    @Override
    public void execute() {
        dayMap.addActivity(date.atStartOfDay(), exercise);
    }


}
