package seedu.duke.command;

import seedu.duke.ActivityList;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;
import static seedu.duke.Ui.displaySavedMessage;

/**
 * Initialises Command to find calorie count.
 */
public class  FindCalorieCommand extends Command {
    protected LocalDate date;
    protected String calorie;

    /**
     * Find matching results based on calorie input.
     * @param calorie calories to search
     */
    public FindCalorieCommand(String calorie) {
        this.date = LocalDateTime.now().toLocalDate();
        this.calorie = calorie;

    }

    @Override
    public void execute() {
        ActivityList activities = dayMap.getActivityList(date.atStartOfDay());
        int activityCounter = activities.getNumberOfActivities();
        if (activityCounter == 0) {
            displayEmptyActivityCounterMessage();
        } else {
            System.out.println("Here are the matching results based on calories:");
            for (int i = 0; i < activityCounter; i++) {
                String currentLine = activities.getActivity(i).toString();
                int calorieStartIndex = currentLine.lastIndexOf(' ');
                String calorieToCheck = currentLine.substring(calorieStartIndex).trim();
                if (calorieToCheck.equals(calorie)) {
                    System.out.println((i + 1) + ". " + currentLine);
                }
            }
        }
        displaySavedMessage();
    }
}
