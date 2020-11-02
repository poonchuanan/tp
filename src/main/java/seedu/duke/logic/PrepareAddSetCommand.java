package seedu.duke.logic;

import seedu.duke.command.AddSetCommand;
import seedu.duke.command.Command;
import seedu.duke.ui.ExceptionMessages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static seedu.duke.Trakcal.calList;
import static seedu.duke.Trakcal.executeCmd;
import static seedu.duke.Trakcal.storage;

public class PrepareAddSetCommand extends PrepareCommand {

    public PrepareAddSetCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares file to be read from and added into the current list.
     *
     * @return Command
     */
    @Override
    public Command prepareCommand() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        try {
            String initialPath = new File("").getAbsolutePath();
            String filePath = initialPath + "/" + description[1] + ".txt";
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            if (file.exists()) {
                String line = reader.readLine();

                while (line != null) {
                    CommandParser parser = new CommandParser("add " + line + " d/ " + strDate);
                    Command cmd = parser.parseArgument();
                    executeCmd(cmd);
                    storage.updateFile(calList);
                    line = reader.readLine();
                }
            } else {
                throw new FileNotFoundException();
            }
            reader.close();
            return new AddSetCommand();
        } catch (FileNotFoundException e) {
            ExceptionMessages.displayShortcutDoesNotExistMessage();
        } catch (IOException e) {
            ExceptionMessages.displayIoExceptionMessage();
        }
        return new AddSetCommand();
    }
}
