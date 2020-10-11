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
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
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
                + "The expected format of input values:\n"
                + "\tcreate new user - Adds a new user profile\n"
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

}
