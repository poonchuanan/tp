package seedu.duke.command;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.Trakcal.logging;
import static seedu.duke.ui.ExceptionMessages.displayEmptyListError;

//@@author chewyang

/**
 * Prints the list of activities for the given day.
 * If no date attribute was given by the user, prints the list of activities for today.
 * Prints error message if there is no activities for the given day.
 */
public class ListCommand extends Command {

    protected LocalDate date;


    public ListCommand(LocalDate date) {
        this.date = date;
        this.canBeChained = true;

    }

    public ListCommand() {
        this.date = LocalDateTime.now().toLocalDate();
        this.canBeChained = true;

    }


    @Override
    public void execute() {
        try {
            dayMap.setLastSeenList(dayMap.getActivityList(date.atStartOfDay()));
            dayMap.drawListAfterListCommand(date);

        } catch (NullPointerException e) {
            displayEmptyListError();
            logging.writeToLogInfo("no data found");
        }

    }
}
//@@author chewyang