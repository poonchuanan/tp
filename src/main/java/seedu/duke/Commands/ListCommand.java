package seedu.duke.Commands;

import seedu.duke.ActivityList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ListCommand extends Command{

    protected LocalDate date;

    public ListCommand(LocalDate date) {
        this.date = date;
    }
    public ListCommand() {
        this.date = LocalDateTime.now().toLocalDate();
    }
   @Override
    public void execute(){
       ActivityList activities= dayMap.getActivityList(date.atStartOfDay());
       int activityCounter = activities.getNumberOfActivities();
       ArrayList activitiesArrayList= activities.getArrayList();
       if(activityCounter == 0) {
           System.out.println("Nothing was added!");
       } else {
           for (int i = 0; i < activityCounter; i++) {
               System.out.println((i + 1) + ". " + activities.getActivity(i).toString());
           }
       }
    }
}
