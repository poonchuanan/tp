package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * List of activities for any day.
 */
public class ActivityList extends Duke {
    public static final int INITIALISE = 0;
    private ArrayList<Activity> activities;
    private int activityCounter;

    public ActivityList() {
        activities = new ArrayList<>();
        activityCounter = INITIALISE;
    }

    /**
     *
     * @return current number of activities in the list
     */
    public int getNumberOfActivity() {
        return activityCounter;
    }

    /**
     *
     * @param userInput Food description.
     * @param calories Amount of calories.
     */
    public void addFood(String userInput, int calories) {
        Activity item = new Food(userInput, calories);
        activities.add(item);
        System.out.println("\t" + activities.get(activityCounter++).toString());
    }

    /**
     *
     * @param userInput Exercise description.
     * @param calories Amount of calories.
     */
    public void addExercise(String userInput, int calories) {
        Activity item = new Exercise(userInput, calories);
        activities.add(item);
        System.out.println("\t" + activities.get(activityCounter++).toString());
    }

    @Override
    public String toString() {
        return (Arrays.toString(activities.toArray()));
    }
}
