package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.ListCommand;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static seedu.duke.ui.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;

public class PrepareListCommand extends PrepareCommand {


    public PrepareListCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the list command by checking the userInput.
     *
     * @return ListCommand
     */
    @Override
    public Command prepareCommand() {

        if (description.length == 1) {
            return new ListCommand();
        } else {
            String dateString = description[1];
            try {
                LocalDate date = processDate(dateString);
                return new ListCommand(date);
            } catch (DateTimeParseException e) {
                displayIncorrectDateTimeFormatEnteredMessage();
                return null;
            }
        }
    }

    /**
     * Process date input by user.
     *
     * @param dateInput date input by user
     * @return date
     * @throws DateTimeParseException if the string is in the incorrect format
     */
    private LocalDate processDate(String dateInput) throws DateTimeParseException {
        LocalDate dateTime = LocalDate.parse(dateInput);

        return dateTime;
    }
}
