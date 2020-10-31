package seedu.duke.ui;

import static seedu.duke.ui.Ui.drawDivider;
import static seedu.duke.ui.Ui.promptUserOfHelpMessage;

/**
 * Deals with error/exception messages.
 */
public class ExceptionMessages {
    /**
     * Prints error message when StringIndexOutOfBoundsException occurs.
     */
    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        drawDivider();
        String exceptionMessage = "The index entered is not within the range!";
        System.out.println(exceptionMessage);
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when IOException occurs.
     */
    public static void displayIoExceptionMessage() {
        drawDivider();
        System.out.println("IO Exception has occurred!");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when NumberFormatException occurs in delete command.
     */
    public static void displayDeleteCommandNumberFormatExceptionMessage() {
        drawDivider();
        System.out.println("Index is not a number!");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when NullPointerException occurs in delete command.
     */
    public static void displayDeleteCommandNullPointerExceptionMessage() {
        drawDivider();
        System.out.println("There is not index to remove");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when attempting to access an empty list.
     */
    public static void displayListNotFoundExceptionMessage() {
        drawDivider();
        System.out.println("The list to work on is empty!" + "\nTry entering a list command first.");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when NullPointerException occurs in Parser.
     */
    public static void displayParserNullPointerExceptionMessage() {
        drawDivider();
        System.out.println("Invalid command!");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints error message when error occurs in add command.
     */
    public static void displayAddCommandErrorMessage() {
        drawDivider();
        System.out.println("Invalid input given!");
        System.out.println("The input format for adding food activity is 'add f/ X c/ Y d/ Z\n"
                + " - where food is X, calories lost is Y and date(YYYY-MM-DD) is Z");
        System.out.println("The input format for adding exercise activity is 'add e/ X c/ Y d/ Z\n"
                + " - where exercise done is X, calories lost is Y and date(YYYY-MM-DD) is Z");
        System.out.println("If this is still too confusing for you, please do input 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints error message when error occurs in find command.
     */
    public static void displayFindErrorMessage() {
        drawDivider();
        System.out.println("I do not understand what you mean!");
        System.out.println("The input format for finding food or exercise activity via keyword is 'find d/ X'\n"
                + " - where keyword is X");
        System.out.println("The input format for finding calorie count via keyword is 'find c/ X'\n"
                + " - where calories count is X");
        System.out.println("Please do input 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints out error message when date and time format entered is wrong.
     */
    public static void displayIncorrectDateTimeFormatEnteredMessage() {
        drawDivider();
        System.out.println("Wrong format of date entered!");
        System.out.println("The accepted format is YYYY-MM-DD!");
        System.out.println("Also, ensure that the date input actually exists!");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints out error message when invalid input for add activity given.
     */
    public static void displayAddActivityExceptionMessage() {
        drawDivider();
        System.out.println("Sorry I do not understand what you mean!");
        System.out.println("One of the following has been violated:");
        System.out.println("\t1. Description or calories input cannot be empty");
        System.out.println("\t2. Calories count input must be an integer > 0!");
        System.out.println("\t3. Wrong input format");
        System.out.println("\t\tInput format is:");
        System.out.println("\t\tadd f/ FOOD_DESCRIPTION c/ CALORIES d/ YYYY-MM-DD");
        System.out.println("\t\tadd e/ EXERCISE_DESCRIPTION c/ CALORIES d/ YYYY-MM-DD");
        drawDivider();
    }

    /**
     * Prints out error message when invalid input for add activity given.
     */
    public static void displayEditActivityExceptionMessage() {
        drawDivider();
        System.out.println("Sorry I do not understand what you mean!");
        System.out.println("One of the following has been violated:");
        System.out.println("\t1. Description or calories input cannot be empty");
        System.out.println("\t2. Calories count input must be an integer > 0!");
        System.out.println("\t3. Wrong input format");
        System.out.println("\t\tInput format is:");
        System.out.println("\t\tedita INDEX f/ FOOD_DESCRIPTION c/ CALORIES");
        System.out.println("\t\tedita INDEX e/ EXERCISE_DESCRIPTION c/ CALORIES");
        drawDivider();
    }

    /**
     * Prints out error message when attributes input by user is empty.
     */
    public static void displayEmptyAddActivityErrorMessage() {
        drawDivider();
        System.out.println("Sorry! There is missing input!");
        drawDivider();
    }

    /**
     * Prints out error message when input of user is not understood.
     */
    public static void displayInvalidInputErrorMessage() {
        drawDivider();
        System.out.println("Sorry I do not understand the input given!");
        System.out.println("Perhaps pulling out help list via input 'help' may help.");
        drawDivider();
    }

    /**
     * Prints out error message when invalid activity factor input.
     */
    public static void displayInvalidActivityFactorMessage() {
        drawDivider();
        System.out.println("Sorry this is an invalid activity factor!");
        System.out.println("Please enter an integer from 1 to 5, with 1 being the least "
                + "active and 5 being the most active\n");
    }

    /**
     * Prints out error message when DateTimeException occurs.
     */
    public static void displayDateTimeExceptionMessage() {
        drawDivider();
        System.out.println("Sorry, I do not understand!");
        System.out.println("The input format of date is YYYY-MM-DD.");
    }

    /**
     * Prints out error message when attributes input by user is empty.
     */
    public static void displayEmptyEditActivityErrorMessage() {
        drawDivider();
        System.out.println("Sorry! There is missing input!");
        drawDivider();
    }

    /**
     * Prints message when there is a presence of a duplicated naming for file.
     */
    public static void displayExistingFileMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Sorry! There is an existing set with this name, please use another name!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid gender input.
     */
    public static void displayInvalidGenderMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please input female or male as gender only!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid weight goal input.
     */
    public static void displayInvalidWeightGoalMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please input lose or maintain or gain as weight goal only!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid weight input.
     */
    public static void displayInvalidWeightMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter a valid weight format!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid height input.
     */
    public static void displayInvalidHeightMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter a valid height format!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid age input.
     */
    public static void displayInvalidAgeMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter a valid age!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when invalid activity level input.
     */
    public static void displayInvalidActivityLevelMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please integer for activity level only!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when IndexOutOfBoundsException occurs in edit command.
     */
    public static void displayEditIndexOutOfBoundsExceptionMessage() {
        drawDivider();
        System.out.println("Index entered is not within the range!\n"
                + "Please pull out the list for the day before editing on it!");
        drawDivider();
    }

    /**
     * Prints out error message when a shortcut has not been created in addSet command.
     */
    public static void displayShortcutDoesNotExistMessage() {
        System.out.println();
        drawDivider();
        System.out.println("This shortcut does not exists, please create a shortcut before adding it!");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when calorie has not been input as integer.
     */
    public static void displayInvalidCalorieEntryMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter calories as an integer");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when weight range is not between 20 to 650kg.
     */
    public static void displayInvalidWeightRangeMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter a weight range from 20kg to 650kg");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when age is not between 0 to 120 years old.
     */
    public static void displayInvalidAgeRangeMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter an age range from 1 to 120 years old");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when height is not between 10 to 300cm.
     */
    public static void displayInvalidHeightRangeMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter a height range from 10cm to 300cm");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when activity level from 1 to 5.
     */
    public static void displayInvalidActivityLevelRangeMessage() {
        System.out.println();
        drawDivider();
        System.out.println("Please enter an activity level from 1 to 5 only");
        drawDivider();
        System.out.println();
    }

    /**
     * Prints out error message when calorie count too big or small.
     */
    public static void displayCalorieCountOutOfBound() {
        drawDivider();
        System.out.println("Calorie count should be > 0 and <= 3000!");
        drawDivider();
    }

    /**
     * Prints out error message when activity level from 1 to 5.
     */
    public static void displayEmptyInput() {
        drawDivider();
        System.out.println("Empty description!");
        drawDivider();
    }

    /**
     * Prints out error message for invalid number for delete command.
     */
    public static void displayDeleteCommandStringOutOfBoundExceptionMessage() {
        drawDivider();
        System.out.println("Invalid index!");
        drawDivider();
    }


}
