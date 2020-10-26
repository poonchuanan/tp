package seedu.duke.command;

import seedu.duke.ListDrawer;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * List command.
 */
public class ListCommand extends Command {

    protected LocalDate date;
    private ListDrawer listDrawer;

    public ListCommand(LocalDate date) {
        this.date = date;
        this.canBeChained = true;

    }

    public ListCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.canBeChained = true;

    }

    /**
     * Prints the list of activities for the given day.
     * If no date attribute was given by the user, prints the list of activities for today.
     * Prints error message if there is no activities for the given day.
     */
    @Override
    public void execute() {
        try {
            dayMap.setLastSeenList(dayMap.getActivityList(date.atStartOfDay()));
            dayMap.printList(date);
            System.out.println(dayMap.toString(date.atStartOfDay()));
            listDrawer = new ListDrawer(date, dayMap.getLastSeenList());
            listDrawer.printListDrawing();
        } catch (NullPointerException e) {
            System.out.println("There is no data for " + date.toString());
        }

    }
}
