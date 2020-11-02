package seedu.duke.logic;

import seedu.duke.command.AddExerciseCommand;
import seedu.duke.command.AddFoodCommand;
import seedu.duke.command.AddSetCommand;
import seedu.duke.command.ByeCommand;
import seedu.duke.command.Command;
import seedu.duke.command.CreateNewRepeatedSet;
import seedu.duke.command.CreateNewUserCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.EditExerciseCommand;
import seedu.duke.command.EditFoodCommand;
import seedu.duke.command.EditUserProfileCommand;
import seedu.duke.command.FindAllCommand;
import seedu.duke.command.FindCalorieCommand;
import seedu.duke.command.FindDescriptionCommand;
import seedu.duke.command.FindEitherCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.ListCommand;

import seedu.duke.command.ListUserProfileCommand;
import seedu.duke.command.MoveActivityCommand;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.ui.ExceptionMessages;
import seedu.duke.userprofile.AskUserProfileQns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.format.DateTimeParseException;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;
import static seedu.duke.ui.ExceptionMessages.displayAddActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBound;
import static seedu.duke.ui.ExceptionMessages.displayDateTimeExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandStringOutOfBoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEditActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidInputErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.ui.Ui.displayAddMessage;
import static seedu.duke.ui.Ui.displayEditMessage;

/**
 * Initialises parser class.
 */
public class CommandParser extends Parser{

    protected static final int ALPHABET_WITH_SLASH_LENGTH = 2;
    public static final String SPACE = " ";

    protected static final String FOOD_TAG = "f/";
    protected static final String EXERCISE_TAG = "e/";
    protected static final String CALORIE_TAG = "c/";
    protected static final String DATE_TAG = "d/";

    protected static final int INDEX_NOT_FOUND = -1;

    protected static final boolean FALSE = false;


    /**
     * Store details in the class.
     *
     * @param userInput user from the user
     */
    public CommandParser(String userInput) {
        super(userInput);
    }

    /**
     * Parses commands input by user.
     *
     * @return Command type
     */
    @Override
    public Command parseArgument() {
        String[] arguments = userInput.split(SPACE, 2);
        try {
            switch (arguments[0].toLowerCase()) {
            case "create":
                return new CreateNewUserCommand();
            case "createset":
                return new CreateNewRepeatedSet(arguments[1]);
            case "add":
                return new PrepareAddCommand(arguments).prepareCommand();
            case "addset":
                return new PrepareAddSetCommand(arguments).prepareCommand();
            case "find":
                return new PrepareFindCommand(arguments).prepareCommand();
            case "edit":
                return new PrepareEditUserProfile(arguments).prepareCommand();
            case "edita":
                return new PrepareEditCommand(arguments).prepareCommand();
            case "delete":
                return new PrepareDeleteCommand(arguments).prepareCommand();
            case "list":
                return new PrepareListCommand(arguments).prepareCommand();
            case "listup":
                return new PrepareProfileListCommand(arguments).prepareCommand();
            case "help":
                return new PrepareHelpCommand(arguments).prepareCommand();
            case "move":
                return new PrepareMoveIndexCommand(arguments).prepareCommand();
            case "bye":
                return new PrepareByeCommand(arguments).prepareCommand();
            case "graph":
                return new PrepareGraphCommand(arguments).prepareCommand();
            default:
                return new InvalidCommand(displayInvalidInputErrorMessage());
            }
        } catch (StringIndexOutOfBoundsException e) {
            displayStringIndexOutOfBoundsExceptionMessage();
        } catch (IOException e) {
            displayIoExceptionMessage();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return null;
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

}
