package seedu.duke;

import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;

import seedu.duke.userprofile.Userinfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    protected Scanner userInput;

    public Duke() {
        this.userInput = new Scanner(System.in);
    }

    /*
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        /*
         * Create user profile for first time user
         * Edit user profile
         */
        String name = Initialiseuser.input("What is your name?\n");
        System.out.println("Hello " + name + "\n");
        Duke duke = new Duke();
        duke.run();
    }

    public void run() {
        //TODO userInput.nextLine() is repeated
        String name = userInput.nextLine();
        System.out.println("Hello " + name);
        while (!(userInput.nextLine().equals("bye"))) {
            Parser parser = new Parser(userInput.nextLine());
            parser.parseCommand();
        }
        System.out.println("THank you for using TraKCAL. See you again!");
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