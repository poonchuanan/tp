package seedu.duke.ui;

/**
 * Deals with interactions with the user.
 */
public class Ui {
    /**
     * Prints out welcome message to user when program is run.
     */
    public static void displayWelcomeMessage() {
        displayDuke();
        helloMessage();
        promptUserOfHelpMessage();
    }

    /**
     * Prints out traKCAL logo.
     */
    public static void displayDuke() {
        drawDivider();
        String logo = "|  _                  _  __   ___     _     _"
                + "                                                       |\n"
                + "| | |_   _ _   __ _  | |/ /  / __|   /_\\   | |"
                + "                                                      |\n"
                + "| |  _| | '_| / _` | | ' <  | (__   / _ \\  | |__"
                + "                                                    |\n"
                + "|  \\__| |_|   \\__,_| |_|\\_\\  \\___| /_/ \\_\\ |____|"
                + "                                                   |\n"
                + "|                                                  "
                + "                                                 |";
        System.out.println("| Hello from"
                + "                                                                                        |\n"
                + logo);
    }

    /**
     * Prints out a line divider.
     */
    public static void drawDivider() {
        String divider = "===================================================================================="
                 + "=================";
        System.out.println(divider);
    }

    /**
     * Prints out hello message.
     */
    public static void helloMessage() {
        System.out.println("| Hello! I'm traKCAL."
                + "                                                                               |");
        drawDivider();
    }

    /**
     * Prints out help list showing the commands available.
     */
    public static void displayHelpMessage() {
        drawDivider();
        String helpList = "Commands available: create new user, list, help, add, delete, find, bye\n"
                + "\n"
                + "The expected format of input values:\n"
                + "\tcreate new user        - Creates a new user profile\n"
                + "\ttarget CALORIE         - Adds a target calorie, CALORIE\n"
                + "\thelp                   - Prints out commands available and their input format\n"
                + "\tadd f/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE\n"
                + "\t                       - Adds food consumed, FOOD_DESCRIPTION calories gained, CALORIE_COUNT\n"
                + "\t                         and date(YYYY-MM-DD), DATE\n"
                + "\tadd e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE\n"
                + "\t                       - Adds exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT\n"
                + "\t                         and date(YYYY-MM-DD), DATE\n"
                + "\tlist                   - Prints out the list of entries.\n"
                + "\tlist DATE              - Prints out the list of entries for the date(YYYY-MM-DD), DATE\n"
                + "\tedit n/ NAME, g/ GENDER, w/ WEIGHT, h/HEIGHT, a/ AGE, af/ ACTIVITY_FACTOR, goal/ WEIGHT_GOALS\n"
                + "\t                       - Edits your name, NAME, your gender(male/female), GENDER,\n"
                + "\t                         your weight in kg, WEIGHT, your height, HEIGHT in cm, your age, AGE,\n"
                + "\t                         activity factor(1-5) with 1 being the most active, ACTIVITY_FACTOR,\n"
                + "\t                         your weight goals(lose/maintain/gain), WEIGHT_GOALS\n"
                + "\tedita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT\n"
                + "\t                       - Edits activity at index LIST_INDEX of latest list printed out\n"
                + "\t                         to food consumed, FOOD_DESCRIPTION, calories gained, CALORIE_COUNT\n"
                + "\tedita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT\n"
                + "\t                       - Edits activity at index LIST_INDEX of latest list printed out\n"
                + "\t                         to exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT\n"
                + "\tfind d/ DESCRIPTION    - Searches for exercise/food description with DESCRIPTION included\n"
                + "\tfind c/ CALORIE_COUNT  - Searches through activity list with calories of CALORIE_COUNT\n"
                + "\tmove from/ INDEX1 below/ INDEX2\n"
                + "\t                       - Moves the activity at index INDEX1 to the index below INDEX2\n"
                + "\tdelete LIST_INDEX      - Deletes activity located at index LIST_INDEX of latest list printed out\n"
                + "\tbye                    - Terminates the program"
                + "\n"
                + "Words in CAPS are parameters to be filled in by you!\n";
        System.out.println(helpList);
        drawDivider();
    }

    /**
     * Prints out acknowledgement of saving current activity list in file.
     */
    public static void displaySavedMessage() {
        System.out.println("The current activity list has been saved.");
    }

    /**
     * Prints out error in saving current activity list in file.
     */
    public static void displayNotSavedMessage() {
        System.out.println("The current activity list has not been saved.");
        System.out.println("An error has occurred!");
        promptUserOfHelpMessage();
        System.out.println();
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
        System.out.println("| Thank you for using traKCAL. See you again!"
                + "                                                       |");
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

    public static void displayAskUserGenderMessage() {
        System.out.println("What is your gender (male/female)?");
    }

    public static void displayAskUserWeightGoalMessage() {
        System.out.println("Do you want to lose/maintain/gain weight?");
    }

    public static void displayAskUserWeightMessage() {
        System.out.println("What is your weight in kg?");
    }

    public static void displayAskUserHeightMessage() {
        System.out.println("What is your height in cm?");
    }

    public static void displayAskUserAgeMessage() {
        System.out.println("What is your age?");
    }

    public static void displayAskUserActivityLevelMessage() {
        System.out.println("How active are you on a scale of 1-5? With 1 being least active and 5 being most active.");
    }

}
