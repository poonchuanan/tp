package seedu.duke.command;

import seedu.duke.Food;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddFoodCommand extends Command {
    protected Food food;
    protected LocalDate date;

    public AddFoodCommand(String description, int calories) {
        this.food = new Food(description, calories);
        this.date = LocalDateTime.now().toLocalDate();
    }

    public AddFoodCommand(String description, int calories, LocalDate date) {
        this.food = new Food(description, calories);
        this.date = date;
    }

    @Override
    public void execute() {
        dayMap.addActivity(date.atStartOfDay(), food);
    }


}
