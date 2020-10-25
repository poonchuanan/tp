package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivityEditTest {
    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50, false));
        dummyList.addActivity(new Food("Banana", 100, false));
        dummyList.addActivity(new Food("Apple pie", 55, false));
        dummyList.addActivity(new Exercise("Juggle Apples", 100, false));
    }

    @Test
    void editActivityFoodToExercise_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Exercise("jumping",900, false);
        dummyList.insertActivity(0, activity);

        assertEquals("[E] | jumping | 900, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[E] | Juggle Apples | 100", dummyList.toString());
    }

    @Test
    void editActivityFoodToExercise2_success() throws NullPointerException {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);
        try {
            EditFoodCommand food = new EditFoodCommand(0, "jumping", 900);
            food.execute();
        } catch (NullPointerException e) {
            System.out.println("null!");
        }
    }

    @Test
    void editActivityExerciseToFood_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Food("Pineapple",77, false);
        dummyList.insertActivity(3, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[F] | Pineapple | 77", dummyList.toString());
    }

    @Test
    void editActivityExerciseToFood2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        try {
            EditExerciseCommand exercise = new EditExerciseCommand(3, "Pineapple", 77);
            exercise.execute();
        } catch (NullPointerException e) {
            System.out.println("null!");
        }
    }

    @Test
    void editActivityExerciseToExercise_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Exercise("jumping",900, false);
        dummyList.insertActivity(3, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[E] | jumping | 900", dummyList.toString());
    }

    /*
    @Test
    void editActivityExerciseToExercise2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        EditExerciseCommand exercise = new EditExerciseCommand(3, "jumping", 900);
        exercise.execute();
    }*/

    @Test
    void editActivityFoodToFood_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Food("Pineapple",77, false);
        dummyList.insertActivity(2, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Pineapple | 77, "
                + "[E] | Juggle Apples | 100", dummyList.toString());
    }

    /*
    @Test
    void editActivityFoodToFood2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        EditFoodCommand food = new EditFoodCommand(2, "jumping", 900);
        food.execute();
    }*/
}
