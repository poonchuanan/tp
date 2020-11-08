package seedu.duke.command;

import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.KeywordNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Initialises Command to find calorie count.
 */
public class  FindCalorieCommand extends Command {
    protected LocalDate date;
    protected String calorie;

    /**
     * Find matching results based on calorie input.
     *
     * @param calorie calories to search
     */
    public FindCalorieCommand(String calorie) {
        this.date = LocalDateTime.now().toLocalDate();
        this.calorie = calorie;

    }

    @Override
    public void execute() {
        try {
            dayMap.listActivitiesContainingCalorie(calorie);
            dayMap.drawListAfterFindCommand();
        } catch (KeywordNotFoundException e) {
            System.out.println("No results were found!");
        } catch (EmptyDescriptionException e) {
            System.out.println("Keyword cannot be empty!");
        }
    }
}

