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
        String helpList = "This section displays the commands available and their respective input format.\n"
                + "> Words in CAPS are parameters to be filled in by you!\n"
                + "\n"
                + "Viewing help:\n"
                + "help                   - Prints out commands available and their input format\n"
                + "\n"
                + "Creating:\n"
                + "create new user        - Creates a new user profile\n"
                + "\n"
                + "Shortcut:\n"
                + "createSet SHORTCUT_NAME f/ FOOD_DESCRIPTION c/ CALORIE_COUNT +\n"
                + "e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT + ...\n"
                + "                       - Creates shortcut for adding food(s) and/or exercise(s) depending on the\n"
                + "                         format entered\n"
                + "addSet SHORTCUT_NAME   - Adds SHORTCUT_NAME into current date list\n"
                + "\n"
                + "Adding:\n"
                + "add f/ FOOD_DESCRIPTION c/ CALORIE_COUNT d/ DATE\n"
                + "                       - Adds food consumed, FOOD_DESCRIPTION calories gained, CALORIE_COUNT\n"
                + "                         and date(YYYY-MM-DD), DATE\n"
                + "add e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT d/ DATE\n"
                + "                       - Adds exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT\n"
                + "                         and date(YYYY-MM-DD), DATE\n"
                + "\n"
                + "Listing:\n"
                + "list                   - Prints out the list of entries.\n"
                + "list DATE              - Prints out the list of entries for the date(YYYY-MM-DD), DATE\n"
                + "\n"
                + "Editing:\n"
                + "edit n/ NAME, g/ GENDER, w/ WEIGHT, h/ HEIGHT, a/ AGE, af/ ACTIVITY_FACTOR, goal/ WEIGHT_GOALS\n"
                + "                       - Edits your name, NAME, your gender(male/female), GENDER,\n"
                + "                         your weight in kg, WEIGHT, your height, HEIGHT in cm, your age, AGE,\n"
                + "                         activity factor(1-5) with 1 being the most active, ACTIVITY_FACTOR,\n"
                + "                         your weight goals(lose/maintain/gain), WEIGHT_GOALS\n"
                + "edita LIST_INDEX f/ FOOD_DESCRIPTION c/ CALORIE_COUNT\n"
                + "                       - Edits activity at index LIST_INDEX of latest list printed out\n"
                + "                         to food consumed, FOOD_DESCRIPTION, calories gained, CALORIE_COUNT\n"
                + "edita LIST_INDEX e/ EXERCISE_DESCRIPTION c/ CALORIE_COUNT\n"
                + "                       - Edits activity at index LIST_INDEX of latest list printed out\n"
                + "                         to exercise done, EXERCISE_DESCRIPTION, calories lost, CALORIE_COUNT\n"
                + "\n"
                + "Finding:\n"
                + "find d/ DESCRIPTION    - Searches for all activities description with the DESCRIPTION keyword\n"
                + "find c/ CALORIE_COUNT  - Searches for all activities with calories of CALORIE_COUNT\n"
                + "find a/ DESCRIPTION1 / DESCRIPTION2 .../ DESCRIPTION\n"
                + "                        - Searches for all activities with ALL matching keywords from\n"
                + "                          DESCRIPTION1 to DESCRIPTION\n"
                + "find e/ DESCRIPTION1 / DESCRIPTION2 .../ DESCRIPTION\n"
                + "                        - Searches for all activities with AT LEAST one matching keyword from\n"
                + "                          DESCRIPTION1 to DESCRIPTION\n"
                + "\n"
                + "Moving:\n"
                + "move from/ INDEX1 below/ INDEX2\n"
                + "                       - Moves the activity at index INDEX1 to the index below INDEX2\n"
                + "\n"
                + "Deleting:\n"
                + "delete LIST_INDEX      - Deletes activity located at index LIST_INDEX of latest list printed out\n"
                + "delete all/            - Deletes all activities in current date list\n"
                + "\n"
                + "Graphing:\n"
                + "graph                  - Generates a graph of target calorie and net calorie obtained up to\n"
                + "                         last 7 days\n"
                + "\n"
                + "Exiting:\n"
                + "bye                    - Terminates the application\n";
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

    /**
     * Prints out message asking for gender.
     */
    public static void displayAskUserGenderMessage() {
        System.out.println("What is your gender (male/female)?");
    }

    /**
     * Prints out message asking for weight goal.
     */
    public static void displayAskUserWeightGoalMessage() {
        System.out.println("Do you wish to lose/maintain/gain weight?");
    }

    /**
     * Prints out message asking for weight.
     */
    public static void displayAskUserWeightMessage() {
        System.out.println("What is your weight in kg?");
    }

    /**
     * Prints out message asking for height.
     */
    public static void displayAskUserHeightMessage() {
        System.out.println("What is your height in cm?");
    }

    /**
     * Prints out message asking for age.
     */
    public static void displayAskUserAgeMessage() {
        System.out.println("What is your age?");
    }

    /**
     * Prints out message asking for activity level.
     */
    public static void displayAskUserActivityLevelMessage() {
        System.out.println("How active are you on a scale of 1-5? With 1 being least active and 5 being most active.");
    }

    /**
     * Prints out message when editing activity successful.
     */
    public static void displayEditMessage() {
        drawDivider();
        System.out.println("Noted! The following has been edited:");
    }

    /**
     * Prints out message when adding activity successful.
     */
    public static void displayAddMessage() {
        drawDivider();
        System.out.println("Noted! The following has been added into list:");
        drawDivider();
    }

    public static void displayMessage(String message) {
        drawDivider();
        System.out.println(message);
        drawDivider();
    }

}
