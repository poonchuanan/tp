package seedu.duke;

import static seedu.duke.Ui.drawDivider;
import static seedu.duke.Ui.promptUserOfHelpMessage;

/**
 * Deals with error/exception messages.
 */
public class ExceptionMessages {
    /**
     * Prints error message when StringIndexOutOfBoundsException occurs.
     */
    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        drawDivider();
        String exceptionMessage = "Something went wrong!! I do not understand what you mean.\n" + "There could be an error in the way of input.";
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
        System.out.println("The input format for adding food activity is 'add f/ X c/ Y d/ Z" + " - where food is X, calories lost is Y and date(YYYY-MM-DD) is Z");
        System.out.println("The input format for adding exercise activity is 'add e/ X c/ Y d/ Z'" + " - where exercise done is X, calories lost is Y and date(YYYY-MM-DD) is Z");
        System.out.println("Please do input 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints error message when error occurs in find command.
     */
    public static void displayFindErrorMessage() {
        drawDivider();
        System.out.println("I do not understand what you mean!");
        System.out.println("The input format for finding food or exercise activity via keyword is 'find d/ X'" + " - where keyword is X");
        System.out.println("The input format for finding calorie count via keyword is 'find c/ X'" + " - where calories count is X");
        System.out.println("Please do input 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints out error message when date and time format entered is wrong.
     */
    public static void displayIncorrectDateTimeFormatEnteredMessage() {
        drawDivider();
        System.out.println("Wrong format of date entered!");
        promptUserOfHelpMessage();
        drawDivider();
    }

    /**
     * Prints out error message when invalid input for add activity given.
     */
    public static void displayAddActivityNumberFormatExceptionMessage() {
        drawDivider();
        System.out.println("Sorry I do not understand what you mean!");
        System.out.println("One of the following has been violated:");
        System.out.println("\t1. Description or calories input cannot be empty");
        System.out.println("\t2. Calories count input must be an integer > 0!");
        System.out.println("\t3. Input format is:");
        System.out.println("\t\tadd f/ X c/ Y");
        System.out.println("\t\tadd e/ X c/ Y");
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
        System.out.println("Please enter an integer from 1 to 5, with 1 being the least " + "active and 5 being the most active\n");
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
}
