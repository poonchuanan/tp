package seedu.duke.command;

import seedu.duke.exception.EmptyKeywordException;
import seedu.duke.exception.KeywordNotFoundException;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyKeywordMessage;
import static seedu.duke.ui.ExceptionMessages.displayKeywordNotFoundMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@@author poonchuanan
/**
 * Initialises Command to find activity description.
 */
public class FindDescriptionCommand extends Command {
    protected LocalDate date;
    protected String description;

    /**
     * Find matching results based on description input.
     *
     * @param description description to search
     */
    public FindDescriptionCommand(String description) {
        this.date = LocalDateTime.now().toLocalDate();;
        this.description = description;

    }

    @Override
    public void execute() {
        try {
            dayMap.listActivitiesContainingDescription(description);
            dayMap.drawListAfterFindCommand();
        } catch (KeywordNotFoundException e) {
            displayKeywordNotFoundMessage();
        } catch (EmptyKeywordException e) {
            displayEmptyKeywordMessage();
        }
    }
}
