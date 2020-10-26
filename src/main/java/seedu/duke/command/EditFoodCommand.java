package seedu.duke.command;

import seedu.duke.ActivityList;
import seedu.duke.Food;

import java.time.LocalDate;

import static seedu.duke.Ui.displaySavedMessage;


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
        ActivityList lastSeenList = dayMap.getLastSeenList();
        LocalDate dateOfActivityToBeEdited = lastSeenList.getDateOfActivityAtIndex(index);
        this.food = new Food(description, calories, dateOfActivityToBeEdited, false);
        this.canBeChained = true;
    }

    @Override
    public void execute() {
        try {
            dayMap.insertActivity(index, food);
            displaySavedMessage();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index entered is not within the range!\n"
                    + "Please pull out the list for the day before editing on it!");
        }
    }
}
