package seedu.duke.command;

import seedu.duke.ActivityList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListCommand extends Command {

    protected LocalDate date;

    public ListCommand(LocalDate date) {
        this.date = date;
    }

    public ListCommand() {
        this.date = LocalDateTime.now().toLocalDate();
    }

    /**
     * Prints the list of activities for the given day.
     * If no date attribute was given by the user, prints the list of activities for today.
     */
    @Override
    public void execute() {
        if (!dayMap.getHashMap().containsKey(date)) {
            System.out.println("Nothing was added!");
        } else {
            ActivityList activities = dayMap.getActivityList(date.atStartOfDay());
            int activityCounter = activities.getNumberOfActivities();
            if (activityCounter == 0) {
                System.out.println("Nothing was added!");
            } else {
                for (int i = 0; i < activityCounter; i++) {
                    System.out.println((i + 1) + ". " + activities.getActivity(i).toString());
                }
            }
        }
    }
}
