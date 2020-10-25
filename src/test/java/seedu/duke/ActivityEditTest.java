package seedu.duke;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityEditTest {
    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50, false));
        dummyList.addActivity(new Food("Banana", 100, false));
        dummyList.addActivity(new Food("Apple pie", 55, false));
        dummyList.addActivity(new Exercise("Juggle Apples", 100, false));
    }

    LocalDate date = LocalDate.of(2020, Month.OCTOBER, 9);
    LocalDate date2 = LocalDate.of(2020, Month.NOVEMBER, 10);
    LocalDate date3 = LocalDate.of(2020, Month.DECEMBER, 11);


    void createObjects2(DayMap dummyMap) {
        dummyMap.addActivity(date.atStartOfDay(), new Food("rice with eggs", 50, false));
        dummyMap.addActivity(date.atStartOfDay(), new Exercise("run 2km", 100, false));

        dummyMap.addActivity(date2.atStartOfDay(), new Exercise("run 10km", 51, false));
        dummyMap.addActivity(date2.atStartOfDay(), new Food("rice with tofu", 101, false));

        dummyMap.addActivity(date3.atStartOfDay(), new Food("rice with shit", 51, false));
        dummyMap.addActivity(date3.atStartOfDay(), new Food("rice with pork", 101, false));
    }

    @Test
    void editActivityFoodToExercise_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Exercise("jumping", 900, false);
        dummyList.insertActivity(0, activity);

        assertEquals("[E] | jumping | 900, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[E] | Juggle Apples | 100", dummyList.toString());
    }

    @Test
    void editActivityFoodToExercise2_success() throws NullPointerException {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        DayMap dummyMap = new DayMap();
        createObjects2(dummyMap);

        EditExerciseCommand exercise = new EditExerciseCommand(0, "jumping", 900);

        Assertions.assertThrows(NullPointerException.class, () -> {
            exercise.execute();
        });
    }

    @Test
    void editActivityExerciseToFood_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Food("Pineapple", 77, false);
        dummyList.insertActivity(3, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[F] | Pineapple | 77", dummyList.toString());
    }

    @Test
    void editActivityExerciseToFood2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        DayMap dummyMap = new DayMap();
        createObjects2(dummyMap);

        EditFoodCommand food = new EditFoodCommand(3, "Pineapple", 77);

        Assertions.assertThrows(NullPointerException.class, () -> {
            food.execute();
        });
    }

    @Test
    void editActivityExerciseToExercise_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Exercise("jumping", 900, false);
        dummyList.insertActivity(3, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Apple pie | 55, "
                + "[E] | jumping | 900", dummyList.toString());
    }

    @Test
    void editActivityExerciseToExercise2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        DayMap dummyMap = new DayMap();
        createObjects2(dummyMap);

        EditExerciseCommand exercise = new EditExerciseCommand(3, "jumping", 900);

        Assertions.assertThrows(NullPointerException.class, () -> {
            exercise.execute();
        });
    }

    @Test
    void editActivityFoodToFood_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        Activity activity = new Food("Pineapple", 77, false);
        dummyList.insertActivity(2, activity);

        assertEquals("[F] | Apple | 50, [F] | Banana | 100, [F] | Pineapple | 77, "
                + "[E] | Juggle Apples | 100", dummyList.toString());
    }

    @Test
    void editActivityFoodToFood2_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);

        DayMap dummyMap = new DayMap();
        createObjects2(dummyMap);

        EditFoodCommand food = new EditFoodCommand(2, "jumping", 900);

        Assertions.assertThrows(NullPointerException.class, () -> {
            food.execute();
        });
    }
}
