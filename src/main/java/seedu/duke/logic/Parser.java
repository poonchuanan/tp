package seedu.duke.logic;

import seedu.duke.Trakcal;
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
import seedu.duke.command.GraphCommand;
import seedu.duke.command.HelpCommand;
import seedu.duke.command.InvalidCommand;
import seedu.duke.command.ListCommand;

import seedu.duke.command.ListUserProfileCommand;
import seedu.duke.command.MoveActivityCommand;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.CalorieTagNotFoundException;
import seedu.duke.exception.DateLimitException;
import seedu.duke.exception.DescriptionLengthExceedException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.InvalidCalorieException;
import seedu.duke.ui.ExceptionMessages;
import seedu.duke.userprofile.UserProfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.time.format.DateTimeParseException;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;
import static seedu.duke.ui.ExceptionMessages.displayAddActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayAddCommandErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieCountOutOfBoundMessage;
import static seedu.duke.ui.ExceptionMessages.displayCalorieTagNotFoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDateLimitExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDateTimeExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNullPointerExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandNumberFormatExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDeleteCommandStringOutOfBoundExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayDescriptionLengthExceedExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEditActivityExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyAddActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyEditActivityErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayEmptyDescriptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayFindErrorMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidCalorieExceptionMessage;
import static seedu.duke.ui.ExceptionMessages.displayInvalidInputErrorMessage;
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

    protected static final int ALPHABET_WITH_SLASH_LENGTH = 2;
    public static final String SPACE = " ";
    public static final String CHAIN_SEPARATOR = "&&";
    protected static final int CHAIN_SEPARATOR_LENGTH = 2;

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
                return prepareEditUserProfile(arguments[1]);
            case "edita":
                return prepareEditActivityCommand(arguments[1]);
            case "delete":
                return prepareDeleteCommand(arguments[1]);
            case "list":
                return prepareListCommand(userInput);
            case "listup":
                return prepareListUserProfileCommand();
            case "help":
                return new HelpCommand();
            case "move":
                return prepareMoveIndexCommand(userInput);
            case "bye":
                return new ByeCommand();
            case "graph":
                return prepareGraphCommand(arguments);
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

    private Command prepareEditUserProfile(String userInput) throws IOException {
        UserProfile.edit(userInput);
        return new EditUserProfileCommand();
    }

    /**
     * Prepares chained input by user into their respective commands to be read.
     *
     * @param userInput input given by user
     * @return null
     */
    public Command prepareChaining(String userInput) {
        while (userInput.contains(CHAIN_SEPARATOR)) {
            if (!(userInput.endsWith(CHAIN_SEPARATOR))) {
                userInput = userInput + SPACE + CHAIN_SEPARATOR;
            }
            int chainIndex = userInput.indexOf(CHAIN_SEPARATOR);

            String firstString = userInput.substring(0, chainIndex).trim();

            Parser parser = new Parser(firstString);
            Command cmd = parser.parseCommand();

            if (cmd.getCanBeChained()) {
                executeCmd(cmd);
            } else {
                System.out.println("'" + firstString + "' cannot be chained!");
                break;
            }
            storage.updateFile(calList);

            userInput = userInput.substring(chainIndex + CHAIN_SEPARATOR_LENGTH).trim();
        }
        return null;
    }

    private Command prepareListUserProfileCommand() throws IOException {
        String initialPath = new File("").getAbsolutePath();
        String filePath = initialPath + "/tp.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();

        System.out.println("Here is your user profile:");
        System.out.println("Name : " + line);
        line = reader.readLine();
        System.out.println("Gender : " + line);
        line = reader.readLine();
        System.out.println("Weight : " + line);
        line = reader.readLine();
        System.out.println("Height : " + line);
        line = reader.readLine();
        System.out.println("Age : " + line);
        line = reader.readLine();
        System.out.println("Activity Level : " + line);
        line = reader.readLine();
        System.out.println("Weight Goal : " + line + "\n");
        reader.close();

        return new ListUserProfileCommand();
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
                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    foodDescription = userInput.substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionValid(foodDescription)
                        && isDescriptionLengthValid(foodDescription);

                String calorieInput = userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesValid(calories);

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
                isDescriptionInputValid = isDescriptionValid(exerciseDescription)
                        && isDescriptionLengthValid(exerciseDescription);

                String calorieInput = userInput.substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesValid(calories);

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
        } catch (EmptyDescriptionException e) {
            displayEmptyDescriptionMessage();
        } catch (CalorieTagNotFoundException e) {
            displayCalorieTagNotFoundExceptionMessage();
        } catch (InvalidCalorieException e) {
            displayInvalidCalorieExceptionMessage();
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
     * Checks if the calorie input is within accepted range.
     *
     * @param calorie calories input by user
     * @return true is calorie is within range
     * @throws CalorieCountException if calorie not within range
     */
    public boolean isCaloriesValid(int calorie) throws CalorieCountException {
        if (calorie <= 0 || calorie > 3000) {
            throw new CalorieCountException();
        } else {
            return true;
        }
    }

    /**
     * Checks if the description is filled.
     *
     * @param description description input by user
     * @return true if no error in description input
     * @throws EmptyDescriptionException if description input has error
     */
    public boolean isDescriptionValid(String description) throws EmptyDescriptionException {
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
    public boolean isDescriptionLengthValid(String description) throws DescriptionLengthExceedException {
        if (description.length() >= 40) {
            throw new DescriptionLengthExceedException();
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
        LocalDate past = processDate("2020-11-01");
        if (date.isAfter(current)) {
            throw new DateLimitException();
        } else if (date.isBefore(past)) {
            throw new DateLimitException();
        } else {
            return date;
        }
    }

    /**
     * Checks if calorie input by user is empty
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
                String foodDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    foodDescription = arguments[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionValid(foodDescription)
                        && isDescriptionLengthValid(foodDescription);

                int dateIndex = arguments[1].indexOf(DATE_TAG);
                String calorieInput;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calorieInput = arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                } else {
                    calorieInput = arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH, dateIndex).trim();
                }

                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesValid(calories);

                LocalDate date;
                if (isCalorieValid && isDescriptionInputValid && dateIndex == INDEX_NOT_FOUND) {
                    date = currentDate();
                } else {
                    date = checkDateValidity(arguments[1], dateIndex);
                }

                if (isDescriptionInputValid && isCalorieValid) {
                    displayAddMessage();
                } else {
                    throw new Exception();
                }

                assert calories > 0 : "calories should be greater than 0";
                return new AddFoodCommand(foodDescription, calories, FALSE, date);
            } else if (arguments[1].startsWith(EXERCISE_TAG)) {
                int calorieIndex = arguments[1].indexOf(CALORIE_TAG);
                String exerciseDescription;
                if (calorieIndex == INDEX_NOT_FOUND) {
                    throw new CalorieTagNotFoundException();
                } else {
                    exerciseDescription = arguments[1].substring(ALPHABET_WITH_SLASH_LENGTH, calorieIndex - 1).trim();
                }

                boolean isDescriptionInputValid;
                isDescriptionInputValid = isDescriptionValid(exerciseDescription)
                        && isDescriptionLengthValid(exerciseDescription);

                int dateIndex = arguments[1].indexOf(DATE_TAG);
                String calorieInput;
                if (dateIndex == INDEX_NOT_FOUND) {
                    calorieInput = arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH).trim();
                } else {
                    calorieInput = arguments[1].substring(calorieIndex + ALPHABET_WITH_SLASH_LENGTH, dateIndex).trim();
                }

                int calories = parseCalorie(calorieInput);
                boolean isCalorieValid = isCaloriesValid(calories);

                LocalDate date;
                if (isCalorieValid && isDescriptionInputValid && dateIndex == INDEX_NOT_FOUND) {
                    date = currentDate();
                } else {
                    date = checkDateValidity(arguments[1], dateIndex);
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
     * Prepares the arguments needed for moving an activity from one index to another.
     *
     * @param userInput description of the move command
     * @return the moveCommand
     * @throws IndexOutOfBoundsException if the index is not valid
     */
    private Command prepareMoveIndexCommand(String userInput) throws IndexOutOfBoundsException {
        //Removing additional spaces in the user's input
        String after = userInput.trim().replaceAll(" +", " ");
        String firstIndexKey = "from/";
        String secondIndexKey = "below/";


        int firstIndex = after.indexOf(firstIndexKey) + firstIndexKey.length(); //index after first keyword
        int secondIndex = after.indexOf(secondIndexKey) + secondIndexKey.length(); //index after second keyword

        if (!after.contains(firstIndexKey) && !after.contains(secondIndexKey)) {
            return new InvalidCommand("'from/' and 'below/' keyword is missing!");
        } else if (!after.contains(firstIndexKey)) {
            return new InvalidCommand("'from/' keyword is missing!");
        } else if (!after.contains(secondIndexKey)) {
            return new InvalidCommand("'below/' keyword is missing!");
        }


        String firstIndexString = after.substring(firstIndex).trim().split(SPACE)[0];
        String secondIndexString = after.substring(secondIndex).trim().split(SPACE)[0];
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
     * Prepares the list command by checking the userInput.
     *
     * @param userInput description of the list command
     * @return ListCommand
     */
    private Command prepareListCommand(String userInput) {

        if (userInput.toLowerCase().equals("list")) {
            return new ListCommand();
        } else {
            String dateString = userInput.split(SPACE)[1];
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
                checkIndex(index);
                return new DeleteCommand(index);
            }
        } catch (NumberFormatException e) {
            displayDeleteCommandNumberFormatExceptionMessage();
        } catch (NullPointerException e) {
            displayDeleteCommandNullPointerExceptionMessage();
        } catch (IndexOutOfBoundsException e) {
            displayDeleteCommandStringOutOfBoundExceptionMessage();
        }
        return null;
    }

    /** Checks for index of the delete command.
     *
     * @param index index of the delete command
     * @throws IndexOutOfBoundsException if index is below 0
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
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
            String[] arguments = userInput.split(SPACE, 2);
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

    /**
     * Prepares the arguments needed for the graph command.
     *
     * @param userInput description of the graph command
     * @return graphCommand
     * @throws Exception if no records are found
     */
    private Command prepareGraphCommand(String[] userInput) throws Exception {
        if (userInput.length != 1) {
            throw new Exception("Graph has no description");
        }
        if (Trakcal.calList.getHashMap().size() == 0) {
            throw new Exception("No records found!");
        }
        return new GraphCommand();
    }


}
