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
     * Returns the current number of activities in the list.
     *
     * @return current number of activities in the list
     */
    public int getNumberOfActivities() {
        return activityCounter;
    }

    public ArrayList getArrayList() {
        return activities;
    }

    /**
     * Adds food with its respective calories to activity list.
     *
     * @param userInput Food description.
     * @param calories  Amount of calories.
     */
    public void addFood(String userInput, int calories) {
        Activity item = new Food(userInput, calories);
        activities.add(item);
        System.out.println("\t" + activities.get(activityCounter++).toString());
        //return activityCounter;
    }

    /**
     * Adds exercise with its respective calories to activity list.
     *
     * @param userInput Exercise description.
     * @param calories  Amount of calories.
     */
    public void addExercise(String userInput, int calories) {
        Activity item = new Exercise(userInput, calories);
        activities.add(item);
        System.out.println("\t" + activities.get(activityCounter++).toString());
        //return activityCounter;
    }

    public Activity getActivity(int index) {
        return activities.get(index);
    }

    @Override
    public String toString() {
        return (Arrays.toString(activities.toArray()));
    }
}
