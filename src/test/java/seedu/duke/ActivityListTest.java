package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ActivityListTest {
    protected ActivityList dummyList = new ActivityList();

    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50, false));
        dummyList.addActivity(new Food("Banana", 100, false));
        dummyList.addActivity(new Food("Orange", 25, false));
    }

    @Test
    void removeActivity_validIndex_success() {
        createObjects(dummyList);
        dummyList.removeActivity(1);
        assertEquals("[F] | Apple | 50, [F] | Orange | 25", dummyList.toString());
    }

    @Test
    void clearList_success() {
        createObjects(dummyList);
        dummyList.clearList();
        assertEquals(0, dummyList.getNumberOfActivities());
    }
}