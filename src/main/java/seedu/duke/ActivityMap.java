package seedu.duke;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.ArrayList;
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
        ActivityList aList = this.getDateTime(dateTime);

        if (aList == null) { //if the day specified does not contain an activity list yet, create one first
            activitiesMap.put(dateTime.toLocalDate(), new ActivityList());
        }
        aList = this.getDateTime(dateTime);
        aList.addActivity(activity);
    }

    //returns the activityList for the given dateTime
    public ActivityList getDateTime(LocalDateTime dateTime) {
        return activitiesMap.get(dateTime.toLocalDate());
    }

    //returns the number of activities for the given day
    public int getSizeOfActivityList(LocalDateTime dateTime) {
        ActivityList aList = this.getDateTime(dateTime);
        if (aList == null) {
            return 0;
        } else {
            return aList.getNumberOfActivity();
        }
    }

    public String toString(LocalDateTime dateTime) {
        ActivityList aList = this.getDateTime(dateTime);
        return dateTime.toLocalDate().toString() + " : " + aList.toString();
    }
}
