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
        String name = Initialiseuser.input("What is your name?\n");
        System.out.println("Hello " + name + "\n");
//        Path path = Paths.get(Userinfotextfilestorage.FILE_PATH);

//        if (!Files.exists(path)) {
        if (Initialiseuser.input2().startsWith("create new user")) {
            Initialiseuser.sendname(name);
            Initialiseuser.gender();
        } else {
            String[] data = new String[4];
            ArrayList<String> previous = Userinfotextfilestorage.update();
            for (int i = 0; i < 4; i++) {
                data[i] = previous.get(i);
            }

            new Userinfo(data[0],data[1],data[2],data[3]);
            Initialiseuser.saveExistingUserInfo();
        }

        /**
         * Calorie List and List
         */
        // Example code to use calorie list.

        //DayMap calList = new DayMap();
        //LocalDateTime adatetime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        //calList.addActivity(adatetime, "description of activity", 500, "food"); //daymap equivalent
        //System.out.println(calList.toString(aDateTime));
        //System.out.println("Size of activity list: " + calList.getSizeOfActivityList(aDateTime));


        /**
         * Add exercise/food with their respective calories
         */
        DayMap calList = new DayMap();
        LocalDateTime date = LocalDateTime.now();
        while (true) {
            String userInput = Initialiseuser.input2();
            try {
                if (userInput.startsWith("add f/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, userInput, calories, "food"); //daymap equivalent
                    //used method inside daymap to get size of the activitylist instead
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                } else if (userInput.startsWith("add e/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, userInput, calories, "exercise"); //daymap equivalent
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                } else if (userInput.startsWith("find d/")) {
                    userInput = userInput.substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    //used method inside daymap to get size of the activitylist instead
                    for (int i = 0; i < calList.getSizeOfActivityList(date); i++) {
                        //created new method to get the arraylist inside the activity list from the daymap
                        //maybe can find a better implementation of this later on
                        String description = calList.getArrayList(date).toArray()[i].toString().substring(
                                0, calList.getArrayList(date).toArray()[i].toString().indexOf(",")).trim();
                        if (description.contains(userInput)) {
                            System.out.println(calList.getArrayList(date).toArray()[i]);
                        }
                    }
                } else if (userInput.startsWith("find c/")) {
                    userInput = userInput.substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    //used method inside daymap to get size of the activitylist instead
                    for (int i = 0; i < calList.getSizeOfActivityList(date); i++) {
                        //created new method to get the arraylist inside the activity list from the daymap
                        //maybe can find a better implementation of this later on
                        String calories = calList.getArrayList(date).toArray()[i].toString().substring(
                                calList.getArrayList(date).toArray()[i].toString().indexOf(",") + 1).trim();
                        if (calories.equals(userInput)) {
                            System.out.println(calList.getArrayList(date).toArray()[i]);
                        }
                    }
                } else if (userInput.startsWith("edit n/")) {
                    Userinfo store = new Userinfo();
                    store.editUserInfo(userInput);
                    Initialiseuser.save();
                } else if (userInput.startsWith("edit")) {
                    Userinfo store = new Userinfo();
                    store.editUserInfo(userInput);
                    Initialiseuser.save();
                } else if (userInput.startsWith("bye")) {
                    System.out.println("bye!\n");
                    Initialiseuser.closescanner();
                    System.exit(0);
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