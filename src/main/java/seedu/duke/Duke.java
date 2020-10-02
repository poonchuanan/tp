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

        Scanner in = new Scanner(System.in);
        System.out.println("Hello " + in.nextLine());

        //example code to use calorie list
        ActivityMap calList = new ActivityMap();

        LocalDateTime adatetime = LocalDateTime.of(2015,
                Month.JULY, 29, 19, 30, 40);

        calList.addActivity(adatetime, 10);
        calList.addActivity(adatetime, 11);
        calList.addActivity(adatetime, 12);

        //System.out.println(calList.toString(adatetime));
        //System.out.println("Size of activity list: " + calList.getSizeOfActivityList(adatetime));
    }
}