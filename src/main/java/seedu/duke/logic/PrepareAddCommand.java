package seedu.duke.logic;

import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;
import seedu.duke.command.Command;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.EmptyDescriptionException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static seedu.duke.ui.ExceptionMessages.displayAddActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBound;
import static seedu.duke.ui.ExceptionMessages.displayDateTimeExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.ui.Ui.displayAddMessage;

public class PrepareAddCommand extends PrepareCommand {
    protected static final String CALORIE_TAG = "c/";
    protected static final String FOOD_TAG = "f/";
    protected static final String DATE_TAG = "d/";
    protected static final int ALPHABET_WITH_SLASH_LENGTH = 2;
    protected static final int INDEX_NOT_FOUND = -1;
    protected static final String EXERCISE_TAG = "e/";
    protected static final boolean FALSE = false;

    public PrepareAddCommand(String[] description) {
        super(description);
    }


    /**
     * Prepares the add command by checking the userInput.
     *
     * @return AddFoodCommand or AddExerciseCommand
     */
    @Override
    public Command prepareCommand() {
        try {
            if (description[1].startsWith(FOOD_TAG)) {
                int calorieIndex = description[1].indexOf(CALORIE_TAG);
                int dateIndex = description[1].indexOf(DATE_TAG);

                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new Exception();
                } else {
                    foodDescription = description[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }
                boolean descriptionCheck;
                descriptionCheck = checkDescription(foodDescription);

                int calories;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calories = Integer.parseInt(description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH)
                            .trim());
                } else {
                    calories = Integer.parseInt(description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH,
                            dateIndex).trim());
                }
                boolean calorieCheck;
                calorieCheck = checkCalories(calories);

                LocalDate date;
                if (calorieCheck && descriptionCheck && dateIndex == INDEX_NOT_FOUND) {
                    date = LocalDate.now();
                } else {
                    date = processDate(description[1].substring(dateIndex + ALPHABET_WITH_SLASH_LENGTH).trim());
                }

                displayAddMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(foodDescription, calories, FALSE, date);
            } else if (description[1].startsWith(EXERCISE_TAG)) {
                int calorieIndex = description[1].indexOf(CALORIE_TAG);
                int dateIndex = description[1].indexOf(DATE_TAG);

                String exerciseDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new Exception();
                } else {
                    exerciseDescription = description[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }
                boolean descriptionCheck;
                descriptionCheck = checkDescription(exerciseDescription);

                int calories;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calories = Integer.parseInt(description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH)
                            .trim());
                } else {
                    calories = Integer.parseInt(description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH,
                            dateIndex).trim());
                }
                boolean calorieCheck;
                calorieCheck = checkCalories(calories);

                LocalDate date;
                if (calorieCheck && descriptionCheck && dateIndex == INDEX_NOT_FOUND) {
                    date = LocalDate.now();
                } else {
                    date = processDate(description[1].substring(dateIndex + ALPHABET_WITH_SLASH_LENGTH).trim());
                }

                displayAddMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new AddExerciseCommand(exerciseDescription, calories, FALSE, date);
            } else {
                displayEmptyAddActivityErrorMessage();
            }
        } catch (NumberFormatException e) {
            displayAddActivityExceptionMessage();
        } catch (DateTimeParseException e) {
            displayIncorrectDateTimeFormatEnteredMessage();
        } catch (CalorieCountException e) {
            displayCalorieCountOutOfBound();
        } catch (DateTimeException e) {
            displayDateTimeExceptionMessage();
        } catch (EmptyDescriptionException e) {
            displayEmptyDescriptionMessage();
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayAddCommandErrorMessage();
        } catch (Exception e) {
            displayAddActivityExceptionMessage();
        }
        return null;
    }

    public boolean checkCalories(int calories) throws CalorieCountException {
        if (calories <= 0 || calories > 3000) {
            throw new CalorieCountException();
        } else {
            return true;
        }
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
}
