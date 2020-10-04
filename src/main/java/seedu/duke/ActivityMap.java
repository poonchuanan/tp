package seedu.duke;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Use hashmap of to store all the data.
 * The key of the hashmap would be the date and the value would be the activityList for that day.
 */
public class ActivityMap {

    private HashMap<LocalDate, ActivityList> activitiesMap;

    public ActivityMap() {
        this.activitiesMap = new HashMap<>();
    }

    //extracts activity list from map and adds the activity to it
    //Integer to be replaced with activity class added this just to test this implementation
    public void addActivity(LocalDateTime dateTime, Integer activity) {
        ActivityList alist = this.getValue(dateTime);

        if (alist == null) { //if the day specified does not contain an activity list yet, create one first
            activitiesMap.put(dateTime.toLocalDate(), new ActivityList());
        }
        alist = this.getValue(dateTime);
        alist.addActivity(activity);
    }

    //returns the activityList for the given dateTime
    public ActivityList getValue(LocalDateTime dateTime) {
        return activitiesMap.get(dateTime.toLocalDate());
    }

    //retruns the number of activities for the given day
    public int getSizeOfActivityList(LocalDateTime dateTime) {
        ActivityList alist = this.getValue(dateTime);
        if (alist == null) {
            return 0;
        } else {
            return alist.getNumberOfActivity();
        }
    }

    public String toString(LocalDateTime dateTime) {
        ActivityList alist = this.getValue(dateTime);
        return dateTime.toLocalDate().toString() + " : " + alist.toString();
    }
}
