package seedu.duke;

import java.time.LocalDateTime;
import java.time.Month;
//import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        /**
         * Create user profile for first time user
         * Edit user profile
         */

        Scanner input = new Scanner(System.in);
        System.out.println("Hello " + input.nextLine());

        /**
         * Calorie List and List
         */
        // Example code to use calorie list.
        ActivityMap calList = new ActivityMap();

        LocalDateTime adatetime = LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40);

        calList.addActivity(adatetime, 10);
        calList.addActivity(adatetime, 11);
        calList.addActivity(adatetime, 12);

        //System.out.println(calList.toString(aDateTime));
        //System.out.println("Size of activity list: " + calList.getSizeOfActivityList(aDateTime));
        /**
         * Add exercise/food with their respective calories
         */

        /**
         * Remove/Delete index from current list
         * Remove/Delete whole list
         */

        /**
         * Find exercise/food description
         * Find calorie count
         */
    }
}