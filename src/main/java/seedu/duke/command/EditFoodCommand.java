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


    /**
     * Edit food and it's respective calories.
     *
     * @param description food description.
     * @param calories calories gained.
     */
    public EditFoodCommand(int index, String description, int calories) {
        this.index = index;
        this.food = new Food(description, calories, false);
        this.canBeChained = true;

    }

    @Override
    public void execute() {

        try {
            dayMap.insertActivity(index, food);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!");
        }

    }
}
