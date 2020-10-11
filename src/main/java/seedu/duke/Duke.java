package seedu.duke;

import java.io.File;

import seedu.duke.command.Command;
import seedu.duke.storage.Userinfotextfilestorage;
import seedu.duke.userprofile.Initialiseuser;
import seedu.duke.userprofile.Userinfo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static seedu.duke.Ui.displayWelcomeMessage;
import static seedu.duke.ExceptionMessages.displayIoExceptionMessage;
import static seedu.duke.ExceptionMessages.displayParserNullPointerExceptionMessage;

public class Duke {

    public static DayMap calList = new DayMap();

    public static Scanner in = new Scanner(System.in);
    public static Storage storage = new Storage(getJarFilePath() + "/tpdata/tpcsv.csv");

    public static void main(String[] args) {
        displayWelcomeMessage();
        storage.loadData();
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
                try {
                    Command cmd = parser.parseCommand();
                    executeCmd(cmd);
                    storage.updateFile(calList);
                } catch (NullPointerException e) {
                    displayParserNullPointerExceptionMessage();
                }
            }
        } catch (IOException e) {
            displayIoExceptionMessage();
        }
    }

    public static DayMap getDayMap() {
        return calList;
    }

    public static void executeCmd(Command cmd) {
        cmd.setData(calList);
        cmd.execute();
    }

    private static String getJarFilePath() {
        return new File(Duke.class.getProtectionDomain().getCodeSource().getLocation().getPath())
                .getParent().replace("%20", " ");
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