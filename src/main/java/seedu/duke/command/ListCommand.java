package seedu.duke.command;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        dayMap.setLastSeenList(dayMap.getActivityList(date.atStartOfDay()));
        dayMap.getLastSeenList().printList();
    }
}
