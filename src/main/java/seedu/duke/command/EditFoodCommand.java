package seedu.duke.command;

import seedu.duke.Food;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static seedu.duke.Ui.displayHelpMessage;
import static seedu.duke.Ui.displaySaveMessage;

/**
 * Edit food.
 */
public class EditFoodCommand extends Command {
    protected int index;
    protected Food food;
    protected LocalDate date;

    /**
     * Edit food and it's respective calories.
     *
     * @param description food description.
     * @param calories calories gained.
     * @param isFromFile if data is from csv file.
     * @param date date of activity.
     */
    public EditFoodCommand(int index, String description, int calories, boolean isFromFile, LocalDate date) {
        this.index = index;
        this.food = new Food(description, calories, isFromFile);
        this.date = date;
    }

    @Override
    public void execute() {
        dayMap.insertActivity(index, date.atStartOfDay(), food);
    }
}
