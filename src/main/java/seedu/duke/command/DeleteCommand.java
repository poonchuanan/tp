package seedu.duke.command;

import seedu.duke.Activity;
import seedu.duke.ActivityList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Initialises Command to delete activities.
 */
public class DeleteCommand extends Command {
    protected LocalDate date;
    protected int index;

    /**
     * Delete Command constructor.
     *
     * @param date date of the activities.
     * @param index index of the activies.
     */
    public DeleteCommand(LocalDate date, int index) {
        this.date = date;
        this.index = index;
    }

    /**
     * Delete Command Constructor.
     * @param index index of the activities.
     */
    public DeleteCommand(int index) {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = index;
    }

    /**
     * Delete Command Constructor.
     */
    public DeleteCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.index = -1;
    }

    /**
     * Executes the correct delete command.
     */
    @Override
    public void execute() {

        if (index == -1) {
            dayMap.getLastSeenList().clearList();
            return;
        }


        HashMap dayHashMap = dayMap.getHashMap();
        ActivityList lastSeenList = dayMap.getLastSeenList();
        try {
            Activity activityToMatch = lastSeenList.getActivity(index);
            //if previous command was the list command then this will straight away delete the activity
            // from the list in the daymap
            lastSeenList.removeActivity(index);

            //if all the activities in a date is deleted, this is the key to be removed from the daymap
            LocalDate keyToDelete = null;

            //iterating through the entire daymap to find the activity to delete
            Iterator it = dayHashMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                ActivityList activities = (ActivityList) pair.getValue();
                int activityCounter = activities.getNumberOfActivities();

                if (activityCounter > 0) {
                    for (int i = 0; i < activityCounter; i++) {
                        if (activityToMatch.equals(activities.getActivity(i))) {
                            activities.removeActivity(i);
                            //if deleted the last item in the ActivityList then obtain the key to be deleted from daymap
                            if (activities.getNumberOfActivities() == 0) {
                                keyToDelete = (LocalDate) pair.getKey();
                            }
                            break;
                        }
                    }
                    //If encountered a activitylist with a count of 0,
                    // which will be resulted if deleted the last item of ActivityList from a list command
                } else if (activityCounter == 0) {
                    keyToDelete = (LocalDate) pair.getKey();
                }
            }
            //removes key from the daymap
            dayHashMap.remove(keyToDelete);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
        }
    }
}
