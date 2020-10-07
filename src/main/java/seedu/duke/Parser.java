package seedu.duke;

import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;

import java.io.IOException;
import java.time.LocalDateTime;

public class Parser {
    protected String userInput;
    protected DayMap calList;
    protected LocalDateTime date;

    public Parser(String userInput) {
        this.userInput = userInput;
        this.calList = new DayMap();
        this.date = LocalDateTime.now();
    }

    public void parseCommand() {
        String[] arguments = userInput.split(" ", 1); //TODO split for all types of spaces etc TAB.
        try {
            switch (arguments[1].toLowerCase()) {
            case "add":
                //TODO apply SLAP
                if (arguments[1].startsWith("f/")) {
                    int calorieIndex = arguments[1].indexOf("c/");
                    int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2).trim());
                    arguments[1] = arguments[1].substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, arguments[1], calories, "food"); //daymap equivalent
                    //used method inside daymap to get size of the activitylist instead
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                } else if (arguments[1].startsWith("e/")) {
                    int calorieIndex = arguments[1].indexOf("c/");
                    int calories = Integer.parseInt(arguments[1].substring(calorieIndex + 2).trim());
                    arguments[1] = arguments[1].substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, arguments[1], calories, "exercise"); //daymap equivalent
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                }
                break;
            case "find":
                //TODO apply SLAP
                if (arguments[1].startsWith("d/")) {
                    arguments[1] = arguments[1].substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    //used method inside daymap to get size of the activitylist instead
                    for (int i = 0; i < calList.getSizeOfActivityList(date); i++) {
                        //created new method to get the arraylist inside the activity list from the daymap
                        //maybe can find a better implementation of this later on
                        String description = calList.getArrayList(date).toArray()[i].toString().substring(
                                0, calList.getArrayList(date).toArray()[i].toString().indexOf(",")).trim();
                        if (description.contains(arguments[1])) {
                            System.out.println(calList.getArrayList(date).toArray()[i]);
                        }
                    }
                } else if (arguments[1].startsWith("c/")) {
                    arguments[1] = arguments[1].substring(7).trim();
                    System.out.println("Here are the matching descriptions: ");
                    //used method inside daymap to get size of the activitylist instead
                    for (int i = 0; i < calList.getSizeOfActivityList(date); i++) {
                        //created new method to get the arraylist inside the activity list from the daymap
                        //maybe can find a better implementation of this later on
                        String calories = calList.getArrayList(date).toArray()[i].toString().substring(
                                calList.getArrayList(date).toArray()[i].toString().indexOf(",") + 1).trim();
                        if (calories.equals(arguments[1])) {
                            System.out.println(calList.getArrayList(date).toArray()[i]);
                        }
                    }
                }
                break;
            case "edit":
                //TODO apply SLAP
                Userinfo store = new Userinfo();
                store.editUserInfo(arguments[1]);
                Initialiseuser.save();
                break;

            //TODO list command
            //TODO delete command
            default:
                System.out.println("Invalid command. Please type 'help' for more information.");
                break;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Something went wrong!! I do not understand what you mean.\n"
                    + "There could be an error in the way of input.\n"
                    + "Please do input 'help' for the commands and their respective input format.");
        } catch (IOException e) {
            System.out.println("IO Exception found!");
        }
    }
}
