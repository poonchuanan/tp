package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class ActivityListTest {

    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50));
        dummyList.addActivity(new Food("Banana", 100));
        dummyList.addActivity(new Food("Orange", 25));
    }

    @Test
    void removeActivity_validIndex_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);
        dummyList.removeActivity(1);
        assertEquals("[[F] | Apple | 50, [F] | Orange | 25]", dummyList.toString());
    }
}