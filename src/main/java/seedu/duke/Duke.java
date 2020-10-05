package seedu.duke;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
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

        LocalDateTime adatetime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);

        calList.addActivity(adatetime, 10);
        calList.addActivity(adatetime, 11);
        calList.addActivity(adatetime, 12);

        //System.out.println(calList.toString(aDateTime));
        //System.out.println("Size of activity list: " + calList.getSizeOfActivityList(aDateTime));


        /**
         * Add exercise/food with their respective calories
         */
        Scanner in = new Scanner(System.in);
        String userInput = in.nextLine();
        ActivityList actList = new ActivityList();
        try {
            if (userInput.startsWith("add f/")) {
                int calorieIndex = userInput.indexOf("c/");
                int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                userInput = userInput.substring(6, calorieIndex - 1).trim();
                actList.addFood(userInput, calories);
            } else if (userInput.startsWith("add e/")) {
                int calorieIndex = userInput.indexOf("c/");
                int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                userInput = userInput.substring(6, calorieIndex - 1).trim();
                actList.addExercise(userInput, calories);
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Something went wrong!! I do not understand what you mean.\n"
                    + "There could be an error in the way of input.\n"
                    + "Please do input 'help' for the commands and their respective input format.");
        } catch (Exception e) {
            System.out.println("Something went wrong!! I do not understand what you mean.\n"
                    + "There could be an error in the way of input.\n"
                    + "Please do input 'help' for the commands and their respective input format.");
        }

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