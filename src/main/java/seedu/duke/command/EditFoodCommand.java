package seedu.duke.command;

import seedu.duke.model.ActivityList;
import seedu.duke.model.Food;

import java.time.LocalDate;

import static seedu.duke.ui.Ui.displaySavedMessage;


/**
 * Edits food and its attributes at the indicated index.
 */
public class EditFoodCommand extends Command {
    protected int index;
    protected Food food;
    protected LocalDate date;
    protected String description;
    protected int calories;


    /**
     * Edits food and it's respective calories.
     *
     * @param description food description.
     * @param calories calories gained.
     */
    public EditFoodCommand(int index, String description, int calories) {
        this.index = index;
        this.description = description;
        this.calories = calories;
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            ActivityList lastSeenList = dayMap.getLastSeenList();
            LocalDate dateOfActivityToBeEdited = lastSeenList.getDateOfActivityAtIndex(index);
            this.food = new Food(description, calories, dateOfActivityToBeEdited, false);
            dayMap.insertActivity(index, food);
            displaySavedMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!\n"
                    + "Please pull out the list for the day before editing on it!");
        }
    }
}
