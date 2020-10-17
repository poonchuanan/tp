package seedu.duke;

import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;


/**
 * Use hashmap of to store all the data.
 * The key of the hashmap would be the date and the value would be the activityList for that day.
 */
public class DayMap {

    private HashMap<LocalDate, ActivityList> dayMap;
    private ActivityList lastSeenList;

    public DayMap() {
        this.dayMap = new HashMap<>();
    }

    public void setLastSeenList (ActivityList activityList) {
        this.lastSeenList = activityList;
    }

    public ActivityList getLastSeenList() {
        return this.lastSeenList;
    }

    /**
     * Adds activity into activityList under the corresponding dateTime.
     * Creates a new activityList if there are none under the specified date.
     * @param dateTime Specified date to extract activitylist from the dayMap.
     * @param activity Description of the activity, the userinput
     */
    public void addActivity(LocalDateTime dateTime, Activity activity) {
        ActivityList alist = this.getActivityList(dateTime);
        if (alist == null) {
            dayMap.put(dateTime.toLocalDate(), new ActivityList());
            alist = this.getActivityList(dateTime);
        }
        alist.addActivity(activity);
        //System.out.println("Total calorie count for "
        // + dateTime.toLocalDate().toString() + " = " + alist.getNetCalorie());
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

    public int getNetCalorieOfDay(LocalDate date) {
        ActivityList alist = getActivityList(date.atStartOfDay());
        return alist.getNetCalorie();
    }

    public HashMap<LocalDate, ActivityList> getHashMap() {
        return dayMap;
    }

    /**
     * Prints the activities for the given date.
     * @param date specified date to print the list
     */
    public void printActivityList(LocalDate date) {
        if (!dayMap.containsKey(date)) {
            displayEmptyActivityCounterMessage();
        } else {
            getActivityList(date.atStartOfDay()).printList();
        }
    }

    /**
     * Sets the activities at a given date as a string.
     * For e.g, 2020-10-11: [F] | apple | 50, [F] | banana | 100, [E] | pushup | 10, [E] | jogging | 60.
     * @param dateTime is the specified date
     * @return activities as a string for the given date
     */
    public String toString(LocalDateTime dateTime) {
        ActivityList alist = this.getActivityList(dateTime);
        return dateTime.toLocalDate().toString() + ": " + alist.toString();
    }
}
