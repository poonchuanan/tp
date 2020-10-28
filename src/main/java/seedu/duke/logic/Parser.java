package seedu.duke.logic;

import seedu.duke.Trakcal;
//import seedu.duke.command.*;
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
import seedu.duke.command.FindAllCommand;
import seedu.duke.command.FindCalorieCommand;
import seedu.duke.command.FindDescriptionCommand;
import seedu.duke.command.FindEitherCommand;
import seedu.duke.command.GraphCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.ListCommand;

import seedu.duke.command.MoveActivityCommand;
import seedu.duke.ui.ExceptionMessages;
import seedu.duke.userprofile.SaveAndAskForUserProfile;
import seedu.duke.userprofile.InitialiseAndCalculateUserProfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.format.DateTimeParseException;
import java.util.HashMap;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;
import static seedu.duke.ui.ExceptionMessages.displayAddActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEditActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayStringIndexOutOfBoundsExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayIncorrectDateTimeFormatEnteredMessage;
import static seedu.duke.ui.Ui.displayAddMessage;
import static seedu.duke.ui.Ui.displayEditMessage;

/**
 * Initialises parser class.
 */
public class Parser {
    protected String userInput;
    protected LocalDateTime date;

    protected static final int ALPHABET_WITH_SLASH = 2;
    public static final String SPACE = " ";
    public static final String CHAIN_SEPARATOR = "&&";
    protected static final int CHAIN_SEPARATOR_LENGTH = 2;

    protected static final String FOOD_TAG = "f/";
    protected static final String EXERCISE_TAG = "e/";
    protected static final String CALORIE_TAG = "c/";
    protected static final String DATE_TAG = "d/";

    protected static final boolean FALSE = false;


    /**
     * Store details in the class.
     *
     * @param userInput user from the user
     */
    public Parser(String userInput) {
        this.userInput = userInput.trim().replaceAll(" +", SPACE);
        this.date = LocalDateTime.now();
    }

    /**
     * Parses commands input by user.
     *
     * @return Command type
     */
    public Command parseCommand() {
        String[] arguments = userInput.split(SPACE, 2);
        try {
            switch (arguments[0].toLowerCase()) {
            case "create":
                return new CreateNewUserCommand();
            case "createset":
                return new CreateNewRepeatedSet(arguments[1]);
            case "add":
                return prepareAddCommand(userInput);
            case "addset":
                return prepareAddSet(arguments[1]);
            case "find":
                return prepareFindCommand(userInput);
            case "edit":
                Trakcal.profile = InitialiseAndCalculateUserProfile.editUserInfo(arguments[1]);
                SaveAndAskForUserProfile.save(Trakcal.profile);
                break;
            case "edita":
                return prepareEditActivityCommand(arguments[1]);
            case "delete":
                return prepareDeleteCommand(arguments[1]);
            case "list":
                return prepareListCommand(userInput);
            case "help":
                return new HelpCommand();
            case "move":
                return prepareMoveIndexCommand(userInput);
            case "bye":
                return new ByeCommand();
            case "graph":
                return prepareGraphCommand(arguments);
            default:
                return new InvalidCommand();
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
     * Prepares file to be read from and added into the current list.
     *
     * @param fileName file to be read from
     * @return Command
     */
    private Command prepareAddSet(String fileName) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        try {
            String initialPath = new File("").getAbsolutePath();
            String filePath = initialPath + "/" + fileName + ".txt";
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            if (file.exists()) {
                String line = reader.readLine();

                while (line != null) {
                    Parser parser = new Parser("add " + line + " d/ " + strDate);
                    Command cmd = parser.parseCommand();
                    executeCmd(cmd);
                    storage.updateFile(calList);
                    line = reader.readLine();
                }
            } else {
                throw new FileNotFoundException();
            }
            reader.close();
            return new AddSetCommand();
        } catch (FileNotFoundException e) {
            ExceptionMessages.displayShortcutDoesNotExistMessage();
        } catch (IOException e) {
            ExceptionMessages.displayIoExceptionMessage();
        }
        return new AddSetCommand();
    }

    /**
     * Prepares chained input by user into their respective commands to be read.
     *
     * @param userInput input given by user
     * @return null
     */
    public Command prepareChaining(String userInput) {
        while (userInput.contains(CHAIN_SEPARATOR)) {
            if (userInput.equals(CHAIN_SEPARATOR)) {
                break;
            }

            userInput = userInput + SPACE + CHAIN_SEPARATOR;
            int chainIndex = userInput.indexOf(CHAIN_SEPARATOR);

            String firstString = userInput.substring(0, chainIndex).trim();

            Parser parser = new Parser(firstString);
            Command cmd = parser.parseCommand();

            if (cmd.getCanBeChained()) {
                executeCmd(cmd);
            } else {
                System.out.println("This command entered cannot be chained together!");
                break;
            }
            storage.updateFile(calList);

            userInput = userInput.substring(chainIndex + CHAIN_SEPARATOR_LENGTH).trim();
        }
        return null;
    }


    /**
     * Prepares the edit command by checking the userInput.
     *
     * @param userInput description of the edit command
     * @return EditFoodCommand or EditExerciseCommand
     */
    private Command prepareEditActivityCommand(String userInput) {
        String[] arguments = userInput.split(SPACE, 2);
        int index = Integer.parseInt(arguments[0]) - 1;
        userInput = arguments[1];

        try {
            if (userInput.startsWith(FOOD_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);
                int calories = Integer.parseInt(userInput.substring(calorieIndex + ALPHABET_WITH_SLASH).trim());
                if (calories < 0) {
                    throw new Exception();
                }

                String foodDescription = userInput.substring(ALPHABET_WITH_SLASH, calorieIndex - 1).trim();

                displayEditMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new EditFoodCommand(index, foodDescription, calories);
            } else if (userInput.startsWith(EXERCISE_TAG)) {
                int calorieIndex = userInput.indexOf(CALORIE_TAG);
                int calories = Integer.parseInt(userInput.substring(calorieIndex + ALPHABET_WITH_SLASH).trim());
                if (calories < 0) {
                    throw new Exception();
                }

                String exerciseDescription = userInput.substring(ALPHABET_WITH_SLASH, calorieIndex - 1).trim();

                displayEditMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new EditExerciseCommand(index, exerciseDescription, calories);
            } else {
                displayEmptyEditActivityErrorMessage();
            }
        } catch (NullPointerException e) {
            displayEditActivityExceptionMessage();
        } catch (NumberFormatException e) {
            displayEditActivityExceptionMessage();
        } catch (Exception e) {
            displayEditActivityExceptionMessage();
        }
        return null;
    }

    /**
     * Prepares the add command by checking the userInput.
     *
     * @param userInput description of the add command
     * @return AddFoodCommand or AddExerciseCommand
     */
    private Command prepareAddCommand(String userInput) {
        try {
            String[] arguments = userInput.split(SPACE, 2);
            if (arguments[1].startsWith(FOOD_TAG)) {
                int calorieIndex = arguments[1].indexOf(CALORIE_TAG);
                int dateIndex = arguments[1].indexOf(DATE_TAG);

                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH,
                        dateIndex).trim());
                if (calories < 0) {
                    throw new Exception();
                }

                LocalDate date = processDate(arguments[1].substring(dateIndex + ALPHABET_WITH_SLASH).trim());
                String foodDescription = arguments[1].substring(ALPHABET_WITH_SLASH, calorieIndex - 1).trim();

                displayAddMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(foodDescription, calories, FALSE, date);
            } else if (arguments[1].startsWith(EXERCISE_TAG)) {
                int calorieIndex = arguments[1].indexOf(CALORIE_TAG);
                int dateIndex = arguments[1].indexOf(DATE_TAG);

                int calories = Integer.parseInt(arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH,
                        dateIndex).trim());
                if (calories < 0) {
                    throw new Exception();
                }

                LocalDate date = processDate(arguments[1].substring(dateIndex + ALPHABET_WITH_SLASH).trim());
                String exerciseDescription = arguments[1].substring(ALPHABET_WITH_SLASH, calorieIndex - 1).trim();

                displayAddMessage();

                assert calories > 0 : "calories should be greater than 0";
                return new AddExerciseCommand(exerciseDescription, calories, FALSE, date);
            } else {
                displayEmptyAddActivityErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayAddCommandErrorMessage();
        } catch (NumberFormatException e) {
            displayAddActivityExceptionMessage();
        } catch (DateTimeParseException e) {
            displayIncorrectDateTimeFormatEnteredMessage();
        } catch (Exception e) {
            displayAddActivityExceptionMessage();
        }
        return null;
    }

    private Command prepareMoveIndexCommand(String userInput) throws IndexOutOfBoundsException {
        //Removing additional spaces in the user's input
        String after = userInput.trim().replaceAll(" +", " ");
        String firstIndexKey = "from/";
        String secondIndexKey = "below/";

        int firstIndex = after.indexOf(firstIndexKey) + firstIndexKey.length(); //index after first keyword
        int secondIndex = after.indexOf(secondIndexKey) + secondIndexKey.length(); //index after second keyword

        String firstIndexString = after.substring(firstIndex).trim().split(" ")[0];
        String secondIndexString = after.substring(secondIndex).trim().split(" ")[0];
        int indexToBeChanged = 0;
        int indexToBeInsertedBelow = 0;
        try {
            indexToBeChanged = Integer.parseInt(firstIndexString);
            indexToBeInsertedBelow = Integer.parseInt(secondIndexString);
            return new MoveActivityCommand(indexToBeChanged, indexToBeInsertedBelow);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid index!");
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
        LocalDate dateTime = LocalDate.parse(dateInput);

        return dateTime;
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
     * Prepares the list command by checking the userInput.
     *
     * @param userInput description of the list command
     * @return ListCommand
     */
    private Command prepareListCommand(String userInput) {

        if (userInput.toLowerCase().equals("list")) {
            return new ListCommand();
        } else {
            String dateString = userInput.split(" ")[1];
            try {
                LocalDate date = processDate(dateString);
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
     * @param userInput description of the delete command
     * @return DeleteCommand
     */
    private Command prepareDeleteCommand(String userInput) {
        try {
            if (userInput.equals("all/")) {
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
     * @param userInput description of the find command
     * @return FindCalorieCommand
     */
    private Command prepareFindCommand(String userInput) {
        try {
            String[] arguments = userInput.split(" ", 2);
            if (arguments[1].startsWith("d/")) {
                String description = arguments[1].substring(2).trim();
                return new FindDescriptionCommand(description);
            } else if (arguments[1].startsWith(CALORIE_TAG)) {
                String calorie = arguments[1].substring(2).trim();
                return new FindCalorieCommand(calorie);
            } else if (arguments[1].startsWith("a/")) {
                return new FindAllCommand(arguments[1]);
            } else if (arguments[1].startsWith("e/")) {
                return new FindEitherCommand(arguments[1]);
            } else {
                displayFindErrorMessage();
            }
        } catch (NullPointerException | StringIndexOutOfBoundsException e) {
            displayFindErrorMessage();
        }
        return null;
    }

    private Command prepareGraphCommand(String[] userInput) throws Exception {
        if (userInput.length != 1) {
            throw new Exception("Graph has has no description");
        }
        if (Trakcal.calList.getHashMap().size() == 0) {
            throw new Exception("No records found!");
        }
        return new GraphCommand();
    }


}
