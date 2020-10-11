package seedu.duke.command;

import seedu.duke.ActivityList;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;

public class FindDescriptionCommand extends Command {
    protected LocalDate date;
    protected String description;

    public FindDescriptionCommand(String description) {
        this.date = LocalDateTime.now().toLocalDate();;
        this.description = description;
    }

    @Override
    public void execute() {
        ActivityList activities = dayMap.getActivityList(date.atStartOfDay());
        int activityCounter = activities.getNumberOfActivities();
        if (activityCounter == 0) {
            displayEmptyActivityCounterMessage();
        } else {
            System.out.println("Here are the matching results based on description");
            for (int i = 0; i < activityCounter; i++) {
                String currentLine = activities.getActivity(i).toString();
                String descriptionToCheck = currentLine.substring(currentLine.indexOf("|") + 1);
                descriptionToCheck = descriptionToCheck.substring(0, descriptionToCheck.indexOf("|")).trim();
                if (descriptionToCheck.contains(description)) {
                    System.out.println((i + 1) + ". " + currentLine);
                }
            }
        }
    }
}
