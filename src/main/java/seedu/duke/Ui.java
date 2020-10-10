package seedu.duke;

import java.time.LocalDateTime;

import static seedu.duke.Duke.calList;

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
        drawDivider();
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
        String hello = "Hello! I'm traKCAL.\n"
                + "What is your name?";
        System.out.println(hello);
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
        helloMessage();
        displayHelpMessage();
    }

    /**
     * Prints out bye message and let the user know that the current list has been saved to file.
     */
    public static void displayByeMessage() {
        drawDivider();
        System.out.println("THank you for using TraKCAL. See you again!");
        drawDivider();
    }


}
