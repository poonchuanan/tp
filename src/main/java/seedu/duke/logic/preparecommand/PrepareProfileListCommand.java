package seedu.duke.logic.preparecommand;

import seedu.duke.command.Command;
import seedu.duke.command.ListUserProfileCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrepareProfileListCommand extends PrepareCommand {
    public PrepareProfileListCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares user profile into a list and prints it out.
     *
     * @return ListUserProfileCommand
     */
    @Override
    public Command prepareCommand() throws IOException {
        String initialPath = new File("").getAbsolutePath();
        String filePath = initialPath + "/tp.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();

        System.out.println("Here is your user profile:");
        System.out.println("Name : " + line);
        line = reader.readLine();
        System.out.println("Gender : " + line);
        line = reader.readLine();
        System.out.println("Weight : " + line);
        line = reader.readLine();
        System.out.println("Height : " + line);
        line = reader.readLine();
        System.out.println("Age : " + line);
        line = reader.readLine();
        System.out.println("Activity Level : " + line);
        line = reader.readLine();
        System.out.println("Weight Goal : " + line + "\n");
        reader.close();

        return new ListUserProfileCommand();
    }

}
