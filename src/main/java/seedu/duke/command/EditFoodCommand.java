package seedu.duke.command;

import seedu.duke.Food;

import java.time.LocalDate;


/**
 * Edits food and its attributes at the indicated index.
 */
public class EditFoodCommand extends Command {
    protected int index;
    protected Food food;
    protected LocalDate date;


    /**
     * Edits food and it's respective calories.
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
