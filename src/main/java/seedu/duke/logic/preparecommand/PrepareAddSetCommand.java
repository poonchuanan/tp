package seedu.duke.logic.preparecommand;

import seedu.duke.command.AddSetCommand;
import seedu.duke.command.Command;
import seedu.duke.exception.CalorieCountException;
import seedu.duke.exception.EmptyDescriptionException;
import seedu.duke.exception.EmptyTextFileException;
import seedu.duke.exception.InvalidNumberOfArguments;
import seedu.duke.logic.parser.CommandParser;
import seedu.duke.ui.ExceptionMessages;
import seedu.duke.ui.Ui;

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
import static seedu.duke.ui.ExceptionMessages.displayShortageOfArguments;

/**
 * Prepares add set command.
 */
public class PrepareAddSetCommand extends PrepareCommand {
    protected static final int ARGUMENT_LIMIT = 2;

    public PrepareAddSetCommand(String[] description) {
        super(description);
    }

    /**
     * Prepares file to be read from and added into the current list.
     *
     * @return AddSet Command
     */
    @Override
    public Command prepareCommand() {
        try {
            isNumberOfArgumentsValid(ARGUMENT_LIMIT);
            return new AddSetCommand(description[1]);
        } catch (InvalidNumberOfArguments e) {
            displayShortageOfArguments();
        }
        return null;
    }

}
