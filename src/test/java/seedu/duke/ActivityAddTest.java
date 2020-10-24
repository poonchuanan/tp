package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityAddTest {
    @Test
    void addActivityFood_success() {
        Food food = new Food("Apple", 50, false);
        String output = food.toString();
        assertEquals("[F] | Apple | 50", output);
    }

    @Test
    void addActivityExercise_success() {
        Exercise exercise = new Exercise("Running", 450, false);
        String output = exercise.toString();
        assertEquals("[E] | Running | 450", output);
    }
}
