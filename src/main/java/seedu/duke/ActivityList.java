package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * List of activities for any day.
 */
public class ActivityList {
    //Integer to be replaced with the Activity class
    private ArrayList<Integer> activities;
    private int activityCounter;

    public ActivityList() {
        activities = new ArrayList<>();
        activityCounter = 0;
    }

    public int getNumberOfActivity() {
        return activityCounter;
    }

    //Integer to be replaced with activity class added this just to test this implementation
    public void addActivity(Integer activity) {
        activities.add(activity);
        activityCounter++;
    }

    @Override
    public String toString() {
        return (Arrays.toString(activities.toArray()));
    }
}
