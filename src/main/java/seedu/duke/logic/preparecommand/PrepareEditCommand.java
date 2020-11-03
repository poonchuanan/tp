package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.CalorieTagNotFoundException;
import seedu.duke.exception.DescriptionLengthExceedException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.InvalidCalorieException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBoundMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieTagNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDescriptionLengthExceedExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEditActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCalorieExceptionMessage;
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
        try {
            String[] arguments = description[1].split(SPACE, 2);
            int index = Integer.parseInt(arguments[0]) - 1;
            String userInput = arguments[1];

            if (userInput.startsWith(FOOD_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);
                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    foodDescription = userInput.substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionNotEmpty(foodDescription)
                        && isDescriptionLengthWithinRange(foodDescription);

                String calorieInput = userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesWithinRange(calories);

                boolean isInputValid = isCalorieValid && isDescriptionInputValid;
                if (isInputValid) {
                    displayEditMessage();
                } else {
                    throw new Exception();
                }

                assert calories > 0 : "calories should be greater than 0";
                return new EditFoodCommand(index, foodDescription, calories);
            } else if (userInput.startsWith(EXERCISE_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);
                String exerciseDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    exerciseDescription = userInput.substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionNotEmpty(exerciseDescription)
                        && isDescriptionLengthWithinRange(exerciseDescription);

                String calorieInput = userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesWithinRange(calories);

                boolean isInputValid = isCalorieValid && isDescriptionInputValid;
                if (isInputValid) {
                    displayEditMessage();
                } else {
                    throw new Exception();
                }

                assert calories > 0 : "calories should be greater than 0";
                return new EditExerciseCommand(index, exerciseDescription, calories);
            } else {
                displayEmptyEditActivityErrorMessage();
            }
        } catch (CalorieCountException e) {
            displayCalorieCountOutOfBoundMessage();
        } catch (CalorieTagNotFoundException e) {
            displayCalorieTagNotFoundExceptionMessage();
        } catch (DescriptionLengthExceedException e) {
            displayDescriptionLengthExceedExceptionMessage();
        } catch (InvalidCalorieException e) {
            displayInvalidCalorieExceptionMessage();
        } catch (EmptyDescriptionException e) {
            displayEmptyDescriptionMessage();
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayEditActivityExceptionMessage();
        } catch (NumberFormatException e) {
            displayEditActivityExceptionMessage();
        } catch (Exception e) {
            displayEditActivityExceptionMessage();
        }
        return null;
    }

    /**
     * Checks if calorie input by user is empty.
     *
     * @param calorieInput calorie input by user
     * @return calorie count if it is not empty
     * @throws InvalidCalorieException if the calorie count is empty
     */
    public int parseCalorie(String calorieInput) throws InvalidCalorieException {
        if (!calorieInput.equals("")) {
            return Integer.parseInt(calorieInput);
        } else {
            throw new InvalidCalorieException();
        }
    }

    /**
     * Checks if the description is filled.
     *
     * @param description description input by user
     * @return true if no error in description input
     * @throws EmptyDescriptionException if description input has error
     */
    public boolean isDescriptionNotEmpty(String description) throws EmptyDescriptionException {
        if (description.equals(" ") || description.equals("")) {
            throw new EmptyDescriptionException();
        } else {
            return true;
        }
    }

    /**
     * Checks if the description character counts is within accepted range.
     *
     * @param description description input by user
     * @return true if description length is within range
     * @throws DescriptionLengthExceedException if description exceeds range
     */
    public boolean isDescriptionLengthWithinRange(String description) throws DescriptionLengthExceedException {
        if (description.length() >= MAXIMUM_DESCRIPTION_LENGTH) {
            throw new DescriptionLengthExceedException();
        } else {
            return true;
        }
    }

    public boolean isCaloriesWithinRange(int calorie) throws CalorieCountException {
        if (calorie <= MINIMUM_CALORIE_COUNT || calorie > MAXIMUM_CALORIE_COUNT) {
            throw new CalorieCountException();
        } else {
            return true;
        }
    }
}
