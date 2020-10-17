package seedu.duke.command;

import seedu.duke.exception.KeywordNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FindDescriptionCommand extends Command {
    protected LocalDate date;
    protected String description;

    /**
     * Find matching results based on description input.
     * @param description description to search
     */
    public FindDescriptionCommand(String description) {
        this.date = LocalDateTime.now().toLocalDate();;
        this.description = description;
    }

    @Override
    public void execute() {
        try {
            dayMap.listActivitiesContaining(description);
        } catch (KeywordNotFoundException e) {
            System.out.println("Invalid keyword!");
        }

    }


}
