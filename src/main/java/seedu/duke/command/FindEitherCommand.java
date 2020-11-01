package seedu.duke.command;

import seedu.duke.model.FindDrawer;
import seedu.duke.exception.KeywordNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Initialises Command to find all description tags.
 */
public class FindEitherCommand extends Command {
    protected LocalDate date;
    protected String userInput;

    /**
     * Find matching results based on input tags.
     *
     * @param userInput keywords to be matched
     */
    public FindEitherCommand(String userInput) {
        this.date = LocalDateTime.now().toLocalDate();
        this.userInput = userInput;
    }

    @Override
    public void execute() {
        try {
            dayMap.listActivitiesContainingEither(userInput);
            dayMap.drawListAfterFindCommand();
        } catch (KeywordNotFoundException e) {
            System.out.println("No results were found!");
        }
    }
}