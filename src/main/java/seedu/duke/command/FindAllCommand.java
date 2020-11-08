package seedu.duke.command;

import seedu.duke.exception.EmptyKeywordException;
import seedu.duke.exception.FindSlashException;
import seedu.duke.exception.KeywordNotFoundException;
import static seedu.duke.ui.ExceptionMessages.displayEmptyKeywordMessage;
import static seedu.duke.ui.ExceptionMessages.displayFindSlashExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayKeywordNotFoundMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@@author poonchuanan
/**
 * Initialises Command to find all description tags.
 */
public class FindAllCommand extends Command {
    protected LocalDate date;
    protected String userInput;

    /**
     * Find matching results based on input tags.
     *
     * @param userInput keywords to be matched
     */
    public FindAllCommand(String userInput) {
        this.date = LocalDateTime.now().toLocalDate();
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        try {
            dayMap.listActivitiesContainingAll(userInput);
            dayMap.drawListAfterFindCommand();
        } catch (KeywordNotFoundException e) {
            displayKeywordNotFoundMessage();
        } catch (EmptyKeywordException e) {
            displayEmptyKeywordMessage();
        } catch (FindSlashException e) {
            displayFindSlashExceptionMessage();
        }
    }
}
