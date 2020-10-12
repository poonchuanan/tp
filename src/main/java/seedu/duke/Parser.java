package seedu.duke;

import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.Command;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.FindCalorieCommand;
import seedu.duke.command.FindDescriptionCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.time.format.DateTimeParseException;

import static seedu.duke.ExceptionMessages.displayAddActivityNumberFormatExceptionMessage;
import static seedu.duke.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ExceptionMessages.displayInvalidInputErrorMessage;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.Ui.displayHelpMessage;


public class Parser {
    protected String userInput;
    protected LocalDateTime date;
    protected DayMap calList;

    public Parser(String userInput) {
        this.userInput = userInput;
        this.date = LocalDateTime.now();
        this.calList = Duke.getDayMap();
    }

    public Command parseCommand() {
        String[] arguments = userInput.split(" ", 2); //TODO split for all types of spaces etc TAB.

        try {
            switch (arguments[0].toLowerCase()) {
            case "add":
                return prepareAddCommand(userInput);
            case "find":
                return prepareFindCommand(userInput);
            case "edit":
                //TODO apply SLAP
                Userinfo store = new Userinfo();
                store.editUserInfo(arguments[1]);
                Initialiseuser.save(store);
                break;
            case "delete":
                return prepareDeleteCommand(arguments[1]);
            case "list":
                return prepareListCommand(userInput);
            case "help":
                return new HelpCommand();
            case "bye":
                return new ByeCommand();
            default:
                displayInvalidInputErrorMessage();
                break;
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
        return null;
    }

    private Command prepareAddCommand(String userInput) {
        try {
            String[] arguments = userInput.split(" ", 2);
            if (arguments[1].startsWith("f/")) {
                int calorieIndex = arguments[1].indexOf("c/");
                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2).trim());
                arguments[1] = arguments[1].substring(2, calorieIndex - 1).trim();

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(arguments[1], calories);
            } else if (arguments[1].startsWith("e/")) {
                int calorieIndex = arguments[1].indexOf("c/");
                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2).trim());
                arguments[1] = arguments[1].substring(2, calorieIndex - 1).trim();

                assert calories > 0 : "calories should be greater than 0";
                return new AddExerciseCommand(arguments[1], calories);
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

    private Command prepareDeleteCommand(String userInput) {
        try {
            int index = Integer.parseInt(userInput);

            return new DeleteCommand(index - 1);
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        }
        return null;
    }

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
