package seedu.duke;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Use hashmap of to store all the data.
 * The key of the hashmap would be the date and the value would be the activityList for that day.
 */
public class DayMap {

    private HashMap<LocalDate, ActivityList> dayMap;

    public DayMap() {
        this.dayMap = new HashMap<>();
    }

    /**
     * Adds activity into activityList under the corresponding dateTime, creates a new activityList if there are none
     * under the specified date
     * @param dateTime
     * @param activityDescription
     * @param calories
     * @param activityType
     */
    public void addActivity(LocalDateTime dateTime, String activityDescription, int calories, String activityType) {
        ActivityList alist = this.getActivityList(dateTime);

        //if the day specified does not contain an activity list yet, create one first
        if (alist == null) {
            dayMap.put(dateTime.toLocalDate(), new ActivityList());
        }
        alist = this.getActivityList(dateTime);

        if(activityType.equals("food")) {
            alist.addFood(activityDescription, calories);
        }
        else if (activityType.equals("exercise")) {
            alist.addExercise(activityDescription, calories);
        }
    }

    public ArrayList getArrayList(LocalDateTime dateTime) {
        return getActivityList(dateTime).getArrayList();
    }

    //returns the activityList for the given dateTime
    public ActivityList getActivityList(LocalDateTime dateTime) {
        return dayMap.get(dateTime.toLocalDate());
    }

    //returns the number of activities for the given day
    public int getSizeOfActivityList(LocalDateTime dateTime) {
        ActivityList alist = this.getActivityList(dateTime);
        if (alist == null) {
            return 0;
        } else {
            return alist.getNumberOfActivities();
        }
    }

    public String toString(LocalDateTime dateTime) {
        ActivityList alist = this.getActivityList(dateTime);
        return dateTime.toLocalDate().toString() + " : " + alist.toString();
    }

}
