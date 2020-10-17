package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.DayMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static seedu.duke.Ui.displayEmptyActivityCounterMessage;

public class FindDescriptionCommand extends Command {
    protected LocalDate date;
    protected String description;

    /**
     * Find matching results based on description input.
     * @param description description to search
     */
    public FindDescriptionCommand(String description) {
        this.date = LocalDateTime.now().toLocalDate();;
        this.description = description;
    }

    @Override
    public void execute() {
        HashMap dayHashMap = dayMap.getHashMap();
        dayMap.setLastSeenList(new ActivityList());
        ActivityList lastSeenList = dayMap.getLastSeenList();
        Iterator it = dayHashMap.entrySet().iterator();
        int activityFindCounter = 0;
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String date = pair.getKey().toString();
            ActivityList activities = (ActivityList) pair.getValue();
            int activityCounter = activities.getNumberOfActivities();

            if (activityCounter > 0) {
                for (int i = 0; i < activityCounter; i++) {
                    String currentLine = activities.getActivity(i).toString();
                    String descriptionToCheck = currentLine.substring(currentLine.indexOf("|") + 1);
                    descriptionToCheck = descriptionToCheck.substring(0, descriptionToCheck.indexOf("|")).trim();
                    if (descriptionToCheck.contains(description)) {
                        System.out.println((activityFindCounter + 1) + ". " + date + " " + currentLine);
                        lastSeenList.addActivity(activities.getActivity(i));
                        activityFindCounter++;
                    }
                }
            }
        }
        if (activityFindCounter == 0) {
            System.out.println("Not found in daymap!");
        }

    }
}
