package seedu.duke;

import seedu.duke.Commands.Command;
import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static Scanner userInput = new Scanner(System.in);
    public static DayMap calList = new DayMap();

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
            if (userInput.nextLine().startsWith("create new user")) {
                Initialiseuser.sendname();
                Initialiseuser.gender();
            } else {
                String[] data = new String[4];
                ArrayList<String> previous = Userinfotextfilestorage.update();
                for (int i = 0; i < 4; i++) {
                    data[i] = previous.get(i);
                }

                profile = new Userinfo(data[0], data[1], data[2], data[3]);
                Initialiseuser.saveExistingUserInfo(profile);
            }
        } catch (IOException e) {
            System.out.println("IO exception has occured!");
        }
        while (userInput.hasNextLine()) {
            if (!(userInput.nextLine().equals("bye"))) {
                Parser parser = new Parser(userInput.nextLine());
                parser.parseCommand();
            } else {
                break;
            }
        }
        System.out.println("THank you for using TraKCAL. See you again!");
    }
public static void executeCmd(Command cmd){
        cmd.setData(calList);
        cmd.execute();
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