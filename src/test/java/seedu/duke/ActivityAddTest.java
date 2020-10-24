package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityAddTest {
    @Test
    void addActivityFood_success() {
        Food food = new Food("Apple", 50, false);
        String output = food.getString();
        assertEquals("[F] | Apple | 50", output);
    }

    @Test
    void addActivityFood2_success() {
        AddFoodCommand food = new AddFoodCommand("Apple", 50, false);
    }

    @Test
    void addActivityExercise_success() {
        Exercise exercise = new Exercise("Running", 450, false);
        String output = exercise.getString();
        assertEquals("[E] | Running | 450", output);
    }

    @Test
    void addActivityExercise2_success() {
        AddExerciseCommand exercise = new AddExerciseCommand("Running", 450, false);
    }
}
