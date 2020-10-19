package seedu.duke;

import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.FindCalorieCommand;
import seedu.duke.command.FindDescriptionCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.command.graphCommand;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeParseException;

import static seedu.duke.ExceptionMessages.displayAddActivityNumberFormatExceptionMessage;
import static seedu.duke.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ExceptionMessages.displayDateTimeExceptionMessage;
import static seedu.duke.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ExceptionMessages.displayInvalidInputErrorMessage;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.Ui.displayHelpMessage;

/**
 * Initialises parser class.
 */
public class Parser {
    protected String userInput;
    protected LocalDateTime date;
    protected DayMap calList;

    /**
     * Store details in the class.
     *
     * @param userInput user from the user.
     */
    public Parser(String userInput) {
        this.userInput = userInput;
        this.date = LocalDateTime.now();
        this.calList = Duke.getDayMap();
    }

    /**
     * Parses commands.
     *
     * @return Command type
     */
    public Command parseCommand() {
        String[] arguments = userInput.split(" ", 2);

        try {
            switch (arguments[0].toLowerCase()) {
            case "add":
                return prepareAddCommand(userInput);
            case "find":
                return prepareFindCommand(userInput);
            case "edit":
                Userinfo store = new Userinfo();
                store.editUserInfo(arguments[1]);
                Initialiseuser.save(store);
                break;
            case "edita":
                return prepareEditCommand(arguments[1]);
            case "delete":
                return prepareDeleteCommand(arguments[1]);
            case "list":
                return prepareListCommand(userInput);
            case "help":
                return new HelpCommand();
            case "bye":
                return new ByeCommand();
            case "graph":
                return new graphCommand();
            default:
                return new InvalidCommand();
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return null;
    }

    /**
     * Prepares the edit command by checking the userInput.
     *
     * @param userInput description of the edit command.
     * @return EditFoodCommand
     * @return EditExerciseCommand
     */
    private Command prepareEditCommand(String userInput) {
        int index = Integer.parseInt(userInput.substring(0, 1).trim()) - 1;
        userInput = userInput.substring(1).trim();
        try {
            if (userInput.startsWith("f/")) {
                int calorieIndex = userInput.indexOf("c/");
                int dateIndex = userInput.indexOf("d/");
                int calories = Integer.parseInt(userInput.substring(calorieIndex + 2, dateIndex).trim());
                LocalDate date = processDate(userInput.substring(dateIndex + 2).trim());

                String foodDescription = userInput.substring(2, calorieIndex - 1).trim();

                new DeleteCommand(index);
                return new EditFoodCommand(index, foodDescription, calories, false, date);
            } else if (userInput.startsWith("e/")) {
                int calorieIndex = userInput.indexOf("c/");
                int dateIndex = userInput.indexOf("d/");
                int calories = Integer.parseInt(userInput.substring(calorieIndex + 2, dateIndex).trim());
                LocalDate date = processDate(userInput.substring(dateIndex + 2).trim());

                String exerciseDescription = userInput.substring(2, calorieIndex - 1).trim();

                new DeleteCommand(index);
                return new EditExerciseCommand(index, exerciseDescription, calories, false, date);
            } else {
                displayEmptyEditActivityErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayAddCommandErrorMessage();
        } catch (NumberFormatException e) {
            displayAddActivityNumberFormatExceptionMessage();
        }
        return null;
    }

    /**
     * Prepares the add command by checking the userInput.
     *
     * @param userInput description of the add command.
     * @return AddFoodCommand
     * @return AddExerciseCommand
     */
    private Command prepareAddCommand(String userInput) {
        try {
            String[] arguments = userInput.split(" ", 2);
            if (arguments[1].startsWith("f/")) {
                int calorieIndex = arguments[1].indexOf("c/");
                int dateIndex = arguments[1].indexOf("d/");
                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2, dateIndex).trim());
                LocalDate date = processDate(arguments[1].substring(dateIndex + 2).trim());

                String foodDescription = arguments[1].substring(2, calorieIndex - 1).trim();

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(foodDescription, calories, false, date);
            } else if (arguments[1].startsWith("e/")) {
                int calorieIndex = arguments[1].indexOf("c/");
                int dateIndex = arguments[1].indexOf("d/");
                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2, dateIndex).trim());
                LocalDate date = processDate(arguments[1].substring(dateIndex + 2).trim());

                String exerciseDescription = arguments[1].substring(2, calorieIndex - 1).trim();

                assert calories > 0 : "calories should be greater than 0";
                return new AddExerciseCommand(exerciseDescription, calories, false, date);
            } else {
                displayEmptyAddActivityErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayAddCommandErrorMessage();
        } catch (NumberFormatException e) {
            displayAddActivityNumberFormatExceptionMessage();
        }
        return null;
    }

    /**
     * Process date input by user.
     *
     * @param dateInput date input by user.
     * @return date
     */
    private LocalDate processDate(String dateInput) {
        try {
            LocalDate date = LocalDate.parse(dateInput);

            return date;
        } catch (DateTimeException e) {
            //displayDateTimeExceptionMessage();
            return currentDate();
        }
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
     * Process the date input by user.
     *
     * @param dateInput date input by user.
     * @return date
     */
    private String processingDate(String dateInput) {
        int extra = dateInput.indexOf("&&");
        dateInput = dateInput.substring(0, extra);

        try {
            LocalDate data = LocalDate.parse(dateInput);
            String day = data.getDayOfMonth() + " ";
            String month = data.getMonth() + " ";
            String year = data.getYear() + "";
            String date = day + month + year;

            return date;
        } catch (DateTimeException e) {
            displayDateTimeExceptionMessage();
            return null;
        }
    }

    /**
     * Prepares the list command by checking the userInput.
     *
     * @param userInput description of the list command.
     * @return ListCommand
     */
    private Command prepareListCommand(String userInput) {
        if (userInput.toLowerCase().equals("list")) {
            return new ListCommand();
        } else {
            String[] arguments = userInput.split(" ");
            try {
                LocalDate date = checkDate(arguments[1]);
                return new ListCommand(date);
            } catch (DateTimeParseException e) {
                displayIncorrectDateTimeFormatEnteredMessage();
                return null;
            }
        }
    }

    /**
     * Prepares the delete command by checking the userInput.
     *
     * @param userInput description of the delete command.
     * @return DeleteCommand
     */
    private Command prepareDeleteCommand(String userInput) {
        try {
            if (userInput.equals("/all")) {
                return new DeleteCommand();
            } else {
                int index = Integer.parseInt(userInput) - 1;
                return new DeleteCommand(index);
            }
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        }
        return null;
    }

    /**
     * Prepares the find command by checking the userInput.
     * If the keyword contains activity description, returns FindDescriptionCommand.
     * Else if the keyword contains calories count, returns FindCalorieCommand.
     *
     * @param userInput description of the find command.
     * @return FindDescriptionCommand
     * @return FindCalorieCommand
     */
    private Command prepareFindCommand(String userInput) {
        try {
            String[] arguments = userInput.split(" ", 2);
            if (arguments[1].startsWith("d/")) {
                String description = arguments[1].substring(2);
                return new FindDescriptionCommand(description);
            } else if (arguments[1].startsWith("c/")) {
                String calorie = arguments[1].substring(2);
                return new FindCalorieCommand(calorie);
            } else {
                displayFindErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayFindErrorMessage();
        }
        return null;
    }

    private LocalDate checkDate(String dateTimeString) throws DateTimeParseException {
        LocalDate dateTime = LocalDate.parse(dateTimeString);
        return dateTime;
    }
}
