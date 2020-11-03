package seedu.duke.logic.preparecommand;

import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;
import seedu.duke.command.Command;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.CalorieTagNotFoundException;
import seedu.duke.exception.DateLimitException;
import seedu.duke.exception.DescriptionLengthExceedException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.InvalidCalorieException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static seedu.duke.ui.ExceptionMessages.displayAddActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBoundMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieTagNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDateLimitExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDateTimeExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDescriptionLengthExceedExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCalorieExceptionMessage;
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
                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    foodDescription = description[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionNotEmpty(foodDescription)
                        && isDescriptionLengthWithinRange(foodDescription);

                int dateIndex = description[1].indexOf(DATE_TAG);
                String calorieInput;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calorieInput = description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                } else {
                    calorieInput = description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH, dateIndex).trim();
                }

                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesWithinRange(calories);

                LocalDate date;
                if (isCalorieValid && isDescriptionInputValid && dateIndex == INDEX_NOT_FOUND) {
                    date = currentDate();
                } else {
                    date = checkDateValidity(description[1], dateIndex);
                }

                if (isDescriptionInputValid && isCalorieValid) {
                    displayAddMessage();
                } else {
                    throw new Exception();
                }

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(foodDescription, calories, FALSE, date);
            } else if (description[1].startsWith(EXERCISE_TAG)) {
                int calorieIndex = description[1].indexOf(CALORIE_TAG);
                String exerciseDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    exerciseDescription = description[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionNotEmpty(exerciseDescription)
                        && isDescriptionLengthWithinRange(exerciseDescription);

                int dateIndex = description[1].indexOf(DATE_TAG);
                String calorieInput;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calorieInput = description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                } else {
                    calorieInput = description[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH, dateIndex).trim();
                }

                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesWithinRange(calories);

                LocalDate date;
                if (isCalorieValid && isDescriptionInputValid && dateIndex == INDEX_NOT_FOUND) {
                    date = currentDate();
                } else {
                    date = checkDateValidity(description[1], dateIndex);
                }

                if (isDescriptionInputValid && isCalorieValid) {
                    displayAddMessage();
                } else {
                    throw new Exception();
                }

                assert calories > 0 : "calories should be greater than 0";
                return new AddExerciseCommand(exerciseDescription, calories, FALSE, date);
            } else {
                displayAddActivityExceptionMessage();
            }

        } catch (DateTimeParseException e) {
            displayIncorrectDateTimeFormatEnteredMessage();
        } catch (CalorieCountException e) {
            displayCalorieCountOutOfBoundMessage();
        } catch (CalorieTagNotFoundException e) {
            displayCalorieTagNotFoundExceptionMessage();
        } catch (DescriptionLengthExceedException e) {
            displayDescriptionLengthExceedExceptionMessage();
        } catch (InvalidCalorieException e) {
            displayInvalidCalorieExceptionMessage();
        } catch (DateLimitException e) {
            displayDateLimitExceptionMessage();
        } catch (DateTimeException e) {
            displayDateTimeExceptionMessage();
        } catch (EmptyDescriptionException e) {
            displayEmptyDescriptionMessage();
        } catch (NumberFormatException e) {
            displayAddActivityExceptionMessage();
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayAddCommandErrorMessage();
        } catch (Exception e) {
            displayAddActivityExceptionMessage();
        }
        return null;
    }

    /**
     * Process date input by user.
     *
     * @param dateInput date input by user
     * @return date
     * @throws DateTimeParseException if the string is in the incorrect format
     */
    private LocalDate processDate(String dateInput) throws DateTimeParseException {
        return LocalDate.parse(dateInput);
    }

    /**
     * Returns current date.
     *
     * @return current date
     */
    private LocalDate currentDate() {
        LocalDate date = LocalDate.now();

        return date;
    }

    /**
     * Checks if the date is valid.
     *
     * @param dateInput is date input by user
     * @param dateIndex index date is at
     * @return true if date is valid
     * @throws DateLimitException if date exceeds limit
     */
    public LocalDate checkDateValidity(String dateInput, int dateIndex) throws DateLimitException {
        LocalDate date = processDate(dateInput.substring(dateIndex + ALPHABET_WITH_SLASH_LENGTH).trim());
        LocalDate current = LocalDate.now();
        LocalDate past = processDate(APPLICATION_LAUNCH_DATE);
        if (date.isAfter(current)) {
            throw new DateLimitException();
        } else if (date.isBefore(past)) {
            throw new DateLimitException();
        } else {
            return date;
        }
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
     * Checks if the calorie input is within accepted range.
     *
     * @param calorie calories input by user
     * @return true is calorie is within range
     * @throws CalorieCountException if calorie not within range
     */
    public boolean isCaloriesWithinRange(int calorie) throws CalorieCountException {
        if (calorie <= MINIMUM_CALORIE_COUNT || calorie > MAXIMUM_CALORIE_COUNT) {
            throw new CalorieCountException();
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

}
