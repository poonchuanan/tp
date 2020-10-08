package seedu.duke;

import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static Scanner in = new Scanner(System.in);
    protected static DayMap calList = new DayMap();

    public static void main(String[] args) {
        String logo = " ____        _\n"
                + "|  _ \\ _   _| | _____\n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        /*
         * Create user profile for first time user
         * Edit user profile
         */
        Duke.run();
    }

    public static void run() {
        Userinfo profile;
        try {
            while (in.hasNextLine()) {
                String userInput = in.nextLine();
                if (userInput.startsWith("create new user")) {
                    Initialiseuser.sendname();
                    Initialiseuser.gender();
                    continue;
                } else {
                    String[] data = new String[4];
                    ArrayList<String> previous = Userinfotextfilestorage.update();
                    for (int i = 0; i < 4; i++) {
                        data[i] = previous.get(i);
                    }
                    profile = new Userinfo(data[0], data[1], data[2], data[3]);
                    Initialiseuser.saveExistingUserInfo(profile);
                }
                Parser parser = new Parser(userInput);
                parser.parseCommand();
            }
        } catch (IOException e) {
            System.out.println("IO exception has occured!");
        }
    }

    public static DayMap getDayMap() {
        return calList;
    }
}




/*
 * Calorie List and List
 */
// Example code to use calorie list.
//DayMap calList = new DayMap();
//LocalDateTime adatetime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
//calList.addActivity(adatetime, "description of activity", 500, "food"); //daymap equivalent
//System.out.println(calList.toString(aDateTime));
//System.out.println("Size of activity list: " + calList.getSizeOfActivityList(aDateTime));