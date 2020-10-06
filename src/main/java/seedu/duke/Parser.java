package seedu.duke;

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
                if (userInput.startsWith("f/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, userInput, calories, "food"); //daymap equivalent
                    //used method inside daymap to get size of the activitylist instead
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                } else if (userInput.startsWith("e/")) {
                    int calorieIndex = userInput.indexOf("c/");
                    int calories = Integer.parseInt(userInput.substring(calorieIndex + 2).trim());
                    userInput = userInput.substring(6, calorieIndex - 1).trim();
                    calList.addActivity(date, userInput, calories, "exercise"); //daymap equivalent
                    System.out.println("Current number of activities is: " + calList.getSizeOfActivityList(date));
                }
                break;
            case "find":
                //TODO apply SLAP
                if (userInput.startsWith("d/")) {
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
                } else if (userInput.startsWith("c/")) {
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
                }
                break;
            //TODO list command
            default:
                System.out.println("Invalid command. Please type 'help' for more information.");
                break;
            }
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Something went wrong!! I do not understand what you mean.\n"
                    + "There could be an error in the way of input.\n"
                    + "Please do input 'help' for the commands and their respective input format.");
        }
    }
}
