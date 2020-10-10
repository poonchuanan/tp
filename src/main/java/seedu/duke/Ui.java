package seedu.duke;

/**
 * Deals with interactions with the user.
 */
public class Ui {
    /**
     * Prints out Duke logo.
     */
    public static void displayDuke() {
        drawDivider();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
    }

    /**
     * Prints out a line divider.
     */
    public static void drawDivider() {
        String divider = "==============================================================";
        System.out.println(divider);
    }

    /**
     * Prints out hello message.
     */
    public static void helloMessage() {
        System.out.println("Hello! I'm traKCAL.");
        drawDivider();
    }

    /**
     * Prints out commands available.
     */
    public static void displayHelpMessage() {
        drawDivider();
        String helpList = "Commands available: create new user, list, help, add, delete, find, bye\n"
                + "The expected format of input values: \n"
                + "\tcreate new user - Adds a new user profile"
                + "\ttarget X - Adds a target calorie, X\n"
                + "\thelp - Prints out commands available and their input format\n"
                + "\tadd f/ X c/ Y - Adds food/drinks consumed, X and the calories gained, Y\n"
                + "\tadd e/ X c/ Y - Adds exercise done, X and the calories gained, Y\n"
                + "\tlist - Prints out the list of entries.\n"
                + "\tedit n/W, g/X, w/Y, h/Z - Edit user profile to name, W, gender, X, weight, Y and height Z\n"
                + "\tfind d/ X - Searches for exercise/food description with X included\n"
                + "\tfind c/ X - Searches for activity description with calories of X\n"
                + "\tdelete X - Deletes activity located at index X of the list\n"
                + "\tbye - Terminates the program";
        System.out.println(helpList);
        drawDivider();
    }

    /**
     * Prints out welcome message to user when program is run.
     */
    public static void displayWelcomeMessage() {
        displayDuke();
        displayHelpMessage();
        helloMessage();
    }

    /**
     * Prints out acknowledgement of saving current activity list in file.
     */
    public static void displaySaveMessage() {
        System.out.println("The current activity list has been saved.");
        System.out.println();
    }

    /**
     * Prints out error in saving current activity list in file.
     */
    public static void displayNotSavedMessage() {
        System.out.println("The current activity list has not been saved.");
    }

    public static void displayDefaultMessage() {
        drawDivider();
        System.out.println("Invalid command. Please type 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints out bye message and let the user know that the current list has been saved to file.
     */
    public static void displayByeMessage() {
        drawDivider();
        System.out.println("THank you for using TraKCAL. See you again!");
        drawDivider();
    }

    /**
     * Prints out message to recommend user to print out help list.
     */
    public static void promptUserOfHelpMessage() {
        System.out.println("Please do input 'help' for the commands and their respective input format.");
    }

    /**
     * Prints out message when list command given but activity list is empty.
     */
    public static void displayEmptyActivityCounterMessage() {
        System.out.println("Nothing was added!");
    }

    /**
     * Prints error message when StringIndexOutOfBoundsException occurs.
     */
    public static void displayStringIndexOutOfBoundsExceptionMessage() {
        drawDivider();
        String exceptionMessage = "Something went wrong!! I do not understand what you mean.\n"
                + "There could be an error in the way of input.";
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
        System.out.println("The input format for adding food activity is 'add f/ X c/ Y'"
                + " - where food is X and calories gained is Y ");
        System.out.println("The input format for adding exercise activity is 'add e/ X c/ Y'"
                + " - where exercise done is X and calories gained is Y ");
        System.out.println("Please do input 'help' for more information.");
        drawDivider();
    }

    /**
     * Prints error message when error occurs in find command.
     */
    public static void displayFindErrorMessage() {
        drawDivider();
        System.out.println("I do not understand what you mean!");
        System.out.println("The input format for finding food or exercise activity via keyword is 'find d/ X'"
                + " - where keyword is X");
        System.out.println("The input format for finding calorie count via keyword is 'find c/ X'"
                + " - where calories count is X");
        System.out.println("Please do input 'help' for more information.");
        drawDivider();
    }
}
