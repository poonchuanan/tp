package seedu.duke.logic.preparecommand;

import seedu.duke.command.AddSetCommand;
import seedu.duke.command.Command;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.EmptyTextFileException;
import seedu.duke.logic.parser.CommandParser;
import seedu.duke.ui.ExceptionMessages;
import static seedu.duke.ui.ExceptionMessages.displayMissingAddSetInfoMessage;

import static seedu.duke.ui.ExceptionMessages.displayInvalidCreateSetCommandMessage;
import static seedu.duke.ui.ExceptionMessages.displayCorruptedSetMessage;

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
        String initialPath = new File("").getAbsolutePath();
        String filePath = initialPath + "/" + description[1] + ".txt";

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            if (file.exists()) {
                String line = reader.readLine();
                checkEmptyFile(filePath);

                while (line != null) {
                    checkTags(line);
                    String description = line.substring(2, line.indexOf("c/") - 1);
                    String calories = line.substring(line.indexOf("c/") + 2);
                    checkEmptyDescription(description);
                    checkEmptyDescription(calories);
                    checkInteger(calories);
                    checkCalorieRange(calories);
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
        } catch (IllegalArgumentException e) {
            displayInvalidCreateSetCommandMessage();
            displayCorruptedSetMessage();
        } catch (EmptyDescriptionException | CalorieCountException e) {
            displayMissingAddSetInfoMessage();
            displayCorruptedSetMessage();
            deleteInvalidSetFile(filePath);
        } catch (EmptyTextFileException e) {
            displayCorruptedSetMessage();
            deleteInvalidSetFile(filePath);
        }

        return new AddSetCommand();
    }

    private void checkTags(String input) throws IllegalArgumentException {
        if (!input.contains("c/") || !(input.contains("f/") || input.contains("e/"))) {
            throw new IllegalArgumentException();
        }
    }

    private void checkEmptyDescription(String input) throws EmptyDescriptionException {
        if (input.isBlank() || input.isEmpty()) {
            throw new EmptyDescriptionException();
        }
    }

    private void checkInteger(String input) throws NumberFormatException {
        Integer.parseInt(input);
    }

    private void checkCalorieRange(String input) throws CalorieCountException {
        if (Integer.parseInt(input) < 0) {
            throw new CalorieCountException();
        }
    }

    public static void deleteInvalidSetFile(String filePath) {
        File file = new File(filePath);
        file.delete();
    }

    public static void checkEmptyFile(String filePath) throws EmptyTextFileException {
        File file = new File(filePath);
        if (file.length() == 0) {
            throw new EmptyTextFileException();
        }
    }
}
