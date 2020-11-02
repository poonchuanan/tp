package seedu.duke.logic;

import seedu.duke.command.Command;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.EmptyDescriptionException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBound;
import static seedu.duke.ui.ExceptionMessages.displayEditActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ui.Ui.displayEditMessage;

public class PrepareEditCommand extends PrepareCommand {
    protected static final String CALORIE_TAG = "c/";
    protected static final String FOOD_TAG = "f/";
    protected static final String DATE_TAG = "d/";
    protected static final int ALPHABET_WITH_SLASH_LENGTH = 2;
    protected static final int INDEX_NOT_FOUND = -1;
    protected static final String EXERCISE_TAG = "e/";
    protected static final boolean FALSE = false;
    protected static final String SPACE = " ";

    public PrepareEditCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares the edit command by checking the userInput.
     *
     * @return EditFoodCommand or EditExerciseCommand
     */
    @Override
    public Command prepareCommand() {
        String[] arguments = description[1].split(SPACE, 2);
        int index = Integer.parseInt(arguments[0]) - 1;
        String userInput = arguments[1];

        try {
            if (userInput.startsWith(FOOD_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);

                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new Exception();
                } else {
                    foodDescription = userInput.substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }
                checkDescription(foodDescription);

                int calories = Integer.parseInt(userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim());
                checkCalories(calories);

                displayEditMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new EditFoodCommand(index, foodDescription, calories);
            } else if (userInput.startsWith(EXERCISE_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);

                String exerciseDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new Exception();
                } else {
                    exerciseDescription = userInput.substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }
                checkDescription(exerciseDescription);

                int calories = Integer.parseInt(userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim());
                checkCalories(calories);

                displayEditMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new EditExerciseCommand(index, exerciseDescription, calories);
            } else {
                displayEmptyEditActivityErrorMessage();
            }
        } catch (CalorieCountException e) {
            displayCalorieCountOutOfBound();
        } catch (EmptyDescriptionException e) {
            displayEmptyDescriptionMessage();
        } catch (NullPointerException e) {
            displayEditActivityExceptionMessage();
        } catch (NumberFormatException e) {         // catch index not string
            displayEditActivityExceptionMessage();
        } catch (Exception e) {
            displayEditActivityExceptionMessage();
        }
        return null;
    }

    public boolean checkDescription(String description) throws EmptyDescriptionException {
        if (description.equals(" ") || description.equals("")) {
            throw new EmptyDescriptionException();
        } else {
            return true;
        }
    }

    /**
     * Process date input by user.
     *
     * @param dateInput date input by user
     * @return date
     * @throws DateTimeParseException if the string is in the incorrect format
     */
    private LocalDate processDate(String dateInput) throws DateTimeParseException {
        LocalDate dateTime = LocalDate.parse(dateInput);

        return dateTime;
    }

    public boolean checkCalories(int calories) throws CalorieCountException {
        if (calories <= 0 || calories > 3000) {
            throw new CalorieCountException();
        } else {
            return true;
        }
    }
}
