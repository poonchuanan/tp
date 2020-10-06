package seedu.duke;

import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;

import seedu.duke.userprofile.Userinfo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.ActivityList.INITIALISE;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello " + name);

        Path path = Paths.get(Userinfotextfilestorage.FILE_PATH);

        if (!Files.exists(path)) {
            Initialiseuser.sendname(name);
            Initialiseuser.gender();
        } else {
            String[] data = new String[4];
            ArrayList<String> previous;
            previous = Userinfotextfilestorage.update();
            for (int i = 0; i < 4; i++) {
                data[i] = previous.get(i);
            }

            Initialiseuser.saveExistingUserInfo();
        }

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
        ActivityList actList = new ActivityList();
        int numOfActivities = INITIALISE;
        while (true) {
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();
            try {
                if (userInput.startsWith("add f/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    numOfActivities = actList.addFood(userInput, calories);
                    System.out.println("Current number of activities is: " + numOfActivities);
                } else if (userInput.startsWith("add e/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    numOfActivities = actList.addExercise(userInput, calories);
                    System.out.println("Current number of activities is: " + numOfActivities);
                } else if (userInput.startsWith("find d/")) {
                    userInput = userInput.substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    for (int i = 0; i < actList.getNumberOfActivity(); i++) {
                        String description = actList.getActivityList().toArray()[i].toString().substring(
                                0, actList.getActivityList().toArray()[i].toString().indexOf(",")).trim();
                        if (description.contains(userInput)) {
                            System.out.println(actList.getActivityList().toArray()[i]);
                        }
                    }
                } else if (userInput.startsWith("find c/")) {
                    userInput = userInput.substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    for (int i = 0; i < actList.getNumberOfActivity(); i++) {
                        String calories = actList.getActivityList().toArray()[i].toString().substring(
                                actList.getActivityList().toArray()[i].toString().indexOf(",") + 1).trim();
                        if (calories.equals(userInput)) {
                            System.out.println(actList.getActivityList().toArray()[i]);
                        }
                    }
                } else if (userInput.startsWith("edit n/")) {
                    Userinfo store = new Userinfo();
                    store.editUserInfo(userInput);
                    Initialiseuser.save();
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
}