package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityAddTest {
    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50, false));
        dummyList.addActivity(new Food("Banana", 100, false));
        dummyList.addActivity(new Food("Apple pie", 55, false));
        dummyList.addActivity(new Exercise("Juggle Apples", 100, false));
    }


    @Test
    void addActivityFood_success() {
        Food food = new Food("Apple", 50, false);
        String output = food.getString();
        assertEquals("[F] | Apple | 50", output);
    }

    /*
    @Test
    void addActivityFood2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        AddFoodCommand food = new AddFoodCommand("Apple", 50, false);
        food.execute();
    }*/

    @Test
    void addActivityExercise_success() {
        Exercise exercise = new Exercise("Running", 450, false);
        String output = exercise.getString();
        assertEquals("[E] | Running | 450", output);
    }

    /*
    @Test
    void addActivityExercise2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        AddExerciseCommand exercise = new AddExerciseCommand("Running", 450, false);
        exercise.execute();
    }*/
}
