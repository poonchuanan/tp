package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityAddTest {
    @Test
    void addActivityFood_success() {
        Food food = new Food("Apple", 50);
        String output = food.toString();
        assertEquals(output, "[F] | Apple | 50");
    }

    @Test
    void addActivityExercise_success() {
        Exercise exercise = new Exercise("Running", 450);
        String output = exercise.toString();
        assertEquals(output, "[E] | Running | 450");
    }
}
