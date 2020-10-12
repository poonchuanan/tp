package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActivityFindTest {
    void createObjects(ActivityList dummyList) {
        dummyList.addActivity(new Food("Apple", 50));
        dummyList.addActivity(new Food("Banana", 100));
        dummyList.addActivity(new Food("Apple pie", 55));
        dummyList.addActivity(new Exercise("Juggle Apples", 100));
    }
    @Test
    void findActivityDescription_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);
        String output = "";
        for (int i = 0; i < dummyList.getNumberOfActivities(); i++) {
            String currentLine = dummyList.getActivity(i).toString();
            String descriptionToCheck = currentLine.substring(currentLine.indexOf("|") + 1);
            descriptionToCheck = descriptionToCheck.substring(0, descriptionToCheck.indexOf("|"));
            if (descriptionToCheck.contains("Apple")) {
                output += currentLine + " ";
            }
        }
        assertEquals("[F] | Apple | 50 [F] | Apple pie | 55 [E] | Juggle Apples | 100 ", output);
    }

    @Test
    void findActivityCalorie_success() {
        ActivityList dummyList = new ActivityList();
        createObjects(dummyList);
        String output = "";
        for (int i = 0; i < dummyList.getNumberOfActivities(); i++) {
            String currentLine = dummyList.getActivity(i).toString();
            int calorieStartIndex = currentLine.lastIndexOf(' ');
            String calorieToCheck = currentLine.substring(calorieStartIndex).trim();
            if (calorieToCheck.equals("100")) {
                output += currentLine + " ";
            }
        }
        assertEquals("[F] | Banana | 100 [E] | Juggle Apples | 100 ", output);

    }
}
