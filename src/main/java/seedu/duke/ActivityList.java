package seedu.duke;

import java.util.ArrayList;
import java.util.Arrays;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;


/**
 * List of activities for any day.
 */
public class ActivityList extends Duke {
    private ArrayList<Activity> activities;
    private int activityCounter;
    private int netCalorie;

    public ActivityList() {
        activities = new ArrayList<>();
        activityCounter = 0;
        netCalorie = 0;
    }

    /**
     * Returns the current number of activities in the list.
     *
     * @return current number of activities in the list
     */
    public int getNumberOfActivities() {
        return activities.size();
    }

    public ArrayList getArrayList() {
        return activities;
    }


    public void addActivity(Activity activity) {
        //Activity item = new Activity(userInput, calories);
        activities.add(activity);
        System.out.println(activities.get(activityCounter++).toString());
        if (activity instanceof Food) {
            netCalorie += activity.calories;
        } else if (activity instanceof Exercise) {
            netCalorie -= activity.calories;
        }
    }

    public int getNetCalorie() {
        return netCalorie;
    }

    public Activity getActivity(int index) {
        return activities.get(index);
    }

    /**
     * Removes an activity from the list via index.
     *
     * @param index index of acitivty in list
     */
    public void removeActivity(int index) {
        if (isValidIndex(index)) {
            Activity activityToRemove = activities.get(index);
            if (activityToRemove instanceof Food) {
                netCalorie -= activityToRemove.calories;
            } else if (activityToRemove instanceof Exercise) {
                netCalorie += activityToRemove.calories;
            }
            activities.remove(index);
            activityCounter--;
            System.out.print("Activity removed!\n");
        } else {
            System.out.println("Please make sure index is within range");
        }
    }

    /**
     * Prints the list of activities.
     */
    public void printList() {
        if (activityCounter == 0) {
            displayEmptyActivityCounterMessage();
        } else {
            for (int i = 0; i < activityCounter; i++) {
                System.out.println((i + 1) + ". " + getActivity(i).toString());
            }
        }
    }

    /**
     * Checks if the index is valid.
     *
     * @param index index of acitvity in list
     * @return true if index is within range, else false
     */
    public boolean isValidIndex(int index) {
        if ((index >= 0) && (index < activityCounter)) {
            return true;
        }
        return false;
    }

    /**
     * Clears the list of activites.
     */
    public void clearList() {
        activities.clear();
        activityCounter = 0;
        netCalorie = 0;
    }

    /**
     * Sets the activities as a string.
     * For e.g, [F] | apple | 50, [F] | banana | 100, [E] | pushup | 10, [E] | jogging | 60
     * @return activities as a string
     */
    @Override
    public String toString() {
        String activitiesString = Arrays.toString(activities.toArray());
        activitiesString = activitiesString.substring(1, activitiesString.length() - 1);
        return (activitiesString);
    }
}
