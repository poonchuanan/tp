package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActivityEditTest {
    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50, false));
        dummyList.addActivity(new Food("Banana", 100, false));
        dummyList.addActivity(new Food("Apple pie", 55, false));
        dummyList.addActivity(new Exercise("Juggle Apples", 100, false));
    }
//
//    @Test
//    void editActivityFoodToExercise_success() {
//        ActivityList dummyList = new ActivityList();
//        createObjects(dummyList);
//
//        String userInput = "edita 1 e/ jumping c/ 100";
//        new DeleteCommand(0);
//        Parser command = new Parser(userInput);
//        //String output = command.prepareEditActivityCommand(userInput);
//        assertEquals("expected", "actual");
//    }

//    @Test
//    void editActivityExerciseToFood_success() {
//        ActivityList dummyList = new ActivityList();
//        createObjects(dummyList);
//
//        Food food = new Food("Apple", 50, false);
//        String output = food.toString();
//        assertEquals(output, "[F] | Apple | 50");
//    }
//
//    @Test
//    void editActivityExerciseToExercise_success() {
//        ActivityList dummyList = new ActivityList();
//        createObjects(dummyList);
//
//        Food food = new Food("Apple", 50, false);
//        String output = food.toString();
//        assertEquals(output, "[F] | Apple | 50");
//    }
//
//    @Test
//    void editActivityFoodToFood_success() {
//        ActivityList dummyList = new ActivityList();
//        createObjects(dummyList);
//
//        Food food = new Food("Apple", 50, false);
//        String output = food.toString();
//        assertEquals(output, "[F] | Apple | 50");
//    }
}
