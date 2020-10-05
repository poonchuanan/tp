package seedu.duke.UserProfile;
import seedu.duke.Storage.userInfoTextFileStorage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class initialiseUser {
    private static seedu.duke.UserProfile.userInfo userInfo = new userInfo();
    private static String[] data = new String[4];

    public static void openingMessage() throws IOException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");
        run();
    }


    public static void run() throws IOException {
        checkUserProfilePresent();
    }

    public static void checkUserProfilePresent() throws IOException {
        Path path = Paths.get(userInfoTextFileStorage.FILE_PATH);
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Hello " + name);

        if (!Files.exists(path)) {
            data[0] = name;
            gender();
        } else  {
            String userInput = input.nextLine();
            if (userInput.startsWith("edit n/")) {
                userInfo store = new userInfo();
                store.editUserInfo(userInput);
                initialiseUser.save();
            } else {
                ArrayList<String> previous = userInfoTextFileStorage.update();
                for (int i = 0; i < 4; i++) {
                    data[i] = previous.get(i);
                }
                saveExistingUserInfo();
            }
        }
    }

    public static void gender() throws IOException {
        System.out.print("What is your gender (male/female)? ");
        Scanner input = new Scanner(System.in);
        String gender = input.next();
        data[1] = gender;
        weight();
    }


    public static void weight() throws IOException {
        System.out.print("What is your weight in kg? ");
        Scanner input = new Scanner(System.in);
        String weight = input.next();
        data[2] = weight;
        height();
    }

    public static void height() throws IOException {
        System.out.print("What is your height in m? ");
        Scanner input = new Scanner(System.in);
        String height = input.next();
        data[3] = height;
        enterNewUserInfo();
    }

    public static void enterNewUserInfo() throws IOException {
        new userInfo(data[0],data[1],data[2],data[3]);
        userInfo.printNewUserCalculatedDetails();
        initialiseUser.save();
    }

    public static void saveExistingUserInfo() throws IOException {
        new userInfo(data[0],data[1],data[2],data[3]);
        initialiseUser.save();
    }

    public static void save() throws IOException {
        userInfoTextFileStorage storage = new userInfoTextFileStorage();
        storage.save(userInfo.toString());
    }
}