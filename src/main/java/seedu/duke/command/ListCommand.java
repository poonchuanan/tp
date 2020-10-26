package seedu.duke.command;

import seedu.duke.listDrawer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static seedu.duke.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.Ui.displaySavedMessage;

/**
 * List command.
 */
public class ListCommand extends Command {

    protected LocalDate date;
    private listDrawer listDrawer;

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
        //try {
            dayMap.setLastSeenList(dayMap.getActivityList(date.atStartOfDay()));
            dayMap.printList(date);
            System.out.println(dayMap.toString(date.atStartOfDay()));
            FindDrawer findDrawer = new FindDrawer(dayMap.getLastSeenList());
            findDrawer.printListDrawing();
//        } catch (NullPointerException e) {
//            System.out.println("There is no data for " + date.toString());
//        }

    }
}
